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

import com.ecoit.elegaldocument.exception.NoSuchLegalTDRelException;
import com.ecoit.elegaldocument.model.LegalTDRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal td rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalTDRelUtil
 * @generated
 */
@ProviderType
public interface LegalTDRelPersistence extends BasePersistence<LegalTDRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalTDRelUtil} to access the legal td rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal td rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByDocument(long docId);

	/**
	 * Returns a range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByDocument(
		long docId, int start, int end);

	/**
	 * Returns an ordered range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByDocument(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal td rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByDocument(
		long docId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public LegalTDRel findByDocument_First(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
				orderByComparator)
		throws NoSuchLegalTDRelException;

	/**
	 * Returns the first legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public LegalTDRel fetchByDocument_First(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns the last legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public LegalTDRel findByDocument_Last(
			long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
				orderByComparator)
		throws NoSuchLegalTDRelException;

	/**
	 * Returns the last legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public LegalTDRel fetchByDocument_Last(
		long docId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns the legal td rels before and after the current legal td rel in the ordered set where docId = &#63;.
	 *
	 * @param legalTDRelPK the primary key of the current legal td rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public LegalTDRel[] findByDocument_PrevAndNext(
			LegalTDRelPK legalTDRelPK, long docId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
				orderByComparator)
		throws NoSuchLegalTDRelException;

	/**
	 * Removes all the legal td rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 */
	public void removeByDocument(long docId);

	/**
	 * Returns the number of legal td rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching legal td rels
	 */
	public int countByDocument(long docId);

	/**
	 * Returns all the legal td rels where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByTag(long tagId);

	/**
	 * Returns a range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByTag(long tagId, int start, int end);

	/**
	 * Returns an ordered range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByTag(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal td rels where tagId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param tagId the tag ID
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal td rels
	 */
	public java.util.List<LegalTDRel> findByTag(
		long tagId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public LegalTDRel findByTag_First(
			long tagId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
				orderByComparator)
		throws NoSuchLegalTDRelException;

	/**
	 * Returns the first legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public LegalTDRel fetchByTag_First(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns the last legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel
	 * @throws NoSuchLegalTDRelException if a matching legal td rel could not be found
	 */
	public LegalTDRel findByTag_Last(
			long tagId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
				orderByComparator)
		throws NoSuchLegalTDRelException;

	/**
	 * Returns the last legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal td rel, or <code>null</code> if a matching legal td rel could not be found
	 */
	public LegalTDRel fetchByTag_Last(
		long tagId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns the legal td rels before and after the current legal td rel in the ordered set where tagId = &#63;.
	 *
	 * @param legalTDRelPK the primary key of the current legal td rel
	 * @param tagId the tag ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public LegalTDRel[] findByTag_PrevAndNext(
			LegalTDRelPK legalTDRelPK, long tagId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
				orderByComparator)
		throws NoSuchLegalTDRelException;

	/**
	 * Removes all the legal td rels where tagId = &#63; from the database.
	 *
	 * @param tagId the tag ID
	 */
	public void removeByTag(long tagId);

	/**
	 * Returns the number of legal td rels where tagId = &#63;.
	 *
	 * @param tagId the tag ID
	 * @return the number of matching legal td rels
	 */
	public int countByTag(long tagId);

	/**
	 * Caches the legal td rel in the entity cache if it is enabled.
	 *
	 * @param legalTDRel the legal td rel
	 */
	public void cacheResult(LegalTDRel legalTDRel);

	/**
	 * Caches the legal td rels in the entity cache if it is enabled.
	 *
	 * @param legalTDRels the legal td rels
	 */
	public void cacheResult(java.util.List<LegalTDRel> legalTDRels);

	/**
	 * Creates a new legal td rel with the primary key. Does not add the legal td rel to the database.
	 *
	 * @param legalTDRelPK the primary key for the new legal td rel
	 * @return the new legal td rel
	 */
	public LegalTDRel create(LegalTDRelPK legalTDRelPK);

	/**
	 * Removes the legal td rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel that was removed
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public LegalTDRel remove(LegalTDRelPK legalTDRelPK)
		throws NoSuchLegalTDRelException;

	public LegalTDRel updateImpl(LegalTDRel legalTDRel);

	/**
	 * Returns the legal td rel with the primary key or throws a <code>NoSuchLegalTDRelException</code> if it could not be found.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel
	 * @throws NoSuchLegalTDRelException if a legal td rel with the primary key could not be found
	 */
	public LegalTDRel findByPrimaryKey(LegalTDRelPK legalTDRelPK)
		throws NoSuchLegalTDRelException;

	/**
	 * Returns the legal td rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalTDRelPK the primary key of the legal td rel
	 * @return the legal td rel, or <code>null</code> if a legal td rel with the primary key could not be found
	 */
	public LegalTDRel fetchByPrimaryKey(LegalTDRelPK legalTDRelPK);

	/**
	 * Returns all the legal td rels.
	 *
	 * @return the legal td rels
	 */
	public java.util.List<LegalTDRel> findAll();

	/**
	 * Returns a range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @return the range of legal td rels
	 */
	public java.util.List<LegalTDRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal td rels
	 */
	public java.util.List<LegalTDRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal td rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalTDRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal td rels
	 * @param end the upper bound of the range of legal td rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal td rels
	 */
	public java.util.List<LegalTDRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalTDRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal td rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal td rels.
	 *
	 * @return the number of legal td rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}