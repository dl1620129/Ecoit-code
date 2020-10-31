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
public class LichCongTacSoap implements Serializable {

	public static LichCongTacSoap toSoapModel(LichCongTac model) {
		LichCongTacSoap soapModel = new LichCongTacSoap();

		soapModel.setLichCongTacId(model.getLichCongTacId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setTenLich(model.getTenLich());
		soapModel.setNgayBatDau(model.getNgayBatDau());
		soapModel.setNgayKetThuc(model.getNgayKetThuc());
		soapModel.setLichChuyenBanNganh(model.getLichChuyenBanNganh());
		soapModel.setLichChuyenNguoiDung(model.getLichChuyenNguoiDung());
		soapModel.setTrangthaiLichCongTac(model.getTrangthaiLichCongTac());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setLydoTraVe(model.getLydoTraVe());

		return soapModel;
	}

	public static LichCongTacSoap[] toSoapModels(LichCongTac[] models) {
		LichCongTacSoap[] soapModels = new LichCongTacSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LichCongTacSoap[][] toSoapModels(LichCongTac[][] models) {
		LichCongTacSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LichCongTacSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LichCongTacSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LichCongTacSoap[] toSoapModels(List<LichCongTac> models) {
		List<LichCongTacSoap> soapModels = new ArrayList<LichCongTacSoap>(
			models.size());

		for (LichCongTac model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LichCongTacSoap[soapModels.size()]);
	}

	public LichCongTacSoap() {
	}

	public long getPrimaryKey() {
		return _lichCongTacId;
	}

	public void setPrimaryKey(long pk) {
		setLichCongTacId(pk);
	}

	public long getLichCongTacId() {
		return _lichCongTacId;
	}

	public void setLichCongTacId(long lichCongTacId) {
		_lichCongTacId = lichCongTacId;
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

	public String getTenLich() {
		return _tenLich;
	}

	public void setTenLich(String tenLich) {
		_tenLich = tenLich;
	}

	public Date getNgayBatDau() {
		return _ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		_ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		_ngayKetThuc = ngayKetThuc;
	}

	public String getLichChuyenBanNganh() {
		return _lichChuyenBanNganh;
	}

	public void setLichChuyenBanNganh(String lichChuyenBanNganh) {
		_lichChuyenBanNganh = lichChuyenBanNganh;
	}

	public String getLichChuyenNguoiDung() {
		return _lichChuyenNguoiDung;
	}

	public void setLichChuyenNguoiDung(String lichChuyenNguoiDung) {
		_lichChuyenNguoiDung = lichChuyenNguoiDung;
	}

	public int getTrangthaiLichCongTac() {
		return _trangthaiLichCongTac;
	}

	public void setTrangthaiLichCongTac(int trangthaiLichCongTac) {
		_trangthaiLichCongTac = trangthaiLichCongTac;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getLydoTraVe() {
		return _lydoTraVe;
	}

	public void setLydoTraVe(String lydoTraVe) {
		_lydoTraVe = lydoTraVe;
	}

	private long _lichCongTacId;
	private long _groupId;
	private String _language;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private String _tenLich;
	private Date _ngayBatDau;
	private Date _ngayKetThuc;
	private String _lichChuyenBanNganh;
	private String _lichChuyenNguoiDung;
	private int _trangthaiLichCongTac;
	private long _organizationId;
	private String _lydoTraVe;

}