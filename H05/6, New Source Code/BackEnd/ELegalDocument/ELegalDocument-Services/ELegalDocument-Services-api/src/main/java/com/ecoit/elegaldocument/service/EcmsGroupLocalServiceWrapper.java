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
 * Provides a wrapper for {@link EcmsGroupLocalService}.
 *
 * @author Liverpool
 * @see EcmsGroupLocalService
 * @generated
 */
public class EcmsGroupLocalServiceWrapper
	implements EcmsGroupLocalService, ServiceWrapper<EcmsGroupLocalService> {

	public EcmsGroupLocalServiceWrapper(
		EcmsGroupLocalService ecmsGroupLocalService) {

		_ecmsGroupLocalService = ecmsGroupLocalService;
	}

	/**
	 * Adds the ecms group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGroup the ecms group
	 * @return the ecms group that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup addEcmsGroup(
		com.ecoit.elegaldocument.model.EcmsGroup ecmsGroup) {

		return _ecmsGroupLocalService.addEcmsGroup(ecmsGroup);
	}

	@Override
	public int countMemberInGroup(long groupUserId) {
		return _ecmsGroupLocalService.countMemberInGroup(groupUserId);
	}

	@Override
	public int countTotalGroup(long groupId, String name) {
		return _ecmsGroupLocalService.countTotalGroup(groupId, name);
	}

	/**
	 * Creates a new ecms group with the primary key. Does not add the ecms group to the database.
	 *
	 * @param groupUserId the primary key for the new ecms group
	 * @return the new ecms group
	 */
	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup createEcmsGroup(
		long groupUserId) {

		return _ecmsGroupLocalService.createEcmsGroup(groupUserId);
	}

	@Override
	public void createUpdateEcmsgroup(
			long scopeGroupId, long groupUserId, String groupName,
			String description, String[] users, String[] permissions,
			String[] categories, String[] organizations, String[] fields)
		throws Exception {

		_ecmsGroupLocalService.createUpdateEcmsgroup(
			scopeGroupId, groupUserId, groupName, description, users,
			permissions, categories, organizations, fields);
	}

	/**
	 * Deletes the ecms group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGroup the ecms group
	 * @return the ecms group that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup deleteEcmsGroup(
		com.ecoit.elegaldocument.model.EcmsGroup ecmsGroup) {

		return _ecmsGroupLocalService.deleteEcmsGroup(ecmsGroup);
	}

	/**
	 * Deletes the ecms group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group that was removed
	 * @throws PortalException if a ecms group with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup deleteEcmsGroup(
			long groupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecmsGroupLocalService.deleteEcmsGroup(groupUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecmsGroupLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ecmsGroupLocalService.dynamicQuery();
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

		return _ecmsGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl</code>.
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

		return _ecmsGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl</code>.
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

		return _ecmsGroupLocalService.dynamicQuery(
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

		return _ecmsGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ecmsGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup fetchEcmsGroup(
		long groupUserId) {

		return _ecmsGroupLocalService.fetchEcmsGroup(groupUserId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>
			findByGroupId(long groupId, int start, int end, String q)
		throws Exception {

		return _ecmsGroupLocalService.findByGroupId(groupId, start, end, q);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ecmsGroupLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ecms group with the primary key.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group
	 * @throws PortalException if a ecms group with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup getEcmsGroup(
			long groupUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecmsGroupLocalService.getEcmsGroup(groupUserId);
	}

	/**
	 * Returns a range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @return the range of ecms groups
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.EcmsGroup>
		getEcmsGroups(int start, int end) {

		return _ecmsGroupLocalService.getEcmsGroups(start, end);
	}

	/**
	 * Returns the number of ecms groups.
	 *
	 * @return the number of ecms groups
	 */
	@Override
	public int getEcmsGroupsCount() {
		return _ecmsGroupLocalService.getEcmsGroupsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ecmsGroupLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object> getListOfUser(long scopeGroupId)
		throws Exception {

		return _ecmsGroupLocalService.getListOfUser(scopeGroupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecmsGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ecmsGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeEcmsGroup(long groupUserId) throws Exception {
		_ecmsGroupLocalService.removeEcmsGroup(groupUserId);
	}

	/**
	 * Updates the ecms group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGroup the ecms group
	 * @return the ecms group that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.EcmsGroup updateEcmsGroup(
		com.ecoit.elegaldocument.model.EcmsGroup ecmsGroup) {

		return _ecmsGroupLocalService.updateEcmsGroup(ecmsGroup);
	}

	@Override
	public EcmsGroupLocalService getWrappedService() {
		return _ecmsGroupLocalService;
	}

	@Override
	public void setWrappedService(EcmsGroupLocalService ecmsGroupLocalService) {
		_ecmsGroupLocalService = ecmsGroupLocalService;
	}

	private EcmsGroupLocalService _ecmsGroupLocalService;

}