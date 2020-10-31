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

package organizationalStructure.service.service.persistence;

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

import organizationalStructure.service.model.member;

/**
 * The persistence utility for the member service. This utility wraps <code>organizationalStructure.service.service.persistence.impl.memberPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see memberPersistence
 * @generated
 */
public class memberUtil {

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
	public static void clearCache(member member) {
		getPersistence().clearCache(member);
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
	public static Map<Serializable, member> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<member> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<member> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<member> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<member> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static member update(member member) {
		return getPersistence().update(member);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static member update(member member, ServiceContext serviceContext) {
		return getPersistence().update(member, serviceContext);
	}

	/**
	 * Returns all the members where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching members
	 */
	public static List<member> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the members where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	public static List<member> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the members where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	public static List<member> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<member> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the members where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	public static List<member> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<member> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByUuid_First(
			String uuid, OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByUuid_First(
		String uuid, OrderByComparator<member> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByUuid_Last(
			String uuid, OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByUuid_Last(
		String uuid, OrderByComparator<member> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the members before and after the current member in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public static member[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByUuid_PrevAndNext(
			memberId, uuid, orderByComparator);
	}

	/**
	 * Removes all the members where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of members where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching members
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the member where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchmemberException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByUUID_G(String uuid, long groupId)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the member where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the member where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the member where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the member that was removed
	 */
	public static member removeByUUID_G(String uuid, long groupId)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of members where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching members
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the members where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching members
	 */
	public static List<member> findByFindAll(long groupId) {
		return getPersistence().findByFindAll(groupId);
	}

	/**
	 * Returns a range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	public static List<member> findByFindAll(long groupId, int start, int end) {
		return getPersistence().findByFindAll(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	public static List<member> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<member> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	public static List<member> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<member> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByFindAll_First(
			long groupId, OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByFindAll_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByFindAll_First(
		long groupId, OrderByComparator<member> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByFindAll_Last(
			long groupId, OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByFindAll_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByFindAll_Last(
		long groupId, OrderByComparator<member> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the members before and after the current member in the ordered set where groupId = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public static member[] findByFindAll_PrevAndNext(
			long memberId, long groupId,
			OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByFindAll_PrevAndNext(
			memberId, groupId, orderByComparator);
	}

	/**
	 * Removes all the members where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByFindAll(long groupId) {
		getPersistence().removeByFindAll(groupId);
	}

	/**
	 * Returns the number of members where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching members
	 */
	public static int countByFindAll(long groupId) {
		return getPersistence().countByFindAll(groupId);
	}

	/**
	 * Returns all the members where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching members
	 */
	public static List<member> findByorganizationId(long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	 * Returns a range of all the members where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	public static List<member> findByorganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByorganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the members where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	public static List<member> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<member> orderByComparator) {

		return getPersistence().findByorganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the members where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	public static List<member> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<member> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByorganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByorganizationId_First(
			long organizationId, OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByorganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByorganizationId_First(
		long organizationId, OrderByComparator<member> orderByComparator) {

		return getPersistence().fetchByorganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public static member findByorganizationId_Last(
			long organizationId, OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByorganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public static member fetchByorganizationId_Last(
		long organizationId, OrderByComparator<member> orderByComparator) {

		return getPersistence().fetchByorganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the members before and after the current member in the ordered set where organizationId = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public static member[] findByorganizationId_PrevAndNext(
			long memberId, long organizationId,
			OrderByComparator<member> orderByComparator)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByorganizationId_PrevAndNext(
			memberId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the members where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	 * Returns the number of members where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching members
	 */
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	public static void cacheResult(member member) {
		getPersistence().cacheResult(member);
	}

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public static void cacheResult(List<member> members) {
		getPersistence().cacheResult(members);
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	public static member create(long memberId) {
		return getPersistence().create(memberId);
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public static member remove(long memberId)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().remove(memberId);
	}

	public static member updateImpl(member member) {
		return getPersistence().updateImpl(member);
	}

	/**
	 * Returns the member with the primary key or throws a <code>NoSuchmemberException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public static member findByPrimaryKey(long memberId)
		throws organizationalStructure.service.exception.NoSuchmemberException {

		return getPersistence().findByPrimaryKey(memberId);
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 */
	public static member fetchByPrimaryKey(long memberId) {
		return getPersistence().fetchByPrimaryKey(memberId);
	}

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 */
	public static List<member> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 */
	public static List<member> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of members
	 */
	public static List<member> findAll(
		int start, int end, OrderByComparator<member> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of members
	 */
	public static List<member> findAll(
		int start, int end, OrderByComparator<member> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the members from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static memberPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<memberPersistence, memberPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(memberPersistence.class);

		ServiceTracker<memberPersistence, memberPersistence> serviceTracker =
			new ServiceTracker<memberPersistence, memberPersistence>(
				bundle.getBundleContext(), memberPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}