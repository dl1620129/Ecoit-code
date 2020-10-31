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

import User.Rank.Poisition.Service.exception.NoSuchUserChucDanhException;
import User.Rank.Poisition.Service.model.UserChucDanh;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user chuc danh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserChucDanhUtil
 * @generated
 */
@ProviderType
public interface UserChucDanhPersistence extends BasePersistence<UserChucDanh> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserChucDanhUtil} to access the user chuc danh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user chuc danhs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByUuid(String uuid);

	/**
	 * Returns a range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	public java.util.List<UserChucDanh> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByUuid_First(
			String uuid, OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByUuid_First(
		String uuid, OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByUuid_Last(
			String uuid, OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByUuid_Last(
		String uuid, OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public UserChucDanh[] findByUuid_PrevAndNext(
			long userChucDanhId, String uuid,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Removes all the user chuc danhs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user chuc danhs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user chuc danhs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserChucDanhException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByUUID_G(String uuid, long groupId)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Deprecated
	public UserChucDanh fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the user chuc danh where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user chuc danh that was removed
	 */
	public UserChucDanh removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the number of user chuc danhs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user chuc danhs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	public java.util.List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public UserChucDanh[] findByUuid_C_PrevAndNext(
			long userChucDanhId, String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Removes all the user chuc danhs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user chuc danhs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByFindAll(
		long groupId, long companyId);

	/**
	 * Returns a range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	public java.util.List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	public java.util.List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the first user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the first user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the last user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	public UserChucDanh findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the last user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public UserChucDanh fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public UserChucDanh[] findByFindAll_PrevAndNext(
			long userChucDanhId, long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException;

	/**
	 * Removes all the user chuc danhs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user chuc danhs
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the user chuc danh in the entity cache if it is enabled.
	 *
	 * @param userChucDanh the user chuc danh
	 */
	public void cacheResult(UserChucDanh userChucDanh);

	/**
	 * Caches the user chuc danhs in the entity cache if it is enabled.
	 *
	 * @param userChucDanhs the user chuc danhs
	 */
	public void cacheResult(java.util.List<UserChucDanh> userChucDanhs);

	/**
	 * Creates a new user chuc danh with the primary key. Does not add the user chuc danh to the database.
	 *
	 * @param userChucDanhId the primary key for the new user chuc danh
	 * @return the new user chuc danh
	 */
	public UserChucDanh create(long userChucDanhId);

	/**
	 * Removes the user chuc danh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh that was removed
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public UserChucDanh remove(long userChucDanhId)
		throws NoSuchUserChucDanhException;

	public UserChucDanh updateImpl(UserChucDanh userChucDanh);

	/**
	 * Returns the user chuc danh with the primary key or throws a <code>NoSuchUserChucDanhException</code> if it could not be found.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	public UserChucDanh findByPrimaryKey(long userChucDanhId)
		throws NoSuchUserChucDanhException;

	/**
	 * Returns the user chuc danh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh, or <code>null</code> if a user chuc danh with the primary key could not be found
	 */
	public UserChucDanh fetchByPrimaryKey(long userChucDanhId);

	/**
	 * Returns all the user chuc danhs.
	 *
	 * @return the user chuc danhs
	 */
	public java.util.List<UserChucDanh> findAll();

	/**
	 * Returns a range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of user chuc danhs
	 */
	public java.util.List<UserChucDanh> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user chuc danhs
	 */
	@Deprecated
	public java.util.List<UserChucDanh> findAll(
		int start, int end, OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user chuc danhs
	 */
	public java.util.List<UserChucDanh> findAll(
		int start, int end, OrderByComparator<UserChucDanh> orderByComparator);

	/**
	 * Removes all the user chuc danhs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user chuc danhs.
	 *
	 * @return the number of user chuc danhs
	 */
	public int countAll();

}