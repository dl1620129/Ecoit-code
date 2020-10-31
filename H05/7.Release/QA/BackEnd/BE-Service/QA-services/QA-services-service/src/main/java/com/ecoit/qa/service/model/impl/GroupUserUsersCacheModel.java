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

package com.ecoit.qa.service.model.impl;

import com.ecoit.qa.service.model.GroupUserUsers;
import com.ecoit.qa.service.service.persistence.GroupUserUsersPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GroupUserUsers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserUsersCacheModel
	implements CacheModel<GroupUserUsers>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroupUserUsersCacheModel)) {
			return false;
		}

		GroupUserUsersCacheModel groupUserUsersCacheModel =
			(GroupUserUsersCacheModel)obj;

		if (groupUserUsersPK.equals(
				groupUserUsersCacheModel.groupUserUsersPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groupUserUsersPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupUserId=");
		sb.append(groupUserId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GroupUserUsers toEntityModel() {
		GroupUserUsersImpl groupUserUsersImpl = new GroupUserUsersImpl();

		groupUserUsersImpl.setGroupUserId(groupUserId);
		groupUserUsersImpl.setUserId(userId);

		groupUserUsersImpl.resetOriginalValues();

		return groupUserUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupUserId = objectInput.readLong();

		userId = objectInput.readLong();

		groupUserUsersPK = new GroupUserUsersPK(groupUserId, userId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupUserId);

		objectOutput.writeLong(userId);
	}

	public long groupUserId;
	public long userId;
	public transient GroupUserUsersPK groupUserUsersPK;

}