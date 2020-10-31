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

package com.software.cms.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author DungNV
 * @generated
 */
public class CategoryArticlePK
	implements Comparable<CategoryArticlePK>, Serializable {

	public long articleId;
	public long categoryId;

	public CategoryArticlePK() {
	}

	public CategoryArticlePK(long articleId, long categoryId) {
		this.articleId = articleId;
		this.categoryId = categoryId;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int compareTo(CategoryArticlePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (articleId < pk.articleId) {
			value = -1;
		}
		else if (articleId > pk.articleId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (categoryId < pk.categoryId) {
			value = -1;
		}
		else if (categoryId > pk.categoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryArticlePK)) {
			return false;
		}

		CategoryArticlePK pk = (CategoryArticlePK)obj;

		if ((articleId == pk.articleId) && (categoryId == pk.categoryId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, articleId);
		hashCode = HashUtil.hash(hashCode, categoryId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("articleId=");

		sb.append(articleId);
		sb.append(", categoryId=");

		sb.append(categoryId);

		sb.append("}");

		return sb.toString();
	}

}