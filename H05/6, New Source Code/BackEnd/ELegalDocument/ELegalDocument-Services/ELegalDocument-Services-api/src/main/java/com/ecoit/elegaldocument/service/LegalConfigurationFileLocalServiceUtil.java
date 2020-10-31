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
 * Provides the local service utility for LegalConfigurationFile. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalConfigurationFileLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalConfigurationFileLocalService
 * @generated
 */
public class LegalConfigurationFileLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalConfigurationFileLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal configuration file to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalConfigurationFile the legal configuration file
	 * @return the legal configuration file that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
		addLegalConfigurationFile(
			com.ecoit.elegaldocument.model.LegalConfigurationFile
				legalConfigurationFile) {

		return getService().addLegalConfigurationFile(legalConfigurationFile);
	}

	/**
	 * Creates a new legal configuration file with the primary key. Does not add the legal configuration file to the database.
	 *
	 * @param keyId the primary key for the new legal configuration file
	 * @return the new legal configuration file
	 */
	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
		createLegalConfigurationFile(String keyId) {

		return getService().createLegalConfigurationFile(keyId);
	}

	/**
	 * Deletes the legal configuration file from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalConfigurationFile the legal configuration file
	 * @return the legal configuration file that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
		deleteLegalConfigurationFile(
			com.ecoit.elegaldocument.model.LegalConfigurationFile
				legalConfigurationFile) {

		return getService().deleteLegalConfigurationFile(
			legalConfigurationFile);
	}

	/**
	 * Deletes the legal configuration file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file that was removed
	 * @throws PortalException if a legal configuration file with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
			deleteLegalConfigurationFile(String keyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalConfigurationFile(keyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalConfigurationFileModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalConfigurationFileModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
		fetchLegalConfigurationFile(String keyId) {

		return getService().fetchLegalConfigurationFile(keyId);
	}

	/**
	 * Returns the legal configuration file with the primary key.
	 *
	 * @param keyId the primary key of the legal configuration file
	 * @return the legal configuration file
	 * @throws PortalException if a legal configuration file with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
			getLegalConfigurationFile(String keyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalConfigurationFile(keyId);
	}

	/**
	 * Returns a range of all the legal configuration files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalConfigurationFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal configuration files
	 * @param end the upper bound of the range of legal configuration files (not inclusive)
	 * @return the range of legal configuration files
	 */
	public static java.util.List
		<com.ecoit.elegaldocument.model.LegalConfigurationFile>
			getLegalConfigurationFiles(int start, int end) {

		return getService().getLegalConfigurationFiles(start, end);
	}

	/**
	 * Returns the number of legal configuration files.
	 *
	 * @return the number of legal configuration files
	 */
	public static int getLegalConfigurationFilesCount() {
		return getService().getLegalConfigurationFilesCount();
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
	 * Updates the legal configuration file in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalConfigurationFile the legal configuration file
	 * @return the legal configuration file that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalConfigurationFile
		updateLegalConfigurationFile(
			com.ecoit.elegaldocument.model.LegalConfigurationFile
				legalConfigurationFile) {

		return getService().updateLegalConfigurationFile(
			legalConfigurationFile);
	}

	public static LegalConfigurationFileLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalConfigurationFileLocalService, LegalConfigurationFileLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalConfigurationFileLocalService.class);

		ServiceTracker
			<LegalConfigurationFileLocalService,
			 LegalConfigurationFileLocalService> serviceTracker =
				new ServiceTracker
					<LegalConfigurationFileLocalService,
					 LegalConfigurationFileLocalService>(
						 bundle.getBundleContext(),
						 LegalConfigurationFileLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}