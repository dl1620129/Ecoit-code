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

package com.ecoit.lichcongtac.services.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserGroupRelLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRelLocalService
 * @generated
 */
public class UserGroupRelLocalServiceWrapper
	implements ServiceWrapper<UserGroupRelLocalService>,
			   UserGroupRelLocalService {

	public UserGroupRelLocalServiceWrapper(
		UserGroupRelLocalService userGroupRelLocalService) {

		_userGroupRelLocalService = userGroupRelLocalService;
	}

	/**
	 * Adds the user group rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRel the user group rel
	 * @return the user group rel that was added
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel addUserGroupRel(
		com.ecoit.lichcongtac.services.model.UserGroupRel userGroupRel) {

		return _userGroupRelLocalService.addUserGroupRel(userGroupRel);
	}

	@Override
	public int countMemberInGroup(long userGroupId) {
		return _userGroupRelLocalService.countMemberInGroup(userGroupId);
	}

	@Override
	public void createUserGroupRel(long userGroupId, long userId) {
		_userGroupRelLocalService.createUserGroupRel(userGroupId, userId);
	}

	/**
	 * Creates a new user group rel with the primary key. Does not add the user group rel to the database.
	 *
	 * @param userGroupRelPK the primary key for the new user group rel
	 * @return the new user group rel
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel createUserGroupRel(
		com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK
			userGroupRelPK) {

		return _userGroupRelLocalService.createUserGroupRel(userGroupRelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupRelLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user group rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRel the user group rel
	 * @return the user group rel that was removed
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel deleteUserGroupRel(
		com.ecoit.lichcongtac.services.model.UserGroupRel userGroupRel) {

		return _userGroupRelLocalService.deleteUserGroupRel(userGroupRel);
	}

	/**
	 * Deletes the user group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel that was removed
	 * @throws PortalException if a user group rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel deleteUserGroupRel(
			com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK
				userGroupRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupRelLocalService.deleteUserGroupRel(userGroupRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userGroupRelLocalService.dynamicQuery();
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

		return _userGroupRelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.UserGroupRelModelImpl</code>.
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

		return _userGroupRelLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.UserGroupRelModelImpl</code>.
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

		return _userGroupRelLocalService.dynamicQuery(
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

		return _userGroupRelLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userGroupRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel fetchUserGroupRel(
		com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK
			userGroupRelPK) {

		return _userGroupRelLocalService.fetchUserGroupRel(userGroupRelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userGroupRelLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.UserGroupRel>
		getByUserId(long userId) {

		return _userGroupRelLocalService.getByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userGroupRelLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userGroupRelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupRelLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user group rel with the primary key.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel
	 * @throws PortalException if a user group rel with the primary key could not be found
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel getUserGroupRel(
			com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK
				userGroupRelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userGroupRelLocalService.getUserGroupRel(userGroupRelPK);
	}

	/**
	 * Returns a range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of user group rels
	 */
	@Override
	public java.util.List<com.ecoit.lichcongtac.services.model.UserGroupRel>
		getUserGroupRels(int start, int end) {

		return _userGroupRelLocalService.getUserGroupRels(start, end);
	}

	/**
	 * Returns the number of user group rels.
	 *
	 * @return the number of user group rels
	 */
	@Override
	public int getUserGroupRelsCount() {
		return _userGroupRelLocalService.getUserGroupRelsCount();
	}

	@Override
	public boolean isContain(long groupUserId, long userId) {
		return _userGroupRelLocalService.isContain(groupUserId, userId);
	}

	/**
	 * Updates the user group rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRel the user group rel
	 * @return the user group rel that was updated
	 */
	@Override
	public com.ecoit.lichcongtac.services.model.UserGroupRel updateUserGroupRel(
		com.ecoit.lichcongtac.services.model.UserGroupRel userGroupRel) {

		return _userGroupRelLocalService.updateUserGroupRel(userGroupRel);
	}

	@Override
	public UserGroupRelLocalService getWrappedService() {
		return _userGroupRelLocalService;
	}

	@Override
	public void setWrappedService(
		UserGroupRelLocalService userGroupRelLocalService) {

		_userGroupRelLocalService = userGroupRelLocalService;
	}

	private UserGroupRelLocalService _userGroupRelLocalService;

}