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

package com.software.cms.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PermissionGroup}.
 * </p>
 *
 * @author DungNV
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

		attributes.put("permissionId", getPermissionId());
		attributes.put("groupuserid", getGroupuserid());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long permissionId = (Long)attributes.get("permissionId");

		if (permissionId != null) {
			setPermissionId(permissionId);
		}

		Long groupuserid = (Long)attributes.get("groupuserid");

		if (groupuserid != null) {
			setGroupuserid(groupuserid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	 * Returns the group ID of this permission group.
	 *
	 * @return the group ID of this permission group
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the groupuserid of this permission group.
	 *
	 * @return the groupuserid of this permission group
	 */
	@Override
	public long getGroupuserid() {
		return model.getGroupuserid();
	}

	/**
	 * Returns the permission ID of this permission group.
	 *
	 * @return the permission ID of this permission group
	 */
	@Override
	public long getPermissionId() {
		return model.getPermissionId();
	}

	/**
	 * Returns the primary key of this permission group.
	 *
	 * @return the primary key of this permission group
	 */
	@Override
	public com.software.cms.service.persistence.PermissionGroupPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the group ID of this permission group.
	 *
	 * @param groupId the group ID of this permission group
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the groupuserid of this permission group.
	 *
	 * @param groupuserid the groupuserid of this permission group
	 */
	@Override
	public void setGroupuserid(long groupuserid) {
		model.setGroupuserid(groupuserid);
	}

	/**
	 * Sets the permission ID of this permission group.
	 *
	 * @param permissionId the permission ID of this permission group
	 */
	@Override
	public void setPermissionId(long permissionId) {
		model.setPermissionId(permissionId);
	}

	/**
	 * Sets the primary key of this permission group.
	 *
	 * @param primaryKey the primary key of this permission group
	 */
	@Override
	public void setPrimaryKey(
		com.software.cms.service.persistence.PermissionGroupPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected PermissionGroupWrapper wrap(PermissionGroup permissionGroup) {
		return new PermissionGroupWrapper(permissionGroup);
	}

}