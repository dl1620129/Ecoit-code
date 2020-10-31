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

package Album.service.model.impl;

import Album.service.model.Category;

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
 * The cache model class for representing Category in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
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
		StringBundler sb = new StringBundler(35);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createByUser=");
		sb.append(createByUser);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", view=");
		sb.append(view);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", tacGiaAlbum=");
		sb.append(tacGiaAlbum);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", thuTu=");
		sb.append(thuTu);
		sb.append(", isDaiDien=");
		sb.append(isDaiDien);
		sb.append(", urlImage=");
		sb.append(urlImage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(categoryId);
		categoryImpl.setGroupId(groupId);
		categoryImpl.setCompanyId(companyId);

		if (createByUser == null) {
			categoryImpl.setCreateByUser("");
		}
		else {
			categoryImpl.setCreateByUser(createByUser);
		}

		if (createDate == Long.MIN_VALUE) {
			categoryImpl.setCreateDate(null);
		}
		else {
			categoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedByUser == null) {
			categoryImpl.setModifiedByUser("");
		}
		else {
			categoryImpl.setModifiedByUser(modifiedByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			categoryImpl.setModifiedDate(null);
		}
		else {
			categoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		categoryImpl.setView(view);
		categoryImpl.setParentId(parentId);

		if (name == null) {
			categoryImpl.setName("");
		}
		else {
			categoryImpl.setName(name);
		}

		if (description == null) {
			categoryImpl.setDescription("");
		}
		else {
			categoryImpl.setDescription(description);
		}

		if (tacGiaAlbum == null) {
			categoryImpl.setTacGiaAlbum("");
		}
		else {
			categoryImpl.setTacGiaAlbum(tacGiaAlbum);
		}

		categoryImpl.setFieldId(fieldId);
		categoryImpl.setStatus(status);
		categoryImpl.setThuTu(thuTu);
		categoryImpl.setIsDaiDien(isDaiDien);

		if (urlImage == null) {
			categoryImpl.setUrlImage("");
		}
		else {
			categoryImpl.setUrlImage(urlImage);
		}

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createByUser = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedByUser = objectInput.readUTF();
		modifiedDate = objectInput.readLong();

		view = objectInput.readLong();

		parentId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		tacGiaAlbum = objectInput.readUTF();

		fieldId = objectInput.readLong();

		status = objectInput.readLong();

		thuTu = objectInput.readInt();

		isDaiDien = objectInput.readBoolean();
		urlImage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (createByUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createByUser);
		}

		objectOutput.writeLong(createDate);

		if (modifiedByUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedByUser);
		}

		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(view);

		objectOutput.writeLong(parentId);

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

		if (tacGiaAlbum == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tacGiaAlbum);
		}

		objectOutput.writeLong(fieldId);

		objectOutput.writeLong(status);

		objectOutput.writeInt(thuTu);

		objectOutput.writeBoolean(isDaiDien);

		if (urlImage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlImage);
		}
	}

	public long categoryId;
	public long groupId;
	public long companyId;
	public String createByUser;
	public long createDate;
	public String modifiedByUser;
	public long modifiedDate;
	public long view;
	public long parentId;
	public String name;
	public String description;
	public String tacGiaAlbum;
	public long fieldId;
	public long status;
	public int thuTu;
	public boolean isDaiDien;
	public String urlImage;

}