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

import com.ecoit.qa.service.service.persistence.GroupUserUserPK;

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the GroupUserUser service. Represents a row in the &quot;ecoit_qa_GroupUserUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ecoit.qa.service.model.impl.GroupUserUserModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ecoit.qa.service.model.impl.GroupUserUserImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUser
 * @generated
 */
@ProviderType
public interface GroupUserUserModel extends BaseModel<GroupUserUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a group user user model instance should use the {@link GroupUserUser} interface instead.
	 */

	/**
	 * Returns the primary key of this group user user.
	 *
	 * @return the primary key of this group user user
	 */
	public GroupUserUserPK getPrimaryKey();

	/**
	 * Sets the primary key of this group user user.
	 *
	 * @param primaryKey the primary key of this group user user
	 */
	public void setPrimaryKey(GroupUserUserPK primaryKey);

	/**
	 * Returns the group user ID of this group user user.
	 *
	 * @return the group user ID of this group user user
	 */
	public long getGroupUserId();

	/**
	 * Sets the group user ID of this group user user.
	 *
	 * @param groupUserId the group user ID of this group user user
	 */
	public void setGroupUserId(long groupUserId);

	/**
	 * Returns the group user uuid of this group user user.
	 *
	 * @return the group user uuid of this group user user
	 */
	public String getGroupUserUuid();

	/**
	 * Sets the group user uuid of this group user user.
	 *
	 * @param groupUserUuid the group user uuid of this group user user
	 */
	public void setGroupUserUuid(String groupUserUuid);

	/**
	 * Returns the user ID of this group user user.
	 *
	 * @return the user ID of this group user user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this group user user.
	 *
	 * @param userId the user ID of this group user user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this group user user.
	 *
	 * @return the user uuid of this group user user
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this group user user.
	 *
	 * @param userUuid the user uuid of this group user user
	 */
	public void setUserUuid(String userUuid);

}