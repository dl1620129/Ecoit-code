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

package organizationalStructure.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

import organizationalStructure.service.model.members;

/**
 * The cache model class for representing members in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class membersCacheModel implements CacheModel<members>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof membersCacheModel)) {
			return false;
		}

		membersCacheModel membersCacheModel = (membersCacheModel)obj;

		if (memberId == membersCacheModel.memberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", address=");
		sb.append(address);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", position=");
		sb.append(position);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createUser=");
		sb.append(createUser);
		sb.append(", modifiedUser=");
		sb.append(modifiedUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", isLeader=");
		sb.append(isLeader);
		sb.append(", urlImage=");
		sb.append(urlImage);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", imageFileId=");
		sb.append(imageFileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public members toEntityModel() {
		membersImpl membersImpl = new membersImpl();

		if (uuid == null) {
			membersImpl.setUuid("");
		}
		else {
			membersImpl.setUuid(uuid);
		}

		membersImpl.setMemberId(memberId);
		membersImpl.setGroupId(groupId);
		membersImpl.setOrganizationId(organizationId);

		if (fullName == null) {
			membersImpl.setFullName("");
		}
		else {
			membersImpl.setFullName(fullName);
		}

		if (birthday == Long.MIN_VALUE) {
			membersImpl.setBirthday(null);
		}
		else {
			membersImpl.setBirthday(new Date(birthday));
		}

		if (address == null) {
			membersImpl.setAddress("");
		}
		else {
			membersImpl.setAddress(address);
		}

		membersImpl.setSex(sex);

		if (position == null) {
			membersImpl.setPosition("");
		}
		else {
			membersImpl.setPosition(position);
		}

		if (createDate == Long.MIN_VALUE) {
			membersImpl.setCreateDate(null);
		}
		else {
			membersImpl.setCreateDate(new Date(createDate));
		}

		membersImpl.setCreateUser(createUser);
		membersImpl.setModifiedUser(modifiedUser);

		if (modifiedDate == Long.MIN_VALUE) {
			membersImpl.setModifiedDate(null);
		}
		else {
			membersImpl.setModifiedDate(new Date(modifiedDate));
		}

		membersImpl.setIsLeader(isLeader);

		if (urlImage == null) {
			membersImpl.setUrlImage("");
		}
		else {
			membersImpl.setUrlImage(urlImage);
		}

		membersImpl.setFolderId(folderId);
		membersImpl.setImageFileId(imageFileId);

		membersImpl.resetOriginalValues();

		return membersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		memberId = objectInput.readLong();

		groupId = objectInput.readLong();

		organizationId = objectInput.readLong();
		fullName = objectInput.readUTF();
		birthday = objectInput.readLong();
		address = objectInput.readUTF();

		sex = objectInput.readBoolean();
		position = objectInput.readUTF();
		createDate = objectInput.readLong();

		createUser = objectInput.readLong();

		modifiedUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		isLeader = objectInput.readBoolean();
		urlImage = objectInput.readUTF();

		folderId = objectInput.readLong();

		imageFileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(memberId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(organizationId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeLong(birthday);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeBoolean(sex);

		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createUser);

		objectOutput.writeLong(modifiedUser);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(isLeader);

		if (urlImage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlImage);
		}

		objectOutput.writeLong(folderId);

		objectOutput.writeLong(imageFileId);
	}

	public String uuid;
	public long memberId;
	public long groupId;
	public long organizationId;
	public String fullName;
	public long birthday;
	public String address;
	public boolean sex;
	public String position;
	public long createDate;
	public long createUser;
	public long modifiedUser;
	public long modifiedDate;
	public boolean isLeader;
	public String urlImage;
	public long folderId;
	public long imageFileId;

}