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

import com.ecoit.elegaldocument.exception.NoSuchLegalDraftDocumentException;
import com.ecoit.elegaldocument.model.LegalDraftDocument;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal draft document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDraftDocumentUtil
 * @generated
 */
@ProviderType
public interface LegalDraftDocumentPersistence
	extends BasePersistence<LegalDraftDocument> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDraftDocumentUtil} to access the legal draft document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal draft document where draftId = &#63; or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param draftId the draft ID
	 * @return the matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findBydraftId(long draftId)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the legal draft document where draftId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param draftId the draft ID
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchBydraftId(long draftId);

	/**
	 * Returns the legal draft document where draftId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param draftId the draft ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchBydraftId(
		long draftId, boolean useFinderCache);

	/**
	 * Removes the legal draft document where draftId = &#63; from the database.
	 *
	 * @param draftId the draft ID
	 * @return the legal draft document that was removed
	 */
	public LegalDraftDocument removeBydraftId(long draftId)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the number of legal draft documents where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the number of matching legal draft documents
	 */
	public int countBydraftId(long draftId);

	/**
	 * Returns all the legal draft documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByGroupId(long groupId);

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
	public java.util.List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public LegalDraftDocument[] findByGroupId_PrevAndNext(
			long draftId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal draft documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal draft documents
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByG_L(
		long groupId, String language);

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
	public java.util.List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByG_L_PrevAndNext(
			long draftId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByG_D(long groupId, long draftId)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByG_D(long groupId, long draftId);

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByG_D(
		long groupId, long draftId, boolean useFinderCache);

	/**
	 * Removes the legal draft document where groupId = &#63; and draftId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the legal draft document that was removed
	 */
	public LegalDraftDocument removeByG_D(long groupId, long draftId)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and draftId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the number of matching legal draft documents
	 */
	public int countByG_D(long groupId, long draftId);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode);

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
	public java.util.List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDraftDocument findByP_S_D_First(
			long groupId, int statusDraft, String docCode,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_D_First(
		long groupId, int statusDraft, String docCode,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument findByP_S_D_Last(
			long groupId, int statusDraft, String docCode,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_D_Last(
		long groupId, int statusDraft, String docCode,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByP_S_D_PrevAndNext(
			long draftId, long groupId, int statusDraft, String docCode,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 */
	public void removeByP_S_D(long groupId, int statusDraft, String docCode);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @return the number of matching legal draft documents
	 */
	public int countByP_S_D(long groupId, int statusDraft, String docCode);

	/**
	 * Returns all the legal draft documents where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft);

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
	public java.util.List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByDRAFT_STATUS_First(
			int statusDraft,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByDRAFT_STATUS_First(
		int statusDraft,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the last legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByDRAFT_STATUS_Last(
			int statusDraft,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByDRAFT_STATUS_Last(
		int statusDraft,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public LegalDraftDocument[] findByDRAFT_STATUS_PrevAndNext(
			long draftId, int statusDraft,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where statusDraft = &#63; from the database.
	 *
	 * @param statusDraft the status draft
	 */
	public void removeByDRAFT_STATUS(int statusDraft);

	/**
	 * Returns the number of legal draft documents where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @return the number of matching legal draft documents
	 */
	public int countByDRAFT_STATUS(int statusDraft);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId);

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
	public java.util.List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDraftDocument findByP_S_F_First(
			long groupId, int statusDraft, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_F_First(
		long groupId, int statusDraft, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument findByP_S_F_Last(
			long groupId, int statusDraft, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_F_Last(
		long groupId, int statusDraft, long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByP_S_F_PrevAndNext(
			long draftId, long groupId, int statusDraft, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 */
	public void removeByP_S_F(long groupId, int statusDraft, long fieldId);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @return the number of matching legal draft documents
	 */
	public int countByP_S_F(long groupId, int statusDraft, long fieldId);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId);

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
	public java.util.List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDraftDocument findByP_S_T_First(
			long groupId, int statusDraft, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_T_First(
		long groupId, int statusDraft, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument findByP_S_T_Last(
			long groupId, int statusDraft, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_T_Last(
		long groupId, int statusDraft, long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByP_S_T_PrevAndNext(
			long draftId, long groupId, int statusDraft, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 */
	public void removeByP_S_T(long groupId, int statusDraft, long typeId);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @return the number of matching legal draft documents
	 */
	public int countByP_S_T(long groupId, int statusDraft, long typeId);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language);

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
	public java.util.List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDraftDocument findByP_S_L_First(
			long groupId, int statusDraft, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_L_First(
		long groupId, int statusDraft, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument findByP_S_L_Last(
			long groupId, int statusDraft, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_S_L_Last(
		long groupId, int statusDraft, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByP_S_L_PrevAndNext(
			long draftId, long groupId, int statusDraft, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 */
	public void removeByP_S_L(long groupId, int statusDraft, String language);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public int countByP_S_L(long groupId, int statusDraft, String language);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByP_L(
		long groupId, String language);

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
	public java.util.List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByP_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByP_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByP_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByP_L_PrevAndNext(
			long draftId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByP_L(long groupId, String language);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public int countByP_L(long groupId, String language);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language);

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
	public java.util.List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end);

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
	public java.util.List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDraftDocument findByP_S_U_L_First(
			long groupId, int statusDraft, long createdByUser, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

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
	public LegalDraftDocument fetchByP_S_U_L_First(
		long groupId, int statusDraft, long createdByUser, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument findByP_S_U_L_Last(
			long groupId, int statusDraft, long createdByUser, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

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
	public LegalDraftDocument fetchByP_S_U_L_Last(
		long groupId, int statusDraft, long createdByUser, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByP_S_U_L_PrevAndNext(
			long draftId, long groupId, int statusDraft, long createdByUser,
			String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 */
	public void removeByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	public int countByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language);

	/**
	 * Returns all the legal draft documents where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByDocCode(String docCode);

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
	public java.util.List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByDocCode_First(
			String docCode,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByDocCode_First(
		String docCode,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the last legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByDocCode_Last(
			String docCode,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByDocCode_Last(
		String docCode,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public LegalDraftDocument[] findByDocCode_PrevAndNext(
			long draftId, String docCode,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where docCode = &#63; from the database.
	 *
	 * @param docCode the doc code
	 */
	public void removeByDocCode(String docCode);

	/**
	 * Returns the number of legal draft documents where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @return the number of matching legal draft documents
	 */
	public int countByDocCode(String docCode);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft);

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
	public java.util.List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalDraftDocument findByFindGroup_First(
			long groupId, long companyId, int statusDraft,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByFindGroup_First(
		long groupId, long companyId, int statusDraft,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument findByFindGroup_Last(
			long groupId, long companyId, int statusDraft,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByFindGroup_Last(
		long groupId, long companyId, int statusDraft,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByFindGroup_PrevAndNext(
			long draftId, long groupId, long companyId, int statusDraft,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 */
	public void removeByFindGroup(
		long groupId, long companyId, int statusDraft);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @return the number of matching legal draft documents
	 */
	public int countByFindGroup(long groupId, long companyId, int statusDraft);

	/**
	 * Returns all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId);

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
	public java.util.List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	public LegalDraftDocument findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	public LegalDraftDocument fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public LegalDraftDocument[] findByFindAll_PrevAndNext(
			long draftId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
				orderByComparator)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Removes all the legal draft documents where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal draft documents
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the legal draft document in the entity cache if it is enabled.
	 *
	 * @param legalDraftDocument the legal draft document
	 */
	public void cacheResult(LegalDraftDocument legalDraftDocument);

	/**
	 * Caches the legal draft documents in the entity cache if it is enabled.
	 *
	 * @param legalDraftDocuments the legal draft documents
	 */
	public void cacheResult(
		java.util.List<LegalDraftDocument> legalDraftDocuments);

	/**
	 * Creates a new legal draft document with the primary key. Does not add the legal draft document to the database.
	 *
	 * @param draftId the primary key for the new legal draft document
	 * @return the new legal draft document
	 */
	public LegalDraftDocument create(long draftId);

	/**
	 * Removes the legal draft document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document that was removed
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public LegalDraftDocument remove(long draftId)
		throws NoSuchLegalDraftDocumentException;

	public LegalDraftDocument updateImpl(LegalDraftDocument legalDraftDocument);

	/**
	 * Returns the legal draft document with the primary key or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	public LegalDraftDocument findByPrimaryKey(long draftId)
		throws NoSuchLegalDraftDocumentException;

	/**
	 * Returns the legal draft document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document, or <code>null</code> if a legal draft document with the primary key could not be found
	 */
	public LegalDraftDocument fetchByPrimaryKey(long draftId);

	/**
	 * Returns all the legal draft documents.
	 *
	 * @return the legal draft documents
	 */
	public java.util.List<LegalDraftDocument> findAll();

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
	public java.util.List<LegalDraftDocument> findAll(int start, int end);

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
	public java.util.List<LegalDraftDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator);

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
	public java.util.List<LegalDraftDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDraftDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal draft documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal draft documents.
	 *
	 * @return the number of legal draft documents
	 */
	public int countAll();

}