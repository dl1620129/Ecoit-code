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

import com.ecoit.elegaldocument.service.persistence.LegalDURelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDURelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDURelSoap implements Serializable {

	public static LegalDURelSoap toSoapModel(LegalDURel model) {
		LegalDURelSoap soapModel = new LegalDURelSoap();

		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setUserid(model.getUserid());

		return soapModel;
	}

	public static LegalDURelSoap[] toSoapModels(LegalDURel[] models) {
		LegalDURelSoap[] soapModels = new LegalDURelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDURelSoap[][] toSoapModels(LegalDURel[][] models) {
		LegalDURelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDURelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDURelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDURelSoap[] toSoapModels(List<LegalDURel> models) {
		List<LegalDURelSoap> soapModels = new ArrayList<LegalDURelSoap>(
			models.size());

		for (LegalDURel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDURelSoap[soapModels.size()]);
	}

	public LegalDURelSoap() {
	}

	public LegalDURelPK getPrimaryKey() {
		return new LegalDURelPK(_departmentId, _userid);
	}

	public void setPrimaryKey(LegalDURelPK pk) {
		setDepartmentId(pk.departmentId);
		setUserid(pk.userid);
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getUserid() {
		return _userid;
	}

	public void setUserid(long userid) {
		_userid = userid;
	}

	private long _departmentId;
	private long _userid;

}