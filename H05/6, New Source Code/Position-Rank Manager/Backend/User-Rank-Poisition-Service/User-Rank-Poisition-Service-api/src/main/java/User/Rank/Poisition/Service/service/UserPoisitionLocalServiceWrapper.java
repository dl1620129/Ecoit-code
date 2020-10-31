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

package User.Rank.Poisition.Service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link UserPoisitionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisitionLocalService
 * @generated
 */
@ProviderType
public class UserPoisitionLocalServiceWrapper
	implements UserPoisitionLocalService,
			   ServiceWrapper<UserPoisitionLocalService> {

	public UserPoisitionLocalServiceWrapper(
		UserPoisitionLocalService userPoisitionLocalService) {

		_userPoisitionLocalService = userPoisitionLocalService;
	}

	/**
	 * Adds the user poisition to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition the user poisition
	 * @return the user poisition that was added
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition addUserPoisition(
		User.Rank.Poisition.Service.model.UserPoisition userPoisition) {

		return _userPoisitionLocalService.addUserPoisition(userPoisition);
	}

	/**
	 * Creates a new user poisition with the primary key. Does not add the user poisition to the database.
	 *
	 * @param userPoisitionId the primary key for the new user poisition
	 * @return the new user poisition
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition createUserPoisition(
		long userPoisitionId) {

		return _userPoisitionLocalService.createUserPoisition(userPoisitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisitionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user poisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionId the primary key of the user poisition
	 * @return the user poisition that was removed
	 * @throws PortalException if a user poisition with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition deleteUserPoisition(
			long userPoisitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisitionLocalService.deleteUserPoisition(userPoisitionId);
	}

	/**
	 * Deletes the user poisition from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition the user poisition
	 * @return the user poisition that was removed
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition deleteUserPoisition(
		User.Rank.Poisition.Service.model.UserPoisition userPoisition) {

		return _userPoisitionLocalService.deleteUserPoisition(userPoisition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPoisitionLocalService.dynamicQuery();
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

		return _userPoisitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _userPoisitionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _userPoisitionLocalService.dynamicQuery(
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

		return _userPoisitionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userPoisitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public User.Rank.Poisition.Service.model.UserPoisition fetchUserPoisition(
		long userPoisitionId) {

		return _userPoisitionLocalService.fetchUserPoisition(userPoisitionId);
	}

	/**
	 * Returns the user poisition matching the UUID and group.
	 *
	 * @param uuid the user poisition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition
		fetchUserPoisitionByUuidAndGroupId(String uuid, long groupId) {

		return _userPoisitionLocalService.fetchUserPoisitionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userPoisitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountAll(String name, long groupId) throws Exception {
		return _userPoisitionLocalService.getCountAll(name, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userPoisitionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userPoisitionLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition>
			getListUserPoisition(
				long groupId, String name, int start, int limit)
		throws Exception {

		return _userPoisitionLocalService.getListUserPoisition(
			groupId, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPoisitionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user poisition with the primary key.
	 *
	 * @param userPoisitionId the primary key of the user poisition
	 * @return the user poisition
	 * @throws PortalException if a user poisition with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition getUserPoisition(
			long userPoisitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisitionLocalService.getUserPoisition(userPoisitionId);
	}

	/**
	 * Returns the user poisition matching the UUID and group.
	 *
	 * @param uuid the user poisition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition
	 * @throws PortalException if a matching user poisition could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition
			getUserPoisitionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisitionLocalService.getUserPoisitionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the user poisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @return the range of user poisitions
	 */
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition>
		getUserPoisitions(int start, int end) {

		return _userPoisitionLocalService.getUserPoisitions(start, end);
	}

	/**
	 * Returns all the user poisitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisitions
	 * @param companyId the primary key of the company
	 * @return the matching user poisitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition>
		getUserPoisitionsByUuidAndCompanyId(String uuid, long companyId) {

		return _userPoisitionLocalService.getUserPoisitionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of user poisitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user poisitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition>
		getUserPoisitionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<User.Rank.Poisition.Service.model.UserPoisition>
					orderByComparator) {

		return _userPoisitionLocalService.getUserPoisitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user poisitions.
	 *
	 * @return the number of user poisitions
	 */
	@Override
	public int getUserPoisitionsCount() {
		return _userPoisitionLocalService.getUserPoisitionsCount();
	}

	/**
	 * Updates the user poisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition the user poisition
	 * @return the user poisition that was updated
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition updateUserPoisition(
		User.Rank.Poisition.Service.model.UserPoisition userPoisition) {

		return _userPoisitionLocalService.updateUserPoisition(userPoisition);
	}

	@Override
	public UserPoisitionLocalService getWrappedService() {
		return _userPoisitionLocalService;
	}

	@Override
	public void setWrappedService(
		UserPoisitionLocalService userPoisitionLocalService) {

		_userPoisitionLocalService = userPoisitionLocalService;
	}

	private UserPoisitionLocalService _userPoisitionLocalService;

}