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

package com.ecoit.elegaldocument.service.persistence;

import com.ecoit.elegaldocument.model.GroupOrganization;

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
 * The persistence utility for the group organization service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.GroupOrganizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see GroupOrganizationPersistence
 * @generated
 */
public class GroupOrganizationUtil {

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
	public static void clearCache(GroupOrganization groupOrganization) {
		getPersistence().clearCache(groupOrganization);
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
	public static Map<Serializable, GroupOrganization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GroupOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GroupOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GroupOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GroupOrganization update(
		GroupOrganization groupOrganization) {

		return getPersistence().update(groupOrganization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GroupOrganization update(
		GroupOrganization groupOrganization, ServiceContext serviceContext) {

		return getPersistence().update(groupOrganization, serviceContext);
	}

	/**
	 * Returns all the group organizations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group organizations
	 */
	public static List<GroupOrganization> findByGroupUser(long groupUserId) {
		return getPersistence().findByGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of matching group organizations
	 */
	public static List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end) {

		return getPersistence().findByGroupUser(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group organizations
	 */
	public static List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group organizations
	 */
	public static List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupUser(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public static GroupOrganization findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public static GroupOrganization fetchByGroupUser_First(
		long groupUserId,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().fetchByGroupUser_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public static GroupOrganization findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public static GroupOrganization fetchByGroupUser_Last(
		long groupUserId,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().fetchByGroupUser_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the group organizations before and after the current group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupOrganizationPK the primary key of the current group organization
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public static GroupOrganization[] findByGroupUser_PrevAndNext(
			GroupOrganizationPK groupOrganizationPK, long groupUserId,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByGroupUser_PrevAndNext(
			groupOrganizationPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the group organizations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeByGroupUser(long groupUserId) {
		getPersistence().removeByGroupUser(groupUserId);
	}

	/**
	 * Returns the number of group organizations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group organizations
	 */
	public static int countByGroupUser(long groupUserId) {
		return getPersistence().countByGroupUser(groupUserId);
	}

	/**
	 * Returns all the group organizations where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the matching group organizations
	 */
	public static List<GroupOrganization> findByOrganization(
		long organizationid) {

		return getPersistence().findByOrganization(organizationid);
	}

	/**
	 * Returns a range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of matching group organizations
	 */
	public static List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end) {

		return getPersistence().findByOrganization(organizationid, start, end);
	}

	/**
	 * Returns an ordered range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group organizations
	 */
	public static List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().findByOrganization(
			organizationid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group organizations
	 */
	public static List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganization(
			organizationid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public static GroupOrganization findByOrganization_First(
			long organizationid,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByOrganization_First(
			organizationid, orderByComparator);
	}

	/**
	 * Returns the first group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public static GroupOrganization fetchByOrganization_First(
		long organizationid,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().fetchByOrganization_First(
			organizationid, orderByComparator);
	}

	/**
	 * Returns the last group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public static GroupOrganization findByOrganization_Last(
			long organizationid,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByOrganization_Last(
			organizationid, orderByComparator);
	}

	/**
	 * Returns the last group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public static GroupOrganization fetchByOrganization_Last(
		long organizationid,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().fetchByOrganization_Last(
			organizationid, orderByComparator);
	}

	/**
	 * Returns the group organizations before and after the current group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param groupOrganizationPK the primary key of the current group organization
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public static GroupOrganization[] findByOrganization_PrevAndNext(
			GroupOrganizationPK groupOrganizationPK, long organizationid,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByOrganization_PrevAndNext(
			groupOrganizationPK, organizationid, orderByComparator);
	}

	/**
	 * Removes all the group organizations where organizationid = &#63; from the database.
	 *
	 * @param organizationid the organizationid
	 */
	public static void removeByOrganization(long organizationid) {
		getPersistence().removeByOrganization(organizationid);
	}

	/**
	 * Returns the number of group organizations where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the number of matching group organizations
	 */
	public static int countByOrganization(long organizationid) {
		return getPersistence().countByOrganization(organizationid);
	}

	/**
	 * Caches the group organization in the entity cache if it is enabled.
	 *
	 * @param groupOrganization the group organization
	 */
	public static void cacheResult(GroupOrganization groupOrganization) {
		getPersistence().cacheResult(groupOrganization);
	}

	/**
	 * Caches the group organizations in the entity cache if it is enabled.
	 *
	 * @param groupOrganizations the group organizations
	 */
	public static void cacheResult(List<GroupOrganization> groupOrganizations) {
		getPersistence().cacheResult(groupOrganizations);
	}

	/**
	 * Creates a new group organization with the primary key. Does not add the group organization to the database.
	 *
	 * @param groupOrganizationPK the primary key for the new group organization
	 * @return the new group organization
	 */
	public static GroupOrganization create(
		GroupOrganizationPK groupOrganizationPK) {

		return getPersistence().create(groupOrganizationPK);
	}

	/**
	 * Removes the group organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization that was removed
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public static GroupOrganization remove(
			GroupOrganizationPK groupOrganizationPK)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().remove(groupOrganizationPK);
	}

	public static GroupOrganization updateImpl(
		GroupOrganization groupOrganization) {

		return getPersistence().updateImpl(groupOrganization);
	}

	/**
	 * Returns the group organization with the primary key or throws a <code>NoSuchGroupOrganizationException</code> if it could not be found.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public static GroupOrganization findByPrimaryKey(
			GroupOrganizationPK groupOrganizationPK)
		throws com.ecoit.elegaldocument.exception.
			NoSuchGroupOrganizationException {

		return getPersistence().findByPrimaryKey(groupOrganizationPK);
	}

	/**
	 * Returns the group organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization, or <code>null</code> if a group organization with the primary key could not be found
	 */
	public static GroupOrganization fetchByPrimaryKey(
		GroupOrganizationPK groupOrganizationPK) {

		return getPersistence().fetchByPrimaryKey(groupOrganizationPK);
	}

	/**
	 * Returns all the group organizations.
	 *
	 * @return the group organizations
	 */
	public static List<GroupOrganization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of group organizations
	 */
	public static List<GroupOrganization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group organizations
	 */
	public static List<GroupOrganization> findAll(
		int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group organizations
	 */
	public static List<GroupOrganization> findAll(
		int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the group organizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of group organizations.
	 *
	 * @return the number of group organizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static GroupOrganizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupOrganizationPersistence, GroupOrganizationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupOrganizationPersistence.class);

		ServiceTracker
			<GroupOrganizationPersistence, GroupOrganizationPersistence>
				serviceTracker =
					new ServiceTracker
						<GroupOrganizationPersistence,
						 GroupOrganizationPersistence>(
							 bundle.getBundleContext(),
							 GroupOrganizationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}