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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for members. This utility wraps
 * <code>organizationalStructure.service.service.impl.membersLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see membersLocalService
 * @generated
 */
@ProviderType
public class membersLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>organizationalStructure.service.service.impl.membersLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the members to the database. Also notifies the appropriate model listeners.
	 *
	 * @param members the members
	 * @return the members that was added
	 */
	public static organizationalStructure.service.model.members addmembers(
		organizationalStructure.service.model.members members) {

		return getService().addmembers(members);
	}

	/**
	 * Creates a new members with the primary key. Does not add the members to the database.
	 *
	 * @param memberId the primary key for the new members
	 * @return the new members
	 */
	public static organizationalStructure.service.model.members createmembers(
		long memberId) {

		return getService().createmembers(memberId);
	}

	/**
	 * Deletes the members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the members
	 * @return the members that was removed
	 * @throws PortalException if a members with the primary key could not be found
	 */
	public static organizationalStructure.service.model.members deletemembers(
			long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletemembers(memberId);
	}

	/**
	 * Deletes the members from the database. Also notifies the appropriate model listeners.
	 *
	 * @param members the members
	 * @return the members that was removed
	 */
	public static organizationalStructure.service.model.members deletemembers(
		organizationalStructure.service.model.members members) {

		return getService().deletemembers(members);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>organizationalStructure.service.model.impl.membersModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static organizationalStructure.service.model.members fetchmembers(
		long memberId) {

		return getService().fetchmembers(memberId);
	}

	/**
	 * Returns the members matching the UUID and group.
	 *
	 * @param uuid the members's UUID
	 * @param groupId the primary key of the group
	 * @return the matching members, or <code>null</code> if a matching members could not be found
	 */
	public static organizationalStructure.service.model.members
		fetchmembersByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchmembersByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the members with the primary key.
	 *
	 * @param memberId the primary key of the members
	 * @return the members
	 * @throws PortalException if a members with the primary key could not be found
	 */
	public static organizationalStructure.service.model.members getmembers(
			long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getmembers(memberId);
	}

	/**
	 * Returns the members matching the UUID and group.
	 *
	 * @param uuid the members's UUID
	 * @param groupId the primary key of the group
	 * @return the matching members
	 * @throws PortalException if a matching members could not be found
	 */
	public static organizationalStructure.service.model.members
			getmembersByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getmembersByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<organizationalStructure.service.model.members>
		getmemberses(int start, int end) {

		return getService().getmemberses(start, end);
	}

	/**
	 * Returns the number of memberses.
	 *
	 * @return the number of memberses
	 */
	public static int getmembersesCount() {
		return getService().getmembersesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the members in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param members the members
	 * @return the members that was updated
	 */
	public static organizationalStructure.service.model.members updatemembers(
		organizationalStructure.service.model.members members) {

		return getService().updatemembers(members);
	}

	public static membersLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<membersLocalService, membersLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(membersLocalService.class);

		ServiceTracker<membersLocalService, membersLocalService>
			serviceTracker =
				new ServiceTracker<membersLocalService, membersLocalService>(
					bundle.getBundleContext(), membersLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}