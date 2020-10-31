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

package ChungThuSo.Service.model.impl;

import ChungThuSo.Service.model.Kyso;

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
 * The cache model class for representing Kyso in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class KysoCacheModel implements CacheModel<Kyso>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KysoCacheModel)) {
			return false;
		}

		KysoCacheModel kysoCacheModel = (KysoCacheModel)obj;

		if (kysoId == kysoCacheModel.kysoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, kysoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", kysoId=");
		sb.append(kysoId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", rawData=");
		sb.append(rawData);
		sb.append(", serialNumber=");
		sb.append(serialNumber);
		sb.append(", details=");
		sb.append(details);
		sb.append(", organization=");
		sb.append(organization);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Kyso toEntityModel() {
		KysoImpl kysoImpl = new KysoImpl();

		if (uuid == null) {
			kysoImpl.setUuid("");
		}
		else {
			kysoImpl.setUuid(uuid);
		}

		kysoImpl.setKysoId(kysoId);
		kysoImpl.setGroupId(groupId);
		kysoImpl.setCompanyId(companyId);
		kysoImpl.setUserId(userId);

		if (screenName == null) {
			kysoImpl.setScreenName("");
		}
		else {
			kysoImpl.setScreenName(screenName);
		}

		if (createDate == Long.MIN_VALUE) {
			kysoImpl.setCreateDate(null);
		}
		else {
			kysoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kysoImpl.setModifiedDate(null);
		}
		else {
			kysoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (rawData == null) {
			kysoImpl.setRawData("");
		}
		else {
			kysoImpl.setRawData(rawData);
		}

		if (serialNumber == null) {
			kysoImpl.setSerialNumber("");
		}
		else {
			kysoImpl.setSerialNumber(serialNumber);
		}

		if (details == null) {
			kysoImpl.setDetails("");
		}
		else {
			kysoImpl.setDetails(details);
		}

		if (organization == null) {
			kysoImpl.setOrganization("");
		}
		else {
			kysoImpl.setOrganization(organization);
		}

		if (userName == null) {
			kysoImpl.setUserName("");
		}
		else {
			kysoImpl.setUserName(userName);
		}

		kysoImpl.setCreateUserId(createUserId);

		if (fromDate == Long.MIN_VALUE) {
			kysoImpl.setFromDate(null);
		}
		else {
			kysoImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			kysoImpl.setToDate(null);
		}
		else {
			kysoImpl.setToDate(new Date(toDate));
		}

		kysoImpl.resetOriginalValues();

		return kysoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		kysoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		screenName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rawData = objectInput.readUTF();
		serialNumber = objectInput.readUTF();
		details = objectInput.readUTF();
		organization = objectInput.readUTF();
		userName = objectInput.readUTF();

		createUserId = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(kysoId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (screenName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (rawData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rawData);
		}

		if (serialNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serialNumber);
		}

		if (details == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(details);
		}

		if (organization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organization);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
	}

	public String uuid;
	public long kysoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String screenName;
	public long createDate;
	public long modifiedDate;
	public String rawData;
	public String serialNumber;
	public String details;
	public String organization;
	public String userName;
	public long createUserId;
	public long fromDate;
	public long toDate;

}