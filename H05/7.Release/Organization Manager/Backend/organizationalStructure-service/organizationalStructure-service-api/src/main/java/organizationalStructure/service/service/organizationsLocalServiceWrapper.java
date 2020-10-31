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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link organizationsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see organizationsLocalService
 * @generated
 */
@ProviderType
public class organizationsLocalServiceWrapper
	implements organizationsLocalService,
			   ServiceWrapper<organizationsLocalService> {

	public organizationsLocalServiceWrapper(
		organizationsLocalService organizationsLocalService) {

		_organizationsLocalService = organizationsLocalService;
	}

	/**
	 * Adds the organizations to the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizations the organizations
	 * @return the organizations that was added
	 */
	@Override
	public organizationalStructure.service.model.organizations addorganizations(
		organizationalStructure.service.model.organizations organizations) {

		return _organizationsLocalService.addorganizations(organizations);
	}

	/**
	 * Creates a new organizations with the primary key. Does not add the organizations to the database.
	 *
	 * @param organizationId the primary key for the new organizations
	 * @return the new organizations
	 */
	@Override
	public organizationalStructure.service.model.organizations
		createorganizations(long organizationId) {

		return _organizationsLocalService.createorganizations(organizationId);
	}

	/**
	 * Deletes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations that was removed
	 * @throws PortalException if a organizations with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.organizations
			deleteorganizations(long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationsLocalService.deleteorganizations(organizationId);
	}

	/**
	 * Deletes the organizations from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizations the organizations
	 * @return the organizations that was removed
	 */
	@Override
	public organizationalStructure.service.model.organizations
		deleteorganizations(
			organizationalStructure.service.model.organizations organizations) {

		return _organizationsLocalService.deleteorganizations(organizations);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organizationsLocalService.dynamicQuery();
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

		return _organizationsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _organizationsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _organizationsLocalService.dynamicQuery(
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

		return _organizationsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _organizationsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public organizationalStructure.service.model.organizations
		fetchorganizations(long organizationId) {

		return _organizationsLocalService.fetchorganizations(organizationId);
	}

	/**
	 * Returns the organizations matching the UUID and group.
	 *
	 * @param uuid the organizations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	@Override
	public organizationalStructure.service.model.organizations
		fetchorganizationsByUuidAndGroupId(String uuid, long groupId) {

		return _organizationsLocalService.fetchorganizationsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _organizationsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _organizationsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the organizations with the primary key.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations
	 * @throws PortalException if a organizations with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.organizations getorganizations(
			long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationsLocalService.getorganizations(organizationId);
	}

	/**
	 * Returns the organizations matching the UUID and group.
	 *
	 * @param uuid the organizations's UUID
	 * @param groupId the primary key of the group
	 * @return the matching organizations
	 * @throws PortalException if a matching organizations could not be found
	 */
	@Override
	public organizationalStructure.service.model.organizations
			getorganizationsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationsLocalService.getorganizationsByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of organizationses
	 */
	@Override
	public java.util.List<organizationalStructure.service.model.organizations>
		getorganizationses(int start, int end) {

		return _organizationsLocalService.getorganizationses(start, end);
	}

	/**
	 * Returns the number of organizationses.
	 *
	 * @return the number of organizationses
	 */
	@Override
	public int getorganizationsesCount() {
		return _organizationsLocalService.getorganizationsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _organizationsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _organizationsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the organizations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param organizations the organizations
	 * @return the organizations that was updated
	 */
	@Override
	public organizationalStructure.service.model.organizations
		updateorganizations(
			organizationalStructure.service.model.organizations organizations) {

		return _organizationsLocalService.updateorganizations(organizations);
	}

	@Override
	public organizationsLocalService getWrappedService() {
		return _organizationsLocalService;
	}

	@Override
	public void setWrappedService(
		organizationsLocalService organizationsLocalService) {

		_organizationsLocalService = organizationsLocalService;
	}

	private organizationsLocalService _organizationsLocalService;

}