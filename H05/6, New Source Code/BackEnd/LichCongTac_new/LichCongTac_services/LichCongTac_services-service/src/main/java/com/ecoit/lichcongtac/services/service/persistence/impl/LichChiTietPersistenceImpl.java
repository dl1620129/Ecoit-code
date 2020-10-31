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

import com.ecoit.lichcongtac.services.exception.NoSuchLichChiTietException;
import com.ecoit.lichcongtac.services.model.LichChiTiet;
import com.ecoit.lichcongtac.services.model.impl.LichChiTietImpl;
import com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl;
import com.ecoit.lichcongtac.services.service.persistence.LichChiTietPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the lich chi tiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LichChiTietPersistence.class)
public class LichChiTietPersistenceImpl
	extends BasePersistenceImpl<LichChiTiet> implements LichChiTietPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LichChiTietUtil</code> to access the lich chi tiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LichChiTietImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLichCongTacId;
	private FinderPath _finderPathWithoutPaginationFindByLichCongTacId;
	private FinderPath _finderPathCountByLichCongTacId;

	/**
	 * Returns all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findByLichCongTacId(long lichCongTacId) {
		return findByLichCongTacId(
			lichCongTacId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of matching lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end) {

		return findByLichCongTacId(lichCongTacId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end,
		OrderByComparator<LichChiTiet> orderByComparator) {

		return findByLichCongTacId(
			lichCongTacId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end,
		OrderByComparator<LichChiTiet> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLichCongTacId;
				finderArgs = new Object[] {lichCongTacId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLichCongTacId;
			finderArgs = new Object[] {
				lichCongTacId, start, end, orderByComparator
			};
		}

		List<LichChiTiet> list = null;

		if (useFinderCache) {
			list = (List<LichChiTiet>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LichChiTiet lichChiTiet : list) {
					if (lichCongTacId != lichChiTiet.getLichCongTacId()) {
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

			query.append(_SQL_SELECT_LICHCHITIET_WHERE);

			query.append(_FINDER_COLUMN_LICHCONGTACID_LICHCONGTACID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(LichChiTietModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lichCongTacId);

				list = (List<LichChiTiet>)QueryUtil.list(
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
	 * Returns the first lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich chi tiet
	 * @throws NoSuchLichChiTietException if a matching lich chi tiet could not be found
	 */
	@Override
	public LichChiTiet findByLichCongTacId_First(
			long lichCongTacId,
			OrderByComparator<LichChiTiet> orderByComparator)
		throws NoSuchLichChiTietException {

		LichChiTiet lichChiTiet = fetchByLichCongTacId_First(
			lichCongTacId, orderByComparator);

		if (lichChiTiet != null) {
			return lichChiTiet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lichCongTacId=");
		msg.append(lichCongTacId);

		msg.append("}");

		throw new NoSuchLichChiTietException(msg.toString());
	}

	/**
	 * Returns the first lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich chi tiet, or <code>null</code> if a matching lich chi tiet could not be found
	 */
	@Override
	public LichChiTiet fetchByLichCongTacId_First(
		long lichCongTacId, OrderByComparator<LichChiTiet> orderByComparator) {

		List<LichChiTiet> list = findByLichCongTacId(
			lichCongTacId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich chi tiet
	 * @throws NoSuchLichChiTietException if a matching lich chi tiet could not be found
	 */
	@Override
	public LichChiTiet findByLichCongTacId_Last(
			long lichCongTacId,
			OrderByComparator<LichChiTiet> orderByComparator)
		throws NoSuchLichChiTietException {

		LichChiTiet lichChiTiet = fetchByLichCongTacId_Last(
			lichCongTacId, orderByComparator);

		if (lichChiTiet != null) {
			return lichChiTiet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lichCongTacId=");
		msg.append(lichCongTacId);

		msg.append("}");

		throw new NoSuchLichChiTietException(msg.toString());
	}

	/**
	 * Returns the last lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich chi tiet, or <code>null</code> if a matching lich chi tiet could not be found
	 */
	@Override
	public LichChiTiet fetchByLichCongTacId_Last(
		long lichCongTacId, OrderByComparator<LichChiTiet> orderByComparator) {

		int count = countByLichCongTacId(lichCongTacId);

		if (count == 0) {
			return null;
		}

		List<LichChiTiet> list = findByLichCongTacId(
			lichCongTacId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lich chi tiets before and after the current lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichChiTietId the primary key of the current lich chi tiet
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich chi tiet
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public LichChiTiet[] findByLichCongTacId_PrevAndNext(
			long lichChiTietId, long lichCongTacId,
			OrderByComparator<LichChiTiet> orderByComparator)
		throws NoSuchLichChiTietException {

		LichChiTiet lichChiTiet = findByPrimaryKey(lichChiTietId);

		Session session = null;

		try {
			session = openSession();

			LichChiTiet[] array = new LichChiTietImpl[3];

			array[0] = getByLichCongTacId_PrevAndNext(
				session, lichChiTiet, lichCongTacId, orderByComparator, true);

			array[1] = lichChiTiet;

			array[2] = getByLichCongTacId_PrevAndNext(
				session, lichChiTiet, lichCongTacId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected LichChiTiet getByLichCongTacId_PrevAndNext(
		Session session, LichChiTiet lichChiTiet, long lichCongTacId,
		OrderByComparator<LichChiTiet> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICHCHITIET_WHERE);

		query.append(_FINDER_COLUMN_LICHCONGTACID_LICHCONGTACID_2);

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
			query.append(LichChiTietModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lichCongTacId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lichChiTiet)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<LichChiTiet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lich chi tiets where lichCongTacId = &#63; from the database.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 */
	@Override
	public void removeByLichCongTacId(long lichCongTacId) {
		for (LichChiTiet lichChiTiet :
				findByLichCongTacId(
					lichCongTacId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lichChiTiet);
		}
	}

	/**
	 * Returns the number of lich chi tiets where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @return the number of matching lich chi tiets
	 */
	@Override
	public int countByLichCongTacId(long lichCongTacId) {
		FinderPath finderPath = _finderPathCountByLichCongTacId;

		Object[] finderArgs = new Object[] {lichCongTacId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICHCHITIET_WHERE);

			query.append(_FINDER_COLUMN_LICHCONGTACID_LICHCONGTACID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_LICHCONGTACID_LICHCONGTACID_2 =
		"lichChiTiet.lichCongTacId = ?";

	public LichChiTietPersistenceImpl() {
		setModelClass(LichChiTiet.class);

		setModelImplClass(LichChiTietImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the lich chi tiet in the entity cache if it is enabled.
	 *
	 * @param lichChiTiet the lich chi tiet
	 */
	@Override
	public void cacheResult(LichChiTiet lichChiTiet) {
		entityCache.putResult(
			entityCacheEnabled, LichChiTietImpl.class,
			lichChiTiet.getPrimaryKey(), lichChiTiet);

		lichChiTiet.resetOriginalValues();
	}

	/**
	 * Caches the lich chi tiets in the entity cache if it is enabled.
	 *
	 * @param lichChiTiets the lich chi tiets
	 */
	@Override
	public void cacheResult(List<LichChiTiet> lichChiTiets) {
		for (LichChiTiet lichChiTiet : lichChiTiets) {
			if (entityCache.getResult(
					entityCacheEnabled, LichChiTietImpl.class,
					lichChiTiet.getPrimaryKey()) == null) {

				cacheResult(lichChiTiet);
			}
			else {
				lichChiTiet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lich chi tiets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LichChiTietImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lich chi tiet.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LichChiTiet lichChiTiet) {
		entityCache.removeResult(
			entityCacheEnabled, LichChiTietImpl.class,
			lichChiTiet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LichChiTiet> lichChiTiets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LichChiTiet lichChiTiet : lichChiTiets) {
			entityCache.removeResult(
				entityCacheEnabled, LichChiTietImpl.class,
				lichChiTiet.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, LichChiTietImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lich chi tiet with the primary key. Does not add the lich chi tiet to the database.
	 *
	 * @param lichChiTietId the primary key for the new lich chi tiet
	 * @return the new lich chi tiet
	 */
	@Override
	public LichChiTiet create(long lichChiTietId) {
		LichChiTiet lichChiTiet = new LichChiTietImpl();

		lichChiTiet.setNew(true);
		lichChiTiet.setPrimaryKey(lichChiTietId);

		lichChiTiet.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lichChiTiet;
	}

	/**
	 * Removes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public LichChiTiet remove(long lichChiTietId)
		throws NoSuchLichChiTietException {

		return remove((Serializable)lichChiTietId);
	}

	/**
	 * Removes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public LichChiTiet remove(Serializable primaryKey)
		throws NoSuchLichChiTietException {

		Session session = null;

		try {
			session = openSession();

			LichChiTiet lichChiTiet = (LichChiTiet)session.get(
				LichChiTietImpl.class, primaryKey);

			if (lichChiTiet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLichChiTietException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lichChiTiet);
		}
		catch (NoSuchLichChiTietException noSuchEntityException) {
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
	protected LichChiTiet removeImpl(LichChiTiet lichChiTiet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lichChiTiet)) {
				lichChiTiet = (LichChiTiet)session.get(
					LichChiTietImpl.class, lichChiTiet.getPrimaryKeyObj());
			}

			if (lichChiTiet != null) {
				session.delete(lichChiTiet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lichChiTiet != null) {
			clearCache(lichChiTiet);
		}

		return lichChiTiet;
	}

	@Override
	public LichChiTiet updateImpl(LichChiTiet lichChiTiet) {
		boolean isNew = lichChiTiet.isNew();

		if (!(lichChiTiet instanceof LichChiTietModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lichChiTiet.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lichChiTiet);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lichChiTiet proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LichChiTiet implementation " +
					lichChiTiet.getClass());
		}

		LichChiTietModelImpl lichChiTietModelImpl =
			(LichChiTietModelImpl)lichChiTiet;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lichChiTiet.getCreateDate() == null)) {
			if (serviceContext == null) {
				lichChiTiet.setCreateDate(now);
			}
			else {
				lichChiTiet.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!lichChiTietModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lichChiTiet.setModifiedDate(now);
			}
			else {
				lichChiTiet.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lichChiTiet.isNew()) {
				session.save(lichChiTiet);

				lichChiTiet.setNew(false);
			}
			else {
				lichChiTiet = (LichChiTiet)session.merge(lichChiTiet);
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
				lichChiTietModelImpl.getLichCongTacId()
			};

			finderCache.removeResult(_finderPathCountByLichCongTacId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLichCongTacId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((lichChiTietModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLichCongTacId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lichChiTietModelImpl.getOriginalLichCongTacId()
				};

				finderCache.removeResult(_finderPathCountByLichCongTacId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLichCongTacId, args);

				args = new Object[] {lichChiTietModelImpl.getLichCongTacId()};

				finderCache.removeResult(_finderPathCountByLichCongTacId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLichCongTacId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LichChiTietImpl.class,
			lichChiTiet.getPrimaryKey(), lichChiTiet, false);

		lichChiTiet.resetOriginalValues();

		return lichChiTiet;
	}

	/**
	 * Returns the lich chi tiet with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public LichChiTiet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLichChiTietException {

		LichChiTiet lichChiTiet = fetchByPrimaryKey(primaryKey);

		if (lichChiTiet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLichChiTietException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lichChiTiet;
	}

	/**
	 * Returns the lich chi tiet with the primary key or throws a <code>NoSuchLichChiTietException</code> if it could not be found.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public LichChiTiet findByPrimaryKey(long lichChiTietId)
		throws NoSuchLichChiTietException {

		return findByPrimaryKey((Serializable)lichChiTietId);
	}

	/**
	 * Returns the lich chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet, or <code>null</code> if a lich chi tiet with the primary key could not be found
	 */
	@Override
	public LichChiTiet fetchByPrimaryKey(long lichChiTietId) {
		return fetchByPrimaryKey((Serializable)lichChiTietId);
	}

	/**
	 * Returns all the lich chi tiets.
	 *
	 * @return the lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findAll(
		int start, int end, OrderByComparator<LichChiTiet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lich chi tiets
	 */
	@Override
	public List<LichChiTiet> findAll(
		int start, int end, OrderByComparator<LichChiTiet> orderByComparator,
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

		List<LichChiTiet> list = null;

		if (useFinderCache) {
			list = (List<LichChiTiet>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LICHCHITIET);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICHCHITIET;

				sql = sql.concat(LichChiTietModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<LichChiTiet>)QueryUtil.list(
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
	 * Removes all the lich chi tiets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LichChiTiet lichChiTiet : findAll()) {
			remove(lichChiTiet);
		}
	}

	/**
	 * Returns the number of lich chi tiets.
	 *
	 * @return the number of lich chi tiets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICHCHITIET);

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
		return "lichChiTietId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LICHCHITIET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LichChiTietModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lich chi tiet persistence.
	 */
	@Activate
	public void activate() {
		LichChiTietModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LichChiTietModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByLichCongTacId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLichCongTacId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLichCongTacId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LichChiTietImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLichCongTacId",
			new String[] {Long.class.getName()},
			LichChiTietModelImpl.LICHCONGTACID_COLUMN_BITMASK);

		_finderPathCountByLichCongTacId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLichCongTacId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LichChiTietImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.lichcongtac.services.model.LichChiTiet"),
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

	private static final String _SQL_SELECT_LICHCHITIET =
		"SELECT lichChiTiet FROM LichChiTiet lichChiTiet";

	private static final String _SQL_SELECT_LICHCHITIET_WHERE =
		"SELECT lichChiTiet FROM LichChiTiet lichChiTiet WHERE ";

	private static final String _SQL_COUNT_LICHCHITIET =
		"SELECT COUNT(lichChiTiet) FROM LichChiTiet lichChiTiet";

	private static final String _SQL_COUNT_LICHCHITIET_WHERE =
		"SELECT COUNT(lichChiTiet) FROM LichChiTiet lichChiTiet WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lichChiTiet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LichChiTiet exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LichChiTiet exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LichChiTietPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_lichPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}