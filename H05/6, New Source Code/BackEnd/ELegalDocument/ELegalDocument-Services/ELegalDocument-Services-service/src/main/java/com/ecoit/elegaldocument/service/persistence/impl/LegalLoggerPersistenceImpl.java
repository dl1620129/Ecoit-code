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

import com.ecoit.elegaldocument.exception.NoSuchLegalLoggerException;
import com.ecoit.elegaldocument.model.LegalLogger;
import com.ecoit.elegaldocument.model.impl.LegalLoggerImpl;
import com.ecoit.elegaldocument.model.impl.LegalLoggerModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalLoggerPersistence;
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

import java.sql.Timestamp;

import java.util.Date;
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
 * The persistence implementation for the legal logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalLoggerPersistence.class)
public class LegalLoggerPersistenceImpl
	extends BasePersistenceImpl<LegalLogger> implements LegalLoggerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalLoggerUtil</code> to access the legal logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalLoggerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByU_D;
	private FinderPath _finderPathWithoutPaginationFindByU_D;
	private FinderPath _finderPathCountByU_D;

	/**
	 * Returns all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByU_D(String createdByUser, Date createdDate) {
		return findByU_D(
			createdByUser, createdDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end) {

		return findByU_D(createdByUser, createdDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return findByU_D(
			createdByUser, createdDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByU_D(
		String createdByUser, Date createdDate, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		createdByUser = Objects.toString(createdByUser, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_D;
				finderArgs = new Object[] {
					createdByUser, _getTime(createdDate)
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_D;
			finderArgs = new Object[] {
				createdByUser, _getTime(createdDate), start, end,
				orderByComparator
			};
		}

		List<LegalLogger> list = null;

		if (useFinderCache) {
			list = (List<LegalLogger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLogger legalLogger : list) {
					if (!createdByUser.equals(legalLogger.getCreatedByUser()) ||
						!Objects.equals(
							createdDate, legalLogger.getCreatedDate())) {

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

			query.append(_SQL_SELECT_LEGALLOGGER_WHERE);

			boolean bindCreatedByUser = false;

			if (createdByUser.isEmpty()) {
				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_3);
			}
			else {
				bindCreatedByUser = true;

				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_2);
			}

			boolean bindCreatedDate = false;

			if (createdDate == null) {
				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_1);
			}
			else {
				bindCreatedDate = true;

				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLoggerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatedByUser) {
					qPos.add(createdByUser);
				}

				if (bindCreatedDate) {
					qPos.add(new Timestamp(createdDate.getTime()));
				}

				list = (List<LegalLogger>)QueryUtil.list(
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
	 * Returns the first legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger findByU_D_First(
			String createdByUser, Date createdDate,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByU_D_First(
			createdByUser, createdDate, orderByComparator);

		if (legalLogger != null) {
			return legalLogger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdByUser=");
		msg.append(createdByUser);

		msg.append(", createdDate=");
		msg.append(createdDate);

		msg.append("}");

		throw new NoSuchLegalLoggerException(msg.toString());
	}

	/**
	 * Returns the first legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger fetchByU_D_First(
		String createdByUser, Date createdDate,
		OrderByComparator<LegalLogger> orderByComparator) {

		List<LegalLogger> list = findByU_D(
			createdByUser, createdDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger findByU_D_Last(
			String createdByUser, Date createdDate,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByU_D_Last(
			createdByUser, createdDate, orderByComparator);

		if (legalLogger != null) {
			return legalLogger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdByUser=");
		msg.append(createdByUser);

		msg.append(", createdDate=");
		msg.append(createdDate);

		msg.append("}");

		throw new NoSuchLegalLoggerException(msg.toString());
	}

	/**
	 * Returns the last legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger fetchByU_D_Last(
		String createdByUser, Date createdDate,
		OrderByComparator<LegalLogger> orderByComparator) {

		int count = countByU_D(createdByUser, createdDate);

		if (count == 0) {
			return null;
		}

		List<LegalLogger> list = findByU_D(
			createdByUser, createdDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal loggers before and after the current legal logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param loggerId the primary key of the current legal logger
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger[] findByU_D_PrevAndNext(
			String loggerId, String createdByUser, Date createdDate,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		createdByUser = Objects.toString(createdByUser, "");

		LegalLogger legalLogger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			LegalLogger[] array = new LegalLoggerImpl[3];

			array[0] = getByU_D_PrevAndNext(
				session, legalLogger, createdByUser, createdDate,
				orderByComparator, true);

			array[1] = legalLogger;

			array[2] = getByU_D_PrevAndNext(
				session, legalLogger, createdByUser, createdDate,
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

	protected LegalLogger getByU_D_PrevAndNext(
		Session session, LegalLogger legalLogger, String createdByUser,
		Date createdDate, OrderByComparator<LegalLogger> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLOGGER_WHERE);

		boolean bindCreatedByUser = false;

		if (createdByUser.isEmpty()) {
			query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_3);
		}
		else {
			bindCreatedByUser = true;

			query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_2);
		}

		boolean bindCreatedDate = false;

		if (createdDate == null) {
			query.append(_FINDER_COLUMN_U_D_CREATEDDATE_1);
		}
		else {
			bindCreatedDate = true;

			query.append(_FINDER_COLUMN_U_D_CREATEDDATE_2);
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
			query.append(LegalLoggerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreatedByUser) {
			qPos.add(createdByUser);
		}

		if (bindCreatedDate) {
			qPos.add(new Timestamp(createdDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalLogger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLogger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal loggers where createdByUser = &#63; and createdDate = &#63; from the database.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 */
	@Override
	public void removeByU_D(String createdByUser, Date createdDate) {
		for (LegalLogger legalLogger :
				findByU_D(
					createdByUser, createdDate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalLogger);
		}
	}

	/**
	 * Returns the number of legal loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the number of matching legal loggers
	 */
	@Override
	public int countByU_D(String createdByUser, Date createdDate) {
		createdByUser = Objects.toString(createdByUser, "");

		FinderPath finderPath = _finderPathCountByU_D;

		Object[] finderArgs = new Object[] {
			createdByUser, _getTime(createdDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALLOGGER_WHERE);

			boolean bindCreatedByUser = false;

			if (createdByUser.isEmpty()) {
				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_3);
			}
			else {
				bindCreatedByUser = true;

				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_2);
			}

			boolean bindCreatedDate = false;

			if (createdDate == null) {
				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_1);
			}
			else {
				bindCreatedDate = true;

				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatedByUser) {
					qPos.add(createdByUser);
				}

				if (bindCreatedDate) {
					qPos.add(new Timestamp(createdDate.getTime()));
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

	private static final String _FINDER_COLUMN_U_D_CREATEDBYUSER_2 =
		"legalLogger.createdByUser = ? AND ";

	private static final String _FINDER_COLUMN_U_D_CREATEDBYUSER_3 =
		"(legalLogger.createdByUser IS NULL OR legalLogger.createdByUser = '') AND ";

	private static final String _FINDER_COLUMN_U_D_CREATEDDATE_1 =
		"legalLogger.createdDate IS NULL";

	private static final String _FINDER_COLUMN_U_D_CREATEDDATE_2 =
		"legalLogger.createdDate = ?";

	private FinderPath _finderPathWithPaginationFindByE_C;
	private FinderPath _finderPathWithoutPaginationFindByE_C;
	private FinderPath _finderPathCountByE_C;

	/**
	 * Returns all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @return the matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByE_C(String entryId, String classEntry) {
		return findByE_C(
			entryId, classEntry, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end) {

		return findByE_C(entryId, classEntry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return findByE_C(
			entryId, classEntry, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByE_C(
		String entryId, String classEntry, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		entryId = Objects.toString(entryId, "");
		classEntry = Objects.toString(classEntry, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByE_C;
				finderArgs = new Object[] {entryId, classEntry};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByE_C;
			finderArgs = new Object[] {
				entryId, classEntry, start, end, orderByComparator
			};
		}

		List<LegalLogger> list = null;

		if (useFinderCache) {
			list = (List<LegalLogger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLogger legalLogger : list) {
					if (!entryId.equals(legalLogger.getEntryId()) ||
						!classEntry.equals(legalLogger.getClassEntry())) {

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

			query.append(_SQL_SELECT_LEGALLOGGER_WHERE);

			boolean bindEntryId = false;

			if (entryId.isEmpty()) {
				query.append(_FINDER_COLUMN_E_C_ENTRYID_3);
			}
			else {
				bindEntryId = true;

				query.append(_FINDER_COLUMN_E_C_ENTRYID_2);
			}

			boolean bindClassEntry = false;

			if (classEntry.isEmpty()) {
				query.append(_FINDER_COLUMN_E_C_CLASSENTRY_3);
			}
			else {
				bindClassEntry = true;

				query.append(_FINDER_COLUMN_E_C_CLASSENTRY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLoggerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEntryId) {
					qPos.add(entryId);
				}

				if (bindClassEntry) {
					qPos.add(classEntry);
				}

				list = (List<LegalLogger>)QueryUtil.list(
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
	 * Returns the first legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger findByE_C_First(
			String entryId, String classEntry,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByE_C_First(
			entryId, classEntry, orderByComparator);

		if (legalLogger != null) {
			return legalLogger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entryId=");
		msg.append(entryId);

		msg.append(", classEntry=");
		msg.append(classEntry);

		msg.append("}");

		throw new NoSuchLegalLoggerException(msg.toString());
	}

	/**
	 * Returns the first legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger fetchByE_C_First(
		String entryId, String classEntry,
		OrderByComparator<LegalLogger> orderByComparator) {

		List<LegalLogger> list = findByE_C(
			entryId, classEntry, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger findByE_C_Last(
			String entryId, String classEntry,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByE_C_Last(
			entryId, classEntry, orderByComparator);

		if (legalLogger != null) {
			return legalLogger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("entryId=");
		msg.append(entryId);

		msg.append(", classEntry=");
		msg.append(classEntry);

		msg.append("}");

		throw new NoSuchLegalLoggerException(msg.toString());
	}

	/**
	 * Returns the last legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger fetchByE_C_Last(
		String entryId, String classEntry,
		OrderByComparator<LegalLogger> orderByComparator) {

		int count = countByE_C(entryId, classEntry);

		if (count == 0) {
			return null;
		}

		List<LegalLogger> list = findByE_C(
			entryId, classEntry, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal loggers before and after the current legal logger in the ordered set where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param loggerId the primary key of the current legal logger
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger[] findByE_C_PrevAndNext(
			String loggerId, String entryId, String classEntry,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		entryId = Objects.toString(entryId, "");
		classEntry = Objects.toString(classEntry, "");

		LegalLogger legalLogger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			LegalLogger[] array = new LegalLoggerImpl[3];

			array[0] = getByE_C_PrevAndNext(
				session, legalLogger, entryId, classEntry, orderByComparator,
				true);

			array[1] = legalLogger;

			array[2] = getByE_C_PrevAndNext(
				session, legalLogger, entryId, classEntry, orderByComparator,
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

	protected LegalLogger getByE_C_PrevAndNext(
		Session session, LegalLogger legalLogger, String entryId,
		String classEntry, OrderByComparator<LegalLogger> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLOGGER_WHERE);

		boolean bindEntryId = false;

		if (entryId.isEmpty()) {
			query.append(_FINDER_COLUMN_E_C_ENTRYID_3);
		}
		else {
			bindEntryId = true;

			query.append(_FINDER_COLUMN_E_C_ENTRYID_2);
		}

		boolean bindClassEntry = false;

		if (classEntry.isEmpty()) {
			query.append(_FINDER_COLUMN_E_C_CLASSENTRY_3);
		}
		else {
			bindClassEntry = true;

			query.append(_FINDER_COLUMN_E_C_CLASSENTRY_2);
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
			query.append(LegalLoggerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEntryId) {
			qPos.add(entryId);
		}

		if (bindClassEntry) {
			qPos.add(classEntry);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalLogger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLogger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal loggers where entryId = &#63; and classEntry = &#63; from the database.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 */
	@Override
	public void removeByE_C(String entryId, String classEntry) {
		for (LegalLogger legalLogger :
				findByE_C(
					entryId, classEntry, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalLogger);
		}
	}

	/**
	 * Returns the number of legal loggers where entryId = &#63; and classEntry = &#63;.
	 *
	 * @param entryId the entry ID
	 * @param classEntry the class entry
	 * @return the number of matching legal loggers
	 */
	@Override
	public int countByE_C(String entryId, String classEntry) {
		entryId = Objects.toString(entryId, "");
		classEntry = Objects.toString(classEntry, "");

		FinderPath finderPath = _finderPathCountByE_C;

		Object[] finderArgs = new Object[] {entryId, classEntry};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALLOGGER_WHERE);

			boolean bindEntryId = false;

			if (entryId.isEmpty()) {
				query.append(_FINDER_COLUMN_E_C_ENTRYID_3);
			}
			else {
				bindEntryId = true;

				query.append(_FINDER_COLUMN_E_C_ENTRYID_2);
			}

			boolean bindClassEntry = false;

			if (classEntry.isEmpty()) {
				query.append(_FINDER_COLUMN_E_C_CLASSENTRY_3);
			}
			else {
				bindClassEntry = true;

				query.append(_FINDER_COLUMN_E_C_CLASSENTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEntryId) {
					qPos.add(entryId);
				}

				if (bindClassEntry) {
					qPos.add(classEntry);
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

	private static final String _FINDER_COLUMN_E_C_ENTRYID_2 =
		"legalLogger.entryId = ? AND ";

	private static final String _FINDER_COLUMN_E_C_ENTRYID_3 =
		"(legalLogger.entryId IS NULL OR legalLogger.entryId = '') AND ";

	private static final String _FINDER_COLUMN_E_C_CLASSENTRY_2 =
		"legalLogger.classEntry = ?";

	private static final String _FINDER_COLUMN_E_C_CLASSENTRY_3 =
		"(legalLogger.classEntry IS NULL OR legalLogger.classEntry = '')";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByFindAll(long groupId, long companyId) {
		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal loggers
	 */
	@Override
	public List<LegalLogger> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLogger> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindAll;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindAll;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<LegalLogger> list = null;

		if (useFinderCache) {
			list = (List<LegalLogger>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLogger legalLogger : list) {
					if ((groupId != legalLogger.getGroupId()) ||
						(companyId != legalLogger.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALLOGGER_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLoggerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalLogger>)QueryUtil.list(
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
	 * Returns the first legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalLogger != null) {
			return legalLogger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalLoggerException(msg.toString());
	}

	/**
	 * Returns the first legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalLogger> orderByComparator) {

		List<LegalLogger> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger
	 * @throws NoSuchLegalLoggerException if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalLogger != null) {
			return legalLogger;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalLoggerException(msg.toString());
	}

	/**
	 * Returns the last legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal logger, or <code>null</code> if a matching legal logger could not be found
	 */
	@Override
	public LegalLogger fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalLogger> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalLogger> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal loggers before and after the current legal logger in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param loggerId the primary key of the current legal logger
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger[] findByFindAll_PrevAndNext(
			String loggerId, long groupId, long companyId,
			OrderByComparator<LegalLogger> orderByComparator)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			LegalLogger[] array = new LegalLoggerImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalLogger, groupId, companyId, orderByComparator,
				true);

			array[1] = legalLogger;

			array[2] = getByFindAll_PrevAndNext(
				session, legalLogger, groupId, companyId, orderByComparator,
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

	protected LegalLogger getByFindAll_PrevAndNext(
		Session session, LegalLogger legalLogger, long groupId, long companyId,
		OrderByComparator<LegalLogger> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALLOGGER_WHERE);

		query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

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
			query.append(LegalLoggerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalLogger)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLogger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal loggers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalLogger legalLogger :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalLogger);
		}
	}

	/**
	 * Returns the number of legal loggers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal loggers
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALLOGGER_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_FINDALL_GROUPID_2 =
		"legalLogger.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalLogger.companyId = ?";

	public LegalLoggerPersistenceImpl() {
		setModelClass(LegalLogger.class);

		setModelImplClass(LegalLoggerImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the legal logger in the entity cache if it is enabled.
	 *
	 * @param legalLogger the legal logger
	 */
	@Override
	public void cacheResult(LegalLogger legalLogger) {
		entityCache.putResult(
			entityCacheEnabled, LegalLoggerImpl.class,
			legalLogger.getPrimaryKey(), legalLogger);

		legalLogger.resetOriginalValues();
	}

	/**
	 * Caches the legal loggers in the entity cache if it is enabled.
	 *
	 * @param legalLoggers the legal loggers
	 */
	@Override
	public void cacheResult(List<LegalLogger> legalLoggers) {
		for (LegalLogger legalLogger : legalLoggers) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalLoggerImpl.class,
					legalLogger.getPrimaryKey()) == null) {

				cacheResult(legalLogger);
			}
			else {
				legalLogger.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal loggers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalLoggerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal logger.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalLogger legalLogger) {
		entityCache.removeResult(
			entityCacheEnabled, LegalLoggerImpl.class,
			legalLogger.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalLogger> legalLoggers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalLogger legalLogger : legalLoggers) {
			entityCache.removeResult(
				entityCacheEnabled, LegalLoggerImpl.class,
				legalLogger.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalLoggerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal logger with the primary key. Does not add the legal logger to the database.
	 *
	 * @param loggerId the primary key for the new legal logger
	 * @return the new legal logger
	 */
	@Override
	public LegalLogger create(String loggerId) {
		LegalLogger legalLogger = new LegalLoggerImpl();

		legalLogger.setNew(true);
		legalLogger.setPrimaryKey(loggerId);

		legalLogger.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalLogger;
	}

	/**
	 * Removes the legal logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger that was removed
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger remove(String loggerId)
		throws NoSuchLegalLoggerException {

		return remove((Serializable)loggerId);
	}

	/**
	 * Removes the legal logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal logger
	 * @return the legal logger that was removed
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger remove(Serializable primaryKey)
		throws NoSuchLegalLoggerException {

		Session session = null;

		try {
			session = openSession();

			LegalLogger legalLogger = (LegalLogger)session.get(
				LegalLoggerImpl.class, primaryKey);

			if (legalLogger == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalLoggerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalLogger);
		}
		catch (NoSuchLegalLoggerException noSuchEntityException) {
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
	protected LegalLogger removeImpl(LegalLogger legalLogger) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalLogger)) {
				legalLogger = (LegalLogger)session.get(
					LegalLoggerImpl.class, legalLogger.getPrimaryKeyObj());
			}

			if (legalLogger != null) {
				session.delete(legalLogger);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalLogger != null) {
			clearCache(legalLogger);
		}

		return legalLogger;
	}

	@Override
	public LegalLogger updateImpl(LegalLogger legalLogger) {
		boolean isNew = legalLogger.isNew();

		if (!(legalLogger instanceof LegalLoggerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalLogger.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalLogger);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalLogger proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalLogger implementation " +
					legalLogger.getClass());
		}

		LegalLoggerModelImpl legalLoggerModelImpl =
			(LegalLoggerModelImpl)legalLogger;

		Session session = null;

		try {
			session = openSession();

			if (legalLogger.isNew()) {
				session.save(legalLogger);

				legalLogger.setNew(false);
			}
			else {
				legalLogger = (LegalLogger)session.merge(legalLogger);
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
				legalLoggerModelImpl.getCreatedByUser(),
				legalLoggerModelImpl.getCreatedDate()
			};

			finderCache.removeResult(_finderPathCountByU_D, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByU_D, args);

			args = new Object[] {
				legalLoggerModelImpl.getEntryId(),
				legalLoggerModelImpl.getClassEntry()
			};

			finderCache.removeResult(_finderPathCountByE_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByE_C, args);

			args = new Object[] {
				legalLoggerModelImpl.getGroupId(),
				legalLoggerModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalLoggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByU_D.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalLoggerModelImpl.getOriginalCreatedByUser(),
					legalLoggerModelImpl.getOriginalCreatedDate()
				};

				finderCache.removeResult(_finderPathCountByU_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_D, args);

				args = new Object[] {
					legalLoggerModelImpl.getCreatedByUser(),
					legalLoggerModelImpl.getCreatedDate()
				};

				finderCache.removeResult(_finderPathCountByU_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_D, args);
			}

			if ((legalLoggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByE_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalLoggerModelImpl.getOriginalEntryId(),
					legalLoggerModelImpl.getOriginalClassEntry()
				};

				finderCache.removeResult(_finderPathCountByE_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByE_C, args);

				args = new Object[] {
					legalLoggerModelImpl.getEntryId(),
					legalLoggerModelImpl.getClassEntry()
				};

				finderCache.removeResult(_finderPathCountByE_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByE_C, args);
			}

			if ((legalLoggerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalLoggerModelImpl.getOriginalGroupId(),
					legalLoggerModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalLoggerModelImpl.getGroupId(),
					legalLoggerModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalLoggerImpl.class,
			legalLogger.getPrimaryKey(), legalLogger, false);

		legalLogger.resetOriginalValues();

		return legalLogger;
	}

	/**
	 * Returns the legal logger with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal logger
	 * @return the legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalLoggerException {

		LegalLogger legalLogger = fetchByPrimaryKey(primaryKey);

		if (legalLogger == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalLoggerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalLogger;
	}

	/**
	 * Returns the legal logger with the primary key or throws a <code>NoSuchLegalLoggerException</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger
	 * @throws NoSuchLegalLoggerException if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger findByPrimaryKey(String loggerId)
		throws NoSuchLegalLoggerException {

		return findByPrimaryKey((Serializable)loggerId);
	}

	/**
	 * Returns the legal logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the legal logger
	 * @return the legal logger, or <code>null</code> if a legal logger with the primary key could not be found
	 */
	@Override
	public LegalLogger fetchByPrimaryKey(String loggerId) {
		return fetchByPrimaryKey((Serializable)loggerId);
	}

	/**
	 * Returns all the legal loggers.
	 *
	 * @return the legal loggers
	 */
	@Override
	public List<LegalLogger> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @return the range of legal loggers
	 */
	@Override
	public List<LegalLogger> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal loggers
	 */
	@Override
	public List<LegalLogger> findAll(
		int start, int end, OrderByComparator<LegalLogger> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLoggerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal loggers
	 * @param end the upper bound of the range of legal loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal loggers
	 */
	@Override
	public List<LegalLogger> findAll(
		int start, int end, OrderByComparator<LegalLogger> orderByComparator,
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

		List<LegalLogger> list = null;

		if (useFinderCache) {
			list = (List<LegalLogger>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALLOGGER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALLOGGER;

				sql = sql.concat(LegalLoggerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalLogger>)QueryUtil.list(
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
	 * Removes all the legal loggers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalLogger legalLogger : findAll()) {
			remove(legalLogger);
		}
	}

	/**
	 * Returns the number of legal loggers.
	 *
	 * @return the number of legal loggers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALLOGGER);

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
		return "loggerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALLOGGER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalLoggerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal logger persistence.
	 */
	@Activate
	public void activate() {
		LegalLoggerModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalLoggerModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByU_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_D",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByU_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_D",
			new String[] {String.class.getName(), Date.class.getName()},
			LegalLoggerModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			LegalLoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByU_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_D",
			new String[] {String.class.getName(), Date.class.getName()});

		_finderPathWithPaginationFindByE_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByE_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByE_C",
			new String[] {String.class.getName(), String.class.getName()},
			LegalLoggerModelImpl.ENTRYID_COLUMN_BITMASK |
			LegalLoggerModelImpl.CLASSENTRY_COLUMN_BITMASK |
			LegalLoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByE_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_C",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalLoggerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLoggerModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalLoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalLoggerImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalLogger"),
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_LEGALLOGGER =
		"SELECT legalLogger FROM LegalLogger legalLogger";

	private static final String _SQL_SELECT_LEGALLOGGER_WHERE =
		"SELECT legalLogger FROM LegalLogger legalLogger WHERE ";

	private static final String _SQL_COUNT_LEGALLOGGER =
		"SELECT COUNT(legalLogger) FROM LegalLogger legalLogger";

	private static final String _SQL_COUNT_LEGALLOGGER_WHERE =
		"SELECT COUNT(legalLogger) FROM LegalLogger legalLogger WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalLogger.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalLogger exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalLogger exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalLoggerPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}