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
 * This class is used by SOAP remote services, specifically {@link com.software.cms.service.http.ArticleServiceSoap}.
 *
 * @author DungNV
 * @generated
 */
public class ArticleSoap implements Serializable {

	public static ArticleSoap toSoapModel(Article model) {
		ArticleSoap soapModel = new ArticleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setTitle(model.getTitle());
		soapModel.setSummary(model.getSummary());
		soapModel.setContent(model.getContent());
		soapModel.setImage(model.getImage());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setSource(model.getSource());
		soapModel.setEventId(model.getEventId());
		soapModel.setAllowComent(model.isAllowComent());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPendingDate(model.getPendingDate());
		soapModel.setApprovedDate(model.getApprovedDate());
		soapModel.setNeverExpire(model.isNeverExpire());
		soapModel.setPublishedDateFrom(model.getPublishedDateFrom());
		soapModel.setPublishedDateTo(model.getPublishedDateTo());
		soapModel.setCreatedByUser(model.getCreatedByUser());
		soapModel.setPendingByUser(model.getPendingByUser());
		soapModel.setModifiedByUser(model.getModifiedByUser());
		soapModel.setApprovedByUser(model.getApprovedByUser());
		soapModel.setPublishedByUser(model.getPublishedByUser());
		soapModel.setFriendlyURL(model.getFriendlyURL());
		soapModel.setIsImageArticle(model.isIsImageArticle());
		soapModel.setIsHomePage(model.isIsHomePage());
		soapModel.setThuTu(model.getThuTu());
		soapModel.setInvolveArt(model.getInvolveArt());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setTags(model.getTags());
		soapModel.setTagIds(model.getTagIds());
		soapModel.setEventIds(model.getEventIds());
		soapModel.setEvents(model.getEvents());
		soapModel.setIsRss(model.isIsRss());
		soapModel.setArticleMainId(model.getArticleMainId());
		soapModel.setIsSubSite(model.isIsSubSite());
		soapModel.setIsNoiBat(model.isIsNoiBat());
		soapModel.setDonVi(model.getDonVi());
		soapModel.setLoaiTinBai(model.getLoaiTinBai());
		soapModel.setSoKyTuBaiViet(model.getSoKyTuBaiViet());
		soapModel.setSoAnhBaiViet(model.getSoAnhBaiViet());
		soapModel.setLoaiAnh(model.getLoaiAnh());
		soapModel.setTheLoaiTinBai(model.getTheLoaiTinBai());
		soapModel.setIsTimer(model.isIsTimer());
		soapModel.setHumanAccess(model.getHumanAccess());
		soapModel.setHumanAccessIds(model.getHumanAccessIds());

		return soapModel;
	}

