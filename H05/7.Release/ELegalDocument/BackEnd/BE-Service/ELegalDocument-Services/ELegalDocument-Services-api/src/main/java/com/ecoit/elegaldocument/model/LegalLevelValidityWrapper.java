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
 * This class is a wrapper for {@link LegalLevelValidity}.
 * </p>
 *
 * @author Liverpool
 * @see LegalLevelValidity
 * @generated
 */
public class LegalLevelValidityWrapper
	extends BaseModelWrapper<LegalLevelValidity>
	implements LegalLevelValidity, ModelWrapper<LegalLevelValidity> {

	public LegalLevelValidityWrapper(LegalLevelValidity legalLevelValidity) {
		super(legalLevelValidity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("levelValidityId", getLevelValidityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("language", getLanguage());
		attributes.put("statusLevelValidity", isStatusLevelValidity());
		attributes.put("position", getPosition());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long levelValidityId = (Long)attributes.get("levelValidityId");

		if (levelValidityId != null) {
			setLevelValidityId(levelValidityId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Boolean statusLevelValidity = (Boolean)attributes.get(
			"statusLevelValidity");

		if (statusLevelValidity != null) {
			setStatusLevelValidity(statusLevelValidity);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}
	}

	/**
	 * Returns the company ID of this legal level validity.
	 *
	 * @return the company ID of this legal level validity
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created by user of this legal level validity.
	 *
	 * @return the created by user of this legal level validity
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this legal level validity.
	 *
	 * @return the created date of this legal level validity
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the description of this legal level validity.
	 *
	 * @return the description of this legal level validity
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this legal level validity.
	 *
	 * @return the group ID of this legal level validity
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this legal level validity.
	 *
	 * @return the language of this legal level validity
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the level validity ID of this legal level validity.
	 *
	 * @return the level validity ID of this legal level validity
	 */
	@Override
	public long getLevelValidityId() {
		return model.getLevelValidityId();
	}

	/**
	 * Returns the modified by user of this legal level validity.
	 *
	 * @return the modified by user of this legal level validity
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this legal level validity.
	 *
	 * @return the modified date of this legal level validity
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this legal level validity.
	 *
	 * @return the name of this legal level validity
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the position of this legal level validity.
	 *
	 * @return the position of this legal level validity
	 */
	@Override
	public int getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this legal level validity.
	 *
	 * @return the primary key of this legal level validity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status level validity of this legal level validity.
	 *
	 * @return the status level validity of this legal level validity
	 */
	@Override
	public boolean getStatusLevelValidity() {
		return model.getStatusLevelValidity();
	}

	/**
	 * Returns the user ID of this legal level validity.
	 *
	 * @return the user ID of this legal level validity
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this legal level validity.
	 *
	 * @return the user uuid of this legal level validity
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this legal level validity is status level validity.
	 *
	 * @return <code>true</code> if this legal level validity is status level validity; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatusLevelValidity() {
		return model.isStatusLevelValidity();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this legal level validity.
	 *
	 * @param companyId the company ID of this legal level validity
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created by user of this legal level validity.
	 *
	 * @param createdByUser the created by user of this legal level validity
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this legal level validity.
	 *
	 * @param createdDate the created date of this legal level validity
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the description of this legal level validity.
	 *
	 * @param description the description of this legal level validity
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this legal level validity.
	 *
	 * @param groupId the group ID of this legal level validity
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this legal level validity.
	 *
	 * @param language the language of this legal level validity
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the level validity ID of this legal level validity.
	 *
	 * @param levelValidityId the level validity ID of this legal level validity
	 */
	@Override
	public void setLevelValidityId(long levelValidityId) {
		model.setLevelValidityId(levelValidityId);
	}

	/**
	 * Sets the modified by user of this legal level validity.
	 *
	 * @param modifiedByUser the modified by user of this legal level validity
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this legal level validity.
	 *
	 * @param modifiedDate the modified date of this legal level validity
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this legal level validity.
	 *
	 * @param name the name of this legal level validity
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the position of this legal level validity.
	 *
	 * @param position the position of this legal level validity
	 */
	@Override
	public void setPosition(int position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this legal level validity.
	 *
	 * @param primaryKey the primary key of this legal level validity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this legal level validity is status level validity.
	 *
	 * @param statusLevelValidity the status level validity of this legal level validity
	 */
	@Override
	public void setStatusLevelValidity(boolean statusLevelValidity) {
		model.setStatusLevelValidity(statusLevelValidity);
	}

	/**
	 * Sets the user ID of this legal level validity.
	 *
	 * @param userId the user ID of this legal level validity
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this legal level validity.
	 *
	 * @param userUuid the user uuid of this legal level validity
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LegalLevelValidityWrapper wrap(
		LegalLevelValidity legalLevelValidity) {

		return new LegalLevelValidityWrapper(legalLevelValidity);
	}

}