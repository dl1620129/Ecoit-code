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
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author DungNV
 * @see Category
 * @generated
 */
public class CategoryWrapper
	extends BaseModelWrapper<Category>
	implements Category, ModelWrapper<Category> {

	public CategoryWrapper(Category category) {
		super(category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdUser", getCreatedUser());
		attributes.put("modifiedUser", getModifiedUser());
		attributes.put("path", getPath());
		attributes.put("description", getDescription());
		attributes.put("display", isDisplay());
		attributes.put("parentId", getParentId());
		attributes.put("active", getActive());
		attributes.put("cateChild", getCateChild());
		attributes.put("thuTu", getThuTu());
		attributes.put("link", getLink());
		attributes.put("isRss", isIsRss());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdUser = (Long)attributes.get("createdUser");

		if (createdUser != null) {
			setCreatedUser(createdUser);
		}

		Long modifiedUser = (Long)attributes.get("modifiedUser");

		if (modifiedUser != null) {
			setModifiedUser(modifiedUser);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean display = (Boolean)attributes.get("display");

		if (display != null) {
			setDisplay(display);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long active = (Long)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		String cateChild = (String)attributes.get("cateChild");

		if (cateChild != null) {
			setCateChild(cateChild);
		}

		Integer thuTu = (Integer)attributes.get("thuTu");

		if (thuTu != null) {
			setThuTu(thuTu);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Boolean isRss = (Boolean)attributes.get("isRss");

		if (isRss != null) {
			setIsRss(isRss);
		}
	}

	/**
	 * Returns the active of this category.
	 *
	 * @return the active of this category
	 */
	@Override
	public long getActive() {
		return model.getActive();
	}

	/**
	 * Returns the cate child of this category.
	 *
	 * @return the cate child of this category
	 */
	@Override
	public String getCateChild() {
		return model.getCateChild();
	}

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the created date of this category.
	 *
	 * @return the created date of this category
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the created user of this category.
	 *
	 * @return the created user of this category
	 */
	@Override
	public long getCreatedUser() {
		return model.getCreatedUser();
	}

	/**
	 * Returns the description of this category.
	 *
	 * @return the description of this category
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the display of this category.
	 *
	 * @return the display of this category
	 */
	@Override
	public boolean getDisplay() {
		return model.getDisplay();
	}

	/**
	 * Returns the group ID of this category.
	 *
	 * @return the group ID of this category
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is rss of this category.
	 *
	 * @return the is rss of this category
	 */
	@Override
	public boolean getIsRss() {
		return model.getIsRss();
	}

	/**
	 * Returns the language of this category.
	 *
	 * @return the language of this category
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the link of this category.
	 *
	 * @return the link of this category
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this category.
	 *
	 * @return the modified date of this category
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified user of this category.
	 *
	 * @return the modified user of this category
	 */
	@Override
	public long getModifiedUser() {
		return model.getModifiedUser();
	}

	/**
	 * Returns the parent ID of this category.
	 *
	 * @return the parent ID of this category
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the path of this category.
	 *
	 * @return the path of this category
	 */
	@Override
	public String getPath() {
		return model.getPath();
	}

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the thu tu of this category.
	 *
	 * @return the thu tu of this category
	 */
	@Override
	public int getThuTu() {
		return model.getThuTu();
	}

	/**
	 * Returns the title of this category.
	 *
	 * @return the title of this category
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this category.
	 *
	 * @return the uuid of this category
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this category is display.
	 *
	 * @return <code>true</code> if this category is display; <code>false</code> otherwise
	 */
	@Override
	public boolean isDisplay() {
		return model.isDisplay();
	}

	/**
	 * Returns <code>true</code> if this category is is rss.
	 *
	 * @return <code>true</code> if this category is is rss; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRss() {
		return model.isIsRss();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this category.
	 *
	 * @param active the active of this category
	 */
	@Override
	public void setActive(long active) {
		model.setActive(active);
	}

	/**
	 * Sets the cate child of this category.
	 *
	 * @param cateChild the cate child of this category
	 */
	@Override
	public void setCateChild(String cateChild) {
		model.setCateChild(cateChild);
	}

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the created date of this category.
	 *
	 * @param createdDate the created date of this category
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the created user of this category.
	 *
	 * @param createdUser the created user of this category
	 */
	@Override
	public void setCreatedUser(long createdUser) {
		model.setCreatedUser(createdUser);
	}

	/**
	 * Sets the description of this category.
	 *
	 * @param description the description of this category
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets whether this category is display.
	 *
	 * @param display the display of this category
	 */
	@Override
	public void setDisplay(boolean display) {
		model.setDisplay(display);
	}

	/**
	 * Sets the group ID of this category.
	 *
	 * @param groupId the group ID of this category
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this category is is rss.
	 *
	 * @param isRss the is rss of this category
	 */
	@Override
	public void setIsRss(boolean isRss) {
		model.setIsRss(isRss);
	}

	/**
	 * Sets the language of this category.
	 *
	 * @param language the language of this category
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the link of this category.
	 *
	 * @param link the link of this category
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this category.
	 *
	 * @param modifiedDate the modified date of this category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified user of this category.
	 *
	 * @param modifiedUser the modified user of this category
	 */
	@Override
	public void setModifiedUser(long modifiedUser) {
		model.setModifiedUser(modifiedUser);
	}

	/**
	 * Sets the parent ID of this category.
	 *
	 * @param parentId the parent ID of this category
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the path of this category.
	 *
	 * @param path the path of this category
	 */
	@Override
	public void setPath(String path) {
		model.setPath(path);
	}

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the thu tu of this category.
	 *
	 * @param thuTu the thu tu of this category
	 */
	@Override
	public void setThuTu(int thuTu) {
		model.setThuTu(thuTu);
	}

	/**
	 * Sets the title of this category.
	 *
	 * @param title the title of this category
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this category.
	 *
	 * @param uuid the uuid of this category
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CategoryWrapper wrap(Category category) {
		return new CategoryWrapper(category);
	}

}