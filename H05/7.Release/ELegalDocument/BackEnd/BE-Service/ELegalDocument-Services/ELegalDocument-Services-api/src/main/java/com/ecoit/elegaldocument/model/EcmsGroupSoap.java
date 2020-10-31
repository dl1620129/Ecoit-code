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
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.EcmsGroupServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class EcmsGroupSoap implements Serializable {

	public static EcmsGroupSoap toSoapModel(EcmsGroup model) {
		EcmsGroupSoap soapModel = new EcmsGroupSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static EcmsGroupSoap[] toSoapModels(EcmsGroup[] models) {
		EcmsGroupSoap[] soapModels = new EcmsGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EcmsGroupSoap[][] toSoapModels(EcmsGroup[][] models) {
		EcmsGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EcmsGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EcmsGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EcmsGroupSoap[] toSoapModels(List<EcmsGroup> models) {
		List<EcmsGroupSoap> soapModels = new ArrayList<EcmsGroupSoap>(
			models.size());

		for (EcmsGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EcmsGroupSoap[soapModels.size()]);
	}

	public EcmsGroupSoap() {
	}

	public long getPrimaryKey() {
		return _groupUserId;
	}

	public void setPrimaryKey(long pk) {
		setGroupUserId(pk);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _groupUserId;
	private String _groupName;
	private String _description;
	private long _groupId;
	private Date _createdDate;

}