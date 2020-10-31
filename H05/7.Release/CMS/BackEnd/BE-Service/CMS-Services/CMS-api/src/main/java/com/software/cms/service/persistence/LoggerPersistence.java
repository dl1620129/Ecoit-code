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

import com.software.cms.exception.NoSuchLoggerException;
import com.software.cms.model.Logger;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see LoggerUtil
 * @generated
 */
@ProviderType
public interface LoggerPersistence extends BasePersistence<Logger> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoggerUtil} to access the logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the loggers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loggers
	 */
	public java.util.List<Logger> findByUuid(String uuid);

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
	public java.util.List<Logger> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Logger> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public java.util.List<Logger> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public Logger findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the first logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

	/**
	 * Returns the last logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public Logger findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the last logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

	/**
	 * Returns the loggers before and after the current logger in the ordered set where uuid = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public Logger[] findByUuid_PrevAndNext(
			long loggerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Removes all the loggers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of loggers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loggers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoggerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public Logger findByUUID_G(String uuid, long groupId)
		throws NoSuchLoggerException;

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the logger where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the logger that was removed
	 */
	public Logger removeByUUID_G(String uuid, long groupId)
		throws NoSuchLoggerException;

	/**
	 * Returns the number of loggers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching loggers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @return the matching loggers
	 */
	public java.util.List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId);

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
	public java.util.List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end);

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
	public java.util.List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public java.util.List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator,
		boolean useFinderCache);

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
	public Logger findByGroup_Language_User_First(
			long groupId, String language, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByGroup_Language_User_First(
		long groupId, String language, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger findByGroup_Language_User_Last(
			long groupId, String language, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByGroup_Language_User_Last(
		long groupId, String language, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger[] findByGroup_Language_User_PrevAndNext(
			long loggerId, long groupId, String language, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 */
	public void removeByGroup_Language_User(
		long groupId, String language, long userId);

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @return the number of matching loggers
	 */
	public int countByGroup_Language_User(
		long groupId, String language, long userId);

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching loggers
	 */
	public java.util.List<Logger> findByGroup_Language(
		long groupId, String language);

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
	public java.util.List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end);

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
	public java.util.List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public java.util.List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public Logger findByGroup_Language_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByGroup_Language_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	public Logger findByGroup_Language_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByGroup_Language_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger[] findByGroup_Language_PrevAndNext(
			long loggerId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByGroup_Language(long groupId, String language);

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching loggers
	 */
	public int countByGroup_Language(long groupId, String language);

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @return the matching loggers
	 */
	public java.util.List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type);

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
	public java.util.List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end);

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
	public java.util.List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public java.util.List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator,
		boolean useFinderCache);

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
	public Logger findByGroup_Language_Type_First(
			long groupId, String language, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByGroup_Language_Type_First(
		long groupId, String language, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger findByGroup_Language_Type_Last(
			long groupId, String language, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public Logger fetchByGroup_Language_Type_Last(
		long groupId, String language, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger[] findByGroup_Language_Type_PrevAndNext(
			long loggerId, long groupId, String language, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 */
	public void removeByGroup_Language_Type(
		long groupId, String language, String type);

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @return the number of matching loggers
	 */
	public int countByGroup_Language_Type(
		long groupId, String language, String type);

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching loggers
	 */
	public java.util.List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type);

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
	public java.util.List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end);

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
	public java.util.List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public java.util.List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator,
		boolean useFinderCache);

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
	public Logger findByGroup_Language_User_Type_First(
			long groupId, String language, long userId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

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
	public Logger fetchByGroup_Language_User_Type_First(
		long groupId, String language, long userId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger findByGroup_Language_User_Type_Last(
			long groupId, String language, long userId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

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
	public Logger fetchByGroup_Language_User_Type_Last(
		long groupId, String language, long userId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public Logger[] findByGroup_Language_User_Type_PrevAndNext(
			long loggerId, long groupId, String language, long userId,
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<Logger>
				orderByComparator)
		throws NoSuchLoggerException;

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 */
	public void removeByGroup_Language_User_Type(
		long groupId, String language, long userId, String type);

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching loggers
	 */
	public int countByGroup_Language_User_Type(
		long groupId, String language, long userId, String type);

	/**
	 * Caches the logger in the entity cache if it is enabled.
	 *
	 * @param logger the logger
	 */
	public void cacheResult(Logger logger);

	/**
	 * Caches the loggers in the entity cache if it is enabled.
	 *
	 * @param loggers the loggers
	 */
	public void cacheResult(java.util.List<Logger> loggers);

	/**
	 * Creates a new logger with the primary key. Does not add the logger to the database.
	 *
	 * @param loggerId the primary key for the new logger
	 * @return the new logger
	 */
	public Logger create(long loggerId);

	/**
	 * Removes the logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger that was removed
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public Logger remove(long loggerId) throws NoSuchLoggerException;

	public Logger updateImpl(Logger logger);

	/**
	 * Returns the logger with the primary key or throws a <code>NoSuchLoggerException</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	public Logger findByPrimaryKey(long loggerId) throws NoSuchLoggerException;

	/**
	 * Returns the logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger, or <code>null</code> if a logger with the primary key could not be found
	 */
	public Logger fetchByPrimaryKey(long loggerId);

	/**
	 * Returns all the loggers.
	 *
	 * @return the loggers
	 */
	public java.util.List<Logger> findAll();

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
	public java.util.List<Logger> findAll(int start, int end);

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
	public java.util.List<Logger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator);

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
	public java.util.List<Logger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Logger>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the loggers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of loggers.
	 *
	 * @return the number of loggers
	 */
	public int countAll();

}