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
 * Provides a wrapper for {@link UserOrganizationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserOrganizationLocalService
 * @generated
 */
public class UserOrganizationLocalServiceWrapper
	implements ServiceWrapper<UserOrganizationLocalService>,
			   UserOrganizationLocalService {

	public UserOrganizationLocalServiceWrapper(
		UserOrganizationLocalService userOrganizationLocalService) {

		_userOrganizationLocalService = userOrganizationLocalService;
	}

	/**
	 * Adds the user organization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOrganization the user organization
	 * @return the user organization that was added
	 */
	@Override
	public organizationalStructure.service.model.UserOrganization
		addUserOrganization(
			organizationalStructure.service.model.UserOrganization
				userOrganization) {

		return _userOrganizationLocalService.addUserOrganization(
			userOrganization);
	}

	@Override
	public void createUserOrganization(long userId, long organizationId) {
		_userOrganizationLocalService.createUserOrganization(
			userId, organizationId);
	}

	/**
	 * Creates a new user organization with the primary key. Does not add the user organization to the database.
	 *
	 * @param userOrganizationPK the primary key for the new user organization
	 * @return the new user organization
	 */
	@Override
	public organizationalStructure.service.model.UserOrganization
		createUserOrganization(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK) {

		return _userOrganizationLocalService.createUserOrganization(
			userOrganizationPK);
	}

	@Override
	public void deleteByUserId(long userId) {
		_userOrganizationLocalService.deleteByUserId(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOrganizationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user organization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOrganization the user organization
	 * @return the user organization that was removed
	 */
	@Override
	public organizationalStructure.service.model.UserOrganization
		deleteUserOrganization(
			organizationalStructure.service.model.UserOrganization
				userOrganization) {

		return _userOrganizationLocalService.deleteUserOrganization(
			userOrganization);
	}

	/**
	 * Deletes the user organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization that was removed
	 * @throws PortalException if a user organization with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.UserOrganization
			deleteUserOrganization(
				organizationalStructure.service.service.persistence.
					UserOrganizationPK userOrganizationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOrganizationLocalService.deleteUserOrganization(
			userOrganizationPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userOrganizationLocalService.dynamicQuery();
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

		return _userOrganizationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.UserOrganizationModelImpl</code>.
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

		return _userOrganizationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.UserOrganizationModelImpl</code>.
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

		return _userOrganizationLocalService.dynamicQuery(
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

		return _userOrganizationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userOrganizationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public organizationalStructure.service.model.UserOrganization
		fetchUserOrganization(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK) {

		return _userOrganizationLocalService.fetchUserOrganization(
			userOrganizationPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userOrganizationLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<organizationalStructure.service.model.UserOrganization>
			getByOrganization(long organizationId) {

		return _userOrganizationLocalService.getByOrganization(organizationId);
	}

	@Override
	public java.util.List
		<organizationalStructure.service.model.UserOrganization> getByUser(
			long userId) {

		return _userOrganizationLocalService.getByUser(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userOrganizationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userOrganizationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOrganizationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user organization with the primary key.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization
	 * @throws PortalException if a user organization with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.UserOrganization
			getUserOrganization(
				organizationalStructure.service.service.persistence.
					UserOrganizationPK userOrganizationPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userOrganizationLocalService.getUserOrganization(
			userOrganizationPK);
	}

	/**
	 * Returns a range of all the user organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @return the range of user organizations
	 */
	@Override
	public java.util.List
		<organizationalStructure.service.model.UserOrganization>
			getUserOrganizations(int start, int end) {

		return _userOrganizationLocalService.getUserOrganizations(start, end);
	}

	/**
	 * Returns the number of user organizations.
	 *
	 * @return the number of user organizations
	 */
	@Override
	public int getUserOrganizationsCount() {
		return _userOrganizationLocalService.getUserOrganizationsCount();
	}

	/**
	 * Updates the user organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userOrganization the user organization
	 * @return the user organization that was updated
	 */
	@Override
	public organizationalStructure.service.model.UserOrganization
		updateUserOrganization(
			organizationalStructure.service.model.UserOrganization
				userOrganization) {

		return _userOrganizationLocalService.updateUserOrganization(
			userOrganization);
	}

	@Override
	public UserOrganizationLocalService getWrappedService() {
		return _userOrganizationLocalService;
	}

	@Override
	public void setWrappedService(
		UserOrganizationLocalService userOrganizationLocalService) {

		_userOrganizationLocalService = userOrganizationLocalService;
	}

	private UserOrganizationLocalService _userOrganizationLocalService;

}