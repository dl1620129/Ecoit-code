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

package com.ecoit.lichcongtac.services.model.impl;

import com.ecoit.lichcongtac.services.model.LichChiTiet;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LichChiTiet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LichChiTietCacheModel
	implements CacheModel<LichChiTiet>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LichChiTietCacheModel)) {
			return false;
		}

		LichChiTietCacheModel lichChiTietCacheModel =
			(LichChiTietCacheModel)obj;

		if (lichChiTietId == lichChiTietCacheModel.lichChiTietId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lichChiTietId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{lichChiTietId=");
		sb.append(lichChiTietId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", gioBatDau=");
		sb.append(gioBatDau);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", nguoiThamDu=");
		sb.append(nguoiThamDu);
		sb.append(", nguoiChuTri=");
		sb.append(nguoiChuTri);
		sb.append(", selectedDate=");
		sb.append(selectedDate);
		sb.append(", trangthaiChiTiet=");
		sb.append(trangthaiChiTiet);
		sb.append(", lichCongTacId=");
		sb.append(lichCongTacId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", note=");
		sb.append(note);
		sb.append(", lydoTraVe=");
		sb.append(lydoTraVe);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LichChiTiet toEntityModel() {
		LichChiTietImpl lichChiTietImpl = new LichChiTietImpl();

		lichChiTietImpl.setLichChiTietId(lichChiTietId);
		lichChiTietImpl.setGroupId(groupId);

		if (language == null) {
			lichChiTietImpl.setLanguage("");
		}
		else {
			lichChiTietImpl.setLanguage(language);
		}

		lichChiTietImpl.setCompanyId(companyId);
		lichChiTietImpl.setUserId(userId);

		if (userName == null) {
			lichChiTietImpl.setUserName("");
		}
		else {
			lichChiTietImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lichChiTietImpl.setCreateDate(null);
		}
		else {
			lichChiTietImpl.setCreateDate(new Date(createDate));
		}

		lichChiTietImpl.setCreatedByUser(createdByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			lichChiTietImpl.setModifiedDate(null);
		}
		else {
			lichChiTietImpl.setModifiedDate(new Date(modifiedDate));
		}

		lichChiTietImpl.setModifiedByUser(modifiedByUser);

		if (gioBatDau == Long.MIN_VALUE) {
			lichChiTietImpl.setGioBatDau(null);
		}
		else {
			lichChiTietImpl.setGioBatDau(new Date(gioBatDau));
		}

		if (moTa == null) {
			lichChiTietImpl.setMoTa("");
		}
		else {
			lichChiTietImpl.setMoTa(moTa);
		}

		if (nguoiThamDu == null) {
			lichChiTietImpl.setNguoiThamDu("");
		}
		else {
			lichChiTietImpl.setNguoiThamDu(nguoiThamDu);
		}

		if (nguoiChuTri == null) {
			lichChiTietImpl.setNguoiChuTri("");
		}
		else {
			lichChiTietImpl.setNguoiChuTri(nguoiChuTri);
		}

		if (selectedDate == Long.MIN_VALUE) {
			lichChiTietImpl.setSelectedDate(null);
		}
		else {
			lichChiTietImpl.setSelectedDate(new Date(selectedDate));
		}

		lichChiTietImpl.setTrangthaiChiTiet(trangthaiChiTiet);
		lichChiTietImpl.setLichCongTacId(lichCongTacId);

		if (address == null) {
			lichChiTietImpl.setAddress("");
		}
		else {
			lichChiTietImpl.setAddress(address);
		}

		if (note == null) {
			lichChiTietImpl.setNote("");
		}
		else {
			lichChiTietImpl.setNote(note);
		}

		if (lydoTraVe == null) {
			lichChiTietImpl.setLydoTraVe("");
		}
		else {
			lichChiTietImpl.setLydoTraVe(lydoTraVe);
		}

		lichChiTietImpl.setOrganizationId(organizationId);

		lichChiTietImpl.resetOriginalValues();

		return lichChiTietImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lichChiTietId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		gioBatDau = objectInput.readLong();
		moTa = objectInput.readUTF();
		nguoiThamDu = objectInput.readUTF();
		nguoiChuTri = objectInput.readUTF();
		selectedDate = objectInput.readLong();

		trangthaiChiTiet = objectInput.readInt();

		lichCongTacId = objectInput.readLong();
		address = objectInput.readUTF();
		note = objectInput.readUTF();
		lydoTraVe = objectInput.readUTF();

		organizationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lichChiTietId);

		objectOutput.writeLong(groupId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdByUser);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedByUser);
		objectOutput.writeLong(gioBatDau);

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		if (nguoiThamDu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nguoiThamDu);
		}

		if (nguoiChuTri == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nguoiChuTri);
		}

		objectOutput.writeLong(selectedDate);

		objectOutput.writeInt(trangthaiChiTiet);

		objectOutput.writeLong(lichCongTacId);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (lydoTraVe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lydoTraVe);
		}

		objectOutput.writeLong(organizationId);
	}

	public long lichChiTietId;
	public long groupId;
	public String language;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdByUser;
	public long modifiedDate;
	public long modifiedByUser;
	public long gioBatDau;
	public String moTa;
	public String nguoiThamDu;
	public String nguoiChuTri;
	public long selectedDate;
	public int trangthaiChiTiet;
	public long lichCongTacId;
	public String address;
	public String note;
	public String lydoTraVe;
	public long organizationId;

}