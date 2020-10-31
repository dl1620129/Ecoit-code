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
 * Provides a wrapper for {@link LegalFoRelLocalService}.
 *
 * @author Liverpool
 * @see LegalFoRelLocalService
 * @generated
 */
public class LegalFoRelLocalServiceWrapper
	implements LegalFoRelLocalService, ServiceWrapper<LegalFoRelLocalService> {

	public LegalFoRelLocalServiceWrapper(
		LegalFoRelLocalService legalFoRelLocalService) {

		_legalFoRelLocalService = legalFoRelLocalService;
	}

	/**
	 * Adds the legal fo rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRel the legal fo rel
	 * @return the legal fo rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel addLegalFoRel(
		com.ecoit.elegaldocument.model.LegalFoRel legalFoRel) {

		return _legalFoRelLocalService.addLegalFoRel(legalFoRel);
	}

	/**
	 * Creates a new legal fo rel with the primary key. Does not add the legal fo rel to the database.
	 *
	 * @param legalFoRelPK the primary key for the new legal fo rel
	 * @return the new legal fo rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel createLegalFoRel(
		com.ecoit.elegaldocument.service.persistence.LegalFoRelPK
			legalFoRelPK) {

		return _legalFoRelLocalService.createLegalFoRel(legalFoRelPK);
	}

	/**
	 * Deletes the legal fo rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRel the legal fo rel
	 * @return the legal fo rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel deleteLegalFoRel(
		com.ecoit.elegaldocument.model.LegalFoRel legalFoRel) {

		return _legalFoRelLocalService.deleteLegalFoRel(legalFoRel);
	}

	/**
	 * Deletes the legal fo rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel that was removed
	 * @throws PortalException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel deleteLegalFoRel(
			com.ecoit.elegaldocument.service.persistence.LegalFoRelPK
				legalFoRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFoRelLocalService.deleteLegalFoRel(legalFoRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFoRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalFoRelLocalService.dynamicQuery();
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

		return _legalFoRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFoRelModelImpl</code>.
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

		return _legalFoRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFoRelModelImpl</code>.
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

		return _legalFoRelLocalService.dynamicQuery(
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

		return _legalFoRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalFoRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel fetchLegalFoRel(
		com.ecoit.elegaldocument.service.persistence.LegalFoRelPK
			legalFoRelPK) {

		return _legalFoRelLocalService.fetchLegalFoRel(legalFoRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalFoRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalFoRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal fo rel with the primary key.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel
	 * @throws PortalException if a legal fo rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel getLegalFoRel(
			com.ecoit.elegaldocument.service.persistence.LegalFoRelPK
				legalFoRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFoRelLocalService.getLegalFoRel(legalFoRelPK);
	}

	/**
	 * Returns a range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of legal fo rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalFoRel>
		getLegalFoRels(int start, int end) {

		return _legalFoRelLocalService.getLegalFoRels(start, end);
	}

	/**
	 * Returns the number of legal fo rels.
	 *
	 * @return the number of legal fo rels
	 */
	@Override
	public int getLegalFoRelsCount() {
		return _legalFoRelLocalService.getLegalFoRelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalFoRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFoRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal fo rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRel the legal fo rel
	 * @return the legal fo rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFoRel updateLegalFoRel(
		com.ecoit.elegaldocument.model.LegalFoRel legalFoRel) {

		return _legalFoRelLocalService.updateLegalFoRel(legalFoRel);
	}

	@Override
	public LegalFoRelLocalService getWrappedService() {
		return _legalFoRelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalFoRelLocalService legalFoRelLocalService) {

		_legalFoRelLocalService = legalFoRelLocalService;
	}

	private LegalFoRelLocalService _legalFoRelLocalService;

}