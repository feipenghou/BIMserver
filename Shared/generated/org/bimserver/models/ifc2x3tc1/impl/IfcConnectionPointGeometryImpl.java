/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 */
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcConnectionPointGeometry;
import org.bimserver.models.ifc2x3tc1.IfcPointOrVertexPoint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Point Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointGeometryImpl#getPointOnRelatingElement <em>Point On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionPointGeometryImpl#getPointOnRelatedElement <em>Point On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionPointGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionPointGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPointGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPointOrVertexPoint getPointOnRelatingElement() {
		return (IfcPointOrVertexPoint) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOnRelatingElement(IfcPointOrVertexPoint newPointOnRelatingElement) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATING_ELEMENT, newPointOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPointOrVertexPoint getPointOnRelatedElement() {
		return (IfcPointOrVertexPoint) eGet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointOnRelatedElement(IfcPointOrVertexPoint newPointOnRelatedElement) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT, newPointOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPointOnRelatedElement() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPointOnRelatedElement() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_POINT_GEOMETRY__POINT_ON_RELATED_ELEMENT);
	}

} //IfcConnectionPointGeometryImpl
