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

import com.ecoit.elegaldocument.model.DocumentAttachments;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DocumentAttachments in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class DocumentAttachmentsCacheModel
	implements CacheModel<DocumentAttachments>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentAttachmentsCacheModel)) {
			return false;
		}

		DocumentAttachmentsCacheModel documentAttachmentsCacheModel =
			(DocumentAttachmentsCacheModel)obj;

		if (attachmentId == documentAttachmentsCacheModel.attachmentId) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", docId=");
		sb.append(docId);
		sb.append(", view=");
		sb.append(view);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentAttachments toEntityModel() {
		DocumentAttachmentsImpl documentAttachmentsImpl =
			new DocumentAttachmentsImpl();

		documentAttachmentsImpl.setAttachmentId(attachmentId);
		documentAttachmentsImpl.setDocId(docId);
		documentAttachmentsImpl.setView(view);

		documentAttachmentsImpl.resetOriginalValues();

		return documentAttachmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();

		docId = objectInput.readLong();

		view = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(docId);

		objectOutput.writeLong(view);
	}

	public long attachmentId;
	public long docId;
	public long view;

}