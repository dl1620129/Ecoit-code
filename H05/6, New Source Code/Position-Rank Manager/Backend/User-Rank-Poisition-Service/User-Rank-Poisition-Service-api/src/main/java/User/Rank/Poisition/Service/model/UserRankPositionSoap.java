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
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link User.Rank.Poisition.Service.service.http.UserRankPositionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UserRankPositionSoap implements Serializable {

	public static UserRankPositionSoap toSoapModel(UserRankPosition model) {
		UserRankPositionSoap soapModel = new UserRankPositionSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setUserRankId(model.getUserRankId());
		soapModel.setUserPoisitionDangId(model.getUserPoisitionDangId());
		soapModel.setUserPoisitionId(model.getUserPoisitionId());

		return soapModel;
	}

	public static UserRankPositionSoap[] toSoapModels(
		UserRankPosition[] models) {

		UserRankPositionSoap[] soapModels =
			new UserRankPositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRankPositionSoap[][] toSoapModels(
		UserRankPosition[][] models) {

		UserRankPositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserRankPositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserRankPositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRankPositionSoap[] toSoapModels(
		List<UserRankPosition> models) {

		List<UserRankPositionSoap> soapModels =
			new ArrayList<UserRankPositionSoap>(models.size());

		for (UserRankPosition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserRankPositionSoap[soapModels.size()]);
	}

	public UserRankPositionSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getUserRankId() {
		return _userRankId;
	}

	public void setUserRankId(long userRankId) {
		_userRankId = userRankId;
	}

	public long getUserPoisitionDangId() {
		return _userPoisitionDangId;
	}

	public void setUserPoisitionDangId(long userPoisitionDangId) {
		_userPoisitionDangId = userPoisitionDangId;
	}

	public long getUserPoisitionId() {
		return _userPoisitionId;
	}

	public void setUserPoisitionId(long userPoisitionId) {
		_userPoisitionId = userPoisitionId;
	}

	private long _userId;
	private long _userRankId;
	private long _userPoisitionDangId;
	private long _userPoisitionId;

}