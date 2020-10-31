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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.software.cms.exception.NoSuchMapCateLayoutException;
import com.software.cms.model.MapCateLayout;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the map cate layout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see MapCateLayoutUtil
 * @generated
 */
@ProviderType
public interface MapCateLayoutPersistence
	extends BasePersistence<MapCateLayout> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MapCateLayoutUtil} to access the map cate layout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the map cate layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching map cate layouts
	 */
	public java.util.List<MapCateLayout> findByUuid(String uuid);

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
	public java.util.List<MapCateLayout> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MapCateLayout> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public java.util.List<MapCateLayout> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public MapCateLayout[] findByUuid_PrevAndNext(
			long mapCateLayoutId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Removes all the map cate layouts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of map cate layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching map cate layouts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByUUID_G(String uuid, long groupId)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the map cate layout where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the map cate layout that was removed
	 */
	public MapCateLayout removeByUUID_G(String uuid, long groupId)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the number of map cate layouts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching map cate layouts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching map cate layouts
	 */
	public java.util.List<MapCateLayout> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public java.util.List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public MapCateLayout[] findByUuid_C_PrevAndNext(
			long mapCateLayoutId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Removes all the map cate layouts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching map cate layouts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the map cate layout where categoryId = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByCategoryId(long categoryId)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the map cate layout where categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryId the category ID
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByCategoryId(long categoryId);

	/**
	 * Returns the map cate layout where categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByCategoryId(
		long categoryId, boolean useFinderCache);

	/**
	 * Removes the map cate layout where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @return the map cate layout that was removed
	 */
	public MapCateLayout removeByCategoryId(long categoryId)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the number of map cate layouts where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching map cate layouts
	 */
	public int countByCategoryId(long categoryId);

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByCategoryIdAndType(long categoryId, int type)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByCategoryIdAndType(long categoryId, int type);

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByCategoryIdAndType(
		long categoryId, int type, boolean useFinderCache);

	/**
	 * Removes the map cate layout where categoryId = &#63; and type = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the map cate layout that was removed
	 */
	public MapCateLayout removeByCategoryIdAndType(long categoryId, int type)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the number of map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public int countByCategoryIdAndType(long categoryId, int type);

	/**
	 * Returns all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching map cate layouts
	 */
	public java.util.List<MapCateLayout> findByByType(long groupId, int type);

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
	public java.util.List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end);

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
	public java.util.List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public java.util.List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByByType_First(
			long groupId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the first map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByByType_First(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

	/**
	 * Returns the last map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByByType_Last(
			long groupId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the last map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByByType_Last(
		long groupId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public MapCateLayout[] findByByType_PrevAndNext(
			long mapCateLayoutId, long groupId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Removes all the map cate layouts where groupId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 */
	public void removeByByType(long groupId, int type);

	/**
	 * Returns the number of map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public int countByByType(long groupId, int type);

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByByLayoutIdAndType(long layoutId, int type)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByByLayoutIdAndType(long layoutId, int type);

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByByLayoutIdAndType(
		long layoutId, int type, boolean useFinderCache);

	/**
	 * Removes the map cate layout where layoutId = &#63; and type = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the map cate layout that was removed
	 */
	public MapCateLayout removeByByLayoutIdAndType(long layoutId, int type)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the number of map cate layouts where layoutId = &#63; and type = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public int countByByLayoutIdAndType(long layoutId, int type);

	/**
	 * Returns all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layouts
	 */
	public java.util.List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type);

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
	public java.util.List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end);

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
	public java.util.List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public java.util.List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByCheckCategoryIdAndType_First(
			long categoryId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the first map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByCheckCategoryIdAndType_First(
		long categoryId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

	/**
	 * Returns the last map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	public MapCateLayout findByCheckCategoryIdAndType_Last(
			long categoryId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the last map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public MapCateLayout fetchByCheckCategoryIdAndType_Last(
		long categoryId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public MapCateLayout[] findByCheckCategoryIdAndType_PrevAndNext(
			long mapCateLayoutId, long categoryId, int type,
			com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
				orderByComparator)
		throws NoSuchMapCateLayoutException;

	/**
	 * Removes all the map cate layouts where categoryId = &#63; and type = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 */
	public void removeByCheckCategoryIdAndType(long categoryId, int type);

	/**
	 * Returns the number of map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	public int countByCheckCategoryIdAndType(long categoryId, int type);

	/**
	 * Caches the map cate layout in the entity cache if it is enabled.
	 *
	 * @param mapCateLayout the map cate layout
	 */
	public void cacheResult(MapCateLayout mapCateLayout);

	/**
	 * Caches the map cate layouts in the entity cache if it is enabled.
	 *
	 * @param mapCateLayouts the map cate layouts
	 */
	public void cacheResult(java.util.List<MapCateLayout> mapCateLayouts);

	/**
	 * Creates a new map cate layout with the primary key. Does not add the map cate layout to the database.
	 *
	 * @param mapCateLayoutId the primary key for the new map cate layout
	 * @return the new map cate layout
	 */
	public MapCateLayout create(long mapCateLayoutId);

	/**
	 * Removes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public MapCateLayout remove(long mapCateLayoutId)
		throws NoSuchMapCateLayoutException;

	public MapCateLayout updateImpl(MapCateLayout mapCateLayout);

	/**
	 * Returns the map cate layout with the primary key or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	public MapCateLayout findByPrimaryKey(long mapCateLayoutId)
		throws NoSuchMapCateLayoutException;

	/**
	 * Returns the map cate layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout, or <code>null</code> if a map cate layout with the primary key could not be found
	 */
	public MapCateLayout fetchByPrimaryKey(long mapCateLayoutId);

	/**
	 * Returns all the map cate layouts.
	 *
	 * @return the map cate layouts
	 */
	public java.util.List<MapCateLayout> findAll();

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
	public java.util.List<MapCateLayout> findAll(int start, int end);

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
	public java.util.List<MapCateLayout> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator);

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
	public java.util.List<MapCateLayout> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MapCateLayout>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the map cate layouts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of map cate layouts.
	 *
	 * @return the number of map cate layouts
	 */
	public int countAll();

}