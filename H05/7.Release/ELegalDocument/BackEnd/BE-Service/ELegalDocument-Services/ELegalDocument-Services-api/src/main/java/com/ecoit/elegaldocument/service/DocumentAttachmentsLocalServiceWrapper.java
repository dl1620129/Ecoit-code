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
 * Provides a wrapper for {@link DocumentAttachmentsLocalService}.
 *
 * @author Liverpool
 * @see DocumentAttachmentsLocalService
 * @generated
 */
public class DocumentAttachmentsLocalServiceWrapper
	implements DocumentAttachmentsLocalService,
			   ServiceWrapper<DocumentAttachmentsLocalService> {

	public DocumentAttachmentsLocalServiceWrapper(
		DocumentAttachmentsLocalService documentAttachmentsLocalService) {

		_documentAttachmentsLocalService = documentAttachmentsLocalService;
	}

	/**
	 * Adds the document attachments to the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentAttachments the document attachments
	 * @return the document attachments that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
		addDocumentAttachments(
			com.ecoit.elegaldocument.model.DocumentAttachments
				documentAttachments) {

		return _documentAttachmentsLocalService.addDocumentAttachments(
			documentAttachments);
	}

	/**
	 * Creates a new document attachments with the primary key. Does not add the document attachments to the database.
	 *
	 * @param attachmentId the primary key for the new document attachments
	 * @return the new document attachments
	 */
	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
		createDocumentAttachments(long attachmentId) {

		return _documentAttachmentsLocalService.createDocumentAttachments(
			attachmentId);
	}

	/**
	 * Deletes the document attachments from the database. Also notifies the appropriate model listeners.
	 *
	 * @param documentAttachments the document attachments
	 * @return the document attachments that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
		deleteDocumentAttachments(
			com.ecoit.elegaldocument.model.DocumentAttachments
				documentAttachments) {

		return _documentAttachmentsLocalService.deleteDocumentAttachments(
			documentAttachments);
	}

	/**
	 * Deletes the document attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments that was removed
	 * @throws PortalException if a document attachments with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
			deleteDocumentAttachments(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentAttachmentsLocalService.deleteDocumentAttachments(
			attachmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentAttachmentsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentAttachmentsLocalService.dynamicQuery();
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

		return _documentAttachmentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DocumentAttachmentsModelImpl</code>.
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

		return _documentAttachmentsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DocumentAttachmentsModelImpl</code>.
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

		return _documentAttachmentsLocalService.dynamicQuery(
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

		return _documentAttachmentsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _documentAttachmentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
		fetchDocumentAttachments(long attachmentId) {

		return _documentAttachmentsLocalService.fetchDocumentAttachments(
			attachmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _documentAttachmentsLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.DocumentAttachments>
		getAttachmentsByDocId(long docId) {

		return _documentAttachmentsLocalService.getAttachmentsByDocId(docId);
	}

	/**
	 * Returns the document attachments with the primary key.
	 *
	 * @param attachmentId the primary key of the document attachments
	 * @return the document attachments
	 * @throws PortalException if a document attachments with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
			getDocumentAttachments(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentAttachmentsLocalService.getDocumentAttachments(
			attachmentId);
	}

	/**
	 * Returns a range of all the document attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DocumentAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document attachmentses
	 * @param end the upper bound of the range of document attachmentses (not inclusive)
	 * @return the range of document attachmentses
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.DocumentAttachments>
		getDocumentAttachmentses(int start, int end) {

		return _documentAttachmentsLocalService.getDocumentAttachmentses(
			start, end);
	}

	/**
	 * Returns the number of document attachmentses.
	 *
	 * @return the number of document attachmentses
	 */
	@Override
	public int getDocumentAttachmentsesCount() {
		return _documentAttachmentsLocalService.getDocumentAttachmentsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _documentAttachmentsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentAttachmentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _documentAttachmentsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the document attachments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param documentAttachments the document attachments
	 * @return the document attachments that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.DocumentAttachments
		updateDocumentAttachments(
			com.ecoit.elegaldocument.model.DocumentAttachments
				documentAttachments) {

		return _documentAttachmentsLocalService.updateDocumentAttachments(
			documentAttachments);
	}

	@Override
	public DocumentAttachmentsLocalService getWrappedService() {
		return _documentAttachmentsLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentAttachmentsLocalService documentAttachmentsLocalService) {

		_documentAttachmentsLocalService = documentAttachmentsLocalService;
	}

	private DocumentAttachmentsLocalService _documentAttachmentsLocalService;

}