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

package com.ecoit.mr.model.impl;

import com.ecoit.mr.model.MemberReport;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MemberReport in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MemberReportCacheModel
	implements CacheModel<MemberReport>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MemberReportCacheModel)) {
			return false;
		}

		MemberReportCacheModel memberReportCacheModel =
			(MemberReportCacheModel)obj;

		if (memberReportId == memberReportCacheModel.memberReportId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberReportId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", memberReportId=");
		sb.append(memberReportId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", tong=");
		sb.append(tong);
		sb.append(", congTac=");
		sb.append(congTac);
		sb.append(", hocTap=");
		sb.append(hocTap);
		sb.append(", nghiPhep=");
		sb.append(nghiPhep);
		sb.append(", nghiOm=");
		sb.append(nghiOm);
		sb.append(", nghiBu=");
		sb.append(nghiBu);
		sb.append(", liDoKhac=");
		sb.append(liDoKhac);
		sb.append(", note=");
		sb.append(note);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MemberReport toEntityModel() {
		MemberReportImpl memberReportImpl = new MemberReportImpl();

		if (uuid == null) {
			memberReportImpl.setUuid("");
		}
		else {
			memberReportImpl.setUuid(uuid);
		}

		memberReportImpl.setMemberReportId(memberReportId);
		memberReportImpl.setGroupId(groupId);
		memberReportImpl.setCompanyId(companyId);
		memberReportImpl.setUserId(userId);

		if (userName == null) {
			memberReportImpl.setUserName("");
		}
		else {
			memberReportImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			memberReportImpl.setCreateDate(null);
		}
		else {
			memberReportImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberReportImpl.setModifiedDate(null);
		}
		else {
			memberReportImpl.setModifiedDate(new Date(modifiedDate));
		}

		memberReportImpl.setCreatedByUser(createdByUser);
		memberReportImpl.setModifiedByUser(modifiedByUser);
		memberReportImpl.setTong(tong);
		memberReportImpl.setCongTac(congTac);
		memberReportImpl.setHocTap(hocTap);
		memberReportImpl.setNghiPhep(nghiPhep);
		memberReportImpl.setNghiOm(nghiOm);
		memberReportImpl.setNghiBu(nghiBu);
		memberReportImpl.setLiDoKhac(liDoKhac);

		if (note == null) {
			memberReportImpl.setNote("");
		}
		else {
			memberReportImpl.setNote(note);
		}

		memberReportImpl.setUnitId(unitId);

		if (language == null) {
			memberReportImpl.setLanguage("");
		}
		else {
			memberReportImpl.setLanguage(language);
		}

		memberReportImpl.setStatus(status);

		memberReportImpl.resetOriginalValues();

		return memberReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		memberReportId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		createdByUser = objectInput.readLong();

		modifiedByUser = objectInput.readLong();

		tong = objectInput.readLong();

		congTac = objectInput.readLong();

		hocTap = objectInput.readLong();

		nghiPhep = objectInput.readLong();

		nghiOm = objectInput.readLong();

		nghiBu = objectInput.readLong();

		liDoKhac = objectInput.readLong();
		note = objectInput.readUTF();

		unitId = objectInput.readLong();
		language = objectInput.readUTF();

		status = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(memberReportId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(createdByUser);

		objectOutput.writeLong(modifiedByUser);

		objectOutput.writeLong(tong);

		objectOutput.writeLong(congTac);

		objectOutput.writeLong(hocTap);

		objectOutput.writeLong(nghiPhep);

		objectOutput.writeLong(nghiOm);

		objectOutput.writeLong(nghiBu);

		objectOutput.writeLong(liDoKhac);

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(unitId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeLong(status);
	}

	public String uuid;
	public long memberReportId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long createdByUser;
	public long modifiedByUser;
	public long tong;
	public long congTac;
	public long hocTap;
	public long nghiPhep;
	public long nghiOm;
	public long nghiBu;
	public long liDoKhac;
	public String note;
	public long unitId;
	public String language;
	public long status;

}