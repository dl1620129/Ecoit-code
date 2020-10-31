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
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalLevelValidityServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalLevelValiditySoap implements Serializable {

	public static LegalLevelValiditySoap toSoapModel(LegalLevelValidity model) {
		LegalLevelValiditySoap soapModel = new LegalLevelValiditySoap();

		soapModel.setLevelValidityId(model.getLevelValidityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatusLevelValidity(model.isStatusLevelValidity());
		soapModel.setPosition(model.getPosition());

		return soapModel;
	}

	public static LegalLevelValiditySoap[] toSoapModels(
		LegalLevelValidity[] models) {

		LegalLevelValiditySoap[] soapModels =
			new LegalLevelValiditySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalLevelValiditySoap[][] toSoapModels(
		LegalLevelValidity[][] models) {

		LegalLevelValiditySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LegalLevelValiditySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalLevelValiditySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalLevelValiditySoap[] toSoapModels(
		List<LegalLevelValidity> models) {

		List<LegalLevelValiditySoap> soapModels =
			new ArrayList<LegalLevelValiditySoap>(models.size());

		for (LegalLevelValidity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new LegalLevelValiditySoap[soapModels.size()]);
	}

	public LegalLevelValiditySoap() {
	}

	public long getPrimaryKey() {
		return _levelValidityId;
	}

	public void setPrimaryKey(long pk) {
		setLevelValidityId(pk);
	}

	public long getLevelValidityId() {
		return _levelValidityId;
	}

	public void setLevelValidityId(long levelValidityId) {
		_levelValidityId = levelValidityId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public boolean getStatusLevelValidity() {
		return _statusLevelValidity;
	}

	public boolean isStatusLevelValidity() {
		return _statusLevelValidity;
	}

	public void setStatusLevelValidity(boolean statusLevelValidity) {
		_statusLevelValidity = statusLevelValidity;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	private long _levelValidityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _createdByUser;
	private long _modifiedByUser;
	private String _name;
	private String _description;
	private String _language;
	private boolean _statusLevelValidity;
	private int _position;

}