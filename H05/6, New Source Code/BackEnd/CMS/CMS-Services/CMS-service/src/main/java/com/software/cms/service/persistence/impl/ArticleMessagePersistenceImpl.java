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

import com.software.cms.exception.NoSuchArticleMessageException;
import com.software.cms.model.ArticleMessage;
import com.software.cms.model.impl.ArticleMessageImpl;
import com.software.cms.model.impl.ArticleMessageModelImpl;
import com.software.cms.service.persistence.ArticleMessagePersistence;
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
 * The persistence implementation for the article message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = ArticleMessagePersistence.class)
public class ArticleMessagePersistenceImpl
	extends BasePersistenceImpl<ArticleMessage>
	implements ArticleMessagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ArticleMessageUtil</code> to access the article message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ArticleMessageImpl.class.getName();

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
	 * Returns all the article messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article messages
	 */
	@Override
	public List<ArticleMessage> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the article messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of matching article messages
	 */
	@Override
	public List<ArticleMessage> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the article messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article messages
	 */
	@Override
	public List<ArticleMessage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the article messages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article messages
	 */
	@Override
	public List<ArticleMessage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator,
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

		List<ArticleMessage> list = null;

		if (useFinderCache) {
			list = (List<ArticleMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ArticleMessage articleMessage : list) {
					if (!uuid.equals(articleMessage.getUuid())) {
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

			query.append(_SQL_SELECT_ARTICLEMESSAGE_WHERE);

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
				query.append(ArticleMessageModelImpl.ORDER_BY_JPQL);
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

				list = (List<ArticleMessage>)QueryUtil.list(
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
	 * Returns the first article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	@Override
	public ArticleMessage findByUuid_First(
			String uuid, OrderByComparator<ArticleMessage> orderByComparator)
		throws NoSuchArticleMessageException {

		ArticleMessage articleMessage = fetchByUuid_First(
			uuid, orderByComparator);

		if (articleMessage != null) {
			return articleMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleMessageException(msg.toString());
	}

	/**
	 * Returns the first article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message, or <code>null</code> if a matching article message could not be found
	 */
	@Override
	public ArticleMessage fetchByUuid_First(
		String uuid, OrderByComparator<ArticleMessage> orderByComparator) {

		List<ArticleMessage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	@Override
	public ArticleMessage findByUuid_Last(
			String uuid, OrderByComparator<ArticleMessage> orderByComparator)
		throws NoSuchArticleMessageException {

		ArticleMessage articleMessage = fetchByUuid_Last(
			uuid, orderByComparator);

		if (articleMessage != null) {
			return articleMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleMessageException(msg.toString());
	}

	/**
	 * Returns the last article message in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message, or <code>null</code> if a matching article message could not be found
	 */
	@Override
	public ArticleMessage fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleMessage> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ArticleMessage> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the article messages before and after the current article message in the ordered set where uuid = &#63;.
	 *
	 * @param messageId the primary key of the current article message
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage[] findByUuid_PrevAndNext(
			long messageId, String uuid,
			OrderByComparator<ArticleMessage> orderByComparator)
		throws NoSuchArticleMessageException {

		uuid = Objects.toString(uuid, "");

		ArticleMessage articleMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			ArticleMessage[] array = new ArticleMessageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, articleMessage, uuid, orderByComparator, true);

			array[1] = articleMessage;

			array[2] = getByUuid_PrevAndNext(
				session, articleMessage, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleMessage getByUuid_PrevAndNext(
		Session session, ArticleMessage articleMessage, String uuid,
		OrderByComparator<ArticleMessage> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLEMESSAGE_WHERE);

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
			query.append(ArticleMessageModelImpl.ORDER_BY_JPQL);
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
						articleMessage)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ArticleMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the article messages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ArticleMessage articleMessage :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(articleMessage);
		}
	}

	/**
	 * Returns the number of article messages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article messages
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLEMESSAGE_WHERE);

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
		"articleMessage.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(articleMessage.uuid IS NULL OR articleMessage.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByArticle;
	private FinderPath _finderPathWithoutPaginationFindByArticle;
	private FinderPath _finderPathCountByArticle;

	/**
	 * Returns all the article messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching article messages
	 */
	@Override
	public List<ArticleMessage> findByArticle(long articleId) {
		return findByArticle(
			articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the article messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of matching article messages
	 */
	@Override
	public List<ArticleMessage> findByArticle(
		long articleId, int start, int end) {

		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the article messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article messages
	 */
	@Override
	public List<ArticleMessage> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return findByArticle(articleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the article messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article messages
	 */
	@Override
	public List<ArticleMessage> findByArticle(
		long articleId, int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator,
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

		List<ArticleMessage> list = null;

		if (useFinderCache) {
			list = (List<ArticleMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ArticleMessage articleMessage : list) {
					if (articleId != articleMessage.getArticleId()) {
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

			query.append(_SQL_SELECT_ARTICLEMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ArticleMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articleId);

				list = (List<ArticleMessage>)QueryUtil.list(
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
	 * Returns the first article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	@Override
	public ArticleMessage findByArticle_First(
			long articleId, OrderByComparator<ArticleMessage> orderByComparator)
		throws NoSuchArticleMessageException {

		ArticleMessage articleMessage = fetchByArticle_First(
			articleId, orderByComparator);

		if (articleMessage != null) {
			return articleMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchArticleMessageException(msg.toString());
	}

	/**
	 * Returns the first article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article message, or <code>null</code> if a matching article message could not be found
	 */
	@Override
	public ArticleMessage fetchByArticle_First(
		long articleId, OrderByComparator<ArticleMessage> orderByComparator) {

		List<ArticleMessage> list = findByArticle(
			articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message
	 * @throws NoSuchArticleMessageException if a matching article message could not be found
	 */
	@Override
	public ArticleMessage findByArticle_Last(
			long articleId, OrderByComparator<ArticleMessage> orderByComparator)
		throws NoSuchArticleMessageException {

		ArticleMessage articleMessage = fetchByArticle_Last(
			articleId, orderByComparator);

		if (articleMessage != null) {
			return articleMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchArticleMessageException(msg.toString());
	}

	/**
	 * Returns the last article message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article message, or <code>null</code> if a matching article message could not be found
	 */
	@Override
	public ArticleMessage fetchByArticle_Last(
		long articleId, OrderByComparator<ArticleMessage> orderByComparator) {

		int count = countByArticle(articleId);

		if (count == 0) {
			return null;
		}

		List<ArticleMessage> list = findByArticle(
			articleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the article messages before and after the current article message in the ordered set where articleId = &#63;.
	 *
	 * @param messageId the primary key of the current article message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage[] findByArticle_PrevAndNext(
			long messageId, long articleId,
			OrderByComparator<ArticleMessage> orderByComparator)
		throws NoSuchArticleMessageException {

		ArticleMessage articleMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			ArticleMessage[] array = new ArticleMessageImpl[3];

			array[0] = getByArticle_PrevAndNext(
				session, articleMessage, articleId, orderByComparator, true);

			array[1] = articleMessage;

			array[2] = getByArticle_PrevAndNext(
				session, articleMessage, articleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleMessage getByArticle_PrevAndNext(
		Session session, ArticleMessage articleMessage, long articleId,
		OrderByComparator<ArticleMessage> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ARTICLEMESSAGE_WHERE);

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
			query.append(ArticleMessageModelImpl.ORDER_BY_JPQL);
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
						articleMessage)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ArticleMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the article messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	@Override
	public void removeByArticle(long articleId) {
		for (ArticleMessage articleMessage :
				findByArticle(
					articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(articleMessage);
		}
	}

	/**
	 * Returns the number of article messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching article messages
	 */
	@Override
	public int countByArticle(long articleId) {
		FinderPath finderPath = _finderPathCountByArticle;

		Object[] finderArgs = new Object[] {articleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLEMESSAGE_WHERE);

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
		"articleMessage.articleId = ?";

	public ArticleMessagePersistenceImpl() {
		setModelClass(ArticleMessage.class);

		setModelImplClass(ArticleMessageImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the article message in the entity cache if it is enabled.
	 *
	 * @param articleMessage the article message
	 */
	@Override
	public void cacheResult(ArticleMessage articleMessage) {
		entityCache.putResult(
			entityCacheEnabled, ArticleMessageImpl.class,
			articleMessage.getPrimaryKey(), articleMessage);

		articleMessage.resetOriginalValues();
	}

	/**
	 * Caches the article messages in the entity cache if it is enabled.
	 *
	 * @param articleMessages the article messages
	 */
	@Override
	public void cacheResult(List<ArticleMessage> articleMessages) {
		for (ArticleMessage articleMessage : articleMessages) {
			if (entityCache.getResult(
					entityCacheEnabled, ArticleMessageImpl.class,
					articleMessage.getPrimaryKey()) == null) {

				cacheResult(articleMessage);
			}
			else {
				articleMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all article messages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleMessageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article message.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ArticleMessage articleMessage) {
		entityCache.removeResult(
			entityCacheEnabled, ArticleMessageImpl.class,
			articleMessage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ArticleMessage> articleMessages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ArticleMessage articleMessage : articleMessages) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleMessageImpl.class,
				articleMessage.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleMessageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new article message with the primary key. Does not add the article message to the database.
	 *
	 * @param messageId the primary key for the new article message
	 * @return the new article message
	 */
	@Override
	public ArticleMessage create(long messageId) {
		ArticleMessage articleMessage = new ArticleMessageImpl();

		articleMessage.setNew(true);
		articleMessage.setPrimaryKey(messageId);

		String uuid = PortalUUIDUtil.generate();

		articleMessage.setUuid(uuid);

		return articleMessage;
	}

	/**
	 * Removes the article message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message that was removed
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage remove(long messageId)
		throws NoSuchArticleMessageException {

		return remove((Serializable)messageId);
	}

	/**
	 * Removes the article message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article message
	 * @return the article message that was removed
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage remove(Serializable primaryKey)
		throws NoSuchArticleMessageException {

		Session session = null;

		try {
			session = openSession();

			ArticleMessage articleMessage = (ArticleMessage)session.get(
				ArticleMessageImpl.class, primaryKey);

			if (articleMessage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleMessageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(articleMessage);
		}
		catch (NoSuchArticleMessageException noSuchEntityException) {
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
	protected ArticleMessage removeImpl(ArticleMessage articleMessage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(articleMessage)) {
				articleMessage = (ArticleMessage)session.get(
					ArticleMessageImpl.class,
					articleMessage.getPrimaryKeyObj());
			}

			if (articleMessage != null) {
				session.delete(articleMessage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (articleMessage != null) {
			clearCache(articleMessage);
		}

		return articleMessage;
	}

	@Override
	public ArticleMessage updateImpl(ArticleMessage articleMessage) {
		boolean isNew = articleMessage.isNew();

		if (!(articleMessage instanceof ArticleMessageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(articleMessage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					articleMessage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in articleMessage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ArticleMessage implementation " +
					articleMessage.getClass());
		}

		ArticleMessageModelImpl articleMessageModelImpl =
			(ArticleMessageModelImpl)articleMessage;

		if (Validator.isNull(articleMessage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			articleMessage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (articleMessage.isNew()) {
				session.save(articleMessage);

				articleMessage.setNew(false);
			}
			else {
				articleMessage = (ArticleMessage)session.merge(articleMessage);
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
			Object[] args = new Object[] {articleMessageModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {articleMessageModelImpl.getArticleId()};

			finderCache.removeResult(_finderPathCountByArticle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByArticle, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((articleMessageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					articleMessageModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {articleMessageModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((articleMessageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByArticle.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					articleMessageModelImpl.getOriginalArticleId()
				};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);

				args = new Object[] {articleMessageModelImpl.getArticleId()};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ArticleMessageImpl.class,
			articleMessage.getPrimaryKey(), articleMessage, false);

		articleMessage.resetOriginalValues();

		return articleMessage;
	}

	/**
	 * Returns the article message with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article message
	 * @return the article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleMessageException {

		ArticleMessage articleMessage = fetchByPrimaryKey(primaryKey);

		if (articleMessage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleMessageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return articleMessage;
	}

	/**
	 * Returns the article message with the primary key or throws a <code>NoSuchArticleMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message
	 * @throws NoSuchArticleMessageException if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage findByPrimaryKey(long messageId)
		throws NoSuchArticleMessageException {

		return findByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns the article message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the article message
	 * @return the article message, or <code>null</code> if a article message with the primary key could not be found
	 */
	@Override
	public ArticleMessage fetchByPrimaryKey(long messageId) {
		return fetchByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns all the article messages.
	 *
	 * @return the article messages
	 */
	@Override
	public List<ArticleMessage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @return the range of article messages
	 */
	@Override
	public List<ArticleMessage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article messages
	 */
	@Override
	public List<ArticleMessage> findAll(
		int start, int end,
		OrderByComparator<ArticleMessage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the article messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article messages
	 * @param end the upper bound of the range of article messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article messages
	 */
	@Override
	public List<ArticleMessage> findAll(
		int start, int end, OrderByComparator<ArticleMessage> orderByComparator,
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

		List<ArticleMessage> list = null;

		if (useFinderCache) {
			list = (List<ArticleMessage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ARTICLEMESSAGE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLEMESSAGE;

				sql = sql.concat(ArticleMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ArticleMessage>)QueryUtil.list(
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
	 * Removes all the article messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ArticleMessage articleMessage : findAll()) {
			remove(articleMessage);
		}
	}

	/**
	 * Returns the number of article messages.
	 *
	 * @return the number of article messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLEMESSAGE);

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
		return "messageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ARTICLEMESSAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ArticleMessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article message persistence.
	 */
	@Activate
	public void activate() {
		ArticleMessageModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ArticleMessageModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ArticleMessageModelImpl.UUID_COLUMN_BITMASK |
			ArticleMessageModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] {Long.class.getName()},
			ArticleMessageModelImpl.ARTICLEID_COLUMN_BITMASK |
			ArticleMessageModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ArticleMessageImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.ArticleMessage"),
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

	private static final String _SQL_SELECT_ARTICLEMESSAGE =
		"SELECT articleMessage FROM ArticleMessage articleMessage";

	private static final String _SQL_SELECT_ARTICLEMESSAGE_WHERE =
		"SELECT articleMessage FROM ArticleMessage articleMessage WHERE ";

	private static final String _SQL_COUNT_ARTICLEMESSAGE =
		"SELECT COUNT(articleMessage) FROM ArticleMessage articleMessage";

	private static final String _SQL_COUNT_ARTICLEMESSAGE_WHERE =
		"SELECT COUNT(articleMessage) FROM ArticleMessage articleMessage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "articleMessage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ArticleMessage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ArticleMessage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ArticleMessagePersistenceImpl.class);

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