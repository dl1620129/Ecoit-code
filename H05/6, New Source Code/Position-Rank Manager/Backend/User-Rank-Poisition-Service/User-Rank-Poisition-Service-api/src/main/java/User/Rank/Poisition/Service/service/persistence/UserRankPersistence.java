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

import User.Rank.Poisition.Service.exception.NoSuchUserRankException;
import User.Rank.Poisition.Service.model.UserRank;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user rank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRankUtil
 * @generated
 */
@ProviderType
public interface UserRankPersistence extends BasePersistence<UserRank> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRankUtil} to access the user rank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user ranks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user ranks
	 */
	public java.util.List<UserRank> findByUuid(String uuid);

	/**
	 * Returns a range of all the user ranks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @return the range of matching user ranks
	 */
	public java.util.List<UserRank> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user ranks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user ranks
	 */
	@Deprecated
	public java.util.List<UserRank> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserRank> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user ranks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user ranks
	 */
	public java.util.List<UserRank> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByUuid_First(
			String uuid, OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByUuid_First(
		String uuid, OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByUuid_Last(
			String uuid, OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByUuid_Last(
		String uuid, OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the user ranks before and after the current user rank in the ordered set where uuid = &#63;.
	 *
	 * @param userRankId the primary key of the current user rank
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user rank
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public UserRank[] findByUuid_PrevAndNext(
			long userRankId, String uuid,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Removes all the user ranks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user ranks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user ranks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user rank where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserRankException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByUUID_G(String uuid, long groupId)
		throws NoSuchUserRankException;

	/**
	 * Returns the user rank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	@Deprecated
	public UserRank fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the user rank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the user rank where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user rank that was removed
	 */
	public UserRank removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserRankException;

	/**
	 * Returns the number of user ranks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user ranks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user ranks
	 */
	public java.util.List<UserRank> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @return the range of matching user ranks
	 */
	public java.util.List<UserRank> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user ranks
	 */
	@Deprecated
	public java.util.List<UserRank> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user ranks
	 */
	public java.util.List<UserRank> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the user ranks before and after the current user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userRankId the primary key of the current user rank
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user rank
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public UserRank[] findByUuid_C_PrevAndNext(
			long userRankId, String uuid, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Removes all the user ranks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user ranks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user ranks
	 */
	public java.util.List<UserRank> findByFindAll(long groupId, long companyId);

	/**
	 * Returns a range of all the user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @return the range of matching user ranks
	 */
	public java.util.List<UserRank> findByFindAll(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user ranks
	 */
	@Deprecated
	public java.util.List<UserRank> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user ranks
	 */
	public java.util.List<UserRank> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the first user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Returns the first user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the last user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public UserRank findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Returns the last user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public UserRank fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserRank> orderByComparator);

	/**
	 * Returns the user ranks before and after the current user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userRankId the primary key of the current user rank
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user rank
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public UserRank[] findByFindAll_PrevAndNext(
			long userRankId, long groupId, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws NoSuchUserRankException;

	/**
	 * Removes all the user ranks where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user ranks
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the user rank in the entity cache if it is enabled.
	 *
	 * @param userRank the user rank
	 */
	public void cacheResult(UserRank userRank);

	/**
	 * Caches the user ranks in the entity cache if it is enabled.
	 *
	 * @param userRanks the user ranks
	 */
	public void cacheResult(java.util.List<UserRank> userRanks);

	/**
	 * Creates a new user rank with the primary key. Does not add the user rank to the database.
	 *
	 * @param userRankId the primary key for the new user rank
	 * @return the new user rank
	 */
	public UserRank create(long userRankId);

	/**
	 * Removes the user rank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank that was removed
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public UserRank remove(long userRankId) throws NoSuchUserRankException;

	public UserRank updateImpl(UserRank userRank);

	/**
	 * Returns the user rank with the primary key or throws a <code>NoSuchUserRankException</code> if it could not be found.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public UserRank findByPrimaryKey(long userRankId)
		throws NoSuchUserRankException;

	/**
	 * Returns the user rank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank, or <code>null</code> if a user rank with the primary key could not be found
	 */
	public UserRank fetchByPrimaryKey(long userRankId);

	/**
	 * Returns all the user ranks.
	 *
	 * @return the user ranks
	 */
	public java.util.List<UserRank> findAll();

	/**
	 * Returns a range of all the user ranks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @return the range of user ranks
	 */
	public java.util.List<UserRank> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user ranks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user ranks
	 */
	@Deprecated
	public java.util.List<UserRank> findAll(
		int start, int end, OrderByComparator<UserRank> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user ranks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user ranks
	 */
	public java.util.List<UserRank> findAll(
		int start, int end, OrderByComparator<UserRank> orderByComparator);

	/**
	 * Removes all the user ranks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user ranks.
	 *
	 * @return the number of user ranks
	 */
	public int countAll();

}