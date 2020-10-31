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
 * Provides a wrapper for {@link ArticleHistoryLocalService}.
 *
 * @author DungNV
 * @see ArticleHistoryLocalService
 * @generated
 */
public class ArticleHistoryLocalServiceWrapper
	implements ArticleHistoryLocalService,
			   ServiceWrapper<ArticleHistoryLocalService> {

	public ArticleHistoryLocalServiceWrapper(
		ArticleHistoryLocalService articleHistoryLocalService) {

		_articleHistoryLocalService = articleHistoryLocalService;
	}

	/**
	 * Adds the article history to the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistory the article history
	 * @return the article history that was added
	 */
	@Override
	public com.software.cms.model.ArticleHistory addArticleHistory(
		com.software.cms.model.ArticleHistory articleHistory) {

		return _articleHistoryLocalService.addArticleHistory(articleHistory);
	}

	@Override
	public int countByArticle(long articleId) throws Exception {
		return _articleHistoryLocalService.countByArticle(articleId);
	}

	@Override
	public com.software.cms.model.ArticleHistory create() {
		return _articleHistoryLocalService.create();
	}

	/**
	 * Creates a new article history with the primary key. Does not add the article history to the database.
	 *
	 * @param articleHistoryId the primary key for the new article history
	 * @return the new article history
	 */
	@Override
	public com.software.cms.model.ArticleHistory createArticleHistory(
		long articleHistoryId) {

		return _articleHistoryLocalService.createArticleHistory(
			articleHistoryId);
	}

	/**
	 * Deletes the article history from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistory the article history
	 * @return the article history that was removed
	 */
	@Override
	public com.software.cms.model.ArticleHistory deleteArticleHistory(
		com.software.cms.model.ArticleHistory articleHistory) {

		return _articleHistoryLocalService.deleteArticleHistory(articleHistory);
	}

	/**
	 * Deletes the article history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history that was removed
	 * @throws PortalException if a article history with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleHistory deleteArticleHistory(
			long articleHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleHistoryLocalService.deleteArticleHistory(
			articleHistoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleHistoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articleHistoryLocalService.dynamicQuery();
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

		return _articleHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleHistoryModelImpl</code>.
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

		return _articleHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleHistoryModelImpl</code>.
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

		return _articleHistoryLocalService.dynamicQuery(
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

		return _articleHistoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _articleHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.ArticleHistory fetchArticleHistory(
		long articleHistoryId) {

		return _articleHistoryLocalService.fetchArticleHistory(
			articleHistoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _articleHistoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of article histories
	 */
	@Override
	public java.util.List<com.software.cms.model.ArticleHistory>
		getArticleHistories(int start, int end) {

		return _articleHistoryLocalService.getArticleHistories(start, end);
	}

	/**
	 * Returns the number of article histories.
	 *
	 * @return the number of article histories
	 */
	@Override
	public int getArticleHistoriesCount() {
		return _articleHistoryLocalService.getArticleHistoriesCount();
	}

	/**
	 * Returns the article history with the primary key.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history
	 * @throws PortalException if a article history with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleHistory getArticleHistory(
			long articleHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleHistoryLocalService.getArticleHistory(articleHistoryId);
	}

	@Override
	public java.util.List<com.software.cms.model.ArticleHistory>
			getHistoryFromArticle(long articleId, int start, int end)
		throws Exception {

		return _articleHistoryLocalService.getHistoryFromArticle(
			articleId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _articleHistoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleHistoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the article history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistory the article history
	 * @return the article history that was updated
	 */
	@Override
	public com.software.cms.model.ArticleHistory updateArticleHistory(
		com.software.cms.model.ArticleHistory articleHistory) {

		return _articleHistoryLocalService.updateArticleHistory(articleHistory);
	}

	@Override
	public ArticleHistoryLocalService getWrappedService() {
		return _articleHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		ArticleHistoryLocalService articleHistoryLocalService) {

		_articleHistoryLocalService = articleHistoryLocalService;
	}

	private ArticleHistoryLocalService _articleHistoryLocalService;

}