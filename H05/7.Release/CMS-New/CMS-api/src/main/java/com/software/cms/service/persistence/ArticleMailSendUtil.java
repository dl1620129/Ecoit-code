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

import com.software.cms.model.ArticleMailSend;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the article mail send service. This utility wraps <code>com.software.cms.service.persistence.impl.ArticleMailSendPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleMailSendPersistence
 * @generated
 */
public class ArticleMailSendUtil {

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
	public static void clearCache(ArticleMailSend articleMailSend) {
		getPersistence().clearCache(articleMailSend);
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
	public static Map<Serializable, ArticleMailSend> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArticleMailSend> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArticleMailSend> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArticleMailSend> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ArticleMailSend update(ArticleMailSend articleMailSend) {
		return getPersistence().update(articleMailSend);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ArticleMailSend update(
		ArticleMailSend articleMailSend, ServiceContext serviceContext) {

		return getPersistence().update(articleMailSend, serviceContext);
	}

	/**
	 * Returns all the article mail sends where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article mail sends
	 */
	public static List<ArticleMailSend> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of matching article mail sends
	 */
	public static List<ArticleMailSend> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article mail sends
	 */
	public static List<ArticleMailSend> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article mail sends
	 */
	public static List<ArticleMailSend> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	public static ArticleMailSend findByUuid_First(
			String uuid, OrderByComparator<ArticleMailSend> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public static ArticleMailSend fetchByUuid_First(
		String uuid, OrderByComparator<ArticleMailSend> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	public static ArticleMailSend findByUuid_Last(
			String uuid, OrderByComparator<ArticleMailSend> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public static ArticleMailSend fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleMailSend> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the article mail sends before and after the current article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param mailSendId the primary key of the current article mail send
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	public static ArticleMailSend[] findByUuid_PrevAndNext(
			long mailSendId, String uuid,
			OrderByComparator<ArticleMailSend> orderByComparator)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().findByUuid_PrevAndNext(
			mailSendId, uuid, orderByComparator);
	}

	/**
	 * Removes all the article mail sends where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of article mail sends where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article mail sends
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArticleMailSendException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	public static ArticleMailSend findByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public static ArticleMailSend fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	public static ArticleMailSend fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the article mail send where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article mail send that was removed
	 */
	public static ArticleMailSend removeByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of article mail sends where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching article mail sends
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Caches the article mail send in the entity cache if it is enabled.
	 *
	 * @param articleMailSend the article mail send
	 */
	public static void cacheResult(ArticleMailSend articleMailSend) {
		getPersistence().cacheResult(articleMailSend);
	}

	/**
	 * Caches the article mail sends in the entity cache if it is enabled.
	 *
	 * @param articleMailSends the article mail sends
	 */
	public static void cacheResult(List<ArticleMailSend> articleMailSends) {
		getPersistence().cacheResult(articleMailSends);
	}

	/**
	 * Creates a new article mail send with the primary key. Does not add the article mail send to the database.
	 *
	 * @param mailSendId the primary key for the new article mail send
	 * @return the new article mail send
	 */
	public static ArticleMailSend create(long mailSendId) {
		return getPersistence().create(mailSendId);
	}

	/**
	 * Removes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	public static ArticleMailSend remove(long mailSendId)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().remove(mailSendId);
	}

	public static ArticleMailSend updateImpl(ArticleMailSend articleMailSend) {
		return getPersistence().updateImpl(articleMailSend);
	}

	/**
	 * Returns the article mail send with the primary key or throws a <code>NoSuchArticleMailSendException</code> if it could not be found.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	public static ArticleMailSend findByPrimaryKey(long mailSendId)
		throws com.software.cms.exception.NoSuchArticleMailSendException {

		return getPersistence().findByPrimaryKey(mailSendId);
	}

	/**
	 * Returns the article mail send with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send, or <code>null</code> if a article mail send with the primary key could not be found
	 */
	public static ArticleMailSend fetchByPrimaryKey(long mailSendId) {
		return getPersistence().fetchByPrimaryKey(mailSendId);
	}

	/**
	 * Returns all the article mail sends.
	 *
	 * @return the article mail sends
	 */
	public static List<ArticleMailSend> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of article mail sends
	 */
	public static List<ArticleMailSend> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article mail sends
	 */
	public static List<ArticleMailSend> findAll(
		int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article mail sends
	 */
	public static List<ArticleMailSend> findAll(
		int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the article mail sends from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of article mail sends.
	 *
	 * @return the number of article mail sends
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticleMailSendPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ArticleMailSendPersistence, ArticleMailSendPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ArticleMailSendPersistence.class);

		ServiceTracker<ArticleMailSendPersistence, ArticleMailSendPersistence>
			serviceTracker =
				new ServiceTracker
					<ArticleMailSendPersistence, ArticleMailSendPersistence>(
						bundle.getBundleContext(),
						ArticleMailSendPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}