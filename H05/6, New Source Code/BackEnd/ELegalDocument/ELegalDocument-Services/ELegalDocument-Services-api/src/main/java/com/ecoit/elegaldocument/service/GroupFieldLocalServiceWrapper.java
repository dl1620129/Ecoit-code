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

package com.ecoit.elegaldocument.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GroupFieldLocalService}.
 *
 * @author Liverpool
 * @see GroupFieldLocalService
 * @generated
 */
public class GroupFieldLocalServiceWrapper
	implements GroupFieldLocalService, ServiceWrapper<GroupFieldLocalService> {

	public GroupFieldLocalServiceWrapper(
		GroupFieldLocalService groupFieldLocalService) {

		_groupFieldLocalService = groupFieldLocalService;
	}

	/**
	 * Adds the group field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupField the group field
	 * @return the group field that was added
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupField addGroupField(
		com.ecoit.elegaldocument.model.GroupField groupField) {

		return _groupFieldLocalService.addGroupField(groupField);
	}

	@Override
	public void addGroupField(long groupUserId, long FieldId) {
		_groupFieldLocalService.addGroupField(groupUserId, FieldId);
	}

	/**
	 * Creates a new group field with the primary key. Does not add the group field to the database.
	 *
	 * @param groupFieldPK the primary key for the new group field
	 * @return the new group field
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupField createGroupField(
		com.ecoit.elegaldocument.service.persistence.GroupFieldPK
			groupFieldPK) {

		return _groupFieldLocalService.createGroupField(groupFieldPK);
	}

	/**
	 * Deletes the group field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupField the group field
	 * @return the group field that was removed
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupField deleteGroupField(
		com.ecoit.elegaldocument.model.GroupField groupField) {

		return _groupFieldLocalService.deleteGroupField(groupField);
	}

	/**
	 * Deletes the group field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field that was removed
	 * @throws PortalException if a group field with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupField deleteGroupField(
			com.ecoit.elegaldocument.service.persistence.GroupFieldPK
				groupFieldPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupFieldLocalService.deleteGroupField(groupFieldPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupFieldLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupFieldLocalService.dynamicQuery();
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

		return _groupFieldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupFieldModelImpl</code>.
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

		return _groupFieldLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupFieldModelImpl</code>.
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

		return _groupFieldLocalService.dynamicQuery(
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

		return _groupFieldLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupFieldLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.elegaldocument.model.GroupField fetchGroupField(
		com.ecoit.elegaldocument.service.persistence.GroupFieldPK
			groupFieldPK) {

		return _groupFieldLocalService.fetchGroupField(groupFieldPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupFieldLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupField> getByField(
		long FieldId) {

		return _groupFieldLocalService.getByField(FieldId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getByUserIdAndGroupId(long userId, long groupId) {

		return _groupFieldLocalService.getByUserIdAndGroupId(userId, groupId);
	}

	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getByUserIdAndGroupIdAndGroupUserId(
			long userId, long groupId, long groupUserId) {

		return _groupFieldLocalService.getByUserIdAndGroupIdAndGroupUserId(
			userId, groupId, groupUserId);
	}

	/**
	 * Returns the group field with the primary key.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field
	 * @throws PortalException if a group field with the primary key could not be found
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupField getGroupField(
			com.ecoit.elegaldocument.service.persistence.GroupFieldPK
				groupFieldPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupFieldLocalService.getGroupField(groupFieldPK);
	}

	/**
	 * Returns a range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.elegaldocument.model.impl.GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of group fields
	 */
	@Override
	public java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getGroupFields(int start, int end) {

		return _groupFieldLocalService.getGroupFields(start, end);
	}

	/**
	 * Returns the number of group fields.
	 *
	 * @return the number of group fields
	 */
	@Override
	public int getGroupFieldsCount() {
		return _groupFieldLocalService.getGroupFieldsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupFieldLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupFieldLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupFieldLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasGroupField(long groupUserId, long FieldId) {
		return _groupFieldLocalService.hasGroupField(groupUserId, FieldId);
	}

	@Override
	public boolean hasUserAccessField(long userId, long FieldId) {
		return _groupFieldLocalService.hasUserAccessField(userId, FieldId);
	}

	@Override
	public void removeByFieldId(long FieldId) {
		_groupFieldLocalService.removeByFieldId(FieldId);
	}

	@Override
	public void removeByGroupUserId(long groupUserId) {
		_groupFieldLocalService.removeByGroupUserId(groupUserId);
	}

	/**
	 * Updates the group field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupField the group field
	 * @return the group field that was updated
	 */
	@Override
	public com.ecoit.elegaldocument.model.GroupField updateGroupField(
		com.ecoit.elegaldocument.model.GroupField groupField) {

		return _groupFieldLocalService.updateGroupField(groupField);
	}

	@Override
	public GroupFieldLocalService getWrappedService() {
		return _groupFieldLocalService;
	}

	@Override
	public void setWrappedService(
		GroupFieldLocalService groupFieldLocalService) {

		_groupFieldLocalService = groupFieldLocalService;
	}

	private GroupFieldLocalService _groupFieldLocalService;

}