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

package com.ecoit.lichcongtac.services.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ColumnGroupRelPK
	implements Comparable<ColumnGroupRelPK>, Serializable {

	public long userPermissionGroupId;
	public int columnId;

	public ColumnGroupRelPK() {
	}

	public ColumnGroupRelPK(long userPermissionGroupId, int columnId) {
		this.userPermissionGroupId = userPermissionGroupId;
		this.columnId = columnId;
	}

	public long getUserPermissionGroupId() {
		return userPermissionGroupId;
	}

	public void setUserPermissionGroupId(long userPermissionGroupId) {
		this.userPermissionGroupId = userPermissionGroupId;
	}

	public int getColumnId() {
		return columnId;
	}

	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}

	@Override
	public int compareTo(ColumnGroupRelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (userPermissionGroupId < pk.userPermissionGroupId) {
			value = -1;
		}
		else if (userPermissionGroupId > pk.userPermissionGroupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (columnId < pk.columnId) {
			value = -1;
		}
		else if (columnId > pk.columnId) {
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

		if (!(obj instanceof ColumnGroupRelPK)) {
			return false;
		}

		ColumnGroupRelPK pk = (ColumnGroupRelPK)obj;

		if ((userPermissionGroupId == pk.userPermissionGroupId) &&
			(columnId == pk.columnId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, userPermissionGroupId);
		hashCode = HashUtil.hash(hashCode, columnId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("userPermissionGroupId=");

		sb.append(userPermissionGroupId);
		sb.append(", columnId=");

		sb.append(columnId);

		sb.append("}");

		return sb.toString();
	}

}