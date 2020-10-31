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

package User.Rank.Poisition.Service.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserChucDanh. This utility wraps
 * <code>User.Rank.Poisition.Service.service.impl.UserChucDanhLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserChucDanhLocalService
 * @generated
 */
@ProviderType
public class UserChucDanhLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>User.Rank.Poisition.Service.service.impl.UserChucDanhLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user chuc danh to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanh the user chuc danh
	 * @return the user chuc danh that was added
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
		addUserChucDanh(
			User.Rank.Poisition.Service.model.UserChucDanh userChucDanh) {

		return getService().addUserChucDanh(userChucDanh);
	}

	/**
	 * Creates a new user chuc danh with the primary key. Does not add the user chuc danh to the database.
	 *
	 * @param userChucDanhId the primary key for the new user chuc danh
	 * @return the new user chuc danh
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
		createUserChucDanh(long userChucDanhId) {

		return getService().createUserChucDanh(userChucDanhId);
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

	/**
	 * Deletes the user chuc danh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh that was removed
	 * @throws PortalException if a user chuc danh with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
			deleteUserChucDanh(long userChucDanhId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserChucDanh(userChucDanhId);
	}

	/**
	 * Deletes the user chuc danh from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanh the user chuc danh
	 * @return the user chuc danh that was removed
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
		deleteUserChucDanh(
			User.Rank.Poisition.Service.model.UserChucDanh userChucDanh) {

		return getService().deleteUserChucDanh(userChucDanh);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static User.Rank.Poisition.Service.model.UserChucDanh
		fetchUserChucDanh(long userChucDanhId) {

		return getService().fetchUserChucDanh(userChucDanhId);
	}

	/**
	 * Returns the user chuc danh matching the UUID and group.
	 *
	 * @param uuid the user chuc danh's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
		fetchUserChucDanhByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchUserChucDanhByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static int getCountAll(String name, long groupId) throws Exception {
		return getService().getCountAll(name, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<User.Rank.Poisition.Service.model.UserChucDanh>
			getListUserChucDanh(long groupId, String name, int start, int limit)
		throws Exception {

		return getService().getListUserChucDanh(groupId, name, start, limit);
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
	 * Returns the user chuc danh with the primary key.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh
	 * @throws PortalException if a user chuc danh with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
			getUserChucDanh(long userChucDanhId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserChucDanh(userChucDanhId);
	}

	/**
	 * Returns the user chuc danh matching the UUID and group.
	 *
	 * @param uuid the user chuc danh's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user chuc danh
	 * @throws PortalException if a matching user chuc danh could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
			getUserChucDanhByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserChucDanhByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of user chuc danhs
	 */
	public static java.util.List<User.Rank.Poisition.Service.model.UserChucDanh>
		getUserChucDanhs(int start, int end) {

		return getService().getUserChucDanhs(start, end);
	}

	/**
	 * Returns all the user chuc danhs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user chuc danhs
	 * @param companyId the primary key of the company
	 * @return the matching user chuc danhs, or an empty list if no matches were found
	 */
	public static java.util.List<User.Rank.Poisition.Service.model.UserChucDanh>
		getUserChucDanhsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getUserChucDanhsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of user chuc danhs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user chuc danhs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user chuc danhs, or an empty list if no matches were found
	 */
	public static java.util.List<User.Rank.Poisition.Service.model.UserChucDanh>
		getUserChucDanhsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<User.Rank.Poisition.Service.model.UserChucDanh>
					orderByComparator) {

		return getService().getUserChucDanhsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user chuc danhs.
	 *
	 * @return the number of user chuc danhs
	 */
	public static int getUserChucDanhsCount() {
		return getService().getUserChucDanhsCount();
	}

	/**
	 * Updates the user chuc danh in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanh the user chuc danh
	 * @return the user chuc danh that was updated
	 */
	public static User.Rank.Poisition.Service.model.UserChucDanh
		updateUserChucDanh(
			User.Rank.Poisition.Service.model.UserChucDanh userChucDanh) {

		return getService().updateUserChucDanh(userChucDanh);
	}

	public static UserChucDanhLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserChucDanhLocalService, UserChucDanhLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserChucDanhLocalService.class);

		ServiceTracker<UserChucDanhLocalService, UserChucDanhLocalService>
			serviceTracker =
				new ServiceTracker
					<UserChucDanhLocalService, UserChucDanhLocalService>(
						bundle.getBundleContext(),
						UserChucDanhLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}