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

import com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException;
import com.ecoit.elegaldocument.model.LegalTDRel;
import com.ecoit.elegaldocument.model.impl.LegalTDRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalTDRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalTDRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalTDRelPersistence;
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
 * The persistence implementation for the legal td rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalTDRelPersistence.class)
public class LegalTDRelPersistenceImpl
	extends BasePersistenceImpl<LegalTDRel> implements LegalTDRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalTDRelUtil</code> to access the legal td rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalTDRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDocument;
	private FinderPath _finderPathWithoutPaginationFindByDocument;
	private FinderPath _finderPathCountByDocument;

	/**
	 * Returns all the legal td rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByDocument(long docId) {
		return findByDocument(
			docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByDocument(long docId, int start, int end) {
		return findByDocument(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByDocument(
		long docId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator) {

		return findByDocument(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByDocument(
		long docId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocument;
				finderArgs = new Object[] {docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocument;
			finderArgs = new Object[] {docId, start, end, orderByComparator};
		}

		List<LegalTDRel> list = null;

		if (useFinderCache) {
			list = (List<LegalTDRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalTDRel legalTDRel : list) {
					if (docId != legalTDRel.getDocId()) {
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

			query.append(_SQL_SELECT_LEGALTDREL_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENT_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTDRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				list = (List<LegalTDRel>)QueryUtil.list(
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
	 * Returns the first legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel findByDocument_First(
			long docId, OrderByComparator<LegalTDRel> orderByComparator)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = fetchByDocument_First(docId, orderByComparator);

		if (legalTDRel != null) {
			return legalTDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalTDRelException(msg.toString());
	}

	/**
	 * Returns the first legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel fetchByDocument_First(
		long docId, OrderByComparator<LegalTDRel> orderByComparator) {

		List<LegalTDRel> list = findByDocument(docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel findByDocument_Last(
			long docId, OrderByComparator<LegalTDRel> orderByComparator)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = fetchByDocument_Last(docId, orderByComparator);

		if (legalTDRel != null) {
			return legalTDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalTDRelException(msg.toString());
	}

	/**
	 * Returns the last legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel fetchByDocument_Last(
		long docId, OrderByComparator<LegalTDRel> orderByComparator) {

		int count = countByDocument(docId);

		if (count == 0) {
			return null;
		}

		List<LegalTDRel> list = findByDocument(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal td rels before and after the current legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param legalTDRelPK the primary key of the current legal td rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel[] findByDocument_PrevAndNext(
			LegalTDRelPK legalTDRelPK, long docId,
			OrderByComparator<LegalTDRel> orderByComparator)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = findByPrimaryKey(legalTDRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalTDRel[] array = new LegalTDRelImpl[3];

			array[0] = getByDocument_PrevAndNext(
				session, legalTDRel, docId, orderByComparator, true);

			array[1] = legalTDRel;

			array[2] = getByDocument_PrevAndNext(
				session, legalTDRel, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalTDRel getByDocument_PrevAndNext(
		Session session, LegalTDRel legalTDRel, long docId,
		OrderByComparator<LegalTDRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALTDREL_WHERE);

		query.append(_FINDER_COLUMN_DOCUMENT_DOCID_2);

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
			query.append(LegalTDRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalTDRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalTDRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal td rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeByDocument(long docId) {
		for (LegalTDRel legalTDRel :
				findByDocument(
					docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalTDRel);
		}
	}

	/**
	 * Returns the number of legal td rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal td rels
	 */
	@Override
	public int countByDocument(long docId) {
		FinderPath finderPath = _finderPathCountByDocument;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALTDREL_WHERE);

			query.append(_FINDER_COLUMN_DOCUMENT_DOCID_2);

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

	private static final String _FINDER_COLUMN_DOCUMENT_DOCID_2 =
		"legalTDRel.id.docId = ?";

	private FinderPath _finderPathWithPaginationFindByTag;
	private FinderPath _finderPathWithoutPaginationFindByTag;
	private FinderPath _finderPathCountByTag;

	/**
	 * Returns all the legal td rels where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByTag(long tagId) {
		return findByTag(tagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByTag(long tagId, int start, int end) {
		return findByTag(tagId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByTag(
		long tagId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator) {

		return findByTag(tagId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal td rels
	 */
	@Override
	public List<LegalTDRel> findByTag(
		long tagId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTag;
				finderArgs = new Object[] {tagId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTag;
			finderArgs = new Object[] {tagId, start, end, orderByComparator};
		}

		List<LegalTDRel> list = null;

		if (useFinderCache) {
			list = (List<LegalTDRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalTDRel legalTDRel : list) {
					if (tagId != legalTDRel.getTagId()) {
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

			query.append(_SQL_SELECT_LEGALTDREL_WHERE);

			query.append(_FINDER_COLUMN_TAG_TAGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalTDRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

				list = (List<LegalTDRel>)QueryUtil.list(
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
	 * Returns the first legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel findByTag_First(
			long tagId, OrderByComparator<LegalTDRel> orderByComparator)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = fetchByTag_First(tagId, orderByComparator);

		if (legalTDRel != null) {
			return legalTDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append("}");

		throw new NoSuchLegalTDRelException(msg.toString());
	}

	/**
	 * Returns the first legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel fetchByTag_First(
		long tagId, OrderByComparator<LegalTDRel> orderByComparator) {

		List<LegalTDRel> list = findByTag(tagId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel findByTag_Last(
			long tagId, OrderByComparator<LegalTDRel> orderByComparator)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = fetchByTag_Last(tagId, orderByComparator);

		if (legalTDRel != null) {
			return legalTDRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tagId=");
		msg.append(tagId);

		msg.append("}");

		throw new NoSuchLegalTDRelException(msg.toString());
	}

	/**
	 * Returns the last legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	@Override
	public LegalTDRel fetchByTag_Last(
		long tagId, OrderByComparator<LegalTDRel> orderByComparator) {

		int count = countByTag(tagId);

		if (count == 0) {
			return null;
		}

		List<LegalTDRel> list = findByTag(
			tagId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal td rels before and after the current legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param legalTDRelPK the primary key of the current legal td rel
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel[] findByTag_PrevAndNext(
			LegalTDRelPK legalTDRelPK, long tagId,
			OrderByComparator<LegalTDRel> orderByComparator)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = findByPrimaryKey(legalTDRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalTDRel[] array = new LegalTDRelImpl[3];

			array[0] = getByTag_PrevAndNext(
				session, legalTDRel, tagId, orderByComparator, true);

			array[1] = legalTDRel;

			array[2] = getByTag_PrevAndNext(
				session, legalTDRel, tagId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalTDRel getByTag_PrevAndNext(
		Session session, LegalTDRel legalTDRel, long tagId,
		OrderByComparator<LegalTDRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALTDREL_WHERE);

		query.append(_FINDER_COLUMN_TAG_TAGID_2);

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
			query.append(LegalTDRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tagId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalTDRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalTDRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal td rels where tagId = &#63; from the database.
	 *
	 * @param tagId the tag ID
	 */
	@Override
	public void removeByTag(long tagId) {
		for (LegalTDRel legalTDRel :
				findByTag(tagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalTDRel);
		}
	}

	/**
	 * Returns the number of legal td rels where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the number of matching legal td rels
	 */
	@Override
	public int countByTag(long tagId) {
		FinderPath finderPath = _finderPathCountByTag;

		Object[] finderArgs = new Object[] {tagId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALTDREL_WHERE);

			query.append(_FINDER_COLUMN_TAG_TAGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tagId);

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

	private static final String _FINDER_COLUMN_TAG_TAGID_2 =
		"legalTDRel.id.tagId = ?";

	public LegalTDRelPersistenceImpl() {
		setModelClass(LegalTDRel.class);

		setModelImplClass(LegalTDRelImpl.class);
		setModelPKClass(LegalTDRelPK.class);
	}

	/**
	 * Caches the legal td rel in the entity cache if it is enabled.
	 *
	 * @param legalTDRel the legal td rel
	 */
	@Override
	public void cacheResult(LegalTDRel legalTDRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalTDRelImpl.class,
			legalTDRel.getPrimaryKey(), legalTDRel);

		legalTDRel.resetOriginalValues();
	}

	/**
	 * Caches the legal td rels in the entity cache if it is enabled.
	 *
	 * @param legalTDRels the legal td rels
	 */
	@Override
	public void cacheResult(List<LegalTDRel> legalTDRels) {
		for (LegalTDRel legalTDRel : legalTDRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalTDRelImpl.class,
					legalTDRel.getPrimaryKey()) == null) {

				cacheResult(legalTDRel);
			}
			else {
				legalTDRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal td rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalTDRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal td rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalTDRel legalTDRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalTDRelImpl.class,
			legalTDRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalTDRel> legalTDRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalTDRel legalTDRel : legalTDRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalTDRelImpl.class,
				legalTDRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalTDRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal td rel with the primary key. Does not add the legal td rel to the database.
	 *
	 * @param legalTDRelPK the primary key for the new legal td rel
	 * @return the new legal td rel
	 */
	@Override
	public LegalTDRel create(LegalTDRelPK legalTDRelPK) {
		LegalTDRel legalTDRel = new LegalTDRelImpl();

		legalTDRel.setNew(true);
		legalTDRel.setPrimaryKey(legalTDRelPK);

		return legalTDRel;
	}

	/**
	 * Removes the legal td rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel that was removed
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel remove(LegalTDRelPK legalTDRelPK)
		throws NoSuchLegalTDRelException {

		return remove((Serializable)legalTDRelPK);
	}

	/**
	 * Removes the legal td rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal td rel
	 * @return the legal td rel that was removed
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel remove(Serializable primaryKey)
		throws NoSuchLegalTDRelException {

		Session session = null;

		try {
			session = openSession();

			LegalTDRel legalTDRel = (LegalTDRel)session.get(
				LegalTDRelImpl.class, primaryKey);

			if (legalTDRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalTDRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalTDRel);
		}
		catch (NoSuchLegalTDRelException noSuchEntityException) {
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
	protected LegalTDRel removeImpl(LegalTDRel legalTDRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalTDRel)) {
				legalTDRel = (LegalTDRel)session.get(
					LegalTDRelImpl.class, legalTDRel.getPrimaryKeyObj());
			}

			if (legalTDRel != null) {
				session.delete(legalTDRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalTDRel != null) {
			clearCache(legalTDRel);
		}

		return legalTDRel;
	}

	@Override
	public LegalTDRel updateImpl(LegalTDRel legalTDRel) {
		boolean isNew = legalTDRel.isNew();

		if (!(legalTDRel instanceof LegalTDRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalTDRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalTDRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalTDRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalTDRel implementation " +
					legalTDRel.getClass());
		}

		LegalTDRelModelImpl legalTDRelModelImpl =
			(LegalTDRelModelImpl)legalTDRel;

		Session session = null;

		try {
			session = openSession();

			if (legalTDRel.isNew()) {
				session.save(legalTDRel);

				legalTDRel.setNew(false);
			}
			else {
				legalTDRel = (LegalTDRel)session.merge(legalTDRel);
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
			Object[] args = new Object[] {legalTDRelModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountByDocument, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocument, args);

			args = new Object[] {legalTDRelModelImpl.getTagId()};

			finderCache.removeResult(_finderPathCountByTag, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTag, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalTDRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocument.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalTDRelModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByDocument, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocument, args);

				args = new Object[] {legalTDRelModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountByDocument, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocument, args);
			}

			if ((legalTDRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTag.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalTDRelModelImpl.getOriginalTagId()
				};

				finderCache.removeResult(_finderPathCountByTag, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTag, args);

				args = new Object[] {legalTDRelModelImpl.getTagId()};

				finderCache.removeResult(_finderPathCountByTag, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTag, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalTDRelImpl.class,
			legalTDRel.getPrimaryKey(), legalTDRel, false);

		legalTDRel.resetOriginalValues();

		return legalTDRel;
	}

	/**
	 * Returns the legal td rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal td rel
	 * @return the legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalTDRelException {

		LegalTDRel legalTDRel = fetchByPrimaryKey(primaryKey);

		if (legalTDRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalTDRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalTDRel;
	}

	/**
	 * Returns the legal td rel with the primary key or throws a <code>NoSuchLegalTDRelException</code> if it could not be found.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel findByPrimaryKey(LegalTDRelPK legalTDRelPK)
		throws NoSuchLegalTDRelException {

		return findByPrimaryKey((Serializable)legalTDRelPK);
	}

	/**
	 * Returns the legal td rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel, or <code>null</code> if a legal td rel with the primary key could not be found
	 */
	@Override
	public LegalTDRel fetchByPrimaryKey(LegalTDRelPK legalTDRelPK) {
		return fetchByPrimaryKey((Serializable)legalTDRelPK);
	}

	/**
	 * Returns all the legal td rels.
	 *
	 * @return the legal td rels
	 */
	@Override
	public List<LegalTDRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of legal td rels
	 */
	@Override
	public List<LegalTDRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal td rels
	 */
	@Override
	public List<LegalTDRel> findAll(
		int start, int end, OrderByComparator<LegalTDRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal td rels
	 */
	@Override
	public List<LegalTDRel> findAll(
		int start, int end, OrderByComparator<LegalTDRel> orderByComparator,
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

		List<LegalTDRel> list = null;

		if (useFinderCache) {
			list = (List<LegalTDRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALTDREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALTDREL;

				sql = sql.concat(LegalTDRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalTDRel>)QueryUtil.list(
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
	 * Removes all the legal td rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalTDRel legalTDRel : findAll()) {
			remove(legalTDRel);
		}
	}

	/**
	 * Returns the number of legal td rels.
	 *
	 * @return the number of legal td rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALTDREL);

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
		return "legalTDRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALTDREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalTDRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal td rel persistence.
	 */
	@Activate
	public void activate() {
		LegalTDRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalTDRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDocument = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocument",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocument = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocument",
			new String[] {Long.class.getName()},
			LegalTDRelModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDocument = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocument",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTag = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTag",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTag = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalTDRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTag",
			new String[] {Long.class.getName()},
			LegalTDRelModelImpl.TAGID_COLUMN_BITMASK);

		_finderPathCountByTag = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTag",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalTDRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalTDRel"),
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

	private static final String _SQL_SELECT_LEGALTDREL =
		"SELECT legalTDRel FROM LegalTDRel legalTDRel";

	private static final String _SQL_SELECT_LEGALTDREL_WHERE =
		"SELECT legalTDRel FROM LegalTDRel legalTDRel WHERE ";

	private static final String _SQL_COUNT_LEGALTDREL =
		"SELECT COUNT(legalTDRel) FROM LegalTDRel legalTDRel";

	private static final String _SQL_COUNT_LEGALTDREL_WHERE =
		"SELECT COUNT(legalTDRel) FROM LegalTDRel legalTDRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalTDRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalTDRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalTDRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalTDRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"docId", "tagId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}