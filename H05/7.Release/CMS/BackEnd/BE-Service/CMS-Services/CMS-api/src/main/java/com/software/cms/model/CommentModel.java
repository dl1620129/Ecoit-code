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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Comment service. Represents a row in the &quot;soft_cms_Comment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.software.cms.model.impl.CommentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.software.cms.model.impl.CommentImpl</code>.
 * </p>
 *
 * @author DungNV
 * @see Comment
 * @generated
 */
@ProviderType
public interface CommentModel extends BaseModel<Comment> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a comment model instance should use the {@link Comment} interface instead.
	 */

	/**
	 * Returns the primary key of this comment.
	 *
	 * @return the primary key of this comment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this comment.
	 *
	 * @param primaryKey the primary key of this comment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this comment.
	 *
	 * @return the uuid of this comment
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this comment.
	 *
	 * @param uuid the uuid of this comment
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the comment ID of this comment.
	 *
	 * @return the comment ID of this comment
	 */
	public long getCommentId();

	/**
	 * Sets the comment ID of this comment.
	 *
	 * @param commentId the comment ID of this comment
	 */
	public void setCommentId(long commentId);

	/**
	 * Returns the group ID of this comment.
	 *
	 * @return the group ID of this comment
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this comment.
	 *
	 * @param groupId the group ID of this comment
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the created date of this comment.
	 *
	 * @return the created date of this comment
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this comment.
	 *
	 * @param createdDate the created date of this comment
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the username of this comment.
	 *
	 * @return the username of this comment
	 */
	@AutoEscape
	public String getUsername();

	/**
	 * Sets the username of this comment.
	 *
	 * @param username the username of this comment
	 */
	public void setUsername(String username);

	/**
	 * Returns the email of this comment.
	 *
	 * @return the email of this comment
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this comment.
	 *
	 * @param email the email of this comment
	 */
	public void setEmail(String email);

	/**
	 * Returns the content of this comment.
	 *
	 * @return the content of this comment
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this comment.
	 *
	 * @param content the content of this comment
	 */
	public void setContent(String content);

	/**
	 * Returns the likes of this comment.
	 *
	 * @return the likes of this comment
	 */
	public long getLikes();

	/**
	 * Sets the likes of this comment.
	 *
	 * @param likes the likes of this comment
	 */
	public void setLikes(long likes);

	/**
	 * Returns the approved of this comment.
	 *
	 * @return the approved of this comment
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this comment is approved.
	 *
	 * @return <code>true</code> if this comment is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Sets whether this comment is approved.
	 *
	 * @param approved the approved of this comment
	 */
	public void setApproved(boolean approved);

	/**
	 * Returns the article ID of this comment.
	 *
	 * @return the article ID of this comment
	 */
	public long getArticleId();

	/**
	 * Sets the article ID of this comment.
	 *
	 * @param articleId the article ID of this comment
	 */
	public void setArticleId(long articleId);

	/**
	 * Returns the parent ID of this comment.
	 *
	 * @return the parent ID of this comment
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this comment.
	 *
	 * @param parentId the parent ID of this comment
	 */
	public void setParentId(long parentId);

}