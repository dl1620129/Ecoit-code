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

import com.ecoit.elegaldocument.model.EcmsGURelation;

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
 * The persistence utility for the ecms gu relation service. This utility wraps <code>com.ecoit.elegaldocument.service.persistence.impl.EcmsGURelationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see EcmsGURelationPersistence
 * @generated
 */
public class EcmsGURelationUtil {

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
	public static void clearCache(EcmsGURelation ecmsGURelation) {
		getPersistence().clearCache(ecmsGURelation);
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
	public static Map<Serializable, EcmsGURelation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EcmsGURelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EcmsGURelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EcmsGURelation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EcmsGURelation update(EcmsGURelation ecmsGURelation) {
		return getPersistence().update(ecmsGURelation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EcmsGURelation update(
		EcmsGURelation ecmsGURelation, ServiceContext serviceContext) {

		return getPersistence().update(ecmsGURelation, serviceContext);
	}

	/**
	 * Returns all the ecms gu relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms gu relations
	 */
	public static List<EcmsGURelation> findBygroupUserId(long groupUserId) {
		return getPersistence().findBygroupUserId(groupUserId);
	}

	/**
	 * Returns a range of all the ecms gu relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of matching ecms gu relations
	 */
	public static List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end) {

		return getPersistence().findBygroupUserId(groupUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms gu relations
	 */
	public static List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().findBygroupUserId(
			groupUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms gu relations
	 */
	public static List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygroupUserId(
			groupUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation findBygroupUserId_First(
			long groupUserId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findBygroupUserId_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the first ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation fetchBygroupUserId_First(
		long groupUserId, OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().fetchBygroupUserId_First(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation findBygroupUserId_Last(
			long groupUserId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findBygroupUserId_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation fetchBygroupUserId_Last(
		long groupUserId, OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().fetchBygroupUserId_Last(
			groupUserId, orderByComparator);
	}

	/**
	 * Returns the ecms gu relations before and after the current ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param ecmsGURelationPK the primary key of the current ecms gu relation
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public static EcmsGURelation[] findBygroupUserId_PrevAndNext(
			EcmsGURelationPK ecmsGURelationPK, long groupUserId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findBygroupUserId_PrevAndNext(
			ecmsGURelationPK, groupUserId, orderByComparator);
	}

	/**
	 * Removes all the ecms gu relations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public static void removeBygroupUserId(long groupUserId) {
		getPersistence().removeBygroupUserId(groupUserId);
	}

	/**
	 * Returns the number of ecms gu relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms gu relations
	 */
	public static int countBygroupUserId(long groupUserId) {
		return getPersistence().countBygroupUserId(groupUserId);
	}

	/**
	 * Returns all the ecms gu relations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ecms gu relations
	 */
	public static List<EcmsGURelation> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the ecms gu relations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of matching ecms gu relations
	 */
	public static List<EcmsGURelation> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ecms gu relations
	 */
	public static List<EcmsGURelation> findByuserId(
		long userId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ecms gu relations
	 */
	public static List<EcmsGURelation> findByuserId(
		long userId, int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation findByuserId_First(
			long userId, OrderByComparator<EcmsGURelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation fetchByuserId_First(
		long userId, OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation findByuserId_Last(
			long userId, OrderByComparator<EcmsGURelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation fetchByuserId_Last(
		long userId, OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the ecms gu relations before and after the current ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param ecmsGURelationPK the primary key of the current ecms gu relation
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public static EcmsGURelation[] findByuserId_PrevAndNext(
			EcmsGURelationPK ecmsGURelationPK, long userId,
			OrderByComparator<EcmsGURelation> orderByComparator)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findByuserId_PrevAndNext(
			ecmsGURelationPK, userId, orderByComparator);
	}

	/**
	 * Removes all the ecms gu relations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of ecms gu relations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ecms gu relations
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or throws a <code>NoSuchEcmsGURelationException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation findByG_U(long groupUserId, long userId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findByG_U(groupUserId, userId);
	}

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation fetchByG_U(long groupUserId, long userId) {
		return getPersistence().fetchByG_U(groupUserId, userId);
	}

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public static EcmsGURelation fetchByG_U(
		long groupUserId, long userId, boolean useFinderCache) {

		return getPersistence().fetchByG_U(groupUserId, userId, useFinderCache);
	}

	/**
	 * Removes the ecms gu relation where groupUserId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the ecms gu relation that was removed
	 */
	public static EcmsGURelation removeByG_U(long groupUserId, long userId)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().removeByG_U(groupUserId, userId);
	}

	/**
	 * Returns the number of ecms gu relations where groupUserId = &#63; and userId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the number of matching ecms gu relations
	 */
	public static int countByG_U(long groupUserId, long userId) {
		return getPersistence().countByG_U(groupUserId, userId);
	}

	/**
	 * Caches the ecms gu relation in the entity cache if it is enabled.
	 *
	 * @param ecmsGURelation the ecms gu relation
	 */
	public static void cacheResult(EcmsGURelation ecmsGURelation) {
		getPersistence().cacheResult(ecmsGURelation);
	}

	/**
	 * Caches the ecms gu relations in the entity cache if it is enabled.
	 *
	 * @param ecmsGURelations the ecms gu relations
	 */
	public static void cacheResult(List<EcmsGURelation> ecmsGURelations) {
		getPersistence().cacheResult(ecmsGURelations);
	}

	/**
	 * Creates a new ecms gu relation with the primary key. Does not add the ecms gu relation to the database.
	 *
	 * @param ecmsGURelationPK the primary key for the new ecms gu relation
	 * @return the new ecms gu relation
	 */
	public static EcmsGURelation create(EcmsGURelationPK ecmsGURelationPK) {
		return getPersistence().create(ecmsGURelationPK);
	}

	/**
	 * Removes the ecms gu relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation that was removed
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public static EcmsGURelation remove(EcmsGURelationPK ecmsGURelationPK)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().remove(ecmsGURelationPK);
	}

	public static EcmsGURelation updateImpl(EcmsGURelation ecmsGURelation) {
		return getPersistence().updateImpl(ecmsGURelation);
	}

	/**
	 * Returns the ecms gu relation with the primary key or throws a <code>NoSuchEcmsGURelationException</code> if it could not be found.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public static EcmsGURelation findByPrimaryKey(
			EcmsGURelationPK ecmsGURelationPK)
		throws com.ecoit.elegaldocument.exception.
			NoSuchEcmsGURelationException {

		return getPersistence().findByPrimaryKey(ecmsGURelationPK);
	}

	/**
	 * Returns the ecms gu relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation, or <code>null</code> if a ecms gu relation with the primary key could not be found
	 */
	public static EcmsGURelation fetchByPrimaryKey(
		EcmsGURelationPK ecmsGURelationPK) {

		return getPersistence().fetchByPrimaryKey(ecmsGURelationPK);
	}

	/**
	 * Returns all the ecms gu relations.
	 *
	 * @return the ecms gu relations
	 */
	public static List<EcmsGURelation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @return the range of ecms gu relations
	 */
	public static List<EcmsGURelation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ecms gu relations
	 */
	public static List<EcmsGURelation> findAll(
		int start, int end,
		OrderByComparator<EcmsGURelation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ecms gu relations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EcmsGURelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ecms gu relations
	 * @param end the upper bound of the range of ecms gu relations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ecms gu relations
	 */
	public static List<EcmsGURelation> findAll(
		int start, int end, OrderByComparator<EcmsGURelation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ecms gu relations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ecms gu relations.
	 *
	 * @return the number of ecms gu relations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static EcmsGURelationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EcmsGURelationPersistence, EcmsGURelationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EcmsGURelationPersistence.class);

		ServiceTracker<EcmsGURelationPersistence, EcmsGURelationPersistence>
			serviceTracker =
				new ServiceTracker
					<EcmsGURelationPersistence, EcmsGURelationPersistence>(
						bundle.getBundleContext(),
						EcmsGURelationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}