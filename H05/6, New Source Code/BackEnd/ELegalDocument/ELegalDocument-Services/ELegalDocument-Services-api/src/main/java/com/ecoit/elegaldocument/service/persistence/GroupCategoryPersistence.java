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

package com.ecoit.elegaldocument.service.persistence;

import com.ecoit.elegaldocument.exception.NoSuchGroupCategoryException;
import com.ecoit.elegaldocument.model.GroupCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see GroupCategoryUtil
 * @generated
 */
@ProviderType
public interface GroupCategoryPersistence
	extends BasePersistence<GroupCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupCategoryUtil} to access the group category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group categories
	 */
	public java.util.List<GroupCategory> findByGroupUser(long groupUserId);

	/**
	 * Returns a range of all the group categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of matching group categories
	 */
	public java.util.List<GroupCategory> findByGroupUser(
		long groupUserId, int start, int end);

	/**
	 * Returns an ordered range of all the group categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group categories
	 */
	public java.util.List<GroupCategory> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group categories
	 */
	public java.util.List<GroupCategory> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public GroupCategory findByGroupUser_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
				orderByComparator)
		throws NoSuchGroupCategoryException;

	/**
	 * Returns the first group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public GroupCategory fetchByGroupUser_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns the last group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public GroupCategory findByGroupUser_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
				orderByComparator)
		throws NoSuchGroupCategoryException;

	/**
	 * Returns the last group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public GroupCategory fetchByGroupUser_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns the group categories before and after the current group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupCategoryPK the primary key of the current group category
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public GroupCategory[] findByGroupUser_PrevAndNext(
			GroupCategoryPK groupCategoryPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
				orderByComparator)
		throws NoSuchGroupCategoryException;

	/**
	 * Removes all the group categories where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeByGroupUser(long groupUserId);

	/**
	 * Returns the number of group categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group categories
	 */
	public int countByGroupUser(long groupUserId);

	/**
	 * Returns all the group categories where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @return the matching group categories
	 */
	public java.util.List<GroupCategory> findByCategory(long typeid);

	/**
	 * Returns a range of all the group categories where typeid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param typeid the typeid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of matching group categories
	 */
	public java.util.List<GroupCategory> findByCategory(
		long typeid, int start, int end);

	/**
	 * Returns an ordered range of all the group categories where typeid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param typeid the typeid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group categories
	 */
	public java.util.List<GroupCategory> findByCategory(
		long typeid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group categories where typeid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param typeid the typeid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group categories
	 */
	public java.util.List<GroupCategory> findByCategory(
		long typeid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public GroupCategory findByCategory_First(
			long typeid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
				orderByComparator)
		throws NoSuchGroupCategoryException;

	/**
	 * Returns the first group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public GroupCategory fetchByCategory_First(
		long typeid,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns the last group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	public GroupCategory findByCategory_Last(
			long typeid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
				orderByComparator)
		throws NoSuchGroupCategoryException;

	/**
	 * Returns the last group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category, or <code>null</code> if a matching group category could not be found
	 */
	public GroupCategory fetchByCategory_Last(
		long typeid,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns the group categories before and after the current group category in the ordered set where typeid = &#63;.
	 *
	 * @param groupCategoryPK the primary key of the current group category
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public GroupCategory[] findByCategory_PrevAndNext(
			GroupCategoryPK groupCategoryPK, long typeid,
			com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
				orderByComparator)
		throws NoSuchGroupCategoryException;

	/**
	 * Removes all the group categories where typeid = &#63; from the database.
	 *
	 * @param typeid the typeid
	 */
	public void removeByCategory(long typeid);

	/**
	 * Returns the number of group categories where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @return the number of matching group categories
	 */
	public int countByCategory(long typeid);

	/**
	 * Caches the group category in the entity cache if it is enabled.
	 *
	 * @param groupCategory the group category
	 */
	public void cacheResult(GroupCategory groupCategory);

	/**
	 * Caches the group categories in the entity cache if it is enabled.
	 *
	 * @param groupCategories the group categories
	 */
	public void cacheResult(java.util.List<GroupCategory> groupCategories);

	/**
	 * Creates a new group category with the primary key. Does not add the group category to the database.
	 *
	 * @param groupCategoryPK the primary key for the new group category
	 * @return the new group category
	 */
	public GroupCategory create(GroupCategoryPK groupCategoryPK);

	/**
	 * Removes the group category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category that was removed
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public GroupCategory remove(GroupCategoryPK groupCategoryPK)
		throws NoSuchGroupCategoryException;

	public GroupCategory updateImpl(GroupCategory groupCategory);

	/**
	 * Returns the group category with the primary key or throws a <code>NoSuchGroupCategoryException</code> if it could not be found.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	public GroupCategory findByPrimaryKey(GroupCategoryPK groupCategoryPK)
		throws NoSuchGroupCategoryException;

	/**
	 * Returns the group category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category, or <code>null</code> if a group category with the primary key could not be found
	 */
	public GroupCategory fetchByPrimaryKey(GroupCategoryPK groupCategoryPK);

	/**
	 * Returns all the group categories.
	 *
	 * @return the group categories
	 */
	public java.util.List<GroupCategory> findAll();

	/**
	 * Returns a range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of group categories
	 */
	public java.util.List<GroupCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group categories
	 */
	public java.util.List<GroupCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group categories
	 */
	public java.util.List<GroupCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group categories.
	 *
	 * @return the number of group categories
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}