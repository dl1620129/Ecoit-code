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

import com.ecoit.elegaldocument.exception.NoSuchLegalFoRelException;
import com.ecoit.elegaldocument.model.LegalFoRel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the legal fo rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @see LegalFoRelUtil
 * @generated
 */
@ProviderType
public interface LegalFoRelPersistence extends BasePersistence<LegalFoRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LegalFoRelUtil} to access the legal fo rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the legal fo rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByField(long fieldId);

	/**
	 * Returns a range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByField(
		long fieldId, int start, int end);

	/**
	 * Returns an ordered range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByField(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal fo rels where fieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param fieldId the field ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByField(
		long fieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public LegalFoRel findByField_First(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
				orderByComparator)
		throws NoSuchLegalFoRelException;

	/**
	 * Returns the first legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public LegalFoRel fetchByField_First(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns the last legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public LegalFoRel findByField_Last(
			long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
				orderByComparator)
		throws NoSuchLegalFoRelException;

	/**
	 * Returns the last legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public LegalFoRel fetchByField_Last(
		long fieldId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns the legal fo rels before and after the current legal fo rel in the ordered set where fieldId = &#63;.
	 *
	 * @param legalFoRelPK the primary key of the current legal fo rel
	 * @param fieldId the field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public LegalFoRel[] findByField_PrevAndNext(
			LegalFoRelPK legalFoRelPK, long fieldId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
				orderByComparator)
		throws NoSuchLegalFoRelException;

	/**
	 * Removes all the legal fo rels where fieldId = &#63; from the database.
	 *
	 * @param fieldId the field ID
	 */
	public void removeByField(long fieldId);

	/**
	 * Returns the number of legal fo rels where fieldId = &#63;.
	 *
	 * @param fieldId the field ID
	 * @return the number of matching legal fo rels
	 */
	public int countByField(long fieldId);

	/**
	 * Returns all the legal fo rels where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByOrg(long organizationId);

	/**
	 * Returns a range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByOrg(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByOrg(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal fo rels where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching legal fo rels
	 */
	public java.util.List<LegalFoRel> findByOrg(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public LegalFoRel findByOrg_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
				orderByComparator)
		throws NoSuchLegalFoRelException;

	/**
	 * Returns the first legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public LegalFoRel fetchByOrg_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns the last legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel
	 * @throws NoSuchLegalFoRelException if a matching legal fo rel could not be found
	 */
	public LegalFoRel findByOrg_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
				orderByComparator)
		throws NoSuchLegalFoRelException;

	/**
	 * Returns the last legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching legal fo rel, or <code>null</code> if a matching legal fo rel could not be found
	 */
	public LegalFoRel fetchByOrg_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns the legal fo rels before and after the current legal fo rel in the ordered set where organizationId = &#63;.
	 *
	 * @param legalFoRelPK the primary key of the current legal fo rel
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public LegalFoRel[] findByOrg_PrevAndNext(
			LegalFoRelPK legalFoRelPK, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
				orderByComparator)
		throws NoSuchLegalFoRelException;

	/**
	 * Removes all the legal fo rels where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrg(long organizationId);

	/**
	 * Returns the number of legal fo rels where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching legal fo rels
	 */
	public int countByOrg(long organizationId);

	/**
	 * Caches the legal fo rel in the entity cache if it is enabled.
	 *
	 * @param legalFoRel the legal fo rel
	 */
	public void cacheResult(LegalFoRel legalFoRel);

	/**
	 * Caches the legal fo rels in the entity cache if it is enabled.
	 *
	 * @param legalFoRels the legal fo rels
	 */
	public void cacheResult(java.util.List<LegalFoRel> legalFoRels);

	/**
	 * Creates a new legal fo rel with the primary key. Does not add the legal fo rel to the database.
	 *
	 * @param legalFoRelPK the primary key for the new legal fo rel
	 * @return the new legal fo rel
	 */
	public LegalFoRel create(LegalFoRelPK legalFoRelPK);

	/**
	 * Removes the legal fo rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel that was removed
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public LegalFoRel remove(LegalFoRelPK legalFoRelPK)
		throws NoSuchLegalFoRelException;

	public LegalFoRel updateImpl(LegalFoRel legalFoRel);

	/**
	 * Returns the legal fo rel with the primary key or throws a <code>NoSuchLegalFoRelException</code> if it could not be found.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel
	 * @throws NoSuchLegalFoRelException if a legal fo rel with the primary key could not be found
	 */
	public LegalFoRel findByPrimaryKey(LegalFoRelPK legalFoRelPK)
		throws NoSuchLegalFoRelException;

	/**
	 * Returns the legal fo rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param legalFoRelPK the primary key of the legal fo rel
	 * @return the legal fo rel, or <code>null</code> if a legal fo rel with the primary key could not be found
	 */
	public LegalFoRel fetchByPrimaryKey(LegalFoRelPK legalFoRelPK);

	/**
	 * Returns all the legal fo rels.
	 *
	 * @return the legal fo rels
	 */
	public java.util.List<LegalFoRel> findAll();

	/**
	 * Returns a range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @return the range of legal fo rels
	 */
	public java.util.List<LegalFoRel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of legal fo rels
	 */
	public java.util.List<LegalFoRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the legal fo rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LegalFoRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of legal fo rels
	 * @param end the upper bound of the range of legal fo rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of legal fo rels
	 */
	public java.util.List<LegalFoRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LegalFoRel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the legal fo rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of legal fo rels.
	 *
	 * @return the number of legal fo rels
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}