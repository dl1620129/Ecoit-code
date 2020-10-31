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

import com.ecoit.elegaldocument.exception.NoSuchLegalDraftDocumentException;
import com.ecoit.elegaldocument.model.LegalDraftDocument;
import com.ecoit.elegaldocument.model.impl.LegalDraftDocumentImpl;
import com.ecoit.elegaldocument.model.impl.LegalDraftDocumentModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalDraftDocumentPersistence;
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
 * The persistence implementation for the legal draft document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalDraftDocumentPersistence.class)
public class LegalDraftDocumentPersistenceImpl
	extends BasePersistenceImpl<LegalDraftDocument>
	implements LegalDraftDocumentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalDraftDocumentUtil</code> to access the legal draft document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalDraftDocumentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBydraftId;
	private FinderPath _finderPathCountBydraftId;

	/**
	 * Returns the legal draft document where draftId = &#63; or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param draftId the draft ID
	 * @return the matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findBydraftId(long draftId)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchBydraftId(draftId);

		if (legalDraftDocument == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("draftId=");
			msg.append(draftId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDraftDocumentException(msg.toString());
		}

		return legalDraftDocument;
	}

	/**
	 * Returns the legal draft document where draftId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param draftId the draft ID
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchBydraftId(long draftId) {
		return fetchBydraftId(draftId, true);
	}

	/**
	 * Returns the legal draft document where draftId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param draftId the draft ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchBydraftId(
		long draftId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {draftId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBydraftId, finderArgs, this);
		}

		if (result instanceof LegalDraftDocument) {
			LegalDraftDocument legalDraftDocument = (LegalDraftDocument)result;

			if (draftId != legalDraftDocument.getDraftId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DRAFTID_DRAFTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(draftId);

				List<LegalDraftDocument> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBydraftId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {draftId};
							}

							_log.warn(
								"LegalDraftDocumentPersistenceImpl.fetchBydraftId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDraftDocument legalDraftDocument = list.get(0);

					result = legalDraftDocument;

					cacheResult(legalDraftDocument);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBydraftId, finderArgs);
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
			return (LegalDraftDocument)result;
		}
	}

	/**
	 * Removes the legal draft document where draftId = &#63; from the database.
	 *
	 * @param draftId the draft ID
	 * @return the legal draft document that was removed
	 */
	@Override
	public LegalDraftDocument removeBydraftId(long draftId)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findBydraftId(draftId);

		return remove(legalDraftDocument);
	}

	/**
	 * Returns the number of legal draft documents where draftId = &#63;.
	 *
	 * @param draftId the draft ID
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countBydraftId(long draftId) {
		FinderPath finderPath = _finderPathCountBydraftId;

		Object[] finderArgs = new Object[] {draftId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DRAFTID_DRAFTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(draftId);

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

	private static final String _FINDER_COLUMN_DRAFTID_DRAFTID_2 =
		"legalDraftDocument.draftId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal draft documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
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

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if (groupId != legalDraftDocument.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByGroupId_First(
			long groupId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByGroupId_First(
			groupId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByGroupId_First(
		long groupId, OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByGroupId_Last(
			long groupId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByGroupId_PrevAndNext(
			long draftId, long groupId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalDraftDocument, groupId, orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByGroupId_PrevAndNext(
				session, legalDraftDocument, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDraftDocument getByGroupId_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
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
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalDraftDocument legalDraftDocument :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

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
		"legalDraftDocument.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
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

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						!language.equals(legalDraftDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

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
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByG_L_PrevAndNext(
			long draftId, long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		language = Objects.toString(language, "");

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalDraftDocument, groupId, language,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByG_L_PrevAndNext(
				session, legalDraftDocument, groupId, language,
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

	protected LegalDraftDocument getByG_L_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		String language,
		OrderByComparator<LegalDraftDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
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
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalDraftDocument legalDraftDocument :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

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
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalDraftDocument.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalDraftDocument.language IS NULL OR legalDraftDocument.language = '')";

	private FinderPath _finderPathFetchByG_D;
	private FinderPath _finderPathCountByG_D;

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByG_D(long groupId, long draftId)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByG_D(groupId, draftId);

		if (legalDraftDocument == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", draftId=");
			msg.append(draftId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalDraftDocumentException(msg.toString());
		}

		return legalDraftDocument;
	}

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByG_D(long groupId, long draftId) {
		return fetchByG_D(groupId, draftId, true);
	}

	/**
	 * Returns the legal draft document where groupId = &#63; and draftId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByG_D(
		long groupId, long draftId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, draftId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_D, finderArgs, this);
		}

		if (result instanceof LegalDraftDocument) {
			LegalDraftDocument legalDraftDocument = (LegalDraftDocument)result;

			if ((groupId != legalDraftDocument.getGroupId()) ||
				(draftId != legalDraftDocument.getDraftId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DRAFTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(draftId);

				List<LegalDraftDocument> list = q.list();

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
								finderArgs = new Object[] {groupId, draftId};
							}

							_log.warn(
								"LegalDraftDocumentPersistenceImpl.fetchByG_D(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalDraftDocument legalDraftDocument = list.get(0);

					result = legalDraftDocument;

					cacheResult(legalDraftDocument);
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
			return (LegalDraftDocument)result;
		}
	}

	/**
	 * Removes the legal draft document where groupId = &#63; and draftId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the legal draft document that was removed
	 */
	@Override
	public LegalDraftDocument removeByG_D(long groupId, long draftId)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByG_D(groupId, draftId);

		return remove(legalDraftDocument);
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and draftId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param draftId the draft ID
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByG_D(long groupId, long draftId) {
		FinderPath finderPath = _finderPathCountByG_D;

		Object[] finderArgs = new Object[] {groupId, draftId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_D_GROUPID_2);

			query.append(_FINDER_COLUMN_G_D_DRAFTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(draftId);

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
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_D_DRAFTID_2 =
		"legalDraftDocument.draftId = ?";

	private FinderPath _finderPathWithPaginationFindByP_S_D;
	private FinderPath _finderPathWithoutPaginationFindByP_S_D;
	private FinderPath _finderPathCountByP_S_D;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode) {

		return findByP_S_D(
			groupId, statusDraft, docCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end) {

		return findByP_S_D(groupId, statusDraft, docCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByP_S_D(
			groupId, statusDraft, docCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_D(
		long groupId, int statusDraft, String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		docCode = Objects.toString(docCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_S_D;
				finderArgs = new Object[] {groupId, statusDraft, docCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_S_D;
			finderArgs = new Object[] {
				groupId, statusDraft, docCode, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(statusDraft != legalDraftDocument.getStatusDraft()) ||
						!docCode.equals(legalDraftDocument.getDocCode())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_D_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_D_STATUSDRAFT_2);

			boolean bindDocCode = false;

			if (docCode.isEmpty()) {
				query.append(_FINDER_COLUMN_P_S_D_DOCCODE_3);
			}
			else {
				bindDocCode = true;

				query.append(_FINDER_COLUMN_P_S_D_DOCCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				if (bindDocCode) {
					qPos.add(docCode);
				}

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_D_First(
			long groupId, int statusDraft, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_D_First(
			groupId, statusDraft, docCode, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", docCode=");
		msg.append(docCode);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_D_First(
		long groupId, int statusDraft, String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByP_S_D(
			groupId, statusDraft, docCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_D_Last(
			long groupId, int statusDraft, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_D_Last(
			groupId, statusDraft, docCode, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", docCode=");
		msg.append(docCode);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_D_Last(
		long groupId, int statusDraft, String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByP_S_D(groupId, statusDraft, docCode);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByP_S_D(
			groupId, statusDraft, docCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByP_S_D_PrevAndNext(
			long draftId, long groupId, int statusDraft, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		docCode = Objects.toString(docCode, "");

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByP_S_D_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, docCode,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByP_S_D_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, docCode,
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

	protected LegalDraftDocument getByP_S_D_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		int statusDraft, String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_S_D_GROUPID_2);

		query.append(_FINDER_COLUMN_P_S_D_STATUSDRAFT_2);

		boolean bindDocCode = false;

		if (docCode.isEmpty()) {
			query.append(_FINDER_COLUMN_P_S_D_DOCCODE_3);
		}
		else {
			bindDocCode = true;

			query.append(_FINDER_COLUMN_P_S_D_DOCCODE_2);
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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusDraft);

		if (bindDocCode) {
			qPos.add(docCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 */
	@Override
	public void removeByP_S_D(long groupId, int statusDraft, String docCode) {
		for (LegalDraftDocument legalDraftDocument :
				findByP_S_D(
					groupId, statusDraft, docCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and docCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param docCode the doc code
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByP_S_D(long groupId, int statusDraft, String docCode) {
		docCode = Objects.toString(docCode, "");

		FinderPath finderPath = _finderPathCountByP_S_D;

		Object[] finderArgs = new Object[] {groupId, statusDraft, docCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_D_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_D_STATUSDRAFT_2);

			boolean bindDocCode = false;

			if (docCode.isEmpty()) {
				query.append(_FINDER_COLUMN_P_S_D_DOCCODE_3);
			}
			else {
				bindDocCode = true;

				query.append(_FINDER_COLUMN_P_S_D_DOCCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				if (bindDocCode) {
					qPos.add(docCode);
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

	private static final String _FINDER_COLUMN_P_S_D_GROUPID_2 =
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_S_D_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ? AND ";

	private static final String _FINDER_COLUMN_P_S_D_DOCCODE_2 =
		"legalDraftDocument.docCode = ?";

	private static final String _FINDER_COLUMN_P_S_D_DOCCODE_3 =
		"(legalDraftDocument.docCode IS NULL OR legalDraftDocument.docCode = '')";

	private FinderPath _finderPathWithPaginationFindByDRAFT_STATUS;
	private FinderPath _finderPathWithoutPaginationFindByDRAFT_STATUS;
	private FinderPath _finderPathCountByDRAFT_STATUS;

	/**
	 * Returns all the legal draft documents where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDRAFT_STATUS(int statusDraft) {
		return findByDRAFT_STATUS(
			statusDraft, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end) {

		return findByDRAFT_STATUS(statusDraft, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByDRAFT_STATUS(
			statusDraft, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDRAFT_STATUS(
		int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDRAFT_STATUS;
				finderArgs = new Object[] {statusDraft};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDRAFT_STATUS;
			finderArgs = new Object[] {
				statusDraft, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if (statusDraft != legalDraftDocument.getStatusDraft()) {
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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DRAFT_STATUS_STATUSDRAFT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDraft);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByDRAFT_STATUS_First(
			int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByDRAFT_STATUS_First(
			statusDraft, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDraft=");
		msg.append(statusDraft);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByDRAFT_STATUS_First(
		int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByDRAFT_STATUS(
			statusDraft, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByDRAFT_STATUS_Last(
			int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByDRAFT_STATUS_Last(
			statusDraft, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusDraft=");
		msg.append(statusDraft);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByDRAFT_STATUS_Last(
		int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByDRAFT_STATUS(statusDraft);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByDRAFT_STATUS(
			statusDraft, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where statusDraft = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByDRAFT_STATUS_PrevAndNext(
			long draftId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByDRAFT_STATUS_PrevAndNext(
				session, legalDraftDocument, statusDraft, orderByComparator,
				true);

			array[1] = legalDraftDocument;

			array[2] = getByDRAFT_STATUS_PrevAndNext(
				session, legalDraftDocument, statusDraft, orderByComparator,
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

	protected LegalDraftDocument getByDRAFT_STATUS_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_DRAFT_STATUS_STATUSDRAFT_2);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusDraft);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where statusDraft = &#63; from the database.
	 *
	 * @param statusDraft the status draft
	 */
	@Override
	public void removeByDRAFT_STATUS(int statusDraft) {
		for (LegalDraftDocument legalDraftDocument :
				findByDRAFT_STATUS(
					statusDraft, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where statusDraft = &#63;.
	 *
	 * @param statusDraft the status draft
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByDRAFT_STATUS(int statusDraft) {
		FinderPath finderPath = _finderPathCountByDRAFT_STATUS;

		Object[] finderArgs = new Object[] {statusDraft};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_DRAFT_STATUS_STATUSDRAFT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusDraft);

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

	private static final String _FINDER_COLUMN_DRAFT_STATUS_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ?";

	private FinderPath _finderPathWithPaginationFindByP_S_F;
	private FinderPath _finderPathWithoutPaginationFindByP_S_F;
	private FinderPath _finderPathCountByP_S_F;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId) {

		return findByP_S_F(
			groupId, statusDraft, fieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end) {

		return findByP_S_F(groupId, statusDraft, fieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByP_S_F(
			groupId, statusDraft, fieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_F(
		long groupId, int statusDraft, long fieldId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_S_F;
				finderArgs = new Object[] {groupId, statusDraft, fieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_S_F;
			finderArgs = new Object[] {
				groupId, statusDraft, fieldId, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(statusDraft != legalDraftDocument.getStatusDraft()) ||
						(fieldId != legalDraftDocument.getFieldId())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_F_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_F_STATUSDRAFT_2);

			query.append(_FINDER_COLUMN_P_S_F_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				qPos.add(fieldId);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_F_First(
			long groupId, int statusDraft, long fieldId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_F_First(
			groupId, statusDraft, fieldId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_F_First(
		long groupId, int statusDraft, long fieldId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByP_S_F(
			groupId, statusDraft, fieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_F_Last(
			long groupId, int statusDraft, long fieldId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_F_Last(
			groupId, statusDraft, fieldId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", fieldId=");
		msg.append(fieldId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_F_Last(
		long groupId, int statusDraft, long fieldId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByP_S_F(groupId, statusDraft, fieldId);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByP_S_F(
			groupId, statusDraft, fieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByP_S_F_PrevAndNext(
			long draftId, long groupId, int statusDraft, long fieldId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByP_S_F_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, fieldId,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByP_S_F_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, fieldId,
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

	protected LegalDraftDocument getByP_S_F_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		int statusDraft, long fieldId,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_S_F_GROUPID_2);

		query.append(_FINDER_COLUMN_P_S_F_STATUSDRAFT_2);

		query.append(_FINDER_COLUMN_P_S_F_FIELDID_2);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusDraft);

		qPos.add(fieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 */
	@Override
	public void removeByP_S_F(long groupId, int statusDraft, long fieldId) {
		for (LegalDraftDocument legalDraftDocument :
				findByP_S_F(
					groupId, statusDraft, fieldId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and fieldId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param fieldId the field ID
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByP_S_F(long groupId, int statusDraft, long fieldId) {
		FinderPath finderPath = _finderPathCountByP_S_F;

		Object[] finderArgs = new Object[] {groupId, statusDraft, fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_F_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_F_STATUSDRAFT_2);

			query.append(_FINDER_COLUMN_P_S_F_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

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

	private static final String _FINDER_COLUMN_P_S_F_GROUPID_2 =
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_S_F_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ? AND ";

	private static final String _FINDER_COLUMN_P_S_F_FIELDID_2 =
		"legalDraftDocument.fieldId = ?";

	private FinderPath _finderPathWithPaginationFindByP_S_T;
	private FinderPath _finderPathWithoutPaginationFindByP_S_T;
	private FinderPath _finderPathCountByP_S_T;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId) {

		return findByP_S_T(
			groupId, statusDraft, typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end) {

		return findByP_S_T(groupId, statusDraft, typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByP_S_T(
			groupId, statusDraft, typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_T(
		long groupId, int statusDraft, long typeId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_S_T;
				finderArgs = new Object[] {groupId, statusDraft, typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_S_T;
			finderArgs = new Object[] {
				groupId, statusDraft, typeId, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(statusDraft != legalDraftDocument.getStatusDraft()) ||
						(typeId != legalDraftDocument.getTypeId())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_T_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_T_STATUSDRAFT_2);

			query.append(_FINDER_COLUMN_P_S_T_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				qPos.add(typeId);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_T_First(
			long groupId, int statusDraft, long typeId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_T_First(
			groupId, statusDraft, typeId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_T_First(
		long groupId, int statusDraft, long typeId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByP_S_T(
			groupId, statusDraft, typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_T_Last(
			long groupId, int statusDraft, long typeId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_T_Last(
			groupId, statusDraft, typeId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", typeId=");
		msg.append(typeId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_T_Last(
		long groupId, int statusDraft, long typeId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByP_S_T(groupId, statusDraft, typeId);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByP_S_T(
			groupId, statusDraft, typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByP_S_T_PrevAndNext(
			long draftId, long groupId, int statusDraft, long typeId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByP_S_T_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, typeId,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByP_S_T_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, typeId,
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

	protected LegalDraftDocument getByP_S_T_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		int statusDraft, long typeId,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_S_T_GROUPID_2);

		query.append(_FINDER_COLUMN_P_S_T_STATUSDRAFT_2);

		query.append(_FINDER_COLUMN_P_S_T_TYPEID_2);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusDraft);

		qPos.add(typeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 */
	@Override
	public void removeByP_S_T(long groupId, int statusDraft, long typeId) {
		for (LegalDraftDocument legalDraftDocument :
				findByP_S_T(
					groupId, statusDraft, typeId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and typeId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param typeId the type ID
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByP_S_T(long groupId, int statusDraft, long typeId) {
		FinderPath finderPath = _finderPathCountByP_S_T;

		Object[] finderArgs = new Object[] {groupId, statusDraft, typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_T_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_T_STATUSDRAFT_2);

			query.append(_FINDER_COLUMN_P_S_T_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

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

	private static final String _FINDER_COLUMN_P_S_T_GROUPID_2 =
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_S_T_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ? AND ";

	private static final String _FINDER_COLUMN_P_S_T_TYPEID_2 =
		"legalDraftDocument.typeId = ?";

	private FinderPath _finderPathWithPaginationFindByP_S_L;
	private FinderPath _finderPathWithoutPaginationFindByP_S_L;
	private FinderPath _finderPathCountByP_S_L;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language) {

		return findByP_S_L(
			groupId, statusDraft, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end) {

		return findByP_S_L(groupId, statusDraft, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByP_S_L(
			groupId, statusDraft, language, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_L(
		long groupId, int statusDraft, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_S_L;
				finderArgs = new Object[] {groupId, statusDraft, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_S_L;
			finderArgs = new Object[] {
				groupId, statusDraft, language, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(statusDraft != legalDraftDocument.getStatusDraft()) ||
						!language.equals(legalDraftDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_L_STATUSDRAFT_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_S_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_S_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_L_First(
			long groupId, int statusDraft, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_L_First(
			groupId, statusDraft, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_L_First(
		long groupId, int statusDraft, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByP_S_L(
			groupId, statusDraft, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_L_Last(
			long groupId, int statusDraft, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_L_Last(
			groupId, statusDraft, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_L_Last(
		long groupId, int statusDraft, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByP_S_L(groupId, statusDraft, language);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByP_S_L(
			groupId, statusDraft, language, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByP_S_L_PrevAndNext(
			long draftId, long groupId, int statusDraft, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		language = Objects.toString(language, "");

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByP_S_L_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, language,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByP_S_L_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft, language,
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

	protected LegalDraftDocument getByP_S_L_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		int statusDraft, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_S_L_GROUPID_2);

		query.append(_FINDER_COLUMN_P_S_L_STATUSDRAFT_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_P_S_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_P_S_L_LANGUAGE_2);
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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusDraft);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 */
	@Override
	public void removeByP_S_L(long groupId, int statusDraft, String language) {
		for (LegalDraftDocument legalDraftDocument :
				findByP_S_L(
					groupId, statusDraft, language, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByP_S_L(long groupId, int statusDraft, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByP_S_L;

		Object[] finderArgs = new Object[] {groupId, statusDraft, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_L_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_L_STATUSDRAFT_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_S_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_S_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

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

	private static final String _FINDER_COLUMN_P_S_L_GROUPID_2 =
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_S_L_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ? AND ";

	private static final String _FINDER_COLUMN_P_S_L_LANGUAGE_2 =
		"legalDraftDocument.language = ?";

	private static final String _FINDER_COLUMN_P_S_L_LANGUAGE_3 =
		"(legalDraftDocument.language IS NULL OR legalDraftDocument.language = '')";

	private FinderPath _finderPathWithPaginationFindByP_L;
	private FinderPath _finderPathWithoutPaginationFindByP_L;
	private FinderPath _finderPathCountByP_L;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_L(long groupId, String language) {
		return findByP_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end) {

		return findByP_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByP_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_L;
				finderArgs = new Object[] {groupId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_L;
			finderArgs = new Object[] {
				groupId, language, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						!language.equals(legalDraftDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_L_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_L_First(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_L_First(
			groupId, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_L_First(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByP_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_L_Last(
			long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_L_Last(
			groupId, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_L_Last(
		long groupId, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByP_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByP_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByP_L_PrevAndNext(
			long draftId, long groupId, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		language = Objects.toString(language, "");

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByP_L_PrevAndNext(
				session, legalDraftDocument, groupId, language,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByP_L_PrevAndNext(
				session, legalDraftDocument, groupId, language,
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

	protected LegalDraftDocument getByP_L_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		String language,
		OrderByComparator<LegalDraftDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_L_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_P_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_P_L_LANGUAGE_2);
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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
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
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByP_L(long groupId, String language) {
		for (LegalDraftDocument legalDraftDocument :
				findByP_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByP_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByP_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_L_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_L_LANGUAGE_2);
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

	private static final String _FINDER_COLUMN_P_L_GROUPID_2 =
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_L_LANGUAGE_2 =
		"legalDraftDocument.language = ?";

	private static final String _FINDER_COLUMN_P_L_LANGUAGE_3 =
		"(legalDraftDocument.language IS NULL OR legalDraftDocument.language = '')";

	private FinderPath _finderPathWithPaginationFindByP_S_U_L;
	private FinderPath _finderPathWithoutPaginationFindByP_S_U_L;
	private FinderPath _finderPathCountByP_S_U_L;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language) {

		return findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end) {

		return findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language,
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_S_U_L;
				finderArgs = new Object[] {
					groupId, statusDraft, createdByUser, language
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_S_U_L;
			finderArgs = new Object[] {
				groupId, statusDraft, createdByUser, language, start, end,
				orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(statusDraft != legalDraftDocument.getStatusDraft()) ||
						(createdByUser !=
							legalDraftDocument.getCreatedByUser()) ||
						!language.equals(legalDraftDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_U_L_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_U_L_STATUSDRAFT_2);

			query.append(_FINDER_COLUMN_P_S_U_L_CREATEDBYUSER_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_S_U_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_S_U_L_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				qPos.add(createdByUser);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_U_L_First(
			long groupId, int statusDraft, long createdByUser, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_U_L_First(
			groupId, statusDraft, createdByUser, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", createdByUser=");
		msg.append(createdByUser);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_U_L_First(
		long groupId, int statusDraft, long createdByUser, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByP_S_U_L_Last(
			long groupId, int statusDraft, long createdByUser, String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByP_S_U_L_Last(
			groupId, statusDraft, createdByUser, language, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append(", createdByUser=");
		msg.append(createdByUser);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByP_S_U_L_Last(
		long groupId, int statusDraft, long createdByUser, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByP_S_U_L(
			groupId, statusDraft, createdByUser, language);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByP_S_U_L(
			groupId, statusDraft, createdByUser, language, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByP_S_U_L_PrevAndNext(
			long draftId, long groupId, int statusDraft, long createdByUser,
			String language,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		language = Objects.toString(language, "");

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByP_S_U_L_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft,
				createdByUser, language, orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByP_S_U_L_PrevAndNext(
				session, legalDraftDocument, groupId, statusDraft,
				createdByUser, language, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDraftDocument getByP_S_U_L_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		int statusDraft, long createdByUser, String language,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_S_U_L_GROUPID_2);

		query.append(_FINDER_COLUMN_P_S_U_L_STATUSDRAFT_2);

		query.append(_FINDER_COLUMN_P_S_U_L_CREATEDBYUSER_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_P_S_U_L_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_P_S_U_L_LANGUAGE_2);
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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(statusDraft);

		qPos.add(createdByUser);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 */
	@Override
	public void removeByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language) {

		for (LegalDraftDocument legalDraftDocument :
				findByP_S_U_L(
					groupId, statusDraft, createdByUser, language,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and statusDraft = &#63; and createdByUser = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param statusDraft the status draft
	 * @param createdByUser the created by user
	 * @param language the language
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByP_S_U_L(
		long groupId, int statusDraft, long createdByUser, String language) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByP_S_U_L;

		Object[] finderArgs = new Object[] {
			groupId, statusDraft, createdByUser, language
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_S_U_L_GROUPID_2);

			query.append(_FINDER_COLUMN_P_S_U_L_STATUSDRAFT_2);

			query.append(_FINDER_COLUMN_P_S_U_L_CREATEDBYUSER_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_S_U_L_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_S_U_L_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(statusDraft);

				qPos.add(createdByUser);

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

	private static final String _FINDER_COLUMN_P_S_U_L_GROUPID_2 =
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_S_U_L_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ? AND ";

	private static final String _FINDER_COLUMN_P_S_U_L_CREATEDBYUSER_2 =
		"legalDraftDocument.createdByUser = ? AND ";

	private static final String _FINDER_COLUMN_P_S_U_L_LANGUAGE_2 =
		"legalDraftDocument.language = ?";

	private static final String _FINDER_COLUMN_P_S_U_L_LANGUAGE_3 =
		"(legalDraftDocument.language IS NULL OR legalDraftDocument.language = '')";

	private FinderPath _finderPathWithPaginationFindByDocCode;
	private FinderPath _finderPathWithoutPaginationFindByDocCode;
	private FinderPath _finderPathCountByDocCode;

	/**
	 * Returns all the legal draft documents where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDocCode(String docCode) {
		return findByDocCode(
			docCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end) {

		return findByDocCode(docCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByDocCode(docCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where docCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docCode the doc code
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByDocCode(
		String docCode, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		docCode = Objects.toString(docCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDocCode;
				finderArgs = new Object[] {docCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDocCode;
			finderArgs = new Object[] {docCode, start, end, orderByComparator};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if (!docCode.equals(legalDraftDocument.getDocCode())) {
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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			boolean bindDocCode = false;

			if (docCode.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCCODE_DOCCODE_3);
			}
			else {
				bindDocCode = true;

				query.append(_FINDER_COLUMN_DOCCODE_DOCCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocCode) {
					qPos.add(docCode);
				}

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByDocCode_First(
			String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByDocCode_First(
			docCode, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docCode=");
		msg.append(docCode);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByDocCode_First(
		String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByDocCode(
			docCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByDocCode_Last(
			String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByDocCode_Last(
			docCode, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docCode=");
		msg.append(docCode);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByDocCode_Last(
		String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByDocCode(docCode);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByDocCode(
			docCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where docCode = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param docCode the doc code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByDocCode_PrevAndNext(
			long draftId, String docCode,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		docCode = Objects.toString(docCode, "");

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByDocCode_PrevAndNext(
				session, legalDraftDocument, docCode, orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByDocCode_PrevAndNext(
				session, legalDraftDocument, docCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalDraftDocument getByDocCode_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, String docCode,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		boolean bindDocCode = false;

		if (docCode.isEmpty()) {
			query.append(_FINDER_COLUMN_DOCCODE_DOCCODE_3);
		}
		else {
			bindDocCode = true;

			query.append(_FINDER_COLUMN_DOCCODE_DOCCODE_2);
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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDocCode) {
			qPos.add(docCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where docCode = &#63; from the database.
	 *
	 * @param docCode the doc code
	 */
	@Override
	public void removeByDocCode(String docCode) {
		for (LegalDraftDocument legalDraftDocument :
				findByDocCode(
					docCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where docCode = &#63;.
	 *
	 * @param docCode the doc code
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByDocCode(String docCode) {
		docCode = Objects.toString(docCode, "");

		FinderPath finderPath = _finderPathCountByDocCode;

		Object[] finderArgs = new Object[] {docCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			boolean bindDocCode = false;

			if (docCode.isEmpty()) {
				query.append(_FINDER_COLUMN_DOCCODE_DOCCODE_3);
			}
			else {
				bindDocCode = true;

				query.append(_FINDER_COLUMN_DOCCODE_DOCCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDocCode) {
					qPos.add(docCode);
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

	private static final String _FINDER_COLUMN_DOCCODE_DOCCODE_2 =
		"legalDraftDocument.docCode = ?";

	private static final String _FINDER_COLUMN_DOCCODE_DOCCODE_3 =
		"(legalDraftDocument.docCode IS NULL OR legalDraftDocument.docCode = '')";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft) {

		return findByFindGroup(
			groupId, companyId, statusDraft, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end) {

		return findByFindGroup(
			groupId, companyId, statusDraft, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, statusDraft, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindGroup(
		long groupId, long companyId, int statusDraft, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {groupId, companyId, statusDraft};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, statusDraft, start, end, orderByComparator
			};
		}

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(companyId != legalDraftDocument.getCompanyId()) ||
						(statusDraft != legalDraftDocument.getStatusDraft())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSDRAFT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDraft);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByFindGroup_First(
			long groupId, long companyId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByFindGroup_First(
			groupId, companyId, statusDraft, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByFindGroup_First(
		long groupId, long companyId, int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByFindGroup(
			groupId, companyId, statusDraft, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByFindGroup_Last(
			long groupId, long companyId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByFindGroup_Last(
			groupId, companyId, statusDraft, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusDraft=");
		msg.append(statusDraft);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByFindGroup_Last(
		long groupId, long companyId, int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByFindGroup(groupId, companyId, statusDraft);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByFindGroup(
			groupId, companyId, statusDraft, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByFindGroup_PrevAndNext(
			long draftId, long groupId, long companyId, int statusDraft,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalDraftDocument, groupId, companyId, statusDraft,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalDraftDocument, groupId, companyId, statusDraft,
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

	protected LegalDraftDocument getByFindGroup_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		long companyId, int statusDraft,
		OrderByComparator<LegalDraftDocument> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_STATUSDRAFT_2);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusDraft);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 */
	@Override
	public void removeByFindGroup(
		long groupId, long companyId, int statusDraft) {

		for (LegalDraftDocument legalDraftDocument :
				findByFindGroup(
					groupId, companyId, statusDraft, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and companyId = &#63; and statusDraft = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusDraft the status draft
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByFindGroup(long groupId, long companyId, int statusDraft) {
		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId, statusDraft};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSDRAFT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusDraft);

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
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalDraftDocument.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_STATUSDRAFT_2 =
		"legalDraftDocument.statusDraft = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId) {

		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
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

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalDraftDocument legalDraftDocument : list) {
					if ((groupId != legalDraftDocument.getGroupId()) ||
						(companyId != legalDraftDocument.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		List<LegalDraftDocument> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalDraftDocument != null) {
			return legalDraftDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalDraftDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal draft document, or <code>null</code> if a matching legal draft document could not be found
	 */
	@Override
	public LegalDraftDocument fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalDraftDocument> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal draft documents before and after the current legal draft document in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param draftId the primary key of the current legal draft document
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument[] findByFindAll_PrevAndNext(
			long draftId, long groupId, long companyId,
			OrderByComparator<LegalDraftDocument> orderByComparator)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = findByPrimaryKey(draftId);

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument[] array = new LegalDraftDocumentImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalDraftDocument, groupId, companyId,
				orderByComparator, true);

			array[1] = legalDraftDocument;

			array[2] = getByFindAll_PrevAndNext(
				session, legalDraftDocument, groupId, companyId,
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

	protected LegalDraftDocument getByFindAll_PrevAndNext(
		Session session, LegalDraftDocument legalDraftDocument, long groupId,
		long companyId, OrderByComparator<LegalDraftDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE);

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
			query.append(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
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
						legalDraftDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalDraftDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal draft documents where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalDraftDocument legalDraftDocument :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal draft documents
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE);

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
		"legalDraftDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalDraftDocument.companyId = ?";

	public LegalDraftDocumentPersistenceImpl() {
		setModelClass(LegalDraftDocument.class);

		setModelImplClass(LegalDraftDocumentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal draft document in the entity cache if it is enabled.
	 *
	 * @param legalDraftDocument the legal draft document
	 */
	@Override
	public void cacheResult(LegalDraftDocument legalDraftDocument) {
		entityCache.putResult(
			entityCacheEnabled, LegalDraftDocumentImpl.class,
			legalDraftDocument.getPrimaryKey(), legalDraftDocument);

		finderCache.putResult(
			_finderPathFetchBydraftId,
			new Object[] {legalDraftDocument.getDraftId()}, legalDraftDocument);

		finderCache.putResult(
			_finderPathFetchByG_D,
			new Object[] {
				legalDraftDocument.getGroupId(), legalDraftDocument.getDraftId()
			},
			legalDraftDocument);

		legalDraftDocument.resetOriginalValues();
	}

	/**
	 * Caches the legal draft documents in the entity cache if it is enabled.
	 *
	 * @param legalDraftDocuments the legal draft documents
	 */
	@Override
	public void cacheResult(List<LegalDraftDocument> legalDraftDocuments) {
		for (LegalDraftDocument legalDraftDocument : legalDraftDocuments) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalDraftDocumentImpl.class,
					legalDraftDocument.getPrimaryKey()) == null) {

				cacheResult(legalDraftDocument);
			}
			else {
				legalDraftDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal draft documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalDraftDocumentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal draft document.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalDraftDocument legalDraftDocument) {
		entityCache.removeResult(
			entityCacheEnabled, LegalDraftDocumentImpl.class,
			legalDraftDocument.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(LegalDraftDocumentModelImpl)legalDraftDocument, true);
	}

	@Override
	public void clearCache(List<LegalDraftDocument> legalDraftDocuments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalDraftDocument legalDraftDocument : legalDraftDocuments) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDraftDocumentImpl.class,
				legalDraftDocument.getPrimaryKey());

			clearUniqueFindersCache(
				(LegalDraftDocumentModelImpl)legalDraftDocument, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalDraftDocumentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalDraftDocumentModelImpl legalDraftDocumentModelImpl) {

		Object[] args = new Object[] {legalDraftDocumentModelImpl.getDraftId()};

		finderCache.putResult(
			_finderPathCountBydraftId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBydraftId, args, legalDraftDocumentModelImpl,
			false);

		args = new Object[] {
			legalDraftDocumentModelImpl.getGroupId(),
			legalDraftDocumentModelImpl.getDraftId()
		};

		finderCache.putResult(
			_finderPathCountByG_D, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_D, args, legalDraftDocumentModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalDraftDocumentModelImpl legalDraftDocumentModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalDraftDocumentModelImpl.getDraftId()
			};

			finderCache.removeResult(_finderPathCountBydraftId, args);
			finderCache.removeResult(_finderPathFetchBydraftId, args);
		}

		if ((legalDraftDocumentModelImpl.getColumnBitmask() &
			 _finderPathFetchBydraftId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDraftDocumentModelImpl.getOriginalDraftId()
			};

			finderCache.removeResult(_finderPathCountBydraftId, args);
			finderCache.removeResult(_finderPathFetchBydraftId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getDraftId()
			};

			finderCache.removeResult(_finderPathCountByG_D, args);
			finderCache.removeResult(_finderPathFetchByG_D, args);
		}

		if ((legalDraftDocumentModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_D.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalDraftDocumentModelImpl.getOriginalGroupId(),
				legalDraftDocumentModelImpl.getOriginalDraftId()
			};

			finderCache.removeResult(_finderPathCountByG_D, args);
			finderCache.removeResult(_finderPathFetchByG_D, args);
		}
	}

	/**
	 * Creates a new legal draft document with the primary key. Does not add the legal draft document to the database.
	 *
	 * @param draftId the primary key for the new legal draft document
	 * @return the new legal draft document
	 */
	@Override
	public LegalDraftDocument create(long draftId) {
		LegalDraftDocument legalDraftDocument = new LegalDraftDocumentImpl();

		legalDraftDocument.setNew(true);
		legalDraftDocument.setPrimaryKey(draftId);

		legalDraftDocument.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalDraftDocument;
	}

	/**
	 * Removes the legal draft document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document that was removed
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument remove(long draftId)
		throws NoSuchLegalDraftDocumentException {

		return remove((Serializable)draftId);
	}

	/**
	 * Removes the legal draft document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal draft document
	 * @return the legal draft document that was removed
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument remove(Serializable primaryKey)
		throws NoSuchLegalDraftDocumentException {

		Session session = null;

		try {
			session = openSession();

			LegalDraftDocument legalDraftDocument =
				(LegalDraftDocument)session.get(
					LegalDraftDocumentImpl.class, primaryKey);

			if (legalDraftDocument == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalDraftDocumentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalDraftDocument);
		}
		catch (NoSuchLegalDraftDocumentException noSuchEntityException) {
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
	protected LegalDraftDocument removeImpl(
		LegalDraftDocument legalDraftDocument) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalDraftDocument)) {
				legalDraftDocument = (LegalDraftDocument)session.get(
					LegalDraftDocumentImpl.class,
					legalDraftDocument.getPrimaryKeyObj());
			}

			if (legalDraftDocument != null) {
				session.delete(legalDraftDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalDraftDocument != null) {
			clearCache(legalDraftDocument);
		}

		return legalDraftDocument;
	}

	@Override
	public LegalDraftDocument updateImpl(
		LegalDraftDocument legalDraftDocument) {

		boolean isNew = legalDraftDocument.isNew();

		if (!(legalDraftDocument instanceof LegalDraftDocumentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalDraftDocument.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalDraftDocument);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalDraftDocument proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalDraftDocument implementation " +
					legalDraftDocument.getClass());
		}

		LegalDraftDocumentModelImpl legalDraftDocumentModelImpl =
			(LegalDraftDocumentModelImpl)legalDraftDocument;

		Session session = null;

		try {
			session = openSession();

			if (legalDraftDocument.isNew()) {
				session.save(legalDraftDocument);

				legalDraftDocument.setNew(false);
			}
			else {
				legalDraftDocument = (LegalDraftDocument)session.merge(
					legalDraftDocument);
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
				legalDraftDocumentModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getStatusDraft(),
				legalDraftDocumentModelImpl.getDocCode()
			};

			finderCache.removeResult(_finderPathCountByP_S_D, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_S_D, args);

			args = new Object[] {legalDraftDocumentModelImpl.getStatusDraft()};

			finderCache.removeResult(_finderPathCountByDRAFT_STATUS, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDRAFT_STATUS, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getStatusDraft(),
				legalDraftDocumentModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByP_S_F, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_S_F, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getStatusDraft(),
				legalDraftDocumentModelImpl.getTypeId()
			};

			finderCache.removeResult(_finderPathCountByP_S_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_S_T, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getStatusDraft(),
				legalDraftDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByP_S_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_S_L, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByP_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_L, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getStatusDraft(),
				legalDraftDocumentModelImpl.getCreatedByUser(),
				legalDraftDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByP_S_U_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_S_U_L, args);

			args = new Object[] {legalDraftDocumentModelImpl.getDocCode()};

			finderCache.removeResult(_finderPathCountByDocCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDocCode, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getCompanyId(),
				legalDraftDocumentModelImpl.getStatusDraft()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalDraftDocumentModelImpl.getGroupId(),
				legalDraftDocumentModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalDraftDocumentModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_S_D.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalStatusDraft(),
					legalDraftDocumentModelImpl.getOriginalDocCode()
				};

				finderCache.removeResult(_finderPathCountByP_S_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_D, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getStatusDraft(),
					legalDraftDocumentModelImpl.getDocCode()
				};

				finderCache.removeResult(_finderPathCountByP_S_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_D, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDRAFT_STATUS.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalStatusDraft()
				};

				finderCache.removeResult(_finderPathCountByDRAFT_STATUS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDRAFT_STATUS, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getStatusDraft()
				};

				finderCache.removeResult(_finderPathCountByDRAFT_STATUS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDRAFT_STATUS, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_S_F.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalStatusDraft(),
					legalDraftDocumentModelImpl.getOriginalFieldId()
				};

				finderCache.removeResult(_finderPathCountByP_S_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_F, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getStatusDraft(),
					legalDraftDocumentModelImpl.getFieldId()
				};

				finderCache.removeResult(_finderPathCountByP_S_F, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_F, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_S_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalStatusDraft(),
					legalDraftDocumentModelImpl.getOriginalTypeId()
				};

				finderCache.removeResult(_finderPathCountByP_S_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_T, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getStatusDraft(),
					legalDraftDocumentModelImpl.getTypeId()
				};

				finderCache.removeResult(_finderPathCountByP_S_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_T, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_S_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalStatusDraft(),
					legalDraftDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByP_S_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_L, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getStatusDraft(),
					legalDraftDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByP_S_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_L, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByP_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_L, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByP_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_L, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_S_U_L.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalStatusDraft(),
					legalDraftDocumentModelImpl.getOriginalCreatedByUser(),
					legalDraftDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByP_S_U_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_U_L, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getStatusDraft(),
					legalDraftDocumentModelImpl.getCreatedByUser(),
					legalDraftDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByP_S_U_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_S_U_L, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDocCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalDocCode()
				};

				finderCache.removeResult(_finderPathCountByDocCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocCode, args);

				args = new Object[] {legalDraftDocumentModelImpl.getDocCode()};

				finderCache.removeResult(_finderPathCountByDocCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDocCode, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalCompanyId(),
					legalDraftDocumentModelImpl.getOriginalStatusDraft()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getCompanyId(),
					legalDraftDocumentModelImpl.getStatusDraft()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalDraftDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalDraftDocumentModelImpl.getOriginalGroupId(),
					legalDraftDocumentModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalDraftDocumentModelImpl.getGroupId(),
					legalDraftDocumentModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalDraftDocumentImpl.class,
			legalDraftDocument.getPrimaryKey(), legalDraftDocument, false);

		clearUniqueFindersCache(legalDraftDocumentModelImpl, false);
		cacheUniqueFindersCache(legalDraftDocumentModelImpl);

		legalDraftDocument.resetOriginalValues();

		return legalDraftDocument;
	}

	/**
	 * Returns the legal draft document with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal draft document
	 * @return the legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalDraftDocumentException {

		LegalDraftDocument legalDraftDocument = fetchByPrimaryKey(primaryKey);

		if (legalDraftDocument == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalDraftDocumentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalDraftDocument;
	}

	/**
	 * Returns the legal draft document with the primary key or throws a <code>NoSuchLegalDraftDocumentException</code> if it could not be found.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document
	 * @throws NoSuchLegalDraftDocumentException if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument findByPrimaryKey(long draftId)
		throws NoSuchLegalDraftDocumentException {

		return findByPrimaryKey((Serializable)draftId);
	}

	/**
	 * Returns the legal draft document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param draftId the primary key of the legal draft document
	 * @return the legal draft document, or <code>null</code> if a legal draft document with the primary key could not be found
	 */
	@Override
	public LegalDraftDocument fetchByPrimaryKey(long draftId) {
		return fetchByPrimaryKey((Serializable)draftId);
	}

	/**
	 * Returns all the legal draft documents.
	 *
	 * @return the legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @return the range of legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findAll(
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal draft documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDraftDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal draft documents
	 * @param end the upper bound of the range of legal draft documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal draft documents
	 */
	@Override
	public List<LegalDraftDocument> findAll(
		int start, int end,
		OrderByComparator<LegalDraftDocument> orderByComparator,
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

		List<LegalDraftDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalDraftDocument>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALDRAFTDOCUMENT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALDRAFTDOCUMENT;

				sql = sql.concat(LegalDraftDocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalDraftDocument>)QueryUtil.list(
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
	 * Removes all the legal draft documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalDraftDocument legalDraftDocument : findAll()) {
			remove(legalDraftDocument);
		}
	}

	/**
	 * Returns the number of legal draft documents.
	 *
	 * @return the number of legal draft documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALDRAFTDOCUMENT);

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
		return "draftId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALDRAFTDOCUMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalDraftDocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal draft document persistence.
	 */
	@Activate
	public void activate() {
		LegalDraftDocumentModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalDraftDocumentModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBydraftId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBydraftId", new String[] {Long.class.getName()},
			LegalDraftDocumentModelImpl.DRAFTID_COLUMN_BITMASK);

		_finderPathCountBydraftId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydraftId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByG_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_D",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.DRAFTID_COLUMN_BITMASK);

		_finderPathCountByG_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_D",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByP_S_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S_D",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_S_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S_D",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.DOCCODE_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_S_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S_D",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByDRAFT_STATUS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDRAFT_STATUS",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDRAFT_STATUS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDRAFT_STATUS",
			new String[] {Integer.class.getName()},
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByDRAFT_STATUS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDRAFT_STATUS",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByP_S_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S_F",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_S_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S_F",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.FIELDID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_S_F = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S_F",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByP_S_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_S_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.TYPEID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_S_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByP_S_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S_L",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_S_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S_L",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_S_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S_L",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByP_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByP_S_U_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_S_U_L",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_S_U_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_S_U_L",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_S_U_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_S_U_L",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), String.class.getName()
			});

		_finderPathWithPaginationFindByDocCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDocCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocCode",
			new String[] {String.class.getName()},
			LegalDraftDocumentModelImpl.DOCCODE_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByDocCode = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocCode",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.STATUSDRAFT_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalDraftDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalDraftDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalDraftDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalDraftDocumentImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalDraftDocument"),
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

	private static final String _SQL_SELECT_LEGALDRAFTDOCUMENT =
		"SELECT legalDraftDocument FROM LegalDraftDocument legalDraftDocument";

	private static final String _SQL_SELECT_LEGALDRAFTDOCUMENT_WHERE =
		"SELECT legalDraftDocument FROM LegalDraftDocument legalDraftDocument WHERE ";

	private static final String _SQL_COUNT_LEGALDRAFTDOCUMENT =
		"SELECT COUNT(legalDraftDocument) FROM LegalDraftDocument legalDraftDocument";

	private static final String _SQL_COUNT_LEGALDRAFTDOCUMENT_WHERE =
		"SELECT COUNT(legalDraftDocument) FROM LegalDraftDocument legalDraftDocument WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalDraftDocument.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalDraftDocument exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalDraftDocument exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalDraftDocumentPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}