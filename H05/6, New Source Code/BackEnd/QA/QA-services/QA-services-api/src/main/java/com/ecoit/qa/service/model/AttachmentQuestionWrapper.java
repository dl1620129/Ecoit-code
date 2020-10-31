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
 * This class is a wrapper for {@link AttachmentQuestion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentQuestion
 * @generated
 */
public class AttachmentQuestionWrapper
	extends BaseModelWrapper<AttachmentQuestion>
	implements AttachmentQuestion, ModelWrapper<AttachmentQuestion> {

	public AttachmentQuestionWrapper(AttachmentQuestion attachmentQuestion) {
		super(attachmentQuestion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("questionId", getQuestionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}
	}

	/**
	 * Returns the attachment ID of this attachment question.
	 *
	 * @return the attachment ID of this attachment question
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the primary key of this attachment question.
	 *
	 * @return the primary key of this attachment question
	 */
	@Override
	public com.ecoit.qa.service.service.persistence.AttachmentQuestionPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the question ID of this attachment question.
	 *
	 * @return the question ID of this attachment question
	 */
	@Override
	public long getQuestionId() {
		return model.getQuestionId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attachment ID of this attachment question.
	 *
	 * @param attachmentId the attachment ID of this attachment question
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the primary key of this attachment question.
	 *
	 * @param primaryKey the primary key of this attachment question
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.qa.service.service.persistence.AttachmentQuestionPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question ID of this attachment question.
	 *
	 * @param questionId the question ID of this attachment question
	 */
	@Override
	public void setQuestionId(long questionId) {
		model.setQuestionId(questionId);
	}

	@Override
	protected AttachmentQuestionWrapper wrap(
		AttachmentQuestion attachmentQuestion) {

		return new AttachmentQuestionWrapper(attachmentQuestion);
	}

}