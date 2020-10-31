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

import com.ecoit.elegaldocument.model.LegalDTypeRel;

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
 * The persistence utility for the legal d type rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalDTypeRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDTypeRelPersistence
 * @generated
 */
public class LegalDTypeRelUtil {

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
	public static void clearCache(LegalDTypeRel legalDTypeRel) {
		getPersistence().clearCache(legalDTypeRel);
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
	public static Map<Serializable, LegalDTypeRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalDTypeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalDTypeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalDTypeRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalDTypeRel update(LegalDTypeRel legalDTypeRel) {
		return getPersistence().update(legalDTypeRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalDTypeRel update(
		LegalDTypeRel legalDTypeRel, ServiceContext serviceContext) {

		return getPersistence().update(legalDTypeRel, serviceContext);
	}

	/**
	 * Returns all the legal d type rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByType(long typeId) {
		return getPersistence().findByType(typeId);
	}

	/**
	 * Returns a range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByType(
		long typeId, int start, int end) {

		return getPersistence().findByType(typeId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().findByType(
			typeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			typeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel findByType_First(
			long typeId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByType_First(typeId, orderByComparator);
	}

	/**
	 * Returns the first legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel fetchByType_First(
		long typeId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().fetchByType_First(typeId, orderByComparator);
	}

	/**
	 * Returns the last legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel findByType_Last(
			long typeId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByType_Last(typeId, orderByComparator);
	}

	/**
	 * Returns the last legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel fetchByType_Last(
		long typeId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().fetchByType_Last(typeId, orderByComparator);
	}

	/**
	 * Returns the legal d type rels before and after the current legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param legalDTypeRelPK the primary key of the current legal d type rel
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public static LegalDTypeRel[] findByType_PrevAndNext(
			LegalDTypeRelPK legalDTypeRelPK, long typeId,
			OrderByComparator<LegalDTypeRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByType_PrevAndNext(
			legalDTypeRelPK, typeId, orderByComparator);
	}

	/**
	 * Removes all the legal d type rels where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public static void removeByType(long typeId) {
		getPersistence().removeByType(typeId);
	}

	/**
	 * Returns the number of legal d type rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal d type rels
	 */
	public static int countByType(long typeId) {
		return getPersistence().countByType(typeId);
	}

	/**
	 * Returns all the legal d type rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByDoc(long docId) {
		return getPersistence().findByDoc(docId);
	}

	/**
	 * Returns a range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByDoc(
		long docId, int start, int end) {

		return getPersistence().findByDoc(docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().findByDoc(docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal d type rels
	 */
	public static List<LegalDTypeRel> findByDoc(
		long docId, int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDoc(
			docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel findByDoc_First(
			long docId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByDoc_First(docId, orderByComparator);
	}

	/**
	 * Returns the first legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel fetchByDoc_First(
		long docId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().fetchByDoc_First(docId, orderByComparator);
	}

	/**
	 * Returns the last legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel findByDoc_Last(
			long docId, OrderByComparator<LegalDTypeRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByDoc_Last(docId, orderByComparator);
	}

	/**
	 * Returns the last legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel fetchByDoc_Last(
		long docId, OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().fetchByDoc_Last(docId, orderByComparator);
	}

	/**
	 * Returns the legal d type rels before and after the current legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDTypeRelPK the primary key of the current legal d type rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public static LegalDTypeRel[] findByDoc_PrevAndNext(
			LegalDTypeRelPK legalDTypeRelPK, long docId,
			OrderByComparator<LegalDTypeRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByDoc_PrevAndNext(
			legalDTypeRelPK, docId, orderByComparator);
	}

	/**
	 * Removes all the legal d type rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public static void removeByDoc(long docId) {
		getPersistence().removeByDoc(docId);
	}

	/**
	 * Returns the number of legal d type rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal d type rels
	 */
	public static int countByDoc(long docId) {
		return getPersistence().countByDoc(docId);
	}

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or throws a <code>NoSuchLegalDTypeRelException</code> if it could not be found.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel findByDocType(long typeId, long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByDocType(typeId, docId);
	}

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel fetchByDocType(long typeId, long docId) {
		return getPersistence().fetchByDocType(typeId, docId);
	}

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public static LegalDTypeRel fetchByDocType(
		long typeId, long docId, boolean useFinderCache) {

		return getPersistence().fetchByDocType(typeId, docId, useFinderCache);
	}

	/**
	 * Removes the legal d type rel where typeId = &#63; and docId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the legal d type rel that was removed
	 */
	public static LegalDTypeRel removeByDocType(long typeId, long docId)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().removeByDocType(typeId, docId);
	}

	/**
	 * Returns the number of legal d type rels where typeId = &#63; and docId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the number of matching legal d type rels
	 */
	public static int countByDocType(long typeId, long docId) {
		return getPersistence().countByDocType(typeId, docId);
	}

	/**
	 * Caches the legal d type rel in the entity cache if it is enabled.
	 *
	 * @param legalDTypeRel the legal d type rel
	 */
	public static void cacheResult(LegalDTypeRel legalDTypeRel) {
		getPersistence().cacheResult(legalDTypeRel);
	}

	/**
	 * Caches the legal d type rels in the entity cache if it is enabled.
	 *
	 * @param legalDTypeRels the legal d type rels
	 */
	public static void cacheResult(List<LegalDTypeRel> legalDTypeRels) {
		getPersistence().cacheResult(legalDTypeRels);
	}

	/**
	 * Creates a new legal d type rel with the primary key. Does not add the legal d type rel to the database.
	 *
	 * @param legalDTypeRelPK the primary key for the new legal d type rel
	 * @return the new legal d type rel
	 */
	public static LegalDTypeRel create(LegalDTypeRelPK legalDTypeRelPK) {
		return getPersistence().create(legalDTypeRelPK);
	}

	/**
	 * Removes the legal d type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel that was removed
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public static LegalDTypeRel remove(LegalDTypeRelPK legalDTypeRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().remove(legalDTypeRelPK);
	}

	public static LegalDTypeRel updateImpl(LegalDTypeRel legalDTypeRel) {
		return getPersistence().updateImpl(legalDTypeRel);
	}

	/**
	 * Returns the legal d type rel with the primary key or throws a <code>NoSuchLegalDTypeRelException</code> if it could not be found.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public static LegalDTypeRel findByPrimaryKey(
			LegalDTypeRelPK legalDTypeRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException {

		return getPersistence().findByPrimaryKey(legalDTypeRelPK);
	}

	/**
	 * Returns the legal d type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel, or <code>null</code> if a legal d type rel with the primary key could not be found
	 */
	public static LegalDTypeRel fetchByPrimaryKey(
		LegalDTypeRelPK legalDTypeRelPK) {

		return getPersistence().fetchByPrimaryKey(legalDTypeRelPK);
	}

	/**
	 * Returns all the legal d type rels.
	 *
	 * @return the legal d type rels
	 */
	public static List<LegalDTypeRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of legal d type rels
	 */
	public static List<LegalDTypeRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal d type rels
	 */
	public static List<LegalDTypeRel> findAll(
		int start, int end,
		OrderByComparator<LegalDTypeRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal d type rels
	 */
	public static List<LegalDTypeRel> findAll(
		int start, int end, OrderByComparator<LegalDTypeRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal d type rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal d type rels.
	 *
	 * @return the number of legal d type rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalDTypeRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LegalDTypeRelPersistence, LegalDTypeRelPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalDTypeRelPersistence.class);

		ServiceTracker<LegalDTypeRelPersistence, LegalDTypeRelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalDTypeRelPersistence, LegalDTypeRelPersistence>(
						bundle.getBundleContext(),
						LegalDTypeRelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}