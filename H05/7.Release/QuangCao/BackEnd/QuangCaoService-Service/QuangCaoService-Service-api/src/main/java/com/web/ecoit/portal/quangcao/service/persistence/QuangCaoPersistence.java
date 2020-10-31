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

import com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoException;
import com.web.ecoit.portal.quangcao.model.QuangCao;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quang cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoUtil
 * @generated
 */
@ProviderType
public interface QuangCaoPersistence extends BasePersistence<QuangCao> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuangCaoUtil} to access the quang cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quang caos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching quang caos
	 */
	public java.util.List<QuangCao> findByUuid(String uuid);

	/**
	 * Returns a range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of matching quang caos
	 */
	public java.util.List<QuangCao> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang caos
	 */
	@Deprecated
	public java.util.List<QuangCao> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCao> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang caos
	 */
	public java.util.List<QuangCao> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCao> orderByComparator);

	/**
	 * Returns the first quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public QuangCao findByUuid_First(
			String uuid, OrderByComparator<QuangCao> orderByComparator)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the first quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public QuangCao fetchByUuid_First(
		String uuid, OrderByComparator<QuangCao> orderByComparator);

	/**
	 * Returns the last quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public QuangCao findByUuid_Last(
			String uuid, OrderByComparator<QuangCao> orderByComparator)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the last quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public QuangCao fetchByUuid_Last(
		String uuid, OrderByComparator<QuangCao> orderByComparator);

	/**
	 * Returns the quang caos before and after the current quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param quangCaoId the primary key of the current quang cao
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	public QuangCao[] findByUuid_PrevAndNext(
			long quangCaoId, String uuid,
			OrderByComparator<QuangCao> orderByComparator)
		throws NoSuchQuangCaoException;

	/**
	 * Removes all the quang caos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of quang caos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching quang caos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public QuangCao findByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Deprecated
	public QuangCao fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public QuangCao fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the quang cao where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the quang cao that was removed
	 */
	public QuangCao removeByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the number of quang caos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching quang caos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public QuangCao findBybyQuangCaoIdAndGroupIdAndType(
			long quangCaoId, long groupId, int type)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoIdAndGroupIdAndType(long,long,int)}
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Deprecated
	public QuangCao fetchBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type, boolean useFinderCache);

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public QuangCao fetchBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type);

	/**
	 * Removes the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the quang cao that was removed
	 */
	public QuangCao removeBybyQuangCaoIdAndGroupIdAndType(
			long quangCaoId, long groupId, int type)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the number of quang caos where quangCaoId = &#63; and groupId = &#63; and type = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching quang caos
	 */
	public int countBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type);

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	public QuangCao findBybyQuangCaoIdAndStatus(long quangCaoId, int status)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoIdAndStatus(long,int)}
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Deprecated
	public QuangCao fetchBybyQuangCaoIdAndStatus(
		long quangCaoId, int status, boolean useFinderCache);

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	public QuangCao fetchBybyQuangCaoIdAndStatus(long quangCaoId, int status);

	/**
	 * Removes the quang cao where quangCaoId = &#63; and status = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the quang cao that was removed
	 */
	public QuangCao removeBybyQuangCaoIdAndStatus(long quangCaoId, int status)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the number of quang caos where quangCaoId = &#63; and status = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the number of matching quang caos
	 */
	public int countBybyQuangCaoIdAndStatus(long quangCaoId, int status);

	/**
	 * Caches the quang cao in the entity cache if it is enabled.
	 *
	 * @param quangCao the quang cao
	 */
	public void cacheResult(QuangCao quangCao);

	/**
	 * Caches the quang caos in the entity cache if it is enabled.
	 *
	 * @param quangCaos the quang caos
	 */
	public void cacheResult(java.util.List<QuangCao> quangCaos);

	/**
	 * Creates a new quang cao with the primary key. Does not add the quang cao to the database.
	 *
	 * @param quangCaoId the primary key for the new quang cao
	 * @return the new quang cao
	 */
	public QuangCao create(long quangCaoId);

	/**
	 * Removes the quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao that was removed
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	public QuangCao remove(long quangCaoId) throws NoSuchQuangCaoException;

	public QuangCao updateImpl(QuangCao quangCao);

	/**
	 * Returns the quang cao with the primary key or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	public QuangCao findByPrimaryKey(long quangCaoId)
		throws NoSuchQuangCaoException;

	/**
	 * Returns the quang cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao, or <code>null</code> if a quang cao with the primary key could not be found
	 */
	public QuangCao fetchByPrimaryKey(long quangCaoId);

	/**
	 * Returns all the quang caos.
	 *
	 * @return the quang caos
	 */
	public java.util.List<QuangCao> findAll();

	/**
	 * Returns a range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of quang caos
	 */
	public java.util.List<QuangCao> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quang caos
	 */
	@Deprecated
	public java.util.List<QuangCao> findAll(
		int start, int end, OrderByComparator<QuangCao> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quang caos
	 */
	public java.util.List<QuangCao> findAll(
		int start, int end, OrderByComparator<QuangCao> orderByComparator);

	/**
	 * Removes all the quang caos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quang caos.
	 *
	 * @return the number of quang caos
	 */
	public int countAll();

}