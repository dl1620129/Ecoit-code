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

package organizationalStructure.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import organizationalStructure.service.exception.NoSuchmemberException;
import organizationalStructure.service.model.member;

/**
 * The persistence interface for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see memberUtil
 * @generated
 */
@ProviderType
public interface memberPersistence extends BasePersistence<member> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link memberUtil} to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the members where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching members
	 */
	public java.util.List<member> findByUuid(String uuid);

	/**
	 * Returns a range of all the members where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	public java.util.List<member> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the members where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	public java.util.List<member> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns an ordered range of all the members where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	public java.util.List<member> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Returns the first member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns the last member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Returns the last member in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns the members before and after the current member in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public member[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Removes all the members where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of members where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching members
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the member where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchmemberException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByUUID_G(String uuid, long groupId)
		throws NoSuchmemberException;

	/**
	 * Returns the member where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the member where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the member where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the member that was removed
	 */
	public member removeByUUID_G(String uuid, long groupId)
		throws NoSuchmemberException;

	/**
	 * Returns the number of members where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching members
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the members where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching members
	 */
	public java.util.List<member> findByFindAll(long groupId);

	/**
	 * Returns a range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	public java.util.List<member> findByFindAll(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	public java.util.List<member> findByFindAll(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns an ordered range of all the members where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	public java.util.List<member> findByFindAll(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByFindAll_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Returns the first member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByFindAll_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns the last member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByFindAll_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Returns the last member in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByFindAll_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns the members before and after the current member in the ordered set where groupId = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public member[] findByFindAll_PrevAndNext(
			long memberId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Removes all the members where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByFindAll(long groupId);

	/**
	 * Returns the number of members where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching members
	 */
	public int countByFindAll(long groupId);

	/**
	 * Returns all the members where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching members
	 */
	public java.util.List<member> findByorganizationId(long organizationId);

	/**
	 * Returns a range of all the members where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of matching members
	 */
	public java.util.List<member> findByorganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the members where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching members
	 */
	public java.util.List<member> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns an ordered range of all the members where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching members
	 */
	public java.util.List<member> findByorganizationId(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByorganizationId_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Returns the first member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByorganizationId_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns the last member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member
	 * @throws NoSuchmemberException if a matching member could not be found
	 */
	public member findByorganizationId_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Returns the last member in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching member, or <code>null</code> if a matching member could not be found
	 */
	public member fetchByorganizationId_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns the members before and after the current member in the ordered set where organizationId = &#63;.
	 *
	 * @param memberId the primary key of the current member
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public member[] findByorganizationId_PrevAndNext(
			long memberId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<member>
				orderByComparator)
		throws NoSuchmemberException;

	/**
	 * Removes all the members where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByorganizationId(long organizationId);

	/**
	 * Returns the number of members where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching members
	 */
	public int countByorganizationId(long organizationId);

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	public void cacheResult(member member);

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public void cacheResult(java.util.List<member> members);

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	public member create(long memberId);

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public member remove(long memberId) throws NoSuchmemberException;

	public member updateImpl(member member);

	/**
	 * Returns the member with the primary key or throws a <code>NoSuchmemberException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws NoSuchmemberException if a member with the primary key could not be found
	 */
	public member findByPrimaryKey(long memberId) throws NoSuchmemberException;

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 */
	public member fetchByPrimaryKey(long memberId);

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 */
	public java.util.List<member> findAll();

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 */
	public java.util.List<member> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of members
	 */
	public java.util.List<member> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator);

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of members
	 */
	public java.util.List<member> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<member>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the members from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	public int countAll();

}