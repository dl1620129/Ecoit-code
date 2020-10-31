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
public class AttachmentAnswerPK
	implements Comparable<AttachmentAnswerPK>, Serializable {

	public long attachmentId;
	public long answerId;

	public AttachmentAnswerPK() {
	}

	public AttachmentAnswerPK(long attachmentId, long answerId) {
		this.attachmentId = attachmentId;
		this.answerId = answerId;
	}

	public long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	@Override
	public int compareTo(AttachmentAnswerPK pk) {
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

		if (answerId < pk.answerId) {
			value = -1;
		}
		else if (answerId > pk.answerId) {
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

		if (!(obj instanceof AttachmentAnswerPK)) {
			return false;
		}

		AttachmentAnswerPK pk = (AttachmentAnswerPK)obj;

		if ((attachmentId == pk.attachmentId) && (answerId == pk.answerId)) {
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
		hashCode = HashUtil.hash(hashCode, answerId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("attachmentId=");

		sb.append(attachmentId);
		sb.append(", answerId=");

		sb.append(answerId);

		sb.append("}");

		return sb.toString();
	}

}