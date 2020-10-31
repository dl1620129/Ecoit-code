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

import com.ecoit.elegaldocument.exception.NoSuchLegalDFRelException;
import com.ecoit.elegaldocument.model.LegalDFRel;
import com.ecoit.elegaldocument.model.impl.LegalDFRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalDFRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDFRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalDFRelPersistence;
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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the legal df rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDFRelPersistence.class)
public class LegalDFRelPersistenceImpl
	extends BasePersistenceImpl<LegalDFRel> implements LegalDFRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDFRelUtil</code> to access the legal df rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDFRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByField;
	private FinderPath _finderPathWithoutPaginationFindByField;
	private FinderPath _finderPathCountByField;

	/**
	 * Returns all the legal df rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByField(long fieldId) {
		return findByField(fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal df rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByField(long fieldId, int start, int end) {
		return findByField(fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal df rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalDFRel> orderByComparator) {

		return findByField(fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal df rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalDFRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByField;
				finderArgs = new Object[] {fieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByField;
			finderArgs = new Object[] {fieldId, start, end, orderByComparator};
		}

		List<LegalDFRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDFRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDFRel legalDFRel : list) {
					if (fieldId != legalDFRel.getFieldId()) {
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

			query.append(_SQL_SELECT_LEGALDFREL_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDFRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				list = (List<LegalDFRel>)QueryUtil.list(
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
	 * Returns the first legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel findByField_First(
			long fieldId, OrderByComparator<LegalDFRel> orderByComparator)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = fetchByField_First(fieldId, orderByComparator);

		if (legalDFRel != null) {
			return legalDFRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDFRelException(msg.toString());
	}

	/**
	 * Returns the first legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel fetchByField_First(
		long fieldId, OrderByComparator<LegalDFRel> orderByComparator) {

		List<LegalDFRel> list = findByField(fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel findByField_Last(
			long fieldId, OrderByComparator<LegalDFRel> orderByComparator)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = fetchByField_Last(fieldId, orderByComparator);

		if (legalDFRel != null) {
			return legalDFRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDFRelException(msg.toString());
	}

	/**
	 * Returns the last legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel fetchByField_Last(
		long fieldId, OrderByComparator<LegalDFRel> orderByComparator) {

		int count = countByField(fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalDFRel> list = findByField(
			fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal df rels before and after the current legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalDFRelPK the primary key of the current legal df rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel[] findByField_PrevAndNext(
			LegalDFRelPK legalDFRelPK, long fieldId,
			OrderByComparator<LegalDFRel> orderByComparator)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = findByPrimaryKey(legalDFRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDFRel[] array = new LegalDFRelImpl[3];

			array[0] = getByField_PrevAndNext(
				session, legalDFRel, fieldId, orderByComparator, true);

			array[1] = legalDFRel;

			array[2] = getByField_PrevAndNext(
				session, legalDFRel, fieldId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDFRel getByField_PrevAndNext(
		Session session, LegalDFRel legalDFRel, long fieldId,
		OrderByComparator<LegalDFRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDFREL_WHERE);

		query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

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
			query.append(LegalDFRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDFRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDFRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal df rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByField(long fieldId) {
		for (LegalDFRel legalDFRel :
				findByField(
					fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDFRel);
		}
	}

	/**
	 * Returns the number of legal df rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal df rels
	 */
	@Override
	public int countByField(long fieldId) {
		FinderPath finderPath = _finderPathCountByField;

		Object[] finderArgs = new Object[] {fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDFREL_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

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

	private static final String _FINDER_COLUMN_FIELD_FIELDID_2 =
		"legalDFRel.id.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByDocId;
	private FinderPath _finderPathWithoutPaginationFindByDocId;
	private FinderPath _finderPathCountByDocId;

	/**
	 * Returns all the legal df rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByDocId(long docId) {
		return findByDocId(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal df rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByDocId(long docId, int start, int end) {
		return findByDocId(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal df rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByDocId(
		long docId, int start, int end,
		OrderByComparator<LegalDFRel> orderByComparator) {

		return findByDocId(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal df rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal df rels
	 */
	@Override
	public List<LegalDFRel> findByDocId(
		long docId, int start, int end,
		OrderByComparator<LegalDFRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocId;
				finderArgs = new Object[] {docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocId;
			finderArgs = new Object[] {docId, start, end, orderByComparator};
		}

		List<LegalDFRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDFRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDFRel legalDFRel : list) {
					if (docId != legalDFRel.getDocId()) {
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

			query.append(_SQL_SELECT_LEGALDFREL_WHERE);

			query.append(_FINDER_COLUMN_DOCID_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDFRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				list = (List<LegalDFRel>)QueryUtil.list(
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
	 * Returns the first legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel findByDocId_First(
			long docId, OrderByComparator<LegalDFRel> orderByComparator)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = fetchByDocId_First(docId, orderByComparator);

		if (legalDFRel != null) {
			return legalDFRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDFRelException(msg.toString());
	}

	/**
	 * Returns the first legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel fetchByDocId_First(
		long docId, OrderByComparator<LegalDFRel> orderByComparator) {

		List<LegalDFRel> list = findByDocId(docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel findByDocId_Last(
			long docId, OrderByComparator<LegalDFRel> orderByComparator)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = fetchByDocId_Last(docId, orderByComparator);

		if (legalDFRel != null) {
			return legalDFRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDFRelException(msg.toString());
	}

	/**
	 * Returns the last legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	@Override
	public LegalDFRel fetchByDocId_Last(
		long docId, OrderByComparator<LegalDFRel> orderByComparator) {

		int count = countByDocId(docId);

		if (count == 0) {
			return null;
		}

		List<LegalDFRel> list = findByDocId(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal df rels before and after the current legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDFRelPK the primary key of the current legal df rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel[] findByDocId_PrevAndNext(
			LegalDFRelPK legalDFRelPK, long docId,
			OrderByComparator<LegalDFRel> orderByComparator)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = findByPrimaryKey(legalDFRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDFRel[] array = new LegalDFRelImpl[3];

			array[0] = getByDocId_PrevAndNext(
				session, legalDFRel, docId, orderByComparator, true);

			array[1] = legalDFRel;

			array[2] = getByDocId_PrevAndNext(
				session, legalDFRel, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDFRel getByDocId_PrevAndNext(
		Session session, LegalDFRel legalDFRel, long docId,
		OrderByComparator<LegalDFRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDFREL_WHERE);

		query.append(_FINDER_COLUMN_DOCID_DOCID_2);

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
			query.append(LegalDFRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDFRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDFRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal df rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeByDocId(long docId) {
		for (LegalDFRel legalDFRel :
				findByDocId(
					docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDFRel);
		}
	}

	/**
	 * Returns the number of legal df rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal df rels
	 */
	@Override
	public int countByDocId(long docId) {
		FinderPath finderPath = _finderPathCountByDocId;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDFREL_WHERE);

			query.append(_FINDER_COLUMN_DOCID_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

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

	private static final String _FINDER_COLUMN_DOCID_DOCID_2 =
		"legalDFRel.id.docId = ?";

	public LegalDFRelPersistenceImpl() {
		setModelClass(LegalDFRel.class);

		setModelImplClass(LegalDFRelImpl.class);
		setModelPKClass(LegalDFRelPK.class);
	}

	/**
	 * Caches the legal df rel in the entity cache if it is enabled.
	 *
	 * @param legalDFRel the legal df rel
	 */
	@Override
	public void cacheResult(LegalDFRel legalDFRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalDFRelImpl.class,
			legalDFRel.getPrimaryKey(), legalDFRel);

		legalDFRel.resetOriginalValues();
	}

	/**
	 * Caches the legal df rels in the entity cache if it is enabled.
	 *
	 * @param legalDFRels the legal df rels
	 */
	@Override
	public void cacheResult(List<LegalDFRel> legalDFRels) {
		for (LegalDFRel legalDFRel : legalDFRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDFRelImpl.class,
					legalDFRel.getPrimaryKey()) == null) {

				cacheResult(legalDFRel);
			}
			else {
				legalDFRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal df rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDFRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal df rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDFRel legalDFRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDFRelImpl.class,
			legalDFRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalDFRel> legalDFRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDFRel legalDFRel : legalDFRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDFRelImpl.class,
				legalDFRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDFRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal df rel with the primary key. Does not add the legal df rel to the database.
	 *
	 * @param legalDFRelPK the primary key for the new legal df rel
	 * @return the new legal df rel
	 */
	@Override
	public LegalDFRel create(LegalDFRelPK legalDFRelPK) {
		LegalDFRel legalDFRel = new LegalDFRelImpl();

		legalDFRel.setNew(true);
		legalDFRel.setPrimaryKey(legalDFRelPK);

		return legalDFRel;
	}

	/**
	 * Removes the legal df rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel that was removed
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel remove(LegalDFRelPK legalDFRelPK)
		throws NoSuchLegalDFRelException {

		return remove((Serializable)legalDFRelPK);
	}

	/**
	 * Removes the legal df rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal df rel
	 * @return the legal df rel that was removed
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel remove(Serializable primaryKey)
		throws NoSuchLegalDFRelException {

		Session session = null;

		try {
			session = openSession();

			LegalDFRel legalDFRel = (LegalDFRel)session.get(
				LegalDFRelImpl.class, primaryKey);

			if (legalDFRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDFRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDFRel);
		}
		catch (NoSuchLegalDFRelException noSuchEntityException) {
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
	protected LegalDFRel removeImpl(LegalDFRel legalDFRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDFRel)) {
				legalDFRel = (LegalDFRel)session.get(
					LegalDFRelImpl.class, legalDFRel.getPrimaryKeyObj());
			}

			if (legalDFRel != null) {
				session.delete(legalDFRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDFRel != null) {
			clearCache(legalDFRel);
		}

		return legalDFRel;
	}

	@Override
	public LegalDFRel updateImpl(LegalDFRel legalDFRel) {
		boolean isNew = legalDFRel.isNew();

		if (!(legalDFRel instanceof LegalDFRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDFRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalDFRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDFRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDFRel implementation " +
					legalDFRel.getClass());
		}

		LegalDFRelModelImpl legalDFRelModelImpl =
			(LegalDFRelModelImpl)legalDFRel;

		Session session = null;

		try {
			session = openSession();

			if (legalDFRel.isNew()) {
				session.save(legalDFRel);

				legalDFRel.setNew(false);
			}
			else {
				legalDFRel = (LegalDFRel)session.merge(legalDFRel);
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
			Object[] args = new Object[] {legalDFRelModelImpl.getFieldId()};

			finderCache.removeResult(_finderPathCountByField, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByField, args);

			args = new Object[] {legalDFRelModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountByDocId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDFRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByField.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDFRelModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);

				args = new Object[] {legalDFRelModelImpl.getFieldId()};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);
			}

			if ((legalDFRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDFRelModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByDocId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocId, args);

				args = new Object[] {legalDFRelModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountByDocId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDFRelImpl.class,
			legalDFRel.getPrimaryKey(), legalDFRel, false);

		legalDFRel.resetOriginalValues();

		return legalDFRel;
	}

	/**
	 * Returns the legal df rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal df rel
	 * @return the legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDFRelException {

		LegalDFRel legalDFRel = fetchByPrimaryKey(primaryKey);

		if (legalDFRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDFRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDFRel;
	}

	/**
	 * Returns the legal df rel with the primary key or throws a <code>NoSuchLegalDFRelException</code> if it could not be found.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel findByPrimaryKey(LegalDFRelPK legalDFRelPK)
		throws NoSuchLegalDFRelException {

		return findByPrimaryKey((Serializable)legalDFRelPK);
	}

	/**
	 * Returns the legal df rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel, or <code>null</code> if a legal df rel with the primary key could not be found
	 */
	@Override
	public LegalDFRel fetchByPrimaryKey(LegalDFRelPK legalDFRelPK) {
		return fetchByPrimaryKey((Serializable)legalDFRelPK);
	}

	/**
	 * Returns all the legal df rels.
	 *
	 * @return the legal df rels
	 */
	@Override
	public List<LegalDFRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of legal df rels
	 */
	@Override
	public List<LegalDFRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal df rels
	 */
	@Override
	public List<LegalDFRel> findAll(
		int start, int end, OrderByComparator<LegalDFRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal df rels
	 */
	@Override
	public List<LegalDFRel> findAll(
		int start, int end, OrderByComparator<LegalDFRel> orderByComparator,
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

		List<LegalDFRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDFRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDFREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDFREL;

				sql = sql.concat(LegalDFRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDFRel>)QueryUtil.list(
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
	 * Removes all the legal df rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDFRel legalDFRel : findAll()) {
			remove(legalDFRel);
		}
	}

	/**
	 * Returns the number of legal df rels.
	 *
	 * @return the number of legal df rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDFREL);

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
		return "legalDFRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDFREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDFRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal df rel persistence.
	 */
	@Activate
	public void activate() {
		LegalDFRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDFRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDFRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDFRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDFRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDFRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField",
			new String[] {Long.class.getName()},
			LegalDFRelModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDFRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDFRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocId",
			new String[] {Long.class.getName()},
			LegalDFRelModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDFRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDFRel"),
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

	private static final String _SQL_SELECT_LEGALDFREL =
		"SELECT legalDFRel FROM LegalDFRel legalDFRel";

	private static final String _SQL_SELECT_LEGALDFREL_WHERE =
		"SELECT legalDFRel FROM LegalDFRel legalDFRel WHERE ";

	private static final String _SQL_COUNT_LEGALDFREL =
		"SELECT COUNT(legalDFRel) FROM LegalDFRel legalDFRel";

	private static final String _SQL_COUNT_LEGALDFREL_WHERE =
		"SELECT COUNT(legalDFRel) FROM LegalDFRel legalDFRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDFRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDFRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDFRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDFRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"docId", "fieldId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}