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

package com.software.cms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.software.cms.exception.NoSuchCategoryArticleException;
import com.software.cms.model.CategoryArticle;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the category article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see CategoryArticleUtil
 * @generated
 */
@ProviderType
public interface CategoryArticlePersistence
	extends BasePersistence<CategoryArticle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryArticleUtil} to access the category article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the category articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching category articles
	 */
	public java.util.List<CategoryArticle> findByArticle(long articleId);

	/**
	 * Returns a range of all the category articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of matching category articles
	 */
	public java.util.List<CategoryArticle> findByArticle(
		long articleId, int start, int end);

	/**
	 * Returns an ordered range of all the category articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category articles
	 */
	public java.util.List<CategoryArticle> findByArticle(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the category articles where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category articles
	 */
	public java.util.List<CategoryArticle> findByArticle(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public CategoryArticle findByArticle_First(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
				orderByComparator)
		throws NoSuchCategoryArticleException;

	/**
	 * Returns the first category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public CategoryArticle fetchByArticle_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns the last category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public CategoryArticle findByArticle_Last(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
				orderByComparator)
		throws NoSuchCategoryArticleException;

	/**
	 * Returns the last category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public CategoryArticle fetchByArticle_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns the category articles before and after the current category article in the ordered set where articleId = &#63;.
	 *
	 * @param categoryArticlePK the primary key of the current category article
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public CategoryArticle[] findByArticle_PrevAndNext(
			CategoryArticlePK categoryArticlePK, long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
				orderByComparator)
		throws NoSuchCategoryArticleException;

	/**
	 * Removes all the category articles where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public void removeByArticle(long articleId);

	/**
	 * Returns the number of category articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching category articles
	 */
	public int countByArticle(long articleId);

	/**
	 * Returns all the category articles where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching category articles
	 */
	public java.util.List<CategoryArticle> findByCategory(long categoryId);

	/**
	 * Returns a range of all the category articles where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of matching category articles
	 */
	public java.util.List<CategoryArticle> findByCategory(
		long categoryId, int start, int end);

	/**
	 * Returns an ordered range of all the category articles where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category articles
	 */
	public java.util.List<CategoryArticle> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the category articles where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching category articles
	 */
	public java.util.List<CategoryArticle> findByCategory(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public CategoryArticle findByCategory_First(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
				orderByComparator)
		throws NoSuchCategoryArticleException;

	/**
	 * Returns the first category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public CategoryArticle fetchByCategory_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns the last category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	public CategoryArticle findByCategory_Last(
			long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
				orderByComparator)
		throws NoSuchCategoryArticleException;

	/**
	 * Returns the last category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article, or <code>null</code> if a matching category article could not be found
	 */
	public CategoryArticle fetchByCategory_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns the category articles before and after the current category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryArticlePK the primary key of the current category article
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public CategoryArticle[] findByCategory_PrevAndNext(
			CategoryArticlePK categoryArticlePK, long categoryId,
			com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
				orderByComparator)
		throws NoSuchCategoryArticleException;

	/**
	 * Removes all the category articles where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByCategory(long categoryId);

	/**
	 * Returns the number of category articles where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching category articles
	 */
	public int countByCategory(long categoryId);

	/**
	 * Caches the category article in the entity cache if it is enabled.
	 *
	 * @param categoryArticle the category article
	 */
	public void cacheResult(CategoryArticle categoryArticle);

	/**
	 * Caches the category articles in the entity cache if it is enabled.
	 *
	 * @param categoryArticles the category articles
	 */
	public void cacheResult(java.util.List<CategoryArticle> categoryArticles);

	/**
	 * Creates a new category article with the primary key. Does not add the category article to the database.
	 *
	 * @param categoryArticlePK the primary key for the new category article
	 * @return the new category article
	 */
	public CategoryArticle create(CategoryArticlePK categoryArticlePK);

	/**
	 * Removes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article that was removed
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public CategoryArticle remove(CategoryArticlePK categoryArticlePK)
		throws NoSuchCategoryArticleException;

	public CategoryArticle updateImpl(CategoryArticle categoryArticle);

	/**
	 * Returns the category article with the primary key or throws a <code>NoSuchCategoryArticleException</code> if it could not be found.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	public CategoryArticle findByPrimaryKey(CategoryArticlePK categoryArticlePK)
		throws NoSuchCategoryArticleException;

	/**
	 * Returns the category article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article, or <code>null</code> if a category article with the primary key could not be found
	 */
	public CategoryArticle fetchByPrimaryKey(
		CategoryArticlePK categoryArticlePK);

	/**
	 * Returns all the category articles.
	 *
	 * @return the category articles
	 */
	public java.util.List<CategoryArticle> findAll();

	/**
	 * Returns a range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @return the range of category articles
	 */
	public java.util.List<CategoryArticle> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category articles
	 */
	public java.util.List<CategoryArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the category articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CategoryArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of category articles
	 * @param end the upper bound of the range of category articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of category articles
	 */
	public java.util.List<CategoryArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the category articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of category articles.
	 *
	 * @return the number of category articles
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}