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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.DocumentAttachmentsServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class DocumentAttachmentsSoap implements Serializable {

	public static DocumentAttachmentsSoap toSoapModel(
		DocumentAttachments model) {

		DocumentAttachmentsSoap soapModel = new DocumentAttachmentsSoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setDocId(model.getDocId());
		soapModel.setView(model.getView());

		return soapModel;
	}

	public static DocumentAttachmentsSoap[] toSoapModels(
		DocumentAttachments[] models) {

		DocumentAttachmentsSoap[] soapModels =
			new DocumentAttachmentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentAttachmentsSoap[][] toSoapModels(
		DocumentAttachments[][] models) {

		DocumentAttachmentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DocumentAttachmentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentAttachmentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentAttachmentsSoap[] toSoapModels(
		List<DocumentAttachments> models) {

		List<DocumentAttachmentsSoap> soapModels =
			new ArrayList<DocumentAttachmentsSoap>(models.size());

		for (DocumentAttachments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DocumentAttachmentsSoap[soapModels.size()]);
	}

	public DocumentAttachmentsSoap() {
	}

	public long getPrimaryKey() {
		return _attachmentId;
	}

	public void setPrimaryKey(long pk) {
		setAttachmentId(pk);
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public long getView() {
		return _view;
	}

	public void setView(long view) {
		_view = view;
	}

	private long _attachmentId;
	private long _docId;
	private long _view;

}