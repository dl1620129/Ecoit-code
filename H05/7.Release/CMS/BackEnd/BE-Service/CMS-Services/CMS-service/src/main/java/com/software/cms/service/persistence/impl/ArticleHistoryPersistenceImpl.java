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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.software.cms.exception.NoSuchArticleHistoryException;
import com.software.cms.model.ArticleHistory;
import com.software.cms.model.impl.ArticleHistoryImpl;
import com.software.cms.model.impl.ArticleHistoryModelImpl;
import com.software.cms.service.persistence.ArticleHistoryPersistence;
import com.software.cms.service.persistence.impl.constants.soft_cmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the article history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = ArticleHistoryPersistence.class)
public class ArticleHistoryPersistenceImpl
	extends BasePersistenceImpl<ArticleHistory>
	implements ArticleHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ArticleHistoryUtil</code> to access the article history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ArticleHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the article histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article histories
	 */
	@Override
	public List<ArticleHistory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ArticleHistory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<ArticleHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ArticleHistory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ArticleHistory> list = null;

		if (useFinderCache) {
			list = (List<ArticleHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ArticleHistory articleHistory : list) {
					if (!uuid.equals(articleHistory.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLEHISTORY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ArticleHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<ArticleHistory>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Returns the first article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	@Override
	public ArticleHistory findByUuid_First(
			String uuid, OrderByComparator<ArticleHistory> orderByComparator)
		throws NoSuchArticleHistoryException {

		ArticleHistory articleHistory = fetchByUuid_First(
			uuid, orderByComparator);

		if (articleHistory != null) {
			return articleHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleHistoryException(msg.toString());
	}

	/**
	 * Returns the first article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history, or <code>null</code> if a matching article history could not be found
	 */
	@Override
	public ArticleHistory fetchByUuid_First(
		String uuid, OrderByComparator<ArticleHistory> orderByComparator) {

		List<ArticleHistory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	@Override
	public ArticleHistory findByUuid_Last(
			String uuid, OrderByComparator<ArticleHistory> orderByComparator)
		throws NoSuchArticleHistoryException {

		ArticleHistory articleHistory = fetchByUuid_Last(
			uuid, orderByComparator);

		if (articleHistory != null) {
			return articleHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleHistoryException(msg.toString());
	}

	/**
	 * Returns the last article history in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history, or <code>null</code> if a matching article history could not be found
	 */
	@Override
	public ArticleHistory fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleHistory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ArticleHistory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the article histories before and after the current article history in the ordered set where uuid = &#63;.
	 *
	 * @param articleHistoryId the primary key of the current article history
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory[] findByUuid_PrevAndNext(
			long articleHistoryId, String uuid,
			OrderByComparator<ArticleHistory> orderByComparator)
		throws NoSuchArticleHistoryException {

		uuid = Objects.toString(uuid, "");

		ArticleHistory articleHistory = findByPrimaryKey(articleHistoryId);

		Session session = null;

		try {
			session = openSession();

			ArticleHistory[] array = new ArticleHistoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, articleHistory, uuid, orderByComparator, true);

			array[1] = articleHistory;

			array[2] = getByUuid_PrevAndNext(
				session, articleHistory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleHistory getByUuid_PrevAndNext(
		Session session, ArticleHistory articleHistory, String uuid,
		OrderByComparator<ArticleHistory> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLEHISTORY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						articleHistory)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ArticleHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the article histories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ArticleHistory articleHistory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(articleHistory);
		}
	}

	/**
	 * Returns the number of article histories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article histories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLEHISTORY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"articleHistory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(articleHistory.uuid IS NULL OR articleHistory.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByArticle;
	private FinderPath _finderPathWithoutPaginationFindByArticle;
	private FinderPath _finderPathCountByArticle;

	/**
	 * Returns all the article histories where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching article histories
	 */
	@Override
	public List<ArticleHistory> findByArticle(long articleId) {
		return findByArticle(
			articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ArticleHistory> findByArticle(
		long articleId, int start, int end) {

		return findByArticle(articleId, start, end, null);
	}

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
	@Override
	public List<ArticleHistory> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return findByArticle(articleId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ArticleHistory> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator,
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

		List<ArticleHistory> list = null;

		if (useFinderCache) {
			list = (List<ArticleHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ArticleHistory articleHistory : list) {
					if (articleId != articleHistory.getArticleId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ARTICLEHISTORY_WHERE);

			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ArticleHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				list = (List<ArticleHistory>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Returns the first article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	@Override
	public ArticleHistory findByArticle_First(
			long articleId, OrderByComparator<ArticleHistory> orderByComparator)
		throws NoSuchArticleHistoryException {

		ArticleHistory articleHistory = fetchByArticle_First(
			articleId, orderByComparator);

		if (articleHistory != null) {
			return articleHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchArticleHistoryException(msg.toString());
	}

	/**
	 * Returns the first article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article history, or <code>null</code> if a matching article history could not be found
	 */
	@Override
	public ArticleHistory fetchByArticle_First(
		long articleId, OrderByComparator<ArticleHistory> orderByComparator) {

		List<ArticleHistory> list = findByArticle(
			articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history
	 * @throws NoSuchArticleHistoryException if a matching article history could not be found
	 */
	@Override
	public ArticleHistory findByArticle_Last(
			long articleId, OrderByComparator<ArticleHistory> orderByComparator)
		throws NoSuchArticleHistoryException {

		ArticleHistory articleHistory = fetchByArticle_Last(
			articleId, orderByComparator);

		if (articleHistory != null) {
			return articleHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchArticleHistoryException(msg.toString());
	}

	/**
	 * Returns the last article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article history, or <code>null</code> if a matching article history could not be found
	 */
	@Override
	public ArticleHistory fetchByArticle_Last(
		long articleId, OrderByComparator<ArticleHistory> orderByComparator) {

		int count = countByArticle(articleId);

		if (count == 0) {
			return null;
		}

		List<ArticleHistory> list = findByArticle(
			articleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the article histories before and after the current article history in the ordered set where articleId = &#63;.
	 *
	 * @param articleHistoryId the primary key of the current article history
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory[] findByArticle_PrevAndNext(
			long articleHistoryId, long articleId,
			OrderByComparator<ArticleHistory> orderByComparator)
		throws NoSuchArticleHistoryException {

		ArticleHistory articleHistory = findByPrimaryKey(articleHistoryId);

		Session session = null;

		try {
			session = openSession();

			ArticleHistory[] array = new ArticleHistoryImpl[3];

			array[0] = getByArticle_PrevAndNext(
				session, articleHistory, articleId, orderByComparator, true);

			array[1] = articleHistory;

			array[2] = getByArticle_PrevAndNext(
				session, articleHistory, articleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleHistory getByArticle_PrevAndNext(
		Session session, ArticleHistory articleHistory, long articleId,
		OrderByComparator<ArticleHistory> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLEHISTORY_WHERE);

		query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ArticleHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(articleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						articleHistory)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ArticleHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the article histories where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	@Override
	public void removeByArticle(long articleId) {
		for (ArticleHistory articleHistory :
				findByArticle(
					articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(articleHistory);
		}
	}

	/**
	 * Returns the number of article histories where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching article histories
	 */
	@Override
	public int countByArticle(long articleId) {
		FinderPath finderPath = _finderPathCountByArticle;

		Object[] finderArgs = new Object[] {articleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLEHISTORY_WHERE);

			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				count = (Long)q.uniqueResult();

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
		"articleHistory.articleId = ?";

	public ArticleHistoryPersistenceImpl() {
		setModelClass(ArticleHistory.class);

		setModelImplClass(ArticleHistoryImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the article history in the entity cache if it is enabled.
	 *
	 * @param articleHistory the article history
	 */
	@Override
	public void cacheResult(ArticleHistory articleHistory) {
		entityCache.putResult(
			entityCacheEnabled, ArticleHistoryImpl.class,
			articleHistory.getPrimaryKey(), articleHistory);

		articleHistory.resetOriginalValues();
	}

	/**
	 * Caches the article histories in the entity cache if it is enabled.
	 *
	 * @param articleHistories the article histories
	 */
	@Override
	public void cacheResult(List<ArticleHistory> articleHistories) {
		for (ArticleHistory articleHistory : articleHistories) {
			if (entityCache.getResult(
					entityCacheEnabled, ArticleHistoryImpl.class,
					articleHistory.getPrimaryKey()) == null) {

				cacheResult(articleHistory);
			}
			else {
				articleHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all article histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ArticleHistory articleHistory) {
		entityCache.removeResult(
			entityCacheEnabled, ArticleHistoryImpl.class,
			articleHistory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ArticleHistory> articleHistories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ArticleHistory articleHistory : articleHistories) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleHistoryImpl.class,
				articleHistory.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleHistoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new article history with the primary key. Does not add the article history to the database.
	 *
	 * @param articleHistoryId the primary key for the new article history
	 * @return the new article history
	 */
	@Override
	public ArticleHistory create(long articleHistoryId) {
		ArticleHistory articleHistory = new ArticleHistoryImpl();

		articleHistory.setNew(true);
		articleHistory.setPrimaryKey(articleHistoryId);

		String uuid = PortalUUIDUtil.generate();

		articleHistory.setUuid(uuid);

		return articleHistory;
	}

	/**
	 * Removes the article history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history that was removed
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory remove(long articleHistoryId)
		throws NoSuchArticleHistoryException {

		return remove((Serializable)articleHistoryId);
	}

	/**
	 * Removes the article history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article history
	 * @return the article history that was removed
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory remove(Serializable primaryKey)
		throws NoSuchArticleHistoryException {

		Session session = null;

		try {
			session = openSession();

			ArticleHistory articleHistory = (ArticleHistory)session.get(
				ArticleHistoryImpl.class, primaryKey);

			if (articleHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(articleHistory);
		}
		catch (NoSuchArticleHistoryException noSuchEntityException) {
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
	protected ArticleHistory removeImpl(ArticleHistory articleHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(articleHistory)) {
				articleHistory = (ArticleHistory)session.get(
					ArticleHistoryImpl.class,
					articleHistory.getPrimaryKeyObj());
			}

			if (articleHistory != null) {
				session.delete(articleHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (articleHistory != null) {
			clearCache(articleHistory);
		}

		return articleHistory;
	}

	@Override
	public ArticleHistory updateImpl(ArticleHistory articleHistory) {
		boolean isNew = articleHistory.isNew();

		if (!(articleHistory instanceof ArticleHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(articleHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					articleHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in articleHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ArticleHistory implementation " +
					articleHistory.getClass());
		}

		ArticleHistoryModelImpl articleHistoryModelImpl =
			(ArticleHistoryModelImpl)articleHistory;

		if (Validator.isNull(articleHistory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			articleHistory.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (articleHistory.isNew()) {
				session.save(articleHistory);

				articleHistory.setNew(false);
			}
			else {
				articleHistory = (ArticleHistory)session.merge(articleHistory);
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
			Object[] args = new Object[] {articleHistoryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {articleHistoryModelImpl.getArticleId()};

			finderCache.removeResult(_finderPathCountByArticle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByArticle, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((articleHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					articleHistoryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {articleHistoryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((articleHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByArticle.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					articleHistoryModelImpl.getOriginalArticleId()
				};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);

				args = new Object[] {articleHistoryModelImpl.getArticleId()};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ArticleHistoryImpl.class,
			articleHistory.getPrimaryKey(), articleHistory, false);

		articleHistory.resetOriginalValues();

		return articleHistory;
	}

	/**
	 * Returns the article history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article history
	 * @return the article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleHistoryException {

		ArticleHistory articleHistory = fetchByPrimaryKey(primaryKey);

		if (articleHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return articleHistory;
	}

	/**
	 * Returns the article history with the primary key or throws a <code>NoSuchArticleHistoryException</code> if it could not be found.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history
	 * @throws NoSuchArticleHistoryException if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory findByPrimaryKey(long articleHistoryId)
		throws NoSuchArticleHistoryException {

		return findByPrimaryKey((Serializable)articleHistoryId);
	}

	/**
	 * Returns the article history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleHistoryId the primary key of the article history
	 * @return the article history, or <code>null</code> if a article history with the primary key could not be found
	 */
	@Override
	public ArticleHistory fetchByPrimaryKey(long articleHistoryId) {
		return fetchByPrimaryKey((Serializable)articleHistoryId);
	}

	/**
	 * Returns all the article histories.
	 *
	 * @return the article histories
	 */
	@Override
	public List<ArticleHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ArticleHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ArticleHistory> findAll(
		int start, int end,
		OrderByComparator<ArticleHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ArticleHistory> findAll(
		int start, int end, OrderByComparator<ArticleHistory> orderByComparator,
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

		List<ArticleHistory> list = null;

		if (useFinderCache) {
			list = (List<ArticleHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ARTICLEHISTORY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLEHISTORY;

				sql = sql.concat(ArticleHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ArticleHistory>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Removes all the article histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ArticleHistory articleHistory : findAll()) {
			remove(articleHistory);
		}
	}

	/**
	 * Returns the number of article histories.
	 *
	 * @return the number of article histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLEHISTORY);

				count = (Long)q.uniqueResult();

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "articleHistoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ARTICLEHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ArticleHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article history persistence.
	 */
	@Activate
	public void activate() {
		ArticleHistoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ArticleHistoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ArticleHistoryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] {Long.class.getName()},
			ArticleHistoryModelImpl.ARTICLEID_COLUMN_BITMASK);

		_finderPathCountByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ArticleHistoryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.ArticleHistory"),
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

	private static final String _SQL_SELECT_ARTICLEHISTORY =
		"SELECT articleHistory FROM ArticleHistory articleHistory";

	private static final String _SQL_SELECT_ARTICLEHISTORY_WHERE =
		"SELECT articleHistory FROM ArticleHistory articleHistory WHERE ";

	private static final String _SQL_COUNT_ARTICLEHISTORY =
		"SELECT COUNT(articleHistory) FROM ArticleHistory articleHistory";

	private static final String _SQL_COUNT_ARTICLEHISTORY_WHERE =
		"SELECT COUNT(articleHistory) FROM ArticleHistory articleHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "articleHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ArticleHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ArticleHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ArticleHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}