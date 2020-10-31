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

import com.ecoit.elegaldocument.model.LegalFTRel;
import com.ecoit.elegaldocument.service.persistence.LegalFTRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalFTRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalFTRelCacheModel
	implements CacheModel<LegalFTRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalFTRelCacheModel)) {
			return false;
		}

		LegalFTRelCacheModel legalFTRelCacheModel = (LegalFTRelCacheModel)obj;

		if (legalFTRelPK.equals(legalFTRelCacheModel.legalFTRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalFTRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fieldId=");
		sb.append(fieldId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalFTRel toEntityModel() {
		LegalFTRelImpl legalFTRelImpl = new LegalFTRelImpl();

		legalFTRelImpl.setFieldId(fieldId);
		legalFTRelImpl.setTypeId(typeId);

		legalFTRelImpl.resetOriginalValues();

		return legalFTRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fieldId = objectInput.readLong();

		typeId = objectInput.readLong();

		legalFTRelPK = new LegalFTRelPK(fieldId, typeId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fieldId);

		objectOutput.writeLong(typeId);
	}

	public long fieldId;
	public long typeId;
	public transient LegalFTRelPK legalFTRelPK;

}