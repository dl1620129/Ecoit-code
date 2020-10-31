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

import com.ecoit.qa.service.model.AttachmentAnswer;
import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AttachmentAnswer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentAnswerCacheModel
	implements CacheModel<AttachmentAnswer>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentAnswerCacheModel)) {
			return false;
		}

		AttachmentAnswerCacheModel attachmentAnswerCacheModel =
			(AttachmentAnswerCacheModel)obj;

		if (attachmentAnswerPK.equals(
				attachmentAnswerCacheModel.attachmentAnswerPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attachmentAnswerPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", answerId=");
		sb.append(answerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttachmentAnswer toEntityModel() {
		AttachmentAnswerImpl attachmentAnswerImpl = new AttachmentAnswerImpl();

		attachmentAnswerImpl.setAttachmentId(attachmentId);
		attachmentAnswerImpl.setAnswerId(answerId);

		attachmentAnswerImpl.resetOriginalValues();

		return attachmentAnswerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();

		answerId = objectInput.readLong();

		attachmentAnswerPK = new AttachmentAnswerPK(attachmentId, answerId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(answerId);
	}

	public long attachmentId;
	public long answerId;
	public transient AttachmentAnswerPK attachmentAnswerPK;

}