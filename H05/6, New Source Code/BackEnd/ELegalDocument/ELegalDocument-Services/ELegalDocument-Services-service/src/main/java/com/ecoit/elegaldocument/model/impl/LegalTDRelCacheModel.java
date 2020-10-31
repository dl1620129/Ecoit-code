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

package com.ecoit.elegaldocument.model.impl;

import com.ecoit.elegaldocument.model.LegalTDRel;
import com.ecoit.elegaldocument.service.persistence.LegalTDRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalTDRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalTDRelCacheModel
	implements CacheModel<LegalTDRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalTDRelCacheModel)) {
			return false;
		}

		LegalTDRelCacheModel legalTDRelCacheModel = (LegalTDRelCacheModel)obj;

		if (legalTDRelPK.equals(legalTDRelCacheModel.legalTDRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalTDRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", tagId=");
		sb.append(tagId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalTDRel toEntityModel() {
		LegalTDRelImpl legalTDRelImpl = new LegalTDRelImpl();

		legalTDRelImpl.setDocId(docId);
		legalTDRelImpl.setTagId(tagId);

		legalTDRelImpl.resetOriginalValues();

		return legalTDRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docId = objectInput.readLong();

		tagId = objectInput.readLong();

		legalTDRelPK = new LegalTDRelPK(docId, tagId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(docId);

		objectOutput.writeLong(tagId);
	}

	public long docId;
	public long tagId;
	public transient LegalTDRelPK legalTDRelPK;

}