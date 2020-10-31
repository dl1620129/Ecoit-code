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

package com.ecoit.elegaldocument.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroupOrganization. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.GroupOrganizationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see GroupOrganizationLocalService
 * @generated
 */
public class GroupOrganizationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.GroupOrganizationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group organization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganization the group organization
	 * @return the group organization that was added
	 */
	public static com.ecoit.elegaldocument.model.GroupOrganization
		addGroupOrganization(
			com.ecoit.elegaldocument.model.GroupOrganization
				groupOrganization) {

		return getService().addGroupOrganization(groupOrganization);
	}

	public static void addGroupOrganization(
		long groupUserId, long OrganizationId) {

		getService().addGroupOrganization(groupUserId, OrganizationId);
	}

	/**
	 * Creates a new group organization with the primary key. Does not add the group organization to the database.
	 *
	 * @param groupOrganizationPK the primary key for the new group organization
	 * @return the new group organization
	 */
	public static com.ecoit.elegaldocument.model.GroupOrganization
		createGroupOrganization(
			com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
				groupOrganizationPK) {

		return getService().createGroupOrganization(groupOrganizationPK);
	}

	/**
	 * Deletes the group organization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganization the group organization
	 * @return the group organization that was removed
	 */
	public static com.ecoit.elegaldocument.model.GroupOrganization
		deleteGroupOrganization(
			com.ecoit.elegaldocument.model.GroupOrganization
				groupOrganization) {

		return getService().deleteGroupOrganization(groupOrganization);
	}

	/**
	 * Deletes the group organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization that was removed
	 * @throws PortalException if a group organization with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.GroupOrganization
			deleteGroupOrganization(
				com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
					groupOrganizationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupOrganization(groupOrganizationPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.GroupOrganization
		fetchGroupOrganization(
			com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
				groupOrganizationPK) {

		return getService().fetchGroupOrganization(groupOrganizationPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.ecoit.elegaldocument.model.GroupOrganization> getByOrganization(
			long OrganizationId) {

		return getService().getByOrganization(OrganizationId);
	}

	public static java.util.List
		<com.ecoit.elegaldocument.model.GroupOrganization>
			getByUserIdAndGroupId(long userId, long groupId) {

		return getService().getByUserIdAndGroupId(userId, groupId);
	}

	public static java.util.List
		<com.ecoit.elegaldocument.model.GroupOrganization>
			getByUserIdAndGroupIdAndGroupUserId(
				long userId, long groupId, long groupUserId) {

		return getService().getByUserIdAndGroupIdAndGroupUserId(
			userId, groupId, groupUserId);
	}

	/**
	 * Returns the group organization with the primary key.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization
	 * @throws PortalException if a group organization with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.GroupOrganization
			getGroupOrganization(
				com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
					groupOrganizationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupOrganization(groupOrganizationPK);
	}

	/**
	 * Returns a range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of group organizations
	 */
	public static java.util.List
		<com.ecoit.elegaldocument.model.GroupOrganization>
			getGroupOrganizations(int start, int end) {

		return getService().getGroupOrganizations(start, end);
	}

	/**
	 * Returns the number of group organizations.
	 *
	 * @return the number of group organizations
	 */
	public static int getGroupOrganizationsCount() {
		return getService().getGroupOrganizationsCount();
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

	public static boolean hasGroupOrganization(
		long groupUserId, long OrganizationId) {

		return getService().hasGroupOrganization(groupUserId, OrganizationId);
	}

	public static boolean hasUserAccessOrganization(
		long userId, long OrganizationId) {

		return getService().hasUserAccessOrganization(userId, OrganizationId);
	}

	public static void removeByGroupUserId(long groupUserId) {
		getService().removeByGroupUserId(groupUserId);
	}

	public static void removeByOrganizationId(long OrganizationId) {
		getService().removeByOrganizationId(OrganizationId);
	}

	/**
	 * Updates the group organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganization the group organization
	 * @return the group organization that was updated
	 */
	public static com.ecoit.elegaldocument.model.GroupOrganization
		updateGroupOrganization(
			com.ecoit.elegaldocument.model.GroupOrganization
				groupOrganization) {

		return getService().updateGroupOrganization(groupOrganization);
	}

	public static GroupOrganizationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupOrganizationLocalService, GroupOrganizationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupOrganizationLocalService.class);

		ServiceTracker
			<GroupOrganizationLocalService, GroupOrganizationLocalService>
				serviceTracker =
					new ServiceTracker
						<GroupOrganizationLocalService,
						 GroupOrganizationLocalService>(
							 bundle.getBundleContext(),
							 GroupOrganizationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}