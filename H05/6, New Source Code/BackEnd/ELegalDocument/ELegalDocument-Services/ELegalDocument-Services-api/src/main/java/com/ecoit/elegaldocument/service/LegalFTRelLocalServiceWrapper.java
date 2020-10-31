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
 * Provides a wrapper for {@link LegalFTRelLocalService}.
 *
 * @author Liverpool
 * @see LegalFTRelLocalService
 * @generated
 */
public class LegalFTRelLocalServiceWrapper
	implements LegalFTRelLocalService, ServiceWrapper<LegalFTRelLocalService> {

	public LegalFTRelLocalServiceWrapper(
		LegalFTRelLocalService legalFTRelLocalService) {

		_legalFTRelLocalService = legalFTRelLocalService;
	}

	/**
	 * Adds the legal ft rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRel the legal ft rel
	 * @return the legal ft rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel addLegalFTRel(
		com.ecoit.elegaldocument.model.LegalFTRel legalFTRel) {

		return _legalFTRelLocalService.addLegalFTRel(legalFTRel);
	}

	/**
	 * Creates a new legal ft rel with the primary key. Does not add the legal ft rel to the database.
	 *
	 * @param legalFTRelPK the primary key for the new legal ft rel
	 * @return the new legal ft rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel createLegalFTRel(
		com.ecoit.elegaldocument.service.persistence.LegalFTRelPK
			legalFTRelPK) {

		return _legalFTRelLocalService.createLegalFTRel(legalFTRelPK);
	}

	/**
	 * Deletes the legal ft rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRel the legal ft rel
	 * @return the legal ft rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel deleteLegalFTRel(
		com.ecoit.elegaldocument.model.LegalFTRel legalFTRel) {

		return _legalFTRelLocalService.deleteLegalFTRel(legalFTRel);
	}

	/**
	 * Deletes the legal ft rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel that was removed
	 * @throws PortalException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel deleteLegalFTRel(
			com.ecoit.elegaldocument.service.persistence.LegalFTRelPK
				legalFTRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFTRelLocalService.deleteLegalFTRel(legalFTRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFTRelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalFTRelLocalService.dynamicQuery();
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

		return _legalFTRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFTRelModelImpl</code>.
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

		return _legalFTRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFTRelModelImpl</code>.
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

		return _legalFTRelLocalService.dynamicQuery(
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

		return _legalFTRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalFTRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel fetchLegalFTRel(
		com.ecoit.elegaldocument.service.persistence.LegalFTRelPK
			legalFTRelPK) {

		return _legalFTRelLocalService.fetchLegalFTRel(legalFTRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalFTRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalFTRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal ft rel with the primary key.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel
	 * @throws PortalException if a legal ft rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel getLegalFTRel(
			com.ecoit.elegaldocument.service.persistence.LegalFTRelPK
				legalFTRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFTRelLocalService.getLegalFTRel(legalFTRelPK);
	}

	/**
	 * Returns a range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of legal ft rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalFTRel>
		getLegalFTRels(int start, int end) {

		return _legalFTRelLocalService.getLegalFTRels(start, end);
	}

	/**
	 * Returns the number of legal ft rels.
	 *
	 * @return the number of legal ft rels
	 */
	@Override
	public int getLegalFTRelsCount() {
		return _legalFTRelLocalService.getLegalFTRelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalFTRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalFTRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal ft rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRel the legal ft rel
	 * @return the legal ft rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalFTRel updateLegalFTRel(
		com.ecoit.elegaldocument.model.LegalFTRel legalFTRel) {

		return _legalFTRelLocalService.updateLegalFTRel(legalFTRel);
	}

	@Override
	public LegalFTRelLocalService getWrappedService() {
		return _legalFTRelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalFTRelLocalService legalFTRelLocalService) {

		_legalFTRelLocalService = legalFTRelLocalService;
	}

	private LegalFTRelLocalService _legalFTRelLocalService;

}