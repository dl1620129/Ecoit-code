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

package com.software.cms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.software.cms.exception.NoSuchArticleMessageException;
import com.software.cms.model.ArticleMessage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the article message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleMessageUtil
 * @generated
 */
@ProviderType
public interface ArticleMessagePersistence
	extends BasePersistence<ArticleMessage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleMessageUtil} to access the article message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the article messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article messages
	 */
	public java.util.List<ArticleMessage> findByUuid(String uuid);

	/**
	 * Returns a range of all the article messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of matching article messages
	 */
	public java.util.List<ArticleMessage> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the article messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article messages
	 */
	public java.util.List<ArticleMessage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article messages
	 */
	public java.util.List<ArticleMessage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public ArticleMessage findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
				orderByComparator)
		throws NoSuchArticleMessageException;

	/**
	 * Returns the first article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public ArticleMessage fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns the last article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public ArticleMessage findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
				orderByComparator)
		throws NoSuchArticleMessageException;

	/**
	 * Returns the last article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public ArticleMessage fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns the article messages before and after the current article message in the ordered set where uuid = &#63;.
	 *
	 * @param messageId the primary key of the current article message
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public ArticleMessage[] findByUuid_PrevAndNext(
			long messageId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
				orderByComparator)
		throws NoSuchArticleMessageException;

	/**
	 * Removes all the article messages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of article messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article messages
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the article messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching article messages
	 */
	public java.util.List<ArticleMessage> findByArticle(long articleId);

	/**
	 * Returns a range of all the article messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of matching article messages
	 */
	public java.util.List<ArticleMessage> findByArticle(
		long articleId, int start, int end);

	/**
	 * Returns an ordered range of all the article messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article messages
	 */
	public java.util.List<ArticleMessage> findByArticle(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article messages
	 */
	public java.util.List<ArticleMessage> findByArticle(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public ArticleMessage findByArticle_First(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
				orderByComparator)
		throws NoSuchArticleMessageException;

	/**
	 * Returns the first article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public ArticleMessage fetchByArticle_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns the last article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public ArticleMessage findByArticle_Last(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
				orderByComparator)
		throws NoSuchArticleMessageException;

	/**
	 * Returns the last article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public ArticleMessage fetchByArticle_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns the article messages before and after the current article message in the ordered set where articleId = &#63;.
	 *
	 * @param messageId the primary key of the current article message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public ArticleMessage[] findByArticle_PrevAndNext(
			long messageId, long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
				orderByComparator)
		throws NoSuchArticleMessageException;

	/**
	 * Removes all the article messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public void removeByArticle(long articleId);

	/**
	 * Returns the number of article messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching article messages
	 */
	public int countByArticle(long articleId);

	/**
	 * Caches the article message in the entity cache if it is enabled.
	 *
	 * @param articleMessage the article message
	 */
	public void cacheResult(ArticleMessage articleMessage);

	/**
	 * Caches the article messages in the entity cache if it is enabled.
	 *
	 * @param articleMessages the article messages
	 */
	public void cacheResult(java.util.List<ArticleMessage> articleMessages);

	/**
	 * Creates a new article message with the primary key. Does not add the article message to the database.
	 *
	 * @param messageId the primary key for the new article message
	 * @return the new article message
	 */
	public ArticleMessage create(long messageId);

	/**
	 * Removes the article message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message that was removed
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public ArticleMessage remove(long messageId)
		throws NoSuchArticleMessageException;

	public ArticleMessage updateImpl(ArticleMessage articleMessage);

	/**
	 * Returns the article message with the primary key or throws a <code>NoSuchArticleMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public ArticleMessage findByPrimaryKey(long messageId)
		throws NoSuchArticleMessageException;

	/**
	 * Returns the article message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message, or <code>null</code> if a article message with the primary key could not be found
	 */
	public ArticleMessage fetchByPrimaryKey(long messageId);

	/**
	 * Returns all the article messages.
	 *
	 * @return the article messages
	 */
	public java.util.List<ArticleMessage> findAll();

	/**
	 * Returns a range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of article messages
	 */
	public java.util.List<ArticleMessage> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article messages
	 */
	public java.util.List<ArticleMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article messages
	 */
	public java.util.List<ArticleMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleMessage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the article messages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of article messages.
	 *
	 * @return the number of article messages
	 */
	public int countAll();

}