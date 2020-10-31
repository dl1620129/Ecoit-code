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

package com.ecoit.cms.config.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.cms.config.service.http.PortletConfigServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PortletConfigSoap implements Serializable {

	public static PortletConfigSoap toSoapModel(PortletConfig model) {
		PortletConfigSoap soapModel = new PortletConfigSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setCatgoryId(model.getCatgoryId());

		return soapModel;
	}

	public static PortletConfigSoap[] toSoapModels(PortletConfig[] models) {
		PortletConfigSoap[] soapModels = new PortletConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortletConfigSoap[][] toSoapModels(PortletConfig[][] models) {
		PortletConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortletConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortletConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortletConfigSoap[] toSoapModels(List<PortletConfig> models) {
		List<PortletConfigSoap> soapModels = new ArrayList<PortletConfigSoap>(
			models.size());

		for (PortletConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortletConfigSoap[soapModels.size()]);
	}

	public PortletConfigSoap() {
	}

	public String getPrimaryKey() {
		return _portletId;
	}

	public void setPrimaryKey(String pk) {
		setPortletId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public long getCatgoryId() {
		return _catgoryId;
	}

	public void setCatgoryId(long catgoryId) {
		_catgoryId = catgoryId;
	}

	private String _uuid;
	private String _portletId;
	private long _catgoryId;

}