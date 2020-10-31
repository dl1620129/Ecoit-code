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

package com.ecoit.qa.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupUserPermissionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserPermissionLocalService
 * @generated
 */
public class GroupUserPermissionLocalServiceWrapper
	implements GroupUserPermissionLocalService,
			   ServiceWrapper<GroupUserPermissionLocalService> {

	public GroupUserPermissionLocalServiceWrapper(
		GroupUserPermissionLocalService groupUserPermissionLocalService) {

		_groupUserPermissionLocalService = groupUserPermissionLocalService;
	}

	/**
	 * Adds the group user permission to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermission the group user permission
	 * @return the group user permission that was added
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
		addGroupUserPermission(
			com.ecoit.qa.service.model.GroupUserPermission
				groupUserPermission) {

		return _groupUserPermissionLocalService.addGroupUserPermission(
			groupUserPermission);
	}

	@Override
	public boolean checkPermission(long groupUserId, long permissionId) {
		return _groupUserPermissionLocalService.checkPermission(
			groupUserId, permissionId);
	}

	/**
	 * Creates a new group user permission with the primary key. Does not add the group user permission to the database.
	 *
	 * @param groupUserPermissionPK the primary key for the new group user permission
	 * @return the new group user permission
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
		createGroupUserPermission(
			com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
				groupUserPermissionPK) {

		return _groupUserPermissionLocalService.createGroupUserPermission(
			groupUserPermissionPK);
	}

	@Override
	public void createGroupUserPermission(long groupUserId, long permissionId)
		throws Exception {

		_groupUserPermissionLocalService.createGroupUserPermission(
			groupUserId, permissionId);
	}

	/**
	 * Deletes the group user permission from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermission the group user permission
	 * @return the group user permission that was removed
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
		deleteGroupUserPermission(
			com.ecoit.qa.service.model.GroupUserPermission
				groupUserPermission) {

		return _groupUserPermissionLocalService.deleteGroupUserPermission(
			groupUserPermission);
	}

	/**
	 * Deletes the group user permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission that was removed
	 * @throws PortalException if a group user permission with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
			deleteGroupUserPermission(
				com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
					groupUserPermissionPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserPermissionLocalService.deleteGroupUserPermission(
			groupUserPermissionPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserPermissionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupUserPermissionLocalService.dynamicQuery();
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

		return _groupUserPermissionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserPermissionModelImpl</code>.
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

		return _groupUserPermissionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserPermissionModelImpl</code>.
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

		return _groupUserPermissionLocalService.dynamicQuery(
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

		return _groupUserPermissionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupUserPermissionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
		fetchGroupUserPermission(
			com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
				groupUserPermissionPK) {

		return _groupUserPermissionLocalService.fetchGroupUserPermission(
			groupUserPermissionPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupUserPermissionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the group user permission with the primary key.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission
	 * @throws PortalException if a group user permission with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
			getGroupUserPermission(
				com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
					groupUserPermissionPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserPermissionLocalService.getGroupUserPermission(
			groupUserPermissionPK);
	}

	/**
	 * Returns a range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of group user permissions
	 */
	@Override
	public java.util.List<com.ecoit.qa.service.model.GroupUserPermission>
		getGroupUserPermissions(int start, int end) {

		return _groupUserPermissionLocalService.getGroupUserPermissions(
			start, end);
	}

	/**
	 * Returns the number of group user permissions.
	 *
	 * @return the number of group user permissions
	 */
	@Override
	public int getGroupUserPermissionsCount() {
		return _groupUserPermissionLocalService.getGroupUserPermissionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupUserPermissionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupUserPermissionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserPermissionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the group user permission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermission the group user permission
	 * @return the group user permission that was updated
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserPermission
		updateGroupUserPermission(
			com.ecoit.qa.service.model.GroupUserPermission
				groupUserPermission) {

		return _groupUserPermissionLocalService.updateGroupUserPermission(
			groupUserPermission);
	}

	@Override
	public GroupUserPermissionLocalService getWrappedService() {
		return _groupUserPermissionLocalService;
	}

	@Override
	public void setWrappedService(
		GroupUserPermissionLocalService groupUserPermissionLocalService) {

		_groupUserPermissionLocalService = groupUserPermissionLocalService;
	}

	private GroupUserPermissionLocalService _groupUserPermissionLocalService;

}