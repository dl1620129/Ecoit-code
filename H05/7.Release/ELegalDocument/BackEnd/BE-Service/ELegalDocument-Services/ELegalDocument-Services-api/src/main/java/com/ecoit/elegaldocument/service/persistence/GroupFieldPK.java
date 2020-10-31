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
public class GroupFieldPK implements Comparable<GroupFieldPK>, Serializable {

	public long groupUserId;
	public long fieldid;

	public GroupFieldPK() {
	}

	public GroupFieldPK(long groupUserId, long fieldid) {
		this.groupUserId = groupUserId;
		this.fieldid = fieldid;
	}

	public long getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		this.groupUserId = groupUserId;
	}

	public long getFieldid() {
		return fieldid;
	}

	public void setFieldid(long fieldid) {
		this.fieldid = fieldid;
	}

	@Override
	public int compareTo(GroupFieldPK pk) {
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

		if (fieldid < pk.fieldid) {
			value = -1;
		}
		else if (fieldid > pk.fieldid) {
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

		if (!(obj instanceof GroupFieldPK)) {
			return false;
		}

		GroupFieldPK pk = (GroupFieldPK)obj;

		if ((groupUserId == pk.groupUserId) && (fieldid == pk.fieldid)) {
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
		hashCode = HashUtil.hash(hashCode, fieldid);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("groupUserId=");

		sb.append(groupUserId);
		sb.append(", fieldid=");

		sb.append(fieldid);

		sb.append("}");

		return sb.toString();
	}

}