	public static ArticleSoap[] toSoapModels(Article[] models) {
		ArticleSoap[] soapModels = new ArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleSoap[][] toSoapModels(Article[][] models) {
		ArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleSoap[] toSoapModels(List<Article> models) {
		List<ArticleSoap> soapModels = new ArrayList<ArticleSoap>(
			models.size());

		for (Article model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleSoap[soapModels.size()]);
	}

	public ArticleSoap() {
	}

	public long getPrimaryKey() {
		return _articleId;
	}

	public void setPrimaryKey(long pk) {
		setArticleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getImageTitle() {
		return _imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
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

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public boolean getAllowComent() {
		return _allowComent;
	}

	public boolean isAllowComent() {
		return _allowComent;
	}

	public void setAllowComent(boolean allowComent) {
		_allowComent = allowComent;
	}

	public long getViewCount() {
		return _viewCount;
	}

	public void setViewCount(long viewCount) {
		_viewCount = viewCount;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getPendingDate() {
		return _pendingDate;
	}

	public void setPendingDate(Date pendingDate) {
		_pendingDate = pendingDate;
	}

	public Date getApprovedDate() {
		return _approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		_approvedDate = approvedDate;
	}

	public boolean getNeverExpire() {
		return _neverExpire;
	}

	public boolean isNeverExpire() {
		return _neverExpire;
	}

	public void setNeverExpire(boolean neverExpire) {
		_neverExpire = neverExpire;
	}

	public Date getPublishedDateFrom() {
		return _publishedDateFrom;
	}

	public void setPublishedDateFrom(Date publishedDateFrom) {
		_publishedDateFrom = publishedDateFrom;
	}

	public Date getPublishedDateTo() {
		return _publishedDateTo;
	}

	public void setPublishedDateTo(Date publishedDateTo) {
		_publishedDateTo = publishedDateTo;
	}

	public long getCreatedByUser() {
		return _createdByUser;
	}

	public void setCreatedByUser(long createdByUser) {
		_createdByUser = createdByUser;
	}

	public long getPendingByUser() {
		return _pendingByUser;
	}

	public void setPendingByUser(long pendingByUser) {
		_pendingByUser = pendingByUser;
	}

	public long getModifiedByUser() {
		return _modifiedByUser;
	}

	public void setModifiedByUser(long modifiedByUser) {
		_modifiedByUser = modifiedByUser;
	}

	public long getApprovedByUser() {
		return _approvedByUser;
	}

	public void setApprovedByUser(long approvedByUser) {
		_approvedByUser = approvedByUser;
	}

	public long getPublishedByUser() {
		return _publishedByUser;
	}

	public void setPublishedByUser(long publishedByUser) {
		_publishedByUser = publishedByUser;
	}

	public String getFriendlyURL() {
		return _friendlyURL;
	}

	public void setFriendlyURL(String friendlyURL) {
		_friendlyURL = friendlyURL;
	}

	public boolean getIsImageArticle() {
		return _isImageArticle;
	}

	public boolean isIsImageArticle() {
		return _isImageArticle;
	}

	public void setIsImageArticle(boolean isImageArticle) {
		_isImageArticle = isImageArticle;
	}

	public boolean getIsHomePage() {
		return _isHomePage;
	}

	public boolean isIsHomePage() {
		return _isHomePage;
	}

	public void setIsHomePage(boolean isHomePage) {
		_isHomePage = isHomePage;
	}

	public long getThuTu() {
		return _thuTu;
	}

	public void setThuTu(long thuTu) {
		_thuTu = thuTu;
	}

	public String getInvolveArt() {
		return _InvolveArt;
	}

	public void setInvolveArt(String InvolveArt) {
		_InvolveArt = InvolveArt;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	public String getTagIds() {
		return _tagIds;
	}

	public void setTagIds(String tagIds) {
		_tagIds = tagIds;
	}

	public String getEventIds() {
		return _eventIds;
	}

	public void setEventIds(String eventIds) {
		_eventIds = eventIds;
	}

	public String getEvents() {
		return _events;
	}

	public void setEvents(String events) {
		_events = events;
	}

	public boolean getIsRss() {
		return _isRss;
	}

	public boolean isIsRss() {
		return _isRss;
	}

	public void setIsRss(boolean isRss) {
		_isRss = isRss;
	}

	public long getArticleMainId() {
		return _articleMainId;
	}

	public void setArticleMainId(long articleMainId) {
		_articleMainId = articleMainId;
	}

	public boolean getIsSubSite() {
		return _isSubSite;
	}

	public boolean isIsSubSite() {
		return _isSubSite;
	}

	public void setIsSubSite(boolean isSubSite) {
		_isSubSite = isSubSite;
	}

	public boolean getIsNoiBat() {
		return _isNoiBat;
	}

	public boolean isIsNoiBat() {
		return _isNoiBat;
	}

	public void setIsNoiBat(boolean isNoiBat) {
		_isNoiBat = isNoiBat;
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

	public boolean getIsTimer() {
		return _isTimer;
	}

	public boolean isIsTimer() {
		return _isTimer;
	}

	public void setIsTimer(boolean isTimer) {
		_isTimer = isTimer;
	}

	public String getHumanAccess() {
		return _humanAccess;
	}

	public void setHumanAccess(String humanAccess) {
		_humanAccess = humanAccess;
	}

	public String getHumanAccessIds() {
		return _humanAccessIds;
	}

	public void setHumanAccessIds(String humanAccessIds) {
		_humanAccessIds = humanAccessIds;
	}

	private String _uuid;
	private long _articleId;
	private long _groupId;
	private String _language;
	private String _title;
	private String _summary;
	private String _content;
	private String _image;
	private String _imageTitle;
	private String _author;
	private String _source;
	private long _eventId;
	private boolean _allowComent;
	private long _viewCount;
	private long _status;
	private Date _createdDate;
	private Date _modifiedDate;
	private Date _pendingDate;
	private Date _approvedDate;
	private boolean _neverExpire;
	private Date _publishedDateFrom;
	private Date _publishedDateTo;
	private long _createdByUser;
	private long _pendingByUser;
	private long _modifiedByUser;
	private long _approvedByUser;
	private long _publishedByUser;
	private String _friendlyURL;
	private boolean _isImageArticle;
	private boolean _isHomePage;
	private long _thuTu;
	private String _InvolveArt;
	private long _folderId;
	private String _tags;
	private String _tagIds;
	private String _eventIds;
	private String _events;
	private boolean _isRss;
	private long _articleMainId;
	private boolean _isSubSite;
	private boolean _isNoiBat;
	private String _donVi;
	private String _loaiTinBai;
	private String _soKyTuBaiViet;
	private String _soAnhBaiViet;
	private String _loaiAnh;
	private String _theLoaiTinBai;
	private boolean _isTimer;
	private String _humanAccess;
	private String _humanAccessIds;

}