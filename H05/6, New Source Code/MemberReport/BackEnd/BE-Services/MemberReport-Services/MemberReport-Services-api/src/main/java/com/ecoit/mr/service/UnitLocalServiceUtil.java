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

package com.ecoit.mr.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Unit. This utility wraps
 * <code>com.ecoit.mr.service.impl.UnitLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UnitLocalService
 * @generated
 */
public class UnitLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.mr.service.impl.UnitLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the unit to the database. Also notifies the appropriate model listeners.
	 *
	 * @param unit the unit
	 * @return the unit that was added
	 */
	public static com.ecoit.mr.model.Unit addUnit(
		com.ecoit.mr.model.Unit unit) {

		return getService().addUnit(unit);
	}

	public static int countUnit(
			String searchKey, long groupId, long companyId, String language)
		throws Exception {

		return getService().countUnit(searchKey, groupId, companyId, language);
	}

	/**
	 * Creates a new unit with the primary key. Does not add the unit to the database.
	 *
	 * @param unitId the primary key for the new unit
	 * @return the new unit
	 */
	public static com.ecoit.mr.model.Unit createUnit(long unitId) {
		return getService().createUnit(unitId);
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
	 * Deletes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit that was removed
	 * @throws PortalException if a unit with the primary key could not be found
	 */
	public static com.ecoit.mr.model.Unit deleteUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUnit(unitId);
	}

	/**
	 * Deletes the unit from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unit the unit
	 * @return the unit that was removed
	 */
	public static com.ecoit.mr.model.Unit deleteUnit(
		com.ecoit.mr.model.Unit unit) {

		return getService().deleteUnit(unit);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UnitModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UnitModelImpl</code>.
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

	public static com.ecoit.mr.model.Unit fetchUnit(long unitId) {
		return getService().fetchUnit(unitId);
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
	 * Returns the unit with the primary key.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit
	 * @throws PortalException if a unit with the primary key could not be found
	 */
	public static com.ecoit.mr.model.Unit getUnit(long unitId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUnit(unitId);
	}

	/**
	 * Returns a range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UnitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @return the range of units
	 */
	public static java.util.List<com.ecoit.mr.model.Unit> getUnits(
		int start, int end) {

		return getService().getUnits(start, end);
	}

	/**
	 * Returns the number of units.
	 *
	 * @return the number of units
	 */
	public static int getUnitsCount() {
		return getService().getUnitsCount();
	}

	public static java.util.List<com.ecoit.mr.model.Unit> searchUnit(
		String searchKey, long groupId, long companyId, String language,
		int start, int limit) {

		return getService().searchUnit(
			searchKey, groupId, companyId, language, start, limit);
	}

	public static void updateCreateUnit(
			long unitId, long groupId, long companyId, long userId,
			String language, String name, String description)
		throws Exception {

		getService().updateCreateUnit(
			unitId, groupId, companyId, userId, language, name, description);
	}

	/**
	 * Updates the unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param unit the unit
	 * @return the unit that was updated
	 */
	public static com.ecoit.mr.model.Unit updateUnit(
		com.ecoit.mr.model.Unit unit) {

		return getService().updateUnit(unit);
	}

	public static UnitLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UnitLocalService, UnitLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UnitLocalService.class);

		ServiceTracker<UnitLocalService, UnitLocalService> serviceTracker =
			new ServiceTracker<UnitLocalService, UnitLocalService>(
				bundle.getBundleContext(), UnitLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}