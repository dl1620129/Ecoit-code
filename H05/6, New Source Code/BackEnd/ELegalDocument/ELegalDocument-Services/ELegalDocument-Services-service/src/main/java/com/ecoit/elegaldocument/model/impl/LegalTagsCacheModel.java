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

import com.ecoit.elegaldocument.model.LegalTags;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalTags in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalTagsCacheModel
	implements CacheModel<LegalTags>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalTagsCacheModel)) {
			return false;
		}

		LegalTagsCacheModel legalTagsCacheModel = (LegalTagsCacheModel)obj;

		if (tagId == legalTagsCacheModel.tagId) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{tagId=");
		sb.append(tagId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", statusTags=");
		sb.append(statusTags);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalTags toEntityModel() {
		LegalTagsImpl legalTagsImpl = new LegalTagsImpl();

		legalTagsImpl.setTagId(tagId);
		legalTagsImpl.setGroupId(groupId);
		legalTagsImpl.setCompanyId(companyId);
		legalTagsImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalTagsImpl.setCreatedDate(null);
		}
		else {
			legalTagsImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalTagsImpl.setModifiedDate(null);
		}
		else {
			legalTagsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			legalTagsImpl.setName("");
		}
		else {
			legalTagsImpl.setName(name);
		}

		legalTagsImpl.setStatusTags(statusTags);

		legalTagsImpl.resetOriginalValues();

		return legalTagsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tagId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		statusTags = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tagId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(statusTags);
	}

	public long tagId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String name;
	public boolean statusTags;

}