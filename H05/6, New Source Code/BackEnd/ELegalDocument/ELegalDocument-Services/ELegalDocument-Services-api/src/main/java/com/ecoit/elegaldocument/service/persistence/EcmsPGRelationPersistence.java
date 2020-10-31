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

import com.ecoit.elegaldocument.exception.NoSuchEcmsPGRelationException;
import com.ecoit.elegaldocument.model.EcmsPGRelation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ecms pg relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see EcmsPGRelationUtil
 * @generated
 */
@ProviderType
public interface EcmsPGRelationPersistence
	extends BasePersistence<EcmsPGRelation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcmsPGRelationUtil} to access the ecms pg relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ecms pg relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms pg relations
	 */
	public java.util.List<EcmsPGRelation> findBygroupUserId(long groupUserId);

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
	public java.util.List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end);

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
	public java.util.List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

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
	public java.util.List<EcmsPGRelation> findBygroupUserId(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation findBygroupUserId_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
				orderByComparator)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the first ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation fetchBygroupUserId_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

	/**
	 * Returns the last ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation findBygroupUserId_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
				orderByComparator)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the last ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation fetchBygroupUserId_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

	/**
	 * Returns the ecms pg relations before and after the current ecms pg relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param ecmsPGRelationPK the primary key of the current ecms pg relation
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public EcmsPGRelation[] findBygroupUserId_PrevAndNext(
			EcmsPGRelationPK ecmsPGRelationPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
				orderByComparator)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Removes all the ecms pg relations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeBygroupUserId(long groupUserId);

	/**
	 * Returns the number of ecms pg relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms pg relations
	 */
	public int countBygroupUserId(long groupUserId);

	/**
	 * Returns all the ecms pg relations where permission = &#63;.
	 *
	 * @param permission the permission
	 * @return the matching ecms pg relations
	 */
	public java.util.List<EcmsPGRelation> findBypermission(int permission);

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
	public java.util.List<EcmsPGRelation> findBypermission(
		int permission, int start, int end);

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
	public java.util.List<EcmsPGRelation> findBypermission(
		int permission, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

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
	public java.util.List<EcmsPGRelation> findBypermission(
		int permission, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation findBypermission_First(
			int permission,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
				orderByComparator)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the first ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation fetchBypermission_First(
		int permission,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

	/**
	 * Returns the last ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation findBypermission_Last(
			int permission,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
				orderByComparator)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the last ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation fetchBypermission_Last(
		int permission,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

	/**
	 * Returns the ecms pg relations before and after the current ecms pg relation in the ordered set where permission = &#63;.
	 *
	 * @param ecmsPGRelationPK the primary key of the current ecms pg relation
	 * @param permission the permission
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public EcmsPGRelation[] findBypermission_PrevAndNext(
			EcmsPGRelationPK ecmsPGRelationPK, int permission,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
				orderByComparator)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Removes all the ecms pg relations where permission = &#63; from the database.
	 *
	 * @param permission the permission
	 */
	public void removeBypermission(int permission);

	/**
	 * Returns the number of ecms pg relations where permission = &#63;.
	 *
	 * @param permission the permission
	 * @return the number of matching ecms pg relations
	 */
	public int countBypermission(int permission);

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or throws a <code>NoSuchEcmsPGRelationException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the matching ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation findByG_P(long groupUserId, int permission)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation fetchByG_P(long groupUserId, int permission);

	/**
	 * Returns the ecms pg relation where groupUserId = &#63; and permission = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms pg relation, or <code>null</code> if a matching ecms pg relation could not be found
	 */
	public EcmsPGRelation fetchByG_P(
		long groupUserId, int permission, boolean useFinderCache);

	/**
	 * Removes the ecms pg relation where groupUserId = &#63; and permission = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the ecms pg relation that was removed
	 */
	public EcmsPGRelation removeByG_P(long groupUserId, int permission)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the number of ecms pg relations where groupUserId = &#63; and permission = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param permission the permission
	 * @return the number of matching ecms pg relations
	 */
	public int countByG_P(long groupUserId, int permission);

	/**
	 * Caches the ecms pg relation in the entity cache if it is enabled.
	 *
	 * @param ecmsPGRelation the ecms pg relation
	 */
	public void cacheResult(EcmsPGRelation ecmsPGRelation);

	/**
	 * Caches the ecms pg relations in the entity cache if it is enabled.
	 *
	 * @param ecmsPGRelations the ecms pg relations
	 */
	public void cacheResult(java.util.List<EcmsPGRelation> ecmsPGRelations);

	/**
	 * Creates a new ecms pg relation with the primary key. Does not add the ecms pg relation to the database.
	 *
	 * @param ecmsPGRelationPK the primary key for the new ecms pg relation
	 * @return the new ecms pg relation
	 */
	public EcmsPGRelation create(EcmsPGRelationPK ecmsPGRelationPK);

	/**
	 * Removes the ecms pg relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation that was removed
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public EcmsPGRelation remove(EcmsPGRelationPK ecmsPGRelationPK)
		throws NoSuchEcmsPGRelationException;

	public EcmsPGRelation updateImpl(EcmsPGRelation ecmsPGRelation);

	/**
	 * Returns the ecms pg relation with the primary key or throws a <code>NoSuchEcmsPGRelationException</code> if it could not be found.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation
	 * @throws NoSuchEcmsPGRelationException if a ecms pg relation with the primary key could not be found
	 */
	public EcmsPGRelation findByPrimaryKey(EcmsPGRelationPK ecmsPGRelationPK)
		throws NoSuchEcmsPGRelationException;

	/**
	 * Returns the ecms pg relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecmsPGRelationPK the primary key of the ecms pg relation
	 * @return the ecms pg relation, or <code>null</code> if a ecms pg relation with the primary key could not be found
	 */
	public EcmsPGRelation fetchByPrimaryKey(EcmsPGRelationPK ecmsPGRelationPK);

	/**
	 * Returns all the ecms pg relations.
	 *
	 * @return the ecms pg relations
	 */
	public java.util.List<EcmsPGRelation> findAll();

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
	public java.util.List<EcmsPGRelation> findAll(int start, int end);

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
	public java.util.List<EcmsPGRelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator);

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
	public java.util.List<EcmsPGRelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsPGRelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ecms pg relations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ecms pg relations.
	 *
	 * @return the number of ecms pg relations
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}