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

import User.Rank.Poisition.Service.model.UserRankPosition;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user rank position service. This utility wraps <code>User.Rank.Poisition.Service.service.persistence.impl.UserRankPositionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRankPositionPersistence
 * @generated
 */
@ProviderType
public class UserRankPositionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserRankPosition userRankPosition) {
		getPersistence().clearCache(userRankPosition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserRankPosition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserRankPosition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRankPosition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRankPosition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRankPosition update(UserRankPosition userRankPosition) {
		return getPersistence().update(userRankPosition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRankPosition update(
		UserRankPosition userRankPosition, ServiceContext serviceContext) {

		return getPersistence().update(userRankPosition, serviceContext);
	}

	/**
	 * Returns the user rank position where userId = &#63; or throws a <code>NoSuchUserRankPositionException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user rank position
	 * @throws NoSuchUserRankPositionException if a matching user rank position could not be found
	 */
	public static UserRankPosition findByUser(long userId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserRankPositionException {

		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns the user rank position where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUser(long)}
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank position, or <code>null</code> if a matching user rank position could not be found
	 */
	@Deprecated
	public static UserRankPosition fetchByUser(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUser(userId, useFinderCache);
	}

	/**
	 * Returns the user rank position where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank position, or <code>null</code> if a matching user rank position could not be found
	 */
	public static UserRankPosition fetchByUser(long userId) {
		return getPersistence().fetchByUser(userId);
	}

	/**
	 * Removes the user rank position where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user rank position that was removed
	 */
	public static UserRankPosition removeByUser(long userId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserRankPositionException {

		return getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of user rank positions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user rank positions
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Caches the user rank position in the entity cache if it is enabled.
	 *
	 * @param userRankPosition the user rank position
	 */
	public static void cacheResult(UserRankPosition userRankPosition) {
		getPersistence().cacheResult(userRankPosition);
	}

	/**
	 * Caches the user rank positions in the entity cache if it is enabled.
	 *
	 * @param userRankPositions the user rank positions
	 */
	public static void cacheResult(List<UserRankPosition> userRankPositions) {
		getPersistence().cacheResult(userRankPositions);
	}

	/**
	 * Creates a new user rank position with the primary key. Does not add the user rank position to the database.
	 *
	 * @param userId the primary key for the new user rank position
	 * @return the new user rank position
	 */
	public static UserRankPosition create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	 * Removes the user rank position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position that was removed
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	public static UserRankPosition remove(long userId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserRankPositionException {

		return getPersistence().remove(userId);
	}

	public static UserRankPosition updateImpl(
		UserRankPosition userRankPosition) {

		return getPersistence().updateImpl(userRankPosition);
	}

	/**
	 * Returns the user rank position with the primary key or throws a <code>NoSuchUserRankPositionException</code> if it could not be found.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	public static UserRankPosition findByPrimaryKey(long userId)
		throws User.Rank.Poisition.Service.exception.
			NoSuchUserRankPositionException {

		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	 * Returns the user rank position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position, or <code>null</code> if a user rank position with the primary key could not be found
	 */
	public static UserRankPosition fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	 * Returns all the user rank positions.
	 *
	 * @return the user rank positions
	 */
	public static List<UserRankPosition> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserRankPosition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserRankPosition> findAll(
		int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<UserRankPosition> findAll(
		int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the user rank positions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user rank positions.
	 *
	 * @return the number of user rank positions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserRankPositionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserRankPositionPersistence, UserRankPositionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserRankPositionPersistence.class);

		ServiceTracker<UserRankPositionPersistence, UserRankPositionPersistence>
			serviceTracker =
				new ServiceTracker
					<UserRankPositionPersistence, UserRankPositionPersistence>(
						bundle.getBundleContext(),
						UserRankPositionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}