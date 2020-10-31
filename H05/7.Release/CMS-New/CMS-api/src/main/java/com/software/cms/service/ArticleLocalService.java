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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.software.cms.model.Article;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Article. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author DungNV
 * @see ArticleLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ArticleLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleLocalServiceUtil} to access the article local service. Add custom service methods to <code>com.software.cms.service.impl.ArticleLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Article addArticle(Article article);

	public Article create();

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Transactional(enabled = false)
	public Article createArticle(long articleId);

	/**
	 * Deletes the article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Article deleteArticle(Article article);

	/**
	 * Deletes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws PortalException if a article with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Article deleteArticle(long articleId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Article fetchArticle(long articleId);

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Article fetchArticleByUuidAndGroupId(String uuid, long groupId);

	public List<Article> findByUserNews(
			long groupId, String language, long userId, long status,
			long categoryId, String eventName, String tagName, String keyword,
			boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, Date fromDate, Date toDate, boolean inAuthor,
			boolean userKiemDuyet, int start, int end)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the article with the primary key.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws PortalException if a article with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Article getArticle(long articleId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Article getArticleByFriendlyURL(String friendlyUrl);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Article getArticleByFriendlyURLAndStatus(
		String friendlyUrl, int status);

	/**
	 * Returns the article matching the UUID and group.
	 *
	 * @param uuid the article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching article
	 * @throws PortalException if a matching article could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Article getArticleByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> getArticles(int start, int end);

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getArticlesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> getArticleTheoSQL(String sqlQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountArticleByCaterory(
			long groupId, Long categoryId, Date publishDateFrom)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountArticleBySQL(String sql);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountByUserNews(
			long groupId, String language, long userId, long status,
			long categoryId, String eventName, String tagName, String keyword,
			boolean inTitle, boolean inSummary, boolean inContent,
			boolean inDate, Date fromDate, Date toDate, boolean inAuthor,
			boolean userKiemDuyet)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object> getDuLieuTheoSql(String sqlQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object> getDuLieuTheoSql(String sql, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> getListArticleByCaterory(
			long groupId, Long categoryId, Date publishDateFrom, Integer start,
			Integer end)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> getListArticleByEvent(
			long groupId, long articleId, long categoryId, String eventId,
			int start, int end)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> getListArticleBySQL(String sql, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMaxId(String sql);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> searchByAuthorName(
		String name, long groupid, String language);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Article> searchBySourceName(
		String name, long groupid, String language);

	/**
	 * Updates the article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param article the article
	 * @return the article that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Article updateArticle(Article article);

}