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
 * This class is a wrapper for {@link LegalLogger}.
 * </p>
 *
 * @author Liverpool
 * @see LegalLogger
 * @generated
 */
public class LegalLoggerWrapper
	extends BaseModelWrapper<LegalLogger>
	implements LegalLogger, ModelWrapper<LegalLogger> {

	public LegalLoggerWrapper(LegalLogger legalLogger) {
		super(legalLogger);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("loggerId", getLoggerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("language", getLanguage());
		attributes.put("entryId", getEntryId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("classEntry", getClassEntry());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String loggerId = (String)attributes.get("loggerId");

		if (loggerId != null) {
			setLoggerId(loggerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String entryId = (String)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String createdByUser = (String)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		String classEntry = (String)attributes.get("classEntry");

		if (classEntry != null) {
			setClassEntry(classEntry);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	/**
	 * Returns the class entry of this legal logger.
	 *
	 * @return the class entry of this legal logger
	 */
	@Override
	public String getClassEntry() {
		return model.getClassEntry();
	}

	/**
	 * Returns the company ID of this legal logger.
	 *
	 * @return the company ID of this legal logger
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this legal logger.
	 *
	 * @return the content of this legal logger
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by user of this legal logger.
	 *
	 * @return the created by user of this legal logger
	 */
	@Override
	public String getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this legal logger.
	 *
	 * @return the created date of this legal logger
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the entry ID of this legal logger.
	 *
	 * @return the entry ID of this legal logger
	 */
	@Override
	public String getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the group ID of this legal logger.
	 *
	 * @return the group ID of this legal logger
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this legal logger.
	 *
	 * @return the language of this legal logger
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the logger ID of this legal logger.
	 *
	 * @return the logger ID of this legal logger
	 */
	@Override
	public String getLoggerId() {
		return model.getLoggerId();
	}

	/**
	 * Returns the primary key of this legal logger.
	 *
	 * @return the primary key of this legal logger
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class entry of this legal logger.
	 *
	 * @param classEntry the class entry of this legal logger
	 */
	@Override
	public void setClassEntry(String classEntry) {
		model.setClassEntry(classEntry);
	}

	/**
	 * Sets the company ID of this legal logger.
	 *
	 * @param companyId the company ID of this legal logger
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this legal logger.
	 *
	 * @param content the content of this legal logger
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by user of this legal logger.
	 *
	 * @param createdByUser the created by user of this legal logger
	 */
	@Override
	public void setCreatedByUser(String createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this legal logger.
	 *
	 * @param createdDate the created date of this legal logger
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the entry ID of this legal logger.
	 *
	 * @param entryId the entry ID of this legal logger
	 */
	@Override
	public void setEntryId(String entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the group ID of this legal logger.
	 *
	 * @param groupId the group ID of this legal logger
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this legal logger.
	 *
	 * @param language the language of this legal logger
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the logger ID of this legal logger.
	 *
	 * @param loggerId the logger ID of this legal logger
	 */
	@Override
	public void setLoggerId(String loggerId) {
		model.setLoggerId(loggerId);
	}

	/**
	 * Sets the primary key of this legal logger.
	 *
	 * @param primaryKey the primary key of this legal logger
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected LegalLoggerWrapper wrap(LegalLogger legalLogger) {
		return new LegalLoggerWrapper(legalLogger);
	}

}