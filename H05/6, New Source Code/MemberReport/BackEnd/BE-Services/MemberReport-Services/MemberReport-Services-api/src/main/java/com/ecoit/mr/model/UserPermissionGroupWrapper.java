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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserPermissionGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPermissionGroup
 * @generated
 */
public class UserPermissionGroupWrapper
	extends BaseModelWrapper<UserPermissionGroup>
	implements ModelWrapper<UserPermissionGroup>, UserPermissionGroup {

	public UserPermissionGroupWrapper(UserPermissionGroup userPermissionGroup) {
		super(userPermissionGroup);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userPermissionGroupId", getUserPermissionGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupName", getGroupName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userPermissionGroupId = (Long)attributes.get(
			"userPermissionGroupId");

		if (userPermissionGroupId != null) {
			setUserPermissionGroupId(userPermissionGroupId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the company ID of this user permission group.
	 *
	 * @return the company ID of this user permission group
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user permission group.
	 *
	 * @return the create date of this user permission group
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this user permission group.
	 *
	 * @return the description of this user permission group
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this user permission group.
	 *
	 * @return the group ID of this user permission group
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the group name of this user permission group.
	 *
	 * @return the group name of this user permission group
	 */
	@Override
	public String getGroupName() {
		return model.getGroupName();
	}

	/**
	 * Returns the modified date of this user permission group.
	 *
	 * @return the modified date of this user permission group
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user permission group.
	 *
	 * @return the primary key of this user permission group
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this user permission group.
	 *
	 * @return the user ID of this user permission group
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user permission group.
	 *
	 * @return the user name of this user permission group
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user permission group ID of this user permission group.
	 *
	 * @return the user permission group ID of this user permission group
	 */
	@Override
	public long getUserPermissionGroupId() {
		return model.getUserPermissionGroupId();
	}

	/**
	 * Returns the user uuid of this user permission group.
	 *
	 * @return the user uuid of this user permission group
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
	 * Sets the company ID of this user permission group.
	 *
	 * @param companyId the company ID of this user permission group
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user permission group.
	 *
	 * @param createDate the create date of this user permission group
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this user permission group.
	 *
	 * @param description the description of this user permission group
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this user permission group.
	 *
	 * @param groupId the group ID of this user permission group
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the group name of this user permission group.
	 *
	 * @param groupName the group name of this user permission group
	 */
	@Override
	public void setGroupName(String groupName) {
		model.setGroupName(groupName);
	}

	/**
	 * Sets the modified date of this user permission group.
	 *
	 * @param modifiedDate the modified date of this user permission group
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user permission group.
	 *
	 * @param primaryKey the primary key of this user permission group
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this user permission group.
	 *
	 * @param userId the user ID of this user permission group
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user permission group.
	 *
	 * @param userName the user name of this user permission group
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user permission group ID of this user permission group.
	 *
	 * @param userPermissionGroupId the user permission group ID of this user permission group
	 */
	@Override
	public void setUserPermissionGroupId(long userPermissionGroupId) {
		model.setUserPermissionGroupId(userPermissionGroupId);
	}

	/**
	 * Sets the user uuid of this user permission group.
	 *
	 * @param userUuid the user uuid of this user permission group
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserPermissionGroupWrapper wrap(
		UserPermissionGroup userPermissionGroup) {

		return new UserPermissionGroupWrapper(userPermissionGroup);
	}

}