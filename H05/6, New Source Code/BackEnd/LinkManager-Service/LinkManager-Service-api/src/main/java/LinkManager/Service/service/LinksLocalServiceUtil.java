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
 * Provides the local service utility for Links. This utility wraps
 * <code>LinkManager.Service.service.impl.LinksLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LinksLocalService
 * @generated
 */
@ProviderType
public class LinksLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>LinkManager.Service.service.impl.LinksLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the links to the database. Also notifies the appropriate model listeners.
	 *
	 * @param links the links
	 * @return the links that was added
	 */
	public static LinkManager.Service.model.Links addLinks(
		LinkManager.Service.model.Links links) {

		return getService().addLinks(links);
	}

	/**
	 * Creates a new links with the primary key. Does not add the links to the database.
	 *
	 * @param linksid the primary key for the new links
	 * @return the new links
	 */
	public static LinkManager.Service.model.Links createLinks(long linksid) {
		return getService().createLinks(linksid);
	}

	/**
	 * Deletes the links from the database. Also notifies the appropriate model listeners.
	 *
	 * @param links the links
	 * @return the links that was removed
	 */
	public static LinkManager.Service.model.Links deleteLinks(
		LinkManager.Service.model.Links links) {

		return getService().deleteLinks(links);
	}

	/**
	 * Deletes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksid the primary key of the links
	 * @return the links that was removed
	 * @throws PortalException if a links with the primary key could not be found
	 */
	public static LinkManager.Service.model.Links deleteLinks(long linksid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLinks(linksid);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static LinkManager.Service.model.Links fetchLinks(long linksid) {
		return getService().fetchLinks(linksid);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static int getCountByTag(String name, long groupId)
		throws Exception {

		return getService().getCountByTag(name, groupId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<LinkManager.Service.model.Links>
			getLinkByLinkGroupId(long groupId, long linkGroupId)
		throws Exception {

		return getService().getLinkByLinkGroupId(groupId, linkGroupId);
	}

	/**
	 * Returns the links with the primary key.
	 *
	 * @param linksid the primary key of the links
	 * @return the links
	 * @throws PortalException if a links with the primary key could not be found
	 */
	public static LinkManager.Service.model.Links getLinks(long linksid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLinks(linksid);
	}

	/**
	 * Returns a range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of linkses
	 */
	public static java.util.List<LinkManager.Service.model.Links> getLinkses(
		int start, int end) {

		return getService().getLinkses(start, end);
	}

	/**
	 * Returns the number of linkses.
	 *
	 * @return the number of linkses
	 */
	public static int getLinksesCount() {
		return getService().getLinksesCount();
	}

	public static java.util.List<LinkManager.Service.model.Links> getListLink(
			String name, long groupId, int start, int limit)
		throws Exception {

		return getService().getListLink(name, groupId, start, limit);
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
	 * Updates the links in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param links the links
	 * @return the links that was updated
	 */
	public static LinkManager.Service.model.Links updateLinks(
		LinkManager.Service.model.Links links) {

		return getService().updateLinks(links);
	}

	public static LinksLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LinksLocalService, LinksLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LinksLocalService.class);

		ServiceTracker<LinksLocalService, LinksLocalService> serviceTracker =
			new ServiceTracker<LinksLocalService, LinksLocalService>(
				bundle.getBundleContext(), LinksLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}