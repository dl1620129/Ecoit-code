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

package com.software.cms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.LoggerServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class LoggerSoap implements Serializable {

	public static LoggerSoap toSoapModel(Logger model) {
		LoggerSoap soapModel = new LoggerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLoggerId(model.getLoggerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static LoggerSoap[] toSoapModels(Logger[] models) {
		LoggerSoap[] soapModels = new LoggerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoggerSoap[][] toSoapModels(Logger[][] models) {
		LoggerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoggerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoggerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoggerSoap[] toSoapModels(List<Logger> models) {
		List<LoggerSoap> soapModels = new ArrayList<LoggerSoap>(models.size());

		for (Logger model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoggerSoap[soapModels.size()]);
	}

	public LoggerSoap() {
	}

	public long getPrimaryKey() {
		return _loggerId;
	}

	public void setPrimaryKey(long pk) {
		setLoggerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLoggerId() {
		return _loggerId;
	}

	public void setLoggerId(long loggerId) {
		_loggerId = loggerId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _uuid;
	private long _loggerId;
	private long _groupId;
	private String _language;
	private long _userId;
	private Date _createdDate;
	private String _description;
	private String _type;

}