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

package com.web.ecoit.portal.quangcao.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoSliderException;
import com.web.ecoit.portal.quangcao.model.QuangCaoSlider;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quang cao slider service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoSliderUtil
 * @generated
 */
@ProviderType
public interface QuangCaoSliderPersistence
	extends BasePersistence<QuangCaoSlider> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuangCaoSliderUtil} to access the quang cao slider persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quang cao sliders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findByUuid(String uuid);

	/**
	 * Returns a range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of matching quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang cao sliders
	 */
	@Deprecated
	public java.util.List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Returns the first quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider findByUuid_First(
			String uuid, OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the first quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider fetchByUuid_First(
		String uuid, OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Returns the last quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider findByUuid_Last(
			String uuid, OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the last quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider fetchByUuid_Last(
		String uuid, OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Returns the quang cao sliders before and after the current quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param quangCaoSliderId the primary key of the current quang cao slider
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public QuangCaoSlider[] findByUuid_PrevAndNext(
			long quangCaoSliderId, String uuid,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Removes all the quang cao sliders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of quang cao sliders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching quang cao sliders
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider findByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Deprecated
	public QuangCaoSlider fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the quang cao slider where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the quang cao slider that was removed
	 */
	public QuangCaoSlider removeByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the number of quang cao sliders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @return the matching quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId);

	/**
	 * Returns a range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of matching quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBybyQuangCaoIdAndGroupId(long,long, int, int, OrderByComparator)}
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang cao sliders
	 */
	@Deprecated
	public java.util.List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Returns the first quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider findBybyQuangCaoIdAndGroupId_First(
			long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the first quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider fetchBybyQuangCaoIdAndGroupId_First(
		long quangCaoId, long groupId,
		OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Returns the last quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider findBybyQuangCaoIdAndGroupId_Last(
			long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the last quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider fetchBybyQuangCaoIdAndGroupId_Last(
		long quangCaoId, long groupId,
		OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Returns the quang cao sliders before and after the current quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoSliderId the primary key of the current quang cao slider
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public QuangCaoSlider[] findBybyQuangCaoIdAndGroupId_PrevAndNext(
			long quangCaoSliderId, long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Removes all the quang cao sliders where quangCaoId = &#63; and groupId = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 */
	public void removeBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId);

	/**
	 * Returns the number of quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	public int countBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId);

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider findBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoSliderIdAndGroupId(long,long)}
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Deprecated
	public QuangCaoSlider fetchBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId, boolean useFinderCache);

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	public QuangCaoSlider fetchBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId);

	/**
	 * Removes the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; from the database.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the quang cao slider that was removed
	 */
	public QuangCaoSlider removeBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the number of quang cao sliders where quangCaoSliderId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	public int countBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId);

	/**
	 * Caches the quang cao slider in the entity cache if it is enabled.
	 *
	 * @param quangCaoSlider the quang cao slider
	 */
	public void cacheResult(QuangCaoSlider quangCaoSlider);

	/**
	 * Caches the quang cao sliders in the entity cache if it is enabled.
	 *
	 * @param quangCaoSliders the quang cao sliders
	 */
	public void cacheResult(java.util.List<QuangCaoSlider> quangCaoSliders);

	/**
	 * Creates a new quang cao slider with the primary key. Does not add the quang cao slider to the database.
	 *
	 * @param quangCaoSliderId the primary key for the new quang cao slider
	 * @return the new quang cao slider
	 */
	public QuangCaoSlider create(long quangCaoSliderId);

	/**
	 * Removes the quang cao slider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider that was removed
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public QuangCaoSlider remove(long quangCaoSliderId)
		throws NoSuchQuangCaoSliderException;

	public QuangCaoSlider updateImpl(QuangCaoSlider quangCaoSlider);

	/**
	 * Returns the quang cao slider with the primary key or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	public QuangCaoSlider findByPrimaryKey(long quangCaoSliderId)
		throws NoSuchQuangCaoSliderException;

	/**
	 * Returns the quang cao slider with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider, or <code>null</code> if a quang cao slider with the primary key could not be found
	 */
	public QuangCaoSlider fetchByPrimaryKey(long quangCaoSliderId);

	/**
	 * Returns all the quang cao sliders.
	 *
	 * @return the quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findAll();

	/**
	 * Returns a range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quang cao sliders
	 */
	@Deprecated
	public java.util.List<QuangCaoSlider> findAll(
		int start, int end, OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quang cao sliders
	 */
	public java.util.List<QuangCaoSlider> findAll(
		int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator);

	/**
	 * Removes all the quang cao sliders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quang cao sliders.
	 *
	 * @return the number of quang cao sliders
	 */
	public int countAll();

}