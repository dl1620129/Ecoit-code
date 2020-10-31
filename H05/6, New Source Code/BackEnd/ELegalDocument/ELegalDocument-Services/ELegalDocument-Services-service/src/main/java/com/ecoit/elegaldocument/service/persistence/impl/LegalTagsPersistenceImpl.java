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

import com.ecoit.elegaldocument.exception.NoSuchLegalTagsException;
import com.ecoit.elegaldocument.model.LegalTags;
import com.ecoit.elegaldocument.model.impl.LegalTagsImpl;
import com.ecoit.elegaldocument.model.impl.LegalTagsModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalTagsPersistence;
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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the legal tags service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalTagsPersistence.class)
public class LegalTagsPersistenceImpl
	extends BasePersistenceImpl<LegalTags> implements LegalTagsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalTagsUtil</code> to access the legal tags persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalTagsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal tagses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal tagses
	 */
	@Override
	public List<LegalTags> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal tagses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of matching legal tagses
	 */
	@Override
	public List<LegalTags> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal tagses
	 */
	@Override
	public List<LegalTags> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalTags> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal tagses
	 */
	@Override
	public List<LegalTags> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalTags> orderByComparator,
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

		List<LegalTags> list = null;

		if (useFinderCache) {
			list = (List<LegalTags>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalTags legalTags : list) {
					if (groupId != legalTags.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALTAGS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTagsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalTags>)QueryUtil.list(
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
	 * Returns the first legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	@Override
	public LegalTags findByGroupId_First(
			long groupId, OrderByComparator<LegalTags> orderByComparator)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = fetchByGroupId_First(groupId, orderByComparator);

		if (legalTags != null) {
			return legalTags;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalTagsException(msg.toString());
	}

	/**
	 * Returns the first legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	@Override
	public LegalTags fetchByGroupId_First(
		long groupId, OrderByComparator<LegalTags> orderByComparator) {

		List<LegalTags> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	@Override
	public LegalTags findByGroupId_Last(
			long groupId, OrderByComparator<LegalTags> orderByComparator)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = fetchByGroupId_Last(groupId, orderByComparator);

		if (legalTags != null) {
			return legalTags;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalTagsException(msg.toString());
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	@Override
	public LegalTags fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalTags> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalTags> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal tagses before and after the current legal tags in the ordered set where groupId = &#63;.
	 *
	 * @param tagId the primary key of the current legal tags
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags[] findByGroupId_PrevAndNext(
			long tagId, long groupId,
			OrderByComparator<LegalTags> orderByComparator)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = findByPrimaryKey(tagId);

		Session session = null;

		try {
			session = openSession();

			LegalTags[] array = new LegalTagsImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalTags, groupId, orderByComparator, true);

			array[1] = legalTags;

			array[2] = getByGroupId_PrevAndNext(
				session, legalTags, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalTags getByGroupId_PrevAndNext(
		Session session, LegalTags legalTags, long groupId,
		OrderByComparator<LegalTags> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALTAGS_WHERE);

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
			query.append(LegalTagsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalTags)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalTags> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal tagses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalTags legalTags :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalTags);
		}
	}

	/**
	 * Returns the number of legal tagses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal tagses
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALTAGS_WHERE);

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
		"legalTags.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByP_S;
	private FinderPath _finderPathWithoutPaginationFindByP_S;
	private FinderPath _finderPathCountByP_S;

	/**
	 * Returns all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @return the matching legal tagses
	 */
	@Override
	public List<LegalTags> findByP_S(long groupId, boolean statusTags) {
		return findByP_S(
			groupId, statusTags, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of matching legal tagses
	 */
	@Override
	public List<LegalTags> findByP_S(
		long groupId, boolean statusTags, int start, int end) {

		return findByP_S(groupId, statusTags, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal tagses
	 */
	@Override
	public List<LegalTags> findByP_S(
		long groupId, boolean statusTags, int start, int end,
		OrderByComparator<LegalTags> orderByComparator) {

		return findByP_S(
			groupId, statusTags, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal tagses
	 */
	@Override
	public List<LegalTags> findByP_S(
		long groupId, boolean statusTags, int start, int end,
		OrderByComparator<LegalTags> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_S;
				finderArgs = new Object[] {groupId, statusTags};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_S;
			finderArgs = new Object[] {
				groupId, statusTags, start, end, orderByComparator
			};
		}

		List<LegalTags> list = null;

		if (useFinderCache) {
			list = (List<LegalTags>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalTags legalTags : list) {
					if ((groupId != legalTags.getGroupId()) ||
						(statusTags != legalTags.isStatusTags())) {

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

			query.append(_SQL_SELECT_LEGALTAGS_WHERE);

			query.append(_FINDER_COLUMN_P_S_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_STATUSTAGS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTagsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusTags);

				list = (List<LegalTags>)QueryUtil.list(
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
	 * Returns the first legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	@Override
	public LegalTags findByP_S_First(
			long groupId, boolean statusTags,
			OrderByComparator<LegalTags> orderByComparator)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = fetchByP_S_First(
			groupId, statusTags, orderByComparator);

		if (legalTags != null) {
			return legalTags;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusTags=");
		msg.append(statusTags);

		msg.append("}");

		throw new NoSuchLegalTagsException(msg.toString());
	}

	/**
	 * Returns the first legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	@Override
	public LegalTags fetchByP_S_First(
		long groupId, boolean statusTags,
		OrderByComparator<LegalTags> orderByComparator) {

		List<LegalTags> list = findByP_S(
			groupId, statusTags, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags
	 * @throws NoSuchLegalTagsException if a matching legal tags could not be found
	 */
	@Override
	public LegalTags findByP_S_Last(
			long groupId, boolean statusTags,
			OrderByComparator<LegalTags> orderByComparator)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = fetchByP_S_Last(
			groupId, statusTags, orderByComparator);

		if (legalTags != null) {
			return legalTags;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusTags=");
		msg.append(statusTags);

		msg.append("}");

		throw new NoSuchLegalTagsException(msg.toString());
	}

	/**
	 * Returns the last legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal tags, or <code>null</code> if a matching legal tags could not be found
	 */
	@Override
	public LegalTags fetchByP_S_Last(
		long groupId, boolean statusTags,
		OrderByComparator<LegalTags> orderByComparator) {

		int count = countByP_S(groupId, statusTags);

		if (count == 0) {
			return null;
		}

		List<LegalTags> list = findByP_S(
			groupId, statusTags, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal tagses before and after the current legal tags in the ordered set where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param tagId the primary key of the current legal tags
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags[] findByP_S_PrevAndNext(
			long tagId, long groupId, boolean statusTags,
			OrderByComparator<LegalTags> orderByComparator)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = findByPrimaryKey(tagId);

		Session session = null;

		try {
			session = openSession();

			LegalTags[] array = new LegalTagsImpl[3];

			array[0] = getByP_S_PrevAndNext(
				session, legalTags, groupId, statusTags, orderByComparator,
				true);

			array[1] = legalTags;

			array[2] = getByP_S_PrevAndNext(
				session, legalTags, groupId, statusTags, orderByComparator,
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

	protected LegalTags getByP_S_PrevAndNext(
		Session session, LegalTags legalTags, long groupId, boolean statusTags,
		OrderByComparator<LegalTags> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALTAGS_WHERE);

		query.append(_FINDER_COLUMN_P_S_GROUPID_2);

		query.append(_FINDER_COLUMN_P_S_STATUSTAGS_2);

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
			query.append(LegalTagsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusTags);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalTags)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalTags> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal tagses where groupId = &#63; and statusTags = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 */
	@Override
	public void removeByP_S(long groupId, boolean statusTags) {
		for (LegalTags legalTags :
				findByP_S(
					groupId, statusTags, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalTags);
		}
	}

	/**
	 * Returns the number of legal tagses where groupId = &#63; and statusTags = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusTags the status tags
	 * @return the number of matching legal tagses
	 */
	@Override
	public int countByP_S(long groupId, boolean statusTags) {
		FinderPath finderPath = _finderPathCountByP_S;

		Object[] finderArgs = new Object[] {groupId, statusTags};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALTAGS_WHERE);

			query.append(_FINDER_COLUMN_P_S_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_STATUSTAGS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusTags);

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

	private static final String _FINDER_COLUMN_P_S_GROUPID_2 =
		"legalTags.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_S_STATUSTAGS_2 =
		"legalTags.statusTags = ?";

	public LegalTagsPersistenceImpl() {
		setModelClass(LegalTags.class);

		setModelImplClass(LegalTagsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal tags in the entity cache if it is enabled.
	 *
	 * @param legalTags the legal tags
	 */
	@Override
	public void cacheResult(LegalTags legalTags) {
		entityCache.putResult(
			entityCacheEnabled, LegalTagsImpl.class, legalTags.getPrimaryKey(),
			legalTags);

		legalTags.resetOriginalValues();
	}

	/**
	 * Caches the legal tagses in the entity cache if it is enabled.
	 *
	 * @param legalTagses the legal tagses
	 */
	@Override
	public void cacheResult(List<LegalTags> legalTagses) {
		for (LegalTags legalTags : legalTagses) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalTagsImpl.class,
					legalTags.getPrimaryKey()) == null) {

				cacheResult(legalTags);
			}
			else {
				legalTags.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal tagses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalTagsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal tags.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalTags legalTags) {
		entityCache.removeResult(
			entityCacheEnabled, LegalTagsImpl.class, legalTags.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalTags> legalTagses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalTags legalTags : legalTagses) {
			entityCache.removeResult(
				entityCacheEnabled, LegalTagsImpl.class,
				legalTags.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalTagsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal tags with the primary key. Does not add the legal tags to the database.
	 *
	 * @param tagId the primary key for the new legal tags
	 * @return the new legal tags
	 */
	@Override
	public LegalTags create(long tagId) {
		LegalTags legalTags = new LegalTagsImpl();

		legalTags.setNew(true);
		legalTags.setPrimaryKey(tagId);

		legalTags.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalTags;
	}

	/**
	 * Removes the legal tags with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags that was removed
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags remove(long tagId) throws NoSuchLegalTagsException {
		return remove((Serializable)tagId);
	}

	/**
	 * Removes the legal tags with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal tags
	 * @return the legal tags that was removed
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags remove(Serializable primaryKey)
		throws NoSuchLegalTagsException {

		Session session = null;

		try {
			session = openSession();

			LegalTags legalTags = (LegalTags)session.get(
				LegalTagsImpl.class, primaryKey);

			if (legalTags == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalTagsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalTags);
		}
		catch (NoSuchLegalTagsException noSuchEntityException) {
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
	protected LegalTags removeImpl(LegalTags legalTags) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalTags)) {
				legalTags = (LegalTags)session.get(
					LegalTagsImpl.class, legalTags.getPrimaryKeyObj());
			}

			if (legalTags != null) {
				session.delete(legalTags);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalTags != null) {
			clearCache(legalTags);
		}

		return legalTags;
	}

	@Override
	public LegalTags updateImpl(LegalTags legalTags) {
		boolean isNew = legalTags.isNew();

		if (!(legalTags instanceof LegalTagsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalTags.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalTags);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalTags proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalTags implementation " +
					legalTags.getClass());
		}

		LegalTagsModelImpl legalTagsModelImpl = (LegalTagsModelImpl)legalTags;

		Session session = null;

		try {
			session = openSession();

			if (legalTags.isNew()) {
				session.save(legalTags);

				legalTags.setNew(false);
			}
			else {
				legalTags = (LegalTags)session.merge(legalTags);
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
			Object[] args = new Object[] {legalTagsModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalTagsModelImpl.getGroupId(),
				legalTagsModelImpl.isStatusTags()
			};

			finderCache.removeResult(_finderPathCountByP_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_S, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalTagsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTagsModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalTagsModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalTagsModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTagsModelImpl.getOriginalGroupId(),
					legalTagsModelImpl.getOriginalStatusTags()
				};

				finderCache.removeResult(_finderPathCountByP_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S, args);

				args = new Object[] {
					legalTagsModelImpl.getGroupId(),
					legalTagsModelImpl.isStatusTags()
				};

				finderCache.removeResult(_finderPathCountByP_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalTagsImpl.class, legalTags.getPrimaryKey(),
			legalTags, false);

		legalTags.resetOriginalValues();

		return legalTags;
	}

	/**
	 * Returns the legal tags with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal tags
	 * @return the legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalTagsException {

		LegalTags legalTags = fetchByPrimaryKey(primaryKey);

		if (legalTags == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalTagsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalTags;
	}

	/**
	 * Returns the legal tags with the primary key or throws a <code>NoSuchLegalTagsException</code> if it could not be found.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags
	 * @throws NoSuchLegalTagsException if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags findByPrimaryKey(long tagId)
		throws NoSuchLegalTagsException {

		return findByPrimaryKey((Serializable)tagId);
	}

	/**
	 * Returns the legal tags with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the legal tags
	 * @return the legal tags, or <code>null</code> if a legal tags with the primary key could not be found
	 */
	@Override
	public LegalTags fetchByPrimaryKey(long tagId) {
		return fetchByPrimaryKey((Serializable)tagId);
	}

	/**
	 * Returns all the legal tagses.
	 *
	 * @return the legal tagses
	 */
	@Override
	public List<LegalTags> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @return the range of legal tagses
	 */
	@Override
	public List<LegalTags> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal tagses
	 */
	@Override
	public List<LegalTags> findAll(
		int start, int end, OrderByComparator<LegalTags> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal tagses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTagsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal tagses
	 * @param end the upper bound of the range of legal tagses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal tagses
	 */
	@Override
	public List<LegalTags> findAll(
		int start, int end, OrderByComparator<LegalTags> orderByComparator,
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

		List<LegalTags> list = null;

		if (useFinderCache) {
			list = (List<LegalTags>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALTAGS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALTAGS;

				sql = sql.concat(LegalTagsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalTags>)QueryUtil.list(
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
	 * Removes all the legal tagses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalTags legalTags : findAll()) {
			remove(legalTags);
		}
	}

	/**
	 * Returns the number of legal tagses.
	 *
	 * @return the number of legal tagses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALTAGS);

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
		return "tagId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALTAGS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalTagsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal tags persistence.
	 */
	@Activate
	public void activate() {
		LegalTagsModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalTagsModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalTagsModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTagsModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByP_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTagsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			LegalTagsModelImpl.GROUPID_COLUMN_BITMASK |
			LegalTagsModelImpl.STATUSTAGS_COLUMN_BITMASK |
			LegalTagsModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByP_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S",
			new String[] {Long.class.getName(), Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalTagsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalTags"),
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

	private static final String _SQL_SELECT_LEGALTAGS =
		"SELECT legalTags FROM LegalTags legalTags";

	private static final String _SQL_SELECT_LEGALTAGS_WHERE =
		"SELECT legalTags FROM LegalTags legalTags WHERE ";

	private static final String _SQL_COUNT_LEGALTAGS =
		"SELECT COUNT(legalTags) FROM LegalTags legalTags";

	private static final String _SQL_COUNT_LEGALTAGS_WHERE =
		"SELECT COUNT(legalTags) FROM LegalTags legalTags WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalTags.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalTags exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalTags exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalTagsPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}