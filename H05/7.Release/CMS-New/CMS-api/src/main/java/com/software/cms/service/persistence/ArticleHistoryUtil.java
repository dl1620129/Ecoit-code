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

import com.software.cms.model.ArticleHistory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the article history service. This utility wraps <code>com.software.cms.service.persistence.impl.ArticleHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleHistoryPersistence
 * @generated
 */
public class ArticleHistoryUtil {

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
	public static void clearCache(ArticleHistory articleHistory) {
		getPersistence().clearCache(articleHistory);
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
	public static Map<Serializable, ArticleHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArticleHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArticleHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArticleHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ArticleHistory update(ArticleHistory articleHistory) {
		return getPersistence().update(articleHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ArticleHistory update(
		ArticleHistory articleHistory, ServiceContext serviceContext) {

		return getPersistence().update(articleHistory, serviceContext);
	}

	/**
	 * Returns all the article histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article histories
	 */
	public static List<ArticleHistory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the article histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of matching article histories
	 */
	public static List<ArticleHistory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the article histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article histories
	 */
	public static List<ArticleHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article histories
	 */
	public static List<ArticleHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public static ArticleHistory findByUuid_First(
			String uuid, OrderByComparator<ArticleHistory> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public static ArticleHistory fetchByUuid_First(
		String uuid, OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public static ArticleHistory findByUuid_Last(
			String uuid, OrderByComparator<ArticleHistory> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public static ArticleHistory fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the article histories before and after the current article history in the ordered set where uuid = &#63;.
	 *
	 * @param articleHistoryId the primary key of the current article history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public static ArticleHistory[] findByUuid_PrevAndNext(
			long articleHistoryId, String uuid,
			OrderByComparator<ArticleHistory> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByUuid_PrevAndNext(
			articleHistoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the article histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of article histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article histories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the article histories where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching article histories
	 */
	public static List<ArticleHistory> findByArticle(long articleId) {
		return getPersistence().findByArticle(articleId);
	}

	/**
	 * Returns a range of all the article histories where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of matching article histories
	 */
	public static List<ArticleHistory> findByArticle(
		long articleId, int start, int end) {

		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	 * Returns an ordered range of all the article histories where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article histories
	 */
	public static List<ArticleHistory> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article histories where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article histories
	 */
	public static List<ArticleHistory> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public static ArticleHistory findByArticle_First(
			long articleId, OrderByComparator<ArticleHistory> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the first article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public static ArticleHistory fetchByArticle_First(
		long articleId, OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().fetchByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public static ArticleHistory findByArticle_Last(
			long articleId, OrderByComparator<ArticleHistory> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public static ArticleHistory fetchByArticle_Last(
		long articleId, OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().fetchByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the article histories before and after the current article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleHistoryId the primary key of the current article history
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public static ArticleHistory[] findByArticle_PrevAndNext(
			long articleHistoryId, long articleId,
			OrderByComparator<ArticleHistory> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByArticle_PrevAndNext(
			articleHistoryId, articleId, orderByComparator);
	}

	/**
	 * Removes all the article histories where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public static void removeByArticle(long articleId) {
		getPersistence().removeByArticle(articleId);
	}

	/**
	 * Returns the number of article histories where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching article histories
	 */
	public static int countByArticle(long articleId) {
		return getPersistence().countByArticle(articleId);
	}

	/**
	 * Caches the article history in the entity cache if it is enabled.
	 *
	 * @param articleHistory the article history
	 */
	public static void cacheResult(ArticleHistory articleHistory) {
		getPersistence().cacheResult(articleHistory);
	}

	/**
	 * Caches the article histories in the entity cache if it is enabled.
	 *
	 * @param articleHistories the article histories
	 */
	public static void cacheResult(List<ArticleHistory> articleHistories) {
		getPersistence().cacheResult(articleHistories);
	}

	/**
	 * Creates a new article history with the primary key. Does not add the article history to the database.
	 *
	 * @param articleHistoryId the primary key for the new article history
	 * @return the new article history
	 */
	public static ArticleHistory create(long articleHistoryId) {
		return getPersistence().create(articleHistoryId);
	}

	/**
	 * Removes the article history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history that was removed
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public static ArticleHistory remove(long articleHistoryId)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().remove(articleHistoryId);
	}

	public static ArticleHistory updateImpl(ArticleHistory articleHistory) {
		return getPersistence().updateImpl(articleHistory);
	}

	/**
	 * Returns the article history with the primary key or throws a <code>NoSuchArticleHistoryException</code> if it could not be found.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public static ArticleHistory findByPrimaryKey(long articleHistoryId)
		throws com.software.cms.exception.NoSuchArticleHistoryException {

		return getPersistence().findByPrimaryKey(articleHistoryId);
	}

	/**
	 * Returns the article history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history, or <code>null</code> if a article history with the primary key could not be found
	 */
	public static ArticleHistory fetchByPrimaryKey(long articleHistoryId) {
		return getPersistence().fetchByPrimaryKey(articleHistoryId);
	}

	/**
	 * Returns all the article histories.
	 *
	 * @return the article histories
	 */
	public static List<ArticleHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of article histories
	 */
	public static List<ArticleHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article histories
	 */
	public static List<ArticleHistory> findAll(
		int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article histories
	 */
	public static List<ArticleHistory> findAll(
		int start, int end, OrderByComparator<ArticleHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the article histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of article histories.
	 *
	 * @return the number of article histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticleHistoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ArticleHistoryPersistence, ArticleHistoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ArticleHistoryPersistence.class);

		ServiceTracker<ArticleHistoryPersistence, ArticleHistoryPersistence>
			serviceTracker =
				new ServiceTracker
					<ArticleHistoryPersistence, ArticleHistoryPersistence>(
						bundle.getBundleContext(),
						ArticleHistoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}