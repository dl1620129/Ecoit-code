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
 * Provides a wrapper for {@link CategoryLocalService}.
 *
 * @author DungNV
 * @see CategoryLocalService
 * @generated
 */
public class CategoryLocalServiceWrapper
	implements CategoryLocalService, ServiceWrapper<CategoryLocalService> {

	public CategoryLocalServiceWrapper(
		CategoryLocalService categoryLocalService) {

		_categoryLocalService = categoryLocalService;
	}

	/**
	 * Adds the category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param category the category
	 * @return the category that was added
	 */
	@Override
	public com.software.cms.model.Category addCategory(
		com.software.cms.model.Category category) {

		return _categoryLocalService.addCategory(category);
	}

	@Override
	public com.software.cms.model.Category ceate() {
		return _categoryLocalService.ceate();
	}

	@Override
	public com.software.cms.model.Category create() {
		return _categoryLocalService.create();
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public com.software.cms.model.Category createCategory(long categoryId) {
		return _categoryLocalService.createCategory(categoryId);
	}

	@Override
	public com.software.cms.model.Category createCategory(
			long userId, String lang, long groupId, String title, long parentId,
			String description, int thuTu, String duongDan, String cateChild)
		throws Exception {

		return _categoryLocalService.createCategory(
			userId, lang, groupId, title, parentId, description, thuTu,
			duongDan, cateChild);
	}

	/**
	 * Deletes the category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param category the category
	 * @return the category that was removed
	 */
	@Override
	public com.software.cms.model.Category deleteCategory(
		com.software.cms.model.Category category) {

		return _categoryLocalService.deleteCategory(category);
	}

	/**
	 * Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws PortalException if a category with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Category deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.deleteCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void doDeleteCategory(com.software.cms.model.Category category)
		throws com.liferay.portal.kernel.exception.SystemException {

		_categoryLocalService.doDeleteCategory(category);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryLocalService.dynamicQuery();
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

		return _categoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _categoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _categoryLocalService.dynamicQuery(
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

		return _categoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _categoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.Category fetchCategory(long categoryId) {
		return _categoryLocalService.fetchCategory(categoryId);
	}

	/**
	 * Returns the category matching the UUID and group.
	 *
	 * @param uuid the category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public com.software.cms.model.Category fetchCategoryByUuidAndGroupId(
		String uuid, long groupId) {

		return _categoryLocalService.fetchCategoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _categoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<Long> getAllChild(long parentid) throws Exception {
		return _categoryLocalService.getAllChild(parentid);
	}

	@Override
	public java.util.List<Long> getAllChild(
			long parentId, long groupId, String language)
		throws Exception {

		return _categoryLocalService.getAllChild(parentId, groupId, language);
	}

	@Override
	public java.util.List<Long> getAllChildNew(
			long parentId, long groupId, String language)
		throws Exception {

		return _categoryLocalService.getAllChildNew(
			parentId, groupId, language);
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
	@Override
	public java.util.List<com.software.cms.model.Category> getCategories(
		int start, int end) {

		return _categoryLocalService.getCategories(start, end);
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	@Override
	public int getCategoriesCount() {
		return _categoryLocalService.getCategoriesCount();
	}

	/**
	 * Returns the category with the primary key.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws PortalException if a category with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Category getCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.getCategory(categoryId);
	}

	/**
	 * Returns the category matching the UUID and group.
	 *
	 * @param uuid the category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching category
	 * @throws PortalException if a matching category could not be found
	 */
	@Override
	public com.software.cms.model.Category getCategoryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.getCategoryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.software.cms.model.Category>
			getCategoryHaveParentId(
				long groupid, String language, long parentid)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _categoryLocalService.getCategoryHaveParentId(
			groupid, language, parentid);
	}

	@Override
	public java.util.List<com.software.cms.model.Category> getCateTheoSQL(
		String sqlQuery) {

		return _categoryLocalService.getCateTheoSQL(sqlQuery);
	}

	@Override
	public int getCountByLanguage(long groupId, String language) {
		return _categoryLocalService.getCountByLanguage(groupId, language);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _categoryLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public int getMax(long userId, String lang, long groupId, long parentId) {
		return _categoryLocalService.getMax(userId, lang, groupId, parentId);
	}

	@Override
	public int getMaxId() {
		return _categoryLocalService.getMaxId();
	}

	@Override
	public java.util.List<com.software.cms.model.Category> getNode(
			long parentId, long groupId, String language, String title,
			int start, int limit)
		throws Exception {

		return _categoryLocalService.getNode(
			parentId, groupId, language, title, start, limit);
	}

	@Override
	public int getNodeCount(
			long parentId, long groupId, String language, String title)
		throws Exception {

		return _categoryLocalService.getNodeCount(
			parentId, groupId, language, title);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.software.cms.model.Category> searchByArticle(
		long articleId) {

		return _categoryLocalService.searchByArticle(articleId);
	}

	@Override
	public java.util.List<com.software.cms.model.Category> searchByCategoryName(
		String name, long groupid, String language) {

		return _categoryLocalService.searchByCategoryName(
			name, groupid, language);
	}

	@Override
	public java.util.List<com.software.cms.model.Category>
		searchCategoryHaveGroupLanguge(
			long groupId, String language, String key) {

		return _categoryLocalService.searchCategoryHaveGroupLanguge(
			groupId, language, key);
	}

	/**
	 * Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param category the category
	 * @return the category that was updated
	 */
	@Override
	public com.software.cms.model.Category updateCategory(
		com.software.cms.model.Category category) {

		return _categoryLocalService.updateCategory(category);
	}

	@Override
	public com.software.cms.model.Category updateCategory(
			long userId, String lang, long groupId, long parentId, long cateId,
			String title, String description, int thuTu, String duongDan,
			String cateChild)
		throws Exception {

		return _categoryLocalService.updateCategory(
			userId, lang, groupId, parentId, cateId, title, description, thuTu,
			duongDan, cateChild);
	}

	@Override
	public CategoryLocalService getWrappedService() {
		return _categoryLocalService;
	}

	@Override
	public void setWrappedService(CategoryLocalService categoryLocalService) {
		_categoryLocalService = categoryLocalService;
	}

	private CategoryLocalService _categoryLocalService;

}