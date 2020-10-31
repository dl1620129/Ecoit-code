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
 * Provides the local service utility for LegalDocument. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalDocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalDocumentLocalService
 * @generated
 */
public class LegalDocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalDocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDocument the legal document
	 * @return the legal document that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalDocument addLegalDocument(
		com.ecoit.elegaldocument.model.LegalDocument legalDocument) {

		return getService().addLegalDocument(legalDocument);
	}

	/**
	 * Creates a new legal document with the primary key. Does not add the legal document to the database.
	 *
	 * @param docId the primary key for the new legal document
	 * @return the new legal document
	 */
	public static com.ecoit.elegaldocument.model.LegalDocument
		createLegalDocument(long docId) {

		return getService().createLegalDocument(docId);
	}

	/**
	 * Deletes the legal document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDocument the legal document
	 * @return the legal document that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalDocument
		deleteLegalDocument(
			com.ecoit.elegaldocument.model.LegalDocument legalDocument) {

		return getService().deleteLegalDocument(legalDocument);
	}

	/**
	 * Deletes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws PortalException if a legal document with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDocument
			deleteLegalDocument(long docId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalDocument(docId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDocumentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDocumentModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalDocument
		fetchLegalDocument(long docId) {

		return getService().fetchLegalDocument(docId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getByFieldId(long fieldId) {

		return getService().getByFieldId(fieldId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getByOrgId(long orgId) {

		return getService().getByOrgId(orgId);
	}

	public static int getCountByStatusDoc(int statusDoc) {
		return getService().getCountByStatusDoc(statusDoc);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getLatestDocument(
			int isPublic, int limit, long groupId, String language) {

		return getService().getLatestDocument(
			isPublic, limit, groupId, language);
	}

	/**
	 * Returns the legal document with the primary key.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document
	 * @throws PortalException if a legal document with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalDocument getLegalDocument(
			long docId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalDocument(docId);
	}

	/**
	 * Returns a range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of legal documents
	 */
	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getLegalDocuments(int start, int end) {

		return getService().getLegalDocuments(start, end);
	}

	/**
	 * Returns the number of legal documents.
	 *
	 * @return the number of legal documents
	 */
	public static int getLegalDocumentsCount() {
		return getService().getLegalDocumentsCount();
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

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getPopularDocument(int limit, long groupId, String language) {

		return getService().getPopularDocument(limit, groupId, language);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getSuggestedDocument(
			long groupId, long companyId, String language, String searchKey,
			int statusDoc, int limit) {

		return getService().getSuggestedDocument(
			groupId, companyId, language, searchKey, statusDoc, limit);
	}

	public static void removeDocumentByDocId(long docId) throws Exception {
		getService().removeDocumentByDocId(docId);
	}

	public static void resetFieldId(long fieldId) {
		getService().resetFieldId(fieldId);
	}

	public static void resetOrganizationId(long organizationId) {
		getService().resetOrganizationId(organizationId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		searchLegalDocument(
			int statusDoc, long groupId, long companyId, String language,
			java.util.HashMap<String, Object> searchValues) {

		return getService().searchLegalDocument(
			statusDoc, groupId, companyId, language, searchValues);
	}

	public static void updateCreateLegalDocument(
			com.ecoit.elegaldocument.model.LegalDocument legalDocument,
			java.util.List<Long> attachmentIds, long[] typeIds,
			java.util.List<Long> signerIds, long userId)
		throws Exception {

		getService().updateCreateLegalDocument(
			legalDocument, attachmentIds, typeIds, signerIds, userId);
	}

	/**
	 * Updates the legal document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDocument the legal document
	 * @return the legal document that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalDocument
		updateLegalDocument(
			com.ecoit.elegaldocument.model.LegalDocument legalDocument) {

		return getService().updateLegalDocument(legalDocument);
	}

	public static void updateNewGopY(long docId, boolean newGopY) {
		getService().updateNewGopY(docId, newGopY);
	}

	public static void updateStatusDoc(long docId, int statusDoc, long userId)
		throws Exception {

		getService().updateStatusDoc(docId, statusDoc, userId);
	}

	public static LegalDocumentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDocumentLocalService, LegalDocumentLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalDocumentLocalService.class);

		ServiceTracker<LegalDocumentLocalService, LegalDocumentLocalService>
			serviceTracker =
				new ServiceTracker
					<LegalDocumentLocalService, LegalDocumentLocalService>(
						bundle.getBundleContext(),
						LegalDocumentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}