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

import com.ecoit.qa.service.model.GroupUserPermission;

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
 * The persistence utility for the group user permission service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.GroupUserPermissionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserPermissionPersistence
 * @generated
 */
public class GroupUserPermissionUtil {

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
	public static void clearCache(GroupUserPermission groupUserPermission) {
		getPersistence().clearCache(groupUserPermission);
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
	public static Map<Serializable, GroupUserPermission> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupUserPermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupUserPermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupUserPermission> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupUserPermission update(
		GroupUserPermission groupUserPermission) {

		return getPersistence().update(groupUserPermission);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupUserPermission update(
		GroupUserPermission groupUserPermission,
		ServiceContext serviceContext) {

		return getPersistence().update(groupUserPermission, serviceContext);
	}

	/**
	 * Returns all the group user permissions where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the matching group user permissions
	 */
	public static List<GroupUserPermission> findByPermission(
		long permissionId) {

		return getPersistence().findByPermission(permissionId);
	}

	/**
	 * Returns a range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of matching group user permissions
	 */
	public static List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end) {

		return getPersistence().findByPermission(permissionId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user permissions
	 */
	public static List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().findByPermission(
			permissionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user permissions
	 */
	public static List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPermission(
			permissionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public static GroupUserPermission findByPermission_First(
			long permissionId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByPermission_First(
			permissionId, orderByComparator);
	}

	/**
	 * Returns the first group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public static GroupUserPermission fetchByPermission_First(
		long permissionId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().fetchByPermission_First(
			permissionId, orderByComparator);
	}

	/**
	 * Returns the last group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public static GroupUserPermission findByPermission_Last(
			long permissionId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByPermission_Last(
			permissionId, orderByComparator);
	}

	/**
	 * Returns the last group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public static GroupUserPermission fetchByPermission_Last(
		long permissionId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().fetchByPermission_Last(
			permissionId, orderByComparator);
	}

	/**
	 * Returns the group user permissions before and after the current group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param groupUserPermissionPK the primary key of the current group user permission
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public static GroupUserPermission[] findByPermission_PrevAndNext(
			GroupUserPermissionPK groupUserPermissionPK, long permissionId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByPermission_PrevAndNext(
			groupUserPermissionPK, permissionId, orderByComparator);
	}

	/**
	 * Removes all the group user permissions where permissionId = &#63; from the database.
	 *
	 * @param permissionId the permission ID
	 */
	public static void removeByPermission(long permissionId) {
		getPersistence().removeByPermission(permissionId);
	}

	/**
	 * Returns the number of group user permissions where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the number of matching group user permissions
	 */
	public static int countByPermission(long permissionId) {
		return getPersistence().countByPermission(permissionId);
	}

	/**
	 * Returns all the group user permissions where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user permissions
	 */
	public static List<GroupUserPermission> findByGroupUser(long groupUserId) {
		return getPersistence().findByGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of matching group user permissions
	 */
	public static List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end) {

		return getPersistence().findByGroupUser(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user permissions
	 */
	public static List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user permissions
	 */
	public static List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public static GroupUserPermission findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public static GroupUserPermission fetchByGroupUser_First(
		long groupUserId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public static GroupUserPermission findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public static GroupUserPermission fetchByGroupUser_Last(
		long groupUserId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the group user permissions before and after the current group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserPermissionPK the primary key of the current group user permission
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public static GroupUserPermission[] findByGroupUser_PrevAndNext(
			GroupUserPermissionPK groupUserPermissionPK, long groupUserId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupUserPermissionPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the group user permissions where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeByGroupUser(long groupUserId) {
		getPersistence().removeByGroupUser(groupUserId);
	}

	/**
	 * Returns the number of group user permissions where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user permissions
	 */
	public static int countByGroupUser(long groupUserId) {
		return getPersistence().countByGroupUser(groupUserId);
	}

	/**
	 * Caches the group user permission in the entity cache if it is enabled.
	 *
	 * @param groupUserPermission the group user permission
	 */
	public static void cacheResult(GroupUserPermission groupUserPermission) {
		getPersistence().cacheResult(groupUserPermission);
	}

	/**
	 * Caches the group user permissions in the entity cache if it is enabled.
	 *
	 * @param groupUserPermissions the group user permissions
	 */
	public static void cacheResult(
		List<GroupUserPermission> groupUserPermissions) {

		getPersistence().cacheResult(groupUserPermissions);
	}

	/**
	 * Creates a new group user permission with the primary key. Does not add the group user permission to the database.
	 *
	 * @param groupUserPermissionPK the primary key for the new group user permission
	 * @return the new group user permission
	 */
	public static GroupUserPermission create(
		GroupUserPermissionPK groupUserPermissionPK) {

		return getPersistence().create(groupUserPermissionPK);
	}

	/**
	 * Removes the group user permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission that was removed
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public static GroupUserPermission remove(
			GroupUserPermissionPK groupUserPermissionPK)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().remove(groupUserPermissionPK);
	}

	public static GroupUserPermission updateImpl(
		GroupUserPermission groupUserPermission) {

		return getPersistence().updateImpl(groupUserPermission);
	}

	/**
	 * Returns the group user permission with the primary key or throws a <code>NoSuchGroupUserPermissionException</code> if it could not be found.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public static GroupUserPermission findByPrimaryKey(
			GroupUserPermissionPK groupUserPermissionPK)
		throws com.ecoit.qa.service.exception.
			NoSuchGroupUserPermissionException {

		return getPersistence().findByPrimaryKey(groupUserPermissionPK);
	}

	/**
	 * Returns the group user permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission, or <code>null</code> if a group user permission with the primary key could not be found
	 */
	public static GroupUserPermission fetchByPrimaryKey(
		GroupUserPermissionPK groupUserPermissionPK) {

		return getPersistence().fetchByPrimaryKey(groupUserPermissionPK);
	}

	/**
	 * Returns all the group user permissions.
	 *
	 * @return the group user permissions
	 */
	public static List<GroupUserPermission> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of group user permissions
	 */
	public static List<GroupUserPermission> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user permissions
	 */
	public static List<GroupUserPermission> findAll(
		int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user permissions
	 */
	public static List<GroupUserPermission> findAll(
		int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group user permissions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group user permissions.
	 *
	 * @return the number of group user permissions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupUserPermissionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserPermissionPersistence, GroupUserPermissionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserPermissionPersistence.class);

		ServiceTracker
			<GroupUserPermissionPersistence, GroupUserPermissionPersistence>
				serviceTracker =
					new ServiceTracker
						<GroupUserPermissionPersistence,
						 GroupUserPermissionPersistence>(
							 bundle.getBundleContext(),
							 GroupUserPermissionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}