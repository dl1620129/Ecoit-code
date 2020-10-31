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

import com.ecoit.elegaldocument.model.LegalDDRel;

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
 * The persistence utility for the legal dd rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalDDRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDDRelPersistence
 * @generated
 */
public class LegalDDRelUtil {

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
	public static void clearCache(LegalDDRel legalDDRel) {
		getPersistence().clearCache(legalDDRel);
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
	public static Map<Serializable, LegalDDRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalDDRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDDRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDDRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalDDRel update(LegalDDRel legalDDRel) {
		return getPersistence().update(legalDDRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalDDRel update(
		LegalDDRel legalDDRel, ServiceContext serviceContext) {

		return getPersistence().update(legalDDRel, serviceContext);
	}

	/**
	 * Returns all the legal dd rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching legal dd rels
	 */
	public static List<LegalDDRel> findByDepartament(long departmentId) {
		return getPersistence().findByDepartament(departmentId);
	}

	/**
	 * Returns a range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of matching legal dd rels
	 */
	public static List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end) {

		return getPersistence().findByDepartament(departmentId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal dd rels
	 */
	public static List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().findByDepartament(
			departmentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal dd rels
	 */
	public static List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDepartament(
			departmentId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public static LegalDDRel findByDepartament_First(
			long departmentId, OrderByComparator<LegalDDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByDepartament_First(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the first legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public static LegalDDRel fetchByDepartament_First(
		long departmentId, OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().fetchByDepartament_First(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the last legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public static LegalDDRel findByDepartament_Last(
			long departmentId, OrderByComparator<LegalDDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByDepartament_Last(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the last legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public static LegalDDRel fetchByDepartament_Last(
		long departmentId, OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().fetchByDepartament_Last(
			departmentId, orderByComparator);
	}

	/**
	 * Returns the legal dd rels before and after the current legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param legalDDRelPK the primary key of the current legal dd rel
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public static LegalDDRel[] findByDepartament_PrevAndNext(
			LegalDDRelPK legalDDRelPK, long departmentId,
			OrderByComparator<LegalDDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByDepartament_PrevAndNext(
			legalDDRelPK, departmentId, orderByComparator);
	}

	/**
	 * Removes all the legal dd rels where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	public static void removeByDepartament(long departmentId) {
		getPersistence().removeByDepartament(departmentId);
	}

	/**
	 * Returns the number of legal dd rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching legal dd rels
	 */
	public static int countByDepartament(long departmentId) {
		return getPersistence().countByDepartament(departmentId);
	}

	/**
	 * Returns all the legal dd rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal dd rels
	 */
	public static List<LegalDDRel> findByDoc(String docId) {
		return getPersistence().findByDoc(docId);
	}

	/**
	 * Returns a range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of matching legal dd rels
	 */
	public static List<LegalDDRel> findByDoc(String docId, int start, int end) {
		return getPersistence().findByDoc(docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal dd rels
	 */
	public static List<LegalDDRel> findByDoc(
		String docId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().findByDoc(docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal dd rels
	 */
	public static List<LegalDDRel> findByDoc(
		String docId, int start, int end,
		OrderByComparator<LegalDDRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoc(
			docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public static LegalDDRel findByDoc_First(
			String docId, OrderByComparator<LegalDDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByDoc_First(docId, orderByComparator);
	}

	/**
	 * Returns the first legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public static LegalDDRel fetchByDoc_First(
		String docId, OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().fetchByDoc_First(docId, orderByComparator);
	}

	/**
	 * Returns the last legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public static LegalDDRel findByDoc_Last(
			String docId, OrderByComparator<LegalDDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByDoc_Last(docId, orderByComparator);
	}

	/**
	 * Returns the last legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public static LegalDDRel fetchByDoc_Last(
		String docId, OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().fetchByDoc_Last(docId, orderByComparator);
	}

	/**
	 * Returns the legal dd rels before and after the current legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDDRelPK the primary key of the current legal dd rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public static LegalDDRel[] findByDoc_PrevAndNext(
			LegalDDRelPK legalDDRelPK, String docId,
			OrderByComparator<LegalDDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByDoc_PrevAndNext(
			legalDDRelPK, docId, orderByComparator);
	}

	/**
	 * Removes all the legal dd rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public static void removeByDoc(String docId) {
		getPersistence().removeByDoc(docId);
	}

	/**
	 * Returns the number of legal dd rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal dd rels
	 */
	public static int countByDoc(String docId) {
		return getPersistence().countByDoc(docId);
	}

	/**
	 * Caches the legal dd rel in the entity cache if it is enabled.
	 *
	 * @param legalDDRel the legal dd rel
	 */
	public static void cacheResult(LegalDDRel legalDDRel) {
		getPersistence().cacheResult(legalDDRel);
	}

	/**
	 * Caches the legal dd rels in the entity cache if it is enabled.
	 *
	 * @param legalDDRels the legal dd rels
	 */
	public static void cacheResult(List<LegalDDRel> legalDDRels) {
		getPersistence().cacheResult(legalDDRels);
	}

	/**
	 * Creates a new legal dd rel with the primary key. Does not add the legal dd rel to the database.
	 *
	 * @param legalDDRelPK the primary key for the new legal dd rel
	 * @return the new legal dd rel
	 */
	public static LegalDDRel create(LegalDDRelPK legalDDRelPK) {
		return getPersistence().create(legalDDRelPK);
	}

	/**
	 * Removes the legal dd rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel that was removed
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public static LegalDDRel remove(LegalDDRelPK legalDDRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().remove(legalDDRelPK);
	}

	public static LegalDDRel updateImpl(LegalDDRel legalDDRel) {
		return getPersistence().updateImpl(legalDDRel);
	}

	/**
	 * Returns the legal dd rel with the primary key or throws a <code>NoSuchLegalDDRelException</code> if it could not be found.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public static LegalDDRel findByPrimaryKey(LegalDDRelPK legalDDRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException {

		return getPersistence().findByPrimaryKey(legalDDRelPK);
	}

	/**
	 * Returns the legal dd rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel, or <code>null</code> if a legal dd rel with the primary key could not be found
	 */
	public static LegalDDRel fetchByPrimaryKey(LegalDDRelPK legalDDRelPK) {
		return getPersistence().fetchByPrimaryKey(legalDDRelPK);
	}

	/**
	 * Returns all the legal dd rels.
	 *
	 * @return the legal dd rels
	 */
	public static List<LegalDDRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of legal dd rels
	 */
	public static List<LegalDDRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal dd rels
	 */
	public static List<LegalDDRel> findAll(
		int start, int end, OrderByComparator<LegalDDRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal dd rels
	 */
	public static List<LegalDDRel> findAll(
		int start, int end, OrderByComparator<LegalDDRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal dd rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal dd rels.
	 *
	 * @return the number of legal dd rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalDDRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalDDRelPersistence, LegalDDRelPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDDRelPersistence.class);

		ServiceTracker<LegalDDRelPersistence, LegalDDRelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalDDRelPersistence, LegalDDRelPersistence>(
						bundle.getBundleContext(), LegalDDRelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}