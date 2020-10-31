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

import com.ecoit.lichcongtac.services.exception.NoSuchUserGroupRelException;
import com.ecoit.lichcongtac.services.model.UserGroupRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user group rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRelUtil
 * @generated
 */
@ProviderType
public interface UserGroupRelPersistence extends BasePersistence<UserGroupRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserGroupRelUtil} to access the user group rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user group rels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user group rels
	 */
	public java.util.List<UserGroupRel> findByUser(long userId);

	/**
	 * Returns a range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of matching user group rels
	 */
	public java.util.List<UserGroupRel> findByUser(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group rels
	 */
	public java.util.List<UserGroupRel> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user group rels
	 */
	public java.util.List<UserGroupRel> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public UserGroupRel findByUser_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
				orderByComparator)
		throws NoSuchUserGroupRelException;

	/**
	 * Returns the first user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public UserGroupRel fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns the last user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public UserGroupRel findByUser_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
				orderByComparator)
		throws NoSuchUserGroupRelException;

	/**
	 * Returns the last user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public UserGroupRel fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns the user group rels before and after the current user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userGroupRelPK the primary key of the current user group rel
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public UserGroupRel[] findByUser_PrevAndNext(
			UserGroupRelPK userGroupRelPK, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
				orderByComparator)
		throws NoSuchUserGroupRelException;

	/**
	 * Removes all the user group rels where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUser(long userId);

	/**
	 * Returns the number of user group rels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user group rels
	 */
	public int countByUser(long userId);

	/**
	 * Returns all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching user group rels
	 */
	public java.util.List<UserGroupRel> findByGroup(long userPermissionGroupId);

	/**
	 * Returns a range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of matching user group rels
	 */
	public java.util.List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end);

	/**
	 * Returns an ordered range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group rels
	 */
	public java.util.List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user group rels
	 */
	public java.util.List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public UserGroupRel findByGroup_First(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
				orderByComparator)
		throws NoSuchUserGroupRelException;

	/**
	 * Returns the first user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public UserGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns the last user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	public UserGroupRel findByGroup_Last(
			long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
				orderByComparator)
		throws NoSuchUserGroupRelException;

	/**
	 * Returns the last user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	public UserGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns the user group rels before and after the current user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userGroupRelPK the primary key of the current user group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public UserGroupRel[] findByGroup_PrevAndNext(
			UserGroupRelPK userGroupRelPK, long userPermissionGroupId,
			com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
				orderByComparator)
		throws NoSuchUserGroupRelException;

	/**
	 * Removes all the user group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	public void removeByGroup(long userPermissionGroupId);

	/**
	 * Returns the number of user group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching user group rels
	 */
	public int countByGroup(long userPermissionGroupId);

	/**
	 * Caches the user group rel in the entity cache if it is enabled.
	 *
	 * @param userGroupRel the user group rel
	 */
	public void cacheResult(UserGroupRel userGroupRel);

	/**
	 * Caches the user group rels in the entity cache if it is enabled.
	 *
	 * @param userGroupRels the user group rels
	 */
	public void cacheResult(java.util.List<UserGroupRel> userGroupRels);

	/**
	 * Creates a new user group rel with the primary key. Does not add the user group rel to the database.
	 *
	 * @param userGroupRelPK the primary key for the new user group rel
	 * @return the new user group rel
	 */
	public UserGroupRel create(UserGroupRelPK userGroupRelPK);

	/**
	 * Removes the user group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel that was removed
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public UserGroupRel remove(UserGroupRelPK userGroupRelPK)
		throws NoSuchUserGroupRelException;

	public UserGroupRel updateImpl(UserGroupRel userGroupRel);

	/**
	 * Returns the user group rel with the primary key or throws a <code>NoSuchUserGroupRelException</code> if it could not be found.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	public UserGroupRel findByPrimaryKey(UserGroupRelPK userGroupRelPK)
		throws NoSuchUserGroupRelException;

	/**
	 * Returns the user group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel, or <code>null</code> if a user group rel with the primary key could not be found
	 */
	public UserGroupRel fetchByPrimaryKey(UserGroupRelPK userGroupRelPK);

	/**
	 * Returns all the user group rels.
	 *
	 * @return the user group rels
	 */
	public java.util.List<UserGroupRel> findAll();

	/**
	 * Returns a range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of user group rels
	 */
	public java.util.List<UserGroupRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user group rels
	 */
	public java.util.List<UserGroupRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user group rels
	 */
	public java.util.List<UserGroupRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserGroupRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user group rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user group rels.
	 *
	 * @return the number of user group rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}