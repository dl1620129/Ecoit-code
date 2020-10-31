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

package com.ecoit.elegaldocument.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Liverpool
 * @generated
 */
public class EcmsPGRelationPK
	implements Comparable<EcmsPGRelationPK>, Serializable {

	public long groupUserId;
	public int permission;

	public EcmsPGRelationPK() {
	}

	public EcmsPGRelationPK(long groupUserId, int permission) {
		this.groupUserId = groupUserId;
		this.permission = permission;
	}

	public long getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		this.groupUserId = groupUserId;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	@Override
	public int compareTo(EcmsPGRelationPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (groupUserId < pk.groupUserId) {
			value = -1;
		}
		else if (groupUserId > pk.groupUserId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (permission < pk.permission) {
			value = -1;
		}
		else if (permission > pk.permission) {
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

		if (!(obj instanceof EcmsPGRelationPK)) {
			return false;
		}

		EcmsPGRelationPK pk = (EcmsPGRelationPK)obj;

		if ((groupUserId == pk.groupUserId) && (permission == pk.permission)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, groupUserId);
		hashCode = HashUtil.hash(hashCode, permission);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("groupUserId=");

		sb.append(groupUserId);
		sb.append(", permission=");

		sb.append(permission);

		sb.append("}");

		return sb.toString();
	}

}