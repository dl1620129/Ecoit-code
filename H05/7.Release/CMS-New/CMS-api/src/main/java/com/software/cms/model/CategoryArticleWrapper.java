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
 * This class is a wrapper for {@link CategoryArticle}.
 * </p>
 *
 * @author DungNV
 * @see CategoryArticle
 * @generated
 */
public class CategoryArticleWrapper
	extends BaseModelWrapper<CategoryArticle>
	implements CategoryArticle, ModelWrapper<CategoryArticle> {

	public CategoryArticleWrapper(CategoryArticle categoryArticle) {
		super(categoryArticle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("articleId", getArticleId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	 * Returns the article ID of this category article.
	 *
	 * @return the article ID of this category article
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the category ID of this category article.
	 *
	 * @return the category ID of this category article
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the group ID of this category article.
	 *
	 * @return the group ID of this category article
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this category article.
	 *
	 * @return the primary key of this category article
	 */
	@Override
	public com.software.cms.service.persistence.CategoryArticlePK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the article ID of this category article.
	 *
	 * @param articleId the article ID of this category article
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the category ID of this category article.
	 *
	 * @param categoryId the category ID of this category article
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the group ID of this category article.
	 *
	 * @param groupId the group ID of this category article
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this category article.
	 *
	 * @param primaryKey the primary key of this category article
	 */
	@Override
	public void setPrimaryKey(
		com.software.cms.service.persistence.CategoryArticlePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CategoryArticleWrapper wrap(CategoryArticle categoryArticle) {
		return new CategoryArticleWrapper(categoryArticle);
	}

}