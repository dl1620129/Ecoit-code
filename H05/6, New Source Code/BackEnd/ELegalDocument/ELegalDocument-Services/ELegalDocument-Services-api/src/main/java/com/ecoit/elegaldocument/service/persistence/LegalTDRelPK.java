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
public class LegalTDRelPK implements Comparable<LegalTDRelPK>, Serializable {

	public long docId;
	public long tagId;

	public LegalTDRelPK() {
	}

	public LegalTDRelPK(long docId, long tagId) {
		this.docId = docId;
		this.tagId = tagId;
	}

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	@Override
	public int compareTo(LegalTDRelPK pk) {
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

		if (tagId < pk.tagId) {
			value = -1;
		}
		else if (tagId > pk.tagId) {
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

		if (!(obj instanceof LegalTDRelPK)) {
			return false;
		}

		LegalTDRelPK pk = (LegalTDRelPK)obj;

		if ((docId == pk.docId) && (tagId == pk.tagId)) {
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
		hashCode = HashUtil.hash(hashCode, tagId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("docId=");

		sb.append(docId);
		sb.append(", tagId=");

		sb.append(tagId);

		sb.append("}");

		return sb.toString();
	}

}