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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Logger}.
 * </p>
 *
 * @author DungNV
 * @see Logger
 * @generated
 */
public class LoggerWrapper
	extends BaseModelWrapper<Logger> implements Logger, ModelWrapper<Logger> {

	public LoggerWrapper(Logger logger) {
		super(logger);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("loggerId", getLoggerId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("description", getDescription());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long loggerId = (Long)attributes.get("loggerId");

		if (loggerId != null) {
			setLoggerId(loggerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the created date of this logger.
	 *
	 * @return the created date of this logger
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the description of this logger.
	 *
	 * @return the description of this logger
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this logger.
	 *
	 * @return the group ID of this logger
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this logger.
	 *
	 * @return the language of this logger
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the logger ID of this logger.
	 *
	 * @return the logger ID of this logger
	 */
	@Override
	public long getLoggerId() {
		return model.getLoggerId();
	}

	/**
	 * Returns the primary key of this logger.
	 *
	 * @return the primary key of this logger
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this logger.
	 *
	 * @return the type of this logger
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this logger.
	 *
	 * @return the user ID of this logger
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this logger.
	 *
	 * @return the user uuid of this logger
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this logger.
	 *
	 * @return the uuid of this logger
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created date of this logger.
	 *
	 * @param createdDate the created date of this logger
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the description of this logger.
	 *
	 * @param description the description of this logger
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this logger.
	 *
	 * @param groupId the group ID of this logger
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this logger.
	 *
	 * @param language the language of this logger
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the logger ID of this logger.
	 *
	 * @param loggerId the logger ID of this logger
	 */
	@Override
	public void setLoggerId(long loggerId) {
		model.setLoggerId(loggerId);
	}

	/**
	 * Sets the primary key of this logger.
	 *
	 * @param primaryKey the primary key of this logger
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this logger.
	 *
	 * @param type the type of this logger
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this logger.
	 *
	 * @param userId the user ID of this logger
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this logger.
	 *
	 * @param userUuid the user uuid of this logger
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this logger.
	 *
	 * @param uuid the uuid of this logger
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected LoggerWrapper wrap(Logger logger) {
		return new LoggerWrapper(logger);
	}

}