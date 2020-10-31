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
 * Provides the local service utility for LegalTDRel. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalTDRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalTDRelLocalService
 * @generated
 */
public class LegalTDRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalTDRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal td rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRel the legal td rel
	 * @return the legal td rel that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalTDRel addLegalTDRel(
		com.ecoit.elegaldocument.model.LegalTDRel legalTDRel) {

		return getService().addLegalTDRel(legalTDRel);
	}

	/**
	 * Creates a new legal td rel with the primary key. Does not add the legal td rel to the database.
	 *
	 * @param legalTDRelPK the primary key for the new legal td rel
	 * @return the new legal td rel
	 */
	public static com.ecoit.elegaldocument.model.LegalTDRel createLegalTDRel(
		com.ecoit.elegaldocument.service.persistence.LegalTDRelPK
			legalTDRelPK) {

		return getService().createLegalTDRel(legalTDRelPK);
	}

	/**
	 * Deletes the legal td rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRel the legal td rel
	 * @return the legal td rel that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalTDRel deleteLegalTDRel(
		com.ecoit.elegaldocument.model.LegalTDRel legalTDRel) {

		return getService().deleteLegalTDRel(legalTDRel);
	}

	/**
	 * Deletes the legal td rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel that was removed
	 * @throws PortalException if a legal td rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalTDRel deleteLegalTDRel(
			com.ecoit.elegaldocument.service.persistence.LegalTDRelPK
				legalTDRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalTDRel(legalTDRelPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTDRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTDRelModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalTDRel fetchLegalTDRel(
		com.ecoit.elegaldocument.service.persistence.LegalTDRelPK
			legalTDRelPK) {

		return getService().fetchLegalTDRel(legalTDRelPK);
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
	 * Returns the legal td rel with the primary key.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel
	 * @throws PortalException if a legal td rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalTDRel getLegalTDRel(
			com.ecoit.elegaldocument.service.persistence.LegalTDRelPK
				legalTDRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalTDRel(legalTDRelPK);
	}

	/**
	 * Returns a range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of legal td rels
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalTDRel>
		getLegalTDRels(int start, int end) {

		return getService().getLegalTDRels(start, end);
	}

	/**
	 * Returns the number of legal td rels.
	 *
	 * @return the number of legal td rels
	 */
	public static int getLegalTDRelsCount() {
		return getService().getLegalTDRelsCount();
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
	 * Updates the legal td rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRel the legal td rel
	 * @return the legal td rel that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalTDRel updateLegalTDRel(
		com.ecoit.elegaldocument.model.LegalTDRel legalTDRel) {

		return getService().updateLegalTDRel(legalTDRel);
	}

	public static LegalTDRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalTDRelLocalService, LegalTDRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalTDRelLocalService.class);

		ServiceTracker<LegalTDRelLocalService, LegalTDRelLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalTDRelLocalService, LegalTDRelLocalService>(
						bundle.getBundleContext(), LegalTDRelLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}