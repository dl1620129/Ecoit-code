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

import com.ecoit.lichcongtac.services.model.ColumnGroupRel;

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
 * The persistence utility for the column group rel service. This utility wraps <code>com.ecoit.lichcongtac.services.service.persistence.impl.ColumnGroupRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelPersistence
 * @generated
 */
public class ColumnGroupRelUtil {

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
	public static void clearCache(ColumnGroupRel columnGroupRel) {
		getPersistence().clearCache(columnGroupRel);
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
	public static Map<Serializable, ColumnGroupRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ColumnGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ColumnGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ColumnGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ColumnGroupRel update(ColumnGroupRel columnGroupRel) {
		return getPersistence().update(columnGroupRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ColumnGroupRel update(
		ColumnGroupRel columnGroupRel, ServiceContext serviceContext) {

		return getPersistence().update(columnGroupRel, serviceContext);
	}

	/**
	 * Returns all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching column group rels
	 */
	public static List<ColumnGroupRel> findByGroup(long userPermissionGroupId) {
		return getPersistence().findByGroup(userPermissionGroupId);
	}

	/**
	 * Returns a range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of matching column group rels
	 */
	public static List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return getPersistence().findByGroup(userPermissionGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column group rels
	 */
	public static List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column group rels
	 */
	public static List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column group rel
	 * @throws NoSuchColumnGroupRelException if a matching column group rel could not be found
	 */
	public static ColumnGroupRel findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<ColumnGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchColumnGroupRelException {

		return getPersistence().findByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the first column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column group rel, or <code>null</code> if a matching column group rel could not be found
	 */
	public static ColumnGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return getPersistence().fetchByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column group rel
	 * @throws NoSuchColumnGroupRelException if a matching column group rel could not be found
	 */
	public static ColumnGroupRel findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<ColumnGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchColumnGroupRelException {

		return getPersistence().findByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column group rel, or <code>null</code> if a matching column group rel could not be found
	 */
	public static ColumnGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return getPersistence().fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the column group rels before and after the current column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param columnGroupRelPK the primary key of the current column group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	public static ColumnGroupRel[] findByGroup_PrevAndNext(
			ColumnGroupRelPK columnGroupRelPK, long userPermissionGroupId,
			OrderByComparator<ColumnGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchColumnGroupRelException {

		return getPersistence().findByGroup_PrevAndNext(
			columnGroupRelPK, userPermissionGroupId, orderByComparator);
	}

	/**
	 * Removes all the column group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public static void removeByGroup(long userPermissionGroupId) {
		getPersistence().removeByGroup(userPermissionGroupId);
	}

	/**
	 * Returns the number of column group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching column group rels
	 */
	public static int countByGroup(long userPermissionGroupId) {
		return getPersistence().countByGroup(userPermissionGroupId);
	}

	/**
	 * Caches the column group rel in the entity cache if it is enabled.
	 *
	 * @param columnGroupRel the column group rel
	 */
	public static void cacheResult(ColumnGroupRel columnGroupRel) {
		getPersistence().cacheResult(columnGroupRel);
	}

	/**
	 * Caches the column group rels in the entity cache if it is enabled.
	 *
	 * @param columnGroupRels the column group rels
	 */
	public static void cacheResult(List<ColumnGroupRel> columnGroupRels) {
		getPersistence().cacheResult(columnGroupRels);
	}

	/**
	 * Creates a new column group rel with the primary key. Does not add the column group rel to the database.
	 *
	 * @param columnGroupRelPK the primary key for the new column group rel
	 * @return the new column group rel
	 */
	public static ColumnGroupRel create(ColumnGroupRelPK columnGroupRelPK) {
		return getPersistence().create(columnGroupRelPK);
	}

	/**
	 * Removes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	public static ColumnGroupRel remove(ColumnGroupRelPK columnGroupRelPK)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchColumnGroupRelException {

		return getPersistence().remove(columnGroupRelPK);
	}

	public static ColumnGroupRel updateImpl(ColumnGroupRel columnGroupRel) {
		return getPersistence().updateImpl(columnGroupRel);
	}

	/**
	 * Returns the column group rel with the primary key or throws a <code>NoSuchColumnGroupRelException</code> if it could not be found.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	public static ColumnGroupRel findByPrimaryKey(
			ColumnGroupRelPK columnGroupRelPK)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchColumnGroupRelException {

		return getPersistence().findByPrimaryKey(columnGroupRelPK);
	}

	/**
	 * Returns the column group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel, or <code>null</code> if a column group rel with the primary key could not be found
	 */
	public static ColumnGroupRel fetchByPrimaryKey(
		ColumnGroupRelPK columnGroupRelPK) {

		return getPersistence().fetchByPrimaryKey(columnGroupRelPK);
	}

	/**
	 * Returns all the column group rels.
	 *
	 * @return the column group rels
	 */
	public static List<ColumnGroupRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of column group rels
	 */
	public static List<ColumnGroupRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of column group rels
	 */
	public static List<ColumnGroupRel> findAll(
		int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of column group rels
	 */
	public static List<ColumnGroupRel> findAll(
		int start, int end, OrderByComparator<ColumnGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the column group rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of column group rels.
	 *
	 * @return the number of column group rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static ColumnGroupRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ColumnGroupRelPersistence, ColumnGroupRelPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ColumnGroupRelPersistence.class);

		ServiceTracker<ColumnGroupRelPersistence, ColumnGroupRelPersistence>
			serviceTracker =
				new ServiceTracker
					<ColumnGroupRelPersistence, ColumnGroupRelPersistence>(
						bundle.getBundleContext(),
						ColumnGroupRelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}