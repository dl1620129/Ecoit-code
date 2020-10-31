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

package com.ecoit.lichcongtac.services.service.persistence;

import com.ecoit.lichcongtac.services.exception.NoSuchPermissionGroupRelException;
import com.ecoit.lichcongtac.services.model.PermissionGroupRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the permission group rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupRelUtil
 * @generated
 */
@ProviderType
public interface PermissionGroupRelPersistence
	extends BasePersistence<PermissionGroupRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PermissionGroupRelUtil} to access the permission group rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching permission group rels
	 */
	public java.util.List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId);

	/**
	 * Returns a range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @return the range of matching permission group rels
	 */
	public java.util.List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission group rels
	 */
	public java.util.List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission group rels
	 */
	public java.util.List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group rel
	 * @throws NoSuchPermissionGroupRelException if a matching permission group rel could not be found
	 */
	public PermissionGroupRel findByGroup_First(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
				orderByComparator)
		throws NoSuchPermissionGroupRelException;

	/**
	 * Returns the first permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group rel, or <code>null</code> if a matching permission group rel could not be found
	 */
	public PermissionGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
			orderByComparator);

	/**
	 * Returns the last permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group rel
	 * @throws NoSuchPermissionGroupRelException if a matching permission group rel could not be found
	 */
	public PermissionGroupRel findByGroup_Last(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
				orderByComparator)
		throws NoSuchPermissionGroupRelException;

	/**
	 * Returns the last permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group rel, or <code>null</code> if a matching permission group rel could not be found
	 */
	public PermissionGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
			orderByComparator);

	/**
	 * Returns the permission group rels before and after the current permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param permissionGroupRelPK the primary key of the current permission group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	public PermissionGroupRel[] findByGroup_PrevAndNext(
			PermissionGroupRelPK permissionGroupRelPK,
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
				orderByComparator)
		throws NoSuchPermissionGroupRelException;

	/**
	 * Removes all the permission group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public void removeByGroup(long userPermissionGroupId);

	/**
	 * Returns the number of permission group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching permission group rels
	 */
	public int countByGroup(long userPermissionGroupId);

	/**
	 * Caches the permission group rel in the entity cache if it is enabled.
	 *
	 * @param permissionGroupRel the permission group rel
	 */
	public void cacheResult(PermissionGroupRel permissionGroupRel);

	/**
	 * Caches the permission group rels in the entity cache if it is enabled.
	 *
	 * @param permissionGroupRels the permission group rels
	 */
	public void cacheResult(
		java.util.List<PermissionGroupRel> permissionGroupRels);

	/**
	 * Creates a new permission group rel with the primary key. Does not add the permission group rel to the database.
	 *
	 * @param permissionGroupRelPK the primary key for the new permission group rel
	 * @return the new permission group rel
	 */
	public PermissionGroupRel create(PermissionGroupRelPK permissionGroupRelPK);

	/**
	 * Removes the permission group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel that was removed
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	public PermissionGroupRel remove(PermissionGroupRelPK permissionGroupRelPK)
		throws NoSuchPermissionGroupRelException;

	public PermissionGroupRel updateImpl(PermissionGroupRel permissionGroupRel);

	/**
	 * Returns the permission group rel with the primary key or throws a <code>NoSuchPermissionGroupRelException</code> if it could not be found.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	public PermissionGroupRel findByPrimaryKey(
			PermissionGroupRelPK permissionGroupRelPK)
		throws NoSuchPermissionGroupRelException;

	/**
	 * Returns the permission group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel, or <code>null</code> if a permission group rel with the primary key could not be found
	 */
	public PermissionGroupRel fetchByPrimaryKey(
		PermissionGroupRelPK permissionGroupRelPK);

	/**
	 * Returns all the permission group rels.
	 *
	 * @return the permission group rels
	 */
	public java.util.List<PermissionGroupRel> findAll();

	/**
	 * Returns a range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @return the range of permission group rels
	 */
	public java.util.List<PermissionGroupRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission group rels
	 */
	public java.util.List<PermissionGroupRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission group rels
	 */
	public java.util.List<PermissionGroupRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PermissionGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the permission group rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of permission group rels.
	 *
	 * @return the number of permission group rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}