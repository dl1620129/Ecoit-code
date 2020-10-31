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

import com.software.cms.model.Category;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class CategoryCacheModel
	implements CacheModel<Category>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryCacheModel)) {
			return false;
		}

		CategoryCacheModel categoryCacheModel = (CategoryCacheModel)obj;

		if (categoryId == categoryCacheModel.categoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, categoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", title=");
		sb.append(title);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdUser=");
		sb.append(createdUser);
		sb.append(", modifiedUser=");
		sb.append(modifiedUser);
		sb.append(", path=");
		sb.append(path);
		sb.append(", description=");
		sb.append(description);
		sb.append(", display=");
		sb.append(display);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", active=");
		sb.append(active);
		sb.append(", cateChild=");
		sb.append(cateChild);
		sb.append(", thuTu=");
		sb.append(thuTu);
		sb.append(", link=");
		sb.append(link);
		sb.append(", isRss=");
		sb.append(isRss);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		if (uuid == null) {
			categoryImpl.setUuid("");
		}
		else {
			categoryImpl.setUuid(uuid);
		}

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setGroupId(groupId);

		if (language == null) {
			categoryImpl.setLanguage("");
		}
		else {
			categoryImpl.setLanguage(language);
		}

		if (title == null) {
			categoryImpl.setTitle("");
		}
		else {
			categoryImpl.setTitle(title);
		}

		if (createdDate == Long.MIN_VALUE) {
			categoryImpl.setCreatedDate(null);
		}
		else {
			categoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryImpl.setModifiedDate(null);
		}
		else {
			categoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		categoryImpl.setCreatedUser(createdUser);
		categoryImpl.setModifiedUser(modifiedUser);

		if (path == null) {
			categoryImpl.setPath("");
		}
		else {
			categoryImpl.setPath(path);
		}

		if (description == null) {
			categoryImpl.setDescription("");
		}
		else {
			categoryImpl.setDescription(description);
		}

		categoryImpl.setDisplay(display);
		categoryImpl.setParentId(parentId);
		categoryImpl.setActive(active);

		if (cateChild == null) {
			categoryImpl.setCateChild("");
		}
		else {
			categoryImpl.setCateChild(cateChild);
		}

		categoryImpl.setThuTu(thuTu);

		if (link == null) {
			categoryImpl.setLink("");
		}
		else {
			categoryImpl.setLink(link);
		}

		categoryImpl.setIsRss(isRss);

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		categoryId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdUser = objectInput.readLong();

		modifiedUser = objectInput.readLong();
		path = objectInput.readUTF();
		description = objectInput.readUTF();

		display = objectInput.readBoolean();

		parentId = objectInput.readLong();

		active = objectInput.readLong();
		cateChild = objectInput.readUTF();

		thuTu = objectInput.readInt();
		link = objectInput.readUTF();

		isRss = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(groupId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdUser);

		objectOutput.writeLong(modifiedUser);

		if (path == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(path);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(display);

		objectOutput.writeLong(parentId);

		objectOutput.writeLong(active);

		if (cateChild == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cateChild);
		}

		objectOutput.writeInt(thuTu);

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeBoolean(isRss);
	}

	public String uuid;
	public long categoryId;
	public long groupId;
	public String language;
	public String title;
	public long createdDate;
	public long modifiedDate;
	public long createdUser;
	public long modifiedUser;
	public String path;
	public String description;
	public boolean display;
	public long parentId;
	public long active;
	public String cateChild;
	public int thuTu;
	public String link;
	public boolean isRss;

}