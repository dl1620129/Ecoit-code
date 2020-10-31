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

import com.ecoit.elegaldocument.exception.NoSuchEcmsGroupException;
import com.ecoit.elegaldocument.model.EcmsGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ecms group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see EcmsGroupUtil
 * @generated
 */
@ProviderType
public interface EcmsGroupPersistence extends BasePersistence<EcmsGroup> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcmsGroupUtil} to access the ecms group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the ecms group where groupUserId = &#63; or throws a <code>NoSuchEcmsGroupException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms group
	 * @throws NoSuchEcmsGroupException if a matching ecms group could not be found
	 */
	public EcmsGroup findBygroupUserId(long groupUserId)
		throws NoSuchEcmsGroupException;

	/**
	 * Returns the ecms group where groupUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms group, or <code>null</code> if a matching ecms group could not be found
	 */
	public EcmsGroup fetchBygroupUserId(long groupUserId);

	/**
	 * Returns the ecms group where groupUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms group, or <code>null</code> if a matching ecms group could not be found
	 */
	public EcmsGroup fetchBygroupUserId(
		long groupUserId, boolean useFinderCache);

	/**
	 * Removes the ecms group where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @return the ecms group that was removed
	 */
	public EcmsGroup removeBygroupUserId(long groupUserId)
		throws NoSuchEcmsGroupException;

	/**
	 * Returns the number of ecms groups where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms groups
	 */
	public int countBygroupUserId(long groupUserId);

	/**
	 * Caches the ecms group in the entity cache if it is enabled.
	 *
	 * @param ecmsGroup the ecms group
	 */
	public void cacheResult(EcmsGroup ecmsGroup);

	/**
	 * Caches the ecms groups in the entity cache if it is enabled.
	 *
	 * @param ecmsGroups the ecms groups
	 */
	public void cacheResult(java.util.List<EcmsGroup> ecmsGroups);

	/**
	 * Creates a new ecms group with the primary key. Does not add the ecms group to the database.
	 *
	 * @param groupUserId the primary key for the new ecms group
	 * @return the new ecms group
	 */
	public EcmsGroup create(long groupUserId);

	/**
	 * Removes the ecms group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group that was removed
	 * @throws NoSuchEcmsGroupException if a ecms group with the primary key could not be found
	 */
	public EcmsGroup remove(long groupUserId) throws NoSuchEcmsGroupException;

	public EcmsGroup updateImpl(EcmsGroup ecmsGroup);

	/**
	 * Returns the ecms group with the primary key or throws a <code>NoSuchEcmsGroupException</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group
	 * @throws NoSuchEcmsGroupException if a ecms group with the primary key could not be found
	 */
	public EcmsGroup findByPrimaryKey(long groupUserId)
		throws NoSuchEcmsGroupException;

	/**
	 * Returns the ecms group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group, or <code>null</code> if a ecms group with the primary key could not be found
	 */
	public EcmsGroup fetchByPrimaryKey(long groupUserId);

	/**
	 * Returns all the ecms groups.
	 *
	 * @return the ecms groups
	 */
	public java.util.List<EcmsGroup> findAll();

	/**
	 * Returns a range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @return the range of ecms groups
	 */
	public java.util.List<EcmsGroup> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ecms groups
	 */
	public java.util.List<EcmsGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGroup>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ecms groups
	 */
	public java.util.List<EcmsGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGroup>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ecms groups from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ecms groups.
	 *
	 * @return the number of ecms groups
	 */
	public int countAll();

}