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
 * This class is a wrapper for {@link ArticleHistory}.
 * </p>
 *
 * @author DungNV
 * @see ArticleHistory
 * @generated
 */
public class ArticleHistoryWrapper
	extends BaseModelWrapper<ArticleHistory>
	implements ArticleHistory, ModelWrapper<ArticleHistory> {

	public ArticleHistoryWrapper(ArticleHistory articleHistory) {
		super(articleHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("articleHistoryId", getArticleHistoryId());
		attributes.put("articleId", getArticleId());
		attributes.put("title", getTitle());
		attributes.put("summnary", getSummnary());
		attributes.put("content", getContent());
		attributes.put("imageDescription", getImageDescription());
		attributes.put("image", getImage());
		attributes.put("author", getAuthor());
		attributes.put("source", getSource());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("donVi", getDonVi());
		attributes.put("loaiTinBai", getLoaiTinBai());
		attributes.put("soKyTuBaiViet", getSoKyTuBaiViet());
		attributes.put("soAnhBaiViet", getSoAnhBaiViet());
		attributes.put("loaiAnh", getLoaiAnh());
		attributes.put("theLoaiTinBai", getTheLoaiTinBai());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long articleHistoryId = (Long)attributes.get("articleHistoryId");

		if (articleHistoryId != null) {
			setArticleHistoryId(articleHistoryId);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String summnary = (String)attributes.get("summnary");

		if (summnary != null) {
			setSummnary(summnary);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String imageDescription = (String)attributes.get("imageDescription");

		if (imageDescription != null) {
			setImageDescription(imageDescription);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
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
	}

	/**
	 * Returns the article history ID of this article history.
	 *
	 * @return the article history ID of this article history
	 */
	@Override
	public long getArticleHistoryId() {
		return model.getArticleHistoryId();
	}

	/**
	 * Returns the article ID of this article history.
	 *
	 * @return the article ID of this article history
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the author of this article history.
	 *
	 * @return the author of this article history
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the content of this article history.
	 *
	 * @return the content of this article history
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created date of this article history.
	 *
	 * @return the created date of this article history
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the don vi of this article history.
	 *
	 * @return the don vi of this article history
	 */
	@Override
	public String getDonVi() {
		return model.getDonVi();
	}

	/**
	 * Returns the image of this article history.
	 *
	 * @return the image of this article history
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the image description of this article history.
	 *
	 * @return the image description of this article history
	 */
	@Override
	public String getImageDescription() {
		return model.getImageDescription();
	}

	/**
	 * Returns the loai anh of this article history.
	 *
	 * @return the loai anh of this article history
	 */
	@Override
	public String getLoaiAnh() {
		return model.getLoaiAnh();
	}

	/**
	 * Returns the loai tin bai of this article history.
	 *
	 * @return the loai tin bai of this article history
	 */
	@Override
	public String getLoaiTinBai() {
		return model.getLoaiTinBai();
	}

	/**
	 * Returns the primary key of this article history.
	 *
	 * @return the primary key of this article history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the so anh bai viet of this article history.
	 *
	 * @return the so anh bai viet of this article history
	 */
	@Override
	public String getSoAnhBaiViet() {
		return model.getSoAnhBaiViet();
	}

	/**
	 * Returns the so ky tu bai viet of this article history.
	 *
	 * @return the so ky tu bai viet of this article history
	 */
	@Override
	public String getSoKyTuBaiViet() {
		return model.getSoKyTuBaiViet();
	}

	/**
	 * Returns the source of this article history.
	 *
	 * @return the source of this article history
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the summnary of this article history.
	 *
	 * @return the summnary of this article history
	 */
	@Override
	public String getSummnary() {
		return model.getSummnary();
	}

	/**
	 * Returns the the loai tin bai of this article history.
	 *
	 * @return the the loai tin bai of this article history
	 */
	@Override
	public String getTheLoaiTinBai() {
		return model.getTheLoaiTinBai();
	}

	/**
	 * Returns the title of this article history.
	 *
	 * @return the title of this article history
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this article history.
	 *
	 * @return the user ID of this article history
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this article history.
	 *
	 * @return the user uuid of this article history
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this article history.
	 *
	 * @return the uuid of this article history
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
	 * Sets the article history ID of this article history.
	 *
	 * @param articleHistoryId the article history ID of this article history
	 */
	@Override
	public void setArticleHistoryId(long articleHistoryId) {
		model.setArticleHistoryId(articleHistoryId);
	}

	/**
	 * Sets the article ID of this article history.
	 *
	 * @param articleId the article ID of this article history
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the author of this article history.
	 *
	 * @param author the author of this article history
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the content of this article history.
	 *
	 * @param content the content of this article history
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created date of this article history.
	 *
	 * @param createdDate the created date of this article history
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the don vi of this article history.
	 *
	 * @param donVi the don vi of this article history
	 */
	@Override
	public void setDonVi(String donVi) {
		model.setDonVi(donVi);
	}

	/**
	 * Sets the image of this article history.
	 *
	 * @param image the image of this article history
	 */
	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the image description of this article history.
	 *
	 * @param imageDescription the image description of this article history
	 */
	@Override
	public void setImageDescription(String imageDescription) {
		model.setImageDescription(imageDescription);
	}

	/**
	 * Sets the loai anh of this article history.
	 *
	 * @param loaiAnh the loai anh of this article history
	 */
	@Override
	public void setLoaiAnh(String loaiAnh) {
		model.setLoaiAnh(loaiAnh);
	}

	/**
	 * Sets the loai tin bai of this article history.
	 *
	 * @param loaiTinBai the loai tin bai of this article history
	 */
	@Override
	public void setLoaiTinBai(String loaiTinBai) {
		model.setLoaiTinBai(loaiTinBai);
	}

	/**
	 * Sets the primary key of this article history.
	 *
	 * @param primaryKey the primary key of this article history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the so anh bai viet of this article history.
	 *
	 * @param soAnhBaiViet the so anh bai viet of this article history
	 */
	@Override
	public void setSoAnhBaiViet(String soAnhBaiViet) {
		model.setSoAnhBaiViet(soAnhBaiViet);
	}

	/**
	 * Sets the so ky tu bai viet of this article history.
	 *
	 * @param soKyTuBaiViet the so ky tu bai viet of this article history
	 */
	@Override
	public void setSoKyTuBaiViet(String soKyTuBaiViet) {
		model.setSoKyTuBaiViet(soKyTuBaiViet);
	}

	/**
	 * Sets the source of this article history.
	 *
	 * @param source the source of this article history
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the summnary of this article history.
	 *
	 * @param summnary the summnary of this article history
	 */
	@Override
	public void setSummnary(String summnary) {
		model.setSummnary(summnary);
	}

	/**
	 * Sets the the loai tin bai of this article history.
	 *
	 * @param theLoaiTinBai the the loai tin bai of this article history
	 */
	@Override
	public void setTheLoaiTinBai(String theLoaiTinBai) {
		model.setTheLoaiTinBai(theLoaiTinBai);
	}

	/**
	 * Sets the title of this article history.
	 *
	 * @param title the title of this article history
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this article history.
	 *
	 * @param userId the user ID of this article history
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this article history.
	 *
	 * @param userUuid the user uuid of this article history
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this article history.
	 *
	 * @param uuid the uuid of this article history
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ArticleHistoryWrapper wrap(ArticleHistory articleHistory) {
		return new ArticleHistoryWrapper(articleHistory);
	}

}