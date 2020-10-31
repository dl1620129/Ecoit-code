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

import com.ecoit.qa.service.service.persistence.GroupUserUsersPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.GroupUserUsersServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserUsersSoap implements Serializable {

	public static GroupUserUsersSoap toSoapModel(GroupUserUsers model) {
		GroupUserUsersSoap soapModel = new GroupUserUsersSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static GroupUserUsersSoap[] toSoapModels(GroupUserUsers[] models) {
		GroupUserUsersSoap[] soapModels = new GroupUserUsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupUserUsersSoap[][] toSoapModels(
		GroupUserUsers[][] models) {

		GroupUserUsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GroupUserUsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupUserUsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupUserUsersSoap[] toSoapModels(
		List<GroupUserUsers> models) {

		List<GroupUserUsersSoap> soapModels = new ArrayList<GroupUserUsersSoap>(
			models.size());

		for (GroupUserUsers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupUserUsersSoap[soapModels.size()]);
	}

	public GroupUserUsersSoap() {
	}

	public GroupUserUsersPK getPrimaryKey() {
		return new GroupUserUsersPK(_groupUserId, _userId);
	}

	public void setPrimaryKey(GroupUserUsersPK pk) {
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