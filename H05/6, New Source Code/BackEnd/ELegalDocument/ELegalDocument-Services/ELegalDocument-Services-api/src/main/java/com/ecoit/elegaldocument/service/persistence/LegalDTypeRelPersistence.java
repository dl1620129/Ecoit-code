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

import com.ecoit.elegaldocument.exception.NoSuchLegalDTypeRelException;
import com.ecoit.elegaldocument.model.LegalDTypeRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal d type rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalDTypeRelUtil
 * @generated
 */
@ProviderType
public interface LegalDTypeRelPersistence
	extends BasePersistence<LegalDTypeRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalDTypeRelUtil} to access the legal d type rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal d type rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByType(long typeId);

	/**
	 * Returns a range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByType(
		long typeId, int start, int end);

	/**
	 * Returns an ordered range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByType(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal d type rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByType(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel findByType_First(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
				orderByComparator)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the first legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel fetchByType_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns the last legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel findByType_Last(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
				orderByComparator)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the last legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel fetchByType_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns the legal d type rels before and after the current legal d type rel in the ordered set where typeId = &#63;.
	 *
	 * @param legalDTypeRelPK the primary key of the current legal d type rel
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public LegalDTypeRel[] findByType_PrevAndNext(
			LegalDTypeRelPK legalDTypeRelPK, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
				orderByComparator)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Removes all the legal d type rels where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public void removeByType(long typeId);

	/**
	 * Returns the number of legal d type rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal d type rels
	 */
	public int countByType(long typeId);

	/**
	 * Returns all the legal d type rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByDoc(long docId);

	/**
	 * Returns a range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByDoc(
		long docId, int start, int end);

	/**
	 * Returns an ordered range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByDoc(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal d type rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findByDoc(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel findByDoc_First(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
				orderByComparator)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the first legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel fetchByDoc_First(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns the last legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel findByDoc_Last(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
				orderByComparator)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the last legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel fetchByDoc_Last(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns the legal d type rels before and after the current legal d type rel in the ordered set where docId = &#63;.
	 *
	 * @param legalDTypeRelPK the primary key of the current legal d type rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public LegalDTypeRel[] findByDoc_PrevAndNext(
			LegalDTypeRelPK legalDTypeRelPK, long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
				orderByComparator)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Removes all the legal d type rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeByDoc(long docId);

	/**
	 * Returns the number of legal d type rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal d type rels
	 */
	public int countByDoc(long docId);

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or throws a <code>NoSuchLegalDTypeRelException</code> if it could not be found.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the matching legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel findByDocType(long typeId, long docId)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel fetchByDocType(long typeId, long docId);

	/**
	 * Returns the legal d type rel where typeId = &#63; and docId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching legal d type rel, or <code>null</code> if a matching legal d type rel could not be found
	 */
	public LegalDTypeRel fetchByDocType(
		long typeId, long docId, boolean useFinderCache);

	/**
	 * Removes the legal d type rel where typeId = &#63; and docId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the legal d type rel that was removed
	 */
	public LegalDTypeRel removeByDocType(long typeId, long docId)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the number of legal d type rels where typeId = &#63; and docId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param docId the doc ID
	 * @return the number of matching legal d type rels
	 */
	public int countByDocType(long typeId, long docId);

	/**
	 * Caches the legal d type rel in the entity cache if it is enabled.
	 *
	 * @param legalDTypeRel the legal d type rel
	 */
	public void cacheResult(LegalDTypeRel legalDTypeRel);

	/**
	 * Caches the legal d type rels in the entity cache if it is enabled.
	 *
	 * @param legalDTypeRels the legal d type rels
	 */
	public void cacheResult(java.util.List<LegalDTypeRel> legalDTypeRels);

	/**
	 * Creates a new legal d type rel with the primary key. Does not add the legal d type rel to the database.
	 *
	 * @param legalDTypeRelPK the primary key for the new legal d type rel
	 * @return the new legal d type rel
	 */
	public LegalDTypeRel create(LegalDTypeRelPK legalDTypeRelPK);

	/**
	 * Removes the legal d type rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel that was removed
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public LegalDTypeRel remove(LegalDTypeRelPK legalDTypeRelPK)
		throws NoSuchLegalDTypeRelException;

	public LegalDTypeRel updateImpl(LegalDTypeRel legalDTypeRel);

	/**
	 * Returns the legal d type rel with the primary key or throws a <code>NoSuchLegalDTypeRelException</code> if it could not be found.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel
	 * @throws NoSuchLegalDTypeRelException if a legal d type rel with the primary key could not be found
	 */
	public LegalDTypeRel findByPrimaryKey(LegalDTypeRelPK legalDTypeRelPK)
		throws NoSuchLegalDTypeRelException;

	/**
	 * Returns the legal d type rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalDTypeRelPK the primary key of the legal d type rel
	 * @return the legal d type rel, or <code>null</code> if a legal d type rel with the primary key could not be found
	 */
	public LegalDTypeRel fetchByPrimaryKey(LegalDTypeRelPK legalDTypeRelPK);

	/**
	 * Returns all the legal d type rels.
	 *
	 * @return the legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findAll();

	/**
	 * Returns a range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @return the range of legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal d type rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalDTypeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal d type rels
	 * @param end the upper bound of the range of legal d type rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal d type rels
	 */
	public java.util.List<LegalDTypeRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalDTypeRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal d type rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal d type rels.
	 *
	 * @return the number of legal d type rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}