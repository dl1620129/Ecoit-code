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

import com.ecoit.elegaldocument.exception.NoSuchLegalTypeException;
import com.ecoit.elegaldocument.model.LegalType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalTypeUtil
 * @generated
 */
@ProviderType
public interface LegalTypePersistence extends BasePersistence<LegalType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalTypeUtil} to access the legal type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal type where typeId = &#63; or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param typeId the type ID
	 * @return the matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByTypeId(long typeId) throws NoSuchLegalTypeException;

	/**
	 * Returns the legal type where typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeId the type ID
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByTypeId(long typeId);

	/**
	 * Returns the legal type where typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByTypeId(long typeId, boolean useFinderCache);

	/**
	 * Removes the legal type where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @return the legal type that was removed
	 */
	public LegalType removeByTypeId(long typeId)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the number of legal types where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal types
	 */
	public int countByTypeId(long typeId);

	/**
	 * Returns all the legal types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByGroupId(long groupId);

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
	public java.util.List<LegalType> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LegalType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public LegalType[] findByGroupId_PrevAndNext(
			long typeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal types
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByG_L(long groupId, String language);

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
	public java.util.List<LegalType> findByG_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalType> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByG_L_PrevAndNext(
			long typeId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal types
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByG_T(long groupId, long typeId)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_T(long groupId, long typeId);

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_T(
		long groupId, long typeId, boolean useFinderCache);

	/**
	 * Removes the legal type where groupId = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the legal type that was removed
	 */
	public LegalType removeByG_T(long groupId, long typeId)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the number of legal types where groupId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the number of matching legal types
	 */
	public int countByG_T(long groupId, long typeId);

	/**
	 * Returns all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByS_L(
		long groupId, boolean statusType, String language);

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
	public java.util.List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end);

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
	public java.util.List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByS_L_First(
			long groupId, boolean statusType, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByS_L_First(
		long groupId, boolean statusType, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByS_L_Last(
			long groupId, boolean statusType, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByS_L_Last(
		long groupId, boolean statusType, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByS_L_PrevAndNext(
			long typeId, long groupId, boolean statusType, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and statusType = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 */
	public void removeByS_L(long groupId, boolean statusType, String language);

	/**
	 * Returns the number of legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @return the number of matching legal types
	 */
	public int countByS_L(long groupId, boolean statusType, String language);

	/**
	 * Returns all the legal types where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByType_Status(boolean statusType);

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
	public java.util.List<LegalType> findByType_Status(
		boolean statusType, int start, int end);

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
	public java.util.List<LegalType> findByType_Status(
		boolean statusType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByType_Status(
		boolean statusType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByType_Status_First(
			boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByType_Status_First(
		boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

	/**
	 * Returns the last legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByType_Status_Last(
			boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByType_Status_Last(
		boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public LegalType[] findByType_Status_PrevAndNext(
			long typeId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where statusType = &#63; from the database.
	 *
	 * @param statusType the status type
	 */
	public void removeByType_Status(boolean statusType);

	/**
	 * Returns the number of legal types where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public int countByType_Status(boolean statusType);

	/**
	 * Returns all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable);

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
	public java.util.List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end);

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
	public java.util.List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByS_Rss_First(
			long groupId, boolean statusType, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByS_Rss_First(
		long groupId, boolean statusType, boolean rssable,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByS_Rss_Last(
			long groupId, boolean statusType, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByS_Rss_Last(
		long groupId, boolean statusType, boolean rssable,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByS_Rss_PrevAndNext(
			long typeId, long groupId, boolean statusType, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 */
	public void removeByS_Rss(
		long groupId, boolean statusType, boolean rssable);

	/**
	 * Returns the number of legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @return the number of matching legal types
	 */
	public int countByS_Rss(long groupId, boolean statusType, boolean rssable);

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType);

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
	public java.util.List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end);

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
	public java.util.List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByFindGroup_First(
			long groupId, long companyId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByFindGroup_First(
		long groupId, long companyId, boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByFindGroup_Last(
			long groupId, long companyId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByFindGroup_PrevAndNext(
			long typeId, long groupId, long companyId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 */
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusType);

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public int countByFindGroup(
		long groupId, long companyId, boolean statusType);

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId);

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
	public java.util.List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end);

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
	public java.util.List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByG_C_P_First(
			long groupId, long companyId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_C_P_First(
		long groupId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByG_C_P_Last(
			long groupId, long companyId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_C_P_Last(
		long groupId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByG_C_P_PrevAndNext(
			long typeId, long groupId, long companyId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 */
	public void removeByG_C_P(long groupId, long companyId, long parentId);

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal types
	 */
	public int countByG_C_P(long groupId, long companyId, long parentId);

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
	public java.util.List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType);

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
	public java.util.List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end);

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
	public java.util.List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByG_C_L_P_S_First(
			long groupId, long companyId, String language, long parentId,
			boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

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
	public LegalType fetchByG_C_L_P_S_First(
		long groupId, long companyId, String language, long parentId,
		boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByG_C_L_P_S_Last(
			long groupId, long companyId, String language, long parentId,
			boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

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
	public LegalType fetchByG_C_L_P_S_Last(
		long groupId, long companyId, String language, long parentId,
		boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByG_C_L_P_S_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			long parentId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 */
	public void removeByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType);

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
	public int countByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType);

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByG_C_L(
		long groupId, long companyId, String language);

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
	public java.util.List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end);

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
	public java.util.List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByG_C_L_First(
			long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_C_L_First(
		long groupId, long companyId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByG_C_L_Last(
			long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByG_C_L_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	public void removeByG_C_L(long groupId, long companyId, String language);

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal types
	 */
	public int countByG_C_L(long groupId, long companyId, String language);

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType);

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
	public java.util.List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end);

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
	public java.util.List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

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
	public LegalType fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

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
	public LegalType fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByG_C_L_S_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 */
	public void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType);

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType);

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType);

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
	public java.util.List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end);

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
	public java.util.List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalType findByFindGroupCompanyParent_First(
			long groupId, long companyId, long parentId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

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
	public LegalType fetchByFindGroupCompanyParent_First(
		long groupId, long companyId, long parentId, boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType findByFindGroupCompanyParent_Last(
			long groupId, long companyId, long parentId, boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

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
	public LegalType fetchByFindGroupCompanyParent_Last(
		long groupId, long companyId, long parentId, boolean statusType,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByFindGroupCompanyParent_PrevAndNext(
			long typeId, long groupId, long companyId, long parentId,
			boolean statusType,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 */
	public void removeByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType);

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	public int countByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType);

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal types
	 */
	public java.util.List<LegalType> findByFindAll(
		long groupId, long companyId);

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
	public java.util.List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	public LegalType findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	public LegalType fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public LegalType[] findByFindAll_PrevAndNext(
			long typeId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalType>
				orderByComparator)
		throws NoSuchLegalTypeException;

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal types
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the legal type in the entity cache if it is enabled.
	 *
	 * @param legalType the legal type
	 */
	public void cacheResult(LegalType legalType);

	/**
	 * Caches the legal types in the entity cache if it is enabled.
	 *
	 * @param legalTypes the legal types
	 */
	public void cacheResult(java.util.List<LegalType> legalTypes);

	/**
	 * Creates a new legal type with the primary key. Does not add the legal type to the database.
	 *
	 * @param typeId the primary key for the new legal type
	 * @return the new legal type
	 */
	public LegalType create(long typeId);

	/**
	 * Removes the legal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type that was removed
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public LegalType remove(long typeId) throws NoSuchLegalTypeException;

	public LegalType updateImpl(LegalType legalType);

	/**
	 * Returns the legal type with the primary key or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	public LegalType findByPrimaryKey(long typeId)
		throws NoSuchLegalTypeException;

	/**
	 * Returns the legal type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type, or <code>null</code> if a legal type with the primary key could not be found
	 */
	public LegalType fetchByPrimaryKey(long typeId);

	/**
	 * Returns all the legal types.
	 *
	 * @return the legal types
	 */
	public java.util.List<LegalType> findAll();

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
	public java.util.List<LegalType> findAll(int start, int end);

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
	public java.util.List<LegalType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator);

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
	public java.util.List<LegalType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal types.
	 *
	 * @return the number of legal types
	 */
	public int countAll();

}