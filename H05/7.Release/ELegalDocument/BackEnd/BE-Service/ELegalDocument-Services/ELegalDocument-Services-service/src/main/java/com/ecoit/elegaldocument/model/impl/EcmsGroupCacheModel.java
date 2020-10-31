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

import com.ecoit.elegaldocument.model.EcmsGroup;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EcmsGroup in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class EcmsGroupCacheModel
	implements CacheModel<EcmsGroup>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EcmsGroupCacheModel)) {
			return false;
		}

		EcmsGroupCacheModel ecmsGroupCacheModel = (EcmsGroupCacheModel)obj;

		if (groupUserId == ecmsGroupCacheModel.groupUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groupUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{groupUserId=");
		sb.append(groupUserId);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EcmsGroup toEntityModel() {
		EcmsGroupImpl ecmsGroupImpl = new EcmsGroupImpl();

		ecmsGroupImpl.setGroupUserId(groupUserId);

		if (groupName == null) {
			ecmsGroupImpl.setGroupName("");
		}
		else {
			ecmsGroupImpl.setGroupName(groupName);
		}

		if (description == null) {
			ecmsGroupImpl.setDescription("");
		}
		else {
			ecmsGroupImpl.setDescription(description);
		}

		ecmsGroupImpl.setGroupId(groupId);

		if (createdDate == Long.MIN_VALUE) {
			ecmsGroupImpl.setCreatedDate(null);
		}
		else {
			ecmsGroupImpl.setCreatedDate(new Date(createdDate));
		}

		ecmsGroupImpl.resetOriginalValues();

		return ecmsGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupUserId = objectInput.readLong();
		groupName = objectInput.readUTF();
		description = objectInput.readUTF();

		groupId = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupUserId);

		if (groupName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdDate);
	}

	public long groupUserId;
	public String groupName;
	public String description;
	public long groupId;
	public long createdDate;

}