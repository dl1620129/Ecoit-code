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

import com.ecoit.qa.service.service.persistence.AttachmentQuestionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.AttachmentQuestionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentQuestionSoap implements Serializable {

	public static AttachmentQuestionSoap toSoapModel(AttachmentQuestion model) {
		AttachmentQuestionSoap soapModel = new AttachmentQuestionSoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setQuestionId(model.getQuestionId());

		return soapModel;
	}

	public static AttachmentQuestionSoap[] toSoapModels(
		AttachmentQuestion[] models) {

		AttachmentQuestionSoap[] soapModels =
			new AttachmentQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttachmentQuestionSoap[][] toSoapModels(
		AttachmentQuestion[][] models) {

		AttachmentQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AttachmentQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttachmentQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttachmentQuestionSoap[] toSoapModels(
		List<AttachmentQuestion> models) {

		List<AttachmentQuestionSoap> soapModels =
			new ArrayList<AttachmentQuestionSoap>(models.size());

		for (AttachmentQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AttachmentQuestionSoap[soapModels.size()]);
	}

	public AttachmentQuestionSoap() {
	}

	public AttachmentQuestionPK getPrimaryKey() {
		return new AttachmentQuestionPK(_attachmentId, _questionId);
	}

	public void setPrimaryKey(AttachmentQuestionPK pk) {
		setAttachmentId(pk.attachmentId);
		setQuestionId(pk.questionId);
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	private long _attachmentId;
	private long _questionId;

}