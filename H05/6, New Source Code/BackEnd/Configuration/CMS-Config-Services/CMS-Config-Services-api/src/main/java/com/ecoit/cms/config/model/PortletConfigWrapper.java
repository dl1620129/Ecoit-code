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

package com.ecoit.cms.config.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PortletConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletConfig
 * @generated
 */
public class PortletConfigWrapper
	extends BaseModelWrapper<PortletConfig>
	implements ModelWrapper<PortletConfig>, PortletConfig {

	public PortletConfigWrapper(PortletConfig portletConfig) {
		super(portletConfig);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portletId", getPortletId());
		attributes.put("catgoryId", getCatgoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Long catgoryId = (Long)attributes.get("catgoryId");

		if (catgoryId != null) {
			setCatgoryId(catgoryId);
		}
	}

	/**
	 * Returns the catgory ID of this portlet config.
	 *
	 * @return the catgory ID of this portlet config
	 */
	@Override
	public long getCatgoryId() {
		return model.getCatgoryId();
	}

	/**
	 * Returns the portlet ID of this portlet config.
	 *
	 * @return the portlet ID of this portlet config
	 */
	@Override
	public String getPortletId() {
		return model.getPortletId();
	}

	/**
	 * Returns the primary key of this portlet config.
	 *
	 * @return the primary key of this portlet config
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this portlet config.
	 *
	 * @return the uuid of this portlet config
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
	 * Sets the catgory ID of this portlet config.
	 *
	 * @param catgoryId the catgory ID of this portlet config
	 */
	@Override
	public void setCatgoryId(long catgoryId) {
		model.setCatgoryId(catgoryId);
	}

	/**
	 * Sets the portlet ID of this portlet config.
	 *
	 * @param portletId the portlet ID of this portlet config
	 */
	@Override
	public void setPortletId(String portletId) {
		model.setPortletId(portletId);
	}

	/**
	 * Sets the primary key of this portlet config.
	 *
	 * @param primaryKey the primary key of this portlet config
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this portlet config.
	 *
	 * @param uuid the uuid of this portlet config
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PortletConfigWrapper wrap(PortletConfig portletConfig) {
		return new PortletConfigWrapper(portletConfig);
	}

}