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
 * Provides a wrapper for {@link LegalDraftDocumentLocalService}.
 *
 * @author Liverpool
 * @see LegalDraftDocumentLocalService
 * @generated
 */
public class LegalDraftDocumentLocalServiceWrapper
	implements LegalDraftDocumentLocalService,
			   ServiceWrapper<LegalDraftDocumentLocalService> {

	public LegalDraftDocumentLocalServiceWrapper(
		LegalDraftDocumentLocalService legalDraftDocumentLocalService) {

		_legalDraftDocumentLocalService = legalDraftDocumentLocalService;
	}

	/**
	 * Adds the legal draft document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDraftDocument the legal draft document
	 * @return the legal draft document that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
		addLegalDraftDocument(
			com.ecoit.elegaldocument.model.LegalDraftDocument
				legalDraftDocument) {

		return _legalDraftDocumentLocalService.addLegalDraftDocument(
			legalDraftDocument);
	}

	/**
	 * Creates a new legal draft document with the primary key. Does not add the legal draft document to the database.
	 *
	 * @param draftId the primary key for the new legal draft document
	 * @return the new legal draft document
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
		createLegalDraftDocument(long draftId) {

		return _legalDraftDocumentLocalService.createLegalDraftDocument(
			draftId);
	}

	/**
	 * Deletes the legal draft document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDraftDocument the legal draft document
	 * @return the legal draft document that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
		deleteLegalDraftDocument(
			com.ecoit.elegaldocument.model.LegalDraftDocument
				legalDraftDocument) {

		return _legalDraftDocumentLocalService.deleteLegalDraftDocument(
			legalDraftDocument);
	}

	/**
	 * Deletes the legal draft document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document that was removed
	 * @throws PortalException if a legal draft document with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
			deleteLegalDraftDocument(long draftId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDraftDocumentLocalService.deleteLegalDraftDocument(
			draftId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDraftDocumentLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDraftDocumentLocalService.dynamicQuery();
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

		return _legalDraftDocumentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _legalDraftDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _legalDraftDocumentLocalService.dynamicQuery(
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

		return _legalDraftDocumentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDraftDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
		fetchLegalDraftDocument(long draftId) {

		return _legalDraftDocumentLocalService.fetchLegalDraftDocument(draftId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDraftDocumentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDraftDocumentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal draft document with the primary key.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document
	 * @throws PortalException if a legal draft document with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
			getLegalDraftDocument(long draftId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDraftDocumentLocalService.getLegalDraftDocument(draftId);
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
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDraftDocument>
		getLegalDraftDocuments(int start, int end) {

		return _legalDraftDocumentLocalService.getLegalDraftDocuments(
			start, end);
	}

	/**
	 * Returns the number of legal draft documents.
	 *
	 * @return the number of legal draft documents
	 */
	@Override
	public int getLegalDraftDocumentsCount() {
		return _legalDraftDocumentLocalService.getLegalDraftDocumentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDraftDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDraftDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal draft document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDraftDocument the legal draft document
	 * @return the legal draft document that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDraftDocument
		updateLegalDraftDocument(
			com.ecoit.elegaldocument.model.LegalDraftDocument
				legalDraftDocument) {

		return _legalDraftDocumentLocalService.updateLegalDraftDocument(
			legalDraftDocument);
	}

	@Override
	public LegalDraftDocumentLocalService getWrappedService() {
		return _legalDraftDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDraftDocumentLocalService legalDraftDocumentLocalService) {

		_legalDraftDocumentLocalService = legalDraftDocumentLocalService;
	}

	private LegalDraftDocumentLocalService _legalDraftDocumentLocalService;

}