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
 * Provides a wrapper for {@link CategoryArticleLocalService}.
 *
 * @author DungNV
 * @see CategoryArticleLocalService
 * @generated
 */
public class CategoryArticleLocalServiceWrapper
	implements CategoryArticleLocalService,
			   ServiceWrapper<CategoryArticleLocalService> {

	public CategoryArticleLocalServiceWrapper(
		CategoryArticleLocalService categoryArticleLocalService) {

		_categoryArticleLocalService = categoryArticleLocalService;
	}

	/**
	 * Adds the category article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was added
	 */
	@Override
	public com.software.cms.model.CategoryArticle addCategoryArticle(
		com.software.cms.model.CategoryArticle categoryArticle) {

		return _categoryArticleLocalService.addCategoryArticle(categoryArticle);
	}

	@Override
	public void addCategoryArticle(
		long articleId, long categoryId, long groupId) {

		_categoryArticleLocalService.addCategoryArticle(
			articleId, categoryId, groupId);
	}

	@Override
	public com.software.cms.model.CategoryArticle create() {
		return _categoryArticleLocalService.create();
	}

	/**
	 * Creates a new category article with the primary key. Does not add the category article to the database.
	 *
	 * @param categoryArticlePK the primary key for the new category article
	 * @return the new category article
	 */
	@Override
	public com.software.cms.model.CategoryArticle createCategoryArticle(
		com.software.cms.service.persistence.CategoryArticlePK
			categoryArticlePK) {

		return _categoryArticleLocalService.createCategoryArticle(
			categoryArticlePK);
	}

	/**
	 * Deletes the category article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was removed
	 */
	@Override
	public com.software.cms.model.CategoryArticle deleteCategoryArticle(
		com.software.cms.model.CategoryArticle categoryArticle) {

		return _categoryArticleLocalService.deleteCategoryArticle(
			categoryArticle);
	}

	/**
	 * Deletes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article that was removed
	 * @throws PortalException if a category article with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.CategoryArticle deleteCategoryArticle(
			com.software.cms.service.persistence.CategoryArticlePK
				categoryArticlePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryArticleLocalService.deleteCategoryArticle(
			categoryArticlePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryArticleLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryArticleLocalService.dynamicQuery();
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

		return _categoryArticleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
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

		return _categoryArticleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
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

		return _categoryArticleLocalService.dynamicQuery(
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

		return _categoryArticleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _categoryArticleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.CategoryArticle fetchCategoryArticle(
		com.software.cms.service.persistence.CategoryArticlePK
			categoryArticlePK) {

		return _categoryArticleLocalService.fetchCategoryArticle(
			categoryArticlePK);
	}

	@Override
	public java.util.List<com.software.cms.model.CategoryArticle>
		findByCategory(long categoryId) {

		return _categoryArticleLocalService.findByCategory(categoryId);
	}

	@Override
	public java.util.List<com.software.cms.model.CategoryArticle> findByCatId(
		long catId) {

		return _categoryArticleLocalService.findByCatId(catId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _categoryArticleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the category article with the primary key.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article
	 * @throws PortalException if a category article with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.CategoryArticle getCategoryArticle(
			com.software.cms.service.persistence.CategoryArticlePK
				categoryArticlePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryArticleLocalService.getCategoryArticle(
			categoryArticlePK);
	}

	/**
	 * Returns a range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of category articles
	 */
	@Override
	public java.util.List<com.software.cms.model.CategoryArticle>
		getCategoryArticles(int start, int end) {

		return _categoryArticleLocalService.getCategoryArticles(start, end);
	}

	/**
	 * Returns the number of category articles.
	 *
	 * @return the number of category articles
	 */
	@Override
	public int getCategoryArticlesCount() {
		return _categoryArticleLocalService.getCategoryArticlesCount();
	}

	@Override
	public java.util.List<com.software.cms.model.CategoryArticle>
		getCategoryOfArticle(long idArticle) {

		return _categoryArticleLocalService.getCategoryOfArticle(idArticle);
	}

	@Override
	public java.util.List<Long> getCategoryOfArticleWithId(long id_article) {
		return _categoryArticleLocalService.getCategoryOfArticleWithId(
			id_article);
	}

	@Override
	public int getCountById(long catId) throws Exception {
		return _categoryArticleLocalService.getCountById(catId);
	}

	@Override
	public java.util.List<Object> getDuLieuTheoSql(String sqlQuery) {
		return _categoryArticleLocalService.getDuLieuTheoSql(sqlQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _categoryArticleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoryArticleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _categoryArticleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeByArticle(long article) {
		_categoryArticleLocalService.removeByArticle(article);
	}

	@Override
	public void removeByCategory(long categoryId) {
		_categoryArticleLocalService.removeByCategory(categoryId);
	}

	/**
	 * Updates the category article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was updated
	 */
	@Override
	public com.software.cms.model.CategoryArticle updateCategoryArticle(
		com.software.cms.model.CategoryArticle categoryArticle) {

		return _categoryArticleLocalService.updateCategoryArticle(
			categoryArticle);
	}

	@Override
	public CategoryArticleLocalService getWrappedService() {
		return _categoryArticleLocalService;
	}

	@Override
	public void setWrappedService(
		CategoryArticleLocalService categoryArticleLocalService) {

		_categoryArticleLocalService = categoryArticleLocalService;
	}

	private CategoryArticleLocalService _categoryArticleLocalService;

}