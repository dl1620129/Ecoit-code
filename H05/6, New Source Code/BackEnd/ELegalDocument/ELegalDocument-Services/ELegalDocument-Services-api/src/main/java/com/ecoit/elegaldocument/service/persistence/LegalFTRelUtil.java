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

import com.ecoit.elegaldocument.model.LegalFTRel;

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
 * The persistence utility for the legal ft rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalFTRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalFTRelPersistence
 * @generated
 */
public class LegalFTRelUtil {

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
	public static void clearCache(LegalFTRel legalFTRel) {
		getPersistence().clearCache(legalFTRel);
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
	public static Map<Serializable, LegalFTRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalFTRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalFTRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalFTRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalFTRel update(LegalFTRel legalFTRel) {
		return getPersistence().update(legalFTRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalFTRel update(
		LegalFTRel legalFTRel, ServiceContext serviceContext) {

		return getPersistence().update(legalFTRel, serviceContext);
	}

	/**
	 * Returns all the legal ft rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal ft rels
	 */
	public static List<LegalFTRel> findByField(long fieldId) {
		return getPersistence().findByField(fieldId);
	}

	/**
	 * Returns a range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of matching legal ft rels
	 */
	public static List<LegalFTRel> findByField(
		long fieldId, int start, int end) {

		return getPersistence().findByField(fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ft rels
	 */
	public static List<LegalFTRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().findByField(
			fieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ft rels
	 */
	public static List<LegalFTRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByField(
			fieldId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public static LegalFTRel findByField_First(
			long fieldId, OrderByComparator<LegalFTRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByField_First(fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public static LegalFTRel fetchByField_First(
		long fieldId, OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().fetchByField_First(fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public static LegalFTRel findByField_Last(
			long fieldId, OrderByComparator<LegalFTRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByField_Last(fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public static LegalFTRel fetchByField_Last(
		long fieldId, OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().fetchByField_Last(fieldId, orderByComparator);
	}

	/**
	 * Returns the legal ft rels before and after the current legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalFTRelPK the primary key of the current legal ft rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public static LegalFTRel[] findByField_PrevAndNext(
			LegalFTRelPK legalFTRelPK, long fieldId,
			OrderByComparator<LegalFTRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByField_PrevAndNext(
			legalFTRelPK, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal ft rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public static void removeByField(long fieldId) {
		getPersistence().removeByField(fieldId);
	}

	/**
	 * Returns the number of legal ft rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal ft rels
	 */
	public static int countByField(long fieldId) {
		return getPersistence().countByField(fieldId);
	}

	/**
	 * Returns all the legal ft rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal ft rels
	 */
	public static List<LegalFTRel> findByType(long typeId) {
		return getPersistence().findByType(typeId);
	}

	/**
	 * Returns a range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of matching legal ft rels
	 */
	public static List<LegalFTRel> findByType(long typeId, int start, int end) {
		return getPersistence().findByType(typeId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ft rels
	 */
	public static List<LegalFTRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().findByType(
			typeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ft rels
	 */
	public static List<LegalFTRel> findByType(
		long typeId, int start, int end,
		OrderByComparator<LegalFTRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			typeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public static LegalFTRel findByType_First(
			long typeId, OrderByComparator<LegalFTRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByType_First(typeId, orderByComparator);
	}

	/**
	 * Returns the first legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public static LegalFTRel fetchByType_First(
		long typeId, OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().fetchByType_First(typeId, orderByComparator);
	}

	/**
	 * Returns the last legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public static LegalFTRel findByType_Last(
			long typeId, OrderByComparator<LegalFTRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByType_Last(typeId, orderByComparator);
	}

	/**
	 * Returns the last legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public static LegalFTRel fetchByType_Last(
		long typeId, OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().fetchByType_Last(typeId, orderByComparator);
	}

	/**
	 * Returns the legal ft rels before and after the current legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param legalFTRelPK the primary key of the current legal ft rel
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public static LegalFTRel[] findByType_PrevAndNext(
			LegalFTRelPK legalFTRelPK, long typeId,
			OrderByComparator<LegalFTRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByType_PrevAndNext(
			legalFTRelPK, typeId, orderByComparator);
	}

	/**
	 * Removes all the legal ft rels where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public static void removeByType(long typeId) {
		getPersistence().removeByType(typeId);
	}

	/**
	 * Returns the number of legal ft rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal ft rels
	 */
	public static int countByType(long typeId) {
		return getPersistence().countByType(typeId);
	}

	/**
	 * Caches the legal ft rel in the entity cache if it is enabled.
	 *
	 * @param legalFTRel the legal ft rel
	 */
	public static void cacheResult(LegalFTRel legalFTRel) {
		getPersistence().cacheResult(legalFTRel);
	}

	/**
	 * Caches the legal ft rels in the entity cache if it is enabled.
	 *
	 * @param legalFTRels the legal ft rels
	 */
	public static void cacheResult(List<LegalFTRel> legalFTRels) {
		getPersistence().cacheResult(legalFTRels);
	}

	/**
	 * Creates a new legal ft rel with the primary key. Does not add the legal ft rel to the database.
	 *
	 * @param legalFTRelPK the primary key for the new legal ft rel
	 * @return the new legal ft rel
	 */
	public static LegalFTRel create(LegalFTRelPK legalFTRelPK) {
		return getPersistence().create(legalFTRelPK);
	}

	/**
	 * Removes the legal ft rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel that was removed
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public static LegalFTRel remove(LegalFTRelPK legalFTRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().remove(legalFTRelPK);
	}

	public static LegalFTRel updateImpl(LegalFTRel legalFTRel) {
		return getPersistence().updateImpl(legalFTRel);
	}

	/**
	 * Returns the legal ft rel with the primary key or throws a <code>NoSuchLegalFTRelException</code> if it could not be found.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public static LegalFTRel findByPrimaryKey(LegalFTRelPK legalFTRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException {

		return getPersistence().findByPrimaryKey(legalFTRelPK);
	}

	/**
	 * Returns the legal ft rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel, or <code>null</code> if a legal ft rel with the primary key could not be found
	 */
	public static LegalFTRel fetchByPrimaryKey(LegalFTRelPK legalFTRelPK) {
		return getPersistence().fetchByPrimaryKey(legalFTRelPK);
	}

	/**
	 * Returns all the legal ft rels.
	 *
	 * @return the legal ft rels
	 */
	public static List<LegalFTRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of legal ft rels
	 */
	public static List<LegalFTRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal ft rels
	 */
	public static List<LegalFTRel> findAll(
		int start, int end, OrderByComparator<LegalFTRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal ft rels
	 */
	public static List<LegalFTRel> findAll(
		int start, int end, OrderByComparator<LegalFTRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal ft rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal ft rels.
	 *
	 * @return the number of legal ft rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalFTRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalFTRelPersistence, LegalFTRelPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalFTRelPersistence.class);

		ServiceTracker<LegalFTRelPersistence, LegalFTRelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalFTRelPersistence, LegalFTRelPersistence>(
						bundle.getBundleContext(), LegalFTRelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}