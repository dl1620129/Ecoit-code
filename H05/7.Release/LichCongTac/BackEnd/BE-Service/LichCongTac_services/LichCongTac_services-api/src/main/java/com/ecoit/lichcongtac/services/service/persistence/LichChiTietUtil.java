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

package com.ecoit.lichcongtac.services.service.persistence;

import com.ecoit.lichcongtac.services.model.LichChiTiet;

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
 * The persistence utility for the lich chi tiet service. This utility wraps <code>com.ecoit.lichcongtac.services.service.persistence.impl.LichChiTietPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietPersistence
 * @generated
 */
public class LichChiTietUtil {

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
	public static void clearCache(LichChiTiet lichChiTiet) {
		getPersistence().clearCache(lichChiTiet);
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
	public static Map<Serializable, LichChiTiet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LichChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LichChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LichChiTiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LichChiTiet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LichChiTiet update(LichChiTiet lichChiTiet) {
		return getPersistence().update(lichChiTiet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LichChiTiet update(
		LichChiTiet lichChiTiet, ServiceContext serviceContext) {

		return getPersistence().update(lichChiTiet, serviceContext);
	}

	/**
	 * Returns all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich chi tiets
	 */
	public static List<LichChiTiet> findByLichCongTacId(long lichCongTacId) {
		return getPersistence().findByLichCongTacId(lichCongTacId);
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
	public static List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end) {

		return getPersistence().findByLichCongTacId(lichCongTacId, start, end);
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
	public static List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end,
		OrderByComparator<LichChiTiet> orderByComparator) {

		return getPersistence().findByLichCongTacId(
			lichCongTacId, start, end, orderByComparator);
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
	public static List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end,
		OrderByComparator<LichChiTiet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLichCongTacId(
			lichCongTacId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich chi tiet
	 * @throws NoSuchLichChiTietException if a matching lich chi tiet could not be found
	 */
	public static LichChiTiet findByLichCongTacId_First(
			long lichCongTacId,
			OrderByComparator<LichChiTiet> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchLichChiTietException {

		return getPersistence().findByLichCongTacId_First(
			lichCongTacId, orderByComparator);
	}

	/**
	 * Returns the first lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich chi tiet, or <code>null</code> if a matching lich chi tiet could not be found
	 */
	public static LichChiTiet fetchByLichCongTacId_First(
		long lichCongTacId, OrderByComparator<LichChiTiet> orderByComparator) {

		return getPersistence().fetchByLichCongTacId_First(
			lichCongTacId, orderByComparator);
	}

	/**
	 * Returns the last lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich chi tiet
	 * @throws NoSuchLichChiTietException if a matching lich chi tiet could not be found
	 */
	public static LichChiTiet findByLichCongTacId_Last(
			long lichCongTacId,
			OrderByComparator<LichChiTiet> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchLichChiTietException {

		return getPersistence().findByLichCongTacId_Last(
			lichCongTacId, orderByComparator);
	}

	/**
	 * Returns the last lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich chi tiet, or <code>null</code> if a matching lich chi tiet could not be found
	 */
	public static LichChiTiet fetchByLichCongTacId_Last(
		long lichCongTacId, OrderByComparator<LichChiTiet> orderByComparator) {

		return getPersistence().fetchByLichCongTacId_Last(
			lichCongTacId, orderByComparator);
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
	public static LichChiTiet[] findByLichCongTacId_PrevAndNext(
			long lichChiTietId, long lichCongTacId,
			OrderByComparator<LichChiTiet> orderByComparator)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchLichChiTietException {

		return getPersistence().findByLichCongTacId_PrevAndNext(
			lichChiTietId, lichCongTacId, orderByComparator);
	}

	/**
	 * Removes all the lich chi tiets where lichCongTacId = &#63; from the database.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 */
	public static void removeByLichCongTacId(long lichCongTacId) {
		getPersistence().removeByLichCongTacId(lichCongTacId);
	}

	/**
	 * Returns the number of lich chi tiets where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @return the number of matching lich chi tiets
	 */
	public static int countByLichCongTacId(long lichCongTacId) {
		return getPersistence().countByLichCongTacId(lichCongTacId);
	}

	/**
	 * Caches the lich chi tiet in the entity cache if it is enabled.
	 *
	 * @param lichChiTiet the lich chi tiet
	 */
	public static void cacheResult(LichChiTiet lichChiTiet) {
		getPersistence().cacheResult(lichChiTiet);
	}

	/**
	 * Caches the lich chi tiets in the entity cache if it is enabled.
	 *
	 * @param lichChiTiets the lich chi tiets
	 */
	public static void cacheResult(List<LichChiTiet> lichChiTiets) {
		getPersistence().cacheResult(lichChiTiets);
	}

	/**
	 * Creates a new lich chi tiet with the primary key. Does not add the lich chi tiet to the database.
	 *
	 * @param lichChiTietId the primary key for the new lich chi tiet
	 * @return the new lich chi tiet
	 */
	public static LichChiTiet create(long lichChiTietId) {
		return getPersistence().create(lichChiTietId);
	}

	/**
	 * Removes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	public static LichChiTiet remove(long lichChiTietId)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchLichChiTietException {

		return getPersistence().remove(lichChiTietId);
	}

	public static LichChiTiet updateImpl(LichChiTiet lichChiTiet) {
		return getPersistence().updateImpl(lichChiTiet);
	}

	/**
	 * Returns the lich chi tiet with the primary key or throws a <code>NoSuchLichChiTietException</code> if it could not be found.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	public static LichChiTiet findByPrimaryKey(long lichChiTietId)
		throws com.ecoit.lichcongtac.services.exception.
			NoSuchLichChiTietException {

		return getPersistence().findByPrimaryKey(lichChiTietId);
	}

	/**
	 * Returns the lich chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet, or <code>null</code> if a lich chi tiet with the primary key could not be found
	 */
	public static LichChiTiet fetchByPrimaryKey(long lichChiTietId) {
		return getPersistence().fetchByPrimaryKey(lichChiTietId);
	}

	/**
	 * Returns all the lich chi tiets.
	 *
	 * @return the lich chi tiets
	 */
	public static List<LichChiTiet> findAll() {
		return getPersistence().findAll();
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
	public static List<LichChiTiet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<LichChiTiet> findAll(
		int start, int end, OrderByComparator<LichChiTiet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<LichChiTiet> findAll(
		int start, int end, OrderByComparator<LichChiTiet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lich chi tiets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lich chi tiets.
	 *
	 * @return the number of lich chi tiets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LichChiTietPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LichChiTietPersistence, LichChiTietPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LichChiTietPersistence.class);

		ServiceTracker<LichChiTietPersistence, LichChiTietPersistence>
			serviceTracker =
				new ServiceTracker
					<LichChiTietPersistence, LichChiTietPersistence>(
						bundle.getBundleContext(), LichChiTietPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}