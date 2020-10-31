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

package com.ecoit.lichcongtac.services.service.persistence.impl;

import com.ecoit.lichcongtac.services.exception.NoSuchLichCongTacException;
import com.ecoit.lichcongtac.services.model.LichCongTac;
import com.ecoit.lichcongtac.services.model.impl.LichCongTacImpl;
import com.ecoit.lichcongtac.services.model.impl.LichCongTacModelImpl;
import com.ecoit.lichcongtac.services.service.persistence.LichCongTacPersistence;
import com.ecoit.lichcongtac.services.service.persistence.impl.constants.ecoit_lichPersistenceConstants;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the lich cong tac service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LichCongTacPersistence.class)
public class LichCongTacPersistenceImpl
	extends BasePersistenceImpl<LichCongTac> implements LichCongTacPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LichCongTacUtil</code> to access the lich cong tac persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LichCongTacImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBystatusAndId;
	private FinderPath _finderPathCountBystatusAndId;

	/**
	 * Returns the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; or throws a <code>NoSuchLichCongTacException</code> if it could not be found.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich cong tac
	 * @throws NoSuchLichCongTacException if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac findBystatusAndId(
			int trangthaiLichCongTac, long lichCongTacId)
		throws NoSuchLichCongTacException {

		LichCongTac lichCongTac = fetchBystatusAndId(
			trangthaiLichCongTac, lichCongTacId);

		if (lichCongTac == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("trangthaiLichCongTac=");
			msg.append(trangthaiLichCongTac);

			msg.append(", lichCongTacId=");
			msg.append(lichCongTacId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLichCongTacException(msg.toString());
		}

		return lichCongTac;
	}

	/**
	 * Returns the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac fetchBystatusAndId(
		int trangthaiLichCongTac, long lichCongTacId) {

		return fetchBystatusAndId(trangthaiLichCongTac, lichCongTacId, true);
	}

	/**
	 * Returns the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac fetchBystatusAndId(
		int trangthaiLichCongTac, long lichCongTacId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {trangthaiLichCongTac, lichCongTacId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBystatusAndId, finderArgs, this);
		}

		if (result instanceof LichCongTac) {
			LichCongTac lichCongTac = (LichCongTac)result;

			if ((trangthaiLichCongTac !=
					lichCongTac.getTrangthaiLichCongTac()) ||
				(lichCongTacId != lichCongTac.getLichCongTacId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LICHCONGTAC_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDID_TRANGTHAILICHCONGTAC_2);

			query.append(_FINDER_COLUMN_STATUSANDID_LICHCONGTACID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangthaiLichCongTac);

				qPos.add(lichCongTacId);

				List<LichCongTac> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBystatusAndId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									trangthaiLichCongTac, lichCongTacId
								};
							}

							_log.warn(
								"LichCongTacPersistenceImpl.fetchBystatusAndId(int, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LichCongTac lichCongTac = list.get(0);

					result = lichCongTac;

					cacheResult(lichCongTac);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBystatusAndId, finderArgs);
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
			return (LichCongTac)result;
		}
	}

	/**
	 * Removes the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; from the database.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the lich cong tac that was removed
	 */
	@Override
	public LichCongTac removeBystatusAndId(
			int trangthaiLichCongTac, long lichCongTacId)
		throws NoSuchLichCongTacException {

		LichCongTac lichCongTac = findBystatusAndId(
			trangthaiLichCongTac, lichCongTacId);

		return remove(lichCongTac);
	}

	/**
	 * Returns the number of lich cong tacs where trangthaiLichCongTac = &#63; and lichCongTacId = &#63;.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the number of matching lich cong tacs
	 */
	@Override
	public int countBystatusAndId(
		int trangthaiLichCongTac, long lichCongTacId) {

		FinderPath finderPath = _finderPathCountBystatusAndId;

		Object[] finderArgs = new Object[] {
			trangthaiLichCongTac, lichCongTacId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LICHCONGTAC_WHERE);

			query.append(_FINDER_COLUMN_STATUSANDID_TRANGTHAILICHCONGTAC_2);

			query.append(_FINDER_COLUMN_STATUSANDID_LICHCONGTACID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(trangthaiLichCongTac);

				qPos.add(lichCongTacId);

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
		_FINDER_COLUMN_STATUSANDID_TRANGTHAILICHCONGTAC_2 =
			"lichCongTac.trangthaiLichCongTac = ? AND ";

	private static final String _FINDER_COLUMN_STATUSANDID_LICHCONGTACID_2 =
		"lichCongTac.lichCongTacId = ?";

	private FinderPath _finderPathWithPaginationFindByorganization;
	private FinderPath _finderPathWithoutPaginationFindByorganization;
	private FinderPath _finderPathCountByorganization;

	/**
	 * Returns all the lich cong tacs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching lich cong tacs
	 */
	@Override
	public List<LichCongTac> findByorganization(long organizationId) {
		return findByorganization(
			organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich cong tacs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of matching lich cong tacs
	 */
	@Override
	public List<LichCongTac> findByorganization(
		long organizationId, int start, int end) {

		return findByorganization(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich cong tacs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich cong tacs
	 */
	@Override
	public List<LichCongTac> findByorganization(
		long organizationId, int start, int end,
		OrderByComparator<LichCongTac> orderByComparator) {

		return findByorganization(
			organizationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich cong tacs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lich cong tacs
	 */
	@Override
	public List<LichCongTac> findByorganization(
		long organizationId, int start, int end,
		OrderByComparator<LichCongTac> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByorganization;
				finderArgs = new Object[] {organizationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByorganization;
			finderArgs = new Object[] {
				organizationId, start, end, orderByComparator
			};
		}

		List<LichCongTac> list = null;

		if (useFinderCache) {
			list = (List<LichCongTac>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichCongTac lichCongTac : list) {
					if (organizationId != lichCongTac.getOrganizationId()) {
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

			query.append(_SQL_SELECT_LICHCONGTAC_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LichCongTacModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				list = (List<LichCongTac>)QueryUtil.list(
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
	 * Returns the first lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich cong tac
	 * @throws NoSuchLichCongTacException if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac findByorganization_First(
			long organizationId,
			OrderByComparator<LichCongTac> orderByComparator)
		throws NoSuchLichCongTacException {

		LichCongTac lichCongTac = fetchByorganization_First(
			organizationId, orderByComparator);

		if (lichCongTac != null) {
			return lichCongTac;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLichCongTacException(msg.toString());
	}

	/**
	 * Returns the first lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac fetchByorganization_First(
		long organizationId, OrderByComparator<LichCongTac> orderByComparator) {

		List<LichCongTac> list = findByorganization(
			organizationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich cong tac
	 * @throws NoSuchLichCongTacException if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac findByorganization_Last(
			long organizationId,
			OrderByComparator<LichCongTac> orderByComparator)
		throws NoSuchLichCongTacException {

		LichCongTac lichCongTac = fetchByorganization_Last(
			organizationId, orderByComparator);

		if (lichCongTac != null) {
			return lichCongTac;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchLichCongTacException(msg.toString());
	}

	/**
	 * Returns the last lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	@Override
	public LichCongTac fetchByorganization_Last(
		long organizationId, OrderByComparator<LichCongTac> orderByComparator) {

		int count = countByorganization(organizationId);

		if (count == 0) {
			return null;
		}

		List<LichCongTac> list = findByorganization(
			organizationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich cong tacs before and after the current lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param lichCongTacId the primary key of the current lich cong tac
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich cong tac
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac[] findByorganization_PrevAndNext(
			long lichCongTacId, long organizationId,
			OrderByComparator<LichCongTac> orderByComparator)
		throws NoSuchLichCongTacException {

		LichCongTac lichCongTac = findByPrimaryKey(lichCongTacId);

		Session session = null;

		try {
			session = openSession();

			LichCongTac[] array = new LichCongTacImpl[3];

			array[0] = getByorganization_PrevAndNext(
				session, lichCongTac, organizationId, orderByComparator, true);

			array[1] = lichCongTac;

			array[2] = getByorganization_PrevAndNext(
				session, lichCongTac, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LichCongTac getByorganization_PrevAndNext(
		Session session, LichCongTac lichCongTac, long organizationId,
		OrderByComparator<LichCongTac> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICHCONGTAC_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

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
			query.append(LichCongTacModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lichCongTac)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichCongTac> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich cong tacs where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganization(long organizationId) {
		for (LichCongTac lichCongTac :
				findByorganization(
					organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lichCongTac);
		}
	}

	/**
	 * Returns the number of lich cong tacs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching lich cong tacs
	 */
	@Override
	public int countByorganization(long organizationId) {
		FinderPath finderPath = _finderPathCountByorganization;

		Object[] finderArgs = new Object[] {organizationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHCONGTAC_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

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

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 =
		"lichCongTac.organizationId = ?";

	public LichCongTacPersistenceImpl() {
		setModelClass(LichCongTac.class);

		setModelImplClass(LichCongTacImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the lich cong tac in the entity cache if it is enabled.
	 *
	 * @param lichCongTac the lich cong tac
	 */
	@Override
	public void cacheResult(LichCongTac lichCongTac) {
		entityCache.putResult(
			entityCacheEnabled, LichCongTacImpl.class,
			lichCongTac.getPrimaryKey(), lichCongTac);

		finderCache.putResult(
			_finderPathFetchBystatusAndId,
			new Object[] {
				lichCongTac.getTrangthaiLichCongTac(),
				lichCongTac.getLichCongTacId()
			},
			lichCongTac);

		lichCongTac.resetOriginalValues();
	}

	/**
	 * Caches the lich cong tacs in the entity cache if it is enabled.
	 *
	 * @param lichCongTacs the lich cong tacs
	 */
	@Override
	public void cacheResult(List<LichCongTac> lichCongTacs) {
		for (LichCongTac lichCongTac : lichCongTacs) {
			if (entityCache.getResult(
					entityCacheEnabled, LichCongTacImpl.class,
					lichCongTac.getPrimaryKey()) == null) {

				cacheResult(lichCongTac);
			}
			else {
				lichCongTac.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lich cong tacs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LichCongTacImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lich cong tac.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LichCongTac lichCongTac) {
		entityCache.removeResult(
			entityCacheEnabled, LichCongTacImpl.class,
			lichCongTac.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LichCongTacModelImpl)lichCongTac, true);
	}

	@Override
	public void clearCache(List<LichCongTac> lichCongTacs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LichCongTac lichCongTac : lichCongTacs) {
			entityCache.removeResult(
				entityCacheEnabled, LichCongTacImpl.class,
				lichCongTac.getPrimaryKey());

			clearUniqueFindersCache((LichCongTacModelImpl)lichCongTac, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LichCongTacImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LichCongTacModelImpl lichCongTacModelImpl) {

		Object[] args = new Object[] {
			lichCongTacModelImpl.getTrangthaiLichCongTac(),
			lichCongTacModelImpl.getLichCongTacId()
		};

		finderCache.putResult(
			_finderPathCountBystatusAndId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBystatusAndId, args, lichCongTacModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LichCongTacModelImpl lichCongTacModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				lichCongTacModelImpl.getTrangthaiLichCongTac(),
				lichCongTacModelImpl.getLichCongTacId()
			};

			finderCache.removeResult(_finderPathCountBystatusAndId, args);
			finderCache.removeResult(_finderPathFetchBystatusAndId, args);
		}

		if ((lichCongTacModelImpl.getColumnBitmask() &
			 _finderPathFetchBystatusAndId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				lichCongTacModelImpl.getOriginalTrangthaiLichCongTac(),
				lichCongTacModelImpl.getOriginalLichCongTacId()
			};

			finderCache.removeResult(_finderPathCountBystatusAndId, args);
			finderCache.removeResult(_finderPathFetchBystatusAndId, args);
		}
	}

	/**
	 * Creates a new lich cong tac with the primary key. Does not add the lich cong tac to the database.
	 *
	 * @param lichCongTacId the primary key for the new lich cong tac
	 * @return the new lich cong tac
	 */
	@Override
	public LichCongTac create(long lichCongTacId) {
		LichCongTac lichCongTac = new LichCongTacImpl();

		lichCongTac.setNew(true);
		lichCongTac.setPrimaryKey(lichCongTacId);

		lichCongTac.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lichCongTac;
	}

	/**
	 * Removes the lich cong tac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac that was removed
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac remove(long lichCongTacId)
		throws NoSuchLichCongTacException {

		return remove((Serializable)lichCongTacId);
	}

	/**
	 * Removes the lich cong tac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lich cong tac
	 * @return the lich cong tac that was removed
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac remove(Serializable primaryKey)
		throws NoSuchLichCongTacException {

		Session session = null;

		try {
			session = openSession();

			LichCongTac lichCongTac = (LichCongTac)session.get(
				LichCongTacImpl.class, primaryKey);

			if (lichCongTac == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLichCongTacException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lichCongTac);
		}
		catch (NoSuchLichCongTacException noSuchEntityException) {
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
	protected LichCongTac removeImpl(LichCongTac lichCongTac) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lichCongTac)) {
				lichCongTac = (LichCongTac)session.get(
					LichCongTacImpl.class, lichCongTac.getPrimaryKeyObj());
			}

			if (lichCongTac != null) {
				session.delete(lichCongTac);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lichCongTac != null) {
			clearCache(lichCongTac);
		}

		return lichCongTac;
	}

	@Override
	public LichCongTac updateImpl(LichCongTac lichCongTac) {
		boolean isNew = lichCongTac.isNew();

		if (!(lichCongTac instanceof LichCongTacModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lichCongTac.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lichCongTac);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lichCongTac proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LichCongTac implementation " +
					lichCongTac.getClass());
		}

		LichCongTacModelImpl lichCongTacModelImpl =
			(LichCongTacModelImpl)lichCongTac;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lichCongTac.getCreateDate() == null)) {
			if (serviceContext == null) {
				lichCongTac.setCreateDate(now);
			}
			else {
				lichCongTac.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!lichCongTacModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lichCongTac.setModifiedDate(now);
			}
			else {
				lichCongTac.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lichCongTac.isNew()) {
				session.save(lichCongTac);

				lichCongTac.setNew(false);
			}
			else {
				lichCongTac = (LichCongTac)session.merge(lichCongTac);
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
				lichCongTacModelImpl.getOrganizationId()
			};

			finderCache.removeResult(_finderPathCountByorganization, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByorganization, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((lichCongTacModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByorganization.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lichCongTacModelImpl.getOriginalOrganizationId()
				};

				finderCache.removeResult(_finderPathCountByorganization, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByorganization, args);

				args = new Object[] {lichCongTacModelImpl.getOrganizationId()};

				finderCache.removeResult(_finderPathCountByorganization, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByorganization, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LichCongTacImpl.class,
			lichCongTac.getPrimaryKey(), lichCongTac, false);

		clearUniqueFindersCache(lichCongTacModelImpl, false);
		cacheUniqueFindersCache(lichCongTacModelImpl);

		lichCongTac.resetOriginalValues();

		return lichCongTac;
	}

	/**
	 * Returns the lich cong tac with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich cong tac
	 * @return the lich cong tac
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLichCongTacException {

		LichCongTac lichCongTac = fetchByPrimaryKey(primaryKey);

		if (lichCongTac == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLichCongTacException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lichCongTac;
	}

	/**
	 * Returns the lich cong tac with the primary key or throws a <code>NoSuchLichCongTacException</code> if it could not be found.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac findByPrimaryKey(long lichCongTacId)
		throws NoSuchLichCongTacException {

		return findByPrimaryKey((Serializable)lichCongTacId);
	}

	/**
	 * Returns the lich cong tac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac, or <code>null</code> if a lich cong tac with the primary key could not be found
	 */
	@Override
	public LichCongTac fetchByPrimaryKey(long lichCongTacId) {
		return fetchByPrimaryKey((Serializable)lichCongTacId);
	}

	/**
	 * Returns all the lich cong tacs.
	 *
	 * @return the lich cong tacs
	 */
	@Override
	public List<LichCongTac> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of lich cong tacs
	 */
	@Override
	public List<LichCongTac> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich cong tacs
	 */
	@Override
	public List<LichCongTac> findAll(
		int start, int end, OrderByComparator<LichCongTac> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lich cong tacs
	 */
	@Override
	public List<LichCongTac> findAll(
		int start, int end, OrderByComparator<LichCongTac> orderByComparator,
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

		List<LichCongTac> list = null;

		if (useFinderCache) {
			list = (List<LichCongTac>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LICHCONGTAC);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICHCONGTAC;

				sql = sql.concat(LichCongTacModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LichCongTac>)QueryUtil.list(
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
	 * Removes all the lich cong tacs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LichCongTac lichCongTac : findAll()) {
			remove(lichCongTac);
		}
	}

	/**
	 * Returns the number of lich cong tacs.
	 *
	 * @return the number of lich cong tacs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICHCONGTAC);

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
		return "lichCongTacId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LICHCONGTAC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LichCongTacModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lich cong tac persistence.
	 */
	@Activate
	public void activate() {
		LichCongTacModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LichCongTacModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichCongTacImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichCongTacImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBystatusAndId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichCongTacImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystatusAndId",
			new String[] {Integer.class.getName(), Long.class.getName()},
			LichCongTacModelImpl.TRANGTHAILICHCONGTAC_COLUMN_BITMASK |
			LichCongTacModelImpl.LICHCONGTACID_COLUMN_BITMASK);

		_finderPathCountBystatusAndId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatusAndId",
			new String[] {Integer.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByorganization = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichCongTacImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganization",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByorganization = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichCongTacImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganization",
			new String[] {Long.class.getName()},
			LichCongTacModelImpl.ORGANIZATIONID_COLUMN_BITMASK);

		_finderPathCountByorganization = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorganization",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LichCongTacImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_lichPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.lichcongtac.services.model.LichCongTac"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_lichPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_lichPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_LICHCONGTAC =
		"SELECT lichCongTac FROM LichCongTac lichCongTac";

	private static final String _SQL_SELECT_LICHCONGTAC_WHERE =
		"SELECT lichCongTac FROM LichCongTac lichCongTac WHERE ";

	private static final String _SQL_COUNT_LICHCONGTAC =
		"SELECT COUNT(lichCongTac) FROM LichCongTac lichCongTac";

	private static final String _SQL_COUNT_LICHCONGTAC_WHERE =
		"SELECT COUNT(lichCongTac) FROM LichCongTac lichCongTac WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lichCongTac.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LichCongTac exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LichCongTac exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LichCongTacPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_lichPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}