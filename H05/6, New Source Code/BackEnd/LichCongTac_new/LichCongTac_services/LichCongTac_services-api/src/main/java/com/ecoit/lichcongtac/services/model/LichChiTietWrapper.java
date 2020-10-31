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

package com.ecoit.lichcongtac.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LichChiTiet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTiet
 * @generated
 */
public class LichChiTietWrapper
	extends BaseModelWrapper<LichChiTiet>
	implements LichChiTiet, ModelWrapper<LichChiTiet> {

	public LichChiTietWrapper(LichChiTiet lichChiTiet) {
		super(lichChiTiet);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lichChiTietId", getLichChiTietId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("gioBatDau", getGioBatDau());
		attributes.put("moTa", getMoTa());
		attributes.put("nguoiThamDu", getNguoiThamDu());
		attributes.put("nguoiChuTri", getNguoiChuTri());
		attributes.put("selectedDate", getSelectedDate());
		attributes.put("trangthaiChiTiet", getTrangthaiChiTiet());
		attributes.put("lichCongTacId", getLichCongTacId());
		attributes.put("address", getAddress());
		attributes.put("note", getNote());
		attributes.put("lydoTraVe", getLydoTraVe());
		attributes.put("organizationId", getOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lichChiTietId = (Long)attributes.get("lichChiTietId");

		if (lichChiTietId != null) {
			setLichChiTietId(lichChiTietId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
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

		Long createdByUser = (Long)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Date gioBatDau = (Date)attributes.get("gioBatDau");

		if (gioBatDau != null) {
			setGioBatDau(gioBatDau);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		String nguoiThamDu = (String)attributes.get("nguoiThamDu");

		if (nguoiThamDu != null) {
			setNguoiThamDu(nguoiThamDu);
		}

		String nguoiChuTri = (String)attributes.get("nguoiChuTri");

		if (nguoiChuTri != null) {
			setNguoiChuTri(nguoiChuTri);
		}

		Date selectedDate = (Date)attributes.get("selectedDate");

		if (selectedDate != null) {
			setSelectedDate(selectedDate);
		}

		Integer trangthaiChiTiet = (Integer)attributes.get("trangthaiChiTiet");

		if (trangthaiChiTiet != null) {
			setTrangthaiChiTiet(trangthaiChiTiet);
		}

		Long lichCongTacId = (Long)attributes.get("lichCongTacId");

		if (lichCongTacId != null) {
			setLichCongTacId(lichCongTacId);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String lydoTraVe = (String)attributes.get("lydoTraVe");

		if (lydoTraVe != null) {
			setLydoTraVe(lydoTraVe);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}
	}

	/**
	 * Returns the address of this lich chi tiet.
	 *
	 * @return the address of this lich chi tiet
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this lich chi tiet.
	 *
	 * @return the company ID of this lich chi tiet
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this lich chi tiet.
	 *
	 * @return the create date of this lich chi tiet
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by user of this lich chi tiet.
	 *
	 * @return the created by user of this lich chi tiet
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the gio bat dau of this lich chi tiet.
	 *
	 * @return the gio bat dau of this lich chi tiet
	 */
	@Override
	public Date getGioBatDau() {
		return model.getGioBatDau();
	}

	/**
	 * Returns the group ID of this lich chi tiet.
	 *
	 * @return the group ID of this lich chi tiet
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this lich chi tiet.
	 *
	 * @return the language of this lich chi tiet
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the lich chi tiet ID of this lich chi tiet.
	 *
	 * @return the lich chi tiet ID of this lich chi tiet
	 */
	@Override
	public long getLichChiTietId() {
		return model.getLichChiTietId();
	}

	/**
	 * Returns the lich cong tac ID of this lich chi tiet.
	 *
	 * @return the lich cong tac ID of this lich chi tiet
	 */
	@Override
	public long getLichCongTacId() {
		return model.getLichCongTacId();
	}

	/**
	 * Returns the lydo tra ve of this lich chi tiet.
	 *
	 * @return the lydo tra ve of this lich chi tiet
	 */
	@Override
	public String getLydoTraVe() {
		return model.getLydoTraVe();
	}

	/**
	 * Returns the modified by user of this lich chi tiet.
	 *
	 * @return the modified by user of this lich chi tiet
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this lich chi tiet.
	 *
	 * @return the modified date of this lich chi tiet
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mo ta of this lich chi tiet.
	 *
	 * @return the mo ta of this lich chi tiet
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the nguoi chu tri of this lich chi tiet.
	 *
	 * @return the nguoi chu tri of this lich chi tiet
	 */
	@Override
	public String getNguoiChuTri() {
		return model.getNguoiChuTri();
	}

	/**
	 * Returns the nguoi tham du of this lich chi tiet.
	 *
	 * @return the nguoi tham du of this lich chi tiet
	 */
	@Override
	public String getNguoiThamDu() {
		return model.getNguoiThamDu();
	}

	/**
	 * Returns the note of this lich chi tiet.
	 *
	 * @return the note of this lich chi tiet
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the organization ID of this lich chi tiet.
	 *
	 * @return the organization ID of this lich chi tiet
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this lich chi tiet.
	 *
	 * @return the primary key of this lich chi tiet
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the selected date of this lich chi tiet.
	 *
	 * @return the selected date of this lich chi tiet
	 */
	@Override
	public Date getSelectedDate() {
		return model.getSelectedDate();
	}

	/**
	 * Returns the trangthai chi tiet of this lich chi tiet.
	 *
	 * @return the trangthai chi tiet of this lich chi tiet
	 */
	@Override
	public int getTrangthaiChiTiet() {
		return model.getTrangthaiChiTiet();
	}

	/**
	 * Returns the user ID of this lich chi tiet.
	 *
	 * @return the user ID of this lich chi tiet
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this lich chi tiet.
	 *
	 * @return the user name of this lich chi tiet
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this lich chi tiet.
	 *
	 * @return the user uuid of this lich chi tiet
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this lich chi tiet.
	 *
	 * @param address the address of this lich chi tiet
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this lich chi tiet.
	 *
	 * @param companyId the company ID of this lich chi tiet
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lich chi tiet.
	 *
	 * @param createDate the create date of this lich chi tiet
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by user of this lich chi tiet.
	 *
	 * @param createdByUser the created by user of this lich chi tiet
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the gio bat dau of this lich chi tiet.
	 *
	 * @param gioBatDau the gio bat dau of this lich chi tiet
	 */
	@Override
	public void setGioBatDau(Date gioBatDau) {
		model.setGioBatDau(gioBatDau);
	}

	/**
	 * Sets the group ID of this lich chi tiet.
	 *
	 * @param groupId the group ID of this lich chi tiet
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this lich chi tiet.
	 *
	 * @param language the language of this lich chi tiet
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the lich chi tiet ID of this lich chi tiet.
	 *
	 * @param lichChiTietId the lich chi tiet ID of this lich chi tiet
	 */
	@Override
	public void setLichChiTietId(long lichChiTietId) {
		model.setLichChiTietId(lichChiTietId);
	}

	/**
	 * Sets the lich cong tac ID of this lich chi tiet.
	 *
	 * @param lichCongTacId the lich cong tac ID of this lich chi tiet
	 */
	@Override
	public void setLichCongTacId(long lichCongTacId) {
		model.setLichCongTacId(lichCongTacId);
	}

	/**
	 * Sets the lydo tra ve of this lich chi tiet.
	 *
	 * @param lydoTraVe the lydo tra ve of this lich chi tiet
	 */
	@Override
	public void setLydoTraVe(String lydoTraVe) {
		model.setLydoTraVe(lydoTraVe);
	}

	/**
	 * Sets the modified by user of this lich chi tiet.
	 *
	 * @param modifiedByUser the modified by user of this lich chi tiet
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this lich chi tiet.
	 *
	 * @param modifiedDate the modified date of this lich chi tiet
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mo ta of this lich chi tiet.
	 *
	 * @param moTa the mo ta of this lich chi tiet
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the nguoi chu tri of this lich chi tiet.
	 *
	 * @param nguoiChuTri the nguoi chu tri of this lich chi tiet
	 */
	@Override
	public void setNguoiChuTri(String nguoiChuTri) {
		model.setNguoiChuTri(nguoiChuTri);
	}

	/**
	 * Sets the nguoi tham du of this lich chi tiet.
	 *
	 * @param nguoiThamDu the nguoi tham du of this lich chi tiet
	 */
	@Override
	public void setNguoiThamDu(String nguoiThamDu) {
		model.setNguoiThamDu(nguoiThamDu);
	}

	/**
	 * Sets the note of this lich chi tiet.
	 *
	 * @param note the note of this lich chi tiet
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the organization ID of this lich chi tiet.
	 *
	 * @param organizationId the organization ID of this lich chi tiet
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this lich chi tiet.
	 *
	 * @param primaryKey the primary key of this lich chi tiet
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the selected date of this lich chi tiet.
	 *
	 * @param selectedDate the selected date of this lich chi tiet
	 */
	@Override
	public void setSelectedDate(Date selectedDate) {
		model.setSelectedDate(selectedDate);
	}

	/**
	 * Sets the trangthai chi tiet of this lich chi tiet.
	 *
	 * @param trangthaiChiTiet the trangthai chi tiet of this lich chi tiet
	 */
	@Override
	public void setTrangthaiChiTiet(int trangthaiChiTiet) {
		model.setTrangthaiChiTiet(trangthaiChiTiet);
	}

	/**
	 * Sets the user ID of this lich chi tiet.
	 *
	 * @param userId the user ID of this lich chi tiet
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this lich chi tiet.
	 *
	 * @param userName the user name of this lich chi tiet
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lich chi tiet.
	 *
	 * @param userUuid the user uuid of this lich chi tiet
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LichChiTietWrapper wrap(LichChiTiet lichChiTiet) {
		return new LichChiTietWrapper(lichChiTiet);
	}

}