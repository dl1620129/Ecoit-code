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

package com.software.cms.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ArticleMailSend}.
 * </p>
 *
 * @author DungNV
 * @see ArticleMailSend
 * @generated
 */
public class ArticleMailSendWrapper
	extends BaseModelWrapper<ArticleMailSend>
	implements ArticleMailSend, ModelWrapper<ArticleMailSend> {

	public ArticleMailSendWrapper(ArticleMailSend articleMailSend) {
		super(articleMailSend);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("mailSendId", getMailSendId());
		attributes.put("createDate", getCreateDate());
		attributes.put("groupId", getGroupId());
		attributes.put("nguoiGui", getNguoiGui());
		attributes.put("mailNguoiGui", getMailNguoiGui());
		attributes.put("nguoiNhan", getNguoiNhan());
		attributes.put("mailNguoiNhan", getMailNguoiNhan());
		attributes.put("tieuDe", getTieuDe());
		attributes.put("noiDung", getNoiDung());
		attributes.put("articleId", getArticleId());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long mailSendId = (Long)attributes.get("mailSendId");

		if (mailSendId != null) {
			setMailSendId(mailSendId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String nguoiGui = (String)attributes.get("nguoiGui");

		if (nguoiGui != null) {
			setNguoiGui(nguoiGui);
		}

		String mailNguoiGui = (String)attributes.get("mailNguoiGui");

		if (mailNguoiGui != null) {
			setMailNguoiGui(mailNguoiGui);
		}

		String nguoiNhan = (String)attributes.get("nguoiNhan");

		if (nguoiNhan != null) {
			setNguoiNhan(nguoiNhan);
		}

		String mailNguoiNhan = (String)attributes.get("mailNguoiNhan");

		if (mailNguoiNhan != null) {
			setMailNguoiNhan(mailNguoiNhan);
		}

		String tieuDe = (String)attributes.get("tieuDe");

		if (tieuDe != null) {
			setTieuDe(tieuDe);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	 * Returns the article ID of this article mail send.
	 *
	 * @return the article ID of this article mail send
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the category ID of this article mail send.
	 *
	 * @return the category ID of this article mail send
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the create date of this article mail send.
	 *
	 * @return the create date of this article mail send
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this article mail send.
	 *
	 * @return the group ID of this article mail send
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mail nguoi gui of this article mail send.
	 *
	 * @return the mail nguoi gui of this article mail send
	 */
	@Override
	public String getMailNguoiGui() {
		return model.getMailNguoiGui();
	}

	/**
	 * Returns the mail nguoi nhan of this article mail send.
	 *
	 * @return the mail nguoi nhan of this article mail send
	 */
	@Override
	public String getMailNguoiNhan() {
		return model.getMailNguoiNhan();
	}

	/**
	 * Returns the mail send ID of this article mail send.
	 *
	 * @return the mail send ID of this article mail send
	 */
	@Override
	public long getMailSendId() {
		return model.getMailSendId();
	}

	/**
	 * Returns the nguoi gui of this article mail send.
	 *
	 * @return the nguoi gui of this article mail send
	 */
	@Override
	public String getNguoiGui() {
		return model.getNguoiGui();
	}

	/**
	 * Returns the nguoi nhan of this article mail send.
	 *
	 * @return the nguoi nhan of this article mail send
	 */
	@Override
	public String getNguoiNhan() {
		return model.getNguoiNhan();
	}

	/**
	 * Returns the noi dung of this article mail send.
	 *
	 * @return the noi dung of this article mail send
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the primary key of this article mail send.
	 *
	 * @return the primary key of this article mail send
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tieu de of this article mail send.
	 *
	 * @return the tieu de of this article mail send
	 */
	@Override
	public String getTieuDe() {
		return model.getTieuDe();
	}

	/**
	 * Returns the uuid of this article mail send.
	 *
	 * @return the uuid of this article mail send
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
	 * Sets the article ID of this article mail send.
	 *
	 * @param articleId the article ID of this article mail send
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the category ID of this article mail send.
	 *
	 * @param categoryId the category ID of this article mail send
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the create date of this article mail send.
	 *
	 * @param createDate the create date of this article mail send
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this article mail send.
	 *
	 * @param groupId the group ID of this article mail send
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mail nguoi gui of this article mail send.
	 *
	 * @param mailNguoiGui the mail nguoi gui of this article mail send
	 */
	@Override
	public void setMailNguoiGui(String mailNguoiGui) {
		model.setMailNguoiGui(mailNguoiGui);
	}

	/**
	 * Sets the mail nguoi nhan of this article mail send.
	 *
	 * @param mailNguoiNhan the mail nguoi nhan of this article mail send
	 */
	@Override
	public void setMailNguoiNhan(String mailNguoiNhan) {
		model.setMailNguoiNhan(mailNguoiNhan);
	}

	/**
	 * Sets the mail send ID of this article mail send.
	 *
	 * @param mailSendId the mail send ID of this article mail send
	 */
	@Override
	public void setMailSendId(long mailSendId) {
		model.setMailSendId(mailSendId);
	}

	/**
	 * Sets the nguoi gui of this article mail send.
	 *
	 * @param nguoiGui the nguoi gui of this article mail send
	 */
	@Override
	public void setNguoiGui(String nguoiGui) {
		model.setNguoiGui(nguoiGui);
	}

	/**
	 * Sets the nguoi nhan of this article mail send.
	 *
	 * @param nguoiNhan the nguoi nhan of this article mail send
	 */
	@Override
	public void setNguoiNhan(String nguoiNhan) {
		model.setNguoiNhan(nguoiNhan);
	}

	/**
	 * Sets the noi dung of this article mail send.
	 *
	 * @param noiDung the noi dung of this article mail send
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the primary key of this article mail send.
	 *
	 * @param primaryKey the primary key of this article mail send
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tieu de of this article mail send.
	 *
	 * @param tieuDe the tieu de of this article mail send
	 */
	@Override
	public void setTieuDe(String tieuDe) {
		model.setTieuDe(tieuDe);
	}

	/**
	 * Sets the uuid of this article mail send.
	 *
	 * @param uuid the uuid of this article mail send
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ArticleMailSendWrapper wrap(ArticleMailSend articleMailSend) {
		return new ArticleMailSendWrapper(articleMailSend);
	}

}