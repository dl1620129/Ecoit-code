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

package LinkManager.Service.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for portal. This utility wraps
 * <code>LinkManager.Service.service.impl.portalLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see portalLocalService
 * @generated
 */
@ProviderType
public class portalLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>LinkManager.Service.service.impl.portalLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the portal to the database. Also notifies the appropriate model listeners.
	 *
	 * @param portal the portal
	 * @return the portal that was added
	 */
	public static LinkManager.Service.model.portal addportal(
		LinkManager.Service.model.portal portal) {

		return getService().addportal(portal);
	}

	/**
	 * Creates a new portal with the primary key. Does not add the portal to the database.
	 *
	 * @param portalId the primary key for the new portal
	 * @return the new portal
	 */
	public static LinkManager.Service.model.portal createportal(long portalId) {
		return getService().createportal(portalId);
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
	 * Deletes the portal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal that was removed
	 * @throws PortalException if a portal with the primary key could not be found
	 */
	public static LinkManager.Service.model.portal deleteportal(long portalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteportal(portalId);
	}

	/**
	 * Deletes the portal from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portal the portal
	 * @return the portal that was removed
	 */
	public static LinkManager.Service.model.portal deleteportal(
		LinkManager.Service.model.portal portal) {

		return getService().deleteportal(portal);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static LinkManager.Service.model.portal fetchportal(long portalId) {
		return getService().fetchportal(portalId);
	}

	/**
	 * Returns the portal matching the UUID and group.
	 *
	 * @param uuid the portal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public static LinkManager.Service.model.portal fetchportalByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchportalByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the portal with the primary key.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal
	 * @throws PortalException if a portal with the primary key could not be found
	 */
	public static LinkManager.Service.model.portal getportal(long portalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getportal(portalId);
	}

	/**
	 * Returns the portal matching the UUID and group.
	 *
	 * @param uuid the portal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching portal
	 * @throws PortalException if a matching portal could not be found
	 */
	public static LinkManager.Service.model.portal getportalByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getportalByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the portals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @return the range of portals
	 */
	public static java.util.List<LinkManager.Service.model.portal> getportals(
		int start, int end) {

		return getService().getportals(start, end);
	}

	/**
	 * Returns all the portals matching the UUID and company.
	 *
	 * @param uuid the UUID of the portals
	 * @param companyId the primary key of the company
	 * @return the matching portals, or an empty list if no matches were found
	 */
	public static java.util.List<LinkManager.Service.model.portal>
		getportalsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getportalsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of portals matching the UUID and company.
	 *
	 * @param uuid the UUID of the portals
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching portals, or an empty list if no matches were found
	 */
	public static java.util.List<LinkManager.Service.model.portal>
		getportalsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<LinkManager.Service.model.portal> orderByComparator) {

		return getService().getportalsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of portals.
	 *
	 * @return the number of portals
	 */
	public static int getportalsCount() {
		return getService().getportalsCount();
	}

	/**
	 * Updates the portal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param portal the portal
	 * @return the portal that was updated
	 */
	public static LinkManager.Service.model.portal updateportal(
		LinkManager.Service.model.portal portal) {

		return getService().updateportal(portal);
	}

	public static portalLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<portalLocalService, portalLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(portalLocalService.class);

		ServiceTracker<portalLocalService, portalLocalService> serviceTracker =
			new ServiceTracker<portalLocalService, portalLocalService>(
				bundle.getBundleContext(), portalLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}