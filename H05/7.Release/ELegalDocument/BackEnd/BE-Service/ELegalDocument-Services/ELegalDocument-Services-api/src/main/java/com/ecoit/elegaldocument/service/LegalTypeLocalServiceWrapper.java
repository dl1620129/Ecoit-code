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
 * Provides a wrapper for {@link LegalTypeLocalService}.
 *
 * @author Liverpool
 * @see LegalTypeLocalService
 * @generated
 */
public class LegalTypeLocalServiceWrapper
	implements LegalTypeLocalService, ServiceWrapper<LegalTypeLocalService> {

	public LegalTypeLocalServiceWrapper(
		LegalTypeLocalService legalTypeLocalService) {

		_legalTypeLocalService = legalTypeLocalService;
	}

	/**
	 * Adds the legal type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalType the legal type
	 * @return the legal type that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalType addLegalType(
		com.ecoit.elegaldocument.model.LegalType legalType) {

		return _legalTypeLocalService.addLegalType(legalType);
	}

	/**
	 * Creates a new legal type with the primary key. Does not add the legal type to the database.
	 *
	 * @param typeId the primary key for the new legal type
	 * @return the new legal type
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalType createLegalType(
		long typeId) {

		return _legalTypeLocalService.createLegalType(typeId);
	}

	@Override
	public void createUpdateLegalType(
			long legalTypeId, long groupId, long companyId, long userId,
			String name, String description, String language,
			boolean statusType, int position, long parentId)
		throws Exception {

		_legalTypeLocalService.createUpdateLegalType(
			legalTypeId, groupId, companyId, userId, name, description,
			language, statusType, position, parentId);
	}

	/**
	 * Deletes the legal type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalType the legal type
	 * @return the legal type that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalType deleteLegalType(
		com.ecoit.elegaldocument.model.LegalType legalType) {

		return _legalTypeLocalService.deleteLegalType(legalType);
	}

	/**
	 * Deletes the legal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type that was removed
	 * @throws PortalException if a legal type with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalType deleteLegalType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTypeLocalService.deleteLegalType(typeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalTypeLocalService.dynamicQuery();
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

		return _legalTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTypeModelImpl</code>.
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

		return _legalTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTypeModelImpl</code>.
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

		return _legalTypeLocalService.dynamicQuery(
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

		return _legalTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalType fetchLegalType(
		long typeId) {

		return _legalTypeLocalService.fetchLegalType(typeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getAllTypes() {

		return _legalTypeLocalService.getAllTypes();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getByDocumentId(long documentId) {

		return _legalTypeLocalService.getByDocumentId(documentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal type with the primary key.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type
	 * @throws PortalException if a legal type with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalType getLegalType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTypeLocalService.getLegalType(typeId);
	}

	/**
	 * Returns a range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of legal types
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getLegalTypes(int start, int end) {

		return _legalTypeLocalService.getLegalTypes(start, end);
	}

	/**
	 * Returns the number of legal types.
	 *
	 * @return the number of legal types
	 */
	@Override
	public int getLegalTypesCount() {
		return _legalTypeLocalService.getLegalTypesCount();
	}

	@Override
	public int getMax(
		String lang, long groupId, long parentId, long companyId) {

		return _legalTypeLocalService.getMax(
			lang, groupId, parentId, companyId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType> getNode(
			long parentId, long groupId, long companyId, String language,
			String name, int start, int limit)
		throws Exception {

		return _legalTypeLocalService.getNode(
			parentId, groupId, companyId, language, name, start, limit);
	}

	@Override
	public int getNodeCount(
		long parentId, long groupId, long companyId, String language,
		String name) {

		return _legalTypeLocalService.getNodeCount(
			parentId, groupId, companyId, language, name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalType>
		getPublishTypes(
			long parentId, String language, boolean statusType, long groupId) {

		return _legalTypeLocalService.getPublishTypes(
			parentId, language, statusType, groupId);
	}

	/**
	 * Updates the legal type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalType the legal type
	 * @return the legal type that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalType updateLegalType(
		com.ecoit.elegaldocument.model.LegalType legalType) {

		return _legalTypeLocalService.updateLegalType(legalType);
	}

	@Override
	public LegalTypeLocalService getWrappedService() {
		return _legalTypeLocalService;
	}

	@Override
	public void setWrappedService(LegalTypeLocalService legalTypeLocalService) {
		_legalTypeLocalService = legalTypeLocalService;
	}

	private LegalTypeLocalService _legalTypeLocalService;

}