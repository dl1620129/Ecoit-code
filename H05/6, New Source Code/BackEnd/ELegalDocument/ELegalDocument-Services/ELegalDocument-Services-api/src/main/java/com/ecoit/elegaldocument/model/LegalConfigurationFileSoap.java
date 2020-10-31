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
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalConfigurationFileServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalConfigurationFileSoap implements Serializable {

	public static LegalConfigurationFileSoap toSoapModel(
		LegalConfigurationFile model) {

		LegalConfigurationFileSoap soapModel = new LegalConfigurationFileSoap();

		soapModel.setKeyId(model.getKeyId());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static LegalConfigurationFileSoap[] toSoapModels(
		LegalConfigurationFile[] models) {

		LegalConfigurationFileSoap[] soapModels =
			new LegalConfigurationFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalConfigurationFileSoap[][] toSoapModels(
		LegalConfigurationFile[][] models) {

		LegalConfigurationFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LegalConfigurationFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalConfigurationFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalConfigurationFileSoap[] toSoapModels(
		List<LegalConfigurationFile> models) {

		List<LegalConfigurationFileSoap> soapModels =
			new ArrayList<LegalConfigurationFileSoap>(models.size());

		for (LegalConfigurationFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new LegalConfigurationFileSoap[soapModels.size()]);
	}

	public LegalConfigurationFileSoap() {
	}

	public String getPrimaryKey() {
		return _keyId;
	}

	public void setPrimaryKey(String pk) {
		setKeyId(pk);
	}

	public String getKeyId() {
		return _keyId;
	}

	public void setKeyId(String keyId) {
		_keyId = keyId;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _keyId;
	private String _value;

}