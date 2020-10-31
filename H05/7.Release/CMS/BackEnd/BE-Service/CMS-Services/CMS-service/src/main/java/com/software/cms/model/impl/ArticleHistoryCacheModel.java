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

import com.software.cms.model.ArticleHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ArticleHistory in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class ArticleHistoryCacheModel
	implements CacheModel<ArticleHistory>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleHistoryCacheModel)) {
			return false;
		}

		ArticleHistoryCacheModel articleHistoryCacheModel =
			(ArticleHistoryCacheModel)obj;

		if (articleHistoryId == articleHistoryCacheModel.articleHistoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, articleHistoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", articleHistoryId=");
		sb.append(articleHistoryId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", summnary=");
		sb.append(summnary);
		sb.append(", content=");
		sb.append(content);
		sb.append(", imageDescription=");
		sb.append(imageDescription);
		sb.append(", image=");
		sb.append(image);
		sb.append(", author=");
		sb.append(author);
		sb.append(", source=");
		sb.append(source);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArticleHistory toEntityModel() {
		ArticleHistoryImpl articleHistoryImpl = new ArticleHistoryImpl();

		if (uuid == null) {
			articleHistoryImpl.setUuid("");
		}
		else {
			articleHistoryImpl.setUuid(uuid);
		}

		articleHistoryImpl.setArticleHistoryId(articleHistoryId);
		articleHistoryImpl.setArticleId(articleId);

		if (title == null) {
			articleHistoryImpl.setTitle("");
		}
		else {
			articleHistoryImpl.setTitle(title);
		}

		if (summnary == null) {
			articleHistoryImpl.setSummnary("");
		}
		else {
			articleHistoryImpl.setSummnary(summnary);
		}

		if (content == null) {
			articleHistoryImpl.setContent("");
		}
		else {
			articleHistoryImpl.setContent(content);
		}

		if (imageDescription == null) {
			articleHistoryImpl.setImageDescription("");
		}
		else {
			articleHistoryImpl.setImageDescription(imageDescription);
		}

		if (image == null) {
			articleHistoryImpl.setImage("");
		}
		else {
			articleHistoryImpl.setImage(image);
		}

		if (author == null) {
			articleHistoryImpl.setAuthor("");
		}
		else {
			articleHistoryImpl.setAuthor(author);
		}

		if (source == null) {
			articleHistoryImpl.setSource("");
		}
		else {
			articleHistoryImpl.setSource(source);
		}

		articleHistoryImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			articleHistoryImpl.setCreatedDate(null);
		}
		else {
			articleHistoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (donVi == null) {
			articleHistoryImpl.setDonVi("");
		}
		else {
			articleHistoryImpl.setDonVi(donVi);
		}

		if (loaiTinBai == null) {
			articleHistoryImpl.setLoaiTinBai("");
		}
		else {
			articleHistoryImpl.setLoaiTinBai(loaiTinBai);
		}

		if (soKyTuBaiViet == null) {
			articleHistoryImpl.setSoKyTuBaiViet("");
		}
		else {
			articleHistoryImpl.setSoKyTuBaiViet(soKyTuBaiViet);
		}

		if (soAnhBaiViet == null) {
			articleHistoryImpl.setSoAnhBaiViet("");
		}
		else {
			articleHistoryImpl.setSoAnhBaiViet(soAnhBaiViet);
		}

		if (loaiAnh == null) {
			articleHistoryImpl.setLoaiAnh("");
		}
		else {
			articleHistoryImpl.setLoaiAnh(loaiAnh);
		}

		if (theLoaiTinBai == null) {
			articleHistoryImpl.setTheLoaiTinBai("");
		}
		else {
			articleHistoryImpl.setTheLoaiTinBai(theLoaiTinBai);
		}

		articleHistoryImpl.resetOriginalValues();

		return articleHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		articleHistoryId = objectInput.readLong();

		articleId = objectInput.readLong();
		title = objectInput.readUTF();
		summnary = objectInput.readUTF();
		content = objectInput.readUTF();
		imageDescription = objectInput.readUTF();
		image = objectInput.readUTF();
		author = objectInput.readUTF();
		source = objectInput.readUTF();

		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		donVi = objectInput.readUTF();
		loaiTinBai = objectInput.readUTF();
		soKyTuBaiViet = objectInput.readUTF();
		soAnhBaiViet = objectInput.readUTF();
		loaiAnh = objectInput.readUTF();
		theLoaiTinBai = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(articleHistoryId);

		objectOutput.writeLong(articleId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (summnary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summnary);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (imageDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageDescription);
		}

		if (image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image);
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

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);

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
	}

	public String uuid;
	public long articleHistoryId;
	public long articleId;
	public String title;
	public String summnary;
	public String content;
	public String imageDescription;
	public String image;
	public String author;
	public String source;
	public long userId;
	public long createdDate;
	public String donVi;
	public String loaiTinBai;
	public String soKyTuBaiViet;
	public String soAnhBaiViet;
	public String loaiAnh;
	public String theLoaiTinBai;

}