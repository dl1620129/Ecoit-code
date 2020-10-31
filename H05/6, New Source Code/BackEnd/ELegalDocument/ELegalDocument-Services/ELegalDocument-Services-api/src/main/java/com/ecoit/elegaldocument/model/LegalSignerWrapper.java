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
 * This class is a wrapper for {@link LegalSigner}.
 * </p>
 *
 * @author Liverpool
 * @see LegalSigner
 * @generated
 */
public class LegalSignerWrapper
	extends BaseModelWrapper<LegalSigner>
	implements LegalSigner, ModelWrapper<LegalSigner> {

	public LegalSignerWrapper(LegalSigner legalSigner) {
		super(legalSigner);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sigId", getSigId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("language", getLanguage());
		attributes.put("statusSigner", isStatusSigner());
		attributes.put("fullName", getFullName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sigId = (Long)attributes.get("sigId");

		if (sigId != null) {
			setSigId(sigId);
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

		Long createdByUser = (Long)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Boolean statusSigner = (Boolean)attributes.get("statusSigner");

		if (statusSigner != null) {
			setStatusSigner(statusSigner);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}
	}

	/**
	 * Returns the company ID of this legal signer.
	 *
	 * @return the company ID of this legal signer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by user of this legal signer.
	 *
	 * @return the created by user of this legal signer
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this legal signer.
	 *
	 * @return the created date of this legal signer
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the first name of this legal signer.
	 *
	 * @return the first name of this legal signer
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the full name of this legal signer.
	 *
	 * @return the full name of this legal signer
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this legal signer.
	 *
	 * @return the group ID of this legal signer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this legal signer.
	 *
	 * @return the language of this legal signer
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the last name of this legal signer.
	 *
	 * @return the last name of this legal signer
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified by user of this legal signer.
	 *
	 * @return the modified by user of this legal signer
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this legal signer.
	 *
	 * @return the modified date of this legal signer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this legal signer.
	 *
	 * @return the primary key of this legal signer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sig ID of this legal signer.
	 *
	 * @return the sig ID of this legal signer
	 */
	@Override
	public long getSigId() {
		return model.getSigId();
	}

	/**
	 * Returns the status signer of this legal signer.
	 *
	 * @return the status signer of this legal signer
	 */
	@Override
	public boolean getStatusSigner() {
		return model.getStatusSigner();
	}

	/**
	 * Returns the user ID of this legal signer.
	 *
	 * @return the user ID of this legal signer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this legal signer.
	 *
	 * @return the user uuid of this legal signer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this legal signer is status signer.
	 *
	 * @return <code>true</code> if this legal signer is status signer; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatusSigner() {
		return model.isStatusSigner();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this legal signer.
	 *
	 * @param companyId the company ID of this legal signer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by user of this legal signer.
	 *
	 * @param createdByUser the created by user of this legal signer
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this legal signer.
	 *
	 * @param createdDate the created date of this legal signer
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the first name of this legal signer.
	 *
	 * @param firstName the first name of this legal signer
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the full name of this legal signer.
	 *
	 * @param fullName the full name of this legal signer
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this legal signer.
	 *
	 * @param groupId the group ID of this legal signer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this legal signer.
	 *
	 * @param language the language of this legal signer
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the last name of this legal signer.
	 *
	 * @param lastName the last name of this legal signer
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified by user of this legal signer.
	 *
	 * @param modifiedByUser the modified by user of this legal signer
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this legal signer.
	 *
	 * @param modifiedDate the modified date of this legal signer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this legal signer.
	 *
	 * @param primaryKey the primary key of this legal signer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sig ID of this legal signer.
	 *
	 * @param sigId the sig ID of this legal signer
	 */
	@Override
	public void setSigId(long sigId) {
		model.setSigId(sigId);
	}

	/**
	 * Sets whether this legal signer is status signer.
	 *
	 * @param statusSigner the status signer of this legal signer
	 */
	@Override
	public void setStatusSigner(boolean statusSigner) {
		model.setStatusSigner(statusSigner);
	}

	/**
	 * Sets the user ID of this legal signer.
	 *
	 * @param userId the user ID of this legal signer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this legal signer.
	 *
	 * @param userUuid the user uuid of this legal signer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LegalSignerWrapper wrap(LegalSigner legalSigner) {
		return new LegalSignerWrapper(legalSigner);
	}

}