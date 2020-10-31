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

package com.ecoit.elegaldocument.service.persistence;

import com.ecoit.elegaldocument.model.LegalDURel;

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
 * The persistence utility for the legal du rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalDURelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDURelPersistence
 * @generated
 */
public class LegalDURelUtil {

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
	public static void clearCache(LegalDURel legalDURel) {
		getPersistence().clearCache(legalDURel);
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
	public static Map<Serializable, LegalDURel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalDURel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDURel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDURel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalDURel update(LegalDURel legalDURel) {
		return getPersistence().update(legalDURel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalDURel update(
		LegalDURel legalDURel, ServiceContext serviceContext) {

		return getPersistence().update(legalDURel, serviceContext);
	}

	/**
	 * Returns all the legal du rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching legal du rels
	 */
	public static List<LegalDURel> findByDepartament(long departmentId) {
		return getPersistence().findByDepartament(departmentId);
	}

	/**
	 * Returns a range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of matching legal du rels
	 */
	public static List<LegalDURel> findByDepartament(
		long departmentId, int start, int end) {

		return getPersistence().findByDepartament(departmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal du rels
	 */
	public static List<LegalDURel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().findByDepartament(
			departmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal du rels
	 */
	public static List<LegalDURel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDepartament(
			departmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public static LegalDURel findByDepartament_First(
			long departmentId, OrderByComparator<LegalDURel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByDepartament_First(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the first legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public static LegalDURel fetchByDepartament_First(
		long departmentId, OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().fetchByDepartament_First(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the last legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public static LegalDURel findByDepartament_Last(
			long departmentId, OrderByComparator<LegalDURel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByDepartament_Last(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the last legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public static LegalDURel fetchByDepartament_Last(
		long departmentId, OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().fetchByDepartament_Last(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the legal du rels before and after the current legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param legalDURelPK the primary key of the current legal du rel
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public static LegalDURel[] findByDepartament_PrevAndNext(
			LegalDURelPK legalDURelPK, long departmentId,
			OrderByComparator<LegalDURel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByDepartament_PrevAndNext(
			legalDURelPK, departmentId, orderByComparator);
	}

	/**
	 * Removes all the legal du rels where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	public static void removeByDepartament(long departmentId) {
		getPersistence().removeByDepartament(departmentId);
	}

	/**
	 * Returns the number of legal du rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching legal du rels
	 */
	public static int countByDepartament(long departmentId) {
		return getPersistence().countByDepartament(departmentId);
	}

	/**
	 * Returns all the legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the matching legal du rels
	 */
	public static List<LegalDURel> findByUser(long userid) {
		return getPersistence().findByUser(userid);
	}

	/**
	 * Returns a range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of matching legal du rels
	 */
	public static List<LegalDURel> findByUser(long userid, int start, int end) {
		return getPersistence().findByUser(userid, start, end);
	}

	/**
	 * Returns an ordered range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal du rels
	 */
	public static List<LegalDURel> findByUser(
		long userid, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().findByUser(
			userid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal du rels
	 */
	public static List<LegalDURel> findByUser(
		long userid, int start, int end,
		OrderByComparator<LegalDURel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUser(
			userid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public static LegalDURel findByUser_First(
			long userid, OrderByComparator<LegalDURel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByUser_First(userid, orderByComparator);
	}

	/**
	 * Returns the first legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public static LegalDURel fetchByUser_First(
		long userid, OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().fetchByUser_First(userid, orderByComparator);
	}

	/**
	 * Returns the last legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public static LegalDURel findByUser_Last(
			long userid, OrderByComparator<LegalDURel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByUser_Last(userid, orderByComparator);
	}

	/**
	 * Returns the last legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public static LegalDURel fetchByUser_Last(
		long userid, OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().fetchByUser_Last(userid, orderByComparator);
	}

	/**
	 * Returns the legal du rels before and after the current legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param legalDURelPK the primary key of the current legal du rel
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public static LegalDURel[] findByUser_PrevAndNext(
			LegalDURelPK legalDURelPK, long userid,
			OrderByComparator<LegalDURel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByUser_PrevAndNext(
			legalDURelPK, userid, orderByComparator);
	}

	/**
	 * Removes all the legal du rels where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 */
	public static void removeByUser(long userid) {
		getPersistence().removeByUser(userid);
	}

	/**
	 * Returns the number of legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching legal du rels
	 */
	public static int countByUser(long userid) {
		return getPersistence().countByUser(userid);
	}

	/**
	 * Returns the legal du rel where userid = &#63; or throws a <code>NoSuchLegalDURelException</code> if it could not be found.
	 *
	 * @param userid the userid
	 * @return the matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public static LegalDURel findByUserId(long userid)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByUserId(userid);
	}

	/**
	 * Returns the legal du rel where userid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userid the userid
	 * @return the matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public static LegalDURel fetchByUserId(long userid) {
		return getPersistence().fetchByUserId(userid);
	}

	/**
	 * Returns the legal du rel where userid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userid the userid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public static LegalDURel fetchByUserId(
		long userid, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userid, useFinderCache);
	}

	/**
	 * Removes the legal du rel where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 * @return the legal du rel that was removed
	 */
	public static LegalDURel removeByUserId(long userid)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().removeByUserId(userid);
	}

	/**
	 * Returns the number of legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching legal du rels
	 */
	public static int countByUserId(long userid) {
		return getPersistence().countByUserId(userid);
	}

	/**
	 * Caches the legal du rel in the entity cache if it is enabled.
	 *
	 * @param legalDURel the legal du rel
	 */
	public static void cacheResult(LegalDURel legalDURel) {
		getPersistence().cacheResult(legalDURel);
	}

	/**
	 * Caches the legal du rels in the entity cache if it is enabled.
	 *
	 * @param legalDURels the legal du rels
	 */
	public static void cacheResult(List<LegalDURel> legalDURels) {
		getPersistence().cacheResult(legalDURels);
	}

	/**
	 * Creates a new legal du rel with the primary key. Does not add the legal du rel to the database.
	 *
	 * @param legalDURelPK the primary key for the new legal du rel
	 * @return the new legal du rel
	 */
	public static LegalDURel create(LegalDURelPK legalDURelPK) {
		return getPersistence().create(legalDURelPK);
	}

	/**
	 * Removes the legal du rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel that was removed
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public static LegalDURel remove(LegalDURelPK legalDURelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().remove(legalDURelPK);
	}

	public static LegalDURel updateImpl(LegalDURel legalDURel) {
		return getPersistence().updateImpl(legalDURel);
	}

	/**
	 * Returns the legal du rel with the primary key or throws a <code>NoSuchLegalDURelException</code> if it could not be found.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public static LegalDURel findByPrimaryKey(LegalDURelPK legalDURelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDURelException {

		return getPersistence().findByPrimaryKey(legalDURelPK);
	}

	/**
	 * Returns the legal du rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel, or <code>null</code> if a legal du rel with the primary key could not be found
	 */
	public static LegalDURel fetchByPrimaryKey(LegalDURelPK legalDURelPK) {
		return getPersistence().fetchByPrimaryKey(legalDURelPK);
	}

	/**
	 * Returns all the legal du rels.
	 *
	 * @return the legal du rels
	 */
	public static List<LegalDURel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of legal du rels
	 */
	public static List<LegalDURel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal du rels
	 */
	public static List<LegalDURel> findAll(
		int start, int end, OrderByComparator<LegalDURel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal du rels
	 */
	public static List<LegalDURel> findAll(
		int start, int end, OrderByComparator<LegalDURel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal du rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal du rels.
	 *
	 * @return the number of legal du rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalDURelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalDURelPersistence, LegalDURelPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDURelPersistence.class);

		ServiceTracker<LegalDURelPersistence, LegalDURelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalDURelPersistence, LegalDURelPersistence>(
						bundle.getBundleContext(), LegalDURelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}