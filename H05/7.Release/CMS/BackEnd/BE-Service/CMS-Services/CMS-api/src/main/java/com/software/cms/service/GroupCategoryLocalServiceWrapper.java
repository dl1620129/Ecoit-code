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
 * Provides a wrapper for {@link GroupCategoryLocalService}.
 *
 * @author DungNV
 * @see GroupCategoryLocalService
 * @generated
 */
public class GroupCategoryLocalServiceWrapper
	implements GroupCategoryLocalService,
			   ServiceWrapper<GroupCategoryLocalService> {

	public GroupCategoryLocalServiceWrapper(
		GroupCategoryLocalService groupCategoryLocalService) {

		_groupCategoryLocalService = groupCategoryLocalService;
	}

	/**
	 * Adds the group category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategory the group category
	 * @return the group category that was added
	 */
	@Override
	public com.software.cms.model.GroupCategory addGroupCategory(
		com.software.cms.model.GroupCategory groupCategory) {

		return _groupCategoryLocalService.addGroupCategory(groupCategory);
	}

	@Override
	public void addGroupCategory(long groupUserId, long categoryId) {
		_groupCategoryLocalService.addGroupCategory(groupUserId, categoryId);
	}

	@Override
	public com.software.cms.model.GroupCategory create() {
		return _groupCategoryLocalService.create();
	}

	/**
	 * Creates a new group category with the primary key. Does not add the group category to the database.
	 *
	 * @param groupCategoryPK the primary key for the new group category
	 * @return the new group category
	 */
	@Override
	public com.software.cms.model.GroupCategory createGroupCategory(
		com.software.cms.service.persistence.GroupCategoryPK groupCategoryPK) {

		return _groupCategoryLocalService.createGroupCategory(groupCategoryPK);
	}

	/**
	 * Deletes the group category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategory the group category
	 * @return the group category that was removed
	 */
	@Override
	public com.software.cms.model.GroupCategory deleteGroupCategory(
		com.software.cms.model.GroupCategory groupCategory) {

		return _groupCategoryLocalService.deleteGroupCategory(groupCategory);
	}

	/**
	 * Deletes the group category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category that was removed
	 * @throws PortalException if a group category with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.GroupCategory deleteGroupCategory(
			com.software.cms.service.persistence.GroupCategoryPK
				groupCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupCategoryLocalService.deleteGroupCategory(groupCategoryPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupCategoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupCategoryLocalService.dynamicQuery();
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

		return _groupCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupCategoryModelImpl</code>.
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

		return _groupCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupCategoryModelImpl</code>.
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

		return _groupCategoryLocalService.dynamicQuery(
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

		return _groupCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.GroupCategory fetchGroupCategory(
		com.software.cms.service.persistence.GroupCategoryPK groupCategoryPK) {

		return _groupCategoryLocalService.fetchGroupCategory(groupCategoryPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.software.cms.model.GroupCategory> getByCategory(
		long categoryId) {

		return _groupCategoryLocalService.getByCategory(categoryId);
	}

	@Override
	public java.util.List<com.software.cms.model.GroupCategory>
		getByUserIdAndGroupId(long userId, long groupId) {

		return _groupCategoryLocalService.getByUserIdAndGroupId(
			userId, groupId);
	}

	@Override
	public java.util.List<com.software.cms.model.GroupCategory>
		getByUserIdAndGroupIdAndGroupUserId(
			long userId, long groupId, long groupUserId) {

		return _groupCategoryLocalService.getByUserIdAndGroupIdAndGroupUserId(
			userId, groupId, groupUserId);
	}

	/**
	 * Returns a range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of group categories
	 */
	@Override
	public java.util.List<com.software.cms.model.GroupCategory>
		getGroupCategories(int start, int end) {

		return _groupCategoryLocalService.getGroupCategories(start, end);
	}

	/**
	 * Returns the number of group categories.
	 *
	 * @return the number of group categories
	 */
	@Override
	public int getGroupCategoriesCount() {
		return _groupCategoryLocalService.getGroupCategoriesCount();
	}

	/**
	 * Returns the group category with the primary key.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category
	 * @throws PortalException if a group category with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.GroupCategory getGroupCategory(
			com.software.cms.service.persistence.GroupCategoryPK
				groupCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupCategoryLocalService.getGroupCategory(groupCategoryPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasGroupCategory(long groupUserId, long categoryId) {
		return _groupCategoryLocalService.hasGroupCategory(
			groupUserId, categoryId);
	}

	@Override
	public boolean hasUserAccessCategory(long userId, long categoryId) {
		return _groupCategoryLocalService.hasUserAccessCategory(
			userId, categoryId);
	}

	@Override
	public void removeByCategoryId(long categoryId) {
		_groupCategoryLocalService.removeByCategoryId(categoryId);
	}

	@Override
	public void removeByGroupUserId(long groupUserId) {
		_groupCategoryLocalService.removeByGroupUserId(groupUserId);
	}

	/**
	 * Updates the group category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategory the group category
	 * @return the group category that was updated
	 */
	@Override
	public com.software.cms.model.GroupCategory updateGroupCategory(
		com.software.cms.model.GroupCategory groupCategory) {

		return _groupCategoryLocalService.updateGroupCategory(groupCategory);
	}

	@Override
	public GroupCategoryLocalService getWrappedService() {
		return _groupCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		GroupCategoryLocalService groupCategoryLocalService) {

		_groupCategoryLocalService = groupCategoryLocalService;
	}

	private GroupCategoryLocalService _groupCategoryLocalService;

}