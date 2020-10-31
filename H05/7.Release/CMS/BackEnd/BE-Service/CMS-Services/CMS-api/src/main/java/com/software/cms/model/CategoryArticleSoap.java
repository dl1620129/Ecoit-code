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

import com.software.cms.service.persistence.CategoryArticlePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.CategoryArticleServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class CategoryArticleSoap implements Serializable {

	public static CategoryArticleSoap toSoapModel(CategoryArticle model) {
		CategoryArticleSoap soapModel = new CategoryArticleSoap();

		soapModel.setArticleId(model.getArticleId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static CategoryArticleSoap[] toSoapModels(CategoryArticle[] models) {
		CategoryArticleSoap[] soapModels =
			new CategoryArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoryArticleSoap[][] toSoapModels(
		CategoryArticle[][] models) {

		CategoryArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CategoryArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoryArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoryArticleSoap[] toSoapModels(
		List<CategoryArticle> models) {

		List<CategoryArticleSoap> soapModels =
			new ArrayList<CategoryArticleSoap>(models.size());

		for (CategoryArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoryArticleSoap[soapModels.size()]);
	}

	public CategoryArticleSoap() {
	}

	public CategoryArticlePK getPrimaryKey() {
		return new CategoryArticlePK(_articleId, _categoryId);
	}

	public void setPrimaryKey(CategoryArticlePK pk) {
		setArticleId(pk.articleId);
		setCategoryId(pk.categoryId);
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _articleId;
	private long _categoryId;
	private long _groupId;

}