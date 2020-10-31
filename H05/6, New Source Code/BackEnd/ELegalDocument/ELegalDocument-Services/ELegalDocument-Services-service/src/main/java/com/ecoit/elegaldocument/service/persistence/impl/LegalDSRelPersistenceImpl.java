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

import com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException;
import com.ecoit.elegaldocument.model.LegalDSRel;
import com.ecoit.elegaldocument.model.impl.LegalDSRelImpl;
import com.ecoit.elegaldocument.model.impl.LegalDSRelModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDSRelPK;
import com.ecoit.elegaldocument.service.persistence.LegalDSRelPersistence;
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
 * The persistence implementation for the legal ds rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDSRelPersistence.class)
public class LegalDSRelPersistenceImpl
	extends BasePersistenceImpl<LegalDSRel> implements LegalDSRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDSRelUtil</code> to access the legal ds rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDSRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySigner;
	private FinderPath _finderPathWithoutPaginationFindBySigner;
	private FinderPath _finderPathCountBySigner;

	/**
	 * Returns all the legal ds rels where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findBySigner(long sigId) {
		return findBySigner(sigId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findBySigner(long sigId, int start, int end) {
		return findBySigner(sigId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findBySigner(
		long sigId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator) {

		return findBySigner(sigId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findBySigner(
		long sigId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySigner;
				finderArgs = new Object[] {sigId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySigner;
			finderArgs = new Object[] {sigId, start, end, orderByComparator};
		}

		List<LegalDSRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDSRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDSRel legalDSRel : list) {
					if (sigId != legalDSRel.getSigId()) {
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

			query.append(_SQL_SELECT_LEGALDSREL_WHERE);

			query.append(_FINDER_COLUMN_SIGNER_SIGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDSRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sigId);

				list = (List<LegalDSRel>)QueryUtil.list(
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
	 * Returns the first legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel findBySigner_First(
			long sigId, OrderByComparator<LegalDSRel> orderByComparator)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = fetchBySigner_First(sigId, orderByComparator);

		if (legalDSRel != null) {
			return legalDSRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sigId=");
		msg.append(sigId);

		msg.append("}");

		throw new NoSuchLegalDSRelException(msg.toString());
	}

	/**
	 * Returns the first legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel fetchBySigner_First(
		long sigId, OrderByComparator<LegalDSRel> orderByComparator) {

		List<LegalDSRel> list = findBySigner(sigId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel findBySigner_Last(
			long sigId, OrderByComparator<LegalDSRel> orderByComparator)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = fetchBySigner_Last(sigId, orderByComparator);

		if (legalDSRel != null) {
			return legalDSRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sigId=");
		msg.append(sigId);

		msg.append("}");

		throw new NoSuchLegalDSRelException(msg.toString());
	}

	/**
	 * Returns the last legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel fetchBySigner_Last(
		long sigId, OrderByComparator<LegalDSRel> orderByComparator) {

		int count = countBySigner(sigId);

		if (count == 0) {
			return null;
		}

		List<LegalDSRel> list = findBySigner(
			sigId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal ds rels before and after the current legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param legalDSRelPK the primary key of the current legal ds rel
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel[] findBySigner_PrevAndNext(
			LegalDSRelPK legalDSRelPK, long sigId,
			OrderByComparator<LegalDSRel> orderByComparator)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = findByPrimaryKey(legalDSRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDSRel[] array = new LegalDSRelImpl[3];

			array[0] = getBySigner_PrevAndNext(
				session, legalDSRel, sigId, orderByComparator, true);

			array[1] = legalDSRel;

			array[2] = getBySigner_PrevAndNext(
				session, legalDSRel, sigId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDSRel getBySigner_PrevAndNext(
		Session session, LegalDSRel legalDSRel, long sigId,
		OrderByComparator<LegalDSRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDSREL_WHERE);

		query.append(_FINDER_COLUMN_SIGNER_SIGID_2);

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
			query.append(LegalDSRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sigId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDSRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDSRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal ds rels where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 */
	@Override
	public void removeBySigner(long sigId) {
		for (LegalDSRel legalDSRel :
				findBySigner(
					sigId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDSRel);
		}
	}

	/**
	 * Returns the number of legal ds rels where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching legal ds rels
	 */
	@Override
	public int countBySigner(long sigId) {
		FinderPath finderPath = _finderPathCountBySigner;

		Object[] finderArgs = new Object[] {sigId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDSREL_WHERE);

			query.append(_FINDER_COLUMN_SIGNER_SIGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sigId);

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

	private static final String _FINDER_COLUMN_SIGNER_SIGID_2 =
		"legalDSRel.id.sigId = ?";

	private FinderPath _finderPathWithPaginationFindByDoc;
	private FinderPath _finderPathWithoutPaginationFindByDoc;
	private FinderPath _finderPathCountByDoc;

	/**
	 * Returns all the legal ds rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findByDoc(long docId) {
		return findByDoc(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findByDoc(long docId, int start, int end) {
		return findByDoc(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator) {

		return findByDoc(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ds rels
	 */
	@Override
	public List<LegalDSRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator,
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

		List<LegalDSRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDSRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDSRel legalDSRel : list) {
					if (docId != legalDSRel.getDocId()) {
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

			query.append(_SQL_SELECT_LEGALDSREL_WHERE);

			query.append(_FINDER_COLUMN_DOC_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDSRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				list = (List<LegalDSRel>)QueryUtil.list(
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
	 * Returns the first legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel findByDoc_First(
			long docId, OrderByComparator<LegalDSRel> orderByComparator)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = fetchByDoc_First(docId, orderByComparator);

		if (legalDSRel != null) {
			return legalDSRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDSRelException(msg.toString());
	}

	/**
	 * Returns the first legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel fetchByDoc_First(
		long docId, OrderByComparator<LegalDSRel> orderByComparator) {

		List<LegalDSRel> list = findByDoc(docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel findByDoc_Last(
			long docId, OrderByComparator<LegalDSRel> orderByComparator)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = fetchByDoc_Last(docId, orderByComparator);

		if (legalDSRel != null) {
			return legalDSRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalDSRelException(msg.toString());
	}

	/**
	 * Returns the last legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	@Override
	public LegalDSRel fetchByDoc_Last(
		long docId, OrderByComparator<LegalDSRel> orderByComparator) {

		int count = countByDoc(docId);

		if (count == 0) {
			return null;
		}

		List<LegalDSRel> list = findByDoc(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal ds rels before and after the current legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDSRelPK the primary key of the current legal ds rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel[] findByDoc_PrevAndNext(
			LegalDSRelPK legalDSRelPK, long docId,
			OrderByComparator<LegalDSRel> orderByComparator)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = findByPrimaryKey(legalDSRelPK);

		Session session = null;

		try {
			session = openSession();

			LegalDSRel[] array = new LegalDSRelImpl[3];

			array[0] = getByDoc_PrevAndNext(
				session, legalDSRel, docId, orderByComparator, true);

			array[1] = legalDSRel;

			array[2] = getByDoc_PrevAndNext(
				session, legalDSRel, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDSRel getByDoc_PrevAndNext(
		Session session, LegalDSRel legalDSRel, long docId,
		OrderByComparator<LegalDSRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDSREL_WHERE);

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
			query.append(LegalDSRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalDSRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDSRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal ds rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeByDoc(long docId) {
		for (LegalDSRel legalDSRel :
				findByDoc(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDSRel);
		}
	}

	/**
	 * Returns the number of legal ds rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal ds rels
	 */
	@Override
	public int countByDoc(long docId) {
		FinderPath finderPath = _finderPathCountByDoc;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDSREL_WHERE);

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
		"legalDSRel.id.docId = ?";

	public LegalDSRelPersistenceImpl() {
		setModelClass(LegalDSRel.class);

		setModelImplClass(LegalDSRelImpl.class);
		setModelPKClass(LegalDSRelPK.class);
	}

	/**
	 * Caches the legal ds rel in the entity cache if it is enabled.
	 *
	 * @param legalDSRel the legal ds rel
	 */
	@Override
	public void cacheResult(LegalDSRel legalDSRel) {
		entityCache.putResult(
			entityCacheEnabled, LegalDSRelImpl.class,
			legalDSRel.getPrimaryKey(), legalDSRel);

		legalDSRel.resetOriginalValues();
	}

	/**
	 * Caches the legal ds rels in the entity cache if it is enabled.
	 *
	 * @param legalDSRels the legal ds rels
	 */
	@Override
	public void cacheResult(List<LegalDSRel> legalDSRels) {
		for (LegalDSRel legalDSRel : legalDSRels) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDSRelImpl.class,
					legalDSRel.getPrimaryKey()) == null) {

				cacheResult(legalDSRel);
			}
			else {
				legalDSRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal ds rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDSRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal ds rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDSRel legalDSRel) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDSRelImpl.class,
			legalDSRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LegalDSRel> legalDSRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDSRel legalDSRel : legalDSRels) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDSRelImpl.class,
				legalDSRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDSRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new legal ds rel with the primary key. Does not add the legal ds rel to the database.
	 *
	 * @param legalDSRelPK the primary key for the new legal ds rel
	 * @return the new legal ds rel
	 */
	@Override
	public LegalDSRel create(LegalDSRelPK legalDSRelPK) {
		LegalDSRel legalDSRel = new LegalDSRelImpl();

		legalDSRel.setNew(true);
		legalDSRel.setPrimaryKey(legalDSRelPK);

		return legalDSRel;
	}

	/**
	 * Removes the legal ds rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel that was removed
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel remove(LegalDSRelPK legalDSRelPK)
		throws NoSuchLegalDSRelException {

		return remove((Serializable)legalDSRelPK);
	}

	/**
	 * Removes the legal ds rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal ds rel
	 * @return the legal ds rel that was removed
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel remove(Serializable primaryKey)
		throws NoSuchLegalDSRelException {

		Session session = null;

		try {
			session = openSession();

			LegalDSRel legalDSRel = (LegalDSRel)session.get(
				LegalDSRelImpl.class, primaryKey);

			if (legalDSRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDSRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDSRel);
		}
		catch (NoSuchLegalDSRelException noSuchEntityException) {
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
	protected LegalDSRel removeImpl(LegalDSRel legalDSRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDSRel)) {
				legalDSRel = (LegalDSRel)session.get(
					LegalDSRelImpl.class, legalDSRel.getPrimaryKeyObj());
			}

			if (legalDSRel != null) {
				session.delete(legalDSRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDSRel != null) {
			clearCache(legalDSRel);
		}

		return legalDSRel;
	}

	@Override
	public LegalDSRel updateImpl(LegalDSRel legalDSRel) {
		boolean isNew = legalDSRel.isNew();

		if (!(legalDSRel instanceof LegalDSRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDSRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalDSRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDSRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDSRel implementation " +
					legalDSRel.getClass());
		}

		LegalDSRelModelImpl legalDSRelModelImpl =
			(LegalDSRelModelImpl)legalDSRel;

		Session session = null;

		try {
			session = openSession();

			if (legalDSRel.isNew()) {
				session.save(legalDSRel);

				legalDSRel.setNew(false);
			}
			else {
				legalDSRel = (LegalDSRel)session.merge(legalDSRel);
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
			Object[] args = new Object[] {legalDSRelModelImpl.getSigId()};

			finderCache.removeResult(_finderPathCountBySigner, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySigner, args);

			args = new Object[] {legalDSRelModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountByDoc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDoc, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDSRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySigner.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDSRelModelImpl.getOriginalSigId()
				};

				finderCache.removeResult(_finderPathCountBySigner, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySigner, args);

				args = new Object[] {legalDSRelModelImpl.getSigId()};

				finderCache.removeResult(_finderPathCountBySigner, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySigner, args);
			}

			if ((legalDSRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDoc.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDSRelModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc, args);

				args = new Object[] {legalDSRelModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountByDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDSRelImpl.class,
			legalDSRel.getPrimaryKey(), legalDSRel, false);

		legalDSRel.resetOriginalValues();

		return legalDSRel;
	}

	/**
	 * Returns the legal ds rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal ds rel
	 * @return the legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDSRelException {

		LegalDSRel legalDSRel = fetchByPrimaryKey(primaryKey);

		if (legalDSRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDSRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDSRel;
	}

	/**
	 * Returns the legal ds rel with the primary key or throws a <code>NoSuchLegalDSRelException</code> if it could not be found.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel findByPrimaryKey(LegalDSRelPK legalDSRelPK)
		throws NoSuchLegalDSRelException {

		return findByPrimaryKey((Serializable)legalDSRelPK);
	}

	/**
	 * Returns the legal ds rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel, or <code>null</code> if a legal ds rel with the primary key could not be found
	 */
	@Override
	public LegalDSRel fetchByPrimaryKey(LegalDSRelPK legalDSRelPK) {
		return fetchByPrimaryKey((Serializable)legalDSRelPK);
	}

	/**
	 * Returns all the legal ds rels.
	 *
	 * @return the legal ds rels
	 */
	@Override
	public List<LegalDSRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of legal ds rels
	 */
	@Override
	public List<LegalDSRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal ds rels
	 */
	@Override
	public List<LegalDSRel> findAll(
		int start, int end, OrderByComparator<LegalDSRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal ds rels
	 */
	@Override
	public List<LegalDSRel> findAll(
		int start, int end, OrderByComparator<LegalDSRel> orderByComparator,
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

		List<LegalDSRel> list = null;

		if (useFinderCache) {
			list = (List<LegalDSRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDSREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDSREL;

				sql = sql.concat(LegalDSRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDSRel>)QueryUtil.list(
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
	 * Removes all the legal ds rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDSRel legalDSRel : findAll()) {
			remove(legalDSRel);
		}
	}

	/**
	 * Returns the number of legal ds rels.
	 *
	 * @return the number of legal ds rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDSREL);

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
		return "legalDSRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDSRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal ds rel persistence.
	 */
	@Activate
	public void activate() {
		LegalDSRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDSRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDSRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDSRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBySigner = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDSRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySigner",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySigner = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDSRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySigner",
			new String[] {Long.class.getName()},
			LegalDSRelModelImpl.SIGID_COLUMN_BITMASK);

		_finderPathCountBySigner = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigner",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDSRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoc",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDSRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoc",
			new String[] {Long.class.getName()},
			LegalDSRelModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoc",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDSRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDSRel"),
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

	private static final String _SQL_SELECT_LEGALDSREL =
		"SELECT legalDSRel FROM LegalDSRel legalDSRel";

	private static final String _SQL_SELECT_LEGALDSREL_WHERE =
		"SELECT legalDSRel FROM LegalDSRel legalDSRel WHERE ";

	private static final String _SQL_COUNT_LEGALDSREL =
		"SELECT COUNT(legalDSRel) FROM LegalDSRel legalDSRel";

	private static final String _SQL_COUNT_LEGALDSREL_WHERE =
		"SELECT COUNT(legalDSRel) FROM LegalDSRel legalDSRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDSRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDSRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDSRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDSRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"docId", "sigId"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}