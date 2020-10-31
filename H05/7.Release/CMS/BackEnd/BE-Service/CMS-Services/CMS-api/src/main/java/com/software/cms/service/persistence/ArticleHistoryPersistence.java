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

import com.software.cms.exception.NoSuchArticleHistoryException;
import com.software.cms.model.ArticleHistory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the article history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @see ArticleHistoryUtil
 * @generated
 */
@ProviderType
public interface ArticleHistoryPersistence
	extends BasePersistence<ArticleHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleHistoryUtil} to access the article history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the article histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article histories
	 */
	public java.util.List<ArticleHistory> findByUuid(String uuid);

	/**
	 * Returns a range of all the article histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of matching article histories
	 */
	public java.util.List<ArticleHistory> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the article histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article histories
	 */
	public java.util.List<ArticleHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article histories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article histories
	 */
	public java.util.List<ArticleHistory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public ArticleHistory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
				orderByComparator)
		throws NoSuchArticleHistoryException;

	/**
	 * Returns the first article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public ArticleHistory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns the last article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public ArticleHistory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
				orderByComparator)
		throws NoSuchArticleHistoryException;

	/**
	 * Returns the last article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public ArticleHistory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns the article histories before and after the current article history in the ordered set where uuid = &#63;.
	 *
	 * @param articleHistoryId the primary key of the current article history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public ArticleHistory[] findByUuid_PrevAndNext(
			long articleHistoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
				orderByComparator)
		throws NoSuchArticleHistoryException;

	/**
	 * Removes all the article histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of article histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article histories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the article histories where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching article histories
	 */
	public java.util.List<ArticleHistory> findByArticle(long articleId);

	/**
	 * Returns a range of all the article histories where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of matching article histories
	 */
	public java.util.List<ArticleHistory> findByArticle(
		long articleId, int start, int end);

	/**
	 * Returns an ordered range of all the article histories where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article histories
	 */
	public java.util.List<ArticleHistory> findByArticle(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article histories where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article histories
	 */
	public java.util.List<ArticleHistory> findByArticle(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public ArticleHistory findByArticle_First(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
				orderByComparator)
		throws NoSuchArticleHistoryException;

	/**
	 * Returns the first article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public ArticleHistory fetchByArticle_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns the last article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	public ArticleHistory findByArticle_Last(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
				orderByComparator)
		throws NoSuchArticleHistoryException;

	/**
	 * Returns the last article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history, or <code>null</code> if a matching article history could not be found
	 */
	public ArticleHistory fetchByArticle_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns the article histories before and after the current article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleHistoryId the primary key of the current article history
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public ArticleHistory[] findByArticle_PrevAndNext(
			long articleHistoryId, long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
				orderByComparator)
		throws NoSuchArticleHistoryException;

	/**
	 * Removes all the article histories where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public void removeByArticle(long articleId);

	/**
	 * Returns the number of article histories where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching article histories
	 */
	public int countByArticle(long articleId);

	/**
	 * Caches the article history in the entity cache if it is enabled.
	 *
	 * @param articleHistory the article history
	 */
	public void cacheResult(ArticleHistory articleHistory);

	/**
	 * Caches the article histories in the entity cache if it is enabled.
	 *
	 * @param articleHistories the article histories
	 */
	public void cacheResult(java.util.List<ArticleHistory> articleHistories);

	/**
	 * Creates a new article history with the primary key. Does not add the article history to the database.
	 *
	 * @param articleHistoryId the primary key for the new article history
	 * @return the new article history
	 */
	public ArticleHistory create(long articleHistoryId);

	/**
	 * Removes the article history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history that was removed
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public ArticleHistory remove(long articleHistoryId)
		throws NoSuchArticleHistoryException;

	public ArticleHistory updateImpl(ArticleHistory articleHistory);

	/**
	 * Returns the article history with the primary key or throws a <code>NoSuchArticleHistoryException</code> if it could not be found.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	public ArticleHistory findByPrimaryKey(long articleHistoryId)
		throws NoSuchArticleHistoryException;

	/**
	 * Returns the article history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history, or <code>null</code> if a article history with the primary key could not be found
	 */
	public ArticleHistory fetchByPrimaryKey(long articleHistoryId);

	/**
	 * Returns all the article histories.
	 *
	 * @return the article histories
	 */
	public java.util.List<ArticleHistory> findAll();

	/**
	 * Returns a range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @return the range of article histories
	 */
	public java.util.List<ArticleHistory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article histories
	 */
	public java.util.List<ArticleHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the article histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article histories
	 * @param end the upper bound of the range of article histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article histories
	 */
	public java.util.List<ArticleHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the article histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of article histories.
	 *
	 * @return the number of article histories
	 */
	public int countAll();

}