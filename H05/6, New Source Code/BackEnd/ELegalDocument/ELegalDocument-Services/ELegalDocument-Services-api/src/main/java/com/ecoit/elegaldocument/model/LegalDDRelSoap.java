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

import com.ecoit.elegaldocument.service.persistence.LegalDDRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDDRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDDRelSoap implements Serializable {

	public static LegalDDRelSoap toSoapModel(LegalDDRel model) {
		LegalDDRelSoap soapModel = new LegalDDRelSoap();

		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setDocId(model.getDocId());

		return soapModel;
	}

	public static LegalDDRelSoap[] toSoapModels(LegalDDRel[] models) {
		LegalDDRelSoap[] soapModels = new LegalDDRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDDRelSoap[][] toSoapModels(LegalDDRel[][] models) {
		LegalDDRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDDRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDDRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDDRelSoap[] toSoapModels(List<LegalDDRel> models) {
		List<LegalDDRelSoap> soapModels = new ArrayList<LegalDDRelSoap>(
			models.size());

		for (LegalDDRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDDRelSoap[soapModels.size()]);
	}

	public LegalDDRelSoap() {
	}

	public LegalDDRelPK getPrimaryKey() {
		return new LegalDDRelPK(_departmentId, _docId);
	}

	public void setPrimaryKey(LegalDDRelPK pk) {
		setDepartmentId(pk.departmentId);
		setDocId(pk.docId);
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public String getDocId() {
		return _docId;
	}

	public void setDocId(String docId) {
		_docId = docId;
	}

	private long _departmentId;
	private String _docId;

}