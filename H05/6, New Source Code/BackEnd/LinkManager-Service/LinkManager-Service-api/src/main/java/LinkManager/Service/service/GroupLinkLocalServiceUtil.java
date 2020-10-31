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
 * Provides the local service utility for GroupLink. This utility wraps
 * <code>LinkManager.Service.service.impl.GroupLinkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GroupLinkLocalService
 * @generated
 */
@ProviderType
public class GroupLinkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>LinkManager.Service.service.impl.GroupLinkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupLink the group link
	 * @return the group link that was added
	 */
	public static LinkManager.Service.model.GroupLink addGroupLink(
		LinkManager.Service.model.GroupLink groupLink) {

		return getService().addGroupLink(groupLink);
	}

	/**
	 * Creates a new group link with the primary key. Does not add the group link to the database.
	 *
	 * @param linksgroupid the primary key for the new group link
	 * @return the new group link
	 */
	public static LinkManager.Service.model.GroupLink createGroupLink(
		long linksgroupid) {

		return getService().createGroupLink(linksgroupid);
	}

	/**
	 * Deletes the group link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupLink the group link
	 * @return the group link that was removed
	 */
	public static LinkManager.Service.model.GroupLink deleteGroupLink(
		LinkManager.Service.model.GroupLink groupLink) {

		return getService().deleteGroupLink(groupLink);
	}

	/**
	 * Deletes the group link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link that was removed
	 * @throws PortalException if a group link with the primary key could not be found
	 */
	public static LinkManager.Service.model.GroupLink deleteGroupLink(
			long linksgroupid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupLink(linksgroupid);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static LinkManager.Service.model.GroupLink fetchGroupLink(
		long linksgroupid) {

		return getService().fetchGroupLink(linksgroupid);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static int getCount(String name, long groupId) {
		return getService().getCount(name, groupId);
	}

	public static int getCountAll(String name, long groupId) throws Exception {
		return getService().getCountAll(name, groupId);
	}

	/**
	 * Returns the group link with the primary key.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link
	 * @throws PortalException if a group link with the primary key could not be found
	 */
	public static LinkManager.Service.model.GroupLink getGroupLink(
			long linksgroupid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupLink(linksgroupid);
	}

	/**
	 * Returns a range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @return the range of group links
	 */
	public static java.util.List<LinkManager.Service.model.GroupLink>
		getGroupLinks(int start, int end) {

		return getService().getGroupLinks(start, end);
	}

	/**
	 * Returns the number of group links.
	 *
	 * @return the number of group links
	 */
	public static int getGroupLinksCount() {
		return getService().getGroupLinksCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<LinkManager.Service.model.GroupLink>
		getListGroupLink(String name, int start, int limit, long groupId) {

		return getService().getListGroupLink(name, start, limit, groupId);
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
	 * Updates the group link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupLink the group link
	 * @return the group link that was updated
	 */
	public static LinkManager.Service.model.GroupLink updateGroupLink(
		LinkManager.Service.model.GroupLink groupLink) {

		return getService().updateGroupLink(groupLink);
	}

	public static GroupLinkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GroupLinkLocalService, GroupLinkLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupLinkLocalService.class);

		ServiceTracker<GroupLinkLocalService, GroupLinkLocalService>
			serviceTracker =
				new ServiceTracker
					<GroupLinkLocalService, GroupLinkLocalService>(
						bundle.getBundleContext(), GroupLinkLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}