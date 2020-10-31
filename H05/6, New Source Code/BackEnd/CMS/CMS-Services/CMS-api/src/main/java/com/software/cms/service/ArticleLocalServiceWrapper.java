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
 * Provides a wrapper for {@link ArticleLocalService}.
 *
 * @author DungNV
 * @see ArticleLocalService
 * @generated
 */
public class ArticleLocalServiceWrapper
	implements ArticleLocalService, ServiceWrapper<ArticleLocalService> {

	public ArticleLocalServiceWrapper(ArticleLocalService articleLocalService) {
		_articleLocalService = articleLocalService;
	}

	/**
	 * Adds the article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was added
	 */
	@Override
	public com.software.cms.model.Article addArticle(
		com.software.cms.model.Article article) {

		return _articleLocalService.addArticle(article);
	}

	@Override
	public int countArticleNew(long groupId, long categoryId, String artIds)
		throws Exception {

		return _articleLocalService.countArticleNew(
			groupId, categoryId, artIds);
	}

	@Override
	public com.software.cms.model.Article create() {
		return _articleLocalService.create();
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Override
	public com.software.cms.model.Article createArticle(long articleId) {
		return _articleLocalService.createArticle(articleId);
	}

	/**
	 * Deletes the article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was removed
	 */
	@Override
	public com.software.cms.model.Article deleteArticle(
		com.software.cms.model.Article article) {

		return _articleLocalService.deleteArticle(article);
	}

	/**
	 * Deletes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws PortalException if a article with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Article deleteArticle(long articleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleLocalService.deleteArticle(articleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articleLocalService.dynamicQuery();
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

		return _articleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleModelImpl</code>.
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

		return _articleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleModelImpl</code>.
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

		return _articleLocalService.dynamicQuery(
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

		return _articleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _articleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.Article fetchArticle(long articleId) {
		return _articleLocalService.fetchArticle(articleId);
	}

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public com.software.cms.model.Article fetchArticleByUuidAndGroupId(
		String uuid, long groupId) {

		return _articleLocalService.fetchArticleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> findByUserNews(
			long groupId, String language, long userId, long status,
			long categoryId, String eventName, String tagName, String keyword,
			boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, java.util.Date fromDate, java.util.Date toDate,
			boolean inAuthor, boolean userKiemDuyet, int start, int end)
		throws Exception {

		return _articleLocalService.findByUserNews(
			groupId, language, userId, status, categoryId, eventName, tagName,
			keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate,
			inAuthor, userKiemDuyet, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _articleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the article with the primary key.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws PortalException if a article with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.Article getArticle(long articleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleLocalService.getArticle(articleId);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getArticleByCate(
		long groupId, long categoryId, int limit) {

		return _articleLocalService.getArticleByCate(
			groupId, categoryId, limit);
	}

	@Override
	public com.software.cms.model.Article getArticleByFriendlyURL(
		String friendlyUrl) {

		return _articleLocalService.getArticleByFriendlyURL(friendlyUrl);
	}

	@Override
	public com.software.cms.model.Article getArticleByFriendlyURLAndStatus(
			String friendlyUrl, int status)
		throws Exception {

		return _articleLocalService.getArticleByFriendlyURLAndStatus(
			friendlyUrl, status);
	}

	@Override
	public com.software.cms.model.Article getArticleByImageId(
			long articleId, long imageId)
		throws Exception {

		return _articleLocalService.getArticleByImageId(articleId, imageId);
	}

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article
	 * @throws PortalException if a matching article could not be found
	 */
	@Override
	public com.software.cms.model.Article getArticleByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleLocalService.getArticleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getArticleFeaturedNew(
		int thutu, int limit, String locale, boolean ishomepage,
		boolean isnoibat, int status, String lIds, long groupId) {

		return _articleLocalService.getArticleFeaturedNew(
			thutu, limit, locale, ishomepage, isnoibat, status, lIds, groupId);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getArticleInvolve(
			long groupId, String locale, int status, String title, int start,
			int limit, String involveId)
		throws Exception {

		return _articleLocalService.getArticleInvolve(
			groupId, locale, status, title, start, limit, involveId);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getArticleNew(
			long groupId, long categoryId, int start, int limit, String artIds)
		throws Exception {

		return _articleLocalService.getArticleNew(
			groupId, categoryId, start, limit, artIds);
	}

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 */
	@Override
	public java.util.List<com.software.cms.model.Article> getArticles(
		int start, int end) {

		return _articleLocalService.getArticles(start, end);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getArticleScheduler(
		String date, String status) {

		return _articleLocalService.getArticleScheduler(date, status);
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	@Override
	public int getArticlesCount() {
		return _articleLocalService.getArticlesCount();
	}

	@Override
	public java.util.List<Object[]> getArticleSource(String source, int limit)
		throws Exception {

		return _articleLocalService.getArticleSource(source, limit);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getArticleTheoSQL(
		long groupId, long articlemainId) {

		return _articleLocalService.getArticleTheoSQL(groupId, articlemainId);
	}

	@Override
	public int getCountArticleByCaterory(
			long groupId, Long categoryId, java.util.Date publishDateFrom)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _articleLocalService.getCountArticleByCaterory(
			groupId, categoryId, publishDateFrom);
	}

	@Override
	public int getCountArticleBySQL(String sql) {
		return _articleLocalService.getCountArticleBySQL(sql);
	}

	@Override
	public int getCountByUserNews(
			long groupId, String language, long userId, long status,
			long categoryId, String eventName, String tagName, String keyword,
			boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, java.util.Date fromDate, java.util.Date toDate,
			boolean inAuthor, boolean userKiemDuyet)
		throws Exception {

		return _articleLocalService.getCountByUserNews(
			groupId, language, userId, status, categoryId, eventName, tagName,
			keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate,
			inAuthor, userKiemDuyet);
	}

	@Override
	public java.util.List<Object> getDuLieuTheoSql(String sqlQuery) {
		return _articleLocalService.getDuLieuTheoSql(sqlQuery);
	}

	@Override
	public java.util.List<Object> getDuLieuTheoSql(
		String sql, int start, int end) {

		return _articleLocalService.getDuLieuTheoSql(sql, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _articleLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.software.cms.model.Article>
			getListArticleByCaterory(
				long groupId, Long categoryId, java.util.Date publishDateFrom,
				Integer start, Integer end)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _articleLocalService.getListArticleByCaterory(
			groupId, categoryId, publishDateFrom, start, end);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getListArticleByEvent(
			long groupId, long articleId, long categoryId, String eventId,
			int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _articleLocalService.getListArticleByEvent(
			groupId, articleId, categoryId, eventId, start, end);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> getListArticleBySQL(
		String sql, int start, int end) {

		return _articleLocalService.getListArticleBySQL(sql, start, end);
	}

	@Override
	public int getMaxId() {
		return _articleLocalService.getMaxId();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> searchByAuthorName(
		String name, long groupid, String language) {

		return _articleLocalService.searchByAuthorName(name, groupid, language);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> searchBySourceName(
		String name, long groupid, String language) {

		return _articleLocalService.searchBySourceName(name, groupid, language);
	}

	@Override
	public java.util.List<com.software.cms.model.Article> searchNewArticle(
			long groupId, int status, String keyword, String dateFrom,
			String dateTo)
		throws Exception {

		return _articleLocalService.searchNewArticle(
			groupId, status, keyword, dateFrom, dateTo);
	}

	/**
	 * Updates the article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was updated
	 */
	@Override
	public com.software.cms.model.Article updateArticle(
		com.software.cms.model.Article article) {

		return _articleLocalService.updateArticle(article);
	}

	@Override
	public ArticleLocalService getWrappedService() {
		return _articleLocalService;
	}

	@Override
	public void setWrappedService(ArticleLocalService articleLocalService) {
		_articleLocalService = articleLocalService;
	}

	private ArticleLocalService _articleLocalService;

}