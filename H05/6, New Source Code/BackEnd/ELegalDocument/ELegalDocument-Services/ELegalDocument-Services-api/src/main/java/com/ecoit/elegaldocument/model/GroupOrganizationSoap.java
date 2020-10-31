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

package com.ecoit.elegaldocument.model;

import com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.GroupOrganizationServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class GroupOrganizationSoap implements Serializable {

	public static GroupOrganizationSoap toSoapModel(GroupOrganization model) {
		GroupOrganizationSoap soapModel = new GroupOrganizationSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setOrganizationid(model.getOrganizationid());

		return soapModel;
	}

	public static GroupOrganizationSoap[] toSoapModels(
		GroupOrganization[] models) {

		GroupOrganizationSoap[] soapModels =
			new GroupOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GroupOrganizationSoap[][] toSoapModels(
		GroupOrganization[][] models) {

		GroupOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new GroupOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GroupOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GroupOrganizationSoap[] toSoapModels(
		List<GroupOrganization> models) {

		List<GroupOrganizationSoap> soapModels =
			new ArrayList<GroupOrganizationSoap>(models.size());

		for (GroupOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GroupOrganizationSoap[soapModels.size()]);
	}

	public GroupOrganizationSoap() {
	}

	public GroupOrganizationPK getPrimaryKey() {
		return new GroupOrganizationPK(_groupUserId, _organizationid);
	}

	public void setPrimaryKey(GroupOrganizationPK pk) {
		setGroupUserId(pk.groupUserId);
		setOrganizationid(pk.organizationid);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getOrganizationid() {
		return _organizationid;
	}

	public void setOrganizationid(long organizationid) {
		_organizationid = organizationid;
	}

	private long _groupUserId;
	private long _organizationid;

}