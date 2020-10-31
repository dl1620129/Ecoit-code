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

import com.ecoit.elegaldocument.exception.NoSuchLegalSignerException;
import com.ecoit.elegaldocument.model.LegalSigner;
import com.ecoit.elegaldocument.model.impl.LegalSignerImpl;
import com.ecoit.elegaldocument.model.impl.LegalSignerModelImpl;
import com.ecoit.elegaldocument.service.persistence.LegalSignerPersistence;
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
 * The persistence implementation for the legal signer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = LegalSignerPersistence.class)
public class LegalSignerPersistenceImpl
	extends BasePersistenceImpl<LegalSigner> implements LegalSignerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LegalSignerUtil</code> to access the legal signer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LegalSignerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySigId;
	private FinderPath _finderPathCountBySigId;

	/**
	 * Returns the legal signer where sigId = &#63; or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findBySigId(long sigId)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchBySigId(sigId);

		if (legalSigner == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sigId=");
			msg.append(sigId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalSignerException(msg.toString());
		}

		return legalSigner;
	}

	/**
	 * Returns the legal signer where sigId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchBySigId(long sigId) {
		return fetchBySigId(sigId, true);
	}

	/**
	 * Returns the legal signer where sigId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sigId the sig ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchBySigId(long sigId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sigId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySigId, finderArgs, this);
		}

		if (result instanceof LegalSigner) {
			LegalSigner legalSigner = (LegalSigner)result;

			if (sigId != legalSigner.getSigId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_SIGID_SIGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sigId);

				List<LegalSigner> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySigId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {sigId};
							}

							_log.warn(
								"LegalSignerPersistenceImpl.fetchBySigId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalSigner legalSigner = list.get(0);

					result = legalSigner;

					cacheResult(legalSigner);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySigId, finderArgs);
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
			return (LegalSigner)result;
		}
	}

	/**
	 * Removes the legal signer where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 * @return the legal signer that was removed
	 */
	@Override
	public LegalSigner removeBySigId(long sigId)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = findBySigId(sigId);

		return remove(legalSigner);
	}

	/**
	 * Returns the number of legal signers where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching legal signers
	 */
	@Override
	public int countBySigId(long sigId) {
		FinderPath finderPath = _finderPathCountBySigId;

		Object[] finderArgs = new Object[] {sigId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_SIGID_SIGID_2);

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

	private static final String _FINDER_COLUMN_SIGID_SIGID_2 =
		"legalSigner.sigId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the legal signers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching legal signers
	 */
	@Override
	public List<LegalSigner> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
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

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSigner legalSigner : list) {
					if (groupId != legalSigner.getGroupId()) {
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

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Returns the first legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByGroupId_First(
			long groupId, OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByGroupId_First(
			groupId, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByGroupId_First(
		long groupId, OrderByComparator<LegalSigner> orderByComparator) {

		List<LegalSigner> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByGroupId_Last(
			long groupId, OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByGroupId_Last(
		long groupId, OrderByComparator<LegalSigner> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<LegalSigner> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner[] findByGroupId_PrevAndNext(
			long sigId, long groupId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			LegalSigner[] array = new LegalSignerImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, legalSigner, groupId, orderByComparator, true);

			array[1] = legalSigner;

			array[2] = getByGroupId_PrevAndNext(
				session, legalSigner, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalSigner getByGroupId_PrevAndNext(
		Session session, LegalSigner legalSigner, long groupId,
		OrderByComparator<LegalSigner> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

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
			query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalSigner)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSigner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal signers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (LegalSigner legalSigner :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

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
		"legalSigner.groupId = ?";

	private FinderPath _finderPathFetchByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByG_S(long groupId, long sigId)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByG_S(groupId, sigId);

		if (legalSigner == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", sigId=");
			msg.append(sigId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLegalSignerException(msg.toString());
		}

		return legalSigner;
	}

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByG_S(long groupId, long sigId) {
		return fetchByG_S(groupId, sigId, true);
	}

	/**
	 * Returns the legal signer where groupId = &#63; and sigId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByG_S(
		long groupId, long sigId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId, sigId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByG_S, finderArgs, this);
		}

		if (result instanceof LegalSigner) {
			LegalSigner legalSigner = (LegalSigner)result;

			if ((groupId != legalSigner.getGroupId()) ||
				(sigId != legalSigner.getSigId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SIGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(sigId);

				List<LegalSigner> list = q.list();

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
								finderArgs = new Object[] {groupId, sigId};
							}

							_log.warn(
								"LegalSignerPersistenceImpl.fetchByG_S(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LegalSigner legalSigner = list.get(0);

					result = legalSigner;

					cacheResult(legalSigner);
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
			return (LegalSigner)result;
		}
	}

	/**
	 * Removes the legal signer where groupId = &#63; and sigId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the legal signer that was removed
	 */
	@Override
	public LegalSigner removeByG_S(long groupId, long sigId)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = findByG_S(groupId, sigId);

		return remove(legalSigner);
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and sigId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param sigId the sig ID
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByG_S(long groupId, long sigId) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, sigId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_SIGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"legalSigner.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_SIGID_2 =
		"legalSigner.sigId = ?";

	private FinderPath _finderPathWithPaginationFindByG_L;
	private FinderPath _finderPathWithoutPaginationFindByG_L;
	private FinderPath _finderPathCountByG_L;

	/**
	 * Returns all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L(long groupId, String language) {
		return findByG_L(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end) {

		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return findByG_L(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L(
		long groupId, String language, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
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

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSigner legalSigner : list) {
					if ((groupId != legalSigner.getGroupId()) ||
						!language.equals(legalSigner.getLanguage())) {

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

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

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
				query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
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

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByG_L_First(
			long groupId, String language,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByG_L_First(
			groupId, language, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByG_L_First(
		long groupId, String language,
		OrderByComparator<LegalSigner> orderByComparator) {

		List<LegalSigner> list = findByG_L(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByG_L_Last(
			long groupId, String language,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByG_L_Last(
			groupId, language, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByG_L_Last(
		long groupId, String language,
		OrderByComparator<LegalSigner> orderByComparator) {

		int count = countByG_L(groupId, language);

		if (count == 0) {
			return null;
		}

		List<LegalSigner> list = findByG_L(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner[] findByG_L_PrevAndNext(
			long sigId, long groupId, String language,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		language = Objects.toString(language, "");

		LegalSigner legalSigner = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			LegalSigner[] array = new LegalSignerImpl[3];

			array[0] = getByG_L_PrevAndNext(
				session, legalSigner, groupId, language, orderByComparator,
				true);

			array[1] = legalSigner;

			array[2] = getByG_L_PrevAndNext(
				session, legalSigner, groupId, language, orderByComparator,
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

	protected LegalSigner getByG_L_PrevAndNext(
		Session session, LegalSigner legalSigner, long groupId, String language,
		OrderByComparator<LegalSigner> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

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
			query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalSigner)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSigner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByG_L(long groupId, String language) {
		for (LegalSigner legalSigner :
				findByG_L(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByG_L(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

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
		"legalSigner.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 =
		"legalSigner.language = ?";

	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 =
		"(legalSigner.language IS NULL OR legalSigner.language = '')";

	private FinderPath _finderPathWithPaginationFindByG_L_S;
	private FinderPath _finderPathWithoutPaginationFindByG_L_S;
	private FinderPath _finderPathCountByG_L_S;

	/**
	 * Returns all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner) {

		return findByG_L_S(
			groupId, language, statusSigner, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start,
		int end) {

		return findByG_L_S(groupId, language, statusSigner, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return findByG_L_S(
			groupId, language, statusSigner, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByG_L_S(
		long groupId, String language, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_L_S;
				finderArgs = new Object[] {groupId, language, statusSigner};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_L_S;
			finderArgs = new Object[] {
				groupId, language, statusSigner, start, end, orderByComparator
			};
		}

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSigner legalSigner : list) {
					if ((groupId != legalSigner.getGroupId()) ||
						!language.equals(legalSigner.getLanguage()) ||
						(statusSigner != legalSigner.isStatusSigner())) {

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

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_G_L_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_S_STATUSSIGNER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
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

				qPos.add(statusSigner);

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByG_L_S_First(
			long groupId, String language, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByG_L_S_First(
			groupId, language, statusSigner, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusSigner=");
		msg.append(statusSigner);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByG_L_S_First(
		long groupId, String language, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		List<LegalSigner> list = findByG_L_S(
			groupId, language, statusSigner, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByG_L_S_Last(
			long groupId, String language, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByG_L_S_Last(
			groupId, language, statusSigner, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append(", statusSigner=");
		msg.append(statusSigner);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByG_L_S_Last(
		long groupId, String language, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		int count = countByG_L_S(groupId, language, statusSigner);

		if (count == 0) {
			return null;
		}

		List<LegalSigner> list = findByG_L_S(
			groupId, language, statusSigner, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner[] findByG_L_S_PrevAndNext(
			long sigId, long groupId, String language, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		language = Objects.toString(language, "");

		LegalSigner legalSigner = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			LegalSigner[] array = new LegalSignerImpl[3];

			array[0] = getByG_L_S_PrevAndNext(
				session, legalSigner, groupId, language, statusSigner,
				orderByComparator, true);

			array[1] = legalSigner;

			array[2] = getByG_L_S_PrevAndNext(
				session, legalSigner, groupId, language, statusSigner,
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

	protected LegalSigner getByG_L_S_PrevAndNext(
		Session session, LegalSigner legalSigner, long groupId, String language,
		boolean statusSigner, OrderByComparator<LegalSigner> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

		query.append(_FINDER_COLUMN_G_L_S_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_2);
		}

		query.append(_FINDER_COLUMN_G_L_S_STATUSSIGNER_2);

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
			query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
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

		qPos.add(statusSigner);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalSigner)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSigner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 */
	@Override
	public void removeByG_L_S(
		long groupId, String language, boolean statusSigner) {

		for (LegalSigner legalSigner :
				findByG_L_S(
					groupId, language, statusSigner, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and language = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByG_L_S(
		long groupId, String language, boolean statusSigner) {

		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByG_L_S;

		Object[] finderArgs = new Object[] {groupId, language, statusSigner};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_G_L_S_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_G_L_S_LANGUAGE_2);
			}

			query.append(_FINDER_COLUMN_G_L_S_STATUSSIGNER_2);

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

				qPos.add(statusSigner);

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

	private static final String _FINDER_COLUMN_G_L_S_GROUPID_2 =
		"legalSigner.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_L_S_LANGUAGE_2 =
		"legalSigner.language = ? AND ";

	private static final String _FINDER_COLUMN_G_L_S_LANGUAGE_3 =
		"(legalSigner.language IS NULL OR legalSigner.language = '') AND ";

	private static final String _FINDER_COLUMN_G_L_S_STATUSSIGNER_2 =
		"legalSigner.statusSigner = ?";

	private FinderPath _finderPathWithPaginationFindByStatusSIGN;
	private FinderPath _finderPathWithoutPaginationFindByStatusSIGN;
	private FinderPath _finderPathCountByStatusSIGN;

	/**
	 * Returns all the legal signers where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	@Override
	public List<LegalSigner> findByStatusSIGN(boolean statusSigner) {
		return findByStatusSIGN(
			statusSigner, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end) {

		return findByStatusSIGN(statusSigner, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return findByStatusSIGN(
			statusSigner, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal signers where statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByStatusSIGN(
		boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatusSIGN;
				finderArgs = new Object[] {statusSigner};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusSIGN;
			finderArgs = new Object[] {
				statusSigner, start, end, orderByComparator
			};
		}

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSigner legalSigner : list) {
					if (statusSigner != legalSigner.isStatusSigner()) {
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

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_STATUSSIGN_STATUSSIGNER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusSigner);

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Returns the first legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByStatusSIGN_First(
			boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByStatusSIGN_First(
			statusSigner, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusSigner=");
		msg.append(statusSigner);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the first legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByStatusSIGN_First(
		boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		List<LegalSigner> list = findByStatusSIGN(
			statusSigner, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByStatusSIGN_Last(
			boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByStatusSIGN_Last(
			statusSigner, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusSigner=");
		msg.append(statusSigner);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the last legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByStatusSIGN_Last(
		boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		int count = countByStatusSIGN(statusSigner);

		if (count == 0) {
			return null;
		}

		List<LegalSigner> list = findByStatusSIGN(
			statusSigner, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner[] findByStatusSIGN_PrevAndNext(
			long sigId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			LegalSigner[] array = new LegalSignerImpl[3];

			array[0] = getByStatusSIGN_PrevAndNext(
				session, legalSigner, statusSigner, orderByComparator, true);

			array[1] = legalSigner;

			array[2] = getByStatusSIGN_PrevAndNext(
				session, legalSigner, statusSigner, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LegalSigner getByStatusSIGN_PrevAndNext(
		Session session, LegalSigner legalSigner, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

		query.append(_FINDER_COLUMN_STATUSSIGN_STATUSSIGNER_2);

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
			query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(statusSigner);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalSigner)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSigner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal signers where statusSigner = &#63; from the database.
	 *
	 * @param statusSigner the status signer
	 */
	@Override
	public void removeByStatusSIGN(boolean statusSigner) {
		for (LegalSigner legalSigner :
				findByStatusSIGN(
					statusSigner, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers where statusSigner = &#63;.
	 *
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByStatusSIGN(boolean statusSigner) {
		FinderPath finderPath = _finderPathCountByStatusSIGN;

		Object[] finderArgs = new Object[] {statusSigner};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_STATUSSIGN_STATUSSIGNER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(statusSigner);

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

	private static final String _FINDER_COLUMN_STATUSSIGN_STATUSSIGNER_2 =
		"legalSigner.statusSigner = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @return the matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner) {

		return findByFindGroup(
			groupId, companyId, statusSigner, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start,
		int end) {

		return findByFindGroup(
			groupId, companyId, statusSigner, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return findByFindGroup(
			groupId, companyId, statusSigner, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindGroup(
		long groupId, long companyId, boolean statusSigner, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFindGroup;
				finderArgs = new Object[] {groupId, companyId, statusSigner};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, statusSigner, start, end, orderByComparator
			};
		}

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSigner legalSigner : list) {
					if ((groupId != legalSigner.getGroupId()) ||
						(companyId != legalSigner.getCompanyId()) ||
						(statusSigner != legalSigner.isStatusSigner())) {

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

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSSIGNER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusSigner);

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByFindGroup_First(
			long groupId, long companyId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByFindGroup_First(
			groupId, companyId, statusSigner, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusSigner=");
		msg.append(statusSigner);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByFindGroup_First(
		long groupId, long companyId, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		List<LegalSigner> list = findByFindGroup(
			groupId, companyId, statusSigner, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByFindGroup_Last(
			long groupId, long companyId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByFindGroup_Last(
			groupId, companyId, statusSigner, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", statusSigner=");
		msg.append(statusSigner);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByFindGroup_Last(
		long groupId, long companyId, boolean statusSigner,
		OrderByComparator<LegalSigner> orderByComparator) {

		int count = countByFindGroup(groupId, companyId, statusSigner);

		if (count == 0) {
			return null;
		}

		List<LegalSigner> list = findByFindGroup(
			groupId, companyId, statusSigner, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner[] findByFindGroup_PrevAndNext(
			long sigId, long groupId, long companyId, boolean statusSigner,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			LegalSigner[] array = new LegalSignerImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, legalSigner, groupId, companyId, statusSigner,
				orderByComparator, true);

			array[1] = legalSigner;

			array[2] = getByFindGroup_PrevAndNext(
				session, legalSigner, groupId, companyId, statusSigner,
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

	protected LegalSigner getByFindGroup_PrevAndNext(
		Session session, LegalSigner legalSigner, long groupId, long companyId,
		boolean statusSigner, OrderByComparator<LegalSigner> orderByComparator,
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

		query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_STATUSSIGNER_2);

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
			query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(statusSigner);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(legalSigner)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSigner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 */
	@Override
	public void removeByFindGroup(
		long groupId, long companyId, boolean statusSigner) {

		for (LegalSigner legalSigner :
				findByFindGroup(
					groupId, companyId, statusSigner, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and companyId = &#63; and statusSigner = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param statusSigner the status signer
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByFindGroup(
		long groupId, long companyId, boolean statusSigner) {

		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId, statusSigner};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_STATUSSIGNER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(statusSigner);

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
		"legalSigner.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"legalSigner.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_STATUSSIGNER_2 =
		"legalSigner.statusSigner = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindAll(long groupId, long companyId) {
		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator) {

		return findByFindAll(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal signers
	 */
	@Override
	public List<LegalSigner> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<LegalSigner> orderByComparator,
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

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LegalSigner legalSigner : list) {
					if ((groupId != legalSigner.getGroupId()) ||
						(companyId != legalSigner.getCompanyId())) {

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

			query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the first legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<LegalSigner> orderByComparator) {

		List<LegalSigner> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer
	 * @throws NoSuchLegalSignerException if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (legalSigner != null) {
			return legalSigner;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchLegalSignerException(msg.toString());
	}

	/**
	 * Returns the last legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal signer, or <code>null</code> if a matching legal signer could not be found
	 */
	@Override
	public LegalSigner fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<LegalSigner> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<LegalSigner> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the legal signers before and after the current legal signer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param sigId the primary key of the current legal signer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner[] findByFindAll_PrevAndNext(
			long sigId, long groupId, long companyId,
			OrderByComparator<LegalSigner> orderByComparator)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			LegalSigner[] array = new LegalSignerImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, legalSigner, groupId, companyId, orderByComparator,
				true);

			array[1] = legalSigner;

			array[2] = getByFindAll_PrevAndNext(
				session, legalSigner, groupId, companyId, orderByComparator,
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

	protected LegalSigner getByFindAll_PrevAndNext(
		Session session, LegalSigner legalSigner, long groupId, long companyId,
		OrderByComparator<LegalSigner> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LEGALSIGNER_WHERE);

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
			query.append(LegalSignerModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(legalSigner)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LegalSigner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the legal signers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (LegalSigner legalSigner :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching legal signers
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEGALSIGNER_WHERE);

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
		"legalSigner.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"legalSigner.companyId = ?";

	public LegalSignerPersistenceImpl() {
		setModelClass(LegalSigner.class);

		setModelImplClass(LegalSignerImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the legal signer in the entity cache if it is enabled.
	 *
	 * @param legalSigner the legal signer
	 */
	@Override
	public void cacheResult(LegalSigner legalSigner) {
		entityCache.putResult(
			entityCacheEnabled, LegalSignerImpl.class,
			legalSigner.getPrimaryKey(), legalSigner);

		finderCache.putResult(
			_finderPathFetchBySigId, new Object[] {legalSigner.getSigId()},
			legalSigner);

		finderCache.putResult(
			_finderPathFetchByG_S,
			new Object[] {legalSigner.getGroupId(), legalSigner.getSigId()},
			legalSigner);

		legalSigner.resetOriginalValues();
	}

	/**
	 * Caches the legal signers in the entity cache if it is enabled.
	 *
	 * @param legalSigners the legal signers
	 */
	@Override
	public void cacheResult(List<LegalSigner> legalSigners) {
		for (LegalSigner legalSigner : legalSigners) {
			if (entityCache.getResult(
					entityCacheEnabled, LegalSignerImpl.class,
					legalSigner.getPrimaryKey()) == null) {

				cacheResult(legalSigner);
			}
			else {
				legalSigner.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all legal signers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LegalSignerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the legal signer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LegalSigner legalSigner) {
		entityCache.removeResult(
			entityCacheEnabled, LegalSignerImpl.class,
			legalSigner.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LegalSignerModelImpl)legalSigner, true);
	}

	@Override
	public void clearCache(List<LegalSigner> legalSigners) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LegalSigner legalSigner : legalSigners) {
			entityCache.removeResult(
				entityCacheEnabled, LegalSignerImpl.class,
				legalSigner.getPrimaryKey());

			clearUniqueFindersCache((LegalSignerModelImpl)legalSigner, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LegalSignerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LegalSignerModelImpl legalSignerModelImpl) {

		Object[] args = new Object[] {legalSignerModelImpl.getSigId()};

		finderCache.putResult(
			_finderPathCountBySigId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySigId, args, legalSignerModelImpl, false);

		args = new Object[] {
			legalSignerModelImpl.getGroupId(), legalSignerModelImpl.getSigId()
		};

		finderCache.putResult(
			_finderPathCountByG_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByG_S, args, legalSignerModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LegalSignerModelImpl legalSignerModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {legalSignerModelImpl.getSigId()};

			finderCache.removeResult(_finderPathCountBySigId, args);
			finderCache.removeResult(_finderPathFetchBySigId, args);
		}

		if ((legalSignerModelImpl.getColumnBitmask() &
			 _finderPathFetchBySigId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalSignerModelImpl.getOriginalSigId()
			};

			finderCache.removeResult(_finderPathCountBySigId, args);
			finderCache.removeResult(_finderPathFetchBySigId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				legalSignerModelImpl.getGroupId(),
				legalSignerModelImpl.getSigId()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(_finderPathFetchByG_S, args);
		}

		if ((legalSignerModelImpl.getColumnBitmask() &
			 _finderPathFetchByG_S.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				legalSignerModelImpl.getOriginalGroupId(),
				legalSignerModelImpl.getOriginalSigId()
			};

			finderCache.removeResult(_finderPathCountByG_S, args);
			finderCache.removeResult(_finderPathFetchByG_S, args);
		}
	}

	/**
	 * Creates a new legal signer with the primary key. Does not add the legal signer to the database.
	 *
	 * @param sigId the primary key for the new legal signer
	 * @return the new legal signer
	 */
	@Override
	public LegalSigner create(long sigId) {
		LegalSigner legalSigner = new LegalSignerImpl();

		legalSigner.setNew(true);
		legalSigner.setPrimaryKey(sigId);

		legalSigner.setCompanyId(CompanyThreadLocal.getCompanyId());

		return legalSigner;
	}

	/**
	 * Removes the legal signer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer that was removed
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner remove(long sigId) throws NoSuchLegalSignerException {
		return remove((Serializable)sigId);
	}

	/**
	 * Removes the legal signer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the legal signer
	 * @return the legal signer that was removed
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner remove(Serializable primaryKey)
		throws NoSuchLegalSignerException {

		Session session = null;

		try {
			session = openSession();

			LegalSigner legalSigner = (LegalSigner)session.get(
				LegalSignerImpl.class, primaryKey);

			if (legalSigner == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLegalSignerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(legalSigner);
		}
		catch (NoSuchLegalSignerException noSuchEntityException) {
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
	protected LegalSigner removeImpl(LegalSigner legalSigner) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(legalSigner)) {
				legalSigner = (LegalSigner)session.get(
					LegalSignerImpl.class, legalSigner.getPrimaryKeyObj());
			}

			if (legalSigner != null) {
				session.delete(legalSigner);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (legalSigner != null) {
			clearCache(legalSigner);
		}

		return legalSigner;
	}

	@Override
	public LegalSigner updateImpl(LegalSigner legalSigner) {
		boolean isNew = legalSigner.isNew();

		if (!(legalSigner instanceof LegalSignerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(legalSigner.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(legalSigner);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in legalSigner proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LegalSigner implementation " +
					legalSigner.getClass());
		}

		LegalSignerModelImpl legalSignerModelImpl =
			(LegalSignerModelImpl)legalSigner;

		Session session = null;

		try {
			session = openSession();

			if (legalSigner.isNew()) {
				session.save(legalSigner);

				legalSigner.setNew(false);
			}
			else {
				legalSigner = (LegalSigner)session.merge(legalSigner);
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
			Object[] args = new Object[] {legalSignerModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				legalSignerModelImpl.getGroupId(),
				legalSignerModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByG_L, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L, args);

			args = new Object[] {
				legalSignerModelImpl.getGroupId(),
				legalSignerModelImpl.getLanguage(),
				legalSignerModelImpl.isStatusSigner()
			};

			finderCache.removeResult(_finderPathCountByG_L_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByG_L_S, args);

			args = new Object[] {legalSignerModelImpl.isStatusSigner()};

			finderCache.removeResult(_finderPathCountByStatusSIGN, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatusSIGN, args);

			args = new Object[] {
				legalSignerModelImpl.getGroupId(),
				legalSignerModelImpl.getCompanyId(),
				legalSignerModelImpl.isStatusSigner()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			args = new Object[] {
				legalSignerModelImpl.getGroupId(),
				legalSignerModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((legalSignerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSignerModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {legalSignerModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((legalSignerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalSignerModelImpl.getOriginalGroupId(),
					legalSignerModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);

				args = new Object[] {
					legalSignerModelImpl.getGroupId(),
					legalSignerModelImpl.getLanguage()
				};

				finderCache.removeResult(_finderPathCountByG_L, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L, args);
			}

			if ((legalSignerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByG_L_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					legalSignerModelImpl.getOriginalGroupId(),
					legalSignerModelImpl.getOriginalLanguage(),
					legalSignerModelImpl.getOriginalStatusSigner()
				};

				finderCache.removeResult(_finderPathCountByG_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_S, args);

				args = new Object[] {
					legalSignerModelImpl.getGroupId(),
					legalSignerModelImpl.getLanguage(),
					legalSignerModelImpl.isStatusSigner()
				};

				finderCache.removeResult(_finderPathCountByG_L_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByG_L_S, args);
			}

			if ((legalSignerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatusSIGN.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSignerModelImpl.getOriginalStatusSigner()
				};

				finderCache.removeResult(_finderPathCountByStatusSIGN, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatusSIGN, args);

				args = new Object[] {legalSignerModelImpl.isStatusSigner()};

				finderCache.removeResult(_finderPathCountByStatusSIGN, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatusSIGN, args);
			}

			if ((legalSignerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSignerModelImpl.getOriginalGroupId(),
					legalSignerModelImpl.getOriginalCompanyId(),
					legalSignerModelImpl.getOriginalStatusSigner()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					legalSignerModelImpl.getGroupId(),
					legalSignerModelImpl.getCompanyId(),
					legalSignerModelImpl.isStatusSigner()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}

			if ((legalSignerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					legalSignerModelImpl.getOriginalGroupId(),
					legalSignerModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					legalSignerModelImpl.getGroupId(),
					legalSignerModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LegalSignerImpl.class,
			legalSigner.getPrimaryKey(), legalSigner, false);

		clearUniqueFindersCache(legalSignerModelImpl, false);
		cacheUniqueFindersCache(legalSignerModelImpl);

		legalSigner.resetOriginalValues();

		return legalSigner;
	}

	/**
	 * Returns the legal signer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the legal signer
	 * @return the legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLegalSignerException {

		LegalSigner legalSigner = fetchByPrimaryKey(primaryKey);

		if (legalSigner == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLegalSignerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return legalSigner;
	}

	/**
	 * Returns the legal signer with the primary key or throws a <code>NoSuchLegalSignerException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer
	 * @throws NoSuchLegalSignerException if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner findByPrimaryKey(long sigId)
		throws NoSuchLegalSignerException {

		return findByPrimaryKey((Serializable)sigId);
	}

	/**
	 * Returns the legal signer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the legal signer
	 * @return the legal signer, or <code>null</code> if a legal signer with the primary key could not be found
	 */
	@Override
	public LegalSigner fetchByPrimaryKey(long sigId) {
		return fetchByPrimaryKey((Serializable)sigId);
	}

	/**
	 * Returns all the legal signers.
	 *
	 * @return the legal signers
	 */
	@Override
	public List<LegalSigner> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @return the range of legal signers
	 */
	@Override
	public List<LegalSigner> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal signers
	 */
	@Override
	public List<LegalSigner> findAll(
		int start, int end, OrderByComparator<LegalSigner> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the legal signers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalSignerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal signers
	 * @param end the upper bound of the range of legal signers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal signers
	 */
	@Override
	public List<LegalSigner> findAll(
		int start, int end, OrderByComparator<LegalSigner> orderByComparator,
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

		List<LegalSigner> list = null;

		if (useFinderCache) {
			list = (List<LegalSigner>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEGALSIGNER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEGALSIGNER;

				sql = sql.concat(LegalSignerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LegalSigner>)QueryUtil.list(
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
	 * Removes all the legal signers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LegalSigner legalSigner : findAll()) {
			remove(legalSigner);
		}
	}

	/**
	 * Returns the number of legal signers.
	 *
	 * @return the number of legal signers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEGALSIGNER);

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
		return "sigId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LEGALSIGNER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LegalSignerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the legal signer persistence.
	 */
	@Activate
	public void activate() {
		LegalSignerModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LegalSignerModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBySigId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySigId",
			new String[] {Long.class.getName()},
			LegalSignerModelImpl.SIGID_COLUMN_BITMASK);

		_finderPathCountBySigId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			LegalSignerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSignerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathFetchByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_S",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalSignerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSignerModelImpl.SIGID_COLUMN_BITMASK);

		_finderPathCountByG_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] {Long.class.getName(), String.class.getName()},
			LegalSignerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSignerModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalSignerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByG_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByG_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			LegalSignerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSignerModelImpl.LANGUAGE_COLUMN_BITMASK |
			LegalSignerModelImpl.STATUSSIGNER_COLUMN_BITMASK |
			LegalSignerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByG_L_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByStatusSIGN = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusSIGN",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatusSIGN = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusSIGN",
			new String[] {Boolean.class.getName()},
			LegalSignerModelImpl.STATUSSIGNER_COLUMN_BITMASK |
			LegalSignerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByStatusSIGN = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusSIGN",
			new String[] {Boolean.class.getName()});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			LegalSignerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSignerModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalSignerModelImpl.STATUSSIGNER_COLUMN_BITMASK |
			LegalSignerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LegalSignerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			LegalSignerModelImpl.GROUPID_COLUMN_BITMASK |
			LegalSignerModelImpl.COMPANYID_COLUMN_BITMASK |
			LegalSignerModelImpl.CREATEDDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LegalSignerImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.LegalSigner"),
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

	private static final String _SQL_SELECT_LEGALSIGNER =
		"SELECT legalSigner FROM LegalSigner legalSigner";

	private static final String _SQL_SELECT_LEGALSIGNER_WHERE =
		"SELECT legalSigner FROM LegalSigner legalSigner WHERE ";

	private static final String _SQL_COUNT_LEGALSIGNER =
		"SELECT COUNT(legalSigner) FROM LegalSigner legalSigner";

	private static final String _SQL_COUNT_LEGALSIGNER_WHERE =
		"SELECT COUNT(legalSigner) FROM LegalSigner legalSigner WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "legalSigner.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LegalSigner exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LegalSigner exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LegalSignerPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}