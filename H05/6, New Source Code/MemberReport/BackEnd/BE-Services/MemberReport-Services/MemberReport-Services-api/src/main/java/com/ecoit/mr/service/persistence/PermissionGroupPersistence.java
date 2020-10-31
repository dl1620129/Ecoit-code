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

import com.ecoit.mr.exception.NoSuchPermissionGroupException;
import com.ecoit.mr.model.PermissionGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the permission group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupUtil
 * @generated
 */
@ProviderType
public interface PermissionGroupPersistence
	extends BasePersistence<PermissionGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PermissionGroupUtil} to access the permission group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching permission groups
	 */
	public java.util.List<PermissionGroup> findByGroup(
		long userPermissionGroupId);

	/**
	 * Returns a range of all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of matching permission groups
	 */
	public java.util.List<PermissionGroup> findByGroup(
		long userPermissionGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission groups
	 */
	public java.util.List<PermissionGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission groups
	 */
	public java.util.List<PermissionGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	public PermissionGroup findByGroup_First(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
				orderByComparator)
		throws NoSuchPermissionGroupException;

	/**
	 * Returns the first permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	public PermissionGroup fetchByGroup_First(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
			orderByComparator);

	/**
	 * Returns the last permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	public PermissionGroup findByGroup_Last(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
				orderByComparator)
		throws NoSuchPermissionGroupException;

	/**
	 * Returns the last permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	public PermissionGroup fetchByGroup_Last(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
			orderByComparator);

	/**
	 * Returns the permission groups before and after the current permission group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param permissionGroupPK the primary key of the current permission group
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public PermissionGroup[] findByGroup_PrevAndNext(
			PermissionGroupPK permissionGroupPK, long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
				orderByComparator)
		throws NoSuchPermissionGroupException;

	/**
	 * Removes all the permission groups where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public void removeByGroup(long userPermissionGroupId);

	/**
	 * Returns the number of permission groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching permission groups
	 */
	public int countByGroup(long userPermissionGroupId);

	/**
	 * Caches the permission group in the entity cache if it is enabled.
	 *
	 * @param permissionGroup the permission group
	 */
	public void cacheResult(PermissionGroup permissionGroup);

	/**
	 * Caches the permission groups in the entity cache if it is enabled.
	 *
	 * @param permissionGroups the permission groups
	 */
	public void cacheResult(java.util.List<PermissionGroup> permissionGroups);

	/**
	 * Creates a new permission group with the primary key. Does not add the permission group to the database.
	 *
	 * @param permissionGroupPK the primary key for the new permission group
	 * @return the new permission group
	 */
	public PermissionGroup create(PermissionGroupPK permissionGroupPK);

	/**
	 * Removes the permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group that was removed
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public PermissionGroup remove(PermissionGroupPK permissionGroupPK)
		throws NoSuchPermissionGroupException;

	public PermissionGroup updateImpl(PermissionGroup permissionGroup);

	/**
	 * Returns the permission group with the primary key or throws a <code>NoSuchPermissionGroupException</code> if it could not be found.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	public PermissionGroup findByPrimaryKey(PermissionGroupPK permissionGroupPK)
		throws NoSuchPermissionGroupException;

	/**
	 * Returns the permission group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group, or <code>null</code> if a permission group with the primary key could not be found
	 */
	public PermissionGroup fetchByPrimaryKey(
		PermissionGroupPK permissionGroupPK);

	/**
	 * Returns all the permission groups.
	 *
	 * @return the permission groups
	 */
	public java.util.List<PermissionGroup> findAll();

	/**
	 * Returns a range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of permission groups
	 */
	public java.util.List<PermissionGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission groups
	 */
	public java.util.List<PermissionGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission groups
	 */
	public java.util.List<PermissionGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the permission groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of permission groups.
	 *
	 * @return the number of permission groups
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}