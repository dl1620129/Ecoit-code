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

package com.ecoit.elegaldocument.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalLoggerLocalService}.
 *
 * @author Liverpool
 * @see LegalLoggerLocalService
 * @generated
 */
public class LegalLoggerLocalServiceWrapper
	implements LegalLoggerLocalService,
			   ServiceWrapper<LegalLoggerLocalService> {

	public LegalLoggerLocalServiceWrapper(
		LegalLoggerLocalService legalLoggerLocalService) {

		_legalLoggerLocalService = legalLoggerLocalService;
	}

	/**
	 * Adds the legal logger to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLogger the legal logger
	 * @return the legal logger that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLogger addLegalLogger(
		com.ecoit.elegaldocument.model.LegalLogger legalLogger) {

		return _legalLoggerLocalService.addLegalLogger(legalLogger);
	}

	/**
	 * Creates a new legal logger with the primary key. Does not add the legal logger to the database.
	 *
	 * @param loggerId the primary key for the new legal logger
	 * @return the new legal logger
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLogger createLegalLogger(
		String loggerId) {

		return _legalLoggerLocalService.createLegalLogger(loggerId);
	}

	/**
	 * Deletes the legal logger from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLogger the legal logger
	 * @return the legal logger that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLogger deleteLegalLogger(
		com.ecoit.elegaldocument.model.LegalLogger legalLogger) {

		return _legalLoggerLocalService.deleteLegalLogger(legalLogger);
	}

	/**
	 * Deletes the legal logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger that was removed
	 * @throws PortalException if a legal logger with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLogger deleteLegalLogger(
			String loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLoggerLocalService.deleteLegalLogger(loggerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLoggerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalLoggerLocalService.dynamicQuery();
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

		return _legalLoggerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLoggerModelImpl</code>.
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

		return _legalLoggerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLoggerModelImpl</code>.
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

		return _legalLoggerLocalService.dynamicQuery(
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

		return _legalLoggerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalLoggerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalLogger fetchLegalLogger(
		String loggerId) {

		return _legalLoggerLocalService.fetchLegalLogger(loggerId);
	}

	/**
	 * Returns the legal logger with the primary key.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger
	 * @throws PortalException if a legal logger with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLogger getLegalLogger(
			String loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLoggerLocalService.getLegalLogger(loggerId);
	}

	/**
	 * Returns a range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of legal loggers
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalLogger>
		getLegalLoggers(int start, int end) {

		return _legalLoggerLocalService.getLegalLoggers(start, end);
	}

	/**
	 * Returns the number of legal loggers.
	 *
	 * @return the number of legal loggers
	 */
	@Override
	public int getLegalLoggersCount() {
		return _legalLoggerLocalService.getLegalLoggersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalLoggerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLoggerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal logger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalLogger the legal logger
	 * @return the legal logger that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLogger updateLegalLogger(
		com.ecoit.elegaldocument.model.LegalLogger legalLogger) {

		return _legalLoggerLocalService.updateLegalLogger(legalLogger);
	}

	@Override
	public LegalLoggerLocalService getWrappedService() {
		return _legalLoggerLocalService;
	}

	@Override
	public void setWrappedService(
		LegalLoggerLocalService legalLoggerLocalService) {

		_legalLoggerLocalService = legalLoggerLocalService;
	}

	private LegalLoggerLocalService _legalLoggerLocalService;

}