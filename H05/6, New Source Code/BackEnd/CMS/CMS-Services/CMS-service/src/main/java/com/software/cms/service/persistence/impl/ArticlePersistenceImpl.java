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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.software.cms.exception.NoSuchArticleException;
import com.software.cms.model.Article;
import com.software.cms.model.impl.ArticleImpl;
import com.software.cms.model.impl.ArticleModelImpl;
import com.software.cms.service.persistence.ArticlePersistence;
import com.software.cms.service.persistence.impl.constants.soft_cmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = ArticlePersistence.class)
public class ArticlePersistenceImpl
	extends BasePersistenceImpl<Article> implements ArticlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ArticleUtil</code> to access the article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ArticleImpl.class.getName();

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
	 * Returns all the articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	@Override
	public List<Article> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

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

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if (!uuid.equals(article.getUuid())) {
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

			query.append(_SQL_SELECT_ARTICLE_WHERE);

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
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
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

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByUuid_First(
			String uuid, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByUuid_First(uuid, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByUuid_First(
		String uuid, OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByUuid_Last(
			String uuid, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByUuid_Last(uuid, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByUuid_Last(
		String uuid, OrderByComparator<Article> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where uuid = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article[] findByUuid_PrevAndNext(
			long articleId, String uuid,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		uuid = Objects.toString(uuid, "");

		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, article, uuid, orderByComparator, true);

			array[1] = article;

			array[2] = getByUuid_PrevAndNext(
				session, article, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByUuid_PrevAndNext(
		Session session, Article article, String uuid,
		OrderByComparator<Article> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

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
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(article)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Article article :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching articles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "article.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(article.uuid IS NULL OR article.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleException {

		Article article = fetchByUUID_G(uuid, groupId);

		if (article == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchArticleException(msg.toString());
		}

		return article;
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if (!Objects.equals(uuid, article.getUuid()) ||
				(groupId != article.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Article> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Article article = list.get(0);

					result = article;

					cacheResult(article);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article that was removed
	 */
	@Override
	public Article removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleException {

		Article article = findByUUID_G(uuid, groupId);

		return remove(article);
	}

	/**
	 * Returns the number of articles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching articles
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"article.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(article.uuid IS NULL OR article.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"article.groupId = ?";

	private FinderPath _finderPathFetchByFriendUrl;
	private FinderPath _finderPathCountByFriendUrl;

	/**
	 * Returns the article where friendlyURL = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param friendlyURL the friendly url
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByFriendUrl(String friendlyURL)
		throws NoSuchArticleException {

		Article article = fetchByFriendUrl(friendlyURL);

		if (article == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("friendlyURL=");
			msg.append(friendlyURL);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchArticleException(msg.toString());
		}

		return article;
	}

	/**
	 * Returns the article where friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByFriendUrl(String friendlyURL) {
		return fetchByFriendUrl(friendlyURL, true);
	}

	/**
	 * Returns the article where friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByFriendUrl(
		String friendlyURL, boolean useFinderCache) {

		friendlyURL = Objects.toString(friendlyURL, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {friendlyURL};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFriendUrl, finderArgs, this);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if (!Objects.equals(friendlyURL, article.getFriendlyURL())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			boolean bindFriendlyURL = false;

			if (friendlyURL.isEmpty()) {
				query.append(_FINDER_COLUMN_FRIENDURL_FRIENDLYURL_3);
			}
			else {
				bindFriendlyURL = true;

				query.append(_FINDER_COLUMN_FRIENDURL_FRIENDLYURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFriendlyURL) {
					qPos.add(friendlyURL);
				}

				List<Article> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFriendUrl, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {friendlyURL};
							}

							_log.warn(
								"ArticlePersistenceImpl.fetchByFriendUrl(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Article article = list.get(0);

					result = article;

					cacheResult(article);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByFriendUrl, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where friendlyURL = &#63; from the database.
	 *
	 * @param friendlyURL the friendly url
	 * @return the article that was removed
	 */
	@Override
	public Article removeByFriendUrl(String friendlyURL)
		throws NoSuchArticleException {

		Article article = findByFriendUrl(friendlyURL);

		return remove(article);
	}

	/**
	 * Returns the number of articles where friendlyURL = &#63;.
	 *
	 * @param friendlyURL the friendly url
	 * @return the number of matching articles
	 */
	@Override
	public int countByFriendUrl(String friendlyURL) {
		friendlyURL = Objects.toString(friendlyURL, "");

		FinderPath finderPath = _finderPathCountByFriendUrl;

		Object[] finderArgs = new Object[] {friendlyURL};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			boolean bindFriendlyURL = false;

			if (friendlyURL.isEmpty()) {
				query.append(_FINDER_COLUMN_FRIENDURL_FRIENDLYURL_3);
			}
			else {
				bindFriendlyURL = true;

				query.append(_FINDER_COLUMN_FRIENDURL_FRIENDLYURL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFriendlyURL) {
					qPos.add(friendlyURL);
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

	private static final String _FINDER_COLUMN_FRIENDURL_FRIENDLYURL_2 =
		"article.friendlyURL = ?";

	private static final String _FINDER_COLUMN_FRIENDURL_FRIENDLYURL_3 =
		"(article.friendlyURL IS NULL OR article.friendlyURL = '')";

	private FinderPath _finderPathFetchByFriendUrlAndStatus;
	private FinderPath _finderPathCountByFriendUrlAndStatus;

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByFriendUrlAndStatus(String friendlyURL, long status)
		throws NoSuchArticleException {

		Article article = fetchByFriendUrlAndStatus(friendlyURL, status);

		if (article == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("friendlyURL=");
			msg.append(friendlyURL);

			msg.append(", status=");
			msg.append(status);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchArticleException(msg.toString());
		}

		return article;
	}

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByFriendUrlAndStatus(String friendlyURL, long status) {
		return fetchByFriendUrlAndStatus(friendlyURL, status, true);
	}

	/**
	 * Returns the article where friendlyURL = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByFriendUrlAndStatus(
		String friendlyURL, long status, boolean useFinderCache) {

		friendlyURL = Objects.toString(friendlyURL, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {friendlyURL, status};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFriendUrlAndStatus, finderArgs, this);
		}

		if (result instanceof Article) {
			Article article = (Article)result;

			if (!Objects.equals(friendlyURL, article.getFriendlyURL()) ||
				(status != article.getStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			boolean bindFriendlyURL = false;

			if (friendlyURL.isEmpty()) {
				query.append(_FINDER_COLUMN_FRIENDURLANDSTATUS_FRIENDLYURL_3);
			}
			else {
				bindFriendlyURL = true;

				query.append(_FINDER_COLUMN_FRIENDURLANDSTATUS_FRIENDLYURL_2);
			}

			query.append(_FINDER_COLUMN_FRIENDURLANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFriendlyURL) {
					qPos.add(friendlyURL);
				}

				qPos.add(status);

				List<Article> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFriendUrlAndStatus, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {friendlyURL, status};
							}

							_log.warn(
								"ArticlePersistenceImpl.fetchByFriendUrlAndStatus(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Article article = list.get(0);

					result = article;

					cacheResult(article);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByFriendUrlAndStatus, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Article)result;
		}
	}

	/**
	 * Removes the article where friendlyURL = &#63; and status = &#63; from the database.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the article that was removed
	 */
	@Override
	public Article removeByFriendUrlAndStatus(String friendlyURL, long status)
		throws NoSuchArticleException {

		Article article = findByFriendUrlAndStatus(friendlyURL, status);

		return remove(article);
	}

	/**
	 * Returns the number of articles where friendlyURL = &#63; and status = &#63;.
	 *
	 * @param friendlyURL the friendly url
	 * @param status the status
	 * @return the number of matching articles
	 */
	@Override
	public int countByFriendUrlAndStatus(String friendlyURL, long status) {
		friendlyURL = Objects.toString(friendlyURL, "");

		FinderPath finderPath = _finderPathCountByFriendUrlAndStatus;

		Object[] finderArgs = new Object[] {friendlyURL, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			boolean bindFriendlyURL = false;

			if (friendlyURL.isEmpty()) {
				query.append(_FINDER_COLUMN_FRIENDURLANDSTATUS_FRIENDLYURL_3);
			}
			else {
				bindFriendlyURL = true;

				query.append(_FINDER_COLUMN_FRIENDURLANDSTATUS_FRIENDLYURL_2);
			}

			query.append(_FINDER_COLUMN_FRIENDURLANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFriendlyURL) {
					qPos.add(friendlyURL);
				}

				qPos.add(status);

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

	private static final String
		_FINDER_COLUMN_FRIENDURLANDSTATUS_FRIENDLYURL_2 =
			"article.friendlyURL = ? AND ";

	private static final String
		_FINDER_COLUMN_FRIENDURLANDSTATUS_FRIENDLYURL_3 =
			"(article.friendlyURL IS NULL OR article.friendlyURL = '') AND ";

	private static final String _FINDER_COLUMN_FRIENDURLANDSTATUS_STATUS_2 =
		"article.status = ?";

	private FinderPath _finderPathWithPaginationFindByGroup_Language_Status;
	private FinderPath _finderPathWithoutPaginationFindByGroup_Language_Status;
	private FinderPath _finderPathCountByGroup_Language_Status;

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status(
		long groupId, String language, long status) {

		return findByGroup_Language_Status(
			groupId, language, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end) {

		return findByGroup_Language_Status(
			groupId, language, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end,
		OrderByComparator<Article> orderByComparator) {

		return findByGroup_Language_Status(
			groupId, language, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status(
		long groupId, String language, long status, int start, int end,
		OrderByComparator<Article> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Language_Status;
				finderArgs = new Object[] {groupId, language, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_Language_Status;
			finderArgs = new Object[] {
				groupId, language, status, start, end, orderByComparator
			};
		}

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if ((groupId != article.getGroupId()) ||
						!language.equals(article.getLanguage()) ||
						(status != article.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(status);

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByGroup_Language_Status_First(
			long groupId, String language, long status,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByGroup_Language_Status_First(
			groupId, language, status, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByGroup_Language_Status_First(
		long groupId, String language, long status,
		OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByGroup_Language_Status(
			groupId, language, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByGroup_Language_Status_Last(
			long groupId, String language, long status,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByGroup_Language_Status_Last(
			groupId, language, status, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByGroup_Language_Status_Last(
		long groupId, String language, long status,
		OrderByComparator<Article> orderByComparator) {

		int count = countByGroup_Language_Status(groupId, language, status);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByGroup_Language_Status(
			groupId, language, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article[] findByGroup_Language_Status_PrevAndNext(
			long articleId, long groupId, String language, long status,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		language = Objects.toString(language, "");

		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByGroup_Language_Status_PrevAndNext(
				session, article, groupId, language, status, orderByComparator,
				true);

			array[1] = article;

			array[2] = getByGroup_Language_Status_PrevAndNext(
				session, article, groupId, language, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByGroup_Language_Status_PrevAndNext(
		Session session, Article article, long groupId, String language,
		long status, OrderByComparator<Article> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_STATUS_2);

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
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(article)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 */
	@Override
	public void removeByGroup_Language_Status(
		long groupId, String language, long status) {

		for (Article article :
				findByGroup_Language_Status(
					groupId, language, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @return the number of matching articles
	 */
	@Override
	public int countByGroup_Language_Status(
		long groupId, String language, long status) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByGroup_Language_Status;

		Object[] finderArgs = new Object[] {groupId, language, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_STATUS_GROUPID_2 =
		"article.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_2 =
			"article.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_LANGUAGE_3 =
			"(article.language IS NULL OR article.language = '') AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_STATUS_STATUS_2 =
		"article.status = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Language_Status_Event;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Language_Status_Event;
	private FinderPath _finderPathCountByGroup_Language_Status_Event;

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId) {

		return findByGroup_Language_Status_Event(
			groupId, language, status, eventId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end) {

		return findByGroup_Language_Status_Event(
			groupId, language, status, eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end, OrderByComparator<Article> orderByComparator) {

		return findByGroup_Language_Status_Event(
			groupId, language, status, eventId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId, int start,
		int end, OrderByComparator<Article> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Language_Status_Event;
				finderArgs = new Object[] {groupId, language, status, eventId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Language_Status_Event;
			finderArgs = new Object[] {
				groupId, language, status, eventId, start, end,
				orderByComparator
			};
		}

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if ((groupId != article.getGroupId()) ||
						!language.equals(article.getLanguage()) ||
						(status != article.getStatus()) ||
						(eventId != article.getEventId())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_STATUS_2);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(status);

				qPos.add(eventId);

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByGroup_Language_Status_Event_First(
			long groupId, String language, long status, long eventId,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByGroup_Language_Status_Event_First(
			groupId, language, status, eventId, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", status=");
		msg.append(status);

		msg.append(", eventId=");
		msg.append(eventId);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByGroup_Language_Status_Event_First(
		long groupId, String language, long status, long eventId,
		OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByGroup_Language_Status_Event(
			groupId, language, status, eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByGroup_Language_Status_Event_Last(
			long groupId, String language, long status, long eventId,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByGroup_Language_Status_Event_Last(
			groupId, language, status, eventId, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", status=");
		msg.append(status);

		msg.append(", eventId=");
		msg.append(eventId);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByGroup_Language_Status_Event_Last(
		long groupId, String language, long status, long eventId,
		OrderByComparator<Article> orderByComparator) {

		int count = countByGroup_Language_Status_Event(
			groupId, language, status, eventId);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByGroup_Language_Status_Event(
			groupId, language, status, eventId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article[] findByGroup_Language_Status_Event_PrevAndNext(
			long articleId, long groupId, String language, long status,
			long eventId, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		language = Objects.toString(language, "");

		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByGroup_Language_Status_Event_PrevAndNext(
				session, article, groupId, language, status, eventId,
				orderByComparator, true);

			array[1] = article;

			array[2] = getByGroup_Language_Status_Event_PrevAndNext(
				session, article, groupId, language, status, eventId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByGroup_Language_Status_Event_PrevAndNext(
		Session session, Article article, long groupId, String language,
		long status, long eventId, OrderByComparator<Article> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_STATUS_2);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_EVENTID_2);

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
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(status);

		qPos.add(eventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(article)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 */
	@Override
	public void removeByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId) {

		for (Article article :
				findByGroup_Language_Status_Event(
					groupId, language, status, eventId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63; and eventId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param eventId the event ID
	 * @return the number of matching articles
	 */
	@Override
	public int countByGroup_Language_Status_Event(
		long groupId, String language, long status, long eventId) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByGroup_Language_Status_Event;

		Object[] finderArgs = new Object[] {groupId, language, status, eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_STATUS_2);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(status);

				qPos.add(eventId);

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

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_GROUPID_2 =
			"article.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_2 =
			"article.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_LANGUAGE_3 =
			"(article.language IS NULL OR article.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_STATUS_2 =
			"article.status = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_EVENT_EVENTID_2 =
			"article.eventId = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Language_Status_UserCreate;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate;
	private FinderPath _finderPathCountByGroup_Language_Status_UserCreate;

	/**
	 * Returns all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser) {

		return findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end) {

		return findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articles
	 */
	@Override
	public List<Article> findByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser,
		int start, int end, OrderByComparator<Article> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate;
				finderArgs = new Object[] {
					groupId, language, status, createdByUser
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Language_Status_UserCreate;
			finderArgs = new Object[] {
				groupId, language, status, createdByUser, start, end,
				orderByComparator
			};
		}

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Article article : list) {
					if ((groupId != article.getGroupId()) ||
						!language.equals(article.getLanguage()) ||
						(status != article.getStatus()) ||
						(createdByUser != article.getCreatedByUser())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_ARTICLE_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_STATUS_2);

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_CREATEDBYUSER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ArticleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(status);

				qPos.add(createdByUser);

				list = (List<Article>)QueryUtil.list(
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
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByGroup_Language_Status_UserCreate_First(
			long groupId, String language, long status, long createdByUser,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByGroup_Language_Status_UserCreate_First(
			groupId, language, status, createdByUser, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", status=");
		msg.append(status);

		msg.append(", createdByUser=");
		msg.append(createdByUser);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the first article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByGroup_Language_Status_UserCreate_First(
		long groupId, String language, long status, long createdByUser,
		OrderByComparator<Article> orderByComparator) {

		List<Article> list = findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article
	 * @throws NoSuchArticleException if a matching article could not be found
	 */
	@Override
	public Article findByGroup_Language_Status_UserCreate_Last(
			long groupId, String language, long status, long createdByUser,
			OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		Article article = fetchByGroup_Language_Status_UserCreate_Last(
			groupId, language, status, createdByUser, orderByComparator);

		if (article != null) {
			return article;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", status=");
		msg.append(status);

		msg.append(", createdByUser=");
		msg.append(createdByUser);

		msg.append("}");

		throw new NoSuchArticleException(msg.toString());
	}

	/**
	 * Returns the last article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article, or <code>null</code> if a matching article could not be found
	 */
	@Override
	public Article fetchByGroup_Language_Status_UserCreate_Last(
		long groupId, String language, long status, long createdByUser,
		OrderByComparator<Article> orderByComparator) {

		int count = countByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser);

		if (count == 0) {
			return null;
		}

		List<Article> list = findByGroup_Language_Status_UserCreate(
			groupId, language, status, createdByUser, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the articles before and after the current article in the ordered set where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param articleId the primary key of the current article
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article[] findByGroup_Language_Status_UserCreate_PrevAndNext(
			long articleId, long groupId, String language, long status,
			long createdByUser, OrderByComparator<Article> orderByComparator)
		throws NoSuchArticleException {

		language = Objects.toString(language, "");

		Article article = findByPrimaryKey(articleId);

		Session session = null;

		try {
			session = openSession();

			Article[] array = new ArticleImpl[3];

			array[0] = getByGroup_Language_Status_UserCreate_PrevAndNext(
				session, article, groupId, language, status, createdByUser,
				orderByComparator, true);

			array[1] = article;

			array[2] = getByGroup_Language_Status_UserCreate_PrevAndNext(
				session, article, groupId, language, status, createdByUser,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Article getByGroup_Language_Status_UserCreate_PrevAndNext(
		Session session, Article article, long groupId, String language,
		long status, long createdByUser,
		OrderByComparator<Article> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_ARTICLE_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_STATUS_2);

		query.append(
			_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_CREATEDBYUSER_2);

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
			query.append(ArticleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(status);

		qPos.add(createdByUser);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(article)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Article> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 */
	@Override
	public void removeByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser) {

		for (Article article :
				findByGroup_Language_Status_UserCreate(
					groupId, language, status, createdByUser, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(article);
		}
	}

	/**
	 * Returns the number of articles where groupId = &#63; and language = &#63; and status = &#63; and createdByUser = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param status the status
	 * @param createdByUser the created by user
	 * @return the number of matching articles
	 */
	@Override
	public int countByGroup_Language_Status_UserCreate(
		long groupId, String language, long status, long createdByUser) {

		language = Objects.toString(language, "");

		FinderPath finderPath =
			_finderPathCountByGroup_Language_Status_UserCreate;

		Object[] finderArgs = new Object[] {
			groupId, language, status, createdByUser
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_ARTICLE_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_STATUS_2);

			query.append(
				_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_CREATEDBYUSER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(status);

				qPos.add(createdByUser);

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

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_GROUPID_2 =
			"article.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_2 =
			"article.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_LANGUAGE_3 =
			"(article.language IS NULL OR article.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_STATUS_2 =
			"article.status = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_STATUS_USERCREATE_CREATEDBYUSER_2 =
			"article.createdByUser = ?";

	public ArticlePersistenceImpl() {
		setModelClass(Article.class);

		setModelImplClass(ArticleImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the article in the entity cache if it is enabled.
	 *
	 * @param article the article
	 */
	@Override
	public void cacheResult(Article article) {
		entityCache.putResult(
			entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey(),
			article);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {article.getUuid(), article.getGroupId()}, article);

		finderCache.putResult(
			_finderPathFetchByFriendUrl,
			new Object[] {article.getFriendlyURL()}, article);

		finderCache.putResult(
			_finderPathFetchByFriendUrlAndStatus,
			new Object[] {article.getFriendlyURL(), article.getStatus()},
			article);

		article.resetOriginalValues();
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	@Override
	public void cacheResult(List<Article> articles) {
		for (Article article : articles) {
			if (entityCache.getResult(
					entityCacheEnabled, ArticleImpl.class,
					article.getPrimaryKey()) == null) {

				cacheResult(article);
			}
			else {
				article.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all articles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Article article) {
		entityCache.removeResult(
			entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ArticleModelImpl)article, true);
	}

	@Override
	public void clearCache(List<Article> articles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Article article : articles) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey());

			clearUniqueFindersCache((ArticleModelImpl)article, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ArticleModelImpl articleModelImpl) {
		Object[] args = new Object[] {
			articleModelImpl.getUuid(), articleModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, articleModelImpl, false);

		args = new Object[] {articleModelImpl.getFriendlyURL()};

		finderCache.putResult(
			_finderPathCountByFriendUrl, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByFriendUrl, args, articleModelImpl, false);

		args = new Object[] {
			articleModelImpl.getFriendlyURL(), articleModelImpl.getStatus()
		};

		finderCache.putResult(
			_finderPathCountByFriendUrlAndStatus, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByFriendUrlAndStatus, args, articleModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		ArticleModelImpl articleModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				articleModelImpl.getUuid(), articleModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((articleModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				articleModelImpl.getOriginalUuid(),
				articleModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {articleModelImpl.getFriendlyURL()};

			finderCache.removeResult(_finderPathCountByFriendUrl, args);
			finderCache.removeResult(_finderPathFetchByFriendUrl, args);
		}

		if ((articleModelImpl.getColumnBitmask() &
			 _finderPathFetchByFriendUrl.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				articleModelImpl.getOriginalFriendlyURL()
			};

			finderCache.removeResult(_finderPathCountByFriendUrl, args);
			finderCache.removeResult(_finderPathFetchByFriendUrl, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				articleModelImpl.getFriendlyURL(), articleModelImpl.getStatus()
			};

			finderCache.removeResult(
				_finderPathCountByFriendUrlAndStatus, args);
			finderCache.removeResult(
				_finderPathFetchByFriendUrlAndStatus, args);
		}

		if ((articleModelImpl.getColumnBitmask() &
			 _finderPathFetchByFriendUrlAndStatus.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				articleModelImpl.getOriginalFriendlyURL(),
				articleModelImpl.getOriginalStatus()
			};

			finderCache.removeResult(
				_finderPathCountByFriendUrlAndStatus, args);
			finderCache.removeResult(
				_finderPathFetchByFriendUrlAndStatus, args);
		}
	}

	/**
	 * Creates a new article with the primary key. Does not add the article to the database.
	 *
	 * @param articleId the primary key for the new article
	 * @return the new article
	 */
	@Override
	public Article create(long articleId) {
		Article article = new ArticleImpl();

		article.setNew(true);
		article.setPrimaryKey(articleId);

		String uuid = PortalUUIDUtil.generate();

		article.setUuid(uuid);

		return article;
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article remove(long articleId) throws NoSuchArticleException {
		return remove((Serializable)articleId);
	}

	/**
	 * Removes the article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article that was removed
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article remove(Serializable primaryKey)
		throws NoSuchArticleException {

		Session session = null;

		try {
			session = openSession();

			Article article = (Article)session.get(
				ArticleImpl.class, primaryKey);

			if (article == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(article);
		}
		catch (NoSuchArticleException noSuchEntityException) {
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
	protected Article removeImpl(Article article) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(article)) {
				article = (Article)session.get(
					ArticleImpl.class, article.getPrimaryKeyObj());
			}

			if (article != null) {
				session.delete(article);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (article != null) {
			clearCache(article);
		}

		return article;
	}

	@Override
	public Article updateImpl(Article article) {
		boolean isNew = article.isNew();

		if (!(article instanceof ArticleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(article.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(article);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in article proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Article implementation " +
					article.getClass());
		}

		ArticleModelImpl articleModelImpl = (ArticleModelImpl)article;

		if (Validator.isNull(article.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			article.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (article.isNew()) {
				session.save(article);

				article.setNew(false);
			}
			else {
				article = (Article)session.merge(article);
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
			Object[] args = new Object[] {articleModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				articleModelImpl.getGroupId(), articleModelImpl.getLanguage(),
				articleModelImpl.getStatus()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Language_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language_Status, args);

			args = new Object[] {
				articleModelImpl.getGroupId(), articleModelImpl.getLanguage(),
				articleModelImpl.getStatus(), articleModelImpl.getEventId()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Language_Status_Event, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language_Status_Event,
				args);

			args = new Object[] {
				articleModelImpl.getGroupId(), articleModelImpl.getLanguage(),
				articleModelImpl.getStatus(),
				articleModelImpl.getCreatedByUser()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Language_Status_UserCreate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((articleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					articleModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {articleModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((articleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					articleModelImpl.getOriginalGroupId(),
					articleModelImpl.getOriginalLanguage(),
					articleModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Status,
					args);

				args = new Object[] {
					articleModelImpl.getGroupId(),
					articleModelImpl.getLanguage(), articleModelImpl.getStatus()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Status,
					args);
			}

			if ((articleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language_Status_Event.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					articleModelImpl.getOriginalGroupId(),
					articleModelImpl.getOriginalLanguage(),
					articleModelImpl.getOriginalStatus(),
					articleModelImpl.getOriginalEventId()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Status_Event, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Status_Event,
					args);

				args = new Object[] {
					articleModelImpl.getGroupId(),
					articleModelImpl.getLanguage(),
					articleModelImpl.getStatus(), articleModelImpl.getEventId()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Status_Event, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Status_Event,
					args);
			}

			if ((articleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					articleModelImpl.getOriginalGroupId(),
					articleModelImpl.getOriginalLanguage(),
					articleModelImpl.getOriginalStatus(),
					articleModelImpl.getOriginalCreatedByUser()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Status_UserCreate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate,
					args);

				args = new Object[] {
					articleModelImpl.getGroupId(),
					articleModelImpl.getLanguage(),
					articleModelImpl.getStatus(),
					articleModelImpl.getCreatedByUser()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Status_UserCreate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ArticleImpl.class, article.getPrimaryKey(),
			article, false);

		clearUniqueFindersCache(articleModelImpl, false);
		cacheUniqueFindersCache(articleModelImpl);

		article.resetOriginalValues();

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleException {

		Article article = fetchByPrimaryKey(primaryKey);

		if (article == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return article;
	}

	/**
	 * Returns the article with the primary key or throws a <code>NoSuchArticleException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article
	 * @throws NoSuchArticleException if a article with the primary key could not be found
	 */
	@Override
	public Article findByPrimaryKey(long articleId)
		throws NoSuchArticleException {

		return findByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns the article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the article
	 * @return the article, or <code>null</code> if a article with the primary key could not be found
	 */
	@Override
	public Article fetchByPrimaryKey(long articleId) {
		return fetchByPrimaryKey((Serializable)articleId);
	}

	/**
	 * Returns all the articles.
	 *
	 * @return the articles
	 */
	@Override
	public List<Article> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @return the range of articles
	 */
	@Override
	public List<Article> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articles
	 */
	@Override
	public List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articles
	 * @param end the upper bound of the range of articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of articles
	 */
	@Override
	public List<Article> findAll(
		int start, int end, OrderByComparator<Article> orderByComparator,
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

		List<Article> list = null;

		if (useFinderCache) {
			list = (List<Article>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ARTICLE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLE;

				sql = sql.concat(ArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Article>)QueryUtil.list(
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
	 * Removes all the articles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Article article : findAll()) {
			remove(article);
		}
	}

	/**
	 * Returns the number of articles.
	 *
	 * @return the number of articles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLE);

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
		return "articleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ARTICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ArticleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article persistence.
	 */
	@Activate
	public void activate() {
		ArticleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ArticleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ArticleModelImpl.UUID_COLUMN_BITMASK |
			ArticleModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ArticleModelImpl.UUID_COLUMN_BITMASK |
			ArticleModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByFriendUrl = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFriendUrl",
			new String[] {String.class.getName()},
			ArticleModelImpl.FRIENDLYURL_COLUMN_BITMASK);

		_finderPathCountByFriendUrl = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFriendUrl",
			new String[] {String.class.getName()});

		_finderPathFetchByFriendUrlAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFriendUrlAndStatus",
			new String[] {String.class.getName(), Long.class.getName()},
			ArticleModelImpl.FRIENDLYURL_COLUMN_BITMASK |
			ArticleModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByFriendUrlAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFriendUrlAndStatus",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroup_Language_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup_Language_Status",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_Language_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Language_Status",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				ArticleModelImpl.GROUPID_COLUMN_BITMASK |
				ArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
				ArticleModelImpl.STATUS_COLUMN_BITMASK |
				ArticleModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Language_Status",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Language_Status_Event =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Language_Status_Event",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Language_Status_Event =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Language_Status_Event",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Long.class.getName()
				},
				ArticleModelImpl.GROUPID_COLUMN_BITMASK |
				ArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
				ArticleModelImpl.STATUS_COLUMN_BITMASK |
				ArticleModelImpl.EVENTID_COLUMN_BITMASK |
				ArticleModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language_Status_Event = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Language_Status_Event",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Language_Status_UserCreate =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Language_Status_UserCreate",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Language_Status_UserCreate =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, ArticleImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Language_Status_UserCreate",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Long.class.getName()
				},
				ArticleModelImpl.GROUPID_COLUMN_BITMASK |
				ArticleModelImpl.LANGUAGE_COLUMN_BITMASK |
				ArticleModelImpl.STATUS_COLUMN_BITMASK |
				ArticleModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
				ArticleModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language_Status_UserCreate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Language_Status_UserCreate",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ArticleImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.Article"),
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

	private static final String _SQL_SELECT_ARTICLE =
		"SELECT article FROM Article article";

	private static final String _SQL_SELECT_ARTICLE_WHERE =
		"SELECT article FROM Article article WHERE ";

	private static final String _SQL_COUNT_ARTICLE =
		"SELECT COUNT(article) FROM Article article";

	private static final String _SQL_COUNT_ARTICLE_WHERE =
		"SELECT COUNT(article) FROM Article article WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "article.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Article exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Article exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ArticlePersistenceImpl.class);

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