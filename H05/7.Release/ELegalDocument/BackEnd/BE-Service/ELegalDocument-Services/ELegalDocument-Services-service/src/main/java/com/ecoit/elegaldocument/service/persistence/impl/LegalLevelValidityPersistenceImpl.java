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

import com.ecoit.elegaldocument.exception.NoSuchLegalLevelValidityException;
import com.ecoit.elegaldocument.model.LegalLevelValidity;
import com.ecoit.elegaldocument.model.impl.LegalLevelValidityImpl;
import com.ecoit.elegaldocument.model.impl.LegalLevelValidityModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalLevelValidityPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the legal level validity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalLevelValidityPersistence.class)
public class LegalLevelValidityPersistenceImpl
	extends BasePersistenceImpl<LegalLevelValidity>
	implements LegalLevelValidityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalLevelValidityUtil</code> to access the legal level validity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalLevelValidityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByLevelValidityId;
	private FinderPath _finderPathCountByLevelValidityId;

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByLevelValidityId(long levelValidityId)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByLevelValidityId(
			levelValidityId);

		if (legalLevelValidity == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("levelValidityId=");
			msg.append(levelValidityId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalLevelValidityException(msg.toString());
		}

		return legalLevelValidity;
	}

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByLevelValidityId(long levelValidityId) {
		return fetchByLevelValidityId(levelValidityId, true);
	}

	/**
	 * Returns the legal level validity where levelValidityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param levelValidityId the level validity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByLevelValidityId(
		long levelValidityId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {levelValidityId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByLevelValidityId, finderArgs, this);
		}

		if (result instanceof LegalLevelValidity) {
			LegalLevelValidity legalLevelValidity = (LegalLevelValidity)result;

			if (levelValidityId != legalLevelValidity.getLevelValidityId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_LEVELVALIDITYID_LEVELVALIDITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelValidityId);

				List<LegalLevelValidity> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByLevelValidityId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {levelValidityId};
							}

							_log.warn(
								"LegalLevelValidityPersistenceImpl.fetchByLevelValidityId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalLevelValidity legalLevelValidity = list.get(0);

					result = legalLevelValidity;

					cacheResult(legalLevelValidity);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByLevelValidityId, finderArgs);
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
			return (LegalLevelValidity)result;
		}
	}

	/**
	 * Removes the legal level validity where levelValidityId = &#63; from the database.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the legal level validity that was removed
	 */
	@Override
	public LegalLevelValidity removeByLevelValidityId(long levelValidityId)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = findByLevelValidityId(
			levelValidityId);

		return remove(legalLevelValidity);
	}

	/**
	 * Returns the number of legal level validities where levelValidityId = &#63;.
	 *
	 * @param levelValidityId the level validity ID
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByLevelValidityId(long levelValidityId) {
		FinderPath finderPath = _finderPathCountByLevelValidityId;

		Object[] finderArgs = new Object[] {levelValidityId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_LEVELVALIDITYID_LEVELVALIDITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelValidityId);

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
		_FINDER_COLUMN_LEVELVALIDITYID_LEVELVALIDITYID_2 =
			"legalLevelValidity.levelValidityId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal level validities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLevelValidity legalLevelValidity : list) {
					if (groupId != legalLevelValidity.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Returns the first legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByGroupId_First(
			long groupId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByGroupId_First(
			groupId, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByGroupId_First(
		long groupId, OrderByComparator<LegalLevelValidity> orderByComparator) {

		List<LegalLevelValidity> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByGroupId_Last(
			long groupId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalLevelValidity> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalLevelValidity> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity[] findByGroupId_PrevAndNext(
			long levelValidityId, long groupId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = findByPrimaryKey(
			levelValidityId);

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity[] array = new LegalLevelValidityImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalLevelValidity, groupId, orderByComparator, true);

			array[1] = legalLevelValidity;

			array[2] = getByGroupId_PrevAndNext(
				session, legalLevelValidity, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalLevelValidity getByGroupId_PrevAndNext(
		Session session, LegalLevelValidity legalLevelValidity, long groupId,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalLevelValidity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLevelValidity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalLevelValidity legalLevelValidity :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"legalLevelValidity.groupId = ?";

	private FinderPath _finderPathFetchByG_LV;
	private FinderPath _finderPathCountByG_LV;

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByG_LV(long groupId, long levelValidityId)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByG_LV(
			groupId, levelValidityId);

		if (legalLevelValidity == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", levelValidityId=");
			msg.append(levelValidityId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalLevelValidityException(msg.toString());
		}

		return legalLevelValidity;
	}

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByG_LV(long groupId, long levelValidityId) {
		return fetchByG_LV(groupId, levelValidityId, true);
	}

	/**
	 * Returns the legal level validity where groupId = &#63; and levelValidityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByG_LV(
		long groupId, long levelValidityId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, levelValidityId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_LV, finderArgs, this);
		}

		if (result instanceof LegalLevelValidity) {
			LegalLevelValidity legalLevelValidity = (LegalLevelValidity)result;

			if ((groupId != legalLevelValidity.getGroupId()) ||
				(levelValidityId != legalLevelValidity.getLevelValidityId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_G_LV_GROUPID_2);

			query.append(_FINDER_COLUMN_G_LV_LEVELVALIDITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(levelValidityId);

				List<LegalLevelValidity> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_LV, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, levelValidityId
								};
							}

							_log.warn(
								"LegalLevelValidityPersistenceImpl.fetchByG_LV(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalLevelValidity legalLevelValidity = list.get(0);

					result = legalLevelValidity;

					cacheResult(legalLevelValidity);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByG_LV, finderArgs);
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
			return (LegalLevelValidity)result;
		}
	}

	/**
	 * Removes the legal level validity where groupId = &#63; and levelValidityId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the legal level validity that was removed
	 */
	@Override
	public LegalLevelValidity removeByG_LV(long groupId, long levelValidityId)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = findByG_LV(
			groupId, levelValidityId);

		return remove(legalLevelValidity);
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and levelValidityId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param levelValidityId the level validity ID
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByG_LV(long groupId, long levelValidityId) {
		FinderPath finderPath = _finderPathCountByG_LV;

		Object[] finderArgs = new Object[] {groupId, levelValidityId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_G_LV_GROUPID_2);

			query.append(_FINDER_COLUMN_G_LV_LEVELVALIDITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(levelValidityId);

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

	private static final String _FINDER_COLUMN_G_LV_GROUPID_2 =
		"legalLevelValidity.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_LV_LEVELVALIDITYID_2 =
		"legalLevelValidity.levelValidityId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L;
				finderArgs = new Object[] {groupId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L;
			finderArgs = new Object[] {
				groupId, language, start, end, orderByComparator
			};
		}

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLevelValidity legalLevelValidity : list) {
					if ((groupId != legalLevelValidity.getGroupId()) ||
						!language.equals(legalLevelValidity.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		List<LegalLevelValidity> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalLevelValidity> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity[] findByG_L_PrevAndNext(
			long levelValidityId, long groupId, String language,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		language = Objects.toString(language, "");

		LegalLevelValidity legalLevelValidity = findByPrimaryKey(
			levelValidityId);

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity[] array = new LegalLevelValidityImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalLevelValidity, groupId, language,
				orderByComparator, true);

			array[1] = legalLevelValidity;

			array[2] = getByG_L_PrevAndNext(
				session, legalLevelValidity, groupId, language,
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

	protected LegalLevelValidity getByG_L_PrevAndNext(
		Session session, LegalLevelValidity legalLevelValidity, long groupId,
		String language,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

		query.append(_FINDER_COLUMN_G_L_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
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
			query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						legalLevelValidity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLevelValidity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalLevelValidity legalLevelValidity :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
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

	private static final String _FINDER_COLUMN_G_L_GROUPID_2 =
		"legalLevelValidity.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalLevelValidity.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalLevelValidity.language IS NULL OR legalLevelValidity.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_L_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_S;
	private FinderPath _finderPathCountByG_L_S;

	/**
	 * Returns all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity) {

		return findByG_L_S(
			groupId, language, statusLevelValidity, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end) {

		return findByG_L_S(
			groupId, language, statusLevelValidity, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findByG_L_S(
			groupId, language, statusLevelValidity, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByG_L_S(
		long groupId, String language, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_S;
				finderArgs = new Object[] {
					groupId, language, statusLevelValidity
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_S;
			finderArgs = new Object[] {
				groupId, language, statusLevelValidity, start, end,
				orderByComparator
			};
		}

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLevelValidity legalLevelValidity : list) {
					if ((groupId != legalLevelValidity.getGroupId()) ||
						!language.equals(legalLevelValidity.getLanguage()) ||
						(statusLevelValidity !=
							legalLevelValidity.isStatusLevelValidity())) {

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

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_G_L_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_S_STATUSLEVELVALIDITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusLevelValidity);

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByG_L_S_First(
			long groupId, String language, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByG_L_S_First(
			groupId, language, statusLevelValidity, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusLevelValidity=");
		msg.append(statusLevelValidity);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByG_L_S_First(
		long groupId, String language, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		List<LegalLevelValidity> list = findByG_L_S(
			groupId, language, statusLevelValidity, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByG_L_S_Last(
			long groupId, String language, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByG_L_S_Last(
			groupId, language, statusLevelValidity, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusLevelValidity=");
		msg.append(statusLevelValidity);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByG_L_S_Last(
		long groupId, String language, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		int count = countByG_L_S(groupId, language, statusLevelValidity);

		if (count == 0) {
			return null;
		}

		List<LegalLevelValidity> list = findByG_L_S(
			groupId, language, statusLevelValidity, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity[] findByG_L_S_PrevAndNext(
			long levelValidityId, long groupId, String language,
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		language = Objects.toString(language, "");

		LegalLevelValidity legalLevelValidity = findByPrimaryKey(
			levelValidityId);

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity[] array = new LegalLevelValidityImpl[3];

			array[0] = getByG_L_S_PrevAndNext(
				session, legalLevelValidity, groupId, language,
				statusLevelValidity, orderByComparator, true);

			array[1] = legalLevelValidity;

			array[2] = getByG_L_S_PrevAndNext(
				session, legalLevelValidity, groupId, language,
				statusLevelValidity, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalLevelValidity getByG_L_S_PrevAndNext(
		Session session, LegalLevelValidity legalLevelValidity, long groupId,
		String language, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

		query.append(_FINDER_COLUMN_G_L_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_S_STATUSLEVELVALIDITY_2);

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
			query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
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

		qPos.add(statusLevelValidity);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalLevelValidity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLevelValidity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 */
	@Override
	public void removeByG_L_S(
		long groupId, String language, boolean statusLevelValidity) {

		for (LegalLevelValidity legalLevelValidity :
				findByG_L_S(
					groupId, language, statusLevelValidity, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and language = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByG_L_S(
		long groupId, String language, boolean statusLevelValidity) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_S;

		Object[] finderArgs = new Object[] {
			groupId, language, statusLevelValidity
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_G_L_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_S_STATUSLEVELVALIDITY_2);

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

				qPos.add(statusLevelValidity);

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

	private static final String _FINDER_COLUMN_G_L_S_GROUPID_2 =
		"legalLevelValidity.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_S_LANGUAGE_2 =
		"legalLevelValidity.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_S_LANGUAGE_3 =
		"(legalLevelValidity.language IS NULL OR legalLevelValidity.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_S_STATUSLEVELVALIDITY_2 =
		"legalLevelValidity.statusLevelValidity = ?";

	private FinderPath _finderPathWithPaginationFindByStatusLevelValidity;
	private FinderPath _finderPathWithoutPaginationFindByStatusLevelValidity;
	private FinderPath _finderPathCountByStatusLevelValidity;

	/**
	 * Returns all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity) {

		return findByStatusLevelValidity(
			statusLevelValidity, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end) {

		return findByStatusLevelValidity(statusLevelValidity, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findByStatusLevelValidity(
			statusLevelValidity, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities where statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByStatusLevelValidity(
		boolean statusLevelValidity, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByStatusLevelValidity;
				finderArgs = new Object[] {statusLevelValidity};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusLevelValidity;
			finderArgs = new Object[] {
				statusLevelValidity, start, end, orderByComparator
			};
		}

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLevelValidity legalLevelValidity : list) {
					if (statusLevelValidity !=
							legalLevelValidity.isStatusLevelValidity()) {

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

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(
				_FINDER_COLUMN_STATUSLEVELVALIDITY_STATUSLEVELVALIDITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusLevelValidity);

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Returns the first legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByStatusLevelValidity_First(
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity =
			fetchByStatusLevelValidity_First(
				statusLevelValidity, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusLevelValidity=");
		msg.append(statusLevelValidity);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the first legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByStatusLevelValidity_First(
		boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		List<LegalLevelValidity> list = findByStatusLevelValidity(
			statusLevelValidity, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByStatusLevelValidity_Last(
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByStatusLevelValidity_Last(
			statusLevelValidity, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusLevelValidity=");
		msg.append(statusLevelValidity);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the last legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByStatusLevelValidity_Last(
		boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		int count = countByStatusLevelValidity(statusLevelValidity);

		if (count == 0) {
			return null;
		}

		List<LegalLevelValidity> list = findByStatusLevelValidity(
			statusLevelValidity, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity[] findByStatusLevelValidity_PrevAndNext(
			long levelValidityId, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = findByPrimaryKey(
			levelValidityId);

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity[] array = new LegalLevelValidityImpl[3];

			array[0] = getByStatusLevelValidity_PrevAndNext(
				session, legalLevelValidity, statusLevelValidity,
				orderByComparator, true);

			array[1] = legalLevelValidity;

			array[2] = getByStatusLevelValidity_PrevAndNext(
				session, legalLevelValidity, statusLevelValidity,
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

	protected LegalLevelValidity getByStatusLevelValidity_PrevAndNext(
		Session session, LegalLevelValidity legalLevelValidity,
		boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

		query.append(_FINDER_COLUMN_STATUSLEVELVALIDITY_STATUSLEVELVALIDITY_2);

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
			query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusLevelValidity);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalLevelValidity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLevelValidity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal level validities where statusLevelValidity = &#63; from the database.
	 *
	 * @param statusLevelValidity the status level validity
	 */
	@Override
	public void removeByStatusLevelValidity(boolean statusLevelValidity) {
		for (LegalLevelValidity legalLevelValidity :
				findByStatusLevelValidity(
					statusLevelValidity, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities where statusLevelValidity = &#63;.
	 *
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByStatusLevelValidity(boolean statusLevelValidity) {
		FinderPath finderPath = _finderPathCountByStatusLevelValidity;

		Object[] finderArgs = new Object[] {statusLevelValidity};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(
				_FINDER_COLUMN_STATUSLEVELVALIDITY_STATUSLEVELVALIDITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusLevelValidity);

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
		_FINDER_COLUMN_STATUSLEVELVALIDITY_STATUSLEVELVALIDITY_2 =
			"legalLevelValidity.statusLevelValidity = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @return the matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity) {

		return findByFindGroup(
			groupId, companyId, statusLevelValidity, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end) {

		return findByFindGroup(
			groupId, companyId, statusLevelValidity, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, statusLevelValidity, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity, int start,
		int end, OrderByComparator<LegalLevelValidity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {
					groupId, companyId, statusLevelValidity
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, statusLevelValidity, start, end,
				orderByComparator
			};
		}

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLevelValidity legalLevelValidity : list) {
					if ((groupId != legalLevelValidity.getGroupId()) ||
						(companyId != legalLevelValidity.getCompanyId()) ||
						(statusLevelValidity !=
							legalLevelValidity.isStatusLevelValidity())) {

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

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSLEVELVALIDITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusLevelValidity);

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByFindGroup_First(
			long groupId, long companyId, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByFindGroup_First(
			groupId, companyId, statusLevelValidity, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusLevelValidity=");
		msg.append(statusLevelValidity);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByFindGroup_First(
		long groupId, long companyId, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		List<LegalLevelValidity> list = findByFindGroup(
			groupId, companyId, statusLevelValidity, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByFindGroup_Last(
			long groupId, long companyId, boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByFindGroup_Last(
			groupId, companyId, statusLevelValidity, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusLevelValidity=");
		msg.append(statusLevelValidity);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		int count = countByFindGroup(groupId, companyId, statusLevelValidity);

		if (count == 0) {
			return null;
		}

		List<LegalLevelValidity> list = findByFindGroup(
			groupId, companyId, statusLevelValidity, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity[] findByFindGroup_PrevAndNext(
			long levelValidityId, long groupId, long companyId,
			boolean statusLevelValidity,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = findByPrimaryKey(
			levelValidityId);

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity[] array = new LegalLevelValidityImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalLevelValidity, groupId, companyId,
				statusLevelValidity, orderByComparator, true);

			array[1] = legalLevelValidity;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalLevelValidity, groupId, companyId,
				statusLevelValidity, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalLevelValidity getByFindGroup_PrevAndNext(
		Session session, LegalLevelValidity legalLevelValidity, long groupId,
		long companyId, boolean statusLevelValidity,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_STATUSLEVELVALIDITY_2);

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
			query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusLevelValidity);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalLevelValidity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLevelValidity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 */
	@Override
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity) {

		for (LegalLevelValidity legalLevelValidity :
				findByFindGroup(
					groupId, companyId, statusLevelValidity, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and companyId = &#63; and statusLevelValidity = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusLevelValidity the status level validity
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByFindGroup(
		long groupId, long companyId, boolean statusLevelValidity) {

		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {
			groupId, companyId, statusLevelValidity
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSLEVELVALIDITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusLevelValidity);

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

	private static final String _FINDER_COLUMN_FINDGROUP_GROUPID_2 =
		"legalLevelValidity.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalLevelValidity.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_STATUSLEVELVALIDITY_2 =
		"legalLevelValidity.statusLevelValidity = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId) {

		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalLevelValidity legalLevelValidity : list) {
					if ((groupId != legalLevelValidity.getGroupId()) ||
						(companyId != legalLevelValidity.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the first legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		List<LegalLevelValidity> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity
	 * @throws NoSuchLegalLevelValidityException if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalLevelValidity != null) {
			return legalLevelValidity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalLevelValidityException(msg.toString());
	}

	/**
	 * Returns the last legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal level validity, or <code>null</code> if a matching legal level validity could not be found
	 */
	@Override
	public LegalLevelValidity fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalLevelValidity> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal level validities before and after the current legal level validity in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param levelValidityId the primary key of the current legal level validity
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity[] findByFindAll_PrevAndNext(
			long levelValidityId, long groupId, long companyId,
			OrderByComparator<LegalLevelValidity> orderByComparator)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = findByPrimaryKey(
			levelValidityId);

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity[] array = new LegalLevelValidityImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalLevelValidity, groupId, companyId,
				orderByComparator, true);

			array[1] = legalLevelValidity;

			array[2] = getByFindAll_PrevAndNext(
				session, legalLevelValidity, groupId, companyId,
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

	protected LegalLevelValidity getByFindAll_PrevAndNext(
		Session session, LegalLevelValidity legalLevelValidity, long groupId,
		long companyId, OrderByComparator<LegalLevelValidity> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALLEVELVALIDITY_WHERE);

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
			query.append(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						legalLevelValidity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalLevelValidity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal level validities where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalLevelValidity legalLevelValidity :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal level validities
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALLEVELVALIDITY_WHERE);

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
		"legalLevelValidity.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalLevelValidity.companyId = ?";

	public LegalLevelValidityPersistenceImpl() {
		setModelClass(LegalLevelValidity.class);

		setModelImplClass(LegalLevelValidityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal level validity in the entity cache if it is enabled.
	 *
	 * @param legalLevelValidity the legal level validity
	 */
	@Override
	public void cacheResult(LegalLevelValidity legalLevelValidity) {
		entityCache.putResult(
			entityCacheEnabled, LegalLevelValidityImpl.class,
			legalLevelValidity.getPrimaryKey(), legalLevelValidity);

		finderCache.putResult(
			_finderPathFetchByLevelValidityId,
			new Object[] {legalLevelValidity.getLevelValidityId()},
			legalLevelValidity);

		finderCache.putResult(
			_finderPathFetchByG_LV,
			new Object[] {
				legalLevelValidity.getGroupId(),
				legalLevelValidity.getLevelValidityId()
			},
			legalLevelValidity);

		legalLevelValidity.resetOriginalValues();
	}

	/**
	 * Caches the legal level validities in the entity cache if it is enabled.
	 *
	 * @param legalLevelValidities the legal level validities
	 */
	@Override
	public void cacheResult(List<LegalLevelValidity> legalLevelValidities) {
		for (LegalLevelValidity legalLevelValidity : legalLevelValidities) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalLevelValidityImpl.class,
					legalLevelValidity.getPrimaryKey()) == null) {

				cacheResult(legalLevelValidity);
			}
			else {
				legalLevelValidity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal level validities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalLevelValidityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal level validity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalLevelValidity legalLevelValidity) {
		entityCache.removeResult(
			entityCacheEnabled, LegalLevelValidityImpl.class,
			legalLevelValidity.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(LegalLevelValidityModelImpl)legalLevelValidity, true);
	}

	@Override
	public void clearCache(List<LegalLevelValidity> legalLevelValidities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalLevelValidity legalLevelValidity : legalLevelValidities) {
			entityCache.removeResult(
				entityCacheEnabled, LegalLevelValidityImpl.class,
				legalLevelValidity.getPrimaryKey());

			clearUniqueFindersCache(
				(LegalLevelValidityModelImpl)legalLevelValidity, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalLevelValidityImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalLevelValidityModelImpl legalLevelValidityModelImpl) {

		Object[] args = new Object[] {
			legalLevelValidityModelImpl.getLevelValidityId()
		};

		finderCache.putResult(
			_finderPathCountByLevelValidityId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByLevelValidityId, args,
			legalLevelValidityModelImpl, false);

		args = new Object[] {
			legalLevelValidityModelImpl.getGroupId(),
			legalLevelValidityModelImpl.getLevelValidityId()
		};

		finderCache.putResult(
			_finderPathCountByG_LV, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_LV, args, legalLevelValidityModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalLevelValidityModelImpl legalLevelValidityModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalLevelValidityModelImpl.getLevelValidityId()
			};

			finderCache.removeResult(_finderPathCountByLevelValidityId, args);
			finderCache.removeResult(_finderPathFetchByLevelValidityId, args);
		}

		if ((legalLevelValidityModelImpl.getColumnBitmask() &
			 _finderPathFetchByLevelValidityId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalLevelValidityModelImpl.getOriginalLevelValidityId()
			};

			finderCache.removeResult(_finderPathCountByLevelValidityId, args);
			finderCache.removeResult(_finderPathFetchByLevelValidityId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalLevelValidityModelImpl.getGroupId(),
				legalLevelValidityModelImpl.getLevelValidityId()
			};

			finderCache.removeResult(_finderPathCountByG_LV, args);
			finderCache.removeResult(_finderPathFetchByG_LV, args);
		}

		if ((legalLevelValidityModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_LV.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalLevelValidityModelImpl.getOriginalGroupId(),
				legalLevelValidityModelImpl.getOriginalLevelValidityId()
			};

			finderCache.removeResult(_finderPathCountByG_LV, args);
			finderCache.removeResult(_finderPathFetchByG_LV, args);
		}
	}

	/**
	 * Creates a new legal level validity with the primary key. Does not add the legal level validity to the database.
	 *
	 * @param levelValidityId the primary key for the new legal level validity
	 * @return the new legal level validity
	 */
	@Override
	public LegalLevelValidity create(long levelValidityId) {
		LegalLevelValidity legalLevelValidity = new LegalLevelValidityImpl();

		legalLevelValidity.setNew(true);
		legalLevelValidity.setPrimaryKey(levelValidityId);

		legalLevelValidity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalLevelValidity;
	}

	/**
	 * Removes the legal level validity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity that was removed
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity remove(long levelValidityId)
		throws NoSuchLegalLevelValidityException {

		return remove((Serializable)levelValidityId);
	}

	/**
	 * Removes the legal level validity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal level validity
	 * @return the legal level validity that was removed
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity remove(Serializable primaryKey)
		throws NoSuchLegalLevelValidityException {

		Session session = null;

		try {
			session = openSession();

			LegalLevelValidity legalLevelValidity =
				(LegalLevelValidity)session.get(
					LegalLevelValidityImpl.class, primaryKey);

			if (legalLevelValidity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalLevelValidityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalLevelValidity);
		}
		catch (NoSuchLegalLevelValidityException noSuchEntityException) {
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
	protected LegalLevelValidity removeImpl(
		LegalLevelValidity legalLevelValidity) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalLevelValidity)) {
				legalLevelValidity = (LegalLevelValidity)session.get(
					LegalLevelValidityImpl.class,
					legalLevelValidity.getPrimaryKeyObj());
			}

			if (legalLevelValidity != null) {
				session.delete(legalLevelValidity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalLevelValidity != null) {
			clearCache(legalLevelValidity);
		}

		return legalLevelValidity;
	}

	@Override
	public LegalLevelValidity updateImpl(
		LegalLevelValidity legalLevelValidity) {

		boolean isNew = legalLevelValidity.isNew();

		if (!(legalLevelValidity instanceof LegalLevelValidityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalLevelValidity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalLevelValidity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalLevelValidity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalLevelValidity implementation " +
					legalLevelValidity.getClass());
		}

		LegalLevelValidityModelImpl legalLevelValidityModelImpl =
			(LegalLevelValidityModelImpl)legalLevelValidity;

		Session session = null;

		try {
			session = openSession();

			if (legalLevelValidity.isNew()) {
				session.save(legalLevelValidity);

				legalLevelValidity.setNew(false);
			}
			else {
				legalLevelValidity = (LegalLevelValidity)session.merge(
					legalLevelValidity);
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
				legalLevelValidityModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalLevelValidityModelImpl.getGroupId(),
				legalLevelValidityModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalLevelValidityModelImpl.getGroupId(),
				legalLevelValidityModelImpl.getLanguage(),
				legalLevelValidityModelImpl.isStatusLevelValidity()
			};

			finderCache.removeResult(_finderPathCountByG_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_S, args);

			args = new Object[] {
				legalLevelValidityModelImpl.isStatusLevelValidity()
			};

			finderCache.removeResult(
				_finderPathCountByStatusLevelValidity, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatusLevelValidity, args);

			args = new Object[] {
				legalLevelValidityModelImpl.getGroupId(),
				legalLevelValidityModelImpl.getCompanyId(),
				legalLevelValidityModelImpl.isStatusLevelValidity()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalLevelValidityModelImpl.getGroupId(),
				legalLevelValidityModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalLevelValidityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalLevelValidityModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalLevelValidityModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalLevelValidityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalLevelValidityModelImpl.getOriginalGroupId(),
					legalLevelValidityModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalLevelValidityModelImpl.getGroupId(),
					legalLevelValidityModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalLevelValidityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalLevelValidityModelImpl.getOriginalGroupId(),
					legalLevelValidityModelImpl.getOriginalLanguage(),
					legalLevelValidityModelImpl.getOriginalStatusLevelValidity()
				};

				finderCache.removeResult(_finderPathCountByG_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_S, args);

				args = new Object[] {
					legalLevelValidityModelImpl.getGroupId(),
					legalLevelValidityModelImpl.getLanguage(),
					legalLevelValidityModelImpl.isStatusLevelValidity()
				};

				finderCache.removeResult(_finderPathCountByG_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_S, args);
			}

			if ((legalLevelValidityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatusLevelValidity.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalLevelValidityModelImpl.getOriginalStatusLevelValidity()
				};

				finderCache.removeResult(
					_finderPathCountByStatusLevelValidity, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatusLevelValidity,
					args);

				args = new Object[] {
					legalLevelValidityModelImpl.isStatusLevelValidity()
				};

				finderCache.removeResult(
					_finderPathCountByStatusLevelValidity, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatusLevelValidity,
					args);
			}

			if ((legalLevelValidityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalLevelValidityModelImpl.getOriginalGroupId(),
					legalLevelValidityModelImpl.getOriginalCompanyId(),
					legalLevelValidityModelImpl.getOriginalStatusLevelValidity()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalLevelValidityModelImpl.getGroupId(),
					legalLevelValidityModelImpl.getCompanyId(),
					legalLevelValidityModelImpl.isStatusLevelValidity()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalLevelValidityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalLevelValidityModelImpl.getOriginalGroupId(),
					legalLevelValidityModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalLevelValidityModelImpl.getGroupId(),
					legalLevelValidityModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalLevelValidityImpl.class,
			legalLevelValidity.getPrimaryKey(), legalLevelValidity, false);

		clearUniqueFindersCache(legalLevelValidityModelImpl, false);
		cacheUniqueFindersCache(legalLevelValidityModelImpl);

		legalLevelValidity.resetOriginalValues();

		return legalLevelValidity;
	}

	/**
	 * Returns the legal level validity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal level validity
	 * @return the legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalLevelValidityException {

		LegalLevelValidity legalLevelValidity = fetchByPrimaryKey(primaryKey);

		if (legalLevelValidity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalLevelValidityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalLevelValidity;
	}

	/**
	 * Returns the legal level validity with the primary key or throws a <code>NoSuchLegalLevelValidityException</code> if it could not be found.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity
	 * @throws NoSuchLegalLevelValidityException if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity findByPrimaryKey(long levelValidityId)
		throws NoSuchLegalLevelValidityException {

		return findByPrimaryKey((Serializable)levelValidityId);
	}

	/**
	 * Returns the legal level validity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param levelValidityId the primary key of the legal level validity
	 * @return the legal level validity, or <code>null</code> if a legal level validity with the primary key could not be found
	 */
	@Override
	public LegalLevelValidity fetchByPrimaryKey(long levelValidityId) {
		return fetchByPrimaryKey((Serializable)levelValidityId);
	}

	/**
	 * Returns all the legal level validities.
	 *
	 * @return the legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @return the range of legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findAll(
		int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal level validities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalLevelValidityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal level validities
	 * @param end the upper bound of the range of legal level validities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal level validities
	 */
	@Override
	public List<LegalLevelValidity> findAll(
		int start, int end,
		OrderByComparator<LegalLevelValidity> orderByComparator,
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

		List<LegalLevelValidity> list = null;

		if (useFinderCache) {
			list = (List<LegalLevelValidity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALLEVELVALIDITY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALLEVELVALIDITY;

				sql = sql.concat(LegalLevelValidityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalLevelValidity>)QueryUtil.list(
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
	 * Removes all the legal level validities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalLevelValidity legalLevelValidity : findAll()) {
			remove(legalLevelValidity);
		}
	}

	/**
	 * Returns the number of legal level validities.
	 *
	 * @return the number of legal level validities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALLEVELVALIDITY);

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
		return "levelValidityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALLEVELVALIDITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalLevelValidityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal level validity persistence.
	 */
	@Activate
	public void activate() {
		LegalLevelValidityModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalLevelValidityModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByLevelValidityId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLevelValidityId", new String[] {Long.class.getName()},
			LegalLevelValidityModelImpl.LEVELVALIDITYID_COLUMN_BITMASK);

		_finderPathCountByLevelValidityId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelValidityId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalLevelValidityModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathFetchByG_LV = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_LV",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalLevelValidityModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.LEVELVALIDITYID_COLUMN_BITMASK);

		_finderPathCountByG_LV = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_LV",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalLevelValidityModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByG_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			LegalLevelValidityModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.STATUSLEVELVALIDITY_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByStatusLevelValidity = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusLevelValidity",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatusLevelValidity = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusLevelValidity", new String[] {Boolean.class.getName()},
			LegalLevelValidityModelImpl.STATUSLEVELVALIDITY_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByStatusLevelValidity = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusLevelValidity",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalLevelValidityModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.STATUSLEVELVALIDITY_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalLevelValidityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalLevelValidityModelImpl.GROUPID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalLevelValidityModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalLevelValidityImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalLevelValidity"),
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

	private static final String _SQL_SELECT_LEGALLEVELVALIDITY =
		"SELECT legalLevelValidity FROM LegalLevelValidity legalLevelValidity";

	private static final String _SQL_SELECT_LEGALLEVELVALIDITY_WHERE =
		"SELECT legalLevelValidity FROM LegalLevelValidity legalLevelValidity WHERE ";

	private static final String _SQL_COUNT_LEGALLEVELVALIDITY =
		"SELECT COUNT(legalLevelValidity) FROM LegalLevelValidity legalLevelValidity";

	private static final String _SQL_COUNT_LEGALLEVELVALIDITY_WHERE =
		"SELECT COUNT(legalLevelValidity) FROM LegalLevelValidity legalLevelValidity WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalLevelValidity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalLevelValidity exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalLevelValidity exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalLevelValidityPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}