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

import com.ecoit.mr.exception.NoSuchUserPermissionGroupException;
import com.ecoit.mr.model.UserPermissionGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user permission group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPermissionGroupUtil
 * @generated
 */
@ProviderType
public interface UserPermissionGroupPersistence
	extends BasePersistence<UserPermissionGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPermissionGroupUtil} to access the user permission group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the user permission group in the entity cache if it is enabled.
	 *
	 * @param userPermissionGroup the user permission group
	 */
	public void cacheResult(UserPermissionGroup userPermissionGroup);

	/**
	 * Caches the user permission groups in the entity cache if it is enabled.
	 *
	 * @param userPermissionGroups the user permission groups
	 */
	public void cacheResult(
		java.util.List<UserPermissionGroup> userPermissionGroups);

	/**
	 * Creates a new user permission group with the primary key. Does not add the user permission group to the database.
	 *
	 * @param userPermissionGroupId the primary key for the new user permission group
	 * @return the new user permission group
	 */
	public UserPermissionGroup create(long userPermissionGroupId);

	/**
	 * Removes the user permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group that was removed
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	public UserPermissionGroup remove(long userPermissionGroupId)
		throws NoSuchUserPermissionGroupException;

	public UserPermissionGroup updateImpl(
		UserPermissionGroup userPermissionGroup);

	/**
	 * Returns the user permission group with the primary key or throws a <code>NoSuchUserPermissionGroupException</code> if it could not be found.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	public UserPermissionGroup findByPrimaryKey(long userPermissionGroupId)
		throws NoSuchUserPermissionGroupException;

	/**
	 * Returns the user permission group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group, or <code>null</code> if a user permission group with the primary key could not be found
	 */
	public UserPermissionGroup fetchByPrimaryKey(long userPermissionGroupId);

	/**
	 * Returns all the user permission groups.
	 *
	 * @return the user permission groups
	 */
	public java.util.List<UserPermissionGroup> findAll();

	/**
	 * Returns a range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @return the range of user permission groups
	 */
	public java.util.List<UserPermissionGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user permission groups
	 */
	public java.util.List<UserPermissionGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPermissionGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user permission groups
	 */
	public java.util.List<UserPermissionGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserPermissionGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user permission groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user permission groups.
	 *
	 * @return the number of user permission groups
	 */
	public int countAll();

}