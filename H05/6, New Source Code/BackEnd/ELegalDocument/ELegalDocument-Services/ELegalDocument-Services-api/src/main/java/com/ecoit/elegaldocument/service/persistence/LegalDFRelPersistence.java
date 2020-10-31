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

import com.ecoit.elegaldocument.exception.NoSuchLegalDFRelException;
import com.ecoit.elegaldocument.model.LegalDFRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal df rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDFRelUtil
 * @generated
 */
@ProviderType
public interface LegalDFRelPersistence extends BasePersistence<LegalDFRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDFRelUtil} to access the legal df rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal df rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByField(long fieldId);

	/**
	 * Returns a range of all the legal df rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByField(
		long fieldId, int start, int end);

	/**
	 * Returns an ordered range of all the legal df rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByField(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal df rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByField(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	public LegalDFRel findByField_First(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
				orderByComparator)
		throws NoSuchLegalDFRelException;

	/**
	 * Returns the first legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	public LegalDFRel fetchByField_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns the last legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	public LegalDFRel findByField_Last(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
				orderByComparator)
		throws NoSuchLegalDFRelException;

	/**
	 * Returns the last legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	public LegalDFRel fetchByField_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns the legal df rels before and after the current legal df rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalDFRelPK the primary key of the current legal df rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	public LegalDFRel[] findByField_PrevAndNext(
			LegalDFRelPK legalDFRelPK, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
				orderByComparator)
		throws NoSuchLegalDFRelException;

	/**
	 * Removes all the legal df rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public void removeByField(long fieldId);

	/**
	 * Returns the number of legal df rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal df rels
	 */
	public int countByField(long fieldId);

	/**
	 * Returns all the legal df rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByDocId(long docId);

	/**
	 * Returns a range of all the legal df rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByDocId(
		long docId, int start, int end);

	/**
	 * Returns an ordered range of all the legal df rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByDocId(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal df rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal df rels
	 */
	public java.util.List<LegalDFRel> findByDocId(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	public LegalDFRel findByDocId_First(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
				orderByComparator)
		throws NoSuchLegalDFRelException;

	/**
	 * Returns the first legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	public LegalDFRel fetchByDocId_First(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns the last legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel
	 * @throws NoSuchLegalDFRelException if a matching legal df rel could not be found
	 */
	public LegalDFRel findByDocId_Last(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
				orderByComparator)
		throws NoSuchLegalDFRelException;

	/**
	 * Returns the last legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal df rel, or <code>null</code> if a matching legal df rel could not be found
	 */
	public LegalDFRel fetchByDocId_Last(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns the legal df rels before and after the current legal df rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDFRelPK the primary key of the current legal df rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	public LegalDFRel[] findByDocId_PrevAndNext(
			LegalDFRelPK legalDFRelPK, long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
				orderByComparator)
		throws NoSuchLegalDFRelException;

	/**
	 * Removes all the legal df rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeByDocId(long docId);

	/**
	 * Returns the number of legal df rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal df rels
	 */
	public int countByDocId(long docId);

	/**
	 * Caches the legal df rel in the entity cache if it is enabled.
	 *
	 * @param legalDFRel the legal df rel
	 */
	public void cacheResult(LegalDFRel legalDFRel);

	/**
	 * Caches the legal df rels in the entity cache if it is enabled.
	 *
	 * @param legalDFRels the legal df rels
	 */
	public void cacheResult(java.util.List<LegalDFRel> legalDFRels);

	/**
	 * Creates a new legal df rel with the primary key. Does not add the legal df rel to the database.
	 *
	 * @param legalDFRelPK the primary key for the new legal df rel
	 * @return the new legal df rel
	 */
	public LegalDFRel create(LegalDFRelPK legalDFRelPK);

	/**
	 * Removes the legal df rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel that was removed
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	public LegalDFRel remove(LegalDFRelPK legalDFRelPK)
		throws NoSuchLegalDFRelException;

	public LegalDFRel updateImpl(LegalDFRel legalDFRel);

	/**
	 * Returns the legal df rel with the primary key or throws a <code>NoSuchLegalDFRelException</code> if it could not be found.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel
	 * @throws NoSuchLegalDFRelException if a legal df rel with the primary key could not be found
	 */
	public LegalDFRel findByPrimaryKey(LegalDFRelPK legalDFRelPK)
		throws NoSuchLegalDFRelException;

	/**
	 * Returns the legal df rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDFRelPK the primary key of the legal df rel
	 * @return the legal df rel, or <code>null</code> if a legal df rel with the primary key could not be found
	 */
	public LegalDFRel fetchByPrimaryKey(LegalDFRelPK legalDFRelPK);

	/**
	 * Returns all the legal df rels.
	 *
	 * @return the legal df rels
	 */
	public java.util.List<LegalDFRel> findAll();

	/**
	 * Returns a range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @return the range of legal df rels
	 */
	public java.util.List<LegalDFRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal df rels
	 */
	public java.util.List<LegalDFRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal df rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDFRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal df rels
	 * @param end the upper bound of the range of legal df rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal df rels
	 */
	public java.util.List<LegalDFRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDFRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal df rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal df rels.
	 *
	 * @return the number of legal df rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}