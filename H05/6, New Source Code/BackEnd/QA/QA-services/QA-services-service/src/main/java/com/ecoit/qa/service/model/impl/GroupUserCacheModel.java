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

import com.ecoit.qa.service.model.GroupUser;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GroupUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserCacheModel
	implements CacheModel<GroupUser>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroupUserCacheModel)) {
			return false;
		}

		GroupUserCacheModel groupUserCacheModel = (GroupUserCacheModel)obj;

		if (groupUserId == groupUserCacheModel.groupUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groupUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{groupUserId=");
		sb.append(groupUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GroupUser toEntityModel() {
		GroupUserImpl groupUserImpl = new GroupUserImpl();

		groupUserImpl.setGroupUserId(groupUserId);
		groupUserImpl.setGroupId(groupId);
		groupUserImpl.setCompanyId(companyId);
		groupUserImpl.setUserId(userId);

		if (userName == null) {
			groupUserImpl.setUserName("");
		}
		else {
			groupUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			groupUserImpl.setCreateDate(null);
		}
		else {
			groupUserImpl.setCreateDate(new Date(createDate));
		}

		groupUserImpl.setCreatedByUser(createdByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			groupUserImpl.setModifiedDate(null);
		}
		else {
			groupUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		groupUserImpl.setModifiedByUser(modifiedByUser);

		if (name == null) {
			groupUserImpl.setName("");
		}
		else {
			groupUserImpl.setName(name);
		}

		if (description == null) {
			groupUserImpl.setDescription("");
		}
		else {
			groupUserImpl.setDescription(description);
		}

		groupUserImpl.resetOriginalValues();

		return groupUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupUserId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdByUser);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedByUser);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long groupUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdByUser;
	public long modifiedDate;
	public long modifiedByUser;
	public String name;
	public String description;

}