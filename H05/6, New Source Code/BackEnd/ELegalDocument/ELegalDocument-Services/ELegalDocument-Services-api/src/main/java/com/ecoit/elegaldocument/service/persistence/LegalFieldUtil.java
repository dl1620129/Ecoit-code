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

import com.ecoit.elegaldocument.model.LegalField;

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
 * The persistence utility for the legal field service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalFieldPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalFieldPersistence
 * @generated
 */
public class LegalFieldUtil {

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
	public static void clearCache(LegalField legalField) {
		getPersistence().clearCache(legalField);
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
	public static Map<Serializable, LegalField> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalField> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalField update(LegalField legalField) {
		return getPersistence().update(legalField);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalField update(
		LegalField legalField, ServiceContext serviceContext) {

		return getPersistence().update(legalField, serviceContext);
	}

	/**
	 * Returns the legal field where fieldId = &#63; or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFieldId(long fieldId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFieldId(fieldId);
	}

	/**
	 * Returns the legal field where fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFieldId(long fieldId) {
		return getPersistence().fetchByFieldId(fieldId);
	}

	/**
	 * Returns the legal field where fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFieldId(
		long fieldId, boolean useFinderCache) {

		return getPersistence().fetchByFieldId(fieldId, useFinderCache);
	}

	/**
	 * Removes the legal field where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @return the legal field that was removed
	 */
	public static LegalField removeByFieldId(long fieldId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().removeByFieldId(fieldId);
	}

	/**
	 * Returns the number of legal fields where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal fields
	 */
	public static int countByFieldId(long fieldId) {
		return getPersistence().countByFieldId(fieldId);
	}

	/**
	 * Returns all the legal fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByGroupId_First(
			long groupId, OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByGroupId_First(
		long groupId, OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByGroupId_Last(
			long groupId, OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByGroupId_PrevAndNext(
			long fieldId, long groupId,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByGroupId_PrevAndNext(
			fieldId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal fields
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByG_L(long groupId, String language) {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByG_L_PrevAndNext(
			long fieldId, long groupId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_L_PrevAndNext(
			fieldId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_F(long groupId, long fieldId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_F(groupId, fieldId);
	}

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_F(long groupId, long fieldId) {
		return getPersistence().fetchByG_F(groupId, fieldId);
	}

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_F(
		long groupId, long fieldId, boolean useFinderCache) {

		return getPersistence().fetchByG_F(groupId, fieldId, useFinderCache);
	}

	/**
	 * Removes the legal field where groupId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the legal field that was removed
	 */
	public static LegalField removeByG_F(long groupId, long fieldId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().removeByG_F(groupId, fieldId);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the number of matching legal fields
	 */
	public static int countByG_F(long groupId, long fieldId) {
		return getPersistence().countByG_F(groupId, fieldId);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByS_L(
		long groupId, boolean statusField, String language) {

		return getPersistence().findByS_L(groupId, statusField, language);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start,
		int end) {

		return getPersistence().findByS_L(
			groupId, statusField, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByS_L(
			groupId, statusField, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_L(
			groupId, statusField, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByS_L_First(
			long groupId, boolean statusField, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByS_L_First(
			groupId, statusField, language, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByS_L_First(
		long groupId, boolean statusField, String language,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByS_L_First(
			groupId, statusField, language, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByS_L_Last(
			long groupId, boolean statusField, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByS_L_Last(
			groupId, statusField, language, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByS_L_Last(
		long groupId, boolean statusField, String language,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByS_L_Last(
			groupId, statusField, language, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByS_L_PrevAndNext(
			long fieldId, long groupId, boolean statusField, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByS_L_PrevAndNext(
			fieldId, groupId, statusField, language, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 */
	public static void removeByS_L(
		long groupId, boolean statusField, String language) {

		getPersistence().removeByS_L(groupId, statusField, language);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	public static int countByS_L(
		long groupId, boolean statusField, String language) {

		return getPersistence().countByS_L(groupId, statusField, language);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByG_C_L(
		long groupId, long companyId, String language) {

		return getPersistence().findByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_C_L_First(
			long groupId, long companyId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_C_L_First(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_C_L_First(
		long groupId, long companyId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByG_C_L_First(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_C_L_Last(
			long groupId, long companyId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_C_L_Last(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByG_C_L_Last(
			groupId, companyId, language, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByG_C_L_PrevAndNext(
			long fieldId, long groupId, long companyId, String language,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_C_L_PrevAndNext(
			fieldId, groupId, companyId, language, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
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
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	public static int countByG_C_L(
		long groupId, long companyId, String language) {

		return getPersistence().countByG_C_L(groupId, companyId, language);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusField);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusField, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end, OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusField, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end, OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_L_S(
			groupId, companyId, language, statusField, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_C_L_S_First(
			groupId, companyId, language, statusField, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByG_C_L_S_First(
			groupId, companyId, language, statusField, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_C_L_S_Last(
			groupId, companyId, language, statusField, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByG_C_L_S_Last(
			groupId, companyId, language, statusField, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByG_C_L_S_PrevAndNext(
			long fieldId, long groupId, long companyId, String language,
			boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByG_C_L_S_PrevAndNext(
			fieldId, groupId, companyId, language, statusField,
			orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 */
	public static void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField) {

		getPersistence().removeByG_C_L_S(
			groupId, companyId, language, statusField);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	public static int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField) {

		return getPersistence().countByG_C_L_S(
			groupId, companyId, language, statusField);
	}

	/**
	 * Returns all the legal fields where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByFieldStatus(boolean statusField) {
		return getPersistence().findByFieldStatus(statusField);
	}

	/**
	 * Returns a range of all the legal fields where statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end) {

		return getPersistence().findByFieldStatus(statusField, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByFieldStatus(
			statusField, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFieldStatus(
			statusField, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFieldStatus_First(
			boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFieldStatus_First(
			statusField, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFieldStatus_First(
		boolean statusField, OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByFieldStatus_First(
			statusField, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFieldStatus_Last(
			boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFieldStatus_Last(
			statusField, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFieldStatus_Last(
		boolean statusField, OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByFieldStatus_Last(
			statusField, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByFieldStatus_PrevAndNext(
			long fieldId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFieldStatus_PrevAndNext(
			fieldId, statusField, orderByComparator);
	}

	/**
	 * Removes all the legal fields where statusField = &#63; from the database.
	 *
	 * @param statusField the status field
	 */
	public static void removeByFieldStatus(boolean statusField) {
		getPersistence().removeByFieldStatus(statusField);
	}

	/**
	 * Returns the number of legal fields where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	public static int countByFieldStatus(boolean statusField) {
		return getPersistence().countByFieldStatus(statusField);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable) {

		return getPersistence().findByS_Rss(groupId, statusField, rssable);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start,
		int end) {

		return getPersistence().findByS_Rss(
			groupId, statusField, rssable, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByS_Rss(
			groupId, statusField, rssable, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_Rss(
			groupId, statusField, rssable, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByS_Rss_First(
			long groupId, boolean statusField, boolean rssable,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByS_Rss_First(
			groupId, statusField, rssable, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByS_Rss_First(
		long groupId, boolean statusField, boolean rssable,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByS_Rss_First(
			groupId, statusField, rssable, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByS_Rss_Last(
			long groupId, boolean statusField, boolean rssable,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByS_Rss_Last(
			groupId, statusField, rssable, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByS_Rss_Last(
		long groupId, boolean statusField, boolean rssable,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByS_Rss_Last(
			groupId, statusField, rssable, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByS_Rss_PrevAndNext(
			long fieldId, long groupId, boolean statusField, boolean rssable,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByS_Rss_PrevAndNext(
			fieldId, groupId, statusField, rssable, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 */
	public static void removeByS_Rss(
		long groupId, boolean statusField, boolean rssable) {

		getPersistence().removeByS_Rss(groupId, statusField, rssable);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @return the number of matching legal fields
	 */
	public static int countByS_Rss(
		long groupId, boolean statusField, boolean rssable) {

		return getPersistence().countByS_Rss(groupId, statusField, rssable);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusField);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusField, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusField, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusField, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFindGroup_First(
			long groupId, long companyId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, statusField, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFindGroup_First(
		long groupId, long companyId, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, statusField, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFindGroup_Last(
			long groupId, long companyId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, statusField, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusField,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, statusField, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByFindGroup_PrevAndNext(
			long fieldId, long groupId, long companyId, boolean statusField,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFindGroup_PrevAndNext(
			fieldId, groupId, companyId, statusField, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 */
	public static void removeByFindGroup(
		long groupId, long companyId, boolean statusField) {

		getPersistence().removeByFindGroup(groupId, companyId, statusField);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	public static int countByFindGroup(
		long groupId, long companyId, boolean statusField) {

		return getPersistence().countByFindGroup(
			groupId, companyId, statusField);
	}

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal fields
	 */
	public static List<LegalField> findByFindAll(long groupId, long companyId) {
		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of matching legal fields
	 */
	public static List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fields
	 */
	public static List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public static LegalField findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public static LegalField fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField[] findByFindAll_PrevAndNext(
			long fieldId, long groupId, long companyId,
			OrderByComparator<LegalField> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByFindAll_PrevAndNext(
			fieldId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal fields
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the legal field in the entity cache if it is enabled.
	 *
	 * @param legalField the legal field
	 */
	public static void cacheResult(LegalField legalField) {
		getPersistence().cacheResult(legalField);
	}

	/**
	 * Caches the legal fields in the entity cache if it is enabled.
	 *
	 * @param legalFields the legal fields
	 */
	public static void cacheResult(List<LegalField> legalFields) {
		getPersistence().cacheResult(legalFields);
	}

	/**
	 * Creates a new legal field with the primary key. Does not add the legal field to the database.
	 *
	 * @param fieldId the primary key for the new legal field
	 * @return the new legal field
	 */
	public static LegalField create(long fieldId) {
		return getPersistence().create(fieldId);
	}

	/**
	 * Removes the legal field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field that was removed
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField remove(long fieldId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().remove(fieldId);
	}

	public static LegalField updateImpl(LegalField legalField) {
		return getPersistence().updateImpl(legalField);
	}

	/**
	 * Returns the legal field with the primary key or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public static LegalField findByPrimaryKey(long fieldId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFieldException {

		return getPersistence().findByPrimaryKey(fieldId);
	}

	/**
	 * Returns the legal field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field, or <code>null</code> if a legal field with the primary key could not be found
	 */
	public static LegalField fetchByPrimaryKey(long fieldId) {
		return getPersistence().fetchByPrimaryKey(fieldId);
	}

	/**
	 * Returns all the legal fields.
	 *
	 * @return the legal fields
	 */
	public static List<LegalField> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of legal fields
	 */
	public static List<LegalField> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal fields
	 */
	public static List<LegalField> findAll(
		int start, int end, OrderByComparator<LegalField> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal fields
	 */
	public static List<LegalField> findAll(
		int start, int end, OrderByComparator<LegalField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal fields from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal fields.
	 *
	 * @return the number of legal fields
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalFieldPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalFieldPersistence, LegalFieldPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalFieldPersistence.class);

		ServiceTracker<LegalFieldPersistence, LegalFieldPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalFieldPersistence, LegalFieldPersistence>(
						bundle.getBundleContext(), LegalFieldPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}