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
 * Provides a wrapper for {@link LegalDFRelLocalService}.
 *
 * @author Liverpool
 * @see LegalDFRelLocalService
 * @generated
 */
public class LegalDFRelLocalServiceWrapper
	implements LegalDFRelLocalService, ServiceWrapper<LegalDFRelLocalService> {

	public LegalDFRelLocalServiceWrapper(
		LegalDFRelLocalService legalDFRelLocalService) {

		_legalDFRelLocalService = legalDFRelLocalService;
	}

	/**
	 * Adds the legal df rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRel the legal df rel
	 * @return the legal df rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel addLegalDFRel(
		com.ecoit.elegaldocument.model.LegalDFRel legalDFRel) {

		return _legalDFRelLocalService.addLegalDFRel(legalDFRel);
	}

	/**
	 * Creates a new legal df rel with the primary key. Does not add the legal df rel to the database.
	 *
	 * @param legalDFRelPK the primary key for the new legal df rel
	 * @return the new legal df rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel createLegalDFRel(
		com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
			legalDFRelPK) {

		return _legalDFRelLocalService.createLegalDFRel(legalDFRelPK);
	}

	/**
	 * Deletes the legal df rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRel the legal df rel
	 * @return the legal df rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel deleteLegalDFRel(
		com.ecoit.elegaldocument.model.LegalDFRel legalDFRel) {

		return _legalDFRelLocalService.deleteLegalDFRel(legalDFRel);
	}

	/**
	 * Deletes the legal df rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel that was removed
	 * @throws PortalException if a legal df rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel deleteLegalDFRel(
			com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
				legalDFRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDFRelLocalService.deleteLegalDFRel(legalDFRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDFRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDFRelLocalService.dynamicQuery();
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

		return _legalDFRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl</code>.
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

		return _legalDFRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl</code>.
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

		return _legalDFRelLocalService.dynamicQuery(
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

		return _legalDFRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDFRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel fetchLegalDFRel(
		com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
			legalDFRelPK) {

		return _legalDFRelLocalService.fetchLegalDFRel(legalDFRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDFRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDFRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal df rel with the primary key.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel
	 * @throws PortalException if a legal df rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel getLegalDFRel(
			com.ecoit.elegaldocument.service.persistence.LegalDFRelPK
				legalDFRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDFRelLocalService.getLegalDFRel(legalDFRelPK);
	}

	/**
	 * Returns a range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of legal df rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDFRel>
		getLegalDFRels(int start, int end) {

		return _legalDFRelLocalService.getLegalDFRels(start, end);
	}

	/**
	 * Returns the number of legal df rels.
	 *
	 * @return the number of legal df rels
	 */
	@Override
	public int getLegalDFRelsCount() {
		return _legalDFRelLocalService.getLegalDFRelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDFRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDFRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal df rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRel the legal df rel
	 * @return the legal df rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDFRel updateLegalDFRel(
		com.ecoit.elegaldocument.model.LegalDFRel legalDFRel) {

		return _legalDFRelLocalService.updateLegalDFRel(legalDFRel);
	}

	@Override
	public LegalDFRelLocalService getWrappedService() {
		return _legalDFRelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDFRelLocalService legalDFRelLocalService) {

		_legalDFRelLocalService = legalDFRelLocalService;
	}

	private LegalDFRelLocalService _legalDFRelLocalService;

}