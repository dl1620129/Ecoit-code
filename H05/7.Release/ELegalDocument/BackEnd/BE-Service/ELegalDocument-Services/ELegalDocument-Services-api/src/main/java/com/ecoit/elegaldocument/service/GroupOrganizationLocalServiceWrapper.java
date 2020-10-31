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
 * Provides a wrapper for {@link GroupOrganizationLocalService}.
 *
 * @author Liverpool
 * @see GroupOrganizationLocalService
 * @generated
 */
public class GroupOrganizationLocalServiceWrapper
	implements GroupOrganizationLocalService,
			   ServiceWrapper<GroupOrganizationLocalService> {

	public GroupOrganizationLocalServiceWrapper(
		GroupOrganizationLocalService groupOrganizationLocalService) {

		_groupOrganizationLocalService = groupOrganizationLocalService;
	}

	/**
	 * Adds the group organization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganization the group organization
	 * @return the group organization that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
		addGroupOrganization(
			com.ecoit.elegaldocument.model.GroupOrganization
				groupOrganization) {

		return _groupOrganizationLocalService.addGroupOrganization(
			groupOrganization);
	}

	@Override
	public void addGroupOrganization(long groupUserId, long OrganizationId) {
		_groupOrganizationLocalService.addGroupOrganization(
			groupUserId, OrganizationId);
	}

	/**
	 * Creates a new group organization with the primary key. Does not add the group organization to the database.
	 *
	 * @param groupOrganizationPK the primary key for the new group organization
	 * @return the new group organization
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
		createGroupOrganization(
			com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
				groupOrganizationPK) {

		return _groupOrganizationLocalService.createGroupOrganization(
			groupOrganizationPK);
	}

	/**
	 * Deletes the group organization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganization the group organization
	 * @return the group organization that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
		deleteGroupOrganization(
			com.ecoit.elegaldocument.model.GroupOrganization
				groupOrganization) {

		return _groupOrganizationLocalService.deleteGroupOrganization(
			groupOrganization);
	}

	/**
	 * Deletes the group organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization that was removed
	 * @throws PortalException if a group organization with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
			deleteGroupOrganization(
				com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
					groupOrganizationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupOrganizationLocalService.deleteGroupOrganization(
			groupOrganizationPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupOrganizationLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupOrganizationLocalService.dynamicQuery();
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

		return _groupOrganizationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl</code>.
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

		return _groupOrganizationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl</code>.
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

		return _groupOrganizationLocalService.dynamicQuery(
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

		return _groupOrganizationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupOrganizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
		fetchGroupOrganization(
			com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
				groupOrganizationPK) {

		return _groupOrganizationLocalService.fetchGroupOrganization(
			groupOrganizationPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupOrganizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupOrganization>
		getByOrganization(long OrganizationId) {

		return _groupOrganizationLocalService.getByOrganization(OrganizationId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupOrganization>
		getByUserIdAndGroupId(long userId, long groupId) {

		return _groupOrganizationLocalService.getByUserIdAndGroupId(
			userId, groupId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupOrganization>
		getByUserIdAndGroupIdAndGroupUserId(
			long userId, long groupId, long groupUserId) {

		return _groupOrganizationLocalService.
			getByUserIdAndGroupIdAndGroupUserId(userId, groupId, groupUserId);
	}

	/**
	 * Returns the group organization with the primary key.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization
	 * @throws PortalException if a group organization with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
			getGroupOrganization(
				com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK
					groupOrganizationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupOrganizationLocalService.getGroupOrganization(
			groupOrganizationPK);
	}

	/**
	 * Returns a range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of group organizations
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupOrganization>
		getGroupOrganizations(int start, int end) {

		return _groupOrganizationLocalService.getGroupOrganizations(start, end);
	}

	/**
	 * Returns the number of group organizations.
	 *
	 * @return the number of group organizations
	 */
	@Override
	public int getGroupOrganizationsCount() {
		return _groupOrganizationLocalService.getGroupOrganizationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupOrganizationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupOrganizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupOrganizationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasGroupOrganization(long groupUserId, long OrganizationId) {
		return _groupOrganizationLocalService.hasGroupOrganization(
			groupUserId, OrganizationId);
	}

	@Override
	public boolean hasUserAccessOrganization(long userId, long OrganizationId) {
		return _groupOrganizationLocalService.hasUserAccessOrganization(
			userId, OrganizationId);
	}

	@Override
	public void removeByGroupUserId(long groupUserId) {
		_groupOrganizationLocalService.removeByGroupUserId(groupUserId);
	}

	@Override
	public void removeByOrganizationId(long OrganizationId) {
		_groupOrganizationLocalService.removeByOrganizationId(OrganizationId);
	}

	/**
	 * Updates the group organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganization the group organization
	 * @return the group organization that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupOrganization
		updateGroupOrganization(
			com.ecoit.elegaldocument.model.GroupOrganization
				groupOrganization) {

		return _groupOrganizationLocalService.updateGroupOrganization(
			groupOrganization);
	}

	@Override
	public GroupOrganizationLocalService getWrappedService() {
		return _groupOrganizationLocalService;
	}

	@Override
	public void setWrappedService(
		GroupOrganizationLocalService groupOrganizationLocalService) {

		_groupOrganizationLocalService = groupOrganizationLocalService;
	}

	private GroupOrganizationLocalService _groupOrganizationLocalService;

}