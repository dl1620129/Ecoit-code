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

import com.ecoit.elegaldocument.service.persistence.LegalFoRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalFoRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalFoRelSoap implements Serializable {

	public static LegalFoRelSoap toSoapModel(LegalFoRel model) {
		LegalFoRelSoap soapModel = new LegalFoRelSoap();

		soapModel.setFieldId(model.getFieldId());
		soapModel.setOrganizationId(model.getOrganizationId());

		return soapModel;
	}

	public static LegalFoRelSoap[] toSoapModels(LegalFoRel[] models) {
		LegalFoRelSoap[] soapModels = new LegalFoRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalFoRelSoap[][] toSoapModels(LegalFoRel[][] models) {
		LegalFoRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalFoRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalFoRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalFoRelSoap[] toSoapModels(List<LegalFoRel> models) {
		List<LegalFoRelSoap> soapModels = new ArrayList<LegalFoRelSoap>(
			models.size());

		for (LegalFoRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalFoRelSoap[soapModels.size()]);
	}

	public LegalFoRelSoap() {
	}

	public LegalFoRelPK getPrimaryKey() {
		return new LegalFoRelPK(_fieldId, _organizationId);
	}

	public void setPrimaryKey(LegalFoRelPK pk) {
		setFieldId(pk.fieldId);
		setOrganizationId(pk.organizationId);
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	private long _fieldId;
	private long _organizationId;

}