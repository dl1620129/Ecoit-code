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

package com.software.cms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupUserUsersLocalService}.
 *
 * @author DungNV
 * @see GroupUserUsersLocalService
 * @generated
 */
public class GroupUserUsersLocalServiceWrapper
	implements GroupUserUsersLocalService,
			   ServiceWrapper<GroupUserUsersLocalService> {

	public GroupUserUsersLocalServiceWrapper(
		GroupUserUsersLocalService groupUserUsersLocalService) {

		_groupUserUsersLocalService = groupUserUsersLocalService;
	}

	/**
	 * Adds the group user users to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsers the group user users
	 * @return the group user users that was added
	 */
	@Override
	public com.software.cms.model.GroupUserUsers addGroupUserUsers(
		com.software.cms.model.GroupUserUsers groupUserUsers) {

		return _groupUserUsersLocalService.addGroupUserUsers(groupUserUsers);
	}

	@Override
	public void addGroupUserUsers(long groupId, long groupUserId, long userId) {
		_groupUserUsersLocalService.addGroupUserUsers(
			groupId, groupUserId, userId);
	}

	@Override
	public com.software.cms.model.GroupUserUsers create() {
		return _groupUserUsersLocalService.create();
	}

	/**
	 * Creates a new group user users with the primary key. Does not add the group user users to the database.
	 *
	 * @param groupUserUsersPK the primary key for the new group user users
	 * @return the new group user users
	 */
	@Override
	public com.software.cms.model.GroupUserUsers createGroupUserUsers(
		com.software.cms.service.persistence.GroupUserUsersPK
			groupUserUsersPK) {

		return _groupUserUsersLocalService.createGroupUserUsers(
			groupUserUsersPK);
	}

	/**
	 * Deletes the group user users from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsers the group user users
	 * @return the group user users that was removed
	 */
	@Override
	public com.software.cms.model.GroupUserUsers deleteGroupUserUsers(
		com.software.cms.model.GroupUserUsers groupUserUsers) {

		return _groupUserUsersLocalService.deleteGroupUserUsers(groupUserUsers);
	}

	/**
	 * Deletes the group user users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users that was removed
	 * @throws PortalException if a group user users with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.GroupUserUsers deleteGroupUserUsers(
			com.software.cms.service.persistence.GroupUserUsersPK
				groupUserUsersPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserUsersLocalService.deleteGroupUserUsers(
			groupUserUsersPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserUsersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupUserUsersLocalService.dynamicQuery();
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

		return _groupUserUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupUserUsersModelImpl</code>.
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

		return _groupUserUsersLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupUserUsersModelImpl</code>.
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

		return _groupUserUsersLocalService.dynamicQuery(
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

		return _groupUserUsersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupUserUsersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.GroupUserUsers fetchGroupUserUsers(
		com.software.cms.service.persistence.GroupUserUsersPK
			groupUserUsersPK) {

		return _groupUserUsersLocalService.fetchGroupUserUsers(
			groupUserUsersPK);
	}

	/**
	 * @param groupId
	 * @param groupUserId
	 * @return
	 */
	@Override
	public java.util.List<com.software.cms.model.GroupUserUsers>
		findByGroup_GroupUser(long groupId, long groupUserId) {

		return _groupUserUsersLocalService.findByGroup_GroupUser(
			groupId, groupUserId);
	}

	@Override
	public java.util.List<com.software.cms.model.GroupUserUsers>
		findByUser_Group(long userId, long groupId) {

		return _groupUserUsersLocalService.findByUser_Group(userId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupUserUsersLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the group user users with the primary key.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users
	 * @throws PortalException if a group user users with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.GroupUserUsers getGroupUserUsers(
			com.software.cms.service.persistence.GroupUserUsersPK
				groupUserUsersPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserUsersLocalService.getGroupUserUsers(groupUserUsersPK);
	}

	/**
	 * Returns a range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of group user userses
	 */
	@Override
	public java.util.List<com.software.cms.model.GroupUserUsers>
		getGroupUserUserses(int start, int end) {

		return _groupUserUsersLocalService.getGroupUserUserses(start, end);
	}

	/**
	 * Returns the number of group user userses.
	 *
	 * @return the number of group user userses
	 */
	@Override
	public int getGroupUserUsersesCount() {
		return _groupUserUsersLocalService.getGroupUserUsersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupUserUsersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupUserUsersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasGroupUserUsers(long groupUserId, long userId) {
		return _groupUserUsersLocalService.hasGroupUserUsers(
			groupUserId, userId);
	}

	/**
	 * @param groupId
	 * @param groupUserId
	 */
	@Override
	public void removeByGroup_GroupUser(long groupId, long groupUserId) {
		_groupUserUsersLocalService.removeByGroup_GroupUser(
			groupId, groupUserId);
	}

	/**
	 * Updates the group user users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsers the group user users
	 * @return the group user users that was updated
	 */
	@Override
	public com.software.cms.model.GroupUserUsers updateGroupUserUsers(
		com.software.cms.model.GroupUserUsers groupUserUsers) {

		return _groupUserUsersLocalService.updateGroupUserUsers(groupUserUsers);
	}

	@Override
	public GroupUserUsersLocalService getWrappedService() {
		return _groupUserUsersLocalService;
	}

	@Override
	public void setWrappedService(
		GroupUserUsersLocalService groupUserUsersLocalService) {

		_groupUserUsersLocalService = groupUserUsersLocalService;
	}

	private GroupUserUsersLocalService _groupUserUsersLocalService;

}