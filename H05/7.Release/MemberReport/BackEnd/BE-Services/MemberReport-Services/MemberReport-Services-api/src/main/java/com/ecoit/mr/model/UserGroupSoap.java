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

import com.ecoit.mr.service.persistence.UserGroupPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.mr.service.http.UserGroupServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserGroupSoap implements Serializable {

	public static UserGroupSoap toSoapModel(UserGroup model) {
		UserGroupSoap soapModel = new UserGroupSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setUserPermissionGroupId(model.getUserPermissionGroupId());

		return soapModel;
	}

	public static UserGroupSoap[] toSoapModels(UserGroup[] models) {
		UserGroupSoap[] soapModels = new UserGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserGroupSoap[][] toSoapModels(UserGroup[][] models) {
		UserGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserGroupSoap[] toSoapModels(List<UserGroup> models) {
		List<UserGroupSoap> soapModels = new ArrayList<UserGroupSoap>(
			models.size());

		for (UserGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserGroupSoap[soapModels.size()]);
	}

	public UserGroupSoap() {
	}

	public UserGroupPK getPrimaryKey() {
		return new UserGroupPK(_userId, _userPermissionGroupId);
	}

	public void setPrimaryKey(UserGroupPK pk) {
		setUserId(pk.userId);
		setUserPermissionGroupId(pk.userPermissionGroupId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getUserPermissionGroupId() {
		return _userPermissionGroupId;
	}

	public void setUserPermissionGroupId(long userPermissionGroupId) {
		_userPermissionGroupId = userPermissionGroupId;
	}

	private long _userId;
	private long _userPermissionGroupId;

}