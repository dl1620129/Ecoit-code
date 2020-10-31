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

import com.ecoit.elegaldocument.exception.NoSuchLegalDURelException;
import com.ecoit.elegaldocument.model.LegalDURel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal du rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDURelUtil
 * @generated
 */
@ProviderType
public interface LegalDURelPersistence extends BasePersistence<LegalDURel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDURelUtil} to access the legal du rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal du rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching legal du rels
	 */
	public java.util.List<LegalDURel> findByDepartament(long departmentId);

	/**
	 * Returns a range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of matching legal du rels
	 */
	public java.util.List<LegalDURel> findByDepartament(
		long departmentId, int start, int end);

	/**
	 * Returns an ordered range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal du rels
	 */
	public java.util.List<LegalDURel> findByDepartament(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal du rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal du rels
	 */
	public java.util.List<LegalDURel> findByDepartament(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public LegalDURel findByDepartament_First(
			long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
				orderByComparator)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the first legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public LegalDURel fetchByDepartament_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns the last legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public LegalDURel findByDepartament_Last(
			long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
				orderByComparator)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the last legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public LegalDURel fetchByDepartament_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns the legal du rels before and after the current legal du rel in the ordered set where departmentId = &#63;.
	 *
	 * @param legalDURelPK the primary key of the current legal du rel
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public LegalDURel[] findByDepartament_PrevAndNext(
			LegalDURelPK legalDURelPK, long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
				orderByComparator)
		throws NoSuchLegalDURelException;

	/**
	 * Removes all the legal du rels where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	public void removeByDepartament(long departmentId);

	/**
	 * Returns the number of legal du rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching legal du rels
	 */
	public int countByDepartament(long departmentId);

	/**
	 * Returns all the legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the matching legal du rels
	 */
	public java.util.List<LegalDURel> findByUser(long userid);

	/**
	 * Returns a range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of matching legal du rels
	 */
	public java.util.List<LegalDURel> findByUser(
		long userid, int start, int end);

	/**
	 * Returns an ordered range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal du rels
	 */
	public java.util.List<LegalDURel> findByUser(
		long userid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal du rels where userid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param userid the userid
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal du rels
	 */
	public java.util.List<LegalDURel> findByUser(
		long userid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public LegalDURel findByUser_First(
			long userid,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
				orderByComparator)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the first legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public LegalDURel fetchByUser_First(
		long userid,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns the last legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public LegalDURel findByUser_Last(
			long userid,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
				orderByComparator)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the last legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public LegalDURel fetchByUser_Last(
		long userid,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns the legal du rels before and after the current legal du rel in the ordered set where userid = &#63;.
	 *
	 * @param legalDURelPK the primary key of the current legal du rel
	 * @param userid the userid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public LegalDURel[] findByUser_PrevAndNext(
			LegalDURelPK legalDURelPK, long userid,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
				orderByComparator)
		throws NoSuchLegalDURelException;

	/**
	 * Removes all the legal du rels where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 */
	public void removeByUser(long userid);

	/**
	 * Returns the number of legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching legal du rels
	 */
	public int countByUser(long userid);

	/**
	 * Returns the legal du rel where userid = &#63; or throws a <code>NoSuchLegalDURelException</code> if it could not be found.
	 *
	 * @param userid the userid
	 * @return the matching legal du rel
	 * @throws NoSuchLegalDURelException if a matching legal du rel could not be found
	 */
	public LegalDURel findByUserId(long userid)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the legal du rel where userid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userid the userid
	 * @return the matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public LegalDURel fetchByUserId(long userid);

	/**
	 * Returns the legal du rel where userid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userid the userid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal du rel, or <code>null</code> if a matching legal du rel could not be found
	 */
	public LegalDURel fetchByUserId(long userid, boolean useFinderCache);

	/**
	 * Removes the legal du rel where userid = &#63; from the database.
	 *
	 * @param userid the userid
	 * @return the legal du rel that was removed
	 */
	public LegalDURel removeByUserId(long userid)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the number of legal du rels where userid = &#63;.
	 *
	 * @param userid the userid
	 * @return the number of matching legal du rels
	 */
	public int countByUserId(long userid);

	/**
	 * Caches the legal du rel in the entity cache if it is enabled.
	 *
	 * @param legalDURel the legal du rel
	 */
	public void cacheResult(LegalDURel legalDURel);

	/**
	 * Caches the legal du rels in the entity cache if it is enabled.
	 *
	 * @param legalDURels the legal du rels
	 */
	public void cacheResult(java.util.List<LegalDURel> legalDURels);

	/**
	 * Creates a new legal du rel with the primary key. Does not add the legal du rel to the database.
	 *
	 * @param legalDURelPK the primary key for the new legal du rel
	 * @return the new legal du rel
	 */
	public LegalDURel create(LegalDURelPK legalDURelPK);

	/**
	 * Removes the legal du rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel that was removed
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public LegalDURel remove(LegalDURelPK legalDURelPK)
		throws NoSuchLegalDURelException;

	public LegalDURel updateImpl(LegalDURel legalDURel);

	/**
	 * Returns the legal du rel with the primary key or throws a <code>NoSuchLegalDURelException</code> if it could not be found.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel
	 * @throws NoSuchLegalDURelException if a legal du rel with the primary key could not be found
	 */
	public LegalDURel findByPrimaryKey(LegalDURelPK legalDURelPK)
		throws NoSuchLegalDURelException;

	/**
	 * Returns the legal du rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDURelPK the primary key of the legal du rel
	 * @return the legal du rel, or <code>null</code> if a legal du rel with the primary key could not be found
	 */
	public LegalDURel fetchByPrimaryKey(LegalDURelPK legalDURelPK);

	/**
	 * Returns all the legal du rels.
	 *
	 * @return the legal du rels
	 */
	public java.util.List<LegalDURel> findAll();

	/**
	 * Returns a range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @return the range of legal du rels
	 */
	public java.util.List<LegalDURel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal du rels
	 */
	public java.util.List<LegalDURel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal du rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDURelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal du rels
	 * @param end the upper bound of the range of legal du rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal du rels
	 */
	public java.util.List<LegalDURel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDURel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal du rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal du rels.
	 *
	 * @return the number of legal du rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}