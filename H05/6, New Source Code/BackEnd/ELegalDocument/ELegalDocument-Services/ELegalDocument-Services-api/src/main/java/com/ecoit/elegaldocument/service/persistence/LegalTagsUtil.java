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

import com.ecoit.elegaldocument.model.LegalTags;

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
 * The persistence utility for the legal tags service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalTagsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalTagsPersistence
 * @generated
 */
public class LegalTagsUtil {

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
	public static void clearCache(LegalTags legalTags) {
		getPersistence().clearCache(legalTags);
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
	public static Map<Serializable, LegalTags> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalTags> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalTags> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalTags> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalTags update(LegalTags legalTags) {
		return getPersistence().update(legalTags);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalTags update(
		LegalTags legalTags, ServiceContext serviceContext) {

		return getPersistence().update(legalTags, serviceContext);
	}

	/**
	 * Returns all the legal tagses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal tagses
	 */
	public static List<LegalTags> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal tagses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of matching legal tagses
	 */
	public static List<LegalTags> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal tagses
	 */
	public static List<LegalTags> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal tagses
	 */
	public static List<LegalTags> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalTags> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	public static LegalTags findByGroupId_First(
			long groupId, OrderByComparator<LegalTags> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	public static LegalTags fetchByGroupId_First(
		long groupId, OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	public static LegalTags findByGroupId_Last(
			long groupId, OrderByComparator<LegalTags> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	public static LegalTags fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal tagses before and after the current legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param tagId the primary key of the current legal tags
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	public static LegalTags[] findByGroupId_PrevAndNext(
			long tagId, long groupId,
			OrderByComparator<LegalTags> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByGroupId_PrevAndNext(
			tagId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal tagses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal tagses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal tagses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @return the matching legal tagses
	 */
	public static List<LegalTags> findByP_S(long groupId, boolean statusTags) {
		return getPersistence().findByP_S(groupId, statusTags);
	}

	/**
	 * Returns a range of all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of matching legal tagses
	 */
	public static List<LegalTags> findByP_S(
		long groupId, boolean statusTags, int start, int end) {

		return getPersistence().findByP_S(groupId, statusTags, start, end);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal tagses
	 */
	public static List<LegalTags> findByP_S(
		long groupId, boolean statusTags, int start, int end,
		OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().findByP_S(
			groupId, statusTags, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal tagses
	 */
	public static List<LegalTags> findByP_S(
		long groupId, boolean statusTags, int start, int end,
		OrderByComparator<LegalTags> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_S(
			groupId, statusTags, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	public static LegalTags findByP_S_First(
			long groupId, boolean statusTags,
			OrderByComparator<LegalTags> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByP_S_First(
			groupId, statusTags, orderByComparator);
	}

	/**
	 * Returns the first legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	public static LegalTags fetchByP_S_First(
		long groupId, boolean statusTags,
		OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().fetchByP_S_First(
			groupId, statusTags, orderByComparator);
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	public static LegalTags findByP_S_Last(
			long groupId, boolean statusTags,
			OrderByComparator<LegalTags> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByP_S_Last(
			groupId, statusTags, orderByComparator);
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	public static LegalTags fetchByP_S_Last(
		long groupId, boolean statusTags,
		OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().fetchByP_S_Last(
			groupId, statusTags, orderByComparator);
	}

	/**
	 * Returns the legal tagses before and after the current legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param tagId the primary key of the current legal tags
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	public static LegalTags[] findByP_S_PrevAndNext(
			long tagId, long groupId, boolean statusTags,
			OrderByComparator<LegalTags> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByP_S_PrevAndNext(
			tagId, groupId, statusTags, orderByComparator);
	}

	/**
	 * Removes all the legal tagses where groupId = &#63; and statusTags = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 */
	public static void removeByP_S(long groupId, boolean statusTags) {
		getPersistence().removeByP_S(groupId, statusTags);
	}

	/**
	 * Returns the number of legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @return the number of matching legal tagses
	 */
	public static int countByP_S(long groupId, boolean statusTags) {
		return getPersistence().countByP_S(groupId, statusTags);
	}

	/**
	 * Caches the legal tags in the entity cache if it is enabled.
	 *
	 * @param legalTags the legal tags
	 */
	public static void cacheResult(LegalTags legalTags) {
		getPersistence().cacheResult(legalTags);
	}

	/**
	 * Caches the legal tagses in the entity cache if it is enabled.
	 *
	 * @param legalTagses the legal tagses
	 */
	public static void cacheResult(List<LegalTags> legalTagses) {
		getPersistence().cacheResult(legalTagses);
	}

	/**
	 * Creates a new legal tags with the primary key. Does not add the legal tags to the database.
	 *
	 * @param tagId the primary key for the new legal tags
	 * @return the new legal tags
	 */
	public static LegalTags create(long tagId) {
		return getPersistence().create(tagId);
	}

	/**
	 * Removes the legal tags with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags that was removed
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	public static LegalTags remove(long tagId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().remove(tagId);
	}

	public static LegalTags updateImpl(LegalTags legalTags) {
		return getPersistence().updateImpl(legalTags);
	}

	/**
	 * Returns the legal tags with the primary key or throws a <code>NoSuchLegalTagsException</code> if it could not be found.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	public static LegalTags findByPrimaryKey(long tagId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTagsException {

		return getPersistence().findByPrimaryKey(tagId);
	}

	/**
	 * Returns the legal tags with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags, or <code>null</code> if a legal tags with the primary key could not be found
	 */
	public static LegalTags fetchByPrimaryKey(long tagId) {
		return getPersistence().fetchByPrimaryKey(tagId);
	}

	/**
	 * Returns all the legal tagses.
	 *
	 * @return the legal tagses
	 */
	public static List<LegalTags> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of legal tagses
	 */
	public static List<LegalTags> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal tagses
	 */
	public static List<LegalTags> findAll(
		int start, int end, OrderByComparator<LegalTags> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal tagses
	 */
	public static List<LegalTags> findAll(
		int start, int end, OrderByComparator<LegalTags> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal tagses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal tagses.
	 *
	 * @return the number of legal tagses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalTagsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalTagsPersistence, LegalTagsPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalTagsPersistence.class);

		ServiceTracker<LegalTagsPersistence, LegalTagsPersistence>
			serviceTracker =
				new ServiceTracker<LegalTagsPersistence, LegalTagsPersistence>(
					bundle.getBundleContext(), LegalTagsPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}