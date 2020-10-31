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

package com.ecoit.elegaldocument.model;

import com.ecoit.elegaldocument.service.persistence.GroupFieldPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.GroupFieldServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class GroupFieldSoap implements Serializable {

	public static GroupFieldSoap toSoapModel(GroupField model) {
		GroupFieldSoap soapModel = new GroupFieldSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setFieldid(model.getFieldid());

		return soapModel;
	}

	public static GroupFieldSoap[] toSoapModels(GroupField[] models) {
		GroupFieldSoap[] soapModels = new GroupFieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupFieldSoap[][] toSoapModels(GroupField[][] models) {
		GroupFieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GroupFieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupFieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupFieldSoap[] toSoapModels(List<GroupField> models) {
		List<GroupFieldSoap> soapModels = new ArrayList<GroupFieldSoap>(
			models.size());

		for (GroupField model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupFieldSoap[soapModels.size()]);
	}

	public GroupFieldSoap() {
	}

	public GroupFieldPK getPrimaryKey() {
		return new GroupFieldPK(_groupUserId, _fieldid);
	}

	public void setPrimaryKey(GroupFieldPK pk) {
		setGroupUserId(pk.groupUserId);
		setFieldid(pk.fieldid);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getFieldid() {
		return _fieldid;
	}

	public void setFieldid(long fieldid) {
		_fieldid = fieldid;
	}

	private long _groupUserId;
	private long _fieldid;

}