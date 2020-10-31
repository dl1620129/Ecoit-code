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

import com.ecoit.elegaldocument.service.persistence.LegalFTRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalFTRelServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalFTRelSoap implements Serializable {

	public static LegalFTRelSoap toSoapModel(LegalFTRel model) {
		LegalFTRelSoap soapModel = new LegalFTRelSoap();

		soapModel.setFieldId(model.getFieldId());
		soapModel.setTypeId(model.getTypeId());

		return soapModel;
	}

	public static LegalFTRelSoap[] toSoapModels(LegalFTRel[] models) {
		LegalFTRelSoap[] soapModels = new LegalFTRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalFTRelSoap[][] toSoapModels(LegalFTRel[][] models) {
		LegalFTRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalFTRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalFTRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalFTRelSoap[] toSoapModels(List<LegalFTRel> models) {
		List<LegalFTRelSoap> soapModels = new ArrayList<LegalFTRelSoap>(
			models.size());

		for (LegalFTRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalFTRelSoap[soapModels.size()]);
	}

	public LegalFTRelSoap() {
	}

	public LegalFTRelPK getPrimaryKey() {
		return new LegalFTRelPK(_fieldId, _typeId);
	}

	public void setPrimaryKey(LegalFTRelPK pk) {
		setFieldId(pk.fieldId);
		setTypeId(pk.typeId);
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	private long _fieldId;
	private long _typeId;

}