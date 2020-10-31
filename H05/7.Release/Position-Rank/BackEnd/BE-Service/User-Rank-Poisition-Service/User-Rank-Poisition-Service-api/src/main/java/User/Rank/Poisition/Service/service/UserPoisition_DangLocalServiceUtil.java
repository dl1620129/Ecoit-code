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
 * Provides the local service utility for UserPoisition_Dang. This utility wraps
 * <code>User.Rank.Poisition.Service.service.impl.UserPoisition_DangLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangLocalService
 * @generated
 */
@ProviderType
public class UserPoisition_DangLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>User.Rank.Poisition.Service.service.impl.UserPoisition_DangLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user poisition_ dang to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was added
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
		addUserPoisition_Dang(
			User.Rank.Poisition.Service.model.UserPoisition_Dang
				userPoisition_Dang) {

		return getService().addUserPoisition_Dang(userPoisition_Dang);
	}

	/**
	 * Creates a new user poisition_ dang with the primary key. Does not add the user poisition_ dang to the database.
	 *
	 * @param userPoisitionDangId the primary key for the new user poisition_ dang
	 * @return the new user poisition_ dang
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
		createUserPoisition_Dang(long userPoisitionDangId) {

		return getService().createUserPoisition_Dang(userPoisitionDangId);
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
	 * Deletes the user poisition_ dang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 * @throws PortalException if a user poisition_ dang with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
			deleteUserPoisition_Dang(long userPoisitionDangId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserPoisition_Dang(userPoisitionDangId);
	}

	/**
	 * Deletes the user poisition_ dang from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
		deleteUserPoisition_Dang(
			User.Rank.Poisition.Service.model.UserPoisition_Dang
				userPoisition_Dang) {

		return getService().deleteUserPoisition_Dang(userPoisition_Dang);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
		fetchUserPoisition_Dang(long userPoisitionDangId) {

		return getService().fetchUserPoisition_Dang(userPoisitionDangId);
	}

	/**
	 * Returns the user poisition_ dang matching the UUID and group.
	 *
	 * @param uuid the user poisition_ dang's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
		fetchUserPoisition_DangByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchUserPoisition_DangByUuidAndGroupId(
			uuid, groupId);
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

	public static java.util.List
		<User.Rank.Poisition.Service.model.UserPoisition_Dang>
				getListUserPoisition_Dang(
					long groupId, String name, int start, int limit)
			throws Exception {

		return getService().getListUserPoisition_Dang(
			groupId, name, start, limit);
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
	 * Returns the user poisition_ dang with the primary key.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang
	 * @throws PortalException if a user poisition_ dang with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
			getUserPoisition_Dang(long userPoisitionDangId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserPoisition_Dang(userPoisitionDangId);
	}

	/**
	 * Returns the user poisition_ dang matching the UUID and group.
	 *
	 * @param uuid the user poisition_ dang's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition_ dang
	 * @throws PortalException if a matching user poisition_ dang could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
			getUserPoisition_DangByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserPoisition_DangByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of user poisition_ dangs
	 */
	public static java.util.List
		<User.Rank.Poisition.Service.model.UserPoisition_Dang>
			getUserPoisition_Dangs(int start, int end) {

		return getService().getUserPoisition_Dangs(start, end);
	}

	/**
	 * Returns all the user poisition_ dangs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisition_ dangs
	 * @param companyId the primary key of the company
	 * @return the matching user poisition_ dangs, or an empty list if no matches were found
	 */
	public static java.util.List
		<User.Rank.Poisition.Service.model.UserPoisition_Dang>
			getUserPoisition_DangsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getUserPoisition_DangsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of user poisition_ dangs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisition_ dangs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user poisition_ dangs, or an empty list if no matches were found
	 */
	public static java.util.List
		<User.Rank.Poisition.Service.model.UserPoisition_Dang>
			getUserPoisition_DangsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<User.Rank.Poisition.Service.model.UserPoisition_Dang>
						orderByComparator) {

		return getService().getUserPoisition_DangsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user poisition_ dangs.
	 *
	 * @return the number of user poisition_ dangs
	 */
	public static int getUserPoisition_DangsCount() {
		return getService().getUserPoisition_DangsCount();
	}

	/**
	 * Updates the user poisition_ dang in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was updated
	 */
	public static User.Rank.Poisition.Service.model.UserPoisition_Dang
		updateUserPoisition_Dang(
			User.Rank.Poisition.Service.model.UserPoisition_Dang
				userPoisition_Dang) {

		return getService().updateUserPoisition_Dang(userPoisition_Dang);
	}

	public static UserPoisition_DangLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserPoisition_DangLocalService, UserPoisition_DangLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserPoisition_DangLocalService.class);

		ServiceTracker
			<UserPoisition_DangLocalService, UserPoisition_DangLocalService>
				serviceTracker =
					new ServiceTracker
						<UserPoisition_DangLocalService,
						 UserPoisition_DangLocalService>(
							 bundle.getBundleContext(),
							 UserPoisition_DangLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}