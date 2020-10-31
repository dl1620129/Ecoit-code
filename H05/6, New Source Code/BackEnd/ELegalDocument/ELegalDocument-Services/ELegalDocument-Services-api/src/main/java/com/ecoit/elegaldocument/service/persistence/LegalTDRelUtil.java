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

import com.ecoit.elegaldocument.model.LegalTDRel;

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
 * The persistence utility for the legal td rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalTDRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalTDRelPersistence
 * @generated
 */
public class LegalTDRelUtil {

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
	public static void clearCache(LegalTDRel legalTDRel) {
		getPersistence().clearCache(legalTDRel);
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
	public static Map<Serializable, LegalTDRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalTDRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalTDRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalTDRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalTDRel update(LegalTDRel legalTDRel) {
		return getPersistence().update(legalTDRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalTDRel update(
		LegalTDRel legalTDRel, ServiceContext serviceContext) {

		return getPersistence().update(legalTDRel, serviceContext);
	}

	/**
	 * Returns all the legal td rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal td rels
	 */
	public static List<LegalTDRel> findByDocument(long docId) {
		return getPersistence().findByDocument(docId);
	}

	/**
	 * Returns a range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of matching legal td rels
	 */
	public static List<LegalTDRel> findByDocument(
		long docId, int start, int end) {

		return getPersistence().findByDocument(docId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal td rels
	 */
	public static List<LegalTDRel> findByDocument(
		long docId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().findByDocument(
			docId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal td rels
	 */
	public static List<LegalTDRel> findByDocument(
		long docId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDocument(
			docId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public static LegalTDRel findByDocument_First(
			long docId, OrderByComparator<LegalTDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByDocument_First(docId, orderByComparator);
	}

	/**
	 * Returns the first legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public static LegalTDRel fetchByDocument_First(
		long docId, OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().fetchByDocument_First(docId, orderByComparator);
	}

	/**
	 * Returns the last legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public static LegalTDRel findByDocument_Last(
			long docId, OrderByComparator<LegalTDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByDocument_Last(docId, orderByComparator);
	}

	/**
	 * Returns the last legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public static LegalTDRel fetchByDocument_Last(
		long docId, OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().fetchByDocument_Last(docId, orderByComparator);
	}

	/**
	 * Returns the legal td rels before and after the current legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param legalTDRelPK the primary key of the current legal td rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public static LegalTDRel[] findByDocument_PrevAndNext(
			LegalTDRelPK legalTDRelPK, long docId,
			OrderByComparator<LegalTDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByDocument_PrevAndNext(
			legalTDRelPK, docId, orderByComparator);
	}

	/**
	 * Removes all the legal td rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public static void removeByDocument(long docId) {
		getPersistence().removeByDocument(docId);
	}

	/**
	 * Returns the number of legal td rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal td rels
	 */
	public static int countByDocument(long docId) {
		return getPersistence().countByDocument(docId);
	}

	/**
	 * Returns all the legal td rels where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the matching legal td rels
	 */
	public static List<LegalTDRel> findByTag(long tagId) {
		return getPersistence().findByTag(tagId);
	}

	/**
	 * Returns a range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of matching legal td rels
	 */
	public static List<LegalTDRel> findByTag(long tagId, int start, int end) {
		return getPersistence().findByTag(tagId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal td rels
	 */
	public static List<LegalTDRel> findByTag(
		long tagId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().findByTag(tagId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal td rels
	 */
	public static List<LegalTDRel> findByTag(
		long tagId, int start, int end,
		OrderByComparator<LegalTDRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTag(
			tagId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public static LegalTDRel findByTag_First(
			long tagId, OrderByComparator<LegalTDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByTag_First(tagId, orderByComparator);
	}

	/**
	 * Returns the first legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public static LegalTDRel fetchByTag_First(
		long tagId, OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().fetchByTag_First(tagId, orderByComparator);
	}

	/**
	 * Returns the last legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public static LegalTDRel findByTag_Last(
			long tagId, OrderByComparator<LegalTDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByTag_Last(tagId, orderByComparator);
	}

	/**
	 * Returns the last legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public static LegalTDRel fetchByTag_Last(
		long tagId, OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().fetchByTag_Last(tagId, orderByComparator);
	}

	/**
	 * Returns the legal td rels before and after the current legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param legalTDRelPK the primary key of the current legal td rel
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public static LegalTDRel[] findByTag_PrevAndNext(
			LegalTDRelPK legalTDRelPK, long tagId,
			OrderByComparator<LegalTDRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByTag_PrevAndNext(
			legalTDRelPK, tagId, orderByComparator);
	}

	/**
	 * Removes all the legal td rels where tagId = &#63; from the database.
	 *
	 * @param tagId the tag ID
	 */
	public static void removeByTag(long tagId) {
		getPersistence().removeByTag(tagId);
	}

	/**
	 * Returns the number of legal td rels where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the number of matching legal td rels
	 */
	public static int countByTag(long tagId) {
		return getPersistence().countByTag(tagId);
	}

	/**
	 * Caches the legal td rel in the entity cache if it is enabled.
	 *
	 * @param legalTDRel the legal td rel
	 */
	public static void cacheResult(LegalTDRel legalTDRel) {
		getPersistence().cacheResult(legalTDRel);
	}

	/**
	 * Caches the legal td rels in the entity cache if it is enabled.
	 *
	 * @param legalTDRels the legal td rels
	 */
	public static void cacheResult(List<LegalTDRel> legalTDRels) {
		getPersistence().cacheResult(legalTDRels);
	}

	/**
	 * Creates a new legal td rel with the primary key. Does not add the legal td rel to the database.
	 *
	 * @param legalTDRelPK the primary key for the new legal td rel
	 * @return the new legal td rel
	 */
	public static LegalTDRel create(LegalTDRelPK legalTDRelPK) {
		return getPersistence().create(legalTDRelPK);
	}

	/**
	 * Removes the legal td rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel that was removed
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public static LegalTDRel remove(LegalTDRelPK legalTDRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().remove(legalTDRelPK);
	}

	public static LegalTDRel updateImpl(LegalTDRel legalTDRel) {
		return getPersistence().updateImpl(legalTDRel);
	}

	/**
	 * Returns the legal td rel with the primary key or throws a <code>NoSuchLegalTDRelException</code> if it could not be found.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public static LegalTDRel findByPrimaryKey(LegalTDRelPK legalTDRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException {

		return getPersistence().findByPrimaryKey(legalTDRelPK);
	}

	/**
	 * Returns the legal td rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel, or <code>null</code> if a legal td rel with the primary key could not be found
	 */
	public static LegalTDRel fetchByPrimaryKey(LegalTDRelPK legalTDRelPK) {
		return getPersistence().fetchByPrimaryKey(legalTDRelPK);
	}

	/**
	 * Returns all the legal td rels.
	 *
	 * @return the legal td rels
	 */
	public static List<LegalTDRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of legal td rels
	 */
	public static List<LegalTDRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal td rels
	 */
	public static List<LegalTDRel> findAll(
		int start, int end, OrderByComparator<LegalTDRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal td rels
	 */
	public static List<LegalTDRel> findAll(
		int start, int end, OrderByComparator<LegalTDRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal td rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal td rels.
	 *
	 * @return the number of legal td rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalTDRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalTDRelPersistence, LegalTDRelPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalTDRelPersistence.class);

		ServiceTracker<LegalTDRelPersistence, LegalTDRelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalTDRelPersistence, LegalTDRelPersistence>(
						bundle.getBundleContext(), LegalTDRelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}