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

import com.software.cms.model.Tag;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Tag in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class TagCacheModel implements CacheModel<Tag>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TagCacheModel)) {
			return false;
		}

		TagCacheModel tagCacheModel = (TagCacheModel)obj;

		if (tagId == tagCacheModel.tagId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tagId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tagId=");
		sb.append(tagId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", tagName=");
		sb.append(tagName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tag toEntityModel() {
		TagImpl tagImpl = new TagImpl();

		if (uuid == null) {
			tagImpl.setUuid("");
		}
		else {
			tagImpl.setUuid(uuid);
		}

		tagImpl.setTagId(tagId);
		tagImpl.setGroupId(groupId);

		if (language == null) {
			tagImpl.setLanguage("");
		}
		else {
			tagImpl.setLanguage(language);
		}

		if (tagName == null) {
			tagImpl.setTagName("");
		}
		else {
			tagImpl.setTagName(tagName);
		}

		if (description == null) {
			tagImpl.setDescription("");
		}
		else {
			tagImpl.setDescription(description);
		}

		tagImpl.resetOriginalValues();

		return tagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tagId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();
		tagName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(tagId);

		objectOutput.writeLong(groupId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (tagName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tagName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long tagId;
	public long groupId;
	public String language;
	public String tagName;
	public String description;

}