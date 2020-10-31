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

import com.ecoit.mr.model.Unit;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Unit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UnitCacheModel implements CacheModel<Unit>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UnitCacheModel)) {
			return false;
		}

		UnitCacheModel unitCacheModel = (UnitCacheModel)obj;

		if (unitId == unitCacheModel.unitId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, unitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{unitId=");
		sb.append(unitId);
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
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", language=");
		sb.append(language);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Unit toEntityModel() {
		UnitImpl unitImpl = new UnitImpl();

		unitImpl.setUnitId(unitId);
		unitImpl.setGroupId(groupId);
		unitImpl.setCompanyId(companyId);
		unitImpl.setUserId(userId);

		if (userName == null) {
			unitImpl.setUserName("");
		}
		else {
			unitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			unitImpl.setCreateDate(null);
		}
		else {
			unitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			unitImpl.setModifiedDate(null);
		}
		else {
			unitImpl.setModifiedDate(new Date(modifiedDate));
		}

		unitImpl.setCreatedByUser(createdByUser);
		unitImpl.setModifiedByUser(modifiedByUser);

		if (name == null) {
			unitImpl.setName("");
		}
		else {
			unitImpl.setName(name);
		}

		if (description == null) {
			unitImpl.setDescription("");
		}
		else {
			unitImpl.setDescription(description);
		}

		if (language == null) {
			unitImpl.setLanguage("");
		}
		else {
			unitImpl.setLanguage(language);
		}

		unitImpl.resetOriginalValues();

		return unitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		unitId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByUser = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		language = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(unitId);

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
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdByUser);

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

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}
	}

	public long unitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createdByUser;
	public long modifiedByUser;
	public String name;
	public String description;
	public String language;

}