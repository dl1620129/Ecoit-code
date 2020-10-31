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
 * This class is a wrapper for {@link LegalTags}.
 * </p>
 *
 * @author Liverpool
 * @see LegalTags
 * @generated
 */
public class LegalTagsWrapper
	extends BaseModelWrapper<LegalTags>
	implements LegalTags, ModelWrapper<LegalTags> {

	public LegalTagsWrapper(LegalTags legalTags) {
		super(legalTags);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("statusTags", isStatusTags());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean statusTags = (Boolean)attributes.get("statusTags");

		if (statusTags != null) {
			setStatusTags(statusTags);
		}
	}

	/**
	 * Returns the company ID of this legal tags.
	 *
	 * @return the company ID of this legal tags
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created date of this legal tags.
	 *
	 * @return the created date of this legal tags
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the group ID of this legal tags.
	 *
	 * @return the group ID of this legal tags
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this legal tags.
	 *
	 * @return the modified date of this legal tags
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this legal tags.
	 *
	 * @return the name of this legal tags
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this legal tags.
	 *
	 * @return the primary key of this legal tags
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status tags of this legal tags.
	 *
	 * @return the status tags of this legal tags
	 */
	@Override
	public boolean getStatusTags() {
		return model.getStatusTags();
	}

	/**
	 * Returns the tag ID of this legal tags.
	 *
	 * @return the tag ID of this legal tags
	 */
	@Override
	public long getTagId() {
		return model.getTagId();
	}

	/**
	 * Returns the user ID of this legal tags.
	 *
	 * @return the user ID of this legal tags
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this legal tags.
	 *
	 * @return the user uuid of this legal tags
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this legal tags is status tags.
	 *
	 * @return <code>true</code> if this legal tags is status tags; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatusTags() {
		return model.isStatusTags();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this legal tags.
	 *
	 * @param companyId the company ID of this legal tags
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created date of this legal tags.
	 *
	 * @param createdDate the created date of this legal tags
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this legal tags.
	 *
	 * @param groupId the group ID of this legal tags
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this legal tags.
	 *
	 * @param modifiedDate the modified date of this legal tags
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this legal tags.
	 *
	 * @param name the name of this legal tags
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this legal tags.
	 *
	 * @param primaryKey the primary key of this legal tags
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this legal tags is status tags.
	 *
	 * @param statusTags the status tags of this legal tags
	 */
	@Override
	public void setStatusTags(boolean statusTags) {
		model.setStatusTags(statusTags);
	}

	/**
	 * Sets the tag ID of this legal tags.
	 *
	 * @param tagId the tag ID of this legal tags
	 */
	@Override
	public void setTagId(long tagId) {
		model.setTagId(tagId);
	}

	/**
	 * Sets the user ID of this legal tags.
	 *
	 * @param userId the user ID of this legal tags
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this legal tags.
	 *
	 * @param userUuid the user uuid of this legal tags
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LegalTagsWrapper wrap(LegalTags legalTags) {
		return new LegalTagsWrapper(legalTags);
	}

}