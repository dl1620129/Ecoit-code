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
 * Provides a wrapper for {@link LegalDDRelLocalService}.
 *
 * @author Liverpool
 * @see LegalDDRelLocalService
 * @generated
 */
public class LegalDDRelLocalServiceWrapper
	implements LegalDDRelLocalService, ServiceWrapper<LegalDDRelLocalService> {

	public LegalDDRelLocalServiceWrapper(
		LegalDDRelLocalService legalDDRelLocalService) {

		_legalDDRelLocalService = legalDDRelLocalService;
	}

	/**
	 * Adds the legal dd rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRel the legal dd rel
	 * @return the legal dd rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel addLegalDDRel(
		com.ecoit.elegaldocument.model.LegalDDRel legalDDRel) {

		return _legalDDRelLocalService.addLegalDDRel(legalDDRel);
	}

	/**
	 * Creates a new legal dd rel with the primary key. Does not add the legal dd rel to the database.
	 *
	 * @param legalDDRelPK the primary key for the new legal dd rel
	 * @return the new legal dd rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel createLegalDDRel(
		com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
			legalDDRelPK) {

		return _legalDDRelLocalService.createLegalDDRel(legalDDRelPK);
	}

	/**
	 * Deletes the legal dd rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRel the legal dd rel
	 * @return the legal dd rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel deleteLegalDDRel(
		com.ecoit.elegaldocument.model.LegalDDRel legalDDRel) {

		return _legalDDRelLocalService.deleteLegalDDRel(legalDDRel);
	}

	/**
	 * Deletes the legal dd rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel that was removed
	 * @throws PortalException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel deleteLegalDDRel(
			com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
				legalDDRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDDRelLocalService.deleteLegalDDRel(legalDDRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDDRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDDRelLocalService.dynamicQuery();
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

		return _legalDDRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl</code>.
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

		return _legalDDRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl</code>.
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

		return _legalDDRelLocalService.dynamicQuery(
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

		return _legalDDRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDDRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel fetchLegalDDRel(
		com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
			legalDDRelPK) {

		return _legalDDRelLocalService.fetchLegalDDRel(legalDDRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDDRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDDRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal dd rel with the primary key.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel
	 * @throws PortalException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel getLegalDDRel(
			com.ecoit.elegaldocument.service.persistence.LegalDDRelPK
				legalDDRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDDRelLocalService.getLegalDDRel(legalDDRelPK);
	}

	/**
	 * Returns a range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of legal dd rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDDRel>
		getLegalDDRels(int start, int end) {

		return _legalDDRelLocalService.getLegalDDRels(start, end);
	}

	/**
	 * Returns the number of legal dd rels.
	 *
	 * @return the number of legal dd rels
	 */
	@Override
	public int getLegalDDRelsCount() {
		return _legalDDRelLocalService.getLegalDDRelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDDRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDDRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal dd rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRel the legal dd rel
	 * @return the legal dd rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDDRel updateLegalDDRel(
		com.ecoit.elegaldocument.model.LegalDDRel legalDDRel) {

		return _legalDDRelLocalService.updateLegalDDRel(legalDDRel);
	}

	@Override
	public LegalDDRelLocalService getWrappedService() {
		return _legalDDRelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDDRelLocalService legalDDRelLocalService) {

		_legalDDRelLocalService = legalDDRelLocalService;
	}

	private LegalDDRelLocalService _legalDDRelLocalService;

}