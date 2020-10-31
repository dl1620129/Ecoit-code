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

package com.ecoit.mr.service;

import com.ecoit.mr.model.UserPermissionGroup;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for UserPermissionGroup. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPermissionGroupLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UserPermissionGroupLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPermissionGroupLocalServiceUtil} to access the user permission group local service. Add custom service methods to <code>com.ecoit.mr.service.impl.UserPermissionGroupLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the user permission group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroup the user permission group
	 * @return the user permission group that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserPermissionGroup addUserPermissionGroup(
		UserPermissionGroup userPermissionGroup);

	public void createUpdateGroupUser(
			long userId, long groupId, long groupUserId, String groupName,
			String description, String[] users, String[] permissions)
		throws Exception;

	/**
	 * Creates a new user permission group with the primary key. Does not add the user permission group to the database.
	 *
	 * @param userPermissionGroupId the primary key for the new user permission group
	 * @return the new user permission group
	 */
	@Transactional(enabled = false)
	public UserPermissionGroup createUserPermissionGroup(
		long userPermissionGroupId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the user permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group that was removed
	 * @throws PortalException if a user permission group with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserPermissionGroup deleteUserPermissionGroup(
			long userPermissionGroupId)
		throws PortalException;

	/**
	 * Deletes the user permission group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroup the user permission group
	 * @return the user permission group that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserPermissionGroup deleteUserPermissionGroup(
		UserPermissionGroup userPermissionGroup);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserPermissionGroup fetchUserPermissionGroup(
		long userPermissionGroupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserPermissionGroup> getList(
			long groupId, String name, int start, int limit)
		throws Exception;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotal(long groupId, String name) throws Exception;

	/**
	 * Returns the user permission group with the primary key.
	 *
	 * @param userPermissionGroupId the primary key of the user permission group
	 * @return the user permission group
	 * @throws PortalException if a user permission group with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserPermissionGroup getUserPermissionGroup(
			long userPermissionGroupId)
		throws PortalException;

	/**
	 * Returns a range of all the user permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.UserPermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user permission groups
	 * @param end the upper bound of the range of user permission groups (not inclusive)
	 * @return the range of user permission groups
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserPermissionGroup> getUserPermissionGroups(
		int start, int end);

	/**
	 * Returns the number of user permission groups.
	 *
	 * @return the number of user permission groups
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserPermissionGroupsCount();

	/**
	 * Updates the user permission group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPermissionGroup the user permission group
	 * @return the user permission group that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserPermissionGroup updateUserPermissionGroup(
		UserPermissionGroup userPermissionGroup);

}