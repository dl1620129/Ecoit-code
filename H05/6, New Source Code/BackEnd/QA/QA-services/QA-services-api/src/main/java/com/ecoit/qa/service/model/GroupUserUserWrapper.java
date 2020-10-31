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
 * This class is a wrapper for {@link GroupUserUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUser
 * @generated
 */
public class GroupUserUserWrapper
	extends BaseModelWrapper<GroupUserUser>
	implements GroupUserUser, ModelWrapper<GroupUserUser> {

	public GroupUserUserWrapper(GroupUserUser groupUserUser) {
		super(groupUserUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	 * Returns the group user ID of this group user user.
	 *
	 * @return the group user ID of this group user user
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group user user.
	 *
	 * @return the group user uuid of this group user user
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the primary key of this group user user.
	 *
	 * @return the primary key of this group user user
	 */
	@Override
	public com.ecoit.qa.service.service.persistence.GroupUserUserPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this group user user.
	 *
	 * @return the user ID of this group user user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this group user user.
	 *
	 * @return the user uuid of this group user user
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
	 * Sets the group user ID of this group user user.
	 *
	 * @param groupUserId the group user ID of this group user user
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group user user.
	 *
	 * @param groupUserUuid the group user uuid of this group user user
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the primary key of this group user user.
	 *
	 * @param primaryKey the primary key of this group user user
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.qa.service.service.persistence.GroupUserUserPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this group user user.
	 *
	 * @param userId the user ID of this group user user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this group user user.
	 *
	 * @param userUuid the user uuid of this group user user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected GroupUserUserWrapper wrap(GroupUserUser groupUserUser) {
		return new GroupUserUserWrapper(groupUserUser);
	}

}