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

import com.ecoit.mr.model.UserPermissionGroup;

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
 * The persistence utility for the user permission group service. This utility wraps <code>com.ecoit.mr.service.persistence.impl.UserPermissionGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPermissionGroupPersistence
 * @generated
 */
public class UserPermissionGroupUtil {

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
	public static void clearCache(UserPermissionGroup userPermissionGroup) {
		getPersistence().clearCache(userPermissionGroup);
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
	public static Map<Serializable, UserPermissionGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserPermissionGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPermissionGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPermissionGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserPermissionGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserPermissionGroup update(
		UserPermissionGroup userPermissionGroup) {

		return getPersistence().update(userPermissionGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserPermissionGroup update(
		UserPermissionGroup userPermissionGroup,
		ServiceContext serviceContext) {

		return getPersistence().update(userPermissionGroup, serviceContext);
	}

	/**
	 * Caches the user permission group in the entity cache if it is enabled.
	 *
	 * @param userPermissionGroup the user permission group
	 */
	public static void cacheResult(UserPermissionGroup userPermissionGroup) {
		getPersistence().cacheResult(userPermissionGroup);
	}

	/**
	 * Caches the user permission groups in the entity cache if it is enabled.
	 *
	 * @param userPermissionGroups the user permission groups
	 */
	public static void cacheResult(
		List<UserPermissionGroup> userPermissionGroups) {

		getPersistence().cacheResult(userPermissionGroups);
	}

	/**
	 * Creates a new user permission group with the primary key. Does not add the user permission group to the database.
	 *
	 * @param userPermissionGroupId the primary key for the new user permission group
	 * @return the new user permission group
	 */
	public static UserPermissionGroup create(long userPermissionGroupId) {
		return getPersistence().create(userPermissionGroupId);
	}

	/**
	 * Removes the user permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group that was removed
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	public static UserPermissionGroup remove(long userPermissionGroupId)
		throws com.ecoit.mr.exception.NoSuchUserPermissionGroupException {

		return getPersistence().remove(userPermissionGroupId);
	}

	public static UserPermissionGroup updateImpl(
		UserPermissionGroup userPermissionGroup) {

		return getPersistence().updateImpl(userPermissionGroup);
	}

	/**
	 * Returns the user permission group with the primary key or throws a <code>NoSuchUserPermissionGroupException</code> if it could not be found.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	public static UserPermissionGroup findByPrimaryKey(
			long userPermissionGroupId)
		throws com.ecoit.mr.exception.NoSuchUserPermissionGroupException {

		return getPersistence().findByPrimaryKey(userPermissionGroupId);
	}

	/**
	 * Returns the user permission group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group, or <code>null</code> if a user permission group with the primary key could not be found
	 */
	public static UserPermissionGroup fetchByPrimaryKey(
		long userPermissionGroupId) {

		return getPersistence().fetchByPrimaryKey(userPermissionGroupId);
	}

	/**
	 * Returns all the user permission groups.
	 *
	 * @return the user permission groups
	 */
	public static List<UserPermissionGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @return the range of user permission groups
	 */
	public static List<UserPermissionGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user permission groups
	 */
	public static List<UserPermissionGroup> findAll(
		int start, int end,
		OrderByComparator<UserPermissionGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user permission groups
	 */
	public static List<UserPermissionGroup> findAll(
		int start, int end,
		OrderByComparator<UserPermissionGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user permission groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user permission groups.
	 *
	 * @return the number of user permission groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserPermissionGroupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPermissionGroupPersistence, UserPermissionGroupPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserPermissionGroupPersistence.class);

		ServiceTracker
			<UserPermissionGroupPersistence, UserPermissionGroupPersistence>
				serviceTracker =
					new ServiceTracker
						<UserPermissionGroupPersistence,
						 UserPermissionGroupPersistence>(
							 bundle.getBundleContext(),
							 UserPermissionGroupPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}