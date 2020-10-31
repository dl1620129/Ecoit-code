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

import com.ecoit.lichcongtac.services.exception.NoSuchColumnGroupRelException;
import com.ecoit.lichcongtac.services.model.ColumnGroupRel;
import com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelImpl;
import com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl;
import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK;
import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPersistence;
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
 * The persistence implementation for the column group rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ColumnGroupRelPersistence.class)
public class ColumnGroupRelPersistenceImpl
	extends BasePersistenceImpl<ColumnGroupRel>
	implements ColumnGroupRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ColumnGroupRelUtil</code> to access the column group rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ColumnGroupRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching column group rels
	 */
	@Override
	public List<ColumnGroupRel> findByGroup(long userPermissionGroupId) {
		return findByGroup(
			userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of matching column group rels
	 */
	@Override
	public List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return findByGroup(userPermissionGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching column group rels
	 */
	@Override
	public List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return findByGroup(
			userPermissionGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching column group rels
	 */
	@Override
	public List<ColumnGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup;
				finderArgs = new Object[] {userPermissionGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup;
			finderArgs = new Object[] {
				userPermissionGroupId, start, end, orderByComparator
			};
		}

		List<ColumnGroupRel> list = null;

		if (useFinderCache) {
			list = (List<ColumnGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ColumnGroupRel columnGroupRel : list) {
					if (userPermissionGroupId !=
							columnGroupRel.getUserPermissionGroupId()) {

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

			query.append(_SQL_SELECT_COLUMNGROUPREL_WHERE);

			query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(ColumnGroupRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userPermissionGroupId);

				list = (List<ColumnGroupRel>)QueryUtil.list(
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
	 * Returns the first column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column group rel
	 * @throws NoSuchColumnGroupRelException if a matching column group rel could not be found
	 */
	@Override
	public ColumnGroupRel findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<ColumnGroupRel> orderByComparator)
		throws NoSuchColumnGroupRelException {

		ColumnGroupRel columnGroupRel = fetchByGroup_First(
			userPermissionGroupId, orderByComparator);

		if (columnGroupRel != null) {
			return columnGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchColumnGroupRelException(msg.toString());
	}

	/**
	 * Returns the first column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching column group rel, or <code>null</code> if a matching column group rel could not be found
	 */
	@Override
	public ColumnGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		List<ColumnGroupRel> list = findByGroup(
			userPermissionGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column group rel
	 * @throws NoSuchColumnGroupRelException if a matching column group rel could not be found
	 */
	@Override
	public ColumnGroupRel findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<ColumnGroupRel> orderByComparator)
		throws NoSuchColumnGroupRelException {

		ColumnGroupRel columnGroupRel = fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);

		if (columnGroupRel != null) {
			return columnGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchColumnGroupRelException(msg.toString());
	}

	/**
	 * Returns the last column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching column group rel, or <code>null</code> if a matching column group rel could not be found
	 */
	@Override
	public ColumnGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		int count = countByGroup(userPermissionGroupId);

		if (count == 0) {
			return null;
		}

		List<ColumnGroupRel> list = findByGroup(
			userPermissionGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the column group rels before and after the current column group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param columnGroupRelPK the primary key of the current column group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	@Override
	public ColumnGroupRel[] findByGroup_PrevAndNext(
			ColumnGroupRelPK columnGroupRelPK, long userPermissionGroupId,
			OrderByComparator<ColumnGroupRel> orderByComparator)
		throws NoSuchColumnGroupRelException {

		ColumnGroupRel columnGroupRel = findByPrimaryKey(columnGroupRelPK);

		Session session = null;

		try {
			session = openSession();

			ColumnGroupRel[] array = new ColumnGroupRelImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, columnGroupRel, userPermissionGroupId,
				orderByComparator, true);

			array[1] = columnGroupRel;

			array[2] = getByGroup_PrevAndNext(
				session, columnGroupRel, userPermissionGroupId,
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

	protected ColumnGroupRel getByGroup_PrevAndNext(
		Session session, ColumnGroupRel columnGroupRel,
		long userPermissionGroupId,
		OrderByComparator<ColumnGroupRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COLUMNGROUPREL_WHERE);

		query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

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
			query.append(ColumnGroupRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userPermissionGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						columnGroupRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<ColumnGroupRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the column group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	@Override
	public void removeByGroup(long userPermissionGroupId) {
		for (ColumnGroupRel columnGroupRel :
				findByGroup(
					userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(columnGroupRel);
		}
	}

	/**
	 * Returns the number of column group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching column group rels
	 */
	@Override
	public int countByGroup(long userPermissionGroupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {userPermissionGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COLUMNGROUPREL_WHERE);

			query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userPermissionGroupId);

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

	private static final String _FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2 =
		"columnGroupRel.id.userPermissionGroupId = ?";

	public ColumnGroupRelPersistenceImpl() {
		setModelClass(ColumnGroupRel.class);

		setModelImplClass(ColumnGroupRelImpl.class);
		setModelPKClass(ColumnGroupRelPK.class);
	}

	/**
	 * Caches the column group rel in the entity cache if it is enabled.
	 *
	 * @param columnGroupRel the column group rel
	 */
	@Override
	public void cacheResult(ColumnGroupRel columnGroupRel) {
		entityCache.putResult(
			entityCacheEnabled, ColumnGroupRelImpl.class,
			columnGroupRel.getPrimaryKey(), columnGroupRel);

		columnGroupRel.resetOriginalValues();
	}

	/**
	 * Caches the column group rels in the entity cache if it is enabled.
	 *
	 * @param columnGroupRels the column group rels
	 */
	@Override
	public void cacheResult(List<ColumnGroupRel> columnGroupRels) {
		for (ColumnGroupRel columnGroupRel : columnGroupRels) {
			if (entityCache.getResult(
					entityCacheEnabled, ColumnGroupRelImpl.class,
					columnGroupRel.getPrimaryKey()) == null) {

				cacheResult(columnGroupRel);
			}
			else {
				columnGroupRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all column group rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ColumnGroupRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the column group rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ColumnGroupRel columnGroupRel) {
		entityCache.removeResult(
			entityCacheEnabled, ColumnGroupRelImpl.class,
			columnGroupRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ColumnGroupRel> columnGroupRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ColumnGroupRel columnGroupRel : columnGroupRels) {
			entityCache.removeResult(
				entityCacheEnabled, ColumnGroupRelImpl.class,
				columnGroupRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ColumnGroupRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new column group rel with the primary key. Does not add the column group rel to the database.
	 *
	 * @param columnGroupRelPK the primary key for the new column group rel
	 * @return the new column group rel
	 */
	@Override
	public ColumnGroupRel create(ColumnGroupRelPK columnGroupRelPK) {
		ColumnGroupRel columnGroupRel = new ColumnGroupRelImpl();

		columnGroupRel.setNew(true);
		columnGroupRel.setPrimaryKey(columnGroupRelPK);

		return columnGroupRel;
	}

	/**
	 * Removes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	@Override
	public ColumnGroupRel remove(ColumnGroupRelPK columnGroupRelPK)
		throws NoSuchColumnGroupRelException {

		return remove((Serializable)columnGroupRelPK);
	}

	/**
	 * Removes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	@Override
	public ColumnGroupRel remove(Serializable primaryKey)
		throws NoSuchColumnGroupRelException {

		Session session = null;

		try {
			session = openSession();

			ColumnGroupRel columnGroupRel = (ColumnGroupRel)session.get(
				ColumnGroupRelImpl.class, primaryKey);

			if (columnGroupRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchColumnGroupRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(columnGroupRel);
		}
		catch (NoSuchColumnGroupRelException noSuchEntityException) {
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
	protected ColumnGroupRel removeImpl(ColumnGroupRel columnGroupRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(columnGroupRel)) {
				columnGroupRel = (ColumnGroupRel)session.get(
					ColumnGroupRelImpl.class,
					columnGroupRel.getPrimaryKeyObj());
			}

			if (columnGroupRel != null) {
				session.delete(columnGroupRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (columnGroupRel != null) {
			clearCache(columnGroupRel);
		}

		return columnGroupRel;
	}

	@Override
	public ColumnGroupRel updateImpl(ColumnGroupRel columnGroupRel) {
		boolean isNew = columnGroupRel.isNew();

		if (!(columnGroupRel instanceof ColumnGroupRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(columnGroupRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					columnGroupRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in columnGroupRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ColumnGroupRel implementation " +
					columnGroupRel.getClass());
		}

		ColumnGroupRelModelImpl columnGroupRelModelImpl =
			(ColumnGroupRelModelImpl)columnGroupRel;

		Session session = null;

		try {
			session = openSession();

			if (columnGroupRel.isNew()) {
				session.save(columnGroupRel);

				columnGroupRel.setNew(false);
			}
			else {
				columnGroupRel = (ColumnGroupRel)session.merge(columnGroupRel);
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
				columnGroupRelModelImpl.getUserPermissionGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((columnGroupRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					columnGroupRelModelImpl.getOriginalUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {
					columnGroupRelModelImpl.getUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ColumnGroupRelImpl.class,
			columnGroupRel.getPrimaryKey(), columnGroupRel, false);

		columnGroupRel.resetOriginalValues();

		return columnGroupRel;
	}

	/**
	 * Returns the column group rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the column group rel
	 * @return the column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	@Override
	public ColumnGroupRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchColumnGroupRelException {

		ColumnGroupRel columnGroupRel = fetchByPrimaryKey(primaryKey);

		if (columnGroupRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchColumnGroupRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return columnGroupRel;
	}

	/**
	 * Returns the column group rel with the primary key or throws a <code>NoSuchColumnGroupRelException</code> if it could not be found.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel
	 * @throws NoSuchColumnGroupRelException if a column group rel with the primary key could not be found
	 */
	@Override
	public ColumnGroupRel findByPrimaryKey(ColumnGroupRelPK columnGroupRelPK)
		throws NoSuchColumnGroupRelException {

		return findByPrimaryKey((Serializable)columnGroupRelPK);
	}

	/**
	 * Returns the column group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel, or <code>null</code> if a column group rel with the primary key could not be found
	 */
	@Override
	public ColumnGroupRel fetchByPrimaryKey(ColumnGroupRelPK columnGroupRelPK) {
		return fetchByPrimaryKey((Serializable)columnGroupRelPK);
	}

	/**
	 * Returns all the column group rels.
	 *
	 * @return the column group rels
	 */
	@Override
	public List<ColumnGroupRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of column group rels
	 */
	@Override
	public List<ColumnGroupRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of column group rels
	 */
	@Override
	public List<ColumnGroupRel> findAll(
		int start, int end,
		OrderByComparator<ColumnGroupRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of column group rels
	 */
	@Override
	public List<ColumnGroupRel> findAll(
		int start, int end, OrderByComparator<ColumnGroupRel> orderByComparator,
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

		List<ColumnGroupRel> list = null;

		if (useFinderCache) {
			list = (List<ColumnGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COLUMNGROUPREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COLUMNGROUPREL;

				sql = sql.concat(ColumnGroupRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<ColumnGroupRel>)QueryUtil.list(
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
	 * Removes all the column group rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ColumnGroupRel columnGroupRel : findAll()) {
			remove(columnGroupRel);
		}
	}

	/**
	 * Returns the number of column group rels.
	 *
	 * @return the number of column group rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COLUMNGROUPREL);

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
		return "columnGroupRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COLUMNGROUPREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ColumnGroupRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the column group rel persistence.
	 */
	@Activate
	public void activate() {
		ColumnGroupRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ColumnGroupRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ColumnGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ColumnGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ColumnGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ColumnGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			ColumnGroupRelModelImpl.USERPERMISSIONGROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ColumnGroupRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.lichcongtac.services.model.ColumnGroupRel"),
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

	private static final String _SQL_SELECT_COLUMNGROUPREL =
		"SELECT columnGroupRel FROM ColumnGroupRel columnGroupRel";

	private static final String _SQL_SELECT_COLUMNGROUPREL_WHERE =
		"SELECT columnGroupRel FROM ColumnGroupRel columnGroupRel WHERE ";

	private static final String _SQL_COUNT_COLUMNGROUPREL =
		"SELECT COUNT(columnGroupRel) FROM ColumnGroupRel columnGroupRel";

	private static final String _SQL_COUNT_COLUMNGROUPREL_WHERE =
		"SELECT COUNT(columnGroupRel) FROM ColumnGroupRel columnGroupRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "columnGroupRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ColumnGroupRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ColumnGroupRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ColumnGroupRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userPermissionGroupId", "columnId"});

	static {
		try {
			Class.forName(ecoit_lichPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}