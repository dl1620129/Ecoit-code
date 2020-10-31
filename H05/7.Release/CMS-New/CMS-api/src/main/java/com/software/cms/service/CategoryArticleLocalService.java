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

import com.software.cms.model.CategoryArticle;
import com.software.cms.service.persistence.CategoryArticlePK;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CategoryArticle. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author DungNV
 * @see CategoryArticleLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CategoryArticleLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryArticleLocalServiceUtil} to access the category article local service. Add custom service methods to <code>com.software.cms.service.impl.CategoryArticleLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the category article to the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CategoryArticle addCategoryArticle(CategoryArticle categoryArticle);

	public void addCategoryArticle(long articleId, String categoryId);

	public CategoryArticle create();

	/**
	 * Creates a new category article with the primary key. Does not add the category article to the database.
	 *
	 * @param categoryArticlePK the primary key for the new category article
	 * @return the new category article
	 */
	@Transactional(enabled = false)
	public CategoryArticle createCategoryArticle(
		CategoryArticlePK categoryArticlePK);

	/**
	 * Deletes the category article from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public CategoryArticle deleteCategoryArticle(
		CategoryArticle categoryArticle);

	/**
	 * Deletes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article that was removed
	 * @throws PortalException if a category article with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public CategoryArticle deleteCategoryArticle(
			CategoryArticlePK categoryArticlePK)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.CategoryArticleModelImpl</code>.
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
	public CategoryArticle fetchCategoryArticle(
		CategoryArticlePK categoryArticlePK);

	public List<CategoryArticle> findByCategory(long categoryId);

	public List<CategoryArticle> findByCatId(long catId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the category article with the primary key.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article
	 * @throws PortalException if a category article with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CategoryArticle getCategoryArticle(
			CategoryArticlePK categoryArticlePK)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CategoryArticle> getCategoryArticles(int start, int end);

	/**
	 * Returns the number of category articles.
	 *
	 * @return the number of category articles
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCategoryArticlesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CategoryArticle> getCategoryOfArticle(long idArticle);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Long> getCategoryOfArticleWithId(long id_article);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountById(long catId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object> getDuLieuTheoSql(String sqlQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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

	public void removeByArticle(long article);

	public void removeByCategory(long categoryId);

	/**
	 * Updates the category article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticle the category article
	 * @return the category article that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public CategoryArticle updateCategoryArticle(
		CategoryArticle categoryArticle);

}