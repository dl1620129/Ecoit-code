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
 * Provides the local service utility for GroupUserUsers. This utility wraps
 * <code>com.ecoit.qa.service.service.impl.GroupUserUsersLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUsersLocalService
 * @generated
 */
public class GroupUserUsersLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.qa.service.service.impl.GroupUserUsersLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group user users to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsers the group user users
	 * @return the group user users that was added
	 */
	public static com.ecoit.qa.service.model.GroupUserUsers addGroupUserUsers(
		com.ecoit.qa.service.model.GroupUserUsers groupUserUsers) {

		return getService().addGroupUserUsers(groupUserUsers);
	}

	/**
	 * Creates a new group user users with the primary key. Does not add the group user users to the database.
	 *
	 * @param groupUserUsersPK the primary key for the new group user users
	 * @return the new group user users
	 */
	public static com.ecoit.qa.service.model.GroupUserUsers
		createGroupUserUsers(
			com.ecoit.qa.service.service.persistence.GroupUserUsersPK
				groupUserUsersPK) {

		return getService().createGroupUserUsers(groupUserUsersPK);
	}

	/**
	 * Deletes the group user users from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsers the group user users
	 * @return the group user users that was removed
	 */
	public static com.ecoit.qa.service.model.GroupUserUsers
		deleteGroupUserUsers(
			com.ecoit.qa.service.model.GroupUserUsers groupUserUsers) {

		return getService().deleteGroupUserUsers(groupUserUsers);
	}

	/**
	 * Deletes the group user users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users that was removed
	 * @throws PortalException if a group user users with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserUsers
			deleteGroupUserUsers(
				com.ecoit.qa.service.service.persistence.GroupUserUsersPK
					groupUserUsersPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupUserUsers(groupUserUsersPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserUsersModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserUsersModelImpl</code>.
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

	public static com.ecoit.qa.service.model.GroupUserUsers fetchGroupUserUsers(
		com.ecoit.qa.service.service.persistence.GroupUserUsersPK
			groupUserUsersPK) {

		return getService().fetchGroupUserUsers(groupUserUsersPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the group user users with the primary key.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users
	 * @throws PortalException if a group user users with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserUsers getGroupUserUsers(
			com.ecoit.qa.service.service.persistence.GroupUserUsersPK
				groupUserUsersPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupUserUsers(groupUserUsersPK);
	}

	/**
	 * Returns a range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of group user userses
	 */
	public static java.util.List<com.ecoit.qa.service.model.GroupUserUsers>
		getGroupUserUserses(int start, int end) {

		return getService().getGroupUserUserses(start, end);
	}

	/**
	 * Returns the number of group user userses.
	 *
	 * @return the number of group user userses
	 */
	public static int getGroupUserUsersesCount() {
		return getService().getGroupUserUsersesCount();
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
	 * Updates the group user users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsers the group user users
	 * @return the group user users that was updated
	 */
	public static com.ecoit.qa.service.model.GroupUserUsers
		updateGroupUserUsers(
			com.ecoit.qa.service.model.GroupUserUsers groupUserUsers) {

		return getService().updateGroupUserUsers(groupUserUsers);
	}

	public static GroupUserUsersLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserUsersLocalService, GroupUserUsersLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserUsersLocalService.class);

		ServiceTracker<GroupUserUsersLocalService, GroupUserUsersLocalService>
			serviceTracker =
				new ServiceTracker
					<GroupUserUsersLocalService, GroupUserUsersLocalService>(
						bundle.getBundleContext(),
						GroupUserUsersLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}