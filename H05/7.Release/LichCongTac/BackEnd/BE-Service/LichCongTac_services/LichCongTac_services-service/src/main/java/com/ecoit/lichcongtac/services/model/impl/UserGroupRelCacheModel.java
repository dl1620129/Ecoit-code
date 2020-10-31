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

package com.ecoit.lichcongtac.services.model.impl;

import com.ecoit.lichcongtac.services.model.UserGroupRel;
import com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserGroupRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserGroupRelCacheModel
	implements CacheModel<UserGroupRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserGroupRelCacheModel)) {
			return false;
		}

		UserGroupRelCacheModel userGroupRelCacheModel =
			(UserGroupRelCacheModel)obj;

		if (userGroupRelPK.equals(userGroupRelCacheModel.userGroupRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userGroupRelPK);
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
	public UserGroupRel toEntityModel() {
		UserGroupRelImpl userGroupRelImpl = new UserGroupRelImpl();

		userGroupRelImpl.setUserId(userId);
		userGroupRelImpl.setUserPermissionGroupId(userPermissionGroupId);

		userGroupRelImpl.resetOriginalValues();

		return userGroupRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		userPermissionGroupId = objectInput.readLong();

		userGroupRelPK = new UserGroupRelPK(userId, userPermissionGroupId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(userPermissionGroupId);
	}

	public long userId;
	public long userPermissionGroupId;
	public transient UserGroupRelPK userGroupRelPK;

}