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
 * Provides the local service utility for LichChiTiet. This utility wraps
 * <code>com.ecoit.lichcongtac.services.service.impl.LichChiTietLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietLocalService
 * @generated
 */
public class LichChiTietLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.lichcongtac.services.service.impl.LichChiTietLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lich chi tiet to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was added
	 */
	public static com.ecoit.lichcongtac.services.model.LichChiTiet
		addLichChiTiet(
			com.ecoit.lichcongtac.services.model.LichChiTiet lichChiTiet) {

		return getService().addLichChiTiet(lichChiTiet);
	}

	/**
	 * Creates a new lich chi tiet with the primary key. Does not add the lich chi tiet to the database.
	 *
	 * @param lichChiTietId the primary key for the new lich chi tiet
	 * @return the new lich chi tiet
	 */
	public static com.ecoit.lichcongtac.services.model.LichChiTiet
		createLichChiTiet(long lichChiTietId) {

		return getService().createLichChiTiet(lichChiTietId);
	}

	public static void createUpdateLichChiTiet(
		long lichChiTietId, long groupId, long userId, long companyId,
		String description, java.util.Date startTime, long organizationId,
		java.util.Date selectedDate, String nguoiThamDu, String nguoiChuTri,
		long lichCongTacId, String address, String note, int status,
		String language, boolean coLyDo, String lyDoTraVe) {

		getService().createUpdateLichChiTiet(
			lichChiTietId, groupId, userId, companyId, description, startTime,
			organizationId, selectedDate, nguoiThamDu, nguoiChuTri,
			lichCongTacId, address, note, status, language, coLyDo, lyDoTraVe);
	}

	public static void deleteByLichCongTacId(long lichCongTacId) {
		getService().deleteByLichCongTacId(lichCongTacId);
	}

	/**
	 * Deletes the lich chi tiet from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was removed
	 */
	public static com.ecoit.lichcongtac.services.model.LichChiTiet
		deleteLichChiTiet(
			com.ecoit.lichcongtac.services.model.LichChiTiet lichChiTiet) {

		return getService().deleteLichChiTiet(lichChiTiet);
	}

	/**
	 * Deletes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws PortalException if a lich chi tiet with the primary key could not be found
	 */
	public static com.ecoit.lichcongtac.services.model.LichChiTiet
			deleteLichChiTiet(long lichChiTietId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLichChiTiet(lichChiTietId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
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

	public static com.ecoit.lichcongtac.services.model.LichChiTiet
		fetchLichChiTiet(long lichChiTietId) {

		return getService().fetchLichChiTiet(lichChiTietId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.ecoit.lichcongtac.services.model.LichChiTiet> getByDateAndStatus(
			String fromDate, String toDate, long groupId, String language,
			int status) {

		return getService().getByDateAndStatus(
			fromDate, toDate, groupId, language, status);
	}

	public static java.util.List
		<com.ecoit.lichcongtac.services.model.LichChiTiet> getByLichCongTacId(
			long lichCongTacId) {

		return getService().getByLichCongTacId(lichCongTacId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lich chi tiet with the primary key.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws PortalException if a lich chi tiet with the primary key could not be found
	 */
	public static com.ecoit.lichcongtac.services.model.LichChiTiet
			getLichChiTiet(long lichChiTietId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLichChiTiet(lichChiTietId);
	}

	/**
	 * Returns a range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of lich chi tiets
	 */
	public static java.util.List
		<com.ecoit.lichcongtac.services.model.LichChiTiet> getLichChiTiets(
			int start, int end) {

		return getService().getLichChiTiets(start, end);
	}

	/**
	 * Returns the number of lich chi tiets.
	 *
	 * @return the number of lich chi tiets
	 */
	public static int getLichChiTietsCount() {
		return getService().getLichChiTietsCount();
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
		<com.ecoit.lichcongtac.services.model.LichChiTiet>
			getPublishLichChiTiet(
				long groupId, String language, int status, int stableStatus,
				String fromDate, String toDate) {

		return getService().getPublishLichChiTiet(
			groupId, language, status, stableStatus, fromDate, toDate);
	}

	public static java.util.List
		<com.ecoit.lichcongtac.services.model.LichChiTiet> searchLichChiTiet(
			long organizationId, long groupId, String language, int status,
			long userId, String fromDate, String toDate) {

		return getService().searchLichChiTiet(
			organizationId, groupId, language, status, userId, fromDate,
			toDate);
	}

	/**
	 * Updates the lich chi tiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was updated
	 */
	public static com.ecoit.lichcongtac.services.model.LichChiTiet
		updateLichChiTiet(
			com.ecoit.lichcongtac.services.model.LichChiTiet lichChiTiet) {

		return getService().updateLichChiTiet(lichChiTiet);
	}

	public static void updateStatus(
		long userId, int status, long lichChiTietId, boolean coLyDo,
		String lyDoTraVe) {

		getService().updateStatus(
			userId, status, lichChiTietId, coLyDo, lyDoTraVe);
	}

	public static LichChiTietLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LichChiTietLocalService, LichChiTietLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LichChiTietLocalService.class);

		ServiceTracker<LichChiTietLocalService, LichChiTietLocalService>
			serviceTracker =
				new ServiceTracker
					<LichChiTietLocalService, LichChiTietLocalService>(
						bundle.getBundleContext(),
						LichChiTietLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}