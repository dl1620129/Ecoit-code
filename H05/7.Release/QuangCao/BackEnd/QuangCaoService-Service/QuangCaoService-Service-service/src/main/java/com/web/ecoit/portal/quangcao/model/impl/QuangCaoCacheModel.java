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

package com.web.ecoit.portal.quangcao.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.web.ecoit.portal.quangcao.model.QuangCao;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing QuangCao in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class QuangCaoCacheModel
	implements CacheModel<QuangCao>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuangCaoCacheModel)) {
			return false;
		}

		QuangCaoCacheModel quangCaoCacheModel = (QuangCaoCacheModel)obj;

		if (quangCaoId == quangCaoCacheModel.quangCaoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quangCaoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", quangCaoId=");
		sb.append(quangCaoId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", tenQuangCao=");
		sb.append(tenQuangCao);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", target=");
		sb.append(target);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", url=");
		sb.append(url);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuangCao toEntityModel() {
		QuangCaoImpl quangCaoImpl = new QuangCaoImpl();

		if (uuid == null) {
			quangCaoImpl.setUuid("");
		}
		else {
			quangCaoImpl.setUuid(uuid);
		}

		quangCaoImpl.setQuangCaoId(quangCaoId);
		quangCaoImpl.setGroupId(groupId);

		if (language == null) {
			quangCaoImpl.setLanguage("");
		}
		else {
			quangCaoImpl.setLanguage(language);
		}

		quangCaoImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			quangCaoImpl.setCreateDate(null);
		}
		else {
			quangCaoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			quangCaoImpl.setModifiedDate(null);
		}
		else {
			quangCaoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tenQuangCao == null) {
			quangCaoImpl.setTenQuangCao("");
		}
		else {
			quangCaoImpl.setTenQuangCao(tenQuangCao);
		}

		if (moTa == null) {
			quangCaoImpl.setMoTa("");
		}
		else {
			quangCaoImpl.setMoTa(moTa);
		}

		quangCaoImpl.setTarget(target);
		quangCaoImpl.setImageId(imageId);

		if (url == null) {
			quangCaoImpl.setUrl("");
		}
		else {
			quangCaoImpl.setUrl(url);
		}

		quangCaoImpl.setType(type);
		quangCaoImpl.setStatus(status);

		quangCaoImpl.resetOriginalValues();

		return quangCaoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		quangCaoId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tenQuangCao = objectInput.readUTF();
		moTa = objectInput.readUTF();

		target = objectInput.readBoolean();

		imageId = objectInput.readLong();
		url = objectInput.readUTF();

		type = objectInput.readInt();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(quangCaoId);

		objectOutput.writeLong(groupId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (tenQuangCao == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenQuangCao);
		}

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		objectOutput.writeBoolean(target);

		objectOutput.writeLong(imageId);

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeInt(type);

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long quangCaoId;
	public long groupId;
	public String language;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String tenQuangCao;
	public String moTa;
	public boolean target;
	public long imageId;
	public String url;
	public int type;
	public int status;

}