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

import com.software.cms.exception.NoSuchArticleMailSendException;
import com.software.cms.model.ArticleMailSend;
import com.software.cms.model.impl.ArticleMailSendImpl;
import com.software.cms.model.impl.ArticleMailSendModelImpl;
import com.software.cms.service.persistence.ArticleMailSendPersistence;
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
 * The persistence implementation for the article mail send service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = ArticleMailSendPersistence.class)
public class ArticleMailSendPersistenceImpl
	extends BasePersistenceImpl<ArticleMailSend>
	implements ArticleMailSendPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ArticleMailSendUtil</code> to access the article mail send persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ArticleMailSendImpl.class.getName();

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
	 * Returns all the article mail sends where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching article mail sends
	 */
	@Override
	public List<ArticleMailSend> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of matching article mail sends
	 */
	@Override
	public List<ArticleMailSend> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching article mail sends
	 */
	@Override
	public List<ArticleMailSend> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the article mail sends where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching article mail sends
	 */
	@Override
	public List<ArticleMailSend> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator,
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

		List<ArticleMailSend> list = null;

		if (useFinderCache) {
			list = (List<ArticleMailSend>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ArticleMailSend articleMailSend : list) {
					if (!uuid.equals(articleMailSend.getUuid())) {
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

			query.append(_SQL_SELECT_ARTICLEMAILSEND_WHERE);

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
				query.append(ArticleMailSendModelImpl.ORDER_BY_JPQL);
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

				list = (List<ArticleMailSend>)QueryUtil.list(
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
	 * Returns the first article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend findByUuid_First(
			String uuid, OrderByComparator<ArticleMailSend> orderByComparator)
		throws NoSuchArticleMailSendException {

		ArticleMailSend articleMailSend = fetchByUuid_First(
			uuid, orderByComparator);

		if (articleMailSend != null) {
			return articleMailSend;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleMailSendException(msg.toString());
	}

	/**
	 * Returns the first article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend fetchByUuid_First(
		String uuid, OrderByComparator<ArticleMailSend> orderByComparator) {

		List<ArticleMailSend> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend findByUuid_Last(
			String uuid, OrderByComparator<ArticleMailSend> orderByComparator)
		throws NoSuchArticleMailSendException {

		ArticleMailSend articleMailSend = fetchByUuid_Last(
			uuid, orderByComparator);

		if (articleMailSend != null) {
			return articleMailSend;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchArticleMailSendException(msg.toString());
	}

	/**
	 * Returns the last article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend fetchByUuid_Last(
		String uuid, OrderByComparator<ArticleMailSend> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ArticleMailSend> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the article mail sends before and after the current article mail send in the ordered set where uuid = &#63;.
	 *
	 * @param mailSendId the primary key of the current article mail send
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	@Override
	public ArticleMailSend[] findByUuid_PrevAndNext(
			long mailSendId, String uuid,
			OrderByComparator<ArticleMailSend> orderByComparator)
		throws NoSuchArticleMailSendException {

		uuid = Objects.toString(uuid, "");

		ArticleMailSend articleMailSend = findByPrimaryKey(mailSendId);

		Session session = null;

		try {
			session = openSession();

			ArticleMailSend[] array = new ArticleMailSendImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, articleMailSend, uuid, orderByComparator, true);

			array[1] = articleMailSend;

			array[2] = getByUuid_PrevAndNext(
				session, articleMailSend, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ArticleMailSend getByUuid_PrevAndNext(
		Session session, ArticleMailSend articleMailSend, String uuid,
		OrderByComparator<ArticleMailSend> orderByComparator,
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

		query.append(_SQL_SELECT_ARTICLEMAILSEND_WHERE);

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
			query.append(ArticleMailSendModelImpl.ORDER_BY_JPQL);
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
						articleMailSend)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ArticleMailSend> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the article mail sends where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ArticleMailSend articleMailSend :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(articleMailSend);
		}
	}

	/**
	 * Returns the number of article mail sends where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching article mail sends
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ARTICLEMAILSEND_WHERE);

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
		"articleMailSend.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(articleMailSend.uuid IS NULL OR articleMailSend.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArticleMailSendException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article mail send
	 * @throws NoSuchArticleMailSendException if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend findByUUID_G(String uuid, long groupId)
		throws NoSuchArticleMailSendException {

		ArticleMailSend articleMailSend = fetchByUUID_G(uuid, groupId);

		if (articleMailSend == null) {
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

			throw new NoSuchArticleMailSendException(msg.toString());
		}

		return articleMailSend;
	}

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the article mail send where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching article mail send, or <code>null</code> if a matching article mail send could not be found
	 */
	@Override
	public ArticleMailSend fetchByUUID_G(
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

		if (result instanceof ArticleMailSend) {
			ArticleMailSend articleMailSend = (ArticleMailSend)result;

			if (!Objects.equals(uuid, articleMailSend.getUuid()) ||
				(groupId != articleMailSend.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ARTICLEMAILSEND_WHERE);

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

				List<ArticleMailSend> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ArticleMailSend articleMailSend = list.get(0);

					result = articleMailSend;

					cacheResult(articleMailSend);
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
			return (ArticleMailSend)result;
		}
	}

	/**
	 * Removes the article mail send where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the article mail send that was removed
	 */
	@Override
	public ArticleMailSend removeByUUID_G(String uuid, long groupId)
		throws NoSuchArticleMailSendException {

		ArticleMailSend articleMailSend = findByUUID_G(uuid, groupId);

		return remove(articleMailSend);
	}

	/**
	 * Returns the number of article mail sends where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching article mail sends
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ARTICLEMAILSEND_WHERE);

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
		"articleMailSend.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(articleMailSend.uuid IS NULL OR articleMailSend.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"articleMailSend.groupId = ?";

	public ArticleMailSendPersistenceImpl() {
		setModelClass(ArticleMailSend.class);

		setModelImplClass(ArticleMailSendImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the article mail send in the entity cache if it is enabled.
	 *
	 * @param articleMailSend the article mail send
	 */
	@Override
	public void cacheResult(ArticleMailSend articleMailSend) {
		entityCache.putResult(
			entityCacheEnabled, ArticleMailSendImpl.class,
			articleMailSend.getPrimaryKey(), articleMailSend);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				articleMailSend.getUuid(), articleMailSend.getGroupId()
			},
			articleMailSend);

		articleMailSend.resetOriginalValues();
	}

	/**
	 * Caches the article mail sends in the entity cache if it is enabled.
	 *
	 * @param articleMailSends the article mail sends
	 */
	@Override
	public void cacheResult(List<ArticleMailSend> articleMailSends) {
		for (ArticleMailSend articleMailSend : articleMailSends) {
			if (entityCache.getResult(
					entityCacheEnabled, ArticleMailSendImpl.class,
					articleMailSend.getPrimaryKey()) == null) {

				cacheResult(articleMailSend);
			}
			else {
				articleMailSend.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all article mail sends.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleMailSendImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article mail send.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ArticleMailSend articleMailSend) {
		entityCache.removeResult(
			entityCacheEnabled, ArticleMailSendImpl.class,
			articleMailSend.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ArticleMailSendModelImpl)articleMailSend, true);
	}

	@Override
	public void clearCache(List<ArticleMailSend> articleMailSends) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ArticleMailSend articleMailSend : articleMailSends) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleMailSendImpl.class,
				articleMailSend.getPrimaryKey());

			clearUniqueFindersCache(
				(ArticleMailSendModelImpl)articleMailSend, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ArticleMailSendImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ArticleMailSendModelImpl articleMailSendModelImpl) {

		Object[] args = new Object[] {
			articleMailSendModelImpl.getUuid(),
			articleMailSendModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, articleMailSendModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ArticleMailSendModelImpl articleMailSendModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				articleMailSendModelImpl.getUuid(),
				articleMailSendModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((articleMailSendModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				articleMailSendModelImpl.getOriginalUuid(),
				articleMailSendModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new article mail send with the primary key. Does not add the article mail send to the database.
	 *
	 * @param mailSendId the primary key for the new article mail send
	 * @return the new article mail send
	 */
	@Override
	public ArticleMailSend create(long mailSendId) {
		ArticleMailSend articleMailSend = new ArticleMailSendImpl();

		articleMailSend.setNew(true);
		articleMailSend.setPrimaryKey(mailSendId);

		String uuid = PortalUUIDUtil.generate();

		articleMailSend.setUuid(uuid);

		return articleMailSend;
	}

	/**
	 * Removes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	@Override
	public ArticleMailSend remove(long mailSendId)
		throws NoSuchArticleMailSendException {

		return remove((Serializable)mailSendId);
	}

	/**
	 * Removes the article mail send with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article mail send
	 * @return the article mail send that was removed
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	@Override
	public ArticleMailSend remove(Serializable primaryKey)
		throws NoSuchArticleMailSendException {

		Session session = null;

		try {
			session = openSession();

			ArticleMailSend articleMailSend = (ArticleMailSend)session.get(
				ArticleMailSendImpl.class, primaryKey);

			if (articleMailSend == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleMailSendException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(articleMailSend);
		}
		catch (NoSuchArticleMailSendException noSuchEntityException) {
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
	protected ArticleMailSend removeImpl(ArticleMailSend articleMailSend) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(articleMailSend)) {
				articleMailSend = (ArticleMailSend)session.get(
					ArticleMailSendImpl.class,
					articleMailSend.getPrimaryKeyObj());
			}

			if (articleMailSend != null) {
				session.delete(articleMailSend);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (articleMailSend != null) {
			clearCache(articleMailSend);
		}

		return articleMailSend;
	}

	@Override
	public ArticleMailSend updateImpl(ArticleMailSend articleMailSend) {
		boolean isNew = articleMailSend.isNew();

		if (!(articleMailSend instanceof ArticleMailSendModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(articleMailSend.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					articleMailSend);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in articleMailSend proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ArticleMailSend implementation " +
					articleMailSend.getClass());
		}

		ArticleMailSendModelImpl articleMailSendModelImpl =
			(ArticleMailSendModelImpl)articleMailSend;

		if (Validator.isNull(articleMailSend.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			articleMailSend.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (articleMailSend.isNew()) {
				session.save(articleMailSend);

				articleMailSend.setNew(false);
			}
			else {
				articleMailSend = (ArticleMailSend)session.merge(
					articleMailSend);
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
			Object[] args = new Object[] {articleMailSendModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((articleMailSendModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					articleMailSendModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {articleMailSendModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ArticleMailSendImpl.class,
			articleMailSend.getPrimaryKey(), articleMailSend, false);

		clearUniqueFindersCache(articleMailSendModelImpl, false);
		cacheUniqueFindersCache(articleMailSendModelImpl);

		articleMailSend.resetOriginalValues();

		return articleMailSend;
	}

	/**
	 * Returns the article mail send with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article mail send
	 * @return the article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	@Override
	public ArticleMailSend findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleMailSendException {

		ArticleMailSend articleMailSend = fetchByPrimaryKey(primaryKey);

		if (articleMailSend == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleMailSendException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return articleMailSend;
	}

	/**
	 * Returns the article mail send with the primary key or throws a <code>NoSuchArticleMailSendException</code> if it could not be found.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send
	 * @throws NoSuchArticleMailSendException if a article mail send with the primary key could not be found
	 */
	@Override
	public ArticleMailSend findByPrimaryKey(long mailSendId)
		throws NoSuchArticleMailSendException {

		return findByPrimaryKey((Serializable)mailSendId);
	}

	/**
	 * Returns the article mail send with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mailSendId the primary key of the article mail send
	 * @return the article mail send, or <code>null</code> if a article mail send with the primary key could not be found
	 */
	@Override
	public ArticleMailSend fetchByPrimaryKey(long mailSendId) {
		return fetchByPrimaryKey((Serializable)mailSendId);
	}

	/**
	 * Returns all the article mail sends.
	 *
	 * @return the article mail sends
	 */
	@Override
	public List<ArticleMailSend> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @return the range of article mail sends
	 */
	@Override
	public List<ArticleMailSend> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of article mail sends
	 */
	@Override
	public List<ArticleMailSend> findAll(
		int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the article mail sends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticleMailSendModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of article mail sends
	 * @param end the upper bound of the range of article mail sends (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of article mail sends
	 */
	@Override
	public List<ArticleMailSend> findAll(
		int start, int end,
		OrderByComparator<ArticleMailSend> orderByComparator,
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

		List<ArticleMailSend> list = null;

		if (useFinderCache) {
			list = (List<ArticleMailSend>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ARTICLEMAILSEND);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLEMAILSEND;

				sql = sql.concat(ArticleMailSendModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ArticleMailSend>)QueryUtil.list(
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
	 * Removes all the article mail sends from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ArticleMailSend articleMailSend : findAll()) {
			remove(articleMailSend);
		}
	}

	/**
	 * Returns the number of article mail sends.
	 *
	 * @return the number of article mail sends
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLEMAILSEND);

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
		return "mailSendId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ARTICLEMAILSEND;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ArticleMailSendModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article mail send persistence.
	 */
	@Activate
	public void activate() {
		ArticleMailSendModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ArticleMailSendModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMailSendImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMailSendImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMailSendImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMailSendImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ArticleMailSendModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ArticleMailSendImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ArticleMailSendModelImpl.UUID_COLUMN_BITMASK |
			ArticleMailSendModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ArticleMailSendImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.ArticleMailSend"),
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

	private static final String _SQL_SELECT_ARTICLEMAILSEND =
		"SELECT articleMailSend FROM ArticleMailSend articleMailSend";

	private static final String _SQL_SELECT_ARTICLEMAILSEND_WHERE =
		"SELECT articleMailSend FROM ArticleMailSend articleMailSend WHERE ";

	private static final String _SQL_COUNT_ARTICLEMAILSEND =
		"SELECT COUNT(articleMailSend) FROM ArticleMailSend articleMailSend";

	private static final String _SQL_COUNT_ARTICLEMAILSEND_WHERE =
		"SELECT COUNT(articleMailSend) FROM ArticleMailSend articleMailSend WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "articleMailSend.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ArticleMailSend exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ArticleMailSend exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ArticleMailSendPersistenceImpl.class);

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