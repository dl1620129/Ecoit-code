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

import com.software.cms.exception.NoSuchLoggerException;
import com.software.cms.model.Logger;
import com.software.cms.model.impl.LoggerImpl;
import com.software.cms.model.impl.LoggerModelImpl;
import com.software.cms.service.persistence.LoggerPersistence;
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
 * The persistence implementation for the logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = LoggerPersistence.class)
public class LoggerPersistenceImpl
	extends BasePersistenceImpl<Logger> implements LoggerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LoggerUtil</code> to access the logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LoggerImpl.class.getName();

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
	 * Returns all the loggers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loggers
	 */
	@Override
	public List<Logger> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loggers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	@Override
	public List<Logger> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loggers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loggers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

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

		List<Logger> list = null;

		if (useFinderCache) {
			list = (List<Logger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Logger logger : list) {
					if (!uuid.equals(logger.getUuid())) {
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

			query.append(_SQL_SELECT_LOGGER_WHERE);

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
				query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

				list = (List<Logger>)QueryUtil.list(
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
	 * Returns the first logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByUuid_First(
			String uuid, OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByUuid_First(uuid, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the first logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByUuid_First(
		String uuid, OrderByComparator<Logger> orderByComparator) {

		List<Logger> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByUuid_Last(
			String uuid, OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByUuid_Last(uuid, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the last logger in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByUuid_Last(
		String uuid, OrderByComparator<Logger> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Logger> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where uuid = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger[] findByUuid_PrevAndNext(
			long loggerId, String uuid,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		uuid = Objects.toString(uuid, "");

		Logger logger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			Logger[] array = new LoggerImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, logger, uuid, orderByComparator, true);

			array[1] = logger;

			array[2] = getByUuid_PrevAndNext(
				session, logger, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Logger getByUuid_PrevAndNext(
		Session session, Logger logger, String uuid,
		OrderByComparator<Logger> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOGGER_WHERE);

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
			query.append(LoggerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(logger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Logger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loggers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Logger logger :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(logger);
		}
	}

	/**
	 * Returns the number of loggers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loggers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOGGER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "logger.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(logger.uuid IS NULL OR logger.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoggerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByUUID_G(String uuid, long groupId)
		throws NoSuchLoggerException {

		Logger logger = fetchByUUID_G(uuid, groupId);

		if (logger == null) {
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

			throw new NoSuchLoggerException(msg.toString());
		}

		return logger;
	}

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the logger where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByUUID_G(
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

		if (result instanceof Logger) {
			Logger logger = (Logger)result;

			if (!Objects.equals(uuid, logger.getUuid()) ||
				(groupId != logger.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LOGGER_WHERE);

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

				List<Logger> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Logger logger = list.get(0);

					result = logger;

					cacheResult(logger);
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
			return (Logger)result;
		}
	}

	/**
	 * Removes the logger where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the logger that was removed
	 */
	@Override
	public Logger removeByUUID_G(String uuid, long groupId)
		throws NoSuchLoggerException {

		Logger logger = findByUUID_G(uuid, groupId);

		return remove(logger);
	}

	/**
	 * Returns the number of loggers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching loggers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOGGER_WHERE);

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
		"logger.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(logger.uuid IS NULL OR logger.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"logger.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup_Language_User;
	private FinderPath _finderPathWithoutPaginationFindByGroup_Language_User;
	private FinderPath _finderPathCountByGroup_Language_User;

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @return the matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId) {

		return findByGroup_Language_User(
			groupId, language, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end) {

		return findByGroup_Language_User(
			groupId, language, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return findByGroup_Language_User(
			groupId, language, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User(
		long groupId, String language, long userId, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Language_User;
				finderArgs = new Object[] {groupId, language, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_Language_User;
			finderArgs = new Object[] {
				groupId, language, userId, start, end, orderByComparator
			};
		}

		List<Logger> list = null;

		if (useFinderCache) {
			list = (List<Logger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Logger logger : list) {
					if ((groupId != logger.getGroupId()) ||
						!language.equals(logger.getLanguage()) ||
						(userId != logger.getUserId())) {

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

			query.append(_SQL_SELECT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

				qPos.add(userId);

				list = (List<Logger>)QueryUtil.list(
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
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_User_First(
			long groupId, String language, long userId,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_User_First(
			groupId, language, userId, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_User_First(
		long groupId, String language, long userId,
		OrderByComparator<Logger> orderByComparator) {

		List<Logger> list = findByGroup_Language_User(
			groupId, language, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_User_Last(
			long groupId, String language, long userId,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_User_Last(
			groupId, language, userId, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_User_Last(
		long groupId, String language, long userId,
		OrderByComparator<Logger> orderByComparator) {

		int count = countByGroup_Language_User(groupId, language, userId);

		if (count == 0) {
			return null;
		}

		List<Logger> list = findByGroup_Language_User(
			groupId, language, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger[] findByGroup_Language_User_PrevAndNext(
			long loggerId, long groupId, String language, long userId,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		language = Objects.toString(language, "");

		Logger logger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			Logger[] array = new LoggerImpl[3];

			array[0] = getByGroup_Language_User_PrevAndNext(
				session, logger, groupId, language, userId, orderByComparator,
				true);

			array[1] = logger;

			array[2] = getByGroup_Language_User_PrevAndNext(
				session, logger, groupId, language, userId, orderByComparator,
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

	protected Logger getByGroup_Language_User_PrevAndNext(
		Session session, Logger logger, long groupId, String language,
		long userId, OrderByComparator<Logger> orderByComparator,
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

		query.append(_SQL_SELECT_LOGGER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_USERID_2);

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
			query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(logger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Logger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 */
	@Override
	public void removeByGroup_Language_User(
		long groupId, String language, long userId) {

		for (Logger logger :
				findByGroup_Language_User(
					groupId, language, userId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(logger);
		}
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @return the number of matching loggers
	 */
	@Override
	public int countByGroup_Language_User(
		long groupId, String language, long userId) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByGroup_Language_User;

		Object[] finderArgs = new Object[] {groupId, language, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_USERID_2);

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

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_USER_GROUPID_2 =
		"logger.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_2 =
		"logger.language = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_USER_LANGUAGE_3 =
		"(logger.language IS NULL OR logger.language = '') AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_USER_USERID_2 =
		"logger.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup_Language;
	private FinderPath _finderPathWithoutPaginationFindByGroup_Language;
	private FinderPath _finderPathCountByGroup_Language;

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language(long groupId, String language) {
		return findByGroup_Language(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end) {

		return findByGroup_Language(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return findByGroup_Language(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language(
		long groupId, String language, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup_Language;
				finderArgs = new Object[] {groupId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_Language;
			finderArgs = new Object[] {
				groupId, language, start, end, orderByComparator
			};
		}

		List<Logger> list = null;

		if (useFinderCache) {
			list = (List<Logger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Logger logger : list) {
					if ((groupId != logger.getGroupId()) ||
						!language.equals(logger.getLanguage())) {

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

			query.append(_SQL_SELECT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

				list = (List<Logger>)QueryUtil.list(
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
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_First(
			long groupId, String language,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_First(
			groupId, language, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_First(
		long groupId, String language,
		OrderByComparator<Logger> orderByComparator) {

		List<Logger> list = findByGroup_Language(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_Last(
			long groupId, String language,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_Last(
			groupId, language, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_Last(
		long groupId, String language,
		OrderByComparator<Logger> orderByComparator) {

		int count = countByGroup_Language(groupId, language);

		if (count == 0) {
			return null;
		}

		List<Logger> list = findByGroup_Language(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger[] findByGroup_Language_PrevAndNext(
			long loggerId, long groupId, String language,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		language = Objects.toString(language, "");

		Logger logger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			Logger[] array = new LoggerImpl[3];

			array[0] = getByGroup_Language_PrevAndNext(
				session, logger, groupId, language, orderByComparator, true);

			array[1] = logger;

			array[2] = getByGroup_Language_PrevAndNext(
				session, logger, groupId, language, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Logger getByGroup_Language_PrevAndNext(
		Session session, Logger logger, long groupId, String language,
		OrderByComparator<Logger> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOGGER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2);
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
			query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(logger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Logger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByGroup_Language(long groupId, String language) {
		for (Logger logger :
				findByGroup_Language(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(logger);
		}
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching loggers
	 */
	@Override
	public int countByGroup_Language(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByGroup_Language;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2);
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

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2 =
		"logger.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2 =
		"logger.language = ?";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3 =
		"(logger.language IS NULL OR logger.language = '')";

	private FinderPath _finderPathWithPaginationFindByGroup_Language_Type;
	private FinderPath _finderPathWithoutPaginationFindByGroup_Language_Type;
	private FinderPath _finderPathCountByGroup_Language_Type;

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @return the matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type) {

		return findByGroup_Language_Type(
			groupId, language, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end) {

		return findByGroup_Language_Type(
			groupId, language, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end,
		OrderByComparator<Logger> orderByComparator) {

		return findByGroup_Language_Type(
			groupId, language, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_Type(
		long groupId, String language, String type, int start, int end,
		OrderByComparator<Logger> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Language_Type;
				finderArgs = new Object[] {groupId, language, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_Language_Type;
			finderArgs = new Object[] {
				groupId, language, type, start, end, orderByComparator
			};
		}

		List<Logger> list = null;

		if (useFinderCache) {
			list = (List<Logger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Logger logger : list) {
					if ((groupId != logger.getGroupId()) ||
						!language.equals(logger.getLanguage()) ||
						!type.equals(logger.getType())) {

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

			query.append(_SQL_SELECT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

				if (bindType) {
					qPos.add(type);
				}

				list = (List<Logger>)QueryUtil.list(
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
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_Type_First(
			long groupId, String language, String type,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_Type_First(
			groupId, language, type, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_Type_First(
		long groupId, String language, String type,
		OrderByComparator<Logger> orderByComparator) {

		List<Logger> list = findByGroup_Language_Type(
			groupId, language, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_Type_Last(
			long groupId, String language, String type,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_Type_Last(
			groupId, language, type, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_Type_Last(
		long groupId, String language, String type,
		OrderByComparator<Logger> orderByComparator) {

		int count = countByGroup_Language_Type(groupId, language, type);

		if (count == 0) {
			return null;
		}

		List<Logger> list = findByGroup_Language_Type(
			groupId, language, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger[] findByGroup_Language_Type_PrevAndNext(
			long loggerId, long groupId, String language, String type,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		language = Objects.toString(language, "");
		type = Objects.toString(type, "");

		Logger logger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			Logger[] array = new LoggerImpl[3];

			array[0] = getByGroup_Language_Type_PrevAndNext(
				session, logger, groupId, language, type, orderByComparator,
				true);

			array[1] = logger;

			array[2] = getByGroup_Language_Type_PrevAndNext(
				session, logger, groupId, language, type, orderByComparator,
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

	protected Logger getByGroup_Language_Type_PrevAndNext(
		Session session, Logger logger, long groupId, String language,
		String type, OrderByComparator<Logger> orderByComparator,
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

		query.append(_SQL_SELECT_LOGGER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_2);
		}

		boolean bindType = false;

		if (type.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_2);
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
			query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(logger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Logger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 */
	@Override
	public void removeByGroup_Language_Type(
		long groupId, String language, String type) {

		for (Logger logger :
				findByGroup_Language_Type(
					groupId, language, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(logger);
		}
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param type the type
	 * @return the number of matching loggers
	 */
	@Override
	public int countByGroup_Language_Type(
		long groupId, String language, String type) {

		language = Objects.toString(language, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByGroup_Language_Type;

		Object[] finderArgs = new Object[] {groupId, language, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_2);
			}

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_2);
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

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_TYPE_GROUPID_2 =
		"logger.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_2 =
		"logger.language = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_TYPE_LANGUAGE_3 =
		"(logger.language IS NULL OR logger.language = '') AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_2 =
		"logger.type = ?";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_TYPE_TYPE_3 =
		"(logger.type IS NULL OR logger.type = '')";

	private FinderPath _finderPathWithPaginationFindByGroup_Language_User_Type;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Language_User_Type;
	private FinderPath _finderPathCountByGroup_Language_User_Type;

	/**
	 * Returns all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type) {

		return findByGroup_Language_User_Type(
			groupId, language, userId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end) {

		return findByGroup_Language_User_Type(
			groupId, language, userId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end, OrderByComparator<Logger> orderByComparator) {

		return findByGroup_Language_User_Type(
			groupId, language, userId, type, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loggers
	 */
	@Override
	public List<Logger> findByGroup_Language_User_Type(
		long groupId, String language, long userId, String type, int start,
		int end, OrderByComparator<Logger> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Language_User_Type;
				finderArgs = new Object[] {groupId, language, userId, type};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Language_User_Type;
			finderArgs = new Object[] {
				groupId, language, userId, type, start, end, orderByComparator
			};
		}

		List<Logger> list = null;

		if (useFinderCache) {
			list = (List<Logger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Logger logger : list) {
					if ((groupId != logger.getGroupId()) ||
						!language.equals(logger.getLanguage()) ||
						(userId != logger.getUserId()) ||
						!type.equals(logger.getType())) {

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

			query.append(_SQL_SELECT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_USERID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

				qPos.add(userId);

				if (bindType) {
					qPos.add(type);
				}

				list = (List<Logger>)QueryUtil.list(
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
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_User_Type_First(
			long groupId, String language, long userId, String type,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_User_Type_First(
			groupId, language, userId, type, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the first logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_User_Type_First(
		long groupId, String language, long userId, String type,
		OrderByComparator<Logger> orderByComparator) {

		List<Logger> list = findByGroup_Language_User_Type(
			groupId, language, userId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger
	 * @throws NoSuchLoggerException if a matching logger could not be found
	 */
	@Override
	public Logger findByGroup_Language_User_Type_Last(
			long groupId, String language, long userId, String type,
			OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		Logger logger = fetchByGroup_Language_User_Type_Last(
			groupId, language, userId, type, orderByComparator);

		if (logger != null) {
			return logger;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchLoggerException(msg.toString());
	}

	/**
	 * Returns the last logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching logger, or <code>null</code> if a matching logger could not be found
	 */
	@Override
	public Logger fetchByGroup_Language_User_Type_Last(
		long groupId, String language, long userId, String type,
		OrderByComparator<Logger> orderByComparator) {

		int count = countByGroup_Language_User_Type(
			groupId, language, userId, type);

		if (count == 0) {
			return null;
		}

		List<Logger> list = findByGroup_Language_User_Type(
			groupId, language, userId, type, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the loggers before and after the current logger in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param loggerId the primary key of the current logger
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger[] findByGroup_Language_User_Type_PrevAndNext(
			long loggerId, long groupId, String language, long userId,
			String type, OrderByComparator<Logger> orderByComparator)
		throws NoSuchLoggerException {

		language = Objects.toString(language, "");
		type = Objects.toString(type, "");

		Logger logger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			Logger[] array = new LoggerImpl[3];

			array[0] = getByGroup_Language_User_Type_PrevAndNext(
				session, logger, groupId, language, userId, type,
				orderByComparator, true);

			array[1] = logger;

			array[2] = getByGroup_Language_User_Type_PrevAndNext(
				session, logger, groupId, language, userId, type,
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

	protected Logger getByGroup_Language_User_Type_PrevAndNext(
		Session session, Logger logger, long groupId, String language,
		long userId, String type, OrderByComparator<Logger> orderByComparator,
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

		query.append(_SQL_SELECT_LOGGER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_USERID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_2);
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
			query.append(LoggerModelImpl.ORDER_BY_JPQL);
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

		qPos.add(userId);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(logger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Logger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 */
	@Override
	public void removeByGroup_Language_User_Type(
		long groupId, String language, long userId, String type) {

		for (Logger logger :
				findByGroup_Language_User_Type(
					groupId, language, userId, type, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(logger);
		}
	}

	/**
	 * Returns the number of loggers where groupId = &#63; and language = &#63; and userId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching loggers
	 */
	@Override
	public int countByGroup_Language_User_Type(
		long groupId, String language, long userId, String type) {

		language = Objects.toString(language, "");
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByGroup_Language_User_Type;

		Object[] finderArgs = new Object[] {groupId, language, userId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LOGGER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_USERID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_2);
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

				qPos.add(userId);

				if (bindType) {
					qPos.add(type);
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

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_GROUPID_2 =
			"logger.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_2 =
			"logger.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_LANGUAGE_3 =
			"(logger.language IS NULL OR logger.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_USERID_2 =
			"logger.userId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_2 =
		"logger.type = ?";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_USER_TYPE_TYPE_3 =
		"(logger.type IS NULL OR logger.type = '')";

	public LoggerPersistenceImpl() {
		setModelClass(Logger.class);

		setModelImplClass(LoggerImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the logger in the entity cache if it is enabled.
	 *
	 * @param logger the logger
	 */
	@Override
	public void cacheResult(Logger logger) {
		entityCache.putResult(
			entityCacheEnabled, LoggerImpl.class, logger.getPrimaryKey(),
			logger);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {logger.getUuid(), logger.getGroupId()}, logger);

		logger.resetOriginalValues();
	}

	/**
	 * Caches the loggers in the entity cache if it is enabled.
	 *
	 * @param loggers the loggers
	 */
	@Override
	public void cacheResult(List<Logger> loggers) {
		for (Logger logger : loggers) {
			if (entityCache.getResult(
					entityCacheEnabled, LoggerImpl.class,
					logger.getPrimaryKey()) == null) {

				cacheResult(logger);
			}
			else {
				logger.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loggers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LoggerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the logger.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Logger logger) {
		entityCache.removeResult(
			entityCacheEnabled, LoggerImpl.class, logger.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LoggerModelImpl)logger, true);
	}

	@Override
	public void clearCache(List<Logger> loggers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Logger logger : loggers) {
			entityCache.removeResult(
				entityCacheEnabled, LoggerImpl.class, logger.getPrimaryKey());

			clearUniqueFindersCache((LoggerModelImpl)logger, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LoggerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(LoggerModelImpl loggerModelImpl) {
		Object[] args = new Object[] {
			loggerModelImpl.getUuid(), loggerModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, loggerModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LoggerModelImpl loggerModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				loggerModelImpl.getUuid(), loggerModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((loggerModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				loggerModelImpl.getOriginalUuid(),
				loggerModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new logger with the primary key. Does not add the logger to the database.
	 *
	 * @param loggerId the primary key for the new logger
	 * @return the new logger
	 */
	@Override
	public Logger create(long loggerId) {
		Logger logger = new LoggerImpl();

		logger.setNew(true);
		logger.setPrimaryKey(loggerId);

		String uuid = PortalUUIDUtil.generate();

		logger.setUuid(uuid);

		return logger;
	}

	/**
	 * Removes the logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger that was removed
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger remove(long loggerId) throws NoSuchLoggerException {
		return remove((Serializable)loggerId);
	}

	/**
	 * Removes the logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the logger
	 * @return the logger that was removed
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger remove(Serializable primaryKey) throws NoSuchLoggerException {
		Session session = null;

		try {
			session = openSession();

			Logger logger = (Logger)session.get(LoggerImpl.class, primaryKey);

			if (logger == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoggerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(logger);
		}
		catch (NoSuchLoggerException noSuchEntityException) {
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
	protected Logger removeImpl(Logger logger) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(logger)) {
				logger = (Logger)session.get(
					LoggerImpl.class, logger.getPrimaryKeyObj());
			}

			if (logger != null) {
				session.delete(logger);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (logger != null) {
			clearCache(logger);
		}

		return logger;
	}

	@Override
	public Logger updateImpl(Logger logger) {
		boolean isNew = logger.isNew();

		if (!(logger instanceof LoggerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(logger.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(logger);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in logger proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Logger implementation " +
					logger.getClass());
		}

		LoggerModelImpl loggerModelImpl = (LoggerModelImpl)logger;

		if (Validator.isNull(logger.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			logger.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (logger.isNew()) {
				session.save(logger);

				logger.setNew(false);
			}
			else {
				logger = (Logger)session.merge(logger);
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
			Object[] args = new Object[] {loggerModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage(),
				loggerModelImpl.getUserId()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Language_User, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language_User, args);

			args = new Object[] {
				loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByGroup_Language, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language, args);

			args = new Object[] {
				loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage(),
				loggerModelImpl.getType()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Language_Type, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language_Type, args);

			args = new Object[] {
				loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage(),
				loggerModelImpl.getUserId(), loggerModelImpl.getType()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Language_User_Type, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language_User_Type,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((loggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					loggerModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {loggerModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((loggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language_User.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					loggerModelImpl.getOriginalGroupId(),
					loggerModelImpl.getOriginalLanguage(),
					loggerModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_User, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_User,
					args);

				args = new Object[] {
					loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage(),
					loggerModelImpl.getUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_User, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_User,
					args);
			}

			if ((loggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					loggerModelImpl.getOriginalGroupId(),
					loggerModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language, args);

				args = new Object[] {
					loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language, args);
			}

			if ((loggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language_Type.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					loggerModelImpl.getOriginalGroupId(),
					loggerModelImpl.getOriginalLanguage(),
					loggerModelImpl.getOriginalType()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Type, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Type,
					args);

				args = new Object[] {
					loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage(),
					loggerModelImpl.getType()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_Type, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_Type,
					args);
			}

			if ((loggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language_User_Type.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					loggerModelImpl.getOriginalGroupId(),
					loggerModelImpl.getOriginalLanguage(),
					loggerModelImpl.getOriginalUserId(),
					loggerModelImpl.getOriginalType()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_User_Type, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_User_Type,
					args);

				args = new Object[] {
					loggerModelImpl.getGroupId(), loggerModelImpl.getLanguage(),
					loggerModelImpl.getUserId(), loggerModelImpl.getType()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language_User_Type, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language_User_Type,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LoggerImpl.class, logger.getPrimaryKey(),
			logger, false);

		clearUniqueFindersCache(loggerModelImpl, false);
		cacheUniqueFindersCache(loggerModelImpl);

		logger.resetOriginalValues();

		return logger;
	}

	/**
	 * Returns the logger with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the logger
	 * @return the logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoggerException {

		Logger logger = fetchByPrimaryKey(primaryKey);

		if (logger == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoggerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return logger;
	}

	/**
	 * Returns the logger with the primary key or throws a <code>NoSuchLoggerException</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger
	 * @throws NoSuchLoggerException if a logger with the primary key could not be found
	 */
	@Override
	public Logger findByPrimaryKey(long loggerId) throws NoSuchLoggerException {
		return findByPrimaryKey((Serializable)loggerId);
	}

	/**
	 * Returns the logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the logger
	 * @return the logger, or <code>null</code> if a logger with the primary key could not be found
	 */
	@Override
	public Logger fetchByPrimaryKey(long loggerId) {
		return fetchByPrimaryKey((Serializable)loggerId);
	}

	/**
	 * Returns all the loggers.
	 *
	 * @return the loggers
	 */
	@Override
	public List<Logger> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @return the range of loggers
	 */
	@Override
	public List<Logger> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loggers
	 */
	@Override
	public List<Logger> findAll(
		int start, int end, OrderByComparator<Logger> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loggers
	 * @param end the upper bound of the range of loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of loggers
	 */
	@Override
	public List<Logger> findAll(
		int start, int end, OrderByComparator<Logger> orderByComparator,
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

		List<Logger> list = null;

		if (useFinderCache) {
			list = (List<Logger>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOGGER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGGER;

				sql = sql.concat(LoggerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Logger>)QueryUtil.list(
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
	 * Removes all the loggers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Logger logger : findAll()) {
			remove(logger);
		}
	}

	/**
	 * Returns the number of loggers.
	 *
	 * @return the number of loggers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGGER);

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
		return "loggerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LOGGER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LoggerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the logger persistence.
	 */
	@Activate
	public void activate() {
		LoggerModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LoggerModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			LoggerModelImpl.UUID_COLUMN_BITMASK |
			LoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			LoggerModelImpl.UUID_COLUMN_BITMASK |
			LoggerModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroup_Language_User = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_Language_User",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_Language_User = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup_Language_User",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			LoggerModelImpl.GROUPID_COLUMN_BITMASK |
			LoggerModelImpl.LANGUAGE_COLUMN_BITMASK |
			LoggerModelImpl.USERID_COLUMN_BITMASK |
			LoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language_User = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Language_User",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Language = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_Language = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_Language",
			new String[] {Long.class.getName(), String.class.getName()},
			LoggerModelImpl.GROUPID_COLUMN_BITMASK |
			LoggerModelImpl.LANGUAGE_COLUMN_BITMASK |
			LoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_Language",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByGroup_Language_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_Language_Type",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_Language_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup_Language_Type",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			LoggerModelImpl.GROUPID_COLUMN_BITMASK |
			LoggerModelImpl.LANGUAGE_COLUMN_BITMASK |
			LoggerModelImpl.TYPE_COLUMN_BITMASK |
			LoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Language_Type",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Language_User_Type =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Language_User_Type",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Language_User_Type =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LoggerImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Language_User_Type",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), String.class.getName()
				},
				LoggerModelImpl.GROUPID_COLUMN_BITMASK |
				LoggerModelImpl.LANGUAGE_COLUMN_BITMASK |
				LoggerModelImpl.USERID_COLUMN_BITMASK |
				LoggerModelImpl.TYPE_COLUMN_BITMASK |
				LoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Language_User_Type = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Language_User_Type",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LoggerImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.Logger"),
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

	private static final String _SQL_SELECT_LOGGER =
		"SELECT logger FROM Logger logger";

	private static final String _SQL_SELECT_LOGGER_WHERE =
		"SELECT logger FROM Logger logger WHERE ";

	private static final String _SQL_COUNT_LOGGER =
		"SELECT COUNT(logger) FROM Logger logger";

	private static final String _SQL_COUNT_LOGGER_WHERE =
		"SELECT COUNT(logger) FROM Logger logger WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "logger.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Logger exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Logger exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LoggerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}