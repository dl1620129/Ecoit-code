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

package com.ecoit.qa.service.service.persistence;

import com.ecoit.qa.service.exception.NoSuchGroupUserUserException;
import com.ecoit.qa.service.model.GroupUserUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group user user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUserUtil
 * @generated
 */
@ProviderType
public interface GroupUserUserPersistence
	extends BasePersistence<GroupUserUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupUserUserUtil} to access the group user user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group user users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching group user users
	 */
	public java.util.List<GroupUserUser> findByUser(long userId);

	/**
	 * Returns a range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of matching group user users
	 */
	public java.util.List<GroupUserUser> findByUser(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user users
	 */
	public java.util.List<GroupUserUser> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user users
	 */
	public java.util.List<GroupUserUser> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public GroupUserUser findByUser_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
				orderByComparator)
		throws NoSuchGroupUserUserException;

	/**
	 * Returns the first group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public GroupUserUser fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns the last group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public GroupUserUser findByUser_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
				orderByComparator)
		throws NoSuchGroupUserUserException;

	/**
	 * Returns the last group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public GroupUserUser fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns the group user users before and after the current group user user in the ordered set where userId = &#63;.
	 *
	 * @param groupUserUserPK the primary key of the current group user user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public GroupUserUser[] findByUser_PrevAndNext(
			GroupUserUserPK groupUserUserPK, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
				orderByComparator)
		throws NoSuchGroupUserUserException;

	/**
	 * Removes all the group user users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUser(long userId);

	/**
	 * Returns the number of group user users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching group user users
	 */
	public int countByUser(long userId);

	/**
	 * Returns all the group user users where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user users
	 */
	public java.util.List<GroupUserUser> findByGroupUser(long groupUserId);

	/**
	 * Returns a range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of matching group user users
	 */
	public java.util.List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end);

	/**
	 * Returns an ordered range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user users
	 */
	public java.util.List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user users
	 */
	public java.util.List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public GroupUserUser findByGroupUser_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
				orderByComparator)
		throws NoSuchGroupUserUserException;

	/**
	 * Returns the first group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public GroupUserUser fetchByGroupUser_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns the last group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	public GroupUserUser findByGroupUser_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
				orderByComparator)
		throws NoSuchGroupUserUserException;

	/**
	 * Returns the last group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	public GroupUserUser fetchByGroupUser_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns the group user users before and after the current group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserUserPK the primary key of the current group user user
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public GroupUserUser[] findByGroupUser_PrevAndNext(
			GroupUserUserPK groupUserUserPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
				orderByComparator)
		throws NoSuchGroupUserUserException;

	/**
	 * Removes all the group user users where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeByGroupUser(long groupUserId);

	/**
	 * Returns the number of group user users where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user users
	 */
	public int countByGroupUser(long groupUserId);

	/**
	 * Caches the group user user in the entity cache if it is enabled.
	 *
	 * @param groupUserUser the group user user
	 */
	public void cacheResult(GroupUserUser groupUserUser);

	/**
	 * Caches the group user users in the entity cache if it is enabled.
	 *
	 * @param groupUserUsers the group user users
	 */
	public void cacheResult(java.util.List<GroupUserUser> groupUserUsers);

	/**
	 * Creates a new group user user with the primary key. Does not add the group user user to the database.
	 *
	 * @param groupUserUserPK the primary key for the new group user user
	 * @return the new group user user
	 */
	public GroupUserUser create(GroupUserUserPK groupUserUserPK);

	/**
	 * Removes the group user user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user that was removed
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public GroupUserUser remove(GroupUserUserPK groupUserUserPK)
		throws NoSuchGroupUserUserException;

	public GroupUserUser updateImpl(GroupUserUser groupUserUser);

	/**
	 * Returns the group user user with the primary key or throws a <code>NoSuchGroupUserUserException</code> if it could not be found.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	public GroupUserUser findByPrimaryKey(GroupUserUserPK groupUserUserPK)
		throws NoSuchGroupUserUserException;

	/**
	 * Returns the group user user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user, or <code>null</code> if a group user user with the primary key could not be found
	 */
	public GroupUserUser fetchByPrimaryKey(GroupUserUserPK groupUserUserPK);

	/**
	 * Returns all the group user users.
	 *
	 * @return the group user users
	 */
	public java.util.List<GroupUserUser> findAll();

	/**
	 * Returns a range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of group user users
	 */
	public java.util.List<GroupUserUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user users
	 */
	public java.util.List<GroupUserUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user users
	 */
	public java.util.List<GroupUserUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group user users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group user users.
	 *
	 * @return the number of group user users
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}