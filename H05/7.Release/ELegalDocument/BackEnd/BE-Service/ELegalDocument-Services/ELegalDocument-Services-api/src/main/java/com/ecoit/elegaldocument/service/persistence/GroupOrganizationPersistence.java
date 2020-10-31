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

import com.ecoit.elegaldocument.exception.NoSuchGroupOrganizationException;
import com.ecoit.elegaldocument.model.GroupOrganization;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see GroupOrganizationUtil
 * @generated
 */
@ProviderType
public interface GroupOrganizationPersistence
	extends BasePersistence<GroupOrganization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupOrganizationUtil} to access the group organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group organizations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group organizations
	 */
	public java.util.List<GroupOrganization> findByGroupUser(long groupUserId);

	/**
	 * Returns a range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of matching group organizations
	 */
	public java.util.List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end);

	/**
	 * Returns an ordered range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group organizations
	 */
	public java.util.List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group organizations
	 */
	public java.util.List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public GroupOrganization findByGroupUser_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
				orderByComparator)
		throws NoSuchGroupOrganizationException;

	/**
	 * Returns the first group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public GroupOrganization fetchByGroupUser_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns the last group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public GroupOrganization findByGroupUser_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
				orderByComparator)
		throws NoSuchGroupOrganizationException;

	/**
	 * Returns the last group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public GroupOrganization fetchByGroupUser_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns the group organizations before and after the current group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupOrganizationPK the primary key of the current group organization
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public GroupOrganization[] findByGroupUser_PrevAndNext(
			GroupOrganizationPK groupOrganizationPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
				orderByComparator)
		throws NoSuchGroupOrganizationException;

	/**
	 * Removes all the group organizations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeByGroupUser(long groupUserId);

	/**
	 * Returns the number of group organizations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group organizations
	 */
	public int countByGroupUser(long groupUserId);

	/**
	 * Returns all the group organizations where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the matching group organizations
	 */
	public java.util.List<GroupOrganization> findByOrganization(
		long organizationid);

	/**
	 * Returns a range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of matching group organizations
	 */
	public java.util.List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end);

	/**
	 * Returns an ordered range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group organizations
	 */
	public java.util.List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group organizations
	 */
	public java.util.List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public GroupOrganization findByOrganization_First(
			long organizationid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
				orderByComparator)
		throws NoSuchGroupOrganizationException;

	/**
	 * Returns the first group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public GroupOrganization fetchByOrganization_First(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns the last group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	public GroupOrganization findByOrganization_Last(
			long organizationid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
				orderByComparator)
		throws NoSuchGroupOrganizationException;

	/**
	 * Returns the last group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	public GroupOrganization fetchByOrganization_Last(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns the group organizations before and after the current group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param groupOrganizationPK the primary key of the current group organization
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public GroupOrganization[] findByOrganization_PrevAndNext(
			GroupOrganizationPK groupOrganizationPK, long organizationid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
				orderByComparator)
		throws NoSuchGroupOrganizationException;

	/**
	 * Removes all the group organizations where organizationid = &#63; from the database.
	 *
	 * @param organizationid the organizationid
	 */
	public void removeByOrganization(long organizationid);

	/**
	 * Returns the number of group organizations where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the number of matching group organizations
	 */
	public int countByOrganization(long organizationid);

	/**
	 * Caches the group organization in the entity cache if it is enabled.
	 *
	 * @param groupOrganization the group organization
	 */
	public void cacheResult(GroupOrganization groupOrganization);

	/**
	 * Caches the group organizations in the entity cache if it is enabled.
	 *
	 * @param groupOrganizations the group organizations
	 */
	public void cacheResult(
		java.util.List<GroupOrganization> groupOrganizations);

	/**
	 * Creates a new group organization with the primary key. Does not add the group organization to the database.
	 *
	 * @param groupOrganizationPK the primary key for the new group organization
	 * @return the new group organization
	 */
	public GroupOrganization create(GroupOrganizationPK groupOrganizationPK);

	/**
	 * Removes the group organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization that was removed
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public GroupOrganization remove(GroupOrganizationPK groupOrganizationPK)
		throws NoSuchGroupOrganizationException;

	public GroupOrganization updateImpl(GroupOrganization groupOrganization);

	/**
	 * Returns the group organization with the primary key or throws a <code>NoSuchGroupOrganizationException</code> if it could not be found.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	public GroupOrganization findByPrimaryKey(
			GroupOrganizationPK groupOrganizationPK)
		throws NoSuchGroupOrganizationException;

	/**
	 * Returns the group organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization, or <code>null</code> if a group organization with the primary key could not be found
	 */
	public GroupOrganization fetchByPrimaryKey(
		GroupOrganizationPK groupOrganizationPK);

	/**
	 * Returns all the group organizations.
	 *
	 * @return the group organizations
	 */
	public java.util.List<GroupOrganization> findAll();

	/**
	 * Returns a range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of group organizations
	 */
	public java.util.List<GroupOrganization> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group organizations
	 */
	public java.util.List<GroupOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group organizations
	 */
	public java.util.List<GroupOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group organizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group organizations.
	 *
	 * @return the number of group organizations
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}