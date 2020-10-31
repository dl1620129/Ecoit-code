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

import com.ecoit.elegaldocument.exception.NoSuchLegalDSRelException;
import com.ecoit.elegaldocument.model.LegalDSRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal ds rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDSRelUtil
 * @generated
 */
@ProviderType
public interface LegalDSRelPersistence extends BasePersistence<LegalDSRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDSRelUtil} to access the legal ds rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal ds rels where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findBySigner(long sigId);

	/**
	 * Returns a range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findBySigner(
		long sigId, int start, int end);

	/**
	 * Returns an ordered range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findBySigner(
		long sigId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal ds rels where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findBySigner(
		long sigId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public LegalDSRel findBySigner_First(
			long sigId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
				orderByComparator)
		throws NoSuchLegalDSRelException;

	/**
	 * Returns the first legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public LegalDSRel fetchBySigner_First(
		long sigId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns the last legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public LegalDSRel findBySigner_Last(
			long sigId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
				orderByComparator)
		throws NoSuchLegalDSRelException;

	/**
	 * Returns the last legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public LegalDSRel fetchBySigner_Last(
		long sigId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns the legal ds rels before and after the current legal ds rel in the ordered set where sigId = &#63;.
	 *
	 * @param legalDSRelPK the primary key of the current legal ds rel
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public LegalDSRel[] findBySigner_PrevAndNext(
			LegalDSRelPK legalDSRelPK, long sigId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
				orderByComparator)
		throws NoSuchLegalDSRelException;

	/**
	 * Removes all the legal ds rels where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 */
	public void removeBySigner(long sigId);

	/**
	 * Returns the number of legal ds rels where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching legal ds rels
	 */
	public int countBySigner(long sigId);

	/**
	 * Returns all the legal ds rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findByDoc(long docId);

	/**
	 * Returns a range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findByDoc(long docId, int start, int end);

	/**
	 * Returns an ordered range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findByDoc(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal ds rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ds rels
	 */
	public java.util.List<LegalDSRel> findByDoc(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public LegalDSRel findByDoc_First(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
				orderByComparator)
		throws NoSuchLegalDSRelException;

	/**
	 * Returns the first legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public LegalDSRel fetchByDoc_First(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns the last legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel
	 * @throws NoSuchLegalDSRelException if a matching legal ds rel could not be found
	 */
	public LegalDSRel findByDoc_Last(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
				orderByComparator)
		throws NoSuchLegalDSRelException;

	/**
	 * Returns the last legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ds rel, or <code>null</code> if a matching legal ds rel could not be found
	 */
	public LegalDSRel fetchByDoc_Last(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns the legal ds rels before and after the current legal ds rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDSRelPK the primary key of the current legal ds rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public LegalDSRel[] findByDoc_PrevAndNext(
			LegalDSRelPK legalDSRelPK, long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
				orderByComparator)
		throws NoSuchLegalDSRelException;

	/**
	 * Removes all the legal ds rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeByDoc(long docId);

	/**
	 * Returns the number of legal ds rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal ds rels
	 */
	public int countByDoc(long docId);

	/**
	 * Caches the legal ds rel in the entity cache if it is enabled.
	 *
	 * @param legalDSRel the legal ds rel
	 */
	public void cacheResult(LegalDSRel legalDSRel);

	/**
	 * Caches the legal ds rels in the entity cache if it is enabled.
	 *
	 * @param legalDSRels the legal ds rels
	 */
	public void cacheResult(java.util.List<LegalDSRel> legalDSRels);

	/**
	 * Creates a new legal ds rel with the primary key. Does not add the legal ds rel to the database.
	 *
	 * @param legalDSRelPK the primary key for the new legal ds rel
	 * @return the new legal ds rel
	 */
	public LegalDSRel create(LegalDSRelPK legalDSRelPK);

	/**
	 * Removes the legal ds rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel that was removed
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public LegalDSRel remove(LegalDSRelPK legalDSRelPK)
		throws NoSuchLegalDSRelException;

	public LegalDSRel updateImpl(LegalDSRel legalDSRel);

	/**
	 * Returns the legal ds rel with the primary key or throws a <code>NoSuchLegalDSRelException</code> if it could not be found.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel
	 * @throws NoSuchLegalDSRelException if a legal ds rel with the primary key could not be found
	 */
	public LegalDSRel findByPrimaryKey(LegalDSRelPK legalDSRelPK)
		throws NoSuchLegalDSRelException;

	/**
	 * Returns the legal ds rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDSRelPK the primary key of the legal ds rel
	 * @return the legal ds rel, or <code>null</code> if a legal ds rel with the primary key could not be found
	 */
	public LegalDSRel fetchByPrimaryKey(LegalDSRelPK legalDSRelPK);

	/**
	 * Returns all the legal ds rels.
	 *
	 * @return the legal ds rels
	 */
	public java.util.List<LegalDSRel> findAll();

	/**
	 * Returns a range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @return the range of legal ds rels
	 */
	public java.util.List<LegalDSRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal ds rels
	 */
	public java.util.List<LegalDSRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal ds rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDSRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ds rels
	 * @param end the upper bound of the range of legal ds rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal ds rels
	 */
	public java.util.List<LegalDSRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDSRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal ds rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal ds rels.
	 *
	 * @return the number of legal ds rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}