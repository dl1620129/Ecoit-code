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

import com.ecoit.lichcongtac.services.service.persistence.PermissionGroupRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.lichcongtac.services.service.http.PermissionGroupRelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PermissionGroupRelSoap implements Serializable {

	public static PermissionGroupRelSoap toSoapModel(PermissionGroupRel model) {
		PermissionGroupRelSoap soapModel = new PermissionGroupRelSoap();

		soapModel.setUserPermissionGroupId(model.getUserPermissionGroupId());
		soapModel.setPermissionId(model.getPermissionId());

		return soapModel;
	}

	public static PermissionGroupRelSoap[] toSoapModels(
		PermissionGroupRel[] models) {

		PermissionGroupRelSoap[] soapModels =
			new PermissionGroupRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PermissionGroupRelSoap[][] toSoapModels(
		PermissionGroupRel[][] models) {

		PermissionGroupRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PermissionGroupRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PermissionGroupRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PermissionGroupRelSoap[] toSoapModels(
		List<PermissionGroupRel> models) {

		List<PermissionGroupRelSoap> soapModels =
			new ArrayList<PermissionGroupRelSoap>(models.size());

		for (PermissionGroupRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PermissionGroupRelSoap[soapModels.size()]);
	}

	public PermissionGroupRelSoap() {
	}

	public PermissionGroupRelPK getPrimaryKey() {
		return new PermissionGroupRelPK(_userPermissionGroupId, _permissionId);
	}

	public void setPrimaryKey(PermissionGroupRelPK pk) {
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