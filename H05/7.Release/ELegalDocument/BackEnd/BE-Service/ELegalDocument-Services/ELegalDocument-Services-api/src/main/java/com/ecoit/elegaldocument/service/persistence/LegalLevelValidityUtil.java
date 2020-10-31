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

import com.ecoit.elegaldocument.model.LegalLevelValidity;

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
 * The persistence utility for the legal level validity service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalLevelValidityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalLevelValidityPersistence
 * @generated
 */
public class LegalLevelValidityUtil {

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
	public static void clearCache(LegalLevelValidity legalLevelValidity) {
		getPersistence().clearCache(legalLevelValidity);
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
	public static Map<Serializable, LegalLevelValidity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalLevelValidity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalLevelValidity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalLevelValidity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalLevelValidity update(
		LegalLevelValidity legalLevelValidity) {

		return getPersistence().update(legalLevelValidity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalLevelValidity update(
		LegalLevelValidity legalLevelValidity, ServiceContext serviceContext) {

		return getPersistence().update(legalLevelValidity, serviceContext);
	}

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByLevelValidityId(long levelValidityId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByLevelValidityId(levelValidityId);
	}

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByLevelValidityId(
		long levelValidityId) {

		return getPersistence().fetchByLevelValidityId(levelValidityId);
	}

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelValidityId the level validity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByLevelValidityId(
		long levelValidityId, boolean useFinderCache) {

		return getPersistence().fetchByLevelValidityId(
			levelValidityId, useFinderCache);
	}

	/**
	 * Removes the legal level validity where levelValidityId = &#63; from the database.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the legal level validity that was removed
	 */
	public static LegalLevelValidity removeByLevelValidityId(
			long levelValidityId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().removeByLevelValidityId(levelValidityId);
	}

	/**
	 * Returns the number of legal level validities where levelValidityId = &#63;.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the number of matching legal level validities
	 */
	public static int countByLevelValidityId(long levelValidityId) {
		return getPersistence().countByLevelValidityId(levelValidityId);
	}

	/**
	 * Returns all the legal level validities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal level validities
	 */
	public static List<LegalLevelValidity> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByGroupId_First(
			long groupId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByGroupId_First(
		long groupId, OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByGroupId_Last(
			long groupId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity[] findByGroupId_PrevAndNext(
			long levelValidityId, long groupId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByGroupId_PrevAndNext(
			levelValidityId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal level validities
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByG_LV(
			long groupId, long levelValidityId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_LV(groupId, levelValidityId);
	}

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByG_LV(
		long groupId, long levelValidityId) {

		return getPersistence().fetchByG_LV(groupId, levelValidityId);
	}

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByG_LV(
		long groupId, long levelValidityId, boolean useFinderCache) {

		return getPersistence().fetchByG_LV(
			groupId, levelValidityId, useFinderCache);
	}

	/**
	 * Removes the legal level validity where groupId = &#63; and levelValidityId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the legal level validity that was removed
	 */
	public static LegalLevelValidity removeByG_LV(
			long groupId, long levelValidityId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().removeByG_LV(groupId, levelValidityId);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and levelValidityId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the number of matching legal level validities
	 */
	public static int countByG_LV(long groupId, long levelValidityId) {
		return getPersistence().countByG_LV(groupId, levelValidityId);
	}

	/**
	 * Returns all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L(
		long groupId, String language) {

		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity[] findByG_L_PrevAndNext(
			long levelValidityId, long groupId, String language,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_L_PrevAndNext(
			levelValidityId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal level validities
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity) {

		return getPersistence().findByG_L_S(
			groupId, language, statusLevelValidity);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end) {

		return getPersistence().findByG_L_S(
			groupId, language, statusLevelValidity, start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findByG_L_S(
			groupId, language, statusLevelValidity, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_S(
			groupId, language, statusLevelValidity, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByG_L_S_First(
			long groupId, String language, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_L_S_First(
			groupId, language, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByG_L_S_First(
		long groupId, String language, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByG_L_S_First(
			groupId, language, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByG_L_S_Last(
			long groupId, String language, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_L_S_Last(
			groupId, language, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByG_L_S_Last(
		long groupId, String language, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByG_L_S_Last(
			groupId, language, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity[] findByG_L_S_PrevAndNext(
			long levelValidityId, long groupId, String language,
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByG_L_S_PrevAndNext(
			levelValidityId, groupId, language, statusLevelValidity,
			orderByComparator);
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 */
	public static void removeByG_L_S(
		long groupId, String language, boolean statusLevelValidity) {

		getPersistence().removeByG_L_S(groupId, language, statusLevelValidity);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	public static int countByG_L_S(
		long groupId, String language, boolean statusLevelValidity) {

		return getPersistence().countByG_L_S(
			groupId, language, statusLevelValidity);
	}

	/**
	 * Returns all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	public static List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity) {

		return getPersistence().findByStatusLevelValidity(statusLevelValidity);
	}

	/**
	 * Returns a range of all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end) {

		return getPersistence().findByStatusLevelValidity(
			statusLevelValidity, start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findByStatusLevelValidity(
			statusLevelValidity, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusLevelValidity(
			statusLevelValidity, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByStatusLevelValidity_First(
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByStatusLevelValidity_First(
			statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the first legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByStatusLevelValidity_First(
		boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByStatusLevelValidity_First(
			statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByStatusLevelValidity_Last(
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByStatusLevelValidity_Last(
			statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByStatusLevelValidity_Last(
		boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByStatusLevelValidity_Last(
			statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity[] findByStatusLevelValidity_PrevAndNext(
			long levelValidityId, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByStatusLevelValidity_PrevAndNext(
			levelValidityId, statusLevelValidity, orderByComparator);
	}

	/**
	 * Removes all the legal level validities where statusLevelValidity = &#63; from the database.
	 *
	 * @param statusLevelValidity the status level validity
	 */
	public static void removeByStatusLevelValidity(
		boolean statusLevelValidity) {

		getPersistence().removeByStatusLevelValidity(statusLevelValidity);
	}

	/**
	 * Returns the number of legal level validities where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	public static int countByStatusLevelValidity(boolean statusLevelValidity) {
		return getPersistence().countByStatusLevelValidity(statusLevelValidity);
	}

	/**
	 * Returns all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusLevelValidity);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusLevelValidity, start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusLevelValidity, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusLevelValidity, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByFindGroup_First(
			long groupId, long companyId, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByFindGroup_First(
		long groupId, long companyId, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByFindGroup_Last(
			long groupId, long companyId, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, statusLevelValidity, orderByComparator);
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity[] findByFindGroup_PrevAndNext(
			long levelValidityId, long groupId, long companyId,
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByFindGroup_PrevAndNext(
			levelValidityId, groupId, companyId, statusLevelValidity,
			orderByComparator);
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 */
	public static void removeByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity) {

		getPersistence().removeByFindGroup(
			groupId, companyId, statusLevelValidity);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	public static int countByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity) {

		return getPersistence().countByFindGroup(
			groupId, companyId, statusLevelValidity);
	}

	/**
	 * Returns all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId) {

		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	public static List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public static LegalLevelValidity fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity[] findByFindAll_PrevAndNext(
			long levelValidityId, long groupId, long companyId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByFindAll_PrevAndNext(
			levelValidityId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal level validities
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the legal level validity in the entity cache if it is enabled.
	 *
	 * @param legalLevelValidity the legal level validity
	 */
	public static void cacheResult(LegalLevelValidity legalLevelValidity) {
		getPersistence().cacheResult(legalLevelValidity);
	}

	/**
	 * Caches the legal level validities in the entity cache if it is enabled.
	 *
	 * @param legalLevelValidities the legal level validities
	 */
	public static void cacheResult(
		List<LegalLevelValidity> legalLevelValidities) {

		getPersistence().cacheResult(legalLevelValidities);
	}

	/**
	 * Creates a new legal level validity with the primary key. Does not add the legal level validity to the database.
	 *
	 * @param levelValidityId the primary key for the new legal level validity
	 * @return the new legal level validity
	 */
	public static LegalLevelValidity create(long levelValidityId) {
		return getPersistence().create(levelValidityId);
	}

	/**
	 * Removes the legal level validity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity that was removed
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity remove(long levelValidityId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().remove(levelValidityId);
	}

	public static LegalLevelValidity updateImpl(
		LegalLevelValidity legalLevelValidity) {

		return getPersistence().updateImpl(legalLevelValidity);
	}

	/**
	 * Returns the legal level validity with the primary key or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity findByPrimaryKey(long levelValidityId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalLevelValidityException {

		return getPersistence().findByPrimaryKey(levelValidityId);
	}

	/**
	 * Returns the legal level validity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity, or <code>null</code> if a legal level validity with the primary key could not be found
	 */
	public static LegalLevelValidity fetchByPrimaryKey(long levelValidityId) {
		return getPersistence().fetchByPrimaryKey(levelValidityId);
	}

	/**
	 * Returns all the legal level validities.
	 *
	 * @return the legal level validities
	 */
	public static List<LegalLevelValidity> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of legal level validities
	 */
	public static List<LegalLevelValidity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal level validities
	 */
	public static List<LegalLevelValidity> findAll(
		int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal level validities
	 */
	public static List<LegalLevelValidity> findAll(
		int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal level validities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal level validities.
	 *
	 * @return the number of legal level validities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalLevelValidityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalLevelValidityPersistence, LegalLevelValidityPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalLevelValidityPersistence.class);

		ServiceTracker
			<LegalLevelValidityPersistence, LegalLevelValidityPersistence>
				serviceTracker =
					new ServiceTracker
						<LegalLevelValidityPersistence,
						 LegalLevelValidityPersistence>(
							 bundle.getBundleContext(),
							 LegalLevelValidityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}