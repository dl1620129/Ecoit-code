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
 * Provides the local service utility for LegalDFRel. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalDFRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalDFRelLocalService
 * @generated
 */
public class LegalDFRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalDFRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal df rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRel the legal df rel
	 * @return the legal df rel that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalDFRel addLegalDFRel(
		com.ecoit.elegaldocument.model.LegalDFRel legalDFRel) {

		return getService().addLegalDFRel(legalDFRel);
	}

	/**
	 * Creates a new legal df rel with the primary key. Does not add the legal df rel to the database.
	 *
	 * @param legalDFRelPK the primary key for the new legal df rel
	 * @return the new legal df rel
	 */
	public static com.ecoit.elegaldocument.model.LegalDFRel createLegalDFRel(
		com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
			legalDFRelPK) {

		return getService().createLegalDFRel(legalDFRelPK);
	}

	/**
	 * Deletes the legal df rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRel the legal df rel
	 * @return the legal df rel that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalDFRel deleteLegalDFRel(
		com.ecoit.elegaldocument.model.LegalDFRel legalDFRel) {

		return getService().deleteLegalDFRel(legalDFRel);
	}

	/**
	 * Deletes the legal df rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel that was removed
	 * @throws PortalException if a legal df rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDFRel deleteLegalDFRel(
			com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
				legalDFRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalDFRel(legalDFRelPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalDFRel fetchLegalDFRel(
		com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
			legalDFRelPK) {

		return getService().fetchLegalDFRel(legalDFRelPK);
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
	 * Returns the legal df rel with the primary key.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel
	 * @throws PortalException if a legal df rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDFRel getLegalDFRel(
			com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
				legalDFRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalDFRel(legalDFRelPK);
	}

	/**
	 * Returns a range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of legal df rels
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalDFRel>
		getLegalDFRels(int start, int end) {

		return getService().getLegalDFRels(start, end);
	}

	/**
	 * Returns the number of legal df rels.
	 *
	 * @return the number of legal df rels
	 */
	public static int getLegalDFRelsCount() {
		return getService().getLegalDFRelsCount();
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
	 * Updates the legal df rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRel the legal df rel
	 * @return the legal df rel that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalDFRel updateLegalDFRel(
		com.ecoit.elegaldocument.model.LegalDFRel legalDFRel) {

		return getService().updateLegalDFRel(legalDFRel);
	}

	public static LegalDFRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDFRelLocalService, LegalDFRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDFRelLocalService.class);

		ServiceTracker<LegalDFRelLocalService, LegalDFRelLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalDFRelLocalService, LegalDFRelLocalService>(
						bundle.getBundleContext(), LegalDFRelLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}