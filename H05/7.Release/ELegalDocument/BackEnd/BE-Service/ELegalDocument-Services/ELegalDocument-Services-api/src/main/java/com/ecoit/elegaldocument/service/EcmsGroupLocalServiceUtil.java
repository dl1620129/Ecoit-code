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
 * Provides the local service utility for EcmsGroup. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.EcmsGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see EcmsGroupLocalService
 * @generated
 */
public class EcmsGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.EcmsGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ecms group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGroup the ecms group
	 * @return the ecms group that was added
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup addEcmsGroup(
		com.ecoit.elegaldocument.model.EcmsGroup ecmsGroup) {

		return getService().addEcmsGroup(ecmsGroup);
	}

	public static int countMemberInGroup(long groupUserId) {
		return getService().countMemberInGroup(groupUserId);
	}

	public static int countTotalGroup(long groupId, String name) {
		return getService().countTotalGroup(groupId, name);
	}

	/**
	 * Creates a new ecms group with the primary key. Does not add the ecms group to the database.
	 *
	 * @param groupUserId the primary key for the new ecms group
	 * @return the new ecms group
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup createEcmsGroup(
		long groupUserId) {

		return getService().createEcmsGroup(groupUserId);
	}

	public static void createUpdateEcmsgroup(
			long scopeGroupId, long groupUserId, String groupName,
			String description, String[] users, String[] permissions,
			String[] categories, String[] organizations, String[] fields)
		throws Exception {

		getService().createUpdateEcmsgroup(
			scopeGroupId, groupUserId, groupName, description, users,
			permissions, categories, organizations, fields);
	}

	/**
	 * Deletes the ecms group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGroup the ecms group
	 * @return the ecms group that was removed
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup deleteEcmsGroup(
		com.ecoit.elegaldocument.model.EcmsGroup ecmsGroup) {

		return getService().deleteEcmsGroup(ecmsGroup);
	}

	/**
	 * Deletes the ecms group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group that was removed
	 * @throws PortalException if a ecms group with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup deleteEcmsGroup(
			long groupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEcmsGroup(groupUserId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.EcmsGroup fetchEcmsGroup(
		long groupUserId) {

		return getService().fetchEcmsGroup(groupUserId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>
			findByGroupId(long groupId, int start, int end, String q)
		throws Exception {

		return getService().findByGroupId(groupId, start, end, q);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the ecms group with the primary key.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group
	 * @throws PortalException if a ecms group with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup getEcmsGroup(
			long groupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEcmsGroup(groupUserId);
	}

	/**
	 * Returns a range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @return the range of ecms groups
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>
		getEcmsGroups(int start, int end) {

		return getService().getEcmsGroups(start, end);
	}

	/**
	 * Returns the number of ecms groups.
	 *
	 * @return the number of ecms groups
	 */
	public static int getEcmsGroupsCount() {
		return getService().getEcmsGroupsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<Object> getListOfUser(long scopeGroupId)
		throws Exception {

		return getService().getListOfUser(scopeGroupId);
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

	public static void removeEcmsGroup(long groupUserId) throws Exception {
		getService().removeEcmsGroup(groupUserId);
	}

	/**
	 * Updates the ecms group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGroup the ecms group
	 * @return the ecms group that was updated
	 */
	public static com.ecoit.elegaldocument.model.EcmsGroup updateEcmsGroup(
		com.ecoit.elegaldocument.model.EcmsGroup ecmsGroup) {

		return getService().updateEcmsGroup(ecmsGroup);
	}

	public static EcmsGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EcmsGroupLocalService, EcmsGroupLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EcmsGroupLocalService.class);

		ServiceTracker<EcmsGroupLocalService, EcmsGroupLocalService>
			serviceTracker =
				new ServiceTracker
					<EcmsGroupLocalService, EcmsGroupLocalService>(
						bundle.getBundleContext(), EcmsGroupLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}