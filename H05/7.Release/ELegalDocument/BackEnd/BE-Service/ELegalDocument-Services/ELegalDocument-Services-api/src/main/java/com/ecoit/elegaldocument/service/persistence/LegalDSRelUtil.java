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

import com.ecoit.elegaldocument.model.LegalDSRel;

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
 * The persistence utility for the legal ds rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalDSRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDSRelPersistence
 * @generated
 */
public class LegalDSRelUtil {

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
	public static void clearCache(LegalDSRel legalDSRel) {
		getPersistence().clearCache(legalDSRel);
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
	public static Map<Serializable, LegalDSRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalDSRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDSRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDSRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalDSRel update(LegalDSRel legalDSRel) {
		return getPersistence().update(legalDSRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalDSRel update(
		LegalDSRel legalDSRel, ServiceContext serviceContext) {

		return getPersistence().update(legalDSRel, serviceContext);
	}

	/**
	 * Returns all the legal ds rels where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal ds rels
	 */
	public static List<LegalDSRel> findBySigner(long sigId) {
		return getPersistence().findBySigner(sigId);
	}

	/**
	 * Returns a range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of matching legal ds rels
	 */
	public static List<LegalDSRel> findBySigner(
		long sigId, int start, int end) {

		return getPersistence().findBySigner(sigId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ds rels
	 */
	public static List<LegalDSRel> findBySigner(
		long sigId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().findBySigner(
			sigId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ds rels
	 */
	public static List<LegalDSRel> findBySigner(
		long sigId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySigner(
			sigId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public static LegalDSRel findBySigner_First(
			long sigId, OrderByComparator<LegalDSRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findBySigner_First(sigId, orderByComparator);
	}

	/**
	 * Returns the first legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public static LegalDSRel fetchBySigner_First(
		long sigId, OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().fetchBySigner_First(sigId, orderByComparator);
	}

	/**
	 * Returns the last legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public static LegalDSRel findBySigner_Last(
			long sigId, OrderByComparator<LegalDSRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findBySigner_Last(sigId, orderByComparator);
	}

	/**
	 * Returns the last legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public static LegalDSRel fetchBySigner_Last(
		long sigId, OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().fetchBySigner_Last(sigId, orderByComparator);
	}

	/**
	 * Returns the legal ds rels before and after the current legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param legalDSRelPK the primary key of the current legal ds rel
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public static LegalDSRel[] findBySigner_PrevAndNext(
			LegalDSRelPK legalDSRelPK, long sigId,
			OrderByComparator<LegalDSRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findBySigner_PrevAndNext(
			legalDSRelPK, sigId, orderByComparator);
	}

	/**
	 * Removes all the legal ds rels where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 */
	public static void removeBySigner(long sigId) {
		getPersistence().removeBySigner(sigId);
	}

	/**
	 * Returns the number of legal ds rels where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching legal ds rels
	 */
	public static int countBySigner(long sigId) {
		return getPersistence().countBySigner(sigId);
	}

	/**
	 * Returns all the legal ds rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal ds rels
	 */
	public static List<LegalDSRel> findByDoc(long docId) {
		return getPersistence().findByDoc(docId);
	}

	/**
	 * Returns a range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of matching legal ds rels
	 */
	public static List<LegalDSRel> findByDoc(long docId, int start, int end) {
		return getPersistence().findByDoc(docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ds rels
	 */
	public static List<LegalDSRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().findByDoc(docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ds rels
	 */
	public static List<LegalDSRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDSRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoc(
			docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public static LegalDSRel findByDoc_First(
			long docId, OrderByComparator<LegalDSRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findByDoc_First(docId, orderByComparator);
	}

	/**
	 * Returns the first legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public static LegalDSRel fetchByDoc_First(
		long docId, OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().fetchByDoc_First(docId, orderByComparator);
	}

	/**
	 * Returns the last legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public static LegalDSRel findByDoc_Last(
			long docId, OrderByComparator<LegalDSRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findByDoc_Last(docId, orderByComparator);
	}

	/**
	 * Returns the last legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public static LegalDSRel fetchByDoc_Last(
		long docId, OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().fetchByDoc_Last(docId, orderByComparator);
	}

	/**
	 * Returns the legal ds rels before and after the current legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDSRelPK the primary key of the current legal ds rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public static LegalDSRel[] findByDoc_PrevAndNext(
			LegalDSRelPK legalDSRelPK, long docId,
			OrderByComparator<LegalDSRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findByDoc_PrevAndNext(
			legalDSRelPK, docId, orderByComparator);
	}

	/**
	 * Removes all the legal ds rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public static void removeByDoc(long docId) {
		getPersistence().removeByDoc(docId);
	}

	/**
	 * Returns the number of legal ds rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal ds rels
	 */
	public static int countByDoc(long docId) {
		return getPersistence().countByDoc(docId);
	}

	/**
	 * Caches the legal ds rel in the entity cache if it is enabled.
	 *
	 * @param legalDSRel the legal ds rel
	 */
	public static void cacheResult(LegalDSRel legalDSRel) {
		getPersistence().cacheResult(legalDSRel);
	}

	/**
	 * Caches the legal ds rels in the entity cache if it is enabled.
	 *
	 * @param legalDSRels the legal ds rels
	 */
	public static void cacheResult(List<LegalDSRel> legalDSRels) {
		getPersistence().cacheResult(legalDSRels);
	}

	/**
	 * Creates a new legal ds rel with the primary key. Does not add the legal ds rel to the database.
	 *
	 * @param legalDSRelPK the primary key for the new legal ds rel
	 * @return the new legal ds rel
	 */
	public static LegalDSRel create(LegalDSRelPK legalDSRelPK) {
		return getPersistence().create(legalDSRelPK);
	}

	/**
	 * Removes the legal ds rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel that was removed
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public static LegalDSRel remove(LegalDSRelPK legalDSRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().remove(legalDSRelPK);
	}

	public static LegalDSRel updateImpl(LegalDSRel legalDSRel) {
		return getPersistence().updateImpl(legalDSRel);
	}

	/**
	 * Returns the legal ds rel with the primary key or throws a <code>NoSuchLegalDSRelException</code> if it could not be found.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public static LegalDSRel findByPrimaryKey(LegalDSRelPK legalDSRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException {

		return getPersistence().findByPrimaryKey(legalDSRelPK);
	}

	/**
	 * Returns the legal ds rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel, or <code>null</code> if a legal ds rel with the primary key could not be found
	 */
	public static LegalDSRel fetchByPrimaryKey(LegalDSRelPK legalDSRelPK) {
		return getPersistence().fetchByPrimaryKey(legalDSRelPK);
	}

	/**
	 * Returns all the legal ds rels.
	 *
	 * @return the legal ds rels
	 */
	public static List<LegalDSRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of legal ds rels
	 */
	public static List<LegalDSRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal ds rels
	 */
	public static List<LegalDSRel> findAll(
		int start, int end, OrderByComparator<LegalDSRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal ds rels
	 */
	public static List<LegalDSRel> findAll(
		int start, int end, OrderByComparator<LegalDSRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal ds rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal ds rels.
	 *
	 * @return the number of legal ds rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalDSRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalDSRelPersistence, LegalDSRelPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDSRelPersistence.class);

		ServiceTracker<LegalDSRelPersistence, LegalDSRelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalDSRelPersistence, LegalDSRelPersistence>(
						bundle.getBundleContext(), LegalDSRelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}