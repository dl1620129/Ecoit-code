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

package com.ecoit.qa.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupUserCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserCategoryLocalService
 * @generated
 */
public class GroupUserCategoryLocalServiceWrapper
	implements GroupUserCategoryLocalService,
			   ServiceWrapper<GroupUserCategoryLocalService> {

	public GroupUserCategoryLocalServiceWrapper(
		GroupUserCategoryLocalService groupUserCategoryLocalService) {

		_groupUserCategoryLocalService = groupUserCategoryLocalService;
	}

	/**
	 * Adds the group user category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategory the group user category
	 * @return the group user category that was added
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserCategory addGroupUserCategory(
		com.ecoit.qa.service.model.GroupUserCategory groupUserCategory) {

		return _groupUserCategoryLocalService.addGroupUserCategory(
			groupUserCategory);
	}

	/**
	 * Creates a new group user category with the primary key. Does not add the group user category to the database.
	 *
	 * @param groupUserCategoryPK the primary key for the new group user category
	 * @return the new group user category
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserCategory createGroupUserCategory(
		com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
			groupUserCategoryPK) {

		return _groupUserCategoryLocalService.createGroupUserCategory(
			groupUserCategoryPK);
	}

	@Override
	public void createGroupUserCategory(long groupUserId, long categoryId)
		throws Exception {

		_groupUserCategoryLocalService.createGroupUserCategory(
			groupUserId, categoryId);
	}

	/**
	 * Deletes the group user category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategory the group user category
	 * @return the group user category that was removed
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserCategory deleteGroupUserCategory(
		com.ecoit.qa.service.model.GroupUserCategory groupUserCategory) {

		return _groupUserCategoryLocalService.deleteGroupUserCategory(
			groupUserCategory);
	}

	/**
	 * Deletes the group user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category that was removed
	 * @throws PortalException if a group user category with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserCategory deleteGroupUserCategory(
			com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
				groupUserCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserCategoryLocalService.deleteGroupUserCategory(
			groupUserCategoryPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupUserCategoryLocalService.dynamicQuery();
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

		return _groupUserCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserCategoryModelImpl</code>.
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

		return _groupUserCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserCategoryModelImpl</code>.
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

		return _groupUserCategoryLocalService.dynamicQuery(
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

		return _groupUserCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupUserCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.qa.service.model.GroupUserCategory fetchGroupUserCategory(
		com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
			groupUserCategoryPK) {

		return _groupUserCategoryLocalService.fetchGroupUserCategory(
			groupUserCategoryPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupUserCategoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of group user categories
	 */
	@Override
	public java.util.List<com.ecoit.qa.service.model.GroupUserCategory>
		getGroupUserCategories(int start, int end) {

		return _groupUserCategoryLocalService.getGroupUserCategories(
			start, end);
	}

	/**
	 * Returns the number of group user categories.
	 *
	 * @return the number of group user categories
	 */
	@Override
	public int getGroupUserCategoriesCount() {
		return _groupUserCategoryLocalService.getGroupUserCategoriesCount();
	}

	/**
	 * Returns the group user category with the primary key.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category
	 * @throws PortalException if a group user category with the primary key could not be found
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserCategory getGroupUserCategory(
			com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
				groupUserCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserCategoryLocalService.getGroupUserCategory(
			groupUserCategoryPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupUserCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupUserCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupUserCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasCategory(long groupUserId, long categoryId) {
		return _groupUserCategoryLocalService.hasCategory(
			groupUserId, categoryId);
	}

	@Override
	public void removeByCategoryId(long categoryId) {
		_groupUserCategoryLocalService.removeByCategoryId(categoryId);
	}

	@Override
	public void removeByGroupUserId(long groupUserId) {
		_groupUserCategoryLocalService.removeByGroupUserId(groupUserId);
	}

	/**
	 * Updates the group user category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategory the group user category
	 * @return the group user category that was updated
	 */
	@Override
	public com.ecoit.qa.service.model.GroupUserCategory updateGroupUserCategory(
		com.ecoit.qa.service.model.GroupUserCategory groupUserCategory) {

		return _groupUserCategoryLocalService.updateGroupUserCategory(
			groupUserCategory);
	}

	@Override
	public GroupUserCategoryLocalService getWrappedService() {
		return _groupUserCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		GroupUserCategoryLocalService groupUserCategoryLocalService) {

		_groupUserCategoryLocalService = groupUserCategoryLocalService;
	}

	private GroupUserCategoryLocalService _groupUserCategoryLocalService;

}