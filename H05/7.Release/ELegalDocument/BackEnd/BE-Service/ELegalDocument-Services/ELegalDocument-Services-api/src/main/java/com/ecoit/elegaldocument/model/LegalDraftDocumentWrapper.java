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
 * This class is a wrapper for {@link LegalDraftDocument}.
 * </p>
 *
 * @author Liverpool
 * @see LegalDraftDocument
 * @generated
 */
public class LegalDraftDocumentWrapper
	extends BaseModelWrapper<LegalDraftDocument>
	implements LegalDraftDocument, ModelWrapper<LegalDraftDocument> {

	public LegalDraftDocumentWrapper(LegalDraftDocument legalDraftDocument) {
		super(legalDraftDocument);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("draftId", getDraftId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("approvedByUser", getApprovedByUser());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("publishedByUser", getPublishedByUser());
		attributes.put("publishedDate", getPublishedDate());
		attributes.put("title", getTitle());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("language", getLanguage());
		attributes.put("content", getContent());
		attributes.put("typeId", getTypeId());
		attributes.put("fieldId", getFieldId());
		attributes.put("draftLevel", getDraftLevel());
		attributes.put("docCode", getDocCode());
		attributes.put("statusDraft", getStatusDraft());
		attributes.put("email", getEmail());
		attributes.put("destination", getDestination());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long draftId = (Long)attributes.get("draftId");

		if (draftId != null) {
			setDraftId(draftId);
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

		Long publishedByUser = (Long)attributes.get("publishedByUser");

		if (publishedByUser != null) {
			setPublishedByUser(publishedByUser);
		}

		Date publishedDate = (Date)attributes.get("publishedDate");

		if (publishedDate != null) {
			setPublishedDate(publishedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		Integer draftLevel = (Integer)attributes.get("draftLevel");

		if (draftLevel != null) {
			setDraftLevel(draftLevel);
		}

		String docCode = (String)attributes.get("docCode");

		if (docCode != null) {
			setDocCode(docCode);
		}

		Integer statusDraft = (Integer)attributes.get("statusDraft");

		if (statusDraft != null) {
			setStatusDraft(statusDraft);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String destination = (String)attributes.get("destination");

		if (destination != null) {
			setDestination(destination);
		}
	}

	/**
	 * Returns the approved by user of this legal draft document.
	 *
	 * @return the approved by user of this legal draft document
	 */
	@Override
	public long getApprovedByUser() {
		return model.getApprovedByUser();
	}

	/**
	 * Returns the approved date of this legal draft document.
	 *
	 * @return the approved date of this legal draft document
	 */
	@Override
	public Date getApprovedDate() {
		return model.getApprovedDate();
	}

	/**
	 * Returns the company ID of this legal draft document.
	 *
	 * @return the company ID of this legal draft document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this legal draft document.
	 *
	 * @return the content of this legal draft document
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by user of this legal draft document.
	 *
	 * @return the created by user of this legal draft document
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this legal draft document.
	 *
	 * @return the created date of this legal draft document
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the destination of this legal draft document.
	 *
	 * @return the destination of this legal draft document
	 */
	@Override
	public String getDestination() {
		return model.getDestination();
	}

	/**
	 * Returns the doc code of this legal draft document.
	 *
	 * @return the doc code of this legal draft document
	 */
	@Override
	public String getDocCode() {
		return model.getDocCode();
	}

	/**
	 * Returns the draft ID of this legal draft document.
	 *
	 * @return the draft ID of this legal draft document
	 */
	@Override
	public long getDraftId() {
		return model.getDraftId();
	}

	/**
	 * Returns the draft level of this legal draft document.
	 *
	 * @return the draft level of this legal draft document
	 */
	@Override
	public int getDraftLevel() {
		return model.getDraftLevel();
	}

	/**
	 * Returns the email of this legal draft document.
	 *
	 * @return the email of this legal draft document
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the expired date of this legal draft document.
	 *
	 * @return the expired date of this legal draft document
	 */
	@Override
	public Date getExpiredDate() {
		return model.getExpiredDate();
	}

	/**
	 * Returns the field ID of this legal draft document.
	 *
	 * @return the field ID of this legal draft document
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the group ID of this legal draft document.
	 *
	 * @return the group ID of this legal draft document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this legal draft document.
	 *
	 * @return the language of this legal draft document
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the modified by user of this legal draft document.
	 *
	 * @return the modified by user of this legal draft document
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this legal draft document.
	 *
	 * @return the modified date of this legal draft document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this legal draft document.
	 *
	 * @return the primary key of this legal draft document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the published by user of this legal draft document.
	 *
	 * @return the published by user of this legal draft document
	 */
	@Override
	public long getPublishedByUser() {
		return model.getPublishedByUser();
	}

	/**
	 * Returns the published date of this legal draft document.
	 *
	 * @return the published date of this legal draft document
	 */
	@Override
	public Date getPublishedDate() {
		return model.getPublishedDate();
	}

	/**
	 * Returns the status draft of this legal draft document.
	 *
	 * @return the status draft of this legal draft document
	 */
	@Override
	public int getStatusDraft() {
		return model.getStatusDraft();
	}

	/**
	 * Returns the title of this legal draft document.
	 *
	 * @return the title of this legal draft document
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type ID of this legal draft document.
	 *
	 * @return the type ID of this legal draft document
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user ID of this legal draft document.
	 *
	 * @return the user ID of this legal draft document
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this legal draft document.
	 *
	 * @return the user uuid of this legal draft document
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the approved by user of this legal draft document.
	 *
	 * @param approvedByUser the approved by user of this legal draft document
	 */
	@Override
	public void setApprovedByUser(long approvedByUser) {
		model.setApprovedByUser(approvedByUser);
	}

	/**
	 * Sets the approved date of this legal draft document.
	 *
	 * @param approvedDate the approved date of this legal draft document
	 */
	@Override
	public void setApprovedDate(Date approvedDate) {
		model.setApprovedDate(approvedDate);
	}

	/**
	 * Sets the company ID of this legal draft document.
	 *
	 * @param companyId the company ID of this legal draft document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this legal draft document.
	 *
	 * @param content the content of this legal draft document
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by user of this legal draft document.
	 *
	 * @param createdByUser the created by user of this legal draft document
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this legal draft document.
	 *
	 * @param createdDate the created date of this legal draft document
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the destination of this legal draft document.
	 *
	 * @param destination the destination of this legal draft document
	 */
	@Override
	public void setDestination(String destination) {
		model.setDestination(destination);
	}

	/**
	 * Sets the doc code of this legal draft document.
	 *
	 * @param docCode the doc code of this legal draft document
	 */
	@Override
	public void setDocCode(String docCode) {
		model.setDocCode(docCode);
	}

	/**
	 * Sets the draft ID of this legal draft document.
	 *
	 * @param draftId the draft ID of this legal draft document
	 */
	@Override
	public void setDraftId(long draftId) {
		model.setDraftId(draftId);
	}

	/**
	 * Sets the draft level of this legal draft document.
	 *
	 * @param draftLevel the draft level of this legal draft document
	 */
	@Override
	public void setDraftLevel(int draftLevel) {
		model.setDraftLevel(draftLevel);
	}

	/**
	 * Sets the email of this legal draft document.
	 *
	 * @param email the email of this legal draft document
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the expired date of this legal draft document.
	 *
	 * @param expiredDate the expired date of this legal draft document
	 */
	@Override
	public void setExpiredDate(Date expiredDate) {
		model.setExpiredDate(expiredDate);
	}

	/**
	 * Sets the field ID of this legal draft document.
	 *
	 * @param fieldId the field ID of this legal draft document
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the group ID of this legal draft document.
	 *
	 * @param groupId the group ID of this legal draft document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this legal draft document.
	 *
	 * @param language the language of this legal draft document
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the modified by user of this legal draft document.
	 *
	 * @param modifiedByUser the modified by user of this legal draft document
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this legal draft document.
	 *
	 * @param modifiedDate the modified date of this legal draft document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this legal draft document.
	 *
	 * @param primaryKey the primary key of this legal draft document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the published by user of this legal draft document.
	 *
	 * @param publishedByUser the published by user of this legal draft document
	 */
	@Override
	public void setPublishedByUser(long publishedByUser) {
		model.setPublishedByUser(publishedByUser);
	}

	/**
	 * Sets the published date of this legal draft document.
	 *
	 * @param publishedDate the published date of this legal draft document
	 */
	@Override
	public void setPublishedDate(Date publishedDate) {
		model.setPublishedDate(publishedDate);
	}

	/**
	 * Sets the status draft of this legal draft document.
	 *
	 * @param statusDraft the status draft of this legal draft document
	 */
	@Override
	public void setStatusDraft(int statusDraft) {
		model.setStatusDraft(statusDraft);
	}

	/**
	 * Sets the title of this legal draft document.
	 *
	 * @param title the title of this legal draft document
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type ID of this legal draft document.
	 *
	 * @param typeId the type ID of this legal draft document
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this legal draft document.
	 *
	 * @param userId the user ID of this legal draft document
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this legal draft document.
	 *
	 * @param userUuid the user uuid of this legal draft document
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LegalDraftDocumentWrapper wrap(
		LegalDraftDocument legalDraftDocument) {

		return new LegalDraftDocumentWrapper(legalDraftDocument);
	}

}