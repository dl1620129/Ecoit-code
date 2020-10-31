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

package com.ecoit.mr.model;

import com.ecoit.mr.service.persistence.PermissionGroupPK;

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PermissionGroup service. Represents a row in the &quot;ecoit_mr_PermissionGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ecoit.mr.model.impl.PermissionGroupModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ecoit.mr.model.impl.PermissionGroupImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroup
 * @generated
 */
@ProviderType
public interface PermissionGroupModel extends BaseModel<PermissionGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a permission group model instance should use the {@link PermissionGroup} interface instead.
	 */

	/**
	 * Returns the primary key of this permission group.
	 *
	 * @return the primary key of this permission group
	 */
	public PermissionGroupPK getPrimaryKey();

	/**
	 * Sets the primary key of this permission group.
	 *
	 * @param primaryKey the primary key of this permission group
	 */
	public void setPrimaryKey(PermissionGroupPK primaryKey);

	/**
	 * Returns the user permission group ID of this permission group.
	 *
	 * @return the user permission group ID of this permission group
	 */
	public long getUserPermissionGroupId();

	/**
	 * Sets the user permission group ID of this permission group.
	 *
	 * @param userPermissionGroupId the user permission group ID of this permission group
	 */
	public void setUserPermissionGroupId(long userPermissionGroupId);

	/**
	 * Returns the permission ID of this permission group.
	 *
	 * @return the permission ID of this permission group
	 */
	public int getPermissionId();

	/**
	 * Sets the permission ID of this permission group.
	 *
	 * @param permissionId the permission ID of this permission group
	 */
	public void setPermissionId(int permissionId);

}