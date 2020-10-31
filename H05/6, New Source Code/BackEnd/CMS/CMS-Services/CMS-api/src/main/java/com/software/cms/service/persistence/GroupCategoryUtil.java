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

import com.software.cms.model.GroupCategory;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the group category service. This utility wraps <code>com.software.cms.service.persistence.impl.GroupCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see GroupCategoryPersistence
 * @generated
 */
public class GroupCategoryUtil {

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
	public static void clearCache(GroupCategory groupCategory) {
		getPersistence().clearCache(groupCategory);
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
	public static Map<Serializable, GroupCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupCategory update(GroupCategory groupCategory) {
		return getPersistence().update(groupCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupCategory update(
		GroupCategory groupCategory, ServiceContext serviceContext) {

		return getPersistence().update(groupCategory, serviceContext);
	}

	/**
	 * Returns all the group categories where groupuserid = &#63;.
	 *
	 * @param groupuserid the groupuserid
	 * @return the matching group categories
	 */
	public static List<GroupCategory> findByGroupUser(long groupuserid) {
		return getPersistence().findByGroupUser(groupuserid);
	}

	/**
	 * Returns a range of all the group categories where groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of matching group categories
	 */
	public static List<GroupCategory> findByGroupUser(
		long groupuserid, int start, int end) {

		return getPersistence().findByGroupUser(groupuserid, start, end);
	}

	/**
	 * Returns an ordered range of all the group categories where groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group categories
	 */
	public static List<GroupCategory> findByGroupUser(
		long groupuserid, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupuserid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group categories where groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group categories
	 */
	public static List<GroupCategory> findByGroupUser(
		long groupuserid, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupuserid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group category in the ordered set where groupuserid = &#63;.
	 *
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public static GroupCategory findByGroupUser_First(
			long groupuserid,
			OrderByComparator<GroupCategory> orderByComparator)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByGroupUser_First(
			groupuserid, orderByComparator);
	}

	/**
	 * Returns the first group category in the ordered set where groupuserid = &#63;.
	 *
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public static GroupCategory fetchByGroupUser_First(
		long groupuserid, OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupuserid, orderByComparator);
	}

	/**
	 * Returns the last group category in the ordered set where groupuserid = &#63;.
	 *
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public static GroupCategory findByGroupUser_Last(
			long groupuserid,
			OrderByComparator<GroupCategory> orderByComparator)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByGroupUser_Last(
			groupuserid, orderByComparator);
	}

	/**
	 * Returns the last group category in the ordered set where groupuserid = &#63;.
	 *
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public static GroupCategory fetchByGroupUser_Last(
		long groupuserid, OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupuserid, orderByComparator);
	}

	/**
	 * Returns the group categories before and after the current group category in the ordered set where groupuserid = &#63;.
	 *
	 * @param groupCategoryPK the primary key of the current group category
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public static GroupCategory[] findByGroupUser_PrevAndNext(
			GroupCategoryPK groupCategoryPK, long groupuserid,
			OrderByComparator<GroupCategory> orderByComparator)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupCategoryPK, groupuserid, orderByComparator);
	}

	/**
	 * Removes all the group categories where groupuserid = &#63; from the database.
	 *
	 * @param groupuserid the groupuserid
	 */
	public static void removeByGroupUser(long groupuserid) {
		getPersistence().removeByGroupUser(groupuserid);
	}

	/**
	 * Returns the number of group categories where groupuserid = &#63;.
	 *
	 * @param groupuserid the groupuserid
	 * @return the number of matching group categories
	 */
	public static int countByGroupUser(long groupuserid) {
		return getPersistence().countByGroupUser(groupuserid);
	}

	/**
	 * Returns all the group categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching group categories
	 */
	public static List<GroupCategory> findByCategory(long categoryId) {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	 * Returns a range of all the group categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of matching group categories
	 */
	public static List<GroupCategory> findByCategory(
		long categoryId, int start, int end) {

		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the group categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group categories
	 */
	public static List<GroupCategory> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group categories
	 */
	public static List<GroupCategory> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public static GroupCategory findByCategory_First(
			long categoryId, OrderByComparator<GroupCategory> orderByComparator)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first group category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public static GroupCategory fetchByCategory_First(
		long categoryId, OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last group category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public static GroupCategory findByCategory_Last(
			long categoryId, OrderByComparator<GroupCategory> orderByComparator)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last group category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public static GroupCategory fetchByCategory_Last(
		long categoryId, OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the group categories before and after the current group category in the ordered set where categoryId = &#63;.
	 *
	 * @param groupCategoryPK the primary key of the current group category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public static GroupCategory[] findByCategory_PrevAndNext(
			GroupCategoryPK groupCategoryPK, long categoryId,
			OrderByComparator<GroupCategory> orderByComparator)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByCategory_PrevAndNext(
			groupCategoryPK, categoryId, orderByComparator);
	}

	/**
	 * Removes all the group categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategory(long categoryId) {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	 * Returns the number of group categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching group categories
	 */
	public static int countByCategory(long categoryId) {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	 * Caches the group category in the entity cache if it is enabled.
	 *
	 * @param groupCategory the group category
	 */
	public static void cacheResult(GroupCategory groupCategory) {
		getPersistence().cacheResult(groupCategory);
	}

	/**
	 * Caches the group categories in the entity cache if it is enabled.
	 *
	 * @param groupCategories the group categories
	 */
	public static void cacheResult(List<GroupCategory> groupCategories) {
		getPersistence().cacheResult(groupCategories);
	}

	/**
	 * Creates a new group category with the primary key. Does not add the group category to the database.
	 *
	 * @param groupCategoryPK the primary key for the new group category
	 * @return the new group category
	 */
	public static GroupCategory create(GroupCategoryPK groupCategoryPK) {
		return getPersistence().create(groupCategoryPK);
	}

	/**
	 * Removes the group category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category that was removed
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public static GroupCategory remove(GroupCategoryPK groupCategoryPK)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().remove(groupCategoryPK);
	}

	public static GroupCategory updateImpl(GroupCategory groupCategory) {
		return getPersistence().updateImpl(groupCategory);
	}

	/**
	 * Returns the group category with the primary key or throws a <code>NoSuchGroupCategoryException</code> if it could not be found.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public static GroupCategory findByPrimaryKey(
			GroupCategoryPK groupCategoryPK)
		throws com.software.cms.exception.NoSuchGroupCategoryException {

		return getPersistence().findByPrimaryKey(groupCategoryPK);
	}

	/**
	 * Returns the group category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category, or <code>null</code> if a group category with the primary key could not be found
	 */
	public static GroupCategory fetchByPrimaryKey(
		GroupCategoryPK groupCategoryPK) {

		return getPersistence().fetchByPrimaryKey(groupCategoryPK);
	}

	/**
	 * Returns all the group categories.
	 *
	 * @return the group categories
	 */
	public static List<GroupCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of group categories
	 */
	public static List<GroupCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group categories
	 */
	public static List<GroupCategory> findAll(
		int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group categories
	 */
	public static List<GroupCategory> findAll(
		int start, int end, OrderByComparator<GroupCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group categories.
	 *
	 * @return the number of group categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupCategoryPersistence, GroupCategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupCategoryPersistence.class);

		ServiceTracker<GroupCategoryPersistence, GroupCategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<GroupCategoryPersistence, GroupCategoryPersistence>(
						bundle.getBundleContext(),
						GroupCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}