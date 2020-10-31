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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.GroupUserServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class GroupUserSoap implements Serializable {

	public static GroupUserSoap toSoapModel(GroupUser model) {
		GroupUserSoap soapModel = new GroupUserSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static GroupUserSoap[] toSoapModels(GroupUser[] models) {
		GroupUserSoap[] soapModels = new GroupUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupUserSoap[][] toSoapModels(GroupUser[][] models) {
		GroupUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GroupUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupUserSoap[] toSoapModels(List<GroupUser> models) {
		List<GroupUserSoap> soapModels = new ArrayList<GroupUserSoap>(
			models.size());

		for (GroupUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupUserSoap[soapModels.size()]);
	}

	public GroupUserSoap() {
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

	private long _groupUserId;
	private long _groupId;
	private String _language;
	private String _name;
	private String _description;

}