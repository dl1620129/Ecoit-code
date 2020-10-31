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
 * This class is a wrapper for {@link LichCongTac}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichCongTac
 * @generated
 */
public class LichCongTacWrapper
	extends BaseModelWrapper<LichCongTac>
	implements LichCongTac, ModelWrapper<LichCongTac> {

	public LichCongTacWrapper(LichCongTac lichCongTac) {
		super(lichCongTac);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lichCongTacId", getLichCongTacId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("tenLich", getTenLich());
		attributes.put("ngayBatDau", getNgayBatDau());
		attributes.put("ngayKetThuc", getNgayKetThuc());
		attributes.put("lichChuyenBanNganh", getLichChuyenBanNganh());
		attributes.put("lichChuyenNguoiDung", getLichChuyenNguoiDung());
		attributes.put("trangthaiLichCongTac", getTrangthaiLichCongTac());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("lydoTraVe", getLydoTraVe());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lichCongTacId = (Long)attributes.get("lichCongTacId");

		if (lichCongTacId != null) {
			setLichCongTacId(lichCongTacId);
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

		String tenLich = (String)attributes.get("tenLich");

		if (tenLich != null) {
			setTenLich(tenLich);
		}

		Date ngayBatDau = (Date)attributes.get("ngayBatDau");

		if (ngayBatDau != null) {
			setNgayBatDau(ngayBatDau);
		}

		Date ngayKetThuc = (Date)attributes.get("ngayKetThuc");

		if (ngayKetThuc != null) {
			setNgayKetThuc(ngayKetThuc);
		}

		String lichChuyenBanNganh = (String)attributes.get(
			"lichChuyenBanNganh");

		if (lichChuyenBanNganh != null) {
			setLichChuyenBanNganh(lichChuyenBanNganh);
		}

		String lichChuyenNguoiDung = (String)attributes.get(
			"lichChuyenNguoiDung");

		if (lichChuyenNguoiDung != null) {
			setLichChuyenNguoiDung(lichChuyenNguoiDung);
		}

		Integer trangthaiLichCongTac = (Integer)attributes.get(
			"trangthaiLichCongTac");

		if (trangthaiLichCongTac != null) {
			setTrangthaiLichCongTac(trangthaiLichCongTac);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String lydoTraVe = (String)attributes.get("lydoTraVe");

		if (lydoTraVe != null) {
			setLydoTraVe(lydoTraVe);
		}
	}

	/**
	 * Returns the company ID of this lich cong tac.
	 *
	 * @return the company ID of this lich cong tac
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this lich cong tac.
	 *
	 * @return the create date of this lich cong tac
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by user of this lich cong tac.
	 *
	 * @return the created by user of this lich cong tac
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the group ID of this lich cong tac.
	 *
	 * @return the group ID of this lich cong tac
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the language of this lich cong tac.
	 *
	 * @return the language of this lich cong tac
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the lich chuyen ban nganh of this lich cong tac.
	 *
	 * @return the lich chuyen ban nganh of this lich cong tac
	 */
	@Override
	public String getLichChuyenBanNganh() {
		return model.getLichChuyenBanNganh();
	}

	/**
	 * Returns the lich chuyen nguoi dung of this lich cong tac.
	 *
	 * @return the lich chuyen nguoi dung of this lich cong tac
	 */
	@Override
	public String getLichChuyenNguoiDung() {
		return model.getLichChuyenNguoiDung();
	}

	/**
	 * Returns the lich cong tac ID of this lich cong tac.
	 *
	 * @return the lich cong tac ID of this lich cong tac
	 */
	@Override
	public long getLichCongTacId() {
		return model.getLichCongTacId();
	}

	/**
	 * Returns the lydo tra ve of this lich cong tac.
	 *
	 * @return the lydo tra ve of this lich cong tac
	 */
	@Override
	public String getLydoTraVe() {
		return model.getLydoTraVe();
	}

	/**
	 * Returns the modified by user of this lich cong tac.
	 *
	 * @return the modified by user of this lich cong tac
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this lich cong tac.
	 *
	 * @return the modified date of this lich cong tac
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the ngay bat dau of this lich cong tac.
	 *
	 * @return the ngay bat dau of this lich cong tac
	 */
	@Override
	public Date getNgayBatDau() {
		return model.getNgayBatDau();
	}

	/**
	 * Returns the ngay ket thuc of this lich cong tac.
	 *
	 * @return the ngay ket thuc of this lich cong tac
	 */
	@Override
	public Date getNgayKetThuc() {
		return model.getNgayKetThuc();
	}

	/**
	 * Returns the organization ID of this lich cong tac.
	 *
	 * @return the organization ID of this lich cong tac
	 */
	@Override
	public long getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the primary key of this lich cong tac.
	 *
	 * @return the primary key of this lich cong tac
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten lich of this lich cong tac.
	 *
	 * @return the ten lich of this lich cong tac
	 */
	@Override
	public String getTenLich() {
		return model.getTenLich();
	}

	/**
	 * Returns the trangthai lich cong tac of this lich cong tac.
	 *
	 * @return the trangthai lich cong tac of this lich cong tac
	 */
	@Override
	public int getTrangthaiLichCongTac() {
		return model.getTrangthaiLichCongTac();
	}

	/**
	 * Returns the user ID of this lich cong tac.
	 *
	 * @return the user ID of this lich cong tac
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this lich cong tac.
	 *
	 * @return the user name of this lich cong tac
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this lich cong tac.
	 *
	 * @return the user uuid of this lich cong tac
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
	 * Sets the company ID of this lich cong tac.
	 *
	 * @param companyId the company ID of this lich cong tac
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this lich cong tac.
	 *
	 * @param createDate the create date of this lich cong tac
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by user of this lich cong tac.
	 *
	 * @param createdByUser the created by user of this lich cong tac
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the group ID of this lich cong tac.
	 *
	 * @param groupId the group ID of this lich cong tac
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the language of this lich cong tac.
	 *
	 * @param language the language of this lich cong tac
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the lich chuyen ban nganh of this lich cong tac.
	 *
	 * @param lichChuyenBanNganh the lich chuyen ban nganh of this lich cong tac
	 */
	@Override
	public void setLichChuyenBanNganh(String lichChuyenBanNganh) {
		model.setLichChuyenBanNganh(lichChuyenBanNganh);
	}

	/**
	 * Sets the lich chuyen nguoi dung of this lich cong tac.
	 *
	 * @param lichChuyenNguoiDung the lich chuyen nguoi dung of this lich cong tac
	 */
	@Override
	public void setLichChuyenNguoiDung(String lichChuyenNguoiDung) {
		model.setLichChuyenNguoiDung(lichChuyenNguoiDung);
	}

	/**
	 * Sets the lich cong tac ID of this lich cong tac.
	 *
	 * @param lichCongTacId the lich cong tac ID of this lich cong tac
	 */
	@Override
	public void setLichCongTacId(long lichCongTacId) {
		model.setLichCongTacId(lichCongTacId);
	}

	/**
	 * Sets the lydo tra ve of this lich cong tac.
	 *
	 * @param lydoTraVe the lydo tra ve of this lich cong tac
	 */
	@Override
	public void setLydoTraVe(String lydoTraVe) {
		model.setLydoTraVe(lydoTraVe);
	}

	/**
	 * Sets the modified by user of this lich cong tac.
	 *
	 * @param modifiedByUser the modified by user of this lich cong tac
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this lich cong tac.
	 *
	 * @param modifiedDate the modified date of this lich cong tac
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the ngay bat dau of this lich cong tac.
	 *
	 * @param ngayBatDau the ngay bat dau of this lich cong tac
	 */
	@Override
	public void setNgayBatDau(Date ngayBatDau) {
		model.setNgayBatDau(ngayBatDau);
	}

	/**
	 * Sets the ngay ket thuc of this lich cong tac.
	 *
	 * @param ngayKetThuc the ngay ket thuc of this lich cong tac
	 */
	@Override
	public void setNgayKetThuc(Date ngayKetThuc) {
		model.setNgayKetThuc(ngayKetThuc);
	}

	/**
	 * Sets the organization ID of this lich cong tac.
	 *
	 * @param organizationId the organization ID of this lich cong tac
	 */
	@Override
	public void setOrganizationId(long organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the primary key of this lich cong tac.
	 *
	 * @param primaryKey the primary key of this lich cong tac
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten lich of this lich cong tac.
	 *
	 * @param tenLich the ten lich of this lich cong tac
	 */
	@Override
	public void setTenLich(String tenLich) {
		model.setTenLich(tenLich);
	}

	/**
	 * Sets the trangthai lich cong tac of this lich cong tac.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac of this lich cong tac
	 */
	@Override
	public void setTrangthaiLichCongTac(int trangthaiLichCongTac) {
		model.setTrangthaiLichCongTac(trangthaiLichCongTac);
	}

	/**
	 * Sets the user ID of this lich cong tac.
	 *
	 * @param userId the user ID of this lich cong tac
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this lich cong tac.
	 *
	 * @param userName the user name of this lich cong tac
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this lich cong tac.
	 *
	 * @param userUuid the user uuid of this lich cong tac
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LichCongTacWrapper wrap(LichCongTac lichCongTac) {
		return new LichCongTacWrapper(lichCongTac);
	}

}