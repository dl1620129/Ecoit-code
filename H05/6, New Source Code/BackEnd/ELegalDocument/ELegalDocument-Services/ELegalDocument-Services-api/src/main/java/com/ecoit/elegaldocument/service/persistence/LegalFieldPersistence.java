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

import com.ecoit.elegaldocument.exception.NoSuchLegalFieldException;
import com.ecoit.elegaldocument.model.LegalField;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalFieldUtil
 * @generated
 */
@ProviderType
public interface LegalFieldPersistence extends BasePersistence<LegalField> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalFieldUtil} to access the legal field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal field where fieldId = &#63; or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByFieldId(long fieldId)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the legal field where fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFieldId(long fieldId);

	/**
	 * Returns the legal field where fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fieldId the field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFieldId(long fieldId, boolean useFinderCache);

	/**
	 * Removes the legal field where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @return the legal field that was removed
	 */
	public LegalField removeByFieldId(long fieldId)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the number of legal fields where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal fields
	 */
	public int countByFieldId(long fieldId);

	/**
	 * Returns all the legal fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByGroupId(long groupId);

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
	public java.util.List<LegalField> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<LegalField> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where groupId = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public LegalField[] findByGroupId_PrevAndNext(
			long fieldId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal fields where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal fields
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the legal fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByG_L(long groupId, String language);

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
	public java.util.List<LegalField> findByG_L(
		long groupId, String language, int start, int end);

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
	public java.util.List<LegalField> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByG_L_PrevAndNext(
			long fieldId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByG_F(long groupId, long fieldId)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByG_F(long groupId, long fieldId);

	/**
	 * Returns the legal field where groupId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByG_F(
		long groupId, long fieldId, boolean useFinderCache);

	/**
	 * Removes the legal field where groupId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the legal field that was removed
	 */
	public LegalField removeByG_F(long groupId, long fieldId)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the number of legal fields where groupId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param fieldId the field ID
	 * @return the number of matching legal fields
	 */
	public int countByG_F(long groupId, long fieldId);

	/**
	 * Returns all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByS_L(
		long groupId, boolean statusField, String language);

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
	public java.util.List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end);

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
	public java.util.List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByS_L(
		long groupId, boolean statusField, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalField findByS_L_First(
			long groupId, boolean statusField, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByS_L_First(
		long groupId, boolean statusField, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField findByS_L_Last(
			long groupId, boolean statusField, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByS_L_Last(
		long groupId, boolean statusField, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByS_L_PrevAndNext(
			long fieldId, long groupId, boolean statusField, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and statusField = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 */
	public void removeByS_L(long groupId, boolean statusField, String language);

	/**
	 * Returns the number of legal fields where groupId = &#63; and statusField = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	public int countByS_L(long groupId, boolean statusField, String language);

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByG_C_L(
		long groupId, long companyId, String language);

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
	public java.util.List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end);

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
	public java.util.List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalField findByG_C_L_First(
			long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByG_C_L_First(
		long groupId, long companyId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField findByG_C_L_Last(
			long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByG_C_L_PrevAndNext(
			long fieldId, long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	public void removeByG_C_L(long groupId, long companyId, String language);

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal fields
	 */
	public int countByG_C_L(long groupId, long companyId, String language);

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField);

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
	public java.util.List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end);

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
	public java.util.List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalField findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

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
	public LegalField fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusField,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

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
	public LegalField fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusField,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByG_C_L_S_PrevAndNext(
			long fieldId, long groupId, long companyId, String language,
			boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 */
	public void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField);

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and language = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	public int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusField);

	/**
	 * Returns all the legal fields where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByFieldStatus(boolean statusField);

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
	public java.util.List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end);

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
	public java.util.List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByFieldStatus(
		boolean statusField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByFieldStatus_First(
			boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFieldStatus_First(
		boolean statusField,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

	/**
	 * Returns the last legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByFieldStatus_Last(
			boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFieldStatus_Last(
		boolean statusField,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

	/**
	 * Returns the legal fields before and after the current legal field in the ordered set where statusField = &#63;.
	 *
	 * @param fieldId the primary key of the current legal field
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public LegalField[] findByFieldStatus_PrevAndNext(
			long fieldId, boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where statusField = &#63; from the database.
	 *
	 * @param statusField the status field
	 */
	public void removeByFieldStatus(boolean statusField);

	/**
	 * Returns the number of legal fields where statusField = &#63;.
	 *
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	public int countByFieldStatus(boolean statusField);

	/**
	 * Returns all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable);

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
	public java.util.List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end);

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
	public java.util.List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByS_Rss(
		long groupId, boolean statusField, boolean rssable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalField findByS_Rss_First(
			long groupId, boolean statusField, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByS_Rss_First(
		long groupId, boolean statusField, boolean rssable,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField findByS_Rss_Last(
			long groupId, boolean statusField, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByS_Rss_Last(
		long groupId, boolean statusField, boolean rssable,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByS_Rss_PrevAndNext(
			long fieldId, long groupId, boolean statusField, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 */
	public void removeByS_Rss(
		long groupId, boolean statusField, boolean rssable);

	/**
	 * Returns the number of legal fields where groupId = &#63; and statusField = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusField the status field
	 * @param rssable the rssable
	 * @return the number of matching legal fields
	 */
	public int countByS_Rss(long groupId, boolean statusField, boolean rssable);

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField);

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
	public java.util.List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end);

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
	public java.util.List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByFindGroup(
		long groupId, long companyId, boolean statusField, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

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
	public LegalField findByFindGroup_First(
			long groupId, long companyId, boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFindGroup_First(
		long groupId, long companyId, boolean statusField,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField findByFindGroup_Last(
			long groupId, long companyId, boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusField,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByFindGroup_PrevAndNext(
			long fieldId, long groupId, long companyId, boolean statusField,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 */
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusField);

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63; and statusField = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusField the status field
	 * @return the number of matching legal fields
	 */
	public int countByFindGroup(
		long groupId, long companyId, boolean statusField);

	/**
	 * Returns all the legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal fields
	 */
	public java.util.List<LegalField> findByFindAll(
		long groupId, long companyId);

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
	public java.util.List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findByFindAll(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByFindAll_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the first legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFindAll_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field
	 * @throws NoSuchLegalFieldException if a matching legal field could not be found
	 */
	public LegalField findByFindAll_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the last legal field in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal field, or <code>null</code> if a matching legal field could not be found
	 */
	public LegalField fetchByFindAll_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public LegalField[] findByFindAll_PrevAndNext(
			long fieldId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalField>
				orderByComparator)
		throws NoSuchLegalFieldException;

	/**
	 * Removes all the legal fields where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of legal fields where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal fields
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the legal field in the entity cache if it is enabled.
	 *
	 * @param legalField the legal field
	 */
	public void cacheResult(LegalField legalField);

	/**
	 * Caches the legal fields in the entity cache if it is enabled.
	 *
	 * @param legalFields the legal fields
	 */
	public void cacheResult(java.util.List<LegalField> legalFields);

	/**
	 * Creates a new legal field with the primary key. Does not add the legal field to the database.
	 *
	 * @param fieldId the primary key for the new legal field
	 * @return the new legal field
	 */
	public LegalField create(long fieldId);

	/**
	 * Removes the legal field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field that was removed
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public LegalField remove(long fieldId) throws NoSuchLegalFieldException;

	public LegalField updateImpl(LegalField legalField);

	/**
	 * Returns the legal field with the primary key or throws a <code>NoSuchLegalFieldException</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field
	 * @throws NoSuchLegalFieldException if a legal field with the primary key could not be found
	 */
	public LegalField findByPrimaryKey(long fieldId)
		throws NoSuchLegalFieldException;

	/**
	 * Returns the legal field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field, or <code>null</code> if a legal field with the primary key could not be found
	 */
	public LegalField fetchByPrimaryKey(long fieldId);

	/**
	 * Returns all the legal fields.
	 *
	 * @return the legal fields
	 */
	public java.util.List<LegalField> findAll();

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
	public java.util.List<LegalField> findAll(int start, int end);

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
	public java.util.List<LegalField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator);

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
	public java.util.List<LegalField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal fields from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal fields.
	 *
	 * @return the number of legal fields
	 */
	public int countAll();

}