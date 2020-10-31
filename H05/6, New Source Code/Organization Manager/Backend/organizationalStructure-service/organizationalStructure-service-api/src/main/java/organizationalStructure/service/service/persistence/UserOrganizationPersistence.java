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

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

import organizationalStructure.service.exception.NoSuchUserOrganizationException;
import organizationalStructure.service.model.UserOrganization;

/**
 * The persistence interface for the user organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOrganizationUtil
 * @generated
 */
@ProviderType
public interface UserOrganizationPersistence
	extends BasePersistence<UserOrganization> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserOrganizationUtil} to access the user organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user organizations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user organizations
	 */
	public java.util.List<UserOrganization> findByUser(long userId);

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
	public java.util.List<UserOrganization> findByUser(
		long userId, int start, int end);

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
	public java.util.List<UserOrganization> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

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
	public java.util.List<UserOrganization> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public UserOrganization findByUser_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
				orderByComparator)
		throws NoSuchUserOrganizationException;

	/**
	 * Returns the first user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public UserOrganization fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

	/**
	 * Returns the last user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public UserOrganization findByUser_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
				orderByComparator)
		throws NoSuchUserOrganizationException;

	/**
	 * Returns the last user organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public UserOrganization fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

	/**
	 * Returns the user organizations before and after the current user organization in the ordered set where userId = &#63;.
	 *
	 * @param userOrganizationPK the primary key of the current user organization
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user organization
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public UserOrganization[] findByUser_PrevAndNext(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK,
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
				orderByComparator)
		throws NoSuchUserOrganizationException;

	/**
	 * Removes all the user organizations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUser(long userId);

	/**
	 * Returns the number of user organizations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user organizations
	 */
	public int countByUser(long userId);

	/**
	 * Returns all the user organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching user organizations
	 */
	public java.util.List<UserOrganization> findByOrganization(
		long organizationId);

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
	public java.util.List<UserOrganization> findByOrganization(
		long organizationId, int start, int end);

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
	public java.util.List<UserOrganization> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

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
	public java.util.List<UserOrganization> findByOrganization(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public UserOrganization findByOrganization_First(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
				orderByComparator)
		throws NoSuchUserOrganizationException;

	/**
	 * Returns the first user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public UserOrganization fetchByOrganization_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

	/**
	 * Returns the last user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization
	 * @throws NoSuchUserOrganizationException if a matching user organization could not be found
	 */
	public UserOrganization findByOrganization_Last(
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
				orderByComparator)
		throws NoSuchUserOrganizationException;

	/**
	 * Returns the last user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user organization, or <code>null</code> if a matching user organization could not be found
	 */
	public UserOrganization fetchByOrganization_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

	/**
	 * Returns the user organizations before and after the current user organization in the ordered set where organizationId = &#63;.
	 *
	 * @param userOrganizationPK the primary key of the current user organization
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user organization
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public UserOrganization[] findByOrganization_PrevAndNext(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK,
			long organizationId,
			com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
				orderByComparator)
		throws NoSuchUserOrganizationException;

	/**
	 * Removes all the user organizations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	public void removeByOrganization(long organizationId);

	/**
	 * Returns the number of user organizations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching user organizations
	 */
	public int countByOrganization(long organizationId);

	/**
	 * Caches the user organization in the entity cache if it is enabled.
	 *
	 * @param userOrganization the user organization
	 */
	public void cacheResult(UserOrganization userOrganization);

	/**
	 * Caches the user organizations in the entity cache if it is enabled.
	 *
	 * @param userOrganizations the user organizations
	 */
	public void cacheResult(java.util.List<UserOrganization> userOrganizations);

	/**
	 * Creates a new user organization with the primary key. Does not add the user organization to the database.
	 *
	 * @param userOrganizationPK the primary key for the new user organization
	 * @return the new user organization
	 */
	public UserOrganization create(
		organizationalStructure.service.service.persistence.UserOrganizationPK
			userOrganizationPK);

	/**
	 * Removes the user organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization that was removed
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public UserOrganization remove(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK)
		throws NoSuchUserOrganizationException;

	public UserOrganization updateImpl(UserOrganization userOrganization);

	/**
	 * Returns the user organization with the primary key or throws a <code>NoSuchUserOrganizationException</code> if it could not be found.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization
	 * @throws NoSuchUserOrganizationException if a user organization with the primary key could not be found
	 */
	public UserOrganization findByPrimaryKey(
			organizationalStructure.service.service.persistence.
				UserOrganizationPK userOrganizationPK)
		throws NoSuchUserOrganizationException;

	/**
	 * Returns the user organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userOrganizationPK the primary key of the user organization
	 * @return the user organization, or <code>null</code> if a user organization with the primary key could not be found
	 */
	public UserOrganization fetchByPrimaryKey(
		organizationalStructure.service.service.persistence.UserOrganizationPK
			userOrganizationPK);

	/**
	 * Returns all the user organizations.
	 *
	 * @return the user organizations
	 */
	public java.util.List<UserOrganization> findAll();

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
	public java.util.List<UserOrganization> findAll(int start, int end);

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
	public java.util.List<UserOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator);

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
	public java.util.List<UserOrganization> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOrganization>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user organizations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user organizations.
	 *
	 * @return the number of user organizations
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}