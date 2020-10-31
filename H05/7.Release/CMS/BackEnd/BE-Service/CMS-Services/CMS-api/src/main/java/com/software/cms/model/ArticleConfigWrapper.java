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
 * This class is a wrapper for {@link ArticleConfig}.
 * </p>
 *
 * @author DungNV
 * @see ArticleConfig
 * @generated
 */
public class ArticleConfigWrapper
	extends BaseModelWrapper<ArticleConfig>
	implements ArticleConfig, ModelWrapper<ArticleConfig> {

	public ArticleConfigWrapper(ArticleConfig articleConfig) {
		super(articleConfig);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("articleConfigId", getArticleConfigId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long articleConfigId = (Long)attributes.get("articleConfigId");

		if (articleConfigId != null) {
			setArticleConfigId(articleConfigId);
		}
	}

	/**
	 * Returns the article config ID of this article config.
	 *
	 * @return the article config ID of this article config
	 */
	@Override
	public long getArticleConfigId() {
		return model.getArticleConfigId();
	}

	/**
	 * Returns the primary key of this article config.
	 *
	 * @return the primary key of this article config
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this article config.
	 *
	 * @return the uuid of this article config
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
	 * Sets the article config ID of this article config.
	 *
	 * @param articleConfigId the article config ID of this article config
	 */
	@Override
	public void setArticleConfigId(long articleConfigId) {
		model.setArticleConfigId(articleConfigId);
	}

	/**
	 * Sets the primary key of this article config.
	 *
	 * @param primaryKey the primary key of this article config
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this article config.
	 *
	 * @param uuid the uuid of this article config
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ArticleConfigWrapper wrap(ArticleConfig articleConfig) {
		return new ArticleConfigWrapper(articleConfig);
	}

}