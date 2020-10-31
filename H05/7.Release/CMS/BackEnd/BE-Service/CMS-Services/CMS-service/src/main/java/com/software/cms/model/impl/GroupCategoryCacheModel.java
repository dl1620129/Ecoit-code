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

import com.software.cms.model.GroupCategory;
import com.software.cms.service.persistence.GroupCategoryPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GroupCategory in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class GroupCategoryCacheModel
	implements CacheModel<GroupCategory>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroupCategoryCacheModel)) {
			return false;
		}

		GroupCategoryCacheModel groupCategoryCacheModel =
			(GroupCategoryCacheModel)obj;

		if (groupCategoryPK.equals(groupCategoryCacheModel.groupCategoryPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groupCategoryPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupuserid=");
		sb.append(groupuserid);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GroupCategory toEntityModel() {
		GroupCategoryImpl groupCategoryImpl = new GroupCategoryImpl();

		groupCategoryImpl.setGroupuserid(groupuserid);
		groupCategoryImpl.setCategoryId(categoryId);

		groupCategoryImpl.resetOriginalValues();

		return groupCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupuserid = objectInput.readLong();

		categoryId = objectInput.readLong();

		groupCategoryPK = new GroupCategoryPK(groupuserid, categoryId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupuserid);

		objectOutput.writeLong(categoryId);
	}

	public long groupuserid;
	public long categoryId;
	public transient GroupCategoryPK groupCategoryPK;

}