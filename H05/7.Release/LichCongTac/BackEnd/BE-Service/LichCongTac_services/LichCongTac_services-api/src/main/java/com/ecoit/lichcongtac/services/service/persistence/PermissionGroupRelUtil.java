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

import com.ecoit.lichcongtac.services.model.PermissionGroupRel;

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
 * The persistence utility for the permission group rel service. This utility wraps <code>com.ecoit.lichcongtac.services.service.persistence.impl.PermissionGroupRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupRelPersistence
 * @generated
 */
public class PermissionGroupRelUtil {

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
	public static void clearCache(PermissionGroupRel permissionGroupRel) {
		getPersistence().clearCache(permissionGroupRel);
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
	public static Map<Serializable, PermissionGroupRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PermissionGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PermissionGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PermissionGroupRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PermissionGroupRel update(
		PermissionGroupRel permissionGroupRel) {

		return getPersistence().update(permissionGroupRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PermissionGroupRel update(
		PermissionGroupRel permissionGroupRel, ServiceContext serviceContext) {

		return getPersistence().update(permissionGroupRel, serviceContext);
	}

	/**
	 * Returns all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching permission group rels
	 */
	public static List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId) {

		return getPersistence().findByGroup(userPermissionGroupId);
	}

	/**
	 * Returns a range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @return the range of matching permission group rels
	 */
	public static List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return getPersistence().findByGroup(userPermissionGroupId, start, end);
	}

	/**
	 * Returns an ordered range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission group rels
	 */
	public static List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission group rels
	 */
	public static List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup(
			userPermissionGroupId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group rel
	 * @throws NoSuchPermissionGroupRelException if a matching permission group rel could not be found
	 */
	public static PermissionGroupRel findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<PermissionGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchPermissionGroupRelException {

		return getPersistence().findByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the first permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group rel, or <code>null</code> if a matching permission group rel could not be found
	 */
	public static PermissionGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return getPersistence().fetchByGroup_First(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group rel
	 * @throws NoSuchPermissionGroupRelException if a matching permission group rel could not be found
	 */
	public static PermissionGroupRel findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<PermissionGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchPermissionGroupRelException {

		return getPersistence().findByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the last permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group rel, or <code>null</code> if a matching permission group rel could not be found
	 */
	public static PermissionGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return getPersistence().fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);
	}

	/**
	 * Returns the permission group rels before and after the current permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param permissionGroupRelPK the primary key of the current permission group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	public static PermissionGroupRel[] findByGroup_PrevAndNext(
			PermissionGroupRelPK permissionGroupRelPK,
			long userPermissionGroupId,
			OrderByComparator<PermissionGroupRel> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchPermissionGroupRelException {

		return getPersistence().findByGroup_PrevAndNext(
			permissionGroupRelPK, userPermissionGroupId, orderByComparator);
	}

	/**
	 * Removes all the permission group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public static void removeByGroup(long userPermissionGroupId) {
		getPersistence().removeByGroup(userPermissionGroupId);
	}

	/**
	 * Returns the number of permission group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching permission group rels
	 */
	public static int countByGroup(long userPermissionGroupId) {
		return getPersistence().countByGroup(userPermissionGroupId);
	}

	/**
	 * Caches the permission group rel in the entity cache if it is enabled.
	 *
	 * @param permissionGroupRel the permission group rel
	 */
	public static void cacheResult(PermissionGroupRel permissionGroupRel) {
		getPersistence().cacheResult(permissionGroupRel);
	}

	/**
	 * Caches the permission group rels in the entity cache if it is enabled.
	 *
	 * @param permissionGroupRels the permission group rels
	 */
	public static void cacheResult(
		List<PermissionGroupRel> permissionGroupRels) {

		getPersistence().cacheResult(permissionGroupRels);
	}

	/**
	 * Creates a new permission group rel with the primary key. Does not add the permission group rel to the database.
	 *
	 * @param permissionGroupRelPK the primary key for the new permission group rel
	 * @return the new permission group rel
	 */
	public static PermissionGroupRel create(
		PermissionGroupRelPK permissionGroupRelPK) {

		return getPersistence().create(permissionGroupRelPK);
	}

	/**
	 * Removes the permission group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel that was removed
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	public static PermissionGroupRel remove(
			PermissionGroupRelPK permissionGroupRelPK)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchPermissionGroupRelException {

		return getPersistence().remove(permissionGroupRelPK);
	}

	public static PermissionGroupRel updateImpl(
		PermissionGroupRel permissionGroupRel) {

		return getPersistence().updateImpl(permissionGroupRel);
	}

	/**
	 * Returns the permission group rel with the primary key or throws a <code>NoSuchPermissionGroupRelException</code> if it could not be found.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	public static PermissionGroupRel findByPrimaryKey(
			PermissionGroupRelPK permissionGroupRelPK)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchPermissionGroupRelException {

		return getPersistence().findByPrimaryKey(permissionGroupRelPK);
	}

	/**
	 * Returns the permission group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel, or <code>null</code> if a permission group rel with the primary key could not be found
	 */
	public static PermissionGroupRel fetchByPrimaryKey(
		PermissionGroupRelPK permissionGroupRelPK) {

		return getPersistence().fetchByPrimaryKey(permissionGroupRelPK);
	}

	/**
	 * Returns all the permission group rels.
	 *
	 * @return the permission group rels
	 */
	public static List<PermissionGroupRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @return the range of permission group rels
	 */
	public static List<PermissionGroupRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission group rels
	 */
	public static List<PermissionGroupRel> findAll(
		int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission group rels
	 */
	public static List<PermissionGroupRel> findAll(
		int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the permission group rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of permission group rels.
	 *
	 * @return the number of permission group rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static PermissionGroupRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PermissionGroupRelPersistence, PermissionGroupRelPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PermissionGroupRelPersistence.class);

		ServiceTracker
			<PermissionGroupRelPersistence, PermissionGroupRelPersistence>
				serviceTracker =
					new ServiceTracker
						<PermissionGroupRelPersistence,
						 PermissionGroupRelPersistence>(
							 bundle.getBundleContext(),
							 PermissionGroupRelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}