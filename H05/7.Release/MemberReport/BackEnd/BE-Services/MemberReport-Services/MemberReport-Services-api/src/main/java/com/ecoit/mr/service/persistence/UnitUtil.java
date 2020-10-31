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

package com.ecoit.mr.service.persistence;

import com.ecoit.mr.model.Unit;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the unit service. This utility wraps <code>com.ecoit.mr.service.persistence.impl.UnitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UnitPersistence
 * @generated
 */
public class UnitUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Unit unit) {
		getPersistence().clearCache(unit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Unit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Unit> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Unit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Unit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Unit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Unit update(Unit unit) {
		return getPersistence().update(unit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Unit update(Unit unit, ServiceContext serviceContext) {
		return getPersistence().update(unit, serviceContext);
	}

	/**
	 * Caches the unit in the entity cache if it is enabled.
	 *
	 * @param unit the unit
	 */
	public static void cacheResult(Unit unit) {
		getPersistence().cacheResult(unit);
	}

	/**
	 * Caches the units in the entity cache if it is enabled.
	 *
	 * @param units the units
	 */
	public static void cacheResult(List<Unit> units) {
		getPersistence().cacheResult(units);
	}

	/**
	 * Creates a new unit with the primary key. Does not add the unit to the database.
	 *
	 * @param unitId the primary key for the new unit
	 * @return the new unit
	 */
	public static Unit create(long unitId) {
		return getPersistence().create(unitId);
	}

	/**
	 * Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit that was removed
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	public static Unit remove(long unitId)
		throws com.ecoit.mr.exception.NoSuchUnitException {

		return getPersistence().remove(unitId);
	}

	public static Unit updateImpl(Unit unit) {
		return getPersistence().updateImpl(unit);
	}

	/**
	 * Returns the unit with the primary key or throws a <code>NoSuchUnitException</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	public static Unit findByPrimaryKey(long unitId)
		throws com.ecoit.mr.exception.NoSuchUnitException {

		return getPersistence().findByPrimaryKey(unitId);
	}

	/**
	 * Returns the unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit, or <code>null</code> if a unit with the primary key could not be found
	 */
	public static Unit fetchByPrimaryKey(long unitId) {
		return getPersistence().fetchByPrimaryKey(unitId);
	}

	/**
	 * Returns all the units.
	 *
	 * @return the units
	 */
	public static List<Unit> findAll() {
		return getPersistence().findAll();
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
	public static List<Unit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Unit> findAll(
		int start, int end, OrderByComparator<Unit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Unit> findAll(
		int start, int end, OrderByComparator<Unit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the units from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of units.
	 *
	 * @return the number of units
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UnitPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UnitPersistence, UnitPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UnitPersistence.class);

		ServiceTracker<UnitPersistence, UnitPersistence> serviceTracker =
			new ServiceTracker<UnitPersistence, UnitPersistence>(
				bundle.getBundleContext(), UnitPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}