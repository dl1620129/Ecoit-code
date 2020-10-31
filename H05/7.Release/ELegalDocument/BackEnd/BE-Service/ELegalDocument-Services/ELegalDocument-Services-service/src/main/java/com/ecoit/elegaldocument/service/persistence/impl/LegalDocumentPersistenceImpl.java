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

import com.ecoit.elegaldocument.exception.NoSuchLegalDocumentException;
import com.ecoit.elegaldocument.model.LegalDocument;
import com.ecoit.elegaldocument.model.impl.LegalDocumentImpl;
import com.ecoit.elegaldocument.model.impl.LegalDocumentModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDocumentPersistence;
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
 * The persistence implementation for the legal document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDocumentPersistence.class)
public class LegalDocumentPersistenceImpl
	extends BasePersistenceImpl<LegalDocument>
	implements LegalDocumentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDocumentUtil</code> to access the legal document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDocumentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByDocId;
	private FinderPath _finderPathCountByDocId;

	/**
	 * Returns the legal document where docId = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param docId the doc ID
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocId(long docId)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocId(docId);

		if (legalDocument == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("docId=");
			msg.append(docId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDocumentException(msg.toString());
		}

		return legalDocument;
	}

	/**
	 * Returns the legal document where docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param docId the doc ID
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocId(long docId) {
		return fetchByDocId(docId, true);
	}

	/**
	 * Returns the legal document where docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocId(long docId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {docId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocId, finderArgs, this);
		}

		if (result instanceof LegalDocument) {
			LegalDocument legalDocument = (LegalDocument)result;

			if (docId != legalDocument.getDocId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCID_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				List<LegalDocument> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {docId};
							}

							_log.warn(
								"LegalDocumentPersistenceImpl.fetchByDocId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDocument legalDocument = list.get(0);

					result = legalDocument;

					cacheResult(legalDocument);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByDocId, finderArgs);
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
			return (LegalDocument)result;
		}
	}

	/**
	 * Removes the legal document where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 * @return the legal document that was removed
	 */
	@Override
	public LegalDocument removeByDocId(long docId)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByDocId(docId);

		return remove(legalDocument);
	}

	/**
	 * Returns the number of legal documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDocId(long docId) {
		FinderPath finderPath = _finderPathCountByDocId;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

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
		"legalDocument.docId = ?";

	private FinderPath _finderPathWithPaginationFindByDOC_STATUS;
	private FinderPath _finderPathWithoutPaginationFindByDOC_STATUS;
	private FinderPath _finderPathCountByDOC_STATUS;

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDOC_STATUS(int statusDoc) {
		return findByDOC_STATUS(
			statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end) {

		return findByDOC_STATUS(statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDOC_STATUS(statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDOC_STATUS(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDOC_STATUS;
				finderArgs = new Object[] {statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDOC_STATUS;
			finderArgs = new Object[] {
				statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (statusDoc != legalDocument.getStatusDoc()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDOC_STATUS_First(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDOC_STATUS_First(
			statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDOC_STATUS_First(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDOC_STATUS(
			statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDOC_STATUS_Last(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDOC_STATUS_Last(
			statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDOC_STATUS_Last(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDOC_STATUS(statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDOC_STATUS(
			statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDOC_STATUS_PrevAndNext(
			long docId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDOC_STATUS_PrevAndNext(
				session, legalDocument, statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByDOC_STATUS_PrevAndNext(
				session, legalDocument, statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByDOC_STATUS_PrevAndNext(
		Session session, LegalDocument legalDocument, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOC_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByDOC_STATUS(int statusDoc) {
		for (LegalDocument legalDocument :
				findByDOC_STATUS(
					statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDOC_STATUS(int statusDoc) {
		FinderPath finderPath = _finderPathCountByDOC_STATUS;

		Object[] finderArgs = new Object[] {statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_DOC_STATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
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

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (groupId != legalDocument.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroupId_First(
			long groupId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByGroupId_First(
			groupId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroupId_First(
		long groupId, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroupId_Last(
			long groupId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByGroupId_PrevAndNext(
			long docId, long groupId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalDocument, groupId, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByGroupId_PrevAndNext(
				session, legalDocument, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByGroupId_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalDocument legalDocument :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

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
		"legalDocument.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

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

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

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
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_PrevAndNext(
			long docId, long groupId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalDocument, groupId, language, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByG_L_PrevAndNext(
				session, legalDocument, groupId, language, orderByComparator,
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

	protected LegalDocument getByG_L_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalDocument legalDocument :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

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
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalDocument.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '')";

	private FinderPath _finderPathWithPaginationFindByDocsByF_O_T_L_S;
	private FinderPath _finderPathWithoutPaginationFindByDocsByF_O_T_L_S;
	private FinderPath _finderPathCountByDocsByF_O_T_L_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId) {

		return findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end) {

		return findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocsByF_O_T_L_S;
				finderArgs = new Object[] {
					groupId, typeId, organizationId, fieldId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocsByF_O_T_L_S;
			finderArgs = new Object[] {
				groupId, typeId, organizationId, fieldId, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(typeId != legalDocument.getTypeId()) ||
						(organizationId != legalDocument.getOrganizationId()) ||
						(fieldId != legalDocument.getFieldId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(typeId);

				qPos.add(organizationId);

				qPos.add(fieldId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByF_O_T_L_S_First(
			long groupId, long typeId, long organizationId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByF_O_T_L_S_First(
			groupId, typeId, organizationId, fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByF_O_T_L_S_First(
		long groupId, long typeId, long organizationId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByF_O_T_L_S_Last(
			long groupId, long typeId, long organizationId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByF_O_T_L_S_Last(
			groupId, typeId, organizationId, fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByF_O_T_L_S_Last(
		long groupId, long typeId, long organizationId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDocsByF_O_T_L_S(
			groupId, typeId, organizationId, fieldId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDocsByF_O_T_L_S_PrevAndNext(
			long docId, long groupId, long typeId, long organizationId,
			long fieldId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDocsByF_O_T_L_S_PrevAndNext(
				session, legalDocument, groupId, typeId, organizationId,
				fieldId, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByDocsByF_O_T_L_S_PrevAndNext(
				session, legalDocument, groupId, typeId, organizationId,
				fieldId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByDocsByF_O_T_L_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId, long typeId,
		long organizationId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_GROUPID_2);

		query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_TYPEID_2);

		query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_FIELDID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(typeId);

		qPos.add(organizationId);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId) {

		for (LegalDocument legalDocument :
				findByDocsByF_O_T_L_S(
					groupId, typeId, organizationId, fieldId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and typeId = &#63; and organizationId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param typeId the type ID
	 * @param organizationId the organization ID
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDocsByF_O_T_L_S(
		long groupId, long typeId, long organizationId, long fieldId) {

		FinderPath finderPath = _finderPathCountByDocsByF_O_T_L_S;

		Object[] finderArgs = new Object[] {
			groupId, typeId, organizationId, fieldId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_DOCSBYF_O_T_L_S_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(typeId);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_DOCSBYF_O_T_L_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYF_O_T_L_S_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCSBYF_O_T_L_S_ORGANIZATIONID_2 =
			"legalDocument.organizationId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYF_O_T_L_S_FIELDID_2 =
		"legalDocument.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByDocsByG_O_T_L_S;
	private FinderPath _finderPathWithoutPaginationFindByDocsByG_O_T_L_S;
	private FinderPath _finderPathCountByDocsByG_O_T_L_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc) {

		return findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end) {

		return findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocsByG_O_T_L_S;
				finderArgs = new Object[] {
					groupId, organizationId, typeId, language, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocsByG_O_T_L_S;
			finderArgs = new Object[] {
				groupId, organizationId, typeId, language, statusDoc, start,
				end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(organizationId != legalDocument.getOrganizationId()) ||
						(typeId != legalDocument.getTypeId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_TYPEID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(organizationId);

				qPos.add(typeId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByG_O_T_L_S_First(
			long groupId, long organizationId, long typeId, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByG_O_T_L_S_First(
			groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByG_O_T_L_S_First(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByG_O_T_L_S_Last(
			long groupId, long organizationId, long typeId, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByG_O_T_L_S_Last(
			groupId, organizationId, typeId, language, statusDoc,
			orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByG_O_T_L_S_Last(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDocsByG_O_T_L_S(
			groupId, organizationId, typeId, language, statusDoc, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDocsByG_O_T_L_S_PrevAndNext(
			long docId, long groupId, long organizationId, long typeId,
			String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDocsByG_O_T_L_S_PrevAndNext(
				session, legalDocument, groupId, organizationId, typeId,
				language, statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByDocsByG_O_T_L_S_PrevAndNext(
				session, legalDocument, groupId, organizationId, typeId,
				language, statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByDocsByG_O_T_L_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long organizationId, long typeId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(7);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_GROUPID_2);

		query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_TYPEID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(organizationId);

		qPos.add(typeId);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc) {

		for (LegalDocument legalDocument :
				findByDocsByG_O_T_L_S(
					groupId, organizationId, typeId, language, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and organizationId = &#63; and typeId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDocsByG_O_T_L_S(
		long groupId, long organizationId, long typeId, String language,
		int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByDocsByG_O_T_L_S;

		Object[] finderArgs = new Object[] {
			groupId, organizationId, typeId, language, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_GROUPID_2);

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_TYPEID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_DOCSBYG_O_T_L_S_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(organizationId);

				qPos.add(typeId);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_DOCSBYG_O_T_L_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_DOCSBYG_O_T_L_S_ORGANIZATIONID_2 =
			"legalDocument.organizationId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYG_O_T_L_S_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYG_O_T_L_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_DOCSBYG_O_T_L_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByDocsByO_T_F_S;
	private FinderPath _finderPathWithoutPaginationFindByDocsByO_T_F_S;
	private FinderPath _finderPathCountByDocsByO_T_F_S;

	/**
	 * Returns all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc) {

		return findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end) {

		return findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc,
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocsByO_T_F_S;
				finderArgs = new Object[] {
					organizationId, typeId, fieldId, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocsByO_T_F_S;
			finderArgs = new Object[] {
				organizationId, typeId, fieldId, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((organizationId != legalDocument.getOrganizationId()) ||
						(typeId != legalDocument.getTypeId()) ||
						(fieldId != legalDocument.getFieldId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_FIELDID_2);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(typeId);

				qPos.add(fieldId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByO_T_F_S_First(
			long organizationId, long typeId, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByO_T_F_S_First(
			organizationId, typeId, fieldId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByO_T_F_S_First(
		long organizationId, long typeId, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByO_T_F_S_Last(
			long organizationId, long typeId, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByO_T_F_S_Last(
			organizationId, typeId, fieldId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByO_T_F_S_Last(
		long organizationId, long typeId, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDocsByO_T_F_S(
			organizationId, typeId, fieldId, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDocsByO_T_F_S_PrevAndNext(
			long docId, long organizationId, long typeId, long fieldId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDocsByO_T_F_S_PrevAndNext(
				session, legalDocument, organizationId, typeId, fieldId,
				statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByDocsByO_T_F_S_PrevAndNext(
				session, legalDocument, organizationId, typeId, fieldId,
				statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByDocsByO_T_F_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long organizationId,
		long typeId, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_TYPEID_2);

		query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_FIELDID_2);

		query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(typeId);

		qPos.add(fieldId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByDocsByO_T_F_S(
					organizationId, typeId, fieldId, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where organizationId = &#63; and typeId = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param typeId the type ID
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDocsByO_T_F_S(
		long organizationId, long typeId, long fieldId, int statusDoc) {

		FinderPath finderPath = _finderPathCountByDocsByO_T_F_S;

		Object[] finderArgs = new Object[] {
			organizationId, typeId, fieldId, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_FIELDID_2);

			query.append(_FINDER_COLUMN_DOCSBYO_T_F_S_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(typeId);

				qPos.add(fieldId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_DOCSBYO_T_F_S_ORGANIZATIONID_2 =
		"legalDocument.organizationId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYO_T_F_S_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYO_T_F_S_FIELDID_2 =
		"legalDocument.fieldId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYO_T_F_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByDocsByPromulDate;
	private FinderPath _finderPathWithoutPaginationFindByDocsByPromulDate;
	private FinderPath _finderPathCountByDocsByPromulDate;

	/**
	 * Returns all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc) {

		return findByDocsByPromulDate(
			typeId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end) {

		return findByDocsByPromulDate(typeId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDocsByPromulDate(
			typeId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByPromulDate(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocsByPromulDate;
				finderArgs = new Object[] {typeId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocsByPromulDate;
			finderArgs = new Object[] {
				typeId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((typeId != legalDocument.getTypeId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYPROMULDATE_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCSBYPROMULDATE_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByPromulDate_First(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByPromulDate_First(
			typeId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByPromulDate_First(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDocsByPromulDate(
			typeId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByPromulDate_Last(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByPromulDate_Last(
			typeId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByPromulDate_Last(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDocsByPromulDate(typeId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDocsByPromulDate(
			typeId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDocsByPromulDate_PrevAndNext(
			long docId, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDocsByPromulDate_PrevAndNext(
				session, legalDocument, typeId, statusDoc, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByDocsByPromulDate_PrevAndNext(
				session, legalDocument, typeId, statusDoc, orderByComparator,
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

	protected LegalDocument getByDocsByPromulDate_PrevAndNext(
		Session session, LegalDocument legalDocument, long typeId,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOCSBYPROMULDATE_TYPEID_2);

		query.append(_FINDER_COLUMN_DOCSBYPROMULDATE_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByDocsByPromulDate(long typeId, int statusDoc) {
		for (LegalDocument legalDocument :
				findByDocsByPromulDate(
					typeId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDocsByPromulDate(long typeId, int statusDoc) {
		FinderPath finderPath = _finderPathCountByDocsByPromulDate;

		Object[] finderArgs = new Object[] {typeId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYPROMULDATE_TYPEID_2);

			query.append(_FINDER_COLUMN_DOCSBYPROMULDATE_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_DOCSBYPROMULDATE_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYPROMULDATE_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByDoc_Org;
	private FinderPath _finderPathWithoutPaginationFindByDoc_Org;
	private FinderPath _finderPathCountByDoc_Org;

	/**
	 * Returns all the legal documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Org(long organizationId) {
		return findByDoc_Org(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end) {

		return findByDoc_Org(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDoc_Org(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Org(
		long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDoc_Org;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDoc_Org;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (organizationId != legalDocument.getOrganizationId()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_ORG_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDoc_Org_First(
			long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDoc_Org_First(
			organizationId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDoc_Org_First(
		long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDoc_Org(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDoc_Org_Last(
			long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDoc_Org_Last(
			organizationId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDoc_Org_Last(
		long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDoc_Org(organizationId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDoc_Org(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDoc_Org_PrevAndNext(
			long docId, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDoc_Org_PrevAndNext(
				session, legalDocument, organizationId, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByDoc_Org_PrevAndNext(
				session, legalDocument, organizationId, orderByComparator,
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

	protected LegalDocument getByDoc_Org_PrevAndNext(
		Session session, LegalDocument legalDocument, long organizationId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOC_ORG_ORGANIZATIONID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByDoc_Org(long organizationId) {
		for (LegalDocument legalDocument :
				findByDoc_Org(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDoc_Org(long organizationId) {
		FinderPath finderPath = _finderPathCountByDoc_Org;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_ORG_ORGANIZATIONID_2);

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

	private static final String _FINDER_COLUMN_DOC_ORG_ORGANIZATIONID_2 =
		"legalDocument.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByDoc_Category;
	private FinderPath _finderPathWithoutPaginationFindByDoc_Category;
	private FinderPath _finderPathCountByDoc_Category;

	/**
	 * Returns all the legal documents where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Category(long typeId) {
		return findByDoc_Category(
			typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end) {

		return findByDoc_Category(typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDoc_Category(typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Category(
		long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDoc_Category;
				finderArgs = new Object[] {typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDoc_Category;
			finderArgs = new Object[] {typeId, start, end, orderByComparator};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (typeId != legalDocument.getTypeId()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_CATEGORY_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDoc_Category_First(
			long typeId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDoc_Category_First(
			typeId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDoc_Category_First(
		long typeId, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDoc_Category(
			typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDoc_Category_Last(
			long typeId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDoc_Category_Last(
			typeId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDoc_Category_Last(
		long typeId, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDoc_Category(typeId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDoc_Category(
			typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDoc_Category_PrevAndNext(
			long docId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDoc_Category_PrevAndNext(
				session, legalDocument, typeId, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByDoc_Category_PrevAndNext(
				session, legalDocument, typeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByDoc_Category_PrevAndNext(
		Session session, LegalDocument legalDocument, long typeId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOC_CATEGORY_TYPEID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	@Override
	public void removeByDoc_Category(long typeId) {
		for (LegalDocument legalDocument :
				findByDoc_Category(
					typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDoc_Category(long typeId) {
		FinderPath finderPath = _finderPathCountByDoc_Category;

		Object[] finderArgs = new Object[] {typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_CATEGORY_TYPEID_2);

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

	private static final String _FINDER_COLUMN_DOC_CATEGORY_TYPEID_2 =
		"legalDocument.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByDoc_Field;
	private FinderPath _finderPathWithoutPaginationFindByDoc_Field;
	private FinderPath _finderPathCountByDoc_Field;

	/**
	 * Returns all the legal documents where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Field(long fieldId) {
		return findByDoc_Field(
			fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end) {

		return findByDoc_Field(fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDoc_Field(fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDoc_Field(
		long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDoc_Field;
				finderArgs = new Object[] {fieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDoc_Field;
			finderArgs = new Object[] {fieldId, start, end, orderByComparator};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (fieldId != legalDocument.getFieldId()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_FIELD_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDoc_Field_First(
			long fieldId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDoc_Field_First(
			fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDoc_Field_First(
		long fieldId, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDoc_Field(
			fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDoc_Field_Last(
			long fieldId, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDoc_Field_Last(
			fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDoc_Field_Last(
		long fieldId, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDoc_Field(fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDoc_Field(
			fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDoc_Field_PrevAndNext(
			long docId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDoc_Field_PrevAndNext(
				session, legalDocument, fieldId, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByDoc_Field_PrevAndNext(
				session, legalDocument, fieldId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByDoc_Field_PrevAndNext(
		Session session, LegalDocument legalDocument, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOC_FIELD_FIELDID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByDoc_Field(long fieldId) {
		for (LegalDocument legalDocument :
				findByDoc_Field(
					fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDoc_Field(long fieldId) {
		FinderPath finderPath = _finderPathCountByDoc_Field;

		Object[] finderArgs = new Object[] {fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOC_FIELD_FIELDID_2);

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

	private static final String _FINDER_COLUMN_DOC_FIELD_FIELDID_2 =
		"legalDocument.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByDocsByT_L;
	private FinderPath _finderPathWithoutPaginationFindByDocsByT_L;
	private FinderPath _finderPathCountByDocsByT_L;

	/**
	 * Returns all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByT_L(long typeId, String language) {
		return findByDocsByT_L(
			typeId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end) {

		return findByDocsByT_L(typeId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByDocsByT_L(
			typeId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByDocsByT_L(
		long typeId, String language, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocsByT_L;
				finderArgs = new Object[] {typeId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocsByT_L;
			finderArgs = new Object[] {
				typeId, language, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((typeId != legalDocument.getTypeId()) ||
						!language.equals(legalDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYT_L_TYPEID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCSBYT_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_DOCSBYT_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByT_L_First(
			long typeId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByT_L_First(
			typeId, language, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByT_L_First(
		long typeId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByDocsByT_L(
			typeId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByDocsByT_L_Last(
			long typeId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByDocsByT_L_Last(
			typeId, language, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByDocsByT_L_Last(
		long typeId, String language,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByDocsByT_L(typeId, language);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByDocsByT_L(
			typeId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63; and language = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByDocsByT_L_PrevAndNext(
			long docId, long typeId, String language,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByDocsByT_L_PrevAndNext(
				session, legalDocument, typeId, language, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByDocsByT_L_PrevAndNext(
				session, legalDocument, typeId, language, orderByComparator,
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

	protected LegalDocument getByDocsByT_L_PrevAndNext(
		Session session, LegalDocument legalDocument, long typeId,
		String language, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DOCSBYT_L_TYPEID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_DOCSBYT_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_DOCSBYT_L_LANGUAGE_2);
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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where typeId = &#63; and language = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 */
	@Override
	public void removeByDocsByT_L(long typeId, String language) {
		for (LegalDocument legalDocument :
				findByDocsByT_L(
					typeId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where typeId = &#63; and language = &#63;.
	 *
	 * @param typeId the type ID
	 * @param language the language
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByDocsByT_L(long typeId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByDocsByT_L;

		Object[] finderArgs = new Object[] {typeId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DOCSBYT_L_TYPEID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCSBYT_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_DOCSBYT_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

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

	private static final String _FINDER_COLUMN_DOCSBYT_L_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String _FINDER_COLUMN_DOCSBYT_L_LANGUAGE_2 =
		"legalDocument.language = ?";

	private static final String _FINDER_COLUMN_DOCSBYT_L_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_L_U_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_U_S;
	private FinderPath _finderPathCountByG_L_U_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc) {

		return findByG_L_U_S(
			groupId, language, userId, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end) {

		return findByG_L_U_S(
			groupId, language, userId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_U_S(
			groupId, language, userId, statusDoc, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_U_S(
		long groupId, String language, long userId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_U_S;
				finderArgs = new Object[] {
					groupId, language, userId, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_U_S;
			finderArgs = new Object[] {
				groupId, language, userId, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(userId != legalDocument.getUserId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_U_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_U_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_U_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_U_S_USERID_2);

			query.append(_FINDER_COLUMN_G_L_U_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(userId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_U_S_First(
			long groupId, String language, long userId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_U_S_First(
			groupId, language, userId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_U_S_First(
		long groupId, String language, long userId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_U_S(
			groupId, language, userId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_U_S_Last(
			long groupId, String language, long userId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_U_S_Last(
			groupId, language, userId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_U_S_Last(
		long groupId, String language, long userId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_U_S(groupId, language, userId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_U_S(
			groupId, language, userId, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_U_S_PrevAndNext(
			long docId, long groupId, String language, long userId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_U_S_PrevAndNext(
				session, legalDocument, groupId, language, userId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_U_S_PrevAndNext(
				session, legalDocument, groupId, language, userId, statusDoc,
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

	protected LegalDocument getByG_L_U_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long userId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_U_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_U_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_U_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_U_S_USERID_2);

		query.append(_FINDER_COLUMN_G_L_U_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(userId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByG_L_U_S(
		long groupId, String language, long userId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByG_L_U_S(
					groupId, language, userId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and userId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param userId the user ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_U_S(
		long groupId, String language, long userId, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_U_S;

		Object[] finderArgs = new Object[] {
			groupId, language, userId, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_U_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_U_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_U_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_U_S_USERID_2);

			query.append(_FINDER_COLUMN_G_L_U_S_STATUSDOC_2);

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

				qPos.add(userId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_G_L_U_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_U_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_U_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_U_S_USERID_2 =
		"legalDocument.userId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_U_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathFetchByG_D;
	private FinderPath _finderPathCountByG_D;

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_D(long groupId, long docId)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_D(groupId, docId);

		if (legalDocument == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", docId=");
			msg.append(docId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDocumentException(msg.toString());
		}

		return legalDocument;
	}

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_D(long groupId, long docId) {
		return fetchByG_D(groupId, docId, true);
	}

	/**
	 * Returns the legal document where groupId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_D(
		long groupId, long docId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, docId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_D, finderArgs, this);
		}

		if (result instanceof LegalDocument) {
			LegalDocument legalDocument = (LegalDocument)result;

			if ((groupId != legalDocument.getGroupId()) ||
				(docId != legalDocument.getDocId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(docId);

				List<LegalDocument> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_D, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, docId};
							}

							_log.warn(
								"LegalDocumentPersistenceImpl.fetchByG_D(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDocument legalDocument = list.get(0);

					result = legalDocument;

					cacheResult(legalDocument);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_D, finderArgs);
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
			return (LegalDocument)result;
		}
	}

	/**
	 * Removes the legal document where groupId = &#63; and docId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the legal document that was removed
	 */
	@Override
	public LegalDocument removeByG_D(long groupId, long docId)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByG_D(groupId, docId);

		return remove(legalDocument);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param docId the doc ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_D(long groupId, long docId) {
		FinderPath finderPath = _finderPathCountByG_D;

		Object[] finderArgs = new Object[] {groupId, docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_D_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_D_DOCID_2 =
		"legalDocument.docId = ?";

	private FinderPath _finderPathFetchByP_N_S;
	private FinderPath _finderPathCountByP_N_S;

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByP_N_S(long groupId, String num, String symbol)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByP_N_S(groupId, num, symbol);

		if (legalDocument == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", num=");
			msg.append(num);

			msg.append(", symbol=");
			msg.append(symbol);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDocumentException(msg.toString());
		}

		return legalDocument;
	}

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByP_N_S(long groupId, String num, String symbol) {
		return fetchByP_N_S(groupId, num, symbol, true);
	}

	/**
	 * Returns the legal document where groupId = &#63; and num = &#63; and symbol = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByP_N_S(
		long groupId, String num, String symbol, boolean useFinderCache) {

		num = Objects.toString(num, "");
		symbol = Objects.toString(symbol, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, num, symbol};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByP_N_S, finderArgs, this);
		}

		if (result instanceof LegalDocument) {
			LegalDocument legalDocument = (LegalDocument)result;

			if ((groupId != legalDocument.getGroupId()) ||
				!Objects.equals(num, legalDocument.getNum()) ||
				!Objects.equals(symbol, legalDocument.getSymbol())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_N_S_GROUPID_2);

			boolean bindNum = false;

			if (num.isEmpty()) {
				query.append(_FINDER_COLUMN_P_N_S_NUM_3);
			}
			else {
				bindNum = true;

				query.append(_FINDER_COLUMN_P_N_S_NUM_2);
			}

			boolean bindSymbol = false;

			if (symbol.isEmpty()) {
				query.append(_FINDER_COLUMN_P_N_S_SYMBOL_3);
			}
			else {
				bindSymbol = true;

				query.append(_FINDER_COLUMN_P_N_S_SYMBOL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindNum) {
					qPos.add(num);
				}

				if (bindSymbol) {
					qPos.add(symbol);
				}

				List<LegalDocument> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByP_N_S, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, num, symbol
								};
							}

							_log.warn(
								"LegalDocumentPersistenceImpl.fetchByP_N_S(long, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDocument legalDocument = list.get(0);

					result = legalDocument;

					cacheResult(legalDocument);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByP_N_S, finderArgs);
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
			return (LegalDocument)result;
		}
	}

	/**
	 * Removes the legal document where groupId = &#63; and num = &#63; and symbol = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the legal document that was removed
	 */
	@Override
	public LegalDocument removeByP_N_S(long groupId, String num, String symbol)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByP_N_S(groupId, num, symbol);

		return remove(legalDocument);
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and num = &#63; and symbol = &#63;.
	 *
	 * @param groupId the group ID
	 * @param num the num
	 * @param symbol the symbol
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByP_N_S(long groupId, String num, String symbol) {
		num = Objects.toString(num, "");
		symbol = Objects.toString(symbol, "");

		FinderPath finderPath = _finderPathCountByP_N_S;

		Object[] finderArgs = new Object[] {groupId, num, symbol};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_N_S_GROUPID_2);

			boolean bindNum = false;

			if (num.isEmpty()) {
				query.append(_FINDER_COLUMN_P_N_S_NUM_3);
			}
			else {
				bindNum = true;

				query.append(_FINDER_COLUMN_P_N_S_NUM_2);
			}

			boolean bindSymbol = false;

			if (symbol.isEmpty()) {
				query.append(_FINDER_COLUMN_P_N_S_SYMBOL_3);
			}
			else {
				bindSymbol = true;

				query.append(_FINDER_COLUMN_P_N_S_SYMBOL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindNum) {
					qPos.add(num);
				}

				if (bindSymbol) {
					qPos.add(symbol);
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

	private static final String _FINDER_COLUMN_P_N_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_N_S_NUM_2 =
		"legalDocument.num = ? AND ";

	private static final String _FINDER_COLUMN_P_N_S_NUM_3 =
		"(legalDocument.num IS NULL OR legalDocument.num = '') AND ";

	private static final String _FINDER_COLUMN_P_N_S_SYMBOL_2 =
		"legalDocument.symbol = ?";

	private static final String _FINDER_COLUMN_P_N_S_SYMBOL_3 =
		"(legalDocument.symbol IS NULL OR legalDocument.symbol = '')";

	private FinderPath _finderPathWithPaginationFindByP_L_S;
	private FinderPath _finderPathWithoutPaginationFindByP_L_S;
	private FinderPath _finderPathCountByP_L_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc) {

		return findByP_L_S(
			groupId, language, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end) {

		return findByP_L_S(groupId, language, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByP_L_S(
			groupId, language, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_L_S(
		long groupId, String language, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_L_S;
				finderArgs = new Object[] {groupId, language, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_L_S;
			finderArgs = new Object[] {
				groupId, language, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_L_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_P_L_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByP_L_S_First(
			long groupId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByP_L_S_First(
			groupId, language, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByP_L_S_First(
		long groupId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByP_L_S(
			groupId, language, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByP_L_S_Last(
			long groupId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByP_L_S_Last(
			groupId, language, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByP_L_S_Last(
		long groupId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByP_L_S(groupId, language, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByP_L_S(
			groupId, language, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByP_L_S_PrevAndNext(
			long docId, long groupId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByP_L_S_PrevAndNext(
				session, legalDocument, groupId, language, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByP_L_S_PrevAndNext(
				session, legalDocument, groupId, language, statusDoc,
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

	protected LegalDocument getByP_L_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_L_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_P_L_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_P_L_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_P_L_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByP_L_S(long groupId, String language, int statusDoc) {
		for (LegalDocument legalDocument :
				findByP_L_S(
					groupId, language, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByP_L_S(long groupId, String language, int statusDoc) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByP_L_S;

		Object[] finderArgs = new Object[] {groupId, language, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_L_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_P_L_S_STATUSDOC_2);

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

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_P_L_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_L_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_P_L_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_P_L_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_P_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_P_S;
	private FinderPath _finderPathCountByG_L_P_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc) {

		return findByG_L_P_S(
			groupId, language, isPublic, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end) {

		return findByG_L_P_S(
			groupId, language, isPublic, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_P_S(
			groupId, language, isPublic, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_P_S;
				finderArgs = new Object[] {
					groupId, language, isPublic, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_P_S;
			finderArgs = new Object[] {
				groupId, language, isPublic, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_P_S_ISPUBLIC_2);

			query.append(_FINDER_COLUMN_G_L_P_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_P_S_First(
			long groupId, String language, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_P_S_First(
			groupId, language, isPublic, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_P_S_First(
		long groupId, String language, int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_P_S(
			groupId, language, isPublic, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_P_S_Last(
			long groupId, String language, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_P_S_Last(
			groupId, language, isPublic, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_P_S_Last(
		long groupId, String language, int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_P_S(groupId, language, isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_P_S(
			groupId, language, isPublic, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_P_S_PrevAndNext(
			long docId, long groupId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_P_S_PrevAndNext(
				session, legalDocument, groupId, language, isPublic, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_P_S_PrevAndNext(
				session, legalDocument, groupId, language, isPublic, statusDoc,
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

	protected LegalDocument getByG_L_P_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_P_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_P_S_ISPUBLIC_2);

		query.append(_FINDER_COLUMN_G_L_P_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc) {

		for (LegalDocument legalDocument :
				findByG_L_P_S(
					groupId, language, isPublic, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_P_S(
		long groupId, String language, int isPublic, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_P_S;

		Object[] finderArgs = new Object[] {
			groupId, language, isPublic, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_P_S_ISPUBLIC_2);

			query.append(_FINDER_COLUMN_G_L_P_S_STATUSDOC_2);

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

				qPos.add(isPublic);

				qPos.add(statusDoc);

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
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_ISPUBLIC_2 =
		"legalDocument.isPublic = ? AND ";

	private static final String _FINDER_COLUMN_G_L_P_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindBystatusDoc;
	private FinderPath _finderPathWithoutPaginationFindBystatusDoc;
	private FinderPath _finderPathCountBystatusDoc;

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findBystatusDoc(int statusDoc) {
		return findBystatusDoc(
			statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end) {

		return findBystatusDoc(statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findBystatusDoc(statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findBystatusDoc(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystatusDoc;
				finderArgs = new Object[] {statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystatusDoc;
			finderArgs = new Object[] {
				statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (statusDoc != legalDocument.getStatusDoc()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUSDOC_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findBystatusDoc_First(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchBystatusDoc_First(
			statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchBystatusDoc_First(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findBystatusDoc(
			statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findBystatusDoc_Last(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchBystatusDoc_Last(
			statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchBystatusDoc_Last(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countBystatusDoc(statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findBystatusDoc(
			statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findBystatusDoc_PrevAndNext(
			long docId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getBystatusDoc_PrevAndNext(
				session, legalDocument, statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getBystatusDoc_PrevAndNext(
				session, legalDocument, statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getBystatusDoc_PrevAndNext(
		Session session, LegalDocument legalDocument, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_STATUSDOC_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeBystatusDoc(int statusDoc) {
		for (LegalDocument legalDocument :
				findBystatusDoc(
					statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countBystatusDoc(int statusDoc) {
		FinderPath finderPath = _finderPathCountBystatusDoc;

		Object[] finderArgs = new Object[] {statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUSDOC_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_STATUSDOC_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_O_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_O_S;
	private FinderPath _finderPathCountByG_L_O_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc) {

		return findByG_L_O_S(
			groupId, language, organizationId, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end) {

		return findByG_L_O_S(
			groupId, language, organizationId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_O_S(
			groupId, language, organizationId, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc,
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_O_S;
				finderArgs = new Object[] {
					groupId, language, organizationId, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_O_S;
			finderArgs = new Object[] {
				groupId, language, organizationId, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(organizationId != legalDocument.getOrganizationId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_O_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_O_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_O_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_O_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_G_L_O_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(organizationId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_O_S_First(
			long groupId, String language, long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_O_S_First(
			groupId, language, organizationId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_O_S_First(
		long groupId, String language, long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_O_S(
			groupId, language, organizationId, statusDoc, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_O_S_Last(
			long groupId, String language, long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_O_S_Last(
			groupId, language, organizationId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_O_S_Last(
		long groupId, String language, long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_O_S(
			groupId, language, organizationId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_O_S(
			groupId, language, organizationId, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_O_S_PrevAndNext(
			long docId, long groupId, String language, long organizationId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_O_S_PrevAndNext(
				session, legalDocument, groupId, language, organizationId,
				statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_O_S_PrevAndNext(
				session, legalDocument, groupId, language, organizationId,
				statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByG_L_O_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_O_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_O_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_O_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_O_S_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_G_L_O_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(organizationId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByG_L_O_S(
					groupId, language, organizationId, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_O_S(
		long groupId, String language, long organizationId, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_O_S;

		Object[] finderArgs = new Object[] {
			groupId, language, organizationId, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_O_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_O_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_O_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_O_S_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_G_L_O_S_STATUSDOC_2);

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

				qPos.add(organizationId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_G_L_O_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_O_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_O_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_O_S_ORGANIZATIONID_2 =
		"legalDocument.organizationId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_O_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_T_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_T_S;
	private FinderPath _finderPathCountByG_L_T_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc) {

		return findByG_L_T_S(
			groupId, language, typeId, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end) {

		return findByG_L_T_S(
			groupId, language, typeId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_T_S(
			groupId, language, typeId, statusDoc, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_T_S;
				finderArgs = new Object[] {
					groupId, language, typeId, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_T_S;
			finderArgs = new Object[] {
				groupId, language, typeId, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(typeId != legalDocument.getTypeId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_T_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_T_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_T_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_T_S_TYPEID_2);

			query.append(_FINDER_COLUMN_G_L_T_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(typeId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_T_S_First(
			long groupId, String language, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_T_S_First(
			groupId, language, typeId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_T_S_First(
		long groupId, String language, long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_T_S(
			groupId, language, typeId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_T_S_Last(
			long groupId, String language, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_T_S_Last(
			groupId, language, typeId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_T_S_Last(
		long groupId, String language, long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_T_S(groupId, language, typeId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_T_S(
			groupId, language, typeId, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_T_S_PrevAndNext(
			long docId, long groupId, String language, long typeId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_T_S_PrevAndNext(
				session, legalDocument, groupId, language, typeId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_T_S_PrevAndNext(
				session, legalDocument, groupId, language, typeId, statusDoc,
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

	protected LegalDocument getByG_L_T_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_T_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_T_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_T_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_T_S_TYPEID_2);

		query.append(_FINDER_COLUMN_G_L_T_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(typeId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByG_L_T_S(
					groupId, language, typeId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_T_S(
		long groupId, String language, long typeId, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_T_S;

		Object[] finderArgs = new Object[] {
			groupId, language, typeId, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_T_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_T_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_T_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_T_S_TYPEID_2);

			query.append(_FINDER_COLUMN_G_L_T_S_STATUSDOC_2);

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

				qPos.add(typeId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_G_L_T_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_T_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_T_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_T_S_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_T_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_F_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_F_S;
	private FinderPath _finderPathCountByG_L_F_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc) {

		return findByG_L_F_S(
			groupId, language, fieldId, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end) {

		return findByG_L_F_S(
			groupId, language, fieldId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_F_S(
			groupId, language, fieldId, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_F_S;
				finderArgs = new Object[] {
					groupId, language, fieldId, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_F_S;
			finderArgs = new Object[] {
				groupId, language, fieldId, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(fieldId != legalDocument.getFieldId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_F_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_F_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_F_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_F_S_FIELDID_2);

			query.append(_FINDER_COLUMN_G_L_F_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(fieldId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_F_S_First(
			long groupId, String language, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_F_S_First(
			groupId, language, fieldId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_F_S_First(
		long groupId, String language, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_F_S(
			groupId, language, fieldId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_F_S_Last(
			long groupId, String language, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_F_S_Last(
			groupId, language, fieldId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_F_S_Last(
		long groupId, String language, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_F_S(groupId, language, fieldId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_F_S(
			groupId, language, fieldId, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_F_S_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_F_S_PrevAndNext(
				session, legalDocument, groupId, language, fieldId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_F_S_PrevAndNext(
				session, legalDocument, groupId, language, fieldId, statusDoc,
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

	protected LegalDocument getByG_L_F_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_F_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_F_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_F_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_F_S_FIELDID_2);

		query.append(_FINDER_COLUMN_G_L_F_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(fieldId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByG_L_F_S(
					groupId, language, fieldId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_F_S(
		long groupId, String language, long fieldId, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_F_S;

		Object[] finderArgs = new Object[] {
			groupId, language, fieldId, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_F_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_F_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_F_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_F_S_FIELDID_2);

			query.append(_FINDER_COLUMN_G_L_F_S_STATUSDOC_2);

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

				qPos.add(fieldId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_G_L_F_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_F_S_FIELDID_2 =
		"legalDocument.fieldId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_F_P_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_F_P_S;
	private FinderPath _finderPathCountByG_L_F_P_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc) {

		return findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end) {

		return findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_F_P_S;
				finderArgs = new Object[] {
					groupId, language, fieldId, isPublic, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_F_P_S;
			finderArgs = new Object[] {
				groupId, language, fieldId, isPublic, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(fieldId != legalDocument.getFieldId()) ||
						(isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_F_P_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_F_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_F_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_F_P_S_FIELDID_2);

			query.append(_FINDER_COLUMN_G_L_F_P_S_ISPUBLIC_2);

			query.append(_FINDER_COLUMN_G_L_F_P_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(fieldId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_F_P_S_First(
			long groupId, String language, long fieldId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_F_P_S_First(
			groupId, language, fieldId, isPublic, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_F_P_S_First(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_F_P_S_Last(
			long groupId, String language, long fieldId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_F_P_S_Last(
			groupId, language, fieldId, isPublic, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_F_P_S_Last(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_F_P_S(
			groupId, language, fieldId, isPublic, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_F_P_S_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_F_P_S_PrevAndNext(
				session, legalDocument, groupId, language, fieldId, isPublic,
				statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_F_P_S_PrevAndNext(
				session, legalDocument, groupId, language, fieldId, isPublic,
				statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByG_L_F_P_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long fieldId, int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(7);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_F_P_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_F_P_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_F_P_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_F_P_S_FIELDID_2);

		query.append(_FINDER_COLUMN_G_L_F_P_S_ISPUBLIC_2);

		query.append(_FINDER_COLUMN_G_L_F_P_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(fieldId);

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc) {

		for (LegalDocument legalDocument :
				findByG_L_F_P_S(
					groupId, language, fieldId, isPublic, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_F_P_S(
		long groupId, String language, long fieldId, int isPublic,
		int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_F_P_S;

		Object[] finderArgs = new Object[] {
			groupId, language, fieldId, isPublic, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_F_P_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_F_P_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_F_P_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_F_P_S_FIELDID_2);

			query.append(_FINDER_COLUMN_G_L_F_P_S_ISPUBLIC_2);

			query.append(_FINDER_COLUMN_G_L_F_P_S_STATUSDOC_2);

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

				qPos.add(fieldId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_G_L_F_P_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_P_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_P_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_F_P_S_FIELDID_2 =
		"legalDocument.fieldId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_P_S_ISPUBLIC_2 =
		"legalDocument.isPublic = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_P_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Company_Language_Field_Public_Status;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status;
	private FinderPath
		_finderPathCountByGroup_Company_Language_Field_Public_Status;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc) {

		return findByGroup_Company_Language_Field_Public_Status(
			groupId, companyId, language, fieldId, isPublic, statusDoc,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc, int start, int end) {

		return findByGroup_Company_Language_Field_Public_Status(
			groupId, companyId, language, fieldId, isPublic, statusDoc, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroup_Company_Language_Field_Public_Status(
			groupId, companyId, language, fieldId, isPublic, statusDoc, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status;
				finderArgs = new Object[] {
					groupId, companyId, language, fieldId, isPublic, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Company_Language_Field_Public_Status;
			finderArgs = new Object[] {
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(fieldId != legalDocument.getFieldId()) ||
						(isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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
					8 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_FIELDID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(fieldId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Field_Public_Status_First(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Field_Public_Status_First(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument
		fetchByGroup_Company_Language_Field_Public_Status_First(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list =
			findByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Field_Public_Status_Last(
			long groupId, long companyId, String language, long fieldId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Field_Public_Status_Last(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Field_Public_Status_Last(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroup_Company_Language_Field_Public_Status(
			groupId, companyId, language, fieldId, isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list =
			findByGroup_Company_Language_Field_Public_Status(
				groupId, companyId, language, fieldId, isPublic, statusDoc,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[]
			findByGroup_Company_Language_Field_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long fieldId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] =
				getByGroup_Company_Language_Field_Public_Status_PrevAndNext(
					session, legalDocument, groupId, companyId, language,
					fieldId, isPublic, statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] =
				getByGroup_Company_Language_Field_Public_Status_PrevAndNext(
					session, legalDocument, groupId, companyId, language,
					fieldId, isPublic, statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument
		getByGroup_Company_Language_Field_Public_Status_PrevAndNext(
			Session session, LegalDocument legalDocument, long groupId,
			long companyId, String language, long fieldId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
			boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				9 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(8);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_GROUPID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_2);
		}

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_FIELDID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_ISPUBLIC_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(fieldId);

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc) {

		for (LegalDocument legalDocument :
				findByGroup_Company_Language_Field_Public_Status(
					groupId, companyId, language, fieldId, isPublic, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and fieldId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroup_Company_Language_Field_Public_Status(
		long groupId, long companyId, String language, long fieldId,
		int isPublic, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath =
			_finderPathCountByGroup_Company_Language_Field_Public_Status;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, fieldId, isPublic, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_FIELDID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_STATUSDOC_2);

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

				qPos.add(fieldId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

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
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_GROUPID_2 =
			"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_COMPANYID_2 =
			"legalDocument.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_2 =
			"legalDocument.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_LANGUAGE_3 =
			"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_FIELDID_2 =
			"legalDocument.fieldId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_ISPUBLIC_2 =
			"legalDocument.isPublic = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_FIELD_PUBLIC_STATUS_STATUSDOC_2 =
			"legalDocument.statusDoc = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Company_Language_Org_Public_Status;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status;
	private FinderPath
		_finderPathCountByGroup_Company_Language_Org_Public_Status;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc) {

		return findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc, int start, int end) {

		return findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status;
				finderArgs = new Object[] {
					groupId, companyId, language, organizationId, isPublic,
					statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Company_Language_Org_Public_Status;
			finderArgs = new Object[] {
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(organizationId != legalDocument.getOrganizationId()) ||
						(isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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
					8 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ORGANIZATIONID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(organizationId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Org_Public_Status_First(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Org_Public_Status_First(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Org_Public_Status_First(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list =
			findByGroup_Company_Language_Org_Public_Status(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Org_Public_Status_Last(
			long groupId, long companyId, String language, long organizationId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Org_Public_Status_Last(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Org_Public_Status_Last(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroup_Company_Language_Org_Public_Status(
			groupId, companyId, language, organizationId, isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list =
			findByGroup_Company_Language_Org_Public_Status(
				groupId, companyId, language, organizationId, isPublic,
				statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[]
			findByGroup_Company_Language_Org_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long organizationId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] =
				getByGroup_Company_Language_Org_Public_Status_PrevAndNext(
					session, legalDocument, groupId, companyId, language,
					organizationId, isPublic, statusDoc, orderByComparator,
					true);

			array[1] = legalDocument;

			array[2] =
				getByGroup_Company_Language_Org_Public_Status_PrevAndNext(
					session, legalDocument, groupId, companyId, language,
					organizationId, isPublic, statusDoc, orderByComparator,
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

	protected LegalDocument
		getByGroup_Company_Language_Org_Public_Status_PrevAndNext(
			Session session, LegalDocument legalDocument, long groupId,
			long companyId, String language, long organizationId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
			boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				9 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(8);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_GROUPID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_2);
		}

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ORGANIZATIONID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ISPUBLIC_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(organizationId);

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc) {

		for (LegalDocument legalDocument :
				findByGroup_Company_Language_Org_Public_Status(
					groupId, companyId, language, organizationId, isPublic,
					statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and organizationId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroup_Company_Language_Org_Public_Status(
		long groupId, long companyId, String language, long organizationId,
		int isPublic, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath =
			_finderPathCountByGroup_Company_Language_Org_Public_Status;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, organizationId, isPublic, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ORGANIZATIONID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_STATUSDOC_2);

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

				qPos.add(organizationId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

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
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_GROUPID_2 =
			"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_COMPANYID_2 =
			"legalDocument.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_2 =
			"legalDocument.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_LANGUAGE_3 =
			"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ORGANIZATIONID_2 =
			"legalDocument.organizationId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_ISPUBLIC_2 =
			"legalDocument.isPublic = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_ORG_PUBLIC_STATUS_STATUSDOC_2 =
			"legalDocument.statusDoc = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Company_Language_Type_Public_Status;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status;
	private FinderPath
		_finderPathCountByGroup_Company_Language_Type_Public_Status;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc) {

		return findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc, int start, int end) {

		return findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status;
				finderArgs = new Object[] {
					groupId, companyId, language, typeId, isPublic, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Company_Language_Type_Public_Status;
			finderArgs = new Object[] {
				groupId, companyId, language, typeId, isPublic, statusDoc,
				start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(typeId != legalDocument.getTypeId()) ||
						(isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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
					8 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_TYPEID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(typeId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Type_Public_Status_First(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Type_Public_Status_First(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Type_Public_Status_First(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list =
			findByGroup_Company_Language_Type_Public_Status(
				groupId, companyId, language, typeId, isPublic, statusDoc, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Type_Public_Status_Last(
			long groupId, long companyId, String language, long typeId,
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Type_Public_Status_Last(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Type_Public_Status_Last(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroup_Company_Language_Type_Public_Status(
			groupId, companyId, language, typeId, isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list =
			findByGroup_Company_Language_Type_Public_Status(
				groupId, companyId, language, typeId, isPublic, statusDoc,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[]
			findByGroup_Company_Language_Type_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				long typeId, int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] =
				getByGroup_Company_Language_Type_Public_Status_PrevAndNext(
					session, legalDocument, groupId, companyId, language,
					typeId, isPublic, statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] =
				getByGroup_Company_Language_Type_Public_Status_PrevAndNext(
					session, legalDocument, groupId, companyId, language,
					typeId, isPublic, statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument
		getByGroup_Company_Language_Type_Public_Status_PrevAndNext(
			Session session, LegalDocument legalDocument, long groupId,
			long companyId, String language, long typeId, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
			boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				9 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(8);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_GROUPID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_2);
		}

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_TYPEID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_ISPUBLIC_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(typeId);

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc) {

		for (LegalDocument legalDocument :
				findByGroup_Company_Language_Type_Public_Status(
					groupId, companyId, language, typeId, isPublic, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and typeId = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroup_Company_Language_Type_Public_Status(
		long groupId, long companyId, String language, long typeId,
		int isPublic, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath =
			_finderPathCountByGroup_Company_Language_Type_Public_Status;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, typeId, isPublic, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_TYPEID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_STATUSDOC_2);

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

				qPos.add(typeId);

				qPos.add(isPublic);

				qPos.add(statusDoc);

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
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_GROUPID_2 =
			"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_COMPANYID_2 =
			"legalDocument.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_2 =
			"legalDocument.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_LANGUAGE_3 =
			"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_TYPEID_2 =
			"legalDocument.typeId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_ISPUBLIC_2 =
			"legalDocument.isPublic = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_TYPE_PUBLIC_STATUS_STATUSDOC_2 =
			"legalDocument.statusDoc = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Company_Language_Public_Status;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status;
	private FinderPath _finderPathCountByGroup_Company_Language_Public_Status;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc) {

		return findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc, int start, int end) {

		return findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status;
				finderArgs = new Object[] {
					groupId, companyId, language, isPublic, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Company_Language_Public_Status;
			finderArgs = new Object[] {
				groupId, companyId, language, isPublic, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Public_Status_First(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Public_Status_First(
				groupId, companyId, language, isPublic, statusDoc,
				orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Public_Status_First(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Public_Status_Last(
			long groupId, long companyId, String language, int isPublic,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Public_Status_Last(
				groupId, companyId, language, isPublic, statusDoc,
				orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Public_Status_Last(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByGroup_Company_Language_Public_Status(
			groupId, companyId, language, isPublic, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[]
			findByGroup_Company_Language_Public_Status_PrevAndNext(
				long docId, long groupId, long companyId, String language,
				int isPublic, int statusDoc,
				OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByGroup_Company_Language_Public_Status_PrevAndNext(
				session, legalDocument, groupId, companyId, language, isPublic,
				statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByGroup_Company_Language_Public_Status_PrevAndNext(
				session, legalDocument, groupId, companyId, language, isPublic,
				statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument
		getByGroup_Company_Language_Public_Status_PrevAndNext(
			Session session, LegalDocument legalDocument, long groupId,
			long companyId, String language, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator,
			boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(7);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_GROUPID_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_2);
		}

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_ISPUBLIC_2);

		query.append(
			_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc) {

		for (LegalDocument legalDocument :
				findByGroup_Company_Language_Public_Status(
					groupId, companyId, language, isPublic, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroup_Company_Language_Public_Status(
		long groupId, long companyId, String language, int isPublic,
		int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath =
			_finderPathCountByGroup_Company_Language_Public_Status;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, isPublic, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_ISPUBLIC_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_STATUSDOC_2);

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

				qPos.add(isPublic);

				qPos.add(statusDoc);

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
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_GROUPID_2 =
			"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_COMPANYID_2 =
			"legalDocument.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_2 =
			"legalDocument.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_LANGUAGE_3 =
			"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_ISPUBLIC_2 =
			"legalDocument.isPublic = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_PUBLIC_STATUS_STATUSDOC_2 =
			"legalDocument.statusDoc = ?";

	private FinderPath
		_finderPathWithPaginationFindByGroup_Company_Language_Status;
	private FinderPath
		_finderPathWithoutPaginationFindByGroup_Company_Language_Status;
	private FinderPath _finderPathCountByGroup_Company_Language_Status;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc) {

		return findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end) {

		return findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc, int start,
		int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Company_Language_Status;
				finderArgs = new Object[] {
					groupId, companyId, language, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByGroup_Company_Language_Status;
			finderArgs = new Object[] {
				groupId, companyId, language, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Status_First(
			long groupId, long companyId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument =
			fetchByGroup_Company_Language_Status_First(
				groupId, companyId, language, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Status_First(
		long groupId, long companyId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Language_Status_Last(
			long groupId, long companyId, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByGroup_Company_Language_Status_Last(
			groupId, companyId, language, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Language_Status_Last(
		long groupId, long companyId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByGroup_Company_Language_Status(
			groupId, companyId, language, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByGroup_Company_Language_Status_PrevAndNext(
			long docId, long groupId, long companyId, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByGroup_Company_Language_Status_PrevAndNext(
				session, legalDocument, groupId, companyId, language, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByGroup_Company_Language_Status_PrevAndNext(
				session, legalDocument, groupId, companyId, language, statusDoc,
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

	protected LegalDocument getByGroup_Company_Language_Status_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_COMPANYID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc) {

		for (LegalDocument legalDocument :
				findByGroup_Company_Language_Status(
					groupId, companyId, language, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroup_Company_Language_Status(
		long groupId, long companyId, String language, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByGroup_Company_Language_Status;

		Object[] finderArgs = new Object[] {
			groupId, companyId, language, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_GROUPID_2);

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_COMPANYID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(
					_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_2);
			}

			query.append(
				_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_STATUSDOC_2);

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

				qPos.add(statusDoc);

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
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_GROUPID_2 =
			"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_COMPANYID_2 =
			"legalDocument.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_2 =
			"legalDocument.language = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_LANGUAGE_3 =
			"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_LANGUAGE_STATUS_STATUSDOC_2 =
			"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByGroup_Company_Status;
	private FinderPath _finderPathWithoutPaginationFindByGroup_Company_Status;
	private FinderPath _finderPathCountByGroup_Company_Status;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc) {

		return findByGroup_Company_Status(
			groupId, companyId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end) {

		return findByGroup_Company_Status(
			groupId, companyId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByGroup_Company_Status(
			groupId, companyId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByGroup_Company_Status(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroup_Company_Status;
				finderArgs = new Object[] {groupId, companyId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_Company_Status;
			finderArgs = new Object[] {
				groupId, companyId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Status_First(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByGroup_Company_Status_First(
			groupId, companyId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Status_First(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByGroup_Company_Status(
			groupId, companyId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByGroup_Company_Status_Last(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByGroup_Company_Status_Last(
			groupId, companyId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByGroup_Company_Status_Last(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByGroup_Company_Status(groupId, companyId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByGroup_Company_Status(
			groupId, companyId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByGroup_Company_Status_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByGroup_Company_Status_PrevAndNext(
				session, legalDocument, groupId, companyId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByGroup_Company_Status_PrevAndNext(
				session, legalDocument, groupId, companyId, statusDoc,
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

	protected LegalDocument getByGroup_Company_Status_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByGroup_Company_Status(
		long groupId, long companyId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByGroup_Company_Status(
					groupId, companyId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByGroup_Company_Status(
		long groupId, long companyId, int statusDoc) {

		FinderPath finderPath = _finderPathCountByGroup_Company_Status;

		Object[] finderArgs = new Object[] {groupId, companyId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_GROUP_COMPANY_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_GROUP_COMPANY_STATUS_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_STATUS_COMPANYID_2 =
			"legalDocument.companyId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUP_COMPANY_STATUS_STATUSDOC_2 =
			"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_O;
	private FinderPath _finderPathWithoutPaginationFindByG_L_O;
	private FinderPath _finderPathCountByG_L_O;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId) {

		return findByG_L_O(
			groupId, language, organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start,
		int end) {

		return findByG_L_O(groupId, language, organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_O(
			groupId, language, organizationId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_O(
		long groupId, String language, long organizationId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_O;
				finderArgs = new Object[] {groupId, language, organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_O;
			finderArgs = new Object[] {
				groupId, language, organizationId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(organizationId != legalDocument.getOrganizationId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_O_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_O_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_O_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_O_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(organizationId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_O_First(
			long groupId, String language, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_O_First(
			groupId, language, organizationId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_O_First(
		long groupId, String language, long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_O(
			groupId, language, organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_O_Last(
			long groupId, String language, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_O_Last(
			groupId, language, organizationId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_O_Last(
		long groupId, String language, long organizationId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_O(groupId, language, organizationId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_O(
			groupId, language, organizationId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_O_PrevAndNext(
			long docId, long groupId, String language, long organizationId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_O_PrevAndNext(
				session, legalDocument, groupId, language, organizationId,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_O_PrevAndNext(
				session, legalDocument, groupId, language, organizationId,
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

	protected LegalDocument getByG_L_O_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long organizationId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_O_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_O_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_O_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_O_ORGANIZATIONID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and organizationId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByG_L_O(
		long groupId, String language, long organizationId) {

		for (LegalDocument legalDocument :
				findByG_L_O(
					groupId, language, organizationId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and organizationId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param organizationId the organization ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_O(
		long groupId, String language, long organizationId) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_O;

		Object[] finderArgs = new Object[] {groupId, language, organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_O_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_O_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_O_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_O_ORGANIZATIONID_2);

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

	private static final String _FINDER_COLUMN_G_L_O_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_O_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_O_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_O_ORGANIZATIONID_2 =
		"legalDocument.organizationId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_T;
	private FinderPath _finderPathWithoutPaginationFindByG_L_T;
	private FinderPath _finderPathCountByG_L_T;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId) {

		return findByG_L_T(
			groupId, language, typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end) {

		return findByG_L_T(groupId, language, typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_T(
			groupId, language, typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_T(
		long groupId, String language, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_T;
				finderArgs = new Object[] {groupId, language, typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_T;
			finderArgs = new Object[] {
				groupId, language, typeId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(typeId != legalDocument.getTypeId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_T_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_T_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_T_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_T_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(typeId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_T_First(
			long groupId, String language, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_T_First(
			groupId, language, typeId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_T_First(
		long groupId, String language, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_T(
			groupId, language, typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_T_Last(
			long groupId, String language, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_T_Last(
			groupId, language, typeId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_T_Last(
		long groupId, String language, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_T(groupId, language, typeId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_T(
			groupId, language, typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_T_PrevAndNext(
			long docId, long groupId, String language, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_T_PrevAndNext(
				session, legalDocument, groupId, language, typeId,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_T_PrevAndNext(
				session, legalDocument, groupId, language, typeId,
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

	protected LegalDocument getByG_L_T_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long typeId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_T_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_T_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_T_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_T_TYPEID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(typeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 */
	@Override
	public void removeByG_L_T(long groupId, String language, long typeId) {
		for (LegalDocument legalDocument :
				findByG_L_T(
					groupId, language, typeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_T(long groupId, String language, long typeId) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_T;

		Object[] finderArgs = new Object[] {groupId, language, typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_T_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_T_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_T_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_T_TYPEID_2);

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

	private static final String _FINDER_COLUMN_G_L_T_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_T_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_T_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_T_TYPEID_2 =
		"legalDocument.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L_F;
	private FinderPath _finderPathWithoutPaginationFindByG_L_F;
	private FinderPath _finderPathCountByG_L_F;

	/**
	 * Returns all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId) {

		return findByG_L_F(
			groupId, language, fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end) {

		return findByG_L_F(groupId, language, fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByG_L_F(
			groupId, language, fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByG_L_F(
		long groupId, String language, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_F;
				finderArgs = new Object[] {groupId, language, fieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_F;
			finderArgs = new Object[] {
				groupId, language, fieldId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(fieldId != legalDocument.getFieldId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_F_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_F_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_F_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_F_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(fieldId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_F_First(
			long groupId, String language, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_F_First(
			groupId, language, fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_F_First(
		long groupId, String language, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByG_L_F(
			groupId, language, fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByG_L_F_Last(
			long groupId, String language, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByG_L_F_Last(
			groupId, language, fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByG_L_F_Last(
		long groupId, String language, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByG_L_F(groupId, language, fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByG_L_F(
			groupId, language, fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByG_L_F_PrevAndNext(
			long docId, long groupId, String language, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByG_L_F_PrevAndNext(
				session, legalDocument, groupId, language, fieldId,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByG_L_F_PrevAndNext(
				session, legalDocument, groupId, language, fieldId,
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

	protected LegalDocument getByG_L_F_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		String language, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_F_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_F_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_F_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_F_FIELDID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and language = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByG_L_F(long groupId, String language, long fieldId) {
		for (LegalDocument legalDocument :
				findByG_L_F(
					groupId, language, fieldId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and language = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByG_L_F(long groupId, String language, long fieldId) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_F;

		Object[] finderArgs = new Object[] {groupId, language, fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_F_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_F_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_F_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_F_FIELDID_2);

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

	private static final String _FINDER_COLUMN_G_L_F_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_F_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_F_FIELDID_2 =
		"legalDocument.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByP_U_S;
	private FinderPath _finderPathWithoutPaginationFindByP_U_S;
	private FinderPath _finderPathCountByP_U_S;

	/**
	 * Returns all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc) {

		return findByP_U_S(
			groupId, createdByUser, language, statusDoc, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end) {

		return findByP_U_S(
			groupId, createdByUser, language, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByP_U_S(
			groupId, createdByUser, language, statusDoc, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc,
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_U_S;
				finderArgs = new Object[] {
					groupId, createdByUser, language, statusDoc
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_U_S;
			finderArgs = new Object[] {
				groupId, createdByUser, language, statusDoc, start, end,
				orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(createdByUser != legalDocument.getCreatedByUser()) ||
						!language.equals(legalDocument.getLanguage()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN_P_U_S_CREATEDBYUSER_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_U_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_U_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_P_U_S_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(createdByUser);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByP_U_S_First(
			long groupId, long createdByUser, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByP_U_S_First(
			groupId, createdByUser, language, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdByUser=");
		msg.append(createdByUser);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByP_U_S_First(
		long groupId, long createdByUser, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByP_U_S(
			groupId, createdByUser, language, statusDoc, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByP_U_S_Last(
			long groupId, long createdByUser, String language, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByP_U_S_Last(
			groupId, createdByUser, language, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdByUser=");
		msg.append(createdByUser);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByP_U_S_Last(
		long groupId, long createdByUser, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByP_U_S(groupId, createdByUser, language, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByP_U_S(
			groupId, createdByUser, language, statusDoc, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByP_U_S_PrevAndNext(
			long docId, long groupId, long createdByUser, String language,
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		language = Objects.toString(language, "");

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByP_U_S_PrevAndNext(
				session, legalDocument, groupId, createdByUser, language,
				statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByP_U_S_PrevAndNext(
				session, legalDocument, groupId, createdByUser, language,
				statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByP_U_S_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long createdByUser, String language, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_U_S_GROUPID_2);

		query.append(_FINDER_COLUMN_P_U_S_CREATEDBYUSER_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_P_U_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_P_U_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_P_U_S_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(createdByUser);

		if (bindLanguage) {
			qPos.add(language);
		}

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc) {

		for (LegalDocument legalDocument :
				findByP_U_S(
					groupId, createdByUser, language, statusDoc,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and createdByUser = &#63; and language = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByP_U_S(
		long groupId, long createdByUser, String language, int statusDoc) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByP_U_S;

		Object[] finderArgs = new Object[] {
			groupId, createdByUser, language, statusDoc
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_U_S_GROUPID_2);

			query.append(_FINDER_COLUMN_P_U_S_CREATEDBYUSER_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_U_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_U_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_P_U_S_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(createdByUser);

				if (bindLanguage) {
					qPos.add(language);
				}

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_P_U_S_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_U_S_CREATEDBYUSER_2 =
		"legalDocument.createdByUser = ? AND ";

	private static final String _FINDER_COLUMN_P_U_S_LANGUAGE_2 =
		"legalDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_P_U_S_LANGUAGE_3 =
		"(legalDocument.language IS NULL OR legalDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_P_U_S_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByStatus(int statusDoc) {
		return findByStatus(
			statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByStatus(int statusDoc, int start, int end) {
		return findByStatus(statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByStatus(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByStatus(statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByStatus(
		int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {
				statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if (statusDoc != legalDocument.getStatusDoc()) {
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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByStatus_First(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByStatus_First(
			statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByStatus_First(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByStatus(
			statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByStatus_Last(
			int statusDoc, OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByStatus_Last(
			statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByStatus_Last(
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByStatus(statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByStatus(
			statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByStatus_PrevAndNext(
			long docId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, legalDocument, statusDoc, orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByStatus_PrevAndNext(
				session, legalDocument, statusDoc, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDocument getByStatus_PrevAndNext(
		Session session, LegalDocument legalDocument, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where statusDoc = &#63; from the database.
	 *
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByStatus(int statusDoc) {
		for (LegalDocument legalDocument :
				findByStatus(
					statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where statusDoc = &#63;.
	 *
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByStatus(int statusDoc) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_STATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByIsPublic_Status;
	private FinderPath _finderPathWithoutPaginationFindByIsPublic_Status;
	private FinderPath _finderPathCountByIsPublic_Status;

	/**
	 * Returns all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc) {

		return findByIsPublic_Status(
			isPublic, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end) {

		return findByIsPublic_Status(isPublic, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByIsPublic_Status(
			isPublic, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByIsPublic_Status(
		int isPublic, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsPublic_Status;
				finderArgs = new Object[] {isPublic, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsPublic_Status;
			finderArgs = new Object[] {
				isPublic, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((isPublic != legalDocument.getIsPublic()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_STATUS_ISPUBLIC_2);

			query.append(_FINDER_COLUMN_ISPUBLIC_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByIsPublic_Status_First(
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByIsPublic_Status_First(
			isPublic, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByIsPublic_Status_First(
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByIsPublic_Status(
			isPublic, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByIsPublic_Status_Last(
			int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByIsPublic_Status_Last(
			isPublic, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByIsPublic_Status_Last(
		int isPublic, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByIsPublic_Status(isPublic, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByIsPublic_Status(
			isPublic, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByIsPublic_Status_PrevAndNext(
			long docId, int isPublic, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByIsPublic_Status_PrevAndNext(
				session, legalDocument, isPublic, statusDoc, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByIsPublic_Status_PrevAndNext(
				session, legalDocument, isPublic, statusDoc, orderByComparator,
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

	protected LegalDocument getByIsPublic_Status_PrevAndNext(
		Session session, LegalDocument legalDocument, int isPublic,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_ISPUBLIC_STATUS_ISPUBLIC_2);

		query.append(_FINDER_COLUMN_ISPUBLIC_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isPublic);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where isPublic = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByIsPublic_Status(int isPublic, int statusDoc) {
		for (LegalDocument legalDocument :
				findByIsPublic_Status(
					isPublic, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where isPublic = &#63; and statusDoc = &#63;.
	 *
	 * @param isPublic the is public
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByIsPublic_Status(int isPublic, int statusDoc) {
		FinderPath finderPath = _finderPathCountByIsPublic_Status;

		Object[] finderArgs = new Object[] {isPublic, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_STATUS_ISPUBLIC_2);

			query.append(_FINDER_COLUMN_ISPUBLIC_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_ISPUBLIC_STATUS_ISPUBLIC_2 =
		"legalDocument.isPublic = ? AND ";

	private static final String _FINDER_COLUMN_ISPUBLIC_STATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByOrg_Status;
	private FinderPath _finderPathWithoutPaginationFindByOrg_Status;
	private FinderPath _finderPathCountByOrg_Status;

	/**
	 * Returns all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc) {

		return findByOrg_Status(
			organizationId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end) {

		return findByOrg_Status(organizationId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByOrg_Status(
			organizationId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByOrg_Status(
		long organizationId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrg_Status;
				finderArgs = new Object[] {organizationId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrg_Status;
			finderArgs = new Object[] {
				organizationId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((organizationId != legalDocument.getOrganizationId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ORG_STATUS_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORG_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByOrg_Status_First(
			long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByOrg_Status_First(
			organizationId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByOrg_Status_First(
		long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByOrg_Status(
			organizationId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByOrg_Status_Last(
			long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByOrg_Status_Last(
			organizationId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByOrg_Status_Last(
		long organizationId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByOrg_Status(organizationId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByOrg_Status(
			organizationId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByOrg_Status_PrevAndNext(
			long docId, long organizationId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByOrg_Status_PrevAndNext(
				session, legalDocument, organizationId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByOrg_Status_PrevAndNext(
				session, legalDocument, organizationId, statusDoc,
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

	protected LegalDocument getByOrg_Status_PrevAndNext(
		Session session, LegalDocument legalDocument, long organizationId,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_ORG_STATUS_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORG_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where organizationId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByOrg_Status(long organizationId, int statusDoc) {
		for (LegalDocument legalDocument :
				findByOrg_Status(
					organizationId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where organizationId = &#63; and statusDoc = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByOrg_Status(long organizationId, int statusDoc) {
		FinderPath finderPath = _finderPathCountByOrg_Status;

		Object[] finderArgs = new Object[] {organizationId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_ORG_STATUS_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORG_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_ORG_STATUS_ORGANIZATIONID_2 =
		"legalDocument.organizationId = ? AND ";

	private static final String _FINDER_COLUMN_ORG_STATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByType_Status;
	private FinderPath _finderPathWithoutPaginationFindByType_Status;
	private FinderPath _finderPathCountByType_Status;

	/**
	 * Returns all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByType_Status(long typeId, int statusDoc) {
		return findByType_Status(
			typeId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end) {

		return findByType_Status(typeId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByType_Status(
			typeId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByType_Status(
		long typeId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType_Status;
				finderArgs = new Object[] {typeId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType_Status;
			finderArgs = new Object[] {
				typeId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((typeId != legalDocument.getTypeId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_TYPE_STATUS_TYPEID_2);

			query.append(_FINDER_COLUMN_TYPE_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByType_Status_First(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByType_Status_First(
			typeId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByType_Status_First(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByType_Status(
			typeId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByType_Status_Last(
			long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByType_Status_Last(
			typeId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeId=");
		msg.append(typeId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByType_Status_Last(
		long typeId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByType_Status(typeId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByType_Status(
			typeId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByType_Status_PrevAndNext(
			long docId, long typeId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByType_Status_PrevAndNext(
				session, legalDocument, typeId, statusDoc, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByType_Status_PrevAndNext(
				session, legalDocument, typeId, statusDoc, orderByComparator,
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

	protected LegalDocument getByType_Status_PrevAndNext(
		Session session, LegalDocument legalDocument, long typeId,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_TYPE_STATUS_TYPEID_2);

		query.append(_FINDER_COLUMN_TYPE_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where typeId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByType_Status(long typeId, int statusDoc) {
		for (LegalDocument legalDocument :
				findByType_Status(
					typeId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where typeId = &#63; and statusDoc = &#63;.
	 *
	 * @param typeId the type ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByType_Status(long typeId, int statusDoc) {
		FinderPath finderPath = _finderPathCountByType_Status;

		Object[] finderArgs = new Object[] {typeId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_TYPE_STATUS_TYPEID_2);

			query.append(_FINDER_COLUMN_TYPE_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_TYPE_STATUS_TYPEID_2 =
		"legalDocument.typeId = ? AND ";

	private static final String _FINDER_COLUMN_TYPE_STATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByField_Status;
	private FinderPath _finderPathWithoutPaginationFindByField_Status;
	private FinderPath _finderPathCountByField_Status;

	/**
	 * Returns all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByField_Status(long fieldId, int statusDoc) {
		return findByField_Status(
			fieldId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end) {

		return findByField_Status(fieldId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByField_Status(
			fieldId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByField_Status(
		long fieldId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByField_Status;
				finderArgs = new Object[] {fieldId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByField_Status;
			finderArgs = new Object[] {
				fieldId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((fieldId != legalDocument.getFieldId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FIELD_STATUS_FIELDID_2);

			query.append(_FINDER_COLUMN_FIELD_STATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByField_Status_First(
			long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByField_Status_First(
			fieldId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByField_Status_First(
		long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByField_Status(
			fieldId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByField_Status_Last(
			long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByField_Status_Last(
			fieldId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldId=");
		msg.append(fieldId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByField_Status_Last(
		long fieldId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByField_Status(fieldId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByField_Status(
			fieldId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByField_Status_PrevAndNext(
			long docId, long fieldId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByField_Status_PrevAndNext(
				session, legalDocument, fieldId, statusDoc, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByField_Status_PrevAndNext(
				session, legalDocument, fieldId, statusDoc, orderByComparator,
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

	protected LegalDocument getByField_Status_PrevAndNext(
		Session session, LegalDocument legalDocument, long fieldId,
		int statusDoc, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_FIELD_STATUS_FIELDID_2);

		query.append(_FINDER_COLUMN_FIELD_STATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where fieldId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByField_Status(long fieldId, int statusDoc) {
		for (LegalDocument legalDocument :
				findByField_Status(
					fieldId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where fieldId = &#63; and statusDoc = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByField_Status(long fieldId, int statusDoc) {
		FinderPath finderPath = _finderPathCountByField_Status;

		Object[] finderArgs = new Object[] {fieldId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FIELD_STATUS_FIELDID_2);

			query.append(_FINDER_COLUMN_FIELD_STATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_FIELD_STATUS_FIELDID_2 =
		"legalDocument.fieldId = ? AND ";

	private static final String _FINDER_COLUMN_FIELD_STATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc) {

		return findByFindGroup(
			groupId, companyId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end) {

		return findByFindGroup(groupId, companyId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindGroup(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {groupId, companyId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindGroup_First(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindGroup_First(
			groupId, companyId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindGroup_First(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByFindGroup(
			groupId, companyId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindGroup_Last(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindGroup_Last(
			groupId, companyId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindGroup_Last(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByFindGroup(groupId, companyId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByFindGroup(
			groupId, companyId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByFindGroup_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalDocument, groupId, companyId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalDocument, groupId, companyId, statusDoc,
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

	protected LegalDocument getByFindGroup_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByFindGroup(long groupId, long companyId, int statusDoc) {
		for (LegalDocument legalDocument :
				findByFindGroup(
					groupId, companyId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByFindGroup(long groupId, long companyId, int statusDoc) {
		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDoc);

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
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalDocument.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindAll(long groupId, long companyId) {
		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindAll;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindAll;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByFindAll_PrevAndNext(
			long docId, long groupId, long companyId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalDocument, groupId, companyId, orderByComparator,
				true);

			array[1] = legalDocument;

			array[2] = getByFindAll_PrevAndNext(
				session, legalDocument, groupId, companyId, orderByComparator,
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

	protected LegalDocument getByFindAll_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, OrderByComparator<LegalDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalDocument legalDocument :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_FINDALL_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalDocument.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFindType;
	private FinderPath _finderPathWithoutPaginationFindByFindType;
	private FinderPath _finderPathCountByFindType;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId) {

		return findByFindType(
			groupId, companyId, typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end) {

		return findByFindType(groupId, companyId, typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByFindType(
			groupId, companyId, typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindType(
		long groupId, long companyId, long typeId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindType;
				finderArgs = new Object[] {groupId, companyId, typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindType;
			finderArgs = new Object[] {
				groupId, companyId, typeId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						(typeId != legalDocument.getTypeId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDTYPE_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDTYPE_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(typeId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindType_First(
			long groupId, long companyId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindType_First(
			groupId, companyId, typeId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindType_First(
		long groupId, long companyId, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByFindType(
			groupId, companyId, typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindType_Last(
			long groupId, long companyId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindType_Last(
			groupId, companyId, typeId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindType_Last(
		long groupId, long companyId, long typeId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByFindType(groupId, companyId, typeId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByFindType(
			groupId, companyId, typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByFindType_PrevAndNext(
			long docId, long groupId, long companyId, long typeId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByFindType_PrevAndNext(
				session, legalDocument, groupId, companyId, typeId,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByFindType_PrevAndNext(
				session, legalDocument, groupId, companyId, typeId,
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

	protected LegalDocument getByFindType_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, long typeId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_FINDTYPE_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDTYPE_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDTYPE_TYPEID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(typeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 */
	@Override
	public void removeByFindType(long groupId, long companyId, long typeId) {
		for (LegalDocument legalDocument :
				findByFindType(
					groupId, companyId, typeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param typeId the type ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByFindType(long groupId, long companyId, long typeId) {
		FinderPath finderPath = _finderPathCountByFindType;

		Object[] finderArgs = new Object[] {groupId, companyId, typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDTYPE_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDTYPE_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_FINDTYPE_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDTYPE_COMPANYID_2 =
		"legalDocument.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDTYPE_TYPEID_2 =
		"legalDocument.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByFindField;
	private FinderPath _finderPathWithoutPaginationFindByFindField;
	private FinderPath _finderPathCountByFindField;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId) {

		return findByFindField(
			groupId, companyId, fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end) {

		return findByFindField(groupId, companyId, fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByFindField(
			groupId, companyId, fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByFindField(
		long groupId, long companyId, long fieldId, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindField;
				finderArgs = new Object[] {groupId, companyId, fieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindField;
			finderArgs = new Object[] {
				groupId, companyId, fieldId, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						(fieldId != legalDocument.getFieldId())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDFIELD_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDFIELD_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDFIELD_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(fieldId);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindField_First(
			long groupId, long companyId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindField_First(
			groupId, companyId, fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindField_First(
		long groupId, long companyId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByFindField(
			groupId, companyId, fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByFindField_Last(
			long groupId, long companyId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByFindField_Last(
			groupId, companyId, fieldId, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByFindField_Last(
		long groupId, long companyId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByFindField(groupId, companyId, fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByFindField(
			groupId, companyId, fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByFindField_PrevAndNext(
			long docId, long groupId, long companyId, long fieldId,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByFindField_PrevAndNext(
				session, legalDocument, groupId, companyId, fieldId,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByFindField_PrevAndNext(
				session, legalDocument, groupId, companyId, fieldId,
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

	protected LegalDocument getByFindField_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, long fieldId,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_FINDFIELD_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDFIELD_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDFIELD_FIELDID_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByFindField(long groupId, long companyId, long fieldId) {
		for (LegalDocument legalDocument :
				findByFindField(
					groupId, companyId, fieldId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param fieldId the field ID
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByFindField(long groupId, long companyId, long fieldId) {
		FinderPath finderPath = _finderPathCountByFindField;

		Object[] finderArgs = new Object[] {groupId, companyId, fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDFIELD_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDFIELD_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDFIELD_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_FINDFIELD_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDFIELD_COMPANYID_2 =
		"legalDocument.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDFIELD_FIELDID_2 =
		"legalDocument.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByLegalStatus;
	private FinderPath _finderPathWithoutPaginationFindByLegalStatus;
	private FinderPath _finderPathCountByLegalStatus;

	/**
	 * Returns all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the matching legal documents
	 */
	@Override
	public List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc) {

		return findByLegalStatus(
			groupId, companyId, statusDoc, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end) {

		return findByLegalStatus(
			groupId, companyId, statusDoc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findByLegalStatus(
			groupId, companyId, statusDoc, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal documents
	 */
	@Override
	public List<LegalDocument> findByLegalStatus(
		long groupId, long companyId, int statusDoc, int start, int end,
		OrderByComparator<LegalDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLegalStatus;
				finderArgs = new Object[] {groupId, companyId, statusDoc};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLegalStatus;
			finderArgs = new Object[] {
				groupId, companyId, statusDoc, start, end, orderByComparator
			};
		}

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDocument legalDocument : list) {
					if ((groupId != legalDocument.getGroupId()) ||
						(companyId != legalDocument.getCompanyId()) ||
						(statusDoc != legalDocument.getStatusDoc())) {

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

			query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_LEGALSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_LEGALSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_LEGALSTATUS_STATUSDOC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDoc);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByLegalStatus_First(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByLegalStatus_First(
			groupId, companyId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByLegalStatus_First(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		List<LegalDocument> list = findByLegalStatus(
			groupId, companyId, statusDoc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document
	 * @throws NoSuchLegalDocumentException if a matching legal document could not be found
	 */
	@Override
	public LegalDocument findByLegalStatus_Last(
			long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByLegalStatus_Last(
			groupId, companyId, statusDoc, orderByComparator);

		if (legalDocument != null) {
			return legalDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDoc=");
		msg.append(statusDoc);

		msg.append("}");

		throw new NoSuchLegalDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal document, or <code>null</code> if a matching legal document could not be found
	 */
	@Override
	public LegalDocument fetchByLegalStatus_Last(
		long groupId, long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator) {

		int count = countByLegalStatus(groupId, companyId, statusDoc);

		if (count == 0) {
			return null;
		}

		List<LegalDocument> list = findByLegalStatus(
			groupId, companyId, statusDoc, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal documents before and after the current legal document in the ordered set where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param docId the primary key of the current legal document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument[] findByLegalStatus_PrevAndNext(
			long docId, long groupId, long companyId, int statusDoc,
			OrderByComparator<LegalDocument> orderByComparator)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = findByPrimaryKey(docId);

		Session session = null;

		try {
			session = openSession();

			LegalDocument[] array = new LegalDocumentImpl[3];

			array[0] = getByLegalStatus_PrevAndNext(
				session, legalDocument, groupId, companyId, statusDoc,
				orderByComparator, true);

			array[1] = legalDocument;

			array[2] = getByLegalStatus_PrevAndNext(
				session, legalDocument, groupId, companyId, statusDoc,
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

	protected LegalDocument getByLegalStatus_PrevAndNext(
		Session session, LegalDocument legalDocument, long groupId,
		long companyId, int statusDoc,
		OrderByComparator<LegalDocument> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_LEGALSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_LEGALSTATUS_COMPANYID_2);

		query.append(_FINDER_COLUMN_LEGALSTATUS_STATUSDOC_2);

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
			query.append(LegalDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusDoc);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 */
	@Override
	public void removeByLegalStatus(
		long groupId, long companyId, int statusDoc) {

		for (LegalDocument legalDocument :
				findByLegalStatus(
					groupId, companyId, statusDoc, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents where groupId = &#63; and companyId = &#63; and statusDoc = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDoc the status doc
	 * @return the number of matching legal documents
	 */
	@Override
	public int countByLegalStatus(long groupId, long companyId, int statusDoc) {
		FinderPath finderPath = _finderPathCountByLegalStatus;

		Object[] finderArgs = new Object[] {groupId, companyId, statusDoc};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_LEGALSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_LEGALSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_LEGALSTATUS_STATUSDOC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDoc);

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

	private static final String _FINDER_COLUMN_LEGALSTATUS_GROUPID_2 =
		"legalDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_LEGALSTATUS_COMPANYID_2 =
		"legalDocument.companyId = ? AND ";

	private static final String _FINDER_COLUMN_LEGALSTATUS_STATUSDOC_2 =
		"legalDocument.statusDoc = ?";

	public LegalDocumentPersistenceImpl() {
		setModelClass(LegalDocument.class);

		setModelImplClass(LegalDocumentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal document in the entity cache if it is enabled.
	 *
	 * @param legalDocument the legal document
	 */
	@Override
	public void cacheResult(LegalDocument legalDocument) {
		entityCache.putResult(
			entityCacheEnabled, LegalDocumentImpl.class,
			legalDocument.getPrimaryKey(), legalDocument);

		finderCache.putResult(
			_finderPathFetchByDocId, new Object[] {legalDocument.getDocId()},
			legalDocument);

		finderCache.putResult(
			_finderPathFetchByG_D,
			new Object[] {legalDocument.getGroupId(), legalDocument.getDocId()},
			legalDocument);

		finderCache.putResult(
			_finderPathFetchByP_N_S,
			new Object[] {
				legalDocument.getGroupId(), legalDocument.getNum(),
				legalDocument.getSymbol()
			},
			legalDocument);

		legalDocument.resetOriginalValues();
	}

	/**
	 * Caches the legal documents in the entity cache if it is enabled.
	 *
	 * @param legalDocuments the legal documents
	 */
	@Override
	public void cacheResult(List<LegalDocument> legalDocuments) {
		for (LegalDocument legalDocument : legalDocuments) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDocumentImpl.class,
					legalDocument.getPrimaryKey()) == null) {

				cacheResult(legalDocument);
			}
			else {
				legalDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDocumentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal document.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDocument legalDocument) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDocumentImpl.class,
			legalDocument.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalDocumentModelImpl)legalDocument, true);
	}

	@Override
	public void clearCache(List<LegalDocument> legalDocuments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDocument legalDocument : legalDocuments) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDocumentImpl.class,
				legalDocument.getPrimaryKey());

			clearUniqueFindersCache(
				(LegalDocumentModelImpl)legalDocument, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDocumentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalDocumentModelImpl legalDocumentModelImpl) {

		Object[] args = new Object[] {legalDocumentModelImpl.getDocId()};

		finderCache.putResult(
			_finderPathCountByDocId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByDocId, args, legalDocumentModelImpl, false);

		args = new Object[] {
			legalDocumentModelImpl.getGroupId(),
			legalDocumentModelImpl.getDocId()
		};

		finderCache.putResult(
			_finderPathCountByG_D, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_D, args, legalDocumentModelImpl, false);

		args = new Object[] {
			legalDocumentModelImpl.getGroupId(),
			legalDocumentModelImpl.getNum(), legalDocumentModelImpl.getSymbol()
		};

		finderCache.putResult(
			_finderPathCountByP_N_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByP_N_S, args, legalDocumentModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalDocumentModelImpl legalDocumentModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {legalDocumentModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountByDocId, args);
			finderCache.removeResult(_finderPathFetchByDocId, args);
		}

		if ((legalDocumentModelImpl.getColumnBitmask() &
			 _finderPathFetchByDocId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDocumentModelImpl.getOriginalDocId()
			};

			finderCache.removeResult(_finderPathCountByDocId, args);
			finderCache.removeResult(_finderPathFetchByDocId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getDocId()
			};

			finderCache.removeResult(_finderPathCountByG_D, args);
			finderCache.removeResult(_finderPathFetchByG_D, args);
		}

		if ((legalDocumentModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_D.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDocumentModelImpl.getOriginalGroupId(),
				legalDocumentModelImpl.getOriginalDocId()
			};

			finderCache.removeResult(_finderPathCountByG_D, args);
			finderCache.removeResult(_finderPathFetchByG_D, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getNum(),
				legalDocumentModelImpl.getSymbol()
			};

			finderCache.removeResult(_finderPathCountByP_N_S, args);
			finderCache.removeResult(_finderPathFetchByP_N_S, args);
		}

		if ((legalDocumentModelImpl.getColumnBitmask() &
			 _finderPathFetchByP_N_S.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDocumentModelImpl.getOriginalGroupId(),
				legalDocumentModelImpl.getOriginalNum(),
				legalDocumentModelImpl.getOriginalSymbol()
			};

			finderCache.removeResult(_finderPathCountByP_N_S, args);
			finderCache.removeResult(_finderPathFetchByP_N_S, args);
		}
	}

	/**
	 * Creates a new legal document with the primary key. Does not add the legal document to the database.
	 *
	 * @param docId the primary key for the new legal document
	 * @return the new legal document
	 */
	@Override
	public LegalDocument create(long docId) {
		LegalDocument legalDocument = new LegalDocumentImpl();

		legalDocument.setNew(true);
		legalDocument.setPrimaryKey(docId);

		legalDocument.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalDocument;
	}

	/**
	 * Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument remove(long docId)
		throws NoSuchLegalDocumentException {

		return remove((Serializable)docId);
	}

	/**
	 * Removes the legal document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal document
	 * @return the legal document that was removed
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument remove(Serializable primaryKey)
		throws NoSuchLegalDocumentException {

		Session session = null;

		try {
			session = openSession();

			LegalDocument legalDocument = (LegalDocument)session.get(
				LegalDocumentImpl.class, primaryKey);

			if (legalDocument == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDocumentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDocument);
		}
		catch (NoSuchLegalDocumentException noSuchEntityException) {
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
	protected LegalDocument removeImpl(LegalDocument legalDocument) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDocument)) {
				legalDocument = (LegalDocument)session.get(
					LegalDocumentImpl.class, legalDocument.getPrimaryKeyObj());
			}

			if (legalDocument != null) {
				session.delete(legalDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDocument != null) {
			clearCache(legalDocument);
		}

		return legalDocument;
	}

	@Override
	public LegalDocument updateImpl(LegalDocument legalDocument) {
		boolean isNew = legalDocument.isNew();

		if (!(legalDocument instanceof LegalDocumentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDocument.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalDocument);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDocument proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDocument implementation " +
					legalDocument.getClass());
		}

		LegalDocumentModelImpl legalDocumentModelImpl =
			(LegalDocumentModelImpl)legalDocument;

		Session session = null;

		try {
			session = openSession();

			if (legalDocument.isNew()) {
				session.save(legalDocument);

				legalDocument.setNew(false);
			}
			else {
				legalDocument = (LegalDocument)session.merge(legalDocument);
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
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByDOC_STATUS, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDOC_STATUS, args);

			args = new Object[] {legalDocumentModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getOrganizationId(),
				legalDocumentModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByDocsByF_O_T_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocsByF_O_T_L_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getOrganizationId(),
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByDocsByG_O_T_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocsByG_O_T_L_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getOrganizationId(),
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getFieldId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByDocsByO_T_F_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocsByO_T_F_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByDocsByPromulDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocsByPromulDate, args);

			args = new Object[] {legalDocumentModelImpl.getOrganizationId()};

			finderCache.removeResult(_finderPathCountByDoc_Org, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDoc_Org, args);

			args = new Object[] {legalDocumentModelImpl.getTypeId()};

			finderCache.removeResult(_finderPathCountByDoc_Category, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDoc_Category, args);

			args = new Object[] {legalDocumentModelImpl.getFieldId()};

			finderCache.removeResult(_finderPathCountByDoc_Field, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDoc_Field, args);

			args = new Object[] {
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByDocsByT_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocsByT_L, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getUserId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByG_L_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_U_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByP_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_L_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByG_L_P_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_P_S, args);

			args = new Object[] {legalDocumentModelImpl.getStatusDoc()};

			finderCache.removeResult(_finderPathCountBystatusDoc, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBystatusDoc, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getOrganizationId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByG_L_O_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_O_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByG_L_T_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_T_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getFieldId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByG_L_F_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_F_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getFieldId(),
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByG_L_F_P_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_F_P_S, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getFieldId(),
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Company_Language_Field_Public_Status,
				args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status,
				args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getOrganizationId(),
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Company_Language_Org_Public_Status,
				args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status,
				args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Company_Language_Type_Public_Status,
				args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status,
				args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Company_Language_Public_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status,
				args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Company_Language_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Company_Language_Status,
				args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(
				_finderPathCountByGroup_Company_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Company_Status, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getOrganizationId()
			};

			finderCache.removeResult(_finderPathCountByG_L_O, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_O, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getTypeId()
			};

			finderCache.removeResult(_finderPathCountByG_L_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_T, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByG_L_F, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_F, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCreatedByUser(),
				legalDocumentModelImpl.getLanguage(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByP_U_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_U_S, args);

			args = new Object[] {legalDocumentModelImpl.getStatusDoc()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {
				legalDocumentModelImpl.getIsPublic(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByIsPublic_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByIsPublic_Status, args);

			args = new Object[] {
				legalDocumentModelImpl.getOrganizationId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByOrg_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOrg_Status, args);

			args = new Object[] {
				legalDocumentModelImpl.getTypeId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByType_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByType_Status, args);

			args = new Object[] {
				legalDocumentModelImpl.getFieldId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByField_Status, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByField_Status, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getTypeId()
			};

			finderCache.removeResult(_finderPathCountByFindType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindType, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByFindField, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindField, args);

			args = new Object[] {
				legalDocumentModelImpl.getGroupId(),
				legalDocumentModelImpl.getCompanyId(),
				legalDocumentModelImpl.getStatusDoc()
			};

			finderCache.removeResult(_finderPathCountByLegalStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLegalStatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDOC_STATUS.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByDOC_STATUS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDOC_STATUS, args);

				args = new Object[] {legalDocumentModelImpl.getStatusDoc()};

				finderCache.removeResult(_finderPathCountByDOC_STATUS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDOC_STATUS, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalDocumentModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocsByF_O_T_L_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalOrganizationId(),
					legalDocumentModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(
					_finderPathCountByDocsByF_O_T_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByF_O_T_L_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getOrganizationId(),
					legalDocumentModelImpl.getFieldId()
				};

				finderCache.removeResult(
					_finderPathCountByDocsByF_O_T_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByF_O_T_L_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocsByG_O_T_L_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalOrganizationId(),
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByDocsByG_O_T_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByG_O_T_L_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getOrganizationId(),
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByDocsByG_O_T_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByG_O_T_L_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocsByO_T_F_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalOrganizationId(),
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalFieldId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByDocsByO_T_F_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByO_T_F_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getOrganizationId(),
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getFieldId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByDocsByO_T_F_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByO_T_F_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocsByPromulDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByDocsByPromulDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByPromulDate, args);

				args = new Object[] {
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByDocsByPromulDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByPromulDate, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDoc_Org.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalOrganizationId()
				};

				finderCache.removeResult(_finderPathCountByDoc_Org, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc_Org, args);

				args = new Object[] {
					legalDocumentModelImpl.getOrganizationId()
				};

				finderCache.removeResult(_finderPathCountByDoc_Org, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc_Org, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDoc_Category.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalTypeId()
				};

				finderCache.removeResult(_finderPathCountByDoc_Category, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc_Category, args);

				args = new Object[] {legalDocumentModelImpl.getTypeId()};

				finderCache.removeResult(_finderPathCountByDoc_Category, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc_Category, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDoc_Field.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByDoc_Field, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc_Field, args);

				args = new Object[] {legalDocumentModelImpl.getFieldId()};

				finderCache.removeResult(_finderPathCountByDoc_Field, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDoc_Field, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocsByT_L.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByDocsByT_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByT_L, args);

				args = new Object[] {
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByDocsByT_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocsByT_L, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_U_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalUserId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_U_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getUserId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_U_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_L_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByP_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_L_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByP_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_L_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_P_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_P_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_P_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBystatusDoc.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountBystatusDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBystatusDoc, args);

				args = new Object[] {legalDocumentModelImpl.getStatusDoc()};

				finderCache.removeResult(_finderPathCountBystatusDoc, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBystatusDoc, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_O_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalOrganizationId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_O_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_O_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getOrganizationId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_O_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_O_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_T_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_T_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_T_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_T_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_T_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_F_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalFieldId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_F_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_F_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getFieldId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_F_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_F_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_F_P_S.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalFieldId(),
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_F_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_F_P_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getFieldId(),
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByG_L_F_P_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_F_P_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalFieldId(),
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Field_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status,
					args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getFieldId(),
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Field_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status,
					args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalOrganizationId(),
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Org_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status,
					args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getOrganizationId(),
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Org_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status,
					args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Type_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status,
					args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Type_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status,
					args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status,
					args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Public_Status,
					args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status,
					args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Company_Language_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Status,
					args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Language_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Language_Status,
					args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Company_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Status,
					args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Company_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Company_Status,
					args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_O.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalOrganizationId()
				};

				finderCache.removeResult(_finderPathCountByG_L_O, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_O, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getOrganizationId()
				};

				finderCache.removeResult(_finderPathCountByG_L_O, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_O, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalTypeId()
				};

				finderCache.removeResult(_finderPathCountByG_L_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_T, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getTypeId()
				};

				finderCache.removeResult(_finderPathCountByG_L_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_T, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_F.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByG_L_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_F, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getFieldId()
				};

				finderCache.removeResult(_finderPathCountByG_L_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_F, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_U_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCreatedByUser(),
					legalDocumentModelImpl.getOriginalLanguage(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByP_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_U_S, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCreatedByUser(),
					legalDocumentModelImpl.getLanguage(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByP_U_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_U_S, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {legalDocumentModelImpl.getStatusDoc()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByIsPublic_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalIsPublic(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByIsPublic_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIsPublic_Status, args);

				args = new Object[] {
					legalDocumentModelImpl.getIsPublic(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(
					_finderPathCountByIsPublic_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByIsPublic_Status, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOrg_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalOrganizationId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByOrg_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrg_Status, args);

				args = new Object[] {
					legalDocumentModelImpl.getOrganizationId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByOrg_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrg_Status, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByType_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalTypeId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByType_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType_Status, args);

				args = new Object[] {
					legalDocumentModelImpl.getTypeId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByType_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByType_Status, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByField_Status.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalFieldId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByField_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField_Status, args);

				args = new Object[] {
					legalDocumentModelImpl.getFieldId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByField_Status, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField_Status, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalTypeId()
				};

				finderCache.removeResult(_finderPathCountByFindType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindType, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getTypeId()
				};

				finderCache.removeResult(_finderPathCountByFindType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindType, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindField.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByFindField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindField, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getFieldId()
				};

				finderCache.removeResult(_finderPathCountByFindField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindField, args);
			}

			if ((legalDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLegalStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDocumentModelImpl.getOriginalGroupId(),
					legalDocumentModelImpl.getOriginalCompanyId(),
					legalDocumentModelImpl.getOriginalStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByLegalStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLegalStatus, args);

				args = new Object[] {
					legalDocumentModelImpl.getGroupId(),
					legalDocumentModelImpl.getCompanyId(),
					legalDocumentModelImpl.getStatusDoc()
				};

				finderCache.removeResult(_finderPathCountByLegalStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLegalStatus, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDocumentImpl.class,
			legalDocument.getPrimaryKey(), legalDocument, false);

		clearUniqueFindersCache(legalDocumentModelImpl, false);
		cacheUniqueFindersCache(legalDocumentModelImpl);

		legalDocument.resetOriginalValues();

		return legalDocument;
	}

	/**
	 * Returns the legal document with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal document
	 * @return the legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDocumentException {

		LegalDocument legalDocument = fetchByPrimaryKey(primaryKey);

		if (legalDocument == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDocumentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDocument;
	}

	/**
	 * Returns the legal document with the primary key or throws a <code>NoSuchLegalDocumentException</code> if it could not be found.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document
	 * @throws NoSuchLegalDocumentException if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument findByPrimaryKey(long docId)
		throws NoSuchLegalDocumentException {

		return findByPrimaryKey((Serializable)docId);
	}

	/**
	 * Returns the legal document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docId the primary key of the legal document
	 * @return the legal document, or <code>null</code> if a legal document with the primary key could not be found
	 */
	@Override
	public LegalDocument fetchByPrimaryKey(long docId) {
		return fetchByPrimaryKey((Serializable)docId);
	}

	/**
	 * Returns all the legal documents.
	 *
	 * @return the legal documents
	 */
	@Override
	public List<LegalDocument> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @return the range of legal documents
	 */
	@Override
	public List<LegalDocument> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal documents
	 */
	@Override
	public List<LegalDocument> findAll(
		int start, int end,
		OrderByComparator<LegalDocument> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal documents
	 * @param end the upper bound of the range of legal documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal documents
	 */
	@Override
	public List<LegalDocument> findAll(
		int start, int end, OrderByComparator<LegalDocument> orderByComparator,
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

		List<LegalDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDocument>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDOCUMENT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDOCUMENT;

				sql = sql.concat(LegalDocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDocument>)QueryUtil.list(
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
	 * Removes all the legal documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDocument legalDocument : findAll()) {
			remove(legalDocument);
		}
	}

	/**
	 * Returns the number of legal documents.
	 *
	 * @return the number of legal documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDOCUMENT);

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
		return "docId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDOCUMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal document persistence.
	 */
	@Activate
	public void activate() {
		LegalDocumentModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDocumentModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDocId",
			new String[] {Long.class.getName()},
			LegalDocumentModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDOC_STATUS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDOC_STATUS",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDOC_STATUS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDOC_STATUS",
			new String[] {Integer.class.getName()},
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDOC_STATUS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDOC_STATUS",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByDocsByF_O_T_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocsByF_O_T_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocsByF_O_T_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocsByF_O_T_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDocsByF_O_T_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocsByF_O_T_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByDocsByG_O_T_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocsByG_O_T_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocsByG_O_T_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocsByG_O_T_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDocsByG_O_T_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocsByG_O_T_L_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByDocsByO_T_F_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocsByO_T_F_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocsByO_T_F_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocsByO_T_F_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDocsByO_T_F_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocsByO_T_F_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindByDocsByPromulDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocsByPromulDate",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocsByPromulDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocsByPromulDate",
			new String[] {Long.class.getName(), Integer.class.getName()},
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDocsByPromulDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDocsByPromulDate",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByDoc_Org = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoc_Org",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDoc_Org = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoc_Org",
			new String[] {Long.class.getName()},
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDoc_Org = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoc_Org",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDoc_Category = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoc_Category",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDoc_Category = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoc_Category",
			new String[] {Long.class.getName()},
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDoc_Category = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoc_Category",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDoc_Field = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDoc_Field",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDoc_Field = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDoc_Field",
			new String[] {Long.class.getName()},
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDoc_Field = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDoc_Field",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByDocsByT_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocsByT_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocsByT_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocsByT_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByDocsByT_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocsByT_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByG_L_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_U_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_U_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.USERID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_U_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

		_finderPathFetchByG_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_D",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.DOCID_COLUMN_BITMASK);

		_finderPathCountByG_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_D",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByP_N_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByP_N_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.NUM_COLUMN_BITMASK |
			LegalDocumentModelImpl.SYMBOL_COLUMN_BITMASK);

		_finderPathCountByP_N_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_N_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByP_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByP_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindBystatusDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatusDoc",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBystatusDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatusDoc",
			new String[] {Integer.class.getName()},
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountBystatusDoc = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatusDoc",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByG_L_O_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_O_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_O_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_O_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_O_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_O_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_L_T_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_T_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_T_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_T_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_T_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_T_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_L_F_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_F_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_F_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_F_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_F_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_F_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_L_F_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_F_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_F_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_F_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_F_P_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_F_P_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Company_Language_Field_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Company_Language_Field_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Company_Language_Field_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Company_Language_Field_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName()
				},
				LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
				LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
				LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
				LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
				LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
				LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Company_Language_Field_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByGroup_Company_Language_Field_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName()
				});

		_finderPathWithPaginationFindByGroup_Company_Language_Org_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Company_Language_Org_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Company_Language_Org_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Company_Language_Org_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName()
				},
				LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
				LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
				LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
				LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
				LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
				LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Company_Language_Org_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByGroup_Company_Language_Org_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName()
				});

		_finderPathWithPaginationFindByGroup_Company_Language_Type_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Company_Language_Type_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Company_Language_Type_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Company_Language_Type_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName()
				},
				LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
				LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
				LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
				LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
				LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
				LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Company_Language_Type_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByGroup_Company_Language_Type_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName()
				});

		_finderPathWithPaginationFindByGroup_Company_Language_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Company_Language_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Company_Language_Public_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Company_Language_Public_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName()
				},
				LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
				LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
				LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
				LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
				LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Company_Language_Public_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Company_Language_Public_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Company_Language_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByGroup_Company_Language_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByGroup_Company_Language_Status =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroup_Company_Language_Status",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), Integer.class.getName()
				},
				LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
				LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
				LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
				LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
				LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Company_Language_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Company_Language_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindByGroup_Company_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroup_Company_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_Company_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroup_Company_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByGroup_Company_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroup_Company_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByG_L_O = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_O",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_O = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_O",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_O = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_O",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByG_L_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByG_L_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_F",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_F",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_F",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByP_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			LegalDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByP_U_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_U_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName()
			});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByIsPublic_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsPublic_Status",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByIsPublic_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsPublic_Status",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			LegalDocumentModelImpl.ISPUBLIC_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByIsPublic_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsPublic_Status",
			new String[] {Integer.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByOrg_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrg_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOrg_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrg_Status",
			new String[] {Long.class.getName(), Integer.class.getName()},
			LegalDocumentModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByOrg_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrg_Status",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByType_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByType_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType_Status",
			new String[] {Long.class.getName(), Integer.class.getName()},
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByType_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType_Status",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByField_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByField_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField_Status",
			new String[] {Long.class.getName(), Integer.class.getName()},
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByField_Status = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField_Status",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByFindType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByFindType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByFindField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindField",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindField",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByFindField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindField",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByLegalStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLegalStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLegalStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLegalStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			LegalDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDocumentModelImpl.STATUSDOC_COLUMN_BITMASK |
			LegalDocumentModelImpl.PROMULDATE_COLUMN_BITMASK);

		_finderPathCountByLegalStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLegalStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDocumentImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDocument"),
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

	private static final String _SQL_SELECT_LEGALDOCUMENT =
		"SELECT legalDocument FROM LegalDocument legalDocument";

	private static final String _SQL_SELECT_LEGALDOCUMENT_WHERE =
		"SELECT legalDocument FROM LegalDocument legalDocument WHERE ";

	private static final String _SQL_COUNT_LEGALDOCUMENT =
		"SELECT COUNT(legalDocument) FROM LegalDocument legalDocument";

	private static final String _SQL_COUNT_LEGALDOCUMENT_WHERE =
		"SELECT COUNT(legalDocument) FROM LegalDocument legalDocument WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDocument.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDocument exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDocument exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDocumentPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}