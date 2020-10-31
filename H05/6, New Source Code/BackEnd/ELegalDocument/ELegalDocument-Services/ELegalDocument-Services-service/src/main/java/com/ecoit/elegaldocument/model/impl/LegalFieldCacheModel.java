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

import com.ecoit.elegaldocument.model.LegalField;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalField in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalFieldCacheModel
	implements CacheModel<LegalField>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalFieldCacheModel)) {
			return false;
		}

		LegalFieldCacheModel legalFieldCacheModel = (LegalFieldCacheModel)obj;

		if (fieldId == legalFieldCacheModel.fieldId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fieldId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{fieldId=");
		sb.append(fieldId);
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
		sb.append(", statusField=");
		sb.append(statusField);
		sb.append(", rssable=");
		sb.append(rssable);
		sb.append(", position=");
		sb.append(position);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalField toEntityModel() {
		LegalFieldImpl legalFieldImpl = new LegalFieldImpl();

		legalFieldImpl.setFieldId(fieldId);
		legalFieldImpl.setGroupId(groupId);
		legalFieldImpl.setCompanyId(companyId);
		legalFieldImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalFieldImpl.setCreatedDate(null);
		}
		else {
			legalFieldImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalFieldImpl.setModifiedDate(null);
		}
		else {
			legalFieldImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalFieldImpl.setCreatedByUser(createdByUser);
		legalFieldImpl.setModifiedByUser(modifiedByUser);

		if (name == null) {
			legalFieldImpl.setName("");
		}
		else {
			legalFieldImpl.setName(name);
		}

		if (description == null) {
			legalFieldImpl.setDescription("");
		}
		else {
			legalFieldImpl.setDescription(description);
		}

		if (language == null) {
			legalFieldImpl.setLanguage("");
		}
		else {
			legalFieldImpl.setLanguage(language);
		}

		legalFieldImpl.setStatusField(statusField);
		legalFieldImpl.setRssable(rssable);
		legalFieldImpl.setPosition(position);

		legalFieldImpl.resetOriginalValues();

		return legalFieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fieldId = objectInput.readLong();

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

		statusField = objectInput.readBoolean();

		rssable = objectInput.readBoolean();

		position = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fieldId);

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

		objectOutput.writeBoolean(statusField);

		objectOutput.writeBoolean(rssable);

		objectOutput.writeInt(position);
	}

	public long fieldId;
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
	public boolean statusField;
	public boolean rssable;
	public int position;

}