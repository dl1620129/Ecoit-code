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

import com.software.cms.model.ArticleMailSend;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ArticleMailSend in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class ArticleMailSendCacheModel
	implements CacheModel<ArticleMailSend>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleMailSendCacheModel)) {
			return false;
		}

		ArticleMailSendCacheModel articleMailSendCacheModel =
			(ArticleMailSendCacheModel)obj;

		if (mailSendId == articleMailSendCacheModel.mailSendId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mailSendId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", mailSendId=");
		sb.append(mailSendId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", nguoiGui=");
		sb.append(nguoiGui);
		sb.append(", mailNguoiGui=");
		sb.append(mailNguoiGui);
		sb.append(", nguoiNhan=");
		sb.append(nguoiNhan);
		sb.append(", mailNguoiNhan=");
		sb.append(mailNguoiNhan);
		sb.append(", tieuDe=");
		sb.append(tieuDe);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArticleMailSend toEntityModel() {
		ArticleMailSendImpl articleMailSendImpl = new ArticleMailSendImpl();

		if (uuid == null) {
			articleMailSendImpl.setUuid("");
		}
		else {
			articleMailSendImpl.setUuid(uuid);
		}

		articleMailSendImpl.setMailSendId(mailSendId);

		if (createDate == Long.MIN_VALUE) {
			articleMailSendImpl.setCreateDate(null);
		}
		else {
			articleMailSendImpl.setCreateDate(new Date(createDate));
		}

		articleMailSendImpl.setGroupId(groupId);

		if (nguoiGui == null) {
			articleMailSendImpl.setNguoiGui("");
		}
		else {
			articleMailSendImpl.setNguoiGui(nguoiGui);
		}

		if (mailNguoiGui == null) {
			articleMailSendImpl.setMailNguoiGui("");
		}
		else {
			articleMailSendImpl.setMailNguoiGui(mailNguoiGui);
		}

		if (nguoiNhan == null) {
			articleMailSendImpl.setNguoiNhan("");
		}
		else {
			articleMailSendImpl.setNguoiNhan(nguoiNhan);
		}

		if (mailNguoiNhan == null) {
			articleMailSendImpl.setMailNguoiNhan("");
		}
		else {
			articleMailSendImpl.setMailNguoiNhan(mailNguoiNhan);
		}

		if (tieuDe == null) {
			articleMailSendImpl.setTieuDe("");
		}
		else {
			articleMailSendImpl.setTieuDe(tieuDe);
		}

		if (noiDung == null) {
			articleMailSendImpl.setNoiDung("");
		}
		else {
			articleMailSendImpl.setNoiDung(noiDung);
		}

		articleMailSendImpl.setArticleId(articleId);
		articleMailSendImpl.setCategoryId(categoryId);

		articleMailSendImpl.resetOriginalValues();

		return articleMailSendImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		mailSendId = objectInput.readLong();
		createDate = objectInput.readLong();

		groupId = objectInput.readLong();
		nguoiGui = objectInput.readUTF();
		mailNguoiGui = objectInput.readUTF();
		nguoiNhan = objectInput.readUTF();
		mailNguoiNhan = objectInput.readUTF();
		tieuDe = objectInput.readUTF();
		noiDung = objectInput.readUTF();

		articleId = objectInput.readLong();

		categoryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(mailSendId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(groupId);

		if (nguoiGui == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nguoiGui);
		}

		if (mailNguoiGui == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mailNguoiGui);
		}

		if (nguoiNhan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nguoiNhan);
		}

		if (mailNguoiNhan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mailNguoiNhan);
		}

		if (tieuDe == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tieuDe);
		}

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		objectOutput.writeLong(articleId);

		objectOutput.writeLong(categoryId);
	}

	public String uuid;
	public long mailSendId;
	public long createDate;
	public long groupId;
	public String nguoiGui;
	public String mailNguoiGui;
	public String nguoiNhan;
	public String mailNguoiNhan;
	public String tieuDe;
	public String noiDung;
	public long articleId;
	public long categoryId;

}