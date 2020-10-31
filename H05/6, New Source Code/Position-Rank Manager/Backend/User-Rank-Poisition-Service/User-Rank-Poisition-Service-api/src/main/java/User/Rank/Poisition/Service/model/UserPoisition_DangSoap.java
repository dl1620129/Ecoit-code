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

package User.Rank.Poisition.Service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link User.Rank.Poisition.Service.service.http.UserPoisition_DangServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserPoisition_DangSoap implements Serializable {

	public static UserPoisition_DangSoap toSoapModel(UserPoisition_Dang model) {
		UserPoisition_DangSoap soapModel = new UserPoisition_DangSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserPoisitionDangId(model.getUserPoisitionDangId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserPoisitionDangName(model.getUserPoisitionDangName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTotalMember(model.getTotalMember());

		return soapModel;
	}

	public static UserPoisition_DangSoap[] toSoapModels(
		UserPoisition_Dang[] models) {

		UserPoisition_DangSoap[] soapModels =
			new UserPoisition_DangSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPoisition_DangSoap[][] toSoapModels(
		UserPoisition_Dang[][] models) {

		UserPoisition_DangSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserPoisition_DangSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPoisition_DangSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPoisition_DangSoap[] toSoapModels(
		List<UserPoisition_Dang> models) {

		List<UserPoisition_DangSoap> soapModels =
			new ArrayList<UserPoisition_DangSoap>(models.size());

		for (UserPoisition_Dang model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new UserPoisition_DangSoap[soapModels.size()]);
	}

	public UserPoisition_DangSoap() {
	}

	public long getPrimaryKey() {
		return _userPoisitionDangId;
	}

	public void setPrimaryKey(long pk) {
		setUserPoisitionDangId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserPoisitionDangId() {
		return _userPoisitionDangId;
	}

	public void setUserPoisitionDangId(long userPoisitionDangId) {
		_userPoisitionDangId = userPoisitionDangId;
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

	public String getUserPoisitionDangName() {
		return _userPoisitionDangName;
	}

	public void setUserPoisitionDangName(String userPoisitionDangName) {
		_userPoisitionDangName = userPoisitionDangName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public long getTotalMember() {
		return _totalMember;
	}

	public void setTotalMember(long totalMember) {
		_totalMember = totalMember;
	}

	private String _uuid;
	private long _userPoisitionDangId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userPoisitionDangName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private long _totalMember;

}