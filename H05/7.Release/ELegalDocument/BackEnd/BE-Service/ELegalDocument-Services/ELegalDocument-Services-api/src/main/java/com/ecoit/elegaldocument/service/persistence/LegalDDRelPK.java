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
public class LegalDDRelPK implements Comparable<LegalDDRelPK>, Serializable {

	public long departmentId;
	public String docId;

	public LegalDDRelPK() {
	}

	public LegalDDRelPK(long departmentId, String docId) {
		this.departmentId = departmentId;
		this.docId = docId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	@Override
	public int compareTo(LegalDDRelPK pk) {
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

		value = docId.compareTo(pk.docId);

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

		if (!(obj instanceof LegalDDRelPK)) {
			return false;
		}

		LegalDDRelPK pk = (LegalDDRelPK)obj;

		if ((departmentId == pk.departmentId) && docId.equals(pk.docId)) {
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
		hashCode = HashUtil.hash(hashCode, docId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("departmentId=");

		sb.append(departmentId);
		sb.append(", docId=");

		sb.append(docId);

		sb.append("}");

		return sb.toString();
	}

}