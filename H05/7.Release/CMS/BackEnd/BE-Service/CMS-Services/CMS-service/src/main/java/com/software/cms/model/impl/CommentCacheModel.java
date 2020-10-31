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

import com.software.cms.model.Comment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Comment in entity cache.
 *
 * @author DungNV
 * @generated
 */
public class CommentCacheModel implements CacheModel<Comment>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommentCacheModel)) {
			return false;
		}

		CommentCacheModel commentCacheModel = (CommentCacheModel)obj;

		if (commentId == commentCacheModel.commentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, commentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", commentId=");
		sb.append(commentId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", username=");
		sb.append(username);
		sb.append(", email=");
		sb.append(email);
		sb.append(", content=");
		sb.append(content);
		sb.append(", likes=");
		sb.append(likes);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Comment toEntityModel() {
		CommentImpl commentImpl = new CommentImpl();

		if (uuid == null) {
			commentImpl.setUuid("");
		}
		else {
			commentImpl.setUuid(uuid);
		}

		commentImpl.setCommentId(commentId);
		commentImpl.setGroupId(groupId);

		if (createdDate == Long.MIN_VALUE) {
			commentImpl.setCreatedDate(null);
		}
		else {
			commentImpl.setCreatedDate(new Date(createdDate));
		}

		if (username == null) {
			commentImpl.setUsername("");
		}
		else {
			commentImpl.setUsername(username);
		}

		if (email == null) {
			commentImpl.setEmail("");
		}
		else {
			commentImpl.setEmail(email);
		}

		if (content == null) {
			commentImpl.setContent("");
		}
		else {
			commentImpl.setContent(content);
		}

		commentImpl.setLikes(likes);
		commentImpl.setApproved(approved);
		commentImpl.setArticleId(articleId);
		commentImpl.setParentId(parentId);

		commentImpl.resetOriginalValues();

		return commentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		commentId = objectInput.readLong();

		groupId = objectInput.readLong();
		createdDate = objectInput.readLong();
		username = objectInput.readUTF();
		email = objectInput.readUTF();
		content = objectInput.readUTF();

		likes = objectInput.readLong();

		approved = objectInput.readBoolean();

		articleId = objectInput.readLong();

		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(commentId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createdDate);

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(likes);

		objectOutput.writeBoolean(approved);

		objectOutput.writeLong(articleId);

		objectOutput.writeLong(parentId);
	}

	public String uuid;
	public long commentId;
	public long groupId;
	public long createdDate;
	public String username;
	public String email;
	public String content;
	public long likes;
	public boolean approved;
	public long articleId;
	public long parentId;

}