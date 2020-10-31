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

import com.ecoit.elegaldocument.exception.NoSuchLegalTypeException;
import com.ecoit.elegaldocument.model.LegalType;
import com.ecoit.elegaldocument.model.impl.LegalTypeImpl;
import com.ecoit.elegaldocument.model.impl.LegalTypeModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalTypePersistence;
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
 * The persistence implementation for the legal type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalTypePersistence.class)
public class LegalTypePersistenceImpl
	extends BasePersistenceImpl<LegalType> implements LegalTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalTypeUtil</code> to access the legal type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByTypeId;
	private FinderPath _finderPathCountByTypeId;

	/**
	 * Returns the legal type where typeId = &#63; or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param typeId the type ID
	 * @return the matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByTypeId(long typeId) throws NoSuchLegalTypeException {
		LegalType legalType = fetchByTypeId(typeId);

		if (legalType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("typeId=");
			msg.append(typeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalTypeException(msg.toString());
		}

		return legalType;
	}

	/**
	 * Returns the legal type where typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeId the type ID
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByTypeId(long typeId) {
		return fetchByTypeId(typeId, true);
	}

	/**
	 * Returns the legal type where typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByTypeId(long typeId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {typeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTypeId, finderArgs, this);
		}

		if (result instanceof LegalType) {
			LegalType legalType = (LegalType)result;

			if (typeId != legalType.getTypeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_TYPEID_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				List<LegalType> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTypeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {typeId};
							}

							_log.warn(
								"LegalTypePersistenceImpl.fetchByTypeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalType legalType = list.get(0);

					result = legalType;

					cacheResult(legalType);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByTypeId, finderArgs);
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
			return (LegalType)result;
		}
	}

	/**
	 * Removes the legal type where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @return the legal type that was removed
	 */
	@Override
	public LegalType removeByTypeId(long typeId)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByTypeId(typeId);

		return remove(legalType);
	}

	/**
	 * Returns the number of legal types where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal types
	 */
	@Override
	public int countByTypeId(long typeId) {
		FinderPath finderPath = _finderPathCountByTypeId;

		Object[] finderArgs = new Object[] {typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_TYPEID_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

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

	private static final String _FINDER_COLUMN_TYPEID_TYPEID_2 =
		"legalType.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
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

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if (groupId != legalType.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByGroupId_First(
			long groupId, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByGroupId_First(groupId, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByGroupId_First(
		long groupId, OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByGroupId_Last(
			long groupId, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByGroupId_Last(groupId, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalType> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByGroupId_PrevAndNext(
			long typeId, long groupId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalType, groupId, orderByComparator, true);

			array[1] = legalType;

			array[2] = getByGroupId_PrevAndNext(
				session, legalType, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalType getByGroupId_PrevAndNext(
		Session session, LegalType legalType, long groupId,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalType legalType :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal types
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

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
		"legalType.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
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

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						!language.equals(legalType.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

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
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByG_L_PrevAndNext(
			long typeId, long groupId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		language = Objects.toString(language, "");

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalType, groupId, language, orderByComparator, true);

			array[1] = legalType;

			array[2] = getByG_L_PrevAndNext(
				session, legalType, groupId, language, orderByComparator,
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

	protected LegalType getByG_L_PrevAndNext(
		Session session, LegalType legalType, long groupId, String language,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalType legalType :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal types
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

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
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalType.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalType.language IS NULL OR legalType.language = '')";

	private FinderPath _finderPathFetchByG_T;
	private FinderPath _finderPathCountByG_T;

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_T(long groupId, long typeId)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_T(groupId, typeId);

		if (legalType == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", typeId=");
			msg.append(typeId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalTypeException(msg.toString());
		}

		return legalType;
	}

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_T(long groupId, long typeId) {
		return fetchByG_T(groupId, typeId, true);
	}

	/**
	 * Returns the legal type where groupId = &#63; and typeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_T(
		long groupId, long typeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, typeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_T, finderArgs, this);
		}

		if (result instanceof LegalType) {
			LegalType legalType = (LegalType)result;

			if ((groupId != legalType.getGroupId()) ||
				(typeId != legalType.getTypeId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(typeId);

				List<LegalType> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, typeId};
							}

							_log.warn(
								"LegalTypePersistenceImpl.fetchByG_T(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalType legalType = list.get(0);

					result = legalType;

					cacheResult(legalType);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_T, finderArgs);
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
			return (LegalType)result;
		}
	}

	/**
	 * Removes the legal type where groupId = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the legal type that was removed
	 */
	@Override
	public LegalType removeByG_T(long groupId, long typeId)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByG_T(groupId, typeId);

		return remove(legalType);
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @return the number of matching legal types
	 */
	@Override
	public int countByG_T(long groupId, long typeId) {
		FinderPath finderPath = _finderPathCountByG_T;

		Object[] finderArgs = new Object[] {groupId, typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			query.append(_FINDER_COLUMN_G_T_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(typeId);

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

	private static final String _FINDER_COLUMN_G_T_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_T_TYPEID_2 =
		"legalType.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByS_L;
	private FinderPath _finderPathWithoutPaginationFindByS_L;
	private FinderPath _finderPathCountByS_L;

	/**
	 * Returns all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByS_L(
		long groupId, boolean statusType, String language) {

		return findByS_L(
			groupId, statusType, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end) {

		return findByS_L(groupId, statusType, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByS_L(
			groupId, statusType, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByS_L(
		long groupId, boolean statusType, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_L;
				finderArgs = new Object[] {groupId, statusType, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_L;
			finderArgs = new Object[] {
				groupId, statusType, language, start, end, orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(statusType != legalType.isStatusType()) ||
						!language.equals(legalType.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_S_L_STATUSTYPE_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusType);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByS_L_First(
			long groupId, boolean statusType, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByS_L_First(
			groupId, statusType, language, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByS_L_First(
		long groupId, boolean statusType, String language,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByS_L(
			groupId, statusType, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByS_L_Last(
			long groupId, boolean statusType, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByS_L_Last(
			groupId, statusType, language, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByS_L_Last(
		long groupId, boolean statusType, String language,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByS_L(groupId, statusType, language);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByS_L(
			groupId, statusType, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByS_L_PrevAndNext(
			long typeId, long groupId, boolean statusType, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		language = Objects.toString(language, "");

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByS_L_PrevAndNext(
				session, legalType, groupId, statusType, language,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByS_L_PrevAndNext(
				session, legalType, groupId, statusType, language,
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

	protected LegalType getByS_L_PrevAndNext(
		Session session, LegalType legalType, long groupId, boolean statusType,
		String language, OrderByComparator<LegalType> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_S_L_GROUPID_2);

		query.append(_FINDER_COLUMN_S_L_STATUSTYPE_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusType);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and statusType = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 */
	@Override
	public void removeByS_L(long groupId, boolean statusType, String language) {
		for (LegalType legalType :
				findByS_L(
					groupId, statusType, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and statusType = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param language the language
	 * @return the number of matching legal types
	 */
	@Override
	public int countByS_L(long groupId, boolean statusType, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByS_L;

		Object[] finderArgs = new Object[] {groupId, statusType, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_S_L_STATUSTYPE_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusType);

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

	private static final String _FINDER_COLUMN_S_L_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_S_L_STATUSTYPE_2 =
		"legalType.statusType = ? AND ";

	private static final String _FINDER_COLUMN_S_L_LANGUAGE_2 =
		"legalType.language = ?";

	private static final String _FINDER_COLUMN_S_L_LANGUAGE_3 =
		"(legalType.language IS NULL OR legalType.language = '')";

	private FinderPath _finderPathWithPaginationFindByType_Status;
	private FinderPath _finderPathWithoutPaginationFindByType_Status;
	private FinderPath _finderPathCountByType_Status;

	/**
	 * Returns all the legal types where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByType_Status(boolean statusType) {
		return findByType_Status(
			statusType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByType_Status(
		boolean statusType, int start, int end) {

		return findByType_Status(statusType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByType_Status(
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByType_Status(
			statusType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByType_Status(
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType_Status;
				finderArgs = new Object[] {statusType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType_Status;
			finderArgs = new Object[] {
				statusType, start, end, orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if (statusType != legalType.isStatusType()) {
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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_TYPE_STATUS_STATUSTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusType);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByType_Status_First(
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByType_Status_First(
			statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByType_Status_First(
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByType_Status(
			statusType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByType_Status_Last(
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByType_Status_Last(
			statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByType_Status_Last(
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		int count = countByType_Status(statusType);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByType_Status(
			statusType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByType_Status_PrevAndNext(
			long typeId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByType_Status_PrevAndNext(
				session, legalType, statusType, orderByComparator, true);

			array[1] = legalType;

			array[2] = getByType_Status_PrevAndNext(
				session, legalType, statusType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalType getByType_Status_PrevAndNext(
		Session session, LegalType legalType, boolean statusType,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_TYPE_STATUS_STATUSTYPE_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where statusType = &#63; from the database.
	 *
	 * @param statusType the status type
	 */
	@Override
	public void removeByType_Status(boolean statusType) {
		for (LegalType legalType :
				findByType_Status(
					statusType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where statusType = &#63;.
	 *
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	@Override
	public int countByType_Status(boolean statusType) {
		FinderPath finderPath = _finderPathCountByType_Status;

		Object[] finderArgs = new Object[] {statusType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_TYPE_STATUS_STATUSTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusType);

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

	private static final String _FINDER_COLUMN_TYPE_STATUS_STATUSTYPE_2 =
		"legalType.statusType = ?";

	private FinderPath _finderPathWithPaginationFindByS_Rss;
	private FinderPath _finderPathWithoutPaginationFindByS_Rss;
	private FinderPath _finderPathCountByS_Rss;

	/**
	 * Returns all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable) {

		return findByS_Rss(
			groupId, statusType, rssable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end) {

		return findByS_Rss(groupId, statusType, rssable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByS_Rss(
			groupId, statusType, rssable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByS_Rss(
		long groupId, boolean statusType, boolean rssable, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_Rss;
				finderArgs = new Object[] {groupId, statusType, rssable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_Rss;
			finderArgs = new Object[] {
				groupId, statusType, rssable, start, end, orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(statusType != legalType.isStatusType()) ||
						(rssable != legalType.isRssable())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

			query.append(_FINDER_COLUMN_S_RSS_STATUSTYPE_2);

			query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusType);

				qPos.add(rssable);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByS_Rss_First(
			long groupId, boolean statusType, boolean rssable,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByS_Rss_First(
			groupId, statusType, rssable, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append(", rssable=");
		msg.append(rssable);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByS_Rss_First(
		long groupId, boolean statusType, boolean rssable,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByS_Rss(
			groupId, statusType, rssable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByS_Rss_Last(
			long groupId, boolean statusType, boolean rssable,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByS_Rss_Last(
			groupId, statusType, rssable, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append(", rssable=");
		msg.append(rssable);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByS_Rss_Last(
		long groupId, boolean statusType, boolean rssable,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByS_Rss(groupId, statusType, rssable);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByS_Rss(
			groupId, statusType, rssable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByS_Rss_PrevAndNext(
			long typeId, long groupId, boolean statusType, boolean rssable,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByS_Rss_PrevAndNext(
				session, legalType, groupId, statusType, rssable,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByS_Rss_PrevAndNext(
				session, legalType, groupId, statusType, rssable,
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

	protected LegalType getByS_Rss_PrevAndNext(
		Session session, LegalType legalType, long groupId, boolean statusType,
		boolean rssable, OrderByComparator<LegalType> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

		query.append(_FINDER_COLUMN_S_RSS_STATUSTYPE_2);

		query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusType);

		qPos.add(rssable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and statusType = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 */
	@Override
	public void removeByS_Rss(
		long groupId, boolean statusType, boolean rssable) {

		for (LegalType legalType :
				findByS_Rss(
					groupId, statusType, rssable, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and statusType = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusType the status type
	 * @param rssable the rssable
	 * @return the number of matching legal types
	 */
	@Override
	public int countByS_Rss(long groupId, boolean statusType, boolean rssable) {
		FinderPath finderPath = _finderPathCountByS_Rss;

		Object[] finderArgs = new Object[] {groupId, statusType, rssable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

			query.append(_FINDER_COLUMN_S_RSS_STATUSTYPE_2);

			query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusType);

				qPos.add(rssable);

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

	private static final String _FINDER_COLUMN_S_RSS_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_S_RSS_STATUSTYPE_2 =
		"legalType.statusType = ? AND ";

	private static final String _FINDER_COLUMN_S_RSS_RSSABLE_2 =
		"legalType.rssable = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType) {

		return findByFindGroup(
			groupId, companyId, statusType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end) {

		return findByFindGroup(
			groupId, companyId, statusType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, statusType, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroup(
		long groupId, long companyId, boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {groupId, companyId, statusType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, statusType, start, end, orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId()) ||
						(statusType != legalType.isStatusType())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusType);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByFindGroup_First(
			long groupId, long companyId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByFindGroup_First(
			groupId, companyId, statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByFindGroup_First(
		long groupId, long companyId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByFindGroup(
			groupId, companyId, statusType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByFindGroup_Last(
			long groupId, long companyId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByFindGroup_Last(
			groupId, companyId, statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByFindGroup(groupId, companyId, statusType);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByFindGroup(
			groupId, companyId, statusType, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByFindGroup_PrevAndNext(
			long typeId, long groupId, long companyId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalType, groupId, companyId, statusType,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalType, groupId, companyId, statusType,
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

	protected LegalType getByFindGroup_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		boolean statusType, OrderByComparator<LegalType> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_STATUSTYPE_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 */
	@Override
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusType) {

		for (LegalType legalType :
				findByFindGroup(
					groupId, companyId, statusType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	@Override
	public int countByFindGroup(
		long groupId, long companyId, boolean statusType) {

		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId, statusType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusType);

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
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalType.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_STATUSTYPE_2 =
		"legalType.statusType = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_P;
	private FinderPath _finderPathWithoutPaginationFindByG_C_P;
	private FinderPath _finderPathCountByG_C_P;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId) {

		return findByG_C_P(
			groupId, companyId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end) {

		return findByG_C_P(groupId, companyId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByG_C_P(
			groupId, companyId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_P;
				finderArgs = new Object[] {groupId, companyId, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_P;
			finderArgs = new Object[] {
				groupId, companyId, parentId, start, end, orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId()) ||
						(parentId != legalType.getParentId())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(parentId);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_P_First(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_P_First(
			groupId, companyId, parentId, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_P_First(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByG_C_P(
			groupId, companyId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_P_Last(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_P_Last(
			groupId, companyId, parentId, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_P_Last(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByG_C_P(groupId, companyId, parentId);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByG_C_P(
			groupId, companyId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByG_C_P_PrevAndNext(
			long typeId, long groupId, long companyId, long parentId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByG_C_P_PrevAndNext(
				session, legalType, groupId, companyId, parentId,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByG_C_P_PrevAndNext(
				session, legalType, groupId, companyId, parentId,
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

	protected LegalType getByG_C_P_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		long parentId, OrderByComparator<LegalType> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_G_C_P_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_P_COMPANYID_2);

		query.append(_FINDER_COLUMN_G_C_P_PARENTID_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByG_C_P(long groupId, long companyId, long parentId) {
		for (LegalType legalType :
				findByG_C_P(
					groupId, companyId, parentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal types
	 */
	@Override
	public int countByG_C_P(long groupId, long companyId, long parentId) {
		FinderPath finderPath = _finderPathCountByG_C_P;

		Object[] finderArgs = new Object[] {groupId, companyId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_P_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_G_C_P_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_P_COMPANYID_2 =
		"legalType.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_P_PARENTID_2 =
		"legalType.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_L_P_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L_P_S;
	private FinderPath _finderPathCountByG_C_L_P_S;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType) {

		return findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end) {

		return findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L_P_S;
				finderArgs = new Object[] {
					groupId, companyId, language, parentId, statusType
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L_P_S;
			finderArgs = new Object[] {
				groupId, companyId, language, parentId, statusType, start, end,
				orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId()) ||
						!language.equals(legalType.getLanguage()) ||
						(parentId != legalType.getParentId()) ||
						(statusType != legalType.isStatusType())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_P_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_P_S_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_C_L_P_S_PARENTID_2);

			query.append(_FINDER_COLUMN_G_C_L_P_S_STATUSTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(parentId);

				qPos.add(statusType);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_L_P_S_First(
			long groupId, long companyId, String language, long parentId,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_L_P_S_First(
			groupId, companyId, language, parentId, statusType,
			orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_L_P_S_First(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_L_P_S_Last(
			long groupId, long companyId, String language, long parentId,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_L_P_S_Last(
			groupId, companyId, language, parentId, statusType,
			orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_L_P_S_Last(
		long groupId, long companyId, String language, long parentId,
		boolean statusType, OrderByComparator<LegalType> orderByComparator) {

		int count = countByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusType, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByG_C_L_P_S_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			long parentId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		language = Objects.toString(language, "");

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByG_C_L_P_S_PrevAndNext(
				session, legalType, groupId, companyId, language, parentId,
				statusType, orderByComparator, true);

			array[1] = legalType;

			array[2] = getByG_C_L_P_S_PrevAndNext(
				session, legalType, groupId, companyId, language, parentId,
				statusType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalType getByG_C_L_P_S_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		String language, long parentId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(7);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_G_C_L_P_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_L_P_S_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_C_L_P_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_C_L_P_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_C_L_P_S_PARENTID_2);

		query.append(_FINDER_COLUMN_G_C_L_P_S_STATUSTYPE_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(parentId);

		qPos.add(statusType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 */
	@Override
	public void removeByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType) {

		for (LegalType legalType :
				findByG_C_L_P_S(
					groupId, companyId, language, parentId, statusType,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	@Override
	public int countByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusType) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L_P_S;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, parentId, statusType
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_P_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_P_S_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_C_L_P_S_PARENTID_2);

			query.append(_FINDER_COLUMN_G_C_L_P_S_STATUSTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(parentId);

				qPos.add(statusType);

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

	private static final String _FINDER_COLUMN_G_C_L_P_S_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_COMPANYID_2 =
		"legalType.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_LANGUAGE_2 =
		"legalType.language = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_LANGUAGE_3 =
		"(legalType.language IS NULL OR legalType.language = '') AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_PARENTID_2 =
		"legalType.parentId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_STATUSTYPE_2 =
		"legalType.statusType = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_L;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L;
	private FinderPath _finderPathCountByG_C_L;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L(
		long groupId, long companyId, String language) {

		return findByG_C_L(
			groupId, companyId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end) {

		return findByG_C_L(groupId, companyId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L;
				finderArgs = new Object[] {groupId, companyId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L;
			finderArgs = new Object[] {
				groupId, companyId, language, start, end, orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId()) ||
						!language.equals(legalType.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_L_First(
			long groupId, long companyId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_L_First(
			groupId, companyId, language, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_L_First(
		long groupId, long companyId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByG_C_L(
			groupId, companyId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_L_Last(
			long groupId, long companyId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_L_Last(
			groupId, companyId, language, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByG_C_L(groupId, companyId, language);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByG_C_L(
			groupId, companyId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByG_C_L_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		language = Objects.toString(language, "");

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByG_C_L_PrevAndNext(
				session, legalType, groupId, companyId, language,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByG_C_L_PrevAndNext(
				session, legalType, groupId, companyId, language,
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

	protected LegalType getByG_C_L_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		String language, OrderByComparator<LegalType> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_L_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_2);
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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	@Override
	public void removeByG_C_L(long groupId, long companyId, String language) {
		for (LegalType legalType :
				findByG_C_L(
					groupId, companyId, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal types
	 */
	@Override
	public int countByG_C_L(long groupId, long companyId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L;

		Object[] finderArgs = new Object[] {groupId, companyId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_G_C_L_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_COMPANYID_2 =
		"legalType.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_LANGUAGE_2 =
		"legalType.language = ?";

	private static final String _FINDER_COLUMN_G_C_L_LANGUAGE_3 =
		"(legalType.language IS NULL OR legalType.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_C_L_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L_S;
	private FinderPath _finderPathCountByG_C_L_S;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType) {

		return findByG_C_L_S(
			groupId, companyId, language, statusType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end) {

		return findByG_C_L_S(
			groupId, companyId, language, statusType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator) {

		return findByG_C_L_S(
			groupId, companyId, language, statusType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L_S;
				finderArgs = new Object[] {
					groupId, companyId, language, statusType
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L_S;
			finderArgs = new Object[] {
				groupId, companyId, language, statusType, start, end,
				orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId()) ||
						!language.equals(legalType.getLanguage()) ||
						(statusType != legalType.isStatusType())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_S_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_C_L_S_STATUSTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusType);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_L_S_First(
			groupId, companyId, language, statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByG_C_L_S(
			groupId, companyId, language, statusType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByG_C_L_S_Last(
			groupId, companyId, language, statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByG_C_L_S(groupId, companyId, language, statusType);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByG_C_L_S(
			groupId, companyId, language, statusType, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByG_C_L_S_PrevAndNext(
			long typeId, long groupId, long companyId, String language,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		language = Objects.toString(language, "");

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByG_C_L_S_PrevAndNext(
				session, legalType, groupId, companyId, language, statusType,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByG_C_L_S_PrevAndNext(
				session, legalType, groupId, companyId, language, statusType,
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

	protected LegalType getByG_C_L_S_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		String language, boolean statusType,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_G_C_L_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_C_L_S_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_C_L_S_STATUSTYPE_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(statusType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 */
	@Override
	public void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType) {

		for (LegalType legalType :
				findByG_C_L_S(
					groupId, companyId, language, statusType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and language = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	@Override
	public int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusType) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L_S;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, statusType
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_G_C_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_L_S_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_C_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_C_L_S_STATUSTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusType);

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

	private static final String _FINDER_COLUMN_G_C_L_S_GROUPID_2 =
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_COMPANYID_2 =
		"legalType.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_LANGUAGE_2 =
		"legalType.language = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_LANGUAGE_3 =
		"(legalType.language IS NULL OR legalType.language = '') AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_STATUSTYPE_2 =
		"legalType.statusType = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroupCompanyParent;
	private FinderPath _finderPathWithoutPaginationFindByFindGroupCompanyParent;
	private FinderPath _finderPathCountByFindGroupCompanyParent;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType) {

		return findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end) {

		return findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator) {

		return findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType,
		int start, int end, OrderByComparator<LegalType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFindGroupCompanyParent;
				finderArgs = new Object[] {
					groupId, companyId, parentId, statusType
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroupCompanyParent;
			finderArgs = new Object[] {
				groupId, companyId, parentId, statusType, start, end,
				orderByComparator
			};
		}

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId()) ||
						(parentId != legalType.getParentId()) ||
						(statusType != legalType.isStatusType())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(parentId);

				qPos.add(statusType);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByFindGroupCompanyParent_First(
			long groupId, long companyId, long parentId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByFindGroupCompanyParent_First(
			groupId, companyId, parentId, statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByFindGroupCompanyParent_First(
		long groupId, long companyId, long parentId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByFindGroupCompanyParent_Last(
			long groupId, long companyId, long parentId, boolean statusType,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByFindGroupCompanyParent_Last(
			groupId, companyId, parentId, statusType, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusType=");
		msg.append(statusType);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByFindGroupCompanyParent_Last(
		long groupId, long companyId, long parentId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusType, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByFindGroupCompanyParent_PrevAndNext(
			long typeId, long groupId, long companyId, long parentId,
			boolean statusType, OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByFindGroupCompanyParent_PrevAndNext(
				session, legalType, groupId, companyId, parentId, statusType,
				orderByComparator, true);

			array[1] = legalType;

			array[2] = getByFindGroupCompanyParent_PrevAndNext(
				session, legalType, groupId, companyId, parentId, statusType,
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

	protected LegalType getByFindGroupCompanyParent_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		long parentId, boolean statusType,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSTYPE_2);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(parentId);

		qPos.add(statusType);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 */
	@Override
	public void removeByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType) {

		for (LegalType legalType :
				findByFindGroupCompanyParent(
					groupId, companyId, parentId, statusType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusType the status type
	 * @return the number of matching legal types
	 */
	@Override
	public int countByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusType) {

		FinderPath finderPath = _finderPathCountByFindGroupCompanyParent;

		Object[] finderArgs = new Object[] {
			groupId, companyId, parentId, statusType
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(parentId);

				qPos.add(statusType);

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
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2 =
			"legalType.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2 =
			"legalType.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2 =
			"legalType.parentId = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSTYPE_2 =
			"legalType.statusType = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal types
	 */
	@Override
	public List<LegalType> findByFindAll(long groupId, long companyId) {
		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalType> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal types
	 */
	@Override
	public List<LegalType> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalType> orderByComparator,
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

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalType legalType : list) {
					if ((groupId != legalType.getGroupId()) ||
						(companyId != legalType.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALTYPE_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the first legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalType> orderByComparator) {

		List<LegalType> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type
	 * @throws NoSuchLegalTypeException if a matching legal type could not be found
	 */
	@Override
	public LegalType findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalType != null) {
			return legalType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalTypeException(msg.toString());
	}

	/**
	 * Returns the last legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal type, or <code>null</code> if a matching legal type could not be found
	 */
	@Override
	public LegalType fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalType> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalType> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal types before and after the current legal type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param typeId the primary key of the current legal type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType[] findByFindAll_PrevAndNext(
			long typeId, long groupId, long companyId,
			OrderByComparator<LegalType> orderByComparator)
		throws NoSuchLegalTypeException {

		LegalType legalType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			LegalType[] array = new LegalTypeImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalType, groupId, companyId, orderByComparator,
				true);

			array[1] = legalType;

			array[2] = getByFindAll_PrevAndNext(
				session, legalType, groupId, companyId, orderByComparator,
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

	protected LegalType getByFindAll_PrevAndNext(
		Session session, LegalType legalType, long groupId, long companyId,
		OrderByComparator<LegalType> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALTYPE_WHERE);

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
			query.append(LegalTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal types where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalType legalType :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal types
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALTYPE_WHERE);

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
		"legalType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalType.companyId = ?";

	public LegalTypePersistenceImpl() {
		setModelClass(LegalType.class);

		setModelImplClass(LegalTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal type in the entity cache if it is enabled.
	 *
	 * @param legalType the legal type
	 */
	@Override
	public void cacheResult(LegalType legalType) {
		entityCache.putResult(
			entityCacheEnabled, LegalTypeImpl.class, legalType.getPrimaryKey(),
			legalType);

		finderCache.putResult(
			_finderPathFetchByTypeId, new Object[] {legalType.getTypeId()},
			legalType);

		finderCache.putResult(
			_finderPathFetchByG_T,
			new Object[] {legalType.getGroupId(), legalType.getTypeId()},
			legalType);

		legalType.resetOriginalValues();
	}

	/**
	 * Caches the legal types in the entity cache if it is enabled.
	 *
	 * @param legalTypes the legal types
	 */
	@Override
	public void cacheResult(List<LegalType> legalTypes) {
		for (LegalType legalType : legalTypes) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalTypeImpl.class,
					legalType.getPrimaryKey()) == null) {

				cacheResult(legalType);
			}
			else {
				legalType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalType legalType) {
		entityCache.removeResult(
			entityCacheEnabled, LegalTypeImpl.class, legalType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalTypeModelImpl)legalType, true);
	}

	@Override
	public void clearCache(List<LegalType> legalTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalType legalType : legalTypes) {
			entityCache.removeResult(
				entityCacheEnabled, LegalTypeImpl.class,
				legalType.getPrimaryKey());

			clearUniqueFindersCache((LegalTypeModelImpl)legalType, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalTypeModelImpl legalTypeModelImpl) {

		Object[] args = new Object[] {legalTypeModelImpl.getTypeId()};

		finderCache.putResult(
			_finderPathCountByTypeId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByTypeId, args, legalTypeModelImpl, false);

		args = new Object[] {
			legalTypeModelImpl.getGroupId(), legalTypeModelImpl.getTypeId()
		};

		finderCache.putResult(
			_finderPathCountByG_T, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_T, args, legalTypeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalTypeModelImpl legalTypeModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {legalTypeModelImpl.getTypeId()};

			finderCache.removeResult(_finderPathCountByTypeId, args);
			finderCache.removeResult(_finderPathFetchByTypeId, args);
		}

		if ((legalTypeModelImpl.getColumnBitmask() &
			 _finderPathFetchByTypeId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalTypeModelImpl.getOriginalTypeId()
			};

			finderCache.removeResult(_finderPathCountByTypeId, args);
			finderCache.removeResult(_finderPathFetchByTypeId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalTypeModelImpl.getGroupId(), legalTypeModelImpl.getTypeId()
			};

			finderCache.removeResult(_finderPathCountByG_T, args);
			finderCache.removeResult(_finderPathFetchByG_T, args);
		}

		if ((legalTypeModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_T.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalTypeModelImpl.getOriginalGroupId(),
				legalTypeModelImpl.getOriginalTypeId()
			};

			finderCache.removeResult(_finderPathCountByG_T, args);
			finderCache.removeResult(_finderPathFetchByG_T, args);
		}
	}

	/**
	 * Creates a new legal type with the primary key. Does not add the legal type to the database.
	 *
	 * @param typeId the primary key for the new legal type
	 * @return the new legal type
	 */
	@Override
	public LegalType create(long typeId) {
		LegalType legalType = new LegalTypeImpl();

		legalType.setNew(true);
		legalType.setPrimaryKey(typeId);

		legalType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalType;
	}

	/**
	 * Removes the legal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type that was removed
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType remove(long typeId) throws NoSuchLegalTypeException {
		return remove((Serializable)typeId);
	}

	/**
	 * Removes the legal type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal type
	 * @return the legal type that was removed
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType remove(Serializable primaryKey)
		throws NoSuchLegalTypeException {

		Session session = null;

		try {
			session = openSession();

			LegalType legalType = (LegalType)session.get(
				LegalTypeImpl.class, primaryKey);

			if (legalType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalType);
		}
		catch (NoSuchLegalTypeException noSuchEntityException) {
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
	protected LegalType removeImpl(LegalType legalType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalType)) {
				legalType = (LegalType)session.get(
					LegalTypeImpl.class, legalType.getPrimaryKeyObj());
			}

			if (legalType != null) {
				session.delete(legalType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalType != null) {
			clearCache(legalType);
		}

		return legalType;
	}

	@Override
	public LegalType updateImpl(LegalType legalType) {
		boolean isNew = legalType.isNew();

		if (!(legalType instanceof LegalTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalType implementation " +
					legalType.getClass());
		}

		LegalTypeModelImpl legalTypeModelImpl = (LegalTypeModelImpl)legalType;

		Session session = null;

		try {
			session = openSession();

			if (legalType.isNew()) {
				session.save(legalType);

				legalType.setNew(false);
			}
			else {
				legalType = (LegalType)session.merge(legalType);
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
			Object[] args = new Object[] {legalTypeModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.isStatusType(),
				legalTypeModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByS_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByS_L, args);

			args = new Object[] {legalTypeModelImpl.isStatusType()};

			finderCache.removeResult(_finderPathCountByType_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByType_Status, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.isStatusType(),
				legalTypeModelImpl.isRssable()
			};

			finderCache.removeResult(_finderPathCountByS_Rss, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByS_Rss, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId(),
				legalTypeModelImpl.isStatusType()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId(),
				legalTypeModelImpl.getParentId()
			};

			finderCache.removeResult(_finderPathCountByG_C_P, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_P, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId(),
				legalTypeModelImpl.getLanguage(),
				legalTypeModelImpl.getParentId(),
				legalTypeModelImpl.isStatusType()
			};

			finderCache.removeResult(_finderPathCountByG_C_L_P_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L_P_S, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId(),
				legalTypeModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_C_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId(),
				legalTypeModelImpl.getLanguage(),
				legalTypeModelImpl.isStatusType()
			};

			finderCache.removeResult(_finderPathCountByG_C_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L_S, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId(),
				legalTypeModelImpl.getParentId(),
				legalTypeModelImpl.isStatusType()
			};

			finderCache.removeResult(
				_finderPathCountByFindGroupCompanyParent, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroupCompanyParent, args);

			args = new Object[] {
				legalTypeModelImpl.getGroupId(),
				legalTypeModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalTypeModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalStatusType(),
					legalTypeModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByS_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_L, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.isStatusType(),
					legalTypeModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByS_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_L, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByType_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalStatusType()
				};

				finderCache.removeResult(_finderPathCountByType_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType_Status, args);

				args = new Object[] {legalTypeModelImpl.isStatusType()};

				finderCache.removeResult(_finderPathCountByType_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType_Status, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS_Rss.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalStatusType(),
					legalTypeModelImpl.getOriginalRssable()
				};

				finderCache.removeResult(_finderPathCountByS_Rss, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_Rss, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.isStatusType(),
					legalTypeModelImpl.isRssable()
				};

				finderCache.removeResult(_finderPathCountByS_Rss, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_Rss, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId(),
					legalTypeModelImpl.getOriginalStatusType()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId(),
					legalTypeModelImpl.isStatusType()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_P.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId(),
					legalTypeModelImpl.getOriginalParentId()
				};

				finderCache.removeResult(_finderPathCountByG_C_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_P, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId(),
					legalTypeModelImpl.getParentId()
				};

				finderCache.removeResult(_finderPathCountByG_C_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_P, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L_P_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId(),
					legalTypeModelImpl.getOriginalLanguage(),
					legalTypeModelImpl.getOriginalParentId(),
					legalTypeModelImpl.getOriginalStatusType()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_P_S, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId(),
					legalTypeModelImpl.getLanguage(),
					legalTypeModelImpl.getParentId(),
					legalTypeModelImpl.isStatusType()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_P_S, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId(),
					legalTypeModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_C_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId(),
					legalTypeModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_C_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId(),
					legalTypeModelImpl.getOriginalLanguage(),
					legalTypeModelImpl.getOriginalStatusType()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_S, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId(),
					legalTypeModelImpl.getLanguage(),
					legalTypeModelImpl.isStatusType()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_S, args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroupCompanyParent.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId(),
					legalTypeModelImpl.getOriginalParentId(),
					legalTypeModelImpl.getOriginalStatusType()
				};

				finderCache.removeResult(
					_finderPathCountByFindGroupCompanyParent, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroupCompanyParent,
					args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId(),
					legalTypeModelImpl.getParentId(),
					legalTypeModelImpl.isStatusType()
				};

				finderCache.removeResult(
					_finderPathCountByFindGroupCompanyParent, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroupCompanyParent,
					args);
			}

			if ((legalTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTypeModelImpl.getOriginalGroupId(),
					legalTypeModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalTypeModelImpl.getGroupId(),
					legalTypeModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalTypeImpl.class, legalType.getPrimaryKey(),
			legalType, false);

		clearUniqueFindersCache(legalTypeModelImpl, false);
		cacheUniqueFindersCache(legalTypeModelImpl);

		legalType.resetOriginalValues();

		return legalType;
	}

	/**
	 * Returns the legal type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal type
	 * @return the legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalTypeException {

		LegalType legalType = fetchByPrimaryKey(primaryKey);

		if (legalType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalType;
	}

	/**
	 * Returns the legal type with the primary key or throws a <code>NoSuchLegalTypeException</code> if it could not be found.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type
	 * @throws NoSuchLegalTypeException if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType findByPrimaryKey(long typeId)
		throws NoSuchLegalTypeException {

		return findByPrimaryKey((Serializable)typeId);
	}

	/**
	 * Returns the legal type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the legal type
	 * @return the legal type, or <code>null</code> if a legal type with the primary key could not be found
	 */
	@Override
	public LegalType fetchByPrimaryKey(long typeId) {
		return fetchByPrimaryKey((Serializable)typeId);
	}

	/**
	 * Returns all the legal types.
	 *
	 * @return the legal types
	 */
	@Override
	public List<LegalType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @return the range of legal types
	 */
	@Override
	public List<LegalType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal types
	 */
	@Override
	public List<LegalType> findAll(
		int start, int end, OrderByComparator<LegalType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal types
	 * @param end the upper bound of the range of legal types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal types
	 */
	@Override
	public List<LegalType> findAll(
		int start, int end, OrderByComparator<LegalType> orderByComparator,
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

		List<LegalType> list = null;

		if (useFinderCache) {
			list = (List<LegalType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALTYPE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALTYPE;

				sql = sql.concat(LegalTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalType>)QueryUtil.list(
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
	 * Removes all the legal types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalType legalType : findAll()) {
			remove(legalType);
		}
	}

	/**
	 * Returns the number of legal types.
	 *
	 * @return the number of legal types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALTYPE);

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
		return "typeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal type persistence.
	 */
	@Activate
	public void activate() {
		LegalTypeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalTypeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTypeId",
			new String[] {Long.class.getName()},
			LegalTypeModelImpl.TYPEID_COLUMN_BITMASK);

		_finderPathCountByTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByG_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_T",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.TYPEID_COLUMN_BITMASK);

		_finderPathCountByG_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
			LegalTypeModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByType_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType_Status",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByType_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType_Status",
			new String[] {Boolean.class.getName()},
			LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByType_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType_Status",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
			LegalTypeModelImpl.RSSABLE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByG_C_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalTypeModelImpl.PARENTID_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalTypeModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalTypeModelImpl.PARENTID_COLUMN_BITMASK |
			LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalTypeModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName()
			},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalTypeModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindGroupCompanyParent = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFindGroupCompanyParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroupCompanyParent =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFindGroupCompanyParent",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Boolean.class.getName()
				},
				LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
				LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalTypeModelImpl.PARENTID_COLUMN_BITMASK |
				LegalTypeModelImpl.STATUSTYPE_COLUMN_BITMASK |
				LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
				LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindGroupCompanyParent = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindGroupCompanyParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalTypeModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalTypeModelImpl.POSITION_COLUMN_BITMASK |
			LegalTypeModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalTypeImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalType"),
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

	private static final String _SQL_SELECT_LEGALTYPE =
		"SELECT legalType FROM LegalType legalType";

	private static final String _SQL_SELECT_LEGALTYPE_WHERE =
		"SELECT legalType FROM LegalType legalType WHERE ";

	private static final String _SQL_COUNT_LEGALTYPE =
		"SELECT COUNT(legalType) FROM LegalType legalType";

	private static final String _SQL_COUNT_LEGALTYPE_WHERE =
		"SELECT COUNT(legalType) FROM LegalType legalType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalTypePersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}