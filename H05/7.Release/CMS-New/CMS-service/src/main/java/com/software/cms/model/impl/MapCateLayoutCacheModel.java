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

import com.software.cms.model.MapCateLayout;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MapCateLayout in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class MapCateLayoutCacheModel
	implements CacheModel<MapCateLayout>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MapCateLayoutCacheModel)) {
			return false;
		}

		MapCateLayoutCacheModel mapCateLayoutCacheModel =
			(MapCateLayoutCacheModel)obj;

		if (mapCateLayoutId == mapCateLayoutCacheModel.mapCateLayoutId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mapCateLayoutId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", mapCateLayoutId=");
		sb.append(mapCateLayoutId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", layoutId=");
		sb.append(layoutId);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MapCateLayout toEntityModel() {
		MapCateLayoutImpl mapCateLayoutImpl = new MapCateLayoutImpl();

		if (uuid == null) {
			mapCateLayoutImpl.setUuid("");
		}
		else {
			mapCateLayoutImpl.setUuid(uuid);
		}

		mapCateLayoutImpl.setMapCateLayoutId(mapCateLayoutId);
		mapCateLayoutImpl.setCompanyId(companyId);
		mapCateLayoutImpl.setGroupId(groupId);
		mapCateLayoutImpl.setCategoryId(categoryId);
		mapCateLayoutImpl.setLayoutId(layoutId);
		mapCateLayoutImpl.setType(type);

		mapCateLayoutImpl.resetOriginalValues();

		return mapCateLayoutImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		mapCateLayoutId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		categoryId = objectInput.readLong();

		layoutId = objectInput.readLong();

		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(mapCateLayoutId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(layoutId);

		objectOutput.writeInt(type);
	}

	public String uuid;
	public long mapCateLayoutId;
	public long companyId;
	public long groupId;
	public long categoryId;
	public long layoutId;
	public int type;

}