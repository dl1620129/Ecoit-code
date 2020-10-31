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

package LinkManager.Service.service.persistence;

import LinkManager.Service.exception.NoSuchportalException;
import LinkManager.Service.model.portal;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the portal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see portalUtil
 * @generated
 */
@ProviderType
public interface portalPersistence extends BasePersistence<portal> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link portalUtil} to access the portal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the portals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching portals
	 */
	public java.util.List<portal> findByUuid(String uuid);

	/**
	 * Returns a range of all the portals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @return the range of matching portals
	 */
	public java.util.List<portal> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the portals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching portals
	 */
	@Deprecated
	public java.util.List<portal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<portal> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the portals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portals
	 */
	public java.util.List<portal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the first portal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByUuid_First(
			String uuid, OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Returns the first portal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByUuid_First(
		String uuid, OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the last portal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByUuid_Last(
			String uuid, OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Returns the last portal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByUuid_Last(
		String uuid, OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the portals before and after the current portal in the ordered set where uuid = &#63;.
	 *
	 * @param portalId the primary key of the current portal
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal
	 * @throws NoSuchportalException if a portal with the primary key could not be found
	 */
	public portal[] findByUuid_PrevAndNext(
			long portalId, String uuid,
			OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Removes all the portals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of portals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching portals
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the portal where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchportalException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByUUID_G(String uuid, long groupId)
		throws NoSuchportalException;

	/**
	 * Returns the portal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching portal, or <code>null</code> if a matching portal could not be found
	 */
	@Deprecated
	public portal fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the portal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the portal where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the portal that was removed
	 */
	public portal removeByUUID_G(String uuid, long groupId)
		throws NoSuchportalException;

	/**
	 * Returns the number of portals where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching portals
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the portals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching portals
	 */
	public java.util.List<portal> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the portals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @return the range of matching portals
	 */
	public java.util.List<portal> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the portals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching portals
	 */
	@Deprecated
	public java.util.List<portal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<portal> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the portals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portals
	 */
	public java.util.List<portal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the first portal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Returns the first portal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the last portal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Returns the last portal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the portals before and after the current portal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param portalId the primary key of the current portal
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal
	 * @throws NoSuchportalException if a portal with the primary key could not be found
	 */
	public portal[] findByUuid_C_PrevAndNext(
			long portalId, String uuid, long companyId,
			OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Removes all the portals where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of portals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching portals
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the portals where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching portals
	 */
	public java.util.List<portal> findByField2(boolean field2);

	/**
	 * Returns a range of all the portals where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @return the range of matching portals
	 */
	public java.util.List<portal> findByField2(
		boolean field2, int start, int end);

	/**
	 * Returns an ordered range of all the portals where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByField2(boolean, int, int, OrderByComparator)}
	 * @param field2 the field2
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching portals
	 */
	@Deprecated
	public java.util.List<portal> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<portal> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the portals where field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param field2 the field2
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portals
	 */
	public java.util.List<portal> findByField2(
		boolean field2, int start, int end,
		OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the first portal in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByField2_First(
			boolean field2, OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Returns the first portal in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByField2_First(
		boolean field2, OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the last portal in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal
	 * @throws NoSuchportalException if a matching portal could not be found
	 */
	public portal findByField2_Last(
			boolean field2, OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Returns the last portal in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portal, or <code>null</code> if a matching portal could not be found
	 */
	public portal fetchByField2_Last(
		boolean field2, OrderByComparator<portal> orderByComparator);

	/**
	 * Returns the portals before and after the current portal in the ordered set where field2 = &#63;.
	 *
	 * @param portalId the primary key of the current portal
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portal
	 * @throws NoSuchportalException if a portal with the primary key could not be found
	 */
	public portal[] findByField2_PrevAndNext(
			long portalId, boolean field2,
			OrderByComparator<portal> orderByComparator)
		throws NoSuchportalException;

	/**
	 * Removes all the portals where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	public void removeByField2(boolean field2);

	/**
	 * Returns the number of portals where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching portals
	 */
	public int countByField2(boolean field2);

	/**
	 * Caches the portal in the entity cache if it is enabled.
	 *
	 * @param portal the portal
	 */
	public void cacheResult(portal portal);

	/**
	 * Caches the portals in the entity cache if it is enabled.
	 *
	 * @param portals the portals
	 */
	public void cacheResult(java.util.List<portal> portals);

	/**
	 * Creates a new portal with the primary key. Does not add the portal to the database.
	 *
	 * @param portalId the primary key for the new portal
	 * @return the new portal
	 */
	public portal create(long portalId);

	/**
	 * Removes the portal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal that was removed
	 * @throws NoSuchportalException if a portal with the primary key could not be found
	 */
	public portal remove(long portalId) throws NoSuchportalException;

	public portal updateImpl(portal portal);

	/**
	 * Returns the portal with the primary key or throws a <code>NoSuchportalException</code> if it could not be found.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal
	 * @throws NoSuchportalException if a portal with the primary key could not be found
	 */
	public portal findByPrimaryKey(long portalId) throws NoSuchportalException;

	/**
	 * Returns the portal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal, or <code>null</code> if a portal with the primary key could not be found
	 */
	public portal fetchByPrimaryKey(long portalId);

	/**
	 * Returns all the portals.
	 *
	 * @return the portals
	 */
	public java.util.List<portal> findAll();

	/**
	 * Returns a range of all the portals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @return the range of portals
	 */
	public java.util.List<portal> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the portals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of portals
	 */
	@Deprecated
	public java.util.List<portal> findAll(
		int start, int end, OrderByComparator<portal> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the portals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portals
	 */
	public java.util.List<portal> findAll(
		int start, int end, OrderByComparator<portal> orderByComparator);

	/**
	 * Removes all the portals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of portals.
	 *
	 * @return the number of portals
	 */
	public int countAll();

}