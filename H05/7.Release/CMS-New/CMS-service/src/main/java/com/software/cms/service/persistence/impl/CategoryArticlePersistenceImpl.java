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

package com.software.cms.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.software.cms.exception.NoSuchCategoryArticleException;
import com.software.cms.model.CategoryArticle;
import com.software.cms.model.impl.CategoryArticleImpl;
import com.software.cms.model.impl.CategoryArticleModelImpl;
import com.software.cms.service.persistence.CategoryArticlePK;
import com.software.cms.service.persistence.CategoryArticlePersistence;
import com.software.cms.service.persistence.impl.constants.soft_cmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the category article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = CategoryArticlePersistence.class)
public class CategoryArticlePersistenceImpl
	extends BasePersistenceImpl<CategoryArticle>
	implements CategoryArticlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CategoryArticleUtil</code> to access the category article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CategoryArticleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByArticle;
	private FinderPath _finderPathWithoutPaginationFindByArticle;
	private FinderPath _finderPathCountByArticle;

	/**
	 * Returns all the category articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching category articles
	 */
	@Override
	public List<CategoryArticle> findByArticle(long articleId) {
		return findByArticle(
			articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CategoryArticle> findByArticle(
		long articleId, int start, int end) {

		return findByArticle(articleId, start, end, null);
	}

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
	@Override
	public List<CategoryArticle> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return findByArticle(articleId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CategoryArticle> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByArticle;
				finderArgs = new Object[] {articleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByArticle;
			finderArgs = new Object[] {
				articleId, start, end, orderByComparator
			};
		}

		List<CategoryArticle> list = null;

		if (useFinderCache) {
			list = (List<CategoryArticle>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryArticle categoryArticle : list) {
					if (articleId != categoryArticle.getArticleId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATEGORYARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articleId);

				list = (List<CategoryArticle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	@Override
	public CategoryArticle findByArticle_First(
			long articleId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = fetchByArticle_First(
			articleId, orderByComparator);

		if (categoryArticle != null) {
			return categoryArticle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("articleId=");
		sb.append(articleId);

		sb.append("}");

		throw new NoSuchCategoryArticleException(sb.toString());
	}

	/**
	 * Returns the first category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article, or <code>null</code> if a matching category article could not be found
	 */
	@Override
	public CategoryArticle fetchByArticle_First(
		long articleId, OrderByComparator<CategoryArticle> orderByComparator) {

		List<CategoryArticle> list = findByArticle(
			articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	@Override
	public CategoryArticle findByArticle_Last(
			long articleId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = fetchByArticle_Last(
			articleId, orderByComparator);

		if (categoryArticle != null) {
			return categoryArticle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("articleId=");
		sb.append(articleId);

		sb.append("}");

		throw new NoSuchCategoryArticleException(sb.toString());
	}

	/**
	 * Returns the last category article in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article, or <code>null</code> if a matching category article could not be found
	 */
	@Override
	public CategoryArticle fetchByArticle_Last(
		long articleId, OrderByComparator<CategoryArticle> orderByComparator) {

		int count = countByArticle(articleId);

		if (count == 0) {
			return null;
		}

		List<CategoryArticle> list = findByArticle(
			articleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the category articles before and after the current category article in the ordered set where articleId = &#63;.
	 *
	 * @param categoryArticlePK the primary key of the current category article
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle[] findByArticle_PrevAndNext(
			CategoryArticlePK categoryArticlePK, long articleId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = findByPrimaryKey(categoryArticlePK);

		Session session = null;

		try {
			session = openSession();

			CategoryArticle[] array = new CategoryArticleImpl[3];

			array[0] = getByArticle_PrevAndNext(
				session, categoryArticle, articleId, orderByComparator, true);

			array[1] = categoryArticle;

			array[2] = getByArticle_PrevAndNext(
				session, categoryArticle, articleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryArticle getByArticle_PrevAndNext(
		Session session, CategoryArticle categoryArticle, long articleId,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORYARTICLE_WHERE);

		sb.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CategoryArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(articleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						categoryArticle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CategoryArticle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category articles where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	@Override
	public void removeByArticle(long articleId) {
		for (CategoryArticle categoryArticle :
				findByArticle(
					articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(categoryArticle);
		}
	}

	/**
	 * Returns the number of category articles where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching category articles
	 */
	@Override
	public int countByArticle(long articleId) {
		FinderPath finderPath = _finderPathCountByArticle;

		Object[] finderArgs = new Object[] {articleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORYARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(articleId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 =
		"categoryArticle.id.articleId = ?";

	private FinderPath _finderPathWithPaginationFindByCategory;
	private FinderPath _finderPathWithoutPaginationFindByCategory;
	private FinderPath _finderPathCountByCategory;

	/**
	 * Returns all the category articles where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching category articles
	 */
	@Override
	public List<CategoryArticle> findByCategory(long categoryId) {
		return findByCategory(
			categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CategoryArticle> findByCategory(
		long categoryId, int start, int end) {

		return findByCategory(categoryId, start, end, null);
	}

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
	@Override
	public List<CategoryArticle> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return findByCategory(categoryId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<CategoryArticle> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCategory;
				finderArgs = new Object[] {categoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCategory;
			finderArgs = new Object[] {
				categoryId, start, end, orderByComparator
			};
		}

		List<CategoryArticle> list = null;

		if (useFinderCache) {
			list = (List<CategoryArticle>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryArticle categoryArticle : list) {
					if (categoryId != categoryArticle.getCategoryId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CATEGORYARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CategoryArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				list = (List<CategoryArticle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	@Override
	public CategoryArticle findByCategory_First(
			long categoryId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = fetchByCategory_First(
			categoryId, orderByComparator);

		if (categoryArticle != null) {
			return categoryArticle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryId=");
		sb.append(categoryId);

		sb.append("}");

		throw new NoSuchCategoryArticleException(sb.toString());
	}

	/**
	 * Returns the first category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category article, or <code>null</code> if a matching category article could not be found
	 */
	@Override
	public CategoryArticle fetchByCategory_First(
		long categoryId, OrderByComparator<CategoryArticle> orderByComparator) {

		List<CategoryArticle> list = findByCategory(
			categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article
	 * @throws NoSuchCategoryArticleException if a matching category article could not be found
	 */
	@Override
	public CategoryArticle findByCategory_Last(
			long categoryId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = fetchByCategory_Last(
			categoryId, orderByComparator);

		if (categoryArticle != null) {
			return categoryArticle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryId=");
		sb.append(categoryId);

		sb.append("}");

		throw new NoSuchCategoryArticleException(sb.toString());
	}

	/**
	 * Returns the last category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category article, or <code>null</code> if a matching category article could not be found
	 */
	@Override
	public CategoryArticle fetchByCategory_Last(
		long categoryId, OrderByComparator<CategoryArticle> orderByComparator) {

		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<CategoryArticle> list = findByCategory(
			categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the category articles before and after the current category article in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryArticlePK the primary key of the current category article
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle[] findByCategory_PrevAndNext(
			CategoryArticlePK categoryArticlePK, long categoryId,
			OrderByComparator<CategoryArticle> orderByComparator)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = findByPrimaryKey(categoryArticlePK);

		Session session = null;

		try {
			session = openSession();

			CategoryArticle[] array = new CategoryArticleImpl[3];

			array[0] = getByCategory_PrevAndNext(
				session, categoryArticle, categoryId, orderByComparator, true);

			array[1] = categoryArticle;

			array[2] = getByCategory_PrevAndNext(
				session, categoryArticle, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryArticle getByCategory_PrevAndNext(
		Session session, CategoryArticle categoryArticle, long categoryId,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CATEGORYARTICLE_WHERE);

		sb.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CategoryArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						categoryArticle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CategoryArticle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category articles where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByCategory(long categoryId) {
		for (CategoryArticle categoryArticle :
				findByCategory(
					categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(categoryArticle);
		}
	}

	/**
	 * Returns the number of category articles where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching category articles
	 */
	@Override
	public int countByCategory(long categoryId) {
		FinderPath finderPath = _finderPathCountByCategory;

		Object[] finderArgs = new Object[] {categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CATEGORYARTICLE_WHERE);

			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 =
		"categoryArticle.id.categoryId = ?";

	public CategoryArticlePersistenceImpl() {
		setModelClass(CategoryArticle.class);

		setModelImplClass(CategoryArticleImpl.class);
		setModelPKClass(CategoryArticlePK.class);
	}

	/**
	 * Caches the category article in the entity cache if it is enabled.
	 *
	 * @param categoryArticle the category article
	 */
	@Override
	public void cacheResult(CategoryArticle categoryArticle) {
		entityCache.putResult(
			entityCacheEnabled, CategoryArticleImpl.class,
			categoryArticle.getPrimaryKey(), categoryArticle);

		categoryArticle.resetOriginalValues();
	}

	/**
	 * Caches the category articles in the entity cache if it is enabled.
	 *
	 * @param categoryArticles the category articles
	 */
	@Override
	public void cacheResult(List<CategoryArticle> categoryArticles) {
		for (CategoryArticle categoryArticle : categoryArticles) {
			if (entityCache.getResult(
					entityCacheEnabled, CategoryArticleImpl.class,
					categoryArticle.getPrimaryKey()) == null) {

				cacheResult(categoryArticle);
			}
			else {
				categoryArticle.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all category articles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoryArticleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category article.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryArticle categoryArticle) {
		entityCache.removeResult(
			entityCacheEnabled, CategoryArticleImpl.class,
			categoryArticle.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CategoryArticle> categoryArticles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoryArticle categoryArticle : categoryArticles) {
			entityCache.removeResult(
				entityCacheEnabled, CategoryArticleImpl.class,
				categoryArticle.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CategoryArticleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new category article with the primary key. Does not add the category article to the database.
	 *
	 * @param categoryArticlePK the primary key for the new category article
	 * @return the new category article
	 */
	@Override
	public CategoryArticle create(CategoryArticlePK categoryArticlePK) {
		CategoryArticle categoryArticle = new CategoryArticleImpl();

		categoryArticle.setNew(true);
		categoryArticle.setPrimaryKey(categoryArticlePK);

		return categoryArticle;
	}

	/**
	 * Removes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article that was removed
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle remove(CategoryArticlePK categoryArticlePK)
		throws NoSuchCategoryArticleException {

		return remove((Serializable)categoryArticlePK);
	}

	/**
	 * Removes the category article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category article
	 * @return the category article that was removed
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle remove(Serializable primaryKey)
		throws NoSuchCategoryArticleException {

		Session session = null;

		try {
			session = openSession();

			CategoryArticle categoryArticle = (CategoryArticle)session.get(
				CategoryArticleImpl.class, primaryKey);

			if (categoryArticle == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryArticleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(categoryArticle);
		}
		catch (NoSuchCategoryArticleException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CategoryArticle removeImpl(CategoryArticle categoryArticle) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(categoryArticle)) {
				categoryArticle = (CategoryArticle)session.get(
					CategoryArticleImpl.class,
					categoryArticle.getPrimaryKeyObj());
			}

			if (categoryArticle != null) {
				session.delete(categoryArticle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (categoryArticle != null) {
			clearCache(categoryArticle);
		}

		return categoryArticle;
	}

	@Override
	public CategoryArticle updateImpl(CategoryArticle categoryArticle) {
		boolean isNew = categoryArticle.isNew();

		if (!(categoryArticle instanceof CategoryArticleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(categoryArticle.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					categoryArticle);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in categoryArticle proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CategoryArticle implementation " +
					categoryArticle.getClass());
		}

		CategoryArticleModelImpl categoryArticleModelImpl =
			(CategoryArticleModelImpl)categoryArticle;

		Session session = null;

		try {
			session = openSession();

			if (categoryArticle.isNew()) {
				session.save(categoryArticle);

				categoryArticle.setNew(false);
			}
			else {
				categoryArticle = (CategoryArticle)session.merge(
					categoryArticle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				categoryArticleModelImpl.getArticleId()
			};

			finderCache.removeResult(_finderPathCountByArticle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByArticle, args);

			args = new Object[] {categoryArticleModelImpl.getCategoryId()};

			finderCache.removeResult(_finderPathCountByCategory, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCategory, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((categoryArticleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByArticle.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					categoryArticleModelImpl.getOriginalArticleId()
				};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);

				args = new Object[] {categoryArticleModelImpl.getArticleId()};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);
			}

			if ((categoryArticleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCategory.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					categoryArticleModelImpl.getOriginalCategoryId()
				};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);

				args = new Object[] {categoryArticleModelImpl.getCategoryId()};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CategoryArticleImpl.class,
			categoryArticle.getPrimaryKey(), categoryArticle, false);

		categoryArticle.resetOriginalValues();

		return categoryArticle;
	}

	/**
	 * Returns the category article with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category article
	 * @return the category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryArticleException {

		CategoryArticle categoryArticle = fetchByPrimaryKey(primaryKey);

		if (categoryArticle == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryArticleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return categoryArticle;
	}

	/**
	 * Returns the category article with the primary key or throws a <code>NoSuchCategoryArticleException</code> if it could not be found.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article
	 * @throws NoSuchCategoryArticleException if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle findByPrimaryKey(CategoryArticlePK categoryArticlePK)
		throws NoSuchCategoryArticleException {

		return findByPrimaryKey((Serializable)categoryArticlePK);
	}

	/**
	 * Returns the category article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryArticlePK the primary key of the category article
	 * @return the category article, or <code>null</code> if a category article with the primary key could not be found
	 */
	@Override
	public CategoryArticle fetchByPrimaryKey(
		CategoryArticlePK categoryArticlePK) {

		return fetchByPrimaryKey((Serializable)categoryArticlePK);
	}

	/**
	 * Returns all the category articles.
	 *
	 * @return the category articles
	 */
	@Override
	public List<CategoryArticle> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CategoryArticle> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CategoryArticle> findAll(
		int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<CategoryArticle> findAll(
		int start, int end,
		OrderByComparator<CategoryArticle> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CategoryArticle> list = null;

		if (useFinderCache) {
			list = (List<CategoryArticle>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CATEGORYARTICLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYARTICLE;

				sql = sql.concat(CategoryArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CategoryArticle>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the category articles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CategoryArticle categoryArticle : findAll()) {
			remove(categoryArticle);
		}
	}

	/**
	 * Returns the number of category articles.
	 *
	 * @return the number of category articles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CATEGORYARTICLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "categoryArticlePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CATEGORYARTICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CategoryArticleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category article persistence.
	 */
	@Activate
	public void activate() {
		CategoryArticleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CategoryArticleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CategoryArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CategoryArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CategoryArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CategoryArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] {Long.class.getName()},
			CategoryArticleModelImpl.ARTICLEID_COLUMN_BITMASK);

		_finderPathCountByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CategoryArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CategoryArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] {Long.class.getName()},
			CategoryArticleModelImpl.CATEGORYID_COLUMN_BITMASK);

		_finderPathCountByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CategoryArticleImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = soft_cmsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.software.cms.model.CategoryArticle"),
			true);
	}

	@Override
	@Reference(
		target = soft_cmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = soft_cmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CATEGORYARTICLE =
		"SELECT categoryArticle FROM CategoryArticle categoryArticle";

	private static final String _SQL_SELECT_CATEGORYARTICLE_WHERE =
		"SELECT categoryArticle FROM CategoryArticle categoryArticle WHERE ";

	private static final String _SQL_COUNT_CATEGORYARTICLE =
		"SELECT COUNT(categoryArticle) FROM CategoryArticle categoryArticle";

	private static final String _SQL_COUNT_CATEGORYARTICLE_WHERE =
		"SELECT COUNT(categoryArticle) FROM CategoryArticle categoryArticle WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryArticle.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CategoryArticle exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CategoryArticle exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CategoryArticlePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"articleId", "categoryId"});

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}