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

package com.ecoit.lichcongtac.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ColumnGroupRel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRel
 * @generated
 */
public class ColumnGroupRelWrapper
	extends BaseModelWrapper<ColumnGroupRel>
	implements ColumnGroupRel, ModelWrapper<ColumnGroupRel> {

	public ColumnGroupRelWrapper(ColumnGroupRel columnGroupRel) {
		super(columnGroupRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userPermissionGroupId", getUserPermissionGroupId());
		attributes.put("columnId", getColumnId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userPermissionGroupId = (Long)attributes.get(
			"userPermissionGroupId");

		if (userPermissionGroupId != null) {
			setUserPermissionGroupId(userPermissionGroupId);
		}

		Integer columnId = (Integer)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}
	}

	/**
	 * Returns the column ID of this column group rel.
	 *
	 * @return the column ID of this column group rel
	 */
	@Override
	public int getColumnId() {
		return model.getColumnId();
	}

	/**
	 * Returns the primary key of this column group rel.
	 *
	 * @return the primary key of this column group rel
	 */
	@Override
	public com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the user permission group ID of this column group rel.
	 *
	 * @return the user permission group ID of this column group rel
	 */
	@Override
	public long getUserPermissionGroupId() {
		return model.getUserPermissionGroupId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the column ID of this column group rel.
	 *
	 * @param columnId the column ID of this column group rel
	 */
	@Override
	public void setColumnId(int columnId) {
		model.setColumnId(columnId);
	}

	/**
	 * Sets the primary key of this column group rel.
	 *
	 * @param primaryKey the primary key of this column group rel
	 */
	@Override
	public void setPrimaryKey(
		com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user permission group ID of this column group rel.
	 *
	 * @param userPermissionGroupId the user permission group ID of this column group rel
	 */
	@Override
	public void setUserPermissionGroupId(long userPermissionGroupId) {
		model.setUserPermissionGroupId(userPermissionGroupId);
	}

	@Override
	protected ColumnGroupRelWrapper wrap(ColumnGroupRel columnGroupRel) {
		return new ColumnGroupRelWrapper(columnGroupRel);
	}

}