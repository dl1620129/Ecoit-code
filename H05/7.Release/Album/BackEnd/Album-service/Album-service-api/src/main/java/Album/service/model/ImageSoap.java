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
 * This class is used by SOAP remote services, specifically {@link Album.service.service.http.ImageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ImageSoap implements Serializable {

	public static ImageSoap toSoapModel(Image model) {
		ImageSoap soapModel = new ImageSoap();

		soapModel.setImageId(model.getImageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAddByUser(model.getAddByUser());
		soapModel.setAddDate(model.getAddDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setFileAttachId(model.getFileAttachId());
		soapModel.setDisplay(model.isDisplay());
		soapModel.setView(model.getView());
		soapModel.setIsDaiDien(model.isIsDaiDien());
		soapModel.setTacGia(model.getTacGia());
		soapModel.setThuTu(model.getThuTu());
		soapModel.setImageFileId(model.getImageFileId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setImageUrl(model.getImageUrl());

		return soapModel;
	}

	public static ImageSoap[] toSoapModels(Image[] models) {
		ImageSoap[] soapModels = new ImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImageSoap[][] toSoapModels(Image[][] models) {
		ImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImageSoap[] toSoapModels(List<Image> models) {
		List<ImageSoap> soapModels = new ArrayList<ImageSoap>(models.size());

		for (Image model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImageSoap[soapModels.size()]);
	}

	public ImageSoap() {
	}

	public long getPrimaryKey() {
		return _imageId;
	}

	public void setPrimaryKey(long pk) {
		setImageId(pk);
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
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

	public String getAddByUser() {
		return _addByUser;
	}

	public void setAddByUser(String addByUser) {
		_addByUser = addByUser;
	}

	public Date getAddDate() {
		return _addDate;
	}

	public void setAddDate(Date addDate) {
		_addDate = addDate;
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getFileAttachId() {
		return _fileAttachId;
	}

	public void setFileAttachId(long fileAttachId) {
		_fileAttachId = fileAttachId;
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

	public long getView() {
		return _view;
	}

	public void setView(long view) {
		_view = view;
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

	public String getTacGia() {
		return _tacGia;
	}

	public void setTacGia(String tacGia) {
		_tacGia = tacGia;
	}

	public int getThuTu() {
		return _thuTu;
	}

	public void setThuTu(int thuTu) {
		_thuTu = thuTu;
	}

	public long getImageFileId() {
		return _imageFileId;
	}

	public void setImageFileId(long imageFileId) {
		_imageFileId = imageFileId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	private long _imageId;
	private long _groupId;
	private long _companyId;
	private String _addByUser;
	private Date _addDate;
	private String _modifiedByUser;
	private Date _modifiedDate;
	private long _categoryId;
	private long _fieldId;
	private String _title;
	private String _description;
	private long _fileAttachId;
	private boolean _display;
	private long _view;
	private boolean _isDaiDien;
	private String _tacGia;
	private int _thuTu;
	private long _imageFileId;
	private long _folderId;
	private String _imageUrl;

}