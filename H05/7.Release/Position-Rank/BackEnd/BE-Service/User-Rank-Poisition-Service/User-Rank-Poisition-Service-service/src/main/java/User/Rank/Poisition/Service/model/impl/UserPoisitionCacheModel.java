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

import User.Rank.Poisition.Service.model.UserPoisition;

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
 * The cache model class for representing UserPoisition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserPoisitionCacheModel
	implements CacheModel<UserPoisition>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPoisitionCacheModel)) {
			return false;
		}

		UserPoisitionCacheModel userPoisitionCacheModel =
			(UserPoisitionCacheModel)obj;

		if (userPoisitionId == userPoisitionCacheModel.userPoisitionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userPoisitionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userPoisitionId=");
		sb.append(userPoisitionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userPoisitionName=");
		sb.append(userPoisitionName);
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
	public UserPoisition toEntityModel() {
		UserPoisitionImpl userPoisitionImpl = new UserPoisitionImpl();

		if (uuid == null) {
			userPoisitionImpl.setUuid("");
		}
		else {
			userPoisitionImpl.setUuid(uuid);
		}

		userPoisitionImpl.setUserPoisitionId(userPoisitionId);
		userPoisitionImpl.setGroupId(groupId);
		userPoisitionImpl.setCompanyId(companyId);
		userPoisitionImpl.setUserId(userId);

		if (userPoisitionName == null) {
			userPoisitionImpl.setUserPoisitionName("");
		}
		else {
			userPoisitionImpl.setUserPoisitionName(userPoisitionName);
		}

		if (description == null) {
			userPoisitionImpl.setDescription("");
		}
		else {
			userPoisitionImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			userPoisitionImpl.setCreateDate(null);
		}
		else {
			userPoisitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userPoisitionImpl.setModifiedDate(null);
		}
		else {
			userPoisitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		userPoisitionImpl.setTotalMember(totalMember);

		userPoisitionImpl.resetOriginalValues();

		return userPoisitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userPoisitionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userPoisitionName = objectInput.readUTF();
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

		objectOutput.writeLong(userPoisitionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userPoisitionName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userPoisitionName);
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
	public long userPoisitionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userPoisitionName;
	public String description;
	public long createDate;
	public long modifiedDate;
	public long totalMember;

}