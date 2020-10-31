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

package adv.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for QuangCao. This utility wraps
 * <code>adv.service.impl.QuangCaoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoLocalService
 * @generated
 */
public class QuangCaoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>adv.service.impl.QuangCaoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the quang cao to the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCao the quang cao
	 * @return the quang cao that was added
	 */
	public static adv.model.QuangCao addQuangCao(adv.model.QuangCao quangCao) {
		return getService().addQuangCao(quangCao);
	}

	public static int countAbv(long groupId, String locale, String q)
		throws Exception {

		return getService().countAbv(groupId, locale, q);
	}

	/**
	 * Creates a new quang cao with the primary key. Does not add the quang cao to the database.
	 *
	 * @param quangCaoId the primary key for the new quang cao
	 * @return the new quang cao
	 */
	public static adv.model.QuangCao createQuangCao(long quangCaoId) {
		return getService().createQuangCao(quangCaoId);
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
	 * Deletes the quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao that was removed
	 * @throws PortalException if a quang cao with the primary key could not be found
	 */
	public static adv.model.QuangCao deleteQuangCao(long quangCaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuangCao(quangCaoId);
	}

	/**
	 * Deletes the quang cao from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCao the quang cao
	 * @return the quang cao that was removed
	 */
	public static adv.model.QuangCao deleteQuangCao(
		adv.model.QuangCao quangCao) {

		return getService().deleteQuangCao(quangCao);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adv.model.impl.QuangCaoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adv.model.impl.QuangCaoModelImpl</code>.
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

	public static adv.model.QuangCao fetchQuangCao(long quangCaoId) {
		return getService().fetchQuangCao(quangCaoId);
	}

	/**
	 * Returns the quang cao matching the UUID and group.
	 *
	 * @param uuid the quang cao's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public static adv.model.QuangCao fetchQuangCaoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchQuangCaoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<adv.model.QuangCao> getAllAdv(
			long groupId, int start, int limit, String locale, String q)
		throws Exception {

		return getService().getAllAdv(groupId, start, limit, locale, q);
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
	 * Returns the quang cao with the primary key.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao
	 * @throws PortalException if a quang cao with the primary key could not be found
	 */
	public static adv.model.QuangCao getQuangCao(long quangCaoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuangCao(quangCaoId);
	}

	/**
	 * Returns the quang cao matching the UUID and group.
	 *
	 * @param uuid the quang cao's UUID
	 * @param groupId the primary key of the group
	 * @return the matching quang cao
	 * @throws PortalException if a matching quang cao could not be found
	 */
	public static adv.model.QuangCao getQuangCaoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuangCaoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>adv.model.impl.QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of quang caos
	 */
	public static java.util.List<adv.model.QuangCao> getQuangCaos(
		int start, int end) {

		return getService().getQuangCaos(start, end);
	}

	/**
	 * Returns the number of quang caos.
	 *
	 * @return the number of quang caos
	 */
	public static int getQuangCaosCount() {
		return getService().getQuangCaosCount();
	}

	/**
	 * Updates the quang cao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param quangCao the quang cao
	 * @return the quang cao that was updated
	 */
	public static adv.model.QuangCao updateQuangCao(
		adv.model.QuangCao quangCao) {

		return getService().updateQuangCao(quangCao);
	}

	public static QuangCaoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuangCaoLocalService, QuangCaoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuangCaoLocalService.class);

		ServiceTracker<QuangCaoLocalService, QuangCaoLocalService>
			serviceTracker =
				new ServiceTracker<QuangCaoLocalService, QuangCaoLocalService>(
					bundle.getBundleContext(), QuangCaoLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}