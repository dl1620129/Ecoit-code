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

package com.ecoit.mr.model.impl;

import com.ecoit.mr.model.UserGroup;
import com.ecoit.mr.service.persistence.UserGroupPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserGroupCacheModel
	implements CacheModel<UserGroup>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserGroupCacheModel)) {
			return false;
		}

		UserGroupCacheModel userGroupCacheModel = (UserGroupCacheModel)obj;

		if (userGroupPK.equals(userGroupCacheModel.userGroupPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userGroupPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", userPermissionGroupId=");
		sb.append(userPermissionGroupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserGroup toEntityModel() {
		UserGroupImpl userGroupImpl = new UserGroupImpl();

		userGroupImpl.setUserId(userId);
		userGroupImpl.setUserPermissionGroupId(userPermissionGroupId);

		userGroupImpl.resetOriginalValues();

		return userGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		userPermissionGroupId = objectInput.readLong();

		userGroupPK = new UserGroupPK(userId, userPermissionGroupId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(userPermissionGroupId);
	}

	public long userId;
	public long userPermissionGroupId;
	public transient UserGroupPK userGroupPK;

}