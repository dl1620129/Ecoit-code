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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LegalSuggestDocumentLocalService}.
 *
 * @author Liverpool
 * @see LegalSuggestDocumentLocalService
 * @generated
 */
public class LegalSuggestDocumentLocalServiceWrapper
	implements LegalSuggestDocumentLocalService,
			   ServiceWrapper<LegalSuggestDocumentLocalService> {

	public LegalSuggestDocumentLocalServiceWrapper(
		LegalSuggestDocumentLocalService legalSuggestDocumentLocalService) {

		_legalSuggestDocumentLocalService = legalSuggestDocumentLocalService;
	}

	/**
	 * Adds the legal suggest document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
		addLegalSuggestDocument(
			com.ecoit.elegaldocument.model.LegalSuggestDocument
				legalSuggestDocument) {

		return _legalSuggestDocumentLocalService.addLegalSuggestDocument(
			legalSuggestDocument);
	}

	@Override
	public void approvedSuggestion(long sugId, boolean approved, long userId) {
		_legalSuggestDocumentLocalService.approvedSuggestion(
			sugId, approved, userId);
	}

	@Override
	public int countSuggestions(long docId, String language) {
		return _legalSuggestDocumentLocalService.countSuggestions(
			docId, language);
	}

	/**
	 * Creates a new legal suggest document with the primary key. Does not add the legal suggest document to the database.
	 *
	 * @param sugId the primary key for the new legal suggest document
	 * @return the new legal suggest document
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
		createLegalSuggestDocument(long sugId) {

		return _legalSuggestDocumentLocalService.createLegalSuggestDocument(
			sugId);
	}

	@Override
	public void createUpdateSuggestion(
		long legalSuggestId, long docId, long groupId, String language,
		long userId, String userName, String email, String title,
		String content, boolean isApproved) {

		_legalSuggestDocumentLocalService.createUpdateSuggestion(
			legalSuggestId, docId, groupId, language, userId, userName, email,
			title, content, isApproved);
	}

	/**
	 * Deletes the legal suggest document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
		deleteLegalSuggestDocument(
			com.ecoit.elegaldocument.model.LegalSuggestDocument
				legalSuggestDocument) {

		return _legalSuggestDocumentLocalService.deleteLegalSuggestDocument(
			legalSuggestDocument);
	}

	/**
	 * Deletes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws PortalException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
			deleteLegalSuggestDocument(long sugId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSuggestDocumentLocalService.deleteLegalSuggestDocument(
			sugId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSuggestDocumentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalSuggestDocumentLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _legalSuggestDocumentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _legalSuggestDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _legalSuggestDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _legalSuggestDocumentLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _legalSuggestDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
		fetchLegalSuggestDocument(long sugId) {

		return _legalSuggestDocumentLocalService.fetchLegalSuggestDocument(
			sugId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalSuggestDocumentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalSuggestDocument>
		getApprovedSuggestions(
			long docId, String language, boolean isApproved, int start,
			int limit) {

		return _legalSuggestDocumentLocalService.getApprovedSuggestions(
			docId, language, isApproved, start, limit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalSuggestDocumentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal suggest document with the primary key.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws PortalException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
			getLegalSuggestDocument(long sugId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSuggestDocumentLocalService.getLegalSuggestDocument(sugId);
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
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalSuggestDocument>
		getLegalSuggestDocuments(int start, int end) {

		return _legalSuggestDocumentLocalService.getLegalSuggestDocuments(
			start, end);
	}

	/**
	 * Returns the number of legal suggest documents.
	 *
	 * @return the number of legal suggest documents
	 */
	@Override
	public int getLegalSuggestDocumentsCount() {
		return _legalSuggestDocumentLocalService.
			getLegalSuggestDocumentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalSuggestDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSuggestDocumentLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalSuggestDocument>
		getSuggestions(long docId, String language, int start, int limit) {

		return _legalSuggestDocumentLocalService.getSuggestions(
			docId, language, start, limit);
	}

	@Override
	public void removeByDocId(long docId) {
		_legalSuggestDocumentLocalService.removeByDocId(docId);
	}

	/**
	 * Updates the legal suggest document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 * @return the legal suggest document that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSuggestDocument
		updateLegalSuggestDocument(
			com.ecoit.elegaldocument.model.LegalSuggestDocument
				legalSuggestDocument) {

		return _legalSuggestDocumentLocalService.updateLegalSuggestDocument(
			legalSuggestDocument);
	}

	@Override
	public LegalSuggestDocumentLocalService getWrappedService() {
		return _legalSuggestDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		LegalSuggestDocumentLocalService legalSuggestDocumentLocalService) {

		_legalSuggestDocumentLocalService = legalSuggestDocumentLocalService;
	}

	private LegalSuggestDocumentLocalService _legalSuggestDocumentLocalService;

}