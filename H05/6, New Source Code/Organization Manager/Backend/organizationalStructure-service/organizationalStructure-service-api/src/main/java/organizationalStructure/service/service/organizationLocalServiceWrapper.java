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

package organizationalStructure.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link organizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see organizationLocalService
 * @generated
 */
public class organizationLocalServiceWrapper
	implements organizationLocalService,
			   ServiceWrapper<organizationLocalService> {

	public organizationLocalServiceWrapper(
		organizationLocalService organizationLocalService) {

		_organizationLocalService = organizationLocalService;
	}

	/**
	 * Adds the organization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param organization the organization
	 * @return the organization that was added
	 */
	@Override
	public organizationalStructure.service.model.organization addorganization(
		organizationalStructure.service.model.organization organization) {

		return _organizationLocalService.addorganization(organization);
	}

	/**
	 * Creates a new organization with the primary key. Does not add the organization to the database.
	 *
	 * @param organizationId the primary key for the new organization
	 * @return the new organization
	 */
	@Override
	public organizationalStructure.service.model.organization
		createorganization(long organizationId) {

		return _organizationLocalService.createorganization(organizationId);
	}

	/**
	 * Deletes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization that was removed
	 * @throws PortalException if a organization with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.organization
			deleteorganization(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationLocalService.deleteorganization(organizationId);
	}

	/**
	 * Deletes the organization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organization the organization
	 * @return the organization that was removed
	 */
	@Override
	public organizationalStructure.service.model.organization
		deleteorganization(
			organizationalStructure.service.model.organization organization) {

		return _organizationLocalService.deleteorganization(organization);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationLocalService.dynamicQuery();
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

		return _organizationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationModelImpl</code>.
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

		return _organizationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationModelImpl</code>.
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

		return _organizationLocalService.dynamicQuery(
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

		return _organizationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _organizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public organizationalStructure.service.model.organization fetchorganization(
		long organizationId) {

		return _organizationLocalService.fetchorganization(organizationId);
	}

	/**
	 * Returns the organization matching the UUID and group.
	 *
	 * @param uuid the organization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching organization, or <code>null</code> if a matching organization could not be found
	 */
	@Override
	public organizationalStructure.service.model.organization
		fetchorganizationByUuidAndGroupId(String uuid, long groupId) {

		return _organizationLocalService.fetchorganizationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<organizationalStructure.service.model.organization>
			getNode(
				long parentId, long groupId, String name, int start, int limit)
		throws Exception {

		return _organizationLocalService.getNode(
			parentId, groupId, name, start, limit);
	}

	@Override
	public int getNodeCount(long parentId, long groupId, String name)
		throws Exception {

		return _organizationLocalService.getNodeCount(parentId, groupId, name);
	}

	/**
	 * Returns the organization with the primary key.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization
	 * @throws PortalException if a organization with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.organization getorganization(
			long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationLocalService.getorganization(organizationId);
	}

	/**
	 * Returns the organization matching the UUID and group.
	 *
	 * @param uuid the organization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching organization
	 * @throws PortalException if a matching organization could not be found
	 */
	@Override
	public organizationalStructure.service.model.organization
			getorganizationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationLocalService.getorganizationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of organizations
	 */
	@Override
	public java.util.List<organizationalStructure.service.model.organization>
		getorganizations(int start, int end) {

		return _organizationLocalService.getorganizations(start, end);
	}

	/**
	 * Returns the number of organizations.
	 *
	 * @return the number of organizations
	 */
	@Override
	public int getorganizationsCount() {
		return _organizationLocalService.getorganizationsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param organization the organization
	 * @return the organization that was updated
	 */
	@Override
	public organizationalStructure.service.model.organization
		updateorganization(
			organizationalStructure.service.model.organization organization) {

		return _organizationLocalService.updateorganization(organization);
	}

	@Override
	public organizationLocalService getWrappedService() {
		return _organizationLocalService;
	}

	@Override
	public void setWrappedService(
		organizationLocalService organizationLocalService) {

		_organizationLocalService = organizationLocalService;
	}

	private organizationLocalService _organizationLocalService;

}