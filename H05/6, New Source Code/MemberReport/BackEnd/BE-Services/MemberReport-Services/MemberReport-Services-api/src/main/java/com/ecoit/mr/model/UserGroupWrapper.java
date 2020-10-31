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
 * This class is a wrapper for {@link UserGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroup
 * @generated
 */
public class UserGroupWrapper
	extends BaseModelWrapper<UserGroup>
	implements ModelWrapper<UserGroup>, UserGroup {

	public UserGroupWrapper(UserGroup userGroup) {
		super(userGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("userPermissionGroupId", getUserPermissionGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userPermissionGroupId = (Long)attributes.get(
			"userPermissionGroupId");

		if (userPermissionGroupId != null) {
			setUserPermissionGroupId(userPermissionGroupId);
		}
	}

	/**
	 * Returns the primary key of this user group.
	 *
	 * @return the primary key of this user group
	 */
	@Override
	public com.ecoit.mr.service.persistence.UserGroupPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user group.
	 *
	 * @return the user ID of this user group
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user permission group ID of this user group.
	 *
	 * @return the user permission group ID of this user group
	 */
	@Override
	public long getUserPermissionGroupId() {
		return model.getUserPermissionGroupId();
	}

	/**
	 * Returns the user uuid of this user group.
	 *
	 * @return the user uuid of this user group
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this user group.
	 *
	 * @param primaryKey the primary key of this user group
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.mr.service.persistence.UserGroupPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user group.
	 *
	 * @param userId the user ID of this user group
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user permission group ID of this user group.
	 *
	 * @param userPermissionGroupId the user permission group ID of this user group
	 */
	@Override
	public void setUserPermissionGroupId(long userPermissionGroupId) {
		model.setUserPermissionGroupId(userPermissionGroupId);
	}

	/**
	 * Sets the user uuid of this user group.
	 *
	 * @param userUuid the user uuid of this user group
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserGroupWrapper wrap(UserGroup userGroup) {
		return new UserGroupWrapper(userGroup);
	}

}