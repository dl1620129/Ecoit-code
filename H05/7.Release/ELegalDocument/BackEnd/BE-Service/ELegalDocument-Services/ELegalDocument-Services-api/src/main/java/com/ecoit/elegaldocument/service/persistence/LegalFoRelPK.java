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
public class LegalFoRelPK implements Comparable<LegalFoRelPK>, Serializable {

	public long fieldId;
	public long organizationId;

	public LegalFoRelPK() {
	}

	public LegalFoRelPK(long fieldId, long organizationId) {
		this.fieldId = fieldId;
		this.organizationId = organizationId;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public int compareTo(LegalFoRelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (fieldId < pk.fieldId) {
			value = -1;
		}
		else if (fieldId > pk.fieldId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (organizationId < pk.organizationId) {
			value = -1;
		}
		else if (organizationId > pk.organizationId) {
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

		if (!(obj instanceof LegalFoRelPK)) {
			return false;
		}

		LegalFoRelPK pk = (LegalFoRelPK)obj;

		if ((fieldId == pk.fieldId) && (organizationId == pk.organizationId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, fieldId);
		hashCode = HashUtil.hash(hashCode, organizationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("fieldId=");

		sb.append(fieldId);
		sb.append(", organizationId=");

		sb.append(organizationId);

		sb.append("}");

		return sb.toString();
	}

}