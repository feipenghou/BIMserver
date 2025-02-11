package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.ObjectIdentifier;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DownloadByGuidsDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final Set<String> guids;
	private final Set<Long> roids;
	private int progress;
	private final ObjectIDM objectIDM;
	private long serializerOid;
	private Deep deep;

	public DownloadByGuidsDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Set<Long> roids, Set<String> guids, long serializerOid, Authorization authorization, ObjectIDM objectIDM, Deep deep) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roids = roids;
		this.guids = guids;
		this.serializerOid = serializerOid;
		this.objectIDM = objectIDM;
		this.deep = deep;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		User user = getUserByUoid(getAuthorization().getUoid());
		Set<String> foundGuids = new HashSet<String>();
		IfcModelSet ifcModelSet = new IfcModelSet();
		Project project = null;
		long incrSize = 0L;
		PackageMetaData lastPackageMetaData = null;
		
		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, Query.getDefault());
		
		Map<Integer, Long> ridRoidMap = new HashMap<Integer, Long>();
		for (Long roid : roids) {
			Revision virtualRevision = getRevisionByRoid(roid);
			ridRoidMap.put(virtualRevision.getRid(), virtualRevision.getOid());
			project = virtualRevision.getProject();
			if (!getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
			Map<ConcreteRevision, Set<Long>> map = new HashMap<ConcreteRevision, Set<Long>>();
			for (String guid : guids) {
				if (!foundGuids.contains(guid)) {
					for (ConcreteRevision concreteRevision : virtualRevision.getConcreteRevisions()) {
						ObjectIdentifier objectIdentifier = getDatabaseSession().getOidOfGuid(concreteRevision.getProject().getSchema(), guid, concreteRevision.getProject().getId(),
								concreteRevision.getId());
						if (objectIdentifier != null) {
							foundGuids.add(guid);
							if (!map.containsKey(concreteRevision)) {
								map.put(concreteRevision, new HashSet<Long>());
								incrSize += concreteRevision.getSize();
							}
							map.get(concreteRevision).add(objectIdentifier.getOid());
						}
					}
				}
			}
			final long totalSize = incrSize;
			final AtomicLong total = new AtomicLong();

			for (ConcreteRevision concreteRevision : map.keySet()) {
				PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
				lastPackageMetaData = packageMetaData;
				IfcModel subModel = new BasicIfcModel(packageMetaData, ridRoidMap);
				int highestStopId = findHighestStopRid(project, concreteRevision);
				Query query = new Query(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), virtualRevision.getOid(), objectIDM, deep, highestStopId);
				subModel.addChangeListener(new IfcModelChangeListener() {
					@Override
					public void objectAdded() {
						total.incrementAndGet();
						progress = (int) Math.round(100.0 * total.get() / totalSize);
					}
				});
				Set<Long> oids = map.get(concreteRevision);
				getDatabaseSession().getMapWithOids(subModel, oids, query);
				subModel.getModelMetaData().setDate(concreteRevision.getDate());
				
				try {
					checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, concreteRevision, virtualRevision);
				} catch (GeometryGeneratingException e) {
					throw new UserException(e);
				}
				
				ifcModelSet.add(subModel);
			}
		}
		try {
			IfcModelInterface ifcModel = new BasicIfcModel(lastPackageMetaData, ridRoidMap);
			ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(project, ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			ifcModel.getModelMetaData().setName("query");
			for (String guid : guids) {
				if (!foundGuids.contains(guid)) {
					throw new UserException("Guid " + guid + " not found");
				}
			}
			ifcModel.getModelMetaData().setRevisionId(1);
			ifcModel.getModelMetaData().setAuthorizedUser(getUserByUoid(getAuthorization().getUoid()).getName());
			ifcModel.getModelMetaData().setDate(new Date());
			return ifcModel;
		} catch (MergeException e) {
			throw new UserException(e);
		}
	}

	public int getProgress() {
		return progress;
	}
}