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

import com.ecoit.elegaldocument.exception.NoSuchLegalSuggestDocumentException;
import com.ecoit.elegaldocument.model.LegalSuggestDocument;
import com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentImpl;
import com.ecoit.elegaldocument.model.impl.LegalSuggestDocumentModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalSuggestDocumentPersistence;
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
 * The persistence implementation for the legal suggest document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalSuggestDocumentPersistence.class)
public class LegalSuggestDocumentPersistenceImpl
	extends BasePersistenceImpl<LegalSuggestDocument>
	implements LegalSuggestDocumentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalSuggestDocumentUtil</code> to access the legal suggest document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalSuggestDocumentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal suggest documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if (groupId != legalSuggestDocument.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByGroupId_First(
			long groupId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByGroupId_First(
			groupId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByGroupId_First(
		long groupId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByGroupId_Last(
			long groupId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByGroupId_Last(
		long groupId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findByGroupId_PrevAndNext(
			long sugId, long groupId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalSuggestDocument, groupId, orderByComparator,
				true);

			array[1] = legalSuggestDocument;

			array[2] = getByGroupId_PrevAndNext(
				session, legalSuggestDocument, groupId, orderByComparator,
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

	protected LegalSuggestDocument getByGroupId_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument,
		long groupId, OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalSuggestDocument legalSuggestDocument :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

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
		"legalSuggestDocument.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByP_A;
	private FinderPath _finderPathWithoutPaginationFindByP_A;
	private FinderPath _finderPathCountByP_A;

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved) {

		return findByP_A(
			groupId, approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end) {

		return findByP_A(groupId, approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findByP_A(
			groupId, approved, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_A(
		long groupId, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_A;
				finderArgs = new Object[] {groupId, approved};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_A;
			finderArgs = new Object[] {
				groupId, approved, start, end, orderByComparator
			};
		}

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if ((groupId != legalSuggestDocument.getGroupId()) ||
						(approved != legalSuggestDocument.isApproved())) {

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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_A_GROUPID_2);

			query.append(_FINDER_COLUMN_P_A_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(approved);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByP_A_First(
			long groupId, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByP_A_First(
			groupId, approved, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", approved=");
		msg.append(approved);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByP_A_First(
		long groupId, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findByP_A(
			groupId, approved, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByP_A_Last(
			long groupId, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByP_A_Last(
			groupId, approved, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", approved=");
		msg.append(approved);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByP_A_Last(
		long groupId, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countByP_A(groupId, approved);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findByP_A(
			groupId, approved, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findByP_A_PrevAndNext(
			long sugId, long groupId, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getByP_A_PrevAndNext(
				session, legalSuggestDocument, groupId, approved,
				orderByComparator, true);

			array[1] = legalSuggestDocument;

			array[2] = getByP_A_PrevAndNext(
				session, legalSuggestDocument, groupId, approved,
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

	protected LegalSuggestDocument getByP_A_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument,
		long groupId, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_A_GROUPID_2);

		query.append(_FINDER_COLUMN_P_A_APPROVED_2);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(approved);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 */
	@Override
	public void removeByP_A(long groupId, boolean approved) {
		for (LegalSuggestDocument legalSuggestDocument :
				findByP_A(
					groupId, approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByP_A(long groupId, boolean approved) {
		FinderPath finderPath = _finderPathCountByP_A;

		Object[] finderArgs = new Object[] {groupId, approved};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_A_GROUPID_2);

			query.append(_FINDER_COLUMN_P_A_APPROVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(approved);

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

	private static final String _FINDER_COLUMN_P_A_GROUPID_2 =
		"legalSuggestDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_A_APPROVED_2 =
		"legalSuggestDocument.approved = ?";

	private FinderPath _finderPathFetchByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or throws a <code>NoSuchLegalSuggestDocumentException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByG_S(long groupId, long sugId)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByG_S(groupId, sugId);

		if (legalSuggestDocument == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", sugId=");
			msg.append(sugId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalSuggestDocumentException(msg.toString());
		}

		return legalSuggestDocument;
	}

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByG_S(long groupId, long sugId) {
		return fetchByG_S(groupId, sugId, true);
	}

	/**
	 * Returns the legal suggest document where groupId = &#63; and sugId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByG_S(
		long groupId, long sugId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, sugId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_S, finderArgs, this);
		}

		if (result instanceof LegalSuggestDocument) {
			LegalSuggestDocument legalSuggestDocument =
				(LegalSuggestDocument)result;

			if ((groupId != legalSuggestDocument.getGroupId()) ||
				(sugId != legalSuggestDocument.getSugId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SUGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(sugId);

				List<LegalSuggestDocument> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByG_S, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId, sugId};
							}

							_log.warn(
								"LegalSuggestDocumentPersistenceImpl.fetchByG_S(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalSuggestDocument legalSuggestDocument = list.get(0);

					result = legalSuggestDocument;

					cacheResult(legalSuggestDocument);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(_finderPathFetchByG_S, finderArgs);
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
			return (LegalSuggestDocument)result;
		}
	}

	/**
	 * Removes the legal suggest document where groupId = &#63; and sugId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the legal suggest document that was removed
	 */
	@Override
	public LegalSuggestDocument removeByG_S(long groupId, long sugId)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = findByG_S(groupId, sugId);

		return remove(legalSuggestDocument);
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and sugId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sugId the sug ID
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByG_S(long groupId, long sugId) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, sugId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SUGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(sugId);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"legalSuggestDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_SUGID_2 =
		"legalSuggestDocument.sugId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if ((groupId != legalSuggestDocument.getGroupId()) ||
						!language.equals(legalSuggestDocument.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

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
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findByG_L_PrevAndNext(
			long sugId, long groupId, String language,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		language = Objects.toString(language, "");

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalSuggestDocument, groupId, language,
				orderByComparator, true);

			array[1] = legalSuggestDocument;

			array[2] = getByG_L_PrevAndNext(
				session, legalSuggestDocument, groupId, language,
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

	protected LegalSuggestDocument getByG_L_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument,
		long groupId, String language,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalSuggestDocument legalSuggestDocument :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

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
		"legalSuggestDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalSuggestDocument.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalSuggestDocument.language IS NULL OR legalSuggestDocument.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_L_A;
	private FinderPath _finderPathWithoutPaginationFindByG_L_A;
	private FinderPath _finderPathCountByG_L_A;

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved) {

		return findByG_L_A(
			groupId, language, approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end) {

		return findByG_L_A(groupId, language, approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findByG_L_A(
			groupId, language, approved, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByG_L_A(
		long groupId, String language, boolean approved, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_A;
				finderArgs = new Object[] {groupId, language, approved};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_A;
			finderArgs = new Object[] {
				groupId, language, approved, start, end, orderByComparator
			};
		}

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if ((groupId != legalSuggestDocument.getGroupId()) ||
						!language.equals(legalSuggestDocument.getLanguage()) ||
						(approved != legalSuggestDocument.isApproved())) {

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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_A_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(approved);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByG_L_A_First(
			long groupId, String language, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByG_L_A_First(
			groupId, language, approved, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", approved=");
		msg.append(approved);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByG_L_A_First(
		long groupId, String language, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findByG_L_A(
			groupId, language, approved, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByG_L_A_Last(
			long groupId, String language, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByG_L_A_Last(
			groupId, language, approved, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", approved=");
		msg.append(approved);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByG_L_A_Last(
		long groupId, String language, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countByG_L_A(groupId, language, approved);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findByG_L_A(
			groupId, language, approved, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findByG_L_A_PrevAndNext(
			long sugId, long groupId, String language, boolean approved,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		language = Objects.toString(language, "");

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getByG_L_A_PrevAndNext(
				session, legalSuggestDocument, groupId, language, approved,
				orderByComparator, true);

			array[1] = legalSuggestDocument;

			array[2] = getByG_L_A_PrevAndNext(
				session, legalSuggestDocument, groupId, language, approved,
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

	protected LegalSuggestDocument getByG_L_A_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument,
		long groupId, String language, boolean approved,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_A_APPROVED_2);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(approved);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 */
	@Override
	public void removeByG_L_A(long groupId, String language, boolean approved) {
		for (LegalSuggestDocument legalSuggestDocument :
				findByG_L_A(
					groupId, language, approved, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByG_L_A(long groupId, String language, boolean approved) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_A;

		Object[] finderArgs = new Object[] {groupId, language, approved};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_A_APPROVED_2);

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

				qPos.add(approved);

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

	private static final String _FINDER_COLUMN_G_L_A_GROUPID_2 =
		"legalSuggestDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_A_LANGUAGE_2 =
		"legalSuggestDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_A_LANGUAGE_3 =
		"(legalSuggestDocument.language IS NULL OR legalSuggestDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_A_APPROVED_2 =
		"legalSuggestDocument.approved = ?";

	private FinderPath _finderPathWithPaginationFindByP_L_A_D;
	private FinderPath _finderPathWithoutPaginationFindByP_L_A_D;
	private FinderPath _finderPathCountByP_L_A_D;

	/**
	 * Returns all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId) {

		return findByP_L_A_D(
			groupId, language, approved, docId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end) {

		return findByP_L_A_D(
			groupId, language, approved, docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end, OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findByP_L_A_D(
			groupId, language, approved, docId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByP_L_A_D(
		long groupId, String language, boolean approved, long docId, int start,
		int end, OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByP_L_A_D;
				finderArgs = new Object[] {groupId, language, approved, docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByP_L_A_D;
			finderArgs = new Object[] {
				groupId, language, approved, docId, start, end,
				orderByComparator
			};
		}

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if ((groupId != legalSuggestDocument.getGroupId()) ||
						!language.equals(legalSuggestDocument.getLanguage()) ||
						(approved != legalSuggestDocument.isApproved()) ||
						(docId != legalSuggestDocument.getDocId())) {

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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_L_A_D_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_L_A_D_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_L_A_D_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_P_L_A_D_APPROVED_2);

			query.append(_FINDER_COLUMN_P_L_A_D_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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

				qPos.add(approved);

				qPos.add(docId);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByP_L_A_D_First(
			long groupId, String language, boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByP_L_A_D_First(
			groupId, language, approved, docId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", approved=");
		msg.append(approved);

		msg.append(", docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByP_L_A_D_First(
		long groupId, String language, boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findByP_L_A_D(
			groupId, language, approved, docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByP_L_A_D_Last(
			long groupId, String language, boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByP_L_A_D_Last(
			groupId, language, approved, docId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", approved=");
		msg.append(approved);

		msg.append(", docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByP_L_A_D_Last(
		long groupId, String language, boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countByP_L_A_D(groupId, language, approved, docId);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findByP_L_A_D(
			groupId, language, approved, docId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findByP_L_A_D_PrevAndNext(
			long sugId, long groupId, String language, boolean approved,
			long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		language = Objects.toString(language, "");

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getByP_L_A_D_PrevAndNext(
				session, legalSuggestDocument, groupId, language, approved,
				docId, orderByComparator, true);

			array[1] = legalSuggestDocument;

			array[2] = getByP_L_A_D_PrevAndNext(
				session, legalSuggestDocument, groupId, language, approved,
				docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalSuggestDocument getByP_L_A_D_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument,
		long groupId, String language, boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_P_L_A_D_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_P_L_A_D_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_P_L_A_D_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_P_L_A_D_APPROVED_2);

		query.append(_FINDER_COLUMN_P_L_A_D_DOCID_2);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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

		qPos.add(approved);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 */
	@Override
	public void removeByP_L_A_D(
		long groupId, String language, boolean approved, long docId) {

		for (LegalSuggestDocument legalSuggestDocument :
				findByP_L_A_D(
					groupId, language, approved, docId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where groupId = &#63; and language = &#63; and approved = &#63; and docId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByP_L_A_D(
		long groupId, String language, boolean approved, long docId) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByP_L_A_D;

		Object[] finderArgs = new Object[] {groupId, language, approved, docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_P_L_A_D_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_P_L_A_D_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_P_L_A_D_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_P_L_A_D_APPROVED_2);

			query.append(_FINDER_COLUMN_P_L_A_D_DOCID_2);

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

				qPos.add(approved);

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

	private static final String _FINDER_COLUMN_P_L_A_D_GROUPID_2 =
		"legalSuggestDocument.groupId = ? AND ";

	private static final String _FINDER_COLUMN_P_L_A_D_LANGUAGE_2 =
		"legalSuggestDocument.language = ? AND ";

	private static final String _FINDER_COLUMN_P_L_A_D_LANGUAGE_3 =
		"(legalSuggestDocument.language IS NULL OR legalSuggestDocument.language = '') AND ";

	private static final String _FINDER_COLUMN_P_L_A_D_APPROVED_2 =
		"legalSuggestDocument.approved = ? AND ";

	private static final String _FINDER_COLUMN_P_L_A_D_DOCID_2 =
		"legalSuggestDocument.docId = ?";

	private FinderPath _finderPathWithPaginationFindByA_D;
	private FinderPath _finderPathWithoutPaginationFindByA_D;
	private FinderPath _finderPathCountByA_D;

	/**
	 * Returns all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByA_D(boolean approved, long docId) {
		return findByA_D(
			approved, docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end) {

		return findByA_D(approved, docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findByA_D(approved, docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findByA_D(
		boolean approved, long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByA_D;
				finderArgs = new Object[] {approved, docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByA_D;
			finderArgs = new Object[] {
				approved, docId, start, end, orderByComparator
			};
		}

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if ((approved != legalSuggestDocument.isApproved()) ||
						(docId != legalSuggestDocument.getDocId())) {

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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_A_D_APPROVED_2);

			query.append(_FINDER_COLUMN_A_D_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

				qPos.add(docId);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByA_D_First(
			boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByA_D_First(
			approved, docId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(", docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByA_D_First(
		boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findByA_D(
			approved, docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findByA_D_Last(
			boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByA_D_Last(
			approved, docId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approved=");
		msg.append(approved);

		msg.append(", docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByA_D_Last(
		boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countByA_D(approved, docId);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findByA_D(
			approved, docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where approved = &#63; and docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param approved the approved
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findByA_D_PrevAndNext(
			long sugId, boolean approved, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getByA_D_PrevAndNext(
				session, legalSuggestDocument, approved, docId,
				orderByComparator, true);

			array[1] = legalSuggestDocument;

			array[2] = getByA_D_PrevAndNext(
				session, legalSuggestDocument, approved, docId,
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

	protected LegalSuggestDocument getByA_D_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument,
		boolean approved, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_A_D_APPROVED_2);

		query.append(_FINDER_COLUMN_A_D_DOCID_2);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approved);

		qPos.add(docId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where approved = &#63; and docId = &#63; from the database.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 */
	@Override
	public void removeByA_D(boolean approved, long docId) {
		for (LegalSuggestDocument legalSuggestDocument :
				findByA_D(
					approved, docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where approved = &#63; and docId = &#63;.
	 *
	 * @param approved the approved
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countByA_D(boolean approved, long docId) {
		FinderPath finderPath = _finderPathCountByA_D;

		Object[] finderArgs = new Object[] {approved, docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_A_D_APPROVED_2);

			query.append(_FINDER_COLUMN_A_D_DOCID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

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

	private static final String _FINDER_COLUMN_A_D_APPROVED_2 =
		"legalSuggestDocument.approved = ? AND ";

	private static final String _FINDER_COLUMN_A_D_DOCID_2 =
		"legalSuggestDocument.docId = ?";

	private FinderPath _finderPathWithPaginationFindBySuggByDocId;
	private FinderPath _finderPathWithoutPaginationFindBySuggByDocId;
	private FinderPath _finderPathCountBySuggByDocId;

	/**
	 * Returns all the legal suggest documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findBySuggByDocId(long docId) {
		return findBySuggByDocId(
			docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end) {

		return findBySuggByDocId(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findBySuggByDocId(docId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findBySuggByDocId(
		long docId, int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySuggByDocId;
				finderArgs = new Object[] {docId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySuggByDocId;
			finderArgs = new Object[] {docId, start, end, orderByComparator};
		}

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSuggestDocument legalSuggestDocument : list) {
					if (docId != legalSuggestDocument.getDocId()) {
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

			query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_SUGGBYDOCID_DOCID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(docId);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Returns the first legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findBySuggByDocId_First(
			long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchBySuggByDocId_First(
			docId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the first legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchBySuggByDocId_First(
		long docId, OrderByComparator<LegalSuggestDocument> orderByComparator) {

		List<LegalSuggestDocument> list = findBySuggByDocId(
			docId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument findBySuggByDocId_Last(
			long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchBySuggByDocId_Last(
			docId, orderByComparator);

		if (legalSuggestDocument != null) {
			return legalSuggestDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("docId=");
		msg.append(docId);

		msg.append("}");

		throw new NoSuchLegalSuggestDocumentException(msg.toString());
	}

	/**
	 * Returns the last legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal suggest document, or <code>null</code> if a matching legal suggest document could not be found
	 */
	@Override
	public LegalSuggestDocument fetchBySuggByDocId_Last(
		long docId, OrderByComparator<LegalSuggestDocument> orderByComparator) {

		int count = countBySuggByDocId(docId);

		if (count == 0) {
			return null;
		}

		List<LegalSuggestDocument> list = findBySuggByDocId(
			docId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal suggest documents before and after the current legal suggest document in the ordered set where docId = &#63;.
	 *
	 * @param sugId the primary key of the current legal suggest document
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument[] findBySuggByDocId_PrevAndNext(
			long sugId, long docId,
			OrderByComparator<LegalSuggestDocument> orderByComparator)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = findByPrimaryKey(sugId);

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument[] array = new LegalSuggestDocumentImpl[3];

			array[0] = getBySuggByDocId_PrevAndNext(
				session, legalSuggestDocument, docId, orderByComparator, true);

			array[1] = legalSuggestDocument;

			array[2] = getBySuggByDocId_PrevAndNext(
				session, legalSuggestDocument, docId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalSuggestDocument getBySuggByDocId_PrevAndNext(
		Session session, LegalSuggestDocument legalSuggestDocument, long docId,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE);

		query.append(_FINDER_COLUMN_SUGGBYDOCID_DOCID_2);

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
			query.append(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
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
						legalSuggestDocument)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSuggestDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal suggest documents where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	@Override
	public void removeBySuggByDocId(long docId) {
		for (LegalSuggestDocument legalSuggestDocument :
				findBySuggByDocId(
					docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal suggest documents
	 */
	@Override
	public int countBySuggByDocId(long docId) {
		FinderPath finderPath = _finderPathCountBySuggByDocId;

		Object[] finderArgs = new Object[] {docId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_SUGGBYDOCID_DOCID_2);

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

	private static final String _FINDER_COLUMN_SUGGBYDOCID_DOCID_2 =
		"legalSuggestDocument.docId = ?";

	public LegalSuggestDocumentPersistenceImpl() {
		setModelClass(LegalSuggestDocument.class);

		setModelImplClass(LegalSuggestDocumentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal suggest document in the entity cache if it is enabled.
	 *
	 * @param legalSuggestDocument the legal suggest document
	 */
	@Override
	public void cacheResult(LegalSuggestDocument legalSuggestDocument) {
		entityCache.putResult(
			entityCacheEnabled, LegalSuggestDocumentImpl.class,
			legalSuggestDocument.getPrimaryKey(), legalSuggestDocument);

		finderCache.putResult(
			_finderPathFetchByG_S,
			new Object[] {
				legalSuggestDocument.getGroupId(),
				legalSuggestDocument.getSugId()
			},
			legalSuggestDocument);

		legalSuggestDocument.resetOriginalValues();
	}

	/**
	 * Caches the legal suggest documents in the entity cache if it is enabled.
	 *
	 * @param legalSuggestDocuments the legal suggest documents
	 */
	@Override
	public void cacheResult(List<LegalSuggestDocument> legalSuggestDocuments) {
		for (LegalSuggestDocument legalSuggestDocument :
				legalSuggestDocuments) {

			if (entityCache.getResult(
					entityCacheEnabled, LegalSuggestDocumentImpl.class,
					legalSuggestDocument.getPrimaryKey()) == null) {

				cacheResult(legalSuggestDocument);
			}
			else {
				legalSuggestDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal suggest documents.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalSuggestDocumentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal suggest document.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalSuggestDocument legalSuggestDocument) {
		entityCache.removeResult(
			entityCacheEnabled, LegalSuggestDocumentImpl.class,
			legalSuggestDocument.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(LegalSuggestDocumentModelImpl)legalSuggestDocument, true);
	}

	@Override
	public void clearCache(List<LegalSuggestDocument> legalSuggestDocuments) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalSuggestDocument legalSuggestDocument :
				legalSuggestDocuments) {

			entityCache.removeResult(
				entityCacheEnabled, LegalSuggestDocumentImpl.class,
				legalSuggestDocument.getPrimaryKey());

			clearUniqueFindersCache(
				(LegalSuggestDocumentModelImpl)legalSuggestDocument, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalSuggestDocumentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalSuggestDocumentModelImpl legalSuggestDocumentModelImpl) {

		Object[] args = new Object[] {
			legalSuggestDocumentModelImpl.getGroupId(),
			legalSuggestDocumentModelImpl.getSugId()
		};

		finderCache.putResult(
			_finderPathCountByG_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_S, args, legalSuggestDocumentModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalSuggestDocumentModelImpl legalSuggestDocumentModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalSuggestDocumentModelImpl.getGroupId(),
				legalSuggestDocumentModelImpl.getSugId()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(_finderPathFetchByG_S, args);
		}

		if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_S.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalSuggestDocumentModelImpl.getOriginalGroupId(),
				legalSuggestDocumentModelImpl.getOriginalSugId()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(_finderPathFetchByG_S, args);
		}
	}

	/**
	 * Creates a new legal suggest document with the primary key. Does not add the legal suggest document to the database.
	 *
	 * @param sugId the primary key for the new legal suggest document
	 * @return the new legal suggest document
	 */
	@Override
	public LegalSuggestDocument create(long sugId) {
		LegalSuggestDocument legalSuggestDocument =
			new LegalSuggestDocumentImpl();

		legalSuggestDocument.setNew(true);
		legalSuggestDocument.setPrimaryKey(sugId);

		legalSuggestDocument.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalSuggestDocument;
	}

	/**
	 * Removes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument remove(long sugId)
		throws NoSuchLegalSuggestDocumentException {

		return remove((Serializable)sugId);
	}

	/**
	 * Removes the legal suggest document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal suggest document
	 * @return the legal suggest document that was removed
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument remove(Serializable primaryKey)
		throws NoSuchLegalSuggestDocumentException {

		Session session = null;

		try {
			session = openSession();

			LegalSuggestDocument legalSuggestDocument =
				(LegalSuggestDocument)session.get(
					LegalSuggestDocumentImpl.class, primaryKey);

			if (legalSuggestDocument == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalSuggestDocumentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalSuggestDocument);
		}
		catch (NoSuchLegalSuggestDocumentException noSuchEntityException) {
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
	protected LegalSuggestDocument removeImpl(
		LegalSuggestDocument legalSuggestDocument) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalSuggestDocument)) {
				legalSuggestDocument = (LegalSuggestDocument)session.get(
					LegalSuggestDocumentImpl.class,
					legalSuggestDocument.getPrimaryKeyObj());
			}

			if (legalSuggestDocument != null) {
				session.delete(legalSuggestDocument);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalSuggestDocument != null) {
			clearCache(legalSuggestDocument);
		}

		return legalSuggestDocument;
	}

	@Override
	public LegalSuggestDocument updateImpl(
		LegalSuggestDocument legalSuggestDocument) {

		boolean isNew = legalSuggestDocument.isNew();

		if (!(legalSuggestDocument instanceof LegalSuggestDocumentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalSuggestDocument.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					legalSuggestDocument);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalSuggestDocument proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalSuggestDocument implementation " +
					legalSuggestDocument.getClass());
		}

		LegalSuggestDocumentModelImpl legalSuggestDocumentModelImpl =
			(LegalSuggestDocumentModelImpl)legalSuggestDocument;

		Session session = null;

		try {
			session = openSession();

			if (legalSuggestDocument.isNew()) {
				session.save(legalSuggestDocument);

				legalSuggestDocument.setNew(false);
			}
			else {
				legalSuggestDocument = (LegalSuggestDocument)session.merge(
					legalSuggestDocument);
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
				legalSuggestDocumentModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalSuggestDocumentModelImpl.getGroupId(),
				legalSuggestDocumentModelImpl.isApproved()
			};

			finderCache.removeResult(_finderPathCountByP_A, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_A, args);

			args = new Object[] {
				legalSuggestDocumentModelImpl.getGroupId(),
				legalSuggestDocumentModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalSuggestDocumentModelImpl.getGroupId(),
				legalSuggestDocumentModelImpl.getLanguage(),
				legalSuggestDocumentModelImpl.isApproved()
			};

			finderCache.removeResult(_finderPathCountByG_L_A, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_A, args);

			args = new Object[] {
				legalSuggestDocumentModelImpl.getGroupId(),
				legalSuggestDocumentModelImpl.getLanguage(),
				legalSuggestDocumentModelImpl.isApproved(),
				legalSuggestDocumentModelImpl.getDocId()
			};

			finderCache.removeResult(_finderPathCountByP_L_A_D, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByP_L_A_D, args);

			args = new Object[] {
				legalSuggestDocumentModelImpl.isApproved(),
				legalSuggestDocumentModelImpl.getDocId()
			};

			finderCache.removeResult(_finderPathCountByA_D, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByA_D, args);

			args = new Object[] {legalSuggestDocumentModelImpl.getDocId()};

			finderCache.removeResult(_finderPathCountBySuggByDocId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySuggByDocId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {
					legalSuggestDocumentModelImpl.getGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_A.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalGroupId(),
					legalSuggestDocumentModelImpl.getOriginalApproved()
				};

				finderCache.removeResult(_finderPathCountByP_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_A, args);

				args = new Object[] {
					legalSuggestDocumentModelImpl.getGroupId(),
					legalSuggestDocumentModelImpl.isApproved()
				};

				finderCache.removeResult(_finderPathCountByP_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_A, args);
			}

			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalGroupId(),
					legalSuggestDocumentModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalSuggestDocumentModelImpl.getGroupId(),
					legalSuggestDocumentModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_A.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalGroupId(),
					legalSuggestDocumentModelImpl.getOriginalLanguage(),
					legalSuggestDocumentModelImpl.getOriginalApproved()
				};

				finderCache.removeResult(_finderPathCountByG_L_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_A, args);

				args = new Object[] {
					legalSuggestDocumentModelImpl.getGroupId(),
					legalSuggestDocumentModelImpl.getLanguage(),
					legalSuggestDocumentModelImpl.isApproved()
				};

				finderCache.removeResult(_finderPathCountByG_L_A, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_A, args);
			}

			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByP_L_A_D.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalGroupId(),
					legalSuggestDocumentModelImpl.getOriginalLanguage(),
					legalSuggestDocumentModelImpl.getOriginalApproved(),
					legalSuggestDocumentModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByP_L_A_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_L_A_D, args);

				args = new Object[] {
					legalSuggestDocumentModelImpl.getGroupId(),
					legalSuggestDocumentModelImpl.getLanguage(),
					legalSuggestDocumentModelImpl.isApproved(),
					legalSuggestDocumentModelImpl.getDocId()
				};

				finderCache.removeResult(_finderPathCountByP_L_A_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByP_L_A_D, args);
			}

			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByA_D.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalApproved(),
					legalSuggestDocumentModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountByA_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByA_D, args);

				args = new Object[] {
					legalSuggestDocumentModelImpl.isApproved(),
					legalSuggestDocumentModelImpl.getDocId()
				};

				finderCache.removeResult(_finderPathCountByA_D, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByA_D, args);
			}

			if ((legalSuggestDocumentModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySuggByDocId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSuggestDocumentModelImpl.getOriginalDocId()
				};

				finderCache.removeResult(_finderPathCountBySuggByDocId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySuggByDocId, args);

				args = new Object[] {legalSuggestDocumentModelImpl.getDocId()};

				finderCache.removeResult(_finderPathCountBySuggByDocId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySuggByDocId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalSuggestDocumentImpl.class,
			legalSuggestDocument.getPrimaryKey(), legalSuggestDocument, false);

		clearUniqueFindersCache(legalSuggestDocumentModelImpl, false);
		cacheUniqueFindersCache(legalSuggestDocumentModelImpl);

		legalSuggestDocument.resetOriginalValues();

		return legalSuggestDocument;
	}

	/**
	 * Returns the legal suggest document with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalSuggestDocumentException {

		LegalSuggestDocument legalSuggestDocument = fetchByPrimaryKey(
			primaryKey);

		if (legalSuggestDocument == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalSuggestDocumentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalSuggestDocument;
	}

	/**
	 * Returns the legal suggest document with the primary key or throws a <code>NoSuchLegalSuggestDocumentException</code> if it could not be found.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document
	 * @throws NoSuchLegalSuggestDocumentException if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument findByPrimaryKey(long sugId)
		throws NoSuchLegalSuggestDocumentException {

		return findByPrimaryKey((Serializable)sugId);
	}

	/**
	 * Returns the legal suggest document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sugId the primary key of the legal suggest document
	 * @return the legal suggest document, or <code>null</code> if a legal suggest document with the primary key could not be found
	 */
	@Override
	public LegalSuggestDocument fetchByPrimaryKey(long sugId) {
		return fetchByPrimaryKey((Serializable)sugId);
	}

	/**
	 * Returns all the legal suggest documents.
	 *
	 * @return the legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @return the range of legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findAll(
		int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal suggest documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSuggestDocumentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal suggest documents
	 * @param end the upper bound of the range of legal suggest documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal suggest documents
	 */
	@Override
	public List<LegalSuggestDocument> findAll(
		int start, int end,
		OrderByComparator<LegalSuggestDocument> orderByComparator,
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

		List<LegalSuggestDocument> list = null;

		if (useFinderCache) {
			list = (List<LegalSuggestDocument>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALSUGGESTDOCUMENT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALSUGGESTDOCUMENT;

				sql = sql.concat(LegalSuggestDocumentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalSuggestDocument>)QueryUtil.list(
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
	 * Removes all the legal suggest documents from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalSuggestDocument legalSuggestDocument : findAll()) {
			remove(legalSuggestDocument);
		}
	}

	/**
	 * Returns the number of legal suggest documents.
	 *
	 * @return the number of legal suggest documents
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALSUGGESTDOCUMENT);

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
		return "sugId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALSUGGESTDOCUMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalSuggestDocumentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal suggest document persistence.
	 */
	@Activate
	public void activate() {
		LegalSuggestDocumentModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalSuggestDocumentModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalSuggestDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByP_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_A",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			LegalSuggestDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.APPROVED_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_A",
			new String[] {Long.class.getName(), Boolean.class.getName()});

		_finderPathFetchByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByG_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalSuggestDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.SUGID_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalSuggestDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByG_L_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			LegalSuggestDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.APPROVED_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_A = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByP_L_A_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_L_A_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByP_L_A_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_L_A_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Long.class.getName()
			},
			LegalSuggestDocumentModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.APPROVED_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.DOCID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByP_L_A_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_L_A_D",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByA_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA_D",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByA_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_D",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			LegalSuggestDocumentModelImpl.APPROVED_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.DOCID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByA_D = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_D",
			new String[] {Boolean.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindBySuggByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySuggByDocId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySuggByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			LegalSuggestDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySuggByDocId",
			new String[] {Long.class.getName()},
			LegalSuggestDocumentModelImpl.DOCID_COLUMN_BITMASK |
			LegalSuggestDocumentModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountBySuggByDocId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySuggByDocId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalSuggestDocumentImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalSuggestDocument"),
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

	private static final String _SQL_SELECT_LEGALSUGGESTDOCUMENT =
		"SELECT legalSuggestDocument FROM LegalSuggestDocument legalSuggestDocument";

	private static final String _SQL_SELECT_LEGALSUGGESTDOCUMENT_WHERE =
		"SELECT legalSuggestDocument FROM LegalSuggestDocument legalSuggestDocument WHERE ";

	private static final String _SQL_COUNT_LEGALSUGGESTDOCUMENT =
		"SELECT COUNT(legalSuggestDocument) FROM LegalSuggestDocument legalSuggestDocument";

	private static final String _SQL_COUNT_LEGALSUGGESTDOCUMENT_WHERE =
		"SELECT COUNT(legalSuggestDocument) FROM LegalSuggestDocument legalSuggestDocument WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"legalSuggestDocument.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalSuggestDocument exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalSuggestDocument exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalSuggestDocumentPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}