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

package com.ecoit.qa.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.qa.service.service.http.AnswerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnswerSoap implements Serializable {

	public static AnswerSoap toSoapModel(Answer model) {
		AnswerSoap soapModel = new AnswerSoap();

		soapModel.setAnswerId(model.getAnswerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setContent(model.getContent());
		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setQuestionId(model.getQuestionId());

		return soapModel;
	}

	public static AnswerSoap[] toSoapModels(Answer[] models) {
		AnswerSoap[] soapModels = new AnswerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnswerSoap[][] toSoapModels(Answer[][] models) {
		AnswerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnswerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnswerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnswerSoap[] toSoapModels(List<Answer> models) {
		List<AnswerSoap> soapModels = new ArrayList<AnswerSoap>(models.size());

		for (Answer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnswerSoap[soapModels.size()]);
	}

	public AnswerSoap() {
	}

	public long getPrimaryKey() {
		return _answerId;
	}

	public void setPrimaryKey(long pk) {
		setAnswerId(pk);
	}

	public long getAnswerId() {
		return _answerId;
	}

	public void setAnswerId(long answerId) {
		_answerId = answerId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	private long _answerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _createdByUser;
	private Date _modifiedDate;
	private long _modifiedByUser;
	private String _content;
	private long _attachmentId;
	private long _questionId;

}