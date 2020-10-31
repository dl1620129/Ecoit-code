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

package User.Rank.Poisition.Service.model.impl;

import User.Rank.Poisition.Service.model.UserChucDanh;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing UserChucDanh in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserChucDanhCacheModel
	implements CacheModel<UserChucDanh>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserChucDanhCacheModel)) {
			return false;
		}

		UserChucDanhCacheModel userChucDanhCacheModel =
			(UserChucDanhCacheModel)obj;

		if (userChucDanhId == userChucDanhCacheModel.userChucDanhId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userChucDanhId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userChucDanhId=");
		sb.append(userChucDanhId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userChucDanhName=");
		sb.append(userChucDanhName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", totalMember=");
		sb.append(totalMember);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserChucDanh toEntityModel() {
		UserChucDanhImpl userChucDanhImpl = new UserChucDanhImpl();

		if (uuid == null) {
			userChucDanhImpl.setUuid("");
		}
		else {
			userChucDanhImpl.setUuid(uuid);
		}

		userChucDanhImpl.setUserChucDanhId(userChucDanhId);
		userChucDanhImpl.setGroupId(groupId);
		userChucDanhImpl.setCompanyId(companyId);
		userChucDanhImpl.setUserId(userId);

		if (userChucDanhName == null) {
			userChucDanhImpl.setUserChucDanhName("");
		}
		else {
			userChucDanhImpl.setUserChucDanhName(userChucDanhName);
		}

		if (description == null) {
			userChucDanhImpl.setDescription("");
		}
		else {
			userChucDanhImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			userChucDanhImpl.setCreateDate(null);
		}
		else {
			userChucDanhImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userChucDanhImpl.setModifiedDate(null);
		}
		else {
			userChucDanhImpl.setModifiedDate(new Date(modifiedDate));
		}

		userChucDanhImpl.setTotalMember(totalMember);

		userChucDanhImpl.resetOriginalValues();

		return userChucDanhImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userChucDanhId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userChucDanhName = objectInput.readUTF();
		description = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		totalMember = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userChucDanhId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userChucDanhName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userChucDanhName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(totalMember);
	}

	public String uuid;
	public long userChucDanhId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userChucDanhName;
	public String description;
	public long createDate;
	public long modifiedDate;
	public long totalMember;

}