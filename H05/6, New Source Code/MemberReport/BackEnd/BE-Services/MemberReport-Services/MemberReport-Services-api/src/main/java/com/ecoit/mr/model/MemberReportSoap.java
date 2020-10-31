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

package com.ecoit.mr.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.mr.service.http.MemberReportServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MemberReportSoap implements Serializable {

	public static MemberReportSoap toSoapModel(MemberReport model) {
		MemberReportSoap soapModel = new MemberReportSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMemberReportId(model.getMemberReportId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setTong(model.getTong());
		soapModel.setCongTac(model.getCongTac());
		soapModel.setHocTap(model.getHocTap());
		soapModel.setNghiPhep(model.getNghiPhep());
		soapModel.setNghiOm(model.getNghiOm());
		soapModel.setNghiBu(model.getNghiBu());
		soapModel.setLiDoKhac(model.getLiDoKhac());
		soapModel.setNote(model.getNote());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static MemberReportSoap[] toSoapModels(MemberReport[] models) {
		MemberReportSoap[] soapModels = new MemberReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberReportSoap[][] toSoapModels(MemberReport[][] models) {
		MemberReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberReportSoap[] toSoapModels(List<MemberReport> models) {
		List<MemberReportSoap> soapModels = new ArrayList<MemberReportSoap>(
			models.size());

		for (MemberReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberReportSoap[soapModels.size()]);
	}

	public MemberReportSoap() {
	}

	public long getPrimaryKey() {
		return _memberReportId;
	}

	public void setPrimaryKey(long pk) {
		setMemberReportId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMemberReportId() {
		return _memberReportId;
	}

	public void setMemberReportId(long memberReportId) {
		_memberReportId = memberReportId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public long getTong() {
		return _tong;
	}

	public void setTong(long tong) {
		_tong = tong;
	}

	public long getCongTac() {
		return _congTac;
	}

	public void setCongTac(long congTac) {
		_congTac = congTac;
	}

	public long getHocTap() {
		return _hocTap;
	}

	public void setHocTap(long hocTap) {
		_hocTap = hocTap;
	}

	public long getNghiPhep() {
		return _nghiPhep;
	}

	public void setNghiPhep(long nghiPhep) {
		_nghiPhep = nghiPhep;
	}

	public long getNghiOm() {
		return _nghiOm;
	}

	public void setNghiOm(long nghiOm) {
		_nghiOm = nghiOm;
	}

	public long getNghiBu() {
		return _nghiBu;
	}

	public void setNghiBu(long nghiBu) {
		_nghiBu = nghiBu;
	}

	public long getLiDoKhac() {
		return _liDoKhac;
	}

	public void setLiDoKhac(long liDoKhac) {
		_liDoKhac = liDoKhac;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	private String _uuid;
	private long _memberReportId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createdByUser;
	private long _modifiedByUser;
	private long _tong;
	private long _congTac;
	private long _hocTap;
	private long _nghiPhep;
	private long _nghiOm;
	private long _nghiBu;
	private long _liDoKhac;
	private String _note;
	private long _unitId;
	private String _language;
	private long _status;

}