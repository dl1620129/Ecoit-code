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

package com.ecoit.elegaldocument.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentAttachments}.
 * </p>
 *
 * @author Liverpool
 * @see DocumentAttachments
 * @generated
 */
public class DocumentAttachmentsWrapper
	extends BaseModelWrapper<DocumentAttachments>
	implements DocumentAttachments, ModelWrapper<DocumentAttachments> {

	public DocumentAttachmentsWrapper(DocumentAttachments documentAttachments) {
		super(documentAttachments);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("docId", getDocId());
		attributes.put("view", getView());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Long view = (Long)attributes.get("view");

		if (view != null) {
			setView(view);
		}
	}

	/**
	 * Returns the attachment ID of this document attachments.
	 *
	 * @return the attachment ID of this document attachments
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the doc ID of this document attachments.
	 *
	 * @return the doc ID of this document attachments
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the primary key of this document attachments.
	 *
	 * @return the primary key of this document attachments
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the view of this document attachments.
	 *
	 * @return the view of this document attachments
	 */
	@Override
	public long getView() {
		return model.getView();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment ID of this document attachments.
	 *
	 * @param attachmentId the attachment ID of this document attachments
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the doc ID of this document attachments.
	 *
	 * @param docId the doc ID of this document attachments
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the primary key of this document attachments.
	 *
	 * @param primaryKey the primary key of this document attachments
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the view of this document attachments.
	 *
	 * @param view the view of this document attachments
	 */
	@Override
	public void setView(long view) {
		model.setView(view);
	}

	@Override
	protected DocumentAttachmentsWrapper wrap(
		DocumentAttachments documentAttachments) {

		return new DocumentAttachmentsWrapper(documentAttachments);
	}

}