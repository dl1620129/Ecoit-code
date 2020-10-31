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

package com.ecoit.lichcongtac.services.model.impl;

import com.ecoit.lichcongtac.services.model.ColumnGroupRel;
import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ColumnGroupRel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ColumnGroupRelCacheModel
	implements CacheModel<ColumnGroupRel>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ColumnGroupRelCacheModel)) {
			return false;
		}

		ColumnGroupRelCacheModel columnGroupRelCacheModel =
			(ColumnGroupRelCacheModel)obj;

		if (columnGroupRelPK.equals(
				columnGroupRelCacheModel.columnGroupRelPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, columnGroupRelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userPermissionGroupId=");
		sb.append(userPermissionGroupId);
		sb.append(", columnId=");
		sb.append(columnId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ColumnGroupRel toEntityModel() {
		ColumnGroupRelImpl columnGroupRelImpl = new ColumnGroupRelImpl();

		columnGroupRelImpl.setUserPermissionGroupId(userPermissionGroupId);
		columnGroupRelImpl.setColumnId(columnId);

		columnGroupRelImpl.resetOriginalValues();

		return columnGroupRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userPermissionGroupId = objectInput.readLong();

		columnId = objectInput.readInt();

		columnGroupRelPK = new ColumnGroupRelPK(
			userPermissionGroupId, columnId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userPermissionGroupId);

		objectOutput.writeInt(columnId);
	}

	public long userPermissionGroupId;
	public int columnId;
	public transient ColumnGroupRelPK columnGroupRelPK;

}