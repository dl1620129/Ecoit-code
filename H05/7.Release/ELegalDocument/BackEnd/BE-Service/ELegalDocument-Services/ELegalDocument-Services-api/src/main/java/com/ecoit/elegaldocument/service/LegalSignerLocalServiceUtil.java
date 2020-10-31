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
 * Provides the local service utility for LegalSigner. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalSignerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalSignerLocalService
 * @generated
 */
public class LegalSignerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalSignerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal signer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSigner the legal signer
	 * @return the legal signer that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalSigner addLegalSigner(
		com.ecoit.elegaldocument.model.LegalSigner legalSigner) {

		return getService().addLegalSigner(legalSigner);
	}

	public static int countTotalLegalSigner(
		String name, long groupId, long companyId) {

		return getService().countTotalLegalSigner(name, groupId, companyId);
	}

	/**
	 * Creates a new legal signer with the primary key. Does not add the legal signer to the database.
	 *
	 * @param sigId the primary key for the new legal signer
	 * @return the new legal signer
	 */
	public static com.ecoit.elegaldocument.model.LegalSigner createLegalSigner(
		long sigId) {

		return getService().createLegalSigner(sigId);
	}

	public static com.ecoit.elegaldocument.model.LegalSigner
			createUpdateLegalSigner(
				long sigId, long groupId, long companyId, long userId,
				String firstName, String lastName, String language,
				boolean statusSigner)
		throws Exception {

		return getService().createUpdateLegalSigner(
			sigId, groupId, companyId, userId, firstName, lastName, language,
			statusSigner);
	}

	/**
	 * Deletes the legal signer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSigner the legal signer
	 * @return the legal signer that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalSigner deleteLegalSigner(
		com.ecoit.elegaldocument.model.LegalSigner legalSigner) {

		return getService().deleteLegalSigner(legalSigner);
	}

	/**
	 * Deletes the legal signer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer that was removed
	 * @throws PortalException if a legal signer with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalSigner deleteLegalSigner(
			long sigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalSigner(sigId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalSigner fetchLegalSigner(
		long sigId) {

		return getService().fetchLegalSigner(sigId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalSigner>
		getByDocumentId(long documentId) {

		return getService().getByDocumentId(documentId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal signer with the primary key.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer
	 * @throws PortalException if a legal signer with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalSigner getLegalSigner(
			long sigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalSigner(sigId);
	}

	/**
	 * Returns a range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of legal signers
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalSigner>
		getLegalSigners(int start, int end) {

		return getService().getLegalSigners(start, end);
	}

	/**
	 * Returns the number of legal signers.
	 *
	 * @return the number of legal signers
	 */
	public static int getLegalSignersCount() {
		return getService().getLegalSignersCount();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalSigner>
		getListLegalSigner(
			String name, long groupId, long companyId, int start, int limit) {

		return getService().getListLegalSigner(
			name, groupId, companyId, start, limit);
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
	 * Updates the legal signer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalSigner the legal signer
	 * @return the legal signer that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalSigner updateLegalSigner(
		com.ecoit.elegaldocument.model.LegalSigner legalSigner) {

		return getService().updateLegalSigner(legalSigner);
	}

	public static LegalSignerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalSignerLocalService, LegalSignerLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalSignerLocalService.class);

		ServiceTracker<LegalSignerLocalService, LegalSignerLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalSignerLocalService, LegalSignerLocalService>(
						bundle.getBundleContext(),
						LegalSignerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}