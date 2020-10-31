/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ecoit.elegaldocument.model;

import com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK;

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EcmsPGRelation service. Represents a row in the &quot;ecoit_doc_EcmsPGRelation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ecoit.elegaldocument.model.impl.EcmsPGRelationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ecoit.elegaldocument.model.impl.EcmsPGRelationImpl</code>.
 * </p>
 *
 * @author Liverpool
 * @see EcmsPGRelation
 * @generated
 */
@ProviderType
public interface EcmsPGRelationModel extends BaseModel<EcmsPGRelation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ecms pg relation model instance should use the {@link EcmsPGRelation} interface instead.
	 */

	/**
	 * Returns the primary key of this ecms pg relation.
	 *
	 * @return the primary key of this ecms pg relation
	 */
	public EcmsPGRelationPK getPrimaryKey();

	/**
	 * Sets the primary key of this ecms pg relation.
	 *
	 * @param primaryKey the primary key of this ecms pg relation
	 */
	public void setPrimaryKey(EcmsPGRelationPK primaryKey);

	/**
	 * Returns the group user ID of this ecms pg relation.
	 *
	 * @return the group user ID of this ecms pg relation
	 */
	public long getGroupUserId();

	/**
	 * Sets the group user ID of this ecms pg relation.
	 *
	 * @param groupUserId the group user ID of this ecms pg relation
	 */
	public void setGroupUserId(long groupUserId);

	/**
	 * Returns the group user uuid of this ecms pg relation.
	 *
	 * @return the group user uuid of this ecms pg relation
	 */
	public String getGroupUserUuid();

	/**
	 * Sets the group user uuid of this ecms pg relation.
	 *
	 * @param groupUserUuid the group user uuid of this ecms pg relation
	 */
	public void setGroupUserUuid(String groupUserUuid);

	/**
	 * Returns the permission of this ecms pg relation.
	 *
	 * @return the permission of this ecms pg relation
	 */
	public int getPermission();

	/**
	 * Sets the permission of this ecms pg relation.
	 *
	 * @param permission the permission of this ecms pg relation
	 */
	public void setPermission(int permission);

}