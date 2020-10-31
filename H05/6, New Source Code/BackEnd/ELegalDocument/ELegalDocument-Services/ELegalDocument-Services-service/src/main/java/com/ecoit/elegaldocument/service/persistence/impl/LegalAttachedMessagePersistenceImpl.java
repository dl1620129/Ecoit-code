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

package com.ecoit.elegaldocument.service.persistence.impl;

import com.ecoit.elegaldocument.exception.NoSuchLegalAttachedMessageException;
import com.ecoit.elegaldocument.model.LegalAttachedMessage;
import com.ecoit.elegaldocument.model.impl.LegalAttachedMessageImpl;
import com.ecoit.elegaldocument.model.impl.LegalAttachedMessageModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalAttachedMessagePersistence;
import com.ecoit.elegaldocument.service.persistence.impl.constants.ecoit_docPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the legal attached message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalAttachedMessagePersistence.class)
public class LegalAttachedMessagePersistenceImpl
	extends BasePersistenceImpl<LegalAttachedMessage>
	implements LegalAttachedMessagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalAttachedMessageUtil</code> to access the legal attached message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalAttachedMessageImpl.class.getName();

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
	 * Returns all the legal attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByArticle(String articleId) {
		return findByArticle(
			articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end) {

		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return findByArticle(articleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByArticle(
		String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		articleId = Objects.toString(articleId, "");

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

		List<LegalAttachedMessage> list = null;

		if (useFinderCache) {
			list = (List<LegalAttachedMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalAttachedMessage legalAttachedMessage : list) {
					if (!articleId.equals(
							legalAttachedMessage.getArticleId())) {

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

			query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

			boolean bindArticleId = false;

			if (articleId.isEmpty()) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArticleId) {
					qPos.add(articleId);
				}

				list = (List<LegalAttachedMessage>)QueryUtil.list(
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
	 * Returns the first legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByArticle_First(
			String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByArticle_First(
			articleId, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByArticle_First(
		String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		List<LegalAttachedMessage> list = findByArticle(
			articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByArticle_Last(
			String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByArticle_Last(
			articleId, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByArticle_Last(
		String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		int count = countByArticle(articleId);

		if (count == 0) {
			return null;
		}

		List<LegalAttachedMessage> list = findByArticle(
			articleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where articleId = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage[] findByArticle_PrevAndNext(
			String messageId, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		articleId = Objects.toString(articleId, "");

		LegalAttachedMessage legalAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			LegalAttachedMessage[] array = new LegalAttachedMessageImpl[3];

			array[0] = getByArticle_PrevAndNext(
				session, legalAttachedMessage, articleId, orderByComparator,
				true);

			array[1] = legalAttachedMessage;

			array[2] = getByArticle_PrevAndNext(
				session, legalAttachedMessage, articleId, orderByComparator,
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

	protected LegalAttachedMessage getByArticle_PrevAndNext(
		Session session, LegalAttachedMessage legalAttachedMessage,
		String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

		boolean bindArticleId = false;

		if (articleId.isEmpty()) {
			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
		}
		else {
			bindArticleId = true;

			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
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
			query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindArticleId) {
			qPos.add(articleId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalAttachedMessage)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal attached messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	@Override
	public void removeByArticle(String articleId) {
		for (LegalAttachedMessage legalAttachedMessage :
				findByArticle(
					articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalAttachedMessage);
		}
	}

	/**
	 * Returns the number of legal attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching legal attached messages
	 */
	@Override
	public int countByArticle(String articleId) {
		articleId = Objects.toString(articleId, "");

		FinderPath finderPath = _finderPathCountByArticle;

		Object[] finderArgs = new Object[] {articleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALATTACHEDMESSAGE_WHERE);

			boolean bindArticleId = false;

			if (articleId.isEmpty()) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArticleId) {
					qPos.add(articleId);
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

	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 =
		"legalAttachedMessage.articleId = ?";

	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 =
		"(legalAttachedMessage.articleId IS NULL OR legalAttachedMessage.articleId = '')";

	private FinderPath _finderPathWithPaginationFindByUnRead;
	private FinderPath _finderPathWithoutPaginationFindByUnRead;
	private FinderPath _finderPathCountByUnRead;

	/**
	 * Returns all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @return the matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId) {

		return findByUnRead(
			readMessage, articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end) {

		return findByUnRead(readMessage, articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return findByUnRead(
			readMessage, articleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByUnRead(
		boolean readMessage, String articleId, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		articleId = Objects.toString(articleId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUnRead;
				finderArgs = new Object[] {readMessage, articleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUnRead;
			finderArgs = new Object[] {
				readMessage, articleId, start, end, orderByComparator
			};
		}

		List<LegalAttachedMessage> list = null;

		if (useFinderCache) {
			list = (List<LegalAttachedMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalAttachedMessage legalAttachedMessage : list) {
					if ((readMessage != legalAttachedMessage.isReadMessage()) ||
						!articleId.equals(
							legalAttachedMessage.getArticleId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_UNREAD_READMESSAGE_2);

			boolean bindArticleId = false;

			if (articleId.isEmpty()) {
				query.append(_FINDER_COLUMN_UNREAD_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_UNREAD_ARTICLEID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(readMessage);

				if (bindArticleId) {
					qPos.add(articleId);
				}

				list = (List<LegalAttachedMessage>)QueryUtil.list(
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
	 * Returns the first legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByUnRead_First(
			boolean readMessage, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByUnRead_First(
			readMessage, articleId, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("readMessage=");
		msg.append(readMessage);

		msg.append(", articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the first legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByUnRead_First(
		boolean readMessage, String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		List<LegalAttachedMessage> list = findByUnRead(
			readMessage, articleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByUnRead_Last(
			boolean readMessage, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByUnRead_Last(
			readMessage, articleId, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("readMessage=");
		msg.append(readMessage);

		msg.append(", articleId=");
		msg.append(articleId);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the last legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByUnRead_Last(
		boolean readMessage, String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		int count = countByUnRead(readMessage, articleId);

		if (count == 0) {
			return null;
		}

		List<LegalAttachedMessage> list = findByUnRead(
			readMessage, articleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage[] findByUnRead_PrevAndNext(
			String messageId, boolean readMessage, String articleId,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		articleId = Objects.toString(articleId, "");

		LegalAttachedMessage legalAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			LegalAttachedMessage[] array = new LegalAttachedMessageImpl[3];

			array[0] = getByUnRead_PrevAndNext(
				session, legalAttachedMessage, readMessage, articleId,
				orderByComparator, true);

			array[1] = legalAttachedMessage;

			array[2] = getByUnRead_PrevAndNext(
				session, legalAttachedMessage, readMessage, articleId,
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

	protected LegalAttachedMessage getByUnRead_PrevAndNext(
		Session session, LegalAttachedMessage legalAttachedMessage,
		boolean readMessage, String articleId,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_UNREAD_READMESSAGE_2);

		boolean bindArticleId = false;

		if (articleId.isEmpty()) {
			query.append(_FINDER_COLUMN_UNREAD_ARTICLEID_3);
		}
		else {
			bindArticleId = true;

			query.append(_FINDER_COLUMN_UNREAD_ARTICLEID_2);
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
			query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(readMessage);

		if (bindArticleId) {
			qPos.add(articleId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalAttachedMessage)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal attached messages where readMessage = &#63; and articleId = &#63; from the database.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 */
	@Override
	public void removeByUnRead(boolean readMessage, String articleId) {
		for (LegalAttachedMessage legalAttachedMessage :
				findByUnRead(
					readMessage, articleId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalAttachedMessage);
		}
	}

	/**
	 * Returns the number of legal attached messages where readMessage = &#63; and articleId = &#63;.
	 *
	 * @param readMessage the read message
	 * @param articleId the article ID
	 * @return the number of matching legal attached messages
	 */
	@Override
	public int countByUnRead(boolean readMessage, String articleId) {
		articleId = Objects.toString(articleId, "");

		FinderPath finderPath = _finderPathCountByUnRead;

		Object[] finderArgs = new Object[] {readMessage, articleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_UNREAD_READMESSAGE_2);

			boolean bindArticleId = false;

			if (articleId.isEmpty()) {
				query.append(_FINDER_COLUMN_UNREAD_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_UNREAD_ARTICLEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(readMessage);

				if (bindArticleId) {
					qPos.add(articleId);
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

	private static final String _FINDER_COLUMN_UNREAD_READMESSAGE_2 =
		"legalAttachedMessage.readMessage = ? AND ";

	private static final String _FINDER_COLUMN_UNREAD_ARTICLEID_2 =
		"legalAttachedMessage.articleId = ?";

	private static final String _FINDER_COLUMN_UNREAD_ARTICLEID_3 =
		"(legalAttachedMessage.articleId IS NULL OR legalAttachedMessage.articleId = '')";

	private FinderPath _finderPathWithPaginationFindByA_R;
	private FinderPath _finderPathWithoutPaginationFindByA_R;
	private FinderPath _finderPathCountByA_R;

	/**
	 * Returns all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage) {

		return findByA_R(
			articleId, readMessage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end) {

		return findByA_R(articleId, readMessage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return findByA_R(
			articleId, readMessage, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByA_R(
		String articleId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		articleId = Objects.toString(articleId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByA_R;
				finderArgs = new Object[] {articleId, readMessage};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByA_R;
			finderArgs = new Object[] {
				articleId, readMessage, start, end, orderByComparator
			};
		}

		List<LegalAttachedMessage> list = null;

		if (useFinderCache) {
			list = (List<LegalAttachedMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalAttachedMessage legalAttachedMessage : list) {
					if (!articleId.equals(
							legalAttachedMessage.getArticleId()) ||
						(readMessage != legalAttachedMessage.isReadMessage())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

			boolean bindArticleId = false;

			if (articleId.isEmpty()) {
				query.append(_FINDER_COLUMN_A_R_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_A_R_ARTICLEID_2);
			}

			query.append(_FINDER_COLUMN_A_R_READMESSAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArticleId) {
					qPos.add(articleId);
				}

				qPos.add(readMessage);

				list = (List<LegalAttachedMessage>)QueryUtil.list(
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
	 * Returns the first legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByA_R_First(
			String articleId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByA_R_First(
			articleId, readMessage, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append(", readMessage=");
		msg.append(readMessage);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the first legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByA_R_First(
		String articleId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		List<LegalAttachedMessage> list = findByA_R(
			articleId, readMessage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByA_R_Last(
			String articleId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByA_R_Last(
			articleId, readMessage, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append(", readMessage=");
		msg.append(readMessage);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the last legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByA_R_Last(
		String articleId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		int count = countByA_R(articleId, readMessage);

		if (count == 0) {
			return null;
		}

		List<LegalAttachedMessage> list = findByA_R(
			articleId, readMessage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage[] findByA_R_PrevAndNext(
			String messageId, String articleId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		articleId = Objects.toString(articleId, "");

		LegalAttachedMessage legalAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			LegalAttachedMessage[] array = new LegalAttachedMessageImpl[3];

			array[0] = getByA_R_PrevAndNext(
				session, legalAttachedMessage, articleId, readMessage,
				orderByComparator, true);

			array[1] = legalAttachedMessage;

			array[2] = getByA_R_PrevAndNext(
				session, legalAttachedMessage, articleId, readMessage,
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

	protected LegalAttachedMessage getByA_R_PrevAndNext(
		Session session, LegalAttachedMessage legalAttachedMessage,
		String articleId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

		boolean bindArticleId = false;

		if (articleId.isEmpty()) {
			query.append(_FINDER_COLUMN_A_R_ARTICLEID_3);
		}
		else {
			bindArticleId = true;

			query.append(_FINDER_COLUMN_A_R_ARTICLEID_2);
		}

		query.append(_FINDER_COLUMN_A_R_READMESSAGE_2);

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
			query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindArticleId) {
			qPos.add(articleId);
		}

		qPos.add(readMessage);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalAttachedMessage)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal attached messages where articleId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 */
	@Override
	public void removeByA_R(String articleId, boolean readMessage) {
		for (LegalAttachedMessage legalAttachedMessage :
				findByA_R(
					articleId, readMessage, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalAttachedMessage);
		}
	}

	/**
	 * Returns the number of legal attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the number of matching legal attached messages
	 */
	@Override
	public int countByA_R(String articleId, boolean readMessage) {
		articleId = Objects.toString(articleId, "");

		FinderPath finderPath = _finderPathCountByA_R;

		Object[] finderArgs = new Object[] {articleId, readMessage};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALATTACHEDMESSAGE_WHERE);

			boolean bindArticleId = false;

			if (articleId.isEmpty()) {
				query.append(_FINDER_COLUMN_A_R_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_A_R_ARTICLEID_2);
			}

			query.append(_FINDER_COLUMN_A_R_READMESSAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArticleId) {
					qPos.add(articleId);
				}

				qPos.add(readMessage);

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

	private static final String _FINDER_COLUMN_A_R_ARTICLEID_2 =
		"legalAttachedMessage.articleId = ? AND ";

	private static final String _FINDER_COLUMN_A_R_ARTICLEID_3 =
		"(legalAttachedMessage.articleId IS NULL OR legalAttachedMessage.articleId = '') AND ";

	private static final String _FINDER_COLUMN_A_R_READMESSAGE_2 =
		"legalAttachedMessage.readMessage = ?";

	private FinderPath _finderPathWithPaginationFindByG_R;
	private FinderPath _finderPathWithoutPaginationFindByG_R;
	private FinderPath _finderPathCountByG_R;

	/**
	 * Returns all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage) {

		return findByG_R(
			groupId, readMessage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end) {

		return findByG_R(groupId, readMessage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return findByG_R(
			groupId, readMessage, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findByG_R(
		long groupId, boolean readMessage, int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_R;
				finderArgs = new Object[] {groupId, readMessage};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_R;
			finderArgs = new Object[] {
				groupId, readMessage, start, end, orderByComparator
			};
		}

		List<LegalAttachedMessage> list = null;

		if (useFinderCache) {
			list = (List<LegalAttachedMessage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalAttachedMessage legalAttachedMessage : list) {
					if ((groupId != legalAttachedMessage.getGroupId()) ||
						(readMessage != legalAttachedMessage.isReadMessage())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_G_R_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_READMESSAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(readMessage);

				list = (List<LegalAttachedMessage>)QueryUtil.list(
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
	 * Returns the first legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByG_R_First(
			long groupId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByG_R_First(
			groupId, readMessage, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", readMessage=");
		msg.append(readMessage);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the first legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByG_R_First(
		long groupId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		List<LegalAttachedMessage> list = findByG_R(
			groupId, readMessage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage findByG_R_Last(
			long groupId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByG_R_Last(
			groupId, readMessage, orderByComparator);

		if (legalAttachedMessage != null) {
			return legalAttachedMessage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", readMessage=");
		msg.append(readMessage);

		msg.append("}");

		throw new NoSuchLegalAttachedMessageException(msg.toString());
	}

	/**
	 * Returns the last legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal attached message, or <code>null</code> if a matching legal attached message could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByG_R_Last(
		long groupId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		int count = countByG_R(groupId, readMessage);

		if (count == 0) {
			return null;
		}

		List<LegalAttachedMessage> list = findByG_R(
			groupId, readMessage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal attached messages before and after the current legal attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param messageId the primary key of the current legal attached message
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage[] findByG_R_PrevAndNext(
			String messageId, long groupId, boolean readMessage,
			OrderByComparator<LegalAttachedMessage> orderByComparator)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			LegalAttachedMessage[] array = new LegalAttachedMessageImpl[3];

			array[0] = getByG_R_PrevAndNext(
				session, legalAttachedMessage, groupId, readMessage,
				orderByComparator, true);

			array[1] = legalAttachedMessage;

			array[2] = getByG_R_PrevAndNext(
				session, legalAttachedMessage, groupId, readMessage,
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

	protected LegalAttachedMessage getByG_R_PrevAndNext(
		Session session, LegalAttachedMessage legalAttachedMessage,
		long groupId, boolean readMessage,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_G_R_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_READMESSAGE_2);

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
			query.append(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(readMessage);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalAttachedMessage)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal attached messages where groupId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 */
	@Override
	public void removeByG_R(long groupId, boolean readMessage) {
		for (LegalAttachedMessage legalAttachedMessage :
				findByG_R(
					groupId, readMessage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalAttachedMessage);
		}
	}

	/**
	 * Returns the number of legal attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the number of matching legal attached messages
	 */
	@Override
	public int countByG_R(long groupId, boolean readMessage) {
		FinderPath finderPath = _finderPathCountByG_R;

		Object[] finderArgs = new Object[] {groupId, readMessage};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_G_R_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_READMESSAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(readMessage);

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

	private static final String _FINDER_COLUMN_G_R_GROUPID_2 =
		"legalAttachedMessage.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_R_READMESSAGE_2 =
		"legalAttachedMessage.readMessage = ?";

	public LegalAttachedMessagePersistenceImpl() {
		setModelClass(LegalAttachedMessage.class);

		setModelImplClass(LegalAttachedMessageImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the legal attached message in the entity cache if it is enabled.
	 *
	 * @param legalAttachedMessage the legal attached message
	 */
	@Override
	public void cacheResult(LegalAttachedMessage legalAttachedMessage) {
		entityCache.putResult(
			entityCacheEnabled, LegalAttachedMessageImpl.class,
			legalAttachedMessage.getPrimaryKey(), legalAttachedMessage);

		legalAttachedMessage.resetOriginalValues();
	}

	/**
	 * Caches the legal attached messages in the entity cache if it is enabled.
	 *
	 * @param legalAttachedMessages the legal attached messages
	 */
	@Override
	public void cacheResult(List<LegalAttachedMessage> legalAttachedMessages) {
		for (LegalAttachedMessage legalAttachedMessage :
				legalAttachedMessages) {

			if (entityCache.getResult(
					entityCacheEnabled, LegalAttachedMessageImpl.class,
					legalAttachedMessage.getPrimaryKey()) == null) {

				cacheResult(legalAttachedMessage);
			}
			else {
				legalAttachedMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal attached messages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalAttachedMessageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal attached message.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalAttachedMessage legalAttachedMessage) {
		entityCache.removeResult(
			entityCacheEnabled, LegalAttachedMessageImpl.class,
			legalAttachedMessage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalAttachedMessage> legalAttachedMessages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalAttachedMessage legalAttachedMessage :
				legalAttachedMessages) {

			entityCache.removeResult(
				entityCacheEnabled, LegalAttachedMessageImpl.class,
				legalAttachedMessage.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalAttachedMessageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal attached message with the primary key. Does not add the legal attached message to the database.
	 *
	 * @param messageId the primary key for the new legal attached message
	 * @return the new legal attached message
	 */
	@Override
	public LegalAttachedMessage create(String messageId) {
		LegalAttachedMessage legalAttachedMessage =
			new LegalAttachedMessageImpl();

		legalAttachedMessage.setNew(true);
		legalAttachedMessage.setPrimaryKey(messageId);

		legalAttachedMessage.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalAttachedMessage;
	}

	/**
	 * Removes the legal attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message that was removed
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage remove(String messageId)
		throws NoSuchLegalAttachedMessageException {

		return remove((Serializable)messageId);
	}

	/**
	 * Removes the legal attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal attached message
	 * @return the legal attached message that was removed
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage remove(Serializable primaryKey)
		throws NoSuchLegalAttachedMessageException {

		Session session = null;

		try {
			session = openSession();

			LegalAttachedMessage legalAttachedMessage =
				(LegalAttachedMessage)session.get(
					LegalAttachedMessageImpl.class, primaryKey);

			if (legalAttachedMessage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalAttachedMessageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalAttachedMessage);
		}
		catch (NoSuchLegalAttachedMessageException noSuchEntityException) {
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
	protected LegalAttachedMessage removeImpl(
		LegalAttachedMessage legalAttachedMessage) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalAttachedMessage)) {
				legalAttachedMessage = (LegalAttachedMessage)session.get(
					LegalAttachedMessageImpl.class,
					legalAttachedMessage.getPrimaryKeyObj());
			}

			if (legalAttachedMessage != null) {
				session.delete(legalAttachedMessage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalAttachedMessage != null) {
			clearCache(legalAttachedMessage);
		}

		return legalAttachedMessage;
	}

	@Override
	public LegalAttachedMessage updateImpl(
		LegalAttachedMessage legalAttachedMessage) {

		boolean isNew = legalAttachedMessage.isNew();

		if (!(legalAttachedMessage instanceof LegalAttachedMessageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalAttachedMessage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalAttachedMessage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalAttachedMessage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalAttachedMessage implementation " +
					legalAttachedMessage.getClass());
		}

		LegalAttachedMessageModelImpl legalAttachedMessageModelImpl =
			(LegalAttachedMessageModelImpl)legalAttachedMessage;

		Session session = null;

		try {
			session = openSession();

			if (legalAttachedMessage.isNew()) {
				session.save(legalAttachedMessage);

				legalAttachedMessage.setNew(false);
			}
			else {
				legalAttachedMessage = (LegalAttachedMessage)session.merge(
					legalAttachedMessage);
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
				legalAttachedMessageModelImpl.getArticleId()
			};

			finderCache.removeResult(_finderPathCountByArticle, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByArticle, args);

			args = new Object[] {
				legalAttachedMessageModelImpl.isReadMessage(),
				legalAttachedMessageModelImpl.getArticleId()
			};

			finderCache.removeResult(_finderPathCountByUnRead, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUnRead, args);

			args = new Object[] {
				legalAttachedMessageModelImpl.getArticleId(),
				legalAttachedMessageModelImpl.isReadMessage()
			};

			finderCache.removeResult(_finderPathCountByA_R, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByA_R, args);

			args = new Object[] {
				legalAttachedMessageModelImpl.getGroupId(),
				legalAttachedMessageModelImpl.isReadMessage()
			};

			finderCache.removeResult(_finderPathCountByG_R, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_R, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalAttachedMessageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByArticle.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalAttachedMessageModelImpl.getOriginalArticleId()
				};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);

				args = new Object[] {
					legalAttachedMessageModelImpl.getArticleId()
				};

				finderCache.removeResult(_finderPathCountByArticle, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByArticle, args);
			}

			if ((legalAttachedMessageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUnRead.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalAttachedMessageModelImpl.getOriginalReadMessage(),
					legalAttachedMessageModelImpl.getOriginalArticleId()
				};

				finderCache.removeResult(_finderPathCountByUnRead, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUnRead, args);

				args = new Object[] {
					legalAttachedMessageModelImpl.isReadMessage(),
					legalAttachedMessageModelImpl.getArticleId()
				};

				finderCache.removeResult(_finderPathCountByUnRead, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUnRead, args);
			}

			if ((legalAttachedMessageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByA_R.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalAttachedMessageModelImpl.getOriginalArticleId(),
					legalAttachedMessageModelImpl.getOriginalReadMessage()
				};

				finderCache.removeResult(_finderPathCountByA_R, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByA_R, args);

				args = new Object[] {
					legalAttachedMessageModelImpl.getArticleId(),
					legalAttachedMessageModelImpl.isReadMessage()
				};

				finderCache.removeResult(_finderPathCountByA_R, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByA_R, args);
			}

			if ((legalAttachedMessageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_R.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalAttachedMessageModelImpl.getOriginalGroupId(),
					legalAttachedMessageModelImpl.getOriginalReadMessage()
				};

				finderCache.removeResult(_finderPathCountByG_R, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_R, args);

				args = new Object[] {
					legalAttachedMessageModelImpl.getGroupId(),
					legalAttachedMessageModelImpl.isReadMessage()
				};

				finderCache.removeResult(_finderPathCountByG_R, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_R, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalAttachedMessageImpl.class,
			legalAttachedMessage.getPrimaryKey(), legalAttachedMessage, false);

		legalAttachedMessage.resetOriginalValues();

		return legalAttachedMessage;
	}

	/**
	 * Returns the legal attached message with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal attached message
	 * @return the legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalAttachedMessageException {

		LegalAttachedMessage legalAttachedMessage = fetchByPrimaryKey(
			primaryKey);

		if (legalAttachedMessage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalAttachedMessageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalAttachedMessage;
	}

	/**
	 * Returns the legal attached message with the primary key or throws a <code>NoSuchLegalAttachedMessageException</code> if it could not be found.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message
	 * @throws NoSuchLegalAttachedMessageException if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage findByPrimaryKey(String messageId)
		throws NoSuchLegalAttachedMessageException {

		return findByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns the legal attached message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the legal attached message
	 * @return the legal attached message, or <code>null</code> if a legal attached message with the primary key could not be found
	 */
	@Override
	public LegalAttachedMessage fetchByPrimaryKey(String messageId) {
		return fetchByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns all the legal attached messages.
	 *
	 * @return the legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @return the range of legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findAll(
		int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalAttachedMessageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal attached messages
	 * @param end the upper bound of the range of legal attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal attached messages
	 */
	@Override
	public List<LegalAttachedMessage> findAll(
		int start, int end,
		OrderByComparator<LegalAttachedMessage> orderByComparator,
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

		List<LegalAttachedMessage> list = null;

		if (useFinderCache) {
			list = (List<LegalAttachedMessage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALATTACHEDMESSAGE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALATTACHEDMESSAGE;

				sql = sql.concat(LegalAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalAttachedMessage>)QueryUtil.list(
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
	 * Removes all the legal attached messages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalAttachedMessage legalAttachedMessage : findAll()) {
			remove(legalAttachedMessage);
		}
	}

	/**
	 * Returns the number of legal attached messages.
	 *
	 * @return the number of legal attached messages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALATTACHEDMESSAGE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "messageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALATTACHEDMESSAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalAttachedMessageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal attached message persistence.
	 */
	@Activate
	public void activate() {
		LegalAttachedMessageModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalAttachedMessageModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] {String.class.getName()},
			LegalAttachedMessageModelImpl.ARTICLEID_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByArticle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUnRead = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnRead",
			new String[] {
				Boolean.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUnRead = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnRead",
			new String[] {Boolean.class.getName(), String.class.getName()},
			LegalAttachedMessageModelImpl.READMESSAGE_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.ARTICLEID_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByUnRead = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnRead",
			new String[] {Boolean.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByA_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA_R",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByA_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_R",
			new String[] {String.class.getName(), Boolean.class.getName()},
			LegalAttachedMessageModelImpl.ARTICLEID_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.READMESSAGE_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByA_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_R",
			new String[] {String.class.getName(), Boolean.class.getName()});

		_finderPathWithPaginationFindByG_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			LegalAttachedMessageModelImpl.GROUPID_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.READMESSAGE_COLUMN_BITMASK |
			LegalAttachedMessageModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R",
			new String[] {Long.class.getName(), Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalAttachedMessageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalAttachedMessage"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_LEGALATTACHEDMESSAGE =
		"SELECT legalAttachedMessage FROM LegalAttachedMessage legalAttachedMessage";

	private static final String _SQL_SELECT_LEGALATTACHEDMESSAGE_WHERE =
		"SELECT legalAttachedMessage FROM LegalAttachedMessage legalAttachedMessage WHERE ";

	private static final String _SQL_COUNT_LEGALATTACHEDMESSAGE =
		"SELECT COUNT(legalAttachedMessage) FROM LegalAttachedMessage legalAttachedMessage";

	private static final String _SQL_COUNT_LEGALATTACHEDMESSAGE_WHERE =
		"SELECT COUNT(legalAttachedMessage) FROM LegalAttachedMessage legalAttachedMessage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"legalAttachedMessage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalAttachedMessage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalAttachedMessage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalAttachedMessagePersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}