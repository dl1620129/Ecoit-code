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

import com.ecoit.elegaldocument.service.persistence.LegalDFRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDFRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDFRelSoap implements Serializable {

	public static LegalDFRelSoap toSoapModel(LegalDFRel model) {
		LegalDFRelSoap soapModel = new LegalDFRelSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setFieldId(model.getFieldId());

		return soapModel;
	}

	public static LegalDFRelSoap[] toSoapModels(LegalDFRel[] models) {
		LegalDFRelSoap[] soapModels = new LegalDFRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDFRelSoap[][] toSoapModels(LegalDFRel[][] models) {
		LegalDFRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDFRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDFRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDFRelSoap[] toSoapModels(List<LegalDFRel> models) {
		List<LegalDFRelSoap> soapModels = new ArrayList<LegalDFRelSoap>(
			models.size());

		for (LegalDFRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDFRelSoap[soapModels.size()]);
	}

	public LegalDFRelSoap() {
	}

	public LegalDFRelPK getPrimaryKey() {
		return new LegalDFRelPK(_docId, _fieldId);
	}

	public void setPrimaryKey(LegalDFRelPK pk) {
		setDocId(pk.docId);
		setFieldId(pk.fieldId);
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	private long _docId;
	private long _fieldId;

}