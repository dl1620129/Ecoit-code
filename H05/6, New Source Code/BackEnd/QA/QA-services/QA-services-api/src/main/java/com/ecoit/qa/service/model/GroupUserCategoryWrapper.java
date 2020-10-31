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

package com.ecoit.qa.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GroupUserCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserCategory
 * @generated
 */
public class GroupUserCategoryWrapper
	extends BaseModelWrapper<GroupUserCategory>
	implements GroupUserCategory, ModelWrapper<GroupUserCategory> {

	public GroupUserCategoryWrapper(GroupUserCategory groupUserCategory) {
		super(groupUserCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	 * Returns the category ID of this group user category.
	 *
	 * @return the category ID of this group user category
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the group user ID of this group user category.
	 *
	 * @return the group user ID of this group user category
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group user category.
	 *
	 * @return the group user uuid of this group user category
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the primary key of this group user category.
	 *
	 * @return the primary key of this group user category
	 */
	@Override
	public com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category ID of this group user category.
	 *
	 * @param categoryId the category ID of this group user category
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the group user ID of this group user category.
	 *
	 * @param groupUserId the group user ID of this group user category
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group user category.
	 *
	 * @param groupUserUuid the group user uuid of this group user category
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the primary key of this group user category.
	 *
	 * @param primaryKey the primary key of this group user category
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupUserCategoryWrapper wrap(
		GroupUserCategory groupUserCategory) {

		return new GroupUserCategoryWrapper(groupUserCategory);
	}

}