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
 * Provides the local service utility for UserRank. This utility wraps
 * <code>User.Rank.Poisition.Service.service.impl.UserRankLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserRankLocalService
 * @generated
 */
@ProviderType
public class UserRankLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>User.Rank.Poisition.Service.service.impl.UserRankLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user rank to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRank the user rank
	 * @return the user rank that was added
	 */
	public static User.Rank.Poisition.Service.model.UserRank addUserRank(
		User.Rank.Poisition.Service.model.UserRank userRank) {

		return getService().addUserRank(userRank);
	}

	/**
	 * Creates a new user rank with the primary key. Does not add the user rank to the database.
	 *
	 * @param userRankId the primary key for the new user rank
	 * @return the new user rank
	 */
	public static User.Rank.Poisition.Service.model.UserRank createUserRank(
		long userRankId) {

		return getService().createUserRank(userRankId);
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
	 * Deletes the user rank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank that was removed
	 * @throws PortalException if a user rank with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserRank deleteUserRank(
			long userRankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserRank(userRankId);
	}

	/**
	 * Deletes the user rank from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRank the user rank
	 * @return the user rank that was removed
	 */
	public static User.Rank.Poisition.Service.model.UserRank deleteUserRank(
		User.Rank.Poisition.Service.model.UserRank userRank) {

		return getService().deleteUserRank(userRank);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static User.Rank.Poisition.Service.model.UserRank fetchUserRank(
		long userRankId) {

		return getService().fetchUserRank(userRankId);
	}

	/**
	 * Returns the user rank matching the UUID and group.
	 *
	 * @param uuid the user rank's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserRank
		fetchUserRankByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchUserRankByUuidAndGroupId(uuid, groupId);
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

	public static java.util.List<User.Rank.Poisition.Service.model.UserRank>
			getListUserRank(long groupId, String name, int start, int limit)
		throws Exception {

		return getService().getListUserRank(groupId, name, start, limit);
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
	 * Returns the user rank with the primary key.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank
	 * @throws PortalException if a user rank with the primary key could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserRank getUserRank(
			long userRankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserRank(userRankId);
	}

	/**
	 * Returns the user rank matching the UUID and group.
	 *
	 * @param uuid the user rank's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user rank
	 * @throws PortalException if a matching user rank could not be found
	 */
	public static User.Rank.Poisition.Service.model.UserRank
			getUserRankByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserRankByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the user ranks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>User.Rank.Poisition.Service.model.impl.UserRankModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @return the range of user ranks
	 */
	public static java.util.List<User.Rank.Poisition.Service.model.UserRank>
		getUserRanks(int start, int end) {

		return getService().getUserRanks(start, end);
	}

	/**
	 * Returns all the user ranks matching the UUID and company.
	 *
	 * @param uuid the UUID of the user ranks
	 * @param companyId the primary key of the company
	 * @return the matching user ranks, or an empty list if no matches were found
	 */
	public static java.util.List<User.Rank.Poisition.Service.model.UserRank>
		getUserRanksByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getUserRanksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of user ranks matching the UUID and company.
	 *
	 * @param uuid the UUID of the user ranks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of user ranks
	 * @param end the upper bound of the range of user ranks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching user ranks, or an empty list if no matches were found
	 */
	public static java.util.List<User.Rank.Poisition.Service.model.UserRank>
		getUserRanksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<User.Rank.Poisition.Service.model.UserRank>
					orderByComparator) {

		return getService().getUserRanksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user ranks.
	 *
	 * @return the number of user ranks
	 */
	public static int getUserRanksCount() {
		return getService().getUserRanksCount();
	}

	/**
	 * Updates the user rank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userRank the user rank
	 * @return the user rank that was updated
	 */
	public static User.Rank.Poisition.Service.model.UserRank updateUserRank(
		User.Rank.Poisition.Service.model.UserRank userRank) {

		return getService().updateUserRank(userRank);
	}

	public static UserRankLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserRankLocalService, UserRankLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserRankLocalService.class);

		ServiceTracker<UserRankLocalService, UserRankLocalService>
			serviceTracker =
				new ServiceTracker<UserRankLocalService, UserRankLocalService>(
					bundle.getBundleContext(), UserRankLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}