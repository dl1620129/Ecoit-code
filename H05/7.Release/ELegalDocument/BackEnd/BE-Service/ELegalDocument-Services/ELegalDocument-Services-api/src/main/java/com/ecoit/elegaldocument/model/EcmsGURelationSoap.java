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

import com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.EcmsGURelationServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class EcmsGURelationSoap implements Serializable {

	public static EcmsGURelationSoap toSoapModel(EcmsGURelation model) {
		EcmsGURelationSoap soapModel = new EcmsGURelationSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setGroupUserId(model.getGroupUserId());

		return soapModel;
	}

	public static EcmsGURelationSoap[] toSoapModels(EcmsGURelation[] models) {
		EcmsGURelationSoap[] soapModels = new EcmsGURelationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EcmsGURelationSoap[][] toSoapModels(
		EcmsGURelation[][] models) {

		EcmsGURelationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EcmsGURelationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EcmsGURelationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EcmsGURelationSoap[] toSoapModels(
		List<EcmsGURelation> models) {

		List<EcmsGURelationSoap> soapModels = new ArrayList<EcmsGURelationSoap>(
			models.size());

		for (EcmsGURelation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EcmsGURelationSoap[soapModels.size()]);
	}

	public EcmsGURelationSoap() {
	}

	public EcmsGURelationPK getPrimaryKey() {
		return new EcmsGURelationPK(_userId, _groupUserId);
	}

	public void setPrimaryKey(EcmsGURelationPK pk) {
		setUserId(pk.userId);
		setGroupUserId(pk.groupUserId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	private long _userId;
	private long _groupUserId;

}