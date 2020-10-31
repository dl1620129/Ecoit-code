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

import com.ecoit.qa.service.model.Question;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuestionCacheModel
	implements CacheModel<Question>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionCacheModel)) {
			return false;
		}

		QuestionCacheModel questionCacheModel = (QuestionCacheModel)obj;

		if (questionId == questionCacheModel.questionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, questionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", questionId=");
		sb.append(questionId);
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
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", language=");
		sb.append(language);
		sb.append(", title=");
		sb.append(title);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", address=");
		sb.append(address);
		sb.append(", view=");
		sb.append(view);
		sb.append(", content=");
		sb.append(content);
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		if (uuid == null) {
			questionImpl.setUuid("");
		}
		else {
			questionImpl.setUuid(uuid);
		}

		questionImpl.setQuestionId(questionId);
		questionImpl.setGroupId(groupId);
		questionImpl.setCompanyId(companyId);
		questionImpl.setUserId(userId);

		if (userName == null) {
			questionImpl.setUserName("");
		}
		else {
			questionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			questionImpl.setCreateDate(null);
		}
		else {
			questionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionImpl.setModifiedDate(null);
		}
		else {
			questionImpl.setModifiedDate(new Date(modifiedDate));
		}

		questionImpl.setModifiedByUser(modifiedByUser);

		if (language == null) {
			questionImpl.setLanguage("");
		}
		else {
			questionImpl.setLanguage(language);
		}

		if (title == null) {
			questionImpl.setTitle("");
		}
		else {
			questionImpl.setTitle(title);
		}

		if (email == null) {
			questionImpl.setEmail("");
		}
		else {
			questionImpl.setEmail(email);
		}

		if (phoneNumber == null) {
			questionImpl.setPhoneNumber("");
		}
		else {
			questionImpl.setPhoneNumber(phoneNumber);
		}

		if (address == null) {
			questionImpl.setAddress("");
		}
		else {
			questionImpl.setAddress(address);
		}

		questionImpl.setView(view);

		if (content == null) {
			questionImpl.setContent("");
		}
		else {
			questionImpl.setContent(content);
		}

		questionImpl.setAttachmentId(attachmentId);
		questionImpl.setCategoryId(categoryId);
		questionImpl.setStatus(status);

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		questionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		address = objectInput.readUTF();

		view = objectInput.readLong();
		content = objectInput.readUTF();

		attachmentId = objectInput.readLong();

		categoryId = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(questionId);

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
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedByUser);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(view);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(categoryId);

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long questionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long modifiedByUser;
	public String language;
	public String title;
	public String email;
	public String phoneNumber;
	public String address;
	public long view;
	public String content;
	public long attachmentId;
	public long categoryId;
	public int status;

}