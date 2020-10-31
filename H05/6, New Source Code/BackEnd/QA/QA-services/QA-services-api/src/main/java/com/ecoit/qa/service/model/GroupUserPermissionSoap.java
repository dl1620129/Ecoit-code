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

import com.ecoit.qa.service.service.persistence.GroupUserPermissionPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.GroupUserPermissionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserPermissionSoap implements Serializable {

	public static GroupUserPermissionSoap toSoapModel(
		GroupUserPermission model) {

		GroupUserPermissionSoap soapModel = new GroupUserPermissionSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setPermissionId(model.getPermissionId());

		return soapModel;
	}

	public static GroupUserPermissionSoap[] toSoapModels(
		GroupUserPermission[] models) {

		GroupUserPermissionSoap[] soapModels =
			new GroupUserPermissionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupUserPermissionSoap[][] toSoapModels(
		GroupUserPermission[][] models) {

		GroupUserPermissionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GroupUserPermissionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupUserPermissionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupUserPermissionSoap[] toSoapModels(
		List<GroupUserPermission> models) {

		List<GroupUserPermissionSoap> soapModels =
			new ArrayList<GroupUserPermissionSoap>(models.size());

		for (GroupUserPermission model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new GroupUserPermissionSoap[soapModels.size()]);
	}

	public GroupUserPermissionSoap() {
	}

	public GroupUserPermissionPK getPrimaryKey() {
		return new GroupUserPermissionPK(_groupUserId, _permissionId);
	}

	public void setPrimaryKey(GroupUserPermissionPK pk) {
		setGroupUserId(pk.groupUserId);
		setPermissionId(pk.permissionId);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getPermissionId() {
		return _permissionId;
	}

	public void setPermissionId(long permissionId) {
		_permissionId = permissionId;
	}

	private long _groupUserId;
	private long _permissionId;

}