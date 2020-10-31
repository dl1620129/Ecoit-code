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
 * This class is a wrapper for {@link GroupUser}.
 * </p>
 *
 * @author DungNV
 * @see GroupUser
 * @generated
 */
public class GroupUserWrapper
	extends BaseModelWrapper<GroupUser>
	implements GroupUser, ModelWrapper<GroupUser> {

	public GroupUserWrapper(GroupUser groupUser) {
		super(groupUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the description of this group user.
	 *
	 * @return the description of this group user
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this group user.
	 *
	 * @return the group ID of this group user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the group user ID of this group user.
	 *
	 * @return the group user ID of this group user
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group user.
	 *
	 * @return the group user uuid of this group user
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the language of this group user.
	 *
	 * @return the language of this group user
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the name of this group user.
	 *
	 * @return the name of this group user
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this group user.
	 *
	 * @return the primary key of this group user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description of this group user.
	 *
	 * @param description the description of this group user
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this group user.
	 *
	 * @param groupId the group ID of this group user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the group user ID of this group user.
	 *
	 * @param groupUserId the group user ID of this group user
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group user.
	 *
	 * @param groupUserUuid the group user uuid of this group user
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the language of this group user.
	 *
	 * @param language the language of this group user
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the name of this group user.
	 *
	 * @param name the name of this group user
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this group user.
	 *
	 * @param primaryKey the primary key of this group user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupUserWrapper wrap(GroupUser groupUser) {
		return new GroupUserWrapper(groupUser);
	}

}