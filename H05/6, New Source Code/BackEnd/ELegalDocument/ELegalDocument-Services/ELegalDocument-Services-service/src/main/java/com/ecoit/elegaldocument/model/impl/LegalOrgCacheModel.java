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

import com.ecoit.elegaldocument.model.LegalOrg;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LegalOrg in entity cache.
 *
 * @author Liverpool
 * @generated
 */
public class LegalOrgCacheModel
	implements CacheModel<LegalOrg>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalOrgCacheModel)) {
			return false;
		}

		LegalOrgCacheModel legalOrgCacheModel = (LegalOrgCacheModel)obj;

		if (organizationId == legalOrgCacheModel.organizationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, organizationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{organizationId=");
		sb.append(organizationId);
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
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", language=");
		sb.append(language);
		sb.append(", statusOrg=");
		sb.append(statusOrg);
		sb.append(", rssable=");
		sb.append(rssable);
		sb.append(", position=");
		sb.append(position);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LegalOrg toEntityModel() {
		LegalOrgImpl legalOrgImpl = new LegalOrgImpl();

		legalOrgImpl.setOrganizationId(organizationId);
		legalOrgImpl.setGroupId(groupId);
		legalOrgImpl.setCompanyId(companyId);
		legalOrgImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			legalOrgImpl.setCreatedDate(null);
		}
		else {
			legalOrgImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			legalOrgImpl.setModifiedDate(null);
		}
		else {
			legalOrgImpl.setModifiedDate(new Date(modifiedDate));
		}

		legalOrgImpl.setCreatedByUser(createdByUser);
		legalOrgImpl.setModifiedByUser(modifiedByUser);

		if (name == null) {
			legalOrgImpl.setName("");
		}
		else {
			legalOrgImpl.setName(name);
		}

		if (description == null) {
			legalOrgImpl.setDescription("");
		}
		else {
			legalOrgImpl.setDescription(description);
		}

		if (language == null) {
			legalOrgImpl.setLanguage("");
		}
		else {
			legalOrgImpl.setLanguage(language);
		}

		legalOrgImpl.setStatusOrg(statusOrg);
		legalOrgImpl.setRssable(rssable);
		legalOrgImpl.setPosition(position);
		legalOrgImpl.setParentId(parentId);

		legalOrgImpl.resetOriginalValues();

		return legalOrgImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		organizationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByUser = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		language = objectInput.readUTF();

		statusOrg = objectInput.readBoolean();

		rssable = objectInput.readBoolean();

		position = objectInput.readInt();

		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(organizationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdByUser);

		objectOutput.writeLong(modifiedByUser);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeBoolean(statusOrg);

		objectOutput.writeBoolean(rssable);

		objectOutput.writeInt(position);

		objectOutput.writeLong(parentId);
	}

	public long organizationId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long createdByUser;
	public long modifiedByUser;
	public String name;
	public String description;
	public String language;
	public boolean statusOrg;
	public boolean rssable;
	public int position;
	public long parentId;

}