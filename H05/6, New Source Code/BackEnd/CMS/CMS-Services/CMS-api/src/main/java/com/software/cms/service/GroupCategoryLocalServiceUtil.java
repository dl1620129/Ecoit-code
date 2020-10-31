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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroupCategory. This utility wraps
 * <code>com.software.cms.service.impl.GroupCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see GroupCategoryLocalService
 * @generated
 */
public class GroupCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.GroupCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategory the group category
	 * @return the group category that was added
	 */
	public static com.software.cms.model.GroupCategory addGroupCategory(
		com.software.cms.model.GroupCategory groupCategory) {

		return getService().addGroupCategory(groupCategory);
	}

	public static void addGroupCategory(long groupUserId, long categoryId) {
		getService().addGroupCategory(groupUserId, categoryId);
	}

	public static com.software.cms.model.GroupCategory create() {
		return getService().create();
	}

	/**
	 * Creates a new group category with the primary key. Does not add the group category to the database.
	 *
	 * @param groupCategoryPK the primary key for the new group category
	 * @return the new group category
	 */
	public static com.software.cms.model.GroupCategory createGroupCategory(
		com.software.cms.service.persistence.GroupCategoryPK groupCategoryPK) {

		return getService().createGroupCategory(groupCategoryPK);
	}

	/**
	 * Deletes the group category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategory the group category
	 * @return the group category that was removed
	 */
	public static com.software.cms.model.GroupCategory deleteGroupCategory(
		com.software.cms.model.GroupCategory groupCategory) {

		return getService().deleteGroupCategory(groupCategory);
	}

	/**
	 * Deletes the group category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category that was removed
	 * @throws PortalException if a group category with the primary key could not be found
	 */
	public static com.software.cms.model.GroupCategory deleteGroupCategory(
			com.software.cms.service.persistence.GroupCategoryPK
				groupCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupCategory(groupCategoryPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.software.cms.model.GroupCategory fetchGroupCategory(
		com.software.cms.service.persistence.GroupCategoryPK groupCategoryPK) {

		return getService().fetchGroupCategory(groupCategoryPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.software.cms.model.GroupCategory>
		getByCategory(long categoryId) {

		return getService().getByCategory(categoryId);
	}

	public static java.util.List<com.software.cms.model.GroupCategory>
		getByUserIdAndGroupId(long userId, long groupId) {

		return getService().getByUserIdAndGroupId(userId, groupId);
	}

	public static java.util.List<com.software.cms.model.GroupCategory>
		getByUserIdAndGroupIdAndGroupUserId(
			long userId, long groupId, long groupUserId) {

		return getService().getByUserIdAndGroupIdAndGroupUserId(
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
	public static java.util.List<com.software.cms.model.GroupCategory>
		getGroupCategories(int start, int end) {

		return getService().getGroupCategories(start, end);
	}

	/**
	 * Returns the number of group categories.
	 *
	 * @return the number of group categories
	 */
	public static int getGroupCategoriesCount() {
		return getService().getGroupCategoriesCount();
	}

	/**
	 * Returns the group category with the primary key.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category
	 * @throws PortalException if a group category with the primary key could not be found
	 */
	public static com.software.cms.model.GroupCategory getGroupCategory(
			com.software.cms.service.persistence.GroupCategoryPK
				groupCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupCategory(groupCategoryPK);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasGroupCategory(long groupUserId, long categoryId) {
		return getService().hasGroupCategory(groupUserId, categoryId);
	}

	public static boolean hasUserAccessCategory(long userId, long categoryId) {
		return getService().hasUserAccessCategory(userId, categoryId);
	}

	public static void removeByCategoryId(long categoryId) {
		getService().removeByCategoryId(categoryId);
	}

	public static void removeByGroupUserId(long groupUserId) {
		getService().removeByGroupUserId(groupUserId);
	}

	/**
	 * Updates the group category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategory the group category
	 * @return the group category that was updated
	 */
	public static com.software.cms.model.GroupCategory updateGroupCategory(
		com.software.cms.model.GroupCategory groupCategory) {

		return getService().updateGroupCategory(groupCategory);
	}

	public static GroupCategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupCategoryLocalService, GroupCategoryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupCategoryLocalService.class);

		ServiceTracker<GroupCategoryLocalService, GroupCategoryLocalService>
			serviceTracker =
				new ServiceTracker
					<GroupCategoryLocalService, GroupCategoryLocalService>(
						bundle.getBundleContext(),
						GroupCategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}