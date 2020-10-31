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

import com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.EcmsPGRelationServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class EcmsPGRelationSoap implements Serializable {

	public static EcmsPGRelationSoap toSoapModel(EcmsPGRelation model) {
		EcmsPGRelationSoap soapModel = new EcmsPGRelationSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setPermission(model.getPermission());

		return soapModel;
	}

	public static EcmsPGRelationSoap[] toSoapModels(EcmsPGRelation[] models) {
		EcmsPGRelationSoap[] soapModels = new EcmsPGRelationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EcmsPGRelationSoap[][] toSoapModels(
		EcmsPGRelation[][] models) {

		EcmsPGRelationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EcmsPGRelationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EcmsPGRelationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EcmsPGRelationSoap[] toSoapModels(
		List<EcmsPGRelation> models) {

		List<EcmsPGRelationSoap> soapModels = new ArrayList<EcmsPGRelationSoap>(
			models.size());

		for (EcmsPGRelation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EcmsPGRelationSoap[soapModels.size()]);
	}

	public EcmsPGRelationSoap() {
	}

	public EcmsPGRelationPK getPrimaryKey() {
		return new EcmsPGRelationPK(_groupUserId, _permission);
	}

	public void setPrimaryKey(EcmsPGRelationPK pk) {
		setGroupUserId(pk.groupUserId);
		setPermission(pk.permission);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public int getPermission() {
		return _permission;
	}

	public void setPermission(int permission) {
		_permission = permission;
	}

	private long _groupUserId;
	private int _permission;

}