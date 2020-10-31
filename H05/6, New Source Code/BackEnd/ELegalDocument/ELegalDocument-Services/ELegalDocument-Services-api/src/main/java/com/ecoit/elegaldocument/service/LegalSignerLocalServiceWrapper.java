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
 * Provides a wrapper for {@link LegalSignerLocalService}.
 *
 * @author Liverpool
 * @see LegalSignerLocalService
 * @generated
 */
public class LegalSignerLocalServiceWrapper
	implements LegalSignerLocalService,
			   ServiceWrapper<LegalSignerLocalService> {

	public LegalSignerLocalServiceWrapper(
		LegalSignerLocalService legalSignerLocalService) {

		_legalSignerLocalService = legalSignerLocalService;
	}

	/**
	 * Adds the legal signer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSigner the legal signer
	 * @return the legal signer that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSigner addLegalSigner(
		com.ecoit.elegaldocument.model.LegalSigner legalSigner) {

		return _legalSignerLocalService.addLegalSigner(legalSigner);
	}

	@Override
	public int countTotalLegalSigner(
		String name, long groupId, long companyId) {

		return _legalSignerLocalService.countTotalLegalSigner(
			name, groupId, companyId);
	}

	/**
	 * Creates a new legal signer with the primary key. Does not add the legal signer to the database.
	 *
	 * @param sigId the primary key for the new legal signer
	 * @return the new legal signer
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSigner createLegalSigner(
		long sigId) {

		return _legalSignerLocalService.createLegalSigner(sigId);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalSigner createUpdateLegalSigner(
			long sigId, long groupId, long companyId, long userId,
			String firstName, String lastName, String language,
			boolean statusSigner)
		throws Exception {

		return _legalSignerLocalService.createUpdateLegalSigner(
			sigId, groupId, companyId, userId, firstName, lastName, language,
			statusSigner);
	}

	/**
	 * Deletes the legal signer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalSigner the legal signer
	 * @return the legal signer that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSigner deleteLegalSigner(
		com.ecoit.elegaldocument.model.LegalSigner legalSigner) {

		return _legalSignerLocalService.deleteLegalSigner(legalSigner);
	}

	/**
	 * Deletes the legal signer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer that was removed
	 * @throws PortalException if a legal signer with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSigner deleteLegalSigner(
			long sigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSignerLocalService.deleteLegalSigner(sigId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSignerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _legalSignerLocalService.dynamicQuery();
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

		return _legalSignerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl</code>.
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

		return _legalSignerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl</code>.
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

		return _legalSignerLocalService.dynamicQuery(
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

		return _legalSignerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _legalSignerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.LegalSigner fetchLegalSigner(
		long sigId) {

		return _legalSignerLocalService.fetchLegalSigner(sigId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _legalSignerLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalSigner>
		getByDocumentId(long documentId) {

		return _legalSignerLocalService.getByDocumentId(documentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _legalSignerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the legal signer with the primary key.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer
	 * @throws PortalException if a legal signer with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSigner getLegalSigner(long sigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSignerLocalService.getLegalSigner(sigId);
	}

	/**
	 * Returns a range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of legal signers
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalSigner>
		getLegalSigners(int start, int end) {

		return _legalSignerLocalService.getLegalSigners(start, end);
	}

	/**
	 * Returns the number of legal signers.
	 *
	 * @return the number of legal signers
	 */
	@Override
	public int getLegalSignersCount() {
		return _legalSignerLocalService.getLegalSignersCount();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.LegalSigner>
		getListLegalSigner(
			String name, long groupId, long companyId, int start, int limit) {

		return _legalSignerLocalService.getListLegalSigner(
			name, groupId, companyId, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _legalSignerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _legalSignerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the legal signer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legalSigner the legal signer
	 * @return the legal signer that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.LegalSigner updateLegalSigner(
		com.ecoit.elegaldocument.model.LegalSigner legalSigner) {

		return _legalSignerLocalService.updateLegalSigner(legalSigner);
	}

	@Override
	public LegalSignerLocalService getWrappedService() {
		return _legalSignerLocalService;
	}

	@Override
	public void setWrappedService(
		LegalSignerLocalService legalSignerLocalService) {

		_legalSignerLocalService = legalSignerLocalService;
	}

	private LegalSignerLocalService _legalSignerLocalService;

}