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
 * Provides a wrapper for {@link PermissionGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupLocalService
 * @generated
 */
public class PermissionGroupLocalServiceWrapper
	implements PermissionGroupLocalService,
			   ServiceWrapper<PermissionGroupLocalService> {

	public PermissionGroupLocalServiceWrapper(
		PermissionGroupLocalService permissionGroupLocalService) {

		_permissionGroupLocalService = permissionGroupLocalService;
	}

	/**
	 * Adds the permission group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroup the permission group
	 * @return the permission group that was added
	 */
	@Override
	public com.ecoit.mr.model.PermissionGroup addPermissionGroup(
		com.ecoit.mr.model.PermissionGroup permissionGroup) {

		return _permissionGroupLocalService.addPermissionGroup(permissionGroup);
	}

	@Override
	public boolean checkPermission(long userGroupId, int permission) {
		return _permissionGroupLocalService.checkPermission(
			userGroupId, permission);
	}

	/**
	 * Creates a new permission group with the primary key. Does not add the permission group to the database.
	 *
	 * @param permissionGroupPK the primary key for the new permission group
	 * @return the new permission group
	 */
	@Override
	public com.ecoit.mr.model.PermissionGroup createPermissionGroup(
		com.ecoit.mr.service.persistence.PermissionGroupPK permissionGroupPK) {

		return _permissionGroupLocalService.createPermissionGroup(
			permissionGroupPK);
	}

	@Override
	public void createPermissionGroupRel(long userGroupId, int permission) {
		_permissionGroupLocalService.createPermissionGroupRel(
			userGroupId, permission);
	}

	/**
	 * Deletes the permission group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroup the permission group
	 * @return the permission group that was removed
	 */
	@Override
	public com.ecoit.mr.model.PermissionGroup deletePermissionGroup(
		com.ecoit.mr.model.PermissionGroup permissionGroup) {

		return _permissionGroupLocalService.deletePermissionGroup(
			permissionGroup);
	}

	/**
	 * Deletes the permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group that was removed
	 * @throws PortalException if a permission group with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.PermissionGroup deletePermissionGroup(
			com.ecoit.mr.service.persistence.PermissionGroupPK
				permissionGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionGroupLocalService.deletePermissionGroup(
			permissionGroupPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionGroupLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permissionGroupLocalService.dynamicQuery();
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

		return _permissionGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.PermissionGroupModelImpl</code>.
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

		return _permissionGroupLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.PermissionGroupModelImpl</code>.
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

		return _permissionGroupLocalService.dynamicQuery(
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

		return _permissionGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _permissionGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.mr.model.PermissionGroup fetchPermissionGroup(
		com.ecoit.mr.service.persistence.PermissionGroupPK permissionGroupPK) {

		return _permissionGroupLocalService.fetchPermissionGroup(
			permissionGroupPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _permissionGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _permissionGroupLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.mr.model.PermissionGroup> getList(
			long groupId, String name, int start, int limit)
		throws Exception {

		return _permissionGroupLocalService.getList(
			groupId, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _permissionGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the permission group with the primary key.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group
	 * @throws PortalException if a permission group with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.PermissionGroup getPermissionGroup(
			com.ecoit.mr.service.persistence.PermissionGroupPK
				permissionGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionGroupLocalService.getPermissionGroup(
			permissionGroupPK);
	}

	/**
	 * Returns a range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of permission groups
	 */
	@Override
	public java.util.List<com.ecoit.mr.model.PermissionGroup>
		getPermissionGroups(int start, int end) {

		return _permissionGroupLocalService.getPermissionGroups(start, end);
	}

	/**
	 * Returns the number of permission groups.
	 *
	 * @return the number of permission groups
	 */
	@Override
	public int getPermissionGroupsCount() {
		return _permissionGroupLocalService.getPermissionGroupsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _permissionGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getTotal(long groupId, String name) throws Exception {
		return _permissionGroupLocalService.getTotal(groupId, name);
	}

	/**
	 * Updates the permission group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroup the permission group
	 * @return the permission group that was updated
	 */
	@Override
	public com.ecoit.mr.model.PermissionGroup updatePermissionGroup(
		com.ecoit.mr.model.PermissionGroup permissionGroup) {

		return _permissionGroupLocalService.updatePermissionGroup(
			permissionGroup);
	}

	@Override
	public PermissionGroupLocalService getWrappedService() {
		return _permissionGroupLocalService;
	}

	@Override
	public void setWrappedService(
		PermissionGroupLocalService permissionGroupLocalService) {

		_permissionGroupLocalService = permissionGroupLocalService;
	}

	private PermissionGroupLocalService _permissionGroupLocalService;

}