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

import User.Rank.Poisition.Service.model.UserRank;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user rank service. This utility wraps <code>User.Rank.Poisition.Service.service.persistence.impl.UserRankPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRankPersistence
 * @generated
 */
@ProviderType
public class UserRankUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserRank userRank) {
		getPersistence().clearCache(userRank);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserRank> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserRank> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRank> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRank> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRank update(UserRank userRank) {
		return getPersistence().update(userRank);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRank update(
		UserRank userRank, ServiceContext serviceContext) {

		return getPersistence().update(userRank, serviceContext);
	}

	/**
	 * Returns all the user ranks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user ranks
	 */
	public static List<UserRank> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<UserRank> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<UserRank> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserRank> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<UserRank> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByUuid_First(
			String uuid, OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByUuid_First(
		String uuid, OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByUuid_Last(
			String uuid, OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByUuid_Last(
		String uuid, OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user ranks before and after the current user rank in the ordered set where uuid = &#63;.
	 *
	 * @param userRankId the primary key of the current user rank
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user rank
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public static UserRank[] findByUuid_PrevAndNext(
			long userRankId, String uuid,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUuid_PrevAndNext(
			userRankId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user ranks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user ranks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user ranks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user rank where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserRankException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByUUID_G(String uuid, long groupId)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

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
	public static UserRank fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Returns the user rank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Removes the user rank where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user rank that was removed
	 */
	public static UserRank removeByUUID_G(String uuid, long groupId)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user ranks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user ranks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user ranks
	 */
	public static List<UserRank> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<UserRank> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<UserRank> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<UserRank> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user rank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static UserRank[] findByUuid_C_PrevAndNext(
			long userRankId, String uuid, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByUuid_C_PrevAndNext(
			userRankId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the user ranks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of user ranks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user ranks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user ranks
	 */
	public static List<UserRank> findByFindAll(long groupId, long companyId) {
		return getPersistence().findByFindAll(groupId, companyId);
	}

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
	public static List<UserRank> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindAll(groupId, companyId, start, end);
	}

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
	public static List<UserRank> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

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
	public static List<UserRank> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank
	 * @throws NoSuchUserRankException if a matching user rank could not be found
	 */
	public static UserRank findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last user rank in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static UserRank fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, orderByComparator);
	}

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
	public static UserRank[] findByFindAll_PrevAndNext(
			long userRankId, long groupId, long companyId,
			OrderByComparator<UserRank> orderByComparator)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByFindAll_PrevAndNext(
			userRankId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the user ranks where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindAll(long groupId, long companyId) {
		getPersistence().removeByFindAll(groupId, companyId);
	}

	/**
	 * Returns the number of user ranks where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user ranks
	 */
	public static int countByFindAll(long groupId, long companyId) {
		return getPersistence().countByFindAll(groupId, companyId);
	}

	/**
	 * Caches the user rank in the entity cache if it is enabled.
	 *
	 * @param userRank the user rank
	 */
	public static void cacheResult(UserRank userRank) {
		getPersistence().cacheResult(userRank);
	}

	/**
	 * Caches the user ranks in the entity cache if it is enabled.
	 *
	 * @param userRanks the user ranks
	 */
	public static void cacheResult(List<UserRank> userRanks) {
		getPersistence().cacheResult(userRanks);
	}

	/**
	 * Creates a new user rank with the primary key. Does not add the user rank to the database.
	 *
	 * @param userRankId the primary key for the new user rank
	 * @return the new user rank
	 */
	public static UserRank create(long userRankId) {
		return getPersistence().create(userRankId);
	}

	/**
	 * Removes the user rank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank that was removed
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public static UserRank remove(long userRankId)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().remove(userRankId);
	}

	public static UserRank updateImpl(UserRank userRank) {
		return getPersistence().updateImpl(userRank);
	}

	/**
	 * Returns the user rank with the primary key or throws a <code>NoSuchUserRankException</code> if it could not be found.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank
	 * @throws NoSuchUserRankException if a user rank with the primary key could not be found
	 */
	public static UserRank findByPrimaryKey(long userRankId)
		throws User.Rank.Poisition.Service.exception.NoSuchUserRankException {

		return getPersistence().findByPrimaryKey(userRankId);
	}

	/**
	 * Returns the user rank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank, or <code>null</code> if a user rank with the primary key could not be found
	 */
	public static UserRank fetchByPrimaryKey(long userRankId) {
		return getPersistence().fetchByPrimaryKey(userRankId);
	}

	/**
	 * Returns all the user ranks.
	 *
	 * @return the user ranks
	 */
	public static List<UserRank> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserRank> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserRank> findAll(
		int start, int end, OrderByComparator<UserRank> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<UserRank> findAll(
		int start, int end, OrderByComparator<UserRank> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the user ranks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user ranks.
	 *
	 * @return the number of user ranks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserRankPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserRankPersistence, UserRankPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserRankPersistence.class);

		ServiceTracker<UserRankPersistence, UserRankPersistence>
			serviceTracker =
				new ServiceTracker<UserRankPersistence, UserRankPersistence>(
					bundle.getBundleContext(), UserRankPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}