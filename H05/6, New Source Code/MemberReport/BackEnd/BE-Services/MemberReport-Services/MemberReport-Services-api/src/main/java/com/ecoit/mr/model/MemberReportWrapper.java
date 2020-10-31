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

package com.ecoit.mr.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MemberReport}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberReport
 * @generated
 */
public class MemberReportWrapper
	extends BaseModelWrapper<MemberReport>
	implements MemberReport, ModelWrapper<MemberReport> {

	public MemberReportWrapper(MemberReport memberReport) {
		super(memberReport);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("memberReportId", getMemberReportId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("tong", getTong());
		attributes.put("congTac", getCongTac());
		attributes.put("hocTap", getHocTap());
		attributes.put("nghiPhep", getNghiPhep());
		attributes.put("nghiOm", getNghiOm());
		attributes.put("nghiBu", getNghiBu());
		attributes.put("liDoKhac", getLiDoKhac());
		attributes.put("note", getNote());
		attributes.put("unitId", getUnitId());
		attributes.put("language", getLanguage());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long memberReportId = (Long)attributes.get("memberReportId");

		if (memberReportId != null) {
			setMemberReportId(memberReportId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long createdByUser = (Long)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Long tong = (Long)attributes.get("tong");

		if (tong != null) {
			setTong(tong);
		}

		Long congTac = (Long)attributes.get("congTac");

		if (congTac != null) {
			setCongTac(congTac);
		}

		Long hocTap = (Long)attributes.get("hocTap");

		if (hocTap != null) {
			setHocTap(hocTap);
		}

		Long nghiPhep = (Long)attributes.get("nghiPhep");

		if (nghiPhep != null) {
			setNghiPhep(nghiPhep);
		}

		Long nghiOm = (Long)attributes.get("nghiOm");

		if (nghiOm != null) {
			setNghiOm(nghiOm);
		}

		Long nghiBu = (Long)attributes.get("nghiBu");

		if (nghiBu != null) {
			setNghiBu(nghiBu);
		}

		Long liDoKhac = (Long)attributes.get("liDoKhac");

		if (liDoKhac != null) {
			setLiDoKhac(liDoKhac);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this member report.
	 *
	 * @return the company ID of this member report
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cong tac of this member report.
	 *
	 * @return the cong tac of this member report
	 */
	@Override
	public long getCongTac() {
		return model.getCongTac();
	}

	/**
	 * Returns the create date of this member report.
	 *
	 * @return the create date of this member report
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by user of this member report.
	 *
	 * @return the created by user of this member report
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the group ID of this member report.
	 *
	 * @return the group ID of this member report
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hoc tap of this member report.
	 *
	 * @return the hoc tap of this member report
	 */
	@Override
	public long getHocTap() {
		return model.getHocTap();
	}

	/**
	 * Returns the language of this member report.
	 *
	 * @return the language of this member report
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the li do khac of this member report.
	 *
	 * @return the li do khac of this member report
	 */
	@Override
	public long getLiDoKhac() {
		return model.getLiDoKhac();
	}

	/**
	 * Returns the member report ID of this member report.
	 *
	 * @return the member report ID of this member report
	 */
	@Override
	public long getMemberReportId() {
		return model.getMemberReportId();
	}

	/**
	 * Returns the modified by user of this member report.
	 *
	 * @return the modified by user of this member report
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this member report.
	 *
	 * @return the modified date of this member report
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nghi bu of this member report.
	 *
	 * @return the nghi bu of this member report
	 */
	@Override
	public long getNghiBu() {
		return model.getNghiBu();
	}

	/**
	 * Returns the nghi om of this member report.
	 *
	 * @return the nghi om of this member report
	 */
	@Override
	public long getNghiOm() {
		return model.getNghiOm();
	}

	/**
	 * Returns the nghi phep of this member report.
	 *
	 * @return the nghi phep of this member report
	 */
	@Override
	public long getNghiPhep() {
		return model.getNghiPhep();
	}

	/**
	 * Returns the note of this member report.
	 *
	 * @return the note of this member report
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the primary key of this member report.
	 *
	 * @return the primary key of this member report
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this member report.
	 *
	 * @return the status of this member report
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tong of this member report.
	 *
	 * @return the tong of this member report
	 */
	@Override
	public long getTong() {
		return model.getTong();
	}

	/**
	 * Returns the unit ID of this member report.
	 *
	 * @return the unit ID of this member report
	 */
	@Override
	public long getUnitId() {
		return model.getUnitId();
	}

	/**
	 * Returns the user ID of this member report.
	 *
	 * @return the user ID of this member report
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this member report.
	 *
	 * @return the user name of this member report
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this member report.
	 *
	 * @return the user uuid of this member report
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this member report.
	 *
	 * @return the uuid of this member report
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this member report.
	 *
	 * @param companyId the company ID of this member report
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cong tac of this member report.
	 *
	 * @param congTac the cong tac of this member report
	 */
	@Override
	public void setCongTac(long congTac) {
		model.setCongTac(congTac);
	}

	/**
	 * Sets the create date of this member report.
	 *
	 * @param createDate the create date of this member report
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by user of this member report.
	 *
	 * @param createdByUser the created by user of this member report
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the group ID of this member report.
	 *
	 * @param groupId the group ID of this member report
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hoc tap of this member report.
	 *
	 * @param hocTap the hoc tap of this member report
	 */
	@Override
	public void setHocTap(long hocTap) {
		model.setHocTap(hocTap);
	}

	/**
	 * Sets the language of this member report.
	 *
	 * @param language the language of this member report
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the li do khac of this member report.
	 *
	 * @param liDoKhac the li do khac of this member report
	 */
	@Override
	public void setLiDoKhac(long liDoKhac) {
		model.setLiDoKhac(liDoKhac);
	}

	/**
	 * Sets the member report ID of this member report.
	 *
	 * @param memberReportId the member report ID of this member report
	 */
	@Override
	public void setMemberReportId(long memberReportId) {
		model.setMemberReportId(memberReportId);
	}

	/**
	 * Sets the modified by user of this member report.
	 *
	 * @param modifiedByUser the modified by user of this member report
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this member report.
	 *
	 * @param modifiedDate the modified date of this member report
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nghi bu of this member report.
	 *
	 * @param nghiBu the nghi bu of this member report
	 */
	@Override
	public void setNghiBu(long nghiBu) {
		model.setNghiBu(nghiBu);
	}

	/**
	 * Sets the nghi om of this member report.
	 *
	 * @param nghiOm the nghi om of this member report
	 */
	@Override
	public void setNghiOm(long nghiOm) {
		model.setNghiOm(nghiOm);
	}

	/**
	 * Sets the nghi phep of this member report.
	 *
	 * @param nghiPhep the nghi phep of this member report
	 */
	@Override
	public void setNghiPhep(long nghiPhep) {
		model.setNghiPhep(nghiPhep);
	}

	/**
	 * Sets the note of this member report.
	 *
	 * @param note the note of this member report
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the primary key of this member report.
	 *
	 * @param primaryKey the primary key of this member report
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this member report.
	 *
	 * @param status the status of this member report
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tong of this member report.
	 *
	 * @param tong the tong of this member report
	 */
	@Override
	public void setTong(long tong) {
		model.setTong(tong);
	}

	/**
	 * Sets the unit ID of this member report.
	 *
	 * @param unitId the unit ID of this member report
	 */
	@Override
	public void setUnitId(long unitId) {
		model.setUnitId(unitId);
	}

	/**
	 * Sets the user ID of this member report.
	 *
	 * @param userId the user ID of this member report
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this member report.
	 *
	 * @param userName the user name of this member report
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this member report.
	 *
	 * @param userUuid the user uuid of this member report
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this member report.
	 *
	 * @param uuid the uuid of this member report
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected MemberReportWrapper wrap(MemberReport memberReport) {
		return new MemberReportWrapper(memberReport);
	}

}