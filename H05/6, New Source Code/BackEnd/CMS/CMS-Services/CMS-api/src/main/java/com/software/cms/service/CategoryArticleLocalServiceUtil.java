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
 * Provides the local service utility for CategoryArticle. This utility wraps
 * <code>com.software.cms.service.impl.CategoryArticleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see CategoryArticleLocalService
 * @generated
 */
public class CategoryArticleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.CategoryArticleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the category article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was added
	 */
	public static com.software.cms.model.CategoryArticle addCategoryArticle(
		com.software.cms.model.CategoryArticle categoryArticle) {

		return getService().addCategoryArticle(categoryArticle);
	}

	public static void addCategoryArticle(
		long articleId, long categoryId, long groupId) {

		getService().addCategoryArticle(articleId, categoryId, groupId);
	}

	public static com.software.cms.model.CategoryArticle create() {
		return getService().create();
	}

	/**
	 * Creates a new category article with the primary key. Does not add the category article to the database.
	 *
	 * @param categoryArticlePK the primary key for the new category article
	 * @return the new category article
	 */
	public static com.software.cms.model.CategoryArticle createCategoryArticle(
		com.software.cms.service.persistence.CategoryArticlePK
			categoryArticlePK) {

		return getService().createCategoryArticle(categoryArticlePK);
	}

	/**
	 * Deletes the category article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was removed
	 */
	public static com.software.cms.model.CategoryArticle deleteCategoryArticle(
		com.software.cms.model.CategoryArticle categoryArticle) {

		return getService().deleteCategoryArticle(categoryArticle);
	}

	/**
	 * Deletes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article that was removed
	 * @throws PortalException if a category article with the primary key could not be found
	 */
	public static com.software.cms.model.CategoryArticle deleteCategoryArticle(
			com.software.cms.service.persistence.CategoryArticlePK
				categoryArticlePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCategoryArticle(categoryArticlePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
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

	public static com.software.cms.model.CategoryArticle fetchCategoryArticle(
		com.software.cms.service.persistence.CategoryArticlePK
			categoryArticlePK) {

		return getService().fetchCategoryArticle(categoryArticlePK);
	}

	public static java.util.List<com.software.cms.model.CategoryArticle>
		findByCategory(long categoryId) {

		return getService().findByCategory(categoryId);
	}

	public static java.util.List<com.software.cms.model.CategoryArticle>
		findByCatId(long catId) {

		return getService().findByCatId(catId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the category article with the primary key.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article
	 * @throws PortalException if a category article with the primary key could not be found
	 */
	public static com.software.cms.model.CategoryArticle getCategoryArticle(
			com.software.cms.service.persistence.CategoryArticlePK
				categoryArticlePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCategoryArticle(categoryArticlePK);
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
	public static java.util.List<com.software.cms.model.CategoryArticle>
		getCategoryArticles(int start, int end) {

		return getService().getCategoryArticles(start, end);
	}

	/**
	 * Returns the number of category articles.
	 *
	 * @return the number of category articles
	 */
	public static int getCategoryArticlesCount() {
		return getService().getCategoryArticlesCount();
	}

	public static java.util.List<com.software.cms.model.CategoryArticle>
		getCategoryOfArticle(long idArticle) {

		return getService().getCategoryOfArticle(idArticle);
	}

	public static java.util.List<Long> getCategoryOfArticleWithId(
		long id_article) {

		return getService().getCategoryOfArticleWithId(id_article);
	}

	public static int getCountById(long catId) throws Exception {
		return getService().getCountById(catId);
	}

	public static java.util.List<Object> getDuLieuTheoSql(String sqlQuery) {
		return getService().getDuLieuTheoSql(sqlQuery);
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

	public static void removeByArticle(long article) {
		getService().removeByArticle(article);
	}

	public static void removeByCategory(long categoryId) {
		getService().removeByCategory(categoryId);
	}

	/**
	 * Updates the category article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was updated
	 */
	public static com.software.cms.model.CategoryArticle updateCategoryArticle(
		com.software.cms.model.CategoryArticle categoryArticle) {

		return getService().updateCategoryArticle(categoryArticle);
	}

	public static CategoryArticleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CategoryArticleLocalService, CategoryArticleLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CategoryArticleLocalService.class);

		ServiceTracker<CategoryArticleLocalService, CategoryArticleLocalService>
			serviceTracker =
				new ServiceTracker
					<CategoryArticleLocalService, CategoryArticleLocalService>(
						bundle.getBundleContext(),
						CategoryArticleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}