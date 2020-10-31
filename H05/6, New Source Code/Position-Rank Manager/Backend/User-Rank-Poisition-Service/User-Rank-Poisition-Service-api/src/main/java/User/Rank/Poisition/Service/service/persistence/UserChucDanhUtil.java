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

package User.Rank.Poisition.Service.service.persistence;

import User.Rank.Poisition.Service.model.UserChucDanh;

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
 * The persistence utility for the user chuc danh service. This utility wraps <code>User.Rank.Poisition.Service.service.persistence.impl.UserChucDanhPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserChucDanhPersistence
 * @generated
 */
@ProviderType
public class UserChucDanhUtil {

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
	public static void clearCache(UserChucDanh userChucDanh) {
		getPersistence().clearCache(userChucDanh);
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
	public static Map<Serializable, UserChucDanh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserChucDanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserChucDanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserChucDanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserChucDanh update(UserChucDanh userChucDanh) {
		return getPersistence().update(userChucDanh);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserChucDanh update(
		UserChucDanh userChucDanh, ServiceContext serviceContext) {

		return getPersistence().update(userChucDanh, serviceContext);
	}

	/**
	 * Returns all the user chuc danhs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user chuc danhs
	 */
	public static List<UserChucDanh> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	public static List<UserChucDanh> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	public static List<UserChucDanh> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	public static List<UserChucDanh> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByUuid_First(
			String uuid, OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByUuid_First(
		String uuid, OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByUuid_Last(
			String uuid, OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByUuid_Last(
		String uuid, OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public static UserChucDanh[] findByUuid_PrevAndNext(
			long userChucDanhId, String uuid,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUuid_PrevAndNext(
			userChucDanhId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user chuc danhs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user chuc danhs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user chuc danhs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserChucDanhException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByUUID_G(String uuid, long groupId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Deprecated
	public static UserChucDanh fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the user chuc danh where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user chuc danh that was removed
	 */
	public static UserChucDanh removeByUUID_G(String uuid, long groupId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user chuc danhs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user chuc danhs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user chuc danhs
	 */
	public static List<UserChucDanh> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	public static List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	public static List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	public static List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public static UserChucDanh[] findByUuid_C_PrevAndNext(
			long userChucDanhId, String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByUuid_C_PrevAndNext(
			userChucDanhId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the user chuc danhs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user chuc danhs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user chuc danhs
	 */
	public static List<UserChucDanh> findByFindAll(
		long groupId, long companyId) {

		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	public static List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	public static List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	public static List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public static UserChucDanh findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static UserChucDanh fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public static UserChucDanh[] findByFindAll_PrevAndNext(
			long userChucDanhId, long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByFindAll_PrevAndNext(
			userChucDanhId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the user chuc danhs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user chuc danhs
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the user chuc danh in the entity cache if it is enabled.
	 *
	 * @param userChucDanh the user chuc danh
	 */
	public static void cacheResult(UserChucDanh userChucDanh) {
		getPersistence().cacheResult(userChucDanh);
	}

	/**
	 * Caches the user chuc danhs in the entity cache if it is enabled.
	 *
	 * @param userChucDanhs the user chuc danhs
	 */
	public static void cacheResult(List<UserChucDanh> userChucDanhs) {
		getPersistence().cacheResult(userChucDanhs);
	}

	/**
	 * Creates a new user chuc danh with the primary key. Does not add the user chuc danh to the database.
	 *
	 * @param userChucDanhId the primary key for the new user chuc danh
	 * @return the new user chuc danh
	 */
	public static UserChucDanh create(long userChucDanhId) {
		return getPersistence().create(userChucDanhId);
	}

	/**
	 * Removes the user chuc danh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh that was removed
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public static UserChucDanh remove(long userChucDanhId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().remove(userChucDanhId);
	}

	public static UserChucDanh updateImpl(UserChucDanh userChucDanh) {
		return getPersistence().updateImpl(userChucDanh);
	}

	/**
	 * Returns the user chuc danh with the primary key or throws a <code>NoSuchUserChucDanhException</code> if it could not be found.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public static UserChucDanh findByPrimaryKey(long userChucDanhId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserChucDanhException {

		return getPersistence().findByPrimaryKey(userChucDanhId);
	}

	/**
	 * Returns the user chuc danh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh, or <code>null</code> if a user chuc danh with the primary key could not be found
	 */
	public static UserChucDanh fetchByPrimaryKey(long userChucDanhId) {
		return getPersistence().fetchByPrimaryKey(userChucDanhId);
	}

	/**
	 * Returns all the user chuc danhs.
	 *
	 * @return the user chuc danhs
	 */
	public static List<UserChucDanh> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of user chuc danhs
	 */
	public static List<UserChucDanh> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user chuc danhs
	 */
	@Deprecated
	public static List<UserChucDanh> findAll(
		int start, int end, OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user chuc danhs
	 */
	public static List<UserChucDanh> findAll(
		int start, int end, OrderByComparator<UserChucDanh> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the user chuc danhs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user chuc danhs.
	 *
	 * @return the number of user chuc danhs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserChucDanhPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserChucDanhPersistence, UserChucDanhPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserChucDanhPersistence.class);

		ServiceTracker<UserChucDanhPersistence, UserChucDanhPersistence>
			serviceTracker =
				new ServiceTracker
					<UserChucDanhPersistence, UserChucDanhPersistence>(
						bundle.getBundleContext(),
						UserChucDanhPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}