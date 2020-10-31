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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.CategoryServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class CategorySoap implements Serializable {

	public static CategorySoap toSoapModel(Category model) {
		CategorySoap soapModel = new CategorySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTitle(model.getTitle());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedUser(model.getCreatedUser());
		soapModel.setModifiedUser(model.getModifiedUser());
		soapModel.setPath(model.getPath());
		soapModel.setDescription(model.getDescription());
		soapModel.setDisplay(model.isDisplay());
		soapModel.setParentId(model.getParentId());
		soapModel.setActive(model.getActive());
		soapModel.setCateChild(model.getCateChild());
		soapModel.setThuTu(model.getThuTu());
		soapModel.setLink(model.getLink());
		soapModel.setIsRss(model.isIsRss());

		return soapModel;
	}

	public static CategorySoap[] toSoapModels(Category[] models) {
		CategorySoap[] soapModels = new CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategorySoap[][] toSoapModels(Category[][] models) {
		CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategorySoap[] toSoapModels(List<Category> models) {
		List<CategorySoap> soapModels = new ArrayList<CategorySoap>(
			models.size());

		for (Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategorySoap[soapModels.size()]);
	}

	public CategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatedUser() {
		return _createdUser;
	}

	public void setCreatedUser(long createdUser) {
		_createdUser = createdUser;
	}

	public long getModifiedUser() {
		return _modifiedUser;
	}

	public void setModifiedUser(long modifiedUser) {
		_modifiedUser = modifiedUser;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getDisplay() {
		return _display;
	}

	public boolean isDisplay() {
		return _display;
	}

	public void setDisplay(boolean display) {
		_display = display;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public long getActive() {
		return _active;
	}

	public void setActive(long active) {
		_active = active;
	}

	public String getCateChild() {
		return _cateChild;
	}

	public void setCateChild(String cateChild) {
		_cateChild = cateChild;
	}

	public int getThuTu() {
		return _thuTu;
	}

	public void setThuTu(int thuTu) {
		_thuTu = thuTu;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public boolean getIsRss() {
		return _isRss;
	}

	public boolean isIsRss() {
		return _isRss;
	}

	public void setIsRss(boolean isRss) {
		_isRss = isRss;
	}

	private String _uuid;
	private long _categoryId;
	private long _groupId;
	private String _language;
	private String _title;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _createdUser;
	private long _modifiedUser;
	private String _path;
	private String _description;
	private boolean _display;
	private long _parentId;
	private long _active;
	private String _cateChild;
	private int _thuTu;
	private String _link;
	private boolean _isRss;

}