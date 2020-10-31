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
 * Provides a wrapper for {@link ArticleConfigLocalService}.
 *
 * @author DungNV
 * @see ArticleConfigLocalService
 * @generated
 */
public class ArticleConfigLocalServiceWrapper
	implements ArticleConfigLocalService,
			   ServiceWrapper<ArticleConfigLocalService> {

	public ArticleConfigLocalServiceWrapper(
		ArticleConfigLocalService articleConfigLocalService) {

		_articleConfigLocalService = articleConfigLocalService;
	}

	/**
	 * Adds the article config to the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleConfig the article config
	 * @return the article config that was added
	 */
	@Override
	public com.software.cms.model.ArticleConfig addArticleConfig(
		com.software.cms.model.ArticleConfig articleConfig) {

		return _articleConfigLocalService.addArticleConfig(articleConfig);
	}

	/**
	 * Creates a new article config with the primary key. Does not add the article config to the database.
	 *
	 * @param articleConfigId the primary key for the new article config
	 * @return the new article config
	 */
	@Override
	public com.software.cms.model.ArticleConfig createArticleConfig(
		long articleConfigId) {

		return _articleConfigLocalService.createArticleConfig(articleConfigId);
	}

	/**
	 * Deletes the article config from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleConfig the article config
	 * @return the article config that was removed
	 */
	@Override
	public com.software.cms.model.ArticleConfig deleteArticleConfig(
		com.software.cms.model.ArticleConfig articleConfig) {

		return _articleConfigLocalService.deleteArticleConfig(articleConfig);
	}

	/**
	 * Deletes the article config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleConfigId the primary key of the article config
	 * @return the article config that was removed
	 * @throws PortalException if a article config with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleConfig deleteArticleConfig(
			long articleConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleConfigLocalService.deleteArticleConfig(articleConfigId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleConfigLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articleConfigLocalService.dynamicQuery();
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

		return _articleConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleConfigModelImpl</code>.
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

		return _articleConfigLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleConfigModelImpl</code>.
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

		return _articleConfigLocalService.dynamicQuery(
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

		return _articleConfigLocalService.dynamicQueryCount(dynamicQuery);
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

		return _articleConfigLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.ArticleConfig fetchArticleConfig(
		long articleConfigId) {

		return _articleConfigLocalService.fetchArticleConfig(articleConfigId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _articleConfigLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the article config with the primary key.
	 *
	 * @param articleConfigId the primary key of the article config
	 * @return the article config
	 * @throws PortalException if a article config with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.ArticleConfig getArticleConfig(
			long articleConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleConfigLocalService.getArticleConfig(articleConfigId);
	}

	/**
	 * Returns a range of all the article configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article configs
	 * @param end the upper bound of the range of article configs (not inclusive)
	 * @return the range of article configs
	 */
	@Override
	public java.util.List<com.software.cms.model.ArticleConfig>
		getArticleConfigs(int start, int end) {

		return _articleConfigLocalService.getArticleConfigs(start, end);
	}

	/**
	 * Returns the number of article configs.
	 *
	 * @return the number of article configs
	 */
	@Override
	public int getArticleConfigsCount() {
		return _articleConfigLocalService.getArticleConfigsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _articleConfigLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleConfigLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the article config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param articleConfig the article config
	 * @return the article config that was updated
	 */
	@Override
	public com.software.cms.model.ArticleConfig updateArticleConfig(
		com.software.cms.model.ArticleConfig articleConfig) {

		return _articleConfigLocalService.updateArticleConfig(articleConfig);
	}

	@Override
	public ArticleConfigLocalService getWrappedService() {
		return _articleConfigLocalService;
	}

	@Override
	public void setWrappedService(
		ArticleConfigLocalService articleConfigLocalService) {

		_articleConfigLocalService = articleConfigLocalService;
	}

	private ArticleConfigLocalService _articleConfigLocalService;

}