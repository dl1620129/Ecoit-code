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

import Album.service.model.Image;

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
 * The cache model class for representing Image in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ImageCacheModel implements CacheModel<Image>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageCacheModel)) {
			return false;
		}

		ImageCacheModel imageCacheModel = (ImageCacheModel)obj;

		if (imageId == imageCacheModel.imageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, imageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{imageId=");
		sb.append(imageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", addByUser=");
		sb.append(addByUser);
		sb.append(", addDate=");
		sb.append(addDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", fieldId=");
		sb.append(fieldId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", fileAttachId=");
		sb.append(fileAttachId);
		sb.append(", display=");
		sb.append(display);
		sb.append(", view=");
		sb.append(view);
		sb.append(", isDaiDien=");
		sb.append(isDaiDien);
		sb.append(", tacGia=");
		sb.append(tacGia);
		sb.append(", thuTu=");
		sb.append(thuTu);
		sb.append(", imageFileId=");
		sb.append(imageFileId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Image toEntityModel() {
		ImageImpl imageImpl = new ImageImpl();

		imageImpl.setImageId(imageId);
		imageImpl.setGroupId(groupId);
		imageImpl.setCompanyId(companyId);

		if (addByUser == null) {
			imageImpl.setAddByUser("");
		}
		else {
			imageImpl.setAddByUser(addByUser);
		}

		if (addDate == Long.MIN_VALUE) {
			imageImpl.setAddDate(null);
		}
		else {
			imageImpl.setAddDate(new Date(addDate));
		}

		if (modifiedByUser == null) {
			imageImpl.setModifiedByUser("");
		}
		else {
			imageImpl.setModifiedByUser(modifiedByUser);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			imageImpl.setModifiedDate(null);
		}
		else {
			imageImpl.setModifiedDate(new Date(modifiedDate));
		}

		imageImpl.setCategoryId(categoryId);
		imageImpl.setFieldId(fieldId);

		if (title == null) {
			imageImpl.setTitle("");
		}
		else {
			imageImpl.setTitle(title);
		}

		if (description == null) {
			imageImpl.setDescription("");
		}
		else {
			imageImpl.setDescription(description);
		}

		imageImpl.setFileAttachId(fileAttachId);
		imageImpl.setDisplay(display);
		imageImpl.setView(view);
		imageImpl.setIsDaiDien(isDaiDien);

		if (tacGia == null) {
			imageImpl.setTacGia("");
		}
		else {
			imageImpl.setTacGia(tacGia);
		}

		imageImpl.setThuTu(thuTu);
		imageImpl.setImageFileId(imageFileId);
		imageImpl.setFolderId(folderId);

		if (imageUrl == null) {
			imageImpl.setImageUrl("");
		}
		else {
			imageImpl.setImageUrl(imageUrl);
		}

		imageImpl.resetOriginalValues();

		return imageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		imageId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		addByUser = objectInput.readUTF();
		addDate = objectInput.readLong();
		modifiedByUser = objectInput.readUTF();
		modifiedDate = objectInput.readLong();

		categoryId = objectInput.readLong();

		fieldId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		fileAttachId = objectInput.readLong();

		display = objectInput.readBoolean();

		view = objectInput.readLong();

		isDaiDien = objectInput.readBoolean();
		tacGia = objectInput.readUTF();

		thuTu = objectInput.readInt();

		imageFileId = objectInput.readLong();

		folderId = objectInput.readLong();
		imageUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(imageId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (addByUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addByUser);
		}

		objectOutput.writeLong(addDate);

		if (modifiedByUser == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedByUser);
		}

		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(categoryId);

		objectOutput.writeLong(fieldId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(fileAttachId);

		objectOutput.writeBoolean(display);

		objectOutput.writeLong(view);

		objectOutput.writeBoolean(isDaiDien);

		if (tacGia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tacGia);
		}

		objectOutput.writeInt(thuTu);

		objectOutput.writeLong(imageFileId);

		objectOutput.writeLong(folderId);

		if (imageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}
	}

	public long imageId;
	public long groupId;
	public long companyId;
	public String addByUser;
	public long addDate;
	public String modifiedByUser;
	public long modifiedDate;
	public long categoryId;
	public long fieldId;
	public String title;
	public String description;
	public long fileAttachId;
	public boolean display;
	public long view;
	public boolean isDaiDien;
	public String tacGia;
	public int thuTu;
	public long imageFileId;
	public long folderId;
	public String imageUrl;

}