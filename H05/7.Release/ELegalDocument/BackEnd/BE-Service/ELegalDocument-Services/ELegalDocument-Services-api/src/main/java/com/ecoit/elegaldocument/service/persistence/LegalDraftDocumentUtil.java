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

import com.ecoit.elegaldocument.model.LegalDraftDocument;

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
 * The persistence utility for the legal draft document service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalDraftDocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDraftDocumentPersistence
 * @generated
 */
public class LegalDraftDocumentUtil {

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
	public static void clearCache(LegalDraftDocument legalDraftDocument) {
		getPersistence().clearCache(legalDraftDocument);
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
	public static Map<Serializable, LegalDraftDocument> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalDraftDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDraftDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDraftDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalDraftDocument update(
		LegalDraftDocument legalDraftDocument) {

		return getPersistence().update(legalDraftDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalDraftDocument update(
		LegalDraftDocument legalDraftDocument, ServiceContext serviceContext) {

		return getPersistence().update(legalDraftDocument, serviceContext);
	}

	/**
	 * Returns the legal draft document where draftId = &#63; or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param draftId the draft ID
	 * @return the matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findBydraftId(long draftId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findBydraftId(draftId);
	}

	/**
	 * Returns the legal draft document where draftId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param draftId the draft ID
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchBydraftId(long draftId) {
		return getPersistence().fetchBydraftId(draftId);
	}

	/**
	 * Returns the legal draft document where draftId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param draftId the draft ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchBydraftId(
		long draftId, boolean useFinderCache) {

		return getPersistence().fetchBydraftId(draftId, useFinderCache);
	}

	/**
	 * Removes the legal draft document where draftId = &#63; from the database.
	 *
	 * @param draftId the draft ID
	 * @return the legal draft document that was removed
	 */
	public static LegalDraftDocument removeBydraftId(long draftId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().removeBydraftId(draftId);
	}

	/**
	 * Returns the number of legal draft documents where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the number of matching legal draft documents
	 */
	public static int countBydraftId(long draftId) {
		return getPersistence().countBydraftId(draftId);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByGroupId_First(
			long groupId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByGroupId_First(
		long groupId, OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByGroupId_Last(
			long groupId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByGroupId_PrevAndNext(
			long draftId, long groupId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByGroupId_PrevAndNext(
			draftId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal draft documents
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByG_L(
		long groupId, String language) {

		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByG_L_PrevAndNext(
			long draftId, long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByG_L_PrevAndNext(
			draftId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByG_D(long groupId, long draftId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByG_D(groupId, draftId);
	}

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByG_D(long groupId, long draftId) {
		return getPersistence().fetchByG_D(groupId, draftId);
	}

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByG_D(
		long groupId, long draftId, boolean useFinderCache) {

		return getPersistence().fetchByG_D(groupId, draftId, useFinderCache);
	}

	/**
	 * Removes the legal draft document where groupId = &#63; and draftId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the legal draft document that was removed
	 */
	public static LegalDraftDocument removeByG_D(long groupId, long draftId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().removeByG_D(groupId, draftId);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and draftId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the number of matching legal draft documents
	 */
	public static int countByG_D(long groupId, long draftId) {
		return getPersistence().countByG_D(groupId, draftId);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode) {

		return getPersistence().findByP_S_D(groupId, statusDraft, docCode);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end) {

		return getPersistence().findByP_S_D(
			groupId, statusDraft, docCode, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByP_S_D(
			groupId, statusDraft, docCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_S_D(
			groupId, statusDraft, docCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_D_First(
			long groupId, int statusDraft, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_D_First(
			groupId, statusDraft, docCode, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_D_First(
		long groupId, int statusDraft, String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_D_First(
			groupId, statusDraft, docCode, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_D_Last(
			long groupId, int statusDraft, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_D_Last(
			groupId, statusDraft, docCode, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_D_Last(
		long groupId, int statusDraft, String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_D_Last(
			groupId, statusDraft, docCode, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByP_S_D_PrevAndNext(
			long draftId, long groupId, int statusDraft, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_D_PrevAndNext(
			draftId, groupId, statusDraft, docCode, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 */
	public static void removeByP_S_D(
		long groupId, int statusDraft, String docCode) {

		getPersistence().removeByP_S_D(groupId, statusDraft, docCode);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @return the number of matching legal draft documents
	 */
	public static int countByP_S_D(
		long groupId, int statusDraft, String docCode) {

		return getPersistence().countByP_S_D(groupId, statusDraft, docCode);
	}

	/**
	 * Returns all the legal draft documents where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDRAFT_STATUS(int statusDraft) {
		return getPersistence().findByDRAFT_STATUS(statusDraft);
	}

	/**
	 * Returns a range of all the legal draft documents where statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end) {

		return getPersistence().findByDRAFT_STATUS(statusDraft, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByDRAFT_STATUS(
			statusDraft, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDRAFT_STATUS(
			statusDraft, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByDRAFT_STATUS_First(
			int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByDRAFT_STATUS_First(
			statusDraft, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByDRAFT_STATUS_First(
		int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByDRAFT_STATUS_First(
			statusDraft, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByDRAFT_STATUS_Last(
			int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByDRAFT_STATUS_Last(
			statusDraft, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByDRAFT_STATUS_Last(
		int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByDRAFT_STATUS_Last(
			statusDraft, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByDRAFT_STATUS_PrevAndNext(
			long draftId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByDRAFT_STATUS_PrevAndNext(
			draftId, statusDraft, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where statusDraft = &#63; from the database.
	 *
	 * @param statusDraft the status draft
	 */
	public static void removeByDRAFT_STATUS(int statusDraft) {
		getPersistence().removeByDRAFT_STATUS(statusDraft);
	}

	/**
	 * Returns the number of legal draft documents where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @return the number of matching legal draft documents
	 */
	public static int countByDRAFT_STATUS(int statusDraft) {
		return getPersistence().countByDRAFT_STATUS(statusDraft);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId) {

		return getPersistence().findByP_S_F(groupId, statusDraft, fieldId);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end) {

		return getPersistence().findByP_S_F(
			groupId, statusDraft, fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByP_S_F(
			groupId, statusDraft, fieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_S_F(
			groupId, statusDraft, fieldId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_F_First(
			long groupId, int statusDraft, long fieldId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_F_First(
			groupId, statusDraft, fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_F_First(
		long groupId, int statusDraft, long fieldId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_F_First(
			groupId, statusDraft, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_F_Last(
			long groupId, int statusDraft, long fieldId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_F_Last(
			groupId, statusDraft, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_F_Last(
		long groupId, int statusDraft, long fieldId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_F_Last(
			groupId, statusDraft, fieldId, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByP_S_F_PrevAndNext(
			long draftId, long groupId, int statusDraft, long fieldId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_F_PrevAndNext(
			draftId, groupId, statusDraft, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 */
	public static void removeByP_S_F(
		long groupId, int statusDraft, long fieldId) {

		getPersistence().removeByP_S_F(groupId, statusDraft, fieldId);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @return the number of matching legal draft documents
	 */
	public static int countByP_S_F(
		long groupId, int statusDraft, long fieldId) {

		return getPersistence().countByP_S_F(groupId, statusDraft, fieldId);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId) {

		return getPersistence().findByP_S_T(groupId, statusDraft, typeId);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end) {

		return getPersistence().findByP_S_T(
			groupId, statusDraft, typeId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByP_S_T(
			groupId, statusDraft, typeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_S_T(
			groupId, statusDraft, typeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_T_First(
			long groupId, int statusDraft, long typeId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_T_First(
			groupId, statusDraft, typeId, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_T_First(
		long groupId, int statusDraft, long typeId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_T_First(
			groupId, statusDraft, typeId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_T_Last(
			long groupId, int statusDraft, long typeId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_T_Last(
			groupId, statusDraft, typeId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_T_Last(
		long groupId, int statusDraft, long typeId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_T_Last(
			groupId, statusDraft, typeId, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByP_S_T_PrevAndNext(
			long draftId, long groupId, int statusDraft, long typeId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_T_PrevAndNext(
			draftId, groupId, statusDraft, typeId, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 */
	public static void removeByP_S_T(
		long groupId, int statusDraft, long typeId) {

		getPersistence().removeByP_S_T(groupId, statusDraft, typeId);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @return the number of matching legal draft documents
	 */
	public static int countByP_S_T(long groupId, int statusDraft, long typeId) {
		return getPersistence().countByP_S_T(groupId, statusDraft, typeId);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language) {

		return getPersistence().findByP_S_L(groupId, statusDraft, language);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end) {

		return getPersistence().findByP_S_L(
			groupId, statusDraft, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByP_S_L(
			groupId, statusDraft, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_S_L(
			groupId, statusDraft, language, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_L_First(
			long groupId, int statusDraft, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_L_First(
			groupId, statusDraft, language, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_L_First(
		long groupId, int statusDraft, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_L_First(
			groupId, statusDraft, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_L_Last(
			long groupId, int statusDraft, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_L_Last(
			groupId, statusDraft, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_L_Last(
		long groupId, int statusDraft, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_L_Last(
			groupId, statusDraft, language, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByP_S_L_PrevAndNext(
			long draftId, long groupId, int statusDraft, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_L_PrevAndNext(
			draftId, groupId, statusDraft, language, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 */
	public static void removeByP_S_L(
		long groupId, int statusDraft, String language) {

		getPersistence().removeByP_S_L(groupId, statusDraft, language);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public static int countByP_S_L(
		long groupId, int statusDraft, String language) {

		return getPersistence().countByP_S_L(groupId, statusDraft, language);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_L(
		long groupId, String language) {

		return getPersistence().findByP_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByP_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByP_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_L_First(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_L_First(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_L_Last(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_L_Last(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByP_L_PrevAndNext(
			long draftId, long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_L_PrevAndNext(
			draftId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByP_L(long groupId, String language) {
		getPersistence().removeByP_L(groupId, language);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public static int countByP_L(long groupId, String language) {
		return getPersistence().countByP_L(groupId, language);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language) {

		return getPersistence().findByP_S_U_L(
			groupId, statusDraft, createdByUser, language);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end) {

		return getPersistence().findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_U_L_First(
			long groupId, int statusDraft, long createdByUser, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_U_L_First(
			groupId, statusDraft, createdByUser, language, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_U_L_First(
		long groupId, int statusDraft, long createdByUser, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_U_L_First(
			groupId, statusDraft, createdByUser, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByP_S_U_L_Last(
			long groupId, int statusDraft, long createdByUser, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_U_L_Last(
			groupId, statusDraft, createdByUser, language, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByP_S_U_L_Last(
		long groupId, int statusDraft, long createdByUser, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByP_S_U_L_Last(
			groupId, statusDraft, createdByUser, language, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByP_S_U_L_PrevAndNext(
			long draftId, long groupId, int statusDraft, long createdByUser,
			String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByP_S_U_L_PrevAndNext(
			draftId, groupId, statusDraft, createdByUser, language,
			orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 */
	public static void removeByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language) {

		getPersistence().removeByP_S_U_L(
			groupId, statusDraft, createdByUser, language);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public static int countByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language) {

		return getPersistence().countByP_S_U_L(
			groupId, statusDraft, createdByUser, language);
	}

	/**
	 * Returns all the legal draft documents where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDocCode(String docCode) {
		return getPersistence().findByDocCode(docCode);
	}

	/**
	 * Returns a range of all the legal draft documents where docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end) {

		return getPersistence().findByDocCode(docCode, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByDocCode(
			docCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocCode(
			docCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByDocCode_First(
			String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByDocCode_First(docCode, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByDocCode_First(
		String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByDocCode_First(
			docCode, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByDocCode_Last(
			String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByDocCode_Last(docCode, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByDocCode_Last(
		String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByDocCode_Last(docCode, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByDocCode_PrevAndNext(
			long draftId, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByDocCode_PrevAndNext(
			draftId, docCode, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where docCode = &#63; from the database.
	 *
	 * @param docCode the doc code
	 */
	public static void removeByDocCode(String docCode) {
		getPersistence().removeByDocCode(docCode);
	}

	/**
	 * Returns the number of legal draft documents where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @return the number of matching legal draft documents
	 */
	public static int countByDocCode(String docCode) {
		return getPersistence().countByDocCode(docCode);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDraft);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDraft, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDraft, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDraft, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByFindGroup_First(
			long groupId, long companyId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, statusDraft, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByFindGroup_First(
		long groupId, long companyId, int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, statusDraft, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByFindGroup_Last(
			long groupId, long companyId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, statusDraft, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByFindGroup_Last(
		long groupId, long companyId, int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, statusDraft, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByFindGroup_PrevAndNext(
			long draftId, long groupId, long companyId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByFindGroup_PrevAndNext(
			draftId, groupId, companyId, statusDraft, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 */
	public static void removeByFindGroup(
		long groupId, long companyId, int statusDraft) {

		getPersistence().removeByFindGroup(groupId, companyId, statusDraft);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @return the number of matching legal draft documents
	 */
	public static int countByFindGroup(
		long groupId, long companyId, int statusDraft) {

		return getPersistence().countByFindGroup(
			groupId, companyId, statusDraft);
	}

	/**
	 * Returns all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId) {

		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	public static List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public static LegalDraftDocument fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument[] findByFindAll_PrevAndNext(
			long draftId, long groupId, long companyId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByFindAll_PrevAndNext(
			draftId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal draft documents
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the legal draft document in the entity cache if it is enabled.
	 *
	 * @param legalDraftDocument the legal draft document
	 */
	public static void cacheResult(LegalDraftDocument legalDraftDocument) {
		getPersistence().cacheResult(legalDraftDocument);
	}

	/**
	 * Caches the legal draft documents in the entity cache if it is enabled.
	 *
	 * @param legalDraftDocuments the legal draft documents
	 */
	public static void cacheResult(
		List<LegalDraftDocument> legalDraftDocuments) {

		getPersistence().cacheResult(legalDraftDocuments);
	}

	/**
	 * Creates a new legal draft document with the primary key. Does not add the legal draft document to the database.
	 *
	 * @param draftId the primary key for the new legal draft document
	 * @return the new legal draft document
	 */
	public static LegalDraftDocument create(long draftId) {
		return getPersistence().create(draftId);
	}

	/**
	 * Removes the legal draft document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document that was removed
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument remove(long draftId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().remove(draftId);
	}

	public static LegalDraftDocument updateImpl(
		LegalDraftDocument legalDraftDocument) {

		return getPersistence().updateImpl(legalDraftDocument);
	}

	/**
	 * Returns the legal draft document with the primary key or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument findByPrimaryKey(long draftId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchLegalDraftDocumentException {

		return getPersistence().findByPrimaryKey(draftId);
	}

	/**
	 * Returns the legal draft document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document, or <code>null</code> if a legal draft document with the primary key could not be found
	 */
	public static LegalDraftDocument fetchByPrimaryKey(long draftId) {
		return getPersistence().fetchByPrimaryKey(draftId);
	}

	/**
	 * Returns all the legal draft documents.
	 *
	 * @return the legal draft documents
	 */
	public static List<LegalDraftDocument> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of legal draft documents
	 */
	public static List<LegalDraftDocument> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal draft documents
	 */
	public static List<LegalDraftDocument> findAll(
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal draft documents
	 */
	public static List<LegalDraftDocument> findAll(
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal draft documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal draft documents.
	 *
	 * @return the number of legal draft documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalDraftDocumentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDraftDocumentPersistence, LegalDraftDocumentPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalDraftDocumentPersistence.class);

		ServiceTracker
			<LegalDraftDocumentPersistence, LegalDraftDocumentPersistence>
				serviceTracker =
					new ServiceTracker
						<LegalDraftDocumentPersistence,
						 LegalDraftDocumentPersistence>(
							 bundle.getBundleContext(),
							 LegalDraftDocumentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}