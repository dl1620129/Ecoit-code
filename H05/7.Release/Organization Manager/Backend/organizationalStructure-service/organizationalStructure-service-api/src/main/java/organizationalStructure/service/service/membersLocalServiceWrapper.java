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

package organizationalStructure.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link membersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see membersLocalService
 * @generated
 */
@ProviderType
public class membersLocalServiceWrapper
	implements membersLocalService, ServiceWrapper<membersLocalService> {

	public membersLocalServiceWrapper(membersLocalService membersLocalService) {
		_membersLocalService = membersLocalService;
	}

	/**
	 * Adds the members to the database. Also notifies the appropriate model listeners.
	 *
	 * @param members the members
	 * @return the members that was added
	 */
	@Override
	public organizationalStructure.service.model.members addmembers(
		organizationalStructure.service.model.members members) {

		return _membersLocalService.addmembers(members);
	}

	/**
	 * Creates a new members with the primary key. Does not add the members to the database.
	 *
	 * @param memberId the primary key for the new members
	 * @return the new members
	 */
	@Override
	public organizationalStructure.service.model.members createmembers(
		long memberId) {

		return _membersLocalService.createmembers(memberId);
	}

	/**
	 * Deletes the members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the members
	 * @return the members that was removed
	 * @throws PortalException if a members with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.members deletemembers(
			long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membersLocalService.deletemembers(memberId);
	}

	/**
	 * Deletes the members from the database. Also notifies the appropriate model listeners.
	 *
	 * @param members the members
	 * @return the members that was removed
	 */
	@Override
	public organizationalStructure.service.model.members deletemembers(
		organizationalStructure.service.model.members members) {

		return _membersLocalService.deletemembers(members);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membersLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _membersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _membersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _membersLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _membersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _membersLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public organizationalStructure.service.model.members fetchmembers(
		long memberId) {

		return _membersLocalService.fetchmembers(memberId);
	}

	/**
	 * Returns the members matching the UUID and group.
	 *
	 * @param uuid the members's UUID
	 * @param groupId the primary key of the group
	 * @return the matching members, or <code>null</code> if a matching members could not be found
	 */
	@Override
	public organizationalStructure.service.model.members
		fetchmembersByUuidAndGroupId(String uuid, long groupId) {

		return _membersLocalService.fetchmembersByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _membersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _membersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the members with the primary key.
	 *
	 * @param memberId the primary key of the members
	 * @return the members
	 * @throws PortalException if a members with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.members getmembers(
			long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membersLocalService.getmembers(memberId);
	}

	/**
	 * Returns the members matching the UUID and group.
	 *
	 * @param uuid the members's UUID
	 * @param groupId the primary key of the group
	 * @return the matching members
	 * @throws PortalException if a matching members could not be found
	 */
	@Override
	public organizationalStructure.service.model.members
			getmembersByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membersLocalService.getmembersByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of memberses
	 * @param end the upper bound of the range of memberses (not inclusive)
	 * @return the range of memberses
	 */
	@Override
	public java.util.List<organizationalStructure.service.model.members>
		getmemberses(int start, int end) {

		return _membersLocalService.getmemberses(start, end);
	}

	/**
	 * Returns the number of memberses.
	 *
	 * @return the number of memberses
	 */
	@Override
	public int getmembersesCount() {
		return _membersLocalService.getmembersesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _membersLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _membersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the members in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param members the members
	 * @return the members that was updated
	 */
	@Override
	public organizationalStructure.service.model.members updatemembers(
		organizationalStructure.service.model.members members) {

		return _membersLocalService.updatemembers(members);
	}

	@Override
	public membersLocalService getWrappedService() {
		return _membersLocalService;
	}

	@Override
	public void setWrappedService(membersLocalService membersLocalService) {
		_membersLocalService = membersLocalService;
	}

	private membersLocalService _membersLocalService;

}