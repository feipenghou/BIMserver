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

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.UserException;

public class DeleteInternalServiceDatabaseAction extends DeleteDatabaseAction<InternalServicePluginConfiguration> {

	public DeleteInternalServiceDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long ifid) {
		super(databaseSession, accessMethod, StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), ifid);
	}

	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		InternalServicePluginConfiguration object = getDatabaseSession().get(geteClass(), getOid(), Query.getDefault());
		UserSettings settings = object.getUserSettings();
		settings.getServices().remove(object);
		getDatabaseSession().store(settings);
		return super.execute();
	}
}