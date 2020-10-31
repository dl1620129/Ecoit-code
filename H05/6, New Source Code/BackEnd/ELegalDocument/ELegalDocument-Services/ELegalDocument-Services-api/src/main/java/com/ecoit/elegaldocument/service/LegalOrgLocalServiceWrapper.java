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
 * Provides a wrapper for {@link LegalOrgLocalService}.
 *
 * @author Liverpool
 * @see LegalOrgLocalService
 * @generated
 */
public class LegalOrgLocalServiceWrapper
	implements LegalOrgLocalService, ServiceWrapper<LegalOrgLocalService> {

	public LegalOrgLocalServiceWrapper(
		LegalOrgLocalService legalOrgLocalService) {

		_legalOrgLocalService = legalOrgLocalService;
	}

	/**
	 * Adds the legal org to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalOrg the legal org
	 * @return the legal org that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalOrg addLegalOrg(
		com.ecoit.elegaldocument.model.LegalOrg legalOrg) {

		return _legalOrgLocalService.addLegalOrg(legalOrg);
	}

	/**
	 * Creates a new legal org with the primary key. Does not add the legal org to the database.
	 *
	 * @param organizationId the primary key for the new legal org
	 * @return the new legal org
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalOrg createLegalOrg(
		long organizationId) {

		return _legalOrgLocalService.createLegalOrg(organizationId);
	}

	/**
	 * Deletes the legal org from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalOrg the legal org
	 * @return the legal org that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalOrg deleteLegalOrg(
		com.ecoit.elegaldocument.model.LegalOrg legalOrg) {

		return _legalOrgLocalService.deleteLegalOrg(legalOrg);
	}

	/**
	 * Deletes the legal org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org that was removed
	 * @throws PortalException if a legal org with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalOrg deleteLegalOrg(
			long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalOrgLocalService.deleteLegalOrg(organizationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalOrgLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalOrgLocalService.dynamicQuery();
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

		return _legalOrgLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl</code>.
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

		return _legalOrgLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl</code>.
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

		return _legalOrgLocalService.dynamicQuery(
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

		return _legalOrgLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalOrgLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalOrg fetchLegalOrg(
		long organizationId) {

		return _legalOrgLocalService.fetchLegalOrg(organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalOrgLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getAllOrganizations() {

		return _legalOrgLocalService.getAllOrganizations();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalOrgLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal org with the primary key.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org
	 * @throws PortalException if a legal org with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalOrg getLegalOrg(
			long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalOrgLocalService.getLegalOrg(organizationId);
	}

	/**
	 * Returns a range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of legal orgs
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg> getLegalOrgs(
		int start, int end) {

		return _legalOrgLocalService.getLegalOrgs(start, end);
	}

	/**
	 * Returns the number of legal orgs.
	 *
	 * @return the number of legal orgs
	 */
	@Override
	public int getLegalOrgsCount() {
		return _legalOrgLocalService.getLegalOrgsCount();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg> getNode(
			long parentId, long groupId, long companyId, String language,
			String name, int start, int limit)
		throws Exception {

		return _legalOrgLocalService.getNode(
			parentId, groupId, companyId, language, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalOrgLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalOrgLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalOrg>
		getPublishOrganizations(
			long parentId, String language, boolean statusOrg, long groupId) {

		return _legalOrgLocalService.getPublishOrganizations(
			parentId, language, statusOrg, groupId);
	}

	/**
	 * Updates the legal org in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalOrg the legal org
	 * @return the legal org that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalOrg updateLegalOrg(
		com.ecoit.elegaldocument.model.LegalOrg legalOrg) {

		return _legalOrgLocalService.updateLegalOrg(legalOrg);
	}

	@Override
	public LegalOrgLocalService getWrappedService() {
		return _legalOrgLocalService;
	}

	@Override
	public void setWrappedService(LegalOrgLocalService legalOrgLocalService) {
		_legalOrgLocalService = legalOrgLocalService;
	}

	private LegalOrgLocalService _legalOrgLocalService;

}