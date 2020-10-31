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

import com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException;
import com.ecoit.qa.service.model.GroupUserCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group user category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserCategoryUtil
 * @generated
 */
@ProviderType
public interface GroupUserCategoryPersistence
	extends BasePersistence<GroupUserCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupUserCategoryUtil} to access the group user category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the group user categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByCategory(long categoryId);

	/**
	 * Returns a range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end);

	/**
	 * Returns an ordered range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public GroupUserCategory findByCategory_First(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
				orderByComparator)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Returns the first group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public GroupUserCategory fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns the last group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public GroupUserCategory findByCategory_Last(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
				orderByComparator)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Returns the last group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public GroupUserCategory fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns the group user categories before and after the current group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param groupUserCategoryPK the primary key of the current group user category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public GroupUserCategory[] findByCategory_PrevAndNext(
			GroupUserCategoryPK groupUserCategoryPK, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
				orderByComparator)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Removes all the group user categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByCategory(long categoryId);

	/**
	 * Returns the number of group user categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching group user categories
	 */
	public int countByCategory(long categoryId);

	/**
	 * Returns all the group user categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByGroupUser(long groupUserId);

	/**
	 * Returns a range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end);

	/**
	 * Returns an ordered range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user categories
	 */
	public java.util.List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public GroupUserCategory findByGroupUser_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
				orderByComparator)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Returns the first group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public GroupUserCategory fetchByGroupUser_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns the last group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	public GroupUserCategory findByGroupUser_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
				orderByComparator)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Returns the last group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	public GroupUserCategory fetchByGroupUser_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns the group user categories before and after the current group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserCategoryPK the primary key of the current group user category
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public GroupUserCategory[] findByGroupUser_PrevAndNext(
			GroupUserCategoryPK groupUserCategoryPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
				orderByComparator)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Removes all the group user categories where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeByGroupUser(long groupUserId);

	/**
	 * Returns the number of group user categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user categories
	 */
	public int countByGroupUser(long groupUserId);

	/**
	 * Caches the group user category in the entity cache if it is enabled.
	 *
	 * @param groupUserCategory the group user category
	 */
	public void cacheResult(GroupUserCategory groupUserCategory);

	/**
	 * Caches the group user categories in the entity cache if it is enabled.
	 *
	 * @param groupUserCategories the group user categories
	 */
	public void cacheResult(
		java.util.List<GroupUserCategory> groupUserCategories);

	/**
	 * Creates a new group user category with the primary key. Does not add the group user category to the database.
	 *
	 * @param groupUserCategoryPK the primary key for the new group user category
	 * @return the new group user category
	 */
	public GroupUserCategory create(GroupUserCategoryPK groupUserCategoryPK);

	/**
	 * Removes the group user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category that was removed
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public GroupUserCategory remove(GroupUserCategoryPK groupUserCategoryPK)
		throws NoSuchGroupUserCategoryException;

	public GroupUserCategory updateImpl(GroupUserCategory groupUserCategory);

	/**
	 * Returns the group user category with the primary key or throws a <code>NoSuchGroupUserCategoryException</code> if it could not be found.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	public GroupUserCategory findByPrimaryKey(
			GroupUserCategoryPK groupUserCategoryPK)
		throws NoSuchGroupUserCategoryException;

	/**
	 * Returns the group user category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category, or <code>null</code> if a group user category with the primary key could not be found
	 */
	public GroupUserCategory fetchByPrimaryKey(
		GroupUserCategoryPK groupUserCategoryPK);

	/**
	 * Returns all the group user categories.
	 *
	 * @return the group user categories
	 */
	public java.util.List<GroupUserCategory> findAll();

	/**
	 * Returns a range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of group user categories
	 */
	public java.util.List<GroupUserCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user categories
	 */
	public java.util.List<GroupUserCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user categories
	 */
	public java.util.List<GroupUserCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GroupUserCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the group user categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group user categories.
	 *
	 * @return the number of group user categories
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}