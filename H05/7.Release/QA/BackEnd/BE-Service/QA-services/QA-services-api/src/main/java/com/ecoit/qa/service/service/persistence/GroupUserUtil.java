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

import com.ecoit.qa.service.model.GroupUser;

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
 * The persistence utility for the group user service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.GroupUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserPersistence
 * @generated
 */
public class GroupUserUtil {

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
	public static void clearCache(GroupUser groupUser) {
		getPersistence().clearCache(groupUser);
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
	public static Map<Serializable, GroupUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupUser update(GroupUser groupUser) {
		return getPersistence().update(groupUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupUser update(
		GroupUser groupUser, ServiceContext serviceContext) {

		return getPersistence().update(groupUser, serviceContext);
	}

	/**
	 * Caches the group user in the entity cache if it is enabled.
	 *
	 * @param groupUser the group user
	 */
	public static void cacheResult(GroupUser groupUser) {
		getPersistence().cacheResult(groupUser);
	}

	/**
	 * Caches the group users in the entity cache if it is enabled.
	 *
	 * @param groupUsers the group users
	 */
	public static void cacheResult(List<GroupUser> groupUsers) {
		getPersistence().cacheResult(groupUsers);
	}

	/**
	 * Creates a new group user with the primary key. Does not add the group user to the database.
	 *
	 * @param groupUserId the primary key for the new group user
	 * @return the new group user
	 */
	public static GroupUser create(long groupUserId) {
		return getPersistence().create(groupUserId);
	}

	/**
	 * Removes the group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user that was removed
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	public static GroupUser remove(long groupUserId)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserException {

		return getPersistence().remove(groupUserId);
	}

	public static GroupUser updateImpl(GroupUser groupUser) {
		return getPersistence().updateImpl(groupUser);
	}

	/**
	 * Returns the group user with the primary key or throws a <code>NoSuchGroupUserException</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	public static GroupUser findByPrimaryKey(long groupUserId)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserException {

		return getPersistence().findByPrimaryKey(groupUserId);
	}

	/**
	 * Returns the group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user, or <code>null</code> if a group user with the primary key could not be found
	 */
	public static GroupUser fetchByPrimaryKey(long groupUserId) {
		return getPersistence().fetchByPrimaryKey(groupUserId);
	}

	/**
	 * Returns all the group users.
	 *
	 * @return the group users
	 */
	public static List<GroupUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @return the range of group users
	 */
	public static List<GroupUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group users
	 */
	public static List<GroupUser> findAll(
		int start, int end, OrderByComparator<GroupUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group users
	 */
	public static List<GroupUser> findAll(
		int start, int end, OrderByComparator<GroupUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group users.
	 *
	 * @return the number of group users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GroupUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroupUserPersistence, GroupUserPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupUserPersistence.class);

		ServiceTracker<GroupUserPersistence, GroupUserPersistence>
			serviceTracker =
				new ServiceTracker<GroupUserPersistence, GroupUserPersistence>(
					bundle.getBundleContext(), GroupUserPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}