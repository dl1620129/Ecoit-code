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

package com.software.cms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.software.cms.model.CategoryArticle;
import com.software.cms.service.persistence.CategoryArticlePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CategoryArticle in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class CategoryArticleCacheModel
	implements CacheModel<CategoryArticle>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryArticleCacheModel)) {
			return false;
		}

		CategoryArticleCacheModel categoryArticleCacheModel =
			(CategoryArticleCacheModel)obj;

		if (categoryArticlePK.equals(
				categoryArticleCacheModel.categoryArticlePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryArticlePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{articleId=");
		sb.append(articleId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CategoryArticle toEntityModel() {
		CategoryArticleImpl categoryArticleImpl = new CategoryArticleImpl();

		categoryArticleImpl.setArticleId(articleId);
		categoryArticleImpl.setCategoryId(categoryId);
		categoryArticleImpl.setGroupId(groupId);

		categoryArticleImpl.resetOriginalValues();

		return categoryArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		articleId = objectInput.readLong();

		categoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		categoryArticlePK = new CategoryArticlePK(articleId, categoryId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(articleId);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(groupId);
	}

	public long articleId;
	public long categoryId;
	public long groupId;
	public transient CategoryArticlePK categoryArticlePK;

}