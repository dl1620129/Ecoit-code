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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDraftDocumentServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDraftDocumentSoap implements Serializable {

	public static LegalDraftDocumentSoap toSoapModel(LegalDraftDocument model) {
		LegalDraftDocumentSoap soapModel = new LegalDraftDocumentSoap();

		soapModel.setDraftId(model.getDraftId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setPublishedByUser(model.getPublishedByUser());
		soapModel.setPublishedDate(model.getPublishedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setContent(model.getContent());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setDraftLevel(model.getDraftLevel());
		soapModel.setDocCode(model.getDocCode());
		soapModel.setStatusDraft(model.getStatusDraft());
		soapModel.setEmail(model.getEmail());
		soapModel.setDestination(model.getDestination());

		return soapModel;
	}

	public static LegalDraftDocumentSoap[] toSoapModels(
		LegalDraftDocument[] models) {

		LegalDraftDocumentSoap[] soapModels =
			new LegalDraftDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDraftDocumentSoap[][] toSoapModels(
		LegalDraftDocument[][] models) {

		LegalDraftDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LegalDraftDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDraftDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDraftDocumentSoap[] toSoapModels(
		List<LegalDraftDocument> models) {

		List<LegalDraftDocumentSoap> soapModels =
			new ArrayList<LegalDraftDocumentSoap>(models.size());

		for (LegalDraftDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new LegalDraftDocumentSoap[soapModels.size()]);
	}

	public LegalDraftDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _draftId;
	}

	public void setPrimaryKey(long pk) {
		setDraftId(pk);
	}

	public long getDraftId() {
		return _draftId;
	}

	public void setDraftId(long draftId) {
		_draftId = draftId;
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

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getApprovedByUser() {
		return _approvedByUser;
	}

	public void setApprovedByUser(long approvedByUser) {
		_approvedByUser = approvedByUser;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public long getPublishedByUser() {
		return _publishedByUser;
	}

	public void setPublishedByUser(long publishedByUser) {
		_publishedByUser = publishedByUser;
	}

	public Date getPublishedDate() {
		return _publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		_publishedDate = publishedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public long getFieldId() {
		return _fieldId;
	}

	public void setFieldId(long fieldId) {
		_fieldId = fieldId;
	}

	public int getDraftLevel() {
		return _draftLevel;
	}

	public void setDraftLevel(int draftLevel) {
		_draftLevel = draftLevel;
	}

	public String getDocCode() {
		return _docCode;
	}

	public void setDocCode(String docCode) {
		_docCode = docCode;
	}

	public int getStatusDraft() {
		return _statusDraft;
	}

	public void setStatusDraft(int statusDraft) {
		_statusDraft = statusDraft;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDestination() {
		return _destination;
	}

	public void setDestination(String destination) {
		_destination = destination;
	}

	private long _draftId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _createdByUser;
	private Date _createdDate;
	private long _modifiedByUser;
	private Date _modifiedDate;
	private long _approvedByUser;
	private Date _approvedDate;
	private long _publishedByUser;
	private Date _publishedDate;
	private String _title;
	private Date _expiredDate;
	private String _language;
	private String _content;
	private long _typeId;
	private long _fieldId;
	private int _draftLevel;
	private String _docCode;
	private int _statusDraft;
	private String _email;
	private String _destination;

}