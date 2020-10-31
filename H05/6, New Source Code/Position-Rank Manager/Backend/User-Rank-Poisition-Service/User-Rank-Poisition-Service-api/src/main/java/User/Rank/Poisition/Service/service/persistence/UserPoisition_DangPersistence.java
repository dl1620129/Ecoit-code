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

import User.Rank.Poisition.Service.exception.NoSuchUserPoisition_DangException;
import User.Rank.Poisition.Service.model.UserPoisition_Dang;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user poisition_ dang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangUtil
 * @generated
 */
@ProviderType
public interface UserPoisition_DangPersistence
	extends BasePersistence<UserPoisition_Dang> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPoisition_DangUtil} to access the user poisition_ dang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user poisition_ dangs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByUuid(String uuid);

	/**
	 * Returns a range of all the user poisition_ dangs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Deprecated
	public java.util.List<UserPoisition_Dang> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByUuid_First(
			String uuid,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByUuid_First(
		String uuid, OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByUuid_Last(
			String uuid,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByUuid_Last(
		String uuid, OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the user poisition_ dangs before and after the current user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param userPoisitionDangId the primary key of the current user poisition_ dang
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	public UserPoisition_Dang[] findByUuid_PrevAndNext(
			long userPoisitionDangId, String uuid,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Removes all the user poisition_ dangs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user poisition_ dangs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user poisition_ dangs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user poisition_ dang where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPoisition_DangException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByUUID_G(String uuid, long groupId)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the user poisition_ dang where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Deprecated
	public UserPoisition_Dang fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the user poisition_ dang where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the user poisition_ dang where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user poisition_ dang that was removed
	 */
	public UserPoisition_Dang removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the number of user poisition_ dangs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user poisition_ dangs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Deprecated
	public java.util.List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the user poisition_ dangs before and after the current user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userPoisitionDangId the primary key of the current user poisition_ dang
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	public UserPoisition_Dang[] findByUuid_C_PrevAndNext(
			long userPoisitionDangId, String uuid, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Removes all the user poisition_ dangs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user poisition_ dangs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId);

	/**
	 * Returns a range of all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Deprecated
	public java.util.List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the first user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the first user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the last user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the last user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public UserPoisition_Dang fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Returns the user poisition_ dangs before and after the current user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userPoisitionDangId the primary key of the current user poisition_ dang
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	public UserPoisition_Dang[] findByFindAll_PrevAndNext(
			long userPoisitionDangId, long groupId, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Removes all the user poisition_ dangs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindAll(long groupId, long companyId);

	/**
	 * Returns the number of user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user poisition_ dangs
	 */
	public int countByFindAll(long groupId, long companyId);

	/**
	 * Caches the user poisition_ dang in the entity cache if it is enabled.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 */
	public void cacheResult(UserPoisition_Dang userPoisition_Dang);

	/**
	 * Caches the user poisition_ dangs in the entity cache if it is enabled.
	 *
	 * @param userPoisition_Dangs the user poisition_ dangs
	 */
	public void cacheResult(
		java.util.List<UserPoisition_Dang> userPoisition_Dangs);

	/**
	 * Creates a new user poisition_ dang with the primary key. Does not add the user poisition_ dang to the database.
	 *
	 * @param userPoisitionDangId the primary key for the new user poisition_ dang
	 * @return the new user poisition_ dang
	 */
	public UserPoisition_Dang create(long userPoisitionDangId);

	/**
	 * Removes the user poisition_ dang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	public UserPoisition_Dang remove(long userPoisitionDangId)
		throws NoSuchUserPoisition_DangException;

	public UserPoisition_Dang updateImpl(UserPoisition_Dang userPoisition_Dang);

	/**
	 * Returns the user poisition_ dang with the primary key or throws a <code>NoSuchUserPoisition_DangException</code> if it could not be found.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	public UserPoisition_Dang findByPrimaryKey(long userPoisitionDangId)
		throws NoSuchUserPoisition_DangException;

	/**
	 * Returns the user poisition_ dang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang, or <code>null</code> if a user poisition_ dang with the primary key could not be found
	 */
	public UserPoisition_Dang fetchByPrimaryKey(long userPoisitionDangId);

	/**
	 * Returns all the user poisition_ dangs.
	 *
	 * @return the user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findAll();

	/**
	 * Returns a range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user poisition_ dangs
	 */
	@Deprecated
	public java.util.List<UserPoisition_Dang> findAll(
		int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user poisition_ dangs
	 */
	public java.util.List<UserPoisition_Dang> findAll(
		int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator);

	/**
	 * Removes all the user poisition_ dangs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user poisition_ dangs.
	 *
	 * @return the number of user poisition_ dangs
	 */
	public int countAll();

}