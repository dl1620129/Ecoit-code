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
public class LegalDTypeRelPK
	implements Comparable<LegalDTypeRelPK>, Serializable {

	public long docId;
	public long typeId;

	public LegalDTypeRelPK() {
	}

	public LegalDTypeRelPK(long docId, long typeId) {
		this.docId = docId;
		this.typeId = typeId;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	@Override
	public int compareTo(LegalDTypeRelPK pk) {
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

		if (typeId < pk.typeId) {
			value = -1;
		}
		else if (typeId > pk.typeId) {
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

		if (!(obj instanceof LegalDTypeRelPK)) {
			return false;
		}

		LegalDTypeRelPK pk = (LegalDTypeRelPK)obj;

		if ((docId == pk.docId) && (typeId == pk.typeId)) {
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
		hashCode = HashUtil.hash(hashCode, typeId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("docId=");

		sb.append(docId);
		sb.append(", typeId=");

		sb.append(typeId);

		sb.append("}");

		return sb.toString();
	}

}