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

import com.ecoit.elegaldocument.model.LegalDDRel;
import com.ecoit.elegaldocument.service.persistence.LegalDDRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalDDRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDDRelCacheModel
	implements CacheModel<LegalDDRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDDRelCacheModel)) {
			return false;
		}

		LegalDDRelCacheModel legalDDRelCacheModel = (LegalDDRelCacheModel)obj;

		if (legalDDRelPK.equals(legalDDRelCacheModel.legalDDRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalDDRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{departmentId=");
		sb.append(departmentId);
		sb.append(", docId=");
		sb.append(docId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDDRel toEntityModel() {
		LegalDDRelImpl legalDDRelImpl = new LegalDDRelImpl();

		legalDDRelImpl.setDepartmentId(departmentId);

		if (docId == null) {
			legalDDRelImpl.setDocId("");
		}
		else {
			legalDDRelImpl.setDocId(docId);
		}

		legalDDRelImpl.resetOriginalValues();

		return legalDDRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		departmentId = objectInput.readLong();
		docId = objectInput.readUTF();

		legalDDRelPK = new LegalDDRelPK(departmentId, docId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(departmentId);

		if (docId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(docId);
		}
	}

	public long departmentId;
	public String docId;
	public transient LegalDDRelPK legalDDRelPK;

}