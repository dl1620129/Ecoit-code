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

import com.software.cms.model.Logger;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the logger service. This utility wraps <code>com.software.cms.service.persistence.impl.LoggerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see LoggerPersistence
 * @generated
 */
public class LoggerUtil {

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
	public static void clearCache(Logger logger) {
		getPersistence().clearCache(logger);
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
	public static Map<Serializable, Logger> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Logger> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Logger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Logger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Logger update(Logger logger) {
		return getPersistence().update(logger);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Logger update(Logger logger, ServiceContext serviceContext) {
		return getPersistence().update(logger, serviceContext);
	}

	/**
	 * Returns all the loggers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loggers
	 */
	public static List<Logger> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the loggers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	public static List<Logger> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the loggers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loggers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByUuid_First(
			String uuid, OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByUuid_First(
		String uuid, OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByUuid_Last(
			String uuid, OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByUuid_Last(
		String uuid, OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where uuid = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger[] findByUuid_PrevAndNext(
			long loggerId, String uuid,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByUuid_PrevAndNext(
			loggerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the loggers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of loggers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loggers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoggerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the logger where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the logger that was removed
	 */
	public static Logger removeByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of loggers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching loggers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @return the matching loggers
	 */
	public static List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId) {

		return getPersistence().findByGroup_Language_User(
			groupId, language, userId);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end) {

		return getPersistence().findByGroup_Language_User(
			groupId, language, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findByGroup_Language_User(
			groupId, language, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup_Language_User(
			groupId, language, userId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_User_First(
			long groupId, String language, long userId,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_User_First(
			groupId, language, userId, orderByComparator);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_User_First(
		long groupId, String language, long userId,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_User_First(
			groupId, language, userId, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_User_Last(
			long groupId, String language, long userId,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_User_Last(
			groupId, language, userId, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_User_Last(
		long groupId, String language, long userId,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_User_Last(
			groupId, language, userId, orderByComparator);
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger[] findByGroup_Language_User_PrevAndNext(
			long loggerId, long groupId, String language, long userId,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_User_PrevAndNext(
			loggerId, groupId, language, userId, orderByComparator);
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 */
	public static void removeByGroup_Language_User(
		long groupId, String language, long userId) {

		getPersistence().removeByGroup_Language_User(groupId, language, userId);
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @return the number of matching loggers
	 */
	public static int countByGroup_Language_User(
		long groupId, String language, long userId) {

		return getPersistence().countByGroup_Language_User(
			groupId, language, userId);
	}

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching loggers
	 */
	public static List<Logger> findByGroup_Language(
		long groupId, String language) {

		return getPersistence().findByGroup_Language(groupId, language);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	public static List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end) {

		return getPersistence().findByGroup_Language(
			groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findByGroup_Language(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup_Language(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_First(
			long groupId, String language,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_First(
		long groupId, String language,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_Last(
			long groupId, String language,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_Last(
		long groupId, String language,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger[] findByGroup_Language_PrevAndNext(
			long loggerId, long groupId, String language,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_PrevAndNext(
			loggerId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByGroup_Language(long groupId, String language) {
		getPersistence().removeByGroup_Language(groupId, language);
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching loggers
	 */
	public static int countByGroup_Language(long groupId, String language) {
		return getPersistence().countByGroup_Language(groupId, language);
	}

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @return the matching loggers
	 */
	public static List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type) {

		return getPersistence().findByGroup_Language_Type(
			groupId, language, type);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end) {

		return getPersistence().findByGroup_Language_Type(
			groupId, language, type, start, end);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findByGroup_Language_Type(
			groupId, language, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroup_Language_Type(
			groupId, language, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_Type_First(
			long groupId, String language, String type,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_Type_First(
			groupId, language, type, orderByComparator);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_Type_First(
		long groupId, String language, String type,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Type_First(
			groupId, language, type, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_Type_Last(
			long groupId, String language, String type,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_Type_Last(
			groupId, language, type, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_Type_Last(
		long groupId, String language, String type,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_Type_Last(
			groupId, language, type, orderByComparator);
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger[] findByGroup_Language_Type_PrevAndNext(
			long loggerId, long groupId, String language, String type,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_Type_PrevAndNext(
			loggerId, groupId, language, type, orderByComparator);
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 */
	public static void removeByGroup_Language_Type(
		long groupId, String language, String type) {

		getPersistence().removeByGroup_Language_Type(groupId, language, type);
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @return the number of matching loggers
	 */
	public static int countByGroup_Language_Type(
		long groupId, String language, String type) {

		return getPersistence().countByGroup_Language_Type(
			groupId, language, type);
	}

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching loggers
	 */
	public static List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type) {

		return getPersistence().findByGroup_Language_User_Type(
			groupId, language, userId, type);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end) {

		return getPersistence().findByGroup_Language_User_Type(
			groupId, language, userId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end, OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findByGroup_Language_User_Type(
			groupId, language, userId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	public static List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end, OrderByComparator<Logger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup_Language_User_Type(
			groupId, language, userId, type, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_User_Type_First(
			long groupId, String language, long userId, String type,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_User_Type_First(
			groupId, language, userId, type, orderByComparator);
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_User_Type_First(
		long groupId, String language, long userId, String type,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_User_Type_First(
			groupId, language, userId, type, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public static Logger findByGroup_Language_User_Type_Last(
			long groupId, String language, long userId, String type,
			OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_User_Type_Last(
			groupId, language, userId, type, orderByComparator);
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static Logger fetchByGroup_Language_User_Type_Last(
		long groupId, String language, long userId, String type,
		OrderByComparator<Logger> orderByComparator) {

		return getPersistence().fetchByGroup_Language_User_Type_Last(
			groupId, language, userId, type, orderByComparator);
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger[] findByGroup_Language_User_Type_PrevAndNext(
			long loggerId, long groupId, String language, long userId,
			String type, OrderByComparator<Logger> orderByComparator)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByGroup_Language_User_Type_PrevAndNext(
			loggerId, groupId, language, userId, type, orderByComparator);
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 */
	public static void removeByGroup_Language_User_Type(
		long groupId, String language, long userId, String type) {

		getPersistence().removeByGroup_Language_User_Type(
			groupId, language, userId, type);
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching loggers
	 */
	public static int countByGroup_Language_User_Type(
		long groupId, String language, long userId, String type) {

		return getPersistence().countByGroup_Language_User_Type(
			groupId, language, userId, type);
	}

	/**
	 * Caches the logger in the entity cache if it is enabled.
	 *
	 * @param logger the logger
	 */
	public static void cacheResult(Logger logger) {
		getPersistence().cacheResult(logger);
	}

	/**
	 * Caches the loggers in the entity cache if it is enabled.
	 *
	 * @param loggers the loggers
	 */
	public static void cacheResult(List<Logger> loggers) {
		getPersistence().cacheResult(loggers);
	}

	/**
	 * Creates a new logger with the primary key. Does not add the logger to the database.
	 *
	 * @param loggerId the primary key for the new logger
	 * @return the new logger
	 */
	public static Logger create(long loggerId) {
		return getPersistence().create(loggerId);
	}

	/**
	 * Removes the logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger that was removed
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger remove(long loggerId)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().remove(loggerId);
	}

	public static Logger updateImpl(Logger logger) {
		return getPersistence().updateImpl(logger);
	}

	/**
	 * Returns the logger with the primary key or throws a <code>NoSuchLoggerException</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public static Logger findByPrimaryKey(long loggerId)
		throws com.software.cms.exception.NoSuchLoggerException {

		return getPersistence().findByPrimaryKey(loggerId);
	}

	/**
	 * Returns the logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger, or <code>null</code> if a logger with the primary key could not be found
	 */
	public static Logger fetchByPrimaryKey(long loggerId) {
		return getPersistence().fetchByPrimaryKey(loggerId);
	}

	/**
	 * Returns all the loggers.
	 *
	 * @return the loggers
	 */
	public static List<Logger> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of loggers
	 */
	public static List<Logger> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loggers
	 */
	public static List<Logger> findAll(
		int start, int end, OrderByComparator<Logger> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of loggers
	 */
	public static List<Logger> findAll(
		int start, int end, OrderByComparator<Logger> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the loggers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of loggers.
	 *
	 * @return the number of loggers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LoggerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoggerPersistence, LoggerPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoggerPersistence.class);

		ServiceTracker<LoggerPersistence, LoggerPersistence> serviceTracker =
			new ServiceTracker<LoggerPersistence, LoggerPersistence>(
				bundle.getBundleContext(), LoggerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}