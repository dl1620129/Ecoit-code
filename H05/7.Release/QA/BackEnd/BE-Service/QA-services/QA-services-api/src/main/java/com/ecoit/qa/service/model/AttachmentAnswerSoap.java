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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.AttachmentAnswerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AttachmentAnswerSoap implements Serializable {

	public static AttachmentAnswerSoap toSoapModel(AttachmentAnswer model) {
		AttachmentAnswerSoap soapModel = new AttachmentAnswerSoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setAnswerId(model.getAnswerId());

		return soapModel;
	}

	public static AttachmentAnswerSoap[] toSoapModels(
		AttachmentAnswer[] models) {

		AttachmentAnswerSoap[] soapModels =
			new AttachmentAnswerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttachmentAnswerSoap[][] toSoapModels(
		AttachmentAnswer[][] models) {

		AttachmentAnswerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AttachmentAnswerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttachmentAnswerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttachmentAnswerSoap[] toSoapModels(
		List<AttachmentAnswer> models) {

		List<AttachmentAnswerSoap> soapModels =
			new ArrayList<AttachmentAnswerSoap>(models.size());

		for (AttachmentAnswer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttachmentAnswerSoap[soapModels.size()]);
	}

	public AttachmentAnswerSoap() {
	}

	public AttachmentAnswerPK getPrimaryKey() {
		return new AttachmentAnswerPK(_attachmentId, _answerId);
	}

	public void setPrimaryKey(AttachmentAnswerPK pk) {
		setAttachmentId(pk.attachmentId);
		setAnswerId(pk.answerId);
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getAnswerId() {
		return _answerId;
	}

	public void setAnswerId(long answerId) {
		_answerId = answerId;
	}

	private long _attachmentId;
	private long _answerId;

}