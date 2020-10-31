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

package com.ecoit.mr.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.mr.service.http.UserPermissionGroupServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserPermissionGroupSoap implements Serializable {

	public static UserPermissionGroupSoap toSoapModel(
		UserPermissionGroup model) {

		UserPermissionGroupSoap soapModel = new UserPermissionGroupSoap();

		soapModel.setUserPermissionGroupId(model.getUserPermissionGroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static UserPermissionGroupSoap[] toSoapModels(
		UserPermissionGroup[] models) {

		UserPermissionGroupSoap[] soapModels =
			new UserPermissionGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPermissionGroupSoap[][] toSoapModels(
		UserPermissionGroup[][] models) {

		UserPermissionGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserPermissionGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPermissionGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPermissionGroupSoap[] toSoapModels(
		List<UserPermissionGroup> models) {

		List<UserPermissionGroupSoap> soapModels =
			new ArrayList<UserPermissionGroupSoap>(models.size());

		for (UserPermissionGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserPermissionGroupSoap[soapModels.size()]);
	}

	public UserPermissionGroupSoap() {
	}

	public long getPrimaryKey() {
		return _userPermissionGroupId;
	}

	public void setPrimaryKey(long pk) {
		setUserPermissionGroupId(pk);
	}

	public long getUserPermissionGroupId() {
		return _userPermissionGroupId;
	}

	public void setUserPermissionGroupId(long userPermissionGroupId) {
		_userPermissionGroupId = userPermissionGroupId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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

	private long _userPermissionGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _groupName;
	private String _description;

}