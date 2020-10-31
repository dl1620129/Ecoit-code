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

package com.software.cms.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroupUser. This utility wraps
 * <code>com.software.cms.service.impl.GroupUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see GroupUserLocalService
 * @generated
 */
public class GroupUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.GroupUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUser the group user
	 * @return the group user that was added
	 */
	public static com.software.cms.model.GroupUser addGroupUser(
		com.software.cms.model.GroupUser groupUser) {

		return getService().addGroupUser(groupUser);
	}

	public static com.software.cms.model.GroupUser addGroupUser(
		String name, String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addGroupUser(name, description, serviceContext);
	}

	public static int countByGroup_Language(
		long groupId, String language, String q) {

		return getService().countByGroup_Language(groupId, language, q);
	}

	public static int countMemberInGroup(long groupId, long groupUserId) {
		return getService().countMemberInGroup(groupId, groupUserId);
	}

	public static com.software.cms.model.GroupUser create() {
		return getService().create();
	}

	/**
	 * Creates a new group user with the primary key. Does not add the group user to the database.
	 *
	 * @param groupUserId the primary key for the new group user
	 * @return the new group user
	 */
	public static com.software.cms.model.GroupUser createGroupUser(
		long groupUserId) {

		return getService().createGroupUser(groupUserId);
	}

	/**
	 * Deletes the group user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUser the group user
	 * @return the group user that was removed
	 */
	public static com.software.cms.model.GroupUser deleteGroupUser(
		com.software.cms.model.GroupUser groupUser) {

		return getService().deleteGroupUser(groupUser);
	}

	/**
	 * Deletes the group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user that was removed
	 * @throws PortalException if a group user with the primary key could not be found
	 */
	public static com.software.cms.model.GroupUser deleteGroupUser(
			long groupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupUser(groupUserId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupUserModelImpl</code>.
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

	public static com.software.cms.model.GroupUser fetchGroupUser(
		long groupUserId) {

		return getService().fetchGroupUser(groupUserId);
	}

	public static java.util.List<com.software.cms.model.GroupUser>
		findByGroup_Language(long groupId, String language) {

		return getService().findByGroup_Language(groupId, language);
	}

	public static java.util.List<com.software.cms.model.GroupUser>
			findByGroup_Language(
				long groupId, String language, int start, int end, String q)
		throws Exception {

		return getService().findByGroup_Language(
			groupId, language, start, end, q);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the group user with the primary key.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user
	 * @throws PortalException if a group user with the primary key could not be found
	 */
	public static com.software.cms.model.GroupUser getGroupUser(
			long groupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupUser(groupUserId);
	}

	/**
	 * Returns a range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @return the range of group users
	 */
	public static java.util.List<com.software.cms.model.GroupUser>
		getGroupUsers(int start, int end) {

		return getService().getGroupUsers(start, end);
	}

	/**
	 * Returns the number of group users.
	 *
	 * @return the number of group users
	 */
	public static int getGroupUsersCount() {
		return getService().getGroupUsersCount();
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

	public static java.util.List<Object[]> getUserByNameGroup(
			String screenname, long groupId, String language)
		throws Exception {

		return getService().getUserByNameGroup(screenname, groupId, language);
	}

	/**
	 * Updates the group user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUser the group user
	 * @return the group user that was updated
	 */
	public static com.software.cms.model.GroupUser updateGroupUser(
		com.software.cms.model.GroupUser groupUser) {

		return getService().updateGroupUser(groupUser);
	}

	public static GroupUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroupUserLocalService, GroupUserLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupUserLocalService.class);

		ServiceTracker<GroupUserLocalService, GroupUserLocalService>
			serviceTracker =
				new ServiceTracker
					<GroupUserLocalService, GroupUserLocalService>(
						bundle.getBundleContext(), GroupUserLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}