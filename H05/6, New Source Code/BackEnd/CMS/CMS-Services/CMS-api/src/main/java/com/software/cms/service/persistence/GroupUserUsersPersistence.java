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

package com.software.cms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.software.cms.exception.NoSuchGroupUserUsersException;
import com.software.cms.model.GroupUserUsers;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group user users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see GroupUserUsersUtil
 * @generated
 */
@ProviderType
public interface GroupUserUsersPersistence
	extends BasePersistence<GroupUserUsers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupUserUsersUtil} to access the group user users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @return the matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId);

	/**
	 * Returns a range of all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId, int start, int end);

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public GroupUserUsers findByGroup_GroupUser_First(
			long groupId, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
				orderByComparator)
		throws NoSuchGroupUserUsersException;

	/**
	 * Returns the first group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public GroupUserUsers fetchByGroup_GroupUser_First(
		long groupId, long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public GroupUserUsers findByGroup_GroupUser_Last(
			long groupId, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
				orderByComparator)
		throws NoSuchGroupUserUsersException;

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public GroupUserUsers fetchByGroup_GroupUser_Last(
		long groupId, long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns the group user userses before and after the current group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupUserUsersPK the primary key of the current group user users
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public GroupUserUsers[] findByGroup_GroupUser_PrevAndNext(
			GroupUserUsersPK groupUserUsersPK, long groupId, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
				orderByComparator)
		throws NoSuchGroupUserUsersException;

	/**
	 * Removes all the group user userses where groupId = &#63; and groupUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 */
	public void removeByGroup_GroupUser(long groupId, long groupUserId);

	/**
	 * Returns the number of group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @return the number of matching group user userses
	 */
	public int countByGroup_GroupUser(long groupId, long groupUserId);

	/**
	 * Returns all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_User(
		long groupId, long userId);

	/**
	 * Returns a range of all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_User(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_User(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user userses
	 */
	public java.util.List<GroupUserUsers> findByGroup_User(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public GroupUserUsers findByGroup_User_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
				orderByComparator)
		throws NoSuchGroupUserUsersException;

	/**
	 * Returns the first group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public GroupUserUsers fetchByGroup_User_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	public GroupUserUsers findByGroup_User_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
				orderByComparator)
		throws NoSuchGroupUserUsersException;

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	public GroupUserUsers fetchByGroup_User_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns the group user userses before and after the current group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupUserUsersPK the primary key of the current group user users
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public GroupUserUsers[] findByGroup_User_PrevAndNext(
			GroupUserUsersPK groupUserUsersPK, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
				orderByComparator)
		throws NoSuchGroupUserUsersException;

	/**
	 * Removes all the group user userses where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByGroup_User(long groupId, long userId);

	/**
	 * Returns the number of group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching group user userses
	 */
	public int countByGroup_User(long groupId, long userId);

	/**
	 * Caches the group user users in the entity cache if it is enabled.
	 *
	 * @param groupUserUsers the group user users
	 */
	public void cacheResult(GroupUserUsers groupUserUsers);

	/**
	 * Caches the group user userses in the entity cache if it is enabled.
	 *
	 * @param groupUserUserses the group user userses
	 */
	public void cacheResult(java.util.List<GroupUserUsers> groupUserUserses);

	/**
	 * Creates a new group user users with the primary key. Does not add the group user users to the database.
	 *
	 * @param groupUserUsersPK the primary key for the new group user users
	 * @return the new group user users
	 */
	public GroupUserUsers create(GroupUserUsersPK groupUserUsersPK);

	/**
	 * Removes the group user users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users that was removed
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public GroupUserUsers remove(GroupUserUsersPK groupUserUsersPK)
		throws NoSuchGroupUserUsersException;

	public GroupUserUsers updateImpl(GroupUserUsers groupUserUsers);

	/**
	 * Returns the group user users with the primary key or throws a <code>NoSuchGroupUserUsersException</code> if it could not be found.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	public GroupUserUsers findByPrimaryKey(GroupUserUsersPK groupUserUsersPK)
		throws NoSuchGroupUserUsersException;

	/**
	 * Returns the group user users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users, or <code>null</code> if a group user users with the primary key could not be found
	 */
	public GroupUserUsers fetchByPrimaryKey(GroupUserUsersPK groupUserUsersPK);

	/**
	 * Returns all the group user userses.
	 *
	 * @return the group user userses
	 */
	public java.util.List<GroupUserUsers> findAll();

	/**
	 * Returns a range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of group user userses
	 */
	public java.util.List<GroupUserUsers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user userses
	 */
	public java.util.List<GroupUserUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user userses
	 */
	public java.util.List<GroupUserUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group user userses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group user userses.
	 *
	 * @return the number of group user userses
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}