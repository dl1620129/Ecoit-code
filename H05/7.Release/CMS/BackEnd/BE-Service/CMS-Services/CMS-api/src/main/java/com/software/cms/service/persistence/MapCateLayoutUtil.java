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

import com.software.cms.model.MapCateLayout;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the map cate layout service. This utility wraps <code>com.software.cms.service.persistence.impl.MapCateLayoutPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see MapCateLayoutPersistence
 * @generated
 */
public class MapCateLayoutUtil {

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
	public static void clearCache(MapCateLayout mapCateLayout) {
		getPersistence().clearCache(mapCateLayout);
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
	public static Map<Serializable, MapCateLayout> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MapCateLayout> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MapCateLayout> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MapCateLayout> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MapCateLayout update(MapCateLayout mapCateLayout) {
		return getPersistence().update(mapCateLayout);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MapCateLayout update(
		MapCateLayout mapCateLayout, ServiceContext serviceContext) {

		return getPersistence().update(mapCateLayout, serviceContext);
	}

	/**
	 * Returns all the map cate layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the map cate layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByUuid_First(
			String uuid, OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByUuid_First(
		String uuid, OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByUuid_Last(
			String uuid, OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByUuid_Last(
		String uuid, OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout[] findByUuid_PrevAndNext(
			long mapCateLayoutId, String uuid,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUuid_PrevAndNext(
			mapCateLayoutId, uuid, orderByComparator);
	}

	/**
	 * Removes all the map cate layouts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of map cate layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching map cate layouts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the map cate layout where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the map cate layout that was removed
	 */
	public static MapCateLayout removeByUUID_G(String uuid, long groupId)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of map cate layouts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching map cate layouts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout[] findByUuid_C_PrevAndNext(
			long mapCateLayoutId, String uuid, long companyId,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByUuid_C_PrevAndNext(
			mapCateLayoutId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the map cate layouts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching map cate layouts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByCategoryId(long categoryId)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByCategoryId(categoryId);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryId the category ID
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByCategoryId(long categoryId) {
		return getPersistence().fetchByCategoryId(categoryId);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByCategoryId(
		long categoryId, boolean useFinderCache) {

		return getPersistence().fetchByCategoryId(categoryId, useFinderCache);
	}

	/**
	 * Removes the map cate layout where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @return the map cate layout that was removed
	 */
	public static MapCateLayout removeByCategoryId(long categoryId)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().removeByCategoryId(categoryId);
	}

	/**
	 * Returns the number of map cate layouts where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching map cate layouts
	 */
	public static int countByCategoryId(long categoryId) {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByCategoryIdAndType(
			long categoryId, int type)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByCategoryIdAndType(categoryId, type);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByCategoryIdAndType(
		long categoryId, int type) {

		return getPersistence().fetchByCategoryIdAndType(categoryId, type);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByCategoryIdAndType(
		long categoryId, int type, boolean useFinderCache) {

		return getPersistence().fetchByCategoryIdAndType(
			categoryId, type, useFinderCache);
	}

	/**
	 * Removes the map cate layout where categoryId = &#63; and type = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the map cate layout that was removed
	 */
	public static MapCateLayout removeByCategoryIdAndType(
			long categoryId, int type)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().removeByCategoryIdAndType(categoryId, type);
	}

	/**
	 * Returns the number of map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public static int countByCategoryIdAndType(long categoryId, int type) {
		return getPersistence().countByCategoryIdAndType(categoryId, type);
	}

	/**
	 * Returns all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching map cate layouts
	 */
	public static List<MapCateLayout> findByByType(long groupId, int type) {
		return getPersistence().findByByType(groupId, type);
	}

	/**
	 * Returns a range of all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end) {

		return getPersistence().findByByType(groupId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().findByByType(
			groupId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByByType(
			groupId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByByType_First(
			long groupId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByByType_First(
			groupId, type, orderByComparator);
	}

	/**
	 * Returns the first map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByByType_First(
		long groupId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByByType_First(
			groupId, type, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByByType_Last(
			long groupId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByByType_Last(
			groupId, type, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByByType_Last(
		long groupId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByByType_Last(
			groupId, type, orderByComparator);
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout[] findByByType_PrevAndNext(
			long mapCateLayoutId, long groupId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByByType_PrevAndNext(
			mapCateLayoutId, groupId, type, orderByComparator);
	}

	/**
	 * Removes all the map cate layouts where groupId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 */
	public static void removeByByType(long groupId, int type) {
		getPersistence().removeByByType(groupId, type);
	}

	/**
	 * Returns the number of map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public static int countByByType(long groupId, int type) {
		return getPersistence().countByByType(groupId, type);
	}

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByByLayoutIdAndType(long layoutId, int type)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByByLayoutIdAndType(layoutId, type);
	}

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByByLayoutIdAndType(
		long layoutId, int type) {

		return getPersistence().fetchByByLayoutIdAndType(layoutId, type);
	}

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByByLayoutIdAndType(
		long layoutId, int type, boolean useFinderCache) {

		return getPersistence().fetchByByLayoutIdAndType(
			layoutId, type, useFinderCache);
	}

	/**
	 * Removes the map cate layout where layoutId = &#63; and type = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the map cate layout that was removed
	 */
	public static MapCateLayout removeByByLayoutIdAndType(
			long layoutId, int type)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().removeByByLayoutIdAndType(layoutId, type);
	}

	/**
	 * Returns the number of map cate layouts where layoutId = &#63; and type = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public static int countByByLayoutIdAndType(long layoutId, int type) {
		return getPersistence().countByByLayoutIdAndType(layoutId, type);
	}

	/**
	 * Returns all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layouts
	 */
	public static List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type) {

		return getPersistence().findByCheckCategoryIdAndType(categoryId, type);
	}

	/**
	 * Returns a range of all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end) {

		return getPersistence().findByCheckCategoryIdAndType(
			categoryId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().findByCheckCategoryIdAndType(
			categoryId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	public static List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCheckCategoryIdAndType(
			categoryId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByCheckCategoryIdAndType_First(
			long categoryId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByCheckCategoryIdAndType_First(
			categoryId, type, orderByComparator);
	}

	/**
	 * Returns the first map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByCheckCategoryIdAndType_First(
		long categoryId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByCheckCategoryIdAndType_First(
			categoryId, type, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public static MapCateLayout findByCheckCategoryIdAndType_Last(
			long categoryId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByCheckCategoryIdAndType_Last(
			categoryId, type, orderByComparator);
	}

	/**
	 * Returns the last map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static MapCateLayout fetchByCheckCategoryIdAndType_Last(
		long categoryId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().fetchByCheckCategoryIdAndType_Last(
			categoryId, type, orderByComparator);
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout[] findByCheckCategoryIdAndType_PrevAndNext(
			long mapCateLayoutId, long categoryId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByCheckCategoryIdAndType_PrevAndNext(
			mapCateLayoutId, categoryId, type, orderByComparator);
	}

	/**
	 * Removes all the map cate layouts where categoryId = &#63; and type = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 */
	public static void removeByCheckCategoryIdAndType(
		long categoryId, int type) {

		getPersistence().removeByCheckCategoryIdAndType(categoryId, type);
	}

	/**
	 * Returns the number of map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public static int countByCheckCategoryIdAndType(long categoryId, int type) {
		return getPersistence().countByCheckCategoryIdAndType(categoryId, type);
	}

	/**
	 * Caches the map cate layout in the entity cache if it is enabled.
	 *
	 * @param mapCateLayout the map cate layout
	 */
	public static void cacheResult(MapCateLayout mapCateLayout) {
		getPersistence().cacheResult(mapCateLayout);
	}

	/**
	 * Caches the map cate layouts in the entity cache if it is enabled.
	 *
	 * @param mapCateLayouts the map cate layouts
	 */
	public static void cacheResult(List<MapCateLayout> mapCateLayouts) {
		getPersistence().cacheResult(mapCateLayouts);
	}

	/**
	 * Creates a new map cate layout with the primary key. Does not add the map cate layout to the database.
	 *
	 * @param mapCateLayoutId the primary key for the new map cate layout
	 * @return the new map cate layout
	 */
	public static MapCateLayout create(long mapCateLayoutId) {
		return getPersistence().create(mapCateLayoutId);
	}

	/**
	 * Removes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout remove(long mapCateLayoutId)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().remove(mapCateLayoutId);
	}

	public static MapCateLayout updateImpl(MapCateLayout mapCateLayout) {
		return getPersistence().updateImpl(mapCateLayout);
	}

	/**
	 * Returns the map cate layout with the primary key or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout findByPrimaryKey(long mapCateLayoutId)
		throws com.software.cms.exception.NoSuchMapCateLayoutException {

		return getPersistence().findByPrimaryKey(mapCateLayoutId);
	}

	/**
	 * Returns the map cate layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout, or <code>null</code> if a map cate layout with the primary key could not be found
	 */
	public static MapCateLayout fetchByPrimaryKey(long mapCateLayoutId) {
		return getPersistence().fetchByPrimaryKey(mapCateLayoutId);
	}

	/**
	 * Returns all the map cate layouts.
	 *
	 * @return the map cate layouts
	 */
	public static List<MapCateLayout> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of map cate layouts
	 */
	public static List<MapCateLayout> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of map cate layouts
	 */
	public static List<MapCateLayout> findAll(
		int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of map cate layouts
	 */
	public static List<MapCateLayout> findAll(
		int start, int end, OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the map cate layouts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of map cate layouts.
	 *
	 * @return the number of map cate layouts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MapCateLayoutPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MapCateLayoutPersistence, MapCateLayoutPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MapCateLayoutPersistence.class);

		ServiceTracker<MapCateLayoutPersistence, MapCateLayoutPersistence>
			serviceTracker =
				new ServiceTracker
					<MapCateLayoutPersistence, MapCateLayoutPersistence>(
						bundle.getBundleContext(),
						MapCateLayoutPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}