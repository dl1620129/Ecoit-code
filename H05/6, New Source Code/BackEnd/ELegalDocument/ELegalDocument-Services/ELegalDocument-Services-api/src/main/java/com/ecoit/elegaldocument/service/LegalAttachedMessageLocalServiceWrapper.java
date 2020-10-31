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
 * Provides a wrapper for {@link LegalAttachedMessageLocalService}.
 *
 * @author Liverpool
 * @see LegalAttachedMessageLocalService
 * @generated
 */
public class LegalAttachedMessageLocalServiceWrapper
	implements LegalAttachedMessageLocalService,
			   ServiceWrapper<LegalAttachedMessageLocalService> {

	public LegalAttachedMessageLocalServiceWrapper(
		LegalAttachedMessageLocalService legalAttachedMessageLocalService) {

		_legalAttachedMessageLocalService = legalAttachedMessageLocalService;
	}

	/**
	 * Adds the legal attached message to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalAttachedMessage the legal attached message
	 * @return the legal attached message that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
		addLegalAttachedMessage(
			com.ecoit.elegaldocument.model.LegalAttachedMessage
				legalAttachedMessage) {

		return _legalAttachedMessageLocalService.addLegalAttachedMessage(
			legalAttachedMessage);
	}

	/**
	 * Creates a new legal attached message with the primary key. Does not add the legal attached message to the database.
	 *
	 * @param messageId the primary key for the new legal attached message
	 * @return the new legal attached message
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
		createLegalAttachedMessage(String messageId) {

		return _legalAttachedMessageLocalService.createLegalAttachedMessage(
			messageId);
	}

	/**
	 * Deletes the legal attached message from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalAttachedMessage the legal attached message
	 * @return the legal attached message that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
		deleteLegalAttachedMessage(
			com.ecoit.elegaldocument.model.LegalAttachedMessage
				legalAttachedMessage) {

		return _legalAttachedMessageLocalService.deleteLegalAttachedMessage(
			legalAttachedMessage);
	}

	/**
	 * Deletes the legal attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message that was removed
	 * @throws PortalException if a legal attached message with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
			deleteLegalAttachedMessage(String messageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalAttachedMessageLocalService.deleteLegalAttachedMessage(
			messageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalAttachedMessageLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalAttachedMessageLocalService.dynamicQuery();
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

		return _legalAttachedMessageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalAttachedMessageModelImpl</code>.
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

		return _legalAttachedMessageLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalAttachedMessageModelImpl</code>.
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

		return _legalAttachedMessageLocalService.dynamicQuery(
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

		return _legalAttachedMessageLocalService.dynamicQueryCount(
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

		return _legalAttachedMessageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
		fetchLegalAttachedMessage(String messageId) {

		return _legalAttachedMessageLocalService.fetchLegalAttachedMessage(
			messageId);
	}

	/**
	 * Returns the legal attached message with the primary key.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message
	 * @throws PortalException if a legal attached message with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
			getLegalAttachedMessage(String messageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalAttachedMessageLocalService.getLegalAttachedMessage(
			messageId);
	}

	/**
	 * Returns a range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of legal attached messages
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalAttachedMessage>
		getLegalAttachedMessages(int start, int end) {

		return _legalAttachedMessageLocalService.getLegalAttachedMessages(
			start, end);
	}

	/**
	 * Returns the number of legal attached messages.
	 *
	 * @return the number of legal attached messages
	 */
	@Override
	public int getLegalAttachedMessagesCount() {
		return _legalAttachedMessageLocalService.
			getLegalAttachedMessagesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalAttachedMessageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalAttachedMessageLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the legal attached message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalAttachedMessage the legal attached message
	 * @return the legal attached message that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalAttachedMessage
		updateLegalAttachedMessage(
			com.ecoit.elegaldocument.model.LegalAttachedMessage
				legalAttachedMessage) {

		return _legalAttachedMessageLocalService.updateLegalAttachedMessage(
			legalAttachedMessage);
	}

	@Override
	public LegalAttachedMessageLocalService getWrappedService() {
		return _legalAttachedMessageLocalService;
	}

	@Override
	public void setWrappedService(
		LegalAttachedMessageLocalService legalAttachedMessageLocalService) {

		_legalAttachedMessageLocalService = legalAttachedMessageLocalService;
	}

	private LegalAttachedMessageLocalService _legalAttachedMessageLocalService;

}