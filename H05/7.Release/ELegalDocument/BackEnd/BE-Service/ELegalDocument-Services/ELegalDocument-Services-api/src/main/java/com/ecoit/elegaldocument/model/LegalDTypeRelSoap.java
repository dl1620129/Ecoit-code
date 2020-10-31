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

import com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDTypeRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDTypeRelSoap implements Serializable {

	public static LegalDTypeRelSoap toSoapModel(LegalDTypeRel model) {
		LegalDTypeRelSoap soapModel = new LegalDTypeRelSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setTypeId(model.getTypeId());

		return soapModel;
	}

	public static LegalDTypeRelSoap[] toSoapModels(LegalDTypeRel[] models) {
		LegalDTypeRelSoap[] soapModels = new LegalDTypeRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDTypeRelSoap[][] toSoapModels(LegalDTypeRel[][] models) {
		LegalDTypeRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDTypeRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDTypeRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDTypeRelSoap[] toSoapModels(List<LegalDTypeRel> models) {
		List<LegalDTypeRelSoap> soapModels = new ArrayList<LegalDTypeRelSoap>(
			models.size());

		for (LegalDTypeRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDTypeRelSoap[soapModels.size()]);
	}

	public LegalDTypeRelSoap() {
	}

	public LegalDTypeRelPK getPrimaryKey() {
		return new LegalDTypeRelPK(_docId, _typeId);
	}

	public void setPrimaryKey(LegalDTypeRelPK pk) {
		setDocId(pk.docId);
		setTypeId(pk.typeId);
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	private long _docId;
	private long _typeId;

}