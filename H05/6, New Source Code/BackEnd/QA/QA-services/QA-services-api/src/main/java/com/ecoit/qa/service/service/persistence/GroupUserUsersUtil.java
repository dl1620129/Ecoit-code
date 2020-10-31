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

package com.ecoit.qa.service.service.persistence;

import com.ecoit.qa.service.model.GroupUserUsers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the group user users service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.GroupUserUsersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUsersPersistence
 * @generated
 */
public class GroupUserUsersUtil {

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
	public static void clearCache(GroupUserUsers groupUserUsers) {
		getPersistence().clearCache(groupUserUsers);
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
	public static Map<Serializable, GroupUserUsers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupUserUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupUserUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupUserUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupUserUsers update(GroupUserUsers groupUserUsers) {
		return getPersistence().update(groupUserUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupUserUsers update(
		GroupUserUsers groupUserUsers, ServiceContext serviceContext) {

		return getPersistence().update(groupUserUsers, serviceContext);
	}

	/**
	 * Returns all the group user userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching group user userses
	 */
	public static List<GroupUserUsers> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns a range of all the group user userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of matching group user userses
	 */
	public static List<GroupUserUsers> findByUser(
		long userId, int start, int end) {

		return getPersistence().findByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user userses
	 */
	public static List<GroupUserUsers> findByUser(
		long userId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user userses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user userses
	 */
	public static List<GroupUserUsers> findByUser(
		long userId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public static GroupUserUsers findByUser_First(
			long userId, OrderByComparator<GroupUserUsers> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first group user users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public static GroupUserUsers fetchByUser_First(
		long userId, OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last group user users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public static GroupUserUsers findByUser_Last(
			long userId, OrderByComparator<GroupUserUsers> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last group user users in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public static GroupUserUsers fetchByUser_Last(
		long userId, OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the group user userses before and after the current group user users in the ordered set where userId = &#63;.
	 *
	 * @param groupUserUsersPK the primary key of the current group user users
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public static GroupUserUsers[] findByUser_PrevAndNext(
			GroupUserUsersPK groupUserUsersPK, long userId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByUser_PrevAndNext(
			groupUserUsersPK, userId, orderByComparator);
	}

	/**
	 * Removes all the group user userses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of group user userses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching group user userses
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Returns all the group user userses where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user userses
	 */
	public static List<GroupUserUsers> findByGroupUser(long groupUserId) {
		return getPersistence().findByGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group user userses where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of matching group user userses
	 */
	public static List<GroupUserUsers> findByGroupUser(
		long groupUserId, int start, int end) {

		return getPersistence().findByGroupUser(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user userses where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user userses
	 */
	public static List<GroupUserUsers> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user userses where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user userses
	 */
	public static List<GroupUserUsers> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user users in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public static GroupUserUsers findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first group user users in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public static GroupUserUsers fetchByGroupUser_First(
		long groupUserId, OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user users in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public static GroupUserUsers findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user users in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public static GroupUserUsers fetchByGroupUser_Last(
		long groupUserId, OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the group user userses before and after the current group user users in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserUsersPK the primary key of the current group user users
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public static GroupUserUsers[] findByGroupUser_PrevAndNext(
			GroupUserUsersPK groupUserUsersPK, long groupUserId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupUserUsersPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the group user userses where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeByGroupUser(long groupUserId) {
		getPersistence().removeByGroupUser(groupUserId);
	}

	/**
	 * Returns the number of group user userses where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user userses
	 */
	public static int countByGroupUser(long groupUserId) {
		return getPersistence().countByGroupUser(groupUserId);
	}

	/**
	 * Caches the group user users in the entity cache if it is enabled.
	 *
	 * @param groupUserUsers the group user users
	 */
	public static void cacheResult(GroupUserUsers groupUserUsers) {
		getPersistence().cacheResult(groupUserUsers);
	}

	/**
	 * Caches the group user userses in the entity cache if it is enabled.
	 *
	 * @param groupUserUserses the group user userses
	 */
	public static void cacheResult(List<GroupUserUsers> groupUserUserses) {
		getPersistence().cacheResult(groupUserUserses);
	}

	/**
	 * Creates a new group user users with the primary key. Does not add the group user users to the database.
	 *
	 * @param groupUserUsersPK the primary key for the new group user users
	 * @return the new group user users
	 */
	public static GroupUserUsers create(GroupUserUsersPK groupUserUsersPK) {
		return getPersistence().create(groupUserUsersPK);
	}

	/**
	 * Removes the group user users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users that was removed
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public static GroupUserUsers remove(GroupUserUsersPK groupUserUsersPK)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().remove(groupUserUsersPK);
	}

	public static GroupUserUsers updateImpl(GroupUserUsers groupUserUsers) {
		return getPersistence().updateImpl(groupUserUsers);
	}

	/**
	 * Returns the group user users with the primary key or throws a <code>NoSuchGroupUserUsersException</code> if it could not be found.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public static GroupUserUsers findByPrimaryKey(
			GroupUserUsersPK groupUserUsersPK)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUsersException {

		return getPersistence().findByPrimaryKey(groupUserUsersPK);
	}

	/**
	 * Returns the group user users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users, or <code>null</code> if a group user users with the primary key could not be found
	 */
	public static GroupUserUsers fetchByPrimaryKey(
		GroupUserUsersPK groupUserUsersPK) {

		return getPersistence().fetchByPrimaryKey(groupUserUsersPK);
	}

	/**
	 * Returns all the group user userses.
	 *
	 * @return the group user userses
	 */
	public static List<GroupUserUsers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of group user userses
	 */
	public static List<GroupUserUsers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user userses
	 */
	public static List<GroupUserUsers> findAll(
		int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user userses
	 */
	public static List<GroupUserUsers> findAll(
		int start, int end, OrderByComparator<GroupUserUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group user userses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group user userses.
	 *
	 * @return the number of group user userses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupUserUsersPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserUsersPersistence, GroupUserUsersPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserUsersPersistence.class);

		ServiceTracker<GroupUserUsersPersistence, GroupUserUsersPersistence>
			serviceTracker =
				new ServiceTracker
					<GroupUserUsersPersistence, GroupUserUsersPersistence>(
						bundle.getBundleContext(),
						GroupUserUsersPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}