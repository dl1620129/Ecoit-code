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

package com.ecoit.qa.service.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentQuestionPK
	implements Comparable<AttachmentQuestionPK>, Serializable {

	public long attachmentId;
	public long questionId;

	public AttachmentQuestionPK() {
	}

	public AttachmentQuestionPK(long attachmentId, long questionId) {
		this.attachmentId = attachmentId;
		this.questionId = questionId;
	}

	public long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	@Override
	public int compareTo(AttachmentQuestionPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (attachmentId < pk.attachmentId) {
			value = -1;
		}
		else if (attachmentId > pk.attachmentId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (questionId < pk.questionId) {
			value = -1;
		}
		else if (questionId > pk.questionId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentQuestionPK)) {
			return false;
		}

		AttachmentQuestionPK pk = (AttachmentQuestionPK)obj;

		if ((attachmentId == pk.attachmentId) &&
			(questionId == pk.questionId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, attachmentId);
		hashCode = HashUtil.hash(hashCode, questionId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("attachmentId=");

		sb.append(attachmentId);
		sb.append(", questionId=");

		sb.append(questionId);

		sb.append("}");

		return sb.toString();
	}

}