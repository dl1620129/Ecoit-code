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
 * This class is a wrapper for {@link Comment}.
 * </p>
 *
 * @author DungNV
 * @see Comment
 * @generated
 */
public class CommentWrapper
	extends BaseModelWrapper<Comment>
	implements Comment, ModelWrapper<Comment> {

	public CommentWrapper(Comment comment) {
		super(comment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commentId", getCommentId());
		attributes.put("groupId", getGroupId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("username", getUsername());
		attributes.put("email", getEmail());
		attributes.put("content", getContent());
		attributes.put("likes", getLikes());
		attributes.put("approved", isApproved());
		attributes.put("articleId", getArticleId());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long likes = (Long)attributes.get("likes");

		if (likes != null) {
			setLikes(likes);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	/**
	 * Returns the approved of this comment.
	 *
	 * @return the approved of this comment
	 */
	@Override
	public boolean getApproved() {
		return model.getApproved();
	}

	/**
	 * Returns the article ID of this comment.
	 *
	 * @return the article ID of this comment
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the comment ID of this comment.
	 *
	 * @return the comment ID of this comment
	 */
	@Override
	public long getCommentId() {
		return model.getCommentId();
	}

	/**
	 * Returns the content of this comment.
	 *
	 * @return the content of this comment
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created date of this comment.
	 *
	 * @return the created date of this comment
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the email of this comment.
	 *
	 * @return the email of this comment
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this comment.
	 *
	 * @return the group ID of this comment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the likes of this comment.
	 *
	 * @return the likes of this comment
	 */
	@Override
	public long getLikes() {
		return model.getLikes();
	}

	/**
	 * Returns the parent ID of this comment.
	 *
	 * @return the parent ID of this comment
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this comment.
	 *
	 * @return the primary key of this comment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the username of this comment.
	 *
	 * @return the username of this comment
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	/**
	 * Returns the uuid of this comment.
	 *
	 * @return the uuid of this comment
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this comment is approved.
	 *
	 * @return <code>true</code> if this comment is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this comment is approved.
	 *
	 * @param approved the approved of this comment
	 */
	@Override
	public void setApproved(boolean approved) {
		model.setApproved(approved);
	}

	/**
	 * Sets the article ID of this comment.
	 *
	 * @param articleId the article ID of this comment
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the comment ID of this comment.
	 *
	 * @param commentId the comment ID of this comment
	 */
	@Override
	public void setCommentId(long commentId) {
		model.setCommentId(commentId);
	}

	/**
	 * Sets the content of this comment.
	 *
	 * @param content the content of this comment
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created date of this comment.
	 *
	 * @param createdDate the created date of this comment
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the email of this comment.
	 *
	 * @param email the email of this comment
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this comment.
	 *
	 * @param groupId the group ID of this comment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the likes of this comment.
	 *
	 * @param likes the likes of this comment
	 */
	@Override
	public void setLikes(long likes) {
		model.setLikes(likes);
	}

	/**
	 * Sets the parent ID of this comment.
	 *
	 * @param parentId the parent ID of this comment
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this comment.
	 *
	 * @param primaryKey the primary key of this comment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the username of this comment.
	 *
	 * @param username the username of this comment
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	/**
	 * Sets the uuid of this comment.
	 *
	 * @param uuid the uuid of this comment
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CommentWrapper wrap(Comment comment) {
		return new CommentWrapper(comment);
	}

}