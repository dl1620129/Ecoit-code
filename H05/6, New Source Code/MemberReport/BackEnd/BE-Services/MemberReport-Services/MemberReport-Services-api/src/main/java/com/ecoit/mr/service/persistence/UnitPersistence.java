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

import com.ecoit.mr.exception.NoSuchUnitException;
import com.ecoit.mr.model.Unit;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UnitUtil
 * @generated
 */
@ProviderType
public interface UnitPersistence extends BasePersistence<Unit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UnitUtil} to access the unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the unit in the entity cache if it is enabled.
	 *
	 * @param unit the unit
	 */
	public void cacheResult(Unit unit);

	/**
	 * Caches the units in the entity cache if it is enabled.
	 *
	 * @param units the units
	 */
	public void cacheResult(java.util.List<Unit> units);

	/**
	 * Creates a new unit with the primary key. Does not add the unit to the database.
	 *
	 * @param unitId the primary key for the new unit
	 * @return the new unit
	 */
	public Unit create(long unitId);

	/**
	 * Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit that was removed
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	public Unit remove(long unitId) throws NoSuchUnitException;

	public Unit updateImpl(Unit unit);

	/**
	 * Returns the unit with the primary key or throws a <code>NoSuchUnitException</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit
	 * @throws NoSuchUnitException if a unit with the primary key could not be found
	 */
	public Unit findByPrimaryKey(long unitId) throws NoSuchUnitException;

	/**
	 * Returns the unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit, or <code>null</code> if a unit with the primary key could not be found
	 */
	public Unit fetchByPrimaryKey(long unitId);

	/**
	 * Returns all the units.
	 *
	 * @return the units
	 */
	public java.util.List<Unit> findAll();

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
	public java.util.List<Unit> findAll(int start, int end);

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
	public java.util.List<Unit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Unit>
			orderByComparator);

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
	public java.util.List<Unit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Unit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the units from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of units.
	 *
	 * @return the number of units
	 */
	public int countAll();

}