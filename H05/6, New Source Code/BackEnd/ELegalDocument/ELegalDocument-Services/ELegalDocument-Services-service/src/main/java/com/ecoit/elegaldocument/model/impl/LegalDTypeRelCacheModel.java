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

import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalDTypeRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDTypeRelCacheModel
	implements CacheModel<LegalDTypeRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDTypeRelCacheModel)) {
			return false;
		}

		LegalDTypeRelCacheModel legalDTypeRelCacheModel =
			(LegalDTypeRelCacheModel)obj;

		if (legalDTypeRelPK.equals(legalDTypeRelCacheModel.legalDTypeRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalDTypeRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDTypeRel toEntityModel() {
		LegalDTypeRelImpl legalDTypeRelImpl = new LegalDTypeRelImpl();

		legalDTypeRelImpl.setDocId(docId);
		legalDTypeRelImpl.setTypeId(typeId);

		legalDTypeRelImpl.resetOriginalValues();

		return legalDTypeRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docId = objectInput.readLong();

		typeId = objectInput.readLong();

		legalDTypeRelPK = new LegalDTypeRelPK(docId, typeId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(docId);

		objectOutput.writeLong(typeId);
	}

	public long docId;
	public long typeId;
	public transient LegalDTypeRelPK legalDTypeRelPK;

}