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
 * This class is a wrapper for {@link LegalSuggestDocument}.
 * </p>
 *
 * @author Liverpool
 * @see LegalSuggestDocument
 * @generated
 */
public class LegalSuggestDocumentWrapper
	extends BaseModelWrapper<LegalSuggestDocument>
	implements LegalSuggestDocument, ModelWrapper<LegalSuggestDocument> {

	public LegalSuggestDocumentWrapper(
		LegalSuggestDocument legalSuggestDocument) {

		super(legalSuggestDocument);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sugId", getSugId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("approved", isApproved());
		attributes.put("approvedByUser", getApprovedByUser());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("language", getLanguage());
		attributes.put("visitorName", getVisitorName());
		attributes.put("visitorEmail", getVisitorEmail());
		attributes.put("visitorTel", getVisitorTel());
		attributes.put("visitorAddress", getVisitorAddress());
		attributes.put("docId", getDocId());
		attributes.put("hasAttachment", isHasAttachment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sugId = (Long)attributes.get("sugId");

		if (sugId != null) {
			setSugId(sugId);
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

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		Long approvedByUser = (Long)attributes.get("approvedByUser");

		if (approvedByUser != null) {
			setApprovedByUser(approvedByUser);
		}

		Date approvedDate = (Date)attributes.get("approvedDate");

		if (approvedDate != null) {
			setApprovedDate(approvedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String visitorName = (String)attributes.get("visitorName");

		if (visitorName != null) {
			setVisitorName(visitorName);
		}

		String visitorEmail = (String)attributes.get("visitorEmail");

		if (visitorEmail != null) {
			setVisitorEmail(visitorEmail);
		}

		String visitorTel = (String)attributes.get("visitorTel");

		if (visitorTel != null) {
			setVisitorTel(visitorTel);
		}

		String visitorAddress = (String)attributes.get("visitorAddress");

		if (visitorAddress != null) {
			setVisitorAddress(visitorAddress);
		}

		Long docId = (Long)attributes.get("docId");

		if (docId != null) {
			setDocId(docId);
		}

		Boolean hasAttachment = (Boolean)attributes.get("hasAttachment");

		if (hasAttachment != null) {
			setHasAttachment(hasAttachment);
		}
	}

	/**
	 * Returns the approved of this legal suggest document.
	 *
	 * @return the approved of this legal suggest document
	 */
	@Override
	public boolean getApproved() {
		return model.getApproved();
	}

	/**
	 * Returns the approved by user of this legal suggest document.
	 *
	 * @return the approved by user of this legal suggest document
	 */
	@Override
	public long getApprovedByUser() {
		return model.getApprovedByUser();
	}

	/**
	 * Returns the approved date of this legal suggest document.
	 *
	 * @return the approved date of this legal suggest document
	 */
	@Override
	public Date getApprovedDate() {
		return model.getApprovedDate();
	}

	/**
	 * Returns the company ID of this legal suggest document.
	 *
	 * @return the company ID of this legal suggest document
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this legal suggest document.
	 *
	 * @return the content of this legal suggest document
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created date of this legal suggest document.
	 *
	 * @return the created date of this legal suggest document
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the doc ID of this legal suggest document.
	 *
	 * @return the doc ID of this legal suggest document
	 */
	@Override
	public long getDocId() {
		return model.getDocId();
	}

	/**
	 * Returns the group ID of this legal suggest document.
	 *
	 * @return the group ID of this legal suggest document
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has attachment of this legal suggest document.
	 *
	 * @return the has attachment of this legal suggest document
	 */
	@Override
	public boolean getHasAttachment() {
		return model.getHasAttachment();
	}

	/**
	 * Returns the language of this legal suggest document.
	 *
	 * @return the language of this legal suggest document
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the modified by user of this legal suggest document.
	 *
	 * @return the modified by user of this legal suggest document
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this legal suggest document.
	 *
	 * @return the modified date of this legal suggest document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this legal suggest document.
	 *
	 * @return the primary key of this legal suggest document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sug ID of this legal suggest document.
	 *
	 * @return the sug ID of this legal suggest document
	 */
	@Override
	public long getSugId() {
		return model.getSugId();
	}

	/**
	 * Returns the title of this legal suggest document.
	 *
	 * @return the title of this legal suggest document
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this legal suggest document.
	 *
	 * @return the user ID of this legal suggest document
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this legal suggest document.
	 *
	 * @return the user uuid of this legal suggest document
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the visitor address of this legal suggest document.
	 *
	 * @return the visitor address of this legal suggest document
	 */
	@Override
	public String getVisitorAddress() {
		return model.getVisitorAddress();
	}

	/**
	 * Returns the visitor email of this legal suggest document.
	 *
	 * @return the visitor email of this legal suggest document
	 */
	@Override
	public String getVisitorEmail() {
		return model.getVisitorEmail();
	}

	/**
	 * Returns the visitor name of this legal suggest document.
	 *
	 * @return the visitor name of this legal suggest document
	 */
	@Override
	public String getVisitorName() {
		return model.getVisitorName();
	}

	/**
	 * Returns the visitor tel of this legal suggest document.
	 *
	 * @return the visitor tel of this legal suggest document
	 */
	@Override
	public String getVisitorTel() {
		return model.getVisitorTel();
	}

	/**
	 * Returns <code>true</code> if this legal suggest document is approved.
	 *
	 * @return <code>true</code> if this legal suggest document is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this legal suggest document is has attachment.
	 *
	 * @return <code>true</code> if this legal suggest document is has attachment; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasAttachment() {
		return model.isHasAttachment();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this legal suggest document is approved.
	 *
	 * @param approved the approved of this legal suggest document
	 */
	@Override
	public void setApproved(boolean approved) {
		model.setApproved(approved);
	}

	/**
	 * Sets the approved by user of this legal suggest document.
	 *
	 * @param approvedByUser the approved by user of this legal suggest document
	 */
	@Override
	public void setApprovedByUser(long approvedByUser) {
		model.setApprovedByUser(approvedByUser);
	}

	/**
	 * Sets the approved date of this legal suggest document.
	 *
	 * @param approvedDate the approved date of this legal suggest document
	 */
	@Override
	public void setApprovedDate(Date approvedDate) {
		model.setApprovedDate(approvedDate);
	}

	/**
	 * Sets the company ID of this legal suggest document.
	 *
	 * @param companyId the company ID of this legal suggest document
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this legal suggest document.
	 *
	 * @param content the content of this legal suggest document
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created date of this legal suggest document.
	 *
	 * @param createdDate the created date of this legal suggest document
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the doc ID of this legal suggest document.
	 *
	 * @param docId the doc ID of this legal suggest document
	 */
	@Override
	public void setDocId(long docId) {
		model.setDocId(docId);
	}

	/**
	 * Sets the group ID of this legal suggest document.
	 *
	 * @param groupId the group ID of this legal suggest document
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this legal suggest document is has attachment.
	 *
	 * @param hasAttachment the has attachment of this legal suggest document
	 */
	@Override
	public void setHasAttachment(boolean hasAttachment) {
		model.setHasAttachment(hasAttachment);
	}

	/**
	 * Sets the language of this legal suggest document.
	 *
	 * @param language the language of this legal suggest document
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the modified by user of this legal suggest document.
	 *
	 * @param modifiedByUser the modified by user of this legal suggest document
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this legal suggest document.
	 *
	 * @param modifiedDate the modified date of this legal suggest document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this legal suggest document.
	 *
	 * @param primaryKey the primary key of this legal suggest document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sug ID of this legal suggest document.
	 *
	 * @param sugId the sug ID of this legal suggest document
	 */
	@Override
	public void setSugId(long sugId) {
		model.setSugId(sugId);
	}

	/**
	 * Sets the title of this legal suggest document.
	 *
	 * @param title the title of this legal suggest document
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this legal suggest document.
	 *
	 * @param userId the user ID of this legal suggest document
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this legal suggest document.
	 *
	 * @param userUuid the user uuid of this legal suggest document
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the visitor address of this legal suggest document.
	 *
	 * @param visitorAddress the visitor address of this legal suggest document
	 */
	@Override
	public void setVisitorAddress(String visitorAddress) {
		model.setVisitorAddress(visitorAddress);
	}

	/**
	 * Sets the visitor email of this legal suggest document.
	 *
	 * @param visitorEmail the visitor email of this legal suggest document
	 */
	@Override
	public void setVisitorEmail(String visitorEmail) {
		model.setVisitorEmail(visitorEmail);
	}

	/**
	 * Sets the visitor name of this legal suggest document.
	 *
	 * @param visitorName the visitor name of this legal suggest document
	 */
	@Override
	public void setVisitorName(String visitorName) {
		model.setVisitorName(visitorName);
	}

	/**
	 * Sets the visitor tel of this legal suggest document.
	 *
	 * @param visitorTel the visitor tel of this legal suggest document
	 */
	@Override
	public void setVisitorTel(String visitorTel) {
		model.setVisitorTel(visitorTel);
	}

	@Override
	protected LegalSuggestDocumentWrapper wrap(
		LegalSuggestDocument legalSuggestDocument) {

		return new LegalSuggestDocumentWrapper(legalSuggestDocument);
	}

}