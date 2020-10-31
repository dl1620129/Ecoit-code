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

import com.ecoit.qa.service.service.persistence.AttachmentAnswerPK;

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AttachmentAnswer service. Represents a row in the &quot;ecoit_qa_AttachmentAnswer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ecoit.qa.service.model.impl.AttachmentAnswerImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswer
 * @generated
 */
@ProviderType
public interface AttachmentAnswerModel extends BaseModel<AttachmentAnswer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a attachment answer model instance should use the {@link AttachmentAnswer} interface instead.
	 */

	/**
	 * Returns the primary key of this attachment answer.
	 *
	 * @return the primary key of this attachment answer
	 */
	public AttachmentAnswerPK getPrimaryKey();

	/**
	 * Sets the primary key of this attachment answer.
	 *
	 * @param primaryKey the primary key of this attachment answer
	 */
	public void setPrimaryKey(AttachmentAnswerPK primaryKey);

	/**
	 * Returns the attachment ID of this attachment answer.
	 *
	 * @return the attachment ID of this attachment answer
	 */
	public long getAttachmentId();

	/**
	 * Sets the attachment ID of this attachment answer.
	 *
	 * @param attachmentId the attachment ID of this attachment answer
	 */
	public void setAttachmentId(long attachmentId);

	/**
	 * Returns the answer ID of this attachment answer.
	 *
	 * @return the answer ID of this attachment answer
	 */
	public long getAnswerId();

	/**
	 * Sets the answer ID of this attachment answer.
	 *
	 * @param answerId the answer ID of this attachment answer
	 */
	public void setAnswerId(long answerId);

}