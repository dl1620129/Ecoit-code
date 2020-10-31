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

package com.software.cms.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Logger. This utility wraps
 * <code>com.software.cms.service.impl.LoggerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see LoggerLocalService
 * @generated
 */
public class LoggerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.LoggerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the logger to the database. Also notifies the appropriate model listeners.
	 *
	 * @param logger the logger
	 * @return the logger that was added
	 */
	public static com.software.cms.model.Logger addLogger(
		com.software.cms.model.Logger logger) {

		return getService().addLogger(logger);
	}

	/**
	 * Creates a new logger with the primary key. Does not add the logger to the database.
	 *
	 * @param loggerId the primary key for the new logger
	 * @return the new logger
	 */
	public static com.software.cms.model.Logger createLogger(long loggerId) {
		return getService().createLogger(loggerId);
	}

	/**
	 * Deletes the logger from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logger the logger
	 * @return the logger that was removed
	 */
	public static com.software.cms.model.Logger deleteLogger(
		com.software.cms.model.Logger logger) {

		return getService().deleteLogger(logger);
	}

	/**
	 * Deletes the logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger that was removed
	 * @throws PortalException if a logger with the primary key could not be found
	 */
	public static com.software.cms.model.Logger deleteLogger(long loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLogger(loggerId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.LoggerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.LoggerModelImpl</code>.
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

	public static com.software.cms.model.Logger fetchLogger(long loggerId) {
		return getService().fetchLogger(loggerId);
	}

	/**
	 * Returns the logger matching the UUID and group.
	 *
	 * @param uuid the logger's UUID
	 * @param groupId the primary key of the group
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	public static com.software.cms.model.Logger fetchLoggerByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchLoggerByUuidAndGroupId(uuid, groupId);
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
	 * Returns the logger with the primary key.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger
	 * @throws PortalException if a logger with the primary key could not be found
	 */
	public static com.software.cms.model.Logger getLogger(long loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLogger(loggerId);
	}

	/**
	 * Returns the logger matching the UUID and group.
	 *
	 * @param uuid the logger's UUID
	 * @param groupId the primary key of the group
	 * @return the matching logger
	 * @throws PortalException if a matching logger could not be found
	 */
	public static com.software.cms.model.Logger getLoggerByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLoggerByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of loggers
	 */
	public static java.util.List<com.software.cms.model.Logger> getLoggers(
		int start, int end) {

		return getService().getLoggers(start, end);
	}

	/**
	 * Returns the number of loggers.
	 *
	 * @return the number of loggers
	 */
	public static int getLoggersCount() {
		return getService().getLoggersCount();
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
	 * Updates the logger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param logger the logger
	 * @return the logger that was updated
	 */
	public static com.software.cms.model.Logger updateLogger(
		com.software.cms.model.Logger logger) {

		return getService().updateLogger(logger);
	}

	public static LoggerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LoggerLocalService, LoggerLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LoggerLocalService.class);

		ServiceTracker<LoggerLocalService, LoggerLocalService> serviceTracker =
			new ServiceTracker<LoggerLocalService, LoggerLocalService>(
				bundle.getBundleContext(), LoggerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}