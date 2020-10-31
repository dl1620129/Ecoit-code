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

import com.ecoit.elegaldocument.exception.NoSuchEcmsPGRelationException;
import com.ecoit.elegaldocument.model.EcmsPGRelation;
import com.ecoit.elegaldocument.model.impl.EcmsPGRelationImpl;
import com.ecoit.elegaldocument.model.impl.EcmsPGRelationModelImpl;
import com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPK;
import com.ecoit.elegaldocument.service.persistence.EcmsPGRelationPersistence;
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
 * The persistence implementation for the ecms pg relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = EcmsPGRelationPersistence.class)
public class EcmsPGRelationPersistenceImpl
	extends BasePersistenceImpl<EcmsPGRelation>
	implements EcmsPGRelationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EcmsPGRelationUtil</code> to access the ecms pg relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EcmsPGRelationImpl.class.getName();

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
	 * Returns all the ecms pg relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBygroupUserId(long groupUserId) {
		return findBygroupUserId(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms pg relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end) {

		return findBygroupUserId(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return findBygroupUserId(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator,
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

		List<EcmsPGRelation> list = null;

		if (useFinderCache) {
			list = (List<EcmsPGRelation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcmsPGRelation ecmsPGRelation : list) {
					if (groupUserId != ecmsPGRelation.getGroupUserId()) {
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

			query.append(_SQL_SELECT_ECMSPGRELATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(EcmsPGRelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<EcmsPGRelation>)QueryUtil.list(
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
	 * Returns the first ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation findBygroupUserId_First(
			long groupUserId,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = fetchBygroupUserId_First(
			groupUserId, orderByComparator);

		if (ecmsPGRelation != null) {
			return ecmsPGRelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchEcmsPGRelationException(msg.toString());
	}

	/**
	 * Returns the first ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation fetchBygroupUserId_First(
		long groupUserId, OrderByComparator<EcmsPGRelation> orderByComparator) {

		List<EcmsPGRelation> list = findBygroupUserId(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation findBygroupUserId_Last(
			long groupUserId,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = fetchBygroupUserId_Last(
			groupUserId, orderByComparator);

		if (ecmsPGRelation != null) {
			return ecmsPGRelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchEcmsPGRelationException(msg.toString());
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation fetchBygroupUserId_Last(
		long groupUserId, OrderByComparator<EcmsPGRelation> orderByComparator) {

		int count = countBygroupUserId(groupUserId);

		if (count == 0) {
			return null;
		}

		List<EcmsPGRelation> list = findBygroupUserId(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ecms pg relations before and after the current ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param ecmsPGRelationPK the primary key of the current ecms pg relation
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation[] findBygroupUserId_PrevAndNext(
			EcmsPGRelationPK ecmsPGRelationPK, long groupUserId,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = findByPrimaryKey(ecmsPGRelationPK);

		Session session = null;

		try {
			session = openSession();

			EcmsPGRelation[] array = new EcmsPGRelationImpl[3];

			array[0] = getBygroupUserId_PrevAndNext(
				session, ecmsPGRelation, groupUserId, orderByComparator, true);

			array[1] = ecmsPGRelation;

			array[2] = getBygroupUserId_PrevAndNext(
				session, ecmsPGRelation, groupUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcmsPGRelation getBygroupUserId_PrevAndNext(
		Session session, EcmsPGRelation ecmsPGRelation, long groupUserId,
		OrderByComparator<EcmsPGRelation> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ECMSPGRELATION_WHERE);

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
			query.append(EcmsPGRelationModelImpl.ORDER_BY_JPQL);
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
						ecmsPGRelation)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<EcmsPGRelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ecms pg relations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeBygroupUserId(long groupUserId) {
		for (EcmsPGRelation ecmsPGRelation :
				findBygroupUserId(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecmsPGRelation);
		}
	}

	/**
	 * Returns the number of ecms pg relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms pg relations
	 */
	@Override
	public int countBygroupUserId(long groupUserId) {
		FinderPath finderPath = _finderPathCountBygroupUserId;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ECMSPGRELATION_WHERE);

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
		"ecmsPGRelation.id.groupUserId = ?";

	private FinderPath _finderPathWithPaginationFindBypermission;
	private FinderPath _finderPathWithoutPaginationFindBypermission;
	private FinderPath _finderPathCountBypermission;

	/**
	 * Returns all the ecms pg relations where permission = &#63;.
	 *
	 * @param permission the permission
	 * @return the matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBypermission(int permission) {
		return findBypermission(
			permission, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms pg relations where permission = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param permission the permission
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBypermission(
		int permission, int start, int end) {

		return findBypermission(permission, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where permission = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param permission the permission
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBypermission(
		int permission, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return findBypermission(
			permission, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where permission = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param permission the permission
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findBypermission(
		int permission, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypermission;
				finderArgs = new Object[] {permission};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypermission;
			finderArgs = new Object[] {
				permission, start, end, orderByComparator
			};
		}

		List<EcmsPGRelation> list = null;

		if (useFinderCache) {
			list = (List<EcmsPGRelation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EcmsPGRelation ecmsPGRelation : list) {
					if (permission != ecmsPGRelation.getPermission()) {
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

			query.append(_SQL_SELECT_ECMSPGRELATION_WHERE);

			query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(EcmsPGRelationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permission);

				list = (List<EcmsPGRelation>)QueryUtil.list(
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
	 * Returns the first ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation findBypermission_First(
			int permission, OrderByComparator<EcmsPGRelation> orderByComparator)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = fetchBypermission_First(
			permission, orderByComparator);

		if (ecmsPGRelation != null) {
			return ecmsPGRelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permission=");
		msg.append(permission);

		msg.append("}");

		throw new NoSuchEcmsPGRelationException(msg.toString());
	}

	/**
	 * Returns the first ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation fetchBypermission_First(
		int permission, OrderByComparator<EcmsPGRelation> orderByComparator) {

		List<EcmsPGRelation> list = findBypermission(
			permission, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation findBypermission_Last(
			int permission, OrderByComparator<EcmsPGRelation> orderByComparator)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = fetchBypermission_Last(
			permission, orderByComparator);

		if (ecmsPGRelation != null) {
			return ecmsPGRelation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permission=");
		msg.append(permission);

		msg.append("}");

		throw new NoSuchEcmsPGRelationException(msg.toString());
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation fetchBypermission_Last(
		int permission, OrderByComparator<EcmsPGRelation> orderByComparator) {

		int count = countBypermission(permission);

		if (count == 0) {
			return null;
		}

		List<EcmsPGRelation> list = findBypermission(
			permission, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ecms pg relations before and after the current ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param ecmsPGRelationPK the primary key of the current ecms pg relation
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation[] findBypermission_PrevAndNext(
			EcmsPGRelationPK ecmsPGRelationPK, int permission,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = findByPrimaryKey(ecmsPGRelationPK);

		Session session = null;

		try {
			session = openSession();

			EcmsPGRelation[] array = new EcmsPGRelationImpl[3];

			array[0] = getBypermission_PrevAndNext(
				session, ecmsPGRelation, permission, orderByComparator, true);

			array[1] = ecmsPGRelation;

			array[2] = getBypermission_PrevAndNext(
				session, ecmsPGRelation, permission, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EcmsPGRelation getBypermission_PrevAndNext(
		Session session, EcmsPGRelation ecmsPGRelation, int permission,
		OrderByComparator<EcmsPGRelation> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ECMSPGRELATION_WHERE);

		query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_2);

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
			query.append(EcmsPGRelationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(permission);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ecmsPGRelation)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<EcmsPGRelation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ecms pg relations where permission = &#63; from the database.
	 *
	 * @param permission the permission
	 */
	@Override
	public void removeBypermission(int permission) {
		for (EcmsPGRelation ecmsPGRelation :
				findBypermission(
					permission, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ecmsPGRelation);
		}
	}

	/**
	 * Returns the number of ecms pg relations where permission = &#63;.
	 *
	 * @param permission the permission
	 * @return the number of matching ecms pg relations
	 */
	@Override
	public int countBypermission(int permission) {
		FinderPath finderPath = _finderPathCountBypermission;

		Object[] finderArgs = new Object[] {permission};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ECMSPGRELATION_WHERE);

			query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permission);

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

	private static final String _FINDER_COLUMN_PERMISSION_PERMISSION_2 =
		"ecmsPGRelation.id.permission = ?";

	private FinderPath _finderPathFetchByG_P;
	private FinderPath _finderPathCountByG_P;

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or throws a <code>NoSuchEcmsPGRelationException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation findByG_P(long groupUserId, int permission)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = fetchByG_P(groupUserId, permission);

		if (ecmsPGRelation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupUserId=");
			msg.append(groupUserId);

			msg.append(", permission=");
			msg.append(permission);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEcmsPGRelationException(msg.toString());
		}

		return ecmsPGRelation;
	}

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation fetchByG_P(long groupUserId, int permission) {
		return fetchByG_P(groupUserId, permission, true);
	}

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	@Override
	public EcmsPGRelation fetchByG_P(
		long groupUserId, int permission, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupUserId, permission};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_P, finderArgs, this);
		}

		if (result instanceof EcmsPGRelation) {
			EcmsPGRelation ecmsPGRelation = (EcmsPGRelation)result;

			if ((groupUserId != ecmsPGRelation.getGroupUserId()) ||
				(permission != ecmsPGRelation.getPermission())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ECMSPGRELATION_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPUSERID_2);

			query.append(_FINDER_COLUMN_G_P_PERMISSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				qPos.add(permission);

				List<EcmsPGRelation> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_P, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupUserId, permission
								};
							}

							_log.warn(
								"EcmsPGRelationPersistenceImpl.fetchByG_P(long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EcmsPGRelation ecmsPGRelation = list.get(0);

					result = ecmsPGRelation;

					cacheResult(ecmsPGRelation);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_P, finderArgs);
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
			return (EcmsPGRelation)result;
		}
	}

	/**
	 * Removes the ecms pg relation where groupUserId = &#63; and permission = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the ecms pg relation that was removed
	 */
	@Override
	public EcmsPGRelation removeByG_P(long groupUserId, int permission)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = findByG_P(groupUserId, permission);

		return remove(ecmsPGRelation);
	}

	/**
	 * Returns the number of ecms pg relations where groupUserId = &#63; and permission = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the number of matching ecms pg relations
	 */
	@Override
	public int countByG_P(long groupUserId, int permission) {
		FinderPath finderPath = _finderPathCountByG_P;

		Object[] finderArgs = new Object[] {groupUserId, permission};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ECMSPGRELATION_WHERE);

			query.append(_FINDER_COLUMN_G_P_GROUPUSERID_2);

			query.append(_FINDER_COLUMN_G_P_PERMISSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				qPos.add(permission);

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

	private static final String _FINDER_COLUMN_G_P_GROUPUSERID_2 =
		"ecmsPGRelation.id.groupUserId = ? AND ";

	private static final String _FINDER_COLUMN_G_P_PERMISSION_2 =
		"ecmsPGRelation.id.permission = ?";

	public EcmsPGRelationPersistenceImpl() {
		setModelClass(EcmsPGRelation.class);

		setModelImplClass(EcmsPGRelationImpl.class);
		setModelPKClass(EcmsPGRelationPK.class);
	}

	/**
	 * Caches the ecms pg relation in the entity cache if it is enabled.
	 *
	 * @param ecmsPGRelation the ecms pg relation
	 */
	@Override
	public void cacheResult(EcmsPGRelation ecmsPGRelation) {
		entityCache.putResult(
			entityCacheEnabled, EcmsPGRelationImpl.class,
			ecmsPGRelation.getPrimaryKey(), ecmsPGRelation);

		finderCache.putResult(
			_finderPathFetchByG_P,
			new Object[] {
				ecmsPGRelation.getGroupUserId(), ecmsPGRelation.getPermission()
			},
			ecmsPGRelation);

		ecmsPGRelation.resetOriginalValues();
	}

	/**
	 * Caches the ecms pg relations in the entity cache if it is enabled.
	 *
	 * @param ecmsPGRelations the ecms pg relations
	 */
	@Override
	public void cacheResult(List<EcmsPGRelation> ecmsPGRelations) {
		for (EcmsPGRelation ecmsPGRelation : ecmsPGRelations) {
			if (entityCache.getResult(
					entityCacheEnabled, EcmsPGRelationImpl.class,
					ecmsPGRelation.getPrimaryKey()) == null) {

				cacheResult(ecmsPGRelation);
			}
			else {
				ecmsPGRelation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ecms pg relations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EcmsPGRelationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ecms pg relation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EcmsPGRelation ecmsPGRelation) {
		entityCache.removeResult(
			entityCacheEnabled, EcmsPGRelationImpl.class,
			ecmsPGRelation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EcmsPGRelationModelImpl)ecmsPGRelation, true);
	}

	@Override
	public void clearCache(List<EcmsPGRelation> ecmsPGRelations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EcmsPGRelation ecmsPGRelation : ecmsPGRelations) {
			entityCache.removeResult(
				entityCacheEnabled, EcmsPGRelationImpl.class,
				ecmsPGRelation.getPrimaryKey());

			clearUniqueFindersCache(
				(EcmsPGRelationModelImpl)ecmsPGRelation, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, EcmsPGRelationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EcmsPGRelationModelImpl ecmsPGRelationModelImpl) {

		Object[] args = new Object[] {
			ecmsPGRelationModelImpl.getGroupUserId(),
			ecmsPGRelationModelImpl.getPermission()
		};

		finderCache.putResult(
			_finderPathCountByG_P, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_P, args, ecmsPGRelationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EcmsPGRelationModelImpl ecmsPGRelationModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				ecmsPGRelationModelImpl.getGroupUserId(),
				ecmsPGRelationModelImpl.getPermission()
			};

			finderCache.removeResult(_finderPathCountByG_P, args);
			finderCache.removeResult(_finderPathFetchByG_P, args);
		}

		if ((ecmsPGRelationModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_P.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ecmsPGRelationModelImpl.getOriginalGroupUserId(),
				ecmsPGRelationModelImpl.getOriginalPermission()
			};

			finderCache.removeResult(_finderPathCountByG_P, args);
			finderCache.removeResult(_finderPathFetchByG_P, args);
		}
	}

	/**
	 * Creates a new ecms pg relation with the primary key. Does not add the ecms pg relation to the database.
	 *
	 * @param ecmsPGRelationPK the primary key for the new ecms pg relation
	 * @return the new ecms pg relation
	 */
	@Override
	public EcmsPGRelation create(EcmsPGRelationPK ecmsPGRelationPK) {
		EcmsPGRelation ecmsPGRelation = new EcmsPGRelationImpl();

		ecmsPGRelation.setNew(true);
		ecmsPGRelation.setPrimaryKey(ecmsPGRelationPK);

		return ecmsPGRelation;
	}

	/**
	 * Removes the ecms pg relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation that was removed
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation remove(EcmsPGRelationPK ecmsPGRelationPK)
		throws NoSuchEcmsPGRelationException {

		return remove((Serializable)ecmsPGRelationPK);
	}

	/**
	 * Removes the ecms pg relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ecms pg relation
	 * @return the ecms pg relation that was removed
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation remove(Serializable primaryKey)
		throws NoSuchEcmsPGRelationException {

		Session session = null;

		try {
			session = openSession();

			EcmsPGRelation ecmsPGRelation = (EcmsPGRelation)session.get(
				EcmsPGRelationImpl.class, primaryKey);

			if (ecmsPGRelation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEcmsPGRelationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ecmsPGRelation);
		}
		catch (NoSuchEcmsPGRelationException noSuchEntityException) {
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
	protected EcmsPGRelation removeImpl(EcmsPGRelation ecmsPGRelation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ecmsPGRelation)) {
				ecmsPGRelation = (EcmsPGRelation)session.get(
					EcmsPGRelationImpl.class,
					ecmsPGRelation.getPrimaryKeyObj());
			}

			if (ecmsPGRelation != null) {
				session.delete(ecmsPGRelation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ecmsPGRelation != null) {
			clearCache(ecmsPGRelation);
		}

		return ecmsPGRelation;
	}

	@Override
	public EcmsPGRelation updateImpl(EcmsPGRelation ecmsPGRelation) {
		boolean isNew = ecmsPGRelation.isNew();

		if (!(ecmsPGRelation instanceof EcmsPGRelationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ecmsPGRelation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ecmsPGRelation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ecmsPGRelation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EcmsPGRelation implementation " +
					ecmsPGRelation.getClass());
		}

		EcmsPGRelationModelImpl ecmsPGRelationModelImpl =
			(EcmsPGRelationModelImpl)ecmsPGRelation;

		Session session = null;

		try {
			session = openSession();

			if (ecmsPGRelation.isNew()) {
				session.save(ecmsPGRelation);

				ecmsPGRelation.setNew(false);
			}
			else {
				ecmsPGRelation = (EcmsPGRelation)session.merge(ecmsPGRelation);
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
				ecmsPGRelationModelImpl.getGroupUserId()
			};

			finderCache.removeResult(_finderPathCountBygroupUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBygroupUserId, args);

			args = new Object[] {ecmsPGRelationModelImpl.getPermission()};

			finderCache.removeResult(_finderPathCountBypermission, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBypermission, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ecmsPGRelationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBygroupUserId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ecmsPGRelationModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountBygroupUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBygroupUserId, args);

				args = new Object[] {ecmsPGRelationModelImpl.getGroupUserId()};

				finderCache.removeResult(_finderPathCountBygroupUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBygroupUserId, args);
			}

			if ((ecmsPGRelationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBypermission.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ecmsPGRelationModelImpl.getOriginalPermission()
				};

				finderCache.removeResult(_finderPathCountBypermission, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypermission, args);

				args = new Object[] {ecmsPGRelationModelImpl.getPermission()};

				finderCache.removeResult(_finderPathCountBypermission, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypermission, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, EcmsPGRelationImpl.class,
			ecmsPGRelation.getPrimaryKey(), ecmsPGRelation, false);

		clearUniqueFindersCache(ecmsPGRelationModelImpl, false);
		cacheUniqueFindersCache(ecmsPGRelationModelImpl);

		ecmsPGRelation.resetOriginalValues();

		return ecmsPGRelation;
	}

	/**
	 * Returns the ecms pg relation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ecms pg relation
	 * @return the ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEcmsPGRelationException {

		EcmsPGRelation ecmsPGRelation = fetchByPrimaryKey(primaryKey);

		if (ecmsPGRelation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEcmsPGRelationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ecmsPGRelation;
	}

	/**
	 * Returns the ecms pg relation with the primary key or throws a <code>NoSuchEcmsPGRelationException</code> if it could not be found.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation findByPrimaryKey(EcmsPGRelationPK ecmsPGRelationPK)
		throws NoSuchEcmsPGRelationException {

		return findByPrimaryKey((Serializable)ecmsPGRelationPK);
	}

	/**
	 * Returns the ecms pg relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation, or <code>null</code> if a ecms pg relation with the primary key could not be found
	 */
	@Override
	public EcmsPGRelation fetchByPrimaryKey(EcmsPGRelationPK ecmsPGRelationPK) {
		return fetchByPrimaryKey((Serializable)ecmsPGRelationPK);
	}

	/**
	 * Returns all the ecms pg relations.
	 *
	 * @return the ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findAll(
		int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ecms pg relations
	 */
	@Override
	public List<EcmsPGRelation> findAll(
		int start, int end, OrderByComparator<EcmsPGRelation> orderByComparator,
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

		List<EcmsPGRelation> list = null;

		if (useFinderCache) {
			list = (List<EcmsPGRelation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ECMSPGRELATION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ECMSPGRELATION;

				sql = sql.concat(EcmsPGRelationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<EcmsPGRelation>)QueryUtil.list(
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
	 * Removes all the ecms pg relations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EcmsPGRelation ecmsPGRelation : findAll()) {
			remove(ecmsPGRelation);
		}
	}

	/**
	 * Returns the number of ecms pg relations.
	 *
	 * @return the number of ecms pg relations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ECMSPGRELATION);

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
		return "ecmsPGRelationPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ECMSPGRELATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EcmsPGRelationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ecms pg relation persistence.
	 */
	@Activate
	public void activate() {
		EcmsPGRelationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		EcmsPGRelationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupUserId",
			new String[] {Long.class.getName()},
			EcmsPGRelationModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBypermission = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypermission",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBypermission = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypermission",
			new String[] {Integer.class.getName()},
			EcmsPGRelationModelImpl.PERMISSION_COLUMN_BITMASK);

		_finderPathCountBypermission = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypermission",
			new String[] {Integer.class.getName()});

		_finderPathFetchByG_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsPGRelationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_P",
			new String[] {Long.class.getName(), Integer.class.getName()},
			EcmsPGRelationModelImpl.GROUPUSERID_COLUMN_BITMASK |
			EcmsPGRelationModelImpl.PERMISSION_COLUMN_BITMASK);

		_finderPathCountByG_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_P",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EcmsPGRelationImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.EcmsPGRelation"),
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

	private static final String _SQL_SELECT_ECMSPGRELATION =
		"SELECT ecmsPGRelation FROM EcmsPGRelation ecmsPGRelation";

	private static final String _SQL_SELECT_ECMSPGRELATION_WHERE =
		"SELECT ecmsPGRelation FROM EcmsPGRelation ecmsPGRelation WHERE ";

	private static final String _SQL_COUNT_ECMSPGRELATION =
		"SELECT COUNT(ecmsPGRelation) FROM EcmsPGRelation ecmsPGRelation";

	private static final String _SQL_COUNT_ECMSPGRELATION_WHERE =
		"SELECT COUNT(ecmsPGRelation) FROM EcmsPGRelation ecmsPGRelation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ecmsPGRelation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EcmsPGRelation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EcmsPGRelation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EcmsPGRelationPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "permission"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}