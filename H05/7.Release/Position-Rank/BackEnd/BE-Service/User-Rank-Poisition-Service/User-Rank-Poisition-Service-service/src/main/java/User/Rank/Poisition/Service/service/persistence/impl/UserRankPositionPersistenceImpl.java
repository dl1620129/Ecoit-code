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

package User.Rank.Poisition.Service.service.persistence.impl;

import User.Rank.Poisition.Service.exception.NoSuchUserRankPositionException;
import User.Rank.Poisition.Service.model.UserRankPosition;
import User.Rank.Poisition.Service.model.impl.UserRankPositionImpl;
import User.Rank.Poisition.Service.model.impl.UserRankPositionModelImpl;
import User.Rank.Poisition.Service.service.persistence.UserRankPositionPersistence;
import User.Rank.Poisition.Service.service.persistence.impl.constants.portal_userPersistenceConstants;

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

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user rank position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRankPositionPersistence.class)
@ProviderType
public class UserRankPositionPersistenceImpl
	extends BasePersistenceImpl<UserRankPosition>
	implements UserRankPositionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRankPositionUtil</code> to access the user rank position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRankPositionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByUser;
	private FinderPath _finderPathCountByUser;

	/**
	 * Returns the user rank position where userId = &#63; or throws a <code>NoSuchUserRankPositionException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user rank position
	 * @throws NoSuchUserRankPositionException if a matching user rank position could not be found
	 */
	@Override
	public UserRankPosition findByUser(long userId)
		throws NoSuchUserRankPositionException {

		UserRankPosition userRankPosition = fetchByUser(userId);

		if (userRankPosition == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserRankPositionException(msg.toString());
		}

		return userRankPosition;
	}

	/**
	 * Returns the user rank position where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUser(long)}
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank position, or <code>null</code> if a matching user rank position could not be found
	 */
	@Deprecated
	@Override
	public UserRankPosition fetchByUser(long userId, boolean useFinderCache) {
		return fetchByUser(userId);
	}

	/**
	 * Returns the user rank position where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank position, or <code>null</code> if a matching user rank position could not be found
	 */
	@Override
	public UserRankPosition fetchByUser(long userId) {
		Object[] finderArgs = new Object[] {userId};

		Object result = finderCache.getResult(
			_finderPathFetchByUser, finderArgs, this);

		if (result instanceof UserRankPosition) {
			UserRankPosition userRankPosition = (UserRankPosition)result;

			if ((userId != userRankPosition.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERRANKPOSITION_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<UserRankPosition> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUser, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserRankPositionPersistenceImpl.fetchByUser(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserRankPosition userRankPosition = list.get(0);

					result = userRankPosition;

					cacheResult(userRankPosition);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUser, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserRankPosition)result;
		}
	}

	/**
	 * Removes the user rank position where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the user rank position that was removed
	 */
	@Override
	public UserRankPosition removeByUser(long userId)
		throws NoSuchUserRankPositionException {

		UserRankPosition userRankPosition = findByUser(userId);

		return remove(userRankPosition);
	}

	/**
	 * Returns the number of user rank positions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user rank positions
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = _finderPathCountByUser;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERRANKPOSITION_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_USERID_2 =
		"userRankPosition.userId = ?";

	public UserRankPositionPersistenceImpl() {
		setModelClass(UserRankPosition.class);

		setModelImplClass(UserRankPositionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user rank position in the entity cache if it is enabled.
	 *
	 * @param userRankPosition the user rank position
	 */
	@Override
	public void cacheResult(UserRankPosition userRankPosition) {
		entityCache.putResult(
			entityCacheEnabled, UserRankPositionImpl.class,
			userRankPosition.getPrimaryKey(), userRankPosition);

		finderCache.putResult(
			_finderPathFetchByUser, new Object[] {userRankPosition.getUserId()},
			userRankPosition);

		userRankPosition.resetOriginalValues();
	}

	/**
	 * Caches the user rank positions in the entity cache if it is enabled.
	 *
	 * @param userRankPositions the user rank positions
	 */
	@Override
	public void cacheResult(List<UserRankPosition> userRankPositions) {
		for (UserRankPosition userRankPosition : userRankPositions) {
			if (entityCache.getResult(
					entityCacheEnabled, UserRankPositionImpl.class,
					userRankPosition.getPrimaryKey()) == null) {

				cacheResult(userRankPosition);
			}
			else {
				userRankPosition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user rank positions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRankPositionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user rank position.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserRankPosition userRankPosition) {
		entityCache.removeResult(
			entityCacheEnabled, UserRankPositionImpl.class,
			userRankPosition.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(UserRankPositionModelImpl)userRankPosition, true);
	}

	@Override
	public void clearCache(List<UserRankPosition> userRankPositions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserRankPosition userRankPosition : userRankPositions) {
			entityCache.removeResult(
				entityCacheEnabled, UserRankPositionImpl.class,
				userRankPosition.getPrimaryKey());

			clearUniqueFindersCache(
				(UserRankPositionModelImpl)userRankPosition, true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserRankPositionModelImpl userRankPositionModelImpl) {

		Object[] args = new Object[] {userRankPositionModelImpl.getUserId()};

		finderCache.putResult(
			_finderPathCountByUser, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUser, args, userRankPositionModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserRankPositionModelImpl userRankPositionModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				userRankPositionModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(_finderPathFetchByUser, args);
		}

		if ((userRankPositionModelImpl.getColumnBitmask() &
			 _finderPathFetchByUser.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				userRankPositionModelImpl.getOriginalUserId()
			};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(_finderPathFetchByUser, args);
		}
	}

	/**
	 * Creates a new user rank position with the primary key. Does not add the user rank position to the database.
	 *
	 * @param userId the primary key for the new user rank position
	 * @return the new user rank position
	 */
	@Override
	public UserRankPosition create(long userId) {
		UserRankPosition userRankPosition = new UserRankPositionImpl();

		userRankPosition.setNew(true);
		userRankPosition.setPrimaryKey(userId);

		return userRankPosition;
	}

	/**
	 * Removes the user rank position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position that was removed
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	@Override
	public UserRankPosition remove(long userId)
		throws NoSuchUserRankPositionException {

		return remove((Serializable)userId);
	}

	/**
	 * Removes the user rank position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user rank position
	 * @return the user rank position that was removed
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	@Override
	public UserRankPosition remove(Serializable primaryKey)
		throws NoSuchUserRankPositionException {

		Session session = null;

		try {
			session = openSession();

			UserRankPosition userRankPosition = (UserRankPosition)session.get(
				UserRankPositionImpl.class, primaryKey);

			if (userRankPosition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRankPositionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRankPosition);
		}
		catch (NoSuchUserRankPositionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserRankPosition removeImpl(UserRankPosition userRankPosition) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRankPosition)) {
				userRankPosition = (UserRankPosition)session.get(
					UserRankPositionImpl.class,
					userRankPosition.getPrimaryKeyObj());
			}

			if (userRankPosition != null) {
				session.delete(userRankPosition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userRankPosition != null) {
			clearCache(userRankPosition);
		}

		return userRankPosition;
	}

	@Override
	public UserRankPosition updateImpl(UserRankPosition userRankPosition) {
		boolean isNew = userRankPosition.isNew();

		if (!(userRankPosition instanceof UserRankPositionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userRankPosition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userRankPosition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userRankPosition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserRankPosition implementation " +
					userRankPosition.getClass());
		}

		UserRankPositionModelImpl userRankPositionModelImpl =
			(UserRankPositionModelImpl)userRankPosition;

		Session session = null;

		try {
			session = openSession();

			if (userRankPosition.isNew()) {
				session.save(userRankPosition);

				userRankPosition.setNew(false);
			}
			else {
				userRankPosition = (UserRankPosition)session.merge(
					userRankPosition);
			}
		}
		catch (Exception e) {
			throw processException(e);
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
			entityCacheEnabled, UserRankPositionImpl.class,
			userRankPosition.getPrimaryKey(), userRankPosition, false);

		clearUniqueFindersCache(userRankPositionModelImpl, false);
		cacheUniqueFindersCache(userRankPositionModelImpl);

		userRankPosition.resetOriginalValues();

		return userRankPosition;
	}

	/**
	 * Returns the user rank position with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user rank position
	 * @return the user rank position
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	@Override
	public UserRankPosition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRankPositionException {

		UserRankPosition userRankPosition = fetchByPrimaryKey(primaryKey);

		if (userRankPosition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRankPositionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRankPosition;
	}

	/**
	 * Returns the user rank position with the primary key or throws a <code>NoSuchUserRankPositionException</code> if it could not be found.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position
	 * @throws NoSuchUserRankPositionException if a user rank position with the primary key could not be found
	 */
	@Override
	public UserRankPosition findByPrimaryKey(long userId)
		throws NoSuchUserRankPositionException {

		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the user rank position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user rank position
	 * @return the user rank position, or <code>null</code> if a user rank position with the primary key could not be found
	 */
	@Override
	public UserRankPosition fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the user rank positions.
	 *
	 * @return the user rank positions
	 */
	@Override
	public List<UserRankPosition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @return the range of user rank positions
	 */
	@Override
	public List<UserRankPosition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user rank positions
	 */
	@Deprecated
	@Override
	public List<UserRankPosition> findAll(
		int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user rank positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankPositionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user rank positions
	 * @param end the upper bound of the range of user rank positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user rank positions
	 */
	@Override
	public List<UserRankPosition> findAll(
		int start, int end,
		OrderByComparator<UserRankPosition> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserRankPosition> list =
			(List<UserRankPosition>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERRANKPOSITION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERRANKPOSITION;

				if (pagination) {
					sql = sql.concat(UserRankPositionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserRankPosition>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserRankPosition>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user rank positions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRankPosition userRankPosition : findAll()) {
			remove(userRankPosition);
		}
	}

	/**
	 * Returns the number of user rank positions.
	 *
	 * @return the number of user rank positions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERRANKPOSITION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
		return "userId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERRANKPOSITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRankPositionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user rank position persistence.
	 */
	@Activate
	public void activate() {
		UserRankPositionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserRankPositionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserRankPositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserRankPositionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserRankPositionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUser",
			new String[] {Long.class.getName()},
			UserRankPositionModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserRankPositionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = portal_userPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.User.Rank.Poisition.Service.model.UserRankPosition"),
			true);
	}

	@Override
	@Reference(
		target = portal_userPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = portal_userPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERRANKPOSITION =
		"SELECT userRankPosition FROM UserRankPosition userRankPosition";

	private static final String _SQL_SELECT_USERRANKPOSITION_WHERE =
		"SELECT userRankPosition FROM UserRankPosition userRankPosition WHERE ";

	private static final String _SQL_COUNT_USERRANKPOSITION =
		"SELECT COUNT(userRankPosition) FROM UserRankPosition userRankPosition";

	private static final String _SQL_COUNT_USERRANKPOSITION_WHERE =
		"SELECT COUNT(userRankPosition) FROM UserRankPosition userRankPosition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userRankPosition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRankPosition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserRankPosition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRankPositionPersistenceImpl.class);

	static {
		try {
			Class.forName(portal_userPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}