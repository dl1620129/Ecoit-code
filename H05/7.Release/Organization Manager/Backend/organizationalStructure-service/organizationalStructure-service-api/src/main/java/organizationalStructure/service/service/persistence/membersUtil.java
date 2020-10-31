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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import organizationalStructure.service.model.members;

/**
 * The persistence utility for the members service. This utility wraps <code>organizationalStructure.service.service.persistence.impl.membersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see membersPersistence
 * @generated
 */
@ProviderType
public class membersUtil {

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
	public static void clearCache(members members) {
		getPersistence().clearCache(members);
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
	public static Map<Serializable, members> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<members> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<members> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<members> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<members> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static members update(members members) {
		return getPersistence().update(members);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static members update(
		members members, ServiceContext serviceContext) {

		return getPersistence().update(members, serviceContext);
	}

	/**
	 * Returns all the memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching memberses
	 */
	public static List<members> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of matching memberses
	 */
	public static List<members> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memberses
	 */
	@Deprecated
	public static List<members> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<members> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberses
	 */
	public static List<members> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<members> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByUuid_First(
			String uuid, OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByUuid_First(
		String uuid, OrderByComparator<members> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByUuid_Last(
			String uuid, OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByUuid_Last(
		String uuid, OrderByComparator<members> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the memberses before and after the current members in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current members
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public static members[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByUuid_PrevAndNext(
			memberId, uuid, orderByComparator);
	}

	/**
	 * Removes all the memberses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching memberses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the members where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchmembersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByUUID_G(String uuid, long groupId)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the members where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching members, or <code>null</code> if a matching members could not be found
	 */
	@Deprecated
	public static members fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the members where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the members where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the members that was removed
	 */
	public static members removeByUUID_G(String uuid, long groupId)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of memberses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching memberses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the memberses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching memberses
	 */
	public static List<members> findByFindAll(long groupId) {
		return getPersistence().findByFindAll(groupId);
	}

	/**
	 * Returns a range of all the memberses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of matching memberses
	 */
	public static List<members> findByFindAll(
		long groupId, int start, int end) {

		return getPersistence().findByFindAll(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the memberses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memberses
	 */
	@Deprecated
	public static List<members> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<members> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the memberses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberses
	 */
	public static List<members> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<members> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the first members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByFindAll_First(
			long groupId, OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByFindAll_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByFindAll_First(
		long groupId, OrderByComparator<members> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByFindAll_Last(
			long groupId, OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByFindAll_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByFindAll_Last(
		long groupId, OrderByComparator<members> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the memberses before and after the current members in the ordered set where groupId = &#63;.
	 *
	 * @param memberId the primary key of the current members
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public static members[] findByFindAll_PrevAndNext(
			long memberId, long groupId,
			OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByFindAll_PrevAndNext(
			memberId, groupId, orderByComparator);
	}

	/**
	 * Removes all the memberses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByFindAll(long groupId) {
		getPersistence().removeByFindAll(groupId);
	}

	/**
	 * Returns the number of memberses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching memberses
	 */
	public static int countByFindAll(long groupId) {
		return getPersistence().countByFindAll(groupId);
	}

	/**
	 * Returns all the memberses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching memberses
	 */
	public static List<members> findByorganizationId(long organizationId) {
		return getPersistence().findByorganizationId(organizationId);
	}

	/**
	 * Returns a range of all the memberses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of matching memberses
	 */
	public static List<members> findByorganizationId(
		long organizationId, int start, int end) {

		return getPersistence().findByorganizationId(
			organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the memberses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByorganizationId(long, int, int, OrderByComparator)}
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memberses
	 */
	@Deprecated
	public static List<members> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<members> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByorganizationId(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the memberses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberses
	 */
	public static List<members> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<members> orderByComparator) {

		return getPersistence().findByorganizationId(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns the first members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByorganizationId_First(
			long organizationId, OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByorganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByorganizationId_First(
		long organizationId, OrderByComparator<members> orderByComparator) {

		return getPersistence().fetchByorganizationId_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public static members findByorganizationId_Last(
			long organizationId, OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByorganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members, or <code>null</code> if a matching members could not be found
	 */
	public static members fetchByorganizationId_Last(
		long organizationId, OrderByComparator<members> orderByComparator) {

		return getPersistence().fetchByorganizationId_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the memberses before and after the current members in the ordered set where organizationId = &#63;.
	 *
	 * @param memberId the primary key of the current members
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public static members[] findByorganizationId_PrevAndNext(
			long memberId, long organizationId,
			OrderByComparator<members> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByorganizationId_PrevAndNext(
			memberId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the memberses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByorganizationId(long organizationId) {
		getPersistence().removeByorganizationId(organizationId);
	}

	/**
	 * Returns the number of memberses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching memberses
	 */
	public static int countByorganizationId(long organizationId) {
		return getPersistence().countByorganizationId(organizationId);
	}

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public static void cacheResult(members members) {
		getPersistence().cacheResult(members);
	}

	/**
	 * Caches the memberses in the entity cache if it is enabled.
	 *
	 * @param memberses the memberses
	 */
	public static void cacheResult(List<members> memberses) {
		getPersistence().cacheResult(memberses);
	}

	/**
	 * Creates a new members with the primary key. Does not add the members to the database.
	 *
	 * @param memberId the primary key for the new members
	 * @return the new members
	 */
	public static members create(long memberId) {
		return getPersistence().create(memberId);
	}

	/**
	 * Removes the members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the members
	 * @return the members that was removed
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public static members remove(long memberId)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().remove(memberId);
	}

	public static members updateImpl(members members) {
		return getPersistence().updateImpl(members);
	}

	/**
	 * Returns the members with the primary key or throws a <code>NoSuchmembersException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the members
	 * @return the members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public static members findByPrimaryKey(long memberId)
		throws organizationalStructure.service.exception.
			NoSuchmembersException {

		return getPersistence().findByPrimaryKey(memberId);
	}

	/**
	 * Returns the members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the members
	 * @return the members, or <code>null</code> if a members with the primary key could not be found
	 */
	public static members fetchByPrimaryKey(long memberId) {
		return getPersistence().fetchByPrimaryKey(memberId);
	}

	/**
	 * Returns all the memberses.
	 *
	 * @return the memberses
	 */
	public static List<members> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of memberses
	 */
	public static List<members> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of memberses
	 */
	@Deprecated
	public static List<members> findAll(
		int start, int end, OrderByComparator<members> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of memberses
	 */
	public static List<members> findAll(
		int start, int end, OrderByComparator<members> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the memberses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of memberses.
	 *
	 * @return the number of memberses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static membersPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<membersPersistence, membersPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(membersPersistence.class);

		ServiceTracker<membersPersistence, membersPersistence> serviceTracker =
			new ServiceTracker<membersPersistence, membersPersistence>(
				bundle.getBundleContext(), membersPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}