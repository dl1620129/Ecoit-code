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

import com.ecoit.qa.service.model.GroupUserCategory;

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
 * The persistence utility for the group user category service. This utility wraps <code>com.ecoit.qa.service.service.persistence.impl.GroupUserCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserCategoryPersistence
 * @generated
 */
public class GroupUserCategoryUtil {

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
	public static void clearCache(GroupUserCategory groupUserCategory) {
		getPersistence().clearCache(groupUserCategory);
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
	public static Map<Serializable, GroupUserCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupUserCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupUserCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupUserCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupUserCategory update(
		GroupUserCategory groupUserCategory) {

		return getPersistence().update(groupUserCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupUserCategory update(
		GroupUserCategory groupUserCategory, ServiceContext serviceContext) {

		return getPersistence().update(groupUserCategory, serviceContext);
	}

	/**
	 * Returns all the group user categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching group user categories
	 */
	public static List<GroupUserCategory> findByCategory(long categoryId) {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	 * Returns a range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of matching group user categories
	 */
	public static List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end) {

		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user categories
	 */
	public static List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user categories
	 */
	public static List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public static GroupUserCategory findByCategory_First(
			long categoryId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public static GroupUserCategory fetchByCategory_First(
		long categoryId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public static GroupUserCategory findByCategory_Last(
			long categoryId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public static GroupUserCategory fetchByCategory_Last(
		long categoryId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the group user categories before and after the current group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param groupUserCategoryPK the primary key of the current group user category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public static GroupUserCategory[] findByCategory_PrevAndNext(
			GroupUserCategoryPK groupUserCategoryPK, long categoryId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByCategory_PrevAndNext(
			groupUserCategoryPK, categoryId, orderByComparator);
	}

	/**
	 * Removes all the group user categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategory(long categoryId) {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	 * Returns the number of group user categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching group user categories
	 */
	public static int countByCategory(long categoryId) {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	 * Returns all the group user categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user categories
	 */
	public static List<GroupUserCategory> findByGroupUser(long groupUserId) {
		return getPersistence().findByGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of matching group user categories
	 */
	public static List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end) {

		return getPersistence().findByGroupUser(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user categories
	 */
	public static List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user categories
	 */
	public static List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public static GroupUserCategory findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public static GroupUserCategory fetchByGroupUser_First(
		long groupUserId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public static GroupUserCategory findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public static GroupUserCategory fetchByGroupUser_Last(
		long groupUserId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the group user categories before and after the current group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserCategoryPK the primary key of the current group user category
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public static GroupUserCategory[] findByGroupUser_PrevAndNext(
			GroupUserCategoryPK groupUserCategoryPK, long groupUserId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupUserCategoryPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the group user categories where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeByGroupUser(long groupUserId) {
		getPersistence().removeByGroupUser(groupUserId);
	}

	/**
	 * Returns the number of group user categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user categories
	 */
	public static int countByGroupUser(long groupUserId) {
		return getPersistence().countByGroupUser(groupUserId);
	}

	/**
	 * Caches the group user category in the entity cache if it is enabled.
	 *
	 * @param groupUserCategory the group user category
	 */
	public static void cacheResult(GroupUserCategory groupUserCategory) {
		getPersistence().cacheResult(groupUserCategory);
	}

	/**
	 * Caches the group user categories in the entity cache if it is enabled.
	 *
	 * @param groupUserCategories the group user categories
	 */
	public static void cacheResult(
		List<GroupUserCategory> groupUserCategories) {

		getPersistence().cacheResult(groupUserCategories);
	}

	/**
	 * Creates a new group user category with the primary key. Does not add the group user category to the database.
	 *
	 * @param groupUserCategoryPK the primary key for the new group user category
	 * @return the new group user category
	 */
	public static GroupUserCategory create(
		GroupUserCategoryPK groupUserCategoryPK) {

		return getPersistence().create(groupUserCategoryPK);
	}

	/**
	 * Removes the group user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category that was removed
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public static GroupUserCategory remove(
			GroupUserCategoryPK groupUserCategoryPK)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().remove(groupUserCategoryPK);
	}

	public static GroupUserCategory updateImpl(
		GroupUserCategory groupUserCategory) {

		return getPersistence().updateImpl(groupUserCategory);
	}

	/**
	 * Returns the group user category with the primary key or throws a <code>NoSuchGroupUserCategoryException</code> if it could not be found.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public static GroupUserCategory findByPrimaryKey(
			GroupUserCategoryPK groupUserCategoryPK)
		throws com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException {

		return getPersistence().findByPrimaryKey(groupUserCategoryPK);
	}

	/**
	 * Returns the group user category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category, or <code>null</code> if a group user category with the primary key could not be found
	 */
	public static GroupUserCategory fetchByPrimaryKey(
		GroupUserCategoryPK groupUserCategoryPK) {

		return getPersistence().fetchByPrimaryKey(groupUserCategoryPK);
	}

	/**
	 * Returns all the group user categories.
	 *
	 * @return the group user categories
	 */
	public static List<GroupUserCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of group user categories
	 */
	public static List<GroupUserCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user categories
	 */
	public static List<GroupUserCategory> findAll(
		int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user categories
	 */
	public static List<GroupUserCategory> findAll(
		int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group user categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group user categories.
	 *
	 * @return the number of group user categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupUserCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserCategoryPersistence, GroupUserCategoryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserCategoryPersistence.class);

		ServiceTracker
			<GroupUserCategoryPersistence, GroupUserCategoryPersistence>
				serviceTracker =
					new ServiceTracker
						<GroupUserCategoryPersistence,
						 GroupUserCategoryPersistence>(
							 bundle.getBundleContext(),
							 GroupUserCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}