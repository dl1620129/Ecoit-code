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

import com.ecoit.elegaldocument.service.persistence.LegalDSRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDSRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDSRelSoap implements Serializable {

	public static LegalDSRelSoap toSoapModel(LegalDSRel model) {
		LegalDSRelSoap soapModel = new LegalDSRelSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setSigId(model.getSigId());

		return soapModel;
	}

	public static LegalDSRelSoap[] toSoapModels(LegalDSRel[] models) {
		LegalDSRelSoap[] soapModels = new LegalDSRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDSRelSoap[][] toSoapModels(LegalDSRel[][] models) {
		LegalDSRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDSRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDSRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDSRelSoap[] toSoapModels(List<LegalDSRel> models) {
		List<LegalDSRelSoap> soapModels = new ArrayList<LegalDSRelSoap>(
			models.size());

		for (LegalDSRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDSRelSoap[soapModels.size()]);
	}

	public LegalDSRelSoap() {
	}

	public LegalDSRelPK getPrimaryKey() {
		return new LegalDSRelPK(_docId, _sigId);
	}

	public void setPrimaryKey(LegalDSRelPK pk) {
		setDocId(pk.docId);
		setSigId(pk.sigId);
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
	}

	public long getSigId() {
		return _sigId;
	}

	public void setSigId(long sigId) {
		_sigId = sigId;
	}

	private long _docId;
	private long _sigId;

}