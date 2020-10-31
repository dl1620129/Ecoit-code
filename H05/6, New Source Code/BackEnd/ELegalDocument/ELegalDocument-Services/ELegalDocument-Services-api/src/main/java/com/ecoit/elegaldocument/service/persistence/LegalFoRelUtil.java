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

import com.ecoit.elegaldocument.model.LegalFoRel;

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
 * The persistence utility for the legal fo rel service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.LegalFoRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalFoRelPersistence
 * @generated
 */
public class LegalFoRelUtil {

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
	public static void clearCache(LegalFoRel legalFoRel) {
		getPersistence().clearCache(legalFoRel);
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
	public static Map<Serializable, LegalFoRel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LegalFoRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LegalFoRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LegalFoRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LegalFoRel update(LegalFoRel legalFoRel) {
		return getPersistence().update(legalFoRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LegalFoRel update(
		LegalFoRel legalFoRel, ServiceContext serviceContext) {

		return getPersistence().update(legalFoRel, serviceContext);
	}

	/**
	 * Returns all the legal fo rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal fo rels
	 */
	public static List<LegalFoRel> findByField(long fieldId) {
		return getPersistence().findByField(fieldId);
	}

	/**
	 * Returns a range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of matching legal fo rels
	 */
	public static List<LegalFoRel> findByField(
		long fieldId, int start, int end) {

		return getPersistence().findByField(fieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fo rels
	 */
	public static List<LegalFoRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().findByField(
			fieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fo rels
	 */
	public static List<LegalFoRel> findByField(
		long fieldId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByField(
			fieldId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public static LegalFoRel findByField_First(
			long fieldId, OrderByComparator<LegalFoRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByField_First(fieldId, orderByComparator);
	}

	/**
	 * Returns the first legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public static LegalFoRel fetchByField_First(
		long fieldId, OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().fetchByField_First(fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public static LegalFoRel findByField_Last(
			long fieldId, OrderByComparator<LegalFoRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByField_Last(fieldId, orderByComparator);
	}

	/**
	 * Returns the last legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public static LegalFoRel fetchByField_Last(
		long fieldId, OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().fetchByField_Last(fieldId, orderByComparator);
	}

	/**
	 * Returns the legal fo rels before and after the current legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalFoRelPK the primary key of the current legal fo rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public static LegalFoRel[] findByField_PrevAndNext(
			LegalFoRelPK legalFoRelPK, long fieldId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByField_PrevAndNext(
			legalFoRelPK, fieldId, orderByComparator);
	}

	/**
	 * Removes all the legal fo rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public static void removeByField(long fieldId) {
		getPersistence().removeByField(fieldId);
	}

	/**
	 * Returns the number of legal fo rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal fo rels
	 */
	public static int countByField(long fieldId) {
		return getPersistence().countByField(fieldId);
	}

	/**
	 * Returns all the legal fo rels where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal fo rels
	 */
	public static List<LegalFoRel> findByOrg(long organizationId) {
		return getPersistence().findByOrg(organizationId);
	}

	/**
	 * Returns a range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of matching legal fo rels
	 */
	public static List<LegalFoRel> findByOrg(
		long organizationId, int start, int end) {

		return getPersistence().findByOrg(organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fo rels
	 */
	public static List<LegalFoRel> findByOrg(
		long organizationId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().findByOrg(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fo rels
	 */
	public static List<LegalFoRel> findByOrg(
		long organizationId, int start, int end,
		OrderByComparator<LegalFoRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrg(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public static LegalFoRel findByOrg_First(
			long organizationId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByOrg_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public static LegalFoRel fetchByOrg_First(
		long organizationId, OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().fetchByOrg_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public static LegalFoRel findByOrg_Last(
			long organizationId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByOrg_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public static LegalFoRel fetchByOrg_Last(
		long organizationId, OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().fetchByOrg_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the legal fo rels before and after the current legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param legalFoRelPK the primary key of the current legal fo rel
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public static LegalFoRel[] findByOrg_PrevAndNext(
			LegalFoRelPK legalFoRelPK, long organizationId,
			OrderByComparator<LegalFoRel> orderByComparator)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByOrg_PrevAndNext(
			legalFoRelPK, organizationId, orderByComparator);
	}

	/**
	 * Removes all the legal fo rels where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrg(long organizationId) {
		getPersistence().removeByOrg(organizationId);
	}

	/**
	 * Returns the number of legal fo rels where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal fo rels
	 */
	public static int countByOrg(long organizationId) {
		return getPersistence().countByOrg(organizationId);
	}

	/**
	 * Caches the legal fo rel in the entity cache if it is enabled.
	 *
	 * @param legalFoRel the legal fo rel
	 */
	public static void cacheResult(LegalFoRel legalFoRel) {
		getPersistence().cacheResult(legalFoRel);
	}

	/**
	 * Caches the legal fo rels in the entity cache if it is enabled.
	 *
	 * @param legalFoRels the legal fo rels
	 */
	public static void cacheResult(List<LegalFoRel> legalFoRels) {
		getPersistence().cacheResult(legalFoRels);
	}

	/**
	 * Creates a new legal fo rel with the primary key. Does not add the legal fo rel to the database.
	 *
	 * @param legalFoRelPK the primary key for the new legal fo rel
	 * @return the new legal fo rel
	 */
	public static LegalFoRel create(LegalFoRelPK legalFoRelPK) {
		return getPersistence().create(legalFoRelPK);
	}

	/**
	 * Removes the legal fo rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel that was removed
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public static LegalFoRel remove(LegalFoRelPK legalFoRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().remove(legalFoRelPK);
	}

	public static LegalFoRel updateImpl(LegalFoRel legalFoRel) {
		return getPersistence().updateImpl(legalFoRel);
	}

	/**
	 * Returns the legal fo rel with the primary key or throws a <code>NoSuchLegalFoRelException</code> if it could not be found.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public static LegalFoRel findByPrimaryKey(LegalFoRelPK legalFoRelPK)
		throws com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException {

		return getPersistence().findByPrimaryKey(legalFoRelPK);
	}

	/**
	 * Returns the legal fo rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel, or <code>null</code> if a legal fo rel with the primary key could not be found
	 */
	public static LegalFoRel fetchByPrimaryKey(LegalFoRelPK legalFoRelPK) {
		return getPersistence().fetchByPrimaryKey(legalFoRelPK);
	}

	/**
	 * Returns all the legal fo rels.
	 *
	 * @return the legal fo rels
	 */
	public static List<LegalFoRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of legal fo rels
	 */
	public static List<LegalFoRel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal fo rels
	 */
	public static List<LegalFoRel> findAll(
		int start, int end, OrderByComparator<LegalFoRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal fo rels
	 */
	public static List<LegalFoRel> findAll(
		int start, int end, OrderByComparator<LegalFoRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the legal fo rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of legal fo rels.
	 *
	 * @return the number of legal fo rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static LegalFoRelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LegalFoRelPersistence, LegalFoRelPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LegalFoRelPersistence.class);

		ServiceTracker<LegalFoRelPersistence, LegalFoRelPersistence>
			serviceTracker =
				new ServiceTracker
					<LegalFoRelPersistence, LegalFoRelPersistence>(
						bundle.getBundleContext(), LegalFoRelPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}