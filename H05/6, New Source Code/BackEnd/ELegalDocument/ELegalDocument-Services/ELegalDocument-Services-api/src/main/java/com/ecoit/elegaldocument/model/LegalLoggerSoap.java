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
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalLoggerServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalLoggerSoap implements Serializable {

	public static LegalLoggerSoap toSoapModel(LegalLogger model) {
		LegalLoggerSoap soapModel = new LegalLoggerSoap();

		soapModel.setLoggerId(model.getLoggerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setEntryId(model.getEntryId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setClassEntry(model.getClassEntry());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static LegalLoggerSoap[] toSoapModels(LegalLogger[] models) {
		LegalLoggerSoap[] soapModels = new LegalLoggerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalLoggerSoap[][] toSoapModels(LegalLogger[][] models) {
		LegalLoggerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalLoggerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalLoggerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalLoggerSoap[] toSoapModels(List<LegalLogger> models) {
		List<LegalLoggerSoap> soapModels = new ArrayList<LegalLoggerSoap>(
			models.size());

		for (LegalLogger model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalLoggerSoap[soapModels.size()]);
	}

	public LegalLoggerSoap() {
	}

	public String getPrimaryKey() {
		return _loggerId;
	}

	public void setPrimaryKey(String pk) {
		setLoggerId(pk);
	}

	public String getLoggerId() {
		return _loggerId;
	}

	public void setLoggerId(String loggerId) {
		_loggerId = loggerId;
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getEntryId() {
		return _entryId;
	}

	public void setEntryId(String entryId) {
		_entryId = entryId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		_createdByUser = createdByUser;
	}

	public String getClassEntry() {
		return _classEntry;
	}

	public void setClassEntry(String classEntry) {
		_classEntry = classEntry;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _loggerId;
	private long _groupId;
	private long _companyId;
	private String _language;
	private String _entryId;
	private Date _createdDate;
	private String _createdByUser;
	private String _classEntry;
	private String _content;

}