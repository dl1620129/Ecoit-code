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

package com.ecoit.lichcongtac.services.service.persistence;

import com.ecoit.lichcongtac.services.exception.NoSuchLichCongTacException;
import com.ecoit.lichcongtac.services.model.LichCongTac;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lich cong tac service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichCongTacUtil
 * @generated
 */
@ProviderType
public interface LichCongTacPersistence extends BasePersistence<LichCongTac> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichCongTacUtil} to access the lich cong tac persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; or throws a <code>NoSuchLichCongTacException</code> if it could not be found.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich cong tac
	 * @throws NoSuchLichCongTacException if a matching lich cong tac could not be found
	 */
	public LichCongTac findBystatusAndId(
			int trangthaiLichCongTac, long lichCongTacId)
		throws NoSuchLichCongTacException;

	/**
	 * Returns the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	public LichCongTac fetchBystatusAndId(
		int trangthaiLichCongTac, long lichCongTacId);

	/**
	 * Returns the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	public LichCongTac fetchBystatusAndId(
		int trangthaiLichCongTac, long lichCongTacId, boolean useFinderCache);

	/**
	 * Removes the lich cong tac where trangthaiLichCongTac = &#63; and lichCongTacId = &#63; from the database.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the lich cong tac that was removed
	 */
	public LichCongTac removeBystatusAndId(
			int trangthaiLichCongTac, long lichCongTacId)
		throws NoSuchLichCongTacException;

	/**
	 * Returns the number of lich cong tacs where trangthaiLichCongTac = &#63; and lichCongTacId = &#63;.
	 *
	 * @param trangthaiLichCongTac the trangthai lich cong tac
	 * @param lichCongTacId the lich cong tac ID
	 * @return the number of matching lich cong tacs
	 */
	public int countBystatusAndId(int trangthaiLichCongTac, long lichCongTacId);

	/**
	 * Returns all the lich cong tacs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching lich cong tacs
	 */
	public java.util.List<LichCongTac> findByorganization(long organizationId);

	/**
	 * Returns a range of all the lich cong tacs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of matching lich cong tacs
	 */
	public java.util.List<LichCongTac> findByorganization(
		long organizationId, int start, int end);

	/**
	 * Returns an ordered range of all the lich cong tacs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich cong tacs
	 */
	public java.util.List<LichCongTac> findByorganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich cong tacs where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lich cong tacs
	 */
	public java.util.List<LichCongTac> findByorganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich cong tac
	 * @throws NoSuchLichCongTacException if a matching lich cong tac could not be found
	 */
	public LichCongTac findByorganization_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
				orderByComparator)
		throws NoSuchLichCongTacException;

	/**
	 * Returns the first lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	public LichCongTac fetchByorganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
			orderByComparator);

	/**
	 * Returns the last lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich cong tac
	 * @throws NoSuchLichCongTacException if a matching lich cong tac could not be found
	 */
	public LichCongTac findByorganization_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
				orderByComparator)
		throws NoSuchLichCongTacException;

	/**
	 * Returns the last lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich cong tac, or <code>null</code> if a matching lich cong tac could not be found
	 */
	public LichCongTac fetchByorganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
			orderByComparator);

	/**
	 * Returns the lich cong tacs before and after the current lich cong tac in the ordered set where organizationId = &#63;.
	 *
	 * @param lichCongTacId the primary key of the current lich cong tac
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich cong tac
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	public LichCongTac[] findByorganization_PrevAndNext(
			long lichCongTacId, long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
				orderByComparator)
		throws NoSuchLichCongTacException;

	/**
	 * Removes all the lich cong tacs where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByorganization(long organizationId);

	/**
	 * Returns the number of lich cong tacs where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching lich cong tacs
	 */
	public int countByorganization(long organizationId);

	/**
	 * Caches the lich cong tac in the entity cache if it is enabled.
	 *
	 * @param lichCongTac the lich cong tac
	 */
	public void cacheResult(LichCongTac lichCongTac);

	/**
	 * Caches the lich cong tacs in the entity cache if it is enabled.
	 *
	 * @param lichCongTacs the lich cong tacs
	 */
	public void cacheResult(java.util.List<LichCongTac> lichCongTacs);

	/**
	 * Creates a new lich cong tac with the primary key. Does not add the lich cong tac to the database.
	 *
	 * @param lichCongTacId the primary key for the new lich cong tac
	 * @return the new lich cong tac
	 */
	public LichCongTac create(long lichCongTacId);

	/**
	 * Removes the lich cong tac with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac that was removed
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	public LichCongTac remove(long lichCongTacId)
		throws NoSuchLichCongTacException;

	public LichCongTac updateImpl(LichCongTac lichCongTac);

	/**
	 * Returns the lich cong tac with the primary key or throws a <code>NoSuchLichCongTacException</code> if it could not be found.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac
	 * @throws NoSuchLichCongTacException if a lich cong tac with the primary key could not be found
	 */
	public LichCongTac findByPrimaryKey(long lichCongTacId)
		throws NoSuchLichCongTacException;

	/**
	 * Returns the lich cong tac with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongTacId the primary key of the lich cong tac
	 * @return the lich cong tac, or <code>null</code> if a lich cong tac with the primary key could not be found
	 */
	public LichCongTac fetchByPrimaryKey(long lichCongTacId);

	/**
	 * Returns all the lich cong tacs.
	 *
	 * @return the lich cong tacs
	 */
	public java.util.List<LichCongTac> findAll();

	/**
	 * Returns a range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @return the range of lich cong tacs
	 */
	public java.util.List<LichCongTac> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich cong tacs
	 */
	public java.util.List<LichCongTac> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich cong tacs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichCongTacModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich cong tacs
	 * @param end the upper bound of the range of lich cong tacs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lich cong tacs
	 */
	public java.util.List<LichCongTac> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichCongTac>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lich cong tacs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lich cong tacs.
	 *
	 * @return the number of lich cong tacs
	 */
	public int countAll();

}