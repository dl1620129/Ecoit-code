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

import com.ecoit.elegaldocument.model.LegalType;

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
 * The persistence utility for the legal type service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalTypePersistence
 * @generated
 */
public class LegalTypeUtil {

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
	public static void clearCache(LegalType legalType) {
		getPersistence().clearCache(legalType);
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
	public static Map<Serializable, LegalType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalType update(LegalType legalType) {
		return getPersistence().update(legalType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalType update(
		LegalType legalType, ServiceContext serviceContext) {

		return getPersistence().update(legalType, serviceContext);
	}

	/**
	 * Returns the legal type where typeId = &#63; or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param typeId the type ID
	 * @return the matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByTypeId(long typeId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByTypeId(typeId);
	}

	/**
	 * Returns the legal type where typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeId the type ID
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByTypeId(long typeId) {
		return getPersistence().fetchByTypeId(typeId);
	}

	/**
	 * Returns the legal type where typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByTypeId(long typeId, boolean useFinderCache) {
		return getPersistence().fetchByTypeId(typeId, useFinderCache);
	}

	/**
	 * Removes the legal type where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @return the legal type that was removed
	 */
	public static LegalType removeByTypeId(long typeId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().removeByTypeId(typeId);
	}

	/**
	 * Returns the number of legal types where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal types
	 */
	public static int countByTypeId(long typeId) {
		return getPersistence().countByTypeId(typeId);
	}

	/**
	 * Returns all the legal types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal types
	 */
	public static List<LegalType> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByGroupId_First(
			long groupId, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByGroupId_First(
		long groupId, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByGroupId_Last(
			long groupId, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByGroupId_PrevAndNext(
			long typeId, long groupId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByGroupId_PrevAndNext(
			typeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal types
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal types
	 */
	public static List<LegalType> findByG_L(long groupId, String language) {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByG_L_PrevAndNext(
			long typeId, long groupId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_L_PrevAndNext(
			typeId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal types
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_T(long groupId, long typeId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_T(groupId, typeId);
	}

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_T(long groupId, long typeId) {
		return getPersistence().fetchByG_T(groupId, typeId);
	}

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_T(
		long groupId, long typeId, boolean useFinderCache) {

		return getPersistence().fetchByG_T(groupId, typeId, useFinderCache);
	}

	/**
	 * Removes the legal type where groupId = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the legal type that was removed
	 */
	public static LegalType removeByG_T(long groupId, long typeId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().removeByG_T(groupId, typeId);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the number of matching legal types
	 */
	public static int countByG_T(long groupId, long typeId) {
		return getPersistence().countByG_T(groupId, typeId);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @return the matching legal types
	 */
	public static List<LegalType> findByS_L(
		long groupId, boolean statusType, String language) {

		return getPersistence().findByS_L(groupId, statusType, language);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end) {

		return getPersistence().findByS_L(
			groupId, statusType, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByS_L(
			groupId, statusType, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_L(
			groupId, statusType, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByS_L_First(
			long groupId, boolean statusType, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByS_L_First(
			groupId, statusType, language, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByS_L_First(
		long groupId, boolean statusType, String language,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByS_L_First(
			groupId, statusType, language, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByS_L_Last(
			long groupId, boolean statusType, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByS_L_Last(
			groupId, statusType, language, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByS_L_Last(
		long groupId, boolean statusType, String language,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByS_L_Last(
			groupId, statusType, language, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByS_L_PrevAndNext(
			long typeId, long groupId, boolean statusType, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByS_L_PrevAndNext(
			typeId, groupId, statusType, language, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and statusType = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 */
	public static void removeByS_L(
		long groupId, boolean statusType, String language) {

		getPersistence().removeByS_L(groupId, statusType, language);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @return the number of matching legal types
	 */
	public static int countByS_L(
		long groupId, boolean statusType, String language) {

		return getPersistence().countByS_L(groupId, statusType, language);
	}

	/**
	 * Returns all the legal types where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public static List<LegalType> findByType_Status(boolean statusType) {
		return getPersistence().findByType_Status(statusType);
	}

	/**
	 * Returns a range of all the legal types where statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByType_Status(
		boolean statusType, int start, int end) {

		return getPersistence().findByType_Status(statusType, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByType_Status(
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByType_Status(
			statusType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByType_Status(
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType_Status(
			statusType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByType_Status_First(
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByType_Status_First(
			statusType, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByType_Status_First(
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByType_Status_First(
			statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByType_Status_Last(
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByType_Status_Last(
			statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByType_Status_Last(
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByType_Status_Last(
			statusType, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByType_Status_PrevAndNext(
			long typeId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByType_Status_PrevAndNext(
			typeId, statusType, orderByComparator);
	}

	/**
	 * Removes all the legal types where statusType = &#63; from the database.
	 *
	 * @param statusType the status type
	 */
	public static void removeByType_Status(boolean statusType) {
		getPersistence().removeByType_Status(statusType);
	}

	/**
	 * Returns the number of legal types where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public static int countByType_Status(boolean statusType) {
		return getPersistence().countByType_Status(statusType);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @return the matching legal types
	 */
	public static List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable) {

		return getPersistence().findByS_Rss(groupId, statusType, rssable);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end) {

		return getPersistence().findByS_Rss(
			groupId, statusType, rssable, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByS_Rss(
			groupId, statusType, rssable, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_Rss(
			groupId, statusType, rssable, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByS_Rss_First(
			long groupId, boolean statusType, boolean rssable,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByS_Rss_First(
			groupId, statusType, rssable, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByS_Rss_First(
		long groupId, boolean statusType, boolean rssable,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByS_Rss_First(
			groupId, statusType, rssable, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByS_Rss_Last(
			long groupId, boolean statusType, boolean rssable,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByS_Rss_Last(
			groupId, statusType, rssable, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByS_Rss_Last(
		long groupId, boolean statusType, boolean rssable,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByS_Rss_Last(
			groupId, statusType, rssable, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByS_Rss_PrevAndNext(
			long typeId, long groupId, boolean statusType, boolean rssable,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByS_Rss_PrevAndNext(
			typeId, groupId, statusType, rssable, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 */
	public static void removeByS_Rss(
		long groupId, boolean statusType, boolean rssable) {

		getPersistence().removeByS_Rss(groupId, statusType, rssable);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @return the number of matching legal types
	 */
	public static int countByS_Rss(
		long groupId, boolean statusType, boolean rssable) {

		return getPersistence().countByS_Rss(groupId, statusType, rssable);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public static List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType) {

		return getPersistence().findByFindGroup(groupId, companyId, statusType);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusType, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusType, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByFindGroup_First(
			long groupId, long companyId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, statusType, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByFindGroup_First(
		long groupId, long companyId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByFindGroup_Last(
			long groupId, long companyId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, statusType, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByFindGroup_PrevAndNext(
			long typeId, long groupId, long companyId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindGroup_PrevAndNext(
			typeId, groupId, companyId, statusType, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 */
	public static void removeByFindGroup(
		long groupId, long companyId, boolean statusType) {

		getPersistence().removeByFindGroup(groupId, companyId, statusType);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public static int countByFindGroup(
		long groupId, long companyId, boolean statusType) {

		return getPersistence().countByFindGroup(
			groupId, companyId, statusType);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal types
	 */
	public static List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId) {

		return getPersistence().findByG_C_P(groupId, companyId, parentId);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end) {

		return getPersistence().findByG_C_P(
			groupId, companyId, parentId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByG_C_P(
			groupId, companyId, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_P(
			groupId, companyId, parentId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_P_First(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_P_First(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_P_First(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_P_First(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_P_Last(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_P_Last(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_P_Last(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_P_Last(
			groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByG_C_P_PrevAndNext(
			long typeId, long groupId, long companyId, long parentId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_P_PrevAndNext(
			typeId, groupId, companyId, parentId, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; from the database.
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
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal types
	 */
	public static int countByG_C_P(
		long groupId, long companyId, long parentId) {

		return getPersistence().countByG_C_P(groupId, companyId, parentId);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public static List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_L_P_S_First(
			long groupId, long companyId, String language, long parentId,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_P_S_First(
			groupId, companyId, language, parentId, statusType,
			orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_L_P_S_First(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_L_P_S_First(
			groupId, companyId, language, parentId, statusType,
			orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_L_P_S_Last(
			long groupId, long companyId, String language, long parentId,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_P_S_Last(
			groupId, companyId, language, parentId, statusType,
			orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_L_P_S_Last(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_L_P_S_Last(
			groupId, companyId, language, parentId, statusType,
			orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByG_C_L_P_S_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			long parentId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_P_S_PrevAndNext(
			typeId, groupId, companyId, language, parentId, statusType,
			orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 */
	public static void removeByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType) {

		getPersistence().removeByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public static int countByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType) {

		return getPersistence().countByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal types
	 */
	public static List<LegalType> findByG_C_L(
		long groupId, long companyId, String language) {

		return getPersistence().findByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_L_First(
			long groupId, long companyId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_First(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_L_First(
		long groupId, long companyId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_L_First(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_L_Last(
			long groupId, long companyId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_Last(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_L_Last(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByG_C_L_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_PrevAndNext(
			typeId, groupId, companyId, language, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
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
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal types
	 */
	public static int countByG_C_L(
		long groupId, long companyId, String language) {

		return getPersistence().countByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public static List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusType);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusType, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusType, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusType, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_S_First(
			groupId, companyId, language, statusType, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_L_S_First(
			groupId, companyId, language, statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_S_Last(
			groupId, companyId, language, statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByG_C_L_S_Last(
			groupId, companyId, language, statusType, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByG_C_L_S_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByG_C_L_S_PrevAndNext(
			typeId, groupId, companyId, language, statusType,
			orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 */
	public static void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType) {

		getPersistence().removeByG_C_L_S(
			groupId, companyId, language, statusType);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public static int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType) {

		return getPersistence().countByG_C_L_S(
			groupId, companyId, language, statusType);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public static List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByFindGroupCompanyParent_First(
			long groupId, long companyId, long parentId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindGroupCompanyParent_First(
			groupId, companyId, parentId, statusType, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByFindGroupCompanyParent_First(
		long groupId, long companyId, long parentId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByFindGroupCompanyParent_First(
			groupId, companyId, parentId, statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByFindGroupCompanyParent_Last(
			long groupId, long companyId, long parentId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindGroupCompanyParent_Last(
			groupId, companyId, parentId, statusType, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByFindGroupCompanyParent_Last(
		long groupId, long companyId, long parentId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByFindGroupCompanyParent_Last(
			groupId, companyId, parentId, statusType, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByFindGroupCompanyParent_PrevAndNext(
			long typeId, long groupId, long companyId, long parentId,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindGroupCompanyParent_PrevAndNext(
			typeId, groupId, companyId, parentId, statusType,
			orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 */
	public static void removeByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType) {

		getPersistence().removeByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public static int countByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType) {

		return getPersistence().countByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType);
	}

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal types
	 */
	public static List<LegalType> findByFindAll(long groupId, long companyId) {
		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	public static List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	public static List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public static LegalType findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public static LegalType fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType[] findByFindAll_PrevAndNext(
			long typeId, long groupId, long companyId,
			OrderByComparator<LegalType> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByFindAll_PrevAndNext(
			typeId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal types
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the legal type in the entity cache if it is enabled.
	 *
	 * @param legalType the legal type
	 */
	public static void cacheResult(LegalType legalType) {
		getPersistence().cacheResult(legalType);
	}

	/**
	 * Caches the legal types in the entity cache if it is enabled.
	 *
	 * @param legalTypes the legal types
	 */
	public static void cacheResult(List<LegalType> legalTypes) {
		getPersistence().cacheResult(legalTypes);
	}

	/**
	 * Creates a new legal type with the primary key. Does not add the legal type to the database.
	 *
	 * @param typeId the primary key for the new legal type
	 * @return the new legal type
	 */
	public static LegalType create(long typeId) {
		return getPersistence().create(typeId);
	}

	/**
	 * Removes the legal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type that was removed
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType remove(long typeId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().remove(typeId);
	}

	public static LegalType updateImpl(LegalType legalType) {
		return getPersistence().updateImpl(legalType);
	}

	/**
	 * Returns the legal type with the primary key or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public static LegalType findByPrimaryKey(long typeId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTypeException {

		return getPersistence().findByPrimaryKey(typeId);
	}

	/**
	 * Returns the legal type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type, or <code>null</code> if a legal type with the primary key could not be found
	 */
	public static LegalType fetchByPrimaryKey(long typeId) {
		return getPersistence().fetchByPrimaryKey(typeId);
	}

	/**
	 * Returns all the legal types.
	 *
	 * @return the legal types
	 */
	public static List<LegalType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of legal types
	 */
	public static List<LegalType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal types
	 */
	public static List<LegalType> findAll(
		int start, int end, OrderByComparator<LegalType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal types
	 */
	public static List<LegalType> findAll(
		int start, int end, OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal types.
	 *
	 * @return the number of legal types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalTypePersistence, LegalTypePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalTypePersistence.class);

		ServiceTracker<LegalTypePersistence, LegalTypePersistence>
			serviceTracker =
				new ServiceTracker<LegalTypePersistence, LegalTypePersistence>(
					bundle.getBundleContext(), LegalTypePersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}