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

import com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException;
import com.ecoit.elegaldocument.model.LegalDDRel;
import com.ecoit.elegaldocument.model.impl.LegalDDRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalDDRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDDRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalDDRelPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the legal dd rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDDRelPersistence.class)
public class LegalDDRelPersistenceImpl
	extends BasePersistenceImpl<LegalDDRel> implements LegalDDRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDDRelUtil</code> to access the legal dd rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDDRelImpl.class.getName();

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
	 * Returns all the legal dd rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDepartament(long departmentId) {
		return findByDepartament(
			departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end) {

		return findByDepartament(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator) {

		return findByDepartament(
			departmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator,
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

		List<LegalDDRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDDRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDDRel legalDDRel : list) {
					if (departmentId != legalDDRel.getDepartmentId()) {
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

			query.append(_SQL_SELECT_LEGALDDREL_WHERE);

			query.append(_FINDER_COLUMN_DEPARTAMENT_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDDRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				list = (List<LegalDDRel>)QueryUtil.list(
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
	 * Returns the first legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel findByDepartament_First(
			long departmentId, OrderByComparator<LegalDDRel> orderByComparator)
		throws NoSuchLegalDDRelException {

		LegalDDRel legalDDRel = fetchByDepartament_First(
			departmentId, orderByComparator);

		if (legalDDRel != null) {
			return legalDDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append("}");

		throw new NoSuchLegalDDRelException(msg.toString());
	}

	/**
	 * Returns the first legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel fetchByDepartament_First(
		long departmentId, OrderByComparator<LegalDDRel> orderByComparator) {

		List<LegalDDRel> list = findByDepartament(
			departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel findByDepartament_Last(
			long departmentId, OrderByComparator<LegalDDRel> orderByComparator)
		throws NoSuchLegalDDRelException {

		LegalDDRel legalDDRel = fetchByDepartament_Last(
			departmentId, orderByComparator);

		if (legalDDRel != null) {
			return legalDDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append("}");

		throw new NoSuchLegalDDRelException(msg.toString());
	}

	/**
	 * Returns the last legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel fetchByDepartament_Last(
		long departmentId, OrderByComparator<LegalDDRel> orderByComparator) {

		int count = countByDepartament(departmentId);

		if (count == 0) {
			return null;
		}

		List<LegalDDRel> list = findByDepartament(
			departmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal dd rels before and after the current legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param legalDDRelPK the primary key of the current legal dd rel
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel[] findByDepartament_PrevAndNext(
			LegalDDRelPK legalDDRelPK, long departmentId,
			OrderByComparator<LegalDDRel> orderByComparator)
		throws NoSuchLegalDDRelException {

		LegalDDRel legalDDRel = findByPrimaryKey(legalDDRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDDRel[] array = new LegalDDRelImpl[3];

			array[0] = getByDepartament_PrevAndNext(
				session, legalDDRel, departmentId, orderByComparator, true);

			array[1] = legalDDRel;

			array[2] = getByDepartament_PrevAndNext(
				session, legalDDRel, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDDRel getByDepartament_PrevAndNext(
		Session session, LegalDDRel legalDDRel, long departmentId,
		OrderByComparator<LegalDDRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDDREL_WHERE);

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
			query.append(LegalDDRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDDRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDDRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal dd rels where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	@Override
	public void removeByDepartament(long departmentId) {
		for (LegalDDRel legalDDRel :
				findByDepartament(
					departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDDRel);
		}
	}

	/**
	 * Returns the number of legal dd rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching legal dd rels
	 */
	@Override
	public int countByDepartament(long departmentId) {
		FinderPath finderPath = _finderPathCountByDepartament;

		Object[] finderArgs = new Object[] {departmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDDREL_WHERE);

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
		"legalDDRel.id.departmentId = ?";

	private FinderPath _finderPathWithPaginationFindByDoc;
	private FinderPath _finderPathWithoutPaginationFindByDoc;
	private FinderPath _finderPathCountByDoc;

	/**
	 * Returns all the legal dd rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDoc(String docId) {
		return findByDoc(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDoc(String docId, int start, int end) {
		return findByDoc(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDoc(
		String docId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator) {

		return findByDoc(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal dd rels
	 */
	@Override
	public List<LegalDDRel> findByDoc(
		String docId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator,
		boolean useFinderCache) {

		docId = Objects.toString(docId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDoc;
				finderArgs = new Object[] {docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDoc;
			finderArgs = new Object[] {docId, start, end, orderByComparator};
		}

		List<LegalDDRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDDRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDDRel legalDDRel : list) {
					if (!docId.equals(legalDDRel.getDocId())) {
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

			query.append(_SQL_SELECT_LEGALDDREL_WHERE);

			boolean bindDocId = false;

			if (docId.isEmpty()) {
				query.append(_FINDER_COLUMN_DOC_DOCID_3);
			}
			else {
				bindDocId = true;

				query.append(_FINDER_COLUMN_DOC_DOCID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDDRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocId) {
					qPos.add(docId);
				}

				list = (List<LegalDDRel>)QueryUtil.list(
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
	 * Returns the first legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel findByDoc_First(
			String docId, OrderByComparator<LegalDDRel> orderByComparator)
		throws NoSuchLegalDDRelException {

		LegalDDRel legalDDRel = fetchByDoc_First(docId, orderByComparator);

		if (legalDDRel != null) {
			return legalDDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDDRelException(msg.toString());
	}

	/**
	 * Returns the first legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel fetchByDoc_First(
		String docId, OrderByComparator<LegalDDRel> orderByComparator) {

		List<LegalDDRel> list = findByDoc(docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel findByDoc_Last(
			String docId, OrderByComparator<LegalDDRel> orderByComparator)
		throws NoSuchLegalDDRelException {

		LegalDDRel legalDDRel = fetchByDoc_Last(docId, orderByComparator);

		if (legalDDRel != null) {
			return legalDDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDDRelException(msg.toString());
	}

	/**
	 * Returns the last legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	@Override
	public LegalDDRel fetchByDoc_Last(
		String docId, OrderByComparator<LegalDDRel> orderByComparator) {

		int count = countByDoc(docId);

		if (count == 0) {
			return null;
		}

		List<LegalDDRel> list = findByDoc(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal dd rels before and after the current legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDDRelPK the primary key of the current legal dd rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel[] findByDoc_PrevAndNext(
			LegalDDRelPK legalDDRelPK, String docId,
			OrderByComparator<LegalDDRel> orderByComparator)
		throws NoSuchLegalDDRelException {

		docId = Objects.toString(docId, "");

		LegalDDRel legalDDRel = findByPrimaryKey(legalDDRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDDRel[] array = new LegalDDRelImpl[3];

			array[0] = getByDoc_PrevAndNext(
				session, legalDDRel, docId, orderByComparator, true);

			array[1] = legalDDRel;

			array[2] = getByDoc_PrevAndNext(
				session, legalDDRel, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDDRel getByDoc_PrevAndNext(
		Session session, LegalDDRel legalDDRel, String docId,
		OrderByComparator<LegalDDRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDDREL_WHERE);

		boolean bindDocId = false;

		if (docId.isEmpty()) {
			query.append(_FINDER_COLUMN_DOC_DOCID_3);
		}
		else {
			bindDocId = true;

			query.append(_FINDER_COLUMN_DOC_DOCID_2);
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
			query.append(LegalDDRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDocId) {
			qPos.add(docId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDDRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDDRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal dd rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeByDoc(String docId) {
		for (LegalDDRel legalDDRel :
				findByDoc(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDDRel);
		}
	}

	/**
	 * Returns the number of legal dd rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal dd rels
	 */
	@Override
	public int countByDoc(String docId) {
		docId = Objects.toString(docId, "");

		FinderPath finderPath = _finderPathCountByDoc;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDDREL_WHERE);

			boolean bindDocId = false;

			if (docId.isEmpty()) {
				query.append(_FINDER_COLUMN_DOC_DOCID_3);
			}
			else {
				bindDocId = true;

				query.append(_FINDER_COLUMN_DOC_DOCID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocId) {
					qPos.add(docId);
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

	private static final String _FINDER_COLUMN_DOC_DOCID_2 =
		"legalDDRel.id.docId = ?";

	private static final String _FINDER_COLUMN_DOC_DOCID_3 =
		"(legalDDRel.id.docId IS NULL OR legalDDRel.id.docId = '')";

	public LegalDDRelPersistenceImpl() {
		setModelClass(LegalDDRel.class);

		setModelImplClass(LegalDDRelImpl.class);
		setModelPKClass(LegalDDRelPK.class);
	}

	/**
	 * Caches the legal dd rel in the entity cache if it is enabled.
	 *
	 * @param legalDDRel the legal dd rel
	 */
	@Override
	public void cacheResult(LegalDDRel legalDDRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalDDRelImpl.class,
			legalDDRel.getPrimaryKey(), legalDDRel);

		legalDDRel.resetOriginalValues();
	}

	/**
	 * Caches the legal dd rels in the entity cache if it is enabled.
	 *
	 * @param legalDDRels the legal dd rels
	 */
	@Override
	public void cacheResult(List<LegalDDRel> legalDDRels) {
		for (LegalDDRel legalDDRel : legalDDRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDDRelImpl.class,
					legalDDRel.getPrimaryKey()) == null) {

				cacheResult(legalDDRel);
			}
			else {
				legalDDRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal dd rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDDRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal dd rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDDRel legalDDRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDDRelImpl.class,
			legalDDRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalDDRel> legalDDRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDDRel legalDDRel : legalDDRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDDRelImpl.class,
				legalDDRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDDRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal dd rel with the primary key. Does not add the legal dd rel to the database.
	 *
	 * @param legalDDRelPK the primary key for the new legal dd rel
	 * @return the new legal dd rel
	 */
	@Override
	public LegalDDRel create(LegalDDRelPK legalDDRelPK) {
		LegalDDRel legalDDRel = new LegalDDRelImpl();

		legalDDRel.setNew(true);
		legalDDRel.setPrimaryKey(legalDDRelPK);

		return legalDDRel;
	}

	/**
	 * Removes the legal dd rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel that was removed
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel remove(LegalDDRelPK legalDDRelPK)
		throws NoSuchLegalDDRelException {

		return remove((Serializable)legalDDRelPK);
	}

	/**
	 * Removes the legal dd rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal dd rel
	 * @return the legal dd rel that was removed
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel remove(Serializable primaryKey)
		throws NoSuchLegalDDRelException {

		Session session = null;

		try {
			session = openSession();

			LegalDDRel legalDDRel = (LegalDDRel)session.get(
				LegalDDRelImpl.class, primaryKey);

			if (legalDDRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDDRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDDRel);
		}
		catch (NoSuchLegalDDRelException noSuchEntityException) {
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
	protected LegalDDRel removeImpl(LegalDDRel legalDDRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDDRel)) {
				legalDDRel = (LegalDDRel)session.get(
					LegalDDRelImpl.class, legalDDRel.getPrimaryKeyObj());
			}

			if (legalDDRel != null) {
				session.delete(legalDDRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDDRel != null) {
			clearCache(legalDDRel);
		}

		return legalDDRel;
	}

	@Override
	public LegalDDRel updateImpl(LegalDDRel legalDDRel) {
		boolean isNew = legalDDRel.isNew();

		if (!(legalDDRel instanceof LegalDDRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDDRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalDDRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDDRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDDRel implementation " +
					legalDDRel.getClass());
		}

		LegalDDRelModelImpl legalDDRelModelImpl =
			(LegalDDRelModelImpl)legalDDRel;

		Session session = null;

		try {
			session = openSession();

			if (legalDDRel.isNew()) {
				session.save(legalDDRel);

				legalDDRel.setNew(false);
			}
			else {
				legalDDRel = (LegalDDRel)session.merge(legalDDRel);
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
				legalDDRelModelImpl.getDepartmentId()
			};

			finderCache.removeResult(_finderPathCountByDepartament, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDepartament, args);

			args = new Object[] {legalDDRelModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountByDoc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDoc, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDDRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDepartament.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDDRelModelImpl.getOriginalDepartmentId()
				};

				finderCache.removeResult(_finderPathCountByDepartament, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDepartament, args);

				args = new Object[] {legalDDRelModelImpl.getDepartmentId()};

				finderCache.removeResult(_finderPathCountByDepartament, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDepartament, args);
			}

			if ((legalDDRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDoc.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDDRelModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc, args);

				args = new Object[] {legalDDRelModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountByDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDDRelImpl.class,
			legalDDRel.getPrimaryKey(), legalDDRel, false);

		legalDDRel.resetOriginalValues();

		return legalDDRel;
	}

	/**
	 * Returns the legal dd rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal dd rel
	 * @return the legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDDRelException {

		LegalDDRel legalDDRel = fetchByPrimaryKey(primaryKey);

		if (legalDDRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDDRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDDRel;
	}

	/**
	 * Returns the legal dd rel with the primary key or throws a <code>NoSuchLegalDDRelException</code> if it could not be found.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel findByPrimaryKey(LegalDDRelPK legalDDRelPK)
		throws NoSuchLegalDDRelException {

		return findByPrimaryKey((Serializable)legalDDRelPK);
	}

	/**
	 * Returns the legal dd rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel, or <code>null</code> if a legal dd rel with the primary key could not be found
	 */
	@Override
	public LegalDDRel fetchByPrimaryKey(LegalDDRelPK legalDDRelPK) {
		return fetchByPrimaryKey((Serializable)legalDDRelPK);
	}

	/**
	 * Returns all the legal dd rels.
	 *
	 * @return the legal dd rels
	 */
	@Override
	public List<LegalDDRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of legal dd rels
	 */
	@Override
	public List<LegalDDRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal dd rels
	 */
	@Override
	public List<LegalDDRel> findAll(
		int start, int end, OrderByComparator<LegalDDRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal dd rels
	 */
	@Override
	public List<LegalDDRel> findAll(
		int start, int end, OrderByComparator<LegalDDRel> orderByComparator,
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

		List<LegalDDRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDDRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDDREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDDREL;

				sql = sql.concat(LegalDDRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDDRel>)QueryUtil.list(
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
	 * Removes all the legal dd rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDDRel legalDDRel : findAll()) {
			remove(legalDDRel);
		}
	}

	/**
	 * Returns the number of legal dd rels.
	 *
	 * @return the number of legal dd rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDDREL);

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
		return "legalDDRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDDREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDDRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal dd rel persistence.
	 */
	@Activate
	public void activate() {
		LegalDDRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDDRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDepartament = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartament",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDepartament = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartament",
			new String[] {Long.class.getName()},
			LegalDDRelModelImpl.DEPARTMENTID_COLUMN_BITMASK);

		_finderPathCountByDepartament = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartament",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoc",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoc",
			new String[] {String.class.getName()},
			LegalDDRelModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoc",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDDRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDDRel"),
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

	private static final String _SQL_SELECT_LEGALDDREL =
		"SELECT legalDDRel FROM LegalDDRel legalDDRel";

	private static final String _SQL_SELECT_LEGALDDREL_WHERE =
		"SELECT legalDDRel FROM LegalDDRel legalDDRel WHERE ";

	private static final String _SQL_COUNT_LEGALDDREL =
		"SELECT COUNT(legalDDRel) FROM LegalDDRel legalDDRel";

	private static final String _SQL_COUNT_LEGALDDREL_WHERE =
		"SELECT COUNT(legalDDRel) FROM LegalDDRel legalDDRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDDRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDDRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDDRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDDRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"departmentId", "docId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}