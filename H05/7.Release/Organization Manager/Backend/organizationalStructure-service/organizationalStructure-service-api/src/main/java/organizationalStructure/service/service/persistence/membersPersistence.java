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
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

import organizationalStructure.service.exception.NoSuchmembersException;
import organizationalStructure.service.model.members;

/**
 * The persistence interface for the members service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see membersUtil
 * @generated
 */
@ProviderType
public interface membersPersistence extends BasePersistence<members> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link membersUtil} to access the members persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching memberses
	 */
	public java.util.List<members> findByUuid(String uuid);

	/**
	 * Returns a range of all the memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of matching memberses
	 */
	public java.util.List<members> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memberses
	 */
	@Deprecated
	public java.util.List<members> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<members> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberses
	 */
	public java.util.List<members> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<members> orderByComparator);

	/**
	 * Returns the first members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByUuid_First(
			String uuid, OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Returns the first members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByUuid_First(
		String uuid, OrderByComparator<members> orderByComparator);

	/**
	 * Returns the last members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByUuid_Last(
			String uuid, OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Returns the last members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByUuid_Last(
		String uuid, OrderByComparator<members> orderByComparator);

	/**
	 * Returns the memberses before and after the current members in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current members
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public members[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Removes all the memberses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching memberses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the members where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchmembersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByUUID_G(String uuid, long groupId)
		throws NoSuchmembersException;

	/**
	 * Returns the members where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching members, or <code>null</code> if a matching members could not be found
	 */
	@Deprecated
	public members fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the members where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the members where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the members that was removed
	 */
	public members removeByUUID_G(String uuid, long groupId)
		throws NoSuchmembersException;

	/**
	 * Returns the number of memberses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching memberses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the memberses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching memberses
	 */
	public java.util.List<members> findByFindAll(long groupId);

	/**
	 * Returns a range of all the memberses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of matching memberses
	 */
	public java.util.List<members> findByFindAll(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the memberses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memberses
	 */
	@Deprecated
	public java.util.List<members> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<members> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the memberses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberses
	 */
	public java.util.List<members> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<members> orderByComparator);

	/**
	 * Returns the first members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByFindAll_First(
			long groupId, OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Returns the first members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByFindAll_First(
		long groupId, OrderByComparator<members> orderByComparator);

	/**
	 * Returns the last members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByFindAll_Last(
			long groupId, OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Returns the last members in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByFindAll_Last(
		long groupId, OrderByComparator<members> orderByComparator);

	/**
	 * Returns the memberses before and after the current members in the ordered set where groupId = &#63;.
	 *
	 * @param memberId the primary key of the current members
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public members[] findByFindAll_PrevAndNext(
			long memberId, long groupId,
			OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Removes all the memberses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByFindAll(long groupId);

	/**
	 * Returns the number of memberses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching memberses
	 */
	public int countByFindAll(long groupId);

	/**
	 * Returns all the memberses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching memberses
	 */
	public java.util.List<members> findByorganizationId(long organizationId);

	/**
	 * Returns a range of all the memberses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of matching memberses
	 */
	public java.util.List<members> findByorganizationId(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the memberses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByorganizationId(long, int, int, OrderByComparator)}
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching memberses
	 */
	@Deprecated
	public java.util.List<members> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<members> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the memberses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching memberses
	 */
	public java.util.List<members> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<members> orderByComparator);

	/**
	 * Returns the first members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByorganizationId_First(
			long organizationId, OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Returns the first members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByorganizationId_First(
		long organizationId, OrderByComparator<members> orderByComparator);

	/**
	 * Returns the last members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members
	 * @throws NoSuchmembersException if a matching members could not be found
	 */
	public members findByorganizationId_Last(
			long organizationId, OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Returns the last members in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching members, or <code>null</code> if a matching members could not be found
	 */
	public members fetchByorganizationId_Last(
		long organizationId, OrderByComparator<members> orderByComparator);

	/**
	 * Returns the memberses before and after the current members in the ordered set where organizationId = &#63;.
	 *
	 * @param memberId the primary key of the current members
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public members[] findByorganizationId_PrevAndNext(
			long memberId, long organizationId,
			OrderByComparator<members> orderByComparator)
		throws NoSuchmembersException;

	/**
	 * Removes all the memberses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByorganizationId(long organizationId);

	/**
	 * Returns the number of memberses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching memberses
	 */
	public int countByorganizationId(long organizationId);

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public void cacheResult(members members);

	/**
	 * Caches the memberses in the entity cache if it is enabled.
	 *
	 * @param memberses the memberses
	 */
	public void cacheResult(java.util.List<members> memberses);

	/**
	 * Creates a new members with the primary key. Does not add the members to the database.
	 *
	 * @param memberId the primary key for the new members
	 * @return the new members
	 */
	public members create(long memberId);

	/**
	 * Removes the members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the members
	 * @return the members that was removed
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public members remove(long memberId) throws NoSuchmembersException;

	public members updateImpl(members members);

	/**
	 * Returns the members with the primary key or throws a <code>NoSuchmembersException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the members
	 * @return the members
	 * @throws NoSuchmembersException if a members with the primary key could not be found
	 */
	public members findByPrimaryKey(long memberId)
		throws NoSuchmembersException;

	/**
	 * Returns the members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the members
	 * @return the members, or <code>null</code> if a members with the primary key could not be found
	 */
	public members fetchByPrimaryKey(long memberId);

	/**
	 * Returns all the memberses.
	 *
	 * @return the memberses
	 */
	public java.util.List<members> findAll();

	/**
	 * Returns a range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of memberses
	 */
	public java.util.List<members> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of memberses
	 */
	@Deprecated
	public java.util.List<members> findAll(
		int start, int end, OrderByComparator<members> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of memberses
	 */
	public java.util.List<members> findAll(
		int start, int end, OrderByComparator<members> orderByComparator);

	/**
	 * Removes all the memberses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of memberses.
	 *
	 * @return the number of memberses
	 */
	public int countAll();

}