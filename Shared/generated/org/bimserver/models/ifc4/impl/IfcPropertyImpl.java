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
package org.bimserver.models.ifc4.impl;

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcComplexProperty;
import org.bimserver.models.ifc4.IfcProperty;
import org.bimserver.models.ifc4.IfcPropertyDependencyRelationship;
import org.bimserver.models.ifc4.IfcPropertySet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyImpl#getPartOfPset <em>Part Of Pset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyImpl#getPropertyForDependance <em>Property For Dependance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyImpl#getPropertyDependsOn <em>Property Depends On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcPropertyImpl#getPartOfComplex <em>Part Of Complex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyImpl extends IfcPropertyAbstractionImpl implements IfcProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String) eGet(Ifc4Package.Literals.IFC_PROPERTY__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String) eGet(Ifc4Package.Literals.IFC_PROPERTY__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc4Package.Literals.IFC_PROPERTY__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertySet> getPartOfPset() {
		return (EList<IfcPropertySet>) eGet(Ifc4Package.Literals.IFC_PROPERTY__PART_OF_PSET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPartOfPset() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY__PART_OF_PSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPartOfPset() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY__PART_OF_PSET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertyDependencyRelationship> getPropertyForDependance() {
		return (EList<IfcPropertyDependencyRelationship>) eGet(Ifc4Package.Literals.IFC_PROPERTY__PROPERTY_FOR_DEPENDANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPropertyForDependance() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY__PROPERTY_FOR_DEPENDANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPropertyForDependance() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY__PROPERTY_FOR_DEPENDANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertyDependencyRelationship> getPropertyDependsOn() {
		return (EList<IfcPropertyDependencyRelationship>) eGet(Ifc4Package.Literals.IFC_PROPERTY__PROPERTY_DEPENDS_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPropertyDependsOn() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY__PROPERTY_DEPENDS_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPropertyDependsOn() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY__PROPERTY_DEPENDS_ON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcComplexProperty> getPartOfComplex() {
		return (EList<IfcComplexProperty>) eGet(Ifc4Package.Literals.IFC_PROPERTY__PART_OF_COMPLEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPartOfComplex() {
		eUnset(Ifc4Package.Literals.IFC_PROPERTY__PART_OF_COMPLEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPartOfComplex() {
		return eIsSet(Ifc4Package.Literals.IFC_PROPERTY__PART_OF_COMPLEX);
	}

} //IfcPropertyImpl
