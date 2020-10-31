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

package com.ecoit.mr.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupLocalService
 * @generated
 */
public class UserGroupLocalServiceWrapper
	implements ServiceWrapper<UserGroupLocalService>, UserGroupLocalService {

	public UserGroupLocalServiceWrapper(
		UserGroupLocalService userGroupLocalService) {

		_userGroupLocalService = userGroupLocalService;
	}

	/**
	 * Adds the user group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroup the user group
	 * @return the user group that was added
	 */
	@Override
	public com.ecoit.mr.model.UserGroup addUserGroup(
		com.ecoit.mr.model.UserGroup userGroup) {

		return _userGroupLocalService.addUserGroup(userGroup);
	}

	@Override
	public int countMemberInGroup(long userpermissiongroupid) throws Exception {
		return _userGroupLocalService.countMemberInGroup(userpermissiongroupid);
	}

	@Override
	public void createUserGroup(long userGroupId, long userId) {
		_userGroupLocalService.createUserGroup(userGroupId, userId);
	}

	/**
	 * Creates a new user group with the primary key. Does not add the user group to the database.
	 *
	 * @param userGroupPK the primary key for the new user group
	 * @return the new user group
	 */
	@Override
	public com.ecoit.mr.model.UserGroup createUserGroup(
		com.ecoit.mr.service.persistence.UserGroupPK userGroupPK) {

		return _userGroupLocalService.createUserGroup(userGroupPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroup the user group
	 * @return the user group that was removed
	 */
	@Override
	public com.ecoit.mr.model.UserGroup deleteUserGroup(
		com.ecoit.mr.model.UserGroup userGroup) {

		return _userGroupLocalService.deleteUserGroup(userGroup);
	}

	/**
	 * Deletes the user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group that was removed
	 * @throws PortalException if a user group with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.UserGroup deleteUserGroup(
			com.ecoit.mr.service.persistence.UserGroupPK userGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupLocalService.deleteUserGroup(userGroupPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userGroupLocalService.dynamicQuery();
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

		return _userGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserGroupModelImpl</code>.
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

		return _userGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserGroupModelImpl</code>.
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

		return _userGroupLocalService.dynamicQuery(
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

		return _userGroupLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userGroupLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.mr.model.UserGroup fetchUserGroup(
		com.ecoit.mr.service.persistence.UserGroupPK userGroupPK) {

		return _userGroupLocalService.fetchUserGroup(userGroupPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.mr.model.UserGroup> getByUserId(
		long userId) {

		return _userGroupLocalService.getByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userGroupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user group with the primary key.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group
	 * @throws PortalException if a user group with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.UserGroup getUserGroup(
			com.ecoit.mr.service.persistence.UserGroupPK userGroupPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupLocalService.getUserGroup(userGroupPK);
	}

	/**
	 * Returns a range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of user groups
	 */
	@Override
	public java.util.List<com.ecoit.mr.model.UserGroup> getUserGroups(
		int start, int end) {

		return _userGroupLocalService.getUserGroups(start, end);
	}

	/**
	 * Returns the number of user groups.
	 *
	 * @return the number of user groups
	 */
	@Override
	public int getUserGroupsCount() {
		return _userGroupLocalService.getUserGroupsCount();
	}

	@Override
	public boolean isContain(long groupUserId, long userId) {
		return _userGroupLocalService.isContain(groupUserId, userId);
	}

	/**
	 * Updates the user group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userGroup the user group
	 * @return the user group that was updated
	 */
	@Override
	public com.ecoit.mr.model.UserGroup updateUserGroup(
		com.ecoit.mr.model.UserGroup userGroup) {

		return _userGroupLocalService.updateUserGroup(userGroup);
	}

	@Override
	public UserGroupLocalService getWrappedService() {
		return _userGroupLocalService;
	}

	@Override
	public void setWrappedService(UserGroupLocalService userGroupLocalService) {
		_userGroupLocalService = userGroupLocalService;
	}

	private UserGroupLocalService _userGroupLocalService;

}