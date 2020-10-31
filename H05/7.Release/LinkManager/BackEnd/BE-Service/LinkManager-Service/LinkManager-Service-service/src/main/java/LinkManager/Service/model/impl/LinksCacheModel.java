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

import LinkManager.Service.model.Links;

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
 * The cache model class for representing Links in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class LinksCacheModel implements CacheModel<Links>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinksCacheModel)) {
			return false;
		}

		LinksCacheModel linksCacheModel = (LinksCacheModel)obj;

		if (linksid == linksCacheModel.linksid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, linksid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{linksid=");
		sb.append(linksid);
		sb.append(", groupid=");
		sb.append(groupid);
		sb.append(", createddate=");
		sb.append(createddate);
		sb.append(", modifieddate=");
		sb.append(modifieddate);
		sb.append(", linksgroupid=");
		sb.append(linksgroupid);
		sb.append(", name=");
		sb.append(name);
		sb.append(", decription=");
		sb.append(decription);
		sb.append(", url=");
		sb.append(url);
		sb.append(", imageid=");
		sb.append(imageid);
		sb.append(", hasimage=");
		sb.append(hasimage);
		sb.append(", position=");
		sb.append(position);
		sb.append(", show=");
		sb.append(show);
		sb.append(", icon=");
		sb.append(icon);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Links toEntityModel() {
		LinksImpl linksImpl = new LinksImpl();

		linksImpl.setLinksid(linksid);
		linksImpl.setGroupid(groupid);

		if (createddate == Long.MIN_VALUE) {
			linksImpl.setCreateddate(null);
		}
		else {
			linksImpl.setCreateddate(new Date(createddate));
		}

		if (modifieddate == Long.MIN_VALUE) {
			linksImpl.setModifieddate(null);
		}
		else {
			linksImpl.setModifieddate(new Date(modifieddate));
		}

		linksImpl.setLinksgroupid(linksgroupid);

		if (name == null) {
			linksImpl.setName("");
		}
		else {
			linksImpl.setName(name);
		}

		if (decription == null) {
			linksImpl.setDecription("");
		}
		else {
			linksImpl.setDecription(decription);
		}

		if (url == null) {
			linksImpl.setUrl("");
		}
		else {
			linksImpl.setUrl(url);
		}

		linksImpl.setImageid(imageid);
		linksImpl.setHasimage(hasimage);
		linksImpl.setPosition(position);
		linksImpl.setShow(show);
		linksImpl.setIcon(icon);
		linksImpl.setParentId(parentId);

		linksImpl.resetOriginalValues();

		return linksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		linksid = objectInput.readLong();

		groupid = objectInput.readLong();
		createddate = objectInput.readLong();
		modifieddate = objectInput.readLong();

		linksgroupid = objectInput.readLong();
		name = objectInput.readUTF();
		decription = objectInput.readUTF();
		url = objectInput.readUTF();

		imageid = objectInput.readLong();

		hasimage = objectInput.readBoolean();

		position = objectInput.readInt();

		show = objectInput.readBoolean();

		icon = objectInput.readBoolean();

		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(linksid);

		objectOutput.writeLong(groupid);
		objectOutput.writeLong(createddate);
		objectOutput.writeLong(modifieddate);

		objectOutput.writeLong(linksgroupid);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (decription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(decription);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(imageid);

		objectOutput.writeBoolean(hasimage);

		objectOutput.writeInt(position);

		objectOutput.writeBoolean(show);

		objectOutput.writeBoolean(icon);

		objectOutput.writeLong(parentId);
	}

	public long linksid;
	public long groupid;
	public long createddate;
	public long modifieddate;
	public long linksgroupid;
	public String name;
	public String decription;
	public String url;
	public long imageid;
	public boolean hasimage;
	public int position;
	public boolean show;
	public boolean icon;
	public long parentId;

}