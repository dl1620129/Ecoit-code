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

package organizationalStructure.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

import organizationalStructure.service.exception.NoSuchorganizationsException;
import organizationalStructure.service.model.organizations;

/**
 * The persistence interface for the organizations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see organizationsUtil
 * @generated
 */
@ProviderType
public interface organizationsPersistence
	extends BasePersistence<organizations> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link organizationsUtil} to access the organizations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the organizationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching organizationses
	 */
	public java.util.List<organizations> findByUuid(String uuid);

	/**
	 * Returns a range of all the organizationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of matching organizationses
	 */
	public java.util.List<organizations> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the organizationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organizationses
	 */
	@Deprecated
	public java.util.List<organizations> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<organizations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the organizationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizationses
	 */
	public java.util.List<organizations> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<organizations> orderByComparator);

	/**
	 * Returns the first organizations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations
	 * @throws NoSuchorganizationsException if a matching organizations could not be found
	 */
	public organizations findByUuid_First(
			String uuid, OrderByComparator<organizations> orderByComparator)
		throws NoSuchorganizationsException;

	/**
	 * Returns the first organizations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	public organizations fetchByUuid_First(
		String uuid, OrderByComparator<organizations> orderByComparator);

	/**
	 * Returns the last organizations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations
	 * @throws NoSuchorganizationsException if a matching organizations could not be found
	 */
	public organizations findByUuid_Last(
			String uuid, OrderByComparator<organizations> orderByComparator)
		throws NoSuchorganizationsException;

	/**
	 * Returns the last organizations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	public organizations fetchByUuid_Last(
		String uuid, OrderByComparator<organizations> orderByComparator);

	/**
	 * Returns the organizationses before and after the current organizations in the ordered set where uuid = &#63;.
	 *
	 * @param organizationId the primary key of the current organizations
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizations
	 * @throws NoSuchorganizationsException if a organizations with the primary key could not be found
	 */
	public organizations[] findByUuid_PrevAndNext(
			long organizationId, String uuid,
			OrderByComparator<organizations> orderByComparator)
		throws NoSuchorganizationsException;

	/**
	 * Removes all the organizationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of organizationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching organizationses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the organizations where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchorganizationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching organizations
	 * @throws NoSuchorganizationsException if a matching organizations could not be found
	 */
	public organizations findByUUID_G(String uuid, long groupId)
		throws NoSuchorganizationsException;

	/**
	 * Returns the organizations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	@Deprecated
	public organizations fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the organizations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	public organizations fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the organizations where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the organizations that was removed
	 */
	public organizations removeByUUID_G(String uuid, long groupId)
		throws NoSuchorganizationsException;

	/**
	 * Returns the number of organizationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching organizationses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the organizationses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching organizationses
	 */
	public java.util.List<organizations> findByFindAll(long groupId);

	/**
	 * Returns a range of all the organizationses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of matching organizationses
	 */
	public java.util.List<organizations> findByFindAll(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the organizationses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching organizationses
	 */
	@Deprecated
	public java.util.List<organizations> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<organizations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the organizationses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizationses
	 */
	public java.util.List<organizations> findByFindAll(
		long groupId, int start, int end,
		OrderByComparator<organizations> orderByComparator);

	/**
	 * Returns the first organizations in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations
	 * @throws NoSuchorganizationsException if a matching organizations could not be found
	 */
	public organizations findByFindAll_First(
			long groupId, OrderByComparator<organizations> orderByComparator)
		throws NoSuchorganizationsException;

	/**
	 * Returns the first organizations in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	public organizations fetchByFindAll_First(
		long groupId, OrderByComparator<organizations> orderByComparator);

	/**
	 * Returns the last organizations in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations
	 * @throws NoSuchorganizationsException if a matching organizations could not be found
	 */
	public organizations findByFindAll_Last(
			long groupId, OrderByComparator<organizations> orderByComparator)
		throws NoSuchorganizationsException;

	/**
	 * Returns the last organizations in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organizations, or <code>null</code> if a matching organizations could not be found
	 */
	public organizations fetchByFindAll_Last(
		long groupId, OrderByComparator<organizations> orderByComparator);

	/**
	 * Returns the organizationses before and after the current organizations in the ordered set where groupId = &#63;.
	 *
	 * @param organizationId the primary key of the current organizations
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organizations
	 * @throws NoSuchorganizationsException if a organizations with the primary key could not be found
	 */
	public organizations[] findByFindAll_PrevAndNext(
			long organizationId, long groupId,
			OrderByComparator<organizations> orderByComparator)
		throws NoSuchorganizationsException;

	/**
	 * Removes all the organizationses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByFindAll(long groupId);

	/**
	 * Returns the number of organizationses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching organizationses
	 */
	public int countByFindAll(long groupId);

	/**
	 * Caches the organizations in the entity cache if it is enabled.
	 *
	 * @param organizations the organizations
	 */
	public void cacheResult(organizations organizations);

	/**
	 * Caches the organizationses in the entity cache if it is enabled.
	 *
	 * @param organizationses the organizationses
	 */
	public void cacheResult(java.util.List<organizations> organizationses);

	/**
	 * Creates a new organizations with the primary key. Does not add the organizations to the database.
	 *
	 * @param organizationId the primary key for the new organizations
	 * @return the new organizations
	 */
	public organizations create(long organizationId);

	/**
	 * Removes the organizations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations that was removed
	 * @throws NoSuchorganizationsException if a organizations with the primary key could not be found
	 */
	public organizations remove(long organizationId)
		throws NoSuchorganizationsException;

	public organizations updateImpl(organizations organizations);

	/**
	 * Returns the organizations with the primary key or throws a <code>NoSuchorganizationsException</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations
	 * @throws NoSuchorganizationsException if a organizations with the primary key could not be found
	 */
	public organizations findByPrimaryKey(long organizationId)
		throws NoSuchorganizationsException;

	/**
	 * Returns the organizations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the organizations
	 * @return the organizations, or <code>null</code> if a organizations with the primary key could not be found
	 */
	public organizations fetchByPrimaryKey(long organizationId);

	/**
	 * Returns all the organizationses.
	 *
	 * @return the organizationses
	 */
	public java.util.List<organizations> findAll();

	/**
	 * Returns a range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @return the range of organizationses
	 */
	public java.util.List<organizations> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of organizationses
	 */
	@Deprecated
	public java.util.List<organizations> findAll(
		int start, int end, OrderByComparator<organizations> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the organizationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationses
	 * @param end the upper bound of the range of organizationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organizationses
	 */
	public java.util.List<organizations> findAll(
		int start, int end, OrderByComparator<organizations> orderByComparator);

	/**
	 * Removes all the organizationses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of organizationses.
	 *
	 * @return the number of organizationses
	 */
	public int countAll();

}