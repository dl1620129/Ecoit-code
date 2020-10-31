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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroupUserCategory. This utility wraps
 * <code>com.ecoit.qa.service.service.impl.GroupUserCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GroupUserCategoryLocalService
 * @generated
 */
public class GroupUserCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.qa.service.service.impl.GroupUserCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group user category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategory the group user category
	 * @return the group user category that was added
	 */
	public static com.ecoit.qa.service.model.GroupUserCategory
		addGroupUserCategory(
			com.ecoit.qa.service.model.GroupUserCategory groupUserCategory) {

		return getService().addGroupUserCategory(groupUserCategory);
	}

	/**
	 * Creates a new group user category with the primary key. Does not add the group user category to the database.
	 *
	 * @param groupUserCategoryPK the primary key for the new group user category
	 * @return the new group user category
	 */
	public static com.ecoit.qa.service.model.GroupUserCategory
		createGroupUserCategory(
			com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
				groupUserCategoryPK) {

		return getService().createGroupUserCategory(groupUserCategoryPK);
	}

	public static void createGroupUserCategory(
			long groupUserId, long categoryId)
		throws Exception {

		getService().createGroupUserCategory(groupUserId, categoryId);
	}

	/**
	 * Deletes the group user category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategory the group user category
	 * @return the group user category that was removed
	 */
	public static com.ecoit.qa.service.model.GroupUserCategory
		deleteGroupUserCategory(
			com.ecoit.qa.service.model.GroupUserCategory groupUserCategory) {

		return getService().deleteGroupUserCategory(groupUserCategory);
	}

	/**
	 * Deletes the group user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category that was removed
	 * @throws PortalException if a group user category with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserCategory
			deleteGroupUserCategory(
				com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
					groupUserCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupUserCategory(groupUserCategoryPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserCategoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.qa.service.model.impl.GroupUserCategoryModelImpl</code>.
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

	public static com.ecoit.qa.service.model.GroupUserCategory
		fetchGroupUserCategory(
			com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
				groupUserCategoryPK) {

		return getService().fetchGroupUserCategory(groupUserCategoryPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	public static java.util.List<com.ecoit.qa.service.model.GroupUserCategory>
		getGroupUserCategories(int start, int end) {

		return getService().getGroupUserCategories(start, end);
	}

	/**
	 * Returns the number of group user categories.
	 *
	 * @return the number of group user categories
	 */
	public static int getGroupUserCategoriesCount() {
		return getService().getGroupUserCategoriesCount();
	}

	/**
	 * Returns the group user category with the primary key.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category
	 * @throws PortalException if a group user category with the primary key could not be found
	 */
	public static com.ecoit.qa.service.model.GroupUserCategory
			getGroupUserCategory(
				com.ecoit.qa.service.service.persistence.GroupUserCategoryPK
					groupUserCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupUserCategory(groupUserCategoryPK);
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

	public static boolean hasCategory(long groupUserId, long categoryId) {
		return getService().hasCategory(groupUserId, categoryId);
	}

	public static void removeByCategoryId(long categoryId) {
		getService().removeByCategoryId(categoryId);
	}

	public static void removeByGroupUserId(long groupUserId) {
		getService().removeByGroupUserId(groupUserId);
	}

	/**
	 * Updates the group user category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategory the group user category
	 * @return the group user category that was updated
	 */
	public static com.ecoit.qa.service.model.GroupUserCategory
		updateGroupUserCategory(
			com.ecoit.qa.service.model.GroupUserCategory groupUserCategory) {

		return getService().updateGroupUserCategory(groupUserCategory);
	}

	public static GroupUserCategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupUserCategoryLocalService, GroupUserCategoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GroupUserCategoryLocalService.class);

		ServiceTracker
			<GroupUserCategoryLocalService, GroupUserCategoryLocalService>
				serviceTracker =
					new ServiceTracker
						<GroupUserCategoryLocalService,
						 GroupUserCategoryLocalService>(
							 bundle.getBundleContext(),
							 GroupUserCategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}