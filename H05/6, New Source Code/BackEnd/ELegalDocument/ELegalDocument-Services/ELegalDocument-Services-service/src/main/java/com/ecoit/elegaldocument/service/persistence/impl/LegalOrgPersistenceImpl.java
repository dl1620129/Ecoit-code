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

import com.ecoit.elegaldocument.exception.NoSuchLegalOrgException;
import com.ecoit.elegaldocument.model.LegalOrg;
import com.ecoit.elegaldocument.model.impl.LegalOrgImpl;
import com.ecoit.elegaldocument.model.impl.LegalOrgModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalOrgPersistence;
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
 * The persistence implementation for the legal org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalOrgPersistence.class)
public class LegalOrgPersistenceImpl
	extends BasePersistenceImpl<LegalOrg> implements LegalOrgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalOrgUtil</code> to access the legal org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalOrgImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByOrgId;
	private FinderPath _finderPathCountByOrgId;

	/**
	 * Returns the legal org where organizationId = &#63; or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByOrgId(long organizationId)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByOrgId(organizationId);

		if (legalOrg == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalOrgException(msg.toString());
		}

		return legalOrg;
	}

	/**
	 * Returns the legal org where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByOrgId(long organizationId) {
		return fetchByOrgId(organizationId, true);
	}

	/**
	 * Returns the legal org where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByOrgId(long organizationId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {organizationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByOrgId, finderArgs, this);
		}

		if (result instanceof LegalOrg) {
			LegalOrg legalOrg = (LegalOrg)result;

			if (organizationId != legalOrg.getOrganizationId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_ORGID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				List<LegalOrg> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByOrgId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {organizationId};
							}

							_log.warn(
								"LegalOrgPersistenceImpl.fetchByOrgId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalOrg legalOrg = list.get(0);

					result = legalOrg;

					cacheResult(legalOrg);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByOrgId, finderArgs);
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
			return (LegalOrg)result;
		}
	}

	/**
	 * Removes the legal org where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the legal org that was removed
	 */
	@Override
	public LegalOrg removeByOrgId(long organizationId)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByOrgId(organizationId);

		return remove(legalOrg);
	}

	/**
	 * Returns the number of legal orgs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByOrgId(long organizationId) {
		FinderPath finderPath = _finderPathCountByOrgId;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_ORGID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGID_ORGANIZATIONID_2 =
		"legalOrg.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal orgs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

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

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if (groupId != legalOrg.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByGroupId_First(
			long groupId, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByGroupId_First(groupId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByGroupId_First(
		long groupId, OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByGroupId_Last(
			long groupId, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByGroupId_Last(groupId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByGroupId_PrevAndNext(
			long organizationId, long groupId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalOrg, groupId, orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByGroupId_PrevAndNext(
				session, legalOrg, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalOrg getByGroupId_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalOrg legalOrg :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

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
		"legalOrg.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

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

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						!language.equals(legalOrg.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

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
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_L_PrevAndNext(
			long organizationId, long groupId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalOrg, groupId, language, orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_L_PrevAndNext(
				session, legalOrg, groupId, language, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalOrg getByG_L_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, String language,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalOrg legalOrg :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalOrg.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '')";

	private FinderPath _finderPathFetchByG_O;
	private FinderPath _finderPathCountByG_O;

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_O(long groupId, long organizationId)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_O(groupId, organizationId);

		if (legalOrg == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalOrgException(msg.toString());
		}

		return legalOrg;
	}

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_O(long groupId, long organizationId) {
		return fetchByG_O(groupId, organizationId, true);
	}

	/**
	 * Returns the legal org where groupId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_O(
		long groupId, long organizationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, organizationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_O, finderArgs, this);
		}

		if (result instanceof LegalOrg) {
			LegalOrg legalOrg = (LegalOrg)result;

			if ((groupId != legalOrg.getGroupId()) ||
				(organizationId != legalOrg.getOrganizationId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_O_GROUPID_2);

			query.append(_FINDER_COLUMN_G_O_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(organizationId);

				List<LegalOrg> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_O, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, organizationId
								};
							}

							_log.warn(
								"LegalOrgPersistenceImpl.fetchByG_O(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalOrg legalOrg = list.get(0);

					result = legalOrg;

					cacheResult(legalOrg);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_O, finderArgs);
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
			return (LegalOrg)result;
		}
	}

	/**
	 * Removes the legal org where groupId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the legal org that was removed
	 */
	@Override
	public LegalOrg removeByG_O(long groupId, long organizationId)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByG_O(groupId, organizationId);

		return remove(legalOrg);
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_O(long groupId, long organizationId) {
		FinderPath finderPath = _finderPathCountByG_O;

		Object[] finderArgs = new Object[] {groupId, organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_O_GROUPID_2);

			query.append(_FINDER_COLUMN_G_O_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_G_O_GROUPID_2 =
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_O_ORGANIZATIONID_2 =
		"legalOrg.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByOrgStatus;
	private FinderPath _finderPathWithoutPaginationFindByOrgStatus;
	private FinderPath _finderPathCountByOrgStatus;

	/**
	 * Returns all the legal orgs where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByOrgStatus(boolean statusOrg) {
		return findByOrgStatus(
			statusOrg, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end) {

		return findByOrgStatus(statusOrg, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByOrgStatus(statusOrg, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByOrgStatus(
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrgStatus;
				finderArgs = new Object[] {statusOrg};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrgStatus;
			finderArgs = new Object[] {
				statusOrg, start, end, orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if (statusOrg != legalOrg.isStatusOrg()) {
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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_ORGSTATUS_STATUSORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusOrg);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByOrgStatus_First(
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByOrgStatus_First(
			statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByOrgStatus_First(
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByOrgStatus(
			statusOrg, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByOrgStatus_Last(
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByOrgStatus_Last(statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByOrgStatus_Last(
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByOrgStatus(statusOrg);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByOrgStatus(
			statusOrg, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByOrgStatus_PrevAndNext(
			long organizationId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByOrgStatus_PrevAndNext(
				session, legalOrg, statusOrg, orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByOrgStatus_PrevAndNext(
				session, legalOrg, statusOrg, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalOrg getByOrgStatus_PrevAndNext(
		Session session, LegalOrg legalOrg, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_ORGSTATUS_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusOrg);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where statusOrg = &#63; from the database.
	 *
	 * @param statusOrg the status org
	 */
	@Override
	public void removeByOrgStatus(boolean statusOrg) {
		for (LegalOrg legalOrg :
				findByOrgStatus(
					statusOrg, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where statusOrg = &#63;.
	 *
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByOrgStatus(boolean statusOrg) {
		FinderPath finderPath = _finderPathCountByOrgStatus;

		Object[] finderArgs = new Object[] {statusOrg};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_ORGSTATUS_STATUSORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusOrg);

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

	private static final String _FINDER_COLUMN_ORGSTATUS_STATUSORG_2 =
		"legalOrg.statusOrg = ?";

	private FinderPath _finderPathWithPaginationFindByS_L;
	private FinderPath _finderPathWithoutPaginationFindByS_L;
	private FinderPath _finderPathCountByS_L;

	/**
	 * Returns all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language) {

		return findByS_L(
			groupId, statusOrg, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end) {

		return findByS_L(groupId, statusOrg, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByS_L(
			groupId, statusOrg, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_L(
		long groupId, boolean statusOrg, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_L;
				finderArgs = new Object[] {groupId, statusOrg, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_L;
			finderArgs = new Object[] {
				groupId, statusOrg, language, start, end, orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(statusOrg != legalOrg.isStatusOrg()) ||
						!language.equals(legalOrg.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_S_L_STATUSORG_2);

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
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusOrg);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByS_L_First(
			long groupId, boolean statusOrg, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByS_L_First(
			groupId, statusOrg, language, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByS_L_First(
		long groupId, boolean statusOrg, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByS_L(
			groupId, statusOrg, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByS_L_Last(
			long groupId, boolean statusOrg, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByS_L_Last(
			groupId, statusOrg, language, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByS_L_Last(
		long groupId, boolean statusOrg, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByS_L(groupId, statusOrg, language);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByS_L(
			groupId, statusOrg, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByS_L_PrevAndNext(
			long organizationId, long groupId, boolean statusOrg,
			String language, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByS_L_PrevAndNext(
				session, legalOrg, groupId, statusOrg, language,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByS_L_PrevAndNext(
				session, legalOrg, groupId, statusOrg, language,
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

	protected LegalOrg getByS_L_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, boolean statusOrg,
		String language, OrderByComparator<LegalOrg> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_S_L_GROUPID_2);

		query.append(_FINDER_COLUMN_S_L_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusOrg);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 */
	@Override
	public void removeByS_L(long groupId, boolean statusOrg, String language) {
		for (LegalOrg legalOrg :
				findByS_L(
					groupId, statusOrg, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and statusOrg = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByS_L(long groupId, boolean statusOrg, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByS_L;

		Object[] finderArgs = new Object[] {groupId, statusOrg, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_S_L_STATUSORG_2);

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

				qPos.add(statusOrg);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_S_L_STATUSORG_2 =
		"legalOrg.statusOrg = ? AND ";

	private static final String _FINDER_COLUMN_S_L_LANGUAGE_2 =
		"legalOrg.language = ?";

	private static final String _FINDER_COLUMN_S_L_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '')";

	private FinderPath _finderPathWithPaginationFindByS_Rss;
	private FinderPath _finderPathWithoutPaginationFindByS_Rss;
	private FinderPath _finderPathCountByS_Rss;

	/**
	 * Returns all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable) {

		return findByS_Rss(
			groupId, statusOrg, rssable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end) {

		return findByS_Rss(groupId, statusOrg, rssable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByS_Rss(
			groupId, statusOrg, rssable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByS_Rss(
		long groupId, boolean statusOrg, boolean rssable, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_Rss;
				finderArgs = new Object[] {groupId, statusOrg, rssable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_Rss;
			finderArgs = new Object[] {
				groupId, statusOrg, rssable, start, end, orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(statusOrg != legalOrg.isStatusOrg()) ||
						(rssable != legalOrg.isRssable())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

			query.append(_FINDER_COLUMN_S_RSS_STATUSORG_2);

			query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusOrg);

				qPos.add(rssable);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByS_Rss_First(
			long groupId, boolean statusOrg, boolean rssable,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByS_Rss_First(
			groupId, statusOrg, rssable, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append(", rssable=");
		msg.append(rssable);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByS_Rss_First(
		long groupId, boolean statusOrg, boolean rssable,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByS_Rss(
			groupId, statusOrg, rssable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByS_Rss_Last(
			long groupId, boolean statusOrg, boolean rssable,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByS_Rss_Last(
			groupId, statusOrg, rssable, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append(", rssable=");
		msg.append(rssable);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByS_Rss_Last(
		long groupId, boolean statusOrg, boolean rssable,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByS_Rss(groupId, statusOrg, rssable);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByS_Rss(
			groupId, statusOrg, rssable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByS_Rss_PrevAndNext(
			long organizationId, long groupId, boolean statusOrg,
			boolean rssable, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByS_Rss_PrevAndNext(
				session, legalOrg, groupId, statusOrg, rssable,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByS_Rss_PrevAndNext(
				session, legalOrg, groupId, statusOrg, rssable,
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

	protected LegalOrg getByS_Rss_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, boolean statusOrg,
		boolean rssable, OrderByComparator<LegalOrg> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

		query.append(_FINDER_COLUMN_S_RSS_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusOrg);

		qPos.add(rssable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 */
	@Override
	public void removeByS_Rss(
		long groupId, boolean statusOrg, boolean rssable) {

		for (LegalOrg legalOrg :
				findByS_Rss(
					groupId, statusOrg, rssable, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and statusOrg = &#63; and rssable = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusOrg the status org
	 * @param rssable the rssable
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByS_Rss(long groupId, boolean statusOrg, boolean rssable) {
		FinderPath finderPath = _finderPathCountByS_Rss;

		Object[] finderArgs = new Object[] {groupId, statusOrg, rssable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_S_RSS_GROUPID_2);

			query.append(_FINDER_COLUMN_S_RSS_STATUSORG_2);

			query.append(_FINDER_COLUMN_S_RSS_RSSABLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusOrg);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_S_RSS_STATUSORG_2 =
		"legalOrg.statusOrg = ? AND ";

	private static final String _FINDER_COLUMN_S_RSS_RSSABLE_2 =
		"legalOrg.rssable = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_P;
	private FinderPath _finderPathWithoutPaginationFindByG_L_P;
	private FinderPath _finderPathCountByG_L_P;

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId) {

		return findByG_L_P(
			groupId, language, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end) {

		return findByG_L_P(groupId, language, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_L_P(
			groupId, language, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P(
		long groupId, String language, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_P;
				finderArgs = new Object[] {groupId, language, parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_P;
			finderArgs = new Object[] {
				groupId, language, parentId, start, end, orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						!language.equals(legalOrg.getLanguage()) ||
						(parentId != legalOrg.getParentId())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				qPos.add(parentId);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_L_P_First(
			long groupId, String language, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_L_P_First(
			groupId, language, parentId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_L_P_First(
		long groupId, String language, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_L_P(
			groupId, language, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_L_P_Last(
			long groupId, String language, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_L_P_Last(
			groupId, language, parentId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_L_P_Last(
		long groupId, String language, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_L_P(groupId, language, parentId);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_L_P(
			groupId, language, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_L_P_PrevAndNext(
			long organizationId, long groupId, String language, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_L_P_PrevAndNext(
				session, legalOrg, groupId, language, parentId,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_L_P_PrevAndNext(
				session, legalOrg, groupId, language, parentId,
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

	protected LegalOrg getByG_L_P_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, String language,
		long parentId, OrderByComparator<LegalOrg> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

		qPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByG_L_P(long groupId, String language, long parentId) {
		for (LegalOrg legalOrg :
				findByG_L_P(
					groupId, language, parentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_L_P(long groupId, String language, long parentId) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_P;

		Object[] finderArgs = new Object[] {groupId, language, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);

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

	private static final String _FINDER_COLUMN_G_L_P_GROUPID_2 =
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_2 =
		"legalOrg.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_P_PARENTID_2 =
		"legalOrg.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_P_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_P_S;
	private FinderPath _finderPathCountByG_L_P_S;

	/**
	 * Returns all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg) {

		return findByG_L_P_S(
			groupId, language, parentId, statusOrg, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end) {

		return findByG_L_P_S(
			groupId, language, parentId, statusOrg, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_L_P_S(
			groupId, language, parentId, statusOrg, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_P_S;
				finderArgs = new Object[] {
					groupId, language, parentId, statusOrg
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_P_S;
			finderArgs = new Object[] {
				groupId, language, parentId, statusOrg, start, end,
				orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						!language.equals(legalOrg.getLanguage()) ||
						(parentId != legalOrg.getParentId()) ||
						(statusOrg != legalOrg.isStatusOrg())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_P_S_PARENTID_2);

			query.append(_FINDER_COLUMN_G_L_P_S_STATUSORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				qPos.add(parentId);

				qPos.add(statusOrg);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_L_P_S_First(
			long groupId, String language, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_L_P_S_First(
			groupId, language, parentId, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_L_P_S_First(
		long groupId, String language, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_L_P_S(
			groupId, language, parentId, statusOrg, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_L_P_S_Last(
			long groupId, String language, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_L_P_S_Last(
			groupId, language, parentId, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_L_P_S_Last(
		long groupId, String language, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_L_P_S(groupId, language, parentId, statusOrg);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_L_P_S(
			groupId, language, parentId, statusOrg, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_L_P_S_PrevAndNext(
			long organizationId, long groupId, String language, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_L_P_S_PrevAndNext(
				session, legalOrg, groupId, language, parentId, statusOrg,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_L_P_S_PrevAndNext(
				session, legalOrg, groupId, language, parentId, statusOrg,
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

	protected LegalOrg getByG_L_P_S_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, String language,
		long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_G_L_P_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_P_S_PARENTID_2);

		query.append(_FINDER_COLUMN_G_L_P_S_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

		qPos.add(parentId);

		qPos.add(statusOrg);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	@Override
	public void removeByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg) {

		for (LegalOrg legalOrg :
				findByG_L_P_S(
					groupId, language, parentId, statusOrg, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_L_P_S(
		long groupId, String language, long parentId, boolean statusOrg) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_P_S;

		Object[] finderArgs = new Object[] {
			groupId, language, parentId, statusOrg
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_P_S_PARENTID_2);

			query.append(_FINDER_COLUMN_G_L_P_S_STATUSORG_2);

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

				qPos.add(parentId);

				qPos.add(statusOrg);

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

	private static final String _FINDER_COLUMN_G_L_P_S_GROUPID_2 =
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_LANGUAGE_2 =
		"legalOrg.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_PARENTID_2 =
		"legalOrg.parentId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_STATUSORG_2 =
		"legalOrg.statusOrg = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_P;
	private FinderPath _finderPathWithoutPaginationFindByG_C_P;
	private FinderPath _finderPathCountByG_C_P;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId) {

		return findByG_C_P(
			groupId, companyId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end) {

		return findByG_C_P(groupId, companyId, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_C_P(
			groupId, companyId, parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_P(
		long groupId, long companyId, long parentId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

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

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId()) ||
						(parentId != legalOrg.getParentId())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_G_C_P_GROUPID_2);

			query.append(_FINDER_COLUMN_G_C_P_COMPANYID_2);

			query.append(_FINDER_COLUMN_G_C_P_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_P_First(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_P_First(
			groupId, companyId, parentId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
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

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_P_First(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_C_P(
			groupId, companyId, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_P_Last(
			long groupId, long companyId, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_P_Last(
			groupId, companyId, parentId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
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

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_P_Last(
		long groupId, long companyId, long parentId,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_C_P(groupId, companyId, parentId);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_C_P(
			groupId, companyId, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_C_P_PrevAndNext(
			long organizationId, long groupId, long companyId, long parentId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_C_P_PrevAndNext(
				session, legalOrg, groupId, companyId, parentId,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_C_P_PrevAndNext(
				session, legalOrg, groupId, companyId, parentId,
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

	protected LegalOrg getByG_C_P_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		long parentId, OrderByComparator<LegalOrg> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALORG_WHERE);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByG_C_P(long groupId, long companyId, long parentId) {
		for (LegalOrg legalOrg :
				findByG_C_P(
					groupId, companyId, parentId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_C_P(long groupId, long companyId, long parentId) {
		FinderPath finderPath = _finderPathCountByG_C_P;

		Object[] finderArgs = new Object[] {groupId, companyId, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_P_COMPANYID_2 =
		"legalOrg.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_P_PARENTID_2 =
		"legalOrg.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_L_P_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L_P_S;
	private FinderPath _finderPathCountByG_C_L_P_S;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg) {

		return findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end) {

		return findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L_P_S;
				finderArgs = new Object[] {
					groupId, companyId, language, parentId, statusOrg
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L_P_S;
			finderArgs = new Object[] {
				groupId, companyId, language, parentId, statusOrg, start, end,
				orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId()) ||
						!language.equals(legalOrg.getLanguage()) ||
						(parentId != legalOrg.getParentId()) ||
						(statusOrg != legalOrg.isStatusOrg())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

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

			query.append(_FINDER_COLUMN_G_C_L_P_S_STATUSORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusOrg);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_L_P_S_First(
			long groupId, long companyId, String language, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_L_P_S_First(
			groupId, companyId, language, parentId, statusOrg,
			orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
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

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_L_P_S_First(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_L_P_S_Last(
			long groupId, long companyId, String language, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_L_P_S_Last(
			groupId, companyId, language, parentId, statusOrg,
			orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
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

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_L_P_S_Last(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_C_L_P_S(
			groupId, companyId, language, parentId, statusOrg, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_C_L_P_S_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_C_L_P_S_PrevAndNext(
				session, legalOrg, groupId, companyId, language, parentId,
				statusOrg, orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_C_L_P_S_PrevAndNext(
				session, legalOrg, groupId, companyId, language, parentId,
				statusOrg, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalOrg getByG_C_L_P_S_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		String language, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(7);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

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

		query.append(_FINDER_COLUMN_G_C_L_P_S_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

		qPos.add(statusOrg);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	@Override
	public void removeByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg) {

		for (LegalOrg legalOrg :
				findByG_C_L_P_S(
					groupId, companyId, language, parentId, statusOrg,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_C_L_P_S(
		long groupId, long companyId, String language, long parentId,
		boolean statusOrg) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L_P_S;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, parentId, statusOrg
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

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

			query.append(_FINDER_COLUMN_G_C_L_P_S_STATUSORG_2);

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

				qPos.add(statusOrg);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_COMPANYID_2 =
		"legalOrg.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_LANGUAGE_2 =
		"legalOrg.language = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '') AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_PARENTID_2 =
		"legalOrg.parentId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_P_S_STATUSORG_2 =
		"legalOrg.statusOrg = ?";

	private FinderPath _finderPathWithPaginationFindByG_C_L;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L;
	private FinderPath _finderPathCountByG_C_L;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language) {

		return findByG_C_L(
			groupId, companyId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end) {

		return findByG_C_L(groupId, companyId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_C_L(
			groupId, companyId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L(
		long groupId, long companyId, String language, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

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

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId()) ||
						!language.equals(legalOrg.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

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
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_L_First(
			long groupId, long companyId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_L_First(
			groupId, companyId, language, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
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

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_L_First(
		long groupId, long companyId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_C_L(
			groupId, companyId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_L_Last(
			long groupId, long companyId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_L_Last(
			groupId, companyId, language, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
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

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_L_Last(
		long groupId, long companyId, String language,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_C_L(groupId, companyId, language);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_C_L(
			groupId, companyId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_C_L_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_C_L_PrevAndNext(
				session, legalOrg, groupId, companyId, language,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_C_L_PrevAndNext(
				session, legalOrg, groupId, companyId, language,
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

	protected LegalOrg getByG_C_L_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		String language, OrderByComparator<LegalOrg> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALORG_WHERE);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 */
	@Override
	public void removeByG_C_L(long groupId, long companyId, String language) {
		for (LegalOrg legalOrg :
				findByG_C_L(
					groupId, companyId, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_C_L(long groupId, long companyId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L;

		Object[] finderArgs = new Object[] {groupId, companyId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_COMPANYID_2 =
		"legalOrg.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_LANGUAGE_2 =
		"legalOrg.language = ?";

	private static final String _FINDER_COLUMN_G_C_L_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_C_L_S;
	private FinderPath _finderPathWithoutPaginationFindByG_C_L_S;
	private FinderPath _finderPathCountByG_C_L_S;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg) {

		return findByG_C_L_S(
			groupId, companyId, language, statusOrg, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end) {

		return findByG_C_L_S(
			groupId, companyId, language, statusOrg, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return findByG_C_L_S(
			groupId, companyId, language, statusOrg, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_C_L_S;
				finderArgs = new Object[] {
					groupId, companyId, language, statusOrg
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_C_L_S;
			finderArgs = new Object[] {
				groupId, companyId, language, statusOrg, start, end,
				orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId()) ||
						!language.equals(legalOrg.getLanguage()) ||
						(statusOrg != legalOrg.isStatusOrg())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

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

			query.append(_FINDER_COLUMN_G_C_L_S_STATUSORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusOrg);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_L_S_First(
			long groupId, long companyId, String language, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_L_S_First(
			groupId, companyId, language, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_L_S_First(
		long groupId, long companyId, String language, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByG_C_L_S(
			groupId, companyId, language, statusOrg, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByG_C_L_S_Last(
			long groupId, long companyId, String language, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByG_C_L_S_Last(
			groupId, companyId, language, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByG_C_L_S_Last(
		long groupId, long companyId, String language, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByG_C_L_S(groupId, companyId, language, statusOrg);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByG_C_L_S(
			groupId, companyId, language, statusOrg, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByG_C_L_S_PrevAndNext(
			long organizationId, long groupId, long companyId, String language,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		language = Objects.toString(language, "");

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByG_C_L_S_PrevAndNext(
				session, legalOrg, groupId, companyId, language, statusOrg,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByG_C_L_S_PrevAndNext(
				session, legalOrg, groupId, companyId, language, statusOrg,
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

	protected LegalOrg getByG_C_L_S_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		String language, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

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

		query.append(_FINDER_COLUMN_G_C_L_S_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

		qPos.add(statusOrg);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 */
	@Override
	public void removeByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg) {

		for (LegalOrg legalOrg :
				findByG_C_L_S(
					groupId, companyId, language, statusOrg, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and language = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByG_C_L_S(
		long groupId, long companyId, String language, boolean statusOrg) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_C_L_S;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, statusOrg
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

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

			query.append(_FINDER_COLUMN_G_C_L_S_STATUSORG_2);

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

				qPos.add(statusOrg);

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
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_COMPANYID_2 =
		"legalOrg.companyId = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_LANGUAGE_2 =
		"legalOrg.language = ? AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_LANGUAGE_3 =
		"(legalOrg.language IS NULL OR legalOrg.language = '') AND ";

	private static final String _FINDER_COLUMN_G_C_L_S_STATUSORG_2 =
		"legalOrg.statusOrg = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroup(long groupId, long companyId) {
		return findByFindGroup(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end) {

		return findByFindGroup(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByFindGroup_First(
			long groupId, long companyId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByFindGroup_First(
			groupId, companyId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByFindGroup_First(
		long groupId, long companyId,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByFindGroup(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByFindGroup_Last(
			long groupId, long companyId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByFindGroup_Last(
			groupId, companyId, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByFindGroup_Last(
		long groupId, long companyId,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByFindGroup(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByFindGroup(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByFindGroup_PrevAndNext(
			long organizationId, long groupId, long companyId,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalOrg, groupId, companyId, orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalOrg, groupId, companyId, orderByComparator,
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

	protected LegalOrg getByFindGroup_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindGroup(long groupId, long companyId) {
		for (LegalOrg legalOrg :
				findByFindGroup(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByFindGroup(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_FINDGROUP_GROUPID_2 =
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalOrg.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFindAllStatus;
	private FinderPath _finderPathWithoutPaginationFindByFindAllStatus;
	private FinderPath _finderPathCountByFindAllStatus;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg) {

		return findByFindAllStatus(
			groupId, companyId, statusOrg, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end) {

		return findByFindAllStatus(
			groupId, companyId, statusOrg, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator) {

		return findByFindAllStatus(
			groupId, companyId, statusOrg, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindAllStatus(
		long groupId, long companyId, boolean statusOrg, int start, int end,
		OrderByComparator<LegalOrg> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindAllStatus;
				finderArgs = new Object[] {groupId, companyId, statusOrg};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindAllStatus;
			finderArgs = new Object[] {
				groupId, companyId, statusOrg, start, end, orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId()) ||
						(statusOrg != legalOrg.isStatusOrg())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_FINDALLSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALLSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDALLSTATUS_STATUSORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusOrg);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByFindAllStatus_First(
			long groupId, long companyId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByFindAllStatus_First(
			groupId, companyId, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByFindAllStatus_First(
		long groupId, long companyId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByFindAllStatus(
			groupId, companyId, statusOrg, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByFindAllStatus_Last(
			long groupId, long companyId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByFindAllStatus_Last(
			groupId, companyId, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByFindAllStatus_Last(
		long groupId, long companyId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByFindAllStatus(groupId, companyId, statusOrg);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByFindAllStatus(
			groupId, companyId, statusOrg, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByFindAllStatus_PrevAndNext(
			long organizationId, long groupId, long companyId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByFindAllStatus_PrevAndNext(
				session, legalOrg, groupId, companyId, statusOrg,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByFindAllStatus_PrevAndNext(
				session, legalOrg, groupId, companyId, statusOrg,
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

	protected LegalOrg getByFindAllStatus_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_FINDALLSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDALLSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDALLSTATUS_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusOrg);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 */
	@Override
	public void removeByFindAllStatus(
		long groupId, long companyId, boolean statusOrg) {

		for (LegalOrg legalOrg :
				findByFindAllStatus(
					groupId, companyId, statusOrg, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByFindAllStatus(
		long groupId, long companyId, boolean statusOrg) {

		FinderPath finderPath = _finderPathCountByFindAllStatus;

		Object[] finderArgs = new Object[] {groupId, companyId, statusOrg};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_FINDALLSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALLSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDALLSTATUS_STATUSORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusOrg);

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

	private static final String _FINDER_COLUMN_FINDALLSTATUS_GROUPID_2 =
		"legalOrg.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALLSTATUS_COMPANYID_2 =
		"legalOrg.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALLSTATUS_STATUSORG_2 =
		"legalOrg.statusOrg = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroupCompanyParent;
	private FinderPath _finderPathWithoutPaginationFindByFindGroupCompanyParent;
	private FinderPath _finderPathCountByFindGroupCompanyParent;

	/**
	 * Returns all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg) {

		return findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end) {

		return findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal orgs
	 */
	@Override
	public List<LegalOrg> findByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg,
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFindGroupCompanyParent;
				finderArgs = new Object[] {
					groupId, companyId, parentId, statusOrg
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroupCompanyParent;
			finderArgs = new Object[] {
				groupId, companyId, parentId, statusOrg, start, end,
				orderByComparator
			};
		}

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalOrg legalOrg : list) {
					if ((groupId != legalOrg.getGroupId()) ||
						(companyId != legalOrg.getCompanyId()) ||
						(parentId != legalOrg.getParentId()) ||
						(statusOrg != legalOrg.isStatusOrg())) {

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

			query.append(_SQL_SELECT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusOrg);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByFindGroupCompanyParent_First(
			long groupId, long companyId, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByFindGroupCompanyParent_First(
			groupId, companyId, parentId, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the first legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByFindGroupCompanyParent_First(
		long groupId, long companyId, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		List<LegalOrg> list = findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org
	 * @throws NoSuchLegalOrgException if a matching legal org could not be found
	 */
	@Override
	public LegalOrg findByFindGroupCompanyParent_Last(
			long groupId, long companyId, long parentId, boolean statusOrg,
			OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByFindGroupCompanyParent_Last(
			groupId, companyId, parentId, statusOrg, orderByComparator);

		if (legalOrg != null) {
			return legalOrg;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(", statusOrg=");
		msg.append(statusOrg);

		msg.append("}");

		throw new NoSuchLegalOrgException(msg.toString());
	}

	/**
	 * Returns the last legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal org, or <code>null</code> if a matching legal org could not be found
	 */
	@Override
	public LegalOrg fetchByFindGroupCompanyParent_Last(
		long groupId, long companyId, long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator) {

		int count = countByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg);

		if (count == 0) {
			return null;
		}

		List<LegalOrg> list = findByFindGroupCompanyParent(
			groupId, companyId, parentId, statusOrg, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal orgs before and after the current legal org in the ordered set where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param organizationId the primary key of the current legal org
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg[] findByFindGroupCompanyParent_PrevAndNext(
			long organizationId, long groupId, long companyId, long parentId,
			boolean statusOrg, OrderByComparator<LegalOrg> orderByComparator)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			LegalOrg[] array = new LegalOrgImpl[3];

			array[0] = getByFindGroupCompanyParent_PrevAndNext(
				session, legalOrg, groupId, companyId, parentId, statusOrg,
				orderByComparator, true);

			array[1] = legalOrg;

			array[2] = getByFindGroupCompanyParent_PrevAndNext(
				session, legalOrg, groupId, companyId, parentId, statusOrg,
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

	protected LegalOrg getByFindGroupCompanyParent_PrevAndNext(
		Session session, LegalOrg legalOrg, long groupId, long companyId,
		long parentId, boolean statusOrg,
		OrderByComparator<LegalOrg> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALORG_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2);

		query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSORG_2);

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
			query.append(LegalOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(parentId);

		qPos.add(statusOrg);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalOrg)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 */
	@Override
	public void removeByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg) {

		for (LegalOrg legalOrg :
				findByFindGroupCompanyParent(
					groupId, companyId, parentId, statusOrg, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs where groupId = &#63; and companyId = &#63; and parentId = &#63; and statusOrg = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param parentId the parent ID
	 * @param statusOrg the status org
	 * @return the number of matching legal orgs
	 */
	@Override
	public int countByFindGroupCompanyParent(
		long groupId, long companyId, long parentId, boolean statusOrg) {

		FinderPath finderPath = _finderPathCountByFindGroupCompanyParent;

		Object[] finderArgs = new Object[] {
			groupId, companyId, parentId, statusOrg
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALORG_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2);

			query.append(_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(parentId);

				qPos.add(statusOrg);

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
			"legalOrg.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_COMPANYID_2 =
			"legalOrg.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_PARENTID_2 =
			"legalOrg.parentId = ? AND ";

	private static final String
		_FINDER_COLUMN_FINDGROUPCOMPANYPARENT_STATUSORG_2 =
			"legalOrg.statusOrg = ?";

	public LegalOrgPersistenceImpl() {
		setModelClass(LegalOrg.class);

		setModelImplClass(LegalOrgImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal org in the entity cache if it is enabled.
	 *
	 * @param legalOrg the legal org
	 */
	@Override
	public void cacheResult(LegalOrg legalOrg) {
		entityCache.putResult(
			entityCacheEnabled, LegalOrgImpl.class, legalOrg.getPrimaryKey(),
			legalOrg);

		finderCache.putResult(
			_finderPathFetchByOrgId,
			new Object[] {legalOrg.getOrganizationId()}, legalOrg);

		finderCache.putResult(
			_finderPathFetchByG_O,
			new Object[] {legalOrg.getGroupId(), legalOrg.getOrganizationId()},
			legalOrg);

		legalOrg.resetOriginalValues();
	}

	/**
	 * Caches the legal orgs in the entity cache if it is enabled.
	 *
	 * @param legalOrgs the legal orgs
	 */
	@Override
	public void cacheResult(List<LegalOrg> legalOrgs) {
		for (LegalOrg legalOrg : legalOrgs) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalOrgImpl.class,
					legalOrg.getPrimaryKey()) == null) {

				cacheResult(legalOrg);
			}
			else {
				legalOrg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal orgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalOrgImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal org.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalOrg legalOrg) {
		entityCache.removeResult(
			entityCacheEnabled, LegalOrgImpl.class, legalOrg.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalOrgModelImpl)legalOrg, true);
	}

	@Override
	public void clearCache(List<LegalOrg> legalOrgs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalOrg legalOrg : legalOrgs) {
			entityCache.removeResult(
				entityCacheEnabled, LegalOrgImpl.class,
				legalOrg.getPrimaryKey());

			clearUniqueFindersCache((LegalOrgModelImpl)legalOrg, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalOrgImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalOrgModelImpl legalOrgModelImpl) {

		Object[] args = new Object[] {legalOrgModelImpl.getOrganizationId()};

		finderCache.putResult(
			_finderPathCountByOrgId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOrgId, args, legalOrgModelImpl, false);

		args = new Object[] {
			legalOrgModelImpl.getGroupId(),
			legalOrgModelImpl.getOrganizationId()
		};

		finderCache.putResult(
			_finderPathCountByG_O, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_O, args, legalOrgModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalOrgModelImpl legalOrgModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalOrgModelImpl.getOrganizationId()
			};

			finderCache.removeResult(_finderPathCountByOrgId, args);
			finderCache.removeResult(_finderPathFetchByOrgId, args);
		}

		if ((legalOrgModelImpl.getColumnBitmask() &
			 _finderPathFetchByOrgId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalOrgModelImpl.getOriginalOrganizationId()
			};

			finderCache.removeResult(_finderPathCountByOrgId, args);
			finderCache.removeResult(_finderPathFetchByOrgId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getOrganizationId()
			};

			finderCache.removeResult(_finderPathCountByG_O, args);
			finderCache.removeResult(_finderPathFetchByG_O, args);
		}

		if ((legalOrgModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_O.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalOrgModelImpl.getOriginalGroupId(),
				legalOrgModelImpl.getOriginalOrganizationId()
			};

			finderCache.removeResult(_finderPathCountByG_O, args);
			finderCache.removeResult(_finderPathFetchByG_O, args);
		}
	}

	/**
	 * Creates a new legal org with the primary key. Does not add the legal org to the database.
	 *
	 * @param organizationId the primary key for the new legal org
	 * @return the new legal org
	 */
	@Override
	public LegalOrg create(long organizationId) {
		LegalOrg legalOrg = new LegalOrgImpl();

		legalOrg.setNew(true);
		legalOrg.setPrimaryKey(organizationId);

		legalOrg.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalOrg;
	}

	/**
	 * Removes the legal org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org that was removed
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg remove(long organizationId) throws NoSuchLegalOrgException {
		return remove((Serializable)organizationId);
	}

	/**
	 * Removes the legal org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal org
	 * @return the legal org that was removed
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg remove(Serializable primaryKey)
		throws NoSuchLegalOrgException {

		Session session = null;

		try {
			session = openSession();

			LegalOrg legalOrg = (LegalOrg)session.get(
				LegalOrgImpl.class, primaryKey);

			if (legalOrg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalOrgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalOrg);
		}
		catch (NoSuchLegalOrgException noSuchEntityException) {
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
	protected LegalOrg removeImpl(LegalOrg legalOrg) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalOrg)) {
				legalOrg = (LegalOrg)session.get(
					LegalOrgImpl.class, legalOrg.getPrimaryKeyObj());
			}

			if (legalOrg != null) {
				session.delete(legalOrg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalOrg != null) {
			clearCache(legalOrg);
		}

		return legalOrg;
	}

	@Override
	public LegalOrg updateImpl(LegalOrg legalOrg) {
		boolean isNew = legalOrg.isNew();

		if (!(legalOrg instanceof LegalOrgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalOrg.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalOrg);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalOrg proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalOrg implementation " +
					legalOrg.getClass());
		}

		LegalOrgModelImpl legalOrgModelImpl = (LegalOrgModelImpl)legalOrg;

		Session session = null;

		try {
			session = openSession();

			if (legalOrg.isNew()) {
				session.save(legalOrg);

				legalOrg.setNew(false);
			}
			else {
				legalOrg = (LegalOrg)session.merge(legalOrg);
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
			Object[] args = new Object[] {legalOrgModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(), legalOrgModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {legalOrgModelImpl.isStatusOrg()};

			finderCache.removeResult(_finderPathCountByOrgStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOrgStatus, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(), legalOrgModelImpl.isStatusOrg(),
				legalOrgModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByS_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByS_L, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(), legalOrgModelImpl.isStatusOrg(),
				legalOrgModelImpl.isRssable()
			};

			finderCache.removeResult(_finderPathCountByS_Rss, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByS_Rss, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(), legalOrgModelImpl.getLanguage(),
				legalOrgModelImpl.getParentId()
			};

			finderCache.removeResult(_finderPathCountByG_L_P, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_P, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(), legalOrgModelImpl.getLanguage(),
				legalOrgModelImpl.getParentId(), legalOrgModelImpl.isStatusOrg()
			};

			finderCache.removeResult(_finderPathCountByG_L_P_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_P_S, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getCompanyId(),
				legalOrgModelImpl.getParentId()
			};

			finderCache.removeResult(_finderPathCountByG_C_P, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_P, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getCompanyId(),
				legalOrgModelImpl.getLanguage(),
				legalOrgModelImpl.getParentId(), legalOrgModelImpl.isStatusOrg()
			};

			finderCache.removeResult(_finderPathCountByG_C_L_P_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L_P_S, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getCompanyId(),
				legalOrgModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_C_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getCompanyId(),
				legalOrgModelImpl.getLanguage(), legalOrgModelImpl.isStatusOrg()
			};

			finderCache.removeResult(_finderPathCountByG_C_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_C_L_S, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(), legalOrgModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getCompanyId(),
				legalOrgModelImpl.isStatusOrg()
			};

			finderCache.removeResult(_finderPathCountByFindAllStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAllStatus, args);

			args = new Object[] {
				legalOrgModelImpl.getGroupId(),
				legalOrgModelImpl.getCompanyId(),
				legalOrgModelImpl.getParentId(), legalOrgModelImpl.isStatusOrg()
			};

			finderCache.removeResult(
				_finderPathCountByFindGroupCompanyParent, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroupCompanyParent, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalOrgModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOrgStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByOrgStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrgStatus, args);

				args = new Object[] {legalOrgModelImpl.isStatusOrg()};

				finderCache.removeResult(_finderPathCountByOrgStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrgStatus, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalStatusOrg(),
					legalOrgModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByS_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_L, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.isStatusOrg(),
					legalOrgModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByS_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_L, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS_Rss.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalStatusOrg(),
					legalOrgModelImpl.getOriginalRssable()
				};

				finderCache.removeResult(_finderPathCountByS_Rss, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_Rss, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.isStatusOrg(),
					legalOrgModelImpl.isRssable()
				};

				finderCache.removeResult(_finderPathCountByS_Rss, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS_Rss, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_P.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalLanguage(),
					legalOrgModelImpl.getOriginalParentId()
				};

				finderCache.removeResult(_finderPathCountByG_L_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_P, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getLanguage(),
					legalOrgModelImpl.getParentId()
				};

				finderCache.removeResult(_finderPathCountByG_L_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_P, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_P_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalLanguage(),
					legalOrgModelImpl.getOriginalParentId(),
					legalOrgModelImpl.getOriginalStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByG_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_P_S, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getLanguage(),
					legalOrgModelImpl.getParentId(),
					legalOrgModelImpl.isStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByG_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_P_S, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_P.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId(),
					legalOrgModelImpl.getOriginalParentId()
				};

				finderCache.removeResult(_finderPathCountByG_C_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_P, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId(),
					legalOrgModelImpl.getParentId()
				};

				finderCache.removeResult(_finderPathCountByG_C_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_P, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L_P_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId(),
					legalOrgModelImpl.getOriginalLanguage(),
					legalOrgModelImpl.getOriginalParentId(),
					legalOrgModelImpl.getOriginalStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_P_S, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId(),
					legalOrgModelImpl.getLanguage(),
					legalOrgModelImpl.getParentId(),
					legalOrgModelImpl.isStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_P_S, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId(),
					legalOrgModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_C_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId(),
					legalOrgModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_C_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_C_L_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId(),
					legalOrgModelImpl.getOriginalLanguage(),
					legalOrgModelImpl.getOriginalStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_S, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId(),
					legalOrgModelImpl.getLanguage(),
					legalOrgModelImpl.isStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByG_C_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_C_L_S, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAllStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId(),
					legalOrgModelImpl.getOriginalStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByFindAllStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAllStatus, args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId(),
					legalOrgModelImpl.isStatusOrg()
				};

				finderCache.removeResult(_finderPathCountByFindAllStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAllStatus, args);
			}

			if ((legalOrgModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroupCompanyParent.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalOrgModelImpl.getOriginalGroupId(),
					legalOrgModelImpl.getOriginalCompanyId(),
					legalOrgModelImpl.getOriginalParentId(),
					legalOrgModelImpl.getOriginalStatusOrg()
				};

				finderCache.removeResult(
					_finderPathCountByFindGroupCompanyParent, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroupCompanyParent,
					args);

				args = new Object[] {
					legalOrgModelImpl.getGroupId(),
					legalOrgModelImpl.getCompanyId(),
					legalOrgModelImpl.getParentId(),
					legalOrgModelImpl.isStatusOrg()
				};

				finderCache.removeResult(
					_finderPathCountByFindGroupCompanyParent, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroupCompanyParent,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalOrgImpl.class, legalOrg.getPrimaryKey(),
			legalOrg, false);

		clearUniqueFindersCache(legalOrgModelImpl, false);
		cacheUniqueFindersCache(legalOrgModelImpl);

		legalOrg.resetOriginalValues();

		return legalOrg;
	}

	/**
	 * Returns the legal org with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal org
	 * @return the legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalOrgException {

		LegalOrg legalOrg = fetchByPrimaryKey(primaryKey);

		if (legalOrg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalOrgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalOrg;
	}

	/**
	 * Returns the legal org with the primary key or throws a <code>NoSuchLegalOrgException</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org
	 * @throws NoSuchLegalOrgException if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg findByPrimaryKey(long organizationId)
		throws NoSuchLegalOrgException {

		return findByPrimaryKey((Serializable)organizationId);
	}

	/**
	 * Returns the legal org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the legal org
	 * @return the legal org, or <code>null</code> if a legal org with the primary key could not be found
	 */
	@Override
	public LegalOrg fetchByPrimaryKey(long organizationId) {
		return fetchByPrimaryKey((Serializable)organizationId);
	}

	/**
	 * Returns all the legal orgs.
	 *
	 * @return the legal orgs
	 */
	@Override
	public List<LegalOrg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @return the range of legal orgs
	 */
	@Override
	public List<LegalOrg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal orgs
	 */
	@Override
	public List<LegalOrg> findAll(
		int start, int end, OrderByComparator<LegalOrg> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalOrgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal orgs
	 * @param end the upper bound of the range of legal orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal orgs
	 */
	@Override
	public List<LegalOrg> findAll(
		int start, int end, OrderByComparator<LegalOrg> orderByComparator,
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

		List<LegalOrg> list = null;

		if (useFinderCache) {
			list = (List<LegalOrg>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALORG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALORG;

				sql = sql.concat(LegalOrgModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalOrg>)QueryUtil.list(
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
	 * Removes all the legal orgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalOrg legalOrg : findAll()) {
			remove(legalOrg);
		}
	}

	/**
	 * Returns the number of legal orgs.
	 *
	 * @return the number of legal orgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALORG);

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
		return "organizationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALORG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalOrgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal org persistence.
	 */
	@Activate
	public void activate() {
		LegalOrgModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalOrgModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByOrgId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByOrgId",
			new String[] {Long.class.getName()},
			LegalOrgModelImpl.ORGANIZATIONID_COLUMN_BITMASK);

		_finderPathCountByOrgId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrgId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByG_O = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_O",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.ORGANIZATIONID_COLUMN_BITMASK);

		_finderPathCountByG_O = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_O",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByOrgStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrgStatus",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOrgStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrgStatus",
			new String[] {Boolean.class.getName()},
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByOrgStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrgStatus",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByS_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_L",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.RSSABLE_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByS_Rss = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_Rss",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByG_L_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.PARENTID_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_L_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByG_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.PARENTID_COLUMN_BITMASK |
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

		_finderPathWithPaginationFindByG_C_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalOrgModelImpl.PARENTID_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_P",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.PARENTID_COLUMN_BITMASK |
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L_P_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByG_C_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_C_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByFindAllStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAllStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAllStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAllStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
			LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
			LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
			LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindAllStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAllStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindGroupCompanyParent = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
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
				entityCacheEnabled, finderCacheEnabled, LegalOrgImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByFindGroupCompanyParent",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Boolean.class.getName()
				},
				LegalOrgModelImpl.GROUPID_COLUMN_BITMASK |
				LegalOrgModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalOrgModelImpl.PARENTID_COLUMN_BITMASK |
				LegalOrgModelImpl.STATUSORG_COLUMN_BITMASK |
				LegalOrgModelImpl.POSITION_COLUMN_BITMASK |
				LegalOrgModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindGroupCompanyParent = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFindGroupCompanyParent",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalOrgImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalOrg"),
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

	private static final String _SQL_SELECT_LEGALORG =
		"SELECT legalOrg FROM LegalOrg legalOrg";

	private static final String _SQL_SELECT_LEGALORG_WHERE =
		"SELECT legalOrg FROM LegalOrg legalOrg WHERE ";

	private static final String _SQL_COUNT_LEGALORG =
		"SELECT COUNT(legalOrg) FROM LegalOrg legalOrg";

	private static final String _SQL_COUNT_LEGALORG_WHERE =
		"SELECT COUNT(legalOrg) FROM LegalOrg legalOrg WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalOrg.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalOrg exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalOrg exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalOrgPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}