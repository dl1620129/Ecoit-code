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

import organizationalStructure.service.model.organization;

/**
 * The cache model class for representing organization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class organizationCacheModel
	implements CacheModel<organization>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof organizationCacheModel)) {
			return false;
		}

		organizationCacheModel organizationCacheModel =
			(organizationCacheModel)obj;

		if (organizationId == organizationCacheModel.organizationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", organizationCode=");
		sb.append(organizationCode);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", leader=");
		sb.append(leader);
		sb.append(", member=");
		sb.append(member);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", position=");
		sb.append(position);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createUser=");
		sb.append(createUser);
		sb.append(", modifiedUser=");
		sb.append(modifiedUser);
		sb.append(", status=");
		sb.append(status);
		sb.append(", thuTu=");
		sb.append(thuTu);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public organization toEntityModel() {
		organizationImpl organizationImpl = new organizationImpl();

		if (uuid == null) {
			organizationImpl.setUuid("");
		}
		else {
			organizationImpl.setUuid(uuid);
		}

		organizationImpl.setOrganizationId(organizationId);

		if (organizationCode == null) {
			organizationImpl.setOrganizationCode("");
		}
		else {
			organizationImpl.setOrganizationCode(organizationCode);
		}

		organizationImpl.setGroupId(groupId);

		if (name == null) {
			organizationImpl.setName("");
		}
		else {
			organizationImpl.setName(name);
		}

		if (description == null) {
			organizationImpl.setDescription("");
		}
		else {
			organizationImpl.setDescription(description);
		}

		if (leader == null) {
			organizationImpl.setLeader("");
		}
		else {
			organizationImpl.setLeader(leader);
		}

		organizationImpl.setMember(member);

		if (address == null) {
			organizationImpl.setAddress("");
		}
		else {
			organizationImpl.setAddress(address);
		}

		if (phoneNumber == null) {
			organizationImpl.setPhoneNumber("");
		}
		else {
			organizationImpl.setPhoneNumber(phoneNumber);
		}

		if (position == null) {
			organizationImpl.setPosition("");
		}
		else {
			organizationImpl.setPosition(position);
		}

		organizationImpl.setParentId(parentId);

		if (createDate == Long.MIN_VALUE) {
			organizationImpl.setCreateDate(null);
		}
		else {
			organizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationImpl.setModifiedDate(null);
		}
		else {
			organizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationImpl.setCreateUser(createUser);
		organizationImpl.setModifiedUser(modifiedUser);
		organizationImpl.setStatus(status);
		organizationImpl.setThuTu(thuTu);

		organizationImpl.resetOriginalValues();

		return organizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		organizationId = objectInput.readLong();
		organizationCode = objectInput.readUTF();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		leader = objectInput.readUTF();

		member = objectInput.readLong();
		address = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		position = objectInput.readUTF();

		parentId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createUser = objectInput.readLong();

		modifiedUser = objectInput.readLong();

		status = objectInput.readLong();

		thuTu = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(organizationId);

		if (organizationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organizationCode);
		}

		objectOutput.writeLong(groupId);

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

		if (leader == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leader);
		}

		objectOutput.writeLong(member);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (position == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(position);
		}

		objectOutput.writeLong(parentId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createUser);

		objectOutput.writeLong(modifiedUser);

		objectOutput.writeLong(status);

		objectOutput.writeInt(thuTu);
	}

	public String uuid;
	public long organizationId;
	public String organizationCode;
	public long groupId;
	public String name;
	public String description;
	public String leader;
	public long member;
	public String address;
	public String phoneNumber;
	public String position;
	public long parentId;
	public long createDate;
	public long modifiedDate;
	public long createUser;
	public long modifiedUser;
	public long status;
	public int thuTu;

}