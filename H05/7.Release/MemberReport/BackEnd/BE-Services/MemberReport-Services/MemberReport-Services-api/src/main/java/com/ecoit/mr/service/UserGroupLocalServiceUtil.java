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
 * Provides the local service utility for UserGroup. This utility wraps
 * <code>com.ecoit.mr.service.impl.UserGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupLocalService
 * @generated
 */
public class UserGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.mr.service.impl.UserGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroup the user group
	 * @return the user group that was added
	 */
	public static com.ecoit.mr.model.UserGroup addUserGroup(
		com.ecoit.mr.model.UserGroup userGroup) {

		return getService().addUserGroup(userGroup);
	}

	public static int countMemberInGroup(long userpermissiongroupid)
		throws Exception {

		return getService().countMemberInGroup(userpermissiongroupid);
	}

	public static void createUserGroup(long userGroupId, long userId) {
		getService().createUserGroup(userGroupId, userId);
	}

	/**
	 * Creates a new user group with the primary key. Does not add the user group to the database.
	 *
	 * @param userGroupPK the primary key for the new user group
	 * @return the new user group
	 */
	public static com.ecoit.mr.model.UserGroup createUserGroup(
		com.ecoit.mr.service.persistence.UserGroupPK userGroupPK) {

		return getService().createUserGroup(userGroupPK);
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
	 * Deletes the user group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroup the user group
	 * @return the user group that was removed
	 */
	public static com.ecoit.mr.model.UserGroup deleteUserGroup(
		com.ecoit.mr.model.UserGroup userGroup) {

		return getService().deleteUserGroup(userGroup);
	}

	/**
	 * Deletes the user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group that was removed
	 * @throws PortalException if a user group with the primary key could not be found
	 */
	public static com.ecoit.mr.model.UserGroup deleteUserGroup(
			com.ecoit.mr.service.persistence.UserGroupPK userGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserGroup(userGroupPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserGroupModelImpl</code>.
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

	public static com.ecoit.mr.model.UserGroup fetchUserGroup(
		com.ecoit.mr.service.persistence.UserGroupPK userGroupPK) {

		return getService().fetchUserGroup(userGroupPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.mr.model.UserGroup> getByUserId(
		long userId) {

		return getService().getByUserId(userId);
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
	 * Returns the user group with the primary key.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group
	 * @throws PortalException if a user group with the primary key could not be found
	 */
	public static com.ecoit.mr.model.UserGroup getUserGroup(
			com.ecoit.mr.service.persistence.UserGroupPK userGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserGroup(userGroupPK);
	}

	/**
	 * Returns a range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of user groups
	 */
	public static java.util.List<com.ecoit.mr.model.UserGroup> getUserGroups(
		int start, int end) {

		return getService().getUserGroups(start, end);
	}

	/**
	 * Returns the number of user groups.
	 *
	 * @return the number of user groups
	 */
	public static int getUserGroupsCount() {
		return getService().getUserGroupsCount();
	}

	public static boolean isContain(long groupUserId, long userId) {
		return getService().isContain(groupUserId, userId);
	}

	/**
	 * Updates the user group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userGroup the user group
	 * @return the user group that was updated
	 */
	public static com.ecoit.mr.model.UserGroup updateUserGroup(
		com.ecoit.mr.model.UserGroup userGroup) {

		return getService().updateUserGroup(userGroup);
	}

	public static UserGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserGroupLocalService, UserGroupLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserGroupLocalService.class);

		ServiceTracker<UserGroupLocalService, UserGroupLocalService>
			serviceTracker =
				new ServiceTracker
					<UserGroupLocalService, UserGroupLocalService>(
						bundle.getBundleContext(), UserGroupLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}