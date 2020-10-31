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

import com.software.cms.exception.NoSuchGroupUserException;
import com.software.cms.model.GroupUser;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see GroupUserUtil
 * @generated
 */
@ProviderType
public interface GroupUserPersistence extends BasePersistence<GroupUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupUserUtil} to access the group user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group users where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching group users
	 */
	public java.util.List<GroupUser> findByGroup_Language(
		long groupId, String language);

	/**
	 * Returns a range of all the group users where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @return the range of matching group users
	 */
	public java.util.List<GroupUser> findByGroup_Language(
		long groupId, String language, int start, int end);

	/**
	 * Returns an ordered range of all the group users where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group users
	 */
	public java.util.List<GroupUser> findByGroup_Language(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group users where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group users
	 */
	public java.util.List<GroupUser> findByGroup_Language(
		long groupId, String language, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user
	 * @throws NoSuchGroupUserException if a matching group user could not be found
	 */
	public GroupUser findByGroup_Language_First(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
				orderByComparator)
		throws NoSuchGroupUserException;

	/**
	 * Returns the first group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user, or <code>null</code> if a matching group user could not be found
	 */
	public GroupUser fetchByGroup_Language_First(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
			orderByComparator);

	/**
	 * Returns the last group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user
	 * @throws NoSuchGroupUserException if a matching group user could not be found
	 */
	public GroupUser findByGroup_Language_Last(
			long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
				orderByComparator)
		throws NoSuchGroupUserException;

	/**
	 * Returns the last group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user, or <code>null</code> if a matching group user could not be found
	 */
	public GroupUser fetchByGroup_Language_Last(
		long groupId, String language,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
			orderByComparator);

	/**
	 * Returns the group users before and after the current group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupUserId the primary key of the current group user
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	public GroupUser[] findByGroup_Language_PrevAndNext(
			long groupUserId, long groupId, String language,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
				orderByComparator)
		throws NoSuchGroupUserException;

	/**
	 * Removes all the group users where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	public void removeByGroup_Language(long groupId, String language);

	/**
	 * Returns the number of group users where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching group users
	 */
	public int countByGroup_Language(long groupId, String language);

	/**
	 * Caches the group user in the entity cache if it is enabled.
	 *
	 * @param groupUser the group user
	 */
	public void cacheResult(GroupUser groupUser);

	/**
	 * Caches the group users in the entity cache if it is enabled.
	 *
	 * @param groupUsers the group users
	 */
	public void cacheResult(java.util.List<GroupUser> groupUsers);

	/**
	 * Creates a new group user with the primary key. Does not add the group user to the database.
	 *
	 * @param groupUserId the primary key for the new group user
	 * @return the new group user
	 */
	public GroupUser create(long groupUserId);

	/**
	 * Removes the group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user that was removed
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	public GroupUser remove(long groupUserId) throws NoSuchGroupUserException;

	public GroupUser updateImpl(GroupUser groupUser);

	/**
	 * Returns the group user with the primary key or throws a <code>NoSuchGroupUserException</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	public GroupUser findByPrimaryKey(long groupUserId)
		throws NoSuchGroupUserException;

	/**
	 * Returns the group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user, or <code>null</code> if a group user with the primary key could not be found
	 */
	public GroupUser fetchByPrimaryKey(long groupUserId);

	/**
	 * Returns all the group users.
	 *
	 * @return the group users
	 */
	public java.util.List<GroupUser> findAll();

	/**
	 * Returns a range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @return the range of group users
	 */
	public java.util.List<GroupUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group users
	 */
	public java.util.List<GroupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group users
	 */
	public java.util.List<GroupUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group users.
	 *
	 * @return the number of group users
	 */
	public int countAll();

}