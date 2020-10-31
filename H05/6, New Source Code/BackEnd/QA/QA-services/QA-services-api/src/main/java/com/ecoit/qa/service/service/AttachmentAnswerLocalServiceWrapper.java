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

package com.ecoit.qa.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AttachmentAnswerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AttachmentAnswerLocalService
 * @generated
 */
public class AttachmentAnswerLocalServiceWrapper
	implements AttachmentAnswerLocalService,
			   ServiceWrapper<AttachmentAnswerLocalService> {

	public AttachmentAnswerLocalServiceWrapper(
		AttachmentAnswerLocalService attachmentAnswerLocalService) {

		_attachmentAnswerLocalService = attachmentAnswerLocalService;
	}

	/**
	 * Adds the attachment answer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was added
	 */
	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer addAttachmentAnswer(
		com.ecoit.qa.service.model.AttachmentAnswer attachmentAnswer) {

		return _attachmentAnswerLocalService.addAttachmentAnswer(
			attachmentAnswer);
	}

	/**
	 * Creates a new attachment answer with the primary key. Does not add the attachment answer to the database.
	 *
	 * @param attachmentAnswerPK the primary key for the new attachment answer
	 * @return the new attachment answer
	 */
	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer createAttachmentAnswer(
		com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
			attachmentAnswerPK) {

		return _attachmentAnswerLocalService.createAttachmentAnswer(
			attachmentAnswerPK);
	}

	@Override
	public void createAttachmentAnswer(long answerId, long attachmentId) {
		_attachmentAnswerLocalService.createAttachmentAnswer(
			answerId, attachmentId);
	}

	/**
	 * Deletes the attachment answer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was removed
	 */
	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer deleteAttachmentAnswer(
		com.ecoit.qa.service.model.AttachmentAnswer attachmentAnswer) {

		return _attachmentAnswerLocalService.deleteAttachmentAnswer(
			attachmentAnswer);
	}

	/**
	 * Deletes the attachment answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer that was removed
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer deleteAttachmentAnswer(
			com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
				attachmentAnswerPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentAnswerLocalService.deleteAttachmentAnswer(
			attachmentAnswerPK);
	}

	@Override
	public void deleteByAnswerId(long answerId) {
		_attachmentAnswerLocalService.deleteByAnswerId(answerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentAnswerLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attachmentAnswerLocalService.dynamicQuery();
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

		return _attachmentAnswerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
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

		return _attachmentAnswerLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
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

		return _attachmentAnswerLocalService.dynamicQuery(
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

		return _attachmentAnswerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _attachmentAnswerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer fetchAttachmentAnswer(
		com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
			attachmentAnswerPK) {

		return _attachmentAnswerLocalService.fetchAttachmentAnswer(
			attachmentAnswerPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _attachmentAnswerLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the attachment answer with the primary key.
	 *
	 * @param attachmentAnswerPK the primary key of the attachment answer
	 * @return the attachment answer
	 * @throws PortalException if a attachment answer with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer getAttachmentAnswer(
			com.ecoit.qa.service.service.persistence.AttachmentAnswerPK
				attachmentAnswerPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentAnswerLocalService.getAttachmentAnswer(
			attachmentAnswerPK);
	}

	/**
	 * Returns a range of all the attachment answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.AttachmentAnswerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of attachment answers
	 * @param end the upper bound of the range of attachment answers (not inclusive)
	 * @return the range of attachment answers
	 */
	@Override
	public java.util.List<com.ecoit.qa.service.model.AttachmentAnswer>
		getAttachmentAnswers(int start, int end) {

		return _attachmentAnswerLocalService.getAttachmentAnswers(start, end);
	}

	/**
	 * Returns the number of attachment answers.
	 *
	 * @return the number of attachment answers
	 */
	@Override
	public int getAttachmentAnswersCount() {
		return _attachmentAnswerLocalService.getAttachmentAnswersCount();
	}

	@Override
	public java.util.List<com.ecoit.qa.service.model.AttachmentAnswer>
		getByAnswerId(long answerId) {

		return _attachmentAnswerLocalService.getByAnswerId(answerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _attachmentAnswerLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _attachmentAnswerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _attachmentAnswerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the attachment answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param attachmentAnswer the attachment answer
	 * @return the attachment answer that was updated
	 */
	@Override
	public com.ecoit.qa.service.model.AttachmentAnswer updateAttachmentAnswer(
		com.ecoit.qa.service.model.AttachmentAnswer attachmentAnswer) {

		return _attachmentAnswerLocalService.updateAttachmentAnswer(
			attachmentAnswer);
	}

	@Override
	public AttachmentAnswerLocalService getWrappedService() {
		return _attachmentAnswerLocalService;
	}

	@Override
	public void setWrappedService(
		AttachmentAnswerLocalService attachmentAnswerLocalService) {

		_attachmentAnswerLocalService = attachmentAnswerLocalService;
	}

	private AttachmentAnswerLocalService _attachmentAnswerLocalService;

}