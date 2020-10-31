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

/**
 * Provides a wrapper for {@link memberLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see memberLocalService
 * @generated
 */
public class memberLocalServiceWrapper
	implements memberLocalService, ServiceWrapper<memberLocalService> {

	public memberLocalServiceWrapper(memberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	/**
	 * Adds the member to the database. Also notifies the appropriate model listeners.
	 *
	 * @param member the member
	 * @return the member that was added
	 */
	@Override
	public organizationalStructure.service.model.member addmember(
		organizationalStructure.service.model.member member) {

		return _memberLocalService.addmember(member);
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	@Override
	public organizationalStructure.service.model.member createmember(
		long memberId) {

		return _memberLocalService.createmember(memberId);
	}

	/**
	 * Deletes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws PortalException if a member with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.member deletemember(
			long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberLocalService.deletemember(memberId);
	}

	/**
	 * Deletes the member from the database. Also notifies the appropriate model listeners.
	 *
	 * @param member the member
	 * @return the member that was removed
	 */
	@Override
	public organizationalStructure.service.model.member deletemember(
		organizationalStructure.service.model.member member) {

		return _memberLocalService.deletemember(member);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _memberLocalService.dynamicQuery();
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

		return _memberLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.memberModelImpl</code>.
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

		return _memberLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.memberModelImpl</code>.
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

		return _memberLocalService.dynamicQuery(
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

		return _memberLocalService.dynamicQueryCount(dynamicQuery);
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

		return _memberLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public organizationalStructure.service.model.member fetchmember(
		long memberId) {

		return _memberLocalService.fetchmember(memberId);
	}

	/**
	 * Returns the member matching the UUID and group.
	 *
	 * @param uuid the member's UUID
	 * @param groupId the primary key of the group
	 * @return the matching member, or <code>null</code> if a matching member could not be found
	 */
	@Override
	public organizationalStructure.service.model.member
		fetchmemberByUuidAndGroupId(String uuid, long groupId) {

		return _memberLocalService.fetchmemberByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _memberLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCount(long groupId, String fullName) {
		return _memberLocalService.getCount(groupId, fullName);
	}

	@Override
	public int getCountByOrgan(long groupId, long organizationId) {
		return _memberLocalService.getCountByOrgan(groupId, organizationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _memberLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<organizationalStructure.service.model.member>
			getListMember(long groupId, String fullName, int start, int limit)
		throws Exception {

		return _memberLocalService.getListMember(
			groupId, fullName, start, limit);
	}

	@Override
	public java.util.List<organizationalStructure.service.model.member>
			getListMemberByOrganId(
				long groupId, long organizationId, int start, int limit)
		throws Exception {

		return _memberLocalService.getListMemberByOrganId(
			groupId, organizationId, start, limit);
	}

	/**
	 * Returns the member with the primary key.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws PortalException if a member with the primary key could not be found
	 */
	@Override
	public organizationalStructure.service.model.member getmember(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberLocalService.getmember(memberId);
	}

	/**
	 * Returns the member matching the UUID and group.
	 *
	 * @param uuid the member's UUID
	 * @param groupId the primary key of the group
	 * @return the matching member
	 * @throws PortalException if a matching member could not be found
	 */
	@Override
	public organizationalStructure.service.model.member
			getmemberByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberLocalService.getmemberByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.memberModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 */
	@Override
	public java.util.List<organizationalStructure.service.model.member>
		getmembers(int start, int end) {

		return _memberLocalService.getmembers(start, end);
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 */
	@Override
	public int getmembersCount() {
		return _memberLocalService.getmembersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _memberLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the member in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param member the member
	 * @return the member that was updated
	 */
	@Override
	public organizationalStructure.service.model.member updatemember(
		organizationalStructure.service.model.member member) {

		return _memberLocalService.updatemember(member);
	}

	@Override
	public memberLocalService getWrappedService() {
		return _memberLocalService;
	}

	@Override
	public void setWrappedService(memberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	private memberLocalService _memberLocalService;

}