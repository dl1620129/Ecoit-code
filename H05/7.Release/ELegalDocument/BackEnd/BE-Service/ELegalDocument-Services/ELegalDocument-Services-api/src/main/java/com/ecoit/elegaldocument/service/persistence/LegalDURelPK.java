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
public class LegalDURelPK implements Comparable<LegalDURelPK>, Serializable {

	public long departmentId;
	public long userid;

	public LegalDURelPK() {
	}

	public LegalDURelPK(long departmentId, long userid) {
		this.departmentId = departmentId;
		this.userid = userid;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Override
	public int compareTo(LegalDURelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (departmentId < pk.departmentId) {
			value = -1;
		}
		else if (departmentId > pk.departmentId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userid < pk.userid) {
			value = -1;
		}
		else if (userid > pk.userid) {
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

		if (!(obj instanceof LegalDURelPK)) {
			return false;
		}

		LegalDURelPK pk = (LegalDURelPK)obj;

		if ((departmentId == pk.departmentId) && (userid == pk.userid)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, departmentId);
		hashCode = HashUtil.hash(hashCode, userid);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("departmentId=");

		sb.append(departmentId);
		sb.append(", userid=");

		sb.append(userid);

		sb.append("}");

		return sb.toString();
	}

}