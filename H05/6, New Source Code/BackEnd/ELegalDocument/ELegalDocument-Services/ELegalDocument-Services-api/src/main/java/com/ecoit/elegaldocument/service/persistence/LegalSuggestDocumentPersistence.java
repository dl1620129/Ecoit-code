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

import com.ecoit.elegaldocument.exception.NoSuchLegalSuggestDocumentException;
import com.ecoit.elegaldocument.model.LegalSuggestDocument;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal suggest document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalSuggestDocumentUtil
 * @generated
 */
@ProviderType
public interface LegalSuggestDocumentPersistence
	extends BasePersistence<LegalSuggestDocument> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalSuggestDocumentUtil} to access the legal suggest document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal suggest documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findByGroupId(long groupId);

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
	public java.util.List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public LegalSuggestDocument[] findByGroupId_PrevAndNext(
			long sugId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal suggest documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal suggest documents
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved);

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
	public java.util.List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end);

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
	public java.util.List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByP_A_First(
			long groupId, boolean approved,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByP_A_First(
		long groupId, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByP_A_Last(
			long groupId, boolean approved,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByP_A_Last(
		long groupId, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument[] findByP_A_PrevAndNext(
			long sugId, long groupId, boolean approved,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 */
	public void removeByP_A(long groupId, boolean approved);

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the number of matching legal suggest documents
	 */
	public int countByP_A(long groupId, boolean approved);

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or throws a <code>NoSuchLegalSuggestDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByG_S(long groupId, long sugId)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByG_S(long groupId, long sugId);

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByG_S(
		long groupId, long sugId, boolean useFinderCache);

	/**
	 * Removes the legal suggest document where groupId = &#63; and sugId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the legal suggest document that was removed
	 */
	public LegalSuggestDocument removeByG_S(long groupId, long sugId)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and sugId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the number of matching legal suggest documents
	 */
	public int countByG_S(long groupId, long sugId);

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findByG_L(
		long groupId, String language);

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
	public java.util.List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument[] findByG_L_PrevAndNext(
			long sugId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal suggest documents
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved);

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
	public java.util.List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end);

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
	public java.util.List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalSuggestDocument findByG_L_A_First(
			long groupId, String language, boolean approved,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByG_L_A_First(
		long groupId, String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument findByG_L_A_Last(
			long groupId, String language, boolean approved,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByG_L_A_Last(
		long groupId, String language, boolean approved,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument[] findByG_L_A_PrevAndNext(
			long sugId, long groupId, String language, boolean approved,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 */
	public void removeByG_L_A(long groupId, String language, boolean approved);

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the number of matching legal suggest documents
	 */
	public int countByG_L_A(long groupId, String language, boolean approved);

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId);

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
	public java.util.List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end);

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
	public java.util.List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalSuggestDocument findByP_L_A_D_First(
			long groupId, String language, boolean approved, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

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
	public LegalSuggestDocument fetchByP_L_A_D_First(
		long groupId, String language, boolean approved, long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument findByP_L_A_D_Last(
			long groupId, String language, boolean approved, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

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
	public LegalSuggestDocument fetchByP_L_A_D_Last(
		long groupId, String language, boolean approved, long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument[] findByP_L_A_D_PrevAndNext(
			long sugId, long groupId, String language, boolean approved,
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 */
	public void removeByP_L_A_D(
		long groupId, String language, boolean approved, long docId);

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	public int countByP_L_A_D(
		long groupId, String language, boolean approved, long docId);

	/**
	 * Returns all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId);

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
	public java.util.List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end);

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
	public java.util.List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByA_D_First(
			boolean approved, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the first legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByA_D_First(
		boolean approved, long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the last legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findByA_D_Last(
			boolean approved, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the last legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchByA_D_Last(
		boolean approved, long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public LegalSuggestDocument[] findByA_D_PrevAndNext(
			long sugId, boolean approved, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where approved = &#63; and docId = &#63; from the database.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 */
	public void removeByA_D(boolean approved, long docId);

	/**
	 * Returns the number of legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	public int countByA_D(boolean approved, long docId);

	/**
	 * Returns all the legal suggest documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findBySuggByDocId(long docId);

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
	public java.util.List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end);

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
	public java.util.List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findBySuggByDocId_First(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the first legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchBySuggByDocId_First(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the last legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument findBySuggByDocId_Last(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the last legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	public LegalSuggestDocument fetchBySuggByDocId_Last(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public LegalSuggestDocument[] findBySuggByDocId_PrevAndNext(
			long sugId, long docId,
			com.liferay.portal.kernel.util.OrderByComparator
				<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Removes all the legal suggest documents where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeBySuggByDocId(long docId);

	/**
	 * Returns the number of legal suggest documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	public int countBySuggByDocId(long docId);

	/**
	 * Caches the legal suggest document in the entity cache if it is enabled.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 */
	public void cacheResult(LegalSuggestDocument legalSuggestDocument);

	/**
	 * Caches the legal suggest documents in the entity cache if it is enabled.
	 *
	 * @param legalSuggestDocuments the legal suggest documents
	 */
	public void cacheResult(
		java.util.List<LegalSuggestDocument> legalSuggestDocuments);

	/**
	 * Creates a new legal suggest document with the primary key. Does not add the legal suggest document to the database.
	 *
	 * @param sugId the primary key for the new legal suggest document
	 * @return the new legal suggest document
	 */
	public LegalSuggestDocument create(long sugId);

	/**
	 * Removes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public LegalSuggestDocument remove(long sugId)
		throws NoSuchLegalSuggestDocumentException;

	public LegalSuggestDocument updateImpl(
		LegalSuggestDocument legalSuggestDocument);

	/**
	 * Returns the legal suggest document with the primary key or throws a <code>NoSuchLegalSuggestDocumentException</code> if it could not be found.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	public LegalSuggestDocument findByPrimaryKey(long sugId)
		throws NoSuchLegalSuggestDocumentException;

	/**
	 * Returns the legal suggest document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document, or <code>null</code> if a legal suggest document with the primary key could not be found
	 */
	public LegalSuggestDocument fetchByPrimaryKey(long sugId);

	/**
	 * Returns all the legal suggest documents.
	 *
	 * @return the legal suggest documents
	 */
	public java.util.List<LegalSuggestDocument> findAll();

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
	public java.util.List<LegalSuggestDocument> findAll(int start, int end);

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
	public java.util.List<LegalSuggestDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator);

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
	public java.util.List<LegalSuggestDocument> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSuggestDocument>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal suggest documents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal suggest documents.
	 *
	 * @return the number of legal suggest documents
	 */
	public int countAll();

}