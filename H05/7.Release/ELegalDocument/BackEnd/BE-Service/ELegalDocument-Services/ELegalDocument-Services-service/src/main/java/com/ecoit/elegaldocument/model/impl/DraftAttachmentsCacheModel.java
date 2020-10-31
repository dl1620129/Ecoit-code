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

import com.ecoit.elegaldocument.model.DraftAttachments;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DraftAttachments in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class DraftAttachmentsCacheModel
	implements CacheModel<DraftAttachments>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DraftAttachmentsCacheModel)) {
			return false;
		}

		DraftAttachmentsCacheModel draftAttachmentsCacheModel =
			(DraftAttachmentsCacheModel)obj;

		if (attachmentId == draftAttachmentsCacheModel.attachmentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, attachmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", draftId=");
		sb.append(draftId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DraftAttachments toEntityModel() {
		DraftAttachmentsImpl draftAttachmentsImpl = new DraftAttachmentsImpl();

		draftAttachmentsImpl.setAttachmentId(attachmentId);
		draftAttachmentsImpl.setDraftId(draftId);

		draftAttachmentsImpl.resetOriginalValues();

		return draftAttachmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();

		draftId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(draftId);
	}

	public long attachmentId;
	public long draftId;

}