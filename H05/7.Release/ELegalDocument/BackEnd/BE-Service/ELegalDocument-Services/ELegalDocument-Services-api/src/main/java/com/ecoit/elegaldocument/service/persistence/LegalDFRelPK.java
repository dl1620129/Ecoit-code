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
public class LegalDFRelPK implements Comparable<LegalDFRelPK>, Serializable {

	public long docId;
	public long fieldId;

	public LegalDFRelPK() {
	}

	public LegalDFRelPK(long docId, long fieldId) {
		this.docId = docId;
		this.fieldId = fieldId;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}

	@Override
	public int compareTo(LegalDFRelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (docId < pk.docId) {
			value = -1;
		}
		else if (docId > pk.docId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDFRelPK)) {
			return false;
		}

		LegalDFRelPK pk = (LegalDFRelPK)obj;

		if ((docId == pk.docId) && (fieldId == pk.fieldId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, docId);
		hashCode = HashUtil.hash(hashCode, fieldId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("docId=");

		sb.append(docId);
		sb.append(", fieldId=");

		sb.append(fieldId);

		sb.append("}");

		return sb.toString();
	}

}