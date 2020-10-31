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
 * Provides the local service utility for LegalOrg. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalOrgLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalOrgLocalService
 * @generated
 */
public class LegalOrgLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalOrgLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal org to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalOrg the legal org
	 * @return the legal org that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
		com.ecoit.elegaldocument.model.LegalOrg legalOrg) {

		return getService().addLegalOrg(legalOrg);
	}

	/**
	 * Creates a new legal org with the primary key. Does not add the legal org to the database.
	 *
	 * @param organizationId the primary key for the new legal org
	 * @return the new legal org
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg createLegalOrg(
		long organizationId) {

		return getService().createLegalOrg(organizationId);
	}

	/**
	 * Deletes the legal org from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalOrg the legal org
	 * @return the legal org that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg deleteLegalOrg(
		com.ecoit.elegaldocument.model.LegalOrg legalOrg) {

		return getService().deleteLegalOrg(legalOrg);
	}

	/**
	 * Deletes the legal org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org that was removed
	 * @throws PortalException if a legal org with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg deleteLegalOrg(
			long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalOrg(organizationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalOrg fetchLegalOrg(
		long organizationId) {

		return getService().fetchLegalOrg(organizationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getAllOrganizations() {

		return getService().getAllOrganizations();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal org with the primary key.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org
	 * @throws PortalException if a legal org with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg getLegalOrg(
			long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalOrg(organizationId);
	}

	/**
	 * Returns a range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of legal orgs
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getLegalOrgs(int start, int end) {

		return getService().getLegalOrgs(start, end);
	}

	/**
	 * Returns the number of legal orgs.
	 *
	 * @return the number of legal orgs
	 */
	public static int getLegalOrgsCount() {
		return getService().getLegalOrgsCount();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
			getNode(
				long parentId, long groupId, long companyId, String language,
				String name, int start, int limit)
		throws Exception {

		return getService().getNode(
			parentId, groupId, companyId, language, name, start, limit);
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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getPublishOrganizations(
			long parentId, String language, boolean statusOrg, long groupId) {

		return getService().getPublishOrganizations(
			parentId, language, statusOrg, groupId);
	}

	/**
	 * Updates the legal org in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalOrg the legal org
	 * @return the legal org that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalOrg updateLegalOrg(
		com.ecoit.elegaldocument.model.LegalOrg legalOrg) {

		return getService().updateLegalOrg(legalOrg);
	}

	public static LegalOrgLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalOrgLocalService, LegalOrgLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalOrgLocalService.class);

		ServiceTracker<LegalOrgLocalService, LegalOrgLocalService>
			serviceTracker =
				new ServiceTracker<LegalOrgLocalService, LegalOrgLocalService>(
					bundle.getBundleContext(), LegalOrgLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}