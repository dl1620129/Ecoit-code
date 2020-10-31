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

import com.ecoit.elegaldocument.model.LegalDURel;
import com.ecoit.elegaldocument.service.persistence.LegalDURelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LegalDURel in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalDURelCacheModel
	implements CacheModel<LegalDURel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDURelCacheModel)) {
			return false;
		}

		LegalDURelCacheModel legalDURelCacheModel = (LegalDURelCacheModel)obj;

		if (legalDURelPK.equals(legalDURelCacheModel.legalDURelPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, legalDURelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{departmentId=");
		sb.append(departmentId);
		sb.append(", userid=");
		sb.append(userid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalDURel toEntityModel() {
		LegalDURelImpl legalDURelImpl = new LegalDURelImpl();

		legalDURelImpl.setDepartmentId(departmentId);
		legalDURelImpl.setUserid(userid);

		legalDURelImpl.resetOriginalValues();

		return legalDURelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		departmentId = objectInput.readLong();

		userid = objectInput.readLong();

		legalDURelPK = new LegalDURelPK(departmentId, userid);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(departmentId);

		objectOutput.writeLong(userid);
	}

	public long departmentId;
	public long userid;
	public transient LegalDURelPK legalDURelPK;

}