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
public class GroupCategoryPK
	implements Comparable<GroupCategoryPK>, Serializable {

	public long groupuserid;
	public long categoryId;

	public GroupCategoryPK() {
	}

	public GroupCategoryPK(long groupuserid, long categoryId) {
		this.groupuserid = groupuserid;
		this.categoryId = categoryId;
	}

	public long getGroupuserid() {
		return groupuserid;
	}

	public void setGroupuserid(long groupuserid) {
		this.groupuserid = groupuserid;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int compareTo(GroupCategoryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (groupuserid < pk.groupuserid) {
			value = -1;
		}
		else if (groupuserid > pk.groupuserid) {
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

		if (!(obj instanceof GroupCategoryPK)) {
			return false;
		}

		GroupCategoryPK pk = (GroupCategoryPK)obj;

		if ((groupuserid == pk.groupuserid) && (categoryId == pk.categoryId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, groupuserid);
		hashCode = HashUtil.hash(hashCode, categoryId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("groupuserid=");

		sb.append(groupuserid);
		sb.append(", categoryId=");

		sb.append(categoryId);

		sb.append("}");

		return sb.toString();
	}

}