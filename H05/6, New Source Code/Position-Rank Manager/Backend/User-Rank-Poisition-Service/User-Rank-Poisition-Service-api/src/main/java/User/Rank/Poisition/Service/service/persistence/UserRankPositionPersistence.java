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

package User.Rank.Poisition.Service.service.persistence;

import User.Rank.Poisition.Service.exception.NoSuchUserRankPositionException;
import User.Rank.Poisition.Service.model.UserRankPosition;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user rank position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRankPositionUtil
 * @generated
 */
@ProviderType
public interface UserRankPositionPersistence
	extends BasePersistence<UserRankPosition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRankPositionUtil} to access the user rank position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the user rank position where userId = &#63; or throws a <code>NoSuchUserRankPositionException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user rank position
	 * @throws NoSuchUserRankPositionException if a matching user rank position could not be found
	 */
	public UserRankPosition findByUser(long userId)
		throws NoSuchUserRankPositionException;

	/**
	 * Returns the user rank position where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUser(long)}
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank position, or <code>null</code> if a matching user rank position could not be found
	 */
	@Deprecated
	public UserRankPosition fetchByUser(long userId, boolean useFinderCache);

	/**
	 * Returns the user rank position where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank position, or <code>null</code> if a matching user rank position could not be found
	 */
	public UserRankPosition fetchByUser(long userId);

	/**
	 * Removes the user rank position where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user rank position that was removed
	 */
	public UserRankPosition removeByUser(long userId)
		throws NoSuchUserRankPositionException;

	/**
	 * Returns the number of user rank positions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user rank positions
	 */
	public int countByUser(long userId);

	/**
	 * Caches the user rank position in the entity cache if it is enabled.
	 *
	 * @param userRankPosition the user rank position
	 */
	public void cacheResult(UserRankPosition userRankPosition);

	/**
	 * Caches the user rank positions in the entity cache if it is enabled.
	 *
	 * @param userRankPositions the user rank positions
	 */
	public void cacheResult(java.util.List<UserRankPosition> userRankPositions);

	/**
	 * Creates a new user rank position with the primary key. Does not add the user rank position to the database.
	 *
	 * @param userId the primary key for the new user rank position
	 * @return the new user rank position
	 */
	public UserRankPosition create(long userId);

	/**
	 * Removes the user rank position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position that was removed
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	public UserRankPosition remove(long userId)
		throws NoSuchUserRankPositionException;

	public UserRankPosition updateImpl(UserRankPosition userRankPosition);

	/**
	 * Returns the user rank position with the primary key or throws a <code>NoSuchUserRankPositionException</code> if it could not be found.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	public UserRankPosition findByPrimaryKey(long userId)
		throws NoSuchUserRankPositionException;

	/**
	 * Returns the user rank position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position, or <code>null</code> if a user rank position with the primary key could not be found
	 */
	public UserRankPosition fetchByPrimaryKey(long userId);

	/**
	 * Returns all the user rank positions.
	 *
	 * @return the user rank positions
	 */
	public java.util.List<UserRankPosition> findAll();

	/**
	 * Returns a range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @return the range of user rank positions
	 */
	public java.util.List<UserRankPosition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user rank positions
	 */
	@Deprecated
	public java.util.List<UserRankPosition> findAll(
		int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user rank positions
	 */
	public java.util.List<UserRankPosition> findAll(
		int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator);

	/**
	 * Removes all the user rank positions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user rank positions.
	 *
	 * @return the number of user rank positions
	 */
	public int countAll();

}