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
 * This class is used by SOAP remote services, specifically {@link User.Rank.Poisition.Service.service.http.UserRankServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserRankSoap implements Serializable {

	public static UserRankSoap toSoapModel(UserRank model) {
		UserRankSoap soapModel = new UserRankSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserRankId(model.getUserRankId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRankName(model.getRankName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTotalMember(model.getTotalMember());

		return soapModel;
	}

	public static UserRankSoap[] toSoapModels(UserRank[] models) {
		UserRankSoap[] soapModels = new UserRankSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRankSoap[][] toSoapModels(UserRank[][] models) {
		UserRankSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserRankSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserRankSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRankSoap[] toSoapModels(List<UserRank> models) {
		List<UserRankSoap> soapModels = new ArrayList<UserRankSoap>(
			models.size());

		for (UserRank model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserRankSoap[soapModels.size()]);
	}

	public UserRankSoap() {
	}

	public long getPrimaryKey() {
		return _userRankId;
	}

	public void setPrimaryKey(long pk) {
		setUserRankId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserRankId() {
		return _userRankId;
	}

	public void setUserRankId(long userRankId) {
		_userRankId = userRankId;
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

	public String getRankName() {
		return _rankName;
	}

	public void setRankName(String rankName) {
		_rankName = rankName;
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
	private long _userRankId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _rankName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private long _totalMember;

}