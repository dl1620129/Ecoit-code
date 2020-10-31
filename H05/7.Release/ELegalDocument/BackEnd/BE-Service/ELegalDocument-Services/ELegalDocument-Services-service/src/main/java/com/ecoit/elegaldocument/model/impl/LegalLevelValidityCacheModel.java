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

import com.ecoit.elegaldocument.model.LegalLevelValidity;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalLevelValidity in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalLevelValidityCacheModel
	implements CacheModel<LegalLevelValidity>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalLevelValidityCacheModel)) {
			return false;
		}

		LegalLevelValidityCacheModel legalLevelValidityCacheModel =
			(LegalLevelValidityCacheModel)obj;

		if (levelValidityId == legalLevelValidityCacheModel.levelValidityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, levelValidityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{levelValidityId=");
		sb.append(levelValidityId);
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
		sb.append(", statusLevelValidity=");
		sb.append(statusLevelValidity);
		sb.append(", position=");
		sb.append(position);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalLevelValidity toEntityModel() {
		LegalLevelValidityImpl legalLevelValidityImpl =
			new LegalLevelValidityImpl();

		legalLevelValidityImpl.setLevelValidityId(levelValidityId);
		legalLevelValidityImpl.setGroupId(groupId);
		legalLevelValidityImpl.setCompanyId(companyId);
		legalLevelValidityImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalLevelValidityImpl.setCreatedDate(null);
		}
		else {
			legalLevelValidityImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalLevelValidityImpl.setModifiedDate(null);
		}
		else {
			legalLevelValidityImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalLevelValidityImpl.setCreatedByUser(createdByUser);
		legalLevelValidityImpl.setModifiedByUser(modifiedByUser);

		if (name == null) {
			legalLevelValidityImpl.setName("");
		}
		else {
			legalLevelValidityImpl.setName(name);
		}

		if (description == null) {
			legalLevelValidityImpl.setDescription("");
		}
		else {
			legalLevelValidityImpl.setDescription(description);
		}

		if (language == null) {
			legalLevelValidityImpl.setLanguage("");
		}
		else {
			legalLevelValidityImpl.setLanguage(language);
		}

		legalLevelValidityImpl.setStatusLevelValidity(statusLevelValidity);
		legalLevelValidityImpl.setPosition(position);

		legalLevelValidityImpl.resetOriginalValues();

		return legalLevelValidityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		levelValidityId = objectInput.readLong();

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

		statusLevelValidity = objectInput.readBoolean();

		position = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(levelValidityId);

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

		objectOutput.writeBoolean(statusLevelValidity);

		objectOutput.writeInt(position);
	}

	public long levelValidityId;
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
	public boolean statusLevelValidity;
	public int position;

}