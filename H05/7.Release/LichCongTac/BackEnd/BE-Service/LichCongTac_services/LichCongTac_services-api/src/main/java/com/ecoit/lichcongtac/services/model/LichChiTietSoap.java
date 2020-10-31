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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LichChiTietSoap implements Serializable {

	public static LichChiTietSoap toSoapModel(LichChiTiet model) {
		LichChiTietSoap soapModel = new LichChiTietSoap();

		soapModel.setLichChiTietId(model.getLichChiTietId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setGioBatDau(model.getGioBatDau());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setNguoiThamDu(model.getNguoiThamDu());
		soapModel.setNguoiChuTri(model.getNguoiChuTri());
		soapModel.setSelectedDate(model.getSelectedDate());
		soapModel.setTrangthaiChiTiet(model.getTrangthaiChiTiet());
		soapModel.setLichCongTacId(model.getLichCongTacId());
		soapModel.setAddress(model.getAddress());
		soapModel.setNote(model.getNote());
		soapModel.setLydoTraVe(model.getLydoTraVe());
		soapModel.setOrganizationId(model.getOrganizationId());

		return soapModel;
	}

	public static LichChiTietSoap[] toSoapModels(LichChiTiet[] models) {
		LichChiTietSoap[] soapModels = new LichChiTietSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LichChiTietSoap[][] toSoapModels(LichChiTiet[][] models) {
		LichChiTietSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LichChiTietSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LichChiTietSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LichChiTietSoap[] toSoapModels(List<LichChiTiet> models) {
		List<LichChiTietSoap> soapModels = new ArrayList<LichChiTietSoap>(
			models.size());

		for (LichChiTiet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LichChiTietSoap[soapModels.size()]);
	}

	public LichChiTietSoap() {
	}

	public long getPrimaryKey() {
		return _lichChiTietId;
	}

	public void setPrimaryKey(long pk) {
		setLichChiTietId(pk);
	}

	public long getLichChiTietId() {
		return _lichChiTietId;
	}

	public void setLichChiTietId(long lichChiTietId) {
		_lichChiTietId = lichChiTietId;
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public Date getGioBatDau() {
		return _gioBatDau;
	}

	public void setGioBatDau(Date gioBatDau) {
		_gioBatDau = gioBatDau;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public String getNguoiThamDu() {
		return _nguoiThamDu;
	}

	public void setNguoiThamDu(String nguoiThamDu) {
		_nguoiThamDu = nguoiThamDu;
	}

	public String getNguoiChuTri() {
		return _nguoiChuTri;
	}

	public void setNguoiChuTri(String nguoiChuTri) {
		_nguoiChuTri = nguoiChuTri;
	}

	public Date getSelectedDate() {
		return _selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		_selectedDate = selectedDate;
	}

	public int getTrangthaiChiTiet() {
		return _trangthaiChiTiet;
	}

	public void setTrangthaiChiTiet(int trangthaiChiTiet) {
		_trangthaiChiTiet = trangthaiChiTiet;
	}

	public long getLichCongTacId() {
		return _lichCongTacId;
	}

	public void setLichCongTacId(long lichCongTacId) {
		_lichCongTacId = lichCongTacId;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getLydoTraVe() {
		return _lydoTraVe;
	}

	public void setLydoTraVe(String lydoTraVe) {
		_lydoTraVe = lydoTraVe;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	private long _lichChiTietId;
	private long _groupId;
	private String _language;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private Date _gioBatDau;
	private String _moTa;
	private String _nguoiThamDu;
	private String _nguoiChuTri;
	private Date _selectedDate;
	private int _trangthaiChiTiet;
	private long _lichCongTacId;
	private String _address;
	private String _note;
	private String _lydoTraVe;
	private long _organizationId;

}