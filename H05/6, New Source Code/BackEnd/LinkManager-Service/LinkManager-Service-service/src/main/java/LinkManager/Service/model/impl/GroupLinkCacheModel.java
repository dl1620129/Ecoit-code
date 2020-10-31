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

package LinkManager.Service.model.impl;

import LinkManager.Service.model.GroupLink;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing GroupLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GroupLinkCacheModel
	implements CacheModel<GroupLink>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GroupLinkCacheModel)) {
			return false;
		}

		GroupLinkCacheModel groupLinkCacheModel = (GroupLinkCacheModel)obj;

		if (linksgroupid == groupLinkCacheModel.linksgroupid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, linksgroupid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{linksgroupid=");
		sb.append(linksgroupid);
		sb.append(", groupid=");
		sb.append(groupid);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createddate=");
		sb.append(createddate);
		sb.append(", modifieddate=");
		sb.append(modifieddate);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GroupLink toEntityModel() {
		GroupLinkImpl groupLinkImpl = new GroupLinkImpl();

		groupLinkImpl.setLinksgroupid(linksgroupid);
		groupLinkImpl.setGroupid(groupid);
		groupLinkImpl.setCreateUserId(createUserId);

		if (createddate == Long.MIN_VALUE) {
			groupLinkImpl.setCreateddate(null);
		}
		else {
			groupLinkImpl.setCreateddate(new Date(createddate));
		}

		if (modifieddate == Long.MIN_VALUE) {
			groupLinkImpl.setModifieddate(null);
		}
		else {
			groupLinkImpl.setModifieddate(new Date(modifieddate));
		}

		if (groupName == null) {
			groupLinkImpl.setGroupName("");
		}
		else {
			groupLinkImpl.setGroupName(groupName);
		}

		if (description == null) {
			groupLinkImpl.setDescription("");
		}
		else {
			groupLinkImpl.setDescription(description);
		}

		groupLinkImpl.resetOriginalValues();

		return groupLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		linksgroupid = objectInput.readLong();

		groupid = objectInput.readLong();

		createUserId = objectInput.readLong();
		createddate = objectInput.readLong();
		modifieddate = objectInput.readLong();
		groupName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(linksgroupid);

		objectOutput.writeLong(groupid);

		objectOutput.writeLong(createUserId);
		objectOutput.writeLong(createddate);
		objectOutput.writeLong(modifieddate);

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
	}

	public long linksgroupid;
	public long groupid;
	public long createUserId;
	public long createddate;
	public long modifieddate;
	public String groupName;
	public String description;

}