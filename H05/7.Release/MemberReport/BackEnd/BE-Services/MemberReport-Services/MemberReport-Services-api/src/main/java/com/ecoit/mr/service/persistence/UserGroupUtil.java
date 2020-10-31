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

package com.ecoit.mr.service.persistence;

import com.ecoit.mr.model.UserGroup;

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
 * The persistence utility for the user group service. This utility wraps <code>com.ecoit.mr.service.persistence.impl.UserGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupPersistence
 * @generated
 */
public class UserGroupUtil {

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
	public static void clearCache(UserGroup userGroup) {
		getPersistence().clearCache(userGroup);
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
	public static Map<Serializable, UserGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserGroup update(UserGroup userGroup) {
		return getPersistence().update(userGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserGroup update(
		UserGroup userGroup, ServiceContext serviceContext) {

		return getPersistence().update(userGroup, serviceContext);
	}

	/**
	 * Returns all the user groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user groups
	 */
	public static List<UserGroup> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns a range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of matching user groups
	 */
	public static List<UserGroup> findByUser(long userId, int start, int end) {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user groups
	 */
	public static List<UserGroup> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user groups
	 */
	public static List<UserGroup> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public static UserGroup findByUser_First(
			long userId, OrderByComparator<UserGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public static UserGroup fetchByUser_First(
		long userId, OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public static UserGroup findByUser_Last(
			long userId, OrderByComparator<UserGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public static UserGroup fetchByUser_Last(
		long userId, OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user groups before and after the current user group in the ordered set where userId = &#63;.
	 *
	 * @param userGroupPK the primary key of the current user group
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public static UserGroup[] findByUser_PrevAndNext(
			UserGroupPK userGroupPK, long userId,
			OrderByComparator<UserGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByUser_PrevAndNext(
			userGroupPK, userId, orderByComparator);
	}

	/**
	 * Removes all the user groups where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of user groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user groups
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Returns all the user groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching user groups
	 */
	public static List<UserGroup> findByGroup(long userPermissionGroupId) {
		return getPersistence().findByGroup(userPermissionGroupId);
	}

	/**
	 * Returns a range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of matching user groups
	 */
	public static List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return getPersistence().findByGroup(userPermissionGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user groups
	 */
	public static List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user groups
	 */
	public static List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public static UserGroup findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<UserGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the first user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public static UserGroup fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().fetchByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public static UserGroup findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<UserGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public static UserGroup fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the user groups before and after the current user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userGroupPK the primary key of the current user group
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public static UserGroup[] findByGroup_PrevAndNext(
			UserGroupPK userGroupPK, long userPermissionGroupId,
			OrderByComparator<UserGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByGroup_PrevAndNext(
			userGroupPK, userPermissionGroupId, orderByComparator);
	}

	/**
	 * Removes all the user groups where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public static void removeByGroup(long userPermissionGroupId) {
		getPersistence().removeByGroup(userPermissionGroupId);
	}

	/**
	 * Returns the number of user groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching user groups
	 */
	public static int countByGroup(long userPermissionGroupId) {
		return getPersistence().countByGroup(userPermissionGroupId);
	}

	/**
	 * Caches the user group in the entity cache if it is enabled.
	 *
	 * @param userGroup the user group
	 */
	public static void cacheResult(UserGroup userGroup) {
		getPersistence().cacheResult(userGroup);
	}

	/**
	 * Caches the user groups in the entity cache if it is enabled.
	 *
	 * @param userGroups the user groups
	 */
	public static void cacheResult(List<UserGroup> userGroups) {
		getPersistence().cacheResult(userGroups);
	}

	/**
	 * Creates a new user group with the primary key. Does not add the user group to the database.
	 *
	 * @param userGroupPK the primary key for the new user group
	 * @return the new user group
	 */
	public static UserGroup create(UserGroupPK userGroupPK) {
		return getPersistence().create(userGroupPK);
	}

	/**
	 * Removes the user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group that was removed
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public static UserGroup remove(UserGroupPK userGroupPK)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().remove(userGroupPK);
	}

	public static UserGroup updateImpl(UserGroup userGroup) {
		return getPersistence().updateImpl(userGroup);
	}

	/**
	 * Returns the user group with the primary key or throws a <code>NoSuchUserGroupException</code> if it could not be found.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public static UserGroup findByPrimaryKey(UserGroupPK userGroupPK)
		throws com.ecoit.mr.exception.NoSuchUserGroupException {

		return getPersistence().findByPrimaryKey(userGroupPK);
	}

	/**
	 * Returns the user group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group, or <code>null</code> if a user group with the primary key could not be found
	 */
	public static UserGroup fetchByPrimaryKey(UserGroupPK userGroupPK) {
		return getPersistence().fetchByPrimaryKey(userGroupPK);
	}

	/**
	 * Returns all the user groups.
	 *
	 * @return the user groups
	 */
	public static List<UserGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of user groups
	 */
	public static List<UserGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user groups
	 */
	public static List<UserGroup> findAll(
		int start, int end, OrderByComparator<UserGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user groups
	 */
	public static List<UserGroup> findAll(
		int start, int end, OrderByComparator<UserGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user groups.
	 *
	 * @return the number of user groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserGroupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserGroupPersistence, UserGroupPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserGroupPersistence.class);

		ServiceTracker<UserGroupPersistence, UserGroupPersistence>
			serviceTracker =
				new ServiceTracker<UserGroupPersistence, UserGroupPersistence>(
					bundle.getBundleContext(), UserGroupPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}