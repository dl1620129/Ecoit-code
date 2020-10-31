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
 * Provides a wrapper for {@link LegalFieldLocalService}.
 *
 * @author Liverpool
 * @see LegalFieldLocalService
 * @generated
 */
public class LegalFieldLocalServiceWrapper
	implements LegalFieldLocalService, ServiceWrapper<LegalFieldLocalService> {

	public LegalFieldLocalServiceWrapper(
		LegalFieldLocalService legalFieldLocalService) {

		_legalFieldLocalService = legalFieldLocalService;
	}

	/**
	 * Adds the legal field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalField the legal field
	 * @return the legal field that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalField addLegalField(
		com.ecoit.elegaldocument.model.LegalField legalField) {

		return _legalFieldLocalService.addLegalField(legalField);
	}

	@Override
	public int countTotalLegalField(
		long groupId, String language, long companyId, String name) {

		return _legalFieldLocalService.countTotalLegalField(
			groupId, language, companyId, name);
	}

	/**
	 * Creates a new legal field with the primary key. Does not add the legal field to the database.
	 *
	 * @param fieldId the primary key for the new legal field
	 * @return the new legal field
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalField createLegalField(
		long fieldId) {

		return _legalFieldLocalService.createLegalField(fieldId);
	}

	@Override
	public void createUpdateLegalField(
			long userId, long scopeGroupId, String language, long companyId,
			long fieldId, String name, String description,
			boolean isStatusField, int position)
		throws Exception {

		_legalFieldLocalService.createUpdateLegalField(
			userId, scopeGroupId, language, companyId, fieldId, name,
			description, isStatusField, position);
	}

	/**
	 * Deletes the legal field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalField the legal field
	 * @return the legal field that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalField deleteLegalField(
		com.ecoit.elegaldocument.model.LegalField legalField) {

		return _legalFieldLocalService.deleteLegalField(legalField);
	}

	/**
	 * Deletes the legal field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field that was removed
	 * @throws PortalException if a legal field with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalField deleteLegalField(
			long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFieldLocalService.deleteLegalField(fieldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFieldLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalFieldLocalService.dynamicQuery();
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

		return _legalFieldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl</code>.
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

		return _legalFieldLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl</code>.
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

		return _legalFieldLocalService.dynamicQuery(
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

		return _legalFieldLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalFieldLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalField fetchLegalField(
		long fieldId) {

		return _legalFieldLocalService.fetchLegalField(fieldId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalFieldLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getAllFields() {

		return _legalFieldLocalService.getAllFields();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalFieldLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal field with the primary key.
	 *
	 * @param fieldId the primary key of the legal field
	 * @return the legal field
	 * @throws PortalException if a legal field with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalField getLegalField(long fieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFieldLocalService.getLegalField(fieldId);
	}

	/**
	 * Returns a range of all the legal fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fields
	 * @param end the upper bound of the range of legal fields (not inclusive)
	 * @return the range of legal fields
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getLegalFields(int start, int end) {

		return _legalFieldLocalService.getLegalFields(start, end);
	}

	/**
	 * Returns the number of legal fields.
	 *
	 * @return the number of legal fields
	 */
	@Override
	public int getLegalFieldsCount() {
		return _legalFieldLocalService.getLegalFieldsCount();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getListLegalField(
			String name, long groupId, String language, long companyId,
			int start, int limit) {

		return _legalFieldLocalService.getListLegalField(
			name, groupId, language, companyId, start, limit);
	}

	@Override
	public int getMax(String language, long groupId, long companyId) {
		return _legalFieldLocalService.getMax(language, groupId, companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalFieldLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFieldLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalField>
		getPublishFields(String language, boolean statusField, long groupId) {

		return _legalFieldLocalService.getPublishFields(
			language, statusField, groupId);
	}

	/**
	 * Updates the legal field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalField the legal field
	 * @return the legal field that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalField updateLegalField(
		com.ecoit.elegaldocument.model.LegalField legalField) {

		return _legalFieldLocalService.updateLegalField(legalField);
	}

	@Override
	public LegalFieldLocalService getWrappedService() {
		return _legalFieldLocalService;
	}

	@Override
	public void setWrappedService(
		LegalFieldLocalService legalFieldLocalService) {

		_legalFieldLocalService = legalFieldLocalService;
	}

	private LegalFieldLocalService _legalFieldLocalService;

}