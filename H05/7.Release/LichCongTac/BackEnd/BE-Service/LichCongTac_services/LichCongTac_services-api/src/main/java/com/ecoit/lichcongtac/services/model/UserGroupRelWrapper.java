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

package com.ecoit.lichcongtac.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserGroupRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRel
 * @generated
 */
public class UserGroupRelWrapper
	extends BaseModelWrapper<UserGroupRel>
	implements ModelWrapper<UserGroupRel>, UserGroupRel {

	public UserGroupRelWrapper(UserGroupRel userGroupRel) {
		super(userGroupRel);
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
	 * Returns the primary key of this user group rel.
	 *
	 * @return the primary key of this user group rel
	 */
	@Override
	public com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user group rel.
	 *
	 * @return the user ID of this user group rel
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user permission group ID of this user group rel.
	 *
	 * @return the user permission group ID of this user group rel
	 */
	@Override
	public long getUserPermissionGroupId() {
		return model.getUserPermissionGroupId();
	}

	/**
	 * Returns the user uuid of this user group rel.
	 *
	 * @return the user uuid of this user group rel
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
	 * Sets the primary key of this user group rel.
	 *
	 * @param primaryKey the primary key of this user group rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user group rel.
	 *
	 * @param userId the user ID of this user group rel
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user permission group ID of this user group rel.
	 *
	 * @param userPermissionGroupId the user permission group ID of this user group rel
	 */
	@Override
	public void setUserPermissionGroupId(long userPermissionGroupId) {
		model.setUserPermissionGroupId(userPermissionGroupId);
	}

	/**
	 * Sets the user uuid of this user group rel.
	 *
	 * @param userUuid the user uuid of this user group rel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserGroupRelWrapper wrap(UserGroupRel userGroupRel) {
		return new UserGroupRelWrapper(userGroupRel);
	}

}