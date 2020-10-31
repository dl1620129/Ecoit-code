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

package com.ecoit.mr.model.impl;

import com.ecoit.mr.model.PermissionGroup;
import com.ecoit.mr.service.persistence.PermissionGroupPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PermissionGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PermissionGroupCacheModel
	implements CacheModel<PermissionGroup>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PermissionGroupCacheModel)) {
			return false;
		}

		PermissionGroupCacheModel permissionGroupCacheModel =
			(PermissionGroupCacheModel)obj;

		if (permissionGroupPK.equals(
				permissionGroupCacheModel.permissionGroupPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, permissionGroupPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{userPermissionGroupId=");
		sb.append(userPermissionGroupId);
		sb.append(", permissionId=");
		sb.append(permissionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PermissionGroup toEntityModel() {
		PermissionGroupImpl permissionGroupImpl = new PermissionGroupImpl();

		permissionGroupImpl.setUserPermissionGroupId(userPermissionGroupId);
		permissionGroupImpl.setPermissionId(permissionId);

		permissionGroupImpl.resetOriginalValues();

		return permissionGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userPermissionGroupId = objectInput.readLong();

		permissionId = objectInput.readInt();

		permissionGroupPK = new PermissionGroupPK(
			userPermissionGroupId, permissionId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userPermissionGroupId);

		objectOutput.writeInt(permissionId);
	}

	public long userPermissionGroupId;
	public int permissionId;
	public transient PermissionGroupPK permissionGroupPK;

}