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

package com.ecoit.lichcongtac.services.service.persistence;

import com.ecoit.lichcongtac.services.model.UserGroupRel;

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
 * The persistence utility for the user group rel service. This utility wraps <code>com.ecoit.lichcongtac.services.service.persistence.impl.UserGroupRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRelPersistence
 * @generated
 */
public class UserGroupRelUtil {

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
	public static void clearCache(UserGroupRel userGroupRel) {
		getPersistence().clearCache(userGroupRel);
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
	public static Map<Serializable, UserGroupRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserGroupRel update(UserGroupRel userGroupRel) {
		return getPersistence().update(userGroupRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserGroupRel update(
		UserGroupRel userGroupRel, ServiceContext serviceContext) {

		return getPersistence().update(userGroupRel, serviceContext);
	}

	/**
	 * Returns all the user group rels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user group rels
	 */
	public static List<UserGroupRel> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns a range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of matching user group rels
	 */
	public static List<UserGroupRel> findByUser(
		long userId, int start, int end) {

		return getPersistence().findByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group rels
	 */
	public static List<UserGroupRel> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user group rels
	 */
	public static List<UserGroupRel> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public static UserGroupRel findByUser_First(
			long userId, OrderByComparator<UserGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public static UserGroupRel fetchByUser_First(
		long userId, OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public static UserGroupRel findByUser_Last(
			long userId, OrderByComparator<UserGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public static UserGroupRel fetchByUser_Last(
		long userId, OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user group rels before and after the current user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userGroupRelPK the primary key of the current user group rel
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public static UserGroupRel[] findByUser_PrevAndNext(
			UserGroupRelPK userGroupRelPK, long userId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByUser_PrevAndNext(
			userGroupRelPK, userId, orderByComparator);
	}

	/**
	 * Removes all the user group rels where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of user group rels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user group rels
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Returns all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching user group rels
	 */
	public static List<UserGroupRel> findByGroup(long userPermissionGroupId) {
		return getPersistence().findByGroup(userPermissionGroupId);
	}

	/**
	 * Returns a range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of matching user group rels
	 */
	public static List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return getPersistence().findByGroup(userPermissionGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group rels
	 */
	public static List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user group rels
	 */
	public static List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public static UserGroupRel findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the first user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public static UserGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().fetchByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public static UserGroupRel findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public static UserGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the user group rels before and after the current user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userGroupRelPK the primary key of the current user group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public static UserGroupRel[] findByGroup_PrevAndNext(
			UserGroupRelPK userGroupRelPK, long userPermissionGroupId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByGroup_PrevAndNext(
			userGroupRelPK, userPermissionGroupId, orderByComparator);
	}

	/**
	 * Removes all the user group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public static void removeByGroup(long userPermissionGroupId) {
		getPersistence().removeByGroup(userPermissionGroupId);
	}

	/**
	 * Returns the number of user group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching user group rels
	 */
	public static int countByGroup(long userPermissionGroupId) {
		return getPersistence().countByGroup(userPermissionGroupId);
	}

	/**
	 * Caches the user group rel in the entity cache if it is enabled.
	 *
	 * @param userGroupRel the user group rel
	 */
	public static void cacheResult(UserGroupRel userGroupRel) {
		getPersistence().cacheResult(userGroupRel);
	}

	/**
	 * Caches the user group rels in the entity cache if it is enabled.
	 *
	 * @param userGroupRels the user group rels
	 */
	public static void cacheResult(List<UserGroupRel> userGroupRels) {
		getPersistence().cacheResult(userGroupRels);
	}

	/**
	 * Creates a new user group rel with the primary key. Does not add the user group rel to the database.
	 *
	 * @param userGroupRelPK the primary key for the new user group rel
	 * @return the new user group rel
	 */
	public static UserGroupRel create(UserGroupRelPK userGroupRelPK) {
		return getPersistence().create(userGroupRelPK);
	}

	/**
	 * Removes the user group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel that was removed
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public static UserGroupRel remove(UserGroupRelPK userGroupRelPK)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().remove(userGroupRelPK);
	}

	public static UserGroupRel updateImpl(UserGroupRel userGroupRel) {
		return getPersistence().updateImpl(userGroupRel);
	}

	/**
	 * Returns the user group rel with the primary key or throws a <code>NoSuchUserGroupRelException</code> if it could not be found.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public static UserGroupRel findByPrimaryKey(UserGroupRelPK userGroupRelPK)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchUserGroupRelException {

		return getPersistence().findByPrimaryKey(userGroupRelPK);
	}

	/**
	 * Returns the user group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel, or <code>null</code> if a user group rel with the primary key could not be found
	 */
	public static UserGroupRel fetchByPrimaryKey(
		UserGroupRelPK userGroupRelPK) {

		return getPersistence().fetchByPrimaryKey(userGroupRelPK);
	}

	/**
	 * Returns all the user group rels.
	 *
	 * @return the user group rels
	 */
	public static List<UserGroupRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of user group rels
	 */
	public static List<UserGroupRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user group rels
	 */
	public static List<UserGroupRel> findAll(
		int start, int end, OrderByComparator<UserGroupRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user group rels
	 */
	public static List<UserGroupRel> findAll(
		int start, int end, OrderByComparator<UserGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user group rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user group rels.
	 *
	 * @return the number of user group rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserGroupRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserGroupRelPersistence, UserGroupRelPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserGroupRelPersistence.class);

		ServiceTracker<UserGroupRelPersistence, UserGroupRelPersistence>
			serviceTracker =
				new ServiceTracker
					<UserGroupRelPersistence, UserGroupRelPersistence>(
						bundle.getBundleContext(),
						UserGroupRelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}