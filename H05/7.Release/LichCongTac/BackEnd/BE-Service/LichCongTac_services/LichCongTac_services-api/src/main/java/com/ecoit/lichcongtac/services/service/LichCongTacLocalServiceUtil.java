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

package com.ecoit.lichcongtac.services.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LichCongTac. This utility wraps
 * <code>com.ecoit.lichcongtac.services.service.impl.LichCongTacLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LichCongTacLocalService
 * @generated
 */
public class LichCongTacLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.lichcongtac.services.service.impl.LichCongTacLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lich cong tac to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was added
	 */
	public static com.ecoit.lichcongtac.services.model.LichCongTac
		addLichCongTac(
			com.ecoit.lichcongtac.services.model.LichCongTac lichCongTac) {

		return getService().addLichCongTac(lichCongTac);
	}

	public static int countLichCongTac(
		long organizationId, long groupId, String language, String q,
		int status, long userId, String fromDate, String toDate) {

		return getService().countLichCongTac(
			organizationId, groupId, language, q, status, userId, fromDate,
			toDate);
	}

	/**
	 * Creates a new lich cong tac with the primary key. Does not add the lich cong tac to the database.
	 *
	 * @param lichCongTacId the primary key for the new lich cong tac
	 * @return the new lich cong tac
	 */
	public static com.ecoit.lichcongtac.services.model.LichCongTac
		createLichCongTac(long lichCongTacId) {

		return getService().createLichCongTac(lichCongTacId);
	}

	public static com.ecoit.lichcongtac.services.model.LichCongTac
			createUpdateLichCongTac(
				long lichCongTacId, String language, long groupId, long userId,
				boolean coLyDo, String lyDoTraVe, long companyId,
				long organizationId, String name, java.util.Date startDate,
				java.util.Date endDate, String organizations, String users,
				int status)
		throws Exception {

		return getService().createUpdateLichCongTac(
			lichCongTacId, language, groupId, userId, coLyDo, lyDoTraVe,
			companyId, organizationId, name, startDate, endDate, organizations,
			users, status);
	}

	/**
	 * Deletes the lich cong tac from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was removed
	 */
	public static com.ecoit.lichcongtac.services.model.LichCongTac
		deleteLichCongTac(
			com.ecoit.lichcongtac.services.model.LichCongTac lichCongTac) {

		return getService().deleteLichCongTac(lichCongTac);
	}

	/**
	 * Deletes the lich cong tac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac that was removed
	 * @throws PortalException if a lich cong tac with the primary key could not be found
	 */
	public static com.ecoit.lichcongtac.services.model.LichCongTac
			deleteLichCongTac(long lichCongTacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLichCongTac(lichCongTacId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
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

	public static com.ecoit.lichcongtac.services.model.LichCongTac
		fetchLichCongTac(long lichCongTacId) {

		return getService().fetchLichCongTac(lichCongTacId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.ecoit.lichcongtac.services.model.LichCongTac
		getByStatusAndId(int status, long lichCongTacId) {

		return getService().getByStatusAndId(status, lichCongTacId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lich cong tac with the primary key.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac
	 * @throws PortalException if a lich cong tac with the primary key could not be found
	 */
	public static com.ecoit.lichcongtac.services.model.LichCongTac
			getLichCongTac(long lichCongTacId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLichCongTac(lichCongTacId);
	}

	/**
	 * Returns a range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of lich cong tacs
	 */
	public static java.util.List
		<com.ecoit.lichcongtac.services.model.LichCongTac> getLichCongTacs(
			int start, int end) {

		return getService().getLichCongTacs(start, end);
	}

	/**
	 * Returns the number of lich cong tacs.
	 *
	 * @return the number of lich cong tacs
	 */
	public static int getLichCongTacsCount() {
		return getService().getLichCongTacsCount();
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

	public static java.util.List
		<com.ecoit.lichcongtac.services.model.LichCongTac> searchLichCongTac(
			long organizationId, long groupId, String language, String q,
			int start, int limit, int status, long userId, String fromDate,
			String toDate) {

		return getService().searchLichCongTac(
			organizationId, groupId, language, q, start, limit, status, userId,
			fromDate, toDate);
	}

	/**
	 * Updates the lich cong tac in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTac the lich cong tac
	 * @return the lich cong tac that was updated
	 */
	public static com.ecoit.lichcongtac.services.model.LichCongTac
		updateLichCongTac(
			com.ecoit.lichcongtac.services.model.LichCongTac lichCongTac) {

		return getService().updateLichCongTac(lichCongTac);
	}

	public static void updateStatus(
		long userId, int status, long lichCongTacId, boolean coLyDo,
		String lyDoTraVe) {

		getService().updateStatus(
			userId, status, lichCongTacId, coLyDo, lyDoTraVe);
	}

	public static LichCongTacLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LichCongTacLocalService, LichCongTacLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LichCongTacLocalService.class);

		ServiceTracker<LichCongTacLocalService, LichCongTacLocalService>
			serviceTracker =
				new ServiceTracker
					<LichCongTacLocalService, LichCongTacLocalService>(
						bundle.getBundleContext(),
						LichCongTacLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}