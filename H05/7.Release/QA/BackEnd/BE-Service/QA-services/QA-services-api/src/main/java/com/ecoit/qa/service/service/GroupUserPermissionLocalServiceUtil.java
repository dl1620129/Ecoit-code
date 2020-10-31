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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroupUserPermission. This utility wraps
 * <code>com.ecoit.qa.service.service.impl.GroupUserPermissionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserPermissionLocalService
 * @generated
 */
public class GroupUserPermissionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.qa.service.service.impl.GroupUserPermissionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group user permission to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermission the group user permission
	 * @return the group user permission that was added
	 */
	public static com.ecoit.qa.service.model.GroupUserPermission
		addGroupUserPermission(
			com.ecoit.qa.service.model.GroupUserPermission
				groupUserPermission) {

		return getService().addGroupUserPermission(groupUserPermission);
	}

	public static boolean checkPermission(long groupUserId, long permissionId) {
		return getService().checkPermission(groupUserId, permissionId);
	}

	/**
	 * Creates a new group user permission with the primary key. Does not add the group user permission to the database.
	 *
	 * @param groupUserPermissionPK the primary key for the new group user permission
	 * @return the new group user permission
	 */
	public static com.ecoit.qa.service.model.GroupUserPermission
		createGroupUserPermission(
			com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
				groupUserPermissionPK) {

		return getService().createGroupUserPermission(groupUserPermissionPK);
	}

	public static void createGroupUserPermission(
			long groupUserId, long permissionId)
		throws Exception {

		getService().createGroupUserPermission(groupUserId, permissionId);
	}

	/**
	 * Deletes the group user permission from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermission the group user permission
	 * @return the group user permission that was removed
	 */
	public static com.ecoit.qa.service.model.GroupUserPermission
		deleteGroupUserPermission(
			com.ecoit.qa.service.model.GroupUserPermission
				groupUserPermission) {

		return getService().deleteGroupUserPermission(groupUserPermission);
	}

	/**
	 * Deletes the group user permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission that was removed
	 * @throws PortalException if a group user permission with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserPermission
			deleteGroupUserPermission(
				com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
					groupUserPermissionPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupUserPermission(groupUserPermissionPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserPermissionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserPermissionModelImpl</code>.
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

	public static com.ecoit.qa.service.model.GroupUserPermission
		fetchGroupUserPermission(
			com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
				groupUserPermissionPK) {

		return getService().fetchGroupUserPermission(groupUserPermissionPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the group user permission with the primary key.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission
	 * @throws PortalException if a group user permission with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserPermission
			getGroupUserPermission(
				com.ecoit.qa.service.service.persistence.GroupUserPermissionPK
					groupUserPermissionPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupUserPermission(groupUserPermissionPK);
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
	public static java.util.List<com.ecoit.qa.service.model.GroupUserPermission>
		getGroupUserPermissions(int start, int end) {

		return getService().getGroupUserPermissions(start, end);
	}

	/**
	 * Returns the number of group user permissions.
	 *
	 * @return the number of group user permissions
	 */
	public static int getGroupUserPermissionsCount() {
		return getService().getGroupUserPermissionsCount();
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

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the group user permission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermission the group user permission
	 * @return the group user permission that was updated
	 */
	public static com.ecoit.qa.service.model.GroupUserPermission
		updateGroupUserPermission(
			com.ecoit.qa.service.model.GroupUserPermission
				groupUserPermission) {

		return getService().updateGroupUserPermission(groupUserPermission);
	}

	public static GroupUserPermissionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserPermissionLocalService, GroupUserPermissionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserPermissionLocalService.class);

		ServiceTracker
			<GroupUserPermissionLocalService, GroupUserPermissionLocalService>
				serviceTracker =
					new ServiceTracker
						<GroupUserPermissionLocalService,
						 GroupUserPermissionLocalService>(
							 bundle.getBundleContext(),
							 GroupUserPermissionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}