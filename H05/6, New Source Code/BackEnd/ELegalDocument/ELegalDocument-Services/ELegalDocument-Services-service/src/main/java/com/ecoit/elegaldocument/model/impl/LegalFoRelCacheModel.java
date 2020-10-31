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

import com.ecoit.elegaldocument.model.LegalFoRel;
import com.ecoit.elegaldocument.service.persistence.LegalFoRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalFoRel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalFoRelCacheModel
	implements CacheModel<LegalFoRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalFoRelCacheModel)) {
			return false;
		}

		LegalFoRelCacheModel legalFoRelCacheModel = (LegalFoRelCacheModel)obj;

		if (legalFoRelPK.equals(legalFoRelCacheModel.legalFoRelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalFoRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{fieldId=");
		sb.append(fieldId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalFoRel toEntityModel() {
		LegalFoRelImpl legalFoRelImpl = new LegalFoRelImpl();

		legalFoRelImpl.setFieldId(fieldId);
		legalFoRelImpl.setOrganizationId(organizationId);

		legalFoRelImpl.resetOriginalValues();

		return legalFoRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fieldId = objectInput.readLong();

		organizationId = objectInput.readLong();

		legalFoRelPK = new LegalFoRelPK(fieldId, organizationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fieldId);

		objectOutput.writeLong(organizationId);
	}

	public long fieldId;
	public long organizationId;
	public transient LegalFoRelPK legalFoRelPK;

}