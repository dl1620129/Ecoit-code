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

package com.software.cms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.software.cms.model.Article;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Article in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class ArticleCacheModel implements CacheModel<Article>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleCacheModel)) {
			return false;
		}

		ArticleCacheModel articleCacheModel = (ArticleCacheModel)obj;

		if (articleId == articleCacheModel.articleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, articleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(97);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", language=");
		sb.append(language);
		sb.append(", title=");
		sb.append(title);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", content=");
		sb.append(content);
		sb.append(", image=");
		sb.append(image);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", author=");
		sb.append(author);
		sb.append(", source=");
		sb.append(source);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", allowComent=");
		sb.append(allowComent);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", pendingDate=");
		sb.append(pendingDate);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", neverExpire=");
		sb.append(neverExpire);
		sb.append(", publishedDateFrom=");
		sb.append(publishedDateFrom);
		sb.append(", publishedDateTo=");
		sb.append(publishedDateTo);
		sb.append(", createdByUser=");
		sb.append(createdByUser);
		sb.append(", pendingByUser=");
		sb.append(pendingByUser);
		sb.append(", modifiedByUser=");
		sb.append(modifiedByUser);
		sb.append(", approvedByUser=");
		sb.append(approvedByUser);
		sb.append(", publishedByUser=");
		sb.append(publishedByUser);
		sb.append(", friendlyURL=");
		sb.append(friendlyURL);
		sb.append(", isImageArticle=");
		sb.append(isImageArticle);
		sb.append(", isHomePage=");
		sb.append(isHomePage);
		sb.append(", thuTu=");
		sb.append(thuTu);
		sb.append(", InvolveArt=");
		sb.append(InvolveArt);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", tags=");
		sb.append(tags);
		sb.append(", tagIds=");
		sb.append(tagIds);
		sb.append(", eventIds=");
		sb.append(eventIds);
		sb.append(", events=");
		sb.append(events);
		sb.append(", isRss=");
		sb.append(isRss);
		sb.append(", articleMainId=");
		sb.append(articleMainId);
		sb.append(", isSubSite=");
		sb.append(isSubSite);
		sb.append(", isNoiBat=");
		sb.append(isNoiBat);
		sb.append(", donVi=");
		sb.append(donVi);
		sb.append(", loaiTinBai=");
		sb.append(loaiTinBai);
		sb.append(", soKyTuBaiViet=");
		sb.append(soKyTuBaiViet);
		sb.append(", soAnhBaiViet=");
		sb.append(soAnhBaiViet);
		sb.append(", loaiAnh=");
		sb.append(loaiAnh);
		sb.append(", theLoaiTinBai=");
		sb.append(theLoaiTinBai);
		sb.append(", isTimer=");
		sb.append(isTimer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Article toEntityModel() {
		ArticleImpl articleImpl = new ArticleImpl();

		if (uuid == null) {
			articleImpl.setUuid("");
		}
		else {
			articleImpl.setUuid(uuid);
		}

		articleImpl.setArticleId(articleId);
		articleImpl.setGroupId(groupId);

		if (language == null) {
			articleImpl.setLanguage("");
		}
		else {
			articleImpl.setLanguage(language);
		}

		if (title == null) {
			articleImpl.setTitle("");
		}
		else {
			articleImpl.setTitle(title);
		}

		if (summary == null) {
			articleImpl.setSummary("");
		}
		else {
			articleImpl.setSummary(summary);
		}

		if (content == null) {
			articleImpl.setContent("");
		}
		else {
			articleImpl.setContent(content);
		}

		if (image == null) {
			articleImpl.setImage("");
		}
		else {
			articleImpl.setImage(image);
		}

		if (imageTitle == null) {
			articleImpl.setImageTitle("");
		}
		else {
			articleImpl.setImageTitle(imageTitle);
		}

		if (author == null) {
			articleImpl.setAuthor("");
		}
		else {
			articleImpl.setAuthor(author);
		}

		if (source == null) {
			articleImpl.setSource("");
		}
		else {
			articleImpl.setSource(source);
		}

		articleImpl.setEventId(eventId);
		articleImpl.setAllowComent(allowComent);
		articleImpl.setViewCount(viewCount);
		articleImpl.setStatus(status);

		if (createdDate == Long.MIN_VALUE) {
			articleImpl.setCreatedDate(null);
		}
		else {
			articleImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			articleImpl.setModifiedDate(null);
		}
		else {
			articleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (pendingDate == Long.MIN_VALUE) {
			articleImpl.setPendingDate(null);
		}
		else {
			articleImpl.setPendingDate(new Date(pendingDate));
		}

		if (approvedDate == Long.MIN_VALUE) {
			articleImpl.setApprovedDate(null);
		}
		else {
			articleImpl.setApprovedDate(new Date(approvedDate));
		}

		articleImpl.setNeverExpire(neverExpire);

		if (publishedDateFrom == Long.MIN_VALUE) {
			articleImpl.setPublishedDateFrom(null);
		}
		else {
			articleImpl.setPublishedDateFrom(new Date(publishedDateFrom));
		}

		if (publishedDateTo == Long.MIN_VALUE) {
			articleImpl.setPublishedDateTo(null);
		}
		else {
			articleImpl.setPublishedDateTo(new Date(publishedDateTo));
		}

		articleImpl.setCreatedByUser(createdByUser);
		articleImpl.setPendingByUser(pendingByUser);
		articleImpl.setModifiedByUser(modifiedByUser);
		articleImpl.setApprovedByUser(approvedByUser);
		articleImpl.setPublishedByUser(publishedByUser);

		if (friendlyURL == null) {
			articleImpl.setFriendlyURL("");
		}
		else {
			articleImpl.setFriendlyURL(friendlyURL);
		}

		articleImpl.setIsImageArticle(isImageArticle);
		articleImpl.setIsHomePage(isHomePage);
		articleImpl.setThuTu(thuTu);

		if (InvolveArt == null) {
			articleImpl.setInvolveArt("");
		}
		else {
			articleImpl.setInvolveArt(InvolveArt);
		}

		articleImpl.setFolderId(folderId);

		if (tags == null) {
			articleImpl.setTags("");
		}
		else {
			articleImpl.setTags(tags);
		}

		if (tagIds == null) {
			articleImpl.setTagIds("");
		}
		else {
			articleImpl.setTagIds(tagIds);
		}

		if (eventIds == null) {
			articleImpl.setEventIds("");
		}
		else {
			articleImpl.setEventIds(eventIds);
		}

		if (events == null) {
			articleImpl.setEvents("");
		}
		else {
			articleImpl.setEvents(events);
		}

		articleImpl.setIsRss(isRss);
		articleImpl.setArticleMainId(articleMainId);
		articleImpl.setIsSubSite(isSubSite);
		articleImpl.setIsNoiBat(isNoiBat);

		if (donVi == null) {
			articleImpl.setDonVi("");
		}
		else {
			articleImpl.setDonVi(donVi);
		}

		if (loaiTinBai == null) {
			articleImpl.setLoaiTinBai("");
		}
		else {
			articleImpl.setLoaiTinBai(loaiTinBai);
		}

		if (soKyTuBaiViet == null) {
			articleImpl.setSoKyTuBaiViet("");
		}
		else {
			articleImpl.setSoKyTuBaiViet(soKyTuBaiViet);
		}

		if (soAnhBaiViet == null) {
			articleImpl.setSoAnhBaiViet("");
		}
		else {
			articleImpl.setSoAnhBaiViet(soAnhBaiViet);
		}

		if (loaiAnh == null) {
			articleImpl.setLoaiAnh("");
		}
		else {
			articleImpl.setLoaiAnh(loaiAnh);
		}

		if (theLoaiTinBai == null) {
			articleImpl.setTheLoaiTinBai("");
		}
		else {
			articleImpl.setTheLoaiTinBai(theLoaiTinBai);
		}

		articleImpl.setIsTimer(isTimer);

		articleImpl.resetOriginalValues();

		return articleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		articleId = objectInput.readLong();

		groupId = objectInput.readLong();
		language = objectInput.readUTF();
		title = objectInput.readUTF();
		summary = objectInput.readUTF();
		content = objectInput.readUTF();
		image = objectInput.readUTF();
		imageTitle = objectInput.readUTF();
		author = objectInput.readUTF();
		source = objectInput.readUTF();

		eventId = objectInput.readLong();

		allowComent = objectInput.readBoolean();

		viewCount = objectInput.readLong();

		status = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		pendingDate = objectInput.readLong();
		approvedDate = objectInput.readLong();

		neverExpire = objectInput.readBoolean();
		publishedDateFrom = objectInput.readLong();
		publishedDateTo = objectInput.readLong();

		createdByUser = objectInput.readLong();

		pendingByUser = objectInput.readLong();

		modifiedByUser = objectInput.readLong();

		approvedByUser = objectInput.readLong();

		publishedByUser = objectInput.readLong();
		friendlyURL = objectInput.readUTF();

		isImageArticle = objectInput.readBoolean();

		isHomePage = objectInput.readBoolean();

		thuTu = objectInput.readLong();
		InvolveArt = objectInput.readUTF();

		folderId = objectInput.readLong();
		tags = objectInput.readUTF();
		tagIds = objectInput.readUTF();
		eventIds = objectInput.readUTF();
		events = objectInput.readUTF();

		isRss = objectInput.readBoolean();

		articleMainId = objectInput.readLong();

		isSubSite = objectInput.readBoolean();

		isNoiBat = objectInput.readBoolean();
		donVi = objectInput.readUTF();
		loaiTinBai = objectInput.readUTF();
		soKyTuBaiViet = objectInput.readUTF();
		soAnhBaiViet = objectInput.readUTF();
		loaiAnh = objectInput.readUTF();
		theLoaiTinBai = objectInput.readUTF();

		isTimer = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(articleId);

		objectOutput.writeLong(groupId);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summary);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image);
		}

		if (imageTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageTitle);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeBoolean(allowComent);

		objectOutput.writeLong(viewCount);

		objectOutput.writeLong(status);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(pendingDate);
		objectOutput.writeLong(approvedDate);

		objectOutput.writeBoolean(neverExpire);
		objectOutput.writeLong(publishedDateFrom);
		objectOutput.writeLong(publishedDateTo);

		objectOutput.writeLong(createdByUser);

		objectOutput.writeLong(pendingByUser);

		objectOutput.writeLong(modifiedByUser);

		objectOutput.writeLong(approvedByUser);

		objectOutput.writeLong(publishedByUser);

		if (friendlyURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(friendlyURL);
		}

		objectOutput.writeBoolean(isImageArticle);

		objectOutput.writeBoolean(isHomePage);

		objectOutput.writeLong(thuTu);

		if (InvolveArt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(InvolveArt);
		}

		objectOutput.writeLong(folderId);

		if (tags == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tags);
		}

		if (tagIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tagIds);
		}

		if (eventIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventIds);
		}

		if (events == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(events);
		}

		objectOutput.writeBoolean(isRss);

		objectOutput.writeLong(articleMainId);

		objectOutput.writeBoolean(isSubSite);

		objectOutput.writeBoolean(isNoiBat);

		if (donVi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(donVi);
		}

		if (loaiTinBai == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loaiTinBai);
		}

		if (soKyTuBaiViet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soKyTuBaiViet);
		}

		if (soAnhBaiViet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(soAnhBaiViet);
		}

		if (loaiAnh == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(loaiAnh);
		}

		if (theLoaiTinBai == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(theLoaiTinBai);
		}

		objectOutput.writeBoolean(isTimer);
	}

	public String uuid;
	public long articleId;
	public long groupId;
	public String language;
	public String title;
	public String summary;
	public String content;
	public String image;
	public String imageTitle;
	public String author;
	public String source;
	public long eventId;
	public boolean allowComent;
	public long viewCount;
	public long status;
	public long createdDate;
	public long modifiedDate;
	public long pendingDate;
	public long approvedDate;
	public boolean neverExpire;
	public long publishedDateFrom;
	public long publishedDateTo;
	public long createdByUser;
	public long pendingByUser;
	public long modifiedByUser;
	public long approvedByUser;
	public long publishedByUser;
	public String friendlyURL;
	public boolean isImageArticle;
	public boolean isHomePage;
	public long thuTu;
	public String InvolveArt;
	public long folderId;
	public String tags;
	public String tagIds;
	public String eventIds;
	public String events;
	public boolean isRss;
	public long articleMainId;
	public boolean isSubSite;
	public boolean isNoiBat;
	public String donVi;
	public String loaiTinBai;
	public String soKyTuBaiViet;
	public String soAnhBaiViet;
	public String loaiAnh;
	public String theLoaiTinBai;
	public boolean isTimer;

}