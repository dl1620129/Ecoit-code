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

package organizationalStructure.service.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for organizations. This utility wraps
 * <code>organizationalStructure.service.service.impl.organizationsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see organizationsLocalService
 * @generated
 */
@ProviderType
public class organizationsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>organizationalStructure.service.service.impl.organizationsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the organizations to the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizations the organizations
	 * @return the organizations that was added
	 */
	public static organizationalStructure.service.model.organizations
		addorganizations(
			organizationalStructure.service.model.organizations organizations) {

		return getService().addorganizations(organizations);
	}

	/**
	 * Creates a new organizations with the primary key. Does not add the organizations to the database.
	 *
	 * @param organizationId the primary key for the new organizations
	 * @return the new organizations
	 */
	public static organizationalStructure.service.model.organizations
		createorganizations(long organizationId) {

		return getService().createorganizations(organizationId);
	}

	/**
	 * Deletes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations that was removed
	 * @throws PortalException if a organizations with the primary key could not be found
	 */
	public static organizationalStructure.service.model.organizations
			deleteorganizations(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteorganizations(organizationId);
	}

	/**
	 * Deletes the organizations from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizations the organizations
	 * @return the organizations that was removed
	 */
	public static organizationalStructure.service.model.organizations
		deleteorganizations(
			organizationalStructure.service.model.organizations organizations) {

		return getService().deleteorganizations(organizations);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static organizationalStructure.service.model.organizations
		fetchorganizations(long organizationId) {

		return getService().fetchorganizations(organizationId);
	}

	/**
	 * Returns the organizations matching the UUID and group.
	 *
	 * @param uuid the organizations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	public static organizationalStructure.service.model.organizations
		fetchorganizationsByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchorganizationsByUuidAndGroupId(uuid, groupId);
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

	/**
	 * Returns the organizations with the primary key.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations
	 * @throws PortalException if a organizations with the primary key could not be found
	 */
	public static organizationalStructure.service.model.organizations
			getorganizations(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getorganizations(organizationId);
	}

	/**
	 * Returns the organizations matching the UUID and group.
	 *
	 * @param uuid the organizations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching organizations
	 * @throws PortalException if a matching organizations could not be found
	 */
	public static organizationalStructure.service.model.organizations
			getorganizationsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getorganizationsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of organizationses
	 */
	public static java.util.List
		<organizationalStructure.service.model.organizations>
			getorganizationses(int start, int end) {

		return getService().getorganizationses(start, end);
	}

	/**
	 * Returns the number of organizationses.
	 *
	 * @return the number of organizationses
	 */
	public static int getorganizationsesCount() {
		return getService().getorganizationsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the organizations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param organizations the organizations
	 * @return the organizations that was updated
	 */
	public static organizationalStructure.service.model.organizations
		updateorganizations(
			organizationalStructure.service.model.organizations organizations) {

		return getService().updateorganizations(organizations);
	}

	public static organizationsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<organizationsLocalService, organizationsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			organizationsLocalService.class);

		ServiceTracker<organizationsLocalService, organizationsLocalService>
			serviceTracker =
				new ServiceTracker
					<organizationsLocalService, organizationsLocalService>(
						bundle.getBundleContext(),
						organizationsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}