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
 * Provides the local service utility for Article. This utility wraps
 * <code>com.software.cms.service.impl.ArticleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see ArticleLocalService
 * @generated
 */
public class ArticleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.ArticleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was added
	 */
	public static com.software.cms.model.Article addArticle(
		com.software.cms.model.Article article) {

		return getService().addArticle(article);
	}

	public static int countArticleNew(
			long groupId, long categoryId, String artIds)
		throws Exception {

		return getService().countArticleNew(groupId, categoryId, artIds);
	}

	public static com.software.cms.model.Article create() {
		return getService().create();
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	public static com.software.cms.model.Article createArticle(long articleId) {
		return getService().createArticle(articleId);
	}

	/**
	 * Deletes the article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was removed
	 */
	public static com.software.cms.model.Article deleteArticle(
		com.software.cms.model.Article article) {

		return getService().deleteArticle(article);
	}

	/**
	 * Deletes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws PortalException if a article with the primary key could not be found
	 */
	public static com.software.cms.model.Article deleteArticle(long articleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteArticle(articleId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.ArticleModelImpl</code>.
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

	public static com.software.cms.model.Article fetchArticle(long articleId) {
		return getService().fetchArticle(articleId);
	}

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	public static com.software.cms.model.Article fetchArticleByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchArticleByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.software.cms.model.Article> findByUserNews(
			long groupId, String language, long userId, long status,
			long categoryId, String eventName, String tagName, String keyword,
			boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, java.util.Date fromDate, java.util.Date toDate,
			boolean inAuthor, boolean userKiemDuyet, int start, int end)
		throws Exception {

		return getService().findByUserNews(
			groupId, language, userId, status, categoryId, eventName, tagName,
			keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate,
			inAuthor, userKiemDuyet, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the article with the primary key.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws PortalException if a article with the primary key could not be found
	 */
	public static com.software.cms.model.Article getArticle(long articleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getArticle(articleId);
	}

	public static java.util.List<com.software.cms.model.Article>
		getArticleByCate(long groupId, long categoryId, int limit) {

		return getService().getArticleByCate(groupId, categoryId, limit);
	}

	public static com.software.cms.model.Article getArticleByFriendlyURL(
		String friendlyUrl) {

		return getService().getArticleByFriendlyURL(friendlyUrl);
	}

	public static com.software.cms.model.Article
			getArticleByFriendlyURLAndStatus(String friendlyUrl, int status)
		throws Exception {

		return getService().getArticleByFriendlyURLAndStatus(
			friendlyUrl, status);
	}

	public static com.software.cms.model.Article getArticleByImageId(
			long articleId, long imageId)
		throws Exception {

		return getService().getArticleByImageId(articleId, imageId);
	}

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article
	 * @throws PortalException if a matching article could not be found
	 */
	public static com.software.cms.model.Article getArticleByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getArticleByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.software.cms.model.Article>
		getArticleFeaturedNew(
			int thutu, int limit, String locale, boolean ishomepage,
			boolean isnoibat, int status, String lIds, long groupId) {

		return getService().getArticleFeaturedNew(
			thutu, limit, locale, ishomepage, isnoibat, status, lIds, groupId);
	}

	public static java.util.List<com.software.cms.model.Article>
			getArticleInvolve(
				long groupId, String locale, int status, String title,
				int start, int limit, String involveId)
		throws Exception {

		return getService().getArticleInvolve(
			groupId, locale, status, title, start, limit, involveId);
	}

	public static java.util.List<com.software.cms.model.Article> getArticleNew(
			long groupId, long categoryId, int start, int limit, String artIds)
		throws Exception {

		return getService().getArticleNew(
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
	public static java.util.List<com.software.cms.model.Article> getArticles(
		int start, int end) {

		return getService().getArticles(start, end);
	}

	public static java.util.List<com.software.cms.model.Article>
		getArticleScheduler(String date, String status) {

		return getService().getArticleScheduler(date, status);
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	public static int getArticlesCount() {
		return getService().getArticlesCount();
	}

	public static java.util.List<Object[]> getArticleSource(
			String source, int limit)
		throws Exception {

		return getService().getArticleSource(source, limit);
	}

	public static java.util.List<com.software.cms.model.Article>
		getArticleTheoSQL(long groupId, long articlemainId) {

		return getService().getArticleTheoSQL(groupId, articlemainId);
	}

	public static int getCountArticleByCaterory(
			long groupId, Long categoryId, java.util.Date publishDateFrom)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getCountArticleByCaterory(
			groupId, categoryId, publishDateFrom);
	}

	public static int getCountArticleBySQL(String sql) {
		return getService().getCountArticleBySQL(sql);
	}

	public static int getCountByUserNews(
			long groupId, String language, long userId, long status,
			long categoryId, String eventName, String tagName, String keyword,
			boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, java.util.Date fromDate, java.util.Date toDate,
			boolean inAuthor, boolean userKiemDuyet)
		throws Exception {

		return getService().getCountByUserNews(
			groupId, language, userId, status, categoryId, eventName, tagName,
			keyword, inTitle, inSummary, inContent, inDate, fromDate, toDate,
			inAuthor, userKiemDuyet);
	}

	public static java.util.List<Object> getDuLieuTheoSql(String sqlQuery) {
		return getService().getDuLieuTheoSql(sqlQuery);
	}

	public static java.util.List<Object> getDuLieuTheoSql(
		String sql, int start, int end) {

		return getService().getDuLieuTheoSql(sql, start, end);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.software.cms.model.Article>
			getListArticleByCaterory(
				long groupId, Long categoryId, java.util.Date publishDateFrom,
				Integer start, Integer end)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getListArticleByCaterory(
			groupId, categoryId, publishDateFrom, start, end);
	}

	public static java.util.List<com.software.cms.model.Article>
			getListArticleByEvent(
				long groupId, long articleId, long categoryId, String eventId,
				int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().getListArticleByEvent(
			groupId, articleId, categoryId, eventId, start, end);
	}

	public static java.util.List<com.software.cms.model.Article>
		getListArticleBySQL(String sql, int start, int end) {

		return getService().getListArticleBySQL(sql, start, end);
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

	public static java.util.List<com.software.cms.model.Article>
		searchByAuthorName(String name, long groupid, String language) {

		return getService().searchByAuthorName(name, groupid, language);
	}

	public static java.util.List<com.software.cms.model.Article>
		searchBySourceName(String name, long groupid, String language) {

		return getService().searchBySourceName(name, groupid, language);
	}

	public static java.util.List<com.software.cms.model.Article>
			searchNewArticle(
				long groupId, int status, String keyword, String dateFrom,
				String dateTo)
		throws Exception {

		return getService().searchNewArticle(
			groupId, status, keyword, dateFrom, dateTo);
	}

	/**
	 * Updates the article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was updated
	 */
	public static com.software.cms.model.Article updateArticle(
		com.software.cms.model.Article article) {

		return getService().updateArticle(article);
	}

	public static ArticleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArticleLocalService, ArticleLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArticleLocalService.class);

		ServiceTracker<ArticleLocalService, ArticleLocalService>
			serviceTracker =
				new ServiceTracker<ArticleLocalService, ArticleLocalService>(
					bundle.getBundleContext(), ArticleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}