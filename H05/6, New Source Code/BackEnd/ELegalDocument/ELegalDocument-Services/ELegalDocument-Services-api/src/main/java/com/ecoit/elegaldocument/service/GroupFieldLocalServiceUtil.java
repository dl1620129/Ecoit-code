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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GroupField. This utility wraps
 * <code>com.ecoit.elegaldocument.service.impl.GroupFieldLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liverpool
 * @see GroupFieldLocalService
 * @generated
 */
public class GroupFieldLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ecoit.elegaldocument.service.impl.GroupFieldLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the group field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupField the group field
	 * @return the group field that was added
	 */
	public static com.ecoit.elegaldocument.model.GroupField addGroupField(
		com.ecoit.elegaldocument.model.GroupField groupField) {

		return getService().addGroupField(groupField);
	}

	public static void addGroupField(long groupUserId, long FieldId) {
		getService().addGroupField(groupUserId, FieldId);
	}

	/**
	 * Creates a new group field with the primary key. Does not add the group field to the database.
	 *
	 * @param groupFieldPK the primary key for the new group field
	 * @return the new group field
	 */
	public static com.ecoit.elegaldocument.model.GroupField createGroupField(
		com.ecoit.elegaldocument.service.persistence.GroupFieldPK
			groupFieldPK) {

		return getService().createGroupField(groupFieldPK);
	}

	/**
	 * Deletes the group field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupField the group field
	 * @return the group field that was removed
	 */
	public static com.ecoit.elegaldocument.model.GroupField deleteGroupField(
		com.ecoit.elegaldocument.model.GroupField groupField) {

		return getService().deleteGroupField(groupField);
	}

	/**
	 * Deletes the group field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field that was removed
	 * @throws PortalException if a group field with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.GroupField deleteGroupField(
			com.ecoit.elegaldocument.service.persistence.GroupFieldPK
				groupFieldPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGroupField(groupFieldPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ecoit.elegaldocument.model.GroupField fetchGroupField(
		com.ecoit.elegaldocument.service.persistence.GroupFieldPK
			groupFieldPK) {

		return getService().fetchGroupField(groupFieldPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getByField(long FieldId) {

		return getService().getByField(FieldId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getByUserIdAndGroupId(long userId, long groupId) {

		return getService().getByUserIdAndGroupId(userId, groupId);
	}

	public static java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getByUserIdAndGroupIdAndGroupUserId(
			long userId, long groupId, long groupUserId) {

		return getService().getByUserIdAndGroupIdAndGroupUserId(
			userId, groupId, groupUserId);
	}

	/**
	 * Returns the group field with the primary key.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field
	 * @throws PortalException if a group field with the primary key could not be found
	 */
	public static com.ecoit.elegaldocument.model.GroupField getGroupField(
			com.ecoit.elegaldocument.service.persistence.GroupFieldPK
				groupFieldPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGroupField(groupFieldPK);
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
	public static java.util.List<com.ecoit.elegaldocument.model.GroupField>
		getGroupFields(int start, int end) {

		return getService().getGroupFields(start, end);
	}

	/**
	 * Returns the number of group fields.
	 *
	 * @return the number of group fields
	 */
	public static int getGroupFieldsCount() {
		return getService().getGroupFieldsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasGroupField(long groupUserId, long FieldId) {
		return getService().hasGroupField(groupUserId, FieldId);
	}

	public static boolean hasUserAccessField(long userId, long FieldId) {
		return getService().hasUserAccessField(userId, FieldId);
	}

	public static void removeByFieldId(long FieldId) {
		getService().removeByFieldId(FieldId);
	}

	public static void removeByGroupUserId(long groupUserId) {
		getService().removeByGroupUserId(groupUserId);
	}

	/**
	 * Updates the group field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupField the group field
	 * @return the group field that was updated
	 */
	public static com.ecoit.elegaldocument.model.GroupField updateGroupField(
		com.ecoit.elegaldocument.model.GroupField groupField) {

		return getService().updateGroupField(groupField);
	}

	public static GroupFieldLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GroupFieldLocalService, GroupFieldLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GroupFieldLocalService.class);

		ServiceTracker<GroupFieldLocalService, GroupFieldLocalService>
			serviceTracker =
				new ServiceTracker
					<GroupFieldLocalService, GroupFieldLocalService>(
						bundle.getBundleContext(), GroupFieldLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}