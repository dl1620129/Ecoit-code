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

import com.ecoit.elegaldocument.model.EcmsGURelation;
import com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EcmsGURelation in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class EcmsGURelationCacheModel
	implements CacheModel<EcmsGURelation>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EcmsGURelationCacheModel)) {
			return false;
		}

		EcmsGURelationCacheModel ecmsGURelationCacheModel =
			(EcmsGURelationCacheModel)obj;

		if (ecmsGURelationPK.equals(
				ecmsGURelationCacheModel.ecmsGURelationPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ecmsGURelationPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", groupUserId=");
		sb.append(groupUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EcmsGURelation toEntityModel() {
		EcmsGURelationImpl ecmsGURelationImpl = new EcmsGURelationImpl();

		ecmsGURelationImpl.setUserId(userId);
		ecmsGURelationImpl.setGroupUserId(groupUserId);

		ecmsGURelationImpl.resetOriginalValues();

		return ecmsGURelationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		groupUserId = objectInput.readLong();

		ecmsGURelationPK = new EcmsGURelationPK(userId, groupUserId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupUserId);
	}

	public long userId;
	public long groupUserId;
	public transient EcmsGURelationPK ecmsGURelationPK;

}