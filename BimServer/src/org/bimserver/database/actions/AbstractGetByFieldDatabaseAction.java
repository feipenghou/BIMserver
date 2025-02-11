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
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.LiteralCondition;
import org.bimserver.emf.IdEObject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EAttribute;

public abstract class AbstractGetByFieldDatabaseAction<T extends IdEObject> extends AbstractGetByConditionDatabaseAction<T> {

	private EAttribute eAttribute;
	private Object value;

	public AbstractGetByFieldDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Class<T> clazz, EAttribute eAttribute, Object value) {
		super(databaseSession, accessMethod, clazz);
		this.eAttribute = eAttribute;
		this.value = value;
		setCondition(new AttributeCondition(eAttribute, LiteralCondition.from(value)));
	}
	
	@Override
	public T execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		T result = super.execute();
		if (result == null) {
			throw new UserException("No " + getClazz().getSimpleName() + " found where " + eAttribute.getName() + " = " + value);
		}
		return result;
	}
}
