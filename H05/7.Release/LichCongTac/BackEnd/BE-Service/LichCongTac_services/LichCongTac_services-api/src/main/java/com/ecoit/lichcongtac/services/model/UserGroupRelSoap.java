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

package com.ecoit.lichcongtac.services.model;

import com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.lichcongtac.services.service.http.UserGroupRelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserGroupRelSoap implements Serializable {

	public static UserGroupRelSoap toSoapModel(UserGroupRel model) {
		UserGroupRelSoap soapModel = new UserGroupRelSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setUserPermissionGroupId(model.getUserPermissionGroupId());

		return soapModel;
	}

	public static UserGroupRelSoap[] toSoapModels(UserGroupRel[] models) {
		UserGroupRelSoap[] soapModels = new UserGroupRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserGroupRelSoap[][] toSoapModels(UserGroupRel[][] models) {
		UserGroupRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserGroupRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserGroupRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserGroupRelSoap[] toSoapModels(List<UserGroupRel> models) {
		List<UserGroupRelSoap> soapModels = new ArrayList<UserGroupRelSoap>(
			models.size());

		for (UserGroupRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserGroupRelSoap[soapModels.size()]);
	}

	public UserGroupRelSoap() {
	}

	public UserGroupRelPK getPrimaryKey() {
		return new UserGroupRelPK(_userId, _userPermissionGroupId);
	}

	public void setPrimaryKey(UserGroupRelPK pk) {
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