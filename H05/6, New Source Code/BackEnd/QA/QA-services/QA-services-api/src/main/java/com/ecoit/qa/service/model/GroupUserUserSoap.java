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

import com.ecoit.qa.service.service.persistence.GroupUserUserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.GroupUserUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserUserSoap implements Serializable {

	public static GroupUserUserSoap toSoapModel(GroupUserUser model) {
		GroupUserUserSoap soapModel = new GroupUserUserSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static GroupUserUserSoap[] toSoapModels(GroupUserUser[] models) {
		GroupUserUserSoap[] soapModels = new GroupUserUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupUserUserSoap[][] toSoapModels(GroupUserUser[][] models) {
		GroupUserUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GroupUserUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupUserUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupUserUserSoap[] toSoapModels(List<GroupUserUser> models) {
		List<GroupUserUserSoap> soapModels = new ArrayList<GroupUserUserSoap>(
			models.size());

		for (GroupUserUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupUserUserSoap[soapModels.size()]);
	}

	public GroupUserUserSoap() {
	}

	public GroupUserUserPK getPrimaryKey() {
		return new GroupUserUserPK(_groupUserId, _userId);
	}

	public void setPrimaryKey(GroupUserUserPK pk) {
		setGroupUserId(pk.groupUserId);
		setUserId(pk.userId);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _groupUserId;
	private long _userId;

}