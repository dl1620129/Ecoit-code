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

package com.software.cms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.software.cms.model.ArticleMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ArticleMessage in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class ArticleMessageCacheModel
	implements CacheModel<ArticleMessage>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleMessageCacheModel)) {
			return false;
		}

		ArticleMessageCacheModel articleMessageCacheModel =
			(ArticleMessageCacheModel)obj;

		if (messageId == articleMessageCacheModel.messageId) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArticleMessage toEntityModel() {
		ArticleMessageImpl articleMessageImpl = new ArticleMessageImpl();

		if (uuid == null) {
			articleMessageImpl.setUuid("");
		}
		else {
			articleMessageImpl.setUuid(uuid);
		}

		articleMessageImpl.setMessageId(messageId);

		if (content == null) {
			articleMessageImpl.setContent("");
		}
		else {
			articleMessageImpl.setContent(content);
		}

		articleMessageImpl.setArticleId(articleId);
		articleMessageImpl.setCreatedByUser(createdByUser);

		if (createdDate == Long.MIN_VALUE) {
			articleMessageImpl.setCreatedDate(null);
		}
		else {
			articleMessageImpl.setCreatedDate(new Date(createdDate));
		}

		articleMessageImpl.resetOriginalValues();

		return articleMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		messageId = objectInput.readLong();
		content = objectInput.readUTF();

		articleId = objectInput.readLong();

		createdByUser = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(messageId);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(articleId);

		objectOutput.writeLong(createdByUser);
		objectOutput.writeLong(createdDate);
	}

	public String uuid;
	public long messageId;
	public String content;
	public long articleId;
	public long createdByUser;
	public long createdDate;

}