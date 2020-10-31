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

package Album.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link Album.service.service.http.CategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CategorySoap implements Serializable {

	public static CategorySoap toSoapModel(Category model) {
		CategorySoap soapModel = new CategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateByUser(model.getCreateByUser());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setView(model.getView());
		soapModel.setParentId(model.getParentId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setTacGiaAlbum(model.getTacGiaAlbum());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setStatus(model.getStatus());
		soapModel.setThuTu(model.getThuTu());
		soapModel.setIsDaiDien(model.isIsDaiDien());
		soapModel.setUrlImage(model.getUrlImage());

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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getCreateByUser() {
		return _createByUser;
	}

	public void setCreateByUser(String createByUser) {
		_createByUser = createByUser;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(String modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getView() {
		return _view;
	}

	public void setView(long view) {
		_view = view;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getTacGiaAlbum() {
		return _tacGiaAlbum;
	}

	public void setTacGiaAlbum(String tacGiaAlbum) {
		_tacGiaAlbum = tacGiaAlbum;
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public int getThuTu() {
		return _thuTu;
	}

	public void setThuTu(int thuTu) {
		_thuTu = thuTu;
	}

	public boolean getIsDaiDien() {
		return _isDaiDien;
	}

	public boolean isIsDaiDien() {
		return _isDaiDien;
	}

	public void setIsDaiDien(boolean isDaiDien) {
		_isDaiDien = isDaiDien;
	}

	public String getUrlImage() {
		return _urlImage;
	}

	public void setUrlImage(String urlImage) {
		_urlImage = urlImage;
	}

	private long _categoryId;
	private long _groupId;
	private long _companyId;
	private String _createByUser;
	private Date _createDate;
	private String _modifiedByUser;
	private Date _modifiedDate;
	private long _view;
	private long _parentId;
	private String _name;
	private String _description;
	private String _tacGiaAlbum;
	private long _fieldId;
	private long _status;
	private int _thuTu;
	private boolean _isDaiDien;
	private String _urlImage;

}