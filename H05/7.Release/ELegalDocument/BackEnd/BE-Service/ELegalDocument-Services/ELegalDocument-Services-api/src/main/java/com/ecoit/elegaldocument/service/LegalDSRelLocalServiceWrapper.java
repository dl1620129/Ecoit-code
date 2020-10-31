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
 * Provides a wrapper for {@link LegalDSRelLocalService}.
 *
 * @author Liverpool
 * @see LegalDSRelLocalService
 * @generated
 */
public class LegalDSRelLocalServiceWrapper
	implements LegalDSRelLocalService, ServiceWrapper<LegalDSRelLocalService> {

	public LegalDSRelLocalServiceWrapper(
		LegalDSRelLocalService legalDSRelLocalService) {

		_legalDSRelLocalService = legalDSRelLocalService;
	}

	/**
	 * Adds the legal ds rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRel the legal ds rel
	 * @return the legal ds rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel addLegalDSRel(
		com.ecoit.elegaldocument.model.LegalDSRel legalDSRel) {

		return _legalDSRelLocalService.addLegalDSRel(legalDSRel);
	}

	/**
	 * Creates a new legal ds rel with the primary key. Does not add the legal ds rel to the database.
	 *
	 * @param legalDSRelPK the primary key for the new legal ds rel
	 * @return the new legal ds rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel createLegalDSRel(
		com.ecoit.elegaldocument.service.persistence.LegalDSRelPK
			legalDSRelPK) {

		return _legalDSRelLocalService.createLegalDSRel(legalDSRelPK);
	}

	@Override
	public void createLegalDSRel(long docId, long sigId) {
		_legalDSRelLocalService.createLegalDSRel(docId, sigId);
	}

	@Override
	public void deleteBySignerId(long sigId) {
		_legalDSRelLocalService.deleteBySignerId(sigId);
	}

	/**
	 * Deletes the legal ds rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRel the legal ds rel
	 * @return the legal ds rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel deleteLegalDSRel(
		com.ecoit.elegaldocument.model.LegalDSRel legalDSRel) {

		return _legalDSRelLocalService.deleteLegalDSRel(legalDSRel);
	}

	/**
	 * Deletes the legal ds rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel that was removed
	 * @throws PortalException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel deleteLegalDSRel(
			com.ecoit.elegaldocument.service.persistence.LegalDSRelPK
				legalDSRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDSRelLocalService.deleteLegalDSRel(legalDSRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDSRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDSRelLocalService.dynamicQuery();
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

		return _legalDSRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDSRelModelImpl</code>.
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

		return _legalDSRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDSRelModelImpl</code>.
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

		return _legalDSRelLocalService.dynamicQuery(
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

		return _legalDSRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDSRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel fetchLegalDSRel(
		com.ecoit.elegaldocument.service.persistence.LegalDSRelPK
			legalDSRelPK) {

		return _legalDSRelLocalService.fetchLegalDSRel(legalDSRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDSRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDSRel> getByDocId(
		long docId) {

		return _legalDSRelLocalService.getByDocId(docId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDSRel> getBySigId(
		long sigId) {

		return _legalDSRelLocalService.getBySigId(sigId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDSRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal ds rel with the primary key.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel
	 * @throws PortalException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel getLegalDSRel(
			com.ecoit.elegaldocument.service.persistence.LegalDSRelPK
				legalDSRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDSRelLocalService.getLegalDSRel(legalDSRelPK);
	}

	/**
	 * Returns a range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of legal ds rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDSRel>
		getLegalDSRels(int start, int end) {

		return _legalDSRelLocalService.getLegalDSRels(start, end);
	}

	/**
	 * Returns the number of legal ds rels.
	 *
	 * @return the number of legal ds rels
	 */
	@Override
	public int getLegalDSRelsCount() {
		return _legalDSRelLocalService.getLegalDSRelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDSRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDSRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal ds rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRel the legal ds rel
	 * @return the legal ds rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDSRel updateLegalDSRel(
		com.ecoit.elegaldocument.model.LegalDSRel legalDSRel) {

		return _legalDSRelLocalService.updateLegalDSRel(legalDSRel);
	}

	@Override
	public LegalDSRelLocalService getWrappedService() {
		return _legalDSRelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDSRelLocalService legalDSRelLocalService) {

		_legalDSRelLocalService = legalDSRelLocalService;
	}

	private LegalDSRelLocalService _legalDSRelLocalService;

}