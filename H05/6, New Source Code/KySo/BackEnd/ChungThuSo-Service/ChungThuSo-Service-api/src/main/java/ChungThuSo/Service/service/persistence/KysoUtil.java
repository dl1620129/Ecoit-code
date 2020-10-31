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

package ChungThuSo.Service.service.persistence;

import ChungThuSo.Service.model.Kyso;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the kyso service. This utility wraps <code>ChungThuSo.Service.service.persistence.impl.KysoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KysoPersistence
 * @generated
 */
@ProviderType
public class KysoUtil {

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
	public static void clearCache(Kyso kyso) {
		getPersistence().clearCache(kyso);
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
	public static Map<Serializable, Kyso> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Kyso> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Kyso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Kyso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Kyso update(Kyso kyso) {
		return getPersistence().update(kyso);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Kyso update(Kyso kyso, ServiceContext serviceContext) {
		return getPersistence().update(kyso, serviceContext);
	}

	/**
	 * Returns all the kysos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kysos
	 */
	public static List<Kyso> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of matching kysos
	 */
	public static List<Kyso> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kysos
	 */
	@Deprecated
	public static List<Kyso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Kyso> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kysos
	 */
	public static List<Kyso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findByUuid_First(
			String uuid, OrderByComparator<Kyso> orderByComparator)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchByUuid_First(
		String uuid, OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findByUuid_Last(
			String uuid, OrderByComparator<Kyso> orderByComparator)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchByUuid_Last(
		String uuid, OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the kysos before and after the current kyso in the ordered set where uuid = &#63;.
	 *
	 * @param kysoId the primary key of the current kyso
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public static Kyso[] findByUuid_PrevAndNext(
			long kysoId, String uuid, OrderByComparator<Kyso> orderByComparator)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUuid_PrevAndNext(
			kysoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the kysos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of kysos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kysos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findByUUID_G(String uuid, long groupId)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	public static Kyso fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the kyso where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kyso that was removed
	 */
	public static Kyso removeByUUID_G(String uuid, long groupId)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of kysos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kysos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kysos
	 */
	public static List<Kyso> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of matching kysos
	 */
	public static List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kysos
	 */
	@Deprecated
	public static List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Kyso> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kysos
	 */
	public static List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the kysos before and after the current kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param kysoId the primary key of the current kyso
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public static Kyso[] findByUuid_C_PrevAndNext(
			long kysoId, String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			kysoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the kysos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kysos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the kyso where screenName = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param screenName the screen name
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findBygetByScreenName(String screenName)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findBygetByScreenName(screenName);
	}

	/**
	 * Returns the kyso where screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBygetByScreenName(String)}
	 * @param screenName the screen name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	public static Kyso fetchBygetByScreenName(
		String screenName, boolean useFinderCache) {

		return getPersistence().fetchBygetByScreenName(
			screenName, useFinderCache);
	}

	/**
	 * Returns the kyso where screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param screenName the screen name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchBygetByScreenName(String screenName) {
		return getPersistence().fetchBygetByScreenName(screenName);
	}

	/**
	 * Removes the kyso where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 * @return the kyso that was removed
	 */
	public static Kyso removeBygetByScreenName(String screenName)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().removeBygetByScreenName(screenName);
	}

	/**
	 * Returns the number of kysos where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching kysos
	 */
	public static int countBygetByScreenName(String screenName) {
		return getPersistence().countBygetByScreenName(screenName);
	}

	/**
	 * Returns the kyso where serialNumber = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param serialNumber the serial number
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	public static Kyso findBygetBySerialNumber(String serialNumber)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findBygetBySerialNumber(serialNumber);
	}

	/**
	 * Returns the kyso where serialNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBygetBySerialNumber(String)}
	 * @param serialNumber the serial number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	public static Kyso fetchBygetBySerialNumber(
		String serialNumber, boolean useFinderCache) {

		return getPersistence().fetchBygetBySerialNumber(
			serialNumber, useFinderCache);
	}

	/**
	 * Returns the kyso where serialNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialNumber the serial number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	public static Kyso fetchBygetBySerialNumber(String serialNumber) {
		return getPersistence().fetchBygetBySerialNumber(serialNumber);
	}

	/**
	 * Removes the kyso where serialNumber = &#63; from the database.
	 *
	 * @param serialNumber the serial number
	 * @return the kyso that was removed
	 */
	public static Kyso removeBygetBySerialNumber(String serialNumber)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().removeBygetBySerialNumber(serialNumber);
	}

	/**
	 * Returns the number of kysos where serialNumber = &#63;.
	 *
	 * @param serialNumber the serial number
	 * @return the number of matching kysos
	 */
	public static int countBygetBySerialNumber(String serialNumber) {
		return getPersistence().countBygetBySerialNumber(serialNumber);
	}

	/**
	 * Caches the kyso in the entity cache if it is enabled.
	 *
	 * @param kyso the kyso
	 */
	public static void cacheResult(Kyso kyso) {
		getPersistence().cacheResult(kyso);
	}

	/**
	 * Caches the kysos in the entity cache if it is enabled.
	 *
	 * @param kysos the kysos
	 */
	public static void cacheResult(List<Kyso> kysos) {
		getPersistence().cacheResult(kysos);
	}

	/**
	 * Creates a new kyso with the primary key. Does not add the kyso to the database.
	 *
	 * @param kysoId the primary key for the new kyso
	 * @return the new kyso
	 */
	public static Kyso create(long kysoId) {
		return getPersistence().create(kysoId);
	}

	/**
	 * Removes the kyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso that was removed
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public static Kyso remove(long kysoId)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().remove(kysoId);
	}

	public static Kyso updateImpl(Kyso kyso) {
		return getPersistence().updateImpl(kyso);
	}

	/**
	 * Returns the kyso with the primary key or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	public static Kyso findByPrimaryKey(long kysoId)
		throws ChungThuSo.Service.exception.NoSuchKysoException {

		return getPersistence().findByPrimaryKey(kysoId);
	}

	/**
	 * Returns the kyso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso, or <code>null</code> if a kyso with the primary key could not be found
	 */
	public static Kyso fetchByPrimaryKey(long kysoId) {
		return getPersistence().fetchByPrimaryKey(kysoId);
	}

	/**
	 * Returns all the kysos.
	 *
	 * @return the kysos
	 */
	public static List<Kyso> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of kysos
	 */
	public static List<Kyso> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of kysos
	 */
	@Deprecated
	public static List<Kyso> findAll(
		int start, int end, OrderByComparator<Kyso> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kysos
	 */
	public static List<Kyso> findAll(
		int start, int end, OrderByComparator<Kyso> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the kysos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of kysos.
	 *
	 * @return the number of kysos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static KysoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KysoPersistence, KysoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(KysoPersistence.class);

		ServiceTracker<KysoPersistence, KysoPersistence> serviceTracker =
			new ServiceTracker<KysoPersistence, KysoPersistence>(
				bundle.getBundleContext(), KysoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}