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
 * Provides the local service utility for LegalDTypeRel. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalDTypeRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalDTypeRelLocalService
 * @generated
 */
public class LegalDTypeRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalDTypeRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal d type rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRel the legal d type rel
	 * @return the legal d type rel that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalDTypeRel addLegalDTypeRel(
		com.ecoit.elegaldocument.model.LegalDTypeRel legalDTypeRel) {

		return getService().addLegalDTypeRel(legalDTypeRel);
	}

	/**
	 * Creates a new legal d type rel with the primary key. Does not add the legal d type rel to the database.
	 *
	 * @param legalDTypeRelPK the primary key for the new legal d type rel
	 * @return the new legal d type rel
	 */
	public static com.ecoit.elegaldocument.model.LegalDTypeRel
		createLegalDTypeRel(
			com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
				legalDTypeRelPK) {

		return getService().createLegalDTypeRel(legalDTypeRelPK);
	}

	public static void createLegalDTypeRel(long docId, long typeId) {
		getService().createLegalDTypeRel(docId, typeId);
	}

	/**
	 * Deletes the legal d type rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRel the legal d type rel
	 * @return the legal d type rel that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalDTypeRel
		deleteLegalDTypeRel(
			com.ecoit.elegaldocument.model.LegalDTypeRel legalDTypeRel) {

		return getService().deleteLegalDTypeRel(legalDTypeRel);
	}

	/**
	 * Deletes the legal d type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel that was removed
	 * @throws PortalException if a legal d type rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDTypeRel
			deleteLegalDTypeRel(
				com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
					legalDTypeRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalDTypeRel(legalDTypeRelPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalDTypeRel
		fetchLegalDTypeRel(
			com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
				legalDTypeRelPK) {

		return getService().fetchLegalDTypeRel(legalDTypeRelPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDTypeRel>
		getByDocId(long docId) {

		return getService().getByDocId(docId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDTypeRel>
		getByTypeId(long typeId) {

		return getService().getByTypeId(typeId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal d type rel with the primary key.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel
	 * @throws PortalException if a legal d type rel with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDTypeRel getLegalDTypeRel(
			com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
				legalDTypeRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalDTypeRel(legalDTypeRelPK);
	}

	/**
	 * Returns a range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of legal d type rels
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalDTypeRel>
		getLegalDTypeRels(int start, int end) {

		return getService().getLegalDTypeRels(start, end);
	}

	/**
	 * Returns the number of legal d type rels.
	 *
	 * @return the number of legal d type rels
	 */
	public static int getLegalDTypeRelsCount() {
		return getService().getLegalDTypeRelsCount();
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

	public static boolean hasDocumentType(long docId, long typeId) {
		return getService().hasDocumentType(docId, typeId);
	}

	public static void removeByTypeId(long typeId) {
		getService().removeByTypeId(typeId);
	}

	/**
	 * Updates the legal d type rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRel the legal d type rel
	 * @return the legal d type rel that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalDTypeRel
		updateLegalDTypeRel(
			com.ecoit.elegaldocument.model.LegalDTypeRel legalDTypeRel) {

		return getService().updateLegalDTypeRel(legalDTypeRel);
	}

	public static LegalDTypeRelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDTypeRelLocalService, LegalDTypeRelLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalDTypeRelLocalService.class);

		ServiceTracker<LegalDTypeRelLocalService, LegalDTypeRelLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalDTypeRelLocalService, LegalDTypeRelLocalService>(
						bundle.getBundleContext(),
						LegalDTypeRelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}