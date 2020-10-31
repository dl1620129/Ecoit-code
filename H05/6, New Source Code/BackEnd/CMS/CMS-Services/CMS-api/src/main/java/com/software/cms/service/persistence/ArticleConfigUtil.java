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

import com.software.cms.model.ArticleConfig;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the article config service. This utility wraps <code>com.software.cms.service.persistence.impl.ArticleConfigPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleConfigPersistence
 * @generated
 */
public class ArticleConfigUtil {

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
	public static void clearCache(ArticleConfig articleConfig) {
		getPersistence().clearCache(articleConfig);
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
	public static Map<Serializable, ArticleConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArticleConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArticleConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArticleConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ArticleConfig> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ArticleConfig update(ArticleConfig articleConfig) {
		return getPersistence().update(articleConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ArticleConfig update(
		ArticleConfig articleConfig, ServiceContext serviceContext) {

		return getPersistence().update(articleConfig, serviceContext);
	}

	/**
	 * Returns all the article configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article configs
	 */
	public static List<ArticleConfig> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the article configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @return the range of matching article configs
	 */
	public static List<ArticleConfig> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the article configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article configs
	 */
	public static List<ArticleConfig> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleConfig> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article configs
	 */
	public static List<ArticleConfig> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article config
	 * @throws NoSuchArticleConfigException if a matching article config could not be found
	 */
	public static ArticleConfig findByUuid_First(
			String uuid, OrderByComparator<ArticleConfig> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleConfigException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first article config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article config, or <code>null</code> if a matching article config could not be found
	 */
	public static ArticleConfig fetchByUuid_First(
		String uuid, OrderByComparator<ArticleConfig> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last article config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article config
	 * @throws NoSuchArticleConfigException if a matching article config could not be found
	 */
	public static ArticleConfig findByUuid_Last(
			String uuid, OrderByComparator<ArticleConfig> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleConfigException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last article config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article config, or <code>null</code> if a matching article config could not be found
	 */
	public static ArticleConfig fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleConfig> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the article configs before and after the current article config in the ordered set where uuid = &#63;.
	 *
	 * @param articleConfigId the primary key of the current article config
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article config
	 * @throws NoSuchArticleConfigException if a article config with the primary key could not be found
	 */
	public static ArticleConfig[] findByUuid_PrevAndNext(
			long articleConfigId, String uuid,
			OrderByComparator<ArticleConfig> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleConfigException {

		return getPersistence().findByUuid_PrevAndNext(
			articleConfigId, uuid, orderByComparator);
	}

	/**
	 * Removes all the article configs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of article configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article configs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the article config in the entity cache if it is enabled.
	 *
	 * @param articleConfig the article config
	 */
	public static void cacheResult(ArticleConfig articleConfig) {
		getPersistence().cacheResult(articleConfig);
	}

	/**
	 * Caches the article configs in the entity cache if it is enabled.
	 *
	 * @param articleConfigs the article configs
	 */
	public static void cacheResult(List<ArticleConfig> articleConfigs) {
		getPersistence().cacheResult(articleConfigs);
	}

	/**
	 * Creates a new article config with the primary key. Does not add the article config to the database.
	 *
	 * @param articleConfigId the primary key for the new article config
	 * @return the new article config
	 */
	public static ArticleConfig create(long articleConfigId) {
		return getPersistence().create(articleConfigId);
	}

	/**
	 * Removes the article config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleConfigId the primary key of the article config
	 * @return the article config that was removed
	 * @throws NoSuchArticleConfigException if a article config with the primary key could not be found
	 */
	public static ArticleConfig remove(long articleConfigId)
		throws com.software.cms.exception.NoSuchArticleConfigException {

		return getPersistence().remove(articleConfigId);
	}

	public static ArticleConfig updateImpl(ArticleConfig articleConfig) {
		return getPersistence().updateImpl(articleConfig);
	}

	/**
	 * Returns the article config with the primary key or throws a <code>NoSuchArticleConfigException</code> if it could not be found.
	 *
	 * @param articleConfigId the primary key of the article config
	 * @return the article config
	 * @throws NoSuchArticleConfigException if a article config with the primary key could not be found
	 */
	public static ArticleConfig findByPrimaryKey(long articleConfigId)
		throws com.software.cms.exception.NoSuchArticleConfigException {

		return getPersistence().findByPrimaryKey(articleConfigId);
	}

	/**
	 * Returns the article config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleConfigId the primary key of the article config
	 * @return the article config, or <code>null</code> if a article config with the primary key could not be found
	 */
	public static ArticleConfig fetchByPrimaryKey(long articleConfigId) {
		return getPersistence().fetchByPrimaryKey(articleConfigId);
	}

	/**
	 * Returns all the article configs.
	 *
	 * @return the article configs
	 */
	public static List<ArticleConfig> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the article configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @return the range of article configs
	 */
	public static List<ArticleConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the article configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article configs
	 */
	public static List<ArticleConfig> findAll(
		int start, int end,
		OrderByComparator<ArticleConfig> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article configs
	 */
	public static List<ArticleConfig> findAll(
		int start, int end, OrderByComparator<ArticleConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the article configs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of article configs.
	 *
	 * @return the number of article configs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticleConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ArticleConfigPersistence, ArticleConfigPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArticleConfigPersistence.class);

		ServiceTracker<ArticleConfigPersistence, ArticleConfigPersistence>
			serviceTracker =
				new ServiceTracker
					<ArticleConfigPersistence, ArticleConfigPersistence>(
						bundle.getBundleContext(),
						ArticleConfigPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}