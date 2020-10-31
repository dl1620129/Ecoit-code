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
 * Provides the local service utility for LegalDraftDocument. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalDraftDocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalDraftDocumentLocalService
 * @generated
 */
public class LegalDraftDocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalDraftDocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal draft document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDraftDocument the legal draft document
	 * @return the legal draft document that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalDraftDocument
		addLegalDraftDocument(
			com.ecoit.elegaldocument.model.LegalDraftDocument
				legalDraftDocument) {

		return getService().addLegalDraftDocument(legalDraftDocument);
	}

	/**
	 * Creates a new legal draft document with the primary key. Does not add the legal draft document to the database.
	 *
	 * @param draftId the primary key for the new legal draft document
	 * @return the new legal draft document
	 */
	public static com.ecoit.elegaldocument.model.LegalDraftDocument
		createLegalDraftDocument(long draftId) {

		return getService().createLegalDraftDocument(draftId);
	}

	/**
	 * Deletes the legal draft document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDraftDocument the legal draft document
	 * @return the legal draft document that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalDraftDocument
		deleteLegalDraftDocument(
			com.ecoit.elegaldocument.model.LegalDraftDocument
				legalDraftDocument) {

		return getService().deleteLegalDraftDocument(legalDraftDocument);
	}

	/**
	 * Deletes the legal draft document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document that was removed
	 * @throws PortalException if a legal draft document with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDraftDocument
			deleteLegalDraftDocument(long draftId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalDraftDocument(draftId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDraftDocumentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDraftDocumentModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalDraftDocument
		fetchLegalDraftDocument(long draftId) {

		return getService().fetchLegalDraftDocument(draftId);
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
	 * Returns the legal draft document with the primary key.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document
	 * @throws PortalException if a legal draft document with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDraftDocument
			getLegalDraftDocument(long draftId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalDraftDocument(draftId);
	}

	/**
	 * Returns a range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of legal draft documents
	 */
	public static java.util.List
		<com.ecoit.elegaldocument.model.LegalDraftDocument>
			getLegalDraftDocuments(int start, int end) {

		return getService().getLegalDraftDocuments(start, end);
	}

	/**
	 * Returns the number of legal draft documents.
	 *
	 * @return the number of legal draft documents
	 */
	public static int getLegalDraftDocumentsCount() {
		return getService().getLegalDraftDocumentsCount();
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
	 * Updates the legal draft document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDraftDocument the legal draft document
	 * @return the legal draft document that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalDraftDocument
		updateLegalDraftDocument(
			com.ecoit.elegaldocument.model.LegalDraftDocument
				legalDraftDocument) {

		return getService().updateLegalDraftDocument(legalDraftDocument);
	}

	public static LegalDraftDocumentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDraftDocumentLocalService, LegalDraftDocumentLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalDraftDocumentLocalService.class);

		ServiceTracker
			<LegalDraftDocumentLocalService, LegalDraftDocumentLocalService>
				serviceTracker =
					new ServiceTracker
						<LegalDraftDocumentLocalService,
						 LegalDraftDocumentLocalService>(
							 bundle.getBundleContext(),
							 LegalDraftDocumentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}