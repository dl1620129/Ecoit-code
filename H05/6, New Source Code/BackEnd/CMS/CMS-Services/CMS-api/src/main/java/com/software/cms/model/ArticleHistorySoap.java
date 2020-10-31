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
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.ArticleHistoryServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class ArticleHistorySoap implements Serializable {

	public static ArticleHistorySoap toSoapModel(ArticleHistory model) {
		ArticleHistorySoap soapModel = new ArticleHistorySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setArticleHistoryId(model.getArticleHistoryId());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setTitle(model.getTitle());
		soapModel.setSummnary(model.getSummnary());
		soapModel.setContent(model.getContent());
		soapModel.setImageDescription(model.getImageDescription());
		soapModel.setImage(model.getImage());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setSource(model.getSource());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setDonVi(model.getDonVi());
		soapModel.setLoaiTinBai(model.getLoaiTinBai());
		soapModel.setSoKyTuBaiViet(model.getSoKyTuBaiViet());
		soapModel.setSoAnhBaiViet(model.getSoAnhBaiViet());
		soapModel.setLoaiAnh(model.getLoaiAnh());
		soapModel.setTheLoaiTinBai(model.getTheLoaiTinBai());

		return soapModel;
	}

	public static ArticleHistorySoap[] toSoapModels(ArticleHistory[] models) {
		ArticleHistorySoap[] soapModels = new ArticleHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleHistorySoap[][] toSoapModels(
		ArticleHistory[][] models) {

		ArticleHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ArticleHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleHistorySoap[] toSoapModels(
		List<ArticleHistory> models) {

		List<ArticleHistorySoap> soapModels = new ArrayList<ArticleHistorySoap>(
			models.size());

		for (ArticleHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleHistorySoap[soapModels.size()]);
	}

	public ArticleHistorySoap() {
	}

	public long getPrimaryKey() {
		return _articleHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setArticleHistoryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getArticleHistoryId() {
		return _articleHistoryId;
	}

	public void setArticleHistoryId(long articleHistoryId) {
		_articleHistoryId = articleHistoryId;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSummnary() {
		return _summnary;
	}

	public void setSummnary(String summnary) {
		_summnary = summnary;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getImageDescription() {
		return _imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		_imageDescription = imageDescription;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getDonVi() {
		return _donVi;
	}

	public void setDonVi(String donVi) {
		_donVi = donVi;
	}

	public String getLoaiTinBai() {
		return _loaiTinBai;
	}

	public void setLoaiTinBai(String loaiTinBai) {
		_loaiTinBai = loaiTinBai;
	}

	public String getSoKyTuBaiViet() {
		return _soKyTuBaiViet;
	}

	public void setSoKyTuBaiViet(String soKyTuBaiViet) {
		_soKyTuBaiViet = soKyTuBaiViet;
	}

	public String getSoAnhBaiViet() {
		return _soAnhBaiViet;
	}

	public void setSoAnhBaiViet(String soAnhBaiViet) {
		_soAnhBaiViet = soAnhBaiViet;
	}

	public String getLoaiAnh() {
		return _loaiAnh;
	}

	public void setLoaiAnh(String loaiAnh) {
		_loaiAnh = loaiAnh;
	}

	public String getTheLoaiTinBai() {
		return _theLoaiTinBai;
	}

	public void setTheLoaiTinBai(String theLoaiTinBai) {
		_theLoaiTinBai = theLoaiTinBai;
	}

	private String _uuid;
	private long _articleHistoryId;
	private long _articleId;
	private String _title;
	private String _summnary;
	private String _content;
	private String _imageDescription;
	private String _image;
	private String _author;
	private String _source;
	private long _userId;
	private Date _createdDate;
	private String _donVi;
	private String _loaiTinBai;
	private String _soKyTuBaiViet;
	private String _soAnhBaiViet;
	private String _loaiAnh;
	private String _theLoaiTinBai;

}