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

package com.software.cms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.software.cms.model.PermissionGroup;
import com.software.cms.service.persistence.PermissionGroupPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PermissionGroup in entity cache.
 *
 * @author DungNV
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
		StringBundler sb = new StringBundler(7);

		sb.append("{permissionId=");
		sb.append(permissionId);
		sb.append(", groupuserid=");
		sb.append(groupuserid);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PermissionGroup toEntityModel() {
		PermissionGroupImpl permissionGroupImpl = new PermissionGroupImpl();

		permissionGroupImpl.setPermissionId(permissionId);
		permissionGroupImpl.setGroupuserid(groupuserid);
		permissionGroupImpl.setGroupId(groupId);

		permissionGroupImpl.resetOriginalValues();

		return permissionGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		permissionId = objectInput.readLong();

		groupuserid = objectInput.readLong();

		groupId = objectInput.readLong();

		permissionGroupPK = new PermissionGroupPK(permissionId, groupuserid);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(permissionId);

		objectOutput.writeLong(groupuserid);

		objectOutput.writeLong(groupId);
	}

	public long permissionId;
	public long groupuserid;
	public long groupId;
	public transient PermissionGroupPK permissionGroupPK;

}