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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link UserRankPositionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRankPositionLocalService
 * @generated
 */
@ProviderType
public class UserRankPositionLocalServiceWrapper
	implements UserRankPositionLocalService,
			   ServiceWrapper<UserRankPositionLocalService> {

	public UserRankPositionLocalServiceWrapper(
		UserRankPositionLocalService userRankPositionLocalService) {

		_userRankPositionLocalService = userRankPositionLocalService;
	}

	/**
	 * Adds the user rank position to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankPosition the user rank position
	 * @return the user rank position that was added
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
		addUserRankPosition(
			User.Rank.Poisition.Service.model.UserRankPosition
				userRankPosition) {

		return _userRankPositionLocalService.addUserRankPosition(
			userRankPosition);
	}

	/**
	 * Creates a new user rank position with the primary key. Does not add the user rank position to the database.
	 *
	 * @param userId the primary key for the new user rank position
	 * @return the new user rank position
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
		createUserRankPosition(long userId) {

		return _userRankPositionLocalService.createUserRankPosition(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankPositionLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user rank position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position that was removed
	 * @throws PortalException if a user rank position with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
			deleteUserRankPosition(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankPositionLocalService.deleteUserRankPosition(userId);
	}

	/**
	 * Deletes the user rank position from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankPosition the user rank position
	 * @return the user rank position that was removed
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
		deleteUserRankPosition(
			User.Rank.Poisition.Service.model.UserRankPosition
				userRankPosition) {

		return _userRankPositionLocalService.deleteUserRankPosition(
			userRankPosition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRankPositionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userRankPositionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userRankPositionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userRankPositionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userRankPositionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userRankPositionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
		fetchUserRankPosition(long userId) {

		return _userRankPositionLocalService.fetchUserRankPosition(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRankPositionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRankPositionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRankPositionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankPositionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user rank position with the primary key.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position
	 * @throws PortalException if a user rank position with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
			getUserRankPosition(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankPositionLocalService.getUserRankPosition(userId);
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
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserRankPosition>
		getUserRankPositions(int start, int end) {

		return _userRankPositionLocalService.getUserRankPositions(start, end);
	}

	/**
	 * Returns the number of user rank positions.
	 *
	 * @return the number of user rank positions
	 */
	@Override
	public int getUserRankPositionsCount() {
		return _userRankPositionLocalService.getUserRankPositionsCount();
	}

	/**
	 * Updates the user rank position in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userRankPosition the user rank position
	 * @return the user rank position that was updated
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRankPosition
		updateUserRankPosition(
			User.Rank.Poisition.Service.model.UserRankPosition
				userRankPosition) {

		return _userRankPositionLocalService.updateUserRankPosition(
			userRankPosition);
	}

	@Override
	public UserRankPositionLocalService getWrappedService() {
		return _userRankPositionLocalService;
	}

	@Override
	public void setWrappedService(
		UserRankPositionLocalService userRankPositionLocalService) {

		_userRankPositionLocalService = userRankPositionLocalService;
	}

	private UserRankPositionLocalService _userRankPositionLocalService;

}