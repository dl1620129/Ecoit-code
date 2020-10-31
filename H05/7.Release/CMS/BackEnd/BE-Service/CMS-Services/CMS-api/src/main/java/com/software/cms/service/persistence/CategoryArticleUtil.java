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

import com.software.cms.model.CategoryArticle;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the category article service. This utility wraps <code>com.software.cms.service.persistence.impl.CategoryArticlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see CategoryArticlePersistence
 * @generated
 */
public class CategoryArticleUtil {

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
	public static void clearCache(CategoryArticle categoryArticle) {
		getPersistence().clearCache(categoryArticle);
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
	public static Map<Serializable, CategoryArticle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CategoryArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CategoryArticle update(CategoryArticle categoryArticle) {
		return getPersistence().update(categoryArticle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CategoryArticle update(
		CategoryArticle categoryArticle, ServiceContext serviceContext) {

		return getPersistence().update(categoryArticle, serviceContext);
	}

	/**
	 * Returns all the category articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching category articles
	 */
	public static List<CategoryArticle> findByArticle(long articleId) {
		return getPersistence().findByArticle(articleId);
	}

	/**
	 * Returns a range of all the category articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of matching category articles
	 */
	public static List<CategoryArticle> findByArticle(
		long articleId, int start, int end) {

		return getPersistence().findByArticle(articleId, start, end);
	}

	/**
	 * Returns an ordered range of all the category articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category articles
	 */
	public static List<CategoryArticle> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category articles
	 */
	public static List<CategoryArticle> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArticle(
			articleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public static CategoryArticle findByArticle_First(
			long articleId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the first category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public static CategoryArticle fetchByArticle_First(
		long articleId, OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().fetchByArticle_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public static CategoryArticle findByArticle_Last(
			long articleId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public static CategoryArticle fetchByArticle_Last(
		long articleId, OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().fetchByArticle_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the category articles before and after the current category article in the ordered set where articleId = &#63;.
	 *
	 * @param categoryArticlePK the primary key of the current category article
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public static CategoryArticle[] findByArticle_PrevAndNext(
			CategoryArticlePK categoryArticlePK, long articleId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByArticle_PrevAndNext(
			categoryArticlePK, articleId, orderByComparator);
	}

	/**
	 * Removes all the category articles where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public static void removeByArticle(long articleId) {
		getPersistence().removeByArticle(articleId);
	}

	/**
	 * Returns the number of category articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching category articles
	 */
	public static int countByArticle(long articleId) {
		return getPersistence().countByArticle(articleId);
	}

	/**
	 * Returns all the category articles where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching category articles
	 */
	public static List<CategoryArticle> findByCategory(long categoryId) {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	 * Returns a range of all the category articles where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of matching category articles
	 */
	public static List<CategoryArticle> findByCategory(
		long categoryId, int start, int end) {

		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the category articles where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category articles
	 */
	public static List<CategoryArticle> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category articles where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category articles
	 */
	public static List<CategoryArticle> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public static CategoryArticle findByCategory_First(
			long categoryId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public static CategoryArticle fetchByCategory_First(
		long categoryId, OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public static CategoryArticle findByCategory_Last(
			long categoryId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public static CategoryArticle fetchByCategory_Last(
		long categoryId, OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the category articles before and after the current category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryArticlePK the primary key of the current category article
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public static CategoryArticle[] findByCategory_PrevAndNext(
			CategoryArticlePK categoryArticlePK, long categoryId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByCategory_PrevAndNext(
			categoryArticlePK, categoryId, orderByComparator);
	}

	/**
	 * Removes all the category articles where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategory(long categoryId) {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	 * Returns the number of category articles where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching category articles
	 */
	public static int countByCategory(long categoryId) {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	 * Caches the category article in the entity cache if it is enabled.
	 *
	 * @param categoryArticle the category article
	 */
	public static void cacheResult(CategoryArticle categoryArticle) {
		getPersistence().cacheResult(categoryArticle);
	}

	/**
	 * Caches the category articles in the entity cache if it is enabled.
	 *
	 * @param categoryArticles the category articles
	 */
	public static void cacheResult(List<CategoryArticle> categoryArticles) {
		getPersistence().cacheResult(categoryArticles);
	}

	/**
	 * Creates a new category article with the primary key. Does not add the category article to the database.
	 *
	 * @param categoryArticlePK the primary key for the new category article
	 * @return the new category article
	 */
	public static CategoryArticle create(CategoryArticlePK categoryArticlePK) {
		return getPersistence().create(categoryArticlePK);
	}

	/**
	 * Removes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article that was removed
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public static CategoryArticle remove(CategoryArticlePK categoryArticlePK)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().remove(categoryArticlePK);
	}

	public static CategoryArticle updateImpl(CategoryArticle categoryArticle) {
		return getPersistence().updateImpl(categoryArticle);
	}

	/**
	 * Returns the category article with the primary key or throws a <code>NoSuchCategoryArticleException</code> if it could not be found.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public static CategoryArticle findByPrimaryKey(
			CategoryArticlePK categoryArticlePK)
		throws com.software.cms.exception.NoSuchCategoryArticleException {

		return getPersistence().findByPrimaryKey(categoryArticlePK);
	}

	/**
	 * Returns the category article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article, or <code>null</code> if a category article with the primary key could not be found
	 */
	public static CategoryArticle fetchByPrimaryKey(
		CategoryArticlePK categoryArticlePK) {

		return getPersistence().fetchByPrimaryKey(categoryArticlePK);
	}

	/**
	 * Returns all the category articles.
	 *
	 * @return the category articles
	 */
	public static List<CategoryArticle> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of category articles
	 */
	public static List<CategoryArticle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category articles
	 */
	public static List<CategoryArticle> findAll(
		int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of category articles
	 */
	public static List<CategoryArticle> findAll(
		int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the category articles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of category articles.
	 *
	 * @return the number of category articles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static CategoryArticlePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CategoryArticlePersistence, CategoryArticlePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CategoryArticlePersistence.class);

		ServiceTracker<CategoryArticlePersistence, CategoryArticlePersistence>
			serviceTracker =
				new ServiceTracker
					<CategoryArticlePersistence, CategoryArticlePersistence>(
						bundle.getBundleContext(),
						CategoryArticlePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}