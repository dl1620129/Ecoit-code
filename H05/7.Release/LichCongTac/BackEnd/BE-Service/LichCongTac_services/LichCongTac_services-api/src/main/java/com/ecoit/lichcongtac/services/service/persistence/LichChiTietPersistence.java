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

import com.ecoit.lichcongtac.services.exception.NoSuchLichChiTietException;
import com.ecoit.lichcongtac.services.model.LichChiTiet;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lich chi tiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietUtil
 * @generated
 */
@ProviderType
public interface LichChiTietPersistence extends BasePersistence<LichChiTiet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichChiTietUtil} to access the lich chi tiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @return the matching lich chi tiets
	 */
	public java.util.List<LichChiTiet> findByLichCongTacId(long lichCongTacId);

	/**
	 * Returns a range of all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of matching lich chi tiets
	 */
	public java.util.List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end);

	/**
	 * Returns an ordered range of all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lich chi tiets
	 */
	public java.util.List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich chi tiets where lichCongTacId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lich chi tiets
	 */
	public java.util.List<LichChiTiet> findByLichCongTacId(
		long lichCongTacId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich chi tiet
	 * @throws NoSuchLichChiTietException if a matching lich chi tiet could not be found
	 */
	public LichChiTiet findByLichCongTacId_First(
			long lichCongTacId,
			com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
				orderByComparator)
		throws NoSuchLichChiTietException;

	/**
	 * Returns the first lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lich chi tiet, or <code>null</code> if a matching lich chi tiet could not be found
	 */
	public LichChiTiet fetchByLichCongTacId_First(
		long lichCongTacId,
		com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
			orderByComparator);

	/**
	 * Returns the last lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich chi tiet
	 * @throws NoSuchLichChiTietException if a matching lich chi tiet could not be found
	 */
	public LichChiTiet findByLichCongTacId_Last(
			long lichCongTacId,
			com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
				orderByComparator)
		throws NoSuchLichChiTietException;

	/**
	 * Returns the last lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lich chi tiet, or <code>null</code> if a matching lich chi tiet could not be found
	 */
	public LichChiTiet fetchByLichCongTacId_Last(
		long lichCongTacId,
		com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
			orderByComparator);

	/**
	 * Returns the lich chi tiets before and after the current lich chi tiet in the ordered set where lichCongTacId = &#63;.
	 *
	 * @param lichChiTietId the primary key of the current lich chi tiet
	 * @param lichCongTacId the lich cong tac ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lich chi tiet
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	public LichChiTiet[] findByLichCongTacId_PrevAndNext(
			long lichChiTietId, long lichCongTacId,
			com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
				orderByComparator)
		throws NoSuchLichChiTietException;

	/**
	 * Removes all the lich chi tiets where lichCongTacId = &#63; from the database.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 */
	public void removeByLichCongTacId(long lichCongTacId);

	/**
	 * Returns the number of lich chi tiets where lichCongTacId = &#63;.
	 *
	 * @param lichCongTacId the lich cong tac ID
	 * @return the number of matching lich chi tiets
	 */
	public int countByLichCongTacId(long lichCongTacId);

	/**
	 * Caches the lich chi tiet in the entity cache if it is enabled.
	 *
	 * @param lichChiTiet the lich chi tiet
	 */
	public void cacheResult(LichChiTiet lichChiTiet);

	/**
	 * Caches the lich chi tiets in the entity cache if it is enabled.
	 *
	 * @param lichChiTiets the lich chi tiets
	 */
	public void cacheResult(java.util.List<LichChiTiet> lichChiTiets);

	/**
	 * Creates a new lich chi tiet with the primary key. Does not add the lich chi tiet to the database.
	 *
	 * @param lichChiTietId the primary key for the new lich chi tiet
	 * @return the new lich chi tiet
	 */
	public LichChiTiet create(long lichChiTietId);

	/**
	 * Removes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	public LichChiTiet remove(long lichChiTietId)
		throws NoSuchLichChiTietException;

	public LichChiTiet updateImpl(LichChiTiet lichChiTiet);

	/**
	 * Returns the lich chi tiet with the primary key or throws a <code>NoSuchLichChiTietException</code> if it could not be found.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws NoSuchLichChiTietException if a lich chi tiet with the primary key could not be found
	 */
	public LichChiTiet findByPrimaryKey(long lichChiTietId)
		throws NoSuchLichChiTietException;

	/**
	 * Returns the lich chi tiet with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet, or <code>null</code> if a lich chi tiet with the primary key could not be found
	 */
	public LichChiTiet fetchByPrimaryKey(long lichChiTietId);

	/**
	 * Returns all the lich chi tiets.
	 *
	 * @return the lich chi tiets
	 */
	public java.util.List<LichChiTiet> findAll();

	/**
	 * Returns a range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of lich chi tiets
	 */
	public java.util.List<LichChiTiet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lich chi tiets
	 */
	public java.util.List<LichChiTiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lich chi tiets
	 */
	public java.util.List<LichChiTiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LichChiTiet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lich chi tiets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lich chi tiets.
	 *
	 * @return the number of lich chi tiets
	 */
	public int countAll();

}