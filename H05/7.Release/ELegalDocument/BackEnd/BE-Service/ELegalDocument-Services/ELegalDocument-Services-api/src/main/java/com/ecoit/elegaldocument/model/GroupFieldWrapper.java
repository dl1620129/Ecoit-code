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
 * This class is a wrapper for {@link GroupField}.
 * </p>
 *
 * @author Liverpool
 * @see GroupField
 * @generated
 */
public class GroupFieldWrapper
	extends BaseModelWrapper<GroupField>
	implements GroupField, ModelWrapper<GroupField> {

	public GroupFieldWrapper(GroupField groupField) {
		super(groupField);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("fieldid", getFieldid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long fieldid = (Long)attributes.get("fieldid");

		if (fieldid != null) {
			setFieldid(fieldid);
		}
	}

	/**
	 * Returns the fieldid of this group field.
	 *
	 * @return the fieldid of this group field
	 */
	@Override
	public long getFieldid() {
		return model.getFieldid();
	}

	/**
	 * Returns the group user ID of this group field.
	 *
	 * @return the group user ID of this group field
	 */
	@Override
	public long getGroupUserId() {
		return model.getGroupUserId();
	}

	/**
	 * Returns the group user uuid of this group field.
	 *
	 * @return the group user uuid of this group field
	 */
	@Override
	public String getGroupUserUuid() {
		return model.getGroupUserUuid();
	}

	/**
	 * Returns the primary key of this group field.
	 *
	 * @return the primary key of this group field
	 */
	@Override
	public com.ecoit.elegaldocument.service.persistence.GroupFieldPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fieldid of this group field.
	 *
	 * @param fieldid the fieldid of this group field
	 */
	@Override
	public void setFieldid(long fieldid) {
		model.setFieldid(fieldid);
	}

	/**
	 * Sets the group user ID of this group field.
	 *
	 * @param groupUserId the group user ID of this group field
	 */
	@Override
	public void setGroupUserId(long groupUserId) {
		model.setGroupUserId(groupUserId);
	}

	/**
	 * Sets the group user uuid of this group field.
	 *
	 * @param groupUserUuid the group user uuid of this group field
	 */
	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		model.setGroupUserUuid(groupUserUuid);
	}

	/**
	 * Sets the primary key of this group field.
	 *
	 * @param primaryKey the primary key of this group field
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.elegaldocument.service.persistence.GroupFieldPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GroupFieldWrapper wrap(GroupField groupField) {
		return new GroupFieldWrapper(groupField);
	}

}