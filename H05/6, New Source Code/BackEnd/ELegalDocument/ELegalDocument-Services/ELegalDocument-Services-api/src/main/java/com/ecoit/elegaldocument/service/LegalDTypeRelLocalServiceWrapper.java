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
 * Provides a wrapper for {@link LegalDTypeRelLocalService}.
 *
 * @author Liverpool
 * @see LegalDTypeRelLocalService
 * @generated
 */
public class LegalDTypeRelLocalServiceWrapper
	implements LegalDTypeRelLocalService,
			   ServiceWrapper<LegalDTypeRelLocalService> {

	public LegalDTypeRelLocalServiceWrapper(
		LegalDTypeRelLocalService legalDTypeRelLocalService) {

		_legalDTypeRelLocalService = legalDTypeRelLocalService;
	}

	/**
	 * Adds the legal d type rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRel the legal d type rel
	 * @return the legal d type rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel addLegalDTypeRel(
		com.ecoit.elegaldocument.model.LegalDTypeRel legalDTypeRel) {

		return _legalDTypeRelLocalService.addLegalDTypeRel(legalDTypeRel);
	}

	/**
	 * Creates a new legal d type rel with the primary key. Does not add the legal d type rel to the database.
	 *
	 * @param legalDTypeRelPK the primary key for the new legal d type rel
	 * @return the new legal d type rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel createLegalDTypeRel(
		com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
			legalDTypeRelPK) {

		return _legalDTypeRelLocalService.createLegalDTypeRel(legalDTypeRelPK);
	}

	@Override
	public void createLegalDTypeRel(long docId, long typeId) {
		_legalDTypeRelLocalService.createLegalDTypeRel(docId, typeId);
	}

	/**
	 * Deletes the legal d type rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRel the legal d type rel
	 * @return the legal d type rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel deleteLegalDTypeRel(
		com.ecoit.elegaldocument.model.LegalDTypeRel legalDTypeRel) {

		return _legalDTypeRelLocalService.deleteLegalDTypeRel(legalDTypeRel);
	}

	/**
	 * Deletes the legal d type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel that was removed
	 * @throws PortalException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel deleteLegalDTypeRel(
			com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
				legalDTypeRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDTypeRelLocalService.deleteLegalDTypeRel(legalDTypeRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDTypeRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDTypeRelLocalService.dynamicQuery();
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

		return _legalDTypeRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl</code>.
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

		return _legalDTypeRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl</code>.
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

		return _legalDTypeRelLocalService.dynamicQuery(
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

		return _legalDTypeRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDTypeRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel fetchLegalDTypeRel(
		com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
			legalDTypeRelPK) {

		return _legalDTypeRelLocalService.fetchLegalDTypeRel(legalDTypeRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDTypeRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDTypeRel>
		getByDocId(long docId) {

		return _legalDTypeRelLocalService.getByDocId(docId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDTypeRel>
		getByTypeId(long typeId) {

		return _legalDTypeRelLocalService.getByTypeId(typeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDTypeRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal d type rel with the primary key.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel
	 * @throws PortalException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel getLegalDTypeRel(
			com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK
				legalDTypeRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDTypeRelLocalService.getLegalDTypeRel(legalDTypeRelPK);
	}

	/**
	 * Returns a range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of legal d type rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDTypeRel>
		getLegalDTypeRels(int start, int end) {

		return _legalDTypeRelLocalService.getLegalDTypeRels(start, end);
	}

	/**
	 * Returns the number of legal d type rels.
	 *
	 * @return the number of legal d type rels
	 */
	@Override
	public int getLegalDTypeRelsCount() {
		return _legalDTypeRelLocalService.getLegalDTypeRelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDTypeRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDTypeRelLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasDocumentType(long docId, long typeId) {
		return _legalDTypeRelLocalService.hasDocumentType(docId, typeId);
	}

	@Override
	public void removeByTypeId(long typeId) {
		_legalDTypeRelLocalService.removeByTypeId(typeId);
	}

	/**
	 * Updates the legal d type rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRel the legal d type rel
	 * @return the legal d type rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDTypeRel updateLegalDTypeRel(
		com.ecoit.elegaldocument.model.LegalDTypeRel legalDTypeRel) {

		return _legalDTypeRelLocalService.updateLegalDTypeRel(legalDTypeRel);
	}

	@Override
	public LegalDTypeRelLocalService getWrappedService() {
		return _legalDTypeRelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDTypeRelLocalService legalDTypeRelLocalService) {

		_legalDTypeRelLocalService = legalDTypeRelLocalService;
	}

	private LegalDTypeRelLocalService _legalDTypeRelLocalService;

}