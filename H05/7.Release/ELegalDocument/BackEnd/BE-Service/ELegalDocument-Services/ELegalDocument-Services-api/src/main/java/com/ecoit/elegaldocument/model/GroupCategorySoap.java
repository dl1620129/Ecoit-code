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

import com.ecoit.elegaldocument.service.persistence.GroupCategoryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.GroupCategoryServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class GroupCategorySoap implements Serializable {

	public static GroupCategorySoap toSoapModel(GroupCategory model) {
		GroupCategorySoap soapModel = new GroupCategorySoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setTypeid(model.getTypeid());

		return soapModel;
	}

	public static GroupCategorySoap[] toSoapModels(GroupCategory[] models) {
		GroupCategorySoap[] soapModels = new GroupCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupCategorySoap[][] toSoapModels(GroupCategory[][] models) {
		GroupCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GroupCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupCategorySoap[] toSoapModels(List<GroupCategory> models) {
		List<GroupCategorySoap> soapModels = new ArrayList<GroupCategorySoap>(
			models.size());

		for (GroupCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupCategorySoap[soapModels.size()]);
	}

	public GroupCategorySoap() {
	}

	public GroupCategoryPK getPrimaryKey() {
		return new GroupCategoryPK(_groupUserId, _typeid);
	}

	public void setPrimaryKey(GroupCategoryPK pk) {
		setGroupUserId(pk.groupUserId);
		setTypeid(pk.typeid);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getTypeid() {
		return _typeid;
	}

	public void setTypeid(long typeid) {
		_typeid = typeid;
	}

	private long _groupUserId;
	private long _typeid;

}