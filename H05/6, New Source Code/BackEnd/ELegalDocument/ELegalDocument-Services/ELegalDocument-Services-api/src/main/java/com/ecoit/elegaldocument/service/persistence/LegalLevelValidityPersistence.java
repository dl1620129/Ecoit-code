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

import com.ecoit.elegaldocument.exception.NoSuchLegalLevelValidityException;
import com.ecoit.elegaldocument.model.LegalLevelValidity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal level validity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalLevelValidityUtil
 * @generated
 */
@ProviderType
public interface LegalLevelValidityPersistence
	extends BasePersistence<LegalLevelValidity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalLevelValidityUtil} to access the legal level validity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByLevelValidityId(long levelValidityId)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByLevelValidityId(long levelValidityId);

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelValidityId the level validity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByLevelValidityId(
		long levelValidityId, boolean useFinderCache);

	/**
	 * Removes the legal level validity where levelValidityId = &#63; from the database.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the legal level validity that was removed
	 */
	public LegalLevelValidity removeByLevelValidityId(long levelValidityId)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the number of legal level validities where levelValidityId = &#63;.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the number of matching legal level validities
	 */
	public int countByLevelValidityId(long levelValidityId);

	/**
	 * Returns all the legal level validities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal level validities
	 */
	public java.util.List<LegalLevelValidity> findByGroupId(long groupId);

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
	public java.util.List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public LegalLevelValidity[] findByGroupId_PrevAndNext(
			long levelValidityId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Removes all the legal level validities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal level validities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal level validities
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByG_LV(long groupId, long levelValidityId)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByG_LV(long groupId, long levelValidityId);

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByG_LV(
		long groupId, long levelValidityId, boolean useFinderCache);

	/**
	 * Removes the legal level validity where groupId = &#63; and levelValidityId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the legal level validity that was removed
	 */
	public LegalLevelValidity removeByG_LV(long groupId, long levelValidityId)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the number of legal level validities where groupId = &#63; and levelValidityId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the number of matching legal level validities
	 */
	public int countByG_LV(long groupId, long levelValidityId);

	/**
	 * Returns all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal level validities
	 */
	public java.util.List<LegalLevelValidity> findByG_L(
		long groupId, String language);

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
	public java.util.List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public LegalLevelValidity[] findByG_L_PrevAndNext(
			long levelValidityId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Removes all the legal level validities where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal level validities
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	public java.util.List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity);

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
	public java.util.List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end);

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
	public java.util.List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalLevelValidity findByG_L_S_First(
			long groupId, String language, boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByG_L_S_First(
		long groupId, String language, boolean statusLevelValidity,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public LegalLevelValidity findByG_L_S_Last(
			long groupId, String language, boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByG_L_S_Last(
		long groupId, String language, boolean statusLevelValidity,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public LegalLevelValidity[] findByG_L_S_PrevAndNext(
			long levelValidityId, long groupId, String language,
			boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Removes all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 */
	public void removeByG_L_S(
		long groupId, String language, boolean statusLevelValidity);

	/**
	 * Returns the number of legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	public int countByG_L_S(
		long groupId, String language, boolean statusLevelValidity);

	/**
	 * Returns all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	public java.util.List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity);

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
	public java.util.List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end);

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
	public java.util.List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByStatusLevelValidity_First(
			boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the first legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByStatusLevelValidity_First(
		boolean statusLevelValidity,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

	/**
	 * Returns the last legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByStatusLevelValidity_Last(
			boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the last legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByStatusLevelValidity_Last(
		boolean statusLevelValidity,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public LegalLevelValidity[] findByStatusLevelValidity_PrevAndNext(
			long levelValidityId, boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Removes all the legal level validities where statusLevelValidity = &#63; from the database.
	 *
	 * @param statusLevelValidity the status level validity
	 */
	public void removeByStatusLevelValidity(boolean statusLevelValidity);

	/**
	 * Returns the number of legal level validities where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	public int countByStatusLevelValidity(boolean statusLevelValidity);

	/**
	 * Returns all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	public java.util.List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity);

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
	public java.util.List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end);

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
	public java.util.List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalLevelValidity findByFindGroup_First(
			long groupId, long companyId, boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByFindGroup_First(
		long groupId, long companyId, boolean statusLevelValidity,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public LegalLevelValidity findByFindGroup_Last(
			long groupId, long companyId, boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusLevelValidity,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public LegalLevelValidity[] findByFindGroup_PrevAndNext(
			long levelValidityId, long groupId, long companyId,
			boolean statusLevelValidity,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Removes all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 */
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity);

	/**
	 * Returns the number of legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	public int countByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity);

	/**
	 * Returns all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal level validities
	 */
	public java.util.List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId);

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
	public java.util.List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	public LegalLevelValidity findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	public LegalLevelValidity fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public LegalLevelValidity[] findByFindAll_PrevAndNext(
			long levelValidityId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
				orderByComparator)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Removes all the legal level validities where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal level validities
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the legal level validity in the entity cache if it is enabled.
	 *
	 * @param legalLevelValidity the legal level validity
	 */
	public void cacheResult(LegalLevelValidity legalLevelValidity);

	/**
	 * Caches the legal level validities in the entity cache if it is enabled.
	 *
	 * @param legalLevelValidities the legal level validities
	 */
	public void cacheResult(
		java.util.List<LegalLevelValidity> legalLevelValidities);

	/**
	 * Creates a new legal level validity with the primary key. Does not add the legal level validity to the database.
	 *
	 * @param levelValidityId the primary key for the new legal level validity
	 * @return the new legal level validity
	 */
	public LegalLevelValidity create(long levelValidityId);

	/**
	 * Removes the legal level validity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity that was removed
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public LegalLevelValidity remove(long levelValidityId)
		throws NoSuchLegalLevelValidityException;

	public LegalLevelValidity updateImpl(LegalLevelValidity legalLevelValidity);

	/**
	 * Returns the legal level validity with the primary key or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	public LegalLevelValidity findByPrimaryKey(long levelValidityId)
		throws NoSuchLegalLevelValidityException;

	/**
	 * Returns the legal level validity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity, or <code>null</code> if a legal level validity with the primary key could not be found
	 */
	public LegalLevelValidity fetchByPrimaryKey(long levelValidityId);

	/**
	 * Returns all the legal level validities.
	 *
	 * @return the legal level validities
	 */
	public java.util.List<LegalLevelValidity> findAll();

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
	public java.util.List<LegalLevelValidity> findAll(int start, int end);

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
	public java.util.List<LegalLevelValidity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator);

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
	public java.util.List<LegalLevelValidity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalLevelValidity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal level validities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal level validities.
	 *
	 * @return the number of legal level validities
	 */
	public int countAll();

}