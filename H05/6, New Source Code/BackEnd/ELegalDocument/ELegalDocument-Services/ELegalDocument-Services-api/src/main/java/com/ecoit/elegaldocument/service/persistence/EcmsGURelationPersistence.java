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

import com.ecoit.elegaldocument.exception.NoSuchEcmsGURelationException;
import com.ecoit.elegaldocument.model.EcmsGURelation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ecms gu relation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see EcmsGURelationUtil
 * @generated
 */
@ProviderType
public interface EcmsGURelationPersistence
	extends BasePersistence<EcmsGURelation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcmsGURelationUtil} to access the ecms gu relation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ecms gu relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching ecms gu relations
	 */
	public java.util.List<EcmsGURelation> findBygroupUserId(long groupUserId);

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
	public java.util.List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end);

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
	public java.util.List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

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
	public java.util.List<EcmsGURelation> findBygroupUserId(
		long groupUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation findBygroupUserId_First(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
				orderByComparator)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the first ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation fetchBygroupUserId_First(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

	/**
	 * Returns the last ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation findBygroupUserId_Last(
			long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
				orderByComparator)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the last ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation fetchBygroupUserId_Last(
		long groupUserId,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

	/**
	 * Returns the ecms gu relations before and after the current ecms gu relation in the ordered set where groupUserId = &#63;.
	 *
	 * @param ecmsGURelationPK the primary key of the current ecms gu relation
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public EcmsGURelation[] findBygroupUserId_PrevAndNext(
			EcmsGURelationPK ecmsGURelationPK, long groupUserId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
				orderByComparator)
		throws NoSuchEcmsGURelationException;

	/**
	 * Removes all the ecms gu relations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	public void removeBygroupUserId(long groupUserId);

	/**
	 * Returns the number of ecms gu relations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching ecms gu relations
	 */
	public int countBygroupUserId(long groupUserId);

	/**
	 * Returns all the ecms gu relations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ecms gu relations
	 */
	public java.util.List<EcmsGURelation> findByuserId(long userId);

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
	public java.util.List<EcmsGURelation> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<EcmsGURelation> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

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
	public java.util.List<EcmsGURelation> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
				orderByComparator)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the first ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

	/**
	 * Returns the last ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
				orderByComparator)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the last ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

	/**
	 * Returns the ecms gu relations before and after the current ecms gu relation in the ordered set where userId = &#63;.
	 *
	 * @param ecmsGURelationPK the primary key of the current ecms gu relation
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public EcmsGURelation[] findByuserId_PrevAndNext(
			EcmsGURelationPK ecmsGURelationPK, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
				orderByComparator)
		throws NoSuchEcmsGURelationException;

	/**
	 * Removes all the ecms gu relations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of ecms gu relations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ecms gu relations
	 */
	public int countByuserId(long userId);

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or throws a <code>NoSuchEcmsGURelationException</code> if it could not be found.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the matching ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation findByG_U(long groupUserId, long userId)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation fetchByG_U(long groupUserId, long userId);

	/**
	 * Returns the ecms gu relation where groupUserId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ecms gu relation, or <code>null</code> if a matching ecms gu relation could not be found
	 */
	public EcmsGURelation fetchByG_U(
		long groupUserId, long userId, boolean useFinderCache);

	/**
	 * Removes the ecms gu relation where groupUserId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the ecms gu relation that was removed
	 */
	public EcmsGURelation removeByG_U(long groupUserId, long userId)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the number of ecms gu relations where groupUserId = &#63; and userId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param userId the user ID
	 * @return the number of matching ecms gu relations
	 */
	public int countByG_U(long groupUserId, long userId);

	/**
	 * Caches the ecms gu relation in the entity cache if it is enabled.
	 *
	 * @param ecmsGURelation the ecms gu relation
	 */
	public void cacheResult(EcmsGURelation ecmsGURelation);

	/**
	 * Caches the ecms gu relations in the entity cache if it is enabled.
	 *
	 * @param ecmsGURelations the ecms gu relations
	 */
	public void cacheResult(java.util.List<EcmsGURelation> ecmsGURelations);

	/**
	 * Creates a new ecms gu relation with the primary key. Does not add the ecms gu relation to the database.
	 *
	 * @param ecmsGURelationPK the primary key for the new ecms gu relation
	 * @return the new ecms gu relation
	 */
	public EcmsGURelation create(EcmsGURelationPK ecmsGURelationPK);

	/**
	 * Removes the ecms gu relation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation that was removed
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public EcmsGURelation remove(EcmsGURelationPK ecmsGURelationPK)
		throws NoSuchEcmsGURelationException;

	public EcmsGURelation updateImpl(EcmsGURelation ecmsGURelation);

	/**
	 * Returns the ecms gu relation with the primary key or throws a <code>NoSuchEcmsGURelationException</code> if it could not be found.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation
	 * @throws NoSuchEcmsGURelationException if a ecms gu relation with the primary key could not be found
	 */
	public EcmsGURelation findByPrimaryKey(EcmsGURelationPK ecmsGURelationPK)
		throws NoSuchEcmsGURelationException;

	/**
	 * Returns the ecms gu relation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ecmsGURelationPK the primary key of the ecms gu relation
	 * @return the ecms gu relation, or <code>null</code> if a ecms gu relation with the primary key could not be found
	 */
	public EcmsGURelation fetchByPrimaryKey(EcmsGURelationPK ecmsGURelationPK);

	/**
	 * Returns all the ecms gu relations.
	 *
	 * @return the ecms gu relations
	 */
	public java.util.List<EcmsGURelation> findAll();

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
	public java.util.List<EcmsGURelation> findAll(int start, int end);

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
	public java.util.List<EcmsGURelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator);

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
	public java.util.List<EcmsGURelation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EcmsGURelation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ecms gu relations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ecms gu relations.
	 *
	 * @return the number of ecms gu relations
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}