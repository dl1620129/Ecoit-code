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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.MapCateLayoutServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class MapCateLayoutSoap implements Serializable {

	public static MapCateLayoutSoap toSoapModel(MapCateLayout model) {
		MapCateLayoutSoap soapModel = new MapCateLayoutSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMapCateLayoutId(model.getMapCateLayoutId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static MapCateLayoutSoap[] toSoapModels(MapCateLayout[] models) {
		MapCateLayoutSoap[] soapModels = new MapCateLayoutSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MapCateLayoutSoap[][] toSoapModels(MapCateLayout[][] models) {
		MapCateLayoutSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MapCateLayoutSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MapCateLayoutSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MapCateLayoutSoap[] toSoapModels(List<MapCateLayout> models) {
		List<MapCateLayoutSoap> soapModels = new ArrayList<MapCateLayoutSoap>(
			models.size());

		for (MapCateLayout model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MapCateLayoutSoap[soapModels.size()]);
	}

	public MapCateLayoutSoap() {
	}

	public long getPrimaryKey() {
		return _mapCateLayoutId;
	}

	public void setPrimaryKey(long pk) {
		setMapCateLayoutId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMapCateLayoutId() {
		return _mapCateLayoutId;
	}

	public void setMapCateLayoutId(long mapCateLayoutId) {
		_mapCateLayoutId = mapCateLayoutId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private String _uuid;
	private long _mapCateLayoutId;
	private long _companyId;
	private long _groupId;
	private long _categoryId;
	private long _layoutId;
	private int _type;

}