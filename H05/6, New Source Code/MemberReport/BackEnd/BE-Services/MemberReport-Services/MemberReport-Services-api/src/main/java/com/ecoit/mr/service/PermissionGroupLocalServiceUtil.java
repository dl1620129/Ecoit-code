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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PermissionGroup. This utility wraps
 * <code>com.ecoit.mr.service.impl.PermissionGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionGroupLocalService
 * @generated
 */
public class PermissionGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.mr.service.impl.PermissionGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the permission group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroup the permission group
	 * @return the permission group that was added
	 */
	public static com.ecoit.mr.model.PermissionGroup addPermissionGroup(
		com.ecoit.mr.model.PermissionGroup permissionGroup) {

		return getService().addPermissionGroup(permissionGroup);
	}

	public static boolean checkPermission(long userGroupId, int permission) {
		return getService().checkPermission(userGroupId, permission);
	}

	/**
	 * Creates a new permission group with the primary key. Does not add the permission group to the database.
	 *
	 * @param permissionGroupPK the primary key for the new permission group
	 * @return the new permission group
	 */
	public static com.ecoit.mr.model.PermissionGroup createPermissionGroup(
		com.ecoit.mr.service.persistence.PermissionGroupPK permissionGroupPK) {

		return getService().createPermissionGroup(permissionGroupPK);
	}

	public static void createPermissionGroupRel(
		long userGroupId, int permission) {

		getService().createPermissionGroupRel(userGroupId, permission);
	}

	/**
	 * Deletes the permission group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroup the permission group
	 * @return the permission group that was removed
	 */
	public static com.ecoit.mr.model.PermissionGroup deletePermissionGroup(
		com.ecoit.mr.model.PermissionGroup permissionGroup) {

		return getService().deletePermissionGroup(permissionGroup);
	}

	/**
	 * Deletes the permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group that was removed
	 * @throws PortalException if a permission group with the primary key could not be found
	 */
	public static com.ecoit.mr.model.PermissionGroup deletePermissionGroup(
			com.ecoit.mr.service.persistence.PermissionGroupPK
				permissionGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePermissionGroup(permissionGroupPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.PermissionGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.PermissionGroupModelImpl</code>.
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

	public static com.ecoit.mr.model.PermissionGroup fetchPermissionGroup(
		com.ecoit.mr.service.persistence.PermissionGroupPK permissionGroupPK) {

		return getService().fetchPermissionGroup(permissionGroupPK);
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

	public static java.util.List<com.ecoit.mr.model.PermissionGroup> getList(
			long groupId, String name, int start, int limit)
		throws Exception {

		return getService().getList(groupId, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the permission group with the primary key.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group
	 * @throws PortalException if a permission group with the primary key could not be found
	 */
	public static com.ecoit.mr.model.PermissionGroup getPermissionGroup(
			com.ecoit.mr.service.persistence.PermissionGroupPK
				permissionGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPermissionGroup(permissionGroupPK);
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
	public static java.util.List<com.ecoit.mr.model.PermissionGroup>
		getPermissionGroups(int start, int end) {

		return getService().getPermissionGroups(start, end);
	}

	/**
	 * Returns the number of permission groups.
	 *
	 * @return the number of permission groups
	 */
	public static int getPermissionGroupsCount() {
		return getService().getPermissionGroupsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int getTotal(long groupId, String name) throws Exception {
		return getService().getTotal(groupId, name);
	}

	/**
	 * Updates the permission group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroup the permission group
	 * @return the permission group that was updated
	 */
	public static com.ecoit.mr.model.PermissionGroup updatePermissionGroup(
		com.ecoit.mr.model.PermissionGroup permissionGroup) {

		return getService().updatePermissionGroup(permissionGroup);
	}

	public static PermissionGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PermissionGroupLocalService, PermissionGroupLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PermissionGroupLocalService.class);

		ServiceTracker<PermissionGroupLocalService, PermissionGroupLocalService>
			serviceTracker =
				new ServiceTracker
					<PermissionGroupLocalService, PermissionGroupLocalService>(
						bundle.getBundleContext(),
						PermissionGroupLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}