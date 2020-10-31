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

package com.ecoit.elegaldocument.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegalAttachedMessage}.
 * </p>
 *
 * @author Liverpool
 * @see LegalAttachedMessage
 * @generated
 */
public class LegalAttachedMessageWrapper
	extends BaseModelWrapper<LegalAttachedMessage>
	implements LegalAttachedMessage, ModelWrapper<LegalAttachedMessage> {

	public LegalAttachedMessageWrapper(
		LegalAttachedMessage legalAttachedMessage) {

		super(legalAttachedMessage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdByUser", getCreatedByUser());
		attributes.put("articleId", getArticleId());
		attributes.put("content", getContent());
		attributes.put("readMessage", isReadMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String messageId = (String)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String createdByUser = (String)attributes.get("createdByUser");

		if (createdByUser != null) {
			setCreatedByUser(createdByUser);
		}

		String articleId = (String)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Boolean readMessage = (Boolean)attributes.get("readMessage");

		if (readMessage != null) {
			setReadMessage(readMessage);
		}
	}

	/**
	 * Returns the article ID of this legal attached message.
	 *
	 * @return the article ID of this legal attached message
	 */
	@Override
	public String getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the company ID of this legal attached message.
	 *
	 * @return the company ID of this legal attached message
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this legal attached message.
	 *
	 * @return the content of this legal attached message
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by user of this legal attached message.
	 *
	 * @return the created by user of this legal attached message
	 */
	@Override
	public String getCreatedByUser() {
		return model.getCreatedByUser();
	}

	/**
	 * Returns the created date of this legal attached message.
	 *
	 * @return the created date of this legal attached message
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the group ID of this legal attached message.
	 *
	 * @return the group ID of this legal attached message
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the message ID of this legal attached message.
	 *
	 * @return the message ID of this legal attached message
	 */
	@Override
	public String getMessageId() {
		return model.getMessageId();
	}

	/**
	 * Returns the primary key of this legal attached message.
	 *
	 * @return the primary key of this legal attached message
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the read message of this legal attached message.
	 *
	 * @return the read message of this legal attached message
	 */
	@Override
	public boolean getReadMessage() {
		return model.getReadMessage();
	}

	/**
	 * Returns <code>true</code> if this legal attached message is read message.
	 *
	 * @return <code>true</code> if this legal attached message is read message; <code>false</code> otherwise
	 */
	@Override
	public boolean isReadMessage() {
		return model.isReadMessage();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the article ID of this legal attached message.
	 *
	 * @param articleId the article ID of this legal attached message
	 */
	@Override
	public void setArticleId(String articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the company ID of this legal attached message.
	 *
	 * @param companyId the company ID of this legal attached message
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this legal attached message.
	 *
	 * @param content the content of this legal attached message
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by user of this legal attached message.
	 *
	 * @param createdByUser the created by user of this legal attached message
	 */
	@Override
	public void setCreatedByUser(String createdByUser) {
		model.setCreatedByUser(createdByUser);
	}

	/**
	 * Sets the created date of this legal attached message.
	 *
	 * @param createdDate the created date of this legal attached message
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the group ID of this legal attached message.
	 *
	 * @param groupId the group ID of this legal attached message
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the message ID of this legal attached message.
	 *
	 * @param messageId the message ID of this legal attached message
	 */
	@Override
	public void setMessageId(String messageId) {
		model.setMessageId(messageId);
	}

	/**
	 * Sets the primary key of this legal attached message.
	 *
	 * @param primaryKey the primary key of this legal attached message
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this legal attached message is read message.
	 *
	 * @param readMessage the read message of this legal attached message
	 */
	@Override
	public void setReadMessage(boolean readMessage) {
		model.setReadMessage(readMessage);
	}

	@Override
	protected LegalAttachedMessageWrapper wrap(
		LegalAttachedMessage legalAttachedMessage) {

		return new LegalAttachedMessageWrapper(legalAttachedMessage);
	}

}