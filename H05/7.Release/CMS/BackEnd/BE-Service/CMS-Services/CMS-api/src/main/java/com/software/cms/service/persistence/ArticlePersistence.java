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

import com.software.cms.exception.NoSuchArticleException;
import com.software.cms.model.Article;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleUtil
 * @generated
 */
@ProviderType
public interface ArticlePersistence extends BasePersistence<Article> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleUtil} to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching articles
	 */
	public java.util.List<Article> findByUuid(String uuid);

	/**
	 * Returns a range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	public java.util.List<Article> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the articles before and after the current article in the ordered set where uuid = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article[] findByUuid_PrevAndNext(
			long articleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Removes all the articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching articles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleException;

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the article where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article that was removed
	 */
	public Article removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleException;

	/**
	 * Returns the number of articles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching articles
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the article where friendlyURL = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param friendlyURL the friendly url
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByFriendUrl(String friendlyURL)
		throws NoSuchArticleException;

	/**
	 * Returns the article where friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByFriendUrl(String friendlyURL);

	/**
	 * Returns the article where friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByFriendUrl(String friendlyURL, boolean useFinderCache);

	/**
	 * Removes the article where friendlyURL = &#63; from the database.
	 *
	 * @param friendlyURL the friendly url
	 * @return the article that was removed
	 */
	public Article removeByFriendUrl(String friendlyURL)
		throws NoSuchArticleException;

	/**
	 * Returns the number of articles where friendlyURL = &#63;.
	 *
	 * @param friendlyURL the friendly url
	 * @return the number of matching articles
	 */
	public int countByFriendUrl(String friendlyURL);

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByFriendUrlAndStatus(String friendlyURL, long status)
		throws NoSuchArticleException;

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByFriendUrlAndStatus(String friendlyURL, long status);

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByFriendUrlAndStatus(
		String friendlyURL, long status, boolean useFinderCache);

	/**
	 * Removes the article where friendlyURL = &#63; and status = &#63; from the database.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the article that was removed
	 */
	public Article removeByFriendUrlAndStatus(String friendlyURL, long status)
		throws NoSuchArticleException;

	/**
	 * Returns the number of articles where friendlyURL = &#63; and status = &#63;.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the number of matching articles
	 */
	public int countByFriendUrlAndStatus(String friendlyURL, long status);

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status(
		long groupId, String language, long status);

	/**
	 * Returns a range of all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end);

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByGroup_Language_Status_First(
			long groupId, String language, long status,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByGroup_Language_Status_First(
		long groupId, String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByGroup_Language_Status_Last(
			long groupId, String language, long status,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByGroup_Language_Status_Last(
		long groupId, String language, long status,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the articles before and after the current article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article[] findByGroup_Language_Status_PrevAndNext(
			long articleId, long groupId, String language, long status,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 */
	public void removeByGroup_Language_Status(
		long groupId, String language, long status);

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the number of matching articles
	 */
	public int countByGroup_Language_Status(
		long groupId, String language, long status);

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @return the matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId);

	/**
	 * Returns a range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end);

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByGroup_Language_Status_Event_First(
			long groupId, String language, long status, long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByGroup_Language_Status_Event_First(
		long groupId, String language, long status, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByGroup_Language_Status_Event_Last(
			long groupId, String language, long status, long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByGroup_Language_Status_Event_Last(
		long groupId, String language, long status, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the articles before and after the current article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article[] findByGroup_Language_Status_Event_PrevAndNext(
			long articleId, long groupId, String language, long status,
			long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 */
	public void removeByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId);

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @return the number of matching articles
	 */
	public int countByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId);

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser);

	/**
	 * Returns a range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end);

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	public java.util.List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByGroup_Language_Status_UserCreate_First(
			long groupId, String language, long status, long createdByUser,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByGroup_Language_Status_UserCreate_First(
		long groupId, String language, long status, long createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public Article findByGroup_Language_Status_UserCreate_Last(
			long groupId, String language, long status, long createdByUser,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public Article fetchByGroup_Language_Status_UserCreate_Last(
		long groupId, String language, long status, long createdByUser,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns the articles before and after the current article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article[] findByGroup_Language_Status_UserCreate_PrevAndNext(
			long articleId, long groupId, String language, long status,
			long createdByUser,
			com.liferay.portal.kernel.util.OrderByComparator<Article>
				orderByComparator)
		throws NoSuchArticleException;

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 */
	public void removeByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser);

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the number of matching articles
	 */
	public int countByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser);

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	public void cacheResult(Article article);

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	public void cacheResult(java.util.List<Article> articles);

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	public Article create(long articleId);

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article remove(long articleId) throws NoSuchArticleException;

	public Article updateImpl(Article article);

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public Article findByPrimaryKey(long articleId)
		throws NoSuchArticleException;

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	public Article fetchByPrimaryKey(long articleId);

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	public java.util.List<Article> findAll();

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 */
	public java.util.List<Article> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articles
	 */
	public java.util.List<Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of articles
	 */
	public java.util.List<Article> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Article>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	public int countAll();

}