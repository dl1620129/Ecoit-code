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

package User.Rank.Poisition.Service.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserRankPosition. This utility wraps
 * <code>User.Rank.Poisition.Service.service.impl.UserRankPositionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserRankPositionLocalService
 * @generated
 */
@ProviderType
public class UserRankPositionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>User.Rank.Poisition.Service.service.impl.UserRankPositionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user rank position to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankPosition the user rank position
	 * @return the user rank position that was added
	 */
	public static User.Rank.Poisition.Service.model.UserRankPosition
		addUserRankPosition(
			User.Rank.Poisition.Service.model.UserRankPosition
				userRankPosition) {

		return getService().addUserRankPosition(userRankPosition);
	}

	/**
	 * Creates a new user rank position with the primary key. Does not add the user rank position to the database.
	 *
	 * @param userId the primary key for the new user rank position
	 * @return the new user rank position
	 */
	public static User.Rank.Poisition.Service.model.UserRankPosition
		createUserRankPosition(long userId) {

		return getService().createUserRankPosition(userId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user rank position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position that was removed
	 * @throws PortalException if a user rank position with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserRankPosition
			deleteUserRankPosition(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserRankPosition(userId);
	}

	/**
	 * Deletes the user rank position from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankPosition the user rank position
	 * @return the user rank position that was removed
	 */
	public static User.Rank.Poisition.Service.model.UserRankPosition
		deleteUserRankPosition(
			User.Rank.Poisition.Service.model.UserRankPosition
				userRankPosition) {

		return getService().deleteUserRankPosition(userRankPosition);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static User.Rank.Poisition.Service.model.UserRankPosition
		fetchUserRankPosition(long userId) {

		return getService().fetchUserRankPosition(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user rank position with the primary key.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position
	 * @throws PortalException if a user rank position with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserRankPosition
			getUserRankPosition(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserRankPosition(userId);
	}

	/**
	 * Returns a range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @return the range of user rank positions
	 */
	public static java.util.List
		<User.Rank.Poisition.Service.model.UserRankPosition>
			getUserRankPositions(int start, int end) {

		return getService().getUserRankPositions(start, end);
	}

	/**
	 * Returns the number of user rank positions.
	 *
	 * @return the number of user rank positions
	 */
	public static int getUserRankPositionsCount() {
		return getService().getUserRankPositionsCount();
	}

	/**
	 * Updates the user rank position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userRankPosition the user rank position
	 * @return the user rank position that was updated
	 */
	public static User.Rank.Poisition.Service.model.UserRankPosition
		updateUserRankPosition(
			User.Rank.Poisition.Service.model.UserRankPosition
				userRankPosition) {

		return getService().updateUserRankPosition(userRankPosition);
	}

	public static UserRankPositionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserRankPositionLocalService, UserRankPositionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserRankPositionLocalService.class);

		ServiceTracker
			<UserRankPositionLocalService, UserRankPositionLocalService>
				serviceTracker =
					new ServiceTracker
						<UserRankPositionLocalService,
						 UserRankPositionLocalService>(
							 bundle.getBundleContext(),
							 UserRankPositionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}