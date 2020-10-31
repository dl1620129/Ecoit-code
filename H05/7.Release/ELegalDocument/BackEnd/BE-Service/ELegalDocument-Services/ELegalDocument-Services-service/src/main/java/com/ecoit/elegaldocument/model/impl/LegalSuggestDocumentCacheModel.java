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

import com.ecoit.elegaldocument.model.LegalSuggestDocument;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalSuggestDocument in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalSuggestDocumentCacheModel
	implements CacheModel<LegalSuggestDocument>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalSuggestDocumentCacheModel)) {
			return false;
		}

		LegalSuggestDocumentCacheModel legalSuggestDocumentCacheModel =
			(LegalSuggestDocumentCacheModel)obj;

		if (sugId == legalSuggestDocumentCacheModel.sugId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sugId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{sugId=");
		sb.append(sugId);
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
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", language=");
		sb.append(language);
		sb.append(", visitorName=");
		sb.append(visitorName);
		sb.append(", visitorEmail=");
		sb.append(visitorEmail);
		sb.append(", visitorTel=");
		sb.append(visitorTel);
		sb.append(", visitorAddress=");
		sb.append(visitorAddress);
		sb.append(", docId=");
		sb.append(docId);
		sb.append(", hasAttachment=");
		sb.append(hasAttachment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalSuggestDocument toEntityModel() {
		LegalSuggestDocumentImpl legalSuggestDocumentImpl =
			new LegalSuggestDocumentImpl();

		legalSuggestDocumentImpl.setSugId(sugId);
		legalSuggestDocumentImpl.setGroupId(groupId);
		legalSuggestDocumentImpl.setCompanyId(companyId);
		legalSuggestDocumentImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalSuggestDocumentImpl.setCreatedDate(null);
		}
		else {
			legalSuggestDocumentImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalSuggestDocumentImpl.setModifiedDate(null);
		}
		else {
			legalSuggestDocumentImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalSuggestDocumentImpl.setModifiedByUser(modifiedByUser);
		legalSuggestDocumentImpl.setApproved(approved);
		legalSuggestDocumentImpl.setApprovedByUser(approvedByUser);

		if (approvedDate == Long.MIN_VALUE) {
			legalSuggestDocumentImpl.setApprovedDate(null);
		}
		else {
			legalSuggestDocumentImpl.setApprovedDate(new Date(approvedDate));
		}

		if (title == null) {
			legalSuggestDocumentImpl.setTitle("");
		}
		else {
			legalSuggestDocumentImpl.setTitle(title);
		}

		if (content == null) {
			legalSuggestDocumentImpl.setContent("");
		}
		else {
			legalSuggestDocumentImpl.setContent(content);
		}

		if (language == null) {
			legalSuggestDocumentImpl.setLanguage("");
		}
		else {
			legalSuggestDocumentImpl.setLanguage(language);
		}

		if (visitorName == null) {
			legalSuggestDocumentImpl.setVisitorName("");
		}
		else {
			legalSuggestDocumentImpl.setVisitorName(visitorName);
		}

		if (visitorEmail == null) {
			legalSuggestDocumentImpl.setVisitorEmail("");
		}
		else {
			legalSuggestDocumentImpl.setVisitorEmail(visitorEmail);
		}

		if (visitorTel == null) {
			legalSuggestDocumentImpl.setVisitorTel("");
		}
		else {
			legalSuggestDocumentImpl.setVisitorTel(visitorTel);
		}

		if (visitorAddress == null) {
			legalSuggestDocumentImpl.setVisitorAddress("");
		}
		else {
			legalSuggestDocumentImpl.setVisitorAddress(visitorAddress);
		}

		legalSuggestDocumentImpl.setDocId(docId);
		legalSuggestDocumentImpl.setHasAttachment(hasAttachment);

		legalSuggestDocumentImpl.resetOriginalValues();

		return legalSuggestDocumentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sugId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();

		approved = objectInput.readBoolean();

		approvedByUser = objectInput.readLong();
		approvedDate = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		language = objectInput.readUTF();
		visitorName = objectInput.readUTF();
		visitorEmail = objectInput.readUTF();
		visitorTel = objectInput.readUTF();
		visitorAddress = objectInput.readUTF();

		docId = objectInput.readLong();

		hasAttachment = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(sugId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedByUser);

		objectOutput.writeBoolean(approved);

		objectOutput.writeLong(approvedByUser);
		objectOutput.writeLong(approvedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (visitorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visitorName);
		}

		if (visitorEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visitorEmail);
		}

		if (visitorTel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visitorTel);
		}

		if (visitorAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(visitorAddress);
		}

		objectOutput.writeLong(docId);

		objectOutput.writeBoolean(hasAttachment);
	}

	public long sugId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long modifiedByUser;
	public boolean approved;
	public long approvedByUser;
	public long approvedDate;
	public String title;
	public String content;
	public String language;
	public String visitorName;
	public String visitorEmail;
	public String visitorTel;
	public String visitorAddress;
	public long docId;
	public boolean hasAttachment;

}