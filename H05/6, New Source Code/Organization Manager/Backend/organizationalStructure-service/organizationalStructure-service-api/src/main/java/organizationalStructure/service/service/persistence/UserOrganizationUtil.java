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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import organizationalStructure.service.model.UserOrganization;

/**
 * The persistence utility for the user organization service. This utility wraps <code>organizationalStructure.service.service.persistence.impl.UserOrganizationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOrganizationPersistence
 * @generated
 */
public class UserOrganizationUtil {

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
	public static void clearCache(UserOrganization userOrganization) {
		getPersistence().clearCache(userOrganization);
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
	public static Map<Serializable, UserOrganization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserOrganization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserOrganization update(UserOrganization userOrganization) {
		return getPersistence().update(userOrganization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserOrganization update(
		UserOrganization userOrganization, ServiceContext serviceContext) {

		return getPersistence().update(userOrganization, serviceContext);
	}

	/**
	 * Returns all the user organizations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user organizations
	 */
	public static List<UserOrganization> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	 * Returns a range of all the user organizations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @return the range of matching user organizations
	 */
	public static List<UserOrganization> findByUser(
		long userId, int start, int end) {

		return getPersistence().findByUser(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the user organizations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user organizations
	 */
	public static List<UserOrganization> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user organizations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user organizations
	 */
	public static List<UserOrganization> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUser(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public static UserOrganization findByUser_First(
			long userId, OrderByComparator<UserOrganization> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the first user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public static UserOrganization fetchByUser_First(
		long userId, OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	 * Returns the last user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public static UserOrganization findByUser_Last(
			long userId, OrderByComparator<UserOrganization> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public static UserOrganization fetchByUser_Last(
		long userId, OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	 * Returns the user organizations before and after the current user organization in the ordered set where userId = &#63;.
	 *
	 * @param userOrganizationPK the primary key of the current user organization
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user organization
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public static UserOrganization[] findByUser_PrevAndNext(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK,
			long userId, OrderByComparator<UserOrganization> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByUser_PrevAndNext(
			userOrganizationPK, userId, orderByComparator);
	}

	/**
	 * Removes all the user organizations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	 * Returns the number of user organizations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user organizations
	 */
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	 * Returns all the user organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching user organizations
	 */
	public static List<UserOrganization> findByOrganization(
		long organizationId) {

		return getPersistence().findByOrganization(organizationId);
	}

	/**
	 * Returns a range of all the user organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @return the range of matching user organizations
	 */
	public static List<UserOrganization> findByOrganization(
		long organizationId, int start, int end) {

		return getPersistence().findByOrganization(organizationId, start, end);
	}

	/**
	 * Returns an ordered range of all the user organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user organizations
	 */
	public static List<UserOrganization> findByOrganization(
		long organizationId, int start, int end,
		OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().findByOrganization(
			organizationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user organizations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user organizations
	 */
	public static List<UserOrganization> findByOrganization(
		long organizationId, int start, int end,
		OrderByComparator<UserOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOrganization(
			organizationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public static UserOrganization findByOrganization_First(
			long organizationId,
			OrderByComparator<UserOrganization> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByOrganization_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the first user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public static UserOrganization fetchByOrganization_First(
		long organizationId,
		OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().fetchByOrganization_First(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public static UserOrganization findByOrganization_Last(
			long organizationId,
			OrderByComparator<UserOrganization> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByOrganization_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the last user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public static UserOrganization fetchByOrganization_Last(
		long organizationId,
		OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().fetchByOrganization_Last(
			organizationId, orderByComparator);
	}

	/**
	 * Returns the user organizations before and after the current user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param userOrganizationPK the primary key of the current user organization
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user organization
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public static UserOrganization[] findByOrganization_PrevAndNext(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK,
			long organizationId,
			OrderByComparator<UserOrganization> orderByComparator)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByOrganization_PrevAndNext(
			userOrganizationPK, organizationId, orderByComparator);
	}

	/**
	 * Removes all the user organizations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public static void removeByOrganization(long organizationId) {
		getPersistence().removeByOrganization(organizationId);
	}

	/**
	 * Returns the number of user organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching user organizations
	 */
	public static int countByOrganization(long organizationId) {
		return getPersistence().countByOrganization(organizationId);
	}

	/**
	 * Caches the user organization in the entity cache if it is enabled.
	 *
	 * @param userOrganization the user organization
	 */
	public static void cacheResult(UserOrganization userOrganization) {
		getPersistence().cacheResult(userOrganization);
	}

	/**
	 * Caches the user organizations in the entity cache if it is enabled.
	 *
	 * @param userOrganizations the user organizations
	 */
	public static void cacheResult(List<UserOrganization> userOrganizations) {
		getPersistence().cacheResult(userOrganizations);
	}

	/**
	 * Creates a new user organization with the primary key. Does not add the user organization to the database.
	 *
	 * @param userOrganizationPK the primary key for the new user organization
	 * @return the new user organization
	 */
	public static UserOrganization create(
		organizationalStructure.service.service.persistence.UserOrganizationPK
			userOrganizationPK) {

		return getPersistence().create(userOrganizationPK);
	}

	/**
	 * Removes the user organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization that was removed
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public static UserOrganization remove(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().remove(userOrganizationPK);
	}

	public static UserOrganization updateImpl(
		UserOrganization userOrganization) {

		return getPersistence().updateImpl(userOrganization);
	}

	/**
	 * Returns the user organization with the primary key or throws a <code>NoSuchUserOrganizationException</code> if it could not be found.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public static UserOrganization findByPrimaryKey(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK)
		throws organizationalStructure.service.exception.
			NoSuchUserOrganizationException {

		return getPersistence().findByPrimaryKey(userOrganizationPK);
	}

	/**
	 * Returns the user organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization, or <code>null</code> if a user organization with the primary key could not be found
	 */
	public static UserOrganization fetchByPrimaryKey(
		organizationalStructure.service.service.persistence.UserOrganizationPK
			userOrganizationPK) {

		return getPersistence().fetchByPrimaryKey(userOrganizationPK);
	}

	/**
	 * Returns all the user organizations.
	 *
	 * @return the user organizations
	 */
	public static List<UserOrganization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @return the range of user organizations
	 */
	public static List<UserOrganization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user organizations
	 */
	public static List<UserOrganization> findAll(
		int start, int end,
		OrderByComparator<UserOrganization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user organizations
	 * @param end the upper bound of the range of user organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user organizations
	 */
	public static List<UserOrganization> findAll(
		int start, int end,
		OrderByComparator<UserOrganization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user organizations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user organizations.
	 *
	 * @return the number of user organizations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserOrganizationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserOrganizationPersistence, UserOrganizationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserOrganizationPersistence.class);

		ServiceTracker<UserOrganizationPersistence, UserOrganizationPersistence>
			serviceTracker =
				new ServiceTracker
					<UserOrganizationPersistence, UserOrganizationPersistence>(
						bundle.getBundleContext(),
						UserOrganizationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}