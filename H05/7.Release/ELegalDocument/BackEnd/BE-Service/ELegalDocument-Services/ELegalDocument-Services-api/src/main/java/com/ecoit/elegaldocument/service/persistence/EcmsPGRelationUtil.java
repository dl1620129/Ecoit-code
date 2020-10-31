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

import com.ecoit.elegaldocument.model.EcmsPGRelation;

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
 * The persistence utility for the ecms pg relation service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.EcmsPGRelationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see EcmsPGRelationPersistence
 * @generated
 */
public class EcmsPGRelationUtil {

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
	public static void clearCache(EcmsPGRelation ecmsPGRelation) {
		getPersistence().clearCache(ecmsPGRelation);
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
	public static Map<Serializable, EcmsPGRelation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EcmsPGRelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EcmsPGRelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EcmsPGRelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EcmsPGRelation update(EcmsPGRelation ecmsPGRelation) {
		return getPersistence().update(ecmsPGRelation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EcmsPGRelation update(
		EcmsPGRelation ecmsPGRelation, ServiceContext serviceContext) {

		return getPersistence().update(ecmsPGRelation, serviceContext);
	}

	/**
	 * Returns all the ecms pg relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBygroupUserId(long groupUserId) {
		return getPersistence().findBygroupUserId(groupUserId);
	}

	/**
	 * Returns a range of all the ecms pg relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end) {

		return getPersistence().findBygroupUserId(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().findBygroupUserId(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygroupUserId(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation findBygroupUserId_First(
			long groupUserId,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findBygroupUserId_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation fetchBygroupUserId_First(
		long groupUserId, OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().fetchBygroupUserId_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation findBygroupUserId_Last(
			long groupUserId,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findBygroupUserId_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation fetchBygroupUserId_Last(
		long groupUserId, OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().fetchBygroupUserId_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the ecms pg relations before and after the current ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param ecmsPGRelationPK the primary key of the current ecms pg relation
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public static EcmsPGRelation[] findBygroupUserId_PrevAndNext(
			EcmsPGRelationPK ecmsPGRelationPK, long groupUserId,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findBygroupUserId_PrevAndNext(
			ecmsPGRelationPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the ecms pg relations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeBygroupUserId(long groupUserId) {
		getPersistence().removeBygroupUserId(groupUserId);
	}

	/**
	 * Returns the number of ecms pg relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms pg relations
	 */
	public static int countBygroupUserId(long groupUserId) {
		return getPersistence().countBygroupUserId(groupUserId);
	}

	/**
	 * Returns all the ecms pg relations where permission = &#63;.
	 *
	 * @param permission the permission
	 * @return the matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBypermission(int permission) {
		return getPersistence().findBypermission(permission);
	}

	/**
	 * Returns a range of all the ecms pg relations where permission = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param permission the permission
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBypermission(
		int permission, int start, int end) {

		return getPersistence().findBypermission(permission, start, end);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where permission = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param permission the permission
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBypermission(
		int permission, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().findBypermission(
			permission, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations where permission = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param permission the permission
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms pg relations
	 */
	public static List<EcmsPGRelation> findBypermission(
		int permission, int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypermission(
			permission, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation findBypermission_First(
			int permission, OrderByComparator<EcmsPGRelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findBypermission_First(
			permission, orderByComparator);
	}

	/**
	 * Returns the first ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation fetchBypermission_First(
		int permission, OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().fetchBypermission_First(
			permission, orderByComparator);
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation findBypermission_Last(
			int permission, OrderByComparator<EcmsPGRelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findBypermission_Last(
			permission, orderByComparator);
	}

	/**
	 * Returns the last ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation fetchBypermission_Last(
		int permission, OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().fetchBypermission_Last(
			permission, orderByComparator);
	}

	/**
	 * Returns the ecms pg relations before and after the current ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param ecmsPGRelationPK the primary key of the current ecms pg relation
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public static EcmsPGRelation[] findBypermission_PrevAndNext(
			EcmsPGRelationPK ecmsPGRelationPK, int permission,
			OrderByComparator<EcmsPGRelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findBypermission_PrevAndNext(
			ecmsPGRelationPK, permission, orderByComparator);
	}

	/**
	 * Removes all the ecms pg relations where permission = &#63; from the database.
	 *
	 * @param permission the permission
	 */
	public static void removeBypermission(int permission) {
		getPersistence().removeBypermission(permission);
	}

	/**
	 * Returns the number of ecms pg relations where permission = &#63;.
	 *
	 * @param permission the permission
	 * @return the number of matching ecms pg relations
	 */
	public static int countBypermission(int permission) {
		return getPersistence().countBypermission(permission);
	}

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or throws a <code>NoSuchEcmsPGRelationException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation findByG_P(long groupUserId, int permission)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findByG_P(groupUserId, permission);
	}

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation fetchByG_P(long groupUserId, int permission) {
		return getPersistence().fetchByG_P(groupUserId, permission);
	}

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public static EcmsPGRelation fetchByG_P(
		long groupUserId, int permission, boolean useFinderCache) {

		return getPersistence().fetchByG_P(
			groupUserId, permission, useFinderCache);
	}

	/**
	 * Removes the ecms pg relation where groupUserId = &#63; and permission = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the ecms pg relation that was removed
	 */
	public static EcmsPGRelation removeByG_P(long groupUserId, int permission)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().removeByG_P(groupUserId, permission);
	}

	/**
	 * Returns the number of ecms pg relations where groupUserId = &#63; and permission = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the number of matching ecms pg relations
	 */
	public static int countByG_P(long groupUserId, int permission) {
		return getPersistence().countByG_P(groupUserId, permission);
	}

	/**
	 * Caches the ecms pg relation in the entity cache if it is enabled.
	 *
	 * @param ecmsPGRelation the ecms pg relation
	 */
	public static void cacheResult(EcmsPGRelation ecmsPGRelation) {
		getPersistence().cacheResult(ecmsPGRelation);
	}

	/**
	 * Caches the ecms pg relations in the entity cache if it is enabled.
	 *
	 * @param ecmsPGRelations the ecms pg relations
	 */
	public static void cacheResult(List<EcmsPGRelation> ecmsPGRelations) {
		getPersistence().cacheResult(ecmsPGRelations);
	}

	/**
	 * Creates a new ecms pg relation with the primary key. Does not add the ecms pg relation to the database.
	 *
	 * @param ecmsPGRelationPK the primary key for the new ecms pg relation
	 * @return the new ecms pg relation
	 */
	public static EcmsPGRelation create(EcmsPGRelationPK ecmsPGRelationPK) {
		return getPersistence().create(ecmsPGRelationPK);
	}

	/**
	 * Removes the ecms pg relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation that was removed
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public static EcmsPGRelation remove(EcmsPGRelationPK ecmsPGRelationPK)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().remove(ecmsPGRelationPK);
	}

	public static EcmsPGRelation updateImpl(EcmsPGRelation ecmsPGRelation) {
		return getPersistence().updateImpl(ecmsPGRelation);
	}

	/**
	 * Returns the ecms pg relation with the primary key or throws a <code>NoSuchEcmsPGRelationException</code> if it could not be found.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public static EcmsPGRelation findByPrimaryKey(
			EcmsPGRelationPK ecmsPGRelationPK)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsPGRelationException {

		return getPersistence().findByPrimaryKey(ecmsPGRelationPK);
	}

	/**
	 * Returns the ecms pg relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation, or <code>null</code> if a ecms pg relation with the primary key could not be found
	 */
	public static EcmsPGRelation fetchByPrimaryKey(
		EcmsPGRelationPK ecmsPGRelationPK) {

		return getPersistence().fetchByPrimaryKey(ecmsPGRelationPK);
	}

	/**
	 * Returns all the ecms pg relations.
	 *
	 * @return the ecms pg relations
	 */
	public static List<EcmsPGRelation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @return the range of ecms pg relations
	 */
	public static List<EcmsPGRelation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ecms pg relations
	 */
	public static List<EcmsPGRelation> findAll(
		int start, int end,
		OrderByComparator<EcmsPGRelation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ecms pg relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsPGRelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms pg relations
	 * @param end the upper bound of the range of ecms pg relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ecms pg relations
	 */
	public static List<EcmsPGRelation> findAll(
		int start, int end, OrderByComparator<EcmsPGRelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ecms pg relations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ecms pg relations.
	 *
	 * @return the number of ecms pg relations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static EcmsPGRelationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EcmsPGRelationPersistence, EcmsPGRelationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EcmsPGRelationPersistence.class);

		ServiceTracker<EcmsPGRelationPersistence, EcmsPGRelationPersistence>
			serviceTracker =
				new ServiceTracker
					<EcmsPGRelationPersistence, EcmsPGRelationPersistence>(
						bundle.getBundleContext(),
						EcmsPGRelationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}