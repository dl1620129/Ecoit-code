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

import com.ecoit.elegaldocument.exception.NoSuchLegalSignerException;
import com.ecoit.elegaldocument.model.LegalSigner;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal signer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalSignerUtil
 * @generated
 */
@ProviderType
public interface LegalSignerPersistence extends BasePersistence<LegalSigner> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalSignerUtil} to access the legal signer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal signer where sigId = &#63; or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findBySigId(long sigId)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the legal signer where sigId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchBySigId(long sigId);

	/**
	 * Returns the legal signer where sigId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sigId the sig ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchBySigId(long sigId, boolean useFinderCache);

	/**
	 * Removes the legal signer where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 * @return the legal signer that was removed
	 */
	public LegalSigner removeBySigId(long sigId)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the number of legal signers where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching legal signers
	 */
	public int countBySigId(long sigId);

	/**
	 * Returns all the legal signers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal signers
	 */
	public java.util.List<LegalSigner> findByGroupId(long groupId);

	/**
	 * Returns a range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner[] findByGroupId_PrevAndNext(
			long sigId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Removes all the legal signers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal signers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal signers
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByG_S(long groupId, long sigId)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByG_S(long groupId, long sigId);

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByG_S(
		long groupId, long sigId, boolean useFinderCache);

	/**
	 * Removes the legal signer where groupId = &#63; and sigId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the legal signer that was removed
	 */
	public LegalSigner removeByG_S(long groupId, long sigId)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the number of legal signers where groupId = &#63; and sigId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the number of matching legal signers
	 */
	public int countByG_S(long groupId, long sigId);

	/**
	 * Returns all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L(long groupId, String language);

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner[] findByG_L_PrevAndNext(
			long sigId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Removes all the legal signers where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal signers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal signers
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner);

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start,
		int end);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByG_L_S_First(
			long groupId, String language, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByG_L_S_First(
		long groupId, String language, boolean statusSigner,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByG_L_S_Last(
			long groupId, String language, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByG_L_S_Last(
		long groupId, String language, boolean statusSigner,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner[] findByG_L_S_PrevAndNext(
			long sigId, long groupId, String language, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Removes all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 */
	public void removeByG_L_S(
		long groupId, String language, boolean statusSigner);

	/**
	 * Returns the number of legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	public int countByG_L_S(
		long groupId, String language, boolean statusSigner);

	/**
	 * Returns all the legal signers where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	public java.util.List<LegalSigner> findByStatusSIGN(boolean statusSigner);

	/**
	 * Returns a range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end);

	/**
	 * Returns an ordered range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByStatusSIGN_First(
			boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the first legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByStatusSIGN_First(
		boolean statusSigner,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the last legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByStatusSIGN_Last(
			boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the last legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByStatusSIGN_Last(
		boolean statusSigner,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner[] findByStatusSIGN_PrevAndNext(
			long sigId, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Removes all the legal signers where statusSigner = &#63; from the database.
	 *
	 * @param statusSigner the status signer
	 */
	public void removeByStatusSIGN(boolean statusSigner);

	/**
	 * Returns the number of legal signers where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	public int countByStatusSIGN(boolean statusSigner);

	/**
	 * Returns all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner);

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByFindGroup_First(
			long groupId, long companyId, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByFindGroup_First(
		long groupId, long companyId, boolean statusSigner,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByFindGroup_Last(
			long groupId, long companyId, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusSigner,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner[] findByFindGroup_PrevAndNext(
			long sigId, long groupId, long companyId, boolean statusSigner,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Removes all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 */
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusSigner);

	/**
	 * Returns the number of legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	public int countByFindGroup(
		long groupId, long companyId, boolean statusSigner);

	/**
	 * Returns all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindAll(
		long groupId, long companyId);

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	public java.util.List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	public LegalSigner findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	public LegalSigner fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner[] findByFindAll_PrevAndNext(
			long sigId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
				orderByComparator)
		throws NoSuchLegalSignerException;

	/**
	 * Removes all the legal signers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal signers
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the legal signer in the entity cache if it is enabled.
	 *
	 * @param legalSigner the legal signer
	 */
	public void cacheResult(LegalSigner legalSigner);

	/**
	 * Caches the legal signers in the entity cache if it is enabled.
	 *
	 * @param legalSigners the legal signers
	 */
	public void cacheResult(java.util.List<LegalSigner> legalSigners);

	/**
	 * Creates a new legal signer with the primary key. Does not add the legal signer to the database.
	 *
	 * @param sigId the primary key for the new legal signer
	 * @return the new legal signer
	 */
	public LegalSigner create(long sigId);

	/**
	 * Removes the legal signer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer that was removed
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner remove(long sigId) throws NoSuchLegalSignerException;

	public LegalSigner updateImpl(LegalSigner legalSigner);

	/**
	 * Returns the legal signer with the primary key or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	public LegalSigner findByPrimaryKey(long sigId)
		throws NoSuchLegalSignerException;

	/**
	 * Returns the legal signer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer, or <code>null</code> if a legal signer with the primary key could not be found
	 */
	public LegalSigner fetchByPrimaryKey(long sigId);

	/**
	 * Returns all the legal signers.
	 *
	 * @return the legal signers
	 */
	public java.util.List<LegalSigner> findAll();

	/**
	 * Returns a range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of legal signers
	 */
	public java.util.List<LegalSigner> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal signers
	 */
	public java.util.List<LegalSigner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal signers
	 */
	public java.util.List<LegalSigner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalSigner>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal signers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal signers.
	 *
	 * @return the number of legal signers
	 */
	public int countAll();

}