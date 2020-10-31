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

package com.ecoit.mr.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserPermissionGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPermissionGroupLocalService
 * @generated
 */
public class UserPermissionGroupLocalServiceWrapper
	implements ServiceWrapper<UserPermissionGroupLocalService>,
			   UserPermissionGroupLocalService {

	public UserPermissionGroupLocalServiceWrapper(
		UserPermissionGroupLocalService userPermissionGroupLocalService) {

		_userPermissionGroupLocalService = userPermissionGroupLocalService;
	}

	/**
	 * Adds the user permission group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroup the user permission group
	 * @return the user permission group that was added
	 */
	@Override
	public com.ecoit.mr.model.UserPermissionGroup addUserPermissionGroup(
		com.ecoit.mr.model.UserPermissionGroup userPermissionGroup) {

		return _userPermissionGroupLocalService.addUserPermissionGroup(
			userPermissionGroup);
	}

	@Override
	public void createUpdateGroupUser(
			long userId, long groupId, long groupUserId, String groupName,
			String description, String[] users, String[] permissions)
		throws Exception {

		_userPermissionGroupLocalService.createUpdateGroupUser(
			userId, groupId, groupUserId, groupName, description, users,
			permissions);
	}

	/**
	 * Creates a new user permission group with the primary key. Does not add the user permission group to the database.
	 *
	 * @param userPermissionGroupId the primary key for the new user permission group
	 * @return the new user permission group
	 */
	@Override
	public com.ecoit.mr.model.UserPermissionGroup createUserPermissionGroup(
		long userPermissionGroupId) {

		return _userPermissionGroupLocalService.createUserPermissionGroup(
			userPermissionGroupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPermissionGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group that was removed
	 * @throws PortalException if a user permission group with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.UserPermissionGroup deleteUserPermissionGroup(
			long userPermissionGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPermissionGroupLocalService.deleteUserPermissionGroup(
			userPermissionGroupId);
	}

	/**
	 * Deletes the user permission group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroup the user permission group
	 * @return the user permission group that was removed
	 */
	@Override
	public com.ecoit.mr.model.UserPermissionGroup deleteUserPermissionGroup(
		com.ecoit.mr.model.UserPermissionGroup userPermissionGroup) {

		return _userPermissionGroupLocalService.deleteUserPermissionGroup(
			userPermissionGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPermissionGroupLocalService.dynamicQuery();
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

		return _userPermissionGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserPermissionGroupModelImpl</code>.
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

		return _userPermissionGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserPermissionGroupModelImpl</code>.
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

		return _userPermissionGroupLocalService.dynamicQuery(
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

		return _userPermissionGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userPermissionGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.mr.model.UserPermissionGroup fetchUserPermissionGroup(
		long userPermissionGroupId) {

		return _userPermissionGroupLocalService.fetchUserPermissionGroup(
			userPermissionGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userPermissionGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userPermissionGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.mr.model.UserPermissionGroup> getList(
			long groupId, String name, int start, int limit)
		throws Exception {

		return _userPermissionGroupLocalService.getList(
			groupId, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPermissionGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPermissionGroupLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public int getTotal(long groupId, String name) throws Exception {
		return _userPermissionGroupLocalService.getTotal(groupId, name);
	}

	/**
	 * Returns the user permission group with the primary key.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group
	 * @throws PortalException if a user permission group with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.UserPermissionGroup getUserPermissionGroup(
			long userPermissionGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPermissionGroupLocalService.getUserPermissionGroup(
			userPermissionGroupId);
	}

	/**
	 * Returns a range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @return the range of user permission groups
	 */
	@Override
	public java.util.List<com.ecoit.mr.model.UserPermissionGroup>
		getUserPermissionGroups(int start, int end) {

		return _userPermissionGroupLocalService.getUserPermissionGroups(
			start, end);
	}

	/**
	 * Returns the number of user permission groups.
	 *
	 * @return the number of user permission groups
	 */
	@Override
	public int getUserPermissionGroupsCount() {
		return _userPermissionGroupLocalService.getUserPermissionGroupsCount();
	}

	/**
	 * Updates the user permission group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroup the user permission group
	 * @return the user permission group that was updated
	 */
	@Override
	public com.ecoit.mr.model.UserPermissionGroup updateUserPermissionGroup(
		com.ecoit.mr.model.UserPermissionGroup userPermissionGroup) {

		return _userPermissionGroupLocalService.updateUserPermissionGroup(
			userPermissionGroup);
	}

	@Override
	public UserPermissionGroupLocalService getWrappedService() {
		return _userPermissionGroupLocalService;
	}

	@Override
	public void setWrappedService(
		UserPermissionGroupLocalService userPermissionGroupLocalService) {

		_userPermissionGroupLocalService = userPermissionGroupLocalService;
	}

	private UserPermissionGroupLocalService _userPermissionGroupLocalService;

}