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
 * This class is a wrapper for {@link DraftAttachments}.
 * </p>
 *
 * @author Liverpool
 * @see DraftAttachments
 * @generated
 */
public class DraftAttachmentsWrapper
	extends BaseModelWrapper<DraftAttachments>
	implements DraftAttachments, ModelWrapper<DraftAttachments> {

	public DraftAttachmentsWrapper(DraftAttachments draftAttachments) {
		super(draftAttachments);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("draftId", getDraftId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long draftId = (Long)attributes.get("draftId");

		if (draftId != null) {
			setDraftId(draftId);
		}
	}

	/**
	 * Returns the attachment ID of this draft attachments.
	 *
	 * @return the attachment ID of this draft attachments
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the draft ID of this draft attachments.
	 *
	 * @return the draft ID of this draft attachments
	 */
	@Override
	public long getDraftId() {
		return model.getDraftId();
	}

	/**
	 * Returns the primary key of this draft attachments.
	 *
	 * @return the primary key of this draft attachments
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment ID of this draft attachments.
	 *
	 * @param attachmentId the attachment ID of this draft attachments
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the draft ID of this draft attachments.
	 *
	 * @param draftId the draft ID of this draft attachments
	 */
	@Override
	public void setDraftId(long draftId) {
		model.setDraftId(draftId);
	}

	/**
	 * Sets the primary key of this draft attachments.
	 *
	 * @param primaryKey the primary key of this draft attachments
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DraftAttachmentsWrapper wrap(DraftAttachments draftAttachments) {
		return new DraftAttachmentsWrapper(draftAttachments);
	}

}