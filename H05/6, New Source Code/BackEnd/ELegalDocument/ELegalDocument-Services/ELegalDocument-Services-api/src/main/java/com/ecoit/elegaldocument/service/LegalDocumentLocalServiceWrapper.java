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
 * Provides a wrapper for {@link LegalDocumentLocalService}.
 *
 * @author Liverpool
 * @see LegalDocumentLocalService
 * @generated
 */
public class LegalDocumentLocalServiceWrapper
	implements LegalDocumentLocalService,
			   ServiceWrapper<LegalDocumentLocalService> {

	public LegalDocumentLocalServiceWrapper(
		LegalDocumentLocalService legalDocumentLocalService) {

		_legalDocumentLocalService = legalDocumentLocalService;
	}

	/**
	 * Adds the legal document to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDocument the legal document
	 * @return the legal document that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDocument addLegalDocument(
		com.ecoit.elegaldocument.model.LegalDocument legalDocument) {

		return _legalDocumentLocalService.addLegalDocument(legalDocument);
	}

	/**
	 * Creates a new legal document with the primary key. Does not add the legal document to the database.
	 *
	 * @param docId the primary key for the new legal document
	 * @return the new legal document
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDocument createLegalDocument(
		long docId) {

		return _legalDocumentLocalService.createLegalDocument(docId);
	}

	/**
	 * Deletes the legal document from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDocument the legal document
	 * @return the legal document that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDocument deleteLegalDocument(
		com.ecoit.elegaldocument.model.LegalDocument legalDocument) {

		return _legalDocumentLocalService.deleteLegalDocument(legalDocument);
	}

	/**
	 * Deletes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws PortalException if a legal document with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDocument deleteLegalDocument(
			long docId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDocumentLocalService.deleteLegalDocument(docId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDocumentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDocumentLocalService.dynamicQuery();
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

		return _legalDocumentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _legalDocumentLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _legalDocumentLocalService.dynamicQuery(
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

		return _legalDocumentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDocumentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDocument fetchLegalDocument(
		long docId) {

		return _legalDocumentLocalService.fetchLegalDocument(docId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDocumentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getByFieldId(long fieldId) {

		return _legalDocumentLocalService.getByFieldId(fieldId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getByOrgId(long orgId) {

		return _legalDocumentLocalService.getByOrgId(orgId);
	}

	@Override
	public int getCountByStatusDoc(int statusDoc) {
		return _legalDocumentLocalService.getCountByStatusDoc(statusDoc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDocumentLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getLatestDocument(
			int isPublic, int limit, long groupId, String language) {

		return _legalDocumentLocalService.getLatestDocument(
			isPublic, limit, groupId, language);
	}

	/**
	 * Returns the legal document with the primary key.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document
	 * @throws PortalException if a legal document with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDocument getLegalDocument(
			long docId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDocumentLocalService.getLegalDocument(docId);
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
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getLegalDocuments(int start, int end) {

		return _legalDocumentLocalService.getLegalDocuments(start, end);
	}

	/**
	 * Returns the number of legal documents.
	 *
	 * @return the number of legal documents
	 */
	@Override
	public int getLegalDocumentsCount() {
		return _legalDocumentLocalService.getLegalDocumentsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDocumentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDocumentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getPopularDocument(int limit, long groupId, String language) {

		return _legalDocumentLocalService.getPopularDocument(
			limit, groupId, language);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		getSuggestedDocument(
			long groupId, long companyId, String language, String searchKey,
			int statusDoc, int limit) {

		return _legalDocumentLocalService.getSuggestedDocument(
			groupId, companyId, language, searchKey, statusDoc, limit);
	}

	@Override
	public void removeDocumentByDocId(long docId) throws Exception {
		_legalDocumentLocalService.removeDocumentByDocId(docId);
	}

	@Override
	public void resetFieldId(long fieldId) {
		_legalDocumentLocalService.resetFieldId(fieldId);
	}

	@Override
	public void resetOrganizationId(long organizationId) {
		_legalDocumentLocalService.resetOrganizationId(organizationId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDocument>
		searchLegalDocument(
			int statusDoc, long groupId, long companyId, String language,
			java.util.HashMap<String, Object> searchValues) {

		return _legalDocumentLocalService.searchLegalDocument(
			statusDoc, groupId, companyId, language, searchValues);
	}

	@Override
	public void updateCreateLegalDocument(
			com.ecoit.elegaldocument.model.LegalDocument legalDocument,
			java.util.List<Long> attachmentIds, long[] typeIds,
			java.util.List<Long> signerIds, long userId)
		throws Exception {

		_legalDocumentLocalService.updateCreateLegalDocument(
			legalDocument, attachmentIds, typeIds, signerIds, userId);
	}

	/**
	 * Updates the legal document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDocument the legal document
	 * @return the legal document that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDocument updateLegalDocument(
		com.ecoit.elegaldocument.model.LegalDocument legalDocument) {

		return _legalDocumentLocalService.updateLegalDocument(legalDocument);
	}

	@Override
	public void updateNewGopY(long docId, boolean newGopY) {
		_legalDocumentLocalService.updateNewGopY(docId, newGopY);
	}

	@Override
	public void updateStatusDoc(long docId, int statusDoc, long userId)
		throws Exception {

		_legalDocumentLocalService.updateStatusDoc(docId, statusDoc, userId);
	}

	@Override
	public LegalDocumentLocalService getWrappedService() {
		return _legalDocumentLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDocumentLocalService legalDocumentLocalService) {

		_legalDocumentLocalService = legalDocumentLocalService;
	}

	private LegalDocumentLocalService _legalDocumentLocalService;

}