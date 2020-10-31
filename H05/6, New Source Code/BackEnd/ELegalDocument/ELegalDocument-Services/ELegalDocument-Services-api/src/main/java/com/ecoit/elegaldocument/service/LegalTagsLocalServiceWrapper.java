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
 * Provides a wrapper for {@link LegalTagsLocalService}.
 *
 * @author Liverpool
 * @see LegalTagsLocalService
 * @generated
 */
public class LegalTagsLocalServiceWrapper
	implements LegalTagsLocalService, ServiceWrapper<LegalTagsLocalService> {

	public LegalTagsLocalServiceWrapper(
		LegalTagsLocalService legalTagsLocalService) {

		_legalTagsLocalService = legalTagsLocalService;
	}

	/**
	 * Adds the legal tags to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTags the legal tags
	 * @return the legal tags that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalTags addLegalTags(
		com.ecoit.elegaldocument.model.LegalTags legalTags) {

		return _legalTagsLocalService.addLegalTags(legalTags);
	}

	/**
	 * Creates a new legal tags with the primary key. Does not add the legal tags to the database.
	 *
	 * @param tagId the primary key for the new legal tags
	 * @return the new legal tags
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalTags createLegalTags(
		long tagId) {

		return _legalTagsLocalService.createLegalTags(tagId);
	}

	/**
	 * Deletes the legal tags from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTags the legal tags
	 * @return the legal tags that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalTags deleteLegalTags(
		com.ecoit.elegaldocument.model.LegalTags legalTags) {

		return _legalTagsLocalService.deleteLegalTags(legalTags);
	}

	/**
	 * Deletes the legal tags with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags that was removed
	 * @throws PortalException if a legal tags with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalTags deleteLegalTags(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTagsLocalService.deleteLegalTags(tagId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTagsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalTagsLocalService.dynamicQuery();
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

		return _legalTagsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTagsModelImpl</code>.
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

		return _legalTagsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTagsModelImpl</code>.
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

		return _legalTagsLocalService.dynamicQuery(
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

		return _legalTagsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalTagsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalTags fetchLegalTags(long tagId) {
		return _legalTagsLocalService.fetchLegalTags(tagId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalTagsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalTagsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal tags with the primary key.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags
	 * @throws PortalException if a legal tags with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalTags getLegalTags(long tagId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTagsLocalService.getLegalTags(tagId);
	}

	/**
	 * Returns a range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of legal tagses
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalTags>
		getLegalTagses(int start, int end) {

		return _legalTagsLocalService.getLegalTagses(start, end);
	}

	/**
	 * Returns the number of legal tagses.
	 *
	 * @return the number of legal tagses
	 */
	@Override
	public int getLegalTagsesCount() {
		return _legalTagsLocalService.getLegalTagsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalTagsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalTagsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal tags in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalTags the legal tags
	 * @return the legal tags that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalTags updateLegalTags(
		com.ecoit.elegaldocument.model.LegalTags legalTags) {

		return _legalTagsLocalService.updateLegalTags(legalTags);
	}

	@Override
	public LegalTagsLocalService getWrappedService() {
		return _legalTagsLocalService;
	}

	@Override
	public void setWrappedService(LegalTagsLocalService legalTagsLocalService) {
		_legalTagsLocalService = legalTagsLocalService;
	}

	private LegalTagsLocalService _legalTagsLocalService;

}