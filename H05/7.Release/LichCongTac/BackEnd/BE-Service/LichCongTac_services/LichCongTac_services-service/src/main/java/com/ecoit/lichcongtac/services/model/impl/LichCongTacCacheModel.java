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

import com.ecoit.lichcongtac.services.model.LichCongTac;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LichCongTac in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LichCongTacCacheModel
	implements CacheModel<LichCongTac>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LichCongTacCacheModel)) {
			return false;
		}

		LichCongTacCacheModel lichCongTacCacheModel =
			(LichCongTacCacheModel)obj;

		if (lichCongTacId == lichCongTacCacheModel.lichCongTacId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lichCongTacId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{lichCongTacId=");
		sb.append(lichCongTacId);
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
		sb.append(", tenLich=");
		sb.append(tenLich);
		sb.append(", ngayBatDau=");
		sb.append(ngayBatDau);
		sb.append(", ngayKetThuc=");
		sb.append(ngayKetThuc);
		sb.append(", lichChuyenBanNganh=");
		sb.append(lichChuyenBanNganh);
		sb.append(", lichChuyenNguoiDung=");
		sb.append(lichChuyenNguoiDung);
		sb.append(", trangthaiLichCongTac=");
		sb.append(trangthaiLichCongTac);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", lydoTraVe=");
		sb.append(lydoTraVe);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LichCongTac toEntityModel() {
		LichCongTacImpl lichCongTacImpl = new LichCongTacImpl();

		lichCongTacImpl.setLichCongTacId(lichCongTacId);
		lichCongTacImpl.setGroupId(groupId);

		if (language == null) {
			lichCongTacImpl.setLanguage("");
		}
		else {
			lichCongTacImpl.setLanguage(language);
		}

		lichCongTacImpl.setCompanyId(companyId);
		lichCongTacImpl.setUserId(userId);

		if (userName == null) {
			lichCongTacImpl.setUserName("");
		}
		else {
			lichCongTacImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lichCongTacImpl.setCreateDate(null);
		}
		else {
			lichCongTacImpl.setCreateDate(new Date(createDate));
		}

		lichCongTacImpl.setCreatedByUser(createdByUser);

		if (modifiedDate == Long.MIN_VALUE) {
			lichCongTacImpl.setModifiedDate(null);
		}
		else {
			lichCongTacImpl.setModifiedDate(new Date(modifiedDate));
		}

		lichCongTacImpl.setModifiedByUser(modifiedByUser);

		if (tenLich == null) {
			lichCongTacImpl.setTenLich("");
		}
		else {
			lichCongTacImpl.setTenLich(tenLich);
		}

		if (ngayBatDau == Long.MIN_VALUE) {
			lichCongTacImpl.setNgayBatDau(null);
		}
		else {
			lichCongTacImpl.setNgayBatDau(new Date(ngayBatDau));
		}

		if (ngayKetThuc == Long.MIN_VALUE) {
			lichCongTacImpl.setNgayKetThuc(null);
		}
		else {
			lichCongTacImpl.setNgayKetThuc(new Date(ngayKetThuc));
		}

		if (lichChuyenBanNganh == null) {
			lichCongTacImpl.setLichChuyenBanNganh("");
		}
		else {
			lichCongTacImpl.setLichChuyenBanNganh(lichChuyenBanNganh);
		}

		if (lichChuyenNguoiDung == null) {
			lichCongTacImpl.setLichChuyenNguoiDung("");
		}
		else {
			lichCongTacImpl.setLichChuyenNguoiDung(lichChuyenNguoiDung);
		}

		lichCongTacImpl.setTrangthaiLichCongTac(trangthaiLichCongTac);
		lichCongTacImpl.setOrganizationId(organizationId);

		if (lydoTraVe == null) {
			lichCongTacImpl.setLydoTraVe("");
		}
		else {
			lichCongTacImpl.setLydoTraVe(lydoTraVe);
		}

		lichCongTacImpl.resetOriginalValues();

		return lichCongTacImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lichCongTacId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdByUser = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedByUser = objectInput.readLong();
		tenLich = objectInput.readUTF();
		ngayBatDau = objectInput.readLong();
		ngayKetThuc = objectInput.readLong();
		lichChuyenBanNganh = objectInput.readUTF();
		lichChuyenNguoiDung = objectInput.readUTF();

		trangthaiLichCongTac = objectInput.readInt();

		organizationId = objectInput.readLong();
		lydoTraVe = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lichCongTacId);

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

		if (tenLich == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tenLich);
		}

		objectOutput.writeLong(ngayBatDau);
		objectOutput.writeLong(ngayKetThuc);

		if (lichChuyenBanNganh == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lichChuyenBanNganh);
		}

		if (lichChuyenNguoiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lichChuyenNguoiDung);
		}

		objectOutput.writeInt(trangthaiLichCongTac);

		objectOutput.writeLong(organizationId);

		if (lydoTraVe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lydoTraVe);
		}
	}

	public long lichCongTacId;
	public long groupId;
	public String language;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long createdByUser;
	public long modifiedDate;
	public long modifiedByUser;
	public String tenLich;
	public long ngayBatDau;
	public long ngayKetThuc;
	public String lichChuyenBanNganh;
	public String lichChuyenNguoiDung;
	public int trangthaiLichCongTac;
	public long organizationId;
	public String lydoTraVe;

}