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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LoggerLocalService}.
 *
 * @author DungNV
 * @see LoggerLocalService
 * @generated
 */
public class LoggerLocalServiceWrapper
	implements LoggerLocalService, ServiceWrapper<LoggerLocalService> {

	public LoggerLocalServiceWrapper(LoggerLocalService loggerLocalService) {
		_loggerLocalService = loggerLocalService;
	}

	/**
	 * Adds the logger to the database. Also notifies the appropriate model listeners.
	 *
	 * @param logger the logger
	 * @return the logger that was added
	 */
	@Override
	public com.software.cms.model.Logger addLogger(
		com.software.cms.model.Logger logger) {

		return _loggerLocalService.addLogger(logger);
	}

	@Override
	public com.software.cms.model.Logger create() {
		return _loggerLocalService.create();
	}

	/**
	 * Creates a new logger with the primary key. Does not add the logger to the database.
	 *
	 * @param loggerId the primary key for the new logger
	 * @return the new logger
	 */
	@Override
	public com.software.cms.model.Logger createLogger(long loggerId) {
		return _loggerLocalService.createLogger(loggerId);
	}

	/**
	 * Deletes the logger from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logger the logger
	 * @return the logger that was removed
	 */
	@Override
	public com.software.cms.model.Logger deleteLogger(
		com.software.cms.model.Logger logger) {

		return _loggerLocalService.deleteLogger(logger);
	}

	/**
	 * Deletes the logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger that was removed
	 * @throws PortalException if a logger with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Logger deleteLogger(long loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loggerLocalService.deleteLogger(loggerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loggerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loggerLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _loggerLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _loggerLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _loggerLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _loggerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _loggerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.Logger fetchLogger(long loggerId) {
		return _loggerLocalService.fetchLogger(loggerId);
	}

	/**
	 * Returns the logger matching the UUID and group.
	 *
	 * @param uuid the logger's UUID
	 * @param groupId the primary key of the group
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public com.software.cms.model.Logger fetchLoggerByUuidAndGroupId(
		String uuid, long groupId) {

		return _loggerLocalService.fetchLoggerByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _loggerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _loggerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the logger with the primary key.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger
	 * @throws PortalException if a logger with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Logger getLogger(long loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loggerLocalService.getLogger(loggerId);
	}

	/**
	 * Returns the logger matching the UUID and group.
	 *
	 * @param uuid the logger's UUID
	 * @param groupId the primary key of the group
	 * @return the matching logger
	 * @throws PortalException if a matching logger could not be found
	 */
	@Override
	public com.software.cms.model.Logger getLoggerByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loggerLocalService.getLoggerByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.software.cms.model.Logger> getLoggers(
		int start, int end) {

		return _loggerLocalService.getLoggers(start, end);
	}

	/**
	 * Returns the number of loggers.
	 *
	 * @return the number of loggers
	 */
	@Override
	public int getLoggersCount() {
		return _loggerLocalService.getLoggersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loggerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _loggerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the logger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param logger the logger
	 * @return the logger that was updated
	 */
	@Override
	public com.software.cms.model.Logger updateLogger(
		com.software.cms.model.Logger logger) {

		return _loggerLocalService.updateLogger(logger);
	}

	@Override
	public LoggerLocalService getWrappedService() {
		return _loggerLocalService;
	}

	@Override
	public void setWrappedService(LoggerLocalService loggerLocalService) {
		_loggerLocalService = loggerLocalService;
	}

	private LoggerLocalService _loggerLocalService;

}