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
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.DraftAttachmentsServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class DraftAttachmentsSoap implements Serializable {

	public static DraftAttachmentsSoap toSoapModel(DraftAttachments model) {
		DraftAttachmentsSoap soapModel = new DraftAttachmentsSoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setDraftId(model.getDraftId());

		return soapModel;
	}

	public static DraftAttachmentsSoap[] toSoapModels(
		DraftAttachments[] models) {

		DraftAttachmentsSoap[] soapModels =
			new DraftAttachmentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DraftAttachmentsSoap[][] toSoapModels(
		DraftAttachments[][] models) {

		DraftAttachmentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DraftAttachmentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DraftAttachmentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DraftAttachmentsSoap[] toSoapModels(
		List<DraftAttachments> models) {

		List<DraftAttachmentsSoap> soapModels =
			new ArrayList<DraftAttachmentsSoap>(models.size());

		for (DraftAttachments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DraftAttachmentsSoap[soapModels.size()]);
	}

	public DraftAttachmentsSoap() {
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

	public long getDraftId() {
		return _draftId;
	}

	public void setDraftId(long draftId) {
		_draftId = draftId;
	}

	private long _attachmentId;
	private long _draftId;

}