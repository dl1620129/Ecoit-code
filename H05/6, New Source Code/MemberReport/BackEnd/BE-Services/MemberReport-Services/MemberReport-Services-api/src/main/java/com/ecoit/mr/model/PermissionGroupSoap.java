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

import com.ecoit.mr.service.persistence.PermissionGroupPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.mr.service.http.PermissionGroupServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PermissionGroupSoap implements Serializable {

	public static PermissionGroupSoap toSoapModel(PermissionGroup model) {
		PermissionGroupSoap soapModel = new PermissionGroupSoap();

		soapModel.setUserPermissionGroupId(model.getUserPermissionGroupId());
		soapModel.setPermissionId(model.getPermissionId());

		return soapModel;
	}

	public static PermissionGroupSoap[] toSoapModels(PermissionGroup[] models) {
		PermissionGroupSoap[] soapModels =
			new PermissionGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PermissionGroupSoap[][] toSoapModels(
		PermissionGroup[][] models) {

		PermissionGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PermissionGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PermissionGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PermissionGroupSoap[] toSoapModels(
		List<PermissionGroup> models) {

		List<PermissionGroupSoap> soapModels =
			new ArrayList<PermissionGroupSoap>(models.size());

		for (PermissionGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PermissionGroupSoap[soapModels.size()]);
	}

	public PermissionGroupSoap() {
	}

	public PermissionGroupPK getPrimaryKey() {
		return new PermissionGroupPK(_userPermissionGroupId, _permissionId);
	}

	public void setPrimaryKey(PermissionGroupPK pk) {
		setUserPermissionGroupId(pk.userPermissionGroupId);
		setPermissionId(pk.permissionId);
	}

	public long getUserPermissionGroupId() {
		return _userPermissionGroupId;
	}

	public void setUserPermissionGroupId(long userPermissionGroupId) {
		_userPermissionGroupId = userPermissionGroupId;
	}

	public int getPermissionId() {
		return _permissionId;
	}

	public void setPermissionId(int permissionId) {
		_permissionId = permissionId;
	}

	private long _userPermissionGroupId;
	private int _permissionId;

}