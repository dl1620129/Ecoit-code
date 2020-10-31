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

import com.ecoit.elegaldocument.service.persistence.LegalTDRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalTDRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalTDRelSoap implements Serializable {

	public static LegalTDRelSoap toSoapModel(LegalTDRel model) {
		LegalTDRelSoap soapModel = new LegalTDRelSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setTagId(model.getTagId());

		return soapModel;
	}

	public static LegalTDRelSoap[] toSoapModels(LegalTDRel[] models) {
		LegalTDRelSoap[] soapModels = new LegalTDRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalTDRelSoap[][] toSoapModels(LegalTDRel[][] models) {
		LegalTDRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalTDRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalTDRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalTDRelSoap[] toSoapModels(List<LegalTDRel> models) {
		List<LegalTDRelSoap> soapModels = new ArrayList<LegalTDRelSoap>(
			models.size());

		for (LegalTDRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalTDRelSoap[soapModels.size()]);
	}

	public LegalTDRelSoap() {
	}

	public LegalTDRelPK getPrimaryKey() {
		return new LegalTDRelPK(_docId, _tagId);
	}

	public void setPrimaryKey(LegalTDRelPK pk) {
		setDocId(pk.docId);
		setTagId(pk.tagId);
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public long getTagId() {
		return _tagId;
	}

	public void setTagId(long tagId) {
		_tagId = tagId;
	}

	private long _docId;
	private long _tagId;

}