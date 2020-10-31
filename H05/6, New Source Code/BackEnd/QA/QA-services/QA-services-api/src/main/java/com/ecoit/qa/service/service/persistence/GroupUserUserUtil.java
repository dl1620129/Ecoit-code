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

import com.ecoit.qa.service.model.GroupUserUser;

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
 * The persistence utility for the group user user service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.GroupUserUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUserPersistence
 * @generated
 */
public class GroupUserUserUtil {

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
	public static void clearCache(GroupUserUser groupUserUser) {
		getPersistence().clearCache(groupUserUser);
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
	public static Map<Serializable, GroupUserUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupUserUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupUserUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupUserUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupUserUser update(GroupUserUser groupUserUser) {
		return getPersistence().update(groupUserUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupUserUser update(
		GroupUserUser groupUserUser, ServiceContext serviceContext) {

		return getPersistence().update(groupUserUser, serviceContext);
	}

	/**
	 * Returns all the group user users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching group user users
	 */
	public static List<GroupUserUser> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns a range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of matching group user users
	 */
	public static List<GroupUserUser> findByUser(
		long userId, int start, int end) {

		return getPersistence().findByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user users
	 */
	public static List<GroupUserUser> findByUser(
		long userId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user users
	 */
	public static List<GroupUserUser> findByUser(
		long userId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public static GroupUserUser findByUser_First(
			long userId, OrderByComparator<GroupUserUser> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public static GroupUserUser fetchByUser_First(
		long userId, OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public static GroupUserUser findByUser_Last(
			long userId, OrderByComparator<GroupUserUser> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public static GroupUserUser fetchByUser_Last(
		long userId, OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the group user users before and after the current group user user in the ordered set where userId = &#63;.
	 *
	 * @param groupUserUserPK the primary key of the current group user user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public static GroupUserUser[] findByUser_PrevAndNext(
			GroupUserUserPK groupUserUserPK, long userId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByUser_PrevAndNext(
			groupUserUserPK, userId, orderByComparator);
	}

	/**
	 * Removes all the group user users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of group user users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching group user users
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Returns all the group user users where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user users
	 */
	public static List<GroupUserUser> findByGroupUser(long groupUserId) {
		return getPersistence().findByGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of matching group user users
	 */
	public static List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end) {

		return getPersistence().findByGroupUser(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user users
	 */
	public static List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user users
	 */
	public static List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public static GroupUserUser findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public static GroupUserUser fetchByGroupUser_First(
		long groupUserId, OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public static GroupUserUser findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public static GroupUserUser fetchByGroupUser_Last(
		long groupUserId, OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the group user users before and after the current group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserUserPK the primary key of the current group user user
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public static GroupUserUser[] findByGroupUser_PrevAndNext(
			GroupUserUserPK groupUserUserPK, long groupUserId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupUserUserPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the group user users where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeByGroupUser(long groupUserId) {
		getPersistence().removeByGroupUser(groupUserId);
	}

	/**
	 * Returns the number of group user users where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user users
	 */
	public static int countByGroupUser(long groupUserId) {
		return getPersistence().countByGroupUser(groupUserId);
	}

	/**
	 * Caches the group user user in the entity cache if it is enabled.
	 *
	 * @param groupUserUser the group user user
	 */
	public static void cacheResult(GroupUserUser groupUserUser) {
		getPersistence().cacheResult(groupUserUser);
	}

	/**
	 * Caches the group user users in the entity cache if it is enabled.
	 *
	 * @param groupUserUsers the group user users
	 */
	public static void cacheResult(List<GroupUserUser> groupUserUsers) {
		getPersistence().cacheResult(groupUserUsers);
	}

	/**
	 * Creates a new group user user with the primary key. Does not add the group user user to the database.
	 *
	 * @param groupUserUserPK the primary key for the new group user user
	 * @return the new group user user
	 */
	public static GroupUserUser create(GroupUserUserPK groupUserUserPK) {
		return getPersistence().create(groupUserUserPK);
	}

	/**
	 * Removes the group user user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user that was removed
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public static GroupUserUser remove(GroupUserUserPK groupUserUserPK)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().remove(groupUserUserPK);
	}

	public static GroupUserUser updateImpl(GroupUserUser groupUserUser) {
		return getPersistence().updateImpl(groupUserUser);
	}

	/**
	 * Returns the group user user with the primary key or throws a <code>NoSuchGroupUserUserException</code> if it could not be found.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public static GroupUserUser findByPrimaryKey(
			GroupUserUserPK groupUserUserPK)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserUserException {

		return getPersistence().findByPrimaryKey(groupUserUserPK);
	}

	/**
	 * Returns the group user user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user, or <code>null</code> if a group user user with the primary key could not be found
	 */
	public static GroupUserUser fetchByPrimaryKey(
		GroupUserUserPK groupUserUserPK) {

		return getPersistence().fetchByPrimaryKey(groupUserUserPK);
	}

	/**
	 * Returns all the group user users.
	 *
	 * @return the group user users
	 */
	public static List<GroupUserUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of group user users
	 */
	public static List<GroupUserUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user users
	 */
	public static List<GroupUserUser> findAll(
		int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user users
	 */
	public static List<GroupUserUser> findAll(
		int start, int end, OrderByComparator<GroupUserUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group user users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group user users.
	 *
	 * @return the number of group user users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupUserUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserUserPersistence, GroupUserUserPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupUserUserPersistence.class);

		ServiceTracker<GroupUserUserPersistence, GroupUserUserPersistence>
			serviceTracker =
				new ServiceTracker
					<GroupUserUserPersistence, GroupUserUserPersistence>(
						bundle.getBundleContext(),
						GroupUserUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}