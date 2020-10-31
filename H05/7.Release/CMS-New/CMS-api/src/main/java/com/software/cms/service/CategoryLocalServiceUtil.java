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
 * Provides the local service utility for Category. This utility wraps
 * <code>com.software.cms.service.impl.CategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see CategoryLocalService
 * @generated
 */
public class CategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.CategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param category the category
	 * @return the category that was added
	 */
	public static com.software.cms.model.Category addCategory(
		com.software.cms.model.Category category) {

		return getService().addCategory(category);
	}

	public static com.software.cms.model.Category ceate() {
		return getService().ceate();
	}

	public static com.software.cms.model.Category create() {
		return getService().create();
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	public static com.software.cms.model.Category createCategory(
		long categoryId) {

		return getService().createCategory(categoryId);
	}

	/**
	 * Deletes the category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param category the category
	 * @return the category that was removed
	 */
	public static com.software.cms.model.Category deleteCategory(
		com.software.cms.model.Category category) {

		return getService().deleteCategory(category);
	}

	/**
	 * Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws PortalException if a category with the primary key could not be found
	 */
	public static com.software.cms.model.Category deleteCategory(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCategory(categoryId);
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

	public static void doDeleteCategory(
			com.software.cms.model.Category category)
		throws com.liferay.portal.kernel.exception.SystemException {

		getService().doDeleteCategory(category);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryModelImpl</code>.
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

	public static com.software.cms.model.Category fetchCategory(
		long categoryId) {

		return getService().fetchCategory(categoryId);
	}

	/**
	 * Returns the category matching the UUID and group.
	 *
	 * @param uuid the category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	public static com.software.cms.model.Category fetchCategoryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCategoryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<Long> getAllChild(long parentid)
		throws Exception {

		return getService().getAllChild(parentid);
	}

	public static java.util.List<Long> getAllChild(
			long parentId, long groupId, String language)
		throws Exception {

		return getService().getAllChild(parentId, groupId, language);
	}

	public static java.util.List<Long> getAllChildNew(
			long parentId, long groupId, String language)
		throws Exception {

		return getService().getAllChildNew(parentId, groupId, language);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	public static java.util.List<com.software.cms.model.Category> getCategories(
		int start, int end) {

		return getService().getCategories(start, end);
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	public static int getCategoriesCount() {
		return getService().getCategoriesCount();
	}

	/**
	 * Returns the category with the primary key.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws PortalException if a category with the primary key could not be found
	 */
	public static com.software.cms.model.Category getCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCategory(categoryId);
	}

	/**
	 * Returns the category matching the UUID and group.
	 *
	 * @param uuid the category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category
	 * @throws PortalException if a matching category could not be found
	 */
	public static com.software.cms.model.Category getCategoryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCategoryByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.software.cms.model.Category>
			getCategoryHaveParentId(
				long groupid, String language, long parentid)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getCategoryHaveParentId(
			groupid, language, parentid);
	}

	public static java.util.List<com.software.cms.model.Category>
		getCateTheoSQL(String sqlQuery) {

		return getService().getCateTheoSQL(sqlQuery);
	}

	public static int getCountByLanguage(long groupId, String language) {
		return getService().getCountByLanguage(groupId, language);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static int getMaxId() {
		return getService().getMaxId();
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

	public static com.software.cms.model.Category prepCategory(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
			String action, int parentId, long id, String title,
			String description, int thuTu, String duongDan)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().prepCategory(
			themeDisplay, action, parentId, id, title, description, thuTu,
			duongDan);
	}

	public static java.util.List<com.software.cms.model.Category>
		searchByArticle(long articleId) {

		return getService().searchByArticle(articleId);
	}

	public static java.util.List<com.software.cms.model.Category>
		searchByCategoryName(String name, long groupid, String language) {

		return getService().searchByCategoryName(name, groupid, language);
	}

	public static java.util.List<com.software.cms.model.Category>
		searchCategory(String key) {

		return getService().searchCategory(key);
	}

	public static java.util.List<com.software.cms.model.Category>
		searchCategoryHaveGroupLanguge(
			long groupId, String language, String key) {

		return getService().searchCategoryHaveGroupLanguge(
			groupId, language, key);
	}

	/**
	 * Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param category the category
	 * @return the category that was updated
	 */
	public static com.software.cms.model.Category updateCategory(
		com.software.cms.model.Category category) {

		return getService().updateCategory(category);
	}

	public static CategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CategoryLocalService, CategoryLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CategoryLocalService.class);

		ServiceTracker<CategoryLocalService, CategoryLocalService>
			serviceTracker =
				new ServiceTracker<CategoryLocalService, CategoryLocalService>(
					bundle.getBundleContext(), CategoryLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}