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

import com.ecoit.elegaldocument.exception.NoSuchEcmsGURelationException;
import com.ecoit.elegaldocument.model.EcmsGURelation;
import com.ecoit.elegaldocument.model.impl.EcmsGURelationImpl;
import com.ecoit.elegaldocument.model.impl.EcmsGURelationModelImpl;
import com.ecoit.elegaldocument.service.persistence.EcmsGURelationPK;
import com.ecoit.elegaldocument.service.persistence.EcmsGURelationPersistence;
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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ecms gu relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = EcmsGURelationPersistence.class)
public class EcmsGURelationPersistenceImpl
	extends BasePersistenceImpl<EcmsGURelation>
	implements EcmsGURelationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EcmsGURelationUtil</code> to access the ecms gu relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EcmsGURelationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBygroupUserId;
	private FinderPath _finderPathWithoutPaginationFindBygroupUserId;
	private FinderPath _finderPathCountBygroupUserId;

	/**
	 * Returns all the ecms gu relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findBygroupUserId(long groupUserId) {
		return findBygroupUserId(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms gu relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end) {

		return findBygroupUserId(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return findBygroupUserId(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygroupUserId;
				finderArgs = new Object[] {groupUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygroupUserId;
			finderArgs = new Object[] {
				groupUserId, start, end, orderByComparator
			};
		}

		List<EcmsGURelation> list = null;

		if (useFinderCache) {
			list = (List<EcmsGURelation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcmsGURelation ecmsGURelation : list) {
					if (groupUserId != ecmsGURelation.getGroupUserId()) {
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

			query.append(_SQL_SELECT_ECMSGURELATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(EcmsGURelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<EcmsGURelation>)QueryUtil.list(
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
	 * Returns the first ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation findBygroupUserId_First(
			long groupUserId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = fetchBygroupUserId_First(
			groupUserId, orderByComparator);

		if (ecmsGURelation != null) {
			return ecmsGURelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchEcmsGURelationException(msg.toString());
	}

	/**
	 * Returns the first ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation fetchBygroupUserId_First(
		long groupUserId, OrderByComparator<EcmsGURelation> orderByComparator) {

		List<EcmsGURelation> list = findBygroupUserId(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation findBygroupUserId_Last(
			long groupUserId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = fetchBygroupUserId_Last(
			groupUserId, orderByComparator);

		if (ecmsGURelation != null) {
			return ecmsGURelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchEcmsGURelationException(msg.toString());
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation fetchBygroupUserId_Last(
		long groupUserId, OrderByComparator<EcmsGURelation> orderByComparator) {

		int count = countBygroupUserId(groupUserId);

		if (count == 0) {
			return null;
		}

		List<EcmsGURelation> list = findBygroupUserId(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ecms gu relations before and after the current ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param ecmsGURelationPK the primary key of the current ecms gu relation
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation[] findBygroupUserId_PrevAndNext(
			EcmsGURelationPK ecmsGURelationPK, long groupUserId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = findByPrimaryKey(ecmsGURelationPK);

		Session session = null;

		try {
			session = openSession();

			EcmsGURelation[] array = new EcmsGURelationImpl[3];

			array[0] = getBygroupUserId_PrevAndNext(
				session, ecmsGURelation, groupUserId, orderByComparator, true);

			array[1] = ecmsGURelation;

			array[2] = getBygroupUserId_PrevAndNext(
				session, ecmsGURelation, groupUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcmsGURelation getBygroupUserId_PrevAndNext(
		Session session, EcmsGURelation ecmsGURelation, long groupUserId,
		OrderByComparator<EcmsGURelation> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ECMSGURELATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2);

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
			query.append(EcmsGURelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecmsGURelation)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<EcmsGURelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ecms gu relations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeBygroupUserId(long groupUserId) {
		for (EcmsGURelation ecmsGURelation :
				findBygroupUserId(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecmsGURelation);
		}
	}

	/**
	 * Returns the number of ecms gu relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms gu relations
	 */
	@Override
	public int countBygroupUserId(long groupUserId) {
		FinderPath finderPath = _finderPathCountBygroupUserId;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ECMSGURELATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

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

	private static final String _FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2 =
		"ecmsGURelation.id.groupUserId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the ecms gu relations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms gu relations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findByuserId(
		long userId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findByuserId(
		long userId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<EcmsGURelation> list = null;

		if (useFinderCache) {
			list = (List<EcmsGURelation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcmsGURelation ecmsGURelation : list) {
					if (userId != ecmsGURelation.getUserId()) {
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

			query.append(_SQL_SELECT_ECMSGURELATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(EcmsGURelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<EcmsGURelation>)QueryUtil.list(
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
	 * Returns the first ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation findByuserId_First(
			long userId, OrderByComparator<EcmsGURelation> orderByComparator)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = fetchByuserId_First(
			userId, orderByComparator);

		if (ecmsGURelation != null) {
			return ecmsGURelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchEcmsGURelationException(msg.toString());
	}

	/**
	 * Returns the first ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation fetchByuserId_First(
		long userId, OrderByComparator<EcmsGURelation> orderByComparator) {

		List<EcmsGURelation> list = findByuserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation findByuserId_Last(
			long userId, OrderByComparator<EcmsGURelation> orderByComparator)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = fetchByuserId_Last(
			userId, orderByComparator);

		if (ecmsGURelation != null) {
			return ecmsGURelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchEcmsGURelationException(msg.toString());
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation fetchByuserId_Last(
		long userId, OrderByComparator<EcmsGURelation> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<EcmsGURelation> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ecms gu relations before and after the current ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param ecmsGURelationPK the primary key of the current ecms gu relation
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation[] findByuserId_PrevAndNext(
			EcmsGURelationPK ecmsGURelationPK, long userId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = findByPrimaryKey(ecmsGURelationPK);

		Session session = null;

		try {
			session = openSession();

			EcmsGURelation[] array = new EcmsGURelationImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, ecmsGURelation, userId, orderByComparator, true);

			array[1] = ecmsGURelation;

			array[2] = getByuserId_PrevAndNext(
				session, ecmsGURelation, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcmsGURelation getByuserId_PrevAndNext(
		Session session, EcmsGURelation ecmsGURelation, long userId,
		OrderByComparator<EcmsGURelation> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ECMSGURELATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(EcmsGURelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecmsGURelation)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<EcmsGURelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ecms gu relations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (EcmsGURelation ecmsGURelation :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecmsGURelation);
		}
	}

	/**
	 * Returns the number of ecms gu relations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ecms gu relations
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ECMSGURELATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"ecmsGURelation.id.userId = ?";

	private FinderPath _finderPathFetchByG_U;
	private FinderPath _finderPathCountByG_U;

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or throws a <code>NoSuchEcmsGURelationException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation findByG_U(long groupUserId, long userId)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = fetchByG_U(groupUserId, userId);

		if (ecmsGURelation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupUserId=");
			msg.append(groupUserId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEcmsGURelationException(msg.toString());
		}

		return ecmsGURelation;
	}

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation fetchByG_U(long groupUserId, long userId) {
		return fetchByG_U(groupUserId, userId, true);
	}

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	@Override
	public EcmsGURelation fetchByG_U(
		long groupUserId, long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupUserId, userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_U, finderArgs, this);
		}

		if (result instanceof EcmsGURelation) {
			EcmsGURelation ecmsGURelation = (EcmsGURelation)result;

			if ((groupUserId != ecmsGURelation.getGroupUserId()) ||
				(userId != ecmsGURelation.getUserId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ECMSGURELATION_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPUSERID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				qPos.add(userId);

				List<EcmsGURelation> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_U, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupUserId, userId};
							}

							_log.warn(
								"EcmsGURelationPersistenceImpl.fetchByG_U(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EcmsGURelation ecmsGURelation = list.get(0);

					result = ecmsGURelation;

					cacheResult(ecmsGURelation);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_U, finderArgs);
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
			return (EcmsGURelation)result;
		}
	}

	/**
	 * Removes the ecms gu relation where groupUserId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the ecms gu relation that was removed
	 */
	@Override
	public EcmsGURelation removeByG_U(long groupUserId, long userId)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = findByG_U(groupUserId, userId);

		return remove(ecmsGURelation);
	}

	/**
	 * Returns the number of ecms gu relations where groupUserId = &#63; and userId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the number of matching ecms gu relations
	 */
	@Override
	public int countByG_U(long groupUserId, long userId) {
		FinderPath finderPath = _finderPathCountByG_U;

		Object[] finderArgs = new Object[] {groupUserId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ECMSGURELATION_WHERE);

			query.append(_FINDER_COLUMN_G_U_GROUPUSERID_2);

			query.append(_FINDER_COLUMN_G_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

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

	private static final String _FINDER_COLUMN_G_U_GROUPUSERID_2 =
		"ecmsGURelation.id.groupUserId = ? AND ";

	private static final String _FINDER_COLUMN_G_U_USERID_2 =
		"ecmsGURelation.id.userId = ?";

	public EcmsGURelationPersistenceImpl() {
		setModelClass(EcmsGURelation.class);

		setModelImplClass(EcmsGURelationImpl.class);
		setModelPKClass(EcmsGURelationPK.class);
	}

	/**
	 * Caches the ecms gu relation in the entity cache if it is enabled.
	 *
	 * @param ecmsGURelation the ecms gu relation
	 */
	@Override
	public void cacheResult(EcmsGURelation ecmsGURelation) {
		entityCache.putResult(
			entityCacheEnabled, EcmsGURelationImpl.class,
			ecmsGURelation.getPrimaryKey(), ecmsGURelation);

		finderCache.putResult(
			_finderPathFetchByG_U,
			new Object[] {
				ecmsGURelation.getGroupUserId(), ecmsGURelation.getUserId()
			},
			ecmsGURelation);

		ecmsGURelation.resetOriginalValues();
	}

	/**
	 * Caches the ecms gu relations in the entity cache if it is enabled.
	 *
	 * @param ecmsGURelations the ecms gu relations
	 */
	@Override
	public void cacheResult(List<EcmsGURelation> ecmsGURelations) {
		for (EcmsGURelation ecmsGURelation : ecmsGURelations) {
			if (entityCache.getResult(
					entityCacheEnabled, EcmsGURelationImpl.class,
					ecmsGURelation.getPrimaryKey()) == null) {

				cacheResult(ecmsGURelation);
			}
			else {
				ecmsGURelation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ecms gu relations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EcmsGURelationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ecms gu relation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EcmsGURelation ecmsGURelation) {
		entityCache.removeResult(
			entityCacheEnabled, EcmsGURelationImpl.class,
			ecmsGURelation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EcmsGURelationModelImpl)ecmsGURelation, true);
	}

	@Override
	public void clearCache(List<EcmsGURelation> ecmsGURelations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EcmsGURelation ecmsGURelation : ecmsGURelations) {
			entityCache.removeResult(
				entityCacheEnabled, EcmsGURelationImpl.class,
				ecmsGURelation.getPrimaryKey());

			clearUniqueFindersCache(
				(EcmsGURelationModelImpl)ecmsGURelation, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, EcmsGURelationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EcmsGURelationModelImpl ecmsGURelationModelImpl) {

		Object[] args = new Object[] {
			ecmsGURelationModelImpl.getGroupUserId(),
			ecmsGURelationModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountByG_U, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_U, args, ecmsGURelationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EcmsGURelationModelImpl ecmsGURelationModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				ecmsGURelationModelImpl.getGroupUserId(),
				ecmsGURelationModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByG_U, args);
			finderCache.removeResult(_finderPathFetchByG_U, args);
		}

		if ((ecmsGURelationModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_U.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ecmsGURelationModelImpl.getOriginalGroupUserId(),
				ecmsGURelationModelImpl.getOriginalUserId()
			};

			finderCache.removeResult(_finderPathCountByG_U, args);
			finderCache.removeResult(_finderPathFetchByG_U, args);
		}
	}

	/**
	 * Creates a new ecms gu relation with the primary key. Does not add the ecms gu relation to the database.
	 *
	 * @param ecmsGURelationPK the primary key for the new ecms gu relation
	 * @return the new ecms gu relation
	 */
	@Override
	public EcmsGURelation create(EcmsGURelationPK ecmsGURelationPK) {
		EcmsGURelation ecmsGURelation = new EcmsGURelationImpl();

		ecmsGURelation.setNew(true);
		ecmsGURelation.setPrimaryKey(ecmsGURelationPK);

		return ecmsGURelation;
	}

	/**
	 * Removes the ecms gu relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation that was removed
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation remove(EcmsGURelationPK ecmsGURelationPK)
		throws NoSuchEcmsGURelationException {

		return remove((Serializable)ecmsGURelationPK);
	}

	/**
	 * Removes the ecms gu relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ecms gu relation
	 * @return the ecms gu relation that was removed
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation remove(Serializable primaryKey)
		throws NoSuchEcmsGURelationException {

		Session session = null;

		try {
			session = openSession();

			EcmsGURelation ecmsGURelation = (EcmsGURelation)session.get(
				EcmsGURelationImpl.class, primaryKey);

			if (ecmsGURelation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEcmsGURelationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ecmsGURelation);
		}
		catch (NoSuchEcmsGURelationException noSuchEntityException) {
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
	protected EcmsGURelation removeImpl(EcmsGURelation ecmsGURelation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ecmsGURelation)) {
				ecmsGURelation = (EcmsGURelation)session.get(
					EcmsGURelationImpl.class,
					ecmsGURelation.getPrimaryKeyObj());
			}

			if (ecmsGURelation != null) {
				session.delete(ecmsGURelation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ecmsGURelation != null) {
			clearCache(ecmsGURelation);
		}

		return ecmsGURelation;
	}

	@Override
	public EcmsGURelation updateImpl(EcmsGURelation ecmsGURelation) {
		boolean isNew = ecmsGURelation.isNew();

		if (!(ecmsGURelation instanceof EcmsGURelationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ecmsGURelation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ecmsGURelation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ecmsGURelation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EcmsGURelation implementation " +
					ecmsGURelation.getClass());
		}

		EcmsGURelationModelImpl ecmsGURelationModelImpl =
			(EcmsGURelationModelImpl)ecmsGURelation;

		Session session = null;

		try {
			session = openSession();

			if (ecmsGURelation.isNew()) {
				session.save(ecmsGURelation);

				ecmsGURelation.setNew(false);
			}
			else {
				ecmsGURelation = (EcmsGURelation)session.merge(ecmsGURelation);
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
				ecmsGURelationModelImpl.getGroupUserId()
			};

			finderCache.removeResult(_finderPathCountBygroupUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBygroupUserId, args);

			args = new Object[] {ecmsGURelationModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByuserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByuserId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ecmsGURelationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBygroupUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ecmsGURelationModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountBygroupUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBygroupUserId, args);

				args = new Object[] {ecmsGURelationModelImpl.getGroupUserId()};

				finderCache.removeResult(_finderPathCountBygroupUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBygroupUserId, args);
			}

			if ((ecmsGURelationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByuserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ecmsGURelationModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByuserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuserId, args);

				args = new Object[] {ecmsGURelationModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByuserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByuserId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, EcmsGURelationImpl.class,
			ecmsGURelation.getPrimaryKey(), ecmsGURelation, false);

		clearUniqueFindersCache(ecmsGURelationModelImpl, false);
		cacheUniqueFindersCache(ecmsGURelationModelImpl);

		ecmsGURelation.resetOriginalValues();

		return ecmsGURelation;
	}

	/**
	 * Returns the ecms gu relation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ecms gu relation
	 * @return the ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEcmsGURelationException {

		EcmsGURelation ecmsGURelation = fetchByPrimaryKey(primaryKey);

		if (ecmsGURelation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEcmsGURelationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ecmsGURelation;
	}

	/**
	 * Returns the ecms gu relation with the primary key or throws a <code>NoSuchEcmsGURelationException</code> if it could not be found.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation findByPrimaryKey(EcmsGURelationPK ecmsGURelationPK)
		throws NoSuchEcmsGURelationException {

		return findByPrimaryKey((Serializable)ecmsGURelationPK);
	}

	/**
	 * Returns the ecms gu relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation, or <code>null</code> if a ecms gu relation with the primary key could not be found
	 */
	@Override
	public EcmsGURelation fetchByPrimaryKey(EcmsGURelationPK ecmsGURelationPK) {
		return fetchByPrimaryKey((Serializable)ecmsGURelationPK);
	}

	/**
	 * Returns all the ecms gu relations.
	 *
	 * @return the ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findAll(
		int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ecms gu relations
	 */
	@Override
	public List<EcmsGURelation> findAll(
		int start, int end, OrderByComparator<EcmsGURelation> orderByComparator,
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

		List<EcmsGURelation> list = null;

		if (useFinderCache) {
			list = (List<EcmsGURelation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ECMSGURELATION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ECMSGURELATION;

				sql = sql.concat(EcmsGURelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<EcmsGURelation>)QueryUtil.list(
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
	 * Removes all the ecms gu relations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EcmsGURelation ecmsGURelation : findAll()) {
			remove(ecmsGURelation);
		}
	}

	/**
	 * Returns the number of ecms gu relations.
	 *
	 * @return the number of ecms gu relations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ECMSGURELATION);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ecmsGURelationPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ECMSGURELATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EcmsGURelationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ecms gu relation persistence.
	 */
	@Activate
	public void activate() {
		EcmsGURelationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		EcmsGURelationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupUserId",
			new String[] {Long.class.getName()},
			EcmsGURelationModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()},
			EcmsGURelationModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByuserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()});

		_finderPathFetchByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGURelationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			EcmsGURelationModelImpl.GROUPUSERID_COLUMN_BITMASK |
			EcmsGURelationModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByG_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EcmsGURelationImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.EcmsGURelation"),
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

	private static final String _SQL_SELECT_ECMSGURELATION =
		"SELECT ecmsGURelation FROM EcmsGURelation ecmsGURelation";

	private static final String _SQL_SELECT_ECMSGURELATION_WHERE =
		"SELECT ecmsGURelation FROM EcmsGURelation ecmsGURelation WHERE ";

	private static final String _SQL_COUNT_ECMSGURELATION =
		"SELECT COUNT(ecmsGURelation) FROM EcmsGURelation ecmsGURelation";

	private static final String _SQL_COUNT_ECMSGURELATION_WHERE =
		"SELECT COUNT(ecmsGURelation) FROM EcmsGURelation ecmsGURelation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ecmsGURelation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EcmsGURelation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EcmsGURelation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EcmsGURelationPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userId", "groupUserId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}