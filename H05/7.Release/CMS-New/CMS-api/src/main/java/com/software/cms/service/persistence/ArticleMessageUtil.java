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

import com.software.cms.model.ArticleMessage;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the article message service. This utility wraps <code>com.software.cms.service.persistence.impl.ArticleMessagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleMessagePersistence
 * @generated
 */
public class ArticleMessageUtil {

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
	public static void clearCache(ArticleMessage articleMessage) {
		getPersistence().clearCache(articleMessage);
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
	public static Map<Serializable, ArticleMessage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArticleMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArticleMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArticleMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ArticleMessage update(ArticleMessage articleMessage) {
		return getPersistence().update(articleMessage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ArticleMessage update(
		ArticleMessage articleMessage, ServiceContext serviceContext) {

		return getPersistence().update(articleMessage, serviceContext);
	}

	/**
	 * Returns all the article messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article messages
	 */
	public static List<ArticleMessage> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ArticleMessage> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ArticleMessage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ArticleMessage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public static ArticleMessage findByUuid_First(
			String uuid, OrderByComparator<ArticleMessage> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public static ArticleMessage fetchByUuid_First(
		String uuid, OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public static ArticleMessage findByUuid_Last(
			String uuid, OrderByComparator<ArticleMessage> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public static ArticleMessage fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the article messages before and after the current article message in the ordered set where uuid = &#63;.
	 *
	 * @param messageId the primary key of the current article message
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public static ArticleMessage[] findByUuid_PrevAndNext(
			long messageId, String uuid,
			OrderByComparator<ArticleMessage> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByUuid_PrevAndNext(
			messageId, uuid, orderByComparator);
	}

	/**
	 * Removes all the article messages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of article messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article messages
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the article messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching article messages
	 */
	public static List<ArticleMessage> findByArticle(long articleId) {
		return getPersistence().findByArticle(articleId);
	}

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
	public static List<ArticleMessage> findByArticle(
		long articleId, int start, int end) {

		return getPersistence().findByArticle(articleId, start, end);
	}

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
	public static List<ArticleMessage> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator);
	}

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
	public static List<ArticleMessage> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public static ArticleMessage findByArticle_First(
			long articleId, OrderByComparator<ArticleMessage> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the first article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public static ArticleMessage fetchByArticle_First(
		long articleId, OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().fetchByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	public static ArticleMessage findByArticle_Last(
			long articleId, OrderByComparator<ArticleMessage> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message, or <code>null</code> if a matching article message could not be found
	 */
	public static ArticleMessage fetchByArticle_Last(
		long articleId, OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().fetchByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the article messages before and after the current article message in the ordered set where articleId = &#63;.
	 *
	 * @param messageId the primary key of the current article message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public static ArticleMessage[] findByArticle_PrevAndNext(
			long messageId, long articleId,
			OrderByComparator<ArticleMessage> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByArticle_PrevAndNext(
			messageId, articleId, orderByComparator);
	}

	/**
	 * Removes all the article messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public static void removeByArticle(long articleId) {
		getPersistence().removeByArticle(articleId);
	}

	/**
	 * Returns the number of article messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching article messages
	 */
	public static int countByArticle(long articleId) {
		return getPersistence().countByArticle(articleId);
	}

	/**
	 * Caches the article message in the entity cache if it is enabled.
	 *
	 * @param articleMessage the article message
	 */
	public static void cacheResult(ArticleMessage articleMessage) {
		getPersistence().cacheResult(articleMessage);
	}

	/**
	 * Caches the article messages in the entity cache if it is enabled.
	 *
	 * @param articleMessages the article messages
	 */
	public static void cacheResult(List<ArticleMessage> articleMessages) {
		getPersistence().cacheResult(articleMessages);
	}

	/**
	 * Creates a new article message with the primary key. Does not add the article message to the database.
	 *
	 * @param messageId the primary key for the new article message
	 * @return the new article message
	 */
	public static ArticleMessage create(long messageId) {
		return getPersistence().create(messageId);
	}

	/**
	 * Removes the article message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message that was removed
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public static ArticleMessage remove(long messageId)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().remove(messageId);
	}

	public static ArticleMessage updateImpl(ArticleMessage articleMessage) {
		return getPersistence().updateImpl(articleMessage);
	}

	/**
	 * Returns the article message with the primary key or throws a <code>NoSuchArticleMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	public static ArticleMessage findByPrimaryKey(long messageId)
		throws com.software.cms.exception.NoSuchArticleMessageException {

		return getPersistence().findByPrimaryKey(messageId);
	}

	/**
	 * Returns the article message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message, or <code>null</code> if a article message with the primary key could not be found
	 */
	public static ArticleMessage fetchByPrimaryKey(long messageId) {
		return getPersistence().fetchByPrimaryKey(messageId);
	}

	/**
	 * Returns all the article messages.
	 *
	 * @return the article messages
	 */
	public static List<ArticleMessage> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ArticleMessage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ArticleMessage> findAll(
		int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ArticleMessage> findAll(
		int start, int end, OrderByComparator<ArticleMessage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the article messages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of article messages.
	 *
	 * @return the number of article messages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticleMessagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ArticleMessagePersistence, ArticleMessagePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ArticleMessagePersistence.class);

		ServiceTracker<ArticleMessagePersistence, ArticleMessagePersistence>
			serviceTracker =
				new ServiceTracker
					<ArticleMessagePersistence, ArticleMessagePersistence>(
						bundle.getBundleContext(),
						ArticleMessagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}