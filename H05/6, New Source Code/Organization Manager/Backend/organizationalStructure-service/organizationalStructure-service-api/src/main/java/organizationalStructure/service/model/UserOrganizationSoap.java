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

package organizationalStructure.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import organizationalStructure.service.service.persistence.UserOrganizationPK;

/**
 * This class is used by SOAP remote services, specifically {@link organizationalStructure.service.service.http.UserOrganizationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserOrganizationSoap implements Serializable {

	public static UserOrganizationSoap toSoapModel(UserOrganization model) {
		UserOrganizationSoap soapModel = new UserOrganizationSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setOrganizationId(model.getOrganizationId());

		return soapModel;
	}

	public static UserOrganizationSoap[] toSoapModels(
		UserOrganization[] models) {

		UserOrganizationSoap[] soapModels =
			new UserOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserOrganizationSoap[][] toSoapModels(
		UserOrganization[][] models) {

		UserOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserOrganizationSoap[] toSoapModels(
		List<UserOrganization> models) {

		List<UserOrganizationSoap> soapModels =
			new ArrayList<UserOrganizationSoap>(models.size());

		for (UserOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserOrganizationSoap[soapModels.size()]);
	}

	public UserOrganizationSoap() {
	}

	public UserOrganizationPK getPrimaryKey() {
		return new UserOrganizationPK(_userId, _organizationId);
	}

	public void setPrimaryKey(UserOrganizationPK pk) {
		setUserId(pk.userId);
		setOrganizationId(pk.organizationId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	private long _userId;
	private long _organizationId;

}