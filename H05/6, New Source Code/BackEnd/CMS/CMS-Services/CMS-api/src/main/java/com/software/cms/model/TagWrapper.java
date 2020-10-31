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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tag}.
 * </p>
 *
 * @author DungNV
 * @see Tag
 * @generated
 */
public class TagWrapper
	extends BaseModelWrapper<Tag> implements ModelWrapper<Tag>, Tag {

	public TagWrapper(Tag tag) {
		super(tag);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tagId", getTagId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("tagName", getTagName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String tagName = (String)attributes.get("tagName");

		if (tagName != null) {
			setTagName(tagName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the description of this tag.
	 *
	 * @return the description of this tag
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this tag.
	 *
	 * @return the group ID of this tag
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this tag.
	 *
	 * @return the language of this tag
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the primary key of this tag.
	 *
	 * @return the primary key of this tag
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tag ID of this tag.
	 *
	 * @return the tag ID of this tag
	 */
	@Override
	public long getTagId() {
		return model.getTagId();
	}

	/**
	 * Returns the tag name of this tag.
	 *
	 * @return the tag name of this tag
	 */
	@Override
	public String getTagName() {
		return model.getTagName();
	}

	/**
	 * Returns the uuid of this tag.
	 *
	 * @return the uuid of this tag
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
	 * Sets the description of this tag.
	 *
	 * @param description the description of this tag
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this tag.
	 *
	 * @param groupId the group ID of this tag
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this tag.
	 *
	 * @param language the language of this tag
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the primary key of this tag.
	 *
	 * @param primaryKey the primary key of this tag
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tag ID of this tag.
	 *
	 * @param tagId the tag ID of this tag
	 */
	@Override
	public void setTagId(long tagId) {
		model.setTagId(tagId);
	}

	/**
	 * Sets the tag name of this tag.
	 *
	 * @param tagName the tag name of this tag
	 */
	@Override
	public void setTagName(String tagName) {
		model.setTagName(tagName);
	}

	/**
	 * Sets the uuid of this tag.
	 *
	 * @param uuid the uuid of this tag
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected TagWrapper wrap(Tag tag) {
		return new TagWrapper(tag);
	}

}