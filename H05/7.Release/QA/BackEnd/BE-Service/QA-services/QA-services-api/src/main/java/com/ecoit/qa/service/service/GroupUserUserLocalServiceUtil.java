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
 * Provides the local service utility for GroupUserUser. This utility wraps
 * <code>com.ecoit.qa.service.service.impl.GroupUserUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserUserLocalService
 * @generated
 */
public class GroupUserUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.qa.service.service.impl.GroupUserUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group user user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUser the group user user
	 * @return the group user user that was added
	 */
	public static com.ecoit.qa.service.model.GroupUserUser addGroupUserUser(
		com.ecoit.qa.service.model.GroupUserUser groupUserUser) {

		return getService().addGroupUserUser(groupUserUser);
	}

	/**
	 * Creates a new group user user with the primary key. Does not add the group user user to the database.
	 *
	 * @param groupUserUserPK the primary key for the new group user user
	 * @return the new group user user
	 */
	public static com.ecoit.qa.service.model.GroupUserUser createGroupUserUser(
		com.ecoit.qa.service.service.persistence.GroupUserUserPK
			groupUserUserPK) {

		return getService().createGroupUserUser(groupUserUserPK);
	}

	public static void createGroupUserUser(long groupUserId, long userId)
		throws Exception {

		getService().createGroupUserUser(groupUserId, userId);
	}

	/**
	 * Deletes the group user user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUser the group user user
	 * @return the group user user that was removed
	 */
	public static com.ecoit.qa.service.model.GroupUserUser deleteGroupUserUser(
		com.ecoit.qa.service.model.GroupUserUser groupUserUser) {

		return getService().deleteGroupUserUser(groupUserUser);
	}

	/**
	 * Deletes the group user user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user that was removed
	 * @throws PortalException if a group user user with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserUser deleteGroupUserUser(
			com.ecoit.qa.service.service.persistence.GroupUserUserPK
				groupUserUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupUserUser(groupUserUserPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserUserModelImpl</code>.
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

	public static com.ecoit.qa.service.model.GroupUserUser fetchGroupUserUser(
		com.ecoit.qa.service.service.persistence.GroupUserUserPK
			groupUserUserPK) {

		return getService().fetchGroupUserUser(groupUserUserPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the group user user with the primary key.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user
	 * @throws PortalException if a group user user with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserUser getGroupUserUser(
			com.ecoit.qa.service.service.persistence.GroupUserUserPK
				groupUserUserPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupUserUser(groupUserUserPK);
	}

	/**
	 * Returns a range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of group user users
	 */
	public static java.util.List<com.ecoit.qa.service.model.GroupUserUser>
		getGroupUserUsers(int start, int end) {

		return getService().getGroupUserUsers(start, end);
	}

	/**
	 * Returns the number of group user users.
	 *
	 * @return the number of group user users
	 */
	public static int getGroupUserUsersCount() {
		return getService().getGroupUserUsersCount();
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

	public static int getUserCount(long groupUserId) throws Exception {
		return getService().getUserCount(groupUserId);
	}

	public static boolean hasUser(long groupUserId, long userId) {
		return getService().hasUser(groupUserId, userId);
	}

	public static java.util.List<com.ecoit.qa.service.model.GroupUserUser>
			searchByUserId(long userId)
		throws Exception {

		return getService().searchByUserId(userId);
	}

	/**
	 * Updates the group user user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUser the group user user
	 * @return the group user user that was updated
	 */
	public static com.ecoit.qa.service.model.GroupUserUser updateGroupUserUser(
		com.ecoit.qa.service.model.GroupUserUser groupUserUser) {

		return getService().updateGroupUserUser(groupUserUser);
	}

	public static GroupUserUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserUserLocalService, GroupUserUserLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserUserLocalService.class);

		ServiceTracker<GroupUserUserLocalService, GroupUserUserLocalService>
			serviceTracker =
				new ServiceTracker
					<GroupUserUserLocalService, GroupUserUserLocalService>(
						bundle.getBundleContext(),
						GroupUserUserLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}