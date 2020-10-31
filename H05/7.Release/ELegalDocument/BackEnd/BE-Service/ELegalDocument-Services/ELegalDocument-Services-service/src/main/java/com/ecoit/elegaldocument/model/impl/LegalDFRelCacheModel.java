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

import com.ecoit.elegaldocument.model.LegalDFRel;
import com.ecoit.elegaldocument.service.persistence.LegalDFRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalDFRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDFRelCacheModel
	implements CacheModel<LegalDFRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDFRelCacheModel)) {
			return false;
		}

		LegalDFRelCacheModel legalDFRelCacheModel = (LegalDFRelCacheModel)obj;

		if (legalDFRelPK.equals(legalDFRelCacheModel.legalDFRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalDFRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDFRel toEntityModel() {
		LegalDFRelImpl legalDFRelImpl = new LegalDFRelImpl();

		legalDFRelImpl.setDocId(docId);
		legalDFRelImpl.setFieldId(fieldId);

		legalDFRelImpl.resetOriginalValues();

		return legalDFRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docId = objectInput.readLong();

		fieldId = objectInput.readLong();

		legalDFRelPK = new LegalDFRelPK(docId, fieldId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(docId);

		objectOutput.writeLong(fieldId);
	}

	public long docId;
	public long fieldId;
	public transient LegalDFRelPK legalDFRelPK;

}