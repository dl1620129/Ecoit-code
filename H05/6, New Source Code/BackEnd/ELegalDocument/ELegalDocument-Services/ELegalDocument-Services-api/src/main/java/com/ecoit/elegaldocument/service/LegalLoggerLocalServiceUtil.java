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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for LegalLogger. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalLoggerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalLoggerLocalService
 * @generated
 */
public class LegalLoggerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalLoggerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal logger to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLogger the legal logger
	 * @return the legal logger that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalLogger addLegalLogger(
		com.ecoit.elegaldocument.model.LegalLogger legalLogger) {

		return getService().addLegalLogger(legalLogger);
	}

	/**
	 * Creates a new legal logger with the primary key. Does not add the legal logger to the database.
	 *
	 * @param loggerId the primary key for the new legal logger
	 * @return the new legal logger
	 */
	public static com.ecoit.elegaldocument.model.LegalLogger createLegalLogger(
		String loggerId) {

		return getService().createLegalLogger(loggerId);
	}

	/**
	 * Deletes the legal logger from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLogger the legal logger
	 * @return the legal logger that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalLogger deleteLegalLogger(
		com.ecoit.elegaldocument.model.LegalLogger legalLogger) {

		return getService().deleteLegalLogger(legalLogger);
	}

	/**
	 * Deletes the legal logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger that was removed
	 * @throws PortalException if a legal logger with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalLogger deleteLegalLogger(
			String loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalLogger(loggerId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLoggerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLoggerModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalLogger fetchLegalLogger(
		String loggerId) {

		return getService().fetchLegalLogger(loggerId);
	}

	/**
	 * Returns the legal logger with the primary key.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger
	 * @throws PortalException if a legal logger with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalLogger getLegalLogger(
			String loggerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalLogger(loggerId);
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
	public static java.util.List<com.ecoit.elegaldocument.model.LegalLogger>
		getLegalLoggers(int start, int end) {

		return getService().getLegalLoggers(start, end);
	}

	/**
	 * Returns the number of legal loggers.
	 *
	 * @return the number of legal loggers
	 */
	public static int getLegalLoggersCount() {
		return getService().getLegalLoggersCount();
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
	 * Updates the legal logger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalLogger the legal logger
	 * @return the legal logger that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalLogger updateLegalLogger(
		com.ecoit.elegaldocument.model.LegalLogger legalLogger) {

		return getService().updateLegalLogger(legalLogger);
	}

	public static LegalLoggerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalLoggerLocalService, LegalLoggerLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalLoggerLocalService.class);

		ServiceTracker<LegalLoggerLocalService, LegalLoggerLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalLoggerLocalService, LegalLoggerLocalService>(
						bundle.getBundleContext(),
						LegalLoggerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}