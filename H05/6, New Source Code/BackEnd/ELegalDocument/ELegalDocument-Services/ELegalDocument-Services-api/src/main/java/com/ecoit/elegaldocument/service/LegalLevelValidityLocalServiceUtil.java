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
 * Provides the local service utility for LegalLevelValidity. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalLevelValidityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalLevelValidityLocalService
 * @generated
 */
public class LegalLevelValidityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalLevelValidityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal level validity to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLevelValidity the legal level validity
	 * @return the legal level validity that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalLevelValidity
		addLegalLevelValidity(
			com.ecoit.elegaldocument.model.LegalLevelValidity
				legalLevelValidity) {

		return getService().addLegalLevelValidity(legalLevelValidity);
	}

	/**
	 * Creates a new legal level validity with the primary key. Does not add the legal level validity to the database.
	 *
	 * @param levelValidityId the primary key for the new legal level validity
	 * @return the new legal level validity
	 */
	public static com.ecoit.elegaldocument.model.LegalLevelValidity
		createLegalLevelValidity(long levelValidityId) {

		return getService().createLegalLevelValidity(levelValidityId);
	}

	/**
	 * Deletes the legal level validity from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLevelValidity the legal level validity
	 * @return the legal level validity that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalLevelValidity
		deleteLegalLevelValidity(
			com.ecoit.elegaldocument.model.LegalLevelValidity
				legalLevelValidity) {

		return getService().deleteLegalLevelValidity(legalLevelValidity);
	}

	/**
	 * Deletes the legal level validity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity that was removed
	 * @throws PortalException if a legal level validity with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalLevelValidity
			deleteLegalLevelValidity(long levelValidityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalLevelValidity(levelValidityId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalLevelValidity
		fetchLegalLevelValidity(long levelValidityId) {

		return getService().fetchLegalLevelValidity(levelValidityId);
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
	 * Returns a range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of legal level validities
	 */
	public static java.util.List
		<com.ecoit.elegaldocument.model.LegalLevelValidity>
			getLegalLevelValidities(int start, int end) {

		return getService().getLegalLevelValidities(start, end);
	}

	/**
	 * Returns the number of legal level validities.
	 *
	 * @return the number of legal level validities
	 */
	public static int getLegalLevelValiditiesCount() {
		return getService().getLegalLevelValiditiesCount();
	}

	/**
	 * Returns the legal level validity with the primary key.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity
	 * @throws PortalException if a legal level validity with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalLevelValidity
			getLegalLevelValidity(long levelValidityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalLevelValidity(levelValidityId);
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
	 * Updates the legal level validity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalLevelValidity the legal level validity
	 * @return the legal level validity that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalLevelValidity
		updateLegalLevelValidity(
			com.ecoit.elegaldocument.model.LegalLevelValidity
				legalLevelValidity) {

		return getService().updateLegalLevelValidity(legalLevelValidity);
	}

	public static LegalLevelValidityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalLevelValidityLocalService, LegalLevelValidityLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalLevelValidityLocalService.class);

		ServiceTracker
			<LegalLevelValidityLocalService, LegalLevelValidityLocalService>
				serviceTracker =
					new ServiceTracker
						<LegalLevelValidityLocalService,
						 LegalLevelValidityLocalService>(
							 bundle.getBundleContext(),
							 LegalLevelValidityLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}