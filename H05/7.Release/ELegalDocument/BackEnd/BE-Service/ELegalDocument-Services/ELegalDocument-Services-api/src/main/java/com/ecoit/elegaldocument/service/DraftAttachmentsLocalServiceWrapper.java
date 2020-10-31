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
 * Provides a wrapper for {@link DraftAttachmentsLocalService}.
 *
 * @author Liverpool
 * @see DraftAttachmentsLocalService
 * @generated
 */
public class DraftAttachmentsLocalServiceWrapper
	implements DraftAttachmentsLocalService,
			   ServiceWrapper<DraftAttachmentsLocalService> {

	public DraftAttachmentsLocalServiceWrapper(
		DraftAttachmentsLocalService draftAttachmentsLocalService) {

		_draftAttachmentsLocalService = draftAttachmentsLocalService;
	}

	/**
	 * Adds the draft attachments to the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftAttachments the draft attachments
	 * @return the draft attachments that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments addDraftAttachments(
		com.ecoit.elegaldocument.model.DraftAttachments draftAttachments) {

		return _draftAttachmentsLocalService.addDraftAttachments(
			draftAttachments);
	}

	/**
	 * Creates a new draft attachments with the primary key. Does not add the draft attachments to the database.
	 *
	 * @param attachmentId the primary key for the new draft attachments
	 * @return the new draft attachments
	 */
	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments
		createDraftAttachments(long attachmentId) {

		return _draftAttachmentsLocalService.createDraftAttachments(
			attachmentId);
	}

	/**
	 * Deletes the draft attachments from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftAttachments the draft attachments
	 * @return the draft attachments that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments
		deleteDraftAttachments(
			com.ecoit.elegaldocument.model.DraftAttachments draftAttachments) {

		return _draftAttachmentsLocalService.deleteDraftAttachments(
			draftAttachments);
	}

	/**
	 * Deletes the draft attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments that was removed
	 * @throws PortalException if a draft attachments with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments
			deleteDraftAttachments(long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _draftAttachmentsLocalService.deleteDraftAttachments(
			attachmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _draftAttachmentsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _draftAttachmentsLocalService.dynamicQuery();
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

		return _draftAttachmentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl</code>.
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

		return _draftAttachmentsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl</code>.
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

		return _draftAttachmentsLocalService.dynamicQuery(
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

		return _draftAttachmentsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _draftAttachmentsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments
		fetchDraftAttachments(long attachmentId) {

		return _draftAttachmentsLocalService.fetchDraftAttachments(
			attachmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _draftAttachmentsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the draft attachments with the primary key.
	 *
	 * @param attachmentId the primary key of the draft attachments
	 * @return the draft attachments
	 * @throws PortalException if a draft attachments with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments getDraftAttachments(
			long attachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _draftAttachmentsLocalService.getDraftAttachments(attachmentId);
	}

	/**
	 * Returns a range of all the draft attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.DraftAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of draft attachmentses
	 * @param end the upper bound of the range of draft attachmentses (not inclusive)
	 * @return the range of draft attachmentses
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.DraftAttachments>
		getDraftAttachmentses(int start, int end) {

		return _draftAttachmentsLocalService.getDraftAttachmentses(start, end);
	}

	/**
	 * Returns the number of draft attachmentses.
	 *
	 * @return the number of draft attachmentses
	 */
	@Override
	public int getDraftAttachmentsesCount() {
		return _draftAttachmentsLocalService.getDraftAttachmentsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _draftAttachmentsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _draftAttachmentsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _draftAttachmentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the draft attachments in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param draftAttachments the draft attachments
	 * @return the draft attachments that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.DraftAttachments
		updateDraftAttachments(
			com.ecoit.elegaldocument.model.DraftAttachments draftAttachments) {

		return _draftAttachmentsLocalService.updateDraftAttachments(
			draftAttachments);
	}

	@Override
	public DraftAttachmentsLocalService getWrappedService() {
		return _draftAttachmentsLocalService;
	}

	@Override
	public void setWrappedService(
		DraftAttachmentsLocalService draftAttachmentsLocalService) {

		_draftAttachmentsLocalService = draftAttachmentsLocalService;
	}

	private DraftAttachmentsLocalService _draftAttachmentsLocalService;

}