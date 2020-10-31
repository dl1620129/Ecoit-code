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

import com.ecoit.elegaldocument.exception.NoSuchLegalFTRelException;
import com.ecoit.elegaldocument.model.LegalFTRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal ft rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalFTRelUtil
 * @generated
 */
@ProviderType
public interface LegalFTRelPersistence extends BasePersistence<LegalFTRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalFTRelUtil} to access the legal ft rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal ft rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByField(long fieldId);

	/**
	 * Returns a range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByField(
		long fieldId, int start, int end);

	/**
	 * Returns an ordered range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByField(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal ft rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByField(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public LegalFTRel findByField_First(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
				orderByComparator)
		throws NoSuchLegalFTRelException;

	/**
	 * Returns the first legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public LegalFTRel fetchByField_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns the last legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public LegalFTRel findByField_Last(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
				orderByComparator)
		throws NoSuchLegalFTRelException;

	/**
	 * Returns the last legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public LegalFTRel fetchByField_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns the legal ft rels before and after the current legal ft rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalFTRelPK the primary key of the current legal ft rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public LegalFTRel[] findByField_PrevAndNext(
			LegalFTRelPK legalFTRelPK, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
				orderByComparator)
		throws NoSuchLegalFTRelException;

	/**
	 * Removes all the legal ft rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public void removeByField(long fieldId);

	/**
	 * Returns the number of legal ft rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal ft rels
	 */
	public int countByField(long fieldId);

	/**
	 * Returns all the legal ft rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByType(long typeId);

	/**
	 * Returns a range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByType(
		long typeId, int start, int end);

	/**
	 * Returns an ordered range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByType(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal ft rels where typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal ft rels
	 */
	public java.util.List<LegalFTRel> findByType(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public LegalFTRel findByType_First(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
				orderByComparator)
		throws NoSuchLegalFTRelException;

	/**
	 * Returns the first legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public LegalFTRel fetchByType_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns the last legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel
	 * @throws NoSuchLegalFTRelException if a matching legal ft rel could not be found
	 */
	public LegalFTRel findByType_Last(
			long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
				orderByComparator)
		throws NoSuchLegalFTRelException;

	/**
	 * Returns the last legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal ft rel, or <code>null</code> if a matching legal ft rel could not be found
	 */
	public LegalFTRel fetchByType_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns the legal ft rels before and after the current legal ft rel in the ordered set where typeId = &#63;.
	 *
	 * @param legalFTRelPK the primary key of the current legal ft rel
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public LegalFTRel[] findByType_PrevAndNext(
			LegalFTRelPK legalFTRelPK, long typeId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
				orderByComparator)
		throws NoSuchLegalFTRelException;

	/**
	 * Removes all the legal ft rels where typeId = &#63; from the database.
	 *
	 * @param typeId the type ID
	 */
	public void removeByType(long typeId);

	/**
	 * Returns the number of legal ft rels where typeId = &#63;.
	 *
	 * @param typeId the type ID
	 * @return the number of matching legal ft rels
	 */
	public int countByType(long typeId);

	/**
	 * Caches the legal ft rel in the entity cache if it is enabled.
	 *
	 * @param legalFTRel the legal ft rel
	 */
	public void cacheResult(LegalFTRel legalFTRel);

	/**
	 * Caches the legal ft rels in the entity cache if it is enabled.
	 *
	 * @param legalFTRels the legal ft rels
	 */
	public void cacheResult(java.util.List<LegalFTRel> legalFTRels);

	/**
	 * Creates a new legal ft rel with the primary key. Does not add the legal ft rel to the database.
	 *
	 * @param legalFTRelPK the primary key for the new legal ft rel
	 * @return the new legal ft rel
	 */
	public LegalFTRel create(LegalFTRelPK legalFTRelPK);

	/**
	 * Removes the legal ft rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel that was removed
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public LegalFTRel remove(LegalFTRelPK legalFTRelPK)
		throws NoSuchLegalFTRelException;

	public LegalFTRel updateImpl(LegalFTRel legalFTRel);

	/**
	 * Returns the legal ft rel with the primary key or throws a <code>NoSuchLegalFTRelException</code> if it could not be found.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel
	 * @throws NoSuchLegalFTRelException if a legal ft rel with the primary key could not be found
	 */
	public LegalFTRel findByPrimaryKey(LegalFTRelPK legalFTRelPK)
		throws NoSuchLegalFTRelException;

	/**
	 * Returns the legal ft rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalFTRelPK the primary key of the legal ft rel
	 * @return the legal ft rel, or <code>null</code> if a legal ft rel with the primary key could not be found
	 */
	public LegalFTRel fetchByPrimaryKey(LegalFTRelPK legalFTRelPK);

	/**
	 * Returns all the legal ft rels.
	 *
	 * @return the legal ft rels
	 */
	public java.util.List<LegalFTRel> findAll();

	/**
	 * Returns a range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @return the range of legal ft rels
	 */
	public java.util.List<LegalFTRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal ft rels
	 */
	public java.util.List<LegalFTRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal ft rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFTRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal ft rels
	 * @param end the upper bound of the range of legal ft rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal ft rels
	 */
	public java.util.List<LegalFTRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFTRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal ft rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal ft rels.
	 *
	 * @return the number of legal ft rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}