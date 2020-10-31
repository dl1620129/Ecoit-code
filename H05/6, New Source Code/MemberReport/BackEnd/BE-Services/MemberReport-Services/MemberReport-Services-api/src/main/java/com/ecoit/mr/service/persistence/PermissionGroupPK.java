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

package com.ecoit.mr.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PermissionGroupPK
	implements Comparable<PermissionGroupPK>, Serializable {

	public long userPermissionGroupId;
	public int permissionId;

	public PermissionGroupPK() {
	}

	public PermissionGroupPK(long userPermissionGroupId, int permissionId) {
		this.userPermissionGroupId = userPermissionGroupId;
		this.permissionId = permissionId;
	}

	public long getUserPermissionGroupId() {
		return userPermissionGroupId;
	}

	public void setUserPermissionGroupId(long userPermissionGroupId) {
		this.userPermissionGroupId = userPermissionGroupId;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public int compareTo(PermissionGroupPK pk) {
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

		if (permissionId < pk.permissionId) {
			value = -1;
		}
		else if (permissionId > pk.permissionId) {
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

		if (!(obj instanceof PermissionGroupPK)) {
			return false;
		}

		PermissionGroupPK pk = (PermissionGroupPK)obj;

		if ((userPermissionGroupId == pk.userPermissionGroupId) &&
			(permissionId == pk.permissionId)) {

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
		hashCode = HashUtil.hash(hashCode, permissionId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("userPermissionGroupId=");

		sb.append(userPermissionGroupId);
		sb.append(", permissionId=");

		sb.append(permissionId);

		sb.append("}");

		return sb.toString();
	}

}