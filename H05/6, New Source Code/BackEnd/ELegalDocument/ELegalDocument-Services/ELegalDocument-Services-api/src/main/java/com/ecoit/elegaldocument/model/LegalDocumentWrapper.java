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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegalDocument}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDocument
 * @generated
 */
public class LegalDocumentWrapper
	extends BaseModelWrapper<LegalDocument>
	implements LegalDocument, ModelWrapper<LegalDocument> {

	public LegalDocumentWrapper(LegalDocument legalDocument) {
		super(legalDocument);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("docId", getDocId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("approvedByUser", getApprovedByUser());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("forwardedByUser", getForwardedByUser());
		attributes.put("forwardedDate", getForwardedDate());
		attributes.put("publishedByUser", getPublishedByUser());
		attributes.put("publishedDate", getPublishedDate());
		attributes.put("symbol", getSymbol());
		attributes.put("num", getNum());
		attributes.put("promulDate", getPromulDate());
		attributes.put("effectivedDate", getEffectivedDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("replaceDoc", getReplaceDoc());
		attributes.put("summary", getSummary());
		attributes.put("content", getContent());
		attributes.put("language", getLanguage());
		attributes.put("userHit", getUserHit());
		attributes.put("statusDoc", getStatusDoc());
		attributes.put("isPublic", getIsPublic());
		attributes.put("typeId", getTypeId());
		attributes.put("fieldId", getFieldId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("orgRels", getOrgRels());
		attributes.put("signerRels", getSignerRels());
		attributes.put("fieldRels", getFieldRels());
		attributes.put("numRels", getNumRels());
		attributes.put("docCode", getDocCode());
		attributes.put("departmentRels", getDepartmentRels());
		attributes.put("signerName", getSignerName());
		attributes.put("ngayDangCongBao", getNgayDangCongBao());
		attributes.put("soCongBao", getSoCongBao());
		attributes.put("levelValidityId", getLevelValidityId());
		attributes.put("tags", getTags());
		attributes.put("docRelation", getDocRelation());
		attributes.put("newGopY", isNewGopY());
		attributes.put("view", getView());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createdByUser = (Long)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long approvedByUser = (Long)attributes.get("approvedByUser");

		if (approvedByUser != null) {
			setApprovedByUser(approvedByUser);
		}

		Date approvedDate = (Date)attributes.get("approvedDate");

		if (approvedDate != null) {
			setApprovedDate(approvedDate);
		}

		Long forwardedByUser = (Long)attributes.get("forwardedByUser");

		if (forwardedByUser != null) {
			setForwardedByUser(forwardedByUser);
		}

		Date forwardedDate = (Date)attributes.get("forwardedDate");

		if (forwardedDate != null) {
			setForwardedDate(forwardedDate);
		}

		Long publishedByUser = (Long)attributes.get("publishedByUser");

		if (publishedByUser != null) {
			setPublishedByUser(publishedByUser);
		}

		Date publishedDate = (Date)attributes.get("publishedDate");

		if (publishedDate != null) {
			setPublishedDate(publishedDate);
		}

		String symbol = (String)attributes.get("symbol");

		if (symbol != null) {
			setSymbol(symbol);
		}

		String num = (String)attributes.get("num");

		if (num != null) {
			setNum(num);
		}

		Date promulDate = (Date)attributes.get("promulDate");

		if (promulDate != null) {
			setPromulDate(promulDate);
		}

		Date effectivedDate = (Date)attributes.get("effectivedDate");

		if (effectivedDate != null) {
			setEffectivedDate(effectivedDate);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}

		String replaceDoc = (String)attributes.get("replaceDoc");

		if (replaceDoc != null) {
			setReplaceDoc(replaceDoc);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Integer userHit = (Integer)attributes.get("userHit");

		if (userHit != null) {
			setUserHit(userHit);
		}

		Integer statusDoc = (Integer)attributes.get("statusDoc");

		if (statusDoc != null) {
			setStatusDoc(statusDoc);
		}

		Integer isPublic = (Integer)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String orgRels = (String)attributes.get("orgRels");

		if (orgRels != null) {
			setOrgRels(orgRels);
		}

		String signerRels = (String)attributes.get("signerRels");

		if (signerRels != null) {
			setSignerRels(signerRels);
		}

		String fieldRels = (String)attributes.get("fieldRels");

		if (fieldRels != null) {
			setFieldRels(fieldRels);
		}

		String numRels = (String)attributes.get("numRels");

		if (numRels != null) {
			setNumRels(numRels);
		}

		String docCode = (String)attributes.get("docCode");

		if (docCode != null) {
			setDocCode(docCode);
		}

		String departmentRels = (String)attributes.get("departmentRels");

		if (departmentRels != null) {
			setDepartmentRels(departmentRels);
		}

		String signerName = (String)attributes.get("signerName");

		if (signerName != null) {
			setSignerName(signerName);
		}

		Date ngayDangCongBao = (Date)attributes.get("ngayDangCongBao");

		if (ngayDangCongBao != null) {
			setNgayDangCongBao(ngayDangCongBao);
		}

		String soCongBao = (String)attributes.get("soCongBao");

		if (soCongBao != null) {
			setSoCongBao(soCongBao);
		}

		Long levelValidityId = (Long)attributes.get("levelValidityId");

		if (levelValidityId != null) {
			setLevelValidityId(levelValidityId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String docRelation = (String)attributes.get("docRelation");

		if (docRelation != null) {
			setDocRelation(docRelation);
		}

		Boolean newGopY = (Boolean)attributes.get("newGopY");

		if (newGopY != null) {
			setNewGopY(newGopY);
		}

		Long view = (Long)attributes.get("view");

		if (view != null) {
			setView(view);
		}
	}

	/**
	 * Returns the approved by user of this legal document.
	 *
	 * @return the approved by user of this legal document
	 */
	@Override
	public long getApprovedByUser() {
		return model.getApprovedByUser();
	}

	/**
	 * Returns the approved date of this legal document.
	 *
	 * @return the approved date of this legal document
	 */
	@Override
	public Date getApprovedDate() {
		return model.getApprovedDate();
	}

	/**
	 * Returns the company ID of this legal document.
	 *
	 * @return the company ID of this legal document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this legal document.
	 *
	 * @return the content of this legal document
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by user of this legal document.
	 *
	 * @return the created by user of this legal document
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this legal document.
	 *
	 * @return the created date of this legal document
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the department rels of this legal document.
	 *
	 * @return the department rels of this legal document
	 */
	@Override
	public String getDepartmentRels() {
		return model.getDepartmentRels();
	}

	/**
	 * Returns the doc code of this legal document.
	 *
	 * @return the doc code of this legal document
	 */
	@Override
	public String getDocCode() {
		return model.getDocCode();
	}

	/**
	 * Returns the doc ID of this legal document.
	 *
	 * @return the doc ID of this legal document
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the doc relation of this legal document.
	 *
	 * @return the doc relation of this legal document
	 */
	@Override
	public String getDocRelation() {
		return model.getDocRelation();
	}

	/**
	 * Returns the effectived date of this legal document.
	 *
	 * @return the effectived date of this legal document
	 */
	@Override
	public Date getEffectivedDate() {
		return model.getEffectivedDate();
	}

	/**
	 * Returns the expired date of this legal document.
	 *
	 * @return the expired date of this legal document
	 */
	@Override
	public Date getExpiredDate() {
		return model.getExpiredDate();
	}

	/**
	 * Returns the field ID of this legal document.
	 *
	 * @return the field ID of this legal document
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the field rels of this legal document.
	 *
	 * @return the field rels of this legal document
	 */
	@Override
	public String getFieldRels() {
		return model.getFieldRels();
	}

	/**
	 * Returns the forwarded by user of this legal document.
	 *
	 * @return the forwarded by user of this legal document
	 */
	@Override
	public long getForwardedByUser() {
		return model.getForwardedByUser();
	}

	/**
	 * Returns the forwarded date of this legal document.
	 *
	 * @return the forwarded date of this legal document
	 */
	@Override
	public Date getForwardedDate() {
		return model.getForwardedDate();
	}

	/**
	 * Returns the group ID of this legal document.
	 *
	 * @return the group ID of this legal document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is public of this legal document.
	 *
	 * @return the is public of this legal document
	 */
	@Override
	public int getIsPublic() {
		return model.getIsPublic();
	}

	/**
	 * Returns the language of this legal document.
	 *
	 * @return the language of this legal document
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the level validity ID of this legal document.
	 *
	 * @return the level validity ID of this legal document
	 */
	@Override
	public long getLevelValidityId() {
		return model.getLevelValidityId();
	}

	/**
	 * Returns the modified by user of this legal document.
	 *
	 * @return the modified by user of this legal document
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this legal document.
	 *
	 * @return the modified date of this legal document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the new gop y of this legal document.
	 *
	 * @return the new gop y of this legal document
	 */
	@Override
	public boolean getNewGopY() {
		return model.getNewGopY();
	}

	/**
	 * Returns the ngay dang cong bao of this legal document.
	 *
	 * @return the ngay dang cong bao of this legal document
	 */
	@Override
	public Date getNgayDangCongBao() {
		return model.getNgayDangCongBao();
	}

	/**
	 * Returns the num of this legal document.
	 *
	 * @return the num of this legal document
	 */
	@Override
	public String getNum() {
		return model.getNum();
	}

	/**
	 * Returns the num rels of this legal document.
	 *
	 * @return the num rels of this legal document
	 */
	@Override
	public String getNumRels() {
		return model.getNumRels();
	}

	/**
	 * Returns the organization ID of this legal document.
	 *
	 * @return the organization ID of this legal document
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the org rels of this legal document.
	 *
	 * @return the org rels of this legal document
	 */
	@Override
	public String getOrgRels() {
		return model.getOrgRels();
	}

	/**
	 * Returns the primary key of this legal document.
	 *
	 * @return the primary key of this legal document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promul date of this legal document.
	 *
	 * @return the promul date of this legal document
	 */
	@Override
	public Date getPromulDate() {
		return model.getPromulDate();
	}

	/**
	 * Returns the published by user of this legal document.
	 *
	 * @return the published by user of this legal document
	 */
	@Override
	public long getPublishedByUser() {
		return model.getPublishedByUser();
	}

	/**
	 * Returns the published date of this legal document.
	 *
	 * @return the published date of this legal document
	 */
	@Override
	public Date getPublishedDate() {
		return model.getPublishedDate();
	}

	/**
	 * Returns the replace doc of this legal document.
	 *
	 * @return the replace doc of this legal document
	 */
	@Override
	public String getReplaceDoc() {
		return model.getReplaceDoc();
	}

	/**
	 * Returns the signer name of this legal document.
	 *
	 * @return the signer name of this legal document
	 */
	@Override
	public String getSignerName() {
		return model.getSignerName();
	}

	/**
	 * Returns the signer rels of this legal document.
	 *
	 * @return the signer rels of this legal document
	 */
	@Override
	public String getSignerRels() {
		return model.getSignerRels();
	}

	/**
	 * Returns the so cong bao of this legal document.
	 *
	 * @return the so cong bao of this legal document
	 */
	@Override
	public String getSoCongBao() {
		return model.getSoCongBao();
	}

	/**
	 * Returns the status doc of this legal document.
	 *
	 * @return the status doc of this legal document
	 */
	@Override
	public int getStatusDoc() {
		return model.getStatusDoc();
	}

	/**
	 * Returns the summary of this legal document.
	 *
	 * @return the summary of this legal document
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the symbol of this legal document.
	 *
	 * @return the symbol of this legal document
	 */
	@Override
	public String getSymbol() {
		return model.getSymbol();
	}

	/**
	 * Returns the tags of this legal document.
	 *
	 * @return the tags of this legal document
	 */
	@Override
	public String getTags() {
		return model.getTags();
	}

	/**
	 * Returns the type ID of this legal document.
	 *
	 * @return the type ID of this legal document
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user hit of this legal document.
	 *
	 * @return the user hit of this legal document
	 */
	@Override
	public int getUserHit() {
		return model.getUserHit();
	}

	/**
	 * Returns the user ID of this legal document.
	 *
	 * @return the user ID of this legal document
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this legal document.
	 *
	 * @return the user uuid of this legal document
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the view of this legal document.
	 *
	 * @return the view of this legal document
	 */
	@Override
	public long getView() {
		return model.getView();
	}

	/**
	 * Returns <code>true</code> if this legal document is new gop y.
	 *
	 * @return <code>true</code> if this legal document is new gop y; <code>false</code> otherwise
	 */
	@Override
	public boolean isNewGopY() {
		return model.isNewGopY();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the approved by user of this legal document.
	 *
	 * @param approvedByUser the approved by user of this legal document
	 */
	@Override
	public void setApprovedByUser(long approvedByUser) {
		model.setApprovedByUser(approvedByUser);
	}

	/**
	 * Sets the approved date of this legal document.
	 *
	 * @param approvedDate the approved date of this legal document
	 */
	@Override
	public void setApprovedDate(Date approvedDate) {
		model.setApprovedDate(approvedDate);
	}

	/**
	 * Sets the company ID of this legal document.
	 *
	 * @param companyId the company ID of this legal document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this legal document.
	 *
	 * @param content the content of this legal document
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by user of this legal document.
	 *
	 * @param createdByUser the created by user of this legal document
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this legal document.
	 *
	 * @param createdDate the created date of this legal document
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the department rels of this legal document.
	 *
	 * @param departmentRels the department rels of this legal document
	 */
	@Override
	public void setDepartmentRels(String departmentRels) {
		model.setDepartmentRels(departmentRels);
	}

	/**
	 * Sets the doc code of this legal document.
	 *
	 * @param docCode the doc code of this legal document
	 */
	@Override
	public void setDocCode(String docCode) {
		model.setDocCode(docCode);
	}

	/**
	 * Sets the doc ID of this legal document.
	 *
	 * @param docId the doc ID of this legal document
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the doc relation of this legal document.
	 *
	 * @param docRelation the doc relation of this legal document
	 */
	@Override
	public void setDocRelation(String docRelation) {
		model.setDocRelation(docRelation);
	}

	/**
	 * Sets the effectived date of this legal document.
	 *
	 * @param effectivedDate the effectived date of this legal document
	 */
	@Override
	public void setEffectivedDate(Date effectivedDate) {
		model.setEffectivedDate(effectivedDate);
	}

	/**
	 * Sets the expired date of this legal document.
	 *
	 * @param expiredDate the expired date of this legal document
	 */
	@Override
	public void setExpiredDate(Date expiredDate) {
		model.setExpiredDate(expiredDate);
	}

	/**
	 * Sets the field ID of this legal document.
	 *
	 * @param fieldId the field ID of this legal document
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the field rels of this legal document.
	 *
	 * @param fieldRels the field rels of this legal document
	 */
	@Override
	public void setFieldRels(String fieldRels) {
		model.setFieldRels(fieldRels);
	}

	/**
	 * Sets the forwarded by user of this legal document.
	 *
	 * @param forwardedByUser the forwarded by user of this legal document
	 */
	@Override
	public void setForwardedByUser(long forwardedByUser) {
		model.setForwardedByUser(forwardedByUser);
	}

	/**
	 * Sets the forwarded date of this legal document.
	 *
	 * @param forwardedDate the forwarded date of this legal document
	 */
	@Override
	public void setForwardedDate(Date forwardedDate) {
		model.setForwardedDate(forwardedDate);
	}

	/**
	 * Sets the group ID of this legal document.
	 *
	 * @param groupId the group ID of this legal document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is public of this legal document.
	 *
	 * @param isPublic the is public of this legal document
	 */
	@Override
	public void setIsPublic(int isPublic) {
		model.setIsPublic(isPublic);
	}

	/**
	 * Sets the language of this legal document.
	 *
	 * @param language the language of this legal document
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the level validity ID of this legal document.
	 *
	 * @param levelValidityId the level validity ID of this legal document
	 */
	@Override
	public void setLevelValidityId(long levelValidityId) {
		model.setLevelValidityId(levelValidityId);
	}

	/**
	 * Sets the modified by user of this legal document.
	 *
	 * @param modifiedByUser the modified by user of this legal document
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this legal document.
	 *
	 * @param modifiedDate the modified date of this legal document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this legal document is new gop y.
	 *
	 * @param newGopY the new gop y of this legal document
	 */
	@Override
	public void setNewGopY(boolean newGopY) {
		model.setNewGopY(newGopY);
	}

	/**
	 * Sets the ngay dang cong bao of this legal document.
	 *
	 * @param ngayDangCongBao the ngay dang cong bao of this legal document
	 */
	@Override
	public void setNgayDangCongBao(Date ngayDangCongBao) {
		model.setNgayDangCongBao(ngayDangCongBao);
	}

	/**
	 * Sets the num of this legal document.
	 *
	 * @param num the num of this legal document
	 */
	@Override
	public void setNum(String num) {
		model.setNum(num);
	}

	/**
	 * Sets the num rels of this legal document.
	 *
	 * @param numRels the num rels of this legal document
	 */
	@Override
	public void setNumRels(String numRels) {
		model.setNumRels(numRels);
	}

	/**
	 * Sets the organization ID of this legal document.
	 *
	 * @param organizationId the organization ID of this legal document
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the org rels of this legal document.
	 *
	 * @param orgRels the org rels of this legal document
	 */
	@Override
	public void setOrgRels(String orgRels) {
		model.setOrgRels(orgRels);
	}

	/**
	 * Sets the primary key of this legal document.
	 *
	 * @param primaryKey the primary key of this legal document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promul date of this legal document.
	 *
	 * @param promulDate the promul date of this legal document
	 */
	@Override
	public void setPromulDate(Date promulDate) {
		model.setPromulDate(promulDate);
	}

	/**
	 * Sets the published by user of this legal document.
	 *
	 * @param publishedByUser the published by user of this legal document
	 */
	@Override
	public void setPublishedByUser(long publishedByUser) {
		model.setPublishedByUser(publishedByUser);
	}

	/**
	 * Sets the published date of this legal document.
	 *
	 * @param publishedDate the published date of this legal document
	 */
	@Override
	public void setPublishedDate(Date publishedDate) {
		model.setPublishedDate(publishedDate);
	}

	/**
	 * Sets the replace doc of this legal document.
	 *
	 * @param replaceDoc the replace doc of this legal document
	 */
	@Override
	public void setReplaceDoc(String replaceDoc) {
		model.setReplaceDoc(replaceDoc);
	}

	/**
	 * Sets the signer name of this legal document.
	 *
	 * @param signerName the signer name of this legal document
	 */
	@Override
	public void setSignerName(String signerName) {
		model.setSignerName(signerName);
	}

	/**
	 * Sets the signer rels of this legal document.
	 *
	 * @param signerRels the signer rels of this legal document
	 */
	@Override
	public void setSignerRels(String signerRels) {
		model.setSignerRels(signerRels);
	}

	/**
	 * Sets the so cong bao of this legal document.
	 *
	 * @param soCongBao the so cong bao of this legal document
	 */
	@Override
	public void setSoCongBao(String soCongBao) {
		model.setSoCongBao(soCongBao);
	}

	/**
	 * Sets the status doc of this legal document.
	 *
	 * @param statusDoc the status doc of this legal document
	 */
	@Override
	public void setStatusDoc(int statusDoc) {
		model.setStatusDoc(statusDoc);
	}

	/**
	 * Sets the summary of this legal document.
	 *
	 * @param summary the summary of this legal document
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the symbol of this legal document.
	 *
	 * @param symbol the symbol of this legal document
	 */
	@Override
	public void setSymbol(String symbol) {
		model.setSymbol(symbol);
	}

	/**
	 * Sets the tags of this legal document.
	 *
	 * @param tags the tags of this legal document
	 */
	@Override
	public void setTags(String tags) {
		model.setTags(tags);
	}

	/**
	 * Sets the type ID of this legal document.
	 *
	 * @param typeId the type ID of this legal document
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user hit of this legal document.
	 *
	 * @param userHit the user hit of this legal document
	 */
	@Override
	public void setUserHit(int userHit) {
		model.setUserHit(userHit);
	}

	/**
	 * Sets the user ID of this legal document.
	 *
	 * @param userId the user ID of this legal document
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this legal document.
	 *
	 * @param userUuid the user uuid of this legal document
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the view of this legal document.
	 *
	 * @param view the view of this legal document
	 */
	@Override
	public void setView(long view) {
		model.setView(view);
	}

	@Override
	protected LegalDocumentWrapper wrap(LegalDocument legalDocument) {
		return new LegalDocumentWrapper(legalDocument);
	}

}