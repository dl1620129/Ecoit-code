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

import com.ecoit.mr.exception.NoSuchUnitException;
import com.ecoit.mr.model.Unit;
import com.ecoit.mr.model.impl.UnitImpl;
import com.ecoit.mr.model.impl.UnitModelImpl;
import com.ecoit.mr.service.persistence.UnitPersistence;
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
 * The persistence implementation for the unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UnitPersistence.class)
public class UnitPersistenceImpl
	extends BasePersistenceImpl<Unit> implements UnitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UnitUtil</code> to access the unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UnitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UnitPersistenceImpl() {
		setModelClass(Unit.class);

		setModelImplClass(UnitImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the unit in the entity cache if it is enabled.
	 *
	 * @param unit the unit
	 */
	@Override
	public void cacheResult(Unit unit) {
		entityCache.putResult(
			entityCacheEnabled, UnitImpl.class, unit.getPrimaryKey(), unit);

		unit.resetOriginalValues();
	}

	/**
	 * Caches the units in the entity cache if it is enabled.
	 *
	 * @param units the units
	 */
	@Override
	public void cacheResult(List<Unit> units) {
		for (Unit unit : units) {
			if (entityCache.getResult(
					entityCacheEnabled, UnitImpl.class, unit.getPrimaryKey()) ==
						null) {

				cacheResult(unit);
			}
			else {
				unit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all units.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UnitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Unit unit) {
		entityCache.removeResult(
			entityCacheEnabled, UnitImpl.class, unit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Unit> units) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Unit unit : units) {
			entityCache.removeResult(
				entityCacheEnabled, UnitImpl.class, unit.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, UnitImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new unit with the primary key. Does not add the unit to the database.
	 *
	 * @param unitId the primary key for the new unit
	 * @return the new unit
	 */
	@Override
	public Unit create(long unitId) {
		Unit unit = new UnitImpl();

		unit.setNew(true);
		unit.setPrimaryKey(unitId);

		unit.setCompanyId(CompanyThreadLocal.getCompanyId());

		return unit;
	}

	/**
	 * Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit that was removed
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	@Override
	public Unit remove(long unitId) throws NoSuchUnitException {
		return remove((Serializable)unitId);
	}

	/**
	 * Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unit
	 * @return the unit that was removed
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	@Override
	public Unit remove(Serializable primaryKey) throws NoSuchUnitException {
		Session session = null;

		try {
			session = openSession();

			Unit unit = (Unit)session.get(UnitImpl.class, primaryKey);

			if (unit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUnitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(unit);
		}
		catch (NoSuchUnitException noSuchEntityException) {
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
	protected Unit removeImpl(Unit unit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(unit)) {
				unit = (Unit)session.get(
					UnitImpl.class, unit.getPrimaryKeyObj());
			}

			if (unit != null) {
				session.delete(unit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (unit != null) {
			clearCache(unit);
		}

		return unit;
	}

	@Override
	public Unit updateImpl(Unit unit) {
		boolean isNew = unit.isNew();

		if (!(unit instanceof UnitModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(unit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(unit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in unit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Unit implementation " +
					unit.getClass());
		}

		UnitModelImpl unitModelImpl = (UnitModelImpl)unit;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (unit.getCreateDate() == null)) {
			if (serviceContext == null) {
				unit.setCreateDate(now);
			}
			else {
				unit.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!unitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				unit.setModifiedDate(now);
			}
			else {
				unit.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (unit.isNew()) {
				session.save(unit);

				unit.setNew(false);
			}
			else {
				unit = (Unit)session.merge(unit);
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
			entityCacheEnabled, UnitImpl.class, unit.getPrimaryKey(), unit,
			false);

		unit.resetOriginalValues();

		return unit;
	}

	/**
	 * Returns the unit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit
	 * @return the unit
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	@Override
	public Unit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUnitException {

		Unit unit = fetchByPrimaryKey(primaryKey);

		if (unit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUnitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return unit;
	}

	/**
	 * Returns the unit with the primary key or throws a <code>NoSuchUnitException</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	@Override
	public Unit findByPrimaryKey(long unitId) throws NoSuchUnitException {
		return findByPrimaryKey((Serializable)unitId);
	}

	/**
	 * Returns the unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit, or <code>null</code> if a unit with the primary key could not be found
	 */
	@Override
	public Unit fetchByPrimaryKey(long unitId) {
		return fetchByPrimaryKey((Serializable)unitId);
	}

	/**
	 * Returns all the units.
	 *
	 * @return the units
	 */
	@Override
	public List<Unit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @return the range of units
	 */
	@Override
	public List<Unit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of units
	 */
	@Override
	public List<Unit> findAll(
		int start, int end, OrderByComparator<Unit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UnitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of units
	 */
	@Override
	public List<Unit> findAll(
		int start, int end, OrderByComparator<Unit> orderByComparator,
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

		List<Unit> list = null;

		if (useFinderCache) {
			list = (List<Unit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_UNIT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNIT;

				sql = sql.concat(UnitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Unit>)QueryUtil.list(q, getDialect(), start, end);

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
	 * Removes all the units from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Unit unit : findAll()) {
			remove(unit);
		}
	}

	/**
	 * Returns the number of units.
	 *
	 * @return the number of units
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UNIT);

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
		return "unitId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_UNIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UnitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the unit persistence.
	 */
	@Activate
	public void activate() {
		UnitModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UnitModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UnitImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.mr.model.Unit"),
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

	private static final String _SQL_SELECT_UNIT = "SELECT unit FROM Unit unit";

	private static final String _SQL_COUNT_UNIT =
		"SELECT COUNT(unit) FROM Unit unit";

	private static final String _ORDER_BY_ENTITY_ALIAS = "unit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Unit exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UnitPersistenceImpl.class);

	static {
		try {
			Class.forName(ecoit_mrPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}