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

import com.ecoit.elegaldocument.model.LegalOrg;

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
 * The persistence utility for the legal org service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalOrgPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalOrgPersistence
 * @generated
 */
public class LegalOrgUtil {

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
	public static void clearCache(LegalOrg legalOrg) {
		getPersistence().clearCache(legalOrg);
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
	public static Map<Serializable, LegalOrg> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalOrg> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalOrg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalOrg> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalOrg update(LegalOrg legalOrg) {
		return getPersistence().update(legalOrg);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalOrg update(
		LegalOrg legalOrg, ServiceContext serviceContext) {

		return getPersistence().update(legalOrg, serviceContext);
	}

	/**
	 * Returns the legal org where organizationId = &#63; or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByOrgId(long organizationId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByOrgId(organizationId);
	}

	/**
	 * Returns the legal org where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByOrgId(long organizationId) {
		return getPersistence().fetchByOrgId(organizationId);
	}

	/**
	 * Returns the legal org where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByOrgId(
		long organizationId, boolean useFinderCache) {

		return getPersistence().fetchByOrgId(organizationId, useFinderCache);
	}

	/**
	 * Removes the legal org where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the legal org that was removed
	 */
	public static LegalOrg removeByOrgId(long organizationId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().removeByOrgId(organizationId);
	}

	/**
	 * Returns the number of legal orgs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal orgs
	 */
	public static int countByOrgId(long organizationId) {
		return getPersistence().countByOrgId(organizationId);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByGroupId_First(
			long groupId, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByGroupId_First(
		long groupId, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByGroupId_Last(
			long groupId, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByGroupId_PrevAndNext(
			long organizationId, long groupId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByGroupId_PrevAndNext(
			organizationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal orgs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_L(long groupId, String language) {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_L_PrevAndNext(
			long organizationId, long groupId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_PrevAndNext(
			organizationId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_O(long groupId, long organizationId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_O(groupId, organizationId);
	}

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_O(long groupId, long organizationId) {
		return getPersistence().fetchByG_O(groupId, organizationId);
	}

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_O(
		long groupId, long organizationId, boolean useFinderCache) {

		return getPersistence().fetchByG_O(
			groupId, organizationId, useFinderCache);
	}

	/**
	 * Removes the legal org where groupId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the legal org that was removed
	 */
	public static LegalOrg removeByG_O(long groupId, long organizationId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().removeByG_O(groupId, organizationId);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the number of matching legal orgs
	 */
	public static int countByG_O(long groupId, long organizationId) {
		return getPersistence().countByG_O(groupId, organizationId);
	}

	/**
	 * Returns all the legal orgs where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByOrgStatus(boolean statusOrg) {
		return getPersistence().findByOrgStatus(statusOrg);
	}

	/**
	 * Returns a range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end) {

		return getPersistence().findByOrgStatus(statusOrg, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByOrgStatus(
			statusOrg, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOrgStatus(
			statusOrg, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByOrgStatus_First(
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByOrgStatus_First(
			statusOrg, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByOrgStatus_First(
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByOrgStatus_First(
			statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByOrgStatus_Last(
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByOrgStatus_Last(
			statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByOrgStatus_Last(
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByOrgStatus_Last(
			statusOrg, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByOrgStatus_PrevAndNext(
			long organizationId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByOrgStatus_PrevAndNext(
			organizationId, statusOrg, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where statusOrg = &#63; from the database.
	 *
	 * @param statusOrg the status org
	 */
	public static void removeByOrgStatus(boolean statusOrg) {
		getPersistence().removeByOrgStatus(statusOrg);
	}

	/**
	 * Returns the number of legal orgs where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public static int countByOrgStatus(boolean statusOrg) {
		return getPersistence().countByOrgStatus(statusOrg);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language) {

		return getPersistence().findByS_L(groupId, statusOrg, language);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end) {

		return getPersistence().findByS_L(
			groupId, statusOrg, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByS_L(
			groupId, statusOrg, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByS_L(
			groupId, statusOrg, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByS_L_First(
			long groupId, boolean statusOrg, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByS_L_First(
			groupId, statusOrg, language, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByS_L_First(
		long groupId, boolean statusOrg, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByS_L_First(
			groupId, statusOrg, language, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByS_L_Last(
			long groupId, boolean statusOrg, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByS_L_Last(
			groupId, statusOrg, language, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByS_L_Last(
		long groupId, boolean statusOrg, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByS_L_Last(
			groupId, statusOrg, language, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByS_L_PrevAndNext(
			long organizationId, long groupId, boolean statusOrg,
			String language, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByS_L_PrevAndNext(
			organizationId, groupId, statusOrg, language, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 */
	public static void removeByS_L(
		long groupId, boolean statusOrg, String language) {

		getPersistence().removeByS_L(groupId, statusOrg, language);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	public static int countByS_L(
		long groupId, boolean statusOrg, String language) {

		return getPersistence().countByS_L(groupId, statusOrg, language);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable) {

		return getPersistence().findByS_Rss(groupId, statusOrg, rssable);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end) {

		return getPersistence().findByS_Rss(
			groupId, statusOrg, rssable, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByS_Rss(
			groupId, statusOrg, rssable, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByS_Rss(
			groupId, statusOrg, rssable, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByS_Rss_First(
			long groupId, boolean statusOrg, boolean rssable,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByS_Rss_First(
			groupId, statusOrg, rssable, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByS_Rss_First(
		long groupId, boolean statusOrg, boolean rssable,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByS_Rss_First(
			groupId, statusOrg, rssable, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByS_Rss_Last(
			long groupId, boolean statusOrg, boolean rssable,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByS_Rss_Last(
			groupId, statusOrg, rssable, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByS_Rss_Last(
		long groupId, boolean statusOrg, boolean rssable,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByS_Rss_Last(
			groupId, statusOrg, rssable, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByS_Rss_PrevAndNext(
			long organizationId, long groupId, boolean statusOrg,
			boolean rssable, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByS_Rss_PrevAndNext(
			organizationId, groupId, statusOrg, rssable, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 */
	public static void removeByS_Rss(
		long groupId, boolean statusOrg, boolean rssable) {

		getPersistence().removeByS_Rss(groupId, statusOrg, rssable);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @return the number of matching legal orgs
	 */
	public static int countByS_Rss(
		long groupId, boolean statusOrg, boolean rssable) {

		return getPersistence().countByS_Rss(groupId, statusOrg, rssable);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId) {

		return getPersistence().findByG_L_P(groupId, language, parentId);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end) {

		return getPersistence().findByG_L_P(
			groupId, language, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_L_P(
			groupId, language, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_L_P(
			groupId, language, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_L_P_First(
			long groupId, String language, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_P_First(
			groupId, language, parentId, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_L_P_First(
		long groupId, String language, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_L_P_First(
			groupId, language, parentId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_L_P_Last(
			long groupId, String language, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_P_Last(
			groupId, language, parentId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_L_P_Last(
		long groupId, String language, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_L_P_Last(
			groupId, language, parentId, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_L_P_PrevAndNext(
			long organizationId, long groupId, String language, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_P_PrevAndNext(
			organizationId, groupId, language, parentId, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 */
	public static void removeByG_L_P(
		long groupId, String language, long parentId) {

		getPersistence().removeByG_L_P(groupId, language, parentId);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the number of matching legal orgs
	 */
	public static int countByG_L_P(
		long groupId, String language, long parentId) {

		return getPersistence().countByG_L_P(groupId, language, parentId);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg) {

		return getPersistence().findByG_L_P_S(
			groupId, language, parentId, statusOrg);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end) {

		return getPersistence().findByG_L_P_S(
			groupId, language, parentId, statusOrg, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_L_P_S(
			groupId, language, parentId, statusOrg, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_P_S(
			groupId, language, parentId, statusOrg, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_L_P_S_First(
			long groupId, String language, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_P_S_First(
			groupId, language, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_L_P_S_First(
		long groupId, String language, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_L_P_S_First(
			groupId, language, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_L_P_S_Last(
			long groupId, String language, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_P_S_Last(
			groupId, language, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_L_P_S_Last(
		long groupId, String language, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_L_P_S_Last(
			groupId, language, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_L_P_S_PrevAndNext(
			long organizationId, long groupId, String language, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_L_P_S_PrevAndNext(
			organizationId, groupId, language, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	public static void removeByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg) {

		getPersistence().removeByG_L_P_S(
			groupId, language, parentId, statusOrg);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public static int countByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg) {

		return getPersistence().countByG_L_P_S(
			groupId, language, parentId, statusOrg);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId) {

		return getPersistence().findByG_C_P(groupId, companyId, parentId);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end) {

		return getPersistence().findByG_C_P(
			groupId, companyId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_C_P(
			groupId, companyId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_C_P(
			groupId, companyId, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_P_First(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_P_First(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_P_First(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_P_First(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_P_Last(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_P_Last(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_P_Last(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_P_Last(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_C_P_PrevAndNext(
			long organizationId, long groupId, long companyId, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_P_PrevAndNext(
			organizationId, groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 */
	public static void removeByG_C_P(
		long groupId, long companyId, long parentId) {

		getPersistence().removeByG_C_P(groupId, companyId, parentId);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal orgs
	 */
	public static int countByG_C_P(
		long groupId, long companyId, long parentId) {

		return getPersistence().countByG_C_P(groupId, companyId, parentId);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_L_P_S_First(
			long groupId, long companyId, String language, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_P_S_First(
			groupId, companyId, language, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_L_P_S_First(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_L_P_S_First(
			groupId, companyId, language, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_L_P_S_Last(
			long groupId, long companyId, String language, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_P_S_Last(
			groupId, companyId, language, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_L_P_S_Last(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_L_P_S_Last(
			groupId, companyId, language, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_C_L_P_S_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_P_S_PrevAndNext(
			organizationId, groupId, companyId, language, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	public static void removeByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg) {

		getPersistence().removeByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public static int countByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg) {

		return getPersistence().countByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language) {

		return getPersistence().findByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_L_First(
			long groupId, long companyId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_First(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_L_First(
		long groupId, long companyId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_L_First(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_L_Last(
			long groupId, long companyId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_Last(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_L_Last(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_C_L_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_PrevAndNext(
			organizationId, groupId, companyId, language, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	public static void removeByG_C_L(
		long groupId, long companyId, String language) {

		getPersistence().removeByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	public static int countByG_C_L(
		long groupId, long companyId, String language) {

		return getPersistence().countByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusOrg);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusOrg, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusOrg, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusOrg, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_S_First(
			groupId, companyId, language, statusOrg, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_L_S_First(
			groupId, companyId, language, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_S_Last(
			groupId, companyId, language, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByG_C_L_S_Last(
			groupId, companyId, language, statusOrg, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByG_C_L_S_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByG_C_L_S_PrevAndNext(
			organizationId, groupId, companyId, language, statusOrg,
			orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 */
	public static void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg) {

		getPersistence().removeByG_C_L_S(
			groupId, companyId, language, statusOrg);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public static int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg) {

		return getPersistence().countByG_C_L_S(
			groupId, companyId, language, statusOrg);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroup(long groupId, long companyId) {
		return getPersistence().findByFindGroup(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindGroup(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByFindGroup_First(
			long groupId, long companyId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByFindGroup_First(
		long groupId, long companyId,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByFindGroup_Last(
			long groupId, long companyId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByFindGroup_Last(
		long groupId, long companyId,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByFindGroup_PrevAndNext(
			long organizationId, long groupId, long companyId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindGroup_PrevAndNext(
			organizationId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindGroup(long groupId, long companyId) {
		getPersistence().removeByFindGroup(groupId, companyId);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal orgs
	 */
	public static int countByFindGroup(long groupId, long companyId) {
		return getPersistence().countByFindGroup(groupId, companyId);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg) {

		return getPersistence().findByFindAllStatus(
			groupId, companyId, statusOrg);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end) {

		return getPersistence().findByFindAllStatus(
			groupId, companyId, statusOrg, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByFindAllStatus(
			groupId, companyId, statusOrg, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindAllStatus(
			groupId, companyId, statusOrg, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByFindAllStatus_First(
			long groupId, long companyId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindAllStatus_First(
			groupId, companyId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByFindAllStatus_First(
		long groupId, long companyId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByFindAllStatus_First(
			groupId, companyId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByFindAllStatus_Last(
			long groupId, long companyId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindAllStatus_Last(
			groupId, companyId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByFindAllStatus_Last(
		long groupId, long companyId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByFindAllStatus_Last(
			groupId, companyId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByFindAllStatus_PrevAndNext(
			long organizationId, long groupId, long companyId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindAllStatus_PrevAndNext(
			organizationId, groupId, companyId, statusOrg, orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 */
	public static void removeByFindAllStatus(
		long groupId, long companyId, boolean statusOrg) {

		getPersistence().removeByFindAllStatus(groupId, companyId, statusOrg);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public static int countByFindAllStatus(
		long groupId, long companyId, boolean statusOrg) {

		return getPersistence().countByFindAllStatus(
			groupId, companyId, statusOrg);
	}

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public static List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByFindGroupCompanyParent_First(
			long groupId, long companyId, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindGroupCompanyParent_First(
			groupId, companyId, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByFindGroupCompanyParent_First(
		long groupId, long companyId, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByFindGroupCompanyParent_First(
			groupId, companyId, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public static LegalOrg findByFindGroupCompanyParent_Last(
			long groupId, long companyId, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindGroupCompanyParent_Last(
			groupId, companyId, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public static LegalOrg fetchByFindGroupCompanyParent_Last(
		long groupId, long companyId, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().fetchByFindGroupCompanyParent_Last(
			groupId, companyId, parentId, statusOrg, orderByComparator);
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg[] findByFindGroupCompanyParent_PrevAndNext(
			long organizationId, long groupId, long companyId, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByFindGroupCompanyParent_PrevAndNext(
			organizationId, groupId, companyId, parentId, statusOrg,
			orderByComparator);
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	public static void removeByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg) {

		getPersistence().removeByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public static int countByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg) {

		return getPersistence().countByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg);
	}

	/**
	 * Caches the legal org in the entity cache if it is enabled.
	 *
	 * @param legalOrg the legal org
	 */
	public static void cacheResult(LegalOrg legalOrg) {
		getPersistence().cacheResult(legalOrg);
	}

	/**
	 * Caches the legal orgs in the entity cache if it is enabled.
	 *
	 * @param legalOrgs the legal orgs
	 */
	public static void cacheResult(List<LegalOrg> legalOrgs) {
		getPersistence().cacheResult(legalOrgs);
	}

	/**
	 * Creates a new legal org with the primary key. Does not add the legal org to the database.
	 *
	 * @param organizationId the primary key for the new legal org
	 * @return the new legal org
	 */
	public static LegalOrg create(long organizationId) {
		return getPersistence().create(organizationId);
	}

	/**
	 * Removes the legal org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org that was removed
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg remove(long organizationId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().remove(organizationId);
	}

	public static LegalOrg updateImpl(LegalOrg legalOrg) {
		return getPersistence().updateImpl(legalOrg);
	}

	/**
	 * Returns the legal org with the primary key or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public static LegalOrg findByPrimaryKey(long organizationId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalOrgException {

		return getPersistence().findByPrimaryKey(organizationId);
	}

	/**
	 * Returns the legal org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org, or <code>null</code> if a legal org with the primary key could not be found
	 */
	public static LegalOrg fetchByPrimaryKey(long organizationId) {
		return getPersistence().fetchByPrimaryKey(organizationId);
	}

	/**
	 * Returns all the legal orgs.
	 *
	 * @return the legal orgs
	 */
	public static List<LegalOrg> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of legal orgs
	 */
	public static List<LegalOrg> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal orgs
	 */
	public static List<LegalOrg> findAll(
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal orgs
	 */
	public static List<LegalOrg> findAll(
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal orgs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal orgs.
	 *
	 * @return the number of legal orgs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalOrgPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalOrgPersistence, LegalOrgPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalOrgPersistence.class);

		ServiceTracker<LegalOrgPersistence, LegalOrgPersistence>
			serviceTracker =
				new ServiceTracker<LegalOrgPersistence, LegalOrgPersistence>(
					bundle.getBundleContext(), LegalOrgPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}