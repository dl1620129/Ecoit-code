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

import com.ecoit.elegaldocument.exception.NoSuchLegalOrgException;
import com.ecoit.elegaldocument.model.LegalOrg;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalOrgUtil
 * @generated
 */
@ProviderType
public interface LegalOrgPersistence extends BasePersistence<LegalOrg> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalOrgUtil} to access the legal org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the legal org where organizationId = &#63; or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByOrgId(long organizationId)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the legal org where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByOrgId(long organizationId);

	/**
	 * Returns the legal org where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByOrgId(long organizationId, boolean useFinderCache);

	/**
	 * Removes the legal org where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the legal org that was removed
	 */
	public LegalOrg removeByOrgId(long organizationId)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the number of legal orgs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal orgs
	 */
	public int countByOrgId(long organizationId);

	/**
	 * Returns all the legal orgs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByGroupId(long groupId);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByGroupId_PrevAndNext(
			long organizationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of legal orgs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal orgs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L(long groupId, String language);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_L_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_L_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_L_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_L_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_L_PrevAndNext(
			long organizationId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByG_L(long groupId, String language);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	public int countByG_L(long groupId, String language);

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_O(long groupId, long organizationId)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_O(long groupId, long organizationId);

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_O(
		long groupId, long organizationId, boolean useFinderCache);

	/**
	 * Removes the legal org where groupId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the legal org that was removed
	 */
	public LegalOrg removeByG_O(long groupId, long organizationId)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the number of legal orgs where groupId = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the number of matching legal orgs
	 */
	public int countByG_O(long groupId, long organizationId);

	/**
	 * Returns all the legal orgs where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByOrgStatus(boolean statusOrg);

	/**
	 * Returns a range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByOrgStatus_First(
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByOrgStatus_First(
		boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByOrgStatus_Last(
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByOrgStatus_Last(
		boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByOrgStatus_PrevAndNext(
			long organizationId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where statusOrg = &#63; from the database.
	 *
	 * @param statusOrg the status org
	 */
	public void removeByOrgStatus(boolean statusOrg);

	/**
	 * Returns the number of legal orgs where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public int countByOrgStatus(boolean statusOrg);

	/**
	 * Returns all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByS_L_First(
			long groupId, boolean statusOrg, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByS_L_First(
		long groupId, boolean statusOrg, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByS_L_Last(
			long groupId, boolean statusOrg, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByS_L_Last(
		long groupId, boolean statusOrg, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByS_L_PrevAndNext(
			long organizationId, long groupId, boolean statusOrg,
			String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 */
	public void removeByS_L(long groupId, boolean statusOrg, String language);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	public int countByS_L(long groupId, boolean statusOrg, String language);

	/**
	 * Returns all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByS_Rss_First(
			long groupId, boolean statusOrg, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByS_Rss_First(
		long groupId, boolean statusOrg, boolean rssable,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByS_Rss_Last(
			long groupId, boolean statusOrg, boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByS_Rss_Last(
		long groupId, boolean statusOrg, boolean rssable,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByS_Rss_PrevAndNext(
			long organizationId, long groupId, boolean statusOrg,
			boolean rssable,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 */
	public void removeByS_Rss(long groupId, boolean statusOrg, boolean rssable);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @return the number of matching legal orgs
	 */
	public int countByS_Rss(long groupId, boolean statusOrg, boolean rssable);

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_L_P_First(
			long groupId, String language, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_L_P_First(
		long groupId, String language, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_L_P_Last(
			long groupId, String language, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_L_P_Last(
		long groupId, String language, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_L_P_PrevAndNext(
			long organizationId, long groupId, String language, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 */
	public void removeByG_L_P(long groupId, String language, long parentId);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the number of matching legal orgs
	 */
	public int countByG_L_P(long groupId, String language, long parentId);

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_L_P_S_First(
			long groupId, String language, long parentId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_L_P_S_First(
		long groupId, String language, long parentId, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_L_P_S_Last(
			long groupId, String language, long parentId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_L_P_S_Last(
		long groupId, String language, long parentId, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_L_P_S_PrevAndNext(
			long organizationId, long groupId, String language, long parentId,
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	public void removeByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public int countByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_P_First(
			long groupId, long companyId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_P_First(
		long groupId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_P_Last(
			long groupId, long companyId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_P_Last(
		long groupId, long companyId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_C_P_PrevAndNext(
			long organizationId, long groupId, long companyId, long parentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 */
	public void removeByG_C_P(long groupId, long companyId, long parentId);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal orgs
	 */
	public int countByG_C_P(long groupId, long companyId, long parentId);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_L_P_S_First(
			long groupId, long companyId, String language, long parentId,
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_L_P_S_First(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_L_P_S_Last(
			long groupId, long companyId, String language, long parentId,
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_L_P_S_Last(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_C_L_P_S_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			long parentId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	public void removeByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public int countByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_L_First(
			long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_L_First(
		long groupId, long companyId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_L_Last(
			long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_C_L_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	public void removeByG_C_L(long groupId, long companyId, String language);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	public int countByG_C_L(long groupId, long companyId, String language);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByG_C_L_S_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 */
	public void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroup(
		long groupId, long companyId);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByFindGroup_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByFindGroup_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByFindGroup_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByFindGroup_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByFindGroup_PrevAndNext(
			long organizationId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindGroup(long groupId, long companyId);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal orgs
	 */
	public int countByFindGroup(long groupId, long companyId);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByFindAllStatus_First(
			long groupId, long companyId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByFindAllStatus_First(
		long groupId, long companyId, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByFindAllStatus_Last(
			long groupId, long companyId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByFindAllStatus_Last(
		long groupId, long companyId, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByFindAllStatus_PrevAndNext(
			long organizationId, long groupId, long companyId,
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 */
	public void removeByFindAllStatus(
		long groupId, long companyId, boolean statusOrg);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public int countByFindAllStatus(
		long groupId, long companyId, boolean statusOrg);

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg);

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	public java.util.List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByFindGroupCompanyParent_First(
			long groupId, long companyId, long parentId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByFindGroupCompanyParent_First(
		long groupId, long companyId, long parentId, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	public LegalOrg findByFindGroupCompanyParent_Last(
			long groupId, long companyId, long parentId, boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	public LegalOrg fetchByFindGroupCompanyParent_Last(
		long groupId, long companyId, long parentId, boolean statusOrg,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg[] findByFindGroupCompanyParent_PrevAndNext(
			long organizationId, long groupId, long companyId, long parentId,
			boolean statusOrg,
			com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
				orderByComparator)
		throws NoSuchLegalOrgException;

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	public void removeByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg);

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	public int countByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg);

	/**
	 * Caches the legal org in the entity cache if it is enabled.
	 *
	 * @param legalOrg the legal org
	 */
	public void cacheResult(LegalOrg legalOrg);

	/**
	 * Caches the legal orgs in the entity cache if it is enabled.
	 *
	 * @param legalOrgs the legal orgs
	 */
	public void cacheResult(java.util.List<LegalOrg> legalOrgs);

	/**
	 * Creates a new legal org with the primary key. Does not add the legal org to the database.
	 *
	 * @param organizationId the primary key for the new legal org
	 * @return the new legal org
	 */
	public LegalOrg create(long organizationId);

	/**
	 * Removes the legal org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org that was removed
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg remove(long organizationId) throws NoSuchLegalOrgException;

	public LegalOrg updateImpl(LegalOrg legalOrg);

	/**
	 * Returns the legal org with the primary key or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	public LegalOrg findByPrimaryKey(long organizationId)
		throws NoSuchLegalOrgException;

	/**
	 * Returns the legal org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org, or <code>null</code> if a legal org with the primary key could not be found
	 */
	public LegalOrg fetchByPrimaryKey(long organizationId);

	/**
	 * Returns all the legal orgs.
	 *
	 * @return the legal orgs
	 */
	public java.util.List<LegalOrg> findAll();

	/**
	 * Returns a range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of legal orgs
	 */
	public java.util.List<LegalOrg> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal orgs
	 */
	public java.util.List<LegalOrg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal orgs
	 */
	public java.util.List<LegalOrg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalOrg>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal orgs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal orgs.
	 *
	 * @return the number of legal orgs
	 */
	public int countAll();

}