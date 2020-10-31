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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.ArticleMailSendServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class ArticleMailSendSoap implements Serializable {

	public static ArticleMailSendSoap toSoapModel(ArticleMailSend model) {
		ArticleMailSendSoap soapModel = new ArticleMailSendSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMailSendId(model.getMailSendId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setNguoiGui(model.getNguoiGui());
		soapModel.setMailNguoiGui(model.getMailNguoiGui());
		soapModel.setNguoiNhan(model.getNguoiNhan());
		soapModel.setMailNguoiNhan(model.getMailNguoiNhan());
		soapModel.setTieuDe(model.getTieuDe());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static ArticleMailSendSoap[] toSoapModels(ArticleMailSend[] models) {
		ArticleMailSendSoap[] soapModels =
			new ArticleMailSendSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleMailSendSoap[][] toSoapModels(
		ArticleMailSend[][] models) {

		ArticleMailSendSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ArticleMailSendSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleMailSendSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleMailSendSoap[] toSoapModels(
		List<ArticleMailSend> models) {

		List<ArticleMailSendSoap> soapModels =
			new ArrayList<ArticleMailSendSoap>(models.size());

		for (ArticleMailSend model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleMailSendSoap[soapModels.size()]);
	}

	public ArticleMailSendSoap() {
	}

	public long getPrimaryKey() {
		return _mailSendId;
	}

	public void setPrimaryKey(long pk) {
		setMailSendId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMailSendId() {
		return _mailSendId;
	}

	public void setMailSendId(long mailSendId) {
		_mailSendId = mailSendId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getNguoiGui() {
		return _nguoiGui;
	}

	public void setNguoiGui(String nguoiGui) {
		_nguoiGui = nguoiGui;
	}

	public String getMailNguoiGui() {
		return _mailNguoiGui;
	}

	public void setMailNguoiGui(String mailNguoiGui) {
		_mailNguoiGui = mailNguoiGui;
	}

	public String getNguoiNhan() {
		return _nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		_nguoiNhan = nguoiNhan;
	}

	public String getMailNguoiNhan() {
		return _mailNguoiNhan;
	}

	public void setMailNguoiNhan(String mailNguoiNhan) {
		_mailNguoiNhan = mailNguoiNhan;
	}

	public String getTieuDe() {
		return _tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private String _uuid;
	private long _mailSendId;
	private Date _createDate;
	private long _groupId;
	private String _nguoiGui;
	private String _mailNguoiGui;
	private String _nguoiNhan;
	private String _mailNguoiNhan;
	private String _tieuDe;
	private String _noiDung;
	private long _articleId;
	private long _categoryId;

}