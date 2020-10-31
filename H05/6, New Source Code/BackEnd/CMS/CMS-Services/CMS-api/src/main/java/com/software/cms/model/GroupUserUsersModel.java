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

import com.liferay.portal.kernel.model.BaseModel;

import com.software.cms.service.persistence.GroupUserUsersPK;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the GroupUserUsers service. Represents a row in the &quot;soft_cms_GroupUserUsers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.software.cms.model.impl.GroupUserUsersModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.software.cms.model.impl.GroupUserUsersImpl</code>.
 * </p>
 *
 * @author DungNV
 * @see GroupUserUsers
 * @generated
 */
@ProviderType
public interface GroupUserUsersModel extends BaseModel<GroupUserUsers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a group user users model instance should use the {@link GroupUserUsers} interface instead.
	 */

	/**
	 * Returns the primary key of this group user users.
	 *
	 * @return the primary key of this group user users
	 */
	public GroupUserUsersPK getPrimaryKey();

	/**
	 * Sets the primary key of this group user users.
	 *
	 * @param primaryKey the primary key of this group user users
	 */
	public void setPrimaryKey(GroupUserUsersPK primaryKey);

	/**
	 * Returns the group user ID of this group user users.
	 *
	 * @return the group user ID of this group user users
	 */
	public long getGroupUserId();

	/**
	 * Sets the group user ID of this group user users.
	 *
	 * @param groupUserId the group user ID of this group user users
	 */
	public void setGroupUserId(long groupUserId);

	/**
	 * Returns the group user uuid of this group user users.
	 *
	 * @return the group user uuid of this group user users
	 */
	public String getGroupUserUuid();

	/**
	 * Sets the group user uuid of this group user users.
	 *
	 * @param groupUserUuid the group user uuid of this group user users
	 */
	public void setGroupUserUuid(String groupUserUuid);

	/**
	 * Returns the user ID of this group user users.
	 *
	 * @return the user ID of this group user users
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this group user users.
	 *
	 * @param userId the user ID of this group user users
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this group user users.
	 *
	 * @return the user uuid of this group user users
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this group user users.
	 *
	 * @param userUuid the user uuid of this group user users
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this group user users.
	 *
	 * @return the group ID of this group user users
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this group user users.
	 *
	 * @param groupId the group ID of this group user users
	 */
	public void setGroupId(long groupId);

}