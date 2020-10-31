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

import com.ecoit.elegaldocument.service.persistence.GroupFieldPK;

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the GroupField service. Represents a row in the &quot;ecoit_doc_GroupField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ecoit.elegaldocument.model.impl.GroupFieldModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ecoit.elegaldocument.model.impl.GroupFieldImpl</code>.
 * </p>
 *
 * @author Liverpool
 * @see GroupField
 * @generated
 */
@ProviderType
public interface GroupFieldModel extends BaseModel<GroupField> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a group field model instance should use the {@link GroupField} interface instead.
	 */

	/**
	 * Returns the primary key of this group field.
	 *
	 * @return the primary key of this group field
	 */
	public GroupFieldPK getPrimaryKey();

	/**
	 * Sets the primary key of this group field.
	 *
	 * @param primaryKey the primary key of this group field
	 */
	public void setPrimaryKey(GroupFieldPK primaryKey);

	/**
	 * Returns the group user ID of this group field.
	 *
	 * @return the group user ID of this group field
	 */
	public long getGroupUserId();

	/**
	 * Sets the group user ID of this group field.
	 *
	 * @param groupUserId the group user ID of this group field
	 */
	public void setGroupUserId(long groupUserId);

	/**
	 * Returns the group user uuid of this group field.
	 *
	 * @return the group user uuid of this group field
	 */
	public String getGroupUserUuid();

	/**
	 * Sets the group user uuid of this group field.
	 *
	 * @param groupUserUuid the group user uuid of this group field
	 */
	public void setGroupUserUuid(String groupUserUuid);

	/**
	 * Returns the fieldid of this group field.
	 *
	 * @return the fieldid of this group field
	 */
	public long getFieldid();

	/**
	 * Sets the fieldid of this group field.
	 *
	 * @param fieldid the fieldid of this group field
	 */
	public void setFieldid(long fieldid);

}