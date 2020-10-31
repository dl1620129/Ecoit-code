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

package adv.model.impl;

import adv.model.QuangCaoSlider;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuangCaoSlider in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuangCaoSliderCacheModel
	implements CacheModel<QuangCaoSlider>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuangCaoSliderCacheModel)) {
			return false;
		}

		QuangCaoSliderCacheModel quangCaoSliderCacheModel =
			(QuangCaoSliderCacheModel)obj;

		if (quangCaoSliderId == quangCaoSliderCacheModel.quangCaoSliderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, quangCaoSliderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", quangCaoSliderId=");
		sb.append(quangCaoSliderId);
		sb.append(", quangCaoId=");
		sb.append(quangCaoId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", url=");
		sb.append(url);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuangCaoSlider toEntityModel() {
		QuangCaoSliderImpl quangCaoSliderImpl = new QuangCaoSliderImpl();

		if (uuid == null) {
			quangCaoSliderImpl.setUuid("");
		}
		else {
			quangCaoSliderImpl.setUuid(uuid);
		}

		quangCaoSliderImpl.setQuangCaoSliderId(quangCaoSliderId);
		quangCaoSliderImpl.setQuangCaoId(quangCaoId);
		quangCaoSliderImpl.setGroupId(groupId);
		quangCaoSliderImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			quangCaoSliderImpl.setCreateDate(null);
		}
		else {
			quangCaoSliderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			quangCaoSliderImpl.setModifiedDate(null);
		}
		else {
			quangCaoSliderImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tenQuangCao == null) {
			quangCaoSliderImpl.setTenQuangCao("");
		}
		else {
			quangCaoSliderImpl.setTenQuangCao(tenQuangCao);
		}

		if (moTa == null) {
			quangCaoSliderImpl.setMoTa("");
		}
		else {
			quangCaoSliderImpl.setMoTa(moTa);
		}

		quangCaoSliderImpl.setTarget(target);

		if (url == null) {
			quangCaoSliderImpl.setUrl("");
		}
		else {
			quangCaoSliderImpl.setUrl(url);
		}

		quangCaoSliderImpl.setType(type);

		quangCaoSliderImpl.resetOriginalValues();

		return quangCaoSliderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		quangCaoSliderId = objectInput.readLong();

		quangCaoId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tenQuangCao = objectInput.readUTF();
		moTa = objectInput.readUTF();

		target = objectInput.readBoolean();
		url = objectInput.readUTF();

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

		objectOutput.writeLong(quangCaoSliderId);

		objectOutput.writeLong(quangCaoId);

		objectOutput.writeLong(groupId);

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

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeInt(type);
	}

	public String uuid;
	public long quangCaoSliderId;
	public long quangCaoId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String tenQuangCao;
	public String moTa;
	public boolean target;
	public String url;
	public int type;

}