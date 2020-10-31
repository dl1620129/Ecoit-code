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

import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.lichcongtac.services.service.http.ColumnGroupRelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ColumnGroupRelSoap implements Serializable {

	public static ColumnGroupRelSoap toSoapModel(ColumnGroupRel model) {
		ColumnGroupRelSoap soapModel = new ColumnGroupRelSoap();

		soapModel.setUserPermissionGroupId(model.getUserPermissionGroupId());
		soapModel.setColumnId(model.getColumnId());

		return soapModel;
	}

	public static ColumnGroupRelSoap[] toSoapModels(ColumnGroupRel[] models) {
		ColumnGroupRelSoap[] soapModels = new ColumnGroupRelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ColumnGroupRelSoap[][] toSoapModels(
		ColumnGroupRel[][] models) {

		ColumnGroupRelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ColumnGroupRelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ColumnGroupRelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ColumnGroupRelSoap[] toSoapModels(
		List<ColumnGroupRel> models) {

		List<ColumnGroupRelSoap> soapModels = new ArrayList<ColumnGroupRelSoap>(
			models.size());

		for (ColumnGroupRel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ColumnGroupRelSoap[soapModels.size()]);
	}

	public ColumnGroupRelSoap() {
	}

	public ColumnGroupRelPK getPrimaryKey() {
		return new ColumnGroupRelPK(_userPermissionGroupId, _columnId);
	}

	public void setPrimaryKey(ColumnGroupRelPK pk) {
		setUserPermissionGroupId(pk.userPermissionGroupId);
		setColumnId(pk.columnId);
	}

	public long getUserPermissionGroupId() {
		return _userPermissionGroupId;
	}

	public void setUserPermissionGroupId(long userPermissionGroupId) {
		_userPermissionGroupId = userPermissionGroupId;
	}

	public int getColumnId() {
		return _columnId;
	}

	public void setColumnId(int columnId) {
		_columnId = columnId;
	}

	private long _userPermissionGroupId;
	private int _columnId;

}