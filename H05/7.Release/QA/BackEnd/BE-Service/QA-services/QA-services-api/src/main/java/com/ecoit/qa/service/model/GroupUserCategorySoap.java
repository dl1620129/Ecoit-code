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

import com.ecoit.qa.service.service.persistence.GroupUserCategoryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.GroupUserCategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GroupUserCategorySoap implements Serializable {

	public static GroupUserCategorySoap toSoapModel(GroupUserCategory model) {
		GroupUserCategorySoap soapModel = new GroupUserCategorySoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static GroupUserCategorySoap[] toSoapModels(
		GroupUserCategory[] models) {

		GroupUserCategorySoap[] soapModels =
			new GroupUserCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupUserCategorySoap[][] toSoapModels(
		GroupUserCategory[][] models) {

		GroupUserCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GroupUserCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupUserCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupUserCategorySoap[] toSoapModels(
		List<GroupUserCategory> models) {

		List<GroupUserCategorySoap> soapModels =
			new ArrayList<GroupUserCategorySoap>(models.size());

		for (GroupUserCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupUserCategorySoap[soapModels.size()]);
	}

	public GroupUserCategorySoap() {
	}

	public GroupUserCategoryPK getPrimaryKey() {
		return new GroupUserCategoryPK(_groupUserId, _categoryId);
	}

	public void setPrimaryKey(GroupUserCategoryPK pk) {
		setGroupUserId(pk.groupUserId);
		setCategoryId(pk.categoryId);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private long _groupUserId;
	private long _categoryId;

}