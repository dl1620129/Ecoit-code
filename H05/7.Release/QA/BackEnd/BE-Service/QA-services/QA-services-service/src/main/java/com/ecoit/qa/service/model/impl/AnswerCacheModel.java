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

package com.ecoit.qa.service.model.impl;

import com.ecoit.qa.service.model.Answer;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Answer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnswerCacheModel implements CacheModel<Answer>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnswerCacheModel)) {
			return false;
		}

		AnswerCacheModel answerCacheModel = (AnswerCacheModel)obj;

		if (answerId == answerCacheModel.answerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, answerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{answerId=");
		sb.append(answerId);
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
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", content=");
		sb.append(content);
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Answer toEntityModel() {
		AnswerImpl answerImpl = new AnswerImpl();

		answerImpl.setAnswerId(answerId);
		answerImpl.setGroupId(groupId);
		answerImpl.setCompanyId(companyId);
		answerImpl.setUserId(userId);

		if (userName == null) {
			answerImpl.setUserName("");
		}
		else {
			answerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			answerImpl.setCreateDate(null);
		}
		else {
			answerImpl.setCreateDate(new Date(createDate));
		}

		answerImpl.setCreatedByUser(createdByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			answerImpl.setModifiedDate(null);
		}
		else {
			answerImpl.setModifiedDate(new Date(modifiedDate));
		}

		answerImpl.setModifiedByUser(modifiedByUser);

		if (content == null) {
			answerImpl.setContent("");
		}
		else {
			answerImpl.setContent(content);
		}

		answerImpl.setAttachmentId(attachmentId);
		answerImpl.setQuestionId(questionId);

		answerImpl.resetOriginalValues();

		return answerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		answerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		content = objectInput.readUTF();

		attachmentId = objectInput.readLong();

		questionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(answerId);

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

		objectOutput.writeLong(createdByUser);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedByUser);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(questionId);
	}

	public long answerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdByUser;
	public long modifiedDate;
	public long modifiedByUser;
	public String content;
	public long attachmentId;
	public long questionId;

}