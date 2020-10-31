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

import com.ecoit.elegaldocument.model.LegalLogger;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalLogger in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalLoggerCacheModel
	implements CacheModel<LegalLogger>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalLoggerCacheModel)) {
			return false;
		}

		LegalLoggerCacheModel legalLoggerCacheModel =
			(LegalLoggerCacheModel)obj;

		if (loggerId.equals(legalLoggerCacheModel.loggerId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, loggerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{loggerId=");
		sb.append(loggerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", entryId=");
		sb.append(entryId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", classEntry=");
		sb.append(classEntry);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalLogger toEntityModel() {
		LegalLoggerImpl legalLoggerImpl = new LegalLoggerImpl();

		if (loggerId == null) {
			legalLoggerImpl.setLoggerId("");
		}
		else {
			legalLoggerImpl.setLoggerId(loggerId);
		}

		legalLoggerImpl.setGroupId(groupId);
		legalLoggerImpl.setCompanyId(companyId);

		if (language == null) {
			legalLoggerImpl.setLanguage("");
		}
		else {
			legalLoggerImpl.setLanguage(language);
		}

		if (entryId == null) {
			legalLoggerImpl.setEntryId("");
		}
		else {
			legalLoggerImpl.setEntryId(entryId);
		}

		if (createdDate == Long.MIN_VALUE) {
			legalLoggerImpl.setCreatedDate(null);
		}
		else {
			legalLoggerImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			legalLoggerImpl.setCreatedByUser("");
		}
		else {
			legalLoggerImpl.setCreatedByUser(createdByUser);
		}

		if (classEntry == null) {
			legalLoggerImpl.setClassEntry("");
		}
		else {
			legalLoggerImpl.setClassEntry(classEntry);
		}

		if (content == null) {
			legalLoggerImpl.setContent("");
		}
		else {
			legalLoggerImpl.setContent(content);
		}

		legalLoggerImpl.resetOriginalValues();

		return legalLoggerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		loggerId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		language = objectInput.readUTF();
		entryId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		createdByUser = objectInput.readUTF();
		classEntry = objectInput.readUTF();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (loggerId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loggerId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (entryId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entryId);
		}

		objectOutput.writeLong(createdDate);

		if (createdByUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdByUser);
		}

		if (classEntry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(classEntry);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public String loggerId;
	public long groupId;
	public long companyId;
	public String language;
	public String entryId;
	public long createdDate;
	public String createdByUser;
	public String classEntry;
	public String content;

}