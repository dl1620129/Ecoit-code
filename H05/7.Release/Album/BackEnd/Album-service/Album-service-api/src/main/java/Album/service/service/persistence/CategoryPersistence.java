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

package Album.service.service.persistence;

import Album.service.exception.NoSuchCategoryException;
import Album.service.model.Category;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryUtil
 * @generated
 */
@ProviderType
public interface CategoryPersistence extends BasePersistence<Category> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the categories where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching categories
	 */
	public java.util.List<Category> findByFindAll(long groupId, long companyId);

	/**
	 * Returns a range of all the categories where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public java.util.List<Category> findByFindAll(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the categories where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Deprecated
	public java.util.List<Category> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the categories where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public java.util.List<Category> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Category> orderByComparator);

	/**
	 * Returns the first category in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<Category> orderByComparator);

	/**
	 * Returns the last category in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<Category> orderByComparator);

	/**
	 * Returns the categories before and after the current category in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category[] findByFindAll_PrevAndNext(
			long categoryId, long groupId, long companyId,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of categories where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching categories
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Returns all the categories where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching categories
	 */
	public java.util.List<Category> findByFindStatus(long status);

	/**
	 * Returns a range of all the categories where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of matching categories
	 */
	public java.util.List<Category> findByFindStatus(
		long status, int start, int end);

	/**
	 * Returns an ordered range of all the categories where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindStatus(long, int, int, OrderByComparator)}
	 * @param status the status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching categories
	 */
	@Deprecated
	public java.util.List<Category> findByFindStatus(
		long status, int start, int end,
		OrderByComparator<Category> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the categories where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching categories
	 */
	public java.util.List<Category> findByFindStatus(
		long status, int start, int end,
		OrderByComparator<Category> orderByComparator);

	/**
	 * Returns the first category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByFindStatus_First(
			long status, OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the first category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByFindStatus_First(
		long status, OrderByComparator<Category> orderByComparator);

	/**
	 * Returns the last category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	public Category findByFindStatus_Last(
			long status, OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Returns the last category in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category, or <code>null</code> if a matching category could not be found
	 */
	public Category fetchByFindStatus_Last(
		long status, OrderByComparator<Category> orderByComparator);

	/**
	 * Returns the categories before and after the current category in the ordered set where status = &#63;.
	 *
	 * @param categoryId the primary key of the current category
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category[] findByFindStatus_PrevAndNext(
			long categoryId, long status,
			OrderByComparator<Category> orderByComparator)
		throws NoSuchCategoryException;

	/**
	 * Removes all the categories where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByFindStatus(long status);

	/**
	 * Returns the number of categories where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching categories
	 */
	public int countByFindStatus(long status);

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	public void cacheResult(Category category);

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	public void cacheResult(java.util.List<Category> categories);

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	public Category create(long categoryId);

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category remove(long categoryId) throws NoSuchCategoryException;

	public Category updateImpl(Category category);

	/**
	 * Returns the category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	public Category findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException;

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	public Category fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	public java.util.List<Category> findAll();

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	public java.util.List<Category> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of categories
	 */
	@Deprecated
	public java.util.List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	public java.util.List<Category> findAll(
		int start, int end, OrderByComparator<Category> orderByComparator);

	/**
	 * Removes all the categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	public int countAll();

}