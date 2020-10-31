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

import com.ecoit.qa.service.model.AttachmentQuestion;
import com.ecoit.qa.service.service.persistence.AttachmentQuestionPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AttachmentQuestion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentQuestionCacheModel
	implements CacheModel<AttachmentQuestion>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentQuestionCacheModel)) {
			return false;
		}

		AttachmentQuestionCacheModel attachmentQuestionCacheModel =
			(AttachmentQuestionCacheModel)obj;

		if (attachmentQuestionPK.equals(
				attachmentQuestionCacheModel.attachmentQuestionPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attachmentQuestionPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttachmentQuestion toEntityModel() {
		AttachmentQuestionImpl attachmentQuestionImpl =
			new AttachmentQuestionImpl();

		attachmentQuestionImpl.setAttachmentId(attachmentId);
		attachmentQuestionImpl.setQuestionId(questionId);

		attachmentQuestionImpl.resetOriginalValues();

		return attachmentQuestionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();

		questionId = objectInput.readLong();

		attachmentQuestionPK = new AttachmentQuestionPK(
			attachmentId, questionId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(questionId);
	}

	public long attachmentId;
	public long questionId;
	public transient AttachmentQuestionPK attachmentQuestionPK;

}