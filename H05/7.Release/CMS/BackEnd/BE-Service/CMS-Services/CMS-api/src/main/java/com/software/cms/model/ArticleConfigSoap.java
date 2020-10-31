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

package com.software.cms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.ArticleConfigServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class ArticleConfigSoap implements Serializable {

	public static ArticleConfigSoap toSoapModel(ArticleConfig model) {
		ArticleConfigSoap soapModel = new ArticleConfigSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setArticleConfigId(model.getArticleConfigId());

		return soapModel;
	}

	public static ArticleConfigSoap[] toSoapModels(ArticleConfig[] models) {
		ArticleConfigSoap[] soapModels = new ArticleConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleConfigSoap[][] toSoapModels(ArticleConfig[][] models) {
		ArticleConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticleConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleConfigSoap[] toSoapModels(List<ArticleConfig> models) {
		List<ArticleConfigSoap> soapModels = new ArrayList<ArticleConfigSoap>(
			models.size());

		for (ArticleConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleConfigSoap[soapModels.size()]);
	}

	public ArticleConfigSoap() {
	}

	public long getPrimaryKey() {
		return _articleConfigId;
	}

	public void setPrimaryKey(long pk) {
		setArticleConfigId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getArticleConfigId() {
		return _articleConfigId;
	}

	public void setArticleConfigId(long articleConfigId) {
		_articleConfigId = articleConfigId;
	}

	private String _uuid;
	private long _articleConfigId;

}