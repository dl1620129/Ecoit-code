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

import com.ecoit.elegaldocument.model.LegalDocument;

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
 * The persistence utility for the legal document service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalDocumentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDocumentPersistence
 * @generated
 */
public class LegalDocumentUtil {

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
	public static void clearCache(LegalDocument legalDocument) {
		getPersistence().clearCache(legalDocument);
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
	public static Map<Serializable, LegalDocument> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDocument> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalDocument update(LegalDocument legalDocument) {
		return getPersistence().update(legalDocument);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalDocument update(
		LegalDocument legalDocument, ServiceContext serviceContext) {

		return getPersistence().update(legalDocument, serviceContext);
	}

	/**
	 * Returns the legal document where docId = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param docId the doc ID
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocId(long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocId(docId);
	}

	/**
	 * Returns the legal document where docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docId the doc ID
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocId(long docId) {
		return getPersistence().fetchByDocId(docId);
	}

	/**
	 * Returns the legal document where docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocId(
		long docId, boolean useFinderCache) {

		return getPersistence().fetchByDocId(docId, useFinderCache);
	}

	/**
	 * Removes the legal document where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 * @return the legal document that was removed
	 */
	public static LegalDocument removeByDocId(long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().removeByDocId(docId);
	}

	/**
	 * Returns the number of legal documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal documents
	 */
	public static int countByDocId(long docId) {
		return getPersistence().countByDocId(docId);
	}

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDOC_STATUS(int statusDoc) {
		return getPersistence().findByDOC_STATUS(statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end) {

		return getPersistence().findByDOC_STATUS(statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDOC_STATUS(
			statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDOC_STATUS(
			statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDOC_STATUS_First(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDOC_STATUS_First(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDOC_STATUS_First(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDOC_STATUS_First(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDOC_STATUS_Last(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDOC_STATUS_Last(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDOC_STATUS_Last(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDOC_STATUS_Last(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDOC_STATUS_PrevAndNext(
			long docId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDOC_STATUS_PrevAndNext(
			docId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	public static void removeByDOC_STATUS(int statusDoc) {
		getPersistence().removeByDOC_STATUS(statusDoc);
	}

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByDOC_STATUS(int statusDoc) {
		return getPersistence().countByDOC_STATUS(statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroupId_First(
			long groupId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByGroupId_First(
		long groupId, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroupId_Last(
			long groupId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByGroupId_PrevAndNext(
			long docId, long groupId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroupId_PrevAndNext(
			docId, groupId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal documents
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L(long groupId, String language) {
		return getPersistence().findByG_L(groupId, language);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end) {

		return getPersistence().findByG_L(groupId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L(
			groupId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_First(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_Last(
			groupId, language, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_PrevAndNext(
			long docId, long groupId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_PrevAndNext(
			docId, groupId, language, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public static void removeByG_L(long groupId, String language) {
		getPersistence().removeByG_L(groupId, language);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal documents
	 */
	public static int countByG_L(long groupId, String language) {
		return getPersistence().countByG_L(groupId, language);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId) {

		return getPersistence().findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end) {

		return getPersistence().findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByF_O_T_L_S_First(
			long groupId, long typeId, long organizationId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByF_O_T_L_S_First(
			groupId, typeId, organizationId, fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByF_O_T_L_S_First(
		long groupId, long typeId, long organizationId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByF_O_T_L_S_First(
			groupId, typeId, organizationId, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByF_O_T_L_S_Last(
			long groupId, long typeId, long organizationId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByF_O_T_L_S_Last(
			groupId, typeId, organizationId, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByF_O_T_L_S_Last(
		long groupId, long typeId, long organizationId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByF_O_T_L_S_Last(
			groupId, typeId, organizationId, fieldId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDocsByF_O_T_L_S_PrevAndNext(
			long docId, long groupId, long typeId, long organizationId,
			long fieldId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByF_O_T_L_S_PrevAndNext(
			docId, groupId, typeId, organizationId, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 */
	public static void removeByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId) {

		getPersistence().removeByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public static int countByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId) {

		return getPersistence().countByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc) {

		return getPersistence().findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end) {

		return getPersistence().findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByG_O_T_L_S_First(
			long groupId, long organizationId, long typeId, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByG_O_T_L_S_First(
			groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByG_O_T_L_S_First(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByG_O_T_L_S_First(
			groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByG_O_T_L_S_Last(
			long groupId, long organizationId, long typeId, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByG_O_T_L_S_Last(
			groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByG_O_T_L_S_Last(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByG_O_T_L_S_Last(
			groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDocsByG_O_T_L_S_PrevAndNext(
			long docId, long groupId, long organizationId, long typeId,
			String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByG_O_T_L_S_PrevAndNext(
			docId, groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public static void removeByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc) {

		getPersistence().removeByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc) {

		return getPersistence().countByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc);
	}

	/**
	 * Returns all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc) {

		return getPersistence().findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end) {

		return getPersistence().findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByO_T_F_S_First(
			long organizationId, long typeId, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByO_T_F_S_First(
			organizationId, typeId, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByO_T_F_S_First(
		long organizationId, long typeId, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByO_T_F_S_First(
			organizationId, typeId, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByO_T_F_S_Last(
			long organizationId, long typeId, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByO_T_F_S_Last(
			organizationId, typeId, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByO_T_F_S_Last(
		long organizationId, long typeId, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByO_T_F_S_Last(
			organizationId, typeId, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDocsByO_T_F_S_PrevAndNext(
			long docId, long organizationId, long typeId, long fieldId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByO_T_F_S_PrevAndNext(
			docId, organizationId, typeId, fieldId, statusDoc,
			orderByComparator);
	}

	/**
	 * Removes all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	public static void removeByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc) {

		getPersistence().removeByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc) {

		return getPersistence().countByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc);
	}

	/**
	 * Returns all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc) {

		return getPersistence().findByDocsByPromulDate(typeId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end) {

		return getPersistence().findByDocsByPromulDate(
			typeId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDocsByPromulDate(
			typeId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocsByPromulDate(
			typeId, statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByPromulDate_First(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByPromulDate_First(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByPromulDate_First(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByPromulDate_First(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByPromulDate_Last(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByPromulDate_Last(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByPromulDate_Last(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByPromulDate_Last(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDocsByPromulDate_PrevAndNext(
			long docId, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByPromulDate_PrevAndNext(
			docId, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	public static void removeByDocsByPromulDate(long typeId, int statusDoc) {
		getPersistence().removeByDocsByPromulDate(typeId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByDocsByPromulDate(long typeId, int statusDoc) {
		return getPersistence().countByDocsByPromulDate(typeId, statusDoc);
	}

	/**
	 * Returns all the legal documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Org(long organizationId) {
		return getPersistence().findByDoc_Org(organizationId);
	}

	/**
	 * Returns a range of all the legal documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end) {

		return getPersistence().findByDoc_Org(organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDoc_Org(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoc_Org(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDoc_Org_First(
			long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Org_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDoc_Org_First(
		long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDoc_Org_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDoc_Org_Last(
			long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Org_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDoc_Org_Last(
		long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDoc_Org_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDoc_Org_PrevAndNext(
			long docId, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Org_PrevAndNext(
			docId, organizationId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByDoc_Org(long organizationId) {
		getPersistence().removeByDoc_Org(organizationId);
	}

	/**
	 * Returns the number of legal documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal documents
	 */
	public static int countByDoc_Org(long organizationId) {
		return getPersistence().countByDoc_Org(organizationId);
	}

	/**
	 * Returns all the legal documents where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Category(long typeId) {
		return getPersistence().findByDoc_Category(typeId);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end) {

		return getPersistence().findByDoc_Category(typeId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDoc_Category(
			typeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoc_Category(
			typeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDoc_Category_First(
			long typeId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Category_First(
			typeId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDoc_Category_First(
		long typeId, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDoc_Category_First(
			typeId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDoc_Category_Last(
			long typeId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Category_Last(
			typeId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDoc_Category_Last(
		long typeId, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDoc_Category_Last(
			typeId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDoc_Category_PrevAndNext(
			long docId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Category_PrevAndNext(
			docId, typeId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public static void removeByDoc_Category(long typeId) {
		getPersistence().removeByDoc_Category(typeId);
	}

	/**
	 * Returns the number of legal documents where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	public static int countByDoc_Category(long typeId) {
		return getPersistence().countByDoc_Category(typeId);
	}

	/**
	 * Returns all the legal documents where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Field(long fieldId) {
		return getPersistence().findByDoc_Field(fieldId);
	}

	/**
	 * Returns a range of all the legal documents where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end) {

		return getPersistence().findByDoc_Field(fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDoc_Field(
			fieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoc_Field(
			fieldId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDoc_Field_First(
			long fieldId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Field_First(
			fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDoc_Field_First(
		long fieldId, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDoc_Field_First(
			fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDoc_Field_Last(
			long fieldId, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Field_Last(
			fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDoc_Field_Last(
		long fieldId, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDoc_Field_Last(
			fieldId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDoc_Field_PrevAndNext(
			long docId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDoc_Field_PrevAndNext(
			docId, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public static void removeByDoc_Field(long fieldId) {
		getPersistence().removeByDoc_Field(fieldId);
	}

	/**
	 * Returns the number of legal documents where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public static int countByDoc_Field(long fieldId) {
		return getPersistence().countByDoc_Field(fieldId);
	}

	/**
	 * Returns all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByDocsByT_L(
		long typeId, String language) {

		return getPersistence().findByDocsByT_L(typeId, language);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end) {

		return getPersistence().findByDocsByT_L(typeId, language, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByDocsByT_L(
			typeId, language, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocsByT_L(
			typeId, language, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByT_L_First(
			long typeId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByT_L_First(
			typeId, language, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByT_L_First(
		long typeId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByT_L_First(
			typeId, language, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByDocsByT_L_Last(
			long typeId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByT_L_Last(
			typeId, language, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByDocsByT_L_Last(
		long typeId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByDocsByT_L_Last(
			typeId, language, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByDocsByT_L_PrevAndNext(
			long docId, long typeId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByDocsByT_L_PrevAndNext(
			docId, typeId, language, orderByComparator);
	}

	/**
	 * Removes all the legal documents where typeId = &#63; and language = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 */
	public static void removeByDocsByT_L(long typeId, String language) {
		getPersistence().removeByDocsByT_L(typeId, language);
	}

	/**
	 * Returns the number of legal documents where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @return the number of matching legal documents
	 */
	public static int countByDocsByT_L(long typeId, String language) {
		return getPersistence().countByDocsByT_L(typeId, language);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc) {

		return getPersistence().findByG_L_U_S(
			groupId, language, userId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end) {

		return getPersistence().findByG_L_U_S(
			groupId, language, userId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_U_S(
			groupId, language, userId, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_U_S(
			groupId, language, userId, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_U_S_First(
			long groupId, String language, long userId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_U_S_First(
			groupId, language, userId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_U_S_First(
		long groupId, String language, long userId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_U_S_First(
			groupId, language, userId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_U_S_Last(
			long groupId, String language, long userId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_U_S_Last(
			groupId, language, userId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_U_S_Last(
		long groupId, String language, long userId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_U_S_Last(
			groupId, language, userId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_U_S_PrevAndNext(
			long docId, long groupId, String language, long userId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_U_S_PrevAndNext(
			docId, groupId, language, userId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 */
	public static void removeByG_L_U_S(
		long groupId, String language, long userId, int statusDoc) {

		getPersistence().removeByG_L_U_S(groupId, language, userId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_U_S(
		long groupId, String language, long userId, int statusDoc) {

		return getPersistence().countByG_L_U_S(
			groupId, language, userId, statusDoc);
	}

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_D(long groupId, long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_D(groupId, docId);
	}

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_D(long groupId, long docId) {
		return getPersistence().fetchByG_D(groupId, docId);
	}

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_D(
		long groupId, long docId, boolean useFinderCache) {

		return getPersistence().fetchByG_D(groupId, docId, useFinderCache);
	}

	/**
	 * Removes the legal document where groupId = &#63; and docId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the legal document that was removed
	 */
	public static LegalDocument removeByG_D(long groupId, long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().removeByG_D(groupId, docId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the number of matching legal documents
	 */
	public static int countByG_D(long groupId, long docId) {
		return getPersistence().countByG_D(groupId, docId);
	}

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByP_N_S(
			long groupId, String num, String symbol)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_N_S(groupId, num, symbol);
	}

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByP_N_S(
		long groupId, String num, String symbol) {

		return getPersistence().fetchByP_N_S(groupId, num, symbol);
	}

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByP_N_S(
		long groupId, String num, String symbol, boolean useFinderCache) {

		return getPersistence().fetchByP_N_S(
			groupId, num, symbol, useFinderCache);
	}

	/**
	 * Removes the legal document where groupId = &#63; and num = &#63; and symbol = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the legal document that was removed
	 */
	public static LegalDocument removeByP_N_S(
			long groupId, String num, String symbol)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().removeByP_N_S(groupId, num, symbol);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and num = &#63; and symbol = &#63;.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the number of matching legal documents
	 */
	public static int countByP_N_S(long groupId, String num, String symbol) {
		return getPersistence().countByP_N_S(groupId, num, symbol);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc) {

		return getPersistence().findByP_L_S(groupId, language, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end) {

		return getPersistence().findByP_L_S(
			groupId, language, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByP_L_S(
			groupId, language, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_L_S(
			groupId, language, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByP_L_S_First(
			long groupId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_L_S_First(
			groupId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByP_L_S_First(
		long groupId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByP_L_S_First(
			groupId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByP_L_S_Last(
			long groupId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_L_S_Last(
			groupId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByP_L_S_Last(
		long groupId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByP_L_S_Last(
			groupId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByP_L_S_PrevAndNext(
			long docId, long groupId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_L_S_PrevAndNext(
			docId, groupId, language, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public static void removeByP_L_S(
		long groupId, String language, int statusDoc) {

		getPersistence().removeByP_L_S(groupId, language, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByP_L_S(
		long groupId, String language, int statusDoc) {

		return getPersistence().countByP_L_S(groupId, language, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc) {

		return getPersistence().findByG_L_P_S(
			groupId, language, isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end) {

		return getPersistence().findByG_L_P_S(
			groupId, language, isPublic, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_P_S(
			groupId, language, isPublic, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_P_S(
			groupId, language, isPublic, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_P_S_First(
			long groupId, String language, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_P_S_First(
			groupId, language, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_P_S_First(
		long groupId, String language, int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_P_S_First(
			groupId, language, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_P_S_Last(
			long groupId, String language, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_P_S_Last(
			groupId, language, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_P_S_Last(
		long groupId, String language, int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_P_S_Last(
			groupId, language, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_P_S_PrevAndNext(
			long docId, long groupId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_P_S_PrevAndNext(
			docId, groupId, language, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc) {

		getPersistence().removeByG_L_P_S(
			groupId, language, isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc) {

		return getPersistence().countByG_L_P_S(
			groupId, language, isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findBystatusDoc(int statusDoc) {
		return getPersistence().findBystatusDoc(statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end) {

		return getPersistence().findBystatusDoc(statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findBystatusDoc(
			statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBystatusDoc(
			statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findBystatusDoc_First(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findBystatusDoc_First(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchBystatusDoc_First(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchBystatusDoc_First(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findBystatusDoc_Last(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findBystatusDoc_Last(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchBystatusDoc_Last(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchBystatusDoc_Last(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findBystatusDoc_PrevAndNext(
			long docId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findBystatusDoc_PrevAndNext(
			docId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	public static void removeBystatusDoc(int statusDoc) {
		getPersistence().removeBystatusDoc(statusDoc);
	}

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countBystatusDoc(int statusDoc) {
		return getPersistence().countBystatusDoc(statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc) {

		return getPersistence().findByG_L_O_S(
			groupId, language, organizationId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end) {

		return getPersistence().findByG_L_O_S(
			groupId, language, organizationId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_O_S(
			groupId, language, organizationId, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_O_S(
			groupId, language, organizationId, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_O_S_First(
			long groupId, String language, long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_O_S_First(
			groupId, language, organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_O_S_First(
		long groupId, String language, long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_O_S_First(
			groupId, language, organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_O_S_Last(
			long groupId, String language, long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_O_S_Last(
			groupId, language, organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_O_S_Last(
		long groupId, String language, long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_O_S_Last(
			groupId, language, organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_O_S_PrevAndNext(
			long docId, long groupId, String language, long organizationId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_O_S_PrevAndNext(
			docId, groupId, language, organizationId, statusDoc,
			orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 */
	public static void removeByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc) {

		getPersistence().removeByG_L_O_S(
			groupId, language, organizationId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc) {

		return getPersistence().countByG_L_O_S(
			groupId, language, organizationId, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc) {

		return getPersistence().findByG_L_T_S(
			groupId, language, typeId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end) {

		return getPersistence().findByG_L_T_S(
			groupId, language, typeId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_T_S(
			groupId, language, typeId, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_T_S(
			groupId, language, typeId, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_T_S_First(
			long groupId, String language, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_T_S_First(
			groupId, language, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_T_S_First(
		long groupId, String language, long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_T_S_First(
			groupId, language, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_T_S_Last(
			long groupId, String language, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_T_S_Last(
			groupId, language, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_T_S_Last(
		long groupId, String language, long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_T_S_Last(
			groupId, language, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_T_S_PrevAndNext(
			long docId, long groupId, String language, long typeId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_T_S_PrevAndNext(
			docId, groupId, language, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	public static void removeByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc) {

		getPersistence().removeByG_L_T_S(groupId, language, typeId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc) {

		return getPersistence().countByG_L_T_S(
			groupId, language, typeId, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc) {

		return getPersistence().findByG_L_F_S(
			groupId, language, fieldId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end) {

		return getPersistence().findByG_L_F_S(
			groupId, language, fieldId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_F_S(
			groupId, language, fieldId, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_F_S(
			groupId, language, fieldId, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_F_S_First(
			long groupId, String language, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_S_First(
			groupId, language, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_F_S_First(
		long groupId, String language, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_F_S_First(
			groupId, language, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_F_S_Last(
			long groupId, String language, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_S_Last(
			groupId, language, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_F_S_Last(
		long groupId, String language, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_F_S_Last(
			groupId, language, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_F_S_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_S_PrevAndNext(
			docId, groupId, language, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	public static void removeByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc) {

		getPersistence().removeByG_L_F_S(groupId, language, fieldId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc) {

		return getPersistence().countByG_L_F_S(
			groupId, language, fieldId, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc) {

		return getPersistence().findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end) {

		return getPersistence().findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_F_P_S_First(
			long groupId, String language, long fieldId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_P_S_First(
			groupId, language, fieldId, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_F_P_S_First(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_F_P_S_First(
			groupId, language, fieldId, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_F_P_S_Last(
			long groupId, String language, long fieldId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_P_S_Last(
			groupId, language, fieldId, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_F_P_S_Last(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_F_P_S_Last(
			groupId, language, fieldId, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_F_P_S_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_P_S_PrevAndNext(
			docId, groupId, language, fieldId, isPublic, statusDoc,
			orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc) {

		getPersistence().removeByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc) {

		return getPersistence().countByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc) {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc, int start, int end) {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Field_Public_Status_First(
				long groupId, long companyId, String language, long fieldId,
				int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status_First(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Field_Public_Status_First(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Field_Public_Status_First(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Field_Public_Status_Last(
				long groupId, long companyId, String language, long fieldId,
				int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status_Last(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Field_Public_Status_Last(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Field_Public_Status_Last(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[]
			findByGroup_Company_Language_Field_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long fieldId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Field_Public_Status_PrevAndNext(
				docId, groupId, companyId, language, fieldId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc) {

		getPersistence().removeByGroup_Company_Language_Field_Public_Status(
			groupId, companyId, language, fieldId, isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc) {

		return getPersistence().
			countByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc) {

		return getPersistence().findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc, int start, int end) {

		return getPersistence().findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc,
			start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc,
			start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc,
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Org_Public_Status_First(
				long groupId, long companyId, String language,
				long organizationId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Org_Public_Status_First(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Org_Public_Status_First(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Org_Public_Status_First(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Org_Public_Status_Last(
				long groupId, long companyId, String language,
				long organizationId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Org_Public_Status_Last(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Org_Public_Status_Last(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Org_Public_Status_Last(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[]
			findByGroup_Company_Language_Org_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long organizationId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Org_Public_Status_PrevAndNext(
				docId, groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc) {

		getPersistence().removeByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc) {

		return getPersistence().countByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc) {

		return getPersistence().findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc, int start, int end) {

		return getPersistence().findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc, start,
			end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc, start,
			end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc, start,
			end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Type_Public_Status_First(
				long groupId, long companyId, String language, long typeId,
				int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Type_Public_Status_First(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Type_Public_Status_First(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Type_Public_Status_First(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Type_Public_Status_Last(
				long groupId, long companyId, String language, long typeId,
				int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Type_Public_Status_Last(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Type_Public_Status_Last(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Type_Public_Status_Last(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[]
			findByGroup_Company_Language_Type_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long typeId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Type_Public_Status_PrevAndNext(
				docId, groupId, companyId, language, typeId, isPublic,
				statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc) {

		getPersistence().removeByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc) {

		return getPersistence().
			countByGroup_Company_Language_Type_Public_Status(
				groupId, companyId, language, typeId, isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc) {

		return getPersistence().findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, int start, int end) {

		return getPersistence().findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, int start, int end,
			OrderByComparator<LegalDocument> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument
			findByGroup_Company_Language_Public_Status_First(
				long groupId, long companyId, String language, int isPublic,
				int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Public_Status_First(
				groupId, companyId, language, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Public_Status_First(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Public_Status_First(
				groupId, companyId, language, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroup_Company_Language_Public_Status_Last(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Language_Public_Status_Last(
			groupId, companyId, language, isPublic, statusDoc,
			orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument
		fetchByGroup_Company_Language_Public_Status_Last(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().
			fetchByGroup_Company_Language_Public_Status_Last(
				groupId, companyId, language, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[]
			findByGroup_Company_Language_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().
			findByGroup_Company_Language_Public_Status_PrevAndNext(
				docId, groupId, companyId, language, isPublic, statusDoc,
				orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc) {

		getPersistence().removeByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc) {

		return getPersistence().countByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc) {

		return getPersistence().findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end) {

		return getPersistence().findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroup_Company_Language_Status_First(
			long groupId, long companyId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Language_Status_First(
			groupId, companyId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByGroup_Company_Language_Status_First(
		long groupId, long companyId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByGroup_Company_Language_Status_First(
			groupId, companyId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroup_Company_Language_Status_Last(
			long groupId, long companyId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Language_Status_Last(
			groupId, companyId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByGroup_Company_Language_Status_Last(
		long groupId, long companyId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByGroup_Company_Language_Status_Last(
			groupId, companyId, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[]
			findByGroup_Company_Language_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Language_Status_PrevAndNext(
			docId, groupId, companyId, language, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public static void removeByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc) {

		getPersistence().removeByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc) {

		return getPersistence().countByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc) {

		return getPersistence().findByGroup_Company_Status(
			groupId, companyId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end) {

		return getPersistence().findByGroup_Company_Status(
			groupId, companyId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByGroup_Company_Status(
			groupId, companyId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroup_Company_Status(
			groupId, companyId, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroup_Company_Status_First(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Status_First(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByGroup_Company_Status_First(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByGroup_Company_Status_First(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByGroup_Company_Status_Last(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Status_Last(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByGroup_Company_Status_Last(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByGroup_Company_Status_Last(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByGroup_Company_Status_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByGroup_Company_Status_PrevAndNext(
			docId, groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	public static void removeByGroup_Company_Status(
		long groupId, long companyId, int statusDoc) {

		getPersistence().removeByGroup_Company_Status(
			groupId, companyId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByGroup_Company_Status(
		long groupId, long companyId, int statusDoc) {

		return getPersistence().countByGroup_Company_Status(
			groupId, companyId, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId) {

		return getPersistence().findByG_L_O(groupId, language, organizationId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start,
		int end) {

		return getPersistence().findByG_L_O(
			groupId, language, organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_O(
			groupId, language, organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_O(
			groupId, language, organizationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_O_First(
			long groupId, String language, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_O_First(
			groupId, language, organizationId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_O_First(
		long groupId, String language, long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_O_First(
			groupId, language, organizationId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_O_Last(
			long groupId, String language, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_O_Last(
			groupId, language, organizationId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_O_Last(
		long groupId, String language, long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_O_Last(
			groupId, language, organizationId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_O_PrevAndNext(
			long docId, long groupId, String language, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_O_PrevAndNext(
			docId, groupId, language, organizationId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 */
	public static void removeByG_L_O(
		long groupId, String language, long organizationId) {

		getPersistence().removeByG_L_O(groupId, language, organizationId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_O(
		long groupId, String language, long organizationId) {

		return getPersistence().countByG_L_O(groupId, language, organizationId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId) {

		return getPersistence().findByG_L_T(groupId, language, typeId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end) {

		return getPersistence().findByG_L_T(
			groupId, language, typeId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_T(
			groupId, language, typeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_T(
			groupId, language, typeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_T_First(
			long groupId, String language, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_T_First(
			groupId, language, typeId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_T_First(
		long groupId, String language, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_T_First(
			groupId, language, typeId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_T_Last(
			long groupId, String language, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_T_Last(
			groupId, language, typeId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_T_Last(
		long groupId, String language, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_T_Last(
			groupId, language, typeId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_T_PrevAndNext(
			long docId, long groupId, String language, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_T_PrevAndNext(
			docId, groupId, language, typeId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 */
	public static void removeByG_L_T(
		long groupId, String language, long typeId) {

		getPersistence().removeByG_L_T(groupId, language, typeId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_T(long groupId, String language, long typeId) {
		return getPersistence().countByG_L_T(groupId, language, typeId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId) {

		return getPersistence().findByG_L_F(groupId, language, fieldId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end) {

		return getPersistence().findByG_L_F(
			groupId, language, fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByG_L_F(
			groupId, language, fieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_L_F(
			groupId, language, fieldId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_F_First(
			long groupId, String language, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_First(
			groupId, language, fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_F_First(
		long groupId, String language, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_F_First(
			groupId, language, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByG_L_F_Last(
			long groupId, String language, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_Last(
			groupId, language, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByG_L_F_Last(
		long groupId, String language, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByG_L_F_Last(
			groupId, language, fieldId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByG_L_F_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByG_L_F_PrevAndNext(
			docId, groupId, language, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 */
	public static void removeByG_L_F(
		long groupId, String language, long fieldId) {

		getPersistence().removeByG_L_F(groupId, language, fieldId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public static int countByG_L_F(
		long groupId, String language, long fieldId) {

		return getPersistence().countByG_L_F(groupId, language, fieldId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc) {

		return getPersistence().findByP_U_S(
			groupId, createdByUser, language, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end) {

		return getPersistence().findByP_U_S(
			groupId, createdByUser, language, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByP_U_S(
			groupId, createdByUser, language, statusDoc, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByP_U_S(
			groupId, createdByUser, language, statusDoc, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByP_U_S_First(
			long groupId, long createdByUser, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_U_S_First(
			groupId, createdByUser, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByP_U_S_First(
		long groupId, long createdByUser, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByP_U_S_First(
			groupId, createdByUser, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByP_U_S_Last(
			long groupId, long createdByUser, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_U_S_Last(
			groupId, createdByUser, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByP_U_S_Last(
		long groupId, long createdByUser, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByP_U_S_Last(
			groupId, createdByUser, language, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByP_U_S_PrevAndNext(
			long docId, long groupId, long createdByUser, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByP_U_S_PrevAndNext(
			docId, groupId, createdByUser, language, statusDoc,
			orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public static void removeByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc) {

		getPersistence().removeByP_U_S(
			groupId, createdByUser, language, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc) {

		return getPersistence().countByP_U_S(
			groupId, createdByUser, language, statusDoc);
	}

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByStatus(int statusDoc) {
		return getPersistence().findByStatus(statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByStatus(
		int statusDoc, int start, int end) {

		return getPersistence().findByStatus(statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByStatus(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByStatus(
			statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByStatus(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByStatus_First(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByStatus_First(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByStatus_First(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByStatus_First(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByStatus_Last(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByStatus_Last(statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByStatus_Last(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByStatus_Last(
			statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByStatus_PrevAndNext(
			long docId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByStatus_PrevAndNext(
			docId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	public static void removeByStatus(int statusDoc) {
		getPersistence().removeByStatus(statusDoc);
	}

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByStatus(int statusDoc) {
		return getPersistence().countByStatus(statusDoc);
	}

	/**
	 * Returns all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc) {

		return getPersistence().findByIsPublic_Status(isPublic, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end) {

		return getPersistence().findByIsPublic_Status(
			isPublic, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByIsPublic_Status(
			isPublic, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsPublic_Status(
			isPublic, statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByIsPublic_Status_First(
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByIsPublic_Status_First(
			isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByIsPublic_Status_First(
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByIsPublic_Status_First(
			isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByIsPublic_Status_Last(
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByIsPublic_Status_Last(
			isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByIsPublic_Status_Last(
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByIsPublic_Status_Last(
			isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByIsPublic_Status_PrevAndNext(
			long docId, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByIsPublic_Status_PrevAndNext(
			docId, isPublic, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public static void removeByIsPublic_Status(int isPublic, int statusDoc) {
		getPersistence().removeByIsPublic_Status(isPublic, statusDoc);
	}

	/**
	 * Returns the number of legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByIsPublic_Status(int isPublic, int statusDoc) {
		return getPersistence().countByIsPublic_Status(isPublic, statusDoc);
	}

	/**
	 * Returns all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc) {

		return getPersistence().findByOrg_Status(organizationId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end) {

		return getPersistence().findByOrg_Status(
			organizationId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByOrg_Status(
			organizationId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrg_Status(
			organizationId, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByOrg_Status_First(
			long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByOrg_Status_First(
			organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByOrg_Status_First(
		long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByOrg_Status_First(
			organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByOrg_Status_Last(
			long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByOrg_Status_Last(
			organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByOrg_Status_Last(
		long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByOrg_Status_Last(
			organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByOrg_Status_PrevAndNext(
			long docId, long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByOrg_Status_PrevAndNext(
			docId, organizationId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where organizationId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 */
	public static void removeByOrg_Status(long organizationId, int statusDoc) {
		getPersistence().removeByOrg_Status(organizationId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByOrg_Status(long organizationId, int statusDoc) {
		return getPersistence().countByOrg_Status(organizationId, statusDoc);
	}

	/**
	 * Returns all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByType_Status(
		long typeId, int statusDoc) {

		return getPersistence().findByType_Status(typeId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end) {

		return getPersistence().findByType_Status(
			typeId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByType_Status(
			typeId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType_Status(
			typeId, statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByType_Status_First(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByType_Status_First(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByType_Status_First(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByType_Status_First(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByType_Status_Last(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByType_Status_Last(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByType_Status_Last(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByType_Status_Last(
			typeId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByType_Status_PrevAndNext(
			long docId, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByType_Status_PrevAndNext(
			docId, typeId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	public static void removeByType_Status(long typeId, int statusDoc) {
		getPersistence().removeByType_Status(typeId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByType_Status(long typeId, int statusDoc) {
		return getPersistence().countByType_Status(typeId, statusDoc);
	}

	/**
	 * Returns all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc) {

		return getPersistence().findByField_Status(fieldId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end) {

		return getPersistence().findByField_Status(
			fieldId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByField_Status(
			fieldId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByField_Status(
			fieldId, statusDoc, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByField_Status_First(
			long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByField_Status_First(
			fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByField_Status_First(
		long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByField_Status_First(
			fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByField_Status_Last(
			long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByField_Status_Last(
			fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByField_Status_Last(
		long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByField_Status_Last(
			fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByField_Status_PrevAndNext(
			long docId, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByField_Status_PrevAndNext(
			docId, fieldId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	public static void removeByField_Status(long fieldId, int statusDoc) {
		getPersistence().removeByField_Status(fieldId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByField_Status(long fieldId, int statusDoc) {
		return getPersistence().countByField_Status(fieldId, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc) {

		return getPersistence().findByFindGroup(groupId, companyId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindGroup_First(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindGroup_First(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindGroup_Last(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindGroup_Last(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByFindGroup_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindGroup_PrevAndNext(
			docId, groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	public static void removeByFindGroup(
		long groupId, long companyId, int statusDoc) {

		getPersistence().removeByFindGroup(groupId, companyId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByFindGroup(
		long groupId, long companyId, int statusDoc) {

		return getPersistence().countByFindGroup(groupId, companyId, statusDoc);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByFindAll(
		long groupId, long companyId) {

		return getPersistence().findByFindAll(groupId, companyId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByFindAll_PrevAndNext(
			long docId, long groupId, long companyId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindAll_PrevAndNext(
			docId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal documents
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId) {

		return getPersistence().findByFindType(groupId, companyId, typeId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end) {

		return getPersistence().findByFindType(
			groupId, companyId, typeId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByFindType(
			groupId, companyId, typeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindType(
			groupId, companyId, typeId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindType_First(
			long groupId, long companyId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindType_First(
			groupId, companyId, typeId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindType_First(
		long groupId, long companyId, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindType_First(
			groupId, companyId, typeId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindType_Last(
			long groupId, long companyId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindType_Last(
			groupId, companyId, typeId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindType_Last(
		long groupId, long companyId, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindType_Last(
			groupId, companyId, typeId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByFindType_PrevAndNext(
			long docId, long groupId, long companyId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindType_PrevAndNext(
			docId, groupId, companyId, typeId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 */
	public static void removeByFindType(
		long groupId, long companyId, long typeId) {

		getPersistence().removeByFindType(groupId, companyId, typeId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	public static int countByFindType(
		long groupId, long companyId, long typeId) {

		return getPersistence().countByFindType(groupId, companyId, typeId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId) {

		return getPersistence().findByFindField(groupId, companyId, fieldId);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end) {

		return getPersistence().findByFindField(
			groupId, companyId, fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByFindField(
			groupId, companyId, fieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByFindField(
			groupId, companyId, fieldId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindField_First(
			long groupId, long companyId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindField_First(
			groupId, companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindField_First(
		long groupId, long companyId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindField_First(
			groupId, companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByFindField_Last(
			long groupId, long companyId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindField_Last(
			groupId, companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByFindField_Last(
		long groupId, long companyId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByFindField_Last(
			groupId, companyId, fieldId, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByFindField_PrevAndNext(
			long docId, long groupId, long companyId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByFindField_PrevAndNext(
			docId, groupId, companyId, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 */
	public static void removeByFindField(
		long groupId, long companyId, long fieldId) {

		getPersistence().removeByFindField(groupId, companyId, fieldId);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public static int countByFindField(
		long groupId, long companyId, long fieldId) {

		return getPersistence().countByFindField(groupId, companyId, fieldId);
	}

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public static List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc) {

		return getPersistence().findByLegalStatus(
			groupId, companyId, statusDoc);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	public static List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end) {

		return getPersistence().findByLegalStatus(
			groupId, companyId, statusDoc, start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findByLegalStatus(
			groupId, companyId, statusDoc, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	public static List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLegalStatus(
			groupId, companyId, statusDoc, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByLegalStatus_First(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByLegalStatus_First(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByLegalStatus_First(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByLegalStatus_First(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public static LegalDocument findByLegalStatus_Last(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByLegalStatus_Last(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public static LegalDocument fetchByLegalStatus_Last(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().fetchByLegalStatus_Last(
			groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument[] findByLegalStatus_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByLegalStatus_PrevAndNext(
			docId, groupId, companyId, statusDoc, orderByComparator);
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	public static void removeByLegalStatus(
		long groupId, long companyId, int statusDoc) {

		getPersistence().removeByLegalStatus(groupId, companyId, statusDoc);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public static int countByLegalStatus(
		long groupId, long companyId, int statusDoc) {

		return getPersistence().countByLegalStatus(
			groupId, companyId, statusDoc);
	}

	/**
	 * Caches the legal document in the entity cache if it is enabled.
	 *
	 * @param legalDocument the legal document
	 */
	public static void cacheResult(LegalDocument legalDocument) {
		getPersistence().cacheResult(legalDocument);
	}

	/**
	 * Caches the legal documents in the entity cache if it is enabled.
	 *
	 * @param legalDocuments the legal documents
	 */
	public static void cacheResult(List<LegalDocument> legalDocuments) {
		getPersistence().cacheResult(legalDocuments);
	}

	/**
	 * Creates a new legal document with the primary key. Does not add the legal document to the database.
	 *
	 * @param docId the primary key for the new legal document
	 * @return the new legal document
	 */
	public static LegalDocument create(long docId) {
		return getPersistence().create(docId);
	}

	/**
	 * Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument remove(long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().remove(docId);
	}

	public static LegalDocument updateImpl(LegalDocument legalDocument) {
		return getPersistence().updateImpl(legalDocument);
	}

	/**
	 * Returns the legal document with the primary key or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public static LegalDocument findByPrimaryKey(long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException {

		return getPersistence().findByPrimaryKey(docId);
	}

	/**
	 * Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	 */
	public static LegalDocument fetchByPrimaryKey(long docId) {
		return getPersistence().fetchByPrimaryKey(docId);
	}

	/**
	 * Returns all the legal documents.
	 *
	 * @return the legal documents
	 */
	public static List<LegalDocument> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of legal documents
	 */
	public static List<LegalDocument> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal documents
	 */
	public static List<LegalDocument> findAll(
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal documents
	 */
	public static List<LegalDocument> findAll(
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal documents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal documents.
	 *
	 * @return the number of legal documents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LegalDocumentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDocumentPersistence, LegalDocumentPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDocumentPersistence.class);

		ServiceTracker<LegalDocumentPersistence, LegalDocumentPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalDocumentPersistence, LegalDocumentPersistence>(
						bundle.getBundleContext(),
						LegalDocumentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}