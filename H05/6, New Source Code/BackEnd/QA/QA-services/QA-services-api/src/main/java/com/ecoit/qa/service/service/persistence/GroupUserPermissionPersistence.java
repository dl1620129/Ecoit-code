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

import com.ecoit.qa.service.exception.NoSuchGroupUserPermissionException;
import com.ecoit.qa.service.model.GroupUserPermission;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group user permission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserPermissionUtil
 * @generated
 */
@ProviderType
public interface GroupUserPermissionPersistence
	extends BasePersistence<GroupUserPermission> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupUserPermissionUtil} to access the group user permission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group user permissions where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByPermission(
		long permissionId);

	/**
	 * Returns a range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end);

	/**
	 * Returns an ordered range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public GroupUserPermission findByPermission_First(
			long permissionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Returns the first group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public GroupUserPermission fetchByPermission_First(
		long permissionId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns the last group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public GroupUserPermission findByPermission_Last(
			long permissionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Returns the last group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public GroupUserPermission fetchByPermission_Last(
		long permissionId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns the group user permissions before and after the current group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param groupUserPermissionPK the primary key of the current group user permission
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public GroupUserPermission[] findByPermission_PrevAndNext(
			GroupUserPermissionPK groupUserPermissionPK, long permissionId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Removes all the group user permissions where permissionId = &#63; from the database.
	 *
	 * @param permissionId the permission ID
	 */
	public void removeByPermission(long permissionId);

	/**
	 * Returns the number of group user permissions where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the number of matching group user permissions
	 */
	public int countByPermission(long permissionId);

	/**
	 * Returns all the group user permissions where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByGroupUser(
		long groupUserId);

	/**
	 * Returns a range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end);

	/**
	 * Returns an ordered range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user permissions
	 */
	public java.util.List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public GroupUserPermission findByGroupUser_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Returns the first group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public GroupUserPermission fetchByGroupUser_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns the last group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	public GroupUserPermission findByGroupUser_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Returns the last group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	public GroupUserPermission fetchByGroupUser_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns the group user permissions before and after the current group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserPermissionPK the primary key of the current group user permission
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public GroupUserPermission[] findByGroupUser_PrevAndNext(
			GroupUserPermissionPK groupUserPermissionPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator
				<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Removes all the group user permissions where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeByGroupUser(long groupUserId);

	/**
	 * Returns the number of group user permissions where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user permissions
	 */
	public int countByGroupUser(long groupUserId);

	/**
	 * Caches the group user permission in the entity cache if it is enabled.
	 *
	 * @param groupUserPermission the group user permission
	 */
	public void cacheResult(GroupUserPermission groupUserPermission);

	/**
	 * Caches the group user permissions in the entity cache if it is enabled.
	 *
	 * @param groupUserPermissions the group user permissions
	 */
	public void cacheResult(
		java.util.List<GroupUserPermission> groupUserPermissions);

	/**
	 * Creates a new group user permission with the primary key. Does not add the group user permission to the database.
	 *
	 * @param groupUserPermissionPK the primary key for the new group user permission
	 * @return the new group user permission
	 */
	public GroupUserPermission create(
		GroupUserPermissionPK groupUserPermissionPK);

	/**
	 * Removes the group user permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission that was removed
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public GroupUserPermission remove(
			GroupUserPermissionPK groupUserPermissionPK)
		throws NoSuchGroupUserPermissionException;

	public GroupUserPermission updateImpl(
		GroupUserPermission groupUserPermission);

	/**
	 * Returns the group user permission with the primary key or throws a <code>NoSuchGroupUserPermissionException</code> if it could not be found.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	public GroupUserPermission findByPrimaryKey(
			GroupUserPermissionPK groupUserPermissionPK)
		throws NoSuchGroupUserPermissionException;

	/**
	 * Returns the group user permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission, or <code>null</code> if a group user permission with the primary key could not be found
	 */
	public GroupUserPermission fetchByPrimaryKey(
		GroupUserPermissionPK groupUserPermissionPK);

	/**
	 * Returns all the group user permissions.
	 *
	 * @return the group user permissions
	 */
	public java.util.List<GroupUserPermission> findAll();

	/**
	 * Returns a range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of group user permissions
	 */
	public java.util.List<GroupUserPermission> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user permissions
	 */
	public java.util.List<GroupUserPermission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user permissions
	 */
	public java.util.List<GroupUserPermission> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserPermission>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group user permissions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group user permissions.
	 *
	 * @return the number of group user permissions
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}