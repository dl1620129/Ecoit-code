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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GroupCategory}.
 * </p>
 *
 * @author Liverpool
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

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("typeid", getTypeid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long typeid = (Long)attributes.get("typeid");

		if (typeid != null) {
			setTypeid(typeid);
		}
	}

	/**
	 * Returns the group user ID of this group category.
	 *
	 * @return the group user ID of this group category
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group category.
	 *
	 * @return the group user uuid of this group category
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the primary key of this group category.
	 *
	 * @return the primary key of this group category
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.GroupCategoryPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the typeid of this group category.
	 *
	 * @return the typeid of this group category
	 */
	@Override
	public long getTypeid() {
		return model.getTypeid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the group user ID of this group category.
	 *
	 * @param groupUserId the group user ID of this group category
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group category.
	 *
	 * @param groupUserUuid the group user uuid of this group category
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the primary key of this group category.
	 *
	 * @param primaryKey the primary key of this group category
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.GroupCategoryPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the typeid of this group category.
	 *
	 * @param typeid the typeid of this group category
	 */
	@Override
	public void setTypeid(long typeid) {
		model.setTypeid(typeid);
	}

	@Override
	protected GroupCategoryWrapper wrap(GroupCategory groupCategory) {
		return new GroupCategoryWrapper(groupCategory);
	}

}