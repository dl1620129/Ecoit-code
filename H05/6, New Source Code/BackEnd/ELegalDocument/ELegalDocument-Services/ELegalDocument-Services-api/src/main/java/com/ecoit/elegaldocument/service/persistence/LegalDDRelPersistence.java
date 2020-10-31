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

import com.ecoit.elegaldocument.exception.NoSuchLegalDDRelException;
import com.ecoit.elegaldocument.model.LegalDDRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal dd rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDDRelUtil
 * @generated
 */
@ProviderType
public interface LegalDDRelPersistence extends BasePersistence<LegalDDRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDDRelUtil} to access the legal dd rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal dd rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDepartament(long departmentId);

	/**
	 * Returns a range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end);

	/**
	 * Returns an ordered range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal dd rels where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDepartament(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public LegalDDRel findByDepartament_First(
			long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
				orderByComparator)
		throws NoSuchLegalDDRelException;

	/**
	 * Returns the first legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public LegalDDRel fetchByDepartament_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns the last legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public LegalDDRel findByDepartament_Last(
			long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
				orderByComparator)
		throws NoSuchLegalDDRelException;

	/**
	 * Returns the last legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public LegalDDRel fetchByDepartament_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns the legal dd rels before and after the current legal dd rel in the ordered set where departmentId = &#63;.
	 *
	 * @param legalDDRelPK the primary key of the current legal dd rel
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public LegalDDRel[] findByDepartament_PrevAndNext(
			LegalDDRelPK legalDDRelPK, long departmentId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
				orderByComparator)
		throws NoSuchLegalDDRelException;

	/**
	 * Removes all the legal dd rels where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 */
	public void removeByDepartament(long departmentId);

	/**
	 * Returns the number of legal dd rels where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching legal dd rels
	 */
	public int countByDepartament(long departmentId);

	/**
	 * Returns all the legal dd rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDoc(String docId);

	/**
	 * Returns a range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDoc(
		String docId, int start, int end);

	/**
	 * Returns an ordered range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDoc(
		String docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal dd rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal dd rels
	 */
	public java.util.List<LegalDDRel> findByDoc(
		String docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public LegalDDRel findByDoc_First(
			String docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
				orderByComparator)
		throws NoSuchLegalDDRelException;

	/**
	 * Returns the first legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public LegalDDRel fetchByDoc_First(
		String docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns the last legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel
	 * @throws NoSuchLegalDDRelException if a matching legal dd rel could not be found
	 */
	public LegalDDRel findByDoc_Last(
			String docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
				orderByComparator)
		throws NoSuchLegalDDRelException;

	/**
	 * Returns the last legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal dd rel, or <code>null</code> if a matching legal dd rel could not be found
	 */
	public LegalDDRel fetchByDoc_Last(
		String docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns the legal dd rels before and after the current legal dd rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDDRelPK the primary key of the current legal dd rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public LegalDDRel[] findByDoc_PrevAndNext(
			LegalDDRelPK legalDDRelPK, String docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
				orderByComparator)
		throws NoSuchLegalDDRelException;

	/**
	 * Removes all the legal dd rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeByDoc(String docId);

	/**
	 * Returns the number of legal dd rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal dd rels
	 */
	public int countByDoc(String docId);

	/**
	 * Caches the legal dd rel in the entity cache if it is enabled.
	 *
	 * @param legalDDRel the legal dd rel
	 */
	public void cacheResult(LegalDDRel legalDDRel);

	/**
	 * Caches the legal dd rels in the entity cache if it is enabled.
	 *
	 * @param legalDDRels the legal dd rels
	 */
	public void cacheResult(java.util.List<LegalDDRel> legalDDRels);

	/**
	 * Creates a new legal dd rel with the primary key. Does not add the legal dd rel to the database.
	 *
	 * @param legalDDRelPK the primary key for the new legal dd rel
	 * @return the new legal dd rel
	 */
	public LegalDDRel create(LegalDDRelPK legalDDRelPK);

	/**
	 * Removes the legal dd rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel that was removed
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public LegalDDRel remove(LegalDDRelPK legalDDRelPK)
		throws NoSuchLegalDDRelException;

	public LegalDDRel updateImpl(LegalDDRel legalDDRel);

	/**
	 * Returns the legal dd rel with the primary key or throws a <code>NoSuchLegalDDRelException</code> if it could not be found.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel
	 * @throws NoSuchLegalDDRelException if a legal dd rel with the primary key could not be found
	 */
	public LegalDDRel findByPrimaryKey(LegalDDRelPK legalDDRelPK)
		throws NoSuchLegalDDRelException;

	/**
	 * Returns the legal dd rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDDRelPK the primary key of the legal dd rel
	 * @return the legal dd rel, or <code>null</code> if a legal dd rel with the primary key could not be found
	 */
	public LegalDDRel fetchByPrimaryKey(LegalDDRelPK legalDDRelPK);

	/**
	 * Returns all the legal dd rels.
	 *
	 * @return the legal dd rels
	 */
	public java.util.List<LegalDDRel> findAll();

	/**
	 * Returns a range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @return the range of legal dd rels
	 */
	public java.util.List<LegalDDRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal dd rels
	 */
	public java.util.List<LegalDDRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal dd rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal dd rels
	 * @param end the upper bound of the range of legal dd rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal dd rels
	 */
	public java.util.List<LegalDDRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDDRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal dd rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal dd rels.
	 *
	 * @return the number of legal dd rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}