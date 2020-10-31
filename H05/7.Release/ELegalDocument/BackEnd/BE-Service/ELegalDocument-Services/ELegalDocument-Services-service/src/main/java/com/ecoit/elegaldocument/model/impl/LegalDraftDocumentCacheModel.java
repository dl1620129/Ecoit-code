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

import com.ecoit.elegaldocument.model.LegalDraftDocument;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalDraftDocument in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDraftDocumentCacheModel
	implements CacheModel<LegalDraftDocument>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDraftDocumentCacheModel)) {
			return false;
		}

		LegalDraftDocumentCacheModel legalDraftDocumentCacheModel =
			(LegalDraftDocumentCacheModel)obj;

		if (draftId == legalDraftDocumentCacheModel.draftId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, draftId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{draftId=");
		sb.append(draftId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", publishedByUser=");
		sb.append(publishedByUser);
		sb.append(", publishedDate=");
		sb.append(publishedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", language=");
		sb.append(language);
		sb.append(", content=");
		sb.append(content);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", draftLevel=");
		sb.append(draftLevel);
		sb.append(", docCode=");
		sb.append(docCode);
		sb.append(", statusDraft=");
		sb.append(statusDraft);
		sb.append(", email=");
		sb.append(email);
		sb.append(", destination=");
		sb.append(destination);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDraftDocument toEntityModel() {
		LegalDraftDocumentImpl legalDraftDocumentImpl =
			new LegalDraftDocumentImpl();

		legalDraftDocumentImpl.setDraftId(draftId);
		legalDraftDocumentImpl.setGroupId(groupId);
		legalDraftDocumentImpl.setCompanyId(companyId);
		legalDraftDocumentImpl.setUserId(userId);
		legalDraftDocumentImpl.setCreatedByUser(createdByUser);

		if (createdDate == Long.MIN_VALUE) {
			legalDraftDocumentImpl.setCreatedDate(null);
		}
		else {
			legalDraftDocumentImpl.setCreatedDate(new Date(createdDate));
		}

		legalDraftDocumentImpl.setModifiedByUser(modifiedByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			legalDraftDocumentImpl.setModifiedDate(null);
		}
		else {
			legalDraftDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalDraftDocumentImpl.setApprovedByUser(approvedByUser);

		if (approvedDate == Long.MIN_VALUE) {
			legalDraftDocumentImpl.setApprovedDate(null);
		}
		else {
			legalDraftDocumentImpl.setApprovedDate(new Date(approvedDate));
		}

		legalDraftDocumentImpl.setPublishedByUser(publishedByUser);

		if (publishedDate == Long.MIN_VALUE) {
			legalDraftDocumentImpl.setPublishedDate(null);
		}
		else {
			legalDraftDocumentImpl.setPublishedDate(new Date(publishedDate));
		}

		if (title == null) {
			legalDraftDocumentImpl.setTitle("");
		}
		else {
			legalDraftDocumentImpl.setTitle(title);
		}

		if (expiredDate == Long.MIN_VALUE) {
			legalDraftDocumentImpl.setExpiredDate(null);
		}
		else {
			legalDraftDocumentImpl.setExpiredDate(new Date(expiredDate));
		}

		if (language == null) {
			legalDraftDocumentImpl.setLanguage("");
		}
		else {
			legalDraftDocumentImpl.setLanguage(language);
		}

		if (content == null) {
			legalDraftDocumentImpl.setContent("");
		}
		else {
			legalDraftDocumentImpl.setContent(content);
		}

		legalDraftDocumentImpl.setTypeId(typeId);
		legalDraftDocumentImpl.setFieldId(fieldId);
		legalDraftDocumentImpl.setDraftLevel(draftLevel);

		if (docCode == null) {
			legalDraftDocumentImpl.setDocCode("");
		}
		else {
			legalDraftDocumentImpl.setDocCode(docCode);
		}

		legalDraftDocumentImpl.setStatusDraft(statusDraft);

		if (email == null) {
			legalDraftDocumentImpl.setEmail("");
		}
		else {
			legalDraftDocumentImpl.setEmail(email);
		}

		if (destination == null) {
			legalDraftDocumentImpl.setDestination("");
		}
		else {
			legalDraftDocumentImpl.setDestination(destination);
		}

		legalDraftDocumentImpl.resetOriginalValues();

		return legalDraftDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		draftId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		createdByUser = objectInput.readLong();
		createdDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		approvedByUser = objectInput.readLong();
		approvedDate = objectInput.readLong();

		publishedByUser = objectInput.readLong();
		publishedDate = objectInput.readLong();
		title = objectInput.readUTF();
		expiredDate = objectInput.readLong();
		language = objectInput.readUTF();
		content = objectInput.readUTF();

		typeId = objectInput.readLong();

		fieldId = objectInput.readLong();

		draftLevel = objectInput.readInt();
		docCode = objectInput.readUTF();

		statusDraft = objectInput.readInt();
		email = objectInput.readUTF();
		destination = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(draftId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(createdByUser);
		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedByUser);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(approvedByUser);
		objectOutput.writeLong(approvedDate);

		objectOutput.writeLong(publishedByUser);
		objectOutput.writeLong(publishedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(expiredDate);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(fieldId);

		objectOutput.writeInt(draftLevel);

		if (docCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(docCode);
		}

		objectOutput.writeInt(statusDraft);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (destination == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(destination);
		}
	}

	public long draftId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdByUser;
	public long createdDate;
	public long modifiedByUser;
	public long modifiedDate;
	public long approvedByUser;
	public long approvedDate;
	public long publishedByUser;
	public long publishedDate;
	public String title;
	public long expiredDate;
	public String language;
	public String content;
	public long typeId;
	public long fieldId;
	public int draftLevel;
	public String docCode;
	public int statusDraft;
	public String email;
	public String destination;

}