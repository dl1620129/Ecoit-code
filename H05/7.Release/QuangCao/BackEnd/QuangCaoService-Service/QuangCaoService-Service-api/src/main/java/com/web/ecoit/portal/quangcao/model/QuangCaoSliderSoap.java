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

package com.web.ecoit.portal.quangcao.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.web.ecoit.portal.quangcao.service.http.QuangCaoSliderServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuangCaoSliderSoap implements Serializable {

	public static QuangCaoSliderSoap toSoapModel(QuangCaoSlider model) {
		QuangCaoSliderSoap soapModel = new QuangCaoSliderSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setQuangCaoSliderId(model.getQuangCaoSliderId());
		soapModel.setQuangCaoId(model.getQuangCaoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTenQuangCao(model.getTenQuangCao());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setTarget(model.getTarget());
		soapModel.setUrl(model.getUrl());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static QuangCaoSliderSoap[] toSoapModels(QuangCaoSlider[] models) {
		QuangCaoSliderSoap[] soapModels = new QuangCaoSliderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuangCaoSliderSoap[][] toSoapModels(
		QuangCaoSlider[][] models) {

		QuangCaoSliderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuangCaoSliderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuangCaoSliderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuangCaoSliderSoap[] toSoapModels(
		List<QuangCaoSlider> models) {

		List<QuangCaoSliderSoap> soapModels = new ArrayList<QuangCaoSliderSoap>(
			models.size());

		for (QuangCaoSlider model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuangCaoSliderSoap[soapModels.size()]);
	}

	public QuangCaoSliderSoap() {
	}

	public long getPrimaryKey() {
		return _quangCaoSliderId;
	}

	public void setPrimaryKey(long pk) {
		setQuangCaoSliderId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getQuangCaoSliderId() {
		return _quangCaoSliderId;
	}

	public void setQuangCaoSliderId(long quangCaoSliderId) {
		_quangCaoSliderId = quangCaoSliderId;
	}

	public long getQuangCaoId() {
		return _quangCaoId;
	}

	public void setQuangCaoId(long quangCaoId) {
		_quangCaoId = quangCaoId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getTenQuangCao() {
		return _tenQuangCao;
	}

	public void setTenQuangCao(String tenQuangCao) {
		_tenQuangCao = tenQuangCao;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public Boolean getTarget() {
		return _target;
	}

	public void setTarget(Boolean target) {
		_target = target;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private String _uuid;
	private long _quangCaoSliderId;
	private long _quangCaoId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tenQuangCao;
	private String _moTa;
	private Boolean _target;
	private String _url;
	private int _type;

}