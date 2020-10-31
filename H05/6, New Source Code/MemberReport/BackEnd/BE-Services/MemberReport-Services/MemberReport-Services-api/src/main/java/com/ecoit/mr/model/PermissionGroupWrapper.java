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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PermissionGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroup
 * @generated
 */
public class PermissionGroupWrapper
	extends BaseModelWrapper<PermissionGroup>
	implements ModelWrapper<PermissionGroup>, PermissionGroup {

	public PermissionGroupWrapper(PermissionGroup permissionGroup) {
		super(permissionGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userPermissionGroupId", getUserPermissionGroupId());
		attributes.put("permissionId", getPermissionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userPermissionGroupId = (Long)attributes.get(
			"userPermissionGroupId");

		if (userPermissionGroupId != null) {
			setUserPermissionGroupId(userPermissionGroupId);
		}

		Integer permissionId = (Integer)attributes.get("permissionId");

		if (permissionId != null) {
			setPermissionId(permissionId);
		}
	}

	/**
	 * Returns the permission ID of this permission group.
	 *
	 * @return the permission ID of this permission group
	 */
	@Override
	public int getPermissionId() {
		return model.getPermissionId();
	}

	/**
	 * Returns the primary key of this permission group.
	 *
	 * @return the primary key of this permission group
	 */
	@Override
	public com.ecoit.mr.service.persistence.PermissionGroupPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user permission group ID of this permission group.
	 *
	 * @return the user permission group ID of this permission group
	 */
	@Override
	public long getUserPermissionGroupId() {
		return model.getUserPermissionGroupId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the permission ID of this permission group.
	 *
	 * @param permissionId the permission ID of this permission group
	 */
	@Override
	public void setPermissionId(int permissionId) {
		model.setPermissionId(permissionId);
	}

	/**
	 * Sets the primary key of this permission group.
	 *
	 * @param primaryKey the primary key of this permission group
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.mr.service.persistence.PermissionGroupPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user permission group ID of this permission group.
	 *
	 * @param userPermissionGroupId the user permission group ID of this permission group
	 */
	@Override
	public void setUserPermissionGroupId(long userPermissionGroupId) {
		model.setUserPermissionGroupId(userPermissionGroupId);
	}

	@Override
	protected PermissionGroupWrapper wrap(PermissionGroup permissionGroup) {
		return new PermissionGroupWrapper(permissionGroup);
	}

}