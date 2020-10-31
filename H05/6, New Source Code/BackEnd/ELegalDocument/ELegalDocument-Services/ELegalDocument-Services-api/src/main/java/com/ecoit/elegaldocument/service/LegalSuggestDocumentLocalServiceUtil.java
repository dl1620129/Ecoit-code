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
 * Provides the local service utility for LegalSuggestDocument. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.LegalSuggestDocumentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see LegalSuggestDocumentLocalService
 * @generated
 */
public class LegalSuggestDocumentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.LegalSuggestDocumentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the legal suggest document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was added
	 */
	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
		addLegalSuggestDocument(
			com.ecoit.elegaldocument.model.LegalSuggestDocument
				legalSuggestDocument) {

		return getService().addLegalSuggestDocument(legalSuggestDocument);
	}

	public static void approvedSuggestion(
		long sugId, boolean approved, long userId) {

		getService().approvedSuggestion(sugId, approved, userId);
	}

	public static int countSuggestions(long docId, String language) {
		return getService().countSuggestions(docId, language);
	}

	/**
	 * Creates a new legal suggest document with the primary key. Does not add the legal suggest document to the database.
	 *
	 * @param sugId the primary key for the new legal suggest document
	 * @return the new legal suggest document
	 */
	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
		createLegalSuggestDocument(long sugId) {

		return getService().createLegalSuggestDocument(sugId);
	}

	public static void createUpdateSuggestion(
		long legalSuggestId, long docId, long groupId, String language,
		long userId, String userName, String email, String title,
		String content, boolean isApproved) {

		getService().createUpdateSuggestion(
			legalSuggestId, docId, groupId, language, userId, userName, email,
			title, content, isApproved);
	}

	/**
	 * Deletes the legal suggest document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was removed
	 */
	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
		deleteLegalSuggestDocument(
			com.ecoit.elegaldocument.model.LegalSuggestDocument
				legalSuggestDocument) {

		return getService().deleteLegalSuggestDocument(legalSuggestDocument);
	}

	/**
	 * Deletes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws PortalException if a legal suggest document with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
			deleteLegalSuggestDocument(long sugId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLegalSuggestDocument(sugId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl</code>.
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

	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
		fetchLegalSuggestDocument(long sugId) {

		return getService().fetchLegalSuggestDocument(sugId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.ecoit.elegaldocument.model.LegalSuggestDocument>
			getApprovedSuggestions(
				long docId, String language, boolean isApproved, int start,
				int limit) {

		return getService().getApprovedSuggestions(
			docId, language, isApproved, start, limit);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal suggest document with the primary key.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws PortalException if a legal suggest document with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
			getLegalSuggestDocument(long sugId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLegalSuggestDocument(sugId);
	}

	/**
	 * Returns a range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of legal suggest documents
	 */
	public static java.util.List
		<com.ecoit.elegaldocument.model.LegalSuggestDocument>
			getLegalSuggestDocuments(int start, int end) {

		return getService().getLegalSuggestDocuments(start, end);
	}

	/**
	 * Returns the number of legal suggest documents.
	 *
	 * @return the number of legal suggest documents
	 */
	public static int getLegalSuggestDocumentsCount() {
		return getService().getLegalSuggestDocumentsCount();
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

	public static java.util.List
		<com.ecoit.elegaldocument.model.LegalSuggestDocument> getSuggestions(
			long docId, String language, int start, int limit) {

		return getService().getSuggestions(docId, language, start, limit);
	}

	public static void removeByDocId(long docId) {
		getService().removeByDocId(docId);
	}

	/**
	 * Updates the legal suggest document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was updated
	 */
	public static com.ecoit.elegaldocument.model.LegalSuggestDocument
		updateLegalSuggestDocument(
			com.ecoit.elegaldocument.model.LegalSuggestDocument
				legalSuggestDocument) {

		return getService().updateLegalSuggestDocument(legalSuggestDocument);
	}

	public static LegalSuggestDocumentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalSuggestDocumentLocalService, LegalSuggestDocumentLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LegalSuggestDocumentLocalService.class);

		ServiceTracker
			<LegalSuggestDocumentLocalService, LegalSuggestDocumentLocalService>
				serviceTracker =
					new ServiceTracker
						<LegalSuggestDocumentLocalService,
						 LegalSuggestDocumentLocalService>(
							 bundle.getBundleContext(),
							 LegalSuggestDocumentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}