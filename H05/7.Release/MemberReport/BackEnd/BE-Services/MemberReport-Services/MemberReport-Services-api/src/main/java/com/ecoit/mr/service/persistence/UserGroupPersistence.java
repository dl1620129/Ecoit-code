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

package com.ecoit.mr.service.persistence;

import com.ecoit.mr.exception.NoSuchUserGroupException;
import com.ecoit.mr.model.UserGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupUtil
 * @generated
 */
@ProviderType
public interface UserGroupPersistence extends BasePersistence<UserGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserGroupUtil} to access the user group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user groups
	 */
	public java.util.List<UserGroup> findByUser(long userId);

	/**
	 * Returns a range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of matching user groups
	 */
	public java.util.List<UserGroup> findByUser(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user groups
	 */
	public java.util.List<UserGroup> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user groups
	 */
	public java.util.List<UserGroup> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public UserGroup findByUser_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
				orderByComparator)
		throws NoSuchUserGroupException;

	/**
	 * Returns the first user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public UserGroup fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns the last user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public UserGroup findByUser_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
				orderByComparator)
		throws NoSuchUserGroupException;

	/**
	 * Returns the last user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public UserGroup fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns the user groups before and after the current user group in the ordered set where userId = &#63;.
	 *
	 * @param userGroupPK the primary key of the current user group
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public UserGroup[] findByUser_PrevAndNext(
			UserGroupPK userGroupPK, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
				orderByComparator)
		throws NoSuchUserGroupException;

	/**
	 * Removes all the user groups where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUser(long userId);

	/**
	 * Returns the number of user groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user groups
	 */
	public int countByUser(long userId);

	/**
	 * Returns all the user groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching user groups
	 */
	public java.util.List<UserGroup> findByGroup(long userPermissionGroupId);

	/**
	 * Returns a range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of matching user groups
	 */
	public java.util.List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user groups
	 */
	public java.util.List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user groups
	 */
	public java.util.List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public UserGroup findByGroup_First(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
				orderByComparator)
		throws NoSuchUserGroupException;

	/**
	 * Returns the first user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public UserGroup fetchByGroup_First(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns the last user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	public UserGroup findByGroup_Last(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
				orderByComparator)
		throws NoSuchUserGroupException;

	/**
	 * Returns the last user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group, or <code>null</code> if a matching user group could not be found
	 */
	public UserGroup fetchByGroup_Last(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns the user groups before and after the current user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userGroupPK the primary key of the current user group
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public UserGroup[] findByGroup_PrevAndNext(
			UserGroupPK userGroupPK, long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
				orderByComparator)
		throws NoSuchUserGroupException;

	/**
	 * Removes all the user groups where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public void removeByGroup(long userPermissionGroupId);

	/**
	 * Returns the number of user groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching user groups
	 */
	public int countByGroup(long userPermissionGroupId);

	/**
	 * Caches the user group in the entity cache if it is enabled.
	 *
	 * @param userGroup the user group
	 */
	public void cacheResult(UserGroup userGroup);

	/**
	 * Caches the user groups in the entity cache if it is enabled.
	 *
	 * @param userGroups the user groups
	 */
	public void cacheResult(java.util.List<UserGroup> userGroups);

	/**
	 * Creates a new user group with the primary key. Does not add the user group to the database.
	 *
	 * @param userGroupPK the primary key for the new user group
	 * @return the new user group
	 */
	public UserGroup create(UserGroupPK userGroupPK);

	/**
	 * Removes the user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group that was removed
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public UserGroup remove(UserGroupPK userGroupPK)
		throws NoSuchUserGroupException;

	public UserGroup updateImpl(UserGroup userGroup);

	/**
	 * Returns the user group with the primary key or throws a <code>NoSuchUserGroupException</code> if it could not be found.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	public UserGroup findByPrimaryKey(UserGroupPK userGroupPK)
		throws NoSuchUserGroupException;

	/**
	 * Returns the user group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group, or <code>null</code> if a user group with the primary key could not be found
	 */
	public UserGroup fetchByPrimaryKey(UserGroupPK userGroupPK);

	/**
	 * Returns all the user groups.
	 *
	 * @return the user groups
	 */
	public java.util.List<UserGroup> findAll();

	/**
	 * Returns a range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of user groups
	 */
	public java.util.List<UserGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user groups
	 */
	public java.util.List<UserGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user groups
	 */
	public java.util.List<UserGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user groups.
	 *
	 * @return the number of user groups
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}