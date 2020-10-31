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

package com.ecoit.mr.service.persistence.impl;

import com.ecoit.mr.exception.NoSuchUserPermissionGroupException;
import com.ecoit.mr.model.UserPermissionGroup;
import com.ecoit.mr.model.impl.UserPermissionGroupImpl;
import com.ecoit.mr.model.impl.UserPermissionGroupModelImpl;
import com.ecoit.mr.service.persistence.UserPermissionGroupPersistence;
import com.ecoit.mr.service.persistence.impl.constants.ecoit_mrPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the user permission group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserPermissionGroupPersistence.class)
public class UserPermissionGroupPersistenceImpl
	extends BasePersistenceImpl<UserPermissionGroup>
	implements UserPermissionGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserPermissionGroupUtil</code> to access the user permission group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserPermissionGroupImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UserPermissionGroupPersistenceImpl() {
		setModelClass(UserPermissionGroup.class);

		setModelImplClass(UserPermissionGroupImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user permission group in the entity cache if it is enabled.
	 *
	 * @param userPermissionGroup the user permission group
	 */
	@Override
	public void cacheResult(UserPermissionGroup userPermissionGroup) {
		entityCache.putResult(
			entityCacheEnabled, UserPermissionGroupImpl.class,
			userPermissionGroup.getPrimaryKey(), userPermissionGroup);

		userPermissionGroup.resetOriginalValues();
	}

	/**
	 * Caches the user permission groups in the entity cache if it is enabled.
	 *
	 * @param userPermissionGroups the user permission groups
	 */
	@Override
	public void cacheResult(List<UserPermissionGroup> userPermissionGroups) {
		for (UserPermissionGroup userPermissionGroup : userPermissionGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, UserPermissionGroupImpl.class,
					userPermissionGroup.getPrimaryKey()) == null) {

				cacheResult(userPermissionGroup);
			}
			else {
				userPermissionGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user permission groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserPermissionGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user permission group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserPermissionGroup userPermissionGroup) {
		entityCache.removeResult(
			entityCacheEnabled, UserPermissionGroupImpl.class,
			userPermissionGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserPermissionGroup> userPermissionGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserPermissionGroup userPermissionGroup : userPermissionGroups) {
			entityCache.removeResult(
				entityCacheEnabled, UserPermissionGroupImpl.class,
				userPermissionGroup.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, UserPermissionGroupImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user permission group with the primary key. Does not add the user permission group to the database.
	 *
	 * @param userPermissionGroupId the primary key for the new user permission group
	 * @return the new user permission group
	 */
	@Override
	public UserPermissionGroup create(long userPermissionGroupId) {
		UserPermissionGroup userPermissionGroup = new UserPermissionGroupImpl();

		userPermissionGroup.setNew(true);
		userPermissionGroup.setPrimaryKey(userPermissionGroupId);

		userPermissionGroup.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userPermissionGroup;
	}

	/**
	 * Removes the user permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group that was removed
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	@Override
	public UserPermissionGroup remove(long userPermissionGroupId)
		throws NoSuchUserPermissionGroupException {

		return remove((Serializable)userPermissionGroupId);
	}

	/**
	 * Removes the user permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user permission group
	 * @return the user permission group that was removed
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	@Override
	public UserPermissionGroup remove(Serializable primaryKey)
		throws NoSuchUserPermissionGroupException {

		Session session = null;

		try {
			session = openSession();

			UserPermissionGroup userPermissionGroup =
				(UserPermissionGroup)session.get(
					UserPermissionGroupImpl.class, primaryKey);

			if (userPermissionGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserPermissionGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userPermissionGroup);
		}
		catch (NoSuchUserPermissionGroupException noSuchEntityException) {
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
	protected UserPermissionGroup removeImpl(
		UserPermissionGroup userPermissionGroup) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userPermissionGroup)) {
				userPermissionGroup = (UserPermissionGroup)session.get(
					UserPermissionGroupImpl.class,
					userPermissionGroup.getPrimaryKeyObj());
			}

			if (userPermissionGroup != null) {
				session.delete(userPermissionGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userPermissionGroup != null) {
			clearCache(userPermissionGroup);
		}

		return userPermissionGroup;
	}

	@Override
	public UserPermissionGroup updateImpl(
		UserPermissionGroup userPermissionGroup) {

		boolean isNew = userPermissionGroup.isNew();

		if (!(userPermissionGroup instanceof UserPermissionGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userPermissionGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userPermissionGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userPermissionGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserPermissionGroup implementation " +
					userPermissionGroup.getClass());
		}

		UserPermissionGroupModelImpl userPermissionGroupModelImpl =
			(UserPermissionGroupModelImpl)userPermissionGroup;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userPermissionGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				userPermissionGroup.setCreateDate(now);
			}
			else {
				userPermissionGroup.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!userPermissionGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userPermissionGroup.setModifiedDate(now);
			}
			else {
				userPermissionGroup.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userPermissionGroup.isNew()) {
				session.save(userPermissionGroup);

				userPermissionGroup.setNew(false);
			}
			else {
				userPermissionGroup = (UserPermissionGroup)session.merge(
					userPermissionGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, UserPermissionGroupImpl.class,
			userPermissionGroup.getPrimaryKey(), userPermissionGroup, false);

		userPermissionGroup.resetOriginalValues();

		return userPermissionGroup;
	}

	/**
	 * Returns the user permission group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user permission group
	 * @return the user permission group
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	@Override
	public UserPermissionGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserPermissionGroupException {

		UserPermissionGroup userPermissionGroup = fetchByPrimaryKey(primaryKey);

		if (userPermissionGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserPermissionGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userPermissionGroup;
	}

	/**
	 * Returns the user permission group with the primary key or throws a <code>NoSuchUserPermissionGroupException</code> if it could not be found.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group
	 * @throws NoSuchUserPermissionGroupException if a user permission group with the primary key could not be found
	 */
	@Override
	public UserPermissionGroup findByPrimaryKey(long userPermissionGroupId)
		throws NoSuchUserPermissionGroupException {

		return findByPrimaryKey((Serializable)userPermissionGroupId);
	}

	/**
	 * Returns the user permission group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group, or <code>null</code> if a user permission group with the primary key could not be found
	 */
	@Override
	public UserPermissionGroup fetchByPrimaryKey(long userPermissionGroupId) {
		return fetchByPrimaryKey((Serializable)userPermissionGroupId);
	}

	/**
	 * Returns all the user permission groups.
	 *
	 * @return the user permission groups
	 */
	@Override
	public List<UserPermissionGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @return the range of user permission groups
	 */
	@Override
	public List<UserPermissionGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user permission groups
	 */
	@Override
	public List<UserPermissionGroup> findAll(
		int start, int end,
		OrderByComparator<UserPermissionGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user permission groups
	 */
	@Override
	public List<UserPermissionGroup> findAll(
		int start, int end,
		OrderByComparator<UserPermissionGroup> orderByComparator,
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

		List<UserPermissionGroup> list = null;

		if (useFinderCache) {
			list = (List<UserPermissionGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPERMISSIONGROUP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPERMISSIONGROUP;

				sql = sql.concat(UserPermissionGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<UserPermissionGroup>)QueryUtil.list(
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
	 * Removes all the user permission groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserPermissionGroup userPermissionGroup : findAll()) {
			remove(userPermissionGroup);
		}
	}

	/**
	 * Returns the number of user permission groups.
	 *
	 * @return the number of user permission groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPERMISSIONGROUP);

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
		return "userPermissionGroupId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERPERMISSIONGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserPermissionGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user permission group persistence.
	 */
	@Activate
	public void activate() {
		UserPermissionGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserPermissionGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPermissionGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPermissionGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserPermissionGroupImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_mrPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.mr.model.UserPermissionGroup"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_mrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_mrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERPERMISSIONGROUP =
		"SELECT userPermissionGroup FROM UserPermissionGroup userPermissionGroup";

	private static final String _SQL_COUNT_USERPERMISSIONGROUP =
		"SELECT COUNT(userPermissionGroup) FROM UserPermissionGroup userPermissionGroup";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userPermissionGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserPermissionGroup exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UserPermissionGroupPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_mrPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}