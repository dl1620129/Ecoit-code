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

package com.web.ecoit.portal.quangcao.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.web.ecoit.portal.quangcao.model.QuangCaoSlider;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the quang cao slider service. This utility wraps <code>com.web.ecoit.portal.quangcao.service.persistence.impl.QuangCaoSliderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoSliderPersistence
 * @generated
 */
@ProviderType
public class QuangCaoSliderUtil {

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
	public static void clearCache(QuangCaoSlider quangCaoSlider) {
		getPersistence().clearCache(quangCaoSlider);
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
	public static Map<Serializable, QuangCaoSlider> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuangCaoSlider> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuangCaoSlider> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuangCaoSlider> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuangCaoSlider update(QuangCaoSlider quangCaoSlider) {
		return getPersistence().update(quangCaoSlider);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuangCaoSlider update(
		QuangCaoSlider quangCaoSlider, ServiceContext serviceContext) {

		return getPersistence().update(quangCaoSlider, serviceContext);
	}

	/**
	 * Returns all the quang cao sliders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching quang cao sliders
	 */
	public static List<QuangCaoSlider> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of matching quang cao sliders
	 */
	public static List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang cao sliders
	 */
	@Deprecated
	public static List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang cao sliders
	 */
	public static List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider findByUuid_First(
			String uuid, OrderByComparator<QuangCaoSlider> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider fetchByUuid_First(
		String uuid, OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider findByUuid_Last(
			String uuid, OrderByComparator<QuangCaoSlider> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider fetchByUuid_Last(
		String uuid, OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the quang cao sliders before and after the current quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param quangCaoSliderId the primary key of the current quang cao slider
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public static QuangCaoSlider[] findByUuid_PrevAndNext(
			long quangCaoSliderId, String uuid,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findByUuid_PrevAndNext(
			quangCaoSliderId, uuid, orderByComparator);
	}

	/**
	 * Removes all the quang cao sliders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of quang cao sliders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching quang cao sliders
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider findByUUID_G(String uuid, long groupId)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Deprecated
	public static QuangCaoSlider fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the quang cao slider where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the quang cao slider that was removed
	 */
	public static QuangCaoSlider removeByUUID_G(String uuid, long groupId)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of quang cao sliders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @return the matching quang cao sliders
	 */
	public static List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId) {

		return getPersistence().findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId);
	}

	/**
	 * Returns a range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of matching quang cao sliders
	 */
	public static List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end) {

		return getPersistence().findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBybyQuangCaoIdAndGroupId(long,long, int, int, OrderByComparator)}
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang cao sliders
	 */
	@Deprecated
	public static List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang cao sliders
	 */
	public static List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider findBybyQuangCaoIdAndGroupId_First(
			long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findBybyQuangCaoIdAndGroupId_First(
			quangCaoId, groupId, orderByComparator);
	}

	/**
	 * Returns the first quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider fetchBybyQuangCaoIdAndGroupId_First(
		long quangCaoId, long groupId,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().fetchBybyQuangCaoIdAndGroupId_First(
			quangCaoId, groupId, orderByComparator);
	}

	/**
	 * Returns the last quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider findBybyQuangCaoIdAndGroupId_Last(
			long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findBybyQuangCaoIdAndGroupId_Last(
			quangCaoId, groupId, orderByComparator);
	}

	/**
	 * Returns the last quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider fetchBybyQuangCaoIdAndGroupId_Last(
		long quangCaoId, long groupId,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().fetchBybyQuangCaoIdAndGroupId_Last(
			quangCaoId, groupId, orderByComparator);
	}

	/**
	 * Returns the quang cao sliders before and after the current quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoSliderId the primary key of the current quang cao slider
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public static QuangCaoSlider[] findBybyQuangCaoIdAndGroupId_PrevAndNext(
			long quangCaoSliderId, long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findBybyQuangCaoIdAndGroupId_PrevAndNext(
			quangCaoSliderId, quangCaoId, groupId, orderByComparator);
	}

	/**
	 * Removes all the quang cao sliders where quangCaoId = &#63; and groupId = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 */
	public static void removeBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId) {

		getPersistence().removeBybyQuangCaoIdAndGroupId(quangCaoId, groupId);
	}

	/**
	 * Returns the number of quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	public static int countBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId) {

		return getPersistence().countBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId);
	}

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider findBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);
	}

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoSliderIdAndGroupId(long,long)}
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Deprecated
	public static QuangCaoSlider fetchBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId, boolean useFinderCache) {

		return getPersistence().fetchBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId, useFinderCache);
	}

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public static QuangCaoSlider fetchBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId) {

		return getPersistence().fetchBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);
	}

	/**
	 * Removes the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; from the database.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the quang cao slider that was removed
	 */
	public static QuangCaoSlider removeBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().removeBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);
	}

