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

import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.service.persistence.LegalDSRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalDSRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDSRelCacheModel
	implements CacheModel<LegalDSRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDSRelCacheModel)) {
			return false;
		}

		LegalDSRelCacheModel legalDSRelCacheModel = (LegalDSRelCacheModel)obj;

		if (legalDSRelPK.equals(legalDSRelCacheModel.legalDSRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalDSRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{docId=");
		sb.append(docId);
		sb.append(", sigId=");
		sb.append(sigId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDSRel toEntityModel() {
		LegalDSRelImpl legalDSRelImpl = new LegalDSRelImpl();

		legalDSRelImpl.setDocId(docId);
		legalDSRelImpl.setSigId(sigId);

		legalDSRelImpl.resetOriginalValues();

		return legalDSRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		docId = objectInput.readLong();

		sigId = objectInput.readLong();

		legalDSRelPK = new LegalDSRelPK(docId, sigId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(docId);

		objectOutput.writeLong(sigId);
	}

	public long docId;
	public long sigId;
	public transient LegalDSRelPK legalDSRelPK;

}