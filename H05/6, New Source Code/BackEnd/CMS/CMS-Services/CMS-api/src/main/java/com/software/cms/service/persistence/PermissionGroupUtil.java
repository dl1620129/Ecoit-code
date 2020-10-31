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

import com.software.cms.model.PermissionGroup;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the permission group service. This utility wraps <code>com.software.cms.service.persistence.impl.PermissionGroupPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
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
	 * Returns all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @return the matching permission groups
	 */
	public static List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid) {

		return getPersistence().findByGroup_GroupUser(groupId, groupuserid);
	}

	/**
	 * Returns a range of all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of matching permission groups
	 */
	public static List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid, int start, int end) {

		return getPersistence().findByGroup_GroupUser(
			groupId, groupuserid, start, end);
	}

	/**
	 * Returns an ordered range of all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission groups
	 */
	public static List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().findByGroup_GroupUser(
			groupId, groupuserid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission groups
	 */
	public static List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup_GroupUser(
			groupId, groupuserid, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	public static PermissionGroup findByGroup_GroupUser_First(
			long groupId, long groupuserid,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws com.software.cms.exception.NoSuchPermissionGroupException {

		return getPersistence().findByGroup_GroupUser_First(
			groupId, groupuserid, orderByComparator);
	}

	/**
	 * Returns the first permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	public static PermissionGroup fetchByGroup_GroupUser_First(
		long groupId, long groupuserid,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().fetchByGroup_GroupUser_First(
			groupId, groupuserid, orderByComparator);
	}

	/**
	 * Returns the last permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	public static PermissionGroup findByGroup_GroupUser_Last(
			long groupId, long groupuserid,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws com.software.cms.exception.NoSuchPermissionGroupException {

		return getPersistence().findByGroup_GroupUser_Last(
			groupId, groupuserid, orderByComparator);
	}

	/**
	 * Returns the last permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	public static PermissionGroup fetchByGroup_GroupUser_Last(
		long groupId, long groupuserid,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return getPersistence().fetchByGroup_GroupUser_Last(
			groupId, groupuserid, orderByComparator);
	}

	/**
	 * Returns the permission groups before and after the current permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param permissionGroupPK the primary key of the current permission group
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public static PermissionGroup[] findByGroup_GroupUser_PrevAndNext(
			PermissionGroupPK permissionGroupPK, long groupId, long groupuserid,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws com.software.cms.exception.NoSuchPermissionGroupException {

		return getPersistence().findByGroup_GroupUser_PrevAndNext(
			permissionGroupPK, groupId, groupuserid, orderByComparator);
	}

	/**
	 * Removes all the permission groups where groupId = &#63; and groupuserid = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 */
	public static void removeByGroup_GroupUser(long groupId, long groupuserid) {
		getPersistence().removeByGroup_GroupUser(groupId, groupuserid);
	}

	/**
	 * Returns the number of permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @return the number of matching permission groups
	 */
	public static int countByGroup_GroupUser(long groupId, long groupuserid) {
		return getPersistence().countByGroup_GroupUser(groupId, groupuserid);
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
		throws com.software.cms.exception.NoSuchPermissionGroupException {

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
		throws com.software.cms.exception.NoSuchPermissionGroupException {

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