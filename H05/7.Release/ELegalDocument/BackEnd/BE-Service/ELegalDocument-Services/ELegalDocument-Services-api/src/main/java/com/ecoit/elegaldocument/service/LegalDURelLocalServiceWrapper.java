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
 * Provides a wrapper for {@link LegalDURelLocalService}.
 *
 * @author Liverpool
 * @see LegalDURelLocalService
 * @generated
 */
public class LegalDURelLocalServiceWrapper
	implements LegalDURelLocalService, ServiceWrapper<LegalDURelLocalService> {

	public LegalDURelLocalServiceWrapper(
		LegalDURelLocalService legalDURelLocalService) {

		_legalDURelLocalService = legalDURelLocalService;
	}

	/**
	 * Adds the legal du rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURel the legal du rel
	 * @return the legal du rel that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDURel addLegalDURel(
		com.ecoit.elegaldocument.model.LegalDURel legalDURel) {

		return _legalDURelLocalService.addLegalDURel(legalDURel);
	}

	/**
	 * Creates a new legal du rel with the primary key. Does not add the legal du rel to the database.
	 *
	 * @param legalDURelPK the primary key for the new legal du rel
	 * @return the new legal du rel
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDURel createLegalDURel(
		com.ecoit.elegaldocument.service.persistence.LegalDURelPK
			legalDURelPK) {

		return _legalDURelLocalService.createLegalDURel(legalDURelPK);
	}

	/**
	 * Deletes the legal du rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURel the legal du rel
	 * @return the legal du rel that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDURel deleteLegalDURel(
		com.ecoit.elegaldocument.model.LegalDURel legalDURel) {

		return _legalDURelLocalService.deleteLegalDURel(legalDURel);
	}

	/**
	 * Deletes the legal du rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel that was removed
	 * @throws PortalException if a legal du rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDURel deleteLegalDURel(
			com.ecoit.elegaldocument.service.persistence.LegalDURelPK
				legalDURelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDURelLocalService.deleteLegalDURel(legalDURelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDURelLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalDURelLocalService.dynamicQuery();
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

		return _legalDURelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDURelModelImpl</code>.
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

		return _legalDURelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDURelModelImpl</code>.
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

		return _legalDURelLocalService.dynamicQuery(
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

		return _legalDURelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalDURelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalDURel fetchLegalDURel(
		com.ecoit.elegaldocument.service.persistence.LegalDURelPK
			legalDURelPK) {

		return _legalDURelLocalService.fetchLegalDURel(legalDURelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalDURelLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalDURelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal du rel with the primary key.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel
	 * @throws PortalException if a legal du rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDURel getLegalDURel(
			com.ecoit.elegaldocument.service.persistence.LegalDURelPK
				legalDURelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDURelLocalService.getLegalDURel(legalDURelPK);
	}

	/**
	 * Returns a range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of legal du rels
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalDURel>
		getLegalDURels(int start, int end) {

		return _legalDURelLocalService.getLegalDURels(start, end);
	}

	/**
	 * Returns the number of legal du rels.
	 *
	 * @return the number of legal du rels
	 */
	@Override
	public int getLegalDURelsCount() {
		return _legalDURelLocalService.getLegalDURelsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalDURelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalDURelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal du rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURel the legal du rel
	 * @return the legal du rel that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalDURel updateLegalDURel(
		com.ecoit.elegaldocument.model.LegalDURel legalDURel) {

		return _legalDURelLocalService.updateLegalDURel(legalDURel);
	}

	@Override
	public LegalDURelLocalService getWrappedService() {
		return _legalDURelLocalService;
	}

	@Override
	public void setWrappedService(
		LegalDURelLocalService legalDURelLocalService) {

		_legalDURelLocalService = legalDURelLocalService;
	}

	private LegalDURelLocalService _legalDURelLocalService;

}