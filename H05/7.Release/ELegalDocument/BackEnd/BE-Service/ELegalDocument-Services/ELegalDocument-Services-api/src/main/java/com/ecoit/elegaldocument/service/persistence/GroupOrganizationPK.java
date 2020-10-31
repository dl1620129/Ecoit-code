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
public class GroupOrganizationPK
	implements Comparable<GroupOrganizationPK>, Serializable {

	public long groupUserId;
	public long organizationid;

	public GroupOrganizationPK() {
	}

	public GroupOrganizationPK(long groupUserId, long organizationid) {
		this.groupUserId = groupUserId;
		this.organizationid = organizationid;
	}

	public long getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		this.groupUserId = groupUserId;
	}

	public long getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(long organizationid) {
		this.organizationid = organizationid;
	}

	@Override
	public int compareTo(GroupOrganizationPK pk) {
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

		if (organizationid < pk.organizationid) {
			value = -1;
		}
		else if (organizationid > pk.organizationid) {
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

		if (!(obj instanceof GroupOrganizationPK)) {
			return false;
		}

		GroupOrganizationPK pk = (GroupOrganizationPK)obj;

		if ((groupUserId == pk.groupUserId) &&
			(organizationid == pk.organizationid)) {

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
		hashCode = HashUtil.hash(hashCode, organizationid);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("groupUserId=");

		sb.append(groupUserId);
		sb.append(", organizationid=");

		sb.append(organizationid);

		sb.append("}");

		return sb.toString();
	}

}