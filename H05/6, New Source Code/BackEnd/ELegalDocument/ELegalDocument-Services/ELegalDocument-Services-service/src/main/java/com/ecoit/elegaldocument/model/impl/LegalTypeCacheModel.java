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

package com.ecoit.elegaldocument.model.impl;

import com.ecoit.elegaldocument.model.LegalType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalType in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalTypeCacheModel
	implements CacheModel<LegalType>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalTypeCacheModel)) {
			return false;
		}

		LegalTypeCacheModel legalTypeCacheModel = (LegalTypeCacheModel)obj;

		if (typeId == legalTypeCacheModel.typeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
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
		sb.append(", statusType=");
		sb.append(statusType);
		sb.append(", rssable=");
		sb.append(rssable);
		sb.append(", position=");
		sb.append(position);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalType toEntityModel() {
		LegalTypeImpl legalTypeImpl = new LegalTypeImpl();

		legalTypeImpl.setTypeId(typeId);
		legalTypeImpl.setGroupId(groupId);
		legalTypeImpl.setCompanyId(companyId);
		legalTypeImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalTypeImpl.setCreatedDate(null);
		}
		else {
			legalTypeImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalTypeImpl.setModifiedDate(null);
		}
		else {
			legalTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalTypeImpl.setCreatedByUser(createdByUser);
		legalTypeImpl.setModifiedByUser(modifiedByUser);

		if (name == null) {
			legalTypeImpl.setName("");
		}
		else {
			legalTypeImpl.setName(name);
		}

		if (description == null) {
			legalTypeImpl.setDescription("");
		}
		else {
			legalTypeImpl.setDescription(description);
		}

		if (language == null) {
			legalTypeImpl.setLanguage("");
		}
		else {
			legalTypeImpl.setLanguage(language);
		}

		legalTypeImpl.setStatusType(statusType);
		legalTypeImpl.setRssable(rssable);
		legalTypeImpl.setPosition(position);
		legalTypeImpl.setParentId(parentId);

		legalTypeImpl.resetOriginalValues();

		return legalTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByUser = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		language = objectInput.readUTF();

		statusType = objectInput.readBoolean();

		rssable = objectInput.readBoolean();

		position = objectInput.readInt();

		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(typeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
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

		objectOutput.writeBoolean(statusType);

		objectOutput.writeBoolean(rssable);

		objectOutput.writeInt(position);

		objectOutput.writeLong(parentId);
	}

	public long typeId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long createdByUser;
	public long modifiedByUser;
	public String name;
	public String description;
	public String language;
	public boolean statusType;
	public boolean rssable;
	public int position;
	public long parentId;

}