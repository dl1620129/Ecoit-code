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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalSignerServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalSignerSoap implements Serializable {

	public static LegalSignerSoap toSoapModel(LegalSigner model) {
		LegalSignerSoap soapModel = new LegalSignerSoap();

		soapModel.setSigId(model.getSigId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatusSigner(model.isStatusSigner());
		soapModel.setFullName(model.getFullName());

		return soapModel;
	}

	public static LegalSignerSoap[] toSoapModels(LegalSigner[] models) {
		LegalSignerSoap[] soapModels = new LegalSignerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalSignerSoap[][] toSoapModels(LegalSigner[][] models) {
		LegalSignerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalSignerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalSignerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalSignerSoap[] toSoapModels(List<LegalSigner> models) {
		List<LegalSignerSoap> soapModels = new ArrayList<LegalSignerSoap>(
			models.size());

		for (LegalSigner model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalSignerSoap[soapModels.size()]);
	}

	public LegalSignerSoap() {
	}

	public long getPrimaryKey() {
		return _sigId;
	}

	public void setPrimaryKey(long pk) {
		setSigId(pk);
	}

	public long getSigId() {
		return _sigId;
	}

	public void setSigId(long sigId) {
		_sigId = sigId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public boolean getStatusSigner() {
		return _statusSigner;
	}

	public boolean isStatusSigner() {
		return _statusSigner;
	}

	public void setStatusSigner(boolean statusSigner) {
		_statusSigner = statusSigner;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	private long _sigId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _createdByUser;
	private long _modifiedByUser;
	private String _firstName;
	private String _lastName;
	private String _language;
	private boolean _statusSigner;
	private String _fullName;

}