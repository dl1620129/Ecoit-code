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

package com.software.cms.model;

import com.software.cms.service.persistence.GroupCategoryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.GroupCategoryServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class GroupCategorySoap implements Serializable {

	public static GroupCategorySoap toSoapModel(GroupCategory model) {
		GroupCategorySoap soapModel = new GroupCategorySoap();

		soapModel.setGroupuserid(model.getGroupuserid());
		soapModel.setCategoryId(model.getCategoryId());

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
		return new GroupCategoryPK(_groupuserid, _categoryId);
	}

	public void setPrimaryKey(GroupCategoryPK pk) {
		setGroupuserid(pk.groupuserid);
		setCategoryId(pk.categoryId);
	}

	public long getGroupuserid() {
		return _groupuserid;
	}

	public void setGroupuserid(long groupuserid) {
		_groupuserid = groupuserid;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private long _groupuserid;
	private long _categoryId;

}