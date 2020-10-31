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
 * This class is a wrapper for {@link Article}.
 * </p>
 *
 * @author DungNV
 * @see Article
 * @generated
 */
public class ArticleWrapper
	extends BaseModelWrapper<Article>
	implements Article, ModelWrapper<Article> {

	public ArticleWrapper(Article article) {
		super(article);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("articleId", getArticleId());
		attributes.put("groupId", getGroupId());
		attributes.put("language", getLanguage());
		attributes.put("title", getTitle());
		attributes.put("summary", getSummary());
		attributes.put("content", getContent());
		attributes.put("image", getImage());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("author", getAuthor());
		attributes.put("source", getSource());
		attributes.put("eventId", getEventId());
		attributes.put("allowComent", isAllowComent());
		attributes.put("viewCount", getViewCount());
		attributes.put("status", getStatus());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("pendingDate", getPendingDate());
		attributes.put("approvedDate", getApprovedDate());
		attributes.put("neverExpire", isNeverExpire());
		attributes.put("publishedDateFrom", getPublishedDateFrom());
		attributes.put("publishedDateTo", getPublishedDateTo());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("pendingByUser", getPendingByUser());
		attributes.put("modifiedByUser", getModifiedByUser());
		attributes.put("approvedByUser", getApprovedByUser());
		attributes.put("publishedByUser", getPublishedByUser());
		attributes.put("friendlyURL", getFriendlyURL());
		attributes.put("isImageArticle", isIsImageArticle());
		attributes.put("isHomePage", isIsHomePage());
		attributes.put("thuTu", getThuTu());
		attributes.put("InvolveArt", getInvolveArt());
		attributes.put("folderId", getFolderId());
		attributes.put("tags", getTags());
		attributes.put("tagIds", getTagIds());
		attributes.put("eventIds", getEventIds());
		attributes.put("events", getEvents());
		attributes.put("isRss", isIsRss());
		attributes.put("articleMainId", getArticleMainId());
		attributes.put("isSubSite", isIsSubSite());
		attributes.put("isNoiBat", isIsNoiBat());
		attributes.put("donVi", getDonVi());
		attributes.put("loaiTinBai", getLoaiTinBai());
		attributes.put("soKyTuBaiViet", getSoKyTuBaiViet());
		attributes.put("soAnhBaiViet", getSoAnhBaiViet());
		attributes.put("loaiAnh", getLoaiAnh());
		attributes.put("theLoaiTinBai", getTheLoaiTinBai());
		attributes.put("isTimer", isIsTimer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Boolean allowComent = (Boolean)attributes.get("allowComent");

		if (allowComent != null) {
			setAllowComent(allowComent);
		}

		Long viewCount = (Long)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date pendingDate = (Date)attributes.get("pendingDate");

		if (pendingDate != null) {
			setPendingDate(pendingDate);
		}

		Date approvedDate = (Date)attributes.get("approvedDate");

		if (approvedDate != null) {
			setApprovedDate(approvedDate);
		}

		Boolean neverExpire = (Boolean)attributes.get("neverExpire");

		if (neverExpire != null) {
			setNeverExpire(neverExpire);
		}

		Date publishedDateFrom = (Date)attributes.get("publishedDateFrom");

		if (publishedDateFrom != null) {
			setPublishedDateFrom(publishedDateFrom);
		}

		Date publishedDateTo = (Date)attributes.get("publishedDateTo");

		if (publishedDateTo != null) {
			setPublishedDateTo(publishedDateTo);
		}

		Long createdByUser = (Long)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		Long pendingByUser = (Long)attributes.get("pendingByUser");

		if (pendingByUser != null) {
			setPendingByUser(pendingByUser);
		}

		Long modifiedByUser = (Long)attributes.get("modifiedByUser");

		if (modifiedByUser != null) {
			setModifiedByUser(modifiedByUser);
		}

		Long approvedByUser = (Long)attributes.get("approvedByUser");

		if (approvedByUser != null) {
			setApprovedByUser(approvedByUser);
		}

		Long publishedByUser = (Long)attributes.get("publishedByUser");

		if (publishedByUser != null) {
			setPublishedByUser(publishedByUser);
		}

		String friendlyURL = (String)attributes.get("friendlyURL");

		if (friendlyURL != null) {
			setFriendlyURL(friendlyURL);
		}

		Boolean isImageArticle = (Boolean)attributes.get("isImageArticle");

		if (isImageArticle != null) {
			setIsImageArticle(isImageArticle);
		}

		Boolean isHomePage = (Boolean)attributes.get("isHomePage");

		if (isHomePage != null) {
			setIsHomePage(isHomePage);
		}

		Long thuTu = (Long)attributes.get("thuTu");

		if (thuTu != null) {
			setThuTu(thuTu);
		}

		String InvolveArt = (String)attributes.get("InvolveArt");

		if (InvolveArt != null) {
			setInvolveArt(InvolveArt);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}

		String tagIds = (String)attributes.get("tagIds");

		if (tagIds != null) {
			setTagIds(tagIds);
		}

		String eventIds = (String)attributes.get("eventIds");

		if (eventIds != null) {
			setEventIds(eventIds);
		}

		String events = (String)attributes.get("events");

		if (events != null) {
			setEvents(events);
		}

		Boolean isRss = (Boolean)attributes.get("isRss");

		if (isRss != null) {
			setIsRss(isRss);
		}

		Long articleMainId = (Long)attributes.get("articleMainId");

		if (articleMainId != null) {
			setArticleMainId(articleMainId);
		}

		Boolean isSubSite = (Boolean)attributes.get("isSubSite");

		if (isSubSite != null) {
			setIsSubSite(isSubSite);
		}

		Boolean isNoiBat = (Boolean)attributes.get("isNoiBat");

		if (isNoiBat != null) {
			setIsNoiBat(isNoiBat);
		}

		String donVi = (String)attributes.get("donVi");

		if (donVi != null) {
			setDonVi(donVi);
		}

		String loaiTinBai = (String)attributes.get("loaiTinBai");

		if (loaiTinBai != null) {
			setLoaiTinBai(loaiTinBai);
		}

		String soKyTuBaiViet = (String)attributes.get("soKyTuBaiViet");

		if (soKyTuBaiViet != null) {
			setSoKyTuBaiViet(soKyTuBaiViet);
		}

		String soAnhBaiViet = (String)attributes.get("soAnhBaiViet");

		if (soAnhBaiViet != null) {
			setSoAnhBaiViet(soAnhBaiViet);
		}

		String loaiAnh = (String)attributes.get("loaiAnh");

		if (loaiAnh != null) {
			setLoaiAnh(loaiAnh);
		}

		String theLoaiTinBai = (String)attributes.get("theLoaiTinBai");

		if (theLoaiTinBai != null) {
			setTheLoaiTinBai(theLoaiTinBai);
		}

		Boolean isTimer = (Boolean)attributes.get("isTimer");

		if (isTimer != null) {
			setIsTimer(isTimer);
		}
	}

	/**
	 * Returns the allow coment of this article.
	 *
	 * @return the allow coment of this article
	 */
	@Override
	public boolean getAllowComent() {
		return model.getAllowComent();
	}

	/**
	 * Returns the approved by user of this article.
	 *
	 * @return the approved by user of this article
	 */
	@Override
	public long getApprovedByUser() {
		return model.getApprovedByUser();
	}

	/**
	 * Returns the approved date of this article.
	 *
	 * @return the approved date of this article
	 */
	@Override
	public Date getApprovedDate() {
		return model.getApprovedDate();
	}

	/**
	 * Returns the article ID of this article.
	 *
	 * @return the article ID of this article
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the article main ID of this article.
	 *
	 * @return the article main ID of this article
	 */
	@Override
	public long getArticleMainId() {
		return model.getArticleMainId();
	}

	/**
	 * Returns the author of this article.
	 *
	 * @return the author of this article
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the content of this article.
	 *
	 * @return the content of this article
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by user of this article.
	 *
	 * @return the created by user of this article
	 */
	@Override
	public long getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this article.
	 *
	 * @return the created date of this article
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the don vi of this article.
	 *
	 * @return the don vi of this article
	 */
	@Override
	public String getDonVi() {
		return model.getDonVi();
	}

	/**
	 * Returns the event ID of this article.
	 *
	 * @return the event ID of this article
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the event IDs of this article.
	 *
	 * @return the event IDs of this article
	 */
	@Override
	public String getEventIds() {
		return model.getEventIds();
	}

	/**
	 * Returns the events of this article.
	 *
	 * @return the events of this article
	 */
	@Override
	public String getEvents() {
		return model.getEvents();
	}

	/**
	 * Returns the folder ID of this article.
	 *
	 * @return the folder ID of this article
	 */
	@Override
	public long getFolderId() {
		return model.getFolderId();
	}

	/**
	 * Returns the friendly url of this article.
	 *
	 * @return the friendly url of this article
	 */
	@Override
	public String getFriendlyURL() {
		return model.getFriendlyURL();
	}

	/**
	 * Returns the group ID of this article.
	 *
	 * @return the group ID of this article
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image of this article.
	 *
	 * @return the image of this article
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the image title of this article.
	 *
	 * @return the image title of this article
	 */
	@Override
	public String getImageTitle() {
		return model.getImageTitle();
	}

	/**
	 * Returns the involve art of this article.
	 *
	 * @return the involve art of this article
	 */
	@Override
	public String getInvolveArt() {
		return model.getInvolveArt();
	}

	/**
	 * Returns the is home page of this article.
	 *
	 * @return the is home page of this article
	 */
	@Override
	public boolean getIsHomePage() {
		return model.getIsHomePage();
	}

	/**
	 * Returns the is image article of this article.
	 *
	 * @return the is image article of this article
	 */
	@Override
	public boolean getIsImageArticle() {
		return model.getIsImageArticle();
	}

	/**
	 * Returns the is noi bat of this article.
	 *
	 * @return the is noi bat of this article
	 */
	@Override
	public boolean getIsNoiBat() {
		return model.getIsNoiBat();
	}

	/**
	 * Returns the is rss of this article.
	 *
	 * @return the is rss of this article
	 */
	@Override
	public boolean getIsRss() {
		return model.getIsRss();
	}

	/**
	 * Returns the is sub site of this article.
	 *
	 * @return the is sub site of this article
	 */
	@Override
	public boolean getIsSubSite() {
		return model.getIsSubSite();
	}

	/**
	 * Returns the is timer of this article.
	 *
	 * @return the is timer of this article
	 */
	@Override
	public boolean getIsTimer() {
		return model.getIsTimer();
	}

	/**
	 * Returns the language of this article.
	 *
	 * @return the language of this article
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the loai anh of this article.
	 *
	 * @return the loai anh of this article
	 */
	@Override
	public String getLoaiAnh() {
		return model.getLoaiAnh();
	}

	/**
	 * Returns the loai tin bai of this article.
	 *
	 * @return the loai tin bai of this article
	 */
	@Override
	public String getLoaiTinBai() {
		return model.getLoaiTinBai();
	}

	/**
	 * Returns the modified by user of this article.
	 *
	 * @return the modified by user of this article
	 */
	@Override
	public long getModifiedByUser() {
		return model.getModifiedByUser();
	}

	/**
	 * Returns the modified date of this article.
	 *
	 * @return the modified date of this article
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the never expire of this article.
	 *
	 * @return the never expire of this article
	 */
	@Override
	public boolean getNeverExpire() {
		return model.getNeverExpire();
	}

	/**
	 * Returns the pending by user of this article.
	 *
	 * @return the pending by user of this article
	 */
	@Override
	public long getPendingByUser() {
		return model.getPendingByUser();
	}

	/**
	 * Returns the pending date of this article.
	 *
	 * @return the pending date of this article
	 */
	@Override
	public Date getPendingDate() {
		return model.getPendingDate();
	}

	/**
	 * Returns the primary key of this article.
	 *
	 * @return the primary key of this article
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the published by user of this article.
	 *
	 * @return the published by user of this article
	 */
	@Override
	public long getPublishedByUser() {
		return model.getPublishedByUser();
	}

	/**
	 * Returns the published date from of this article.
	 *
	 * @return the published date from of this article
	 */
	@Override
	public Date getPublishedDateFrom() {
		return model.getPublishedDateFrom();
	}

	/**
	 * Returns the published date to of this article.
	 *
	 * @return the published date to of this article
	 */
	@Override
	public Date getPublishedDateTo() {
		return model.getPublishedDateTo();
	}

	/**
	 * Returns the so anh bai viet of this article.
	 *
	 * @return the so anh bai viet of this article
	 */
	@Override
	public String getSoAnhBaiViet() {
		return model.getSoAnhBaiViet();
	}

	/**
	 * Returns the so ky tu bai viet of this article.
	 *
	 * @return the so ky tu bai viet of this article
	 */
	@Override
	public String getSoKyTuBaiViet() {
		return model.getSoKyTuBaiViet();
	}

	/**
	 * Returns the source of this article.
	 *
	 * @return the source of this article
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the status of this article.
	 *
	 * @return the status of this article
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the summary of this article.
	 *
	 * @return the summary of this article
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the tag IDs of this article.
	 *
	 * @return the tag IDs of this article
	 */
	@Override
	public String getTagIds() {
		return model.getTagIds();
	}

	/**
	 * Returns the tags of this article.
	 *
	 * @return the tags of this article
	 */
	@Override
	public String getTags() {
		return model.getTags();
	}

	/**
	 * Returns the the loai tin bai of this article.
	 *
	 * @return the the loai tin bai of this article
	 */
	@Override
	public String getTheLoaiTinBai() {
		return model.getTheLoaiTinBai();
	}

	/**
	 * Returns the thu tu of this article.
	 *
	 * @return the thu tu of this article
	 */
	@Override
	public long getThuTu() {
		return model.getThuTu();
	}

	/**
	 * Returns the title of this article.
	 *
	 * @return the title of this article
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this article.
	 *
	 * @return the uuid of this article
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the view count of this article.
	 *
	 * @return the view count of this article
	 */
	@Override
	public long getViewCount() {
		return model.getViewCount();
	}

	/**
	 * Returns <code>true</code> if this article is allow coment.
	 *
	 * @return <code>true</code> if this article is allow coment; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllowComent() {
		return model.isAllowComent();
	}

	/**
	 * Returns <code>true</code> if this article is is home page.
	 *
	 * @return <code>true</code> if this article is is home page; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsHomePage() {
		return model.isIsHomePage();
	}

	/**
	 * Returns <code>true</code> if this article is is image article.
	 *
	 * @return <code>true</code> if this article is is image article; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsImageArticle() {
		return model.isIsImageArticle();
	}

	/**
	 * Returns <code>true</code> if this article is is noi bat.
	 *
	 * @return <code>true</code> if this article is is noi bat; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsNoiBat() {
		return model.isIsNoiBat();
	}

	/**
	 * Returns <code>true</code> if this article is is rss.
	 *
	 * @return <code>true</code> if this article is is rss; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRss() {
		return model.isIsRss();
	}

	/**
	 * Returns <code>true</code> if this article is is sub site.
	 *
	 * @return <code>true</code> if this article is is sub site; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSubSite() {
		return model.isIsSubSite();
	}

	/**
	 * Returns <code>true</code> if this article is is timer.
	 *
	 * @return <code>true</code> if this article is is timer; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsTimer() {
		return model.isIsTimer();
	}

	/**
	 * Returns <code>true</code> if this article is never expire.
	 *
	 * @return <code>true</code> if this article is never expire; <code>false</code> otherwise
	 */
	@Override
	public boolean isNeverExpire() {
		return model.isNeverExpire();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this article is allow coment.
	 *
	 * @param allowComent the allow coment of this article
	 */
	@Override
	public void setAllowComent(boolean allowComent) {
		model.setAllowComent(allowComent);
	}

	/**
	 * Sets the approved by user of this article.
	 *
	 * @param approvedByUser the approved by user of this article
	 */
	@Override
	public void setApprovedByUser(long approvedByUser) {
		model.setApprovedByUser(approvedByUser);
	}

	/**
	 * Sets the approved date of this article.
	 *
	 * @param approvedDate the approved date of this article
	 */
	@Override
	public void setApprovedDate(Date approvedDate) {
		model.setApprovedDate(approvedDate);
	}

	/**
	 * Sets the article ID of this article.
	 *
	 * @param articleId the article ID of this article
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the article main ID of this article.
	 *
	 * @param articleMainId the article main ID of this article
	 */
	@Override
	public void setArticleMainId(long articleMainId) {
		model.setArticleMainId(articleMainId);
	}

	/**
	 * Sets the author of this article.
	 *
	 * @param author the author of this article
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the content of this article.
	 *
	 * @param content the content of this article
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by user of this article.
	 *
	 * @param createdByUser the created by user of this article
	 */
	@Override
	public void setCreatedByUser(long createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this article.
	 *
	 * @param createdDate the created date of this article
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the don vi of this article.
	 *
	 * @param donVi the don vi of this article
	 */
	@Override
	public void setDonVi(String donVi) {
		model.setDonVi(donVi);
	}

	/**
	 * Sets the event ID of this article.
	 *
	 * @param eventId the event ID of this article
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the event IDs of this article.
	 *
	 * @param eventIds the event IDs of this article
	 */
	@Override
	public void setEventIds(String eventIds) {
		model.setEventIds(eventIds);
	}

	/**
	 * Sets the events of this article.
	 *
	 * @param events the events of this article
	 */
	@Override
	public void setEvents(String events) {
		model.setEvents(events);
	}

	/**
	 * Sets the folder ID of this article.
	 *
	 * @param folderId the folder ID of this article
	 */
	@Override
	public void setFolderId(long folderId) {
		model.setFolderId(folderId);
	}

	/**
	 * Sets the friendly url of this article.
	 *
	 * @param friendlyURL the friendly url of this article
	 */
	@Override
	public void setFriendlyURL(String friendlyURL) {
		model.setFriendlyURL(friendlyURL);
	}

	/**
	 * Sets the group ID of this article.
	 *
	 * @param groupId the group ID of this article
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image of this article.
	 *
	 * @param image the image of this article
	 */
	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the image title of this article.
	 *
	 * @param imageTitle the image title of this article
	 */
	@Override
	public void setImageTitle(String imageTitle) {
		model.setImageTitle(imageTitle);
	}

	/**
	 * Sets the involve art of this article.
	 *
	 * @param InvolveArt the involve art of this article
	 */
	@Override
	public void setInvolveArt(String InvolveArt) {
		model.setInvolveArt(InvolveArt);
	}

	/**
	 * Sets whether this article is is home page.
	 *
	 * @param isHomePage the is home page of this article
	 */
	@Override
	public void setIsHomePage(boolean isHomePage) {
		model.setIsHomePage(isHomePage);
	}

	/**
	 * Sets whether this article is is image article.
	 *
	 * @param isImageArticle the is image article of this article
	 */
	@Override
	public void setIsImageArticle(boolean isImageArticle) {
		model.setIsImageArticle(isImageArticle);
	}

	/**
	 * Sets whether this article is is noi bat.
	 *
	 * @param isNoiBat the is noi bat of this article
	 */
	@Override
	public void setIsNoiBat(boolean isNoiBat) {
		model.setIsNoiBat(isNoiBat);
	}

	/**
	 * Sets whether this article is is rss.
	 *
	 * @param isRss the is rss of this article
	 */
	@Override
	public void setIsRss(boolean isRss) {
		model.setIsRss(isRss);
	}

	/**
	 * Sets whether this article is is sub site.
	 *
	 * @param isSubSite the is sub site of this article
	 */
	@Override
	public void setIsSubSite(boolean isSubSite) {
		model.setIsSubSite(isSubSite);
	}

	/**
	 * Sets whether this article is is timer.
	 *
	 * @param isTimer the is timer of this article
	 */
	@Override
	public void setIsTimer(boolean isTimer) {
		model.setIsTimer(isTimer);
	}

	/**
	 * Sets the language of this article.
	 *
	 * @param language the language of this article
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the loai anh of this article.
	 *
	 * @param loaiAnh the loai anh of this article
	 */
	@Override
	public void setLoaiAnh(String loaiAnh) {
		model.setLoaiAnh(loaiAnh);
	}

	/**
	 * Sets the loai tin bai of this article.
	 *
	 * @param loaiTinBai the loai tin bai of this article
	 */
	@Override
	public void setLoaiTinBai(String loaiTinBai) {
		model.setLoaiTinBai(loaiTinBai);
	}

	/**
	 * Sets the modified by user of this article.
	 *
	 * @param modifiedByUser the modified by user of this article
	 */
	@Override
	public void setModifiedByUser(long modifiedByUser) {
		model.setModifiedByUser(modifiedByUser);
	}

	/**
	 * Sets the modified date of this article.
	 *
	 * @param modifiedDate the modified date of this article
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this article is never expire.
	 *
	 * @param neverExpire the never expire of this article
	 */
	@Override
	public void setNeverExpire(boolean neverExpire) {
		model.setNeverExpire(neverExpire);
	}

	/**
	 * Sets the pending by user of this article.
	 *
	 * @param pendingByUser the pending by user of this article
	 */
	@Override
	public void setPendingByUser(long pendingByUser) {
		model.setPendingByUser(pendingByUser);
	}

	/**
	 * Sets the pending date of this article.
	 *
	 * @param pendingDate the pending date of this article
	 */
	@Override
	public void setPendingDate(Date pendingDate) {
		model.setPendingDate(pendingDate);
	}

	/**
	 * Sets the primary key of this article.
	 *
	 * @param primaryKey the primary key of this article
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the published by user of this article.
	 *
	 * @param publishedByUser the published by user of this article
	 */
	@Override
	public void setPublishedByUser(long publishedByUser) {
		model.setPublishedByUser(publishedByUser);
	}

	/**
	 * Sets the published date from of this article.
	 *
	 * @param publishedDateFrom the published date from of this article
	 */
	@Override
	public void setPublishedDateFrom(Date publishedDateFrom) {
		model.setPublishedDateFrom(publishedDateFrom);
	}

	/**
	 * Sets the published date to of this article.
	 *
	 * @param publishedDateTo the published date to of this article
	 */
	@Override
	public void setPublishedDateTo(Date publishedDateTo) {
		model.setPublishedDateTo(publishedDateTo);
	}

	/**
	 * Sets the so anh bai viet of this article.
	 *
	 * @param soAnhBaiViet the so anh bai viet of this article
	 */
	@Override
	public void setSoAnhBaiViet(String soAnhBaiViet) {
		model.setSoAnhBaiViet(soAnhBaiViet);
	}

	/**
	 * Sets the so ky tu bai viet of this article.
	 *
	 * @param soKyTuBaiViet the so ky tu bai viet of this article
	 */
	@Override
	public void setSoKyTuBaiViet(String soKyTuBaiViet) {
		model.setSoKyTuBaiViet(soKyTuBaiViet);
	}

	/**
	 * Sets the source of this article.
	 *
	 * @param source the source of this article
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the status of this article.
	 *
	 * @param status the status of this article
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the summary of this article.
	 *
	 * @param summary the summary of this article
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the tag IDs of this article.
	 *
	 * @param tagIds the tag IDs of this article
	 */
	@Override
	public void setTagIds(String tagIds) {
		model.setTagIds(tagIds);
	}

	/**
	 * Sets the tags of this article.
	 *
	 * @param tags the tags of this article
	 */
	@Override
	public void setTags(String tags) {
		model.setTags(tags);
	}

	/**
	 * Sets the the loai tin bai of this article.
	 *
	 * @param theLoaiTinBai the the loai tin bai of this article
	 */
	@Override
	public void setTheLoaiTinBai(String theLoaiTinBai) {
		model.setTheLoaiTinBai(theLoaiTinBai);
	}

	/**
	 * Sets the thu tu of this article.
	 *
	 * @param thuTu the thu tu of this article
	 */
	@Override
	public void setThuTu(long thuTu) {
		model.setThuTu(thuTu);
	}

	/**
	 * Sets the title of this article.
	 *
	 * @param title the title of this article
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this article.
	 *
	 * @param uuid the uuid of this article
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the view count of this article.
	 *
	 * @param viewCount the view count of this article
	 */
	@Override
	public void setViewCount(long viewCount) {
		model.setViewCount(viewCount);
	}

	@Override
	protected ArticleWrapper wrap(Article article) {
		return new ArticleWrapper(article);
	}

}