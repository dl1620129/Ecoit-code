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

import com.ecoit.elegaldocument.model.EcmsPGRelation;
import com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EcmsPGRelation in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class EcmsPGRelationCacheModel
	implements CacheModel<EcmsPGRelation>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EcmsPGRelationCacheModel)) {
			return false;
		}

		EcmsPGRelationCacheModel ecmsPGRelationCacheModel =
			(EcmsPGRelationCacheModel)obj;

		if (ecmsPGRelationPK.equals(
				ecmsPGRelationCacheModel.ecmsPGRelationPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ecmsPGRelationPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupUserId=");
		sb.append(groupUserId);
		sb.append(", permission=");
		sb.append(permission);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EcmsPGRelation toEntityModel() {
		EcmsPGRelationImpl ecmsPGRelationImpl = new EcmsPGRelationImpl();

		ecmsPGRelationImpl.setGroupUserId(groupUserId);
		ecmsPGRelationImpl.setPermission(permission);

		ecmsPGRelationImpl.resetOriginalValues();

		return ecmsPGRelationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupUserId = objectInput.readLong();

		permission = objectInput.readInt();

		ecmsPGRelationPK = new EcmsPGRelationPK(groupUserId, permission);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupUserId);

		objectOutput.writeInt(permission);
	}

	public long groupUserId;
	public int permission;
	public transient EcmsPGRelationPK ecmsPGRelationPK;

}