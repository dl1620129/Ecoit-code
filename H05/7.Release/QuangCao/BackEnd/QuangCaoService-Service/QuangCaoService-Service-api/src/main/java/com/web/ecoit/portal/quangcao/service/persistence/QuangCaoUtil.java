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

import com.web.ecoit.portal.quangcao.model.QuangCao;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the quang cao service. This utility wraps <code>com.web.ecoit.portal.quangcao.service.persistence.impl.QuangCaoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoPersistence
 * @generated
 */
@ProviderType
public class QuangCaoUtil {

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
	public static void clearCache(QuangCao quangCao) {
		getPersistence().clearCache(quangCao);
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
	public static Map<Serializable, QuangCao> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuangCao> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuangCao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuangCao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuangCao> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuangCao update(QuangCao quangCao) {
		return getPersistence().update(quangCao);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuangCao update(
		QuangCao quangCao, ServiceContext serviceContext) {

		return getPersistence().update(quangCao, serviceContext);
	}

	/**
	 * Returns all the quang caos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching quang caos
	 */
	public static List<QuangCao> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of matching quang caos
	 */
	public static List<QuangCao> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang caos
	 */
	@Deprecated
	public static List<QuangCao> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCao> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang caos
	 */
	public static List<QuangCao> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCao> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public static QuangCao findByUuid_First(
			String uuid, OrderByComparator<QuangCao> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public static QuangCao fetchByUuid_First(
		String uuid, OrderByComparator<QuangCao> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public static QuangCao findByUuid_Last(
			String uuid, OrderByComparator<QuangCao> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public static QuangCao fetchByUuid_Last(
		String uuid, OrderByComparator<QuangCao> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the quang caos before and after the current quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param quangCaoId the primary key of the current quang cao
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	public static QuangCao[] findByUuid_PrevAndNext(
			long quangCaoId, String uuid,
			OrderByComparator<QuangCao> orderByComparator)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findByUuid_PrevAndNext(
			quangCaoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the quang caos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of quang caos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching quang caos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public static QuangCao findByUUID_G(String uuid, long groupId)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Deprecated
	public static QuangCao fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public static QuangCao fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the quang cao where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the quang cao that was removed
	 */
	public static QuangCao removeByUUID_G(String uuid, long groupId)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of quang caos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching quang caos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public static QuangCao findBybyQuangCaoIdAndGroupIdAndType(
			long quangCaoId, long groupId, int type)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoIdAndGroupIdAndType(long,long,int)}
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Deprecated
	public static QuangCao fetchBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type, boolean useFinderCache) {

		return getPersistence().fetchBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type, useFinderCache);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public static QuangCao fetchBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type) {

		return getPersistence().fetchBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type);
	}

	/**
	 * Removes the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the quang cao that was removed
	 */
	public static QuangCao removeBybyQuangCaoIdAndGroupIdAndType(
			long quangCaoId, long groupId, int type)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().removeBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type);
	}

	/**
	 * Returns the number of quang caos where quangCaoId = &#63; and groupId = &#63; and type = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching quang caos
	 */
	public static int countBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type) {

		return getPersistence().countBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public static QuangCao findBybyQuangCaoIdAndStatus(
			long quangCaoId, int status)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findBybyQuangCaoIdAndStatus(quangCaoId, status);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoIdAndStatus(long,int)}
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Deprecated
	public static QuangCao fetchBybyQuangCaoIdAndStatus(
		long quangCaoId, int status, boolean useFinderCache) {

		return getPersistence().fetchBybyQuangCaoIdAndStatus(
			quangCaoId, status, useFinderCache);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public static QuangCao fetchBybyQuangCaoIdAndStatus(
		long quangCaoId, int status) {

		return getPersistence().fetchBybyQuangCaoIdAndStatus(
			quangCaoId, status);
	}

	/**
	 * Removes the quang cao where quangCaoId = &#63; and status = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the quang cao that was removed
	 */
	public static QuangCao removeBybyQuangCaoIdAndStatus(
			long quangCaoId, int status)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().removeBybyQuangCaoIdAndStatus(
			quangCaoId, status);
	}

	/**
	 * Returns the number of quang caos where quangCaoId = &#63; and status = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the number of matching quang caos
	 */
	public static int countBybyQuangCaoIdAndStatus(
		long quangCaoId, int status) {

		return getPersistence().countBybyQuangCaoIdAndStatus(
			quangCaoId, status);
	}

	/**
	 * Caches the quang cao in the entity cache if it is enabled.
	 *
	 * @param quangCao the quang cao
	 */
	public static void cacheResult(QuangCao quangCao) {
		getPersistence().cacheResult(quangCao);
	}

	/**
	 * Caches the quang caos in the entity cache if it is enabled.
	 *
	 * @param quangCaos the quang caos
	 */
	public static void cacheResult(List<QuangCao> quangCaos) {
		getPersistence().cacheResult(quangCaos);
	}

	/**
	 * Creates a new quang cao with the primary key. Does not add the quang cao to the database.
	 *
	 * @param quangCaoId the primary key for the new quang cao
	 * @return the new quang cao
	 */
	public static QuangCao create(long quangCaoId) {
		return getPersistence().create(quangCaoId);
	}

	/**
	 * Removes the quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao that was removed
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	public static QuangCao remove(long quangCaoId)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().remove(quangCaoId);
	}

	public static QuangCao updateImpl(QuangCao quangCao) {
		return getPersistence().updateImpl(quangCao);
	}

	/**
	 * Returns the quang cao with the primary key or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	public static QuangCao findByPrimaryKey(long quangCaoId)
		throws com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException {

		return getPersistence().findByPrimaryKey(quangCaoId);
	}

	/**
	 * Returns the quang cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao, or <code>null</code> if a quang cao with the primary key could not be found
	 */
	public static QuangCao fetchByPrimaryKey(long quangCaoId) {
		return getPersistence().fetchByPrimaryKey(quangCaoId);
	}

	/**
	 * Returns all the quang caos.
	 *
	 * @return the quang caos
	 */
	public static List<QuangCao> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of quang caos
	 */
	public static List<QuangCao> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quang caos
	 */
	@Deprecated
	public static List<QuangCao> findAll(
		int start, int end, OrderByComparator<QuangCao> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quang caos
	 */
	public static List<QuangCao> findAll(
		int start, int end, OrderByComparator<QuangCao> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the quang caos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quang caos.
	 *
	 * @return the number of quang caos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuangCaoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuangCaoPersistence, QuangCaoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuangCaoPersistence.class);

		ServiceTracker<QuangCaoPersistence, QuangCaoPersistence>
			serviceTracker =
				new ServiceTracker<QuangCaoPersistence, QuangCaoPersistence>(
					bundle.getBundleContext(), QuangCaoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}