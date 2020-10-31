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
 * Provides a wrapper for {@link LegalLevelValidityLocalService}.
 *
 * @author Liverpool
 * @see LegalLevelValidityLocalService
 * @generated
 */
public class LegalLevelValidityLocalServiceWrapper
	implements LegalLevelValidityLocalService,
			   ServiceWrapper<LegalLevelValidityLocalService> {

	public LegalLevelValidityLocalServiceWrapper(
		LegalLevelValidityLocalService legalLevelValidityLocalService) {

		_legalLevelValidityLocalService = legalLevelValidityLocalService;
	}

	/**
	 * Adds the legal level validity to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLevelValidity the legal level validity
	 * @return the legal level validity that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
		addLegalLevelValidity(
			com.ecoit.elegaldocument.model.LegalLevelValidity
				legalLevelValidity) {

		return _legalLevelValidityLocalService.addLegalLevelValidity(
			legalLevelValidity);
	}

	/**
	 * Creates a new legal level validity with the primary key. Does not add the legal level validity to the database.
	 *
	 * @param levelValidityId the primary key for the new legal level validity
	 * @return the new legal level validity
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
		createLegalLevelValidity(long levelValidityId) {

		return _legalLevelValidityLocalService.createLegalLevelValidity(
			levelValidityId);
	}

	/**
	 * Deletes the legal level validity from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalLevelValidity the legal level validity
	 * @return the legal level validity that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
		deleteLegalLevelValidity(
			com.ecoit.elegaldocument.model.LegalLevelValidity
				legalLevelValidity) {

		return _legalLevelValidityLocalService.deleteLegalLevelValidity(
			legalLevelValidity);
	}

	/**
	 * Deletes the legal level validity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity that was removed
	 * @throws PortalException if a legal level validity with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
			deleteLegalLevelValidity(long levelValidityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLevelValidityLocalService.deleteLegalLevelValidity(
			levelValidityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLevelValidityLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalLevelValidityLocalService.dynamicQuery();
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

		return _legalLevelValidityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl</code>.
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

		return _legalLevelValidityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl</code>.
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

		return _legalLevelValidityLocalService.dynamicQuery(
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

		return _legalLevelValidityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalLevelValidityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
		fetchLegalLevelValidity(long levelValidityId) {

		return _legalLevelValidityLocalService.fetchLegalLevelValidity(
			levelValidityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalLevelValidityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalLevelValidityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of legal level validities
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalLevelValidity>
		getLegalLevelValidities(int start, int end) {

		return _legalLevelValidityLocalService.getLegalLevelValidities(
			start, end);
	}

	/**
	 * Returns the number of legal level validities.
	 *
	 * @return the number of legal level validities
	 */
	@Override
	public int getLegalLevelValiditiesCount() {
		return _legalLevelValidityLocalService.getLegalLevelValiditiesCount();
	}

	/**
	 * Returns the legal level validity with the primary key.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity
	 * @throws PortalException if a legal level validity with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
			getLegalLevelValidity(long levelValidityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLevelValidityLocalService.getLegalLevelValidity(
			levelValidityId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalLevelValidityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalLevelValidityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal level validity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalLevelValidity the legal level validity
	 * @return the legal level validity that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalLevelValidity
		updateLegalLevelValidity(
			com.ecoit.elegaldocument.model.LegalLevelValidity
				legalLevelValidity) {

		return _legalLevelValidityLocalService.updateLegalLevelValidity(
			legalLevelValidity);
	}

	@Override
	public LegalLevelValidityLocalService getWrappedService() {
		return _legalLevelValidityLocalService;
	}

	@Override
	public void setWrappedService(
		LegalLevelValidityLocalService legalLevelValidityLocalService) {

		_legalLevelValidityLocalService = legalLevelValidityLocalService;
	}

	private LegalLevelValidityLocalService _legalLevelValidityLocalService;

}