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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.ArticleMessageServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class ArticleMessageSoap implements Serializable {

	public static ArticleMessageSoap toSoapModel(ArticleMessage model) {
		ArticleMessageSoap soapModel = new ArticleMessageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setContent(model.getContent());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static ArticleMessageSoap[] toSoapModels(ArticleMessage[] models) {
		ArticleMessageSoap[] soapModels = new ArticleMessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleMessageSoap[][] toSoapModels(
		ArticleMessage[][] models) {

		ArticleMessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ArticleMessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleMessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleMessageSoap[] toSoapModels(
		List<ArticleMessage> models) {

		List<ArticleMessageSoap> soapModels = new ArrayList<ArticleMessageSoap>(
			models.size());

		for (ArticleMessage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleMessageSoap[soapModels.size()]);
	}

	public ArticleMessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private String _uuid;
	private long _messageId;
	private String _content;
	private long _articleId;
	private long _createdByUser;
	private Date _createdDate;

}