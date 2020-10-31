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

package com.ecoit.qa.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.GroupUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserSoap implements Serializable {

	public static GroupUserSoap toSoapModel(GroupUser model) {
		GroupUserSoap soapModel = new GroupUserSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	private long _groupUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private String _name;
	private String _description;

}