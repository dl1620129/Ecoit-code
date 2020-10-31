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

import com.software.cms.model.ArticleConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ArticleConfig in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class ArticleConfigCacheModel
	implements CacheModel<ArticleConfig>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleConfigCacheModel)) {
			return false;
		}

		ArticleConfigCacheModel articleConfigCacheModel =
			(ArticleConfigCacheModel)obj;

		if (articleConfigId == articleConfigCacheModel.articleConfigId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, articleConfigId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", articleConfigId=");
		sb.append(articleConfigId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArticleConfig toEntityModel() {
		ArticleConfigImpl articleConfigImpl = new ArticleConfigImpl();

		if (uuid == null) {
			articleConfigImpl.setUuid("");
		}
		else {
			articleConfigImpl.setUuid(uuid);
		}

		articleConfigImpl.setArticleConfigId(articleConfigId);

		articleConfigImpl.resetOriginalValues();

		return articleConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		articleConfigId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(articleConfigId);
	}

	public String uuid;
	public long articleConfigId;

}