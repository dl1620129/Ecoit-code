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
 * This class is used by SOAP remote services, specifically {@link com.ecoit.elegaldocument.service.http.LegalDocumentServiceSoap}.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDocumentSoap implements Serializable {

	public static LegalDocumentSoap toSoapModel(LegalDocument model) {
		LegalDocumentSoap soapModel = new LegalDocumentSoap();

		soapModel.setDocId(model.getDocId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setForwardedByUser(model.getForwardedByUser());
		soapModel.setForwardedDate(model.getForwardedDate());
		soapModel.setPublishedByUser(model.getPublishedByUser());
		soapModel.setPublishedDate(model.getPublishedDate());
		soapModel.setSymbol(model.getSymbol());
		soapModel.setNum(model.getNum());
		soapModel.setPromulDate(model.getPromulDate());
		soapModel.setEffectivedDate(model.getEffectivedDate());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setReplaceDoc(model.getReplaceDoc());
		soapModel.setSummary(model.getSummary());
		soapModel.setContent(model.getContent());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setUserHit(model.getUserHit());
		soapModel.setStatusDoc(model.getStatusDoc());
		soapModel.setIsPublic(model.getIsPublic());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setFieldId(model.getFieldId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setOrgRels(model.getOrgRels());
		soapModel.setSignerRels(model.getSignerRels());
		soapModel.setFieldRels(model.getFieldRels());
		soapModel.setNumRels(model.getNumRels());
		soapModel.setDocCode(model.getDocCode());
		soapModel.setDepartmentRels(model.getDepartmentRels());
		soapModel.setSignerName(model.getSignerName());
		soapModel.setNgayDangCongBao(model.getNgayDangCongBao());
		soapModel.setSoCongBao(model.getSoCongBao());
		soapModel.setLevelValidityId(model.getLevelValidityId());
		soapModel.setTags(model.getTags());
		soapModel.setDocRelation(model.getDocRelation());
		soapModel.setNewGopY(model.isNewGopY());
		soapModel.setView(model.getView());

		return soapModel;
	}

	public static LegalDocumentSoap[] toSoapModels(LegalDocument[] models) {
		LegalDocumentSoap[] soapModels = new LegalDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegalDocumentSoap[][] toSoapModels(LegalDocument[][] models) {
		LegalDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegalDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegalDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegalDocumentSoap[] toSoapModels(List<LegalDocument> models) {
		List<LegalDocumentSoap> soapModels = new ArrayList<LegalDocumentSoap>(
			models.size());

		for (LegalDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegalDocumentSoap[soapModels.size()]);
	}

	public LegalDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _docId;
	}

	public void setPrimaryKey(long pk) {
		setDocId(pk);
	}

	public long getDocId() {
		return _docId;
	}

	public void setDocId(long docId) {
		_docId = docId;
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

	public long getForwardedByUser() {
		return _forwardedByUser;
	}

	public void setForwardedByUser(long forwardedByUser) {
		_forwardedByUser = forwardedByUser;
	}

	public Date getForwardedDate() {
		return _forwardedDate;
	}

	public void setForwardedDate(Date forwardedDate) {
		_forwardedDate = forwardedDate;
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

	public String getSymbol() {
		return _symbol;
	}

	public void setSymbol(String symbol) {
		_symbol = symbol;
	}

	public String getNum() {
		return _num;
	}

	public void setNum(String num) {
		_num = num;
	}

	public Date getPromulDate() {
		return _promulDate;
	}

	public void setPromulDate(Date promulDate) {
		_promulDate = promulDate;
	}

	public Date getEffectivedDate() {
		return _effectivedDate;
	}

	public void setEffectivedDate(Date effectivedDate) {
		_effectivedDate = effectivedDate;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public String getReplaceDoc() {
		return _replaceDoc;
	}

	public void setReplaceDoc(String replaceDoc) {
		_replaceDoc = replaceDoc;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public int getUserHit() {
		return _userHit;
	}

	public void setUserHit(int userHit) {
		_userHit = userHit;
	}

	public int getStatusDoc() {
		return _statusDoc;
	}

	public void setStatusDoc(int statusDoc) {
		_statusDoc = statusDoc;
	}

	public int getIsPublic() {
		return _isPublic;
	}

	public void setIsPublic(int isPublic) {
		_isPublic = isPublic;
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

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getOrgRels() {
		return _orgRels;
	}

	public void setOrgRels(String orgRels) {
		_orgRels = orgRels;
	}

	public String getSignerRels() {
		return _signerRels;
	}

	public void setSignerRels(String signerRels) {
		_signerRels = signerRels;
	}

	public String getFieldRels() {
		return _fieldRels;
	}

	public void setFieldRels(String fieldRels) {
		_fieldRels = fieldRels;
	}

	public String getNumRels() {
		return _numRels;
	}

	public void setNumRels(String numRels) {
		_numRels = numRels;
	}

	public String getDocCode() {
		return _docCode;
	}

	public void setDocCode(String docCode) {
		_docCode = docCode;
	}

	public String getDepartmentRels() {
		return _departmentRels;
	}

	public void setDepartmentRels(String departmentRels) {
		_departmentRels = departmentRels;
	}

	public String getSignerName() {
		return _signerName;
	}

	public void setSignerName(String signerName) {
		_signerName = signerName;
	}

	public Date getNgayDangCongBao() {
		return _ngayDangCongBao;
	}

	public void setNgayDangCongBao(Date ngayDangCongBao) {
		_ngayDangCongBao = ngayDangCongBao;
	}

	public String getSoCongBao() {
		return _soCongBao;
	}

	public void setSoCongBao(String soCongBao) {
		_soCongBao = soCongBao;
	}

	public long getLevelValidityId() {
		return _levelValidityId;
	}

	public void setLevelValidityId(long levelValidityId) {
		_levelValidityId = levelValidityId;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	public String getDocRelation() {
		return _docRelation;
	}

	public void setDocRelation(String docRelation) {
		_docRelation = docRelation;
	}

	public boolean getNewGopY() {
		return _newGopY;
	}

	public boolean isNewGopY() {
		return _newGopY;
	}

	public void setNewGopY(boolean newGopY) {
		_newGopY = newGopY;
	}

	public long getView() {
		return _view;
	}

	public void setView(long view) {
		_view = view;
	}

	private long _docId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _createdByUser;
	private Date _createdDate;
	private long _modifiedByUser;
	private Date _modifiedDate;
	private long _approvedByUser;
	private Date _approvedDate;
	private long _forwardedByUser;
	private Date _forwardedDate;
	private long _publishedByUser;
	private Date _publishedDate;
	private String _symbol;
	private String _num;
	private Date _promulDate;
	private Date _effectivedDate;
	private Date _expiredDate;
	private String _replaceDoc;
	private String _summary;
	private String _content;
	private String _language;
	private int _userHit;
	private int _statusDoc;
	private int _isPublic;
	private long _typeId;
	private long _fieldId;
	private long _organizationId;
	private String _orgRels;
	private String _signerRels;
	private String _fieldRels;
	private String _numRels;
	private String _docCode;
	private String _departmentRels;
	private String _signerName;
	private Date _ngayDangCongBao;
	private String _soCongBao;
	private long _levelValidityId;
	private String _tags;
	private String _docRelation;
	private boolean _newGopY;
	private long _view;

}