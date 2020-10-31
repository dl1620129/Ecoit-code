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

import com.ecoit.elegaldocument.exception.NoSuchEcmsGroupException;
import com.ecoit.elegaldocument.model.EcmsGroup;
import com.ecoit.elegaldocument.model.impl.EcmsGroupImpl;
import com.ecoit.elegaldocument.model.impl.EcmsGroupModelImpl;
import com.ecoit.elegaldocument.service.persistence.EcmsGroupPersistence;
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
 * The persistence implementation for the ecms group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = EcmsGroupPersistence.class)
public class EcmsGroupPersistenceImpl
	extends BasePersistenceImpl<EcmsGroup> implements EcmsGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EcmsGroupUtil</code> to access the ecms group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EcmsGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBygroupUserId;
	private FinderPath _finderPathCountBygroupUserId;

	/**
	 * Returns the ecms group where groupUserId = &#63; or throws a <code>NoSuchEcmsGroupException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms group
	 * @throws NoSuchEcmsGroupException if a matching ecms group could not be found
	 */
	@Override
	public EcmsGroup findBygroupUserId(long groupUserId)
		throws NoSuchEcmsGroupException {

		EcmsGroup ecmsGroup = fetchBygroupUserId(groupUserId);

		if (ecmsGroup == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupUserId=");
			msg.append(groupUserId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEcmsGroupException(msg.toString());
		}

		return ecmsGroup;
	}

	/**
	 * Returns the ecms group where groupUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms group, or <code>null</code> if a matching ecms group could not be found
	 */
	@Override
	public EcmsGroup fetchBygroupUserId(long groupUserId) {
		return fetchBygroupUserId(groupUserId, true);
	}

	/**
	 * Returns the ecms group where groupUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms group, or <code>null</code> if a matching ecms group could not be found
	 */
	@Override
	public EcmsGroup fetchBygroupUserId(
		long groupUserId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupUserId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygroupUserId, finderArgs, this);
		}

		if (result instanceof EcmsGroup) {
			EcmsGroup ecmsGroup = (EcmsGroup)result;

			if (groupUserId != ecmsGroup.getGroupUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ECMSGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				List<EcmsGroup> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBygroupUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupUserId};
							}

							_log.warn(
								"EcmsGroupPersistenceImpl.fetchBygroupUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EcmsGroup ecmsGroup = list.get(0);

					result = ecmsGroup;

					cacheResult(ecmsGroup);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBygroupUserId, finderArgs);
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
			return (EcmsGroup)result;
		}
	}

	/**
	 * Removes the ecms group where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @return the ecms group that was removed
	 */
	@Override
	public EcmsGroup removeBygroupUserId(long groupUserId)
		throws NoSuchEcmsGroupException {

		EcmsGroup ecmsGroup = findBygroupUserId(groupUserId);

		return remove(ecmsGroup);
	}

	/**
	 * Returns the number of ecms groups where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms groups
	 */
	@Override
	public int countBygroupUserId(long groupUserId) {
		FinderPath finderPath = _finderPathCountBygroupUserId;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ECMSGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

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

	private static final String _FINDER_COLUMN_GROUPUSERID_GROUPUSERID_2 =
		"ecmsGroup.groupUserId = ?";

	public EcmsGroupPersistenceImpl() {
		setModelClass(EcmsGroup.class);

		setModelImplClass(EcmsGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ecms group in the entity cache if it is enabled.
	 *
	 * @param ecmsGroup the ecms group
	 */
	@Override
	public void cacheResult(EcmsGroup ecmsGroup) {
		entityCache.putResult(
			entityCacheEnabled, EcmsGroupImpl.class, ecmsGroup.getPrimaryKey(),
			ecmsGroup);

		finderCache.putResult(
			_finderPathFetchBygroupUserId,
			new Object[] {ecmsGroup.getGroupUserId()}, ecmsGroup);

		ecmsGroup.resetOriginalValues();
	}

	/**
	 * Caches the ecms groups in the entity cache if it is enabled.
	 *
	 * @param ecmsGroups the ecms groups
	 */
	@Override
	public void cacheResult(List<EcmsGroup> ecmsGroups) {
		for (EcmsGroup ecmsGroup : ecmsGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, EcmsGroupImpl.class,
					ecmsGroup.getPrimaryKey()) == null) {

				cacheResult(ecmsGroup);
			}
			else {
				ecmsGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ecms groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EcmsGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ecms group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EcmsGroup ecmsGroup) {
		entityCache.removeResult(
			entityCacheEnabled, EcmsGroupImpl.class, ecmsGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EcmsGroupModelImpl)ecmsGroup, true);
	}

	@Override
	public void clearCache(List<EcmsGroup> ecmsGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EcmsGroup ecmsGroup : ecmsGroups) {
			entityCache.removeResult(
				entityCacheEnabled, EcmsGroupImpl.class,
				ecmsGroup.getPrimaryKey());

			clearUniqueFindersCache((EcmsGroupModelImpl)ecmsGroup, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, EcmsGroupImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EcmsGroupModelImpl ecmsGroupModelImpl) {

		Object[] args = new Object[] {ecmsGroupModelImpl.getGroupUserId()};

		finderCache.putResult(
			_finderPathCountBygroupUserId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBygroupUserId, args, ecmsGroupModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EcmsGroupModelImpl ecmsGroupModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {ecmsGroupModelImpl.getGroupUserId()};

			finderCache.removeResult(_finderPathCountBygroupUserId, args);
			finderCache.removeResult(_finderPathFetchBygroupUserId, args);
		}

		if ((ecmsGroupModelImpl.getColumnBitmask() &
			 _finderPathFetchBygroupUserId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ecmsGroupModelImpl.getOriginalGroupUserId()
			};

			finderCache.removeResult(_finderPathCountBygroupUserId, args);
			finderCache.removeResult(_finderPathFetchBygroupUserId, args);
		}
	}

	/**
	 * Creates a new ecms group with the primary key. Does not add the ecms group to the database.
	 *
	 * @param groupUserId the primary key for the new ecms group
	 * @return the new ecms group
	 */
	@Override
	public EcmsGroup create(long groupUserId) {
		EcmsGroup ecmsGroup = new EcmsGroupImpl();

		ecmsGroup.setNew(true);
		ecmsGroup.setPrimaryKey(groupUserId);

		return ecmsGroup;
	}

	/**
	 * Removes the ecms group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group that was removed
	 * @throws NoSuchEcmsGroupException if a ecms group with the primary key could not be found
	 */
	@Override
	public EcmsGroup remove(long groupUserId) throws NoSuchEcmsGroupException {
		return remove((Serializable)groupUserId);
	}

	/**
	 * Removes the ecms group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ecms group
	 * @return the ecms group that was removed
	 * @throws NoSuchEcmsGroupException if a ecms group with the primary key could not be found
	 */
	@Override
	public EcmsGroup remove(Serializable primaryKey)
		throws NoSuchEcmsGroupException {

		Session session = null;

		try {
			session = openSession();

			EcmsGroup ecmsGroup = (EcmsGroup)session.get(
				EcmsGroupImpl.class, primaryKey);

			if (ecmsGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEcmsGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ecmsGroup);
		}
		catch (NoSuchEcmsGroupException noSuchEntityException) {
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
	protected EcmsGroup removeImpl(EcmsGroup ecmsGroup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ecmsGroup)) {
				ecmsGroup = (EcmsGroup)session.get(
					EcmsGroupImpl.class, ecmsGroup.getPrimaryKeyObj());
			}

			if (ecmsGroup != null) {
				session.delete(ecmsGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ecmsGroup != null) {
			clearCache(ecmsGroup);
		}

		return ecmsGroup;
	}

	@Override
	public EcmsGroup updateImpl(EcmsGroup ecmsGroup) {
		boolean isNew = ecmsGroup.isNew();

		if (!(ecmsGroup instanceof EcmsGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ecmsGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ecmsGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ecmsGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EcmsGroup implementation " +
					ecmsGroup.getClass());
		}

		EcmsGroupModelImpl ecmsGroupModelImpl = (EcmsGroupModelImpl)ecmsGroup;

		Session session = null;

		try {
			session = openSession();

			if (ecmsGroup.isNew()) {
				session.save(ecmsGroup);

				ecmsGroup.setNew(false);
			}
			else {
				ecmsGroup = (EcmsGroup)session.merge(ecmsGroup);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, EcmsGroupImpl.class, ecmsGroup.getPrimaryKey(),
			ecmsGroup, false);

		clearUniqueFindersCache(ecmsGroupModelImpl, false);
		cacheUniqueFindersCache(ecmsGroupModelImpl);

		ecmsGroup.resetOriginalValues();

		return ecmsGroup;
	}

	/**
	 * Returns the ecms group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ecms group
	 * @return the ecms group
	 * @throws NoSuchEcmsGroupException if a ecms group with the primary key could not be found
	 */
	@Override
	public EcmsGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEcmsGroupException {

		EcmsGroup ecmsGroup = fetchByPrimaryKey(primaryKey);

		if (ecmsGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEcmsGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ecmsGroup;
	}

	/**
	 * Returns the ecms group with the primary key or throws a <code>NoSuchEcmsGroupException</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group
	 * @throws NoSuchEcmsGroupException if a ecms group with the primary key could not be found
	 */
	@Override
	public EcmsGroup findByPrimaryKey(long groupUserId)
		throws NoSuchEcmsGroupException {

		return findByPrimaryKey((Serializable)groupUserId);
	}

	/**
	 * Returns the ecms group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the ecms group
	 * @return the ecms group, or <code>null</code> if a ecms group with the primary key could not be found
	 */
	@Override
	public EcmsGroup fetchByPrimaryKey(long groupUserId) {
		return fetchByPrimaryKey((Serializable)groupUserId);
	}

	/**
	 * Returns all the ecms groups.
	 *
	 * @return the ecms groups
	 */
	@Override
	public List<EcmsGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @return the range of ecms groups
	 */
	@Override
	public List<EcmsGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ecms groups
	 */
	@Override
	public List<EcmsGroup> findAll(
		int start, int end, OrderByComparator<EcmsGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ecms groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms groups
	 * @param end the upper bound of the range of ecms groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ecms groups
	 */
	@Override
	public List<EcmsGroup> findAll(
		int start, int end, OrderByComparator<EcmsGroup> orderByComparator,
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

		List<EcmsGroup> list = null;

		if (useFinderCache) {
			list = (List<EcmsGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ECMSGROUP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ECMSGROUP;

				sql = sql.concat(EcmsGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<EcmsGroup>)QueryUtil.list(
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
	 * Removes all the ecms groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EcmsGroup ecmsGroup : findAll()) {
			remove(ecmsGroup);
		}
	}

	/**
	 * Returns the number of ecms groups.
	 *
	 * @return the number of ecms groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ECMSGROUP);

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
		return "groupUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ECMSGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EcmsGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ecms group persistence.
	 */
	@Activate
	public void activate() {
		EcmsGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		EcmsGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EcmsGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBygroupUserId",
			new String[] {Long.class.getName()},
			EcmsGroupModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountBygroupUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupUserId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EcmsGroupImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.EcmsGroup"),
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

	private static final String _SQL_SELECT_ECMSGROUP =
		"SELECT ecmsGroup FROM EcmsGroup ecmsGroup";

	private static final String _SQL_SELECT_ECMSGROUP_WHERE =
		"SELECT ecmsGroup FROM EcmsGroup ecmsGroup WHERE ";

	private static final String _SQL_COUNT_ECMSGROUP =
		"SELECT COUNT(ecmsGroup) FROM EcmsGroup ecmsGroup";

	private static final String _SQL_COUNT_ECMSGROUP_WHERE =
		"SELECT COUNT(ecmsGroup) FROM EcmsGroup ecmsGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ecmsGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EcmsGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EcmsGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EcmsGroupPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}