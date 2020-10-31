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

package User.Rank.Poisition.Service.service.persistence;

import User.Rank.Poisition.Service.exception.NoSuchUserPoisitionException;
import User.Rank.Poisition.Service.model.UserPoisition;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user poisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisitionUtil
 * @generated
 */
@ProviderType
public interface UserPoisitionPersistence
	extends BasePersistence<UserPoisition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPoisitionUtil} to access the user poisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user poisitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user poisitions
	 */
	public java.util.List<UserPoisition> findByUuid(String uuid);

	/**
	 * Returns a range of all the user poisitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @return the range of matching user poisitions
	 */
	public java.util.List<UserPoisition> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user poisitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisitions
	 */
	@Deprecated
	public java.util.List<UserPoisition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPoisition> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisitions
	 */
	public java.util.List<UserPoisition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the first user poisition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByUuid_First(
			String uuid, OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the first user poisition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByUuid_First(
		String uuid, OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the last user poisition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByUuid_Last(
			String uuid, OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the last user poisition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByUuid_Last(
		String uuid, OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the user poisitions before and after the current user poisition in the ordered set where uuid = &#63;.
	 *
	 * @param userPoisitionId the primary key of the current user poisition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition
	 * @throws NoSuchUserPoisitionException if a user poisition with the primary key could not be found
	 */
	public UserPoisition[] findByUuid_PrevAndNext(
			long userPoisitionId, String uuid,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Removes all the user poisitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user poisitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user poisitions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user poisition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPoisitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByUUID_G(String uuid, long groupId)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the user poisition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	@Deprecated
	public UserPoisition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the user poisition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the user poisition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user poisition that was removed
	 */
	public UserPoisition removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the number of user poisitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user poisitions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user poisitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user poisitions
	 */
	public java.util.List<UserPoisition> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the user poisitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @return the range of matching user poisitions
	 */
	public java.util.List<UserPoisition> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user poisitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisitions
	 */
	@Deprecated
	public java.util.List<UserPoisition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisitions
	 */
	public java.util.List<UserPoisition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the first user poisition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the first user poisition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the last user poisition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the last user poisition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the user poisitions before and after the current user poisition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userPoisitionId the primary key of the current user poisition
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition
	 * @throws NoSuchUserPoisitionException if a user poisition with the primary key could not be found
	 */
	public UserPoisition[] findByUuid_C_PrevAndNext(
			long userPoisitionId, String uuid, long companyId,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Removes all the user poisitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user poisitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user poisitions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user poisitions where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user poisitions
	 */
	public java.util.List<UserPoisition> findByFindAll(
		long groupId, long companyId);

	/**
	 * Returns a range of all the user poisitions where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @return the range of matching user poisitions
	 */
	public java.util.List<UserPoisition> findByFindAll(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user poisitions where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisitions
	 */
	@Deprecated
	public java.util.List<UserPoisition> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserPoisition> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisitions where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisitions
	 */
	public java.util.List<UserPoisition> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the first user poisition in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the first user poisition in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the last user poisition in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition
	 * @throws NoSuchUserPoisitionException if a matching user poisition could not be found
	 */
	public UserPoisition findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the last user poisition in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition, or <code>null</code> if a matching user poisition could not be found
	 */
	public UserPoisition fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Returns the user poisitions before and after the current user poisition in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userPoisitionId the primary key of the current user poisition
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition
	 * @throws NoSuchUserPoisitionException if a user poisition with the primary key could not be found
	 */
	public UserPoisition[] findByFindAll_PrevAndNext(
			long userPoisitionId, long groupId, long companyId,
			OrderByComparator<UserPoisition> orderByComparator)
		throws NoSuchUserPoisitionException;

	/**
	 * Removes all the user poisitions where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of user poisitions where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user poisitions
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the user poisition in the entity cache if it is enabled.
	 *
	 * @param userPoisition the user poisition
	 */
	public void cacheResult(UserPoisition userPoisition);

	/**
	 * Caches the user poisitions in the entity cache if it is enabled.
	 *
	 * @param userPoisitions the user poisitions
	 */
	public void cacheResult(java.util.List<UserPoisition> userPoisitions);

	/**
	 * Creates a new user poisition with the primary key. Does not add the user poisition to the database.
	 *
	 * @param userPoisitionId the primary key for the new user poisition
	 * @return the new user poisition
	 */
	public UserPoisition create(long userPoisitionId);

	/**
	 * Removes the user poisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionId the primary key of the user poisition
	 * @return the user poisition that was removed
	 * @throws NoSuchUserPoisitionException if a user poisition with the primary key could not be found
	 */
	public UserPoisition remove(long userPoisitionId)
		throws NoSuchUserPoisitionException;

	public UserPoisition updateImpl(UserPoisition userPoisition);

	/**
	 * Returns the user poisition with the primary key or throws a <code>NoSuchUserPoisitionException</code> if it could not be found.
	 *
	 * @param userPoisitionId the primary key of the user poisition
	 * @return the user poisition
	 * @throws NoSuchUserPoisitionException if a user poisition with the primary key could not be found
	 */
	public UserPoisition findByPrimaryKey(long userPoisitionId)
		throws NoSuchUserPoisitionException;

	/**
	 * Returns the user poisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPoisitionId the primary key of the user poisition
	 * @return the user poisition, or <code>null</code> if a user poisition with the primary key could not be found
	 */
	public UserPoisition fetchByPrimaryKey(long userPoisitionId);

	/**
	 * Returns all the user poisitions.
	 *
	 * @return the user poisitions
	 */
	public java.util.List<UserPoisition> findAll();

	/**
	 * Returns a range of all the user poisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @return the range of user poisitions
	 */
	public java.util.List<UserPoisition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user poisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user poisitions
	 */
	@Deprecated
	public java.util.List<UserPoisition> findAll(
		int start, int end, OrderByComparator<UserPoisition> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisitionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisitions
	 * @param end the upper bound of the range of user poisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user poisitions
	 */
	public java.util.List<UserPoisition> findAll(
		int start, int end, OrderByComparator<UserPoisition> orderByComparator);

	/**
	 * Removes all the user poisitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user poisitions.
	 *
	 * @return the number of user poisitions
	 */
	public int countAll();

}