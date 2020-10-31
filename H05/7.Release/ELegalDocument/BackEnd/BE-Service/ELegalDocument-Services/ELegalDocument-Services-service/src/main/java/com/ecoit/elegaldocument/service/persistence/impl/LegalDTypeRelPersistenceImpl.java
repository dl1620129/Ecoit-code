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

import com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException;
import com.ecoit.elegaldocument.model.LegalDTypeRel;
import com.ecoit.elegaldocument.model.impl.LegalDTypeRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalDTypeRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalDTypeRelPersistence;
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
 * The persistence implementation for the legal d type rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDTypeRelPersistence.class)
public class LegalDTypeRelPersistenceImpl
	extends BasePersistenceImpl<LegalDTypeRel>
	implements LegalDTypeRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDTypeRelUtil</code> to access the legal d type rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDTypeRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the legal d type rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByType(long typeId) {
		return findByType(typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByType(long typeId, int start, int end) {
		return findByType(typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return findByType(typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {typeId, start, end, orderByComparator};
		}

		List<LegalDTypeRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDTypeRel legalDTypeRel : list) {
					if (typeId != legalDTypeRel.getTypeId()) {
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

			query.append(_SQL_SELECT_LEGALDTYPEREL_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDTypeRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				list = (List<LegalDTypeRel>)QueryUtil.list(
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
	 * Returns the first legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel findByType_First(
			long typeId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = fetchByType_First(
			typeId, orderByComparator);

		if (legalDTypeRel != null) {
			return legalDTypeRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDTypeRelException(msg.toString());
	}

	/**
	 * Returns the first legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel fetchByType_First(
		long typeId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		List<LegalDTypeRel> list = findByType(typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel findByType_Last(
			long typeId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = fetchByType_Last(
			typeId, orderByComparator);

		if (legalDTypeRel != null) {
			return legalDTypeRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDTypeRelException(msg.toString());
	}

	/**
	 * Returns the last legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel fetchByType_Last(
		long typeId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		int count = countByType(typeId);

		if (count == 0) {
			return null;
		}

		List<LegalDTypeRel> list = findByType(
			typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal d type rels before and after the current legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param legalDTypeRelPK the primary key of the current legal d type rel
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel[] findByType_PrevAndNext(
			LegalDTypeRelPK legalDTypeRelPK, long typeId,
			OrderByComparator<LegalDTypeRel> orderByComparator)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = findByPrimaryKey(legalDTypeRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDTypeRel[] array = new LegalDTypeRelImpl[3];

			array[0] = getByType_PrevAndNext(
				session, legalDTypeRel, typeId, orderByComparator, true);

			array[1] = legalDTypeRel;

			array[2] = getByType_PrevAndNext(
				session, legalDTypeRel, typeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDTypeRel getByType_PrevAndNext(
		Session session, LegalDTypeRel legalDTypeRel, long typeId,
		OrderByComparator<LegalDTypeRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDTYPEREL_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPEID_2);

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
			query.append(LegalDTypeRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDTypeRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDTypeRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal d type rels where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	@Override
	public void removeByType(long typeId) {
		for (LegalDTypeRel legalDTypeRel :
				findByType(
					typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDTypeRel);
		}
	}

	/**
	 * Returns the number of legal d type rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal d type rels
	 */
	@Override
	public int countByType(long typeId) {
		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDTYPEREL_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPEID_2);

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

	private static final String _FINDER_COLUMN_TYPE_TYPEID_2 =
		"legalDTypeRel.id.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByDoc;
	private FinderPath _finderPathWithoutPaginationFindByDoc;
	private FinderPath _finderPathCountByDoc;

	/**
	 * Returns all the legal d type rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByDoc(long docId) {
		return findByDoc(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByDoc(long docId, int start, int end) {
		return findByDoc(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return findByDoc(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator,
		boolean useFinderCache) {

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

		List<LegalDTypeRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDTypeRel legalDTypeRel : list) {
					if (docId != legalDTypeRel.getDocId()) {
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

			query.append(_SQL_SELECT_LEGALDTYPEREL_WHERE);

			query.append(_FINDER_COLUMN_DOC_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDTypeRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				list = (List<LegalDTypeRel>)QueryUtil.list(
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
	 * Returns the first legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel findByDoc_First(
			long docId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = fetchByDoc_First(
			docId, orderByComparator);

		if (legalDTypeRel != null) {
			return legalDTypeRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDTypeRelException(msg.toString());
	}

	/**
	 * Returns the first legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel fetchByDoc_First(
		long docId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		List<LegalDTypeRel> list = findByDoc(docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel findByDoc_Last(
			long docId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = fetchByDoc_Last(docId, orderByComparator);

		if (legalDTypeRel != null) {
			return legalDTypeRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDTypeRelException(msg.toString());
	}

	/**
	 * Returns the last legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel fetchByDoc_Last(
		long docId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		int count = countByDoc(docId);

		if (count == 0) {
			return null;
		}

		List<LegalDTypeRel> list = findByDoc(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal d type rels before and after the current legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDTypeRelPK the primary key of the current legal d type rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel[] findByDoc_PrevAndNext(
			LegalDTypeRelPK legalDTypeRelPK, long docId,
			OrderByComparator<LegalDTypeRel> orderByComparator)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = findByPrimaryKey(legalDTypeRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDTypeRel[] array = new LegalDTypeRelImpl[3];

			array[0] = getByDoc_PrevAndNext(
				session, legalDTypeRel, docId, orderByComparator, true);

			array[1] = legalDTypeRel;

			array[2] = getByDoc_PrevAndNext(
				session, legalDTypeRel, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDTypeRel getByDoc_PrevAndNext(
		Session session, LegalDTypeRel legalDTypeRel, long docId,
		OrderByComparator<LegalDTypeRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDTYPEREL_WHERE);

		query.append(_FINDER_COLUMN_DOC_DOCID_2);

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
			query.append(LegalDTypeRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDTypeRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDTypeRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal d type rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeByDoc(long docId) {
		for (LegalDTypeRel legalDTypeRel :
				findByDoc(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDTypeRel);
		}
	}

	/**
	 * Returns the number of legal d type rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal d type rels
	 */
	@Override
	public int countByDoc(long docId) {
		FinderPath finderPath = _finderPathCountByDoc;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDTYPEREL_WHERE);

			query.append(_FINDER_COLUMN_DOC_DOCID_2);

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

	private static final String _FINDER_COLUMN_DOC_DOCID_2 =
		"legalDTypeRel.id.docId = ?";

	private FinderPath _finderPathFetchByDocType;
	private FinderPath _finderPathCountByDocType;

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or throws a <code>NoSuchLegalDTypeRelException</code> if it could not be found.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel findByDocType(long typeId, long docId)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = fetchByDocType(typeId, docId);

		if (legalDTypeRel == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("typeId=");
			msg.append(typeId);

			msg.append(", docId=");
			msg.append(docId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDTypeRelException(msg.toString());
		}

		return legalDTypeRel;
	}

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel fetchByDocType(long typeId, long docId) {
		return fetchByDocType(typeId, docId, true);
	}

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	@Override
	public LegalDTypeRel fetchByDocType(
		long typeId, long docId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {typeId, docId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocType, finderArgs, this);
		}

		if (result instanceof LegalDTypeRel) {
			LegalDTypeRel legalDTypeRel = (LegalDTypeRel)result;

			if ((typeId != legalDTypeRel.getTypeId()) ||
				(docId != legalDTypeRel.getDocId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALDTYPEREL_WHERE);

			query.append(_FINDER_COLUMN_DOCTYPE_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCTYPE_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(docId);

				List<LegalDTypeRel> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocType, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {typeId, docId};
							}

							_log.warn(
								"LegalDTypeRelPersistenceImpl.fetchByDocType(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDTypeRel legalDTypeRel = list.get(0);

					result = legalDTypeRel;

					cacheResult(legalDTypeRel);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDocType, finderArgs);
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
			return (LegalDTypeRel)result;
		}
	}

	/**
	 * Removes the legal d type rel where typeId = &#63; and docId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the legal d type rel that was removed
	 */
	@Override
	public LegalDTypeRel removeByDocType(long typeId, long docId)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = findByDocType(typeId, docId);

		return remove(legalDTypeRel);
	}

	/**
	 * Returns the number of legal d type rels where typeId = &#63; and docId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the number of matching legal d type rels
	 */
	@Override
	public int countByDocType(long typeId, long docId) {
		FinderPath finderPath = _finderPathCountByDocType;

		Object[] finderArgs = new Object[] {typeId, docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDTYPEREL_WHERE);

			query.append(_FINDER_COLUMN_DOCTYPE_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCTYPE_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

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

	private static final String _FINDER_COLUMN_DOCTYPE_TYPEID_2 =
		"legalDTypeRel.id.typeId = ? AND ";

	private static final String _FINDER_COLUMN_DOCTYPE_DOCID_2 =
		"legalDTypeRel.id.docId = ?";

	public LegalDTypeRelPersistenceImpl() {
		setModelClass(LegalDTypeRel.class);

		setModelImplClass(LegalDTypeRelImpl.class);
		setModelPKClass(LegalDTypeRelPK.class);
	}

	/**
	 * Caches the legal d type rel in the entity cache if it is enabled.
	 *
	 * @param legalDTypeRel the legal d type rel
	 */
	@Override
	public void cacheResult(LegalDTypeRel legalDTypeRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalDTypeRelImpl.class,
			legalDTypeRel.getPrimaryKey(), legalDTypeRel);

		finderCache.putResult(
			_finderPathFetchByDocType,
			new Object[] {legalDTypeRel.getTypeId(), legalDTypeRel.getDocId()},
			legalDTypeRel);

		legalDTypeRel.resetOriginalValues();
	}

	/**
	 * Caches the legal d type rels in the entity cache if it is enabled.
	 *
	 * @param legalDTypeRels the legal d type rels
	 */
	@Override
	public void cacheResult(List<LegalDTypeRel> legalDTypeRels) {
		for (LegalDTypeRel legalDTypeRel : legalDTypeRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDTypeRelImpl.class,
					legalDTypeRel.getPrimaryKey()) == null) {

				cacheResult(legalDTypeRel);
			}
			else {
				legalDTypeRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal d type rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDTypeRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal d type rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDTypeRel legalDTypeRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDTypeRelImpl.class,
			legalDTypeRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalDTypeRelModelImpl)legalDTypeRel, true);
	}

	@Override
	public void clearCache(List<LegalDTypeRel> legalDTypeRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDTypeRel legalDTypeRel : legalDTypeRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDTypeRelImpl.class,
				legalDTypeRel.getPrimaryKey());

			clearUniqueFindersCache(
				(LegalDTypeRelModelImpl)legalDTypeRel, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDTypeRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalDTypeRelModelImpl legalDTypeRelModelImpl) {

		Object[] args = new Object[] {
			legalDTypeRelModelImpl.getTypeId(),
			legalDTypeRelModelImpl.getDocId()
		};

		finderCache.putResult(
			_finderPathCountByDocType, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDocType, args, legalDTypeRelModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalDTypeRelModelImpl legalDTypeRelModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalDTypeRelModelImpl.getTypeId(),
				legalDTypeRelModelImpl.getDocId()
			};

			finderCache.removeResult(_finderPathCountByDocType, args);
			finderCache.removeResult(_finderPathFetchByDocType, args);
		}

		if ((legalDTypeRelModelImpl.getColumnBitmask() &
			 _finderPathFetchByDocType.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDTypeRelModelImpl.getOriginalTypeId(),
				legalDTypeRelModelImpl.getOriginalDocId()
			};

			finderCache.removeResult(_finderPathCountByDocType, args);
			finderCache.removeResult(_finderPathFetchByDocType, args);
		}
	}

	/**
	 * Creates a new legal d type rel with the primary key. Does not add the legal d type rel to the database.
	 *
	 * @param legalDTypeRelPK the primary key for the new legal d type rel
	 * @return the new legal d type rel
	 */
	@Override
	public LegalDTypeRel create(LegalDTypeRelPK legalDTypeRelPK) {
		LegalDTypeRel legalDTypeRel = new LegalDTypeRelImpl();

		legalDTypeRel.setNew(true);
		legalDTypeRel.setPrimaryKey(legalDTypeRelPK);

		return legalDTypeRel;
	}

	/**
	 * Removes the legal d type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel that was removed
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel remove(LegalDTypeRelPK legalDTypeRelPK)
		throws NoSuchLegalDTypeRelException {

		return remove((Serializable)legalDTypeRelPK);
	}

	/**
	 * Removes the legal d type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal d type rel
	 * @return the legal d type rel that was removed
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel remove(Serializable primaryKey)
		throws NoSuchLegalDTypeRelException {

		Session session = null;

		try {
			session = openSession();

			LegalDTypeRel legalDTypeRel = (LegalDTypeRel)session.get(
				LegalDTypeRelImpl.class, primaryKey);

			if (legalDTypeRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDTypeRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDTypeRel);
		}
		catch (NoSuchLegalDTypeRelException noSuchEntityException) {
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
	protected LegalDTypeRel removeImpl(LegalDTypeRel legalDTypeRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDTypeRel)) {
				legalDTypeRel = (LegalDTypeRel)session.get(
					LegalDTypeRelImpl.class, legalDTypeRel.getPrimaryKeyObj());
			}

			if (legalDTypeRel != null) {
				session.delete(legalDTypeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDTypeRel != null) {
			clearCache(legalDTypeRel);
		}

		return legalDTypeRel;
	}

	@Override
	public LegalDTypeRel updateImpl(LegalDTypeRel legalDTypeRel) {
		boolean isNew = legalDTypeRel.isNew();

		if (!(legalDTypeRel instanceof LegalDTypeRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDTypeRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalDTypeRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDTypeRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDTypeRel implementation " +
					legalDTypeRel.getClass());
		}

		LegalDTypeRelModelImpl legalDTypeRelModelImpl =
			(LegalDTypeRelModelImpl)legalDTypeRel;

		Session session = null;

		try {
			session = openSession();

			if (legalDTypeRel.isNew()) {
				session.save(legalDTypeRel);

				legalDTypeRel.setNew(false);
			}
			else {
				legalDTypeRel = (LegalDTypeRel)session.merge(legalDTypeRel);
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
			Object[] args = new Object[] {legalDTypeRelModelImpl.getTypeId()};

			finderCache.removeResult(_finderPathCountByType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByType, args);

			args = new Object[] {legalDTypeRelModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountByDoc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDoc, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDTypeRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByType.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDTypeRelModelImpl.getOriginalTypeId()
				};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);

				args = new Object[] {legalDTypeRelModelImpl.getTypeId()};

				finderCache.removeResult(_finderPathCountByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType, args);
			}

			if ((legalDTypeRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDoc.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDTypeRelModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc, args);

				args = new Object[] {legalDTypeRelModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountByDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDTypeRelImpl.class,
			legalDTypeRel.getPrimaryKey(), legalDTypeRel, false);

		clearUniqueFindersCache(legalDTypeRelModelImpl, false);
		cacheUniqueFindersCache(legalDTypeRelModelImpl);

		legalDTypeRel.resetOriginalValues();

		return legalDTypeRel;
	}

	/**
	 * Returns the legal d type rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal d type rel
	 * @return the legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDTypeRelException {

		LegalDTypeRel legalDTypeRel = fetchByPrimaryKey(primaryKey);

		if (legalDTypeRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDTypeRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDTypeRel;
	}

	/**
	 * Returns the legal d type rel with the primary key or throws a <code>NoSuchLegalDTypeRelException</code> if it could not be found.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel findByPrimaryKey(LegalDTypeRelPK legalDTypeRelPK)
		throws NoSuchLegalDTypeRelException {

		return findByPrimaryKey((Serializable)legalDTypeRelPK);
	}

	/**
	 * Returns the legal d type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel, or <code>null</code> if a legal d type rel with the primary key could not be found
	 */
	@Override
	public LegalDTypeRel fetchByPrimaryKey(LegalDTypeRelPK legalDTypeRelPK) {
		return fetchByPrimaryKey((Serializable)legalDTypeRelPK);
	}

	/**
	 * Returns all the legal d type rels.
	 *
	 * @return the legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findAll(
		int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal d type rels
	 */
	@Override
	public List<LegalDTypeRel> findAll(
		int start, int end, OrderByComparator<LegalDTypeRel> orderByComparator,
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

		List<LegalDTypeRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDTypeRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDTYPEREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDTYPEREL;

				sql = sql.concat(LegalDTypeRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDTypeRel>)QueryUtil.list(
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
	 * Removes all the legal d type rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDTypeRel legalDTypeRel : findAll()) {
			remove(legalDTypeRel);
		}
	}

	/**
	 * Returns the number of legal d type rels.
	 *
	 * @return the number of legal d type rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDTYPEREL);

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
		return "legalDTypeRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDTYPEREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDTypeRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal d type rel persistence.
	 */
	@Activate
	public void activate() {
		LegalDTypeRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDTypeRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {Long.class.getName()},
			LegalDTypeRelModelImpl.TYPEID_COLUMN_BITMASK);

		_finderPathCountByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoc",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoc",
			new String[] {Long.class.getName()},
			LegalDTypeRelModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoc",
			new String[] {Long.class.getName()});

		_finderPathFetchByDocType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDTypeRelImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDocType",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalDTypeRelModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDTypeRelModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDocType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocType",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDTypeRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDTypeRel"),
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

	private static final String _SQL_SELECT_LEGALDTYPEREL =
		"SELECT legalDTypeRel FROM LegalDTypeRel legalDTypeRel";

	private static final String _SQL_SELECT_LEGALDTYPEREL_WHERE =
		"SELECT legalDTypeRel FROM LegalDTypeRel legalDTypeRel WHERE ";

	private static final String _SQL_COUNT_LEGALDTYPEREL =
		"SELECT COUNT(legalDTypeRel) FROM LegalDTypeRel legalDTypeRel";

	private static final String _SQL_COUNT_LEGALDTYPEREL_WHERE =
		"SELECT COUNT(legalDTypeRel) FROM LegalDTypeRel legalDTypeRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDTypeRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDTypeRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDTypeRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDTypeRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"docId", "typeId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}