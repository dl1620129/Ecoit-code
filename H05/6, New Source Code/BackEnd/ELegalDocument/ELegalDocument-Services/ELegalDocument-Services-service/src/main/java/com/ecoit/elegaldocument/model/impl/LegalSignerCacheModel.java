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

import com.ecoit.elegaldocument.model.LegalSigner;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalSigner in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalSignerCacheModel
	implements CacheModel<LegalSigner>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalSignerCacheModel)) {
			return false;
		}

		LegalSignerCacheModel legalSignerCacheModel =
			(LegalSignerCacheModel)obj;

		if (sigId == legalSignerCacheModel.sigId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sigId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{sigId=");
		sb.append(sigId);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", language=");
		sb.append(language);
		sb.append(", statusSigner=");
		sb.append(statusSigner);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalSigner toEntityModel() {
		LegalSignerImpl legalSignerImpl = new LegalSignerImpl();

		legalSignerImpl.setSigId(sigId);
		legalSignerImpl.setGroupId(groupId);
		legalSignerImpl.setCompanyId(companyId);
		legalSignerImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalSignerImpl.setCreatedDate(null);
		}
		else {
			legalSignerImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalSignerImpl.setModifiedDate(null);
		}
		else {
			legalSignerImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalSignerImpl.setCreatedByUser(createdByUser);
		legalSignerImpl.setModifiedByUser(modifiedByUser);

		if (firstName == null) {
			legalSignerImpl.setFirstName("");
		}
		else {
			legalSignerImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			legalSignerImpl.setLastName("");
		}
		else {
			legalSignerImpl.setLastName(lastName);
		}

		if (language == null) {
			legalSignerImpl.setLanguage("");
		}
		else {
			legalSignerImpl.setLanguage(language);
		}

		legalSignerImpl.setStatusSigner(statusSigner);

		if (fullName == null) {
			legalSignerImpl.setFullName("");
		}
		else {
			legalSignerImpl.setFullName(fullName);
		}

		legalSignerImpl.resetOriginalValues();

		return legalSignerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sigId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByUser = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		language = objectInput.readUTF();

		statusSigner = objectInput.readBoolean();
		fullName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(sigId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdByUser);

		objectOutput.writeLong(modifiedByUser);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeBoolean(statusSigner);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}
	}

	public long sigId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long createdByUser;
	public long modifiedByUser;
	public String firstName;
	public String lastName;
	public String language;
	public boolean statusSigner;
	public String fullName;

}