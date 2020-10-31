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

import com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException;
import com.ecoit.elegaldocument.model.LegalDocument;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDocumentUtil
 * @generated
 */
@ProviderType
public interface LegalDocumentPersistence
	extends BasePersistence<LegalDocument> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDocumentUtil} to access the legal document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal document where docId = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param docId the doc ID
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDocId(long docId)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the legal document where docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docId the doc ID
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDocId(long docId);

	/**
	 * Returns the legal document where docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDocId(long docId, boolean useFinderCache);

	/**
	 * Removes the legal document where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 * @return the legal document that was removed
	 */
	public LegalDocument removeByDocId(long docId)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the number of legal documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal documents
	 */
	public int countByDocId(long docId);

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDOC_STATUS(int statusDoc);

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
	public java.util.List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDOC_STATUS_First(
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDOC_STATUS_First(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDOC_STATUS_Last(
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDOC_STATUS_Last(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findByDOC_STATUS_PrevAndNext(
			long docId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	public void removeByDOC_STATUS(int statusDoc);

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByDOC_STATUS(int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByGroupId(long groupId);

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
	public java.util.List<LegalDocument> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LegalDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findByGroupId_PrevAndNext(
			long docId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal documents
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L(
		long groupId, String language);

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
	public java.util.List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_PrevAndNext(
			long docId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal documents
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId);

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
	public java.util.List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end);

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
	public java.util.List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByDocsByF_O_T_L_S_First(
			long groupId, long typeId, long organizationId, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByDocsByF_O_T_L_S_First(
		long groupId, long typeId, long organizationId, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByDocsByF_O_T_L_S_Last(
			long groupId, long typeId, long organizationId, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByDocsByF_O_T_L_S_Last(
		long groupId, long typeId, long organizationId, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByDocsByF_O_T_L_S_PrevAndNext(
			long docId, long groupId, long typeId, long organizationId,
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 */
	public void removeByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public int countByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId);

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
	public java.util.List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc);

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
	public java.util.List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByDocsByG_O_T_L_S_First(
			long groupId, long organizationId, long typeId, String language,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByDocsByG_O_T_L_S_First(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByDocsByG_O_T_L_S_Last(
			long groupId, long organizationId, long typeId, String language,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByDocsByG_O_T_L_S_Last(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByDocsByG_O_T_L_S_PrevAndNext(
			long docId, long groupId, long organizationId, long typeId,
			String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public void removeByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc);

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
	public int countByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc);

	/**
	 * Returns all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc);

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
	public java.util.List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end);

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
	public java.util.List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByDocsByO_T_F_S_First(
			long organizationId, long typeId, long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByDocsByO_T_F_S_First(
		long organizationId, long typeId, long fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByDocsByO_T_F_S_Last(
			long organizationId, long typeId, long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByDocsByO_T_F_S_Last(
		long organizationId, long typeId, long fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByDocsByO_T_F_S_PrevAndNext(
			long docId, long organizationId, long typeId, long fieldId,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	public void removeByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc);

	/**
	 * Returns the number of legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc);

	/**
	 * Returns all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc);

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
	public java.util.List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDocsByPromulDate_First(
			long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDocsByPromulDate_First(
		long typeId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDocsByPromulDate_Last(
			long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDocsByPromulDate_Last(
		long typeId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByDocsByPromulDate_PrevAndNext(
			long docId, long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	public void removeByDocsByPromulDate(long typeId, int statusDoc);

	/**
	 * Returns the number of legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByDocsByPromulDate(long typeId, int statusDoc);

	/**
	 * Returns all the legal documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDoc_Org(long organizationId);

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
	public java.util.List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end);

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
	public java.util.List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDoc_Org_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDoc_Org_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDoc_Org_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDoc_Org_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findByDoc_Org_PrevAndNext(
			long docId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByDoc_Org(long organizationId);

	/**
	 * Returns the number of legal documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal documents
	 */
	public int countByDoc_Org(long organizationId);

	/**
	 * Returns all the legal documents where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDoc_Category(long typeId);

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
	public java.util.List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end);

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
	public java.util.List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDoc_Category_First(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDoc_Category_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDoc_Category_Last(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDoc_Category_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findByDoc_Category_PrevAndNext(
			long docId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public void removeByDoc_Category(long typeId);

	/**
	 * Returns the number of legal documents where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	public int countByDoc_Category(long typeId);

	/**
	 * Returns all the legal documents where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDoc_Field(long fieldId);

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
	public java.util.List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end);

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
	public java.util.List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDoc_Field_First(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDoc_Field_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDoc_Field_Last(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDoc_Field_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findByDoc_Field_PrevAndNext(
			long docId, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public void removeByDoc_Field(long fieldId);

	/**
	 * Returns the number of legal documents where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public int countByDoc_Field(long fieldId);

	/**
	 * Returns all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByDocsByT_L(
		long typeId, String language);

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
	public java.util.List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end);

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
	public java.util.List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDocsByT_L_First(
			long typeId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDocsByT_L_First(
		long typeId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByDocsByT_L_Last(
			long typeId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByDocsByT_L_Last(
		long typeId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByDocsByT_L_PrevAndNext(
			long docId, long typeId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where typeId = &#63; and language = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 */
	public void removeByDocsByT_L(long typeId, String language);

	/**
	 * Returns the number of legal documents where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @return the number of matching legal documents
	 */
	public int countByDocsByT_L(long typeId, String language);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end);

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
	public java.util.List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_U_S_First(
			long groupId, String language, long userId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_U_S_First(
		long groupId, String language, long userId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_U_S_Last(
			long groupId, String language, long userId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_U_S_Last(
		long groupId, String language, long userId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_U_S_PrevAndNext(
			long docId, long groupId, String language, long userId,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 */
	public void removeByG_L_U_S(
		long groupId, String language, long userId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByG_L_U_S(
		long groupId, String language, long userId, int statusDoc);

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByG_D(long groupId, long docId)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_D(long groupId, long docId);

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_D(
		long groupId, long docId, boolean useFinderCache);

	/**
	 * Removes the legal document where groupId = &#63; and docId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the legal document that was removed
	 */
	public LegalDocument removeByG_D(long groupId, long docId)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the number of legal documents where groupId = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the number of matching legal documents
	 */
	public int countByG_D(long groupId, long docId);

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByP_N_S(long groupId, String num, String symbol)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByP_N_S(long groupId, String num, String symbol);

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByP_N_S(
		long groupId, String num, String symbol, boolean useFinderCache);

	/**
	 * Removes the legal document where groupId = &#63; and num = &#63; and symbol = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the legal document that was removed
	 */
	public LegalDocument removeByP_N_S(long groupId, String num, String symbol)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the number of legal documents where groupId = &#63; and num = &#63; and symbol = &#63;.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the number of matching legal documents
	 */
	public int countByP_N_S(long groupId, String num, String symbol);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc);

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
	public java.util.List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByP_L_S_First(
			long groupId, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByP_L_S_First(
		long groupId, String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByP_L_S_Last(
			long groupId, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByP_L_S_Last(
		long groupId, String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByP_L_S_PrevAndNext(
			long docId, long groupId, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public void removeByP_L_S(long groupId, String language, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByP_L_S(long groupId, String language, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end);

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
	public java.util.List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_P_S_First(
			long groupId, String language, int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_P_S_First(
		long groupId, String language, int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_P_S_Last(
			long groupId, String language, int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_P_S_Last(
		long groupId, String language, int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_P_S_PrevAndNext(
			long docId, long groupId, String language, int isPublic,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public void removeByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc);

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findBystatusDoc(int statusDoc);

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
	public java.util.List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findBystatusDoc_First(
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchBystatusDoc_First(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findBystatusDoc_Last(
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchBystatusDoc_Last(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findBystatusDoc_PrevAndNext(
			long docId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	public void removeBystatusDoc(int statusDoc);

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countBystatusDoc(int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end);

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
	public java.util.List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_O_S_First(
			long groupId, String language, long organizationId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_O_S_First(
		long groupId, String language, long organizationId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_O_S_Last(
			long groupId, String language, long organizationId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_O_S_Last(
		long groupId, String language, long organizationId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_O_S_PrevAndNext(
			long docId, long groupId, String language, long organizationId,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 */
	public void removeByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end);

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
	public java.util.List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_T_S_First(
			long groupId, String language, long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_T_S_First(
		long groupId, String language, long typeId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_T_S_Last(
			long groupId, String language, long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_T_S_Last(
		long groupId, String language, long typeId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_T_S_PrevAndNext(
			long docId, long groupId, String language, long typeId,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	public void removeByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end);

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
	public java.util.List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_F_S_First(
			long groupId, String language, long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_F_S_First(
		long groupId, String language, long fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_F_S_Last(
			long groupId, String language, long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_F_S_Last(
		long groupId, String language, long fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_F_S_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	public void removeByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc);

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
	public java.util.List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_F_P_S_First(
			long groupId, String language, long fieldId, int isPublic,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_F_P_S_First(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_F_P_S_Last(
			long groupId, String language, long fieldId, int isPublic,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByG_L_F_P_S_Last(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_F_P_S_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public void removeByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc);

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
	public int countByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Field_Public_Status(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator,
			boolean useFinderCache);

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
	public LegalDocument findByGroup_Company_Language_Field_Public_Status_First(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument
		fetchByGroup_Company_Language_Field_Public_Status_First(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator);

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
	public LegalDocument findByGroup_Company_Language_Field_Public_Status_Last(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Field_Public_Status_Last(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[]
			findByGroup_Company_Language_Field_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long fieldId, int isPublic, int statusDoc,
				com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
					orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public void removeByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc);

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
	public int countByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Org_Public_Status(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator,
			boolean useFinderCache);

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
	public LegalDocument findByGroup_Company_Language_Org_Public_Status_First(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Org_Public_Status_First(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByGroup_Company_Language_Org_Public_Status_Last(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Org_Public_Status_Last(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[]
			findByGroup_Company_Language_Org_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long organizationId, int isPublic, int statusDoc,
				com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
					orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public void removeByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc);

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
	public int countByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Type_Public_Status(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator,
			boolean useFinderCache);

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
	public LegalDocument findByGroup_Company_Language_Type_Public_Status_First(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Type_Public_Status_First(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByGroup_Company_Language_Type_Public_Status_Last(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Type_Public_Status_Last(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[]
			findByGroup_Company_Language_Type_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long typeId, int isPublic, int statusDoc,
				com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
					orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public void removeByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc);

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
	public int countByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator);

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
	public java.util.List<LegalDocument>
		findByGroup_Company_Language_Public_Status(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator,
			boolean useFinderCache);

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
	public LegalDocument findByGroup_Company_Language_Public_Status_First(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Public_Status_First(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByGroup_Company_Language_Public_Status_Last(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Public_Status_Last(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[]
			findByGroup_Company_Language_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				int isPublic, int statusDoc,
				com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
					orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public void removeByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc);

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
	public int countByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc);

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
	public java.util.List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end);

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
	public java.util.List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByGroup_Company_Language_Status_First(
			long groupId, long companyId, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Status_First(
		long groupId, long companyId, String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByGroup_Company_Language_Status_Last(
			long groupId, long companyId, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByGroup_Company_Language_Status_Last(
		long groupId, long companyId, String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByGroup_Company_Language_Status_PrevAndNext(
			long docId, long groupId, long companyId, String language,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public void removeByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc);

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
	public java.util.List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByGroup_Company_Status_First(
			long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByGroup_Company_Status_First(
		long groupId, long companyId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByGroup_Company_Status_Last(
			long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByGroup_Company_Status_Last(
		long groupId, long companyId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByGroup_Company_Status_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	public void removeByGroup_Company_Status(
		long groupId, long companyId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByGroup_Company_Status(
		long groupId, long companyId, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId);

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
	public java.util.List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end);

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
	public java.util.List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_O_First(
			long groupId, String language, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_O_First(
		long groupId, String language, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_O_Last(
			long groupId, String language, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_O_Last(
		long groupId, String language, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_O_PrevAndNext(
			long docId, long groupId, String language, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 */
	public void removeByG_L_O(
		long groupId, String language, long organizationId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @return the number of matching legal documents
	 */
	public int countByG_L_O(long groupId, String language, long organizationId);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId);

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
	public java.util.List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end);

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
	public java.util.List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_T_First(
			long groupId, String language, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_T_First(
		long groupId, String language, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_T_Last(
			long groupId, String language, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_T_Last(
		long groupId, String language, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_T_PrevAndNext(
			long docId, long groupId, String language, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 */
	public void removeByG_L_T(long groupId, String language, long typeId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	public int countByG_L_T(long groupId, String language, long typeId);

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId);

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
	public java.util.List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end);

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
	public java.util.List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByG_L_F_First(
			long groupId, String language, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_F_First(
		long groupId, String language, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByG_L_F_Last(
			long groupId, String language, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByG_L_F_Last(
		long groupId, String language, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByG_L_F_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 */
	public void removeByG_L_F(long groupId, String language, long fieldId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public int countByG_L_F(long groupId, String language, long fieldId);

	/**
	 * Returns all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc);

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
	public java.util.List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end);

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
	public java.util.List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByP_U_S_First(
			long groupId, long createdByUser, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByP_U_S_First(
		long groupId, long createdByUser, String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByP_U_S_Last(
			long groupId, long createdByUser, String language, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

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
	public LegalDocument fetchByP_U_S_Last(
		long groupId, long createdByUser, String language, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByP_U_S_PrevAndNext(
			long docId, long groupId, long createdByUser, String language,
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	public void removeByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc);

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByStatus(int statusDoc);

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
	public java.util.List<LegalDocument> findByStatus(
		int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByStatus(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByStatus(
		int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByStatus_First(
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByStatus_First(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByStatus_Last(
			int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByStatus_Last(
		int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument[] findByStatus_PrevAndNext(
			long docId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	public void removeByStatus(int statusDoc);

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByStatus(int statusDoc);

	/**
	 * Returns all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc);

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
	public java.util.List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByIsPublic_Status_First(
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByIsPublic_Status_First(
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByIsPublic_Status_Last(
			int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByIsPublic_Status_Last(
		int isPublic, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByIsPublic_Status_PrevAndNext(
			long docId, int isPublic, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	public void removeByIsPublic_Status(int isPublic, int statusDoc);

	/**
	 * Returns the number of legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByIsPublic_Status(int isPublic, int statusDoc);

	/**
	 * Returns all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc);

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
	public java.util.List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByOrg_Status_First(
			long organizationId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByOrg_Status_First(
		long organizationId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByOrg_Status_Last(
			long organizationId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByOrg_Status_Last(
		long organizationId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByOrg_Status_PrevAndNext(
			long docId, long organizationId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where organizationId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 */
	public void removeByOrg_Status(long organizationId, int statusDoc);

	/**
	 * Returns the number of legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByOrg_Status(long organizationId, int statusDoc);

	/**
	 * Returns all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByType_Status(
		long typeId, int statusDoc);

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
	public java.util.List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByType_Status_First(
			long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByType_Status_First(
		long typeId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByType_Status_Last(
			long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByType_Status_Last(
		long typeId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByType_Status_PrevAndNext(
			long docId, long typeId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	public void removeByType_Status(long typeId, int statusDoc);

	/**
	 * Returns the number of legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByType_Status(long typeId, int statusDoc);

	/**
	 * Returns all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc);

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
	public java.util.List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByField_Status_First(
			long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByField_Status_First(
		long fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByField_Status_Last(
			long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByField_Status_Last(
		long fieldId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByField_Status_PrevAndNext(
			long docId, long fieldId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	public void removeByField_Status(long fieldId, int statusDoc);

	/**
	 * Returns the number of legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByField_Status(long fieldId, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc);

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
	public java.util.List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByFindGroup_First(
			long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindGroup_First(
		long groupId, long companyId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByFindGroup_Last(
			long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindGroup_Last(
		long groupId, long companyId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByFindGroup_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	public void removeByFindGroup(long groupId, long companyId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByFindGroup(long groupId, long companyId, int statusDoc);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByFindAll(
		long groupId, long companyId);

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
	public java.util.List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	public LegalDocument findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByFindAll_PrevAndNext(
			long docId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal documents
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId);

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
	public java.util.List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end);

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
	public java.util.List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByFindType_First(
			long groupId, long companyId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindType_First(
		long groupId, long companyId, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByFindType_Last(
			long groupId, long companyId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindType_Last(
		long groupId, long companyId, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByFindType_PrevAndNext(
			long docId, long groupId, long companyId, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 */
	public void removeByFindType(long groupId, long companyId, long typeId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	public int countByFindType(long groupId, long companyId, long typeId);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId);

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
	public java.util.List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end);

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
	public java.util.List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByFindField_First(
			long groupId, long companyId, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindField_First(
		long groupId, long companyId, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByFindField_Last(
			long groupId, long companyId, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByFindField_Last(
		long groupId, long companyId, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByFindField_PrevAndNext(
			long docId, long groupId, long companyId, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 */
	public void removeByFindField(long groupId, long companyId, long fieldId);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	public int countByFindField(long groupId, long companyId, long fieldId);

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	public java.util.List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc);

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
	public java.util.List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end);

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
	public java.util.List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDocument findByLegalStatus_First(
			long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByLegalStatus_First(
		long groupId, long companyId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument findByLegalStatus_Last(
			long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	public LegalDocument fetchByLegalStatus_Last(
		long groupId, long companyId, int statusDoc,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public LegalDocument[] findByLegalStatus_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
				orderByComparator)
		throws NoSuchLegalDocumentException;

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	public void removeByLegalStatus(
		long groupId, long companyId, int statusDoc);

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	public int countByLegalStatus(long groupId, long companyId, int statusDoc);

	/**
	 * Caches the legal document in the entity cache if it is enabled.
	 *
	 * @param legalDocument the legal document
	 */
	public void cacheResult(LegalDocument legalDocument);

	/**
	 * Caches the legal documents in the entity cache if it is enabled.
	 *
	 * @param legalDocuments the legal documents
	 */
	public void cacheResult(java.util.List<LegalDocument> legalDocuments);

	/**
	 * Creates a new legal document with the primary key. Does not add the legal document to the database.
	 *
	 * @param docId the primary key for the new legal document
	 * @return the new legal document
	 */
	public LegalDocument create(long docId);

	/**
	 * Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument remove(long docId) throws NoSuchLegalDocumentException;

	public LegalDocument updateImpl(LegalDocument legalDocument);

	/**
	 * Returns the legal document with the primary key or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	public LegalDocument findByPrimaryKey(long docId)
		throws NoSuchLegalDocumentException;

	/**
	 * Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	 */
	public LegalDocument fetchByPrimaryKey(long docId);

	/**
	 * Returns all the legal documents.
	 *
	 * @return the legal documents
	 */
	public java.util.List<LegalDocument> findAll();

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
	public java.util.List<LegalDocument> findAll(int start, int end);

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
	public java.util.List<LegalDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator);

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
	public java.util.List<LegalDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal documents.
	 *
	 * @return the number of legal documents
	 */
	public int countAll();

}