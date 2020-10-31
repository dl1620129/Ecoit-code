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

import com.ecoit.elegaldocument.exception.NoSuchLegalDURelException;
import com.ecoit.elegaldocument.model.LegalDURel;
import com.ecoit.elegaldocument.model.impl.LegalDURelImpl;
import com.ecoit.elegaldocument.model.impl.LegalDURelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDURelPK;
import com.ecoit.elegaldocument.service.persistence.LegalDURelPersistence;
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
 * The persistence implementation for the legal du rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDURelPersistence.class)
public class LegalDURelPersistenceImpl
	extends BasePersistenceImpl<LegalDURel> implements LegalDURelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDURelUtil</code> to access the legal du rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDURelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDepartament;
	private FinderPath _finderPathWithoutPaginationFindByDepartament;
	private FinderPath _finderPathCountByDepartament;

	/**
	 * Returns all the legal du rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByDepartament(long departmentId) {
		return findByDepartament(
			departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByDepartament(
		long departmentId, int start, int end) {

		return findByDepartament(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator) {

		return findByDepartament(
			departmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDepartament;
				finderArgs = new Object[] {departmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDepartament;
			finderArgs = new Object[] {
				departmentId, start, end, orderByComparator
			};
		}

		List<LegalDURel> list = null;

		if (useFinderCache) {
			list = (List<LegalDURel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDURel legalDURel : list) {
					if (departmentId != legalDURel.getDepartmentId()) {
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

			query.append(_SQL_SELECT_LEGALDUREL_WHERE);

			query.append(_FINDER_COLUMN_DEPARTAMENT_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDURelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				list = (List<LegalDURel>)QueryUtil.list(
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
	 * Returns the first legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel findByDepartament_First(
			long departmentId, OrderByComparator<LegalDURel> orderByComparator)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = fetchByDepartament_First(
			departmentId, orderByComparator);

		if (legalDURel != null) {
			return legalDURel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append("}");

		throw new NoSuchLegalDURelException(msg.toString());
	}

	/**
	 * Returns the first legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel fetchByDepartament_First(
		long departmentId, OrderByComparator<LegalDURel> orderByComparator) {

		List<LegalDURel> list = findByDepartament(
			departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel findByDepartament_Last(
			long departmentId, OrderByComparator<LegalDURel> orderByComparator)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = fetchByDepartament_Last(
			departmentId, orderByComparator);

		if (legalDURel != null) {
			return legalDURel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append("}");

		throw new NoSuchLegalDURelException(msg.toString());
	}

	/**
	 * Returns the last legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel fetchByDepartament_Last(
		long departmentId, OrderByComparator<LegalDURel> orderByComparator) {

		int count = countByDepartament(departmentId);

		if (count == 0) {
			return null;
		}

		List<LegalDURel> list = findByDepartament(
			departmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal du rels before and after the current legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param legalDURelPK the primary key of the current legal du rel
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel[] findByDepartament_PrevAndNext(
			LegalDURelPK legalDURelPK, long departmentId,
			OrderByComparator<LegalDURel> orderByComparator)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = findByPrimaryKey(legalDURelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDURel[] array = new LegalDURelImpl[3];

			array[0] = getByDepartament_PrevAndNext(
				session, legalDURel, departmentId, orderByComparator, true);

			array[1] = legalDURel;

			array[2] = getByDepartament_PrevAndNext(
				session, legalDURel, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDURel getByDepartament_PrevAndNext(
		Session session, LegalDURel legalDURel, long departmentId,
		OrderByComparator<LegalDURel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDUREL_WHERE);

		query.append(_FINDER_COLUMN_DEPARTAMENT_DEPARTMENTID_2);

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
			query.append(LegalDURelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDURel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDURel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal du rels where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	@Override
	public void removeByDepartament(long departmentId) {
		for (LegalDURel legalDURel :
				findByDepartament(
					departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDURel);
		}
	}

	/**
	 * Returns the number of legal du rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching legal du rels
	 */
	@Override
	public int countByDepartament(long departmentId) {
		FinderPath finderPath = _finderPathCountByDepartament;

		Object[] finderArgs = new Object[] {departmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDUREL_WHERE);

			query.append(_FINDER_COLUMN_DEPARTAMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_DEPARTAMENT_DEPARTMENTID_2 =
		"legalDURel.id.departmentId = ?";

	private FinderPath _finderPathWithPaginationFindByUser;
	private FinderPath _finderPathWithoutPaginationFindByUser;
	private FinderPath _finderPathCountByUser;

	/**
	 * Returns all the legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByUser(long userid) {
		return findByUser(userid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByUser(long userid, int start, int end) {
		return findByUser(userid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByUser(
		long userid, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator) {

		return findByUser(userid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal du rels
	 */
	@Override
	public List<LegalDURel> findByUser(
		long userid, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUser;
				finderArgs = new Object[] {userid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUser;
			finderArgs = new Object[] {userid, start, end, orderByComparator};
		}

		List<LegalDURel> list = null;

		if (useFinderCache) {
			list = (List<LegalDURel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDURel legalDURel : list) {
					if (userid != legalDURel.getUserid()) {
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

			query.append(_SQL_SELECT_LEGALDUREL_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDURelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userid);

				list = (List<LegalDURel>)QueryUtil.list(
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
	 * Returns the first legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel findByUser_First(
			long userid, OrderByComparator<LegalDURel> orderByComparator)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = fetchByUser_First(userid, orderByComparator);

		if (legalDURel != null) {
			return legalDURel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userid=");
		msg.append(userid);

		msg.append("}");

		throw new NoSuchLegalDURelException(msg.toString());
	}

	/**
	 * Returns the first legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel fetchByUser_First(
		long userid, OrderByComparator<LegalDURel> orderByComparator) {

		List<LegalDURel> list = findByUser(userid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel findByUser_Last(
			long userid, OrderByComparator<LegalDURel> orderByComparator)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = fetchByUser_Last(userid, orderByComparator);

		if (legalDURel != null) {
			return legalDURel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userid=");
		msg.append(userid);

		msg.append("}");

		throw new NoSuchLegalDURelException(msg.toString());
	}

	/**
	 * Returns the last legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel fetchByUser_Last(
		long userid, OrderByComparator<LegalDURel> orderByComparator) {

		int count = countByUser(userid);

		if (count == 0) {
			return null;
		}

		List<LegalDURel> list = findByUser(
			userid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal du rels before and after the current legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param legalDURelPK the primary key of the current legal du rel
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel[] findByUser_PrevAndNext(
			LegalDURelPK legalDURelPK, long userid,
			OrderByComparator<LegalDURel> orderByComparator)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = findByPrimaryKey(legalDURelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDURel[] array = new LegalDURelImpl[3];

			array[0] = getByUser_PrevAndNext(
				session, legalDURel, userid, orderByComparator, true);

			array[1] = legalDURel;

			array[2] = getByUser_PrevAndNext(
				session, legalDURel, userid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDURel getByUser_PrevAndNext(
		Session session, LegalDURel legalDURel, long userid,
		OrderByComparator<LegalDURel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDUREL_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(LegalDURelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDURel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDURel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal du rels where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 */
	@Override
	public void removeByUser(long userid) {
		for (LegalDURel legalDURel :
				findByUser(
					userid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDURel);
		}
	}

	/**
	 * Returns the number of legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching legal du rels
	 */
	@Override
	public int countByUser(long userid) {
		FinderPath finderPath = _finderPathCountByUser;

		Object[] finderArgs = new Object[] {userid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDUREL_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userid);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 =
		"legalDURel.id.userid = ?";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the legal du rel where userid = &#63; or throws a <code>NoSuchLegalDURelException</code> if it could not be found.
	 *
	 * @param userid the userid
	 * @return the matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel findByUserId(long userid)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = fetchByUserId(userid);

		if (legalDURel == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userid=");
			msg.append(userid);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDURelException(msg.toString());
		}

		return legalDURel;
	}

	/**
	 * Returns the legal du rel where userid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userid the userid
	 * @return the matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel fetchByUserId(long userid) {
		return fetchByUserId(userid, true);
	}

	/**
	 * Returns the legal du rel where userid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userid the userid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	@Override
	public LegalDURel fetchByUserId(long userid, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userid};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs, this);
		}

		if (result instanceof LegalDURel) {
			LegalDURel legalDURel = (LegalDURel)result;

			if (userid != legalDURel.getUserid()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALDUREL_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userid);

				List<LegalDURel> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userid};
							}

							_log.warn(
								"LegalDURelPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDURel legalDURel = list.get(0);

					result = legalDURel;

					cacheResult(legalDURel);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUserId, finderArgs);
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
			return (LegalDURel)result;
		}
	}

	/**
	 * Removes the legal du rel where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 * @return the legal du rel that was removed
	 */
	@Override
	public LegalDURel removeByUserId(long userid)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = findByUserId(userid);

		return remove(legalDURel);
	}

	/**
	 * Returns the number of legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching legal du rels
	 */
	@Override
	public int countByUserId(long userid) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDUREL_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userid);

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
		"legalDURel.id.userid = ?";

	public LegalDURelPersistenceImpl() {
		setModelClass(LegalDURel.class);

		setModelImplClass(LegalDURelImpl.class);
		setModelPKClass(LegalDURelPK.class);
	}

	/**
	 * Caches the legal du rel in the entity cache if it is enabled.
	 *
	 * @param legalDURel the legal du rel
	 */
	@Override
	public void cacheResult(LegalDURel legalDURel) {
		entityCache.putResult(
			entityCacheEnabled, LegalDURelImpl.class,
			legalDURel.getPrimaryKey(), legalDURel);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {legalDURel.getUserid()},
			legalDURel);

		legalDURel.resetOriginalValues();
	}

	/**
	 * Caches the legal du rels in the entity cache if it is enabled.
	 *
	 * @param legalDURels the legal du rels
	 */
	@Override
	public void cacheResult(List<LegalDURel> legalDURels) {
		for (LegalDURel legalDURel : legalDURels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDURelImpl.class,
					legalDURel.getPrimaryKey()) == null) {

				cacheResult(legalDURel);
			}
			else {
				legalDURel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal du rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDURelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal du rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDURel legalDURel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDURelImpl.class,
			legalDURel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalDURelModelImpl)legalDURel, true);
	}

	@Override
	public void clearCache(List<LegalDURel> legalDURels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDURel legalDURel : legalDURels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDURelImpl.class,
				legalDURel.getPrimaryKey());

			clearUniqueFindersCache((LegalDURelModelImpl)legalDURel, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDURelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalDURelModelImpl legalDURelModelImpl) {

		Object[] args = new Object[] {legalDURelModelImpl.getUserid()};

		finderCache.putResult(
			_finderPathCountByUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUserId, args, legalDURelModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalDURelModelImpl legalDURelModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {legalDURelModelImpl.getUserid()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(_finderPathFetchByUserId, args);
		}

		if ((legalDURelModelImpl.getColumnBitmask() &
			 _finderPathFetchByUserId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDURelModelImpl.getOriginalUserid()
			};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(_finderPathFetchByUserId, args);
		}
	}

	/**
	 * Creates a new legal du rel with the primary key. Does not add the legal du rel to the database.
	 *
	 * @param legalDURelPK the primary key for the new legal du rel
	 * @return the new legal du rel
	 */
	@Override
	public LegalDURel create(LegalDURelPK legalDURelPK) {
		LegalDURel legalDURel = new LegalDURelImpl();

		legalDURel.setNew(true);
		legalDURel.setPrimaryKey(legalDURelPK);

		return legalDURel;
	}

	/**
	 * Removes the legal du rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel that was removed
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel remove(LegalDURelPK legalDURelPK)
		throws NoSuchLegalDURelException {

		return remove((Serializable)legalDURelPK);
	}

	/**
	 * Removes the legal du rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal du rel
	 * @return the legal du rel that was removed
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel remove(Serializable primaryKey)
		throws NoSuchLegalDURelException {

		Session session = null;

		try {
			session = openSession();

			LegalDURel legalDURel = (LegalDURel)session.get(
				LegalDURelImpl.class, primaryKey);

			if (legalDURel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDURelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDURel);
		}
		catch (NoSuchLegalDURelException noSuchEntityException) {
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
	protected LegalDURel removeImpl(LegalDURel legalDURel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDURel)) {
				legalDURel = (LegalDURel)session.get(
					LegalDURelImpl.class, legalDURel.getPrimaryKeyObj());
			}

			if (legalDURel != null) {
				session.delete(legalDURel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDURel != null) {
			clearCache(legalDURel);
		}

		return legalDURel;
	}

	@Override
	public LegalDURel updateImpl(LegalDURel legalDURel) {
		boolean isNew = legalDURel.isNew();

		if (!(legalDURel instanceof LegalDURelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDURel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalDURel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDURel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDURel implementation " +
					legalDURel.getClass());
		}

		LegalDURelModelImpl legalDURelModelImpl =
			(LegalDURelModelImpl)legalDURel;

		Session session = null;

		try {
			session = openSession();

			if (legalDURel.isNew()) {
				session.save(legalDURel);

				legalDURel.setNew(false);
			}
			else {
				legalDURel = (LegalDURel)session.merge(legalDURel);
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
				legalDURelModelImpl.getDepartmentId()
			};

			finderCache.removeResult(_finderPathCountByDepartament, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDepartament, args);

			args = new Object[] {legalDURelModelImpl.getUserid()};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUser, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDURelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDepartament.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDURelModelImpl.getOriginalDepartmentId()
				};

				finderCache.removeResult(_finderPathCountByDepartament, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDepartament, args);

				args = new Object[] {legalDURelModelImpl.getDepartmentId()};

				finderCache.removeResult(_finderPathCountByDepartament, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDepartament, args);
			}

			if ((legalDURelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUser.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDURelModelImpl.getOriginalUserid()
				};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);

				args = new Object[] {legalDURelModelImpl.getUserid()};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDURelImpl.class,
			legalDURel.getPrimaryKey(), legalDURel, false);

		clearUniqueFindersCache(legalDURelModelImpl, false);
		cacheUniqueFindersCache(legalDURelModelImpl);

		legalDURel.resetOriginalValues();

		return legalDURel;
	}

	/**
	 * Returns the legal du rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal du rel
	 * @return the legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDURelException {

		LegalDURel legalDURel = fetchByPrimaryKey(primaryKey);

		if (legalDURel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDURelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDURel;
	}

	/**
	 * Returns the legal du rel with the primary key or throws a <code>NoSuchLegalDURelException</code> if it could not be found.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel findByPrimaryKey(LegalDURelPK legalDURelPK)
		throws NoSuchLegalDURelException {

		return findByPrimaryKey((Serializable)legalDURelPK);
	}

	/**
	 * Returns the legal du rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel, or <code>null</code> if a legal du rel with the primary key could not be found
	 */
	@Override
	public LegalDURel fetchByPrimaryKey(LegalDURelPK legalDURelPK) {
		return fetchByPrimaryKey((Serializable)legalDURelPK);
	}

	/**
	 * Returns all the legal du rels.
	 *
	 * @return the legal du rels
	 */
	@Override
	public List<LegalDURel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of legal du rels
	 */
	@Override
	public List<LegalDURel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal du rels
	 */
	@Override
	public List<LegalDURel> findAll(
		int start, int end, OrderByComparator<LegalDURel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal du rels
	 */
	@Override
	public List<LegalDURel> findAll(
		int start, int end, OrderByComparator<LegalDURel> orderByComparator,
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

		List<LegalDURel> list = null;

		if (useFinderCache) {
			list = (List<LegalDURel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDUREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDUREL;

				sql = sql.concat(LegalDURelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDURel>)QueryUtil.list(
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
	 * Removes all the legal du rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDURel legalDURel : findAll()) {
			remove(legalDURel);
		}
	}

	/**
	 * Returns the number of legal du rels.
	 *
	 * @return the number of legal du rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDUREL);

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
		return "legalDURelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDUREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDURelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal du rel persistence.
	 */
	@Activate
	public void activate() {
		LegalDURelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDURelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDepartament = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartament",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDepartament = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartament",
			new String[] {Long.class.getName()},
			LegalDURelModelImpl.DEPARTMENTID_COLUMN_BITMASK);

		_finderPathCountByDepartament = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartament",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] {Long.class.getName()},
			LegalDURelModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {Long.class.getName()});

		_finderPathFetchByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDURelImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()},
			LegalDURelModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDURelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDURel"),
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

	private static final String _SQL_SELECT_LEGALDUREL =
		"SELECT legalDURel FROM LegalDURel legalDURel";

	private static final String _SQL_SELECT_LEGALDUREL_WHERE =
		"SELECT legalDURel FROM LegalDURel legalDURel WHERE ";

	private static final String _SQL_COUNT_LEGALDUREL =
		"SELECT COUNT(legalDURel) FROM LegalDURel legalDURel";

	private static final String _SQL_COUNT_LEGALDUREL_WHERE =
		"SELECT COUNT(legalDURel) FROM LegalDURel legalDURel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDURel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDURel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDURel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDURelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"departmentId", "userid"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}