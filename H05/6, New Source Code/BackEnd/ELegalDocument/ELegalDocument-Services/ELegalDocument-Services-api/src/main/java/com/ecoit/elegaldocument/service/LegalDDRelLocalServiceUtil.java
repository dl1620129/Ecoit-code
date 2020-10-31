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
 * Provides the local service utility for LegalDDRel. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalDDRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalDDRelLocalService
 * @generated
 */
public class LegalDDRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalDDRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal dd rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRel the legal dd rel
	 * @return the legal dd rel that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalDDRel addLegalDDRel(
		com.ecoit.elegaldocument.model.LegalDDRel legalDDRel) {

		return getService().addLegalDDRel(legalDDRel);
	}

	/**
	 * Creates a new legal dd rel with the primary key. Does not add the legal dd rel to the database.
	 *
	 * @param legalDDRelPK the primary key for the new legal dd rel
	 * @return the new legal dd rel
	 */
	public static com.ecoit.elegaldocument.model.LegalDDRel createLegalDDRel(
		com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
			legalDDRelPK) {

		return getService().createLegalDDRel(legalDDRelPK);
	}

	/**
	 * Deletes the legal dd rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRel the legal dd rel
	 * @return the legal dd rel that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalDDRel deleteLegalDDRel(
		com.ecoit.elegaldocument.model.LegalDDRel legalDDRel) {

		return getService().deleteLegalDDRel(legalDDRel);
	}

	/**
	 * Deletes the legal dd rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel that was removed
	 * @throws PortalException if a legal dd rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDDRel deleteLegalDDRel(
			com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
				legalDDRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalDDRel(legalDDRelPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalDDRel fetchLegalDDRel(
		com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
			legalDDRelPK) {

		return getService().fetchLegalDDRel(legalDDRelPK);
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
	 * Returns the legal dd rel with the primary key.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel
	 * @throws PortalException if a legal dd rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDDRel getLegalDDRel(
			com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
				legalDDRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalDDRel(legalDDRelPK);
	}

	/**
	 * Returns a range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of legal dd rels
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalDDRel>
		getLegalDDRels(int start, int end) {

		return getService().getLegalDDRels(start, end);
	}

	/**
	 * Returns the number of legal dd rels.
	 *
	 * @return the number of legal dd rels
	 */
	public static int getLegalDDRelsCount() {
		return getService().getLegalDDRelsCount();
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
	 * Updates the legal dd rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRel the legal dd rel
	 * @return the legal dd rel that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalDDRel updateLegalDDRel(
		com.ecoit.elegaldocument.model.LegalDDRel legalDDRel) {

		return getService().updateLegalDDRel(legalDDRel);
	}

	public static LegalDDRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDDRelLocalService, LegalDDRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDDRelLocalService.class);

		ServiceTracker<LegalDDRelLocalService, LegalDDRelLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalDDRelLocalService, LegalDDRelLocalService>(
						bundle.getBundleContext(), LegalDDRelLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}