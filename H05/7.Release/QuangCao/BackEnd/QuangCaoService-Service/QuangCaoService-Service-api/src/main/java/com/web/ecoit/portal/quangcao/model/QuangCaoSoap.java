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
 * This class is used by SOAP remote services, specifically {@link com.web.ecoit.portal.quangcao.service.http.QuangCaoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuangCaoSoap implements Serializable {

	public static QuangCaoSoap toSoapModel(QuangCao model) {
		QuangCaoSoap soapModel = new QuangCaoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setQuangCaoId(model.getQuangCaoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTenQuangCao(model.getTenQuangCao());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setTarget(model.getTarget());
		soapModel.setImageId(model.getImageId());
		soapModel.setUrl(model.getUrl());
		soapModel.setType(model.getType());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static QuangCaoSoap[] toSoapModels(QuangCao[] models) {
		QuangCaoSoap[] soapModels = new QuangCaoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuangCaoSoap[][] toSoapModels(QuangCao[][] models) {
		QuangCaoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuangCaoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuangCaoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuangCaoSoap[] toSoapModels(List<QuangCao> models) {
		List<QuangCaoSoap> soapModels = new ArrayList<QuangCaoSoap>(
			models.size());

		for (QuangCao model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuangCaoSoap[soapModels.size()]);
	}

	public QuangCaoSoap() {
	}

	public long getPrimaryKey() {
		return _quangCaoId;
	}

	public void setPrimaryKey(long pk) {
		setQuangCaoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
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

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _quangCaoId;
	private long _groupId;
	private String _language;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tenQuangCao;
	private String _moTa;
	private Boolean _target;
	private long _imageId;
	private String _url;
	private int _type;
	private int _status;

}