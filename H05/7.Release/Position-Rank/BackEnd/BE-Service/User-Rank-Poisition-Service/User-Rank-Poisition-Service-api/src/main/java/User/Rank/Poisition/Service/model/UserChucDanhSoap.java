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
 * This class is used by SOAP remote services, specifically {@link User.Rank.Poisition.Service.service.http.UserChucDanhServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserChucDanhSoap implements Serializable {

	public static UserChucDanhSoap toSoapModel(UserChucDanh model) {
		UserChucDanhSoap soapModel = new UserChucDanhSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserChucDanhId(model.getUserChucDanhId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserChucDanhName(model.getUserChucDanhName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTotalMember(model.getTotalMember());

		return soapModel;
	}

	public static UserChucDanhSoap[] toSoapModels(UserChucDanh[] models) {
		UserChucDanhSoap[] soapModels = new UserChucDanhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserChucDanhSoap[][] toSoapModels(UserChucDanh[][] models) {
		UserChucDanhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserChucDanhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserChucDanhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserChucDanhSoap[] toSoapModels(List<UserChucDanh> models) {
		List<UserChucDanhSoap> soapModels = new ArrayList<UserChucDanhSoap>(
			models.size());

		for (UserChucDanh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserChucDanhSoap[soapModels.size()]);
	}

	public UserChucDanhSoap() {
	}

	public long getPrimaryKey() {
		return _userChucDanhId;
	}

	public void setPrimaryKey(long pk) {
		setUserChucDanhId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserChucDanhId() {
		return _userChucDanhId;
	}

	public void setUserChucDanhId(long userChucDanhId) {
		_userChucDanhId = userChucDanhId;
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

	public String getUserChucDanhName() {
		return _userChucDanhName;
	}

	public void setUserChucDanhName(String userChucDanhName) {
		_userChucDanhName = userChucDanhName;
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
	private long _userChucDanhId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userChucDanhName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private long _totalMember;

}