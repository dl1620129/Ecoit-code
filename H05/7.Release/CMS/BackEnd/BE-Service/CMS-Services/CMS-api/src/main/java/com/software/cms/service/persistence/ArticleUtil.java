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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.software.cms.model.Article;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the article service. This utility wraps <code>com.software.cms.service.persistence.impl.ArticlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticlePersistence
 * @generated
 */
public class ArticleUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Article article) {
		getPersistence().clearCache(article);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Article> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Article> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Article update(Article article) {
		return getPersistence().update(article);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Article update(
		Article article, ServiceContext serviceContext) {

		return getPersistence().update(article, serviceContext);
	}

	/**
	 * Returns all the articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching articles
	 */
	public static List<Article> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Article> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Article> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Article> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByUuid_First(
			String uuid, OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByUuid_First(
		String uuid, OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByUuid_Last(
			String uuid, OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByUuid_Last(
		String uuid, OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where uuid = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public static Article[] findByUuid_PrevAndNext(
			long articleId, String uuid,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByUuid_PrevAndNext(
			articleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching articles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the article where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article that was removed
	 */
	public static Article removeByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of articles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching articles
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the article where friendlyURL = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param friendlyURL the friendly url
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByFriendUrl(String friendlyURL)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByFriendUrl(friendlyURL);
	}

	/**
	 * Returns the article where friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByFriendUrl(String friendlyURL) {
		return getPersistence().fetchByFriendUrl(friendlyURL);
	}

	/**
	 * Returns the article where friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByFriendUrl(
		String friendlyURL, boolean useFinderCache) {

		return getPersistence().fetchByFriendUrl(friendlyURL, useFinderCache);
	}

	/**
	 * Removes the article where friendlyURL = &#63; from the database.
	 *
	 * @param friendlyURL the friendly url
	 * @return the article that was removed
	 */
	public static Article removeByFriendUrl(String friendlyURL)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().removeByFriendUrl(friendlyURL);
	}

	/**
	 * Returns the number of articles where friendlyURL = &#63;.
	 *
	 * @param friendlyURL the friendly url
	 * @return the number of matching articles
	 */
	public static int countByFriendUrl(String friendlyURL) {
		return getPersistence().countByFriendUrl(friendlyURL);
	}

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	public static Article findByFriendUrlAndStatus(
			String friendlyURL, long status)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByFriendUrlAndStatus(friendlyURL, status);
	}

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByFriendUrlAndStatus(
		String friendlyURL, long status) {

		return getPersistence().fetchByFriendUrlAndStatus(friendlyURL, status);
	}

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByFriendUrlAndStatus(
		String friendlyURL, long status, boolean useFinderCache) {

		return getPersistence().fetchByFriendUrlAndStatus(
			friendlyURL, status, useFinderCache);
	}

	/**
	 * Removes the article where friendlyURL = &#63; and status = &#63; from the database.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the article that was removed
	 */
	public static Article removeByFriendUrlAndStatus(
			String friendlyURL, long status)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().removeByFriendUrlAndStatus(friendlyURL, status);
	}

	/**
	 * Returns the number of articles where friendlyURL = &#63; and status = &#63;.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the number of matching articles
	 */
	public static int countByFriendUrlAndStatus(
		String friendlyURL, long status) {

		return getPersistence().countByFriendUrlAndStatus(friendlyURL, status);
	}

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the matching articles
	 */
	public static List<Article> findByGroup_Language_Status(
		long groupId, String language, long status) {

		return getPersistence().findByGroup_Language_Status(
			groupId, language, status);
	}

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
	public static List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end) {

		return getPersistence().findByGroup_Language_Status(
			groupId, language, status, start, end);
	}

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
	public static List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().findByGroup_Language_Status(
			groupId, language, status, start, end, orderByComparator);
	}

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
	public static List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup_Language_Status(
			groupId, language, status, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static Article findByGroup_Language_Status_First(
			long groupId, String language, long status,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_First(
			groupId, language, status, orderByComparator);
	}

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByGroup_Language_Status_First(
		long groupId, String language, long status,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Status_First(
			groupId, language, status, orderByComparator);
	}

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
	public static Article findByGroup_Language_Status_Last(
			long groupId, String language, long status,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_Last(
			groupId, language, status, orderByComparator);
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	public static Article fetchByGroup_Language_Status_Last(
		long groupId, String language, long status,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Status_Last(
			groupId, language, status, orderByComparator);
	}

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
	public static Article[] findByGroup_Language_Status_PrevAndNext(
			long articleId, long groupId, String language, long status,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_PrevAndNext(
			articleId, groupId, language, status, orderByComparator);
	}

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 */
	public static void removeByGroup_Language_Status(
		long groupId, String language, long status) {

		getPersistence().removeByGroup_Language_Status(
			groupId, language, status);
	}

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the number of matching articles
	 */
	public static int countByGroup_Language_Status(
		long groupId, String language, long status) {

		return getPersistence().countByGroup_Language_Status(
			groupId, language, status);
	}

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @return the matching articles
	 */
	public static List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId) {

		return getPersistence().findByGroup_Language_Status_Event(
			groupId, language, status, eventId);
	}

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
	public static List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end) {

		return getPersistence().findByGroup_Language_Status_Event(
			groupId, language, status, eventId, start, end);
	}

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
	public static List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end, OrderByComparator<Article> orderByComparator) {

		return getPersistence().findByGroup_Language_Status_Event(
			groupId, language, status, eventId, start, end, orderByComparator);
	}

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
	public static List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end, OrderByComparator<Article> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup_Language_Status_Event(
			groupId, language, status, eventId, start, end, orderByComparator,
			useFinderCache);
	}

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
	public static Article findByGroup_Language_Status_Event_First(
			long groupId, String language, long status, long eventId,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_Event_First(
			groupId, language, status, eventId, orderByComparator);
	}

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
	public static Article fetchByGroup_Language_Status_Event_First(
		long groupId, String language, long status, long eventId,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Status_Event_First(
			groupId, language, status, eventId, orderByComparator);
	}

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
	public static Article findByGroup_Language_Status_Event_Last(
			long groupId, String language, long status, long eventId,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_Event_Last(
			groupId, language, status, eventId, orderByComparator);
	}

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
	public static Article fetchByGroup_Language_Status_Event_Last(
		long groupId, String language, long status, long eventId,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Status_Event_Last(
			groupId, language, status, eventId, orderByComparator);
	}

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
	public static Article[] findByGroup_Language_Status_Event_PrevAndNext(
			long articleId, long groupId, String language, long status,
			long eventId, OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_Event_PrevAndNext(
			articleId, groupId, language, status, eventId, orderByComparator);
	}

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 */
	public static void removeByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId) {

		getPersistence().removeByGroup_Language_Status_Event(
			groupId, language, status, eventId);
	}

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @return the number of matching articles
	 */
	public static int countByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId) {

		return getPersistence().countByGroup_Language_Status_Event(
			groupId, language, status, eventId);
	}

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the matching articles
	 */
	public static List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser) {

		return getPersistence().findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser);
	}

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
	public static List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end) {

		return getPersistence().findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, start, end);
	}

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
	public static List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return getPersistence().findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, start, end,
			orderByComparator);
	}

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
	public static List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end, OrderByComparator<Article> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static Article findByGroup_Language_Status_UserCreate_First(
			long groupId, String language, long status, long createdByUser,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_UserCreate_First(
			groupId, language, status, createdByUser, orderByComparator);
	}

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
	public static Article fetchByGroup_Language_Status_UserCreate_First(
		long groupId, String language, long status, long createdByUser,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Status_UserCreate_First(
			groupId, language, status, createdByUser, orderByComparator);
	}

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
	public static Article findByGroup_Language_Status_UserCreate_Last(
			long groupId, String language, long status, long createdByUser,
			OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByGroup_Language_Status_UserCreate_Last(
			groupId, language, status, createdByUser, orderByComparator);
	}

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
	public static Article fetchByGroup_Language_Status_UserCreate_Last(
		long groupId, String language, long status, long createdByUser,
		OrderByComparator<Article> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Status_UserCreate_Last(
			groupId, language, status, createdByUser, orderByComparator);
	}

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
	public static Article[] findByGroup_Language_Status_UserCreate_PrevAndNext(
			long articleId, long groupId, String language, long status,
			long createdByUser, OrderByComparator<Article> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().
			findByGroup_Language_Status_UserCreate_PrevAndNext(
				articleId, groupId, language, status, createdByUser,
				orderByComparator);
	}

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 */
	public static void removeByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser) {

		getPersistence().removeByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser);
	}

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the number of matching articles
	 */
	public static int countByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser) {

		return getPersistence().countByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	public static void cacheResult(Article article) {
		getPersistence().cacheResult(article);
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	public static void cacheResult(List<Article> articles) {
		getPersistence().cacheResult(articles);
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	public static Article create(long articleId) {
		return getPersistence().create(articleId);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public static Article remove(long articleId)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().remove(articleId);
	}

	public static Article updateImpl(Article article) {
		return getPersistence().updateImpl(article);
	}

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	public static Article findByPrimaryKey(long articleId)
		throws com.software.cms.exception.NoSuchArticleException {

		return getPersistence().findByPrimaryKey(articleId);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	public static Article fetchByPrimaryKey(long articleId) {
		return getPersistence().fetchByPrimaryKey(articleId);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	public static List<Article> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Article> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the articles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticlePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArticlePersistence, ArticlePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArticlePersistence.class);

		ServiceTracker<ArticlePersistence, ArticlePersistence> serviceTracker =
			new ServiceTracker<ArticlePersistence, ArticlePersistence>(
				bundle.getBundleContext(), ArticlePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}