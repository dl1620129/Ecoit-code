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

import com.ecoit.mr.model.PermissionGroup;

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
 * The persistence utility for the permission group service. This utility wraps <code>com.ecoit.mr.service.persistence.impl.PermissionGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupPersistence
 * @generated
 */
public class PermissionGroupUtil {

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
	public static void clearCache(PermissionGroup permissionGroup) {
		getPersistence().clearCache(permissionGroup);
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
	public static Map<Serializable, PermissionGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PermissionGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PermissionGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PermissionGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PermissionGroup update(PermissionGroup permissionGroup) {
		return getPersistence().update(permissionGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PermissionGroup update(
		PermissionGroup permissionGroup, ServiceContext serviceContext) {

		return getPersistence().update(permissionGroup, serviceContext);
	}

	/**
	 * Returns all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching permission groups
	 */
	public static List<PermissionGroup> findByGroup(
		long userPermissionGroupId) {

		return getPersistence().findByGroup(userPermissionGroupId);
	}

	/**
	 * Returns a range of all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of matching permission groups
	 */
	public static List<PermissionGroup> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return getPersistence().findByGroup(userPermissionGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission groups
	 */
	public static List<PermissionGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission groups
	 */
	public static List<PermissionGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	public static PermissionGroup findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchPermissionGroupException {

		return getPersistence().findByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the first permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	public static PermissionGroup fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().fetchByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	public static PermissionGroup findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchPermissionGroupException {

		return getPersistence().findByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	public static PermissionGroup fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the permission groups before and after the current permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param permissionGroupPK the primary key of the current permission group
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public static PermissionGroup[] findByGroup_PrevAndNext(
			PermissionGroupPK permissionGroupPK, long userPermissionGroupId,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws com.ecoit.mr.exception.NoSuchPermissionGroupException {

		return getPersistence().findByGroup_PrevAndNext(
			permissionGroupPK, userPermissionGroupId, orderByComparator);
	}

	/**
	 * Removes all the permission groups where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public static void removeByGroup(long userPermissionGroupId) {
		getPersistence().removeByGroup(userPermissionGroupId);
	}

	/**
	 * Returns the number of permission groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching permission groups
	 */
	public static int countByGroup(long userPermissionGroupId) {
		return getPersistence().countByGroup(userPermissionGroupId);
	}

	/**
	 * Caches the permission group in the entity cache if it is enabled.
	 *
	 * @param permissionGroup the permission group
	 */
	public static void cacheResult(PermissionGroup permissionGroup) {
		getPersistence().cacheResult(permissionGroup);
	}

	/**
	 * Caches the permission groups in the entity cache if it is enabled.
	 *
	 * @param permissionGroups the permission groups
	 */
	public static void cacheResult(List<PermissionGroup> permissionGroups) {
		getPersistence().cacheResult(permissionGroups);
	}

	/**
	 * Creates a new permission group with the primary key. Does not add the permission group to the database.
	 *
	 * @param permissionGroupPK the primary key for the new permission group
	 * @return the new permission group
	 */
	public static PermissionGroup create(PermissionGroupPK permissionGroupPK) {
		return getPersistence().create(permissionGroupPK);
	}

	/**
	 * Removes the permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group that was removed
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public static PermissionGroup remove(PermissionGroupPK permissionGroupPK)
		throws com.ecoit.mr.exception.NoSuchPermissionGroupException {

		return getPersistence().remove(permissionGroupPK);
	}

	public static PermissionGroup updateImpl(PermissionGroup permissionGroup) {
		return getPersistence().updateImpl(permissionGroup);
	}

	/**
	 * Returns the permission group with the primary key or throws a <code>NoSuchPermissionGroupException</code> if it could not be found.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public static PermissionGroup findByPrimaryKey(
			PermissionGroupPK permissionGroupPK)
		throws com.ecoit.mr.exception.NoSuchPermissionGroupException {

		return getPersistence().findByPrimaryKey(permissionGroupPK);
	}

	/**
	 * Returns the permission group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group, or <code>null</code> if a permission group with the primary key could not be found
	 */
	public static PermissionGroup fetchByPrimaryKey(
		PermissionGroupPK permissionGroupPK) {

		return getPersistence().fetchByPrimaryKey(permissionGroupPK);
	}

	/**
	 * Returns all the permission groups.
	 *
	 * @return the permission groups
	 */
	public static List<PermissionGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of permission groups
	 */
	public static List<PermissionGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission groups
	 */
	public static List<PermissionGroup> findAll(
		int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission groups
	 */
	public static List<PermissionGroup> findAll(
		int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the permission groups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of permission groups.
	 *
	 * @return the number of permission groups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PermissionGroupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PermissionGroupPersistence, PermissionGroupPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PermissionGroupPersistence.class);

		ServiceTracker<PermissionGroupPersistence, PermissionGroupPersistence>
			serviceTracker =
				new ServiceTracker
					<PermissionGroupPersistence, PermissionGroupPersistence>(
						bundle.getBundleContext(),
						PermissionGroupPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}