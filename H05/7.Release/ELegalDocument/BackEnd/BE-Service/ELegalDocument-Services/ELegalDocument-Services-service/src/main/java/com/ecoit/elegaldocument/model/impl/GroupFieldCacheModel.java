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

import com.ecoit.elegaldocument.model.GroupField;
import com.ecoit.elegaldocument.service.persistence.GroupFieldPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GroupField in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class GroupFieldCacheModel
	implements CacheModel<GroupField>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroupFieldCacheModel)) {
			return false;
		}

		GroupFieldCacheModel groupFieldCacheModel = (GroupFieldCacheModel)obj;

		if (groupFieldPK.equals(groupFieldCacheModel.groupFieldPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, groupFieldPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{groupUserId=");
		sb.append(groupUserId);
		sb.append(", fieldid=");
		sb.append(fieldid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GroupField toEntityModel() {
		GroupFieldImpl groupFieldImpl = new GroupFieldImpl();

		groupFieldImpl.setGroupUserId(groupUserId);
		groupFieldImpl.setFieldid(fieldid);

		groupFieldImpl.resetOriginalValues();

		return groupFieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupUserId = objectInput.readLong();

		fieldid = objectInput.readLong();

		groupFieldPK = new GroupFieldPK(groupUserId, fieldid);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(groupUserId);

		objectOutput.writeLong(fieldid);
	}

	public long groupUserId;
	public long fieldid;
	public transient GroupFieldPK groupFieldPK;

}