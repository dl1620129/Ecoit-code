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

package com.ecoit.qa.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AttachmentAnswer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswer
 * @generated
 */
public class AttachmentAnswerWrapper
	extends BaseModelWrapper<AttachmentAnswer>
	implements AttachmentAnswer, ModelWrapper<AttachmentAnswer> {

	public AttachmentAnswerWrapper(AttachmentAnswer attachmentAnswer) {
		super(attachmentAnswer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("answerId", getAnswerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long answerId = (Long)attributes.get("answerId");

		if (answerId != null) {
			setAnswerId(answerId);
		}
	}

	/**
	 * Returns the answer ID of this attachment answer.
	 *
	 * @return the answer ID of this attachment answer
	 */
	@Override
	public long getAnswerId() {
		return model.getAnswerId();
	}

	/**
	 * Returns the attachment ID of this attachment answer.
	 *
	 * @return the attachment ID of this attachment answer
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the primary key of this attachment answer.
	 *
	 * @return the primary key of this attachment answer
	 */
	@Override
	public com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the answer ID of this attachment answer.
	 *
	 * @param answerId the answer ID of this attachment answer
	 */
	@Override
	public void setAnswerId(long answerId) {
		model.setAnswerId(answerId);
	}

	/**
	 * Sets the attachment ID of this attachment answer.
	 *
	 * @param attachmentId the attachment ID of this attachment answer
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the primary key of this attachment answer.
	 *
	 * @param primaryKey the primary key of this attachment answer
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AttachmentAnswerWrapper wrap(AttachmentAnswer attachmentAnswer) {
		return new AttachmentAnswerWrapper(attachmentAnswer);
	}

}