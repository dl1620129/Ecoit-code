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
 * This class is a wrapper for {@link MapCateLayout}.
 * </p>
 *
 * @author DungNV
 * @see MapCateLayout
 * @generated
 */
public class MapCateLayoutWrapper
	extends BaseModelWrapper<MapCateLayout>
	implements MapCateLayout, ModelWrapper<MapCateLayout> {

	public MapCateLayoutWrapper(MapCateLayout mapCateLayout) {
		super(mapCateLayout);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("mapCateLayoutId", getMapCateLayoutId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("layoutId", getLayoutId());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long mapCateLayoutId = (Long)attributes.get("mapCateLayoutId");

		if (mapCateLayoutId != null) {
			setMapCateLayoutId(mapCateLayoutId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the category ID of this map cate layout.
	 *
	 * @return the category ID of this map cate layout
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this map cate layout.
	 *
	 * @return the company ID of this map cate layout
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this map cate layout.
	 *
	 * @return the group ID of this map cate layout
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the layout ID of this map cate layout.
	 *
	 * @return the layout ID of this map cate layout
	 */
	@Override
	public long getLayoutId() {
		return model.getLayoutId();
	}

	/**
	 * Returns the map cate layout ID of this map cate layout.
	 *
	 * @return the map cate layout ID of this map cate layout
	 */
	@Override
	public long getMapCateLayoutId() {
		return model.getMapCateLayoutId();
	}

	/**
	 * Returns the primary key of this map cate layout.
	 *
	 * @return the primary key of this map cate layout
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this map cate layout.
	 *
	 * @return the type of this map cate layout
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this map cate layout.
	 *
	 * @return the uuid of this map cate layout
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
	 * Sets the category ID of this map cate layout.
	 *
	 * @param categoryId the category ID of this map cate layout
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this map cate layout.
	 *
	 * @param companyId the company ID of this map cate layout
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this map cate layout.
	 *
	 * @param groupId the group ID of this map cate layout
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the layout ID of this map cate layout.
	 *
	 * @param layoutId the layout ID of this map cate layout
	 */
	@Override
	public void setLayoutId(long layoutId) {
		model.setLayoutId(layoutId);
	}

	/**
	 * Sets the map cate layout ID of this map cate layout.
	 *
	 * @param mapCateLayoutId the map cate layout ID of this map cate layout
	 */
	@Override
	public void setMapCateLayoutId(long mapCateLayoutId) {
		model.setMapCateLayoutId(mapCateLayoutId);
	}

	/**
	 * Sets the primary key of this map cate layout.
	 *
	 * @param primaryKey the primary key of this map cate layout
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this map cate layout.
	 *
	 * @param type the type of this map cate layout
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the uuid of this map cate layout.
	 *
	 * @param uuid the uuid of this map cate layout
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected MapCateLayoutWrapper wrap(MapCateLayout mapCateLayout) {
		return new MapCateLayoutWrapper(mapCateLayout);
	}

}