	/**
	 * Returns the number of quang cao sliders where quangCaoSliderId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	public static int countBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId) {

		return getPersistence().countBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);
	}

	/**
	 * Caches the quang cao slider in the entity cache if it is enabled.
	 *
	 * @param quangCaoSlider the quang cao slider
	 */
	public static void cacheResult(QuangCaoSlider quangCaoSlider) {
		getPersistence().cacheResult(quangCaoSlider);
	}

	/**
	 * Caches the quang cao sliders in the entity cache if it is enabled.
	 *
	 * @param quangCaoSliders the quang cao sliders
	 */
	public static void cacheResult(List<QuangCaoSlider> quangCaoSliders) {
		getPersistence().cacheResult(quangCaoSliders);
	}

	/**
	 * Creates a new quang cao slider with the primary key. Does not add the quang cao slider to the database.
	 *
	 * @param quangCaoSliderId the primary key for the new quang cao slider
	 * @return the new quang cao slider
	 */
	public static QuangCaoSlider create(long quangCaoSliderId) {
		return getPersistence().create(quangCaoSliderId);
	}

	/**
	 * Removes the quang cao slider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider that was removed
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public static QuangCaoSlider remove(long quangCaoSliderId)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().remove(quangCaoSliderId);
	}

	public static QuangCaoSlider updateImpl(QuangCaoSlider quangCaoSlider) {
		return getPersistence().updateImpl(quangCaoSlider);
	}

	/**
	 * Returns the quang cao slider with the primary key or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public static QuangCaoSlider findByPrimaryKey(long quangCaoSliderId)
		throws com.web.ecoit.portal.quangcao.exception.
			NoSuchQuangCaoSliderException {

		return getPersistence().findByPrimaryKey(quangCaoSliderId);
	}

	/**
	 * Returns the quang cao slider with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider, or <code>null</code> if a quang cao slider with the primary key could not be found
	 */
	public static QuangCaoSlider fetchByPrimaryKey(long quangCaoSliderId) {
		return getPersistence().fetchByPrimaryKey(quangCaoSliderId);
	}

	/**
	 * Returns all the quang cao sliders.
	 *
	 * @return the quang cao sliders
	 */
	public static List<QuangCaoSlider> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of quang cao sliders
	 */
	public static List<QuangCaoSlider> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quang cao sliders
	 */
	@Deprecated
	public static List<QuangCaoSlider> findAll(
		int start, int end, OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quang cao sliders
	 */
	public static List<QuangCaoSlider> findAll(
		int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the quang cao sliders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quang cao sliders.
	 *
	 * @return the number of quang cao sliders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuangCaoSliderPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuangCaoSliderPersistence, QuangCaoSliderPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuangCaoSliderPersistence.class);

		ServiceTracker<QuangCaoSliderPersistence, QuangCaoSliderPersistence>
			serviceTracker =
				new ServiceTracker
					<QuangCaoSliderPersistence, QuangCaoSliderPersistence>(
						bundle.getBundleContext(),
						QuangCaoSliderPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}