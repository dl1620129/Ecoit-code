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

import com.ecoit.lichcongtac.services.exception.NoSuchColumnGroupRelException;
import com.ecoit.lichcongtac.services.model.ColumnGroupRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the column group rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelUtil
 * @generated
 */
@ProviderType
public interface ColumnGroupRelPersistence
	extends BasePersistence<ColumnGroupRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ColumnGroupRelUtil} to access the column group rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching column group rels
	 */
	public java.util.List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId);

	/**
	 * Returns a range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of matching column group rels
	 */
	public java.util.List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column group rels
	 */
	public java.util.List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column group rels
	 */
	public java.util.List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column group rel
	 * @throws NoSuchColumnGroupRelException if a matching column group rel could not be found
	 */
	public ColumnGroupRel findByGroup_First(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
				orderByComparator)
		throws NoSuchColumnGroupRelException;

	/**
	 * Returns the first column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column group rel, or <code>null</code> if a matching column group rel could not be found
	 */
	public ColumnGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
			orderByComparator);

	/**
	 * Returns the last column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column group rel
	 * @throws NoSuchColumnGroupRelException if a matching column group rel could not be found
	 */
	public ColumnGroupRel findByGroup_Last(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
				orderByComparator)
		throws NoSuchColumnGroupRelException;

	/**
	 * Returns the last column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column group rel, or <code>null</code> if a matching column group rel could not be found
	 */
	public ColumnGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
			orderByComparator);

	/**
	 * Returns the column group rels before and after the current column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param columnGroupRelPK the primary key of the current column group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	public ColumnGroupRel[] findByGroup_PrevAndNext(
			ColumnGroupRelPK columnGroupRelPK, long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
				orderByComparator)
		throws NoSuchColumnGroupRelException;

	/**
	 * Removes all the column group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public void removeByGroup(long userPermissionGroupId);

	/**
	 * Returns the number of column group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching column group rels
	 */
	public int countByGroup(long userPermissionGroupId);

	/**
	 * Caches the column group rel in the entity cache if it is enabled.
	 *
	 * @param columnGroupRel the column group rel
	 */
	public void cacheResult(ColumnGroupRel columnGroupRel);

	/**
	 * Caches the column group rels in the entity cache if it is enabled.
	 *
	 * @param columnGroupRels the column group rels
	 */
	public void cacheResult(java.util.List<ColumnGroupRel> columnGroupRels);

	/**
	 * Creates a new column group rel with the primary key. Does not add the column group rel to the database.
	 *
	 * @param columnGroupRelPK the primary key for the new column group rel
	 * @return the new column group rel
	 */
	public ColumnGroupRel create(ColumnGroupRelPK columnGroupRelPK);

	/**
	 * Removes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	public ColumnGroupRel remove(ColumnGroupRelPK columnGroupRelPK)
		throws NoSuchColumnGroupRelException;

	public ColumnGroupRel updateImpl(ColumnGroupRel columnGroupRel);

	/**
	 * Returns the column group rel with the primary key or throws a <code>NoSuchColumnGroupRelException</code> if it could not be found.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	public ColumnGroupRel findByPrimaryKey(ColumnGroupRelPK columnGroupRelPK)
		throws NoSuchColumnGroupRelException;

	/**
	 * Returns the column group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel, or <code>null</code> if a column group rel with the primary key could not be found
	 */
	public ColumnGroupRel fetchByPrimaryKey(ColumnGroupRelPK columnGroupRelPK);

	/**
	 * Returns all the column group rels.
	 *
	 * @return the column group rels
	 */
	public java.util.List<ColumnGroupRel> findAll();

	/**
	 * Returns a range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of column group rels
	 */
	public java.util.List<ColumnGroupRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of column group rels
	 */
	public java.util.List<ColumnGroupRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of column group rels
	 */
	public java.util.List<ColumnGroupRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ColumnGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the column group rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of column group rels.
	 *
	 * @return the number of column group rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}