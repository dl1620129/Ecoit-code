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
 * This class is a wrapper for {@link GroupCategory}.
 * </p>
 *
 * @author DungNV
 * @see GroupCategory
 * @generated
 */
public class GroupCategoryWrapper
	extends BaseModelWrapper<GroupCategory>
	implements GroupCategory, ModelWrapper<GroupCategory> {

	public GroupCategoryWrapper(GroupCategory groupCategory) {
		super(groupCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupuserid", getGroupuserid());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupuserid = (Long)attributes.get("groupuserid");

		if (groupuserid != null) {
			setGroupuserid(groupuserid);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	 * Returns the category ID of this group category.
	 *
	 * @return the category ID of this group category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the groupuserid of this group category.
	 *
	 * @return the groupuserid of this group category
	 */
	@Override
	public long getGroupuserid() {
		return model.getGroupuserid();
	}

	/**
	 * Returns the primary key of this group category.
	 *
	 * @return the primary key of this group category
	 */
	@Override
	public com.software.cms.service.persistence.GroupCategoryPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category ID of this group category.
	 *
	 * @param categoryId the category ID of this group category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the groupuserid of this group category.
	 *
	 * @param groupuserid the groupuserid of this group category
	 */
	@Override
	public void setGroupuserid(long groupuserid) {
		model.setGroupuserid(groupuserid);
	}

	/**
	 * Sets the primary key of this group category.
	 *
	 * @param primaryKey the primary key of this group category
	 */
	@Override
	public void setPrimaryKey(
		com.software.cms.service.persistence.GroupCategoryPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupCategoryWrapper wrap(GroupCategory groupCategory) {
		return new GroupCategoryWrapper(groupCategory);
	}

}