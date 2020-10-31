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

import User.Rank.Poisition.Service.model.UserPoisition_Dang;

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
 * The cache model class for representing UserPoisition_Dang in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserPoisition_DangCacheModel
	implements CacheModel<UserPoisition_Dang>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPoisition_DangCacheModel)) {
			return false;
		}

		UserPoisition_DangCacheModel userPoisition_DangCacheModel =
			(UserPoisition_DangCacheModel)obj;

		if (userPoisitionDangId ==
				userPoisition_DangCacheModel.userPoisitionDangId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userPoisitionDangId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userPoisitionDangId=");
		sb.append(userPoisitionDangId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userPoisitionDangName=");
		sb.append(userPoisitionDangName);
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
	public UserPoisition_Dang toEntityModel() {
		UserPoisition_DangImpl userPoisition_DangImpl =
			new UserPoisition_DangImpl();

		if (uuid == null) {
			userPoisition_DangImpl.setUuid("");
		}
		else {
			userPoisition_DangImpl.setUuid(uuid);
		}

		userPoisition_DangImpl.setUserPoisitionDangId(userPoisitionDangId);
		userPoisition_DangImpl.setGroupId(groupId);
		userPoisition_DangImpl.setCompanyId(companyId);
		userPoisition_DangImpl.setUserId(userId);

		if (userPoisitionDangName == null) {
			userPoisition_DangImpl.setUserPoisitionDangName("");
		}
		else {
			userPoisition_DangImpl.setUserPoisitionDangName(
				userPoisitionDangName);
		}

		if (description == null) {
			userPoisition_DangImpl.setDescription("");
		}
		else {
			userPoisition_DangImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			userPoisition_DangImpl.setCreateDate(null);
		}
		else {
			userPoisition_DangImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userPoisition_DangImpl.setModifiedDate(null);
		}
		else {
			userPoisition_DangImpl.setModifiedDate(new Date(modifiedDate));
		}

		userPoisition_DangImpl.setTotalMember(totalMember);

		userPoisition_DangImpl.resetOriginalValues();

		return userPoisition_DangImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userPoisitionDangId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userPoisitionDangName = objectInput.readUTF();
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

		objectOutput.writeLong(userPoisitionDangId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userPoisitionDangName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userPoisitionDangName);
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
	public long userPoisitionDangId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userPoisitionDangName;
	public String description;
	public long createDate;
	public long modifiedDate;
	public long totalMember;

}