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

package com.ecoit.qa.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GroupUserPermission}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserPermission
 * @generated
 */
public class GroupUserPermissionWrapper
	extends BaseModelWrapper<GroupUserPermission>
	implements GroupUserPermission, ModelWrapper<GroupUserPermission> {

	public GroupUserPermissionWrapper(GroupUserPermission groupUserPermission) {
		super(groupUserPermission);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("permissionId", getPermissionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long permissionId = (Long)attributes.get("permissionId");

		if (permissionId != null) {
			setPermissionId(permissionId);
		}
	}

	/**
	 * Returns the group user ID of this group user permission.
	 *
	 * @return the group user ID of this group user permission
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group user permission.
	 *
	 * @return the group user uuid of this group user permission
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the permission ID of this group user permission.
	 *
	 * @return the permission ID of this group user permission
	 */
	@Override
	public long getPermissionId() {
		return model.getPermissionId();
	}

	/**
	 * Returns the primary key of this group user permission.
	 *
	 * @return the primary key of this group user permission
	 */
	@Override
	public com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the group user ID of this group user permission.
	 *
	 * @param groupUserId the group user ID of this group user permission
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group user permission.
	 *
	 * @param groupUserUuid the group user uuid of this group user permission
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the permission ID of this group user permission.
	 *
	 * @param permissionId the permission ID of this group user permission
	 */
	@Override
	public void setPermissionId(long permissionId) {
		model.setPermissionId(permissionId);
	}

	/**
	 * Sets the primary key of this group user permission.
	 *
	 * @param primaryKey the primary key of this group user permission
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupUserPermissionWrapper wrap(
		GroupUserPermission groupUserPermission) {

		return new GroupUserPermissionWrapper(groupUserPermission);
	}

}