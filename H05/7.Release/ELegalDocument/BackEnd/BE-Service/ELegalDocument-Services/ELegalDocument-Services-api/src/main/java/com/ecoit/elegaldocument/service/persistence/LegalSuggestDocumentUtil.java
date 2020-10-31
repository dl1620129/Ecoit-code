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

import com.ecoit.elegaldocument.model.LegalSuggestDocument;

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
 * The persistence utility for the legal suggest document service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalSuggestDocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalSuggestDocumentPersistence
 * @generated
 */
public class LegalSuggestDocumentUtil {

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
	public static void clearCache(LegalSuggestDocument legalSuggestDocument) {
		getPersistence().clearCache(legalSuggestDocument);
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
	public static Map<Serializable, LegalSuggestDocument> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalSuggestDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalSuggestDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalSuggestDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalSuggestDocument update(
		LegalSuggestDocument legalSuggestDocument) {

		return getPersistence().update(legalSuggestDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalSuggestDocument update(
		LegalSuggestDocument legalSuggestDocument,
		ServiceContext serviceContext) {

		return getPersistence().update(legalSuggestDocument, serviceContext);
	}

	/**
	 * Returns all the legal suggest documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByGroupId_First(
			long groupId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByGroupId_First(
		long groupId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByGroupId_Last(
			long groupId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByGroupId_Last(
		long groupId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findByGroupId_PrevAndNext(
			long sugId, long groupId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByGroupId_PrevAndNext(
			sugId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal suggest documents
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved) {

		return getPersistence().findByP_A(groupId, approved);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end) {

		return getPersistence().findByP_A(groupId, approved, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findByP_A(
			groupId, approved, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_A(
			groupId, approved, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByP_A_First(
			long groupId, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByP_A_First(
			groupId, approved, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByP_A_First(
		long groupId, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByP_A_First(
			groupId, approved, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByP_A_Last(
			long groupId, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByP_A_Last(
			groupId, approved, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByP_A_Last(
		long groupId, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByP_A_Last(
			groupId, approved, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findByP_A_PrevAndNext(
			long sugId, long groupId, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByP_A_PrevAndNext(
			sugId, groupId, approved, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 */
	public static void removeByP_A(long groupId, boolean approved) {
		getPersistence().removeByP_A(groupId, approved);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the number of matching legal suggest documents
	 */
	public static int countByP_A(long groupId, boolean approved) {
		return getPersistence().countByP_A(groupId, approved);
	}

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or throws a <code>NoSuchLegalSuggestDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByG_S(long groupId, long sugId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_S(groupId, sugId);
	}

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByG_S(long groupId, long sugId) {
		return getPersistence().fetchByG_S(groupId, sugId);
	}

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByG_S(
		long groupId, long sugId, boolean useFinderCache) {

		return getPersistence().fetchByG_S(groupId, sugId, useFinderCache);
	}

	/**
	 * Removes the legal suggest document where groupId = &#63; and sugId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the legal suggest document that was removed
	 */
	public static LegalSuggestDocument removeByG_S(long groupId, long sugId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().removeByG_S(groupId, sugId);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and sugId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the number of matching legal suggest documents
	 */
	public static int countByG_S(long groupId, long sugId) {
		return getPersistence().countByG_S(groupId, sugId);
	}

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L(
		long groupId, String language) {

		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findByG_L_PrevAndNext(
			long sugId, long groupId, String language,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_L_PrevAndNext(
			sugId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal suggest documents
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved) {

		return getPersistence().findByG_L_A(groupId, language, approved);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end) {

		return getPersistence().findByG_L_A(
			groupId, language, approved, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findByG_L_A(
			groupId, language, approved, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_A(
			groupId, language, approved, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByG_L_A_First(
			long groupId, String language, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_L_A_First(
			groupId, language, approved, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByG_L_A_First(
		long groupId, String language, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByG_L_A_First(
			groupId, language, approved, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByG_L_A_Last(
			long groupId, String language, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_L_A_Last(
			groupId, language, approved, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByG_L_A_Last(
		long groupId, String language, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByG_L_A_Last(
			groupId, language, approved, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findByG_L_A_PrevAndNext(
			long sugId, long groupId, String language, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByG_L_A_PrevAndNext(
			sugId, groupId, language, approved, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 */
	public static void removeByG_L_A(
		long groupId, String language, boolean approved) {

		getPersistence().removeByG_L_A(groupId, language, approved);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the number of matching legal suggest documents
	 */
	public static int countByG_L_A(
		long groupId, String language, boolean approved) {

		return getPersistence().countByG_L_A(groupId, language, approved);
	}

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId) {

		return getPersistence().findByP_L_A_D(
			groupId, language, approved, docId);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end) {

		return getPersistence().findByP_L_A_D(
			groupId, language, approved, docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end, OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findByP_L_A_D(
			groupId, language, approved, docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end, OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_L_A_D(
			groupId, language, approved, docId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByP_L_A_D_First(
			long groupId, String language, boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByP_L_A_D_First(
			groupId, language, approved, docId, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByP_L_A_D_First(
		long groupId, String language, boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByP_L_A_D_First(
			groupId, language, approved, docId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByP_L_A_D_Last(
			long groupId, String language, boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByP_L_A_D_Last(
			groupId, language, approved, docId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByP_L_A_D_Last(
		long groupId, String language, boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByP_L_A_D_Last(
			groupId, language, approved, docId, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findByP_L_A_D_PrevAndNext(
			long sugId, long groupId, String language, boolean approved,
			long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByP_L_A_D_PrevAndNext(
			sugId, groupId, language, approved, docId, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 */
	public static void removeByP_L_A_D(
		long groupId, String language, boolean approved, long docId) {

		getPersistence().removeByP_L_A_D(groupId, language, approved, docId);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	public static int countByP_L_A_D(
		long groupId, String language, boolean approved, long docId) {

		return getPersistence().countByP_L_A_D(
			groupId, language, approved, docId);
	}

	/**
	 * Returns all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId) {

		return getPersistence().findByA_D(approved, docId);
	}

	/**
	 * Returns a range of all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end) {

		return getPersistence().findByA_D(approved, docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findByA_D(
			approved, docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByA_D(
			approved, docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByA_D_First(
			boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByA_D_First(
			approved, docId, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByA_D_First(
		boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByA_D_First(
			approved, docId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findByA_D_Last(
			boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByA_D_Last(
			approved, docId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchByA_D_Last(
		boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchByA_D_Last(
			approved, docId, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findByA_D_PrevAndNext(
			long sugId, boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByA_D_PrevAndNext(
			sugId, approved, docId, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where approved = &#63; and docId = &#63; from the database.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 */
	public static void removeByA_D(boolean approved, long docId) {
		getPersistence().removeByA_D(approved, docId);
	}

	/**
	 * Returns the number of legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	public static int countByA_D(boolean approved, long docId) {
		return getPersistence().countByA_D(approved, docId);
	}

	/**
	 * Returns all the legal suggest documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findBySuggByDocId(long docId) {
		return getPersistence().findBySuggByDocId(docId);
	}

	/**
	 * Returns a range of all the legal suggest documents where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end) {

		return getPersistence().findBySuggByDocId(docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findBySuggByDocId(
			docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	public static List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySuggByDocId(
			docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findBySuggByDocId_First(
			long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findBySuggByDocId_First(
			docId, orderByComparator);
	}

	/**
	 * Returns the first legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchBySuggByDocId_First(
		long docId, OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchBySuggByDocId_First(
			docId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument findBySuggByDocId_Last(
			long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findBySuggByDocId_Last(
			docId, orderByComparator);
	}

	/**
	 * Returns the last legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public static LegalSuggestDocument fetchBySuggByDocId_Last(
		long docId, OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().fetchBySuggByDocId_Last(
			docId, orderByComparator);
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument[] findBySuggByDocId_PrevAndNext(
			long sugId, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findBySuggByDocId_PrevAndNext(
			sugId, docId, orderByComparator);
	}

	/**
	 * Removes all the legal suggest documents where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public static void removeBySuggByDocId(long docId) {
		getPersistence().removeBySuggByDocId(docId);
	}

	/**
	 * Returns the number of legal suggest documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	public static int countBySuggByDocId(long docId) {
		return getPersistence().countBySuggByDocId(docId);
	}

	/**
	 * Caches the legal suggest document in the entity cache if it is enabled.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 */
	public static void cacheResult(LegalSuggestDocument legalSuggestDocument) {
		getPersistence().cacheResult(legalSuggestDocument);
	}

	/**
	 * Caches the legal suggest documents in the entity cache if it is enabled.
	 *
	 * @param legalSuggestDocuments the legal suggest documents
	 */
	public static void cacheResult(
		List<LegalSuggestDocument> legalSuggestDocuments) {

		getPersistence().cacheResult(legalSuggestDocuments);
	}

	/**
	 * Creates a new legal suggest document with the primary key. Does not add the legal suggest document to the database.
	 *
	 * @param sugId the primary key for the new legal suggest document
	 * @return the new legal suggest document
	 */
	public static LegalSuggestDocument create(long sugId) {
		return getPersistence().create(sugId);
	}

	/**
	 * Removes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument remove(long sugId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().remove(sugId);
	}

	public static LegalSuggestDocument updateImpl(
		LegalSuggestDocument legalSuggestDocument) {

		return getPersistence().updateImpl(legalSuggestDocument);
	}

	/**
	 * Returns the legal suggest document with the primary key or throws a <code>NoSuchLegalSuggestDocumentException</code> if it could not be found.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument findByPrimaryKey(long sugId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalSuggestDocumentException {

		return getPersistence().findByPrimaryKey(sugId);
	}

	/**
	 * Returns the legal suggest document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document, or <code>null</code> if a legal suggest document with the primary key could not be found
	 */
	public static LegalSuggestDocument fetchByPrimaryKey(long sugId) {
		return getPersistence().fetchByPrimaryKey(sugId);
	}

	/**
	 * Returns all the legal suggest documents.
	 *
	 * @return the legal suggest documents
	 */
	public static List<LegalSuggestDocument> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of legal suggest documents
	 */
	public static List<LegalSuggestDocument> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal suggest documents
	 */
	public static List<LegalSuggestDocument> findAll(
		int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal suggest documents
	 */
	public static List<LegalSuggestDocument> findAll(
		int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal suggest documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal suggest documents.
	 *
	 * @return the number of legal suggest documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalSuggestDocumentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalSuggestDocumentPersistence, LegalSuggestDocumentPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalSuggestDocumentPersistence.class);

		ServiceTracker
			<LegalSuggestDocumentPersistence, LegalSuggestDocumentPersistence>
				serviceTracker =
					new ServiceTracker
						<LegalSuggestDocumentPersistence,
						 LegalSuggestDocumentPersistence>(
							 bundle.getBundleContext(),
							 LegalSuggestDocumentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}