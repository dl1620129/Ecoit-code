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

import com.ecoit.elegaldocument.model.LegalAttachedMessage;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalAttachedMessage in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalAttachedMessageCacheModel
	implements CacheModel<LegalAttachedMessage>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalAttachedMessageCacheModel)) {
			return false;
		}

		LegalAttachedMessageCacheModel legalAttachedMessageCacheModel =
			(LegalAttachedMessageCacheModel)obj;

		if (messageId.equals(legalAttachedMessageCacheModel.messageId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, messageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", readMessage=");
		sb.append(readMessage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalAttachedMessage toEntityModel() {
		LegalAttachedMessageImpl legalAttachedMessageImpl =
			new LegalAttachedMessageImpl();

		if (messageId == null) {
			legalAttachedMessageImpl.setMessageId("");
		}
		else {
			legalAttachedMessageImpl.setMessageId(messageId);
		}

		legalAttachedMessageImpl.setGroupId(groupId);
		legalAttachedMessageImpl.setCompanyId(companyId);

		if (createdDate == Long.MIN_VALUE) {
			legalAttachedMessageImpl.setCreatedDate(null);
		}
		else {
			legalAttachedMessageImpl.setCreatedDate(new Date(createdDate));
		}

		if (createdByUser == null) {
			legalAttachedMessageImpl.setCreatedByUser("");
		}
		else {
			legalAttachedMessageImpl.setCreatedByUser(createdByUser);
		}

		if (articleId == null) {
			legalAttachedMessageImpl.setArticleId("");
		}
		else {
			legalAttachedMessageImpl.setArticleId(articleId);
		}

		if (content == null) {
			legalAttachedMessageImpl.setContent("");
		}
		else {
			legalAttachedMessageImpl.setContent(content);
		}

		legalAttachedMessageImpl.setReadMessage(readMessage);

		legalAttachedMessageImpl.resetOriginalValues();

		return legalAttachedMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createdDate = objectInput.readLong();
		createdByUser = objectInput.readUTF();
		articleId = objectInput.readUTF();
		content = objectInput.readUTF();

		readMessage = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (messageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(messageId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdDate);

		if (createdByUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdByUser);
		}

		if (articleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(articleId);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeBoolean(readMessage);
	}

	public String messageId;
	public long groupId;
	public long companyId;
	public long createdDate;
	public String createdByUser;
	public String articleId;
	public String content;
	public boolean readMessage;